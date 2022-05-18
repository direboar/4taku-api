drop table if exists gift;
drop table if exists Hero;
drop table if exists TierTable;
drop table if exists MinionType;

create table gift(
    id   int primary key,
    name varchar(100)
);

create table Hero(
    id int primary key,
    battlenetId int not null,
    name varchar(128) not null,
    displayName varchar(128) not null,
    imageURL varchar(128) not null,
    invalid boolean default false
);
create table TierTable(
    id   int primary key,
    name varchar(128) not null,
    ownerid int,
    tiers jsonb,
    updatedAt timestamp
);
create table MinionType (
    id   int primary key,
    name varchar(64) not null,
    imageURL varchar(64) not null   
);
create table DeckTrackerHeroNameMapping(
 deckTrackerHeroName varchar(128) primary key,
 heroName varchar(128) not null
);

# https://qiita.com/TakahikoKawasaki/items/8f0e422c7edd2d220e06#72-sub-%E3%82%AF%E3%83%AC%E3%83%BC%E3%83%A0
create table account(
    id int primary key,  
    oicdUserName varchar(255) unique not null,
    name varchar(128) not null,
    tableTierId int
);