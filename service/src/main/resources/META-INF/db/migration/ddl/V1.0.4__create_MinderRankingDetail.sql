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