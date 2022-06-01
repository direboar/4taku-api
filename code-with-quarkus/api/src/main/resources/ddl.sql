drop table if exists Hero;
drop table if exists TierTable;
drop table if exists MinionType;
drop table if exists MinderRankingDetail;
drop table if exists MinderRanking;
drop table if exists DeckTrackerHeroNameMapping;
drop table if exists account;
drop SEQUENCE if exists hero_seq ;
drop SEQUENCE if exists tiertable_seq ;
drop SEQUENCE if exists accountid_seq ;
drop SEQUENCE if exists minder_ranking_detail_sec;

create table Hero(
    id int primary key,
    battlenetId int not null,
    name varchar(128) not null,
    displayName varchar(128) not null,
    imageURL varchar(128) not null,
    invalid boolean default false
);
CREATE SEQUENCE hero_seq START 1;

create table TierTable(
    id   int primary key,
    name varchar(128) not null,
    ownerid int,
    tiers jsonb,
    updatedAt timestamp
);
CREATE SEQUENCE tiertable_seq START 1;
create table MinionType (
    id   int primary key,
    name varchar(64) not null,
    imageURL varchar(64) not null   
);
create table DeckTrackerHeroNameMapping(
 deckTrackerHeroName varchar(128) primary key,
 heroName varchar(128) not null
);

create table account(
    id int primary key,  
    oicdUserName varchar(255) unique not null,
    name varchar(128),
    tierTableId int
);
CREATE SEQUENCE accountid_seq START 1;
create table MinderRanking (
  id int4 not null,
  coinCurve1 varchar(128),
  coinCurve2 varchar(128),
  heroName varchar(128),
  ranking varchar(64),
  primary key (id)
);
CREATE SEQUENCE minder_ranking_seq START 1;

create table MinderRankingDetail (
  id int4 not null,
  minionType varchar(64),
  ranking varchar(128),
  rankingId int4,
  primary key (id)
);
CREATE SEQUENCE minder_ranking_detail_sec START 1;

alter table if exists MinderRankingDetail 
  add constraint FKnicw6um2k1yimd7msqrqs94xf 
  foreign key (rankingId) 
  references MinderRanking;