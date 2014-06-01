CREATE TABLE Achievements (
    id integer NOT NULL PRIMARY KEY,
    status boolean NOT NULL,
    message text NOT NULL,
    points integer NOT NULL
);

CREATE TABLE Adventurers (
    id integer NOT NULL,
    email varchar(100) NOT NULL,
    name varchar(100) NOT NULL,
    id_team integer NOT NULL,
    CONSTRAINT Adventurers_pk PRIMARY KEY (id,email,name),
    FOREIGN KEY (id_team) REFERENCES Teams (id)
);

CREATE TABLE BattleEvents (
    id_event integer NOT NULL,
    id_adventurer integer NOT NULL,
    result boolean NOT NULL,
    Adventurers_email varchar(100) NOT NULL,
    Adventurers_name varchar(100) NOT NULL,
    CONSTRAINT BattleEvents_pk PRIMARY KEY (id_event,id_adventurer),
    FOREIGN KEY (id_event) REFERENCES Events (id),
    FOREIGN KEY (id_adventurer,Adventurers_email,Adventurers_name) REFERENCES Adventurers (id,email,name)
);

CREATE TABLE Character (
    id integer NOT NULL PRIMARY KEY,
    id_entity integer NOT NULL,
    id_team integer NOT NULL,
    money integer NOT NULL,
    FOREIGN KEY (id_entity) REFERENCES Entity (id),
    FOREIGN KEY (id_team) REFERENCES Teams (id)
);

CREATE TABLE Entity (
    id integer NOT NULL PRIMARY KEY,
    name varchar(100) NOT NULL,
    id_stats integer NOT NULL,
    id_geolocation integer NOT NULL,
    avatar varchar(100) NOT NULL,
    FOREIGN KEY (id_geolocation) REFERENCES Geolocations (id),
    FOREIGN KEY (id_stats) REFERENCES Stats (id)
);

CREATE TABLE Equipment (
    id integer NOT NULL PRIMARY KEY,
    id_entity integer NOT NULL,
    own boolean NOT NULL,
    equipped boolean NOT NULL,
    FOREIGN KEY (id_entity) REFERENCES Entity (id)
);

CREATE TABLE EquipmentTreasures (
    id_treasure integer NOT NULL,
    id_equipment integer NOT NULL,
    quantity integer NOT NULL,
    CONSTRAINT EquipmentTreasures_pk PRIMARY KEY (id_treasure,id_equipment),
    FOREIGN KEY (id_treasure) REFERENCES Treasures (id),
    FOREIGN KEY (id_equipment) REFERENCES Equipment (id)
);

CREATE TABLE Events (
    id integer NOT NULL PRIMARY KEY,
    timestamp datetime NOT NULL,
    id_zone integer NOT NULL,
    type varchar(100) NOT NULL,
    FOREIGN KEY (id_zone) REFERENCES Zones (id)
);

CREATE TABLE Geolocations (
    id integer NOT NULL PRIMARY KEY,
    latitude double NOT NULL,
    longitude double NOT NULL,
    Geolocations_id integer NOT NULL
);

CREATE TABLE MonsterEvents (
    id integer NOT NULL PRIMARY KEY,
    id_event integer NOT NULL,
    id_monster integer NOT NULL,
    result varchar(100) NOT NULL,
    FOREIGN KEY (id_event) REFERENCES Events (id),
    FOREIGN KEY (id_monster) REFERENCES Monsters (id)
);

CREATE TABLE MonsterStatus (
    id integer NOT NULL PRIMARY KEY,
    status integer NOT NULL
);

CREATE TABLE Monsters (
    id integer NOT NULL PRIMARY KEY,
    id_status integer NOT NULL,
    id_entity integer NOT NULL,
    Monsters_id integer NOT NULL,
    FOREIGN KEY (id_status) REFERENCES MonsterStatus (id),
    FOREIGN KEY (id_entity) REFERENCES Entity (id)
);

CREATE TABLE MonstersAchievements (
    id_achievements integer NOT NULL PRIMARY KEY,
    id_monster_status integer NOT NULL,
    number integer NOT NULL,
    FOREIGN KEY (id_achievements) REFERENCES Achievements (id),
    FOREIGN KEY (id_monster_status) REFERENCES MonsterStatus (id)
);

CREATE TABLE Stats (
    id integer NOT NULL PRIMARY KEY,
    hp integer NOT NULL,
    mp integer NOT NULL,
    strength integer NOT NULL,
    defense integer NOT NULL,
    magic_defense integer NOT NULL,
    speed integer NOT NULL,
    level integer NOT NULL
);

CREATE TABLE Teams (
    id integer NOT NULL PRIMARY KEY,
    name varchar(100) NOT NULL,
    is_ally boolean NOT NULL
);

CREATE TABLE TreasureAchievements (
    id_achievements integer NOT NULL PRIMARY KEY,
    number integer NOT NULL,
    FOREIGN KEY (id_achievements) REFERENCES Achievements (id)
);

CREATE TABLE TreasureEvents (
    id_event integer NOT NULL,
    id_treasure integer NOT NULL,
    CONSTRAINT TreasureEvents_pk PRIMARY KEY (id_event,id_treasure),
    FOREIGN KEY (id_event) REFERENCES Treasures (id),
    FOREIGN KEY (id_treasure) REFERENCES Events (id)
);

CREATE TABLE Treasures (
    id integer NOT NULL PRIMARY KEY,
    id_geolocation integer NOT NULL,
    status boolean NOT NULL,
    money integer NOT NULL
);

CREATE TABLE User (
    id int NOT NULL PRIMARY KEY,
    email varchar(100) NOT NULL,
    name varchar(100) NOT NULL
);

CREATE TABLE Zones (
    id integer NOT NULL PRIMARY KEY,
    id_start_geolocations integer NOT NULL,
    id_end_geolocations integer NOT NULL,
    interest_coefficient double NOT NULL,
    type integer NOT NULL,
    FOREIGN KEY (id_start_geolocations) REFERENCES Geolocations (id),
    FOREIGN KEY (id_end_geolocations) REFERENCES Geolocations (id)
);
