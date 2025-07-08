WITH cte1 AS(
    SELECT product_id, MAX(change_date) AS change_date 
    FROM Products
    WHERE change_date <= '2019-08-16'
    GROUP BY product_id
),
cte2 AS(
    SELECT DISTINCT product_id
    FROM Products
)

SELECT p.product_id , p.new_price AS price
FROM Products p
JOIN cte1 c 
ON p.product_id = c.product_id AND p.change_date = c.change_date 

UNION

SELECT product_id, 10
FROM cte2 
WHERE cte2.product_id NOT IN(
    SELECT product_id
    FROM cte1
)


