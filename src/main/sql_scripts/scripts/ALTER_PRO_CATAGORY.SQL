ALTER TABLE product_catagory ALTER COLUMN pro_catagory_company_id TYPE bigint USING pro_catagory_company_id::bigint;
ALTER TABLE login_credential DROP COLUMN ic_record_status CASCADE;
ALTER TABLE login_credential DROP COLUMN ic_created_date CASCADE;