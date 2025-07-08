WITH cte1 AS (
    SELECT u.name, m.title, mr.rating, mr.created_at
    FROM MovieRating mr 
    JOIN Users u ON mr.user_id = u.user_id 
    JOIN Movies m ON m.movie_id = mr.movie_id
),
cte2 AS (
    SELECT name
    FROM (
        SELECT name, COUNT(title) AS review_count
        FROM cte1
        GROUP BY name
        ORDER BY review_count DESC, name ASC
        LIMIT 1
    ) AS ranked_users
),
cte3 AS (
    SELECT title AS name
    FROM (
        SELECT title, AVG(rating) AS avg_rating
        FROM cte1
        WHERE created_at BETWEEN '2020-02-01' AND '2020-02-29'
        GROUP BY title
        ORDER BY avg_rating DESC, title ASC
        LIMIT 1
    ) AS ranked_movies
)
SELECT name AS results FROM cte2
UNION ALL
SELECT name FROM cte3;
