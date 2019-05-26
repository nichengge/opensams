create database opensams default character set utf8mb4;

use opensams;

create table student(
  id int primary key auto_increment,
  student_name varchar(64),
  student_code varchar(16),
  birthday timestamp,
  sex varchar(16),
  mail varchar(255),
  local_mail varchar(255),
  phone varchar(16),
  qq varchar(16),
  college varchar(255),
  major varchar(255),
  avatar varchar(255),
  login_name varchar(255),
  login_pwd varchar(255),
  description text,
  created_at timestamp default current_timestamp,
  modified_at timestamp default current_timestamp
) engine innodb default character set utf8mb4;

create table student_role(
  id int primary key auto_increment,
  student_code varchar(64),
  role_code varchar(16),
  created_at timestamp default current_timestamp,
  modified_at timestamp default current_timestamp
) engine innodb default character set utf8mb4;

create table role(
  id int primary key auto_increment,
  role varchar(16),
  role_code varchar(16),
  created_at timestamp default current_timestamp,
  modified_at timestamp default current_timestamp
) engine innodb default character set utf8mb4;

create table role_permission(
  id int primary key auto_increment,
  role_code varchar(16),
  permission_code varchar(16),
  created_at timestamp default current_timestamp,
  modified_at timestamp default current_timestamp
) engine innodb default character set utf8mb4;

create table permission(
  id int primary key auto_increment,
  permission varchar(64),
  permission_code varchar(16),
  created_at timestamp default current_timestamp,
  modified_at timestamp default  current_timestamp
) engine innodb default character set utf8mb4;

create table association(
  id int primary key auto_increment,
  name varchar(64),
  founder varchar(64),
  founder_code varchar(16),
  type varchar(16),
  avatar varchar(255),
  spot varchar(255),
  description text,
  created_at timestamp default current_timestamp,
  modified_at timestamp default current_timestamp
) engine innodb default character set utf8mb4;

create table student_association(
  id int primary key auto_increment,
  student_code varchar(16),
  association_id int,
  created_at timestamp default current_timestamp,
  modified_at timestamp default current_timestamp
) engine innodb default character set utf8mb4;

create table notice(
  id int primary key auto_increment,
  title varchar(255),
  content text,
  publisher_code varchar(16),
  created_at timestamp default current_timestamp,
  modified_at timestamp default current_timestamp
) engine innodb default character set utf8mb4;

create table email(
  id int primary key auto_increment,
  email_to varchar(255),
  email_from varchar(255),
  subject varchar(255),
  content text,
  author_code varchar(16),
  type_code varchar(16),
  attach varchar(255),
  created_at timestamp default current_timestamp,
  modified_at timestamp default current_timestamp
) engine innodb default character set utf8mb4;

create table application(
  id int primary key auto_increment,
  title varchar(255),
  type varchar(16),
  reason text,
  mark varchar(255),
  applicant varchar(16),
  created_at timestamp default current_timestamp,
  modified_at timestamp default current_timestamp
) engine innodb default character set utf8mb4;

create table approval(
  id int primary key auto_increment,
  application_id int,
  processor varchar(16),
  status varchar(16),
  advice text,
  created_at timestamp default current_timestamp,
  modified_at timestamp default current_timestamp
) engine innodb default character set utf8mb4;

create table asset(
  id int primary key auto_increment,
  name varchar(64),
  amount int,
  unit varchar(4),
  owner_club int,
  description text,
  created_at timestamp default current_timestamp,
  modified_at timestamp default current_timestamp
) engine innodb default character set utf8mb4;

create table activity(
  id int primary key  auto_increment,
  name varchar(255),
  spot varchar(255),
  association varchar(255),
  startTime timestamp,
  endTime timestamp,
  number int,
  principal varchar(64),
  teacher varchar(64),
  description text,
  created_at timestamp default current_timestamp,
  modified_at timestamp default current_timestamp
) engine innodb default character set utf8mb4;


