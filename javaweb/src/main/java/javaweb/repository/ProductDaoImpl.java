package javaweb.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javaweb.model.entity.Product;

public class ProductDaoImpl extends BaseDao implements ProductDao{

	@Override
	public List<Product> findAllProducts() {
		List<Product> products = new ArrayList<>();
		String sql = "select * from product";
		
		try (Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				Product product = new Product();
				
				product.setProductID(rs.getInt("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setPrice(rs.getDouble("price"));
				product.setStock(rs.getInt("stock_quantity"));
				
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public void deleteProduct(Integer productId) {
		String sql = "delete from product where product_id = ?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)){
		    
            pstmt.setInt(1, productId);
			
			int rowcount = pstmt.executeUpdate();
			if (rowcount != 1) {
				throw new RuntimeException("刪除失敗 productId" + productId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateProductPrice(Integer productId, Double price) {
		String sql = "update product set price = ? where product_id = ? ";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setDouble(1, price);
			pstmt.setInt(2, productId);
			
			int result = pstmt.executeUpdate();
			if (result != 1) {
				throw new RuntimeException("修改失敗 ProductID= " + productId + "Price= " + price);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateProductStock(Integer productId, Integer stock) {
		String sql = "update product set stock_quantity = ? where product_id = ?";
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setInt(1, stock);
			pstmt.setInt(2, productId);
			
			int result = pstmt.executeUpdate();
			if (result != 1) {
				throw new RuntimeException("修改失敗 ProductID= " + productId + "Stock= " + stock);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Product getProduct(String productname) {
		String sql = "select * from product where product_name = ?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1, productname);
			
			try (ResultSet rs = pstmt.executeQuery()){
				
				if (rs.next()) {
					
					Product product = new Product();
					
					product.setProductID(rs.getInt("product_id"));
					product.setProductName(rs.getString("product_name"));
					product.setPrice(rs.getDouble("price"));
					product.setStock(rs.getInt("stock_quantity"));
					
					return product;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addProduct(Product product) {
		String sql = "insert into product(product_name, price, stock_quantity) values(?,?,?)";
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1, product.getProductName());
			pstmt.setDouble(2, product.getPrice());
			pstmt.setInt(3, product.getStock());
			
			int result = pstmt.executeUpdate();
			if (result!=1) {
				throw new RuntimeException("新增失敗!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Map<String, Double> querySalesRanking() {
	    String sql = """
	            SELECT p.product_name, SUM(o.subtotal) AS total_sales
	            FROM orders o
	            LEFT JOIN product p ON o.product_id = p.product_id
	            GROUP BY p.product_name
	            ORDER BY total_sales DESC
	            """.trim();

	    // 存放銷售排行
	    Map<String, Double> salesRanking = new LinkedHashMap<>(); // 初始化 salesRanking

	    try (Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(sql)) {
	         
	         while (rs.next()) {
	             String key = rs.getString("product_name");
	             Double value = rs.getDouble("total_sales");
	             // 將排行放到 Map 集合中
	             salesRanking.put(key, value); // 在外部的 Map 中放置數據
	         }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return salesRanking; // 返回填充好的 salesRanking
	}
	
	

}
