DROP DATABASE IF EXISTS angular;

CREATE DATABASE IF NOT EXISTS angular
  COLLATE = 'utf8_general_ci'
  DEFAULT CHARACTER SET = 'utf8';

USE angular;

DROP TABLE IF EXISTS t_article;
DROP TABLE IF EXISTS t_people;

## 文章
CREATE TABLE t_article (
  id       BIGINT AUTO_INCREMENT PRIMARY KEY,
  title    VARCHAR(64),
  category VARCHAR(32)
)
  ENGINE = InnoDB,
  DEFAULT CHARSET = utf8;

CREATE TABLE t_people (
  id   BIGINT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(32),
  age  INT
)
  ENGINE = InnoDB,
  DEFAULT CHARSET = utf8;

INSERT INTO t_article (id, title, category) VALUES
  (1, 'Angular 2 Tutorial using CLI', 'Angular'),
  (2, 'Spring Boot Getting Started', 'Spring Boot'),
  (3, 'Lambda Expressions Java 8 Example', 'Java 8'),
  (4, 'Android AsyncTask Example', 'Android');

INSERT INTO t_people (id, name, age) VALUES
  ('1', 'Zhang', 25),
  ('2', 'Li', 30),
  ('3', 'Wang', 18);