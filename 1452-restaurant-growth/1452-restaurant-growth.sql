SELECT DISTINCT c1.visited_on, 
    (SELECT SUM(amount) 
    FROM Customer c3
    WHERE c3.visited_on BETWEEN DATE_SUB(c1.visited_on, INTERVAL 6 DAY) AND c1.visited_on) AS amount,
    (SELECT ROUND(SUM(amount) / 7 ,2) 
    FROM Customer c3
    WHERE c3.visited_on BETWEEN DATE_SUB(c1.visited_on, INTERVAL 6 DAY) AND c1.visited_on) AS average_amount
FROM Customer c1
WHERE EXISTS(
    SELECT 1
    FROM Customer c2
    WHERE c2.visited_on = DATE_SUB(c1.visited_on, INTERVAL 6 DAY)
)