/* Create location table */
DROP TABLE IF EXISTS public.location;
CREATE TABLE IF NOT EXISTS public.location
(
    id bigint NOT NULL,
    name character varying(60) NOT NULL,
    type character varying(60) NOT NULL,
    dimension character varying(60) NOT NULL DEFAULT 'unknown'::character varying,
    CONSTRAINT id_location PRIMARY KEY (id),
    CONSTRAINT unique_location UNIQUE (name)
);

/* Create episode table */
DROP TABLE IF EXISTS public.episode;
CREATE TABLE IF NOT EXISTS public.episode
(
    id bigint NOT NULL,
    name character varying(80) NOT NULL,
    airDate character varying(50) NOT NULL,
    episode character varying(10) NOT NULL,
    CONSTRAINT id_episode PRIMARY KEY (id),
    CONSTRAINT unique_episode UNIQUE (name, episode)
);

/* Create character table */
DROP TABLE IF EXISTS public."character";
CREATE TABLE IF NOT EXISTS public."character"
(
    id bigint NOT NULL,
    name character varying(150) NOT NULL,
    status character varying(15) NOT NULL DEFAULT 'unknown'::character varying,
    species character varying(30) NOT NULL DEFAULT 'unknown'::character varying,
    origin character varying(60) NOT NULL DEFAULT 'unknown'::character varying,
    image character varying(200) NOT NULL,
    location_id bigint,
    CONSTRAINT id_character PRIMARY KEY (id),
    CONSTRAINT unique_character UNIQUE (name),
    CONSTRAINT location_id FOREIGN KEY (location_id)
        REFERENCES location (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE SET NULL
);

/* Create character to episode table (many to many) */
DROP TABLE IF EXISTS public.character_episode;
CREATE TABLE IF NOT EXISTS public.character_episode
(
    character_id bigint NOT NULL,
    episode_id bigint NOT NULL,
    CONSTRAINT id_character_episode PRIMARY KEY (character_id, episode_id),
    CONSTRAINT actual_character_id FOREIGN KEY (character_id)
        REFERENCES "character" (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT actual_episode_id FOREIGN KEY (episode_id)
        REFERENCES episode (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);