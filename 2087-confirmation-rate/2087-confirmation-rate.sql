WITH confirmedDB AS (
    SELECT s.user_id, COUNT(c.user_id) AS confirmed_count
    FROM Signups s
    LEFT JOIN Confirmations c
    USING(user_id)
    WHERE c.action = 'confirmed'
    GROUP BY s.user_id
), 
totalDB AS (
    SELECT s.user_id, COUNT(c.user_id) AS total_count
    FROM Signups s
    LEFT JOIN Confirmations c
    USING(user_id)
    GROUP BY s.user_id
)

SELECT t.user_id, 
       CASE 
           WHEN t.total_count = 0 THEN 0 
           ELSE Round(COALESCE(c.confirmed_count, 0) / t.total_count,2) 
       END AS confirmation_rate
FROM totalDB t
LEFT JOIN confirmedDB c
ON t.user_id = c.user_id;