create table TierTable(
    id   int primary key,
    name varchar(128) not null,
    ownerid int,
    tiers jsonb,
    updatedAt timestamp
);
CREATE SEQUENCE tiertable_seq START 1;
