create table account(
    id int primary key,  
    oicdUserName varchar(255) unique not null,
    name varchar(64),
    tierTableId int,
    evaluateByMinderRanking boolean,
    updatedAt timestamp
);
CREATE SEQUENCE accountid_seq START 1;
