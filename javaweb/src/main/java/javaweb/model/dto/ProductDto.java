package javaweb.model.dto;

import lombok.Data;

@Data
public class ProductDto {
	
	private Integer productID;
	private String productName;
	private Double price;
	private Integer stock;

}
