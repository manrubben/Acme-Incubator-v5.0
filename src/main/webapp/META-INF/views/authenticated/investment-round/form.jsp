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
	<acme:form-textbox
		code="authenticated.investment-round.form.label.ticker" path="ticker" />
	<acme:form-textbox
		code="authenticated.investment-round.form.label.creation"
		path="creation" />
	<acme:form-textbox
		code="authenticated.investment-round.form.label.round"
		path="round" />
	<acme:form-textbox
		code="authenticated.investment-round.form.label.title"
		path="title" />
	<acme:form-textarea
		code="authenticated.investment-round.form.label.description"
		path="description" />
		<acme:form-money
		code="authenticated.investment-round.form.label.money" path="money" />
	<acme:form-textbox
		code="authenticated.investment-round.form.label.link" path="link" />


	<acme:form-return
		code="authenticated.investment-round.form.button.return" />
</acme:form>