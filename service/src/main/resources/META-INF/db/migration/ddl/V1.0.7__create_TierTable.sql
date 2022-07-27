create table TierTable(
    id   int primary key,
    name varchar(128) not null,
    ownerid int,
    updatedAt timestamp
);
CREATE SEQUENCE tiertable_seq START 1;

alter table if exists TierTable 
   add constraint TierTableFK 
   foreign key (ownerid) 
   references Account;