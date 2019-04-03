DROP TABLE IF EXISTS Users; 
CREATE TABLE Users (
    id 							VARCHAR(36) NOT NULL, 
    user_role 				    CHAR(5) NOT NULL,
    username                    VARCHAR(64) NOT NULL,
    password_hash               VARCHAR(64) NOT NULL,
    
    primary key (id)
);

set @UserId1 = UUID();
set @UserId2 = UUID();

INSERT INTO Users(id, user_role, username, password_hash) VALUES (@UserId1, 'USER', 'bphun', '1234');
INSERT INTO Users(id, user_role, username, password_hash) VALUES (@UserId2, 'ADMIN', 'admin', '1234');

SELECT * FROM Users;

use mysql;

GRANT ALL ON *.* to root@'%' IDENTIFIED BY '1234';

GRANT ALL ON *.* TO 'authDatabase'@'%' IDENTIFIED BY '1234';

FLUSH PRIVILEGES;