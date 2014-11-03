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

<!-- datatables -->
<link href="http://cdn.datatables.net/1.10.3/css/jquery.dataTables.css" type="text/css" rel="stylesheet">
<link href="http://cdn.datatables.net/tabletools/2.2.3/css/dataTables.tableTools.css" type="text/css" rel="stylesheet">
<link href="${ctx }/static/datatables/extensions/Editor-1.3.3/css/dataTables.editor.min.css" type="text/css" rel="stylesheet">
<link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.0.3/css/font-awesome.css" type="text/css" rel="stylesheet">

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
table.dataTable tr td:first-child {
        text-align: center;
    }
table.dataTable tr td:first-child:before {
    content: "\f096"; /* fa-square-o */
    font-family: FontAwesome;
}
table.dataTable tr.selected td:first-child:before {
    content: "\f046"; /* fa-check-square-o */
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
			<div class="col-sm-3">
				<table id="example" class="display" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th>
 
                </th><th>First name</th>
            </tr>
        </thead>
    </table>
			</div>
			<div class="col-sm-9">
				<!-- <table id="example1" class="row-border" cellspacing="0" width="100%">
					<thead>
						<tr><th colspan="6">客户信息</th></tr>
						<tr>
							<th>客户姓名</th>
							<th>公司</th>
							<th>职务</th>
							<th>地址</th>
						</tr>
					</thead>

					<tfoot>
						<tr>
							<th>客户姓名</th>
							<th>公司</th>
							<th>职务</th>
							<th>地址</th>
						</tr>
					</tfoot>
				</table> -->
			</div>
		</div>
	</div>




	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="${ctx }/static/flatui/dist/js/vendor/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="${ctx }/static/flatui/dist/js/flat-ui-pro.min.js"></script>
	<script src="${ctx }/static/flatui/dist/js/application.js"></script>
	<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
	<script src="http://cdn.datatables.net/1.10.3/js/jquery.dataTables.min.js"></script>
	<script src="http://cdn.datatables.net/plug-ins/380cb78f450/api/fnReloadAjax.js"></script>
	
	<script src="http://cdn.datatables.net/tabletools/2.2.3/js/dataTables.tableTools.min.js"></script>
	<script src="${ctx }/static/datatables/extensions/Editor-1.3.3/js/dataTables.editor.min.js"></script>
	<!-- <script src="http://cdn.datatables.net/plug-ins/380cb78f450/i18n/Chinese.json"></script> -->
	
	<script type="text/javascript">
	$(document).ready(function() {
	    editor = new $.fn.dataTable.Editor( {
	    	ajax: {
	            url: "${ctx}/tag",
	            type: "POST"
	        },
	        table: "#example",
	        fields: [ {
	                label: "Tag name:",
	                name: "tagName"
	            }
	        ]
	    } );
	 
	    // Activate the bubble editor on click of a table cell
	    $('#example').on( 'click', 'tbody td:not(:first-child)', function (e) {
	        editor.bubble( this );
	    } );
	 
	    $('#example').DataTable( {
	        scrollY: 300,
	        paging: false,
	        ajax: "${ctx}/getTag",
	        columns: [
	            { data: null, defaultContent: '', orderable: false },
	            { data: "tagName" }
	        ],
	        order: [ 1, 'asc' ]
	    } );
	} );
	</script>
	
	<!-- <script type="text/javascript">
		var tagTables;
		var customerTables;
	
		$(function(){
			
			/* tagTables = $('#example').dataTable( {
	            "info":     false,
	            "scrollY":        "600px",
	            "scrollCollapse": true,
	            "paging":         false,
	            "aoColumnDefs":[
	                   		{ "bVisible": false, "aTargets": [ 0 ] }
	                   	],
	            "columns": [
	                        { "data": "tagId" },
		                    { "data": "tagName" }
		                ],
		        "ajax": '${ctx}/getTag'
		    } ); */
		        editor = new $.fn.dataTable.Editor( {
		            ajax: "${ctx}/getTag",
		            table: "#example",
		            fields: [ {
		                    label: "First name:",
		                    name: "first_name"
		                }, {
		                    label: "Last name:",
		                    name: "last_name"
		                }, {
		                    label: "Position:",
		                    name: "position"
		                }, {
		                    label: "Office:",
		                    name: "office"
		                }, {
		                    label: "Extension:",
		                    name: "extn"
		                }, {
		                    label: "Start date:",
		                    name: "start_date"
		                }, {
		                    label: "Salary:",
		                    name: "salary"
		                }
		            ]
		        } );
		     
		        // Activate the bubble editor on click of a table cell
		        $('#example').on( 'click', 'tbody td:not(:first-child)', function (e) {
		            editor.bubble( this );
		        } );
		     
		        $('#example').DataTable( {
		            dom: "Tfrtip",
		            scrollY: 300,
		            paging: false,
		            ajax: "../php/staff.php",
		            columns: [
		                { data: null, defaultContent: '', orderable: false },
		                { data: "first_name" },
		                { data: "last_name" },
		                { data: "position" },
		                { data: "office" },
		                { data: "start_date" },
		                { data: "salary", render: $.fn.dataTable.render.number( ',', '.', 0, '$' ) }
		            ],
		            order: [ 1, 'asc' ],
		            tableTools: {
		                sRowSelect: "os",
		                sRowSelector: 'td:first-child',
		                aButtons: [
		                    { sExtends: "editor_create", editor: editor },
		                    { sExtends: "editor_edit",   editor: editor },
		                    { sExtends: "editor_remove", editor: editor }
		                ]
		            }
		        } );
		    
			customerTables = $('#example1').dataTable( {
	            "paging":   false,
            	//"ordering": false,
	            "info":     false,
		        "ajax": '${ctx}/getCustomer',
		        "dom": '<"form-group"<"input-group"f>>',
		        "columns": [
		                    { "data": "custName" },
		                    { "data": "custCompany" },
		                    { "data": "custJob" },
		                    { "data": "custAddress" }
		                ]
		    } );
		    
		    $('#example tbody').on('click', 'tr', function () {
		        var name = $('td', this).eq(0).text();
		        //alert( 'You clicked on '+name+'\'s row' );
		        var index = $(this).context._DT_RowIndex;
		        alert(tagTables.aoData);
		        var nTrs = customerTables.fnGetNodes();//fnGetNodes获取表格所有行，nTrs[i]表示第i行tr对象  
		        for(var i = 0; i < nTrs.length; i++){  
		            console.log('[获取数据]' + customerTables.fnGetData(nTrs[i]).text());//fnGetData获取一行的数据  
		        } 
		       // customerTables.fnReloadAjax('${ctx}/getCustomerByTag/1');	
		    } );
		
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
	</script> -->
</body>
</html>
