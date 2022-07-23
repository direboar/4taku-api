create table TierTable(
    id   int primary key,
    name varchar(128) not null,
    ownerid int,
    updatedAt timestamp
);
CREATE SEQUENCE tiertable_seq START 1;
