with noOfUser as(
    SELECT COUNT(*)
    FROM Users
)

SELECT contest_id ,
    ROUND(((COUNT(r.contest_id) / (select * from noOfUser)) * 100 ), 2) AS percentage 
FROM Register r
GROUP BY r.contest_id
order by percentage desc,contest_id;
