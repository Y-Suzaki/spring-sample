SELECT
  BOOKMARK.ID
FROM BOOKMARK
INNER JOIN BOOKMARK_TAG ON BOOKMARK.ID = BOOKMARK_TAG.BOOKMARK_ID
INNER JOIN TAG ON BOOKMARK_TAG.TAG_ID = TAG.ID
WHERE TAG.ID = /* tagId */1
ORDER BY BOOKMARK.ID ASC