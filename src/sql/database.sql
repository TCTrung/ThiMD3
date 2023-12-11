create database student;
use student;

CREATE TABLE student(
                        id int auto_increment primary key ,
                        name varchar(255) NOT NULL ,
                        email varchar(255) NOT NULL ,
                        localDate date not null ,
                        address varchar(255) NOT NULL ,
                        phone int(10) NOT NULL,
                        id_class int,
                        foreign key (id_class) references classroom (id)
);


CREATE TABLE classroom(
                          id int primary key auto_increment,
                          name varchar(255)
);

insert into student( name, email,localDate, address, phone,id_class)
values ('Trinh Trung','truggtrinh@gmail.com','1999-02-13','Nam Dinh',0945670347,1),
       ('Cong Trang','trangdc@gmail.com','1999-10-10','Hung Yen',0988141516,3),
       ('Minh Son','minhson@gmail.com','1998-02-10','Ha Noi',0988141516,2);
insert into classroom (name)
values ('C0823H1'),
       ('C0823h1'),
       ('C0922h1');

select s.id,s.name, s.email,s.localDate, s.address, s.phone,c.name from student s
join classroom c
on s.id_class = c.id;
select s.id,s.name, s.email,s.localDate, s.address, s.phone,c.name from student s
join classroom c
on s.id_class = c.id
where s.id = 7;