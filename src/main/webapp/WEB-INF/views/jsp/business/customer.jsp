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
	src="${ctx}/static/datatables/media/js/jquery.dataTables.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		
		$("#example tbody tr").click( function( e ) {
	        if ( $(this).hasClass('row_selected') ) {
	            $(this).removeClass('row_selected');
	        }
	        else {
	            oTable.$('tr.row_selected').removeClass('row_selected');
	            $(this).addClass('row_selected');
	        }
	    });
		
		var giCount = 2;
		var oTable = jQuery('#example').DataTable({
			sAjaxSource : "${ctx}/data/1.json",
			bDeferRender:true,
			deferRender : true,//快速删除搜索条中内容
			bFilter: false,//控制是否对表格数据进行过滤,设置为false时将不出现查询输入框,默认为true
			aoColumns : [ {
				"sTitle" : "客户名",
				"mData" : "name",
				"bVisible": false
			}, {
				"sTitle" : "公司",
				"mData" : "position"
			}, {
				"sTitle" : "职务",
				"mData" : "start_date"
			}, {
				"sTitle" : "地址",
				"mData" : "salary"
			} ]
		});
		
		jQuery('#myButton').click(function(){
			console.log(oTable.$('tr.row_selected'));
			jQuery('#example').DataTable().row.add(
				{"name": giCount +'.1',
				 "position": giCount +'.2',
				 "salary": giCount +'.3',
				 "start_date": giCount +'.4',
				 "office": giCount +'.5',
				 "extn": "5421"
				}).draw();
			giCount ++;
		});
	});
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
							<input class="form-control" id="navbarInput-01" type="search"
								placeholder="Search" /> <span class="input-group-btn"> <a
								id="research" type="submit" class="btn"> <span
									class="fui-search"></span>
							</a>
							</span>
						</div>
					</div>
				</form>
				<button id="logout" class="btn btn-primary navbar-btn navbar-right">登出</button>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>


	<div class="container">
		<table id="example" class="row-border" cellspacing="0" width="100%">
			<thead>
				<tr>
					<th>name</th>
					<th>position</th>
					<th>start_date</th>
					<th>salary</th>
				</tr>
			</thead>
		</table>
	</div>
	<button id="myButton" type="button" value="xxxx">xxxx</button>
</body>
</html>

	<%--
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
					<li class="active"><a href="${ctx }/customer">客户管理</a></li>
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
								placeholder="Search" /> <span class="input-group-btn">
								<a id="research" type="submit" class="btn">
									<span class="fui-search"></span>
								</a>
							</span>
						</div>
					</div>
				</form>
				<button id="logout" class="btn btn-primary navbar-btn navbar-right">登出</button>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>


	<div class="container">

		<div class="row">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<span class="panel-title">联系人</span>
					<div id="myList-nav"></div>
				</div>
				<div class="panel-body">
					<div class="listWrapper">
						<div class="row">
							<div class="col-md-2">
								<div class="panel panel-primary">
									<div class="panel-body">
										<div
											style="width: auto; height: 450px; overflow-y: auto; overflow-x: auto;">
											<ul id="myList" class="jScrollbar">
												<li><a href="#1">张三</a></li>
												<li><a href="#1">李四</a></li>
												<li><a href="#1">王二</a></li>
											</ul>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-10">
								<div class="panel panel-primary">
									<div class="panel-body">
										<div class="row">
											<div class="col-md-8">客户信息编辑</div>
											<div class="col-md-4 text-right"><button id="customsub" type="submit" class="btn btn-primary pinned">提交</button></div>
										</div>
										<div class="row">
											<div class="col-md-4 text-center">
												添加头像:
												<div class="form-group">
													<div class="fileinput fileinput-new"
														data-provides="fileinput">
														<div class="fileinput-preview thumbnail"
															data-trigger="fileinput"
															style="width: 200px; height: 150px;"></div>
														<div>
															<span class="btn btn-primary btn-embossed btn-file">
																<span class="fileinput-new"><span
																	class="fui-image"></span>&nbsp;&nbsp;选择照片</span> <span
																class="fileinput-exists"><span class="fui-gear"></span>&nbsp;&nbsp;Change</span>
																<input id="custPortrait" type="file" name="custPortrait">
															</span> <a href="#"
																class="btn btn-primary btn-embossed fileinput-exists"
																data-dismiss="fileinput"><span class="fui-trash"></span>&nbsp;&nbsp;Remove</a>
														</div>
													</div>
												</div>
											</div>
											<div class="col-md-8">
													姓名<input type="text" id="custName" class="form-control input-sm" name="custName" placeholder="姓名" />
													公司<input type="text" id="custCompany" class="form-control input-sm" name="custCompany" placeholder="公司" />
													职务<input type="text" id="custJob" class="form-control input-sm" name="custJob" placeholder="职务" />
													地址<input type="text" id="custAddress" class="form-control input-sm" name="custAddress" placeholder="地址" />
											</div>
										</div>
										<div class="row">
											<div class="col-xs-6">
												<div id="phonelist">
													<div>
														移动电话<span class="fui-plus" onclick="addphone()"></span><input
															type="text" class="form-control input-sm"
															placeholder="移动电话" />
													</div>
												</div>
											</div>
											<div class="col-xs-6">
												<div id="emaillist">
													<div>
														电子邮件<span class="fui-plus" onclick="addemail()"></span><input
															type="text" class="form-control input-sm"
															placeholder="电子邮件" />
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-xs-12">
												客户标签
												<div class="tagsinput-primary">
													<input name="tags" class="tagsinput"  value="客户" />
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-xs-12">
												备注
												<div class="tagsinput-primary">
													<textarea class="form-control" name="remark" rows="3"></textarea>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /container -->

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="static/flatui/dist/js/vendor/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="static/flatui/dist/js/flat-ui-pro.min.js"></script>

	<script src="static/flatui/dist/js/application.js"></script>
	<script src="static/listnav/jquery.charfirst.pinyin.js"
		type="text/javascript"></script>
	<!--ListNav是一个用于创建按字母顺序分类导航的jQuery插件。-->
	<script src="static/listnav/jquery.listnav.min-2.1.js"
		type="text/javascript"></script>

	<script type="text/javascript" src="static/jScrollbar/jquery-ui.js"></script>
	<script type="text/javascript"
		src="static/jScrollbar/jquery-mousewheel.js"></script>
	<script type="text/javascript"
		src="static/jScrollbar/jScrollbar.jquery.js"></script>
		
	<!-- pin标签 -->	
    <script src="static/pin/jquery.pin.js"></script>

	<script type="text/javascript">
	jQuery(function() {
		//初始化listnav对象	
		jQuery('#myList').listnav({
			includeOther : true,
			noMatchText : '没有内容',
			prefixes : [ 'the', 'a' ]
		});
		 $('input.tagsinput').tagsinput();
	});
	function deleteEmail(a){
		if(confirm("确定要删除电子邮箱？")){
			a.parentNode.remove();	
		}
	}
	function deletePhone(a){
		if(confirm("确定要删除电话？")){
			a.parentNode.remove();	
		}
	}
	function addphone(){
		$("#phonelist").append('<div>移动电话1<span class="fui-cross" onclick="deletePhone(this);"></span><input type="text" class="form-control input-sm" placeholder="移动电话" /></div>');
		}
	
	function addemail(){
		$("#emaillist").append('<div>电子邮箱1<span class="fui-cross" onclick="deleteEmail(this);"></span><input type="text" class="form-control input-sm" placeholder="电子邮箱1" /></div>');
	}
	</script>
	<script type="text/javascript">
	    $(document).ready(function(){
	    	// simple jScrollbar plugin call
		    $('.jScrollbar').jScrollbar();
		    // more complex jScrollbar plugin call
		    $('.jScrollbar').jScrollbar({
		        scrollStep : 25,
		        position : 'left',
		        showOnHover : true
		    });
		    $(".pinned").pin();
		    $("#customsub").click(function(){
				alert("信息更新成功.");
			});
		    $("#logout").click(function(){
				location.href = "navbar-fixed-top-login.html";
			});

		    $("#research").click(function(){
				location.href ="navbar-fixed-top-research.html";
			});
		});
	</script> --%>
