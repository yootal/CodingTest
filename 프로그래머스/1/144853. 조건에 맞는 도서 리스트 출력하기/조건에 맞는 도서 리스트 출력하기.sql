SELECT BOOK_ID,	LEFT(PUBLISHED_DATE,10) AS PUBLISHED_DATE
FROM BOOK
WHERE LEFT(PUBLISHED_DATE,4) = '2021' AND CATEGORY = '인문'
ORDER BY PUBLISHED_DATE