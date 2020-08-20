
<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="administrator.notices.list.label.title" path="title" width="25%"/>
	<acme:list-column code="administrator.notices.list.label.creation" path="creation" width="15%"/>
</acme:list>