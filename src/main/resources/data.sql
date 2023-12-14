-- CREATE DATABASE  IF NOT EXISTS `mobilele` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
-- USE `mobilele`;
--
-- CREATE TABLE IF NOT EXISTS `mobilele.brands`;
INSERT INTO brands (`id`, `name`) VALUES (1,'Audi'),(2,'BMW'),(6,'Ford'),(3,'Mercedes'),(5,'Opel'),(9,'Peugeot'),(8,'Renault'),(7,'Toyota'),(4,'Volkswagen');

INSERT INTO models (`id`, `category`, `name`, `brand_id`) VALUES (1,'CAR','A3',1),(2,'CAR','A4',1),(3,'CAR','A5',1),(4,'CAR','A6',1),(5,'CAR','A7',1),(6,'CAR','A8',1),(7,'CAR','M1',2),(8,'CAR','M3',2);

INSERT INTO offers (`id`, `description`, `engine`, `image_url`, `mileage`, `price`, `transmission`, `year`, `model_id`, `uuid`) VALUES (1,'Everything changed','PETROL','https://www.skmobil.com/_products_imgs_skmobil/217/superzoom/217__dsc0511-5b3d3f3d93f05.jpg',170000,12000.00,'MANUAL',2015,4,'b2d14eb6-9ee4-47bc-a113-e5a06dbb04b3'),(2,'Only for serious clients please','PETROL','https://www.motortrend.com/uploads/2022/08/2022-Bugatti-Chiron-Super-Sport-2-1.jpg',23232323,230000.00,'MANUAL',2014,5,'baf47ea6-949c-442b-94f9-a527f0ec2ae8'),(3,'dsadasdasfasdf','DIESEL','https://www.motortrend.com/uploads/2022/08/2022-Bugatti-Chiron-Super-Sport-2-1.jpg',23232323,3123.00,'MANUAL',2016,7,'6d856888-fba7-4831-8741-9d988fb5734d');

INSERT INTO vignettes (`id`, `start_date`, `expire_date`, `period`, `car_id`)

2024-04-24	2023-12-14	1	1	THREE_MONTHS