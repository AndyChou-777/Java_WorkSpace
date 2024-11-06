package javaweb.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javaweb.model.dto.ProductDto;
import javaweb.model.dto.UserDto;
import javaweb.service.ProductService;
import javaweb.service.UserService;

/**
-- 商品 product
+------------+------------------+----------+----------------+
| product_id | product_name     | price    | stock_quantity |
+------------+------------------+----------+----------------+
| 1          | PC               | 30000.00 | 50             |
| 2          | Mobile           | 15000.00 | 100            |
| 3          | MusicBox         | 3000.00  | 200            |
| 4          | Pad              | 20000.00 | 75             |
| 5          | Watch            | 8000.00  | 150            |
+------------+------------------+----------+----------------+

 -- 創建商品表
create table if not exists product (
	product_id int primary key auto_increment comment '商品Id',
	product_name varchar(50) not null unique comment '商品名稱',
	price decimal(10, 2) not null comment '商品價格',
	stock_quantity int not null default 0 comment '商品庫存'
); 


 MVC + 自訂框架
  
  request   +----------------+             +----------------+          +------------+
 ---------> | ProductServlet | ----------> | ProductService | -------> | ProductDao | ------->    MySQL
            | (Controller)   | <---------- |                | <------- |            | <------- (web.product)
  			+----------------+  ProductDto +----------------+  Product +------------+
  			       |              (Dto)                       (Entity)
  			       |
  			       v
  			+-------------+
 <--------- | product.jsp |
  response	|    (View)   |
  			+-------------+                 
 
 查詢全部: GET  /product, /products
 
*/ 

//@WebServlet(urlPatterns = {"/product/*", "/products"})
@WebServlet(value = {"/products", "/product/sales/ranking"})
public class ProductServlet extends HttpServlet{
	
	private ProductService productService = new ProductService();
	
	/*@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		
		if(pathInfo == null || pathInfo.equals("/*")) {
			
			List<ProductDto> productDtos = productService.findAll();
			
			req.setAttribute("productDtos", productDtos);
			
			req.getRequestDispatcher("/WEB-INF/view/product.jsp").forward(req, resp);
			
			return;
		} else if (pathInfo.equals("/delete")) {
			String productId = req.getParameter("productId");
			productService.deleteProduct(productId);
			
			resp.sendRedirect("/javaweb/product");
			return;
		} else if (pathInfo.equals("/get")) {
			String productName = req.getParameter("productName");
			ProductDto productDto = productService.getProduct(productName);
			
			req.setAttribute("productDto", productDto);
			req.getRequestDispatcher("/WEB-INF/view/product_update.jsp").forward(req, resp);
			return;
		}
	}*/
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String servletPath = req.getServletPath();
		switch (servletPath) {
			case "/product/sales/ranking":
				req.setAttribute("salesRankingMap", productService.querySalesRanking());
				req.getRequestDispatcher("/WEB-INF/view/sales_ranking.jsp").forward(req, resp);
				break;
			case "/products":
			default:
				req.setAttribute("productDtos", productService.findAll());
				req.getRequestDispatcher("/WEB-INF/view/product.jsp").forward(req, resp);
		}
		
	}

	/*@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		
		String productName = req.getParameter("productName");
		String price = req.getParameter("price");
		String stock = req.getParameter("stock");
		String productId = req.getParameter("productId");
		
		switch (pathInfo){
			case "/add":
				productService.appendProduct(productName, price, stock);
				break;
			case "/update":
				productService.updatePrice(productId, price, stock);
				break;
		}
		
		resp.sendRedirect("/javaweb/product");
		
	}*/
	
}