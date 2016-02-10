DROP USER 'fsmanager'@'localhost';
DROP USER 'fsmanager'@'%';
CREATE USER 'fsmanager'@'localhost' IDENTIFIED BY 'fman';
CREATE USER 'fsmanager'@'%' IDENTIFIED BY 'fman';
GRANT INSERT, SELECT, UPDATE, DELETE, CREATE, DROP ON FSTOOLS.* TO 'fsmanager'@'%' IDENTIFIED BY 'fman';
GRANT INSERT, SELECT, UPDATE, DELETE, CREATE, DROP ON FSTOOLS.* TO 'fsmanager'@'%' IDENTIFIED BY 'fman';
