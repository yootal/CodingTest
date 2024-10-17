SELECT USER_ID,NICKNAME,SUM(PRICE) AS TOTAL_SALES
FROM USED_GOODS_BOARD AS A
JOIN USED_GOODS_USER AS B ON A.WRITER_ID = B.USER_ID
WHERE STATUS = 'DONE'
GROUP BY A.WRITER_ID
HAVING SUM(PRICE) >= 700000
ORDER BY TOTAL_SALES;