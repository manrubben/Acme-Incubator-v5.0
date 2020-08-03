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

	<acme:form-textbox code="entrepreneur.investmentRound.form.label.ticker" path="ticker" />
	<acme:form-moment code="entrepreneur.investmentRound.form.label.creation" path="creation" />
	<acme:form-textbox code="entrepreneur.investmentRound.form.label.round" path="round" />
	<acme:form-textbox code="entrepreneur.investmentRound.form.label.title" path="title" />
	<acme:form-textarea code="entrepreneur.investmentRound.form.label.description" path="description" />
	<acme:form-money code="entrepreneur.investmentRound.form.label.money" path="money" />
	<acme:form-url code="entrepreneur.investmentRound.form.label.link" path="link" />

	<acme:form-submit test="${command == 'show'}" code="entrepreneur.application.button.list" method="get" 
		action="/entrepreneur/application/list-investment-rounds-app?id=${id}"/>
	
	<acme:form-return code="entrepreneur.application.form.button.return" />
	
</acme:form>
