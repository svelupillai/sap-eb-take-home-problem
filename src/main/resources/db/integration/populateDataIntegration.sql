CREATE TABLE trails AS SELECT * FROM CSVREAD('classpath:db/integration/BoulderTrailHeadsIntegration.csv');
