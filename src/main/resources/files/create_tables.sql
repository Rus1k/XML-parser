CREATE TABLE property
(
  property_listing_id serial NOT NULL,
  property_type character varying(25) NOT NULL,
  property_status character varying(25) NOT NULL,
  listing_type character varying(25) NOT NULL,
  listing_agent_id integer,
  location_id integer NOT NULL,
  details_id integer NOT NULL,
  property_images integer,
  property_videos integer,
  CONSTRAINT pk_property PRIMARY KEY (property_listing_id)
)

CREATE TABLE property_to_location
(
  property_listing_id integer NOT NULL,
  location_id integer NOT NULL,
  CONSTRAINT pk_property_to_location PRIMARY KEY (property_listing_id, location_id)
)

CREATE TABLE property_location
(
  location_id serial NOT NULL,
  region character varying(50) NOT NULL,
  district character varying(50) NOT NULL,
  Locality_name character varying(50) NOT NULL,
  sub_locality_name character varying(50),
  street_address character varying(50) NOT NULL,
  building_number character varying(20),
  CONSTRAINT pk_location PRIMARY KEY (location_id)
)

CREATE TABLE property_to_details
(
  property_listing_id integer NOT NULL,
  details_id integer NOT NULL,
  CONSTRAINT pk_property_to_details PRIMARY KEY (property_listing_id, details_id)
)

CREATE TABLE property_details
(
  details_id serial NOT NULL,
  price decimal NOT NULL,
  currency character varying(5) NOT NULL,
  floor_num integer,
  floor_total integer,
  general_area integer,
  living_area integer,
  kitchen_area integer,
  num_rooms  integer,
  land_square decimal, 
  house_type character varying(25),
  description character varying(200),
  CONSTRAINT pk_details PRIMARY KEY (details_id)
)

