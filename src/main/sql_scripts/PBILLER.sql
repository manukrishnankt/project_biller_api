--
-- PostgreSQL database dump
--

-- Dumped from database version 15.2
-- Dumped by pg_dump version 15.2

-- Started on 2023-03-21 20:30:11

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 214 (class 1259 OID 16523)
-- Name: address; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.address (
    address_id bigint NOT NULL,
    address_building_name character varying(255),
    address_country_id bigint,
    address_created_date timestamp without time zone,
    address_pin character varying(255),
    address_record_status character varying(255),
    address_state_id bigint
);


ALTER TABLE public.address OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 16528)
-- Name: authority; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.authority (
    authority_id bigint NOT NULL,
    authority_name character varying(255)
);


ALTER TABLE public.authority OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 16531)
-- Name: client_granted_authority; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.client_granted_authority (
    granted_authority_id bigint NOT NULL,
    granted_authority_authority_id bigint,
    granted_authority_record_status character varying(10),
    granted_authority_client_id bigint
);


ALTER TABLE public.client_granted_authority OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16534)
-- Name: company; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.company (
    company_id bigint NOT NULL,
    company_address_id bigint,
    company_created_date timestamp without time zone,
    company_currency character varying(255),
    company_name character varying(255),
    company_record_status character varying(255),
    company_login_credential_id bigint
);


ALTER TABLE public.company OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 16539)
-- Name: countries; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.countries (
    country_id bigint NOT NULL,
    country_name character varying(255),
    country_phone character varying(255),
    country_sortname character varying(255)
);


ALTER TABLE public.countries OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 16544)
-- Name: country_states; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.country_states (
    state_id bigint NOT NULL,
    state_country_id bigint,
    state_name character varying(255)
);


ALTER TABLE public.country_states OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 16547)
-- Name: customer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.customer (
    customer_id bigint NOT NULL,
    customer_address_id bigint,
    customer_email character varying(255),
    customer_gender character varying(255),
    customer_name character varying(255),
    customer_phone character varying(255),
    customer_record_status character varying(255)
);


ALTER TABLE public.customer OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 16552)
-- Name: employee; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employee (
    emp_id bigint NOT NULL,
    emp_address_id bigint,
    emp_bloodgroup character varying(255),
    emp_company_id bigint,
    emp_created timestamp without time zone,
    emp_dob date,
    emp_email character varying(255),
    emp_gender character varying(255),
    emp_identity_id bigint,
    emp_lc_id bigint,
    emp_name character varying(255),
    emp_nationality character varying(255),
    emp_parentname character varying(255),
    emp_phone character varying(255),
    emp_record_status character varying(255)
);


ALTER TABLE public.employee OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 16557)
-- Name: granted_authority; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.granted_authority (
    granted_authority_id bigint NOT NULL,
    granted_authority_authority_id bigint,
    granted_authority_record_status character varying(10)
);


ALTER TABLE public.granted_authority OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 16560)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 16561)
-- Name: identity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.identity (
    identity_id bigint NOT NULL,
    identity_created_date timestamp without time zone,
    identity_name character varying(255),
    identity_number character varying(255),
    identity_record_status character varying(255),
    identity_type character varying(255)
);


ALTER TABLE public.identity OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 16566)
-- Name: invoice; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.invoice (
    invdetails_id bigint NOT NULL,
    invdetails_invoice_id bigint,
    invdetails_product_id bigint,
    invdetails_quantity bigint,
    invdetails_record_status character varying(255),
    invdetails_unit character varying(255),
    invoice_id bigint NOT NULL,
    invoice_amount bigint,
    invoice_customer_id bigint,
    invoice_date timestamp without time zone,
    invoice_received_amount bigint,
    invoice_record_status character varying(255)
);


ALTER TABLE public.invoice OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 16571)
-- Name: invoice_details; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.invoice_details (
    invdetails_id bigint NOT NULL,
    invdetails_invoice_id bigint,
    invdetails_product_id bigint,
    invdetails_quantity bigint,
    invdetails_record_status character varying(255),
    invdetails_unit character varying(255)
);


ALTER TABLE public.invoice_details OWNER TO postgres;

--
-- TOC entry 227 (class 1259 OID 16576)
-- Name: login_credential; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.login_credential (
    lc_id bigint NOT NULL,
    lc_company_id bigint,
    lc_password character varying(255),
    lc_password_hint character varying(255),
    lc_username character varying(255),
    lc_created_date timestamp without time zone,
    lc_record_status character varying(255)
);


ALTER TABLE public.login_credential OWNER TO postgres;

