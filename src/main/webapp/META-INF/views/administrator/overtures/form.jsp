<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="administrator.overtures.form.label.title" path="title"/>
	<jstl:if test="${command != 'create'}">
	<acme:form-moment code="administrator.overtures.form.label.creation" path="creation" readonly="true"/>
	</jstl:if>
	<acme:form-moment code="administrator.overtures.form.label.deadline" path="deadline"/>
	<acme:form-textarea code="administrator.overtures.form.label.paragraph" path="paragraph"/>
	<acme:form-money code="administrator.overtures.form.label.rangeMoney" path="rangeMoney"/>
	<acme:form-textbox code="administrator.overtures.form.label.email" path="email"/>
	
	<acme:form-submit test="${command == 'show'}" 
		code="administrator.overtures.form.button.update"
		action="/administrator/overtures/update" />
	<acme:form-submit test="${command == 'show'}" 
		code="administrator.overtures.form.button.delete"
		action="/administrator/overtures/delete" />
	<acme:form-submit test="${command == 'create'}" 
		code="administrator.overtures.form.button.create"
		action="/administrator/overtures/create" />
	<acme:form-submit test="${command == 'update'}" 
		code="administrator.overtures.form.button.update"
		action="/administrator/overtures/update" />
	<acme:form-submit test="${command == 'delete'}" 
		code="administrator.overtures.form.button.delete"
		action="/administrator/overtures/delete" />
	<acme:form-return code="administrator.overtures.form.button.return"/>
</acme:form>