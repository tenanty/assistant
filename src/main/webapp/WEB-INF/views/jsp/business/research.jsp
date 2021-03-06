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
<link href="static/flatui/dist/css/vendor/bootstrap.min.css"
	type="text/css" rel="stylesheet" />

<!-- Loading Flat UI -->
<link href="static/flatui/dist/css/flat-ui-pro.css" type="text/css"
	rel="stylesheet" />

<link rel="shortcut icon" href="static/flatui/dist/img/favicon.ico">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
<!--[if lt IE 9]>
      <script src="static/flatui//dist/js/vendor/html5shiv.js"></script>
      <script src="static/flatui//dist/js/vendor/respond.min.js"></script>
    <![endif]-->
</head>
<style>
body {
	min-height: 2000px;
	padding-top: 70px;
}
</style>
<body>


	<!-- Static navbar -->
	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header active">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span>
				</button>
				<a class="navbar-brand" href="${ctx }/home">xxxxxxxxxx</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="${ctx }/customer/list">客户管理</a></li>
					<li><a href="${ctx }/schedule/list">日程</a></li>
					<li><a href="${ctx }/history">联络历史</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">设置 <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="${ctx }/tag">联系人标签</a></li>
						</ul></li>
				</ul>
				<form class="navbar-form navbar-left" action="${ctx }/research" role="search">
					<div class="form-group">
						<div class="input-group">
							<input class="form-control" id="navbarInput-01" type="search"
								placeholder="Search"> <span class="input-group-btn">
								<a id="research" type="submit" class="btn">
									<span class="fui-search"></span>
								</a>
							</span>
						</div>
					</div>
				</form>
				<button class="btn btn-primary navbar-btn navbar-right" id="logout">登出</button>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="static/flatui/dist/js/vendor/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="static/flatui/dist/js/flat-ui-pro.min.js"></script>

	<script src="static/flatui/dist/js/application.js"></script>
	<script type="text/javascript">
	$(function(){
		$("#logout").click(function(){
			location.href = "navbar-fixed-top-login.html";
		});
		  $("#research").click(function(){
				location.href ="navbar-fixed-top-research.html";
			});
	});
	</script>

	<div class="container">
		全局搜索
		<div class="panel panel-primary">
			<div class="panel-heading">
				<span class="panel-title">客户资料</span>
			</div>
			<div class="panel-body">
				<table class="table">
					<thead>
						<tr>
							<th>用户</th>
							<th>加入日程</th>
							<th>备注</th>
							<th>控制</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>张X</td>
							<td>否</td>
							<td>合约沟通</td>
							<td>
								<button class="btn btn-xs btn-primary create">查看</button>
							</td>
						</tr>
						<tr>
							<td>张Y</td>
							<td>否</td>
							<td>产品介绍</td>
							<td>
								<button class="btn btn-xs btn-primary create">查看</button>
							</td>
						</tr>
						<tr>
							<td>张Z</td>
							<td>是</td>
							<td>问候</td>
							<td>
								<button class="btn btn-xs btn-primary detail">查看</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="panel panel-primary">
			<div class="panel-heading">
				<span class="panel-title">联络历史</span>
			</div>
			<div class="panel-body">
				<table class="table">
					<thead>
						<tr>
							<th>用户</th>
							<th>备注</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>张X</td>
							<td>张先生需要下午联系</td>
							<td>
								<button class="btn btn-xs btn-primary create">查看</button>
							</td>
						</tr>
						<tr>
							<td>张Y</td>
							<td>张Y先生目前不考虑投资</td>
							<td>
								<button class="btn btn-xs btn-primary create">查看</button>
							</td>
						</tr>
						<tr>
							<td>张Z</td>
							<td>张Z先生两个月后才有闲钱</td>
							<td>
								<button class="btn btn-xs btn-primary detail">查看</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="panel panel-primary">
			<div class="panel-heading">
				<span class="panel-title">日程</span>
			</div>
			<div class="panel-body"><table class="table">
					<thead>
						<tr>
							<th>用户</th>
							<th>备注</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>张X</td>
							<td>张先生需要下午联系</td>
							<td>
								<button class="btn btn-xs btn-primary create">查看</button>
							</td>
						</tr>
						<tr>
							<td>张Y</td>
							<td>张Y先生目前不考虑投资</td>
							<td>
								<button class="btn btn-xs btn-primary create">查看</button>
							</td>
						</tr>
						<tr>
							<td>张Z</td>
							<td>张Z先生两个月后才有闲钱</td>
							<td>
								<button class="btn btn-xs btn-primary detail">查看</button>
							</td>
						</tr>
					</tbody>
				</table></div>
		</div>
		<div class="panel panel-primary">
			<div class="panel-heading">
				<span class="panel-title">标签</span>
			</div>
			<div class="panel-body"><table class="table">
					<thead>
						<tr>
							<th>标签名</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>X</td>
							<td>
								<button class="btn btn-xs btn-primary create">查看</button>
							</td>
						</tr>
						<tr>
							<td>XX</td>
							<td>
								<button class="btn btn-xs btn-primary create">查看</button>
							</td>
						</tr>
						<tr>
							<td>XXX</td>
							<td>
								<button class="btn btn-xs btn-primary detail">查看</button>
							</td>
						</tr>
					</tbody>
				</table></div>
		</div>
	</div>


</body>
</html>
