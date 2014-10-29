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
					<li class="active"><a href="${ctx }/history">联络历史</a></li>
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
	<div class="container">

		<div class="panel panel-primary">
			<div class="panel-heading">
				<span class="panel-title">联络历史</span>
			</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-sm-8">
						<div id='calendar'>
							<table class="table">
								<thead>
									<tr>
										<th>时间</th>
										<th>用户</th>
										<th>加入日程</th>
										<th>备注</th>
										<th>控制</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>2014-09-02 18:00:00</td>
										<td>张三</td>
										<td>否</td>
										<td>合约沟通</td>
										<td>
											<button class="btn btn-xs btn-primary create">创建日程</button>
										</td>
									</tr>
									<tr>
										<td>2014-09-02 17:20:00</td>
										<td>李四</td>
										<td>否</td>
										<td>产品介绍</td>
										<td>
											<button class="btn btn-xs btn-primary create">创建日程</button>
										</td>
									</tr>
									<tr>
										<td>2014-09-02 17:00:00</td>
										<td>王五</td>
										<td>是</td>
										<td>问候</td>
										<td>
											<button class="btn btn-xs btn-primary detail">查看日程</button>
										</td>
									</tr>
								</tbody>
							</table>
							<ul class="pagination-plain">
								<li class="previous"><a href="#3">Previous</a></li>
								<li><a href="#3">1</a></li>
								<li class="next"><a href="#3">Newer</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-4">
						筛选条件<br>
						时间：
						 <div class="row">
						 	<div class="col-lg-6">
						 		<input id="txsj" type="text" class="form-control input-sm"
								onClick="WdatePicker()" placeholder="开始时间">
						 	</div>
						 	<div class="col-lg-6">
						 		<input id="txsj" type="text" class="form-control input-sm"
								onClick="WdatePicker()" placeholder="结束时间">
						 	</div>
						 </div>
							
						全文：
						 <div>
							<input id="txsj" type="text" class="form-control input-sm" placeholder="全文检索"> 
						</div>
						<button class="btn btn-primary" style="margin: 30px">查询</button>
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
	<script type="text/javascript" src="static/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#submit-tag").click(function(){
				$("#tab4").append("<span class='label label-primary'>"+$("#user-tag").val()+"</span>").append(' ');
				});
			});
	</script>
	<script type="text/javascript">
	var pickerOption;
	$(function(){
		$("#custom-switch-01").bootstrapSwitch({
			onSwitchChange:function(){
					if($("#custom-switch-01").is(":checked")){
						$("#txsj").val('');
						$("#datetimeInput").show();
					}else{
						$("#txsj").val('');
						$("#datetimeInput").hide();
					}
				}
			});

		if($("#custom-switch-01").is(":checked")){
			$("#txsj").val('');
			$("#datetimeInput").show();
		}else{
			$("#txsj").val('');
			$("#datetimeInput").hide();
		}

		$("#saveEvent").click(function(){
			$("#myModal").modal('hide');
		});
		
		$(".create").click(function(){
			$("#saveEvent").show();
			$("#myModalLabel").html("创建日程");
			$("#txsj").val('');
			$("#myModal").modal();
		});
		$(".detail").click(function(){
			$("#myModalLabel").html("详细日程");
			$("#txsj").val('');
			$("#saveEvent").hide();
			$("#myModal").modal();
		});
		var currentDate = new Date();
		var fullyear = currentDate.getFullYear();
		var month = (currentDate.getMonth()+1)>10 ? (currentDate.getMonth()+1) :"0"+(currentDate.getMonth()+1);
		var date =  currentDate.getDate()>10?currentDate.getDate():"0"+currentDate.getDate();
		var hour = currentDate.getHours()>10?currentDate.getHours():"0"+currentDate.getHours();
		var minute = currentDate.getMinutes()>10?currentDate.getMinutes():"0"+currentDate.getMinutes();
		var second = currentDate.getSeconds()>10?currentDate.getSeconds():"0"+currentDate.getSeconds();
		var dateFmt = fullyear+"-"+month+"-"+date+" "+hour+":"+minute+":"+second;
		pickerOption = {dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:dateFmt};

		$("#logout").click(function(){
			location.href = "navbar-fixed-top-login.html";
		});
		
		$("#research").click(function(){
			location.href ="navbar-fixed-top-research.html";
		});
	});
	
	</script>

	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close fui-cross" data-dismiss="modal"
						aria-hidden="true"></button>
					<h4 class="modal-title" id="myModalLabel">Modal title</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<input id="eventTitle" class="form-control" type="text"
							name="title" placeholder="日程信息">
					</div>
					<div class="form-inline">
						<div class="form-group">
							提醒：<input type="checkbox" id="custom-switch-01"
								class="form-control" />
						</div>
						<div id="datetimeInput" class="form-group">
							<input id="txsj" type="text" class="form-control"
								onClick="WdatePicker(pickerOption)" placeholder="提醒时间">
						</div>
					</div>
					<div class="row" style="margin: 10px;">
						<div class="panel panel-primary">
							<div class="panel-body">
								历史日程
								<table class="table">
									<thead>
										<tr>
											<th>时间</th>
											<th>日程信息</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>2014-09-03 18:00:00</td>
											<td>xxxx</td>
										</tr>
										<tr>
											<td>2014-09-02 17:20:00</td>
											<td>xxxx</td>
										</tr>
										<tr>
											<td>2014-09-01 17:00:00</td>
											<td>xxxx</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button id="saveEvent" type="button" class="btn btn-primary">保存</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
