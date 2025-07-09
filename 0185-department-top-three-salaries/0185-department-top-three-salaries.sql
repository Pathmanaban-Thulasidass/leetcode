WITH cte1 AS(
    SELECT e.id AS eId, e.name, e.salary, d.name AS dName
    FROM Employee e
    JOIN Department d
    ON e.departmentId = d.id
),
cte2 AS(
    SELECT name, salary, dName, dense_rank() over(partition by a.dName order by a.salary desc) as salRank
    FROM cte1 a
)

SELECT dName AS Department, name AS Employee, salary AS Salary
FROM cte2
WHERE salRank <= 3;
