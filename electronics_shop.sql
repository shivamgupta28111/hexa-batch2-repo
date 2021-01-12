create database retaildb;
use retaildb;

create table Login (
loginId int not null unique,
username varchar(50) primary key,
passcode varchar(100) not null,
userType varchar(30) not null);

create table BUYER (
  buyerId int primary key,
  buyerName varchar(50) not null,
  address text(255) not null,
  phone varchar(10) not null,
  emailAddress varchar(50) not null,
  walletBalance double not null);
  
-- alter table CUSTOMER add username varchar(20) not null;
-- alter table CUSTOMER add pass varchar(50) not null;

create table SUPPLIERS (
	supplierId int primary key,
    supplierName varchar(100) not null,
    supplierAddress text(255) not null,
    phoneNo varchar(10) not null,
    emailAdd varchar(50) not null);

-- alter table suppliers add s_username varchar(20) not null;
-- alter table suppliers add s_password varchar(30) not null;
  
create table ORDERS (
	orderId int primary Key,
    orderDate date not null,
    orderAmount double not null,
    buyerId int not null,
    itemId int not null,
    itemQty int not null);

alter table ORDERS add constraint foreign key (buyerId) references Buyer(buyerId);
alter table ORDERS add supplierId int not null;
alter table ORDERS add constraint foreign key (supplierId) references Suppliers(supplierId);
alter table ORDERS add feedback varchar(100);

-- alter table ORDERS add Item1 int not null;
-- alter table ORDERS add constraint foreign key (item1) references items(itemId);
-- alter table ORDERS add Item2 int;
-- alter table ORDERS add constraint foreign key (item2) references items(itemId);
-- alter table ORDERS add Item3 int;
-- alter table ORDERS add constraint foreign key (item3) references items(itemId);
alter table orders add orderStatus varchar(10) not null;

desc ORDERS; -- see the structure of the table
desc customer;

INSERT INTO Buyer VALUES (1001, 'Pallavi Prasad', 'Basaveshwarnagar, Bangalore, Karnataka', '9845543403', 'pallaviprasad.0611@gmail.com', 4500.00);
INSERT INTO Buyer (customerName, customerId, walletbalance, phone, address, emailaddress) VALUES ('Manjula Mahesh', 1002, 4500.00, '9843949433', 'Salem, Tamil Nadu', 'manjula.mahesh@gmail.com');

select * from Buyer;

create table ITEMS (
	itemId int primary key,
    itemName varchar(30) not null,
    unitprice double not null,
    itemCategory varchar(30) not null);
    
alter table ITEMS add supplierId int not null;
alter table ITEMS add constraint foreign key (supplierId) references suppliers(supplierId);
-- alter table ITEMS drop column itemcategory;

update Buyer set username = 'pallavi' where buyerid=1001; 
update Buyer set pass = 'pallavi@123' where buyerid=1001;
update Buyer set username = 'manjula' where buyerid=1002;
update Buyer set pass = 'manjula@123' where buyerid=1002;

-- delete from customer where customerid = 1002;

select constraint_name from information_schema.table_constraints where table_name = 'ORDERS'; -- to retrieve all keys for a table
select constraint_name from information_schema.key_column_usage where table_name = 'ORDERS' and column_name = 'item3';

alter table orders drop foreign key orders_ibfk_5; -- to drop a foreign key
alter table orders drop column item3; -- to delete a column

alter table orders rename column itemId to item1;  -- rename a column

-- 05-01-2021 -> insert, update etc.
INSERT INTO SUPPLIERS VALUES 
	(2001, 'Minecraft Ltd.', 'San Jose, California, USA', '0177778922', 'sales@minecraft.com', '2001', '2001'),
    (2002, 'Inverta Ltd.', 'Bangalore, Karnataka, India', '8738832222', 'sales@inverta.in', '2002','2002'),
    (2003, 'Stark Enterprises', 'London, UK', '4447770922', 'sales@starkenterprises.uk', '2003','2003');
insert into suppliers values (2004, 'Mason & Co.', 'Hyderabad, TS, India', '8477373221','sales@mnc.com','2004','2004');

select * from items;
select * from suppliers;

insert into items values 
	(4001, 'Mac Book Pro', 100000.00, 'Apple', 2001),
    (4002, 'MI Redmi Note 9 Pro', 45000.00, 'Xiaomi', 2002),
    (4003, 'Dell Insprion 3000', 68000.00, 'Dell',2002),
    (4004, 'Lenovo Laptop', 70000.00, 'Lenovo', 2003);

insert into items values
	(4002, 'MI Redmi Note 9 Pro', 45000.00, 'Xiaomi', 2002),
    (4004, 'Lenovo Laptop', 70000.00, 'Lenovo', 2003);
    
insert into items values 
	(4001, 'Mac Book Pro', 100000.00, 'Apple', 2001),
    (4002, 'MI Redmi Note 9 Pro', 45000.00, 'Xiaomi', 2002);
    
-- single row update
update suppliers set s_password = 'stark@123' where supplierId = 2003;

-- multi row update
update items set unitprice = 45000.00 where supplierid = 2002 and brands IN ('Xiaomi','Dell');

update items set unitprice = 50000.00 where supplierid IN (2002,2003);


-- single row delete
delete from items where itemid = 4002;

-- multi row delete
delete from items where supplierid = 2002;

-- delete all rows
delete from items;

-- delete limited rows
delete from items limit 2;

-- -----------------SELECT statements --------------------------
select * from suppliers; -- displays all attributes of all records

select suppliername, supplieraddress, emailadd from suppliers; -- displays the selected attributes for all records

-- ----------Filters ----------------------
select * from suppliers where suppliername = 'Minecraft Ltd.';

select * from suppliers where suppliername LIKE 'M%';

select * from suppliers where suppliername LIKE 'M_';

select distinct supplierid from items;

select * from items where supplierid IN (2002, 2003);

select * from items where supplierid NOT IN (2002, 2003);

select * from items where unitprice BETWEEN 40000 and 70000;
select * from items where unitprice > 40000 and unitprice < 70000;

select * from items ORDER BY itemname ASC;

select brands, itemname, supplierId from items group by supplierid;

select supplierid, count(*) from items group by supplierid;

select supplierid, sum(unitprice) AS Total from items group by supplierid;

select supplierid, sum(unitprice) AS Total 
   from items 
   group by supplierid
   having Total > 100000;
   
drop database retaildb;





