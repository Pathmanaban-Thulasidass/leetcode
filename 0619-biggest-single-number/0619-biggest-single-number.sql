WITH cte1 AS(
    SELECT num
    FROM MyNumbers 
    GROUP BY num
    HAVING COUNT(num) = 1
)
SELECT MAX(num) AS num
FROM cte1;