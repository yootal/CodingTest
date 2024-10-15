SELECT A.NAME, A.DATETIME
FROM ANIMAL_INS AS A
LEFT OUTER JOIN ANIMAL_OUTS AS B ON A.ANIMAL_ID = B.ANIMAL_ID
WHERE B.ANIMAL_ID IS NULL
ORDER BY DATETIME
LIMIT 3;