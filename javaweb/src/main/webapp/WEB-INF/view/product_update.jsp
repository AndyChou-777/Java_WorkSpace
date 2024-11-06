<%@page import="javaweb.model.dto.ProductDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ProductDto productDto = (ProductDto)request.getAttribute("productDto");
%>
    
<!DOCTYPE html>
  <html>
    <head>
      <meta charset="UTF-8">
      <title>Product 修改</title>
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
      <link rel="stylesheet" href="/javaweb/css/buttons.css">
    </head>
    <body style="padding: 15px">
    	<form class="pure-form" method="post" action="/javaweb/product/update">
			<fieldset>
				<legend>Product</legend>
				編號: <input type="text" name="productId" value="<%=productDto.getProductID() %>" readonly /><p />
				商品: <input type="text" name="productName" value="<%=productDto.getProductName() %>" readonly /><p />
				價格: <input type="text" name="price" value="<%=productDto.getPrice() %>" /><p />
				庫存: <input type="text" name="stock" value="<%=productDto.getStock() %>" /><p />
				<button type="submit" class="button-success pure-button">Update</button>
			</fieldset>
		</form>
	</body>
</html>