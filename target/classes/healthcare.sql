create table patient(patient_id int,Unique,first_name text,middle_name text,last_name text,dob date,mobile text)
create table doctor (doctor_id int Unique,first_name text,middle_name text,last_name text,specialization text)

create table appointment (app_id int,paitent_id int,doctor_id int,appoint_date date,time text,status text)
