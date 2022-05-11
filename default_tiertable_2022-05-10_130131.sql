DROP TABLE IF EXISTS tiertable;
CREATE TABLE tiertable(
    id integer,
    name character varying(128),
    ownerid integer,
    tiers jsonb,
    updatedat timestamp without time zone,
    PRIMARY KEY(id)
);
INSERT INTO tiertable(id,name,ownerid,tiers,updatedat) VALUES(1,'test',1,'{\"id\": \"9fdfca66-5f61-459e-9990-c5945e12c7ea\", \"name\": \"S\", \"color\": \"#FF8A80\", \"heros\": [{\"id\": 3, \"ban\": {\"exists\": [\"2\", \"5\", \"6\", \"8\", \"7\"], \"notExists\": [\"4\", \"3\", \"1\"]}, \"memo\": \"111\"}]}, {\"id\": \"a3540270-b27b-4f81-a2bb-fd3efaa1503d\", \"name\": \"A\", \"color\": \"#FFA726\", \"heros\": [{\"id\": 9, \"ban\": {\"exists\": [\"8\", \"3\", \"2\", \"1\"], \"notExists\": [\"6\", \"7\", \"5\", \"4\"]}, \"memo\": \"bbb\"}]}, {\"id\": \"abf55e06-c7ea-4f92-b763-c5ee47cfba55\", \"name\": \"B\", \"color\": \"#FFD180\", \"heros\": [{\"id\": 35, \"ban\": {\"exists\": [\"7\", \"8\", \"4\", \"6\", \"5\", \"3\", \"2\", \"1\"], \"notExists\": []}, \"memo\": \"ccc\"}]}, {\"id\": \"4a871b5c-18dd-4f9e-bbbe-aee8e29944d2\", \"name\": \"C\", \"color\": \"#FFFF8D\", \"heros\": [{\"id\": 17, \"ban\": {\"exists\": [], \"notExists\": [\"6\", \"5\", \"8\", \"7\", \"4\", \"3\", \"2\", \"1\"]}, \"memo\": \"dddd\"}]}, {\"id\": \"0a2b5bad-f308-4beb-a342-d67829d08921\", \"name\": \"D\", \"color\": \"#CCFF90\", \"heros\": []}','2022-05-10 22:00:26.481992');