create table Tier(
    id int primary key,
    -- tierTableId int not null,
    tierTableId int ,
    name varchar(128) not null,
    color varchar(128) not null,
    tableOrder int not null
);
CREATE SEQUENCE tier_seq START 1;
