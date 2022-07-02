create table MinderRanking (
  id int4 not null,
  coinCurve1 varchar(128),
  coinCurve2 varchar(128),
  heroName varchar(128),
  ranking varchar(64),
  primary key (id)
);
CREATE SEQUENCE minder_ranking_seq START 1;
