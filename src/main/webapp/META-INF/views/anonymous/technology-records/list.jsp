<%-- elreyrata 25.10.19

		list.jsp

 --%>
 
<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="anonymous.technology-records.list.label.title" path="title" width="25%"/>
	<acme:list-column code="anonymous.technology-records.list.label.activitySector" path="activitySector" width="15%"/>
	<acme:list-column code="anonymous.technology-records.list.label.stars" path="stars" width="15%"/>	
</acme:list>