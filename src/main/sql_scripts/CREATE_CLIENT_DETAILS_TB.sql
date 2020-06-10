CREATE TABLE public.oauth_client_details
(
    client_id character varying(256) COLLATE pg_catalog."default" NOT NULL,
    resource_ids character varying(256) COLLATE pg_catalog."default",
    client_secret character varying(256) COLLATE pg_catalog."default",
    scope character varying(256) COLLATE pg_catalog."default",
    authorized_grant_types character varying(256) COLLATE pg_catalog."default",
    web_server_redirect_uri character varying(256) COLLATE pg_catalog."default",
    authorities character varying(256) COLLATE pg_catalog."default",
    access_token_validity bigint,
    refresh_token_validity bigint,
    additional_information character varying(256) COLLATE pg_catalog."default",
    autoapprove character varying(256) COLLATE pg_catalog."default",
    CONSTRAINT oauth_client_details_pkey PRIMARY KEY (client_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.oauth_client_details
    OWNER to manu;
    
CREATE TABLE public.granted_authority
(
    granted_authority_id bigint NOT NULL,
    granted_authority_authority_id bigint,
    granted_authority_record_status character varying(10) COLLATE pg_catalog."default",
    CONSTRAINT granted_authority_pkey PRIMARY KEY (granted_authority_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.granted_authority
    OWNER to manu;