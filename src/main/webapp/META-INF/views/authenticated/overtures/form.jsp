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

<acme:form readonly="true">
	<acme:form-textbox code="authenticated.overtures.form.label.title" path="title"/>
	<acme:form-moment code="authenticated.overtures.form.label.creation" path="creation"/>
	<acme:form-moment code="authenticated.overtures.form.label.deadline" path="deadline"/>
	<acme:form-textbox code="authenticated.overtures.form.label.paragraph" path="paragraph"/>
	<acme:form-integer code="authenticated.overtures.form.label.rangeMoney" path="rangeMoney"/>
	<acme:form-textbox code="authenticated.overtures.form.label.email" path="email"/>
	
	<acme:form-return code="authenticated.overtures.form.button.return"/>
</acme:form>