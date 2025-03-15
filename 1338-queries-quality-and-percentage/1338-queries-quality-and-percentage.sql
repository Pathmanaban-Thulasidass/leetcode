# Write your MySQL query statement below
with cte1 as(
    select query_name, round(Avg(rating / position),2) as quality, count(query_name) total
    from Queries
    group by query_name
),
cte2 as(
    select query_name , count(query_name) low_rating
    from Queries
    where rating < 3
    group by query_name
)

select a.query_name, a.quality, coalesce(round((low_rating / total) * 100,2),0) as poor_query_percentage
from cte1 a
left join cte2 b
on a.query_name = b.query_name;