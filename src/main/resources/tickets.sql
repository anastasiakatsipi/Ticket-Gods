drop database if exists Tickets;
create database Tickets;
use Tickets;

create table Cinema (ccode varchar(20), cnames varchar(40), times varchar(20), seats varchar(10), price float(2.2), primary key (ccode));
create table Sports (gcode varchar(20), gnames varchar(40), times varchar(20), seats varchar(10), price float(2.2),primary key (gcode));
create table Festivals (fcode varchar(20), fnames varchar(40), times varchar(20), seats varchar(10), price float(2.2),primary key (fcode));
create table Museums (mcode varchar(20), gal_names varchar(40), price float(2.2),primary key (mcode));
create table Users(username varchar(20), mail varchar(40), passwords varchar(100), roles ENUM('USER', 'ADMIN'), primary key (username));
create table Booking(id varchar (20), username varchar(8), bookname varchar(40), booktimes varchar(20), bookseats varchar(10), bookprice float(2.2), primary key (id));

insert into Museums values("#1Akro1223A","Greek statues", 16.00);
insert into Museums values("#1Akro1223B","Greek statues", 16.00);
insert into Museums values("#1Akro1223C","Greek statues", 16.00);
insert into Museums values("#1Akro1223D","Greek statues", 16.00);
insert into Museums values("#1Akro1223E","Greek statues", 16.00);
insert into Museums values("#1Akro1223F","Greek statues", 16.00);
insert into Museums values("#1Akro1223G","Greek statues", 16.00);
insert into Museums values("#1Akro1223H","Greek statues", 16.00);

insert into Museums values("#1Brit1223A","Capturing WWII", 17.00);
insert into Museums values("#1Brit1223B","Capturing WWII", 17.00);
insert into Museums values("#1Brit1223C","Capturing WWII", 17.00);
insert into Museums values("#1Brit1223D","Capturing WWII", 17.00);
insert into Museums values("#1Brit1223E","Capturing WWII", 17.00);
insert into Museums values("#1Brit1223F","Capturing WWII", 17.00);
insert into Museums values("#1Brit1223G","Capturing WWII", 17.00);
insert into Museums values("#1Brit1223H","Capturing WWII", 17.00);

insert into Festivals values("#2Rame241A","Ramenstain European Tour", "20:00", "1A", 30.00);
insert into Festivals values("#2Rame241B","Ramenstain European Tour", "20:00", "1B", 30.00);
insert into Festivals values("#2Rame241C","Ramenstain European Tour", "20:00", "1C", 30.00);
insert into Festivals values("#2Rame241D","Ramenstain European Tour", "20:00", "1D", 30.00);
insert into Festivals values("#2Rame242A","Ramenstain European Tour", "20:00", "2A", 19.00);
insert into Festivals values("#2Rame242B","Ramenstain European Tour", "20:00", "2B", 19.00);
insert into Festivals values("#2Rame242C","Ramenstain European Tour", "20:00", "2C", 19.00);
insert into Festivals values("#2Rame242D","Ramenstain European Tour", "20:00", "2D", 19.00);

insert into Festivals values("#2BlSb241A","Black Sabbath European Tour", "20:00", "1A", 90.00);
insert into Festivals values("#2BlSb241B","Black Sabbath European Tour", "20:00", "1B", 90.00);
insert into Festivals values("#2BlSb241C","Black Sabbath European Tour", "20:00", "1C", 90.00);
insert into Festivals values("#2BlSb241D","Black Sabbath European Tour", "20:00", "1D", 90.00);
insert into Festivals values("#2BlSb242A","Black Sabbath European Tour", "20:00", "2A", 30.00);
insert into Festivals values("#2BlSb242B","Black Sabbath European Tour", "20:00", "2B", 30.00);
insert into Festivals values("#2BlSb242C","Black Sabbath European Tour", "20:00", "2C", 30.00);
insert into Festivals values("#2BlSb242D","Black Sabbath European Tour", "20:00", "2D", 30.00);

insert into Cinema values("#3CiOp151A","Oppenheimer", "15:00", "1A", 15.00);
insert into Cinema values("#3CiOp151B","Oppenheimer", "15:00", "1B", 15.00);
insert into Cinema values("#3CiOp151C","Oppenheimer", "15:00", "1C", 15.00);
insert into Cinema values("#3CiOp151D","Oppenheimer", "15:00", "1D", 15.00);
insert into Cinema values("#3CiOp152A","Oppenheimer", "15:00", "2A", 10.00);
insert into Cinema values("#3CiOp152B","Oppenheimer", "15:00", "2B", 10.00);
insert into Cinema values("#3CiOp152C","Oppenheimer", "15:00", "2C", 10.00);
insert into Cinema values("#3CiOp152D","Oppenheimer", "15:00", "2D", 10.00);