--
-- TOC entry 228 (class 1259 OID 16581)
-- Name: oauth_client_details; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.oauth_client_details (
    client_id character varying(256) NOT NULL,
    resource_ids character varying(256),
    client_secret character varying(256),
    scope character varying(256),
    authorized_grant_types character varying(256),
    web_server_redirect_uri character varying(256),
    authorities character varying(256),
    access_token_validity bigint,
    refresh_token_validity bigint,
    additional_information character varying(256),
    autoapprove character varying(256),
    client_id_name character varying(255)
);


ALTER TABLE public.oauth_client_details OWNER TO postgres;

--
-- TOC entry 229 (class 1259 OID 16586)
-- Name: product; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.product (
    product_id bigint NOT NULL,
    product_catagory_id bigint,
    product_company_id bigint,
    product_created timestamp without time zone,
    product_lastupdated character varying(255),
    product_name character varying(255),
    product_price bigint,
    product_record_status character varying(255),
    product_description character varying(255),
    product_createdby bigint
);


ALTER TABLE public.product OWNER TO postgres;

--
-- TOC entry 230 (class 1259 OID 16591)
-- Name: product_catagory; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.product_catagory (
    pro_catagory_id bigint NOT NULL,
    pro_catagory_date_created timestamp without time zone,
    pro_catagory_description character varying(255),
    pro_catagory_name character varying(255),
    pro_catagory_recordstatus character varying(255),
    pro_catagory_company_id bigint,
    pro_catagory_createdby bigint,
    pro_catagory_created_by bigint
);


ALTER TABLE public.product_catagory OWNER TO postgres;

--
-- TOC entry 231 (class 1259 OID 16596)
-- Name: product_quantity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.product_quantity (
    pq_id bigint NOT NULL,
    pq_count bigint,
    pq_created timestamp without time zone,
    pq_lastupdated date,
    pq_product_id bigint,
    pq_record_status character varying(255),
    pq_unit character varying(255)
);


ALTER TABLE public.product_quantity OWNER TO postgres;

--
-- TOC entry 232 (class 1259 OID 16601)
-- Name: state_city; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.state_city (
    city_id bigint NOT NULL,
    city_name character varying(255),
    city_state_id bigint
);


ALTER TABLE public.state_city OWNER TO postgres;

--
-- TOC entry 233 (class 1259 OID 16604)
-- Name: user_granted_authority; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_granted_authority (
    user_granted_authority_id bigint NOT NULL,
    user_granted_authority_authority_id bigint,
    user_granted_authority_login_credential_id bigint,
    user_granted_authority_record_status character varying(10)
);


ALTER TABLE public.user_granted_authority OWNER TO postgres;

--
-- TOC entry 3428 (class 0 OID 16523)
-- Dependencies: 214
-- Data for Name: address; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.address (address_id, address_building_name, address_country_id, address_created_date, address_pin, address_record_status, address_state_id) FROM stdin;
\.


--
-- TOC entry 3429 (class 0 OID 16528)
-- Dependencies: 215
-- Data for Name: authority; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.authority (authority_id, authority_name) FROM stdin;
1	ROLE_ADMIN
\.


--
-- TOC entry 3430 (class 0 OID 16531)
-- Dependencies: 216
-- Data for Name: client_granted_authority; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.client_granted_authority (granted_authority_id, granted_authority_authority_id, granted_authority_record_status, granted_authority_client_id) FROM stdin;
1	1	A	1
\.


--
-- TOC entry 3431 (class 0 OID 16534)
-- Dependencies: 217
-- Data for Name: company; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.company (company_id, company_address_id, company_created_date, company_currency, company_name, company_record_status, company_login_credential_id) FROM stdin;
1	1	2023-03-21 19:48:45.679424	INR	ABC	A	2
\.


--
-- TOC entry 3432 (class 0 OID 16539)
-- Dependencies: 218
-- Data for Name: countries; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.countries (country_id, country_name, country_phone, country_sortname) FROM stdin;
\.


--
-- TOC entry 3433 (class 0 OID 16544)
-- Dependencies: 219
-- Data for Name: country_states; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.country_states (state_id, state_country_id, state_name) FROM stdin;
\.


--
-- TOC entry 3434 (class 0 OID 16547)
-- Dependencies: 220
-- Data for Name: customer; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.customer (customer_id, customer_address_id, customer_email, customer_gender, customer_name, customer_phone, customer_record_status) FROM stdin;
\.


