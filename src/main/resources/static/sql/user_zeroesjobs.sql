DROP USER IF EXISTS 'zeroesjobs'@'%';

CREATE USER 'zeroesjobs'@'localhost' IDENTIFIED BY 'zeroesjobs';

GRANT ALL PRIVILEGES ON * . * TO 'zeroesjobs'@'localhost';