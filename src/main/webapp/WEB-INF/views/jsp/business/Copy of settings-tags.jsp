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
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span>
				</button>
				<a class="navbar-brand" href="${ctx }/home">xxxxxxxxxx</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="${ctx }/customer">客户管理</a></li>
					<li><a href="${ctx }/schedule">日程</a></li>
					<li><a href="${ctx }/history">联络历史</a></li>
					<li class="dropdown active"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown">设置 <b
							class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="#">联系人标签</a></li>
						</ul></li>
				</ul>
				<form class="navbar-form navbar-left" action="${ctx }/research" role="search">
					<div class="form-group">
						<div class="input-group">
							<input class="form-control" id="navbarInput-01" type="search"
								placeholder="Search"> <span class="input-group-btn">
								<a id="research" type="submit" class="btn"> <span
									class="fui-search"></span>
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

	<div class="container">
		<div class="row">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<span class="panel-title">个性设置</span>
				</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-sm-12">
							<div class="tabbable">
								<ul class="nav nav-tabs nav-append-content">
									<li class="active"><a href="#tab4">联系人标签</a></li>
								</ul>
								<!-- /tabs -->
								<div class="tab-content">
									<div class="tab-pane active" id="tab4">
										<div id="tags-field">
											<span class="label label-default">关键<span data-role="remove"></span></span> 
											<span class="label label-primary">合作伙伴<span data-role="remove"></span></span> 
											<span class="label label-success">酒肉朋友<span data-role="remove"></span></span> 
											<span class="label label-info">信息<span data-role="remove"></span></span> 
											<span class="label label-warning">大客户<span data-role="remove"></span></span> 
											<span class="label label-danger">潜在客户<span data-role="remove"></span></span>
										</div>
									</div>
									<br>
									<div class="form-group">
										<div class="input-group">
											<input class="form-control" id="user-tag" type="search" placeholder="用户标签" /> 
												<span class="input-group-btn">
												<button id="submit-tag" type="submit" class="btn">
													<span class="fui-play"></span>
												</button>
											</span>
										</div>
									</div>
								</div>
								<!-- /tab-content -->
							</div>
						</div>
					</div>
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
		$(function(){
			$("#submit-tag").click(function(){
				if($("#user-tag").val()!=''){
					$("#tab4").append("<span class='label label-primary'>"+$("#user-tag").val()+"</span>").append(' ');
					}
				$("#user-tag").val('');
				});
			$("#logout").click(function(){
				location.href = "${ctx }/login";
			});
			 $("#research").click(function(){
					location.href ="${ctx }/research";
				});
			});
	</script>
</body>
</html>
