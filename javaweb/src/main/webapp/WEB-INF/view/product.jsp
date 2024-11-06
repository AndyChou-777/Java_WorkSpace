<%@page import="javaweb.model.dto.ProductDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
  List<ProductDto> productDtos = (List<ProductDto>)request.getAttribute("productDtos");
%>
    
<!DOCTYPE html>
  <html>
    <head>
      <meta charset="UTF-8">
      <title>Product 新增</title>
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
      <link rel="stylesheet" href="/javaweb/css/buttons.css">
    </head>
   <body style="padding: 15px">
  	<!-- menu bar -->
		<%@include file="/WEB-INF/view/menu.jspf" %>
		
		<div style="padding: 15px">
    	<form class="pure-form" method="post" action="/javaweb/product/add">
			<fieldset>
				<legend>Product</legend>
				商品: <input type="text" name="productName" placeholder="請輸入商品..." required /><p />
				價格: <input type="text" name="price" placeholder="請輸入價格..." required /><p />
				庫存: <input type="text" name="stock" placeholder="請輸入庫存..." required /><p />
				<button type="reset" class="button-warning pure-button">Reset</button>
				<button type="Submit" class="button-success pure-button">Submit</button>
			</fieldset>
		</form>
		<div class="pure-form">
			<fieldset>
				<table border="1" class="pure-table pure-table-bordered">
				<legend>Product 列表</legend>
					<thead>
						<tr>
							<th>ID</th><th>產品</th><th>價格</th><th>庫存</th>
							<th>修改</th><th>刪除</th>
						</tr>
					</thead>
					<% for(ProductDto productDto : productDtos) { %>
						<tr>
							<td><%=productDto.getProductID() %></td>
							<td><%=productDto.getProductName() %></td>
							<td><%=productDto.getPrice() %></td>
							<td><%=productDto.getStock() %></td>
							<td><a href="/javaweb/product/get?productName=<%=productDto.getProductName() %>" class="button-secondary pure-button">修改</a></td>
							<td><a href="/javaweb/product/delete?productId=<%=productDto.getProductID() %>" class="pure-button pure-button-primary">刪除</a></td>
						</tr>
					<% } %>
				</table>
			</fieldset>
		</div>
		</div>
	</body>
</html>