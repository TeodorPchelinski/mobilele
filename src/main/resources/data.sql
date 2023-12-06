-- CREATE DATABASE  IF NOT EXISTS `mobilele` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
-- USE `mobilele`;
--
-- CREATE TABLE IF NOT EXISTS `mobilele.brands`;
INSERT INTO `brands` (`id`, `name`) VALUES (1,'Audi'),(2,'BMW'),(6,'Ford'),(3,'Mercedes'),(5,'Opel'),(9,'Peugeot'),(8,'Renault'),(7,'Toyota'),(4,'Volkswagen');

INSERT INTO `models` (`id`, `category`, `name`, `brand_id`) VALUES (1,'CAR','A3',1),(2,'CAR','A4',1),(3,'CAR','A5',1),(4,'CAR','A6',1),(5,'CAR','A7',1),(6,'CAR','A8',1),(7,'CAR','M1',2),(8,'CAR','M3',2);

INSERT INTO `offers` (`id`, `description`, `engine`, `image_url`, `mileage`, `price`, `transmission`, `year`, `model_id`, `uuid`) VALUES (1,'Everything changed','PETROL','https://www.skmobil.com/_products_imgs_skmobil/217/superzoom/217__dsc0511-5b3d3f3d93f05.jpg',170000,12000.00,'MANUAL',2015,4,'b2d14eb6-9ee4-47bc-a113-e5a06dbb04b3'),(2,'Only for serious clients please','PETROL','https://www.motortrend.com/uploads/2022/08/2022-Bugatti-Chiron-Super-Sport-2-1.jpg',23232323,230000.00,'MANUAL',2014,5,'baf47ea6-949c-442b-94f9-a527f0ec2ae8'),(3,'dsadasdasfasdf','DIESEL','https://www.motortrend.com/uploads/2022/08/2022-Bugatti-Chiron-Super-Sport-2-1.jpg',23232323,3123.00,'MANUAL',2016,7,'6d856888-fba7-4831-8741-9d988fb5734d');

INSERT INTO `users` (`id`, `active`, `email`, `first_name`, `last_name`, `password`) VALUES (1, 1,'teodor.p4elinski@gmail.com','Teodor','Pchelinski','34576052cf755fd377dbb0aea2e616c40da19eb7c1a5ecbb1cab2de343173d11f7fc8801bc91ebf359fc638caeed4771'),(2,_binary '','teodor.pchelinski@abv.bg','Teodor','Pchelinski','672715a624842c1da5a4af1de83942c41498c89b8b748c6c485b898d7f84d01194dc471f02d82ce0f48aa2b533edf4c6'),(3,_binary '','','','','428dee9c823a53a1004eca8fc315997f84a72cefde90603316dcbdcf940b6c04cca3a4c7e47ab208874a6eb0e79aa18d');

INSERT INTO `exchange_rates` (`currency`,`rate`) VALUES ('BGN', 1.00), ('EUR', 0.51), ('USD', 0.56);
-- Dump completed on 2023-11-21  8:02:19
