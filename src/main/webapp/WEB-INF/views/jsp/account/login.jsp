<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">

<!-- flatui -->
<head>
<meta charset="utf-8">
<title>assistant</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- Loading Bootstrap -->
<link href="${ctx}/static/flatui/dist/css/vendor/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="${ctx}/static/jScrollbar/jScrollbar.jquery.css" media="screen" />

<!-- Loading Flat UI -->
<link href="${ctx}/static/flatui/dist/css/flat-ui-pro.css" type="text/css" rel="stylesheet" />
<link rel="shortcut icon" href="${ctx}/static/flatui/dist/img/favicon.ico">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
<!--[if lt IE 9]>
      <script src="static/flatui//dist/js/vendor/html5shiv.js"></script>
      <script src="static/flatui//dist/js/vendor/respond.min.js"></script>
    <![endif]-->

<link rel="stylesheet" href="${ctx}/static/listnav/css/listnav.css" type="text/css" media="screen" charset="utf-8" />
</head>
<style>
.login-screen {
	background-color: #1abc9c;
}
</style>
<body class="login-screen">
	<div class="container">
		<div style="margin: 170px">
			<div class="text-center">
				<H3>Login</H3>
			</div>
			<div class="row">
				
				<div class="col-lg-6 col-lg-offset-3">
					<form action="${ctx}/login" method="post" id="loginForm">
						<div class="form-group">
							<span class="form-control-feedback fui-user"></span> <label
								class="sr-only" for="exampleInputEmail2"> address</label> <input
								type="text" name="username" value="${username}" class="form-control" id="exampleInputEmail2"
								placeholder="username">
						</div>
						<div class="form-group">
							<span class="form-control-feedback fui-lock"></span> <label
								class="sr-only" for="exampleInputEmail2"> address</label> <input
								type="password" class="form-control" id="exampleInputEmail2" name="password"
								placeholder="password">
						</div>
						<input id="myLogin" class="btn btn-primary" type="submit" value="登录"/>
						<a class="btn" href="${ctx}/register">注册</a>
						<!-- <input id="myRegister" class="btn btn-primary" type="submit" value="注册"/> -->
						
						<!-- <a id="myLogin" type="submit" class="btn btn-primary">登录</a> -->
						<!-- <a id="myRegister" type="submit" class="btn btn-default">注册</a> -->
					</form>

				</div>
			</div>
		</div>
	</div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="${ctx}/static/flatui/dist/js/vendor/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="${ctx}/static/flatui/dist/js/flat-ui-pro.min.js"></script>

	<script src="${ctx}/static/flatui/dist/js/application.js"></script>
<!-- 	<script type="text/javascript">
	jQuery(function(){
		jQuery("#myLogin").click(function(){
			location.href = "navbar-fixed-top-home.html";
		});
		jQuery("#myRegister").click(function(){
			location.href = "navbar-fixed-top-register.html";
		});
	});
	</script> -->
</body>
</html>
