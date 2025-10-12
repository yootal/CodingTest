SELECT id, num
FROM (
  SELECT u.id, SUM(u.num) AS num
  FROM (
    SELECT requester_id AS id, COUNT(*) AS num
    FROM RequestAccepted
    GROUP BY requester_id
    UNION ALL
    SELECT accepter_id AS id, COUNT(*) AS num
    FROM RequestAccepted
    GROUP BY accepter_id
  ) AS u
  GROUP BY u.id
) AS t
ORDER BY num DESC
LIMIT 1;