package javaweb.model.entity;

import lombok.Data;

/**
-- 創建商品表
create table if not exists product (
	product_id int primary key auto_increment comment '商品Id',
	product_name varchar(50) not null unique comment '商品名稱',
	price decimal(10, 2) not null comment '商品價格',
	stock_quantity int not null default 0 comment '商品庫存'
);
*/

@Data
public class Product {
	
	private Integer productID;
	private String productName;
	private Double price;
	private Integer stock;

}
