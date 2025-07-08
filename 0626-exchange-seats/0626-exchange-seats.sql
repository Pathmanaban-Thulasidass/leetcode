SELECT id, 
    CASE
        WHEN s2.id % 2 <> 0 THEN IFNULL((SELECT student FROM Seat s1 WHERE s1.id = (s2.id + 1)) , (SELECT student FROM Seat s1 WHERE s1.id = s2.id))
        ELSE (SELECT student FROM Seat s1 WHERE s1.id = (s2.id - 1)) 
    END AS student 
FROM Seat s2
ORDER BY id;