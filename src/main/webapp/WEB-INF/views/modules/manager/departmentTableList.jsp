<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>部门管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/manager/departmentTable/">部门列表</a></li>
		<shiro:hasPermission name="manager:departmentTable:edit"><li><a href="${ctx}/manager/departmentTable/form">部门添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="departmentTable" action="${ctx}/manager/departmentTable/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>部门名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>部门名称</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="manager:departmentTable:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="departmentTable">
			<tr>
				<td><a href="${ctx}/manager/departmentTable/form?id=${departmentTable.id}">
					${departmentTable.name}
				</a></td>
				<td>
					<fmt:formatDate value="${departmentTable.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${departmentTable.remarks}
				</td>
				<shiro:hasPermission name="manager:departmentTable:edit"><td>
    				<a href="${ctx}/manager/departmentTable/form?id=${departmentTable.id}">修改</a>
					<a href="${ctx}/manager/departmentTable/delete?id=${departmentTable.id}" onclick="return confirmx('确认要删除该部门吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>