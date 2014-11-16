<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<!-- flatui -->
<head>
<meta charset="utf-8">
<title>assistant</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- Loading Bootstrap -->
<link href="${ctx }/static/flatui/dist/css/vendor/bootstrap.min.css"
	type="text/css" rel="stylesheet" />

<!-- Loading Flat UI -->
<link href="${ctx }/static/flatui/dist/css/flat-ui-pro.css"
	type="text/css" rel="stylesheet" />
<link rel="shortcut icon"
	href="${ctx }/static/flatui/dist/img/favicon.ico">
<script type="text/javascript"
	src="${ctx}/static/datatables/media/js/jquery.js"></script>
<script type="text/javascript"
	src="${ctx}/static/flatui/dist/js/flat-ui-pro.min.js"></script>
<script type="text/javascript"
	src="${ctx}/static/datatables/media/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="${ctx}/static/customer/qframe.js"></script>

<script type="text/javascript">
	var oTable;

	$(document)
			.ready(
					function() {

						//标签字段增加
						$('input.tagsinput').tagsinput();

						oTable = jQuery('#example')
								.DataTable(
										{
											sAjaxSource : "${ctx}/customer/all",
											bDeferRender : true,
											deferRender : true,//快速删除搜索条中内容
											filter : true,//控制是否对表格数据进行过滤,设置为false时将不出现查询输入框,默认为true
											aoColumns : [
													{
														"title" : "客户编号",
														"data" : "custId",
														"visible" : false
													},
													{
														"title" : "客户名",
														"data" : "custName"
													},
													{
														"title" : "公司",
														"data" : "custCompany"
													},
													{
														"title" : "职务",
														"data" : "custJob"
													},
													{
														"title" : "地址",
														"data" : "custAddress"
													},
													{
														"title" : "操作",
														"data" : null,
														"mRender" : function(
																data, type,
																full) {
															var render = "<span class='fui-new icon-update' alt='修改'></span>&nbsp";
															render += "<span class='fui-trash icon-delete' alt='删除'></span>";
															return render;
														},
														"width" : "10%",
														"sortable" : false
													} ]
										});
						//删除记录逻辑
						$('#example tbody').on(
							'click',
							'span.icon-delete',
							function() {
								var row = oTable.row($(this).parents('tr'));
								if (confirm("确认删除该记录吗?")) {
									$.ajax({
										url : "${ctx}/customer/" + row.data().custId,
										cache : false,
										type : "delete",
										dataType : "json",
										success : function(data) {
											console.log("获取数据状态:" + data.status);
											console.log("获取数据编号:" + data.id);
											console.log($(this).parents('tr'));
											row.remove().draw();
										}
									});
								}
							});
						//点击修改记录逻辑
						$('#example tbody').on(
							'click',
							'span.icon-update',
							function() {
								var row = oTable.row($(this).parents('tr'));
								$.ajax({
									url : "${ctx}/customer/" + row.data().custId,
									//data : $("#myForm").serializeObject(),
									cache : false,
									type : "get",
									dataType : "json",
									success : function(data){
										console.log(data);
										//打开编辑界面
										$("#myModal").modal('show');
									}
								});
								
							});
						
						
						
						//点击关闭按钮逻辑
						jQuery('#closeButton').click(function() {
							console.log("closeButton...");
							//form清理
							$('#myForm')[0].reset();
							//隐藏modal输入框
							$("#myModal").modal('hide');
						});
						
						//点击保存按钮
						jQuery('#saveButton').click(function() {
							console.log($("#myForm").serializeObject());
							console.log("saveButton...");
							//设置电话号码
							console.log("phone init...");
							var phone = '';
							$("input[name='phone']").each(function() {
								phone += $(this).val() + ","
								console.log("#phone:" + $(this).val());
							});
							
							//设置电子邮箱信息传输到后台
							console.log("email init...");
							var email = '';
							$("input[name='email']").each(function() {
								email += $(this).val() + ","
								console.log("#email:" + $(this).val());
							});
							$("#inputPhone").val(phone);
							$("#inputEmail").val(email);

							console.log("ajax start...");
							//ajax同步数据到服务端
							$.ajax({
								url : "${ctx}/customer",
								data : $("#myForm").serializeObject(),
								cache : false,
								type : "POST",
								dataType : "json",
								success : function(data) {
									console.log("获取数据状态:" + data.status);
									console.log("获取数据信息:" + data.data);
									console.log("获取数据编号:" + data.id);
									console.log("add row start...");
									oTable.row.add({
										custId : data.id,
										custName : $("#custName").val(),
										custCompany : $("#custCompany").val(),
										custJob : $("#custJob").val(),
										custAddress : $("#custAddress").val()
									}).draw();
									//form清理
									$('#myForm')[0].reset();
								}
							});

							$("#myModal").modal('hide');
						});
					});

	function addphone() {
		$("#phonelist")
				.append(
						'<div>移动电话1<span class="fui-cross" onclick="deletePhone(this);"></span><input type="text" class="form-control input-sm" name="phone" placeholder="移动电话" /></div>');
	}

	function addemail() {
		$("#emaillist")
				.append(
						'<div>电子邮箱1<span class="fui-cross" onclick="deleteEmail(this);"></span><input type="text" class="form-control input-sm" name="email" placeholder="电子邮箱1" /></div>');
	}
	function deleteEmail(a) {
		if (confirm("确定要删除电子邮箱？")) {
			a.parentNode.remove();
		}
	}
	function deletePhone(a) {
		if (confirm("确定要删除电话？")) {
			a.parentNode.remove();
		}
	}
