create table Hero(
    id int primary key,
    -- battlenetId int not null,
    name varchar(128) not null,
    displayName varchar(128) not null,
    imageURL varchar(128) not null,
    invalid boolean default false
);
CREATE SEQUENCE heroid_seq START 1;

alter table if exists DeckTrackerHeroNameMapping 
 add constraint DeckTrackerHeroNameMappingFK
 foreign key (heroId) 
 references Hero;
