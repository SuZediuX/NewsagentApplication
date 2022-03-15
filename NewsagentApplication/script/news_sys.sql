create database news_sys;
use news_sys;

create table customers(
	customer_id int not null auto_increment primary key,
    customer_name varchar(50) not null,
	customer_pwd varchar(50) not null,
    customer_phone varchar(50) not null
);

create table subscription_details(
	sub_id int not null,
    item_name varchar(50) not null,
    item_qty int not null,
    delivery_frequency int not null,
    customer_id int not null,
    sub_date date not null,
    primary key (sub_id),
    foreign key (customer_id) references customers(customer_id)
);

create table delivery(
	customer_id int not null primary key,
    area_name varchar(25) not null,
    address_name varchar(50) not null,
    postcode varchar(10) not null
);

create table payment(
	payment_id int not null auto_increment,
    payment_method varchar(10) not null,
    customer_id int not null,
    primary key (payment_id),
    foreign key (customer_id) references customers(customer_id)
);

insert into customers values (1, 'Korah', '123456', '6145554435'),
(2, 'Yash', '111111', '2095551205'),
(3, 'Johnathon', '222222', '2125554800'),
(4, 'Mikayla', '333333', '8005557000'),
(5, 'Kendall', '123456', '5135553043');

insert into delivery values (3, "Athlone", "1 Willow Park", "N37 N5D0"),
(1, "Cork", "56 Bandon Road", "T12 R94V"),
(4, "Galway", "34 Moyola Park", "H91 XD3D");

insert into subscription_details values (1, "Irish Times", 1, 1, 3,'2022-01-15'),
(2, "Thinking in Java", 3, 2, 1,'2022-01-30'),
(3, "Harry Potter", 11, 3, 4,'2022-02-10');

insert into customers values (100, 'John', 'Doe', '6145554435'),
(200, 'Canis', 'Majoris', '2095551205'),
(300, 'R', 'Leporis', '2125554800'),
(400, 'Proxima', 'Centauri', '8005557000'),
(500, 'Eris', 'Morn', '5135553043');

insert into payment(customer_id, payment_method) 
values (100, "cash"),
(200, "card"),
(300, "card"),
(400, "cash"),
(500, "card");

USE news_sys;

CREATE TABLE PAY_REMINDER(
REMINDER_ID INT NOT NULL AUTO_INCREMENT,
AMOUNT_DUE DOUBLE NOT NULL,
DATE_DUE DATE NOT NULL,
CUSTOMER_ID INT NOT NULL,
    PRIMARY KEY (REMINDER_ID),
    FOREIGN KEY (CUSTOMER_ID) references customers(customer_id)
);

INSERT INTO PAY_REMINDER(AMOUNT_DUE, DATE_DUE, CUSTOMER_ID)
VALUES 
(5, '2022-03-31', 100),
(50, '2022-06-30', 200),
(33.333, '2022-02-28', 300);

SELECT * FROM PAY_REMINDER;