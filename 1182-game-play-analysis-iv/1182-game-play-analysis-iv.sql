with cte1 as(
    SELECT player_id, MIN(event_date) AS first_login
    FROM Activity a
    GROUP BY player_id
    HAVING EXISTS (
        SELECT 1
        FROM Activity b
        WHERE b.player_id = a.player_id
        AND b.event_date = DATE_ADD(MIN(a.event_date), INTERVAL 1 DAY)
    )
),
cte2 as(
    SELECT player_id
    FROM Activity
    GROUP BY player_id
)
SELECT ROUND(((SELECT COUNT(*) FROM cte1) / (SELECT COUNT(*) FROM cte2)),2) as fraction