--
-- TOC entry 3435 (class 0 OID 16552)
-- Dependencies: 221
-- Data for Name: employee; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.employee (emp_id, emp_address_id, emp_bloodgroup, emp_company_id, emp_created, emp_dob, emp_email, emp_gender, emp_identity_id, emp_lc_id, emp_name, emp_nationality, emp_parentname, emp_phone, emp_record_status) FROM stdin;
\.


--
-- TOC entry 3436 (class 0 OID 16557)
-- Dependencies: 222
-- Data for Name: granted_authority; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.granted_authority (granted_authority_id, granted_authority_authority_id, granted_authority_record_status) FROM stdin;
\.


--
-- TOC entry 3438 (class 0 OID 16561)
-- Dependencies: 224
-- Data for Name: identity; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.identity (identity_id, identity_created_date, identity_name, identity_number, identity_record_status, identity_type) FROM stdin;
\.


--
-- TOC entry 3439 (class 0 OID 16566)
-- Dependencies: 225
-- Data for Name: invoice; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.invoice (invdetails_id, invdetails_invoice_id, invdetails_product_id, invdetails_quantity, invdetails_record_status, invdetails_unit, invoice_id, invoice_amount, invoice_customer_id, invoice_date, invoice_received_amount, invoice_record_status) FROM stdin;
\.


--
-- TOC entry 3440 (class 0 OID 16571)
-- Dependencies: 226
-- Data for Name: invoice_details; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.invoice_details (invdetails_id, invdetails_invoice_id, invdetails_product_id, invdetails_quantity, invdetails_record_status, invdetails_unit) FROM stdin;
\.


--
-- TOC entry 3441 (class 0 OID 16576)
-- Dependencies: 227
-- Data for Name: login_credential; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.login_credential (lc_id, lc_company_id, lc_password, lc_password_hint, lc_username, lc_created_date, lc_record_status) FROM stdin;
1	1	$2a$10$w/EN5AECe8ZyoL0luwgOPuIHW7XHP2qIstrPeLrLTeB2LoWOtLXqq	GlobalOneTwoDollor	manu.k	2023-03-21 20:10:40.268	A
\.


--
-- TOC entry 3442 (class 0 OID 16581)
-- Dependencies: 228
-- Data for Name: oauth_client_details; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.oauth_client_details (client_id, resource_ids, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove, client_id_name) FROM stdin;
1	resource_id	$2a$10$EOGUqMqbOJEi.k4dCLAMFu037ndEdrvfQr913eT4FQ8aqNQhe/x8W	Read, Write	password,authorization_code,refresh_token,implicit	http://localhost:8080/grandauthcode	\N	3600	14400	\N	false	pbiller
\.


--
-- TOC entry 3443 (class 0 OID 16586)
-- Dependencies: 229
-- Data for Name: product; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.product (product_id, product_catagory_id, product_company_id, product_created, product_lastupdated, product_name, product_price, product_record_status, product_description, product_createdby) FROM stdin;
\.


--
-- TOC entry 3444 (class 0 OID 16591)
-- Dependencies: 230
-- Data for Name: product_catagory; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.product_catagory (pro_catagory_id, pro_catagory_date_created, pro_catagory_description, pro_catagory_name, pro_catagory_recordstatus, pro_catagory_company_id, pro_catagory_createdby, pro_catagory_created_by) FROM stdin;
\.


--
-- TOC entry 3445 (class 0 OID 16596)
-- Dependencies: 231
-- Data for Name: product_quantity; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.product_quantity (pq_id, pq_count, pq_created, pq_lastupdated, pq_product_id, pq_record_status, pq_unit) FROM stdin;
\.


--
-- TOC entry 3446 (class 0 OID 16601)
-- Dependencies: 232
-- Data for Name: state_city; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.state_city (city_id, city_name, city_state_id) FROM stdin;
\.


--
-- TOC entry 3447 (class 0 OID 16604)
-- Dependencies: 233
-- Data for Name: user_granted_authority; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_granted_authority (user_granted_authority_id, user_granted_authority_authority_id, user_granted_authority_login_credential_id, user_granted_authority_record_status) FROM stdin;
1	1	1	A
2	1	1	A
\.


--
-- TOC entry 3454 (class 0 OID 0)
-- Dependencies: 223
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 2, true);


--
-- TOC entry 3246 (class 2606 OID 16608)
-- Name: address address_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.address
    ADD CONSTRAINT address_pkey PRIMARY KEY (address_id);


--
-- TOC entry 3248 (class 2606 OID 16610)
-- Name: authority authority_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.authority
    ADD CONSTRAINT authority_pkey PRIMARY KEY (authority_id);


