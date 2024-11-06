package javaweb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javaweb.model.dto.ProductDto;
import javaweb.model.dto.UserDto;
import javaweb.model.entity.Product;
import javaweb.model.entity.User;
import javaweb.repository.ProductDao;
import javaweb.repository.ProductDaoImpl;

public class ProductService {
	
	private ProductDao productDao = new ProductDaoImpl();
	
	public List<ProductDto> findAll(){
		
		List<ProductDto> productDtos = new ArrayList<>();
		
		List<Product> products = productDao.findAllProducts();
		for(Product product : products) {
			
			ProductDto productDto = new ProductDto();
			productDto.setProductID(product.getProductID());
			productDto.setProductName(product.getProductName());
			productDto.setPrice(product.getPrice());
			productDto.setStock(product.getStock());
			
			productDtos.add(productDto);
		}
		return productDtos;
	}
	
	public void deleteProduct(String productId) {
		productDao.deleteProduct(Integer.parseInt(productId));
	}
	
	public void updatePrice(String productId, String price, String stock) {
		
		if (productId == null || productId.isEmpty()) {
	        throw new IllegalArgumentException("Product ID cannot be null or empty");
	    }
		
		if (!price.isEmpty()) {
			productDao.updateProductPrice(Integer.parseInt(productId), Double.parseDouble(price));
		}
		if (!stock.isEmpty()) {
			productDao.updateProductStock(Integer.parseInt(productId), Integer.parseInt(stock));
		}
		
	}
	
	public ProductDto getProduct(String productName) {
		
		Product product = productDao.getProduct(productName);
		
		if (product == null) {
			return null;
		}
		
		ProductDto productDto = new ProductDto();
		
		productDto.setProductID(product.getProductID());
		productDto.setProductName(product.getProductName());
		productDto.setPrice(product.getPrice());
		productDto.setStock(product.getStock());
		
		return productDto;
	}
	
	public void appendProduct(String productName, String price, String stock) {
		
		Product product = new Product();
		product.setProductName(productName);
		product.setPrice(Double.parseDouble(price));
		product.setStock(Integer.parseInt(stock));
		
		productDao.addProduct(product);
	}
	
	public Map<String, Double> querySalesRanking(){
		return productDao.querySalesRanking();
	}

}
