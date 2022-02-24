create database news_sys;
use news_sys;

create table customers(
	customer_id int not null primary key,
    customer_first_name varchar(50) not null,
	customer_last_name varchar(50) not null,
    customer_phone varchar(50) not null
);

create table subscription_details(
	order_id int not null,
    item_name varchar(50) not null,
    item_qty int not null,
    delivery_frequency int not null,
    customer_id int not null,
    primary key (order_id),
    foreign key (customer_id) references customers(customer_id)
);

create table delivery(
	customer_id int not null primary key,
    area_name varchar(25) not null,
    address_name varchar(50) not null,
    postcode varchar(10) not null
);

create table payment(
	payment_id int not null,
    payment_method varchar(10) not null,
    customer_id int not null,
    primary key (payment_id),
    foreign key (customer_id) references customers(customer_id)
)