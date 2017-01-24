<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>BLOB管理</title>
<meta name="decorator" content="default" />
<script type="text/javascript">
	$(document).ready(function() {

	});
	function page(n, s) {
		$("#pageNo").val(n);
		$("#pageSize").val(s);
		$("#searchForm").submit();
		return false;
	}
</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/testblob/testBlob/">BLOB列表</a></li>
		<shiro:hasPermission name="testblob:testBlob:edit">
			<li><a href="${ctx}/testblob/testBlob/form">BLOB添加</a></li>
		</shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="testBlob"
		action="${ctx}/testblob/testBlob/" method="post"
		class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}" />
		<input id="pageSize" name="pageSize" type="hidden"
			value="${page.pageSize}" />
		<ul class="ul-form">
			<li><label>name：</label> <form:input path="name"
					htmlEscape="false" maxlength="60" class="input-medium" /></li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary"
				type="submit" value="查询" /></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}" />
	<table id="contentTable"
		class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th align="center">name</th>
				<th align="center">更新时间</th>
				<th align="center" style="width: 400px">BLOB信息</th>
				<th align="center">备注信息</th>
				<shiro:hasPermission name="testblob:testBlob:edit">
					<th align="center">操作</th>
				</shiro:hasPermission>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${page.list}" var="testBlob">
				<tr>
					<td scope="row"><a
						href="${ctx}/testblob/testBlob/form?id=${testBlob.id}">${testBlob.name}</a></td>
					<td><fmt:formatDate value="${testBlob.updateDate}"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td align="left"><textarea rows="4" style="width: 400px"
							readonly="readonly">${testBlob.blobCol}</textarea></td>
					<td>${testBlob.remarks}</td>
					<shiro:hasPermission name="testblob:testBlob:edit">
						<td><a href="${ctx}/testblob/testBlob/form?id=${testBlob.id}">修改</a>
							<a href="${ctx}/testblob/testBlob/delete?id=${testBlob.id}"
							onclick="return confirmx('确认要删除该BLOB吗？', this.href)">删除</a></td>
					</shiro:hasPermission>
				</tr>
			</c:forEach>
		</tbody>

	</table>
	<div class="pagination">${page}</div>
</body>
</html>