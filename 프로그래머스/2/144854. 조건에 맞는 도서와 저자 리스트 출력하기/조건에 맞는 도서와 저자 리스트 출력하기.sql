SELECT BOOK.BOOK_ID,AUTHOR.AUTHOR_NAME,LEFT(BOOK.PUBLISHED_DATE,10) AS PUBLISHED_DATE
FROM BOOK
JOIN AUTHOR ON BOOK.AUTHOR_ID = AUTHOR.AUTHOR_ID
WHERE BOOK.CATEGORY = '경제'
ORDER BY BOOK.PUBLISHED_DATE;