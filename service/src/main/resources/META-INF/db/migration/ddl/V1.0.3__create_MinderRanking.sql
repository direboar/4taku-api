create table MinderRanking (
  id int4 not null,
  coinCurve1 varchar(128),
  coinCurve2 varchar(128),
  minderRankingHeroName varchar(128),
  heroId int4,
  ranking varchar(64),
  invalid boolean default false,
  primary key (id)
);
CREATE INDEX minder_ranking_minderRankingHeroName_index ON MinderRanking (minderRankingHeroName);
CREATE SEQUENCE minder_ranking_seq START 1;

alter table if exists MinderRanking 
   add constraint MinderRankingFK 
   foreign key (heroId) 
   references Hero;
