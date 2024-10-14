SELECT I.ITEM_ID,I.ITEM_NAME,I.RARITY
FROM ITEM_TREE AS T1
LEFT OUTER JOIN ITEM_TREE AS T2 ON T1.ITEM_ID = T2.PARENT_ITEM_ID
JOIN ITEM_INFO I ON T1.ITEM_ID = I.ITEM_ID
WHERE T2.ITEM_ID IS NULL
ORDER BY T1.ITEM_ID DESC;