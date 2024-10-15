SELECT CONCAT("/home/grep/src/",B.BOARD_ID,"/",A.FILE_ID,A.FILE_NAME,A.FILE_EXT) AS FILE_PATH
FROM USED_GOODS_FILE AS A
JOIN USED_GOODS_BOARD AS B ON A.BOARD_ID = B.BOARD_ID
WHERE VIEWS = (SELECT MAX(VIEWS) FROM USED_GOODS_BOARD WHERE STATUS = 'DONE')
ORDER BY A.FILE_ID DESC;