WITH cte1 AS(
    SELECT accepter_id, COUNT(requester_id) AS count1
    FROM RequestAccepted 
    GROUP BY accepter_id 
),
cte2 AS(
    SELECT requester_id, COUNT(requester_id) AS count2
    FROM RequestAccepted
    GROUP BY requester_id
),
cte3 AS(
    SELECT c1.accepter_id AS id, c1.count1, c2.count2
    FROM cte1 c1
    LEFT JOIN cte2 c2
    ON c1.accepter_id = c2.requester_id

    UNION

    SELECT c2.requester_id AS accepter_id, c1.count1, c2.count2
    FROM cte1 c1
    RIGHT JOIN cte2 c2
    ON c1.accepter_id = c2.requester_id
),
cte4 AS(
    SELECT id,IFNULL(count1,0) + IFNULL(count2,0) AS num
    FROM cte3
)

SELECT id, num
FROM cte4
WHERE num = (
    SELECT MAX(num)
    FROM cte4
);