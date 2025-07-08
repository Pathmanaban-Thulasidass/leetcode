
SELECT customer_id
FROM Customer
GROUP BY customer_id
HAVING (SELECT COUNT(*) FROM Product) = COUNT(DISTINCT product_key);