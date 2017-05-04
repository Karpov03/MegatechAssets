<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<style>
.blue-button {
	background: #333333;
	filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#25A6E1',
		endColorstr='#188BC0', GradientType=0);
	padding: 3px 5px;
	color: #eee;
	font-family: 'Helvetica Neue', sans-serif;
	font-size: 14px;
	font-weight: bolder;
	border-radius: 2px;
	-moz-border-radius: 2px;
	-webkit-border-radius: 4px;
	border: 1px solid #111;
}

table {
	font-family: "Helvetica Neue", Helvetica, sans-serif;
	width: 50%;
}

th {
	background: #222;
	color: white;
}

td, th {
	border: 1px solid #111;
	width: 25%;
	text-align: left;
	padding: 5px 10px;
}
</style>
</head>
<body>
	<form:form method="post" modelAttribute="asset"
		action="${pageContext.request.contextPath}/view/addAsset">
		<table class="tg" border="1" style="width: 50%">
			<tr>
				<th colspan="2">Add Assets</th>
			</tr>
			<tr>
				<form:hidden path="id" />
				<td><form:label path="assetId">Asset ID:</form:label></td>
				<td><form:input path="assetId" size="30" maxlength="30"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="tags">Tags:</form:label></td>
				<td><form:input path="tags" size="30" maxlength="30"></form:input></td>
			</tr>
			<tr>

				<td><form:label path="tagValue">Tag Value:</form:label></td>
				<td><form:input path="tagValue" size="30" maxlength="30"></form:input></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add"
					class="blue-button" /></td>
			</tr>
		</table>
	</form:form>
	</br>
	<h3>Asset List</h3>
	<c:if test="${!empty listOfAssets}">
		<table class="tg" border="1" style="width: 50%">
			<tr>
				<th width="80">Id</th>
				<th width="120">Asset Id</th>
				<th width="120">Tags</th>
				<th width="120">Tag Value</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${listOfAssets}" var="asset">
				<tr>
					<td>${asset.id}</td>
					<td>${asset.assetId}</td>
					<td>${asset.tags}</td>
					<td>${asset.tagValue}</td>
					<td><a href="<c:url value='delete/${asset.id}' />">Delete</a></td>
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
