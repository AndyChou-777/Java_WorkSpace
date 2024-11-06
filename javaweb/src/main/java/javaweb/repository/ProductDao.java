package javaweb.repository;

import java.util.List;
import java.util.Map;

import javaweb.model.entity.Product;
import javaweb.model.entity.User;

public interface ProductDao {
	
	List<Product> findAllProducts();
	
	Product getProduct(String productname);
	
	void addProduct(Product product);
	
	void deleteProduct(Integer productId);
	
	void updateProductPrice(Integer productId, Double price);
	
	void updateProductStock(Integer productId, Integer stock);
	
	// Map<商品名稱(product_name), 銷售金額 (total_sales)>
	Map<String, Double> querySalesRanking(); // 銷售排行

}
