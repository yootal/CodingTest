SELECT COUNT(*) AS USERS
FROM USER_INFO 
WHERE LEFT(JOINED,4) = '2021' AND AGE BETWEEN 20 AND 29