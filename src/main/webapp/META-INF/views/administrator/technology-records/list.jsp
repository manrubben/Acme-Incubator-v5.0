<%-- elreyrata 25.10.19

		list.jsp

 --%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column
		code="administrator.technology-records.list.label.title" path="title"
		width="25%" />
	<acme:list-column
		code="administrator.technology-records.list.label.activitySector"
		path="activitySector" width="25%" />
	<acme:list-column
		code="administrator.technology-records.list.label.inventorsName"
		path="inventorsName" width="25%" />
	<acme:list-column
		code="administrator.technology-records.list.label.description"
		path="description" width="25%" />

</acme:list>