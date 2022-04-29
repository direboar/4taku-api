drop table if exists gift;
drop table if exists Hero;
drop table if exists TierTable;

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
    tiers jsonb
);

insert into Hero values (9999,74631,'Kurtrus Ashfallen','カートラス・アッシュフォールン','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/791be7c00632456f1ff4ab7e5419418d222d2cb717f4e2cb955f3399c85a01a2.png',false);
insert into Hero values (10000,64400,'Rakanishu','ラカニシュ','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/ec519918ed7a76f2d388bf8670ecb9be5ae6c395b4caac8018f199f17285047d.png',false);
insert into Hero values (10001,999999,'xx','xx','xx',true);

insert into TierTable values (10001, 'tier表 1',1,null);
insert into TierTable values (10002, 'tier表 2',1,null);
insert into TierTable values (10003, 'tier表 3',1,null);
insert into TierTable values (10004, 'tier表 4',1,null);
insert into TierTable values (10005, 'tier表 5',1,null);
insert into TierTable values (10006, 'tier表 6',1,null);
insert into TierTable values (10007, 'tier表 7',1,null);
insert into TierTable values (10008, 'tier表 8',1,null);
insert into TierTable values (10009, 'tier表 9',1,null);
insert into TierTable values (10010, 'tier表10',1,null);
insert into TierTable values (10011, 'tier表11',1,null);
insert into TierTable values (10012, 'tier表12',1,null);
insert into TierTable values (10013, 'tier表13',1,null);
insert into TierTable values (10014, 'tier表14',1,null);
insert into TierTable values (10015, 'tier表15',1,null);
insert into TierTable values (10016, 'tier表16',1,null);
insert into TierTable values (10017, 'tier表17',1,null);
insert into TierTable values (10018, 'tier表18',1,null);
insert into TierTable values (10019, 'tier表19',1,null);
insert into TierTable values (10020, 'tier表20',1,null);
insert into TierTable values (10021, 'tier表21',1,null);
insert into TierTable values (10022, 'tier表22',1,null);
insert into TierTable values (10023, 'tier表23',1,null);
insert into TierTable values (10024, 'tier表24',1,null);
insert into TierTable values (10025, 'tier表25',1,null);
insert into TierTable values (10026, 'tier表26',1,null);
insert into TierTable values (10027, 'tier表27',1,null);
insert into TierTable values (10028, 'tier表28',1,null);
insert into TierTable values (10029, 'tier表29',1,null);
insert into TierTable values (10030, 'tier表30',1,null);
insert into TierTable values (10031, 'tier表31',1,null);
insert into TierTable values (10032, 'tier表32',1,null);
insert into TierTable values (10033, 'tier表33',1,null);
insert into TierTable values (10034, 'tier表34',1,null);
insert into TierTable values (10035, 'tier表35',1,null);
insert into TierTable values (10036, 'tier表36',1,null);
insert into TierTable values (10037, 'tier表37',1,null);
insert into TierTable values (10038, 'tier表38',1,null);
insert into TierTable values (10039, 'tier表39',1,null);
insert into TierTable values (10040, 'tier表40',1,null);
insert into TierTable values (10041, 'tier表41',1,null);
insert into TierTable values (10042, 'tier表42',1,null);
insert into TierTable values (10043, 'tier表43',1,null);
insert into TierTable values (10044, 'tier表44',1,null);
insert into TierTable values (10045, 'tier表45',1,null);
insert into TierTable values (10046, 'tier表46',1,null);
insert into TierTable values (10047, 'tier表47',1,null);
insert into TierTable values (10048, 'tier表48',1,null);
insert into TierTable values (10049, 'tier表49',1,null);
insert into TierTable values (10050, 'tier表50',1,null);
insert into TierTable values (10051, 'tier表51',1,null);
insert into TierTable values (10052, 'tier表52',1,null);
insert into TierTable values (10053, 'tier表53',1,null);
insert into TierTable values (10054, 'tier表54',1,null);
insert into TierTable values (10055, 'tier表55',1,null);
insert into TierTable values (10056, 'tier表56',1,null);
insert into TierTable values (10057, 'tier表57',1,null);
insert into TierTable values (10058, 'tier表58',1,null);
insert into TierTable values (10059, 'tier表59',1,null);
insert into TierTable values (10060, 'tier表60',1,null);


