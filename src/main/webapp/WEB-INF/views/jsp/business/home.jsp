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
<!-- Loading Flat UI -->
<link href="${ctx }/static/flatui/dist/css/flat-ui-pro.css" type="text/css" rel="stylesheet" />
<link rel="shortcut icon" href="${ctx }/static/flatui/dist/img/favicon.ico">

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
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span>
				</button>
				<a class="navbar-brand" href="${ctx }/home">xxxxxxxxxx</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="${ctx }/customer">客户管理</a></li>
					<li><a href="${ctx }/schedule">日程</a></li>
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
				<a href="${ctx}/logout" class="btn btn-primary navbar-btn navbar-right">登出</a>
				<!-- <button class="btn btn-primary navbar-btn navbar-right" id="logout">登出</button> -->
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>


	<div id="base" class="container">
		<div class="row">
			<div class="col-sm-3">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<span class="panel-title">客户概况</span>
					</div>
					<div class="panel-body">
						<canvas id="myChart" width="200" height="200"></canvas>
					</div>
				</div>
				<div class="panel panel-primary">
					<div class="panel-heading">
						<span class="panel-title">任务概况</span>
					</div>
					<div class="panel-body">xxxx</div>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<span class="panel-title">客户类型分析</span>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-sm-6">
								<div class="panel panel-primary">
									<div class="row">
										<div class="col-sm-4 text-center">111</div>
										<div class="col-sm-8">
											<a href="#fakelink" class="btn btn-sm btn-block btn-primary">优质型客户</a>
										</div>
									</div>

								</div>
							</div>
							<div class="col-sm-6">
								<div class="panel panel-primary">
									<div class="row">
										<div class="col-sm-4 text-center">222</div>
										<div class="col-sm-8">
											<a href="#fakelink" class="btn btn-sm btn-block btn-info">维护性客户</a>
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-sm-6">
								<div class="panel panel-primary">
									<div class="row">
										<div class="col-sm-4 text-center">333</div>
										<div class="col-sm-8">
											<a href="#fakelink" class="btn btn-sm btn-block btn-warning">发展型客户</a>
										</div>
									</div>

								</div>
							</div>
							<div class="col-sm-6">
								<div class="panel panel-primary">
									<div class="row">
										<div class="col-sm-4 text-center">444</div>
										<div class="col-sm-8">
											<a href="#fakelink" class="btn btn-sm btn-block btn-danger">放弃型客户</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="panel panel-primary">
					<div class="panel-heading">
						<span class="panel-title">任务分析</span>
					</div>
					<div class="panel-body">xxxx</div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="panel panel-primary">
					<!-- Default panel contents -->
					<div class="panel-heading">
						<span class="panel-title">联络历史</span>
					</div>
					<!-- List group -->
					<ul class="list-group">
						<li class="list-group-item">xxxx</li>
						<li class="list-group-item">xxxx</li>
						<li class="list-group-item">xxxx</li>
						<li class="list-group-item">xxxx</li>
						<li class="list-group-item">xxxx</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="static/flatui/dist/js/vendor/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="static/flatui/dist/js/flat-ui-pro.min.js"></script>

	<script src="static/flatui/dist/js/application.js"></script>

</body>
</html>
