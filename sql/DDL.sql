/**
 * Author:  kevin
 * Created: 27/12/2024
 */

CREATE USER 'auth'@'localhost' IDENTIFIED WITH mysql_native_password BY 'auth-password' 
  PASSWORD EXPIRE INTERVAL 180 DAY
  FAILED_LOGIN_ATTEMPTS 3 PASSWORD_LOCK_TIME 2;

CREATE DATABASE auth_db;