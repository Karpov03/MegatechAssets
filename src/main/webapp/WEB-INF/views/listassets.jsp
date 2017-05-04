<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Users</title>
<style>
.blue-button {
	background: #25A6E1;
	filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#25A6E1',
		endColorstr='#188BC0', GradientType=0);
	padding: 3px 5px;
	color: #fff;
	font-family: 'Helvetica Neue', sans-serif;
	font-size: 12px;
	border-radius: 2px;
	-moz-border-radius: 2px;
	-webkit-border-radius: 4px;
	border: 1px solid #1A87B9
}

table {
	font-family: "Helvetica Neue", Helvetica, sans-serif;
	width: 50%;
}

th {
	background: SteelBlue;
	color: white;
}

td, th {
	border: 1px solid gray;
	width: 25%;
	text-align: left;
	padding: 5px 10px;
}

.tr {
	background: lime;
	color: white;
	text-align: center;
}
</style>

</head>
<body>

	<c:if test="${!empty assets}">
		<table class="tg" border="1" align="center" style="width: 50%">
			<tr>
				<th colspan="4" class="tr">Asset List</th>
			</tr>
			<tr>
				<th width="80">Id</th>
				<th width="120">Asset Id</th>
				<th width="120">Tags</th>
				<th width="120">Tag Value</th>
			</tr>
			<c:forEach items="${assets}" var="asset">
				<tr>
					<td>${asset.id}</td>
					<td>${asset.assetId}</td>
					<td>${asset.tags}</td>
					<td>${asset.tagValue}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

	<c:url value="/logout" var="logoutUrl" />
	<form id="logout" action="${logoutUrl}" method="post">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
			<a	href="javascript:document.getElementById('logout').submit()">Logout</a>
	</form>

</body>
</html>