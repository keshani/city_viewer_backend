DROP TABLE IF EXISTS CITY_INFO;

CREATE TABLE CITY_INFO (
  ID INT PRIMARY KEY,
  CITY_NAME VARCHAR(250) NOT NULL,
  CITY_DESCRIPTION VARCHAR(250) DEFAULT NULL,
  COUNTRY VARCHAR(250) DEFAULT NULL,
  LATITUDE DECIMAL(10,8),
  LONGITUDE DECIMAL(10,8)
);
INSERT INTO CITY_INFO( ID, CITY_NAME, CITY_DESCRIPTION, COUNTRY, LATITUDE, LONGITUDE)
  select convert("id",int), "name", "desciption", "country", convert("lat",decimal(10,8)), convert("lon",decimal(10,8))
  from CSVREAD( 'classpath:city.csv', 'id,name,desciption,country,lat,lon,photo', null );

--  INSERT INTO CITY_INFO( id, CITY_NAME, CITY_DESCRIPTION, COUNTRY)
--  VALUES (1,'test','test','test');