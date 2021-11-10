CREATE TABLE `user` (
                        `user_id` int NOT NULL AUTO_INCREMENT,
                        `adress` varchar(255) DEFAULT NULL,
                        `age` int DEFAULT NULL,
                        `user_name` varchar(255) DEFAULT NULL,
                        `user_password` varchar(255) DEFAULT NULL,
                        `phone_number` int DEFAULT NULL,
                        `role` varchar(255) DEFAULT NULL,
                        PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `admin` (
                         `admin_id` int NOT NULL AUTO_INCREMENT,
                         `admin_login` varchar(255) DEFAULT NULL,
                         `admin_password` varchar(255) DEFAULT NULL,
                         `role` varchar(255) DEFAULT NULL,
                         PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `message` (
                           `message_id` int NOT NULL AUTO_INCREMENT,
                           `message_content` varchar(255) DEFAULT NULL,
                           `from_id` int DEFAULT NULL,
                           `to_id` int DEFAULT NULL,
                           PRIMARY KEY (`message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `user_to_user` (
                                `id` int NOT NULL AUTO_INCREMENT,
                                `user_id_from` int NOT NULL,
                                `user_message_target_id` int NOT NULL,
                                PRIMARY KEY (`id`),
                                KEY `message_to_user_idx` (`user_message_target_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;