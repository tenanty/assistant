<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">

<!-- flatui -->
<head>
<meta charset="utf-8">
<title>assistants</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- Loading Bootstrap -->
<link href="${ctx }/static/flatui/dist/css/vendor/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="${ctx }/static/jScrollbar/jScrollbar.jquery.css" media="screen" />

<!-- Loading Flat UI -->
<link href="${ctx }/static/flatui/dist/css/flat-ui-pro.css" type="text/css" rel="stylesheet" />

<link rel="shortcut icon" href="${ctx }/static/flatui/dist/img/favicon.ico">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
<!--[if lt IE 9]>
      <script src="static/flatui//dist/js/vendor/html5shiv.js"></script>
      <script src="static/flatui//dist/js/vendor/respond.min.js"></script>
    <![endif]-->
<link rel="stylesheet" href="${ctx }/static/listnav/css/listnav.css" type="text/css" media="screen" charset="utf-8" />
</head>
<style>
.login-screen {
	background-color: #1abc9c;
}
</style>
<body class="login-screen">
	<div class="container">
		<div style="margin: 100px">
			<div class="text-center">
				<H3>Sing in</H3>
			</div>
			<div class="row">
				<div class="col-lg-6 col-lg-offset-3">
					<form action="${ctx }/register" method="post">
						<div class="form-group">
							<span class="form-control-feedback fui-user"></span> <label
								class="sr-only" for="exampleInputEmail2"></label> <input name="account"
								type="text" class="form-control" id="exampleInputEmail2"
								placeholder="用户名">
						</div>
						<div class="form-group">
							<span class="form-control-feedback fui-lock"></span> <label
								class="sr-only" for="exampleInputEmail2"> address</label> <input name="plainPassword"
								type="password" class="form-control" id="exampleInputEmail2"
								placeholder="密码">
						</div>
						<div class="form-group">
							<span class="form-control-feedback fui-lock"></span> <label
								class="sr-only" for="exampleInputEmail2"> address</label> <input name="confirmPassword"
								type="password" class="form-control" id="exampleInputEmail2" 
								placeholder="确认密码">
						</div>
						<div class="form-group">
							<span class="form-control-feedback fui-mail"></span> <label
								class="sr-only" for="exampleInputEmail2"> address</label> <input name="email"
								type="text" class="form-control" id="exampleInputEmail2"
								placeholder="邮箱">
						</div>
						<div class="form-group">
							<span class="form-control-feedback fui-power"></span> <label
								class="sr-only" for="exampleInputEmail2"> address</label> <input name="phone"
								type="text" class="form-control" id="exampleInputEmail2"
								placeholder="手机">
						</div>
						<input id="myLogin" class="btn btn-primary" type="submit" value="完成注册"/>
					</form>

				</div>
			</div>
		</div>
	</div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="static/flatui/dist/js/vendor/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="static/flatui/dist/js/flat-ui-pro.min.js"></script>

	<script src="static/flatui/dist/js/application.js"></script>
	<script type="text/javascript">
	jQuery(function(){
		jQuery("#myLogin").click(function(){
			location.href = "navbar-fixed-top-home.html";
		});
	});
	</script>
</body>
</html>
