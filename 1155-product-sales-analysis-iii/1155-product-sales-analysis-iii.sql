WITH cte1 AS(
    SELECT product_id, MIN(year) AS MinYear
    FROM Sales
    GROUP BY product_id
)
SELECT s.product_id , s.year AS first_year , s.quantity , s.price
FROM Sales s 
WHERE EXISTS(
    SELECT 1
    FROM cte1 c
    WHERE c.product_id = s.product_id AND c.MinYear = s.year
)