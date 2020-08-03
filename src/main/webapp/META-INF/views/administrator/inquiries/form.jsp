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
	<acme:form-textbox code="administrator.inquiries.form.label.title" path="title"/>
	<jstl:if test="${command != 'create'}">
		<acme:form-moment code="administrator.inquiries.form.label.creation" path="creation" readonly="true"/>
	</jstl:if>
	<acme:form-moment code="administrator.inquiries.form.label.deadline" path="deadline"/>
	<acme:form-textarea code="administrator.inquiries.form.label.paragraph" path="paragraph"/>
	<acme:form-money code="administrator.inquiries.form.label.moneyMin" path="moneyMin"/>
	<acme:form-money code="administrator.inquiries.form.label.moneyMax" path="moneyMax"/>
	<acme:form-textbox code="administrator.inquiries.form.label.email" path="email"/>
	
	<acme:form-submit test="${command == 'show'}" 
		code="administrator.inquiries.form.button.update"
		action="/administrator/inquiries/update" />
	<acme:form-submit test="${command == 'show'}" 
		code="administrator.inquiries.form.button.delete"
		action="/administrator/inquiries/delete" />
	<acme:form-submit test="${command == 'create'}" 
		code="administrator.inquiries.form.button.create"
		action="/administrator/inquiries/create" />
	<acme:form-submit test="${command == 'update'}" 
		code="administrator.inquiries.form.button.update"
		action="/administrator/inquiries/update" />
	<acme:form-submit test="${command == 'delete'}" 
		code="administrator.inquiries.form.button.delete"
		action="/administrator/inquiries/delete" />
	<acme:form-return code="administrator.inquiries.form.button.return"/>
</acme:form>