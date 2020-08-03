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
	<acme:form-textbox readonly="true" code="entrepreneur.application.form.label.ticker" path="ticker" />
	<acme:form-moment readonly="true" code="entrepreneur.application.form.label.creation" path="creation" />
	<acme:form-textarea readonly="true" code="entrepreneur.application.form.label.statement" path="statement" />
	<acme:form-money readonly="true" code="entrepreneur.application.form.label.money" path="money" />
	
	<acme:form-return code="entrepreneur.application.form.button.return" />
</acme:form>