</script>
<link href="${ctx}/static/datatables/media/css/jquery.dataTables.css"
	type="text/css" rel="stylesheet" />
</head>
<style>
body {
	min-height: 2000px;
	padding-top: 70px;
}

li {
	list-style-type: none;
}
</style>
<body>

	<!-- Static navbar -->
	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span>
			</button>
			<a class="navbar-brand" href="${ctx }/home">xxxxxxxxxx</a>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="${ctx }/customer">客户管理</a></li>
				<li><a href="${ctx }/schedule">日程</a></li>
				<li><a href="${ctx }/history">联络历史</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">设置 <b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="${ctx }/tag">联系人标签</a></li>
					</ul></li>
			</ul>
			<form class="navbar-form navbar-left" action="${ctx }/research"
				role="search">
				<div class="form-group">
					<div class="input-group">
						<input class="form-control" name="search" id="navbarInput-01"
							type="search" placeholder="Search" /> <span
							class="input-group-btn"> <a id="research" type="submit"
							class="btn"> <span class="fui-search"></span>
						</a>
						</span>
					</div>
				</div>
			</form>
			<button id="logout" class="btn btn-primary navbar-btn navbar-right">登出</button>
		</div>
		<!--/.nav-collapse -->
	</div>

	<table id="example" class="row-border" cellspacing="0" width="100%">
	</table>
	<!-- Button trigger modal -->
	<button class="btn btn-primary btn-lg" data-toggle="modal"
		data-target="#myModal">添加</button>

	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close fui-cross" data-dismiss="modal"
						aria-hidden="true"></button>
					<h4 class="modal-title" id="myModalLabel">添加客户资料</h4>
				</div>
				<div class="modal-body">
					<form id="myForm" action="#" method="post">
						<input type="hidden" id="inputPhone" name="inputPhone"> <input
							type="hidden" id="inputEmail" name="inputEmail">
						<div class="row">
							<div class="col-md-8">
								姓名<input type="text" id="custName" class="form-control input-sm"
									name="custName" placeholder="姓名" /> 公司<input type="text"
									id="custCompany" class="form-control input-sm"
									name="custCompany" placeholder="公司" /> 职务<input type="text"
									id="custJob" class="form-control input-sm" name="custJob"
									placeholder="职务" /> 地址<input type="text" id="custAddress"
									class="form-control input-sm" name="custAddress"
									placeholder="地址" />
							</div>
						</div>

						<div class="row">
							<div class="col-xs-6">
								<div id="phonelist">
									<div>
										移动电话<span class="fui-plus" onclick="addphone()"></span><input
											type="text" class="form-control input-sm" name="phone"
											placeholder="移动电话" />
									</div>
								</div>
							</div>
							<div class="col-xs-6">
								<div id="emaillist">
									<div>
										电子邮件<span class="fui-plus" onclick="addemail()"></span><input
											type="text" class="form-control input-sm" name="email"
											placeholder="电子邮件" />
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-12">
								客户标签
								<div class="tagsinput-primary">
									<input name="tag" class="tagsinput" value="客户" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-12">
								备注
								<div class="tagsinput-primary">
									<textarea class="form-control" name="remark" rows="3"
										placeholder="备注"></textarea>
								</div>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" id="closeButton" class="btn btn-default">关闭</button>
					<button type="button" id="saveButton" class="btn btn-primary">保存</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