insert into Cinema values("#3CiBa161A","Barbie", "16:00", "1A", 15.00);
insert into Cinema values("#3CiBa161B","Barbie", "16:00", "1B", 15.00);
insert into Cinema values("#3CiBa161C","Barbie", "16:00", "1C", 15.00);
insert into Cinema values("#3CiBa161D","Barbie", "16:00", "1D", 15.00);
insert into Cinema values("#3CiBa162A","Barbie", "16:00", "2A", 10.00);
insert into Cinema values("#3CiBa162B","Barbie", "16:00", "2B", 10.00);
insert into Cinema values("#3CiBa162C","Barbie", "16:00", "2C", 10.00);
insert into Cinema values("#3CiBa162D","Barbie", "16:00", "2D", 10.00);

insert into Cinema values("#3CiOp191A","Oppenheimer", "19:00", "1A", 20.00);
insert into Cinema values("#3CiOp191B","Oppenheimer", "19:00", "1B", 20.00);
insert into Cinema values("#3CiOp191C","Oppenheimer", "19:00", "1C", 20.00);
insert into Cinema values("#3CiOp191D","Oppenheimer", "19:00", "1D", 20.00);
insert into Cinema values("#3CiOp192A","Oppenheimer", "19:00", "2A", 15.00);
insert into Cinema values("#3CiOp192B","Oppenheimer", "19:00", "2B", 15.00);
insert into Cinema values("#3CiOp192C","Oppenheimer", "19:00", "2C", 15.00);
insert into Cinema values("#3CiOp192D","Oppenheimer", "19:00", "2D", 15.00);

insert into Cinema values("#3CiBa201A","Barbie", "20:00", "1A", 20.00);
insert into Cinema values("#3CiBa201B","Barbie", "20:00", "1B", 20.00);
insert into Cinema values("#3CiBa201C","Barbie", "20:00", "1C", 20.00);
insert into Cinema values("#3CiBa201D","Barbie", "20:00", "1D", 20.00);
insert into Cinema values("#3CiBa202A","Barbie", "20:00", "2A", 15.00);
insert into Cinema values("#3CiBa202B","Barbie", "20:00", "2B", 15.00);
insert into Cinema values("#3CiBa202C","Barbie", "20:00", "2C", 15.00);
insert into Cinema values("#3CiBa202D","Barbie", "20:00", "2D", 15.00);

insert into Sports values("#4OsfpPao23/10.1A","OSFP - PAO", "20:00", "1A", 15.00);
insert into Sports values("#4OsfpPao23/10.1B","OSFP - PAO", "15:00", "1B", 15.00);
insert into Sports values("#4OsfpPao23/10.1C","OSFP - PAO", "15:00", "1C", 15.00);
insert into Sports values("#4OsfpPao23/10.1D","OSFP - PAO", "15:00", "1D", 15.00);
insert into Sports values("#4OsfpPao23/10.2A","OSFP - PAO", "15:00", "2A", 10.00);
insert into Sports values("#4OsfpPao23/10.2B","OSFP - PAO", "15:00", "2B", 10.00);
insert into Sports values("#4OsfpPao23/10.2C","OSFP - PAO", "15:00", "2C", 10.00);
insert into Sports values("#4OsfpPao23/10.2D","OSFP - PAO", "15:00", "2D", 10.00);

insert into Sports values("#4PaokAek25/12.1A","AEK - PAOK", "20:00", "1A", 15.00);
insert into Sports values("#4PaokAek25/12.1B","AEK - PAOK", "15:00", "1B", 15.00);
insert into Sports values("#4PaokAek25/12.1C","AEK - PAOK", "15:00", "1C", 15.00);
insert into Sports values("#4PaokAek25/12.1D","AEK - PAOK", "15:00", "1D", 15.00);
insert into Sports values("#4PaokAek25/12.2A","AEK - PAOK", "15:00", "2A", 10.00);
insert into Sports values("#4PaokAek25/12.2B","AEK - PAOK", "15:00", "2B", 10.00);
insert into Sports values("#4PaokAek25/12.2C","AEK - PAOK", "15:00", "2C", 10.00);
insert into Sports values("#4PaokAek25/12.2D","AEK - PAOK", "15:00", "2D", 10.00);