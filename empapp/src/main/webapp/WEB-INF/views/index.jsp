<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page session="false" %>
<html>
<head>
	<title>Person Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Employee Details
</h1>

<c:url var="addAction" value="/emp/add" ></c:url>

<form:form action="${addAction}" commandName="employee" method="post">
<table>
	<c:if test="${!empty employee.empName}">
	<tr>
		<td>
			<form:label path="empId">
				<spring:message text="empId"/>
			</form:label>
		</td>
		<td>
			<form:input path="empId" readonly="true" size="8"  disabled="true" />
			<form:hidden path="empId" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="empName">
				<spring:message text="empName"/>
			</form:label>
		</td>
		<td>
			<form:input path="empName" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="empAddress">
				<spring:message text="empAddress"/>
			</form:label>
		</td>
		<td>
			<form:input path="empAddress" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="salary">
				<spring:message text="salary"/>
			</form:label>
		</td>
		<td>
			<form:input path="salary" />
		</td>
	</tr>
	
	<tr>
		<td colspan="2">
			<c:if test="${!empty employee.empName}">
				<input type="submit"
					value="<spring:message text="Edit Employee"/>" />
			</c:if>
			<c:if test="${empty employee.empName}">
				<input type="submit"
					value="<spring:message text="Add Employee"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Employee List</h3>
<c:if test="${!empty emplist}">
	<table class="tg">
	<tr>
		<th width="80">Emp ID</th>
		<th width="120">Full Name</th>
		<th width="120">Salary</th>
		<th width="120">City</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${emplist}" var="emp">
		<tr>
			<td>${emp.empId}</td>
			<td>${emp.empName}</td>
			<td>${emp.empAddress}</td>
			<td>${emp.salary}</td>
			<td><a href="<c:url value='/scp/edit/${emp.empId}' />" >EditEmp</a></td>
			<td><a href="<c:url value='/scp/remove/${emp.empId}' />" >DeleteEmp</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
