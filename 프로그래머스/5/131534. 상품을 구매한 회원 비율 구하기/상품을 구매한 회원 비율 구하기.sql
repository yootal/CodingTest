SELECT 
    DATE_FORMAT(B.SALES_DATE, '%Y') AS YEAR,
    DATE_FORMAT(B.SALES_DATE, '%m') AS MONTH,
    COUNT(DISTINCT B.USER_ID) AS PUCHASED_USERS,
    ROUND(COUNT(DISTINCT B.USER_ID)/(SELECT COUNT(*) FROM USER_INFO WHERE LEFT(JOINED,4) = 2021),1) AS PUCHASED_RATIO
FROM USER_INFO  A
JOIN ONLINE_SALE B ON A.USER_ID = B.USER_ID
WHERE LEFT(A.JOINED,4) = 2021
GROUP BY YEAR, MONTH
ORDER BY YEAR, MONTH;