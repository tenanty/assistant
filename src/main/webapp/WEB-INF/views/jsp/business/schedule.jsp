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

<link href='${ctx }/static/fullcalender/fullcalendar.css' rel='stylesheet' />
<link href='${ctx }/static/fullcalender/fullcalendar.print.css' rel='stylesheet' media='print' />

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
	font-size: 14px;
}

#calendar {
	max-width: 650px;
	margin: 0 auto;
}
</style>

<!-- fullcalender -->
<script src='${ctx }/static/fullcalender/lib/moment.min.js'></script>
<script src='${ctx }/static/fullcalender/lib/jquery.min.js'></script>

<script src="${ctx }/static/flatui/dist/js/application.js"></script>

<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${ctx }/static/flatui/dist/js/flat-ui-pro.min.js"></script>

<script src='${ctx }/static/fullcalender/fullcalendar.min.js'></script>
<script type="text/javascript" src="${ctx }/static/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
    var selectStart;
    var selectEnd;
    $(document).ready(
			function() {

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
					eventData = {
							title : $("#eventTitle").val(),
							start : selectStart,
							end : selectEnd
						};
					$('#calendar').fullCalendar('renderEvent',
							eventData, true); // stick? = true
					$("#myModal").modal('hide');
				});
				$('#calendar').fullCalendar(
						{
							header : {
								left : 'prev,next today',
								center : 'title',
								right : ''
							},
							defaultDate : '2014-09-12',
							selectable : true,
							selectHelper : true,
							select : function(start, end) {
								//alert(new Date(start));
								//alert(new Date(end));
								selectStart = start;
								selectEnd = end;
								$("#myModalLabel").html("æ¥ç¨æ·»å ");
								$("#myModal").modal();
								/* 
								var title = prompt('Event Title:');
								var eventData;
								if (title) {
									eventData = {
										title : title,
										start : start,
										end : end
									};
									$('#calendar').fullCalendar('renderEvent',
											eventData, true); // stick? = true
								}
								$('#calendar').fullCalendar('unselect'); */
							},
							editable : true,
							eventLimit : false, // allow "more" link when too many events
							events : [ {
								title : 'èç³»èç',
								start : '2014-09-01'
							} ]
						});
				 $("#logout").click(function(){
						location.href = "${ctx }/login";
					});

				  $("#research").click(function(){
						location.href ="${ctx }/research";
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
			});

   
    </script>



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
					<li class="active"><a href="${ctx }/schedule">日程</a></li>
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
					<span class="panel-title">日程</span>
				</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-sm-8">
							<div id='calendar'></div>
						</div>
						<div class="col-sm-4">
							筛选条件<br> 全文：
							<div>
								<input id="txsj" type="text" class="form-control input-sm"
									placeholder="全文检索">
							</div>
							<button class="btn btn-primary" style="margin: 30px">查询</button>


						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /container -->
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
<script type="text/javascript">
   </script>
</html>
