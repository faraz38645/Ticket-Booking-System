# Ticket-Booking-System
# Queries regarding the project.....

/*
create table Admin(
	admin_id int IDENTITY(1,1) not null primary key,
	name nvarchar(30) ,
	password nvarchar(30) 

)

create table Users(
	user_id int IDENTITY(1,1) not null primary key,
	name nvarchar(30) not null ,
	password nvarchar(30) not null,
	address nvarchar(30) not null,
	phone nvarchar(30) default null,
	
)

create table Events(
	event_id int IDENTITY(1,1) not null primary key,
	event_name nvarchar(30) not null ,
	event_date date not null,
	numb_of_tic int not null,
	admin_id int FOREIGN KEY REFERENCES Admin(admin_id)

)

create table Ticket_Checkouts(
	event_checkout_id int IDENTITY(1,1) not null primary key,
	user_id int FOREIGN KEY REFERENCES Users(user_id) ,
	admin_id int FOREIGN KEY REFERENCES Admin(admin_id),
	user_name nvarchar(30) not null,
	numb_of_ticket int  not null,
	event_name nvarchar(30) not null,
	event_date date not null,
	seating_portion nvarchar(30) not null,
	event_id int FOREIGN KEY REFERENCES Events(event_id)
	

)
*/
--SET ANSI_WARNINGS OFF;
-- Your insert TSQL here.
--SET ANSI_WARNINGS ON;

--insert into Admin values('zawar','okay1')

--update Events set numb_of_tic =numb_of_tic-1 
--where event_id =1
