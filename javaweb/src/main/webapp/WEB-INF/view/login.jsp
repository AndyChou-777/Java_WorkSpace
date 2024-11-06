<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<title>Insert title here</title>
		
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
	    <link rel="stylesheet" href="/javaweb/css/buttons.css">
	    <style>
			html, body {
				height: 100%;
				margin: 0;
				display: flex;
				justify-content: center;
				align-items: center;
			}
			.wrapper {
				text-align: center;
			}
		</style>
	</head>
	
		<body style="padding: 15px">
	
		<form class="pure-form" method="post" action="/javaweb/login">
		
			<fieldset>
				<legend>✨Login✨</legend>
				
				👨‍🎓:<input type="text" name="username" placeholder="請輸入帳號..." required /><p />
				🚀:<input type="password" name="password" placeholder="請輸入密碼..." required /><p />
				<button type="reset" class="pure-button">重置</button>
				<button type="submit" class="pure-button pure-button-primary">登入</button>
				<button type="button" class="pure-button" onclick="window.open('http://localhost:8080/javaweb/user/update/password', '_blank')">修改</button>
			</fieldset>
	
		</form>
	
	</body>
</html>