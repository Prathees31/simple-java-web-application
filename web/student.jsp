<%-- 
    Document   : student
    Created on : 28 May, 2017, 8:00:09 PM
    Author     : pratheesgs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<title>CRUD operations using jTable in J2EE</title>
<!-- Include one of jTable styles. -->
<link href="css/jquery-ui.css" rel="stylesheet" type="text/css" />
<link href="css/metro/blue/jtable.css" rel="stylesheet" type="text/css" />

<!-- Include jTable script file. -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#StudentTableContainer').jtable({
			title : 'Students List',
			actions : {
				listAction : 'student?action=list',
				createAction : 'student?action=create',
				updateAction : 'student?action=update',
				deleteAction : 'student?action=delete'
			},
			fields : {
				rollno : {
					title : 'Roll No',
					width : '30%',
					key : true,
					list : true,
					edit : false,
					create : true
				},
				name : {
					title : 'Name',
					width : '30%',
					edit : true
				},
				department : {
					title : 'Department',
					width : '30%',
					edit : true
				},
				section : {
					title : 'Section',
					width : '20%',
					edit : true
				},
				fname: {
					title : 'fname',
					width : '20%',
					edit : true
				},
				address : {
					title : 'address',
					width : '20%',
					edit : true
				},
				mobile : {
					title : 'mobile',
					width : '20%',
					edit : true
				}
			}
		});
		$('#StudentTableContainer').jtable('load');
	});
</script>

</head>
<body>

<div style="width: 80%; margin-right: 10%; margin-left: 10%; text-align: center;">
<form action="logout" method="post"> 

<input type="submit" value="Logout" style="float: right;"/>


</form>
		<h4>AJAX based CRUD operations using jTable in J2ee</h4>
		<div id="StudentTableContainer"></div>
</div>
    <div>

<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/jquery-ui.min.js" type="text/javascript"></script>
<script src="js/jquery.jtable.js" type="text/javascript"></script>
</body>
</html>
