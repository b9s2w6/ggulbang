CREATE TABLE `product` (
  `userId` varchar(20) NOT NULL,
  `aptCode` bigint NOT NULL,
  PRIMARY KEY (`userId`, `aptCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;