--
-- TOC entry 3250 (class 2606 OID 16612)
-- Name: client_granted_authority client_granted_authority_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client_granted_authority
    ADD CONSTRAINT client_granted_authority_pkey PRIMARY KEY (granted_authority_id);


--
-- TOC entry 3252 (class 2606 OID 16614)
-- Name: company company_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.company
    ADD CONSTRAINT company_pkey PRIMARY KEY (company_id);


--
-- TOC entry 3254 (class 2606 OID 16616)
-- Name: countries countries_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.countries
    ADD CONSTRAINT countries_pkey PRIMARY KEY (country_id);


--
-- TOC entry 3256 (class 2606 OID 16618)
-- Name: country_states country_states_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.country_states
    ADD CONSTRAINT country_states_pkey PRIMARY KEY (state_id);


--
-- TOC entry 3258 (class 2606 OID 16620)
-- Name: customer customer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_pkey PRIMARY KEY (customer_id);


--
-- TOC entry 3260 (class 2606 OID 16622)
-- Name: employee employee_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_pkey PRIMARY KEY (emp_id);


--
-- TOC entry 3262 (class 2606 OID 16624)
-- Name: granted_authority granted_authority_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.granted_authority
    ADD CONSTRAINT granted_authority_pkey PRIMARY KEY (granted_authority_id);


--
-- TOC entry 3264 (class 2606 OID 16626)
-- Name: identity identity_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.identity
    ADD CONSTRAINT identity_pkey PRIMARY KEY (identity_id);


--
-- TOC entry 3268 (class 2606 OID 16628)
-- Name: invoice_details invoice_details_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.invoice_details
    ADD CONSTRAINT invoice_details_pkey PRIMARY KEY (invdetails_id);


--
-- TOC entry 3266 (class 2606 OID 16630)
-- Name: invoice invoice_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.invoice
    ADD CONSTRAINT invoice_pkey PRIMARY KEY (invoice_id);


--
-- TOC entry 3270 (class 2606 OID 16632)
-- Name: login_credential login_credential_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.login_credential
    ADD CONSTRAINT login_credential_pkey PRIMARY KEY (lc_id);


--
-- TOC entry 3272 (class 2606 OID 16634)
-- Name: oauth_client_details oauth_client_details_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.oauth_client_details
    ADD CONSTRAINT oauth_client_details_pkey PRIMARY KEY (client_id);


--
-- TOC entry 3276 (class 2606 OID 16636)
-- Name: product_catagory product_catagory_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product_catagory
    ADD CONSTRAINT product_catagory_pkey PRIMARY KEY (pro_catagory_id);


--
-- TOC entry 3274 (class 2606 OID 16638)
-- Name: product product_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pkey PRIMARY KEY (product_id);


--
-- TOC entry 3278 (class 2606 OID 16640)
-- Name: product_quantity product_quantity_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product_quantity
    ADD CONSTRAINT product_quantity_pkey PRIMARY KEY (pq_id);


--
-- TOC entry 3280 (class 2606 OID 16642)
-- Name: state_city state_city_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.state_city
    ADD CONSTRAINT state_city_pkey PRIMARY KEY (city_id);


--
-- TOC entry 3282 (class 2606 OID 16644)
-- Name: user_granted_authority user_granted_authority_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_granted_authority
    ADD CONSTRAINT user_granted_authority_pkey PRIMARY KEY (user_granted_authority_id);


--
-- TOC entry 3285 (class 2606 OID 16662)
-- Name: product_catagory fk2jufj2kprqo9lkr7gmm4crhqy; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product_catagory
    ADD CONSTRAINT fk2jufj2kprqo9lkr7gmm4crhqy FOREIGN KEY (pro_catagory_created_by) REFERENCES public.login_credential(lc_id);


--
-- TOC entry 3283 (class 2606 OID 16657)
-- Name: product fk6g73mt0th8jm768jhxuxxh044; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT fk6g73mt0th8jm768jhxuxxh044 FOREIGN KEY (product_createdby) REFERENCES public.login_credential(lc_id);


--
-- TOC entry 3284 (class 2606 OID 16652)
-- Name: product fko7tdnuln2rrkf91btm3xwrmbx; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT fko7tdnuln2rrkf91btm3xwrmbx FOREIGN KEY (product_catagory_id) REFERENCES public.product_catagory(pro_catagory_id);


--
-- TOC entry 3453 (class 0 OID 0)
-- Dependencies: 5
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: pg_database_owner
--

GRANT USAGE ON SCHEMA public TO manu;


-- Completed on 2023-03-21 20:30:12

--
-- PostgreSQL database dump complete
--

