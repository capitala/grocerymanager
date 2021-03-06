delete from `grocery_status`;
delete from `grocery_entity`;
insert into grocery_entity(date_of_purchase,name,price,probable_end_date,quantity,total_price) values(NOW(),'shampoo',5,NOW(),10,50);
insert into grocery_entity(date_of_purchase,name,price,probable_end_date,quantity,total_price) values(NOW(),'aata',10,NOW(),1,10);
insert into grocery_entity(date_of_purchase,name,price,probable_end_date,quantity,total_price) values(NOW(),'rice',10,NOW(),1,10);
insert into grocery_entity(date_of_purchase,name,price,probable_end_date,quantity,total_price) values(NOW(),'maggi',1,NOW(),10,10);
insert into grocery_status (grocery_entity_id, status) values((select id from grocery_entity where name = 'shampoo'), 'Available');
insert into grocery_status (grocery_entity_id, status) values((select id from grocery_entity where name = 'aata'), 'HaveToBuy');
insert into grocery_status (grocery_entity_id, status) values((select id from grocery_entity where name = 'rice'), 'Finished');
insert into grocery_status (grocery_entity_id, status) values((select id from grocery_entity where name = 'maggi'), 'Available');