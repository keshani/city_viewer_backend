DROP TABLE IF EXISTS CITY_INFO;
DROP TABLE IF EXISTS CITY_DOCUMENT;

CREATE TABLE CITY_INFO (
  ID INT PRIMARY KEY,
  CITY_NAME VARCHAR(50) NOT NULL,
  CITY_DESCRIPTION VARCHAR(250) DEFAULT NULL,
  COUNTRY VARCHAR(50) DEFAULT NULL,
  LATITUDE DECIMAL(10,8),
  LONGITUDE DECIMAL(10,8)
);

CREATE TABLE CITY_DOCUMENT (
  ID INT PRIMARY KEY,
  DOC_PATH VARCHAR(1000) NOT NULL,
  DOC_NAME VARCHAR(50) DEFAULT NULL,
  DOC_BELONGS_TO INT DEFAULT NULL,
  DOC_TYPE VARCHAR(20)
);

INSERT INTO CITY_INFO( ID, CITY_NAME, CITY_DESCRIPTION, COUNTRY, LATITUDE, LONGITUDE)
  select convert("id",int), "name", "desciption", "country", convert("lat",decimal(10,8)), convert("lon",decimal(10,8))
  from CSVREAD( 'classpath:city.csv', 'id,name,desciption,country,lat,lon,photo', null );

  INSERT INTO CITY_DOCUMENT( ID, DOC_PATH, DOC_BELONGS_TO, DOC_TYPE)
    select convert("id",int), "path",convert("belongsto",int), "type"
    from CSVREAD( 'classpath:city_images.csv', 'id,path,belongsto,type', null );

--  INSERT INTO CITY_INFO( id, CITY_NAME, CITY_DESCRIPTION, COUNTRY)
--  VALUES (1,'test','test','test');


--  INSERT INTO CITY_DOCUMENT( ID, DOC_PATH, DOC_BELONGS_TO, DOC_TYPE)
--    VALUES(1,'test',1,'test')