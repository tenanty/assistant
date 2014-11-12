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
	$(document).ready(function() {
		$.ajax({
			url : "${ctx}/customer/add",
			data : $("#myForm").serializeObject(),
			cache : false,
			type : "POST",
			dataType : "json",
			success : function(data) {
				console.log("获取数据信息:" + data);
			}
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
	<div id="myForm" action="#" method="post">
		<input type="hidden" id="phone" name="phone" value="1"> <input
			type="hidden" id="email" name="email" value="2">
	</div>
</body>

</html>
