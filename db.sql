DROP TABLE IF EXISTS Branch cascade ;
DROP TABLE IF EXISTS Employee CASCADE;
DROP TABLE IF EXISTS "group" CASCADE;
DROP TABLE IF EXISTS Group_history CASCADE;

create  table Branch(
branch_code varchar(50) primary key ,
branch_name varchar(50) not null
);

insert into Branch(branch_code, branch_name) values
('TX','THANH XUAN'),
('HM','HOANG MAI');

create table Employee(
employee_code serial primary key ,
name varchar(50) not null ,
age int,
branch_code varchar(50) references Branch(branch_code) ,
status bool,
address varchar(50),
secret_key varchar(50)
);

insert into Employee(name, age, branch_code, status, address, secret_key) values
('LE VAN MINH', 26, 'TX', true, 'HaNoi', 'secret_1'),
('DO THI BINH', 25, 'TX', false, 'HCM', 'secret_2'),

('LE THI TAM', 21, 'HM', true, 'HCM', 'secret_3'),
('HOANG THI HIEN', 24, 'HM', false, 'ThaiBinh', 'secret_4'),
('NGUYEN THI LOI', 23, 'HM', true, 'NgheAn', 'secret_5'),
('TRAN THI THAO', 22, 'HM', false, 'NamDinh', 'secret_6');

create table "group"(
group_code varchar(50) primary key ,
group_name varchar(50) not null
);

insert into "group"(group_code, group_name) VALUES
('TX_LE VAN MINH','Nhom thuoc thanh xuan'),
('HM_HOANG THI HIEN','Nhom thuoc hoang mai');

create table Group_history(
id serial primary key ,
group_code varchar(50) references "group"(group_code),
employee_code int references Employee(employee_code),
start_date date,
end_date date,
is_leader bool
);

insert into Group_history(group_code, employee_code, start_date, end_date, is_leader) VALUES
('HM_HOANG THI HIEN',3, '2023-11-10', null, true),
('TX_LE VAN MINH', 1, '2023-10-10', null, true),
('TX_LE VAN MINH', 2, '2023-9-9', '2023-10-10', false),
('HM_HOANG THI HIEN', 4, '2023-8-8', null, false),
('HM_HOANG THI HIEN', 5, '2023-7-7', null, false);


-- tìm employee đang hoạt động ở chi nhánh Thanh Xuân
select * from Employee where branch_code = (SELECT Branch.branch_code from Branch where branch_name = 'THANH XUAN') and status=true;
-- đếm employee không hoạt động
select count(employee_code) from Employee where status=false;
-- tìm employee thuộc chi nhánh Thanh Xuân tham gia vào nhóm
select Employee.employee_code, name, age, branch_code, status, address from
    (Employee inner join Group_history on Employee.employee_code = Group_history.employee_code)
where branch_code='TX';
-- danh sách nhân viên đang hoạt động có vào nhóm
select * from Employee inner join Group_history Gh on Employee.employee_code = Gh.employee_code
where status = true;


select * from Employee;
select * from Branch;
