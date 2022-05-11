DROP TABLE IF EXISTS tiertable;
CREATE TABLE tiertable(
    id integer,
    name character varying(128),
    ownerid integer,
    tiers jsonb,
    updatedat timestamp without time zone,
    PRIMARY KEY(id)
);