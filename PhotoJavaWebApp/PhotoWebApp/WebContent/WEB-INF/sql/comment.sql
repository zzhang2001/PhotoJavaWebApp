CREATE TABLE COMMENT (
  COMMENT_ID INTEGER PRIMARY KEY NOT NULL IDENTITY,
  PHOTO_ID INTEGER NOT NULL,
  USER_NAME VARCHAR(50) NOT NULL,
  COMMENT_BODY VARCHAR(500) NOT NULL,
  CREATE_DATE DATE NOT NULL,
  FOREIGN KEY (PHOTO_ID) REFERENCES PHOTO (PHOTO_ID)
);