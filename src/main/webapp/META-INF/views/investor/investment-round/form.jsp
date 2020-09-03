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



<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">

	<acme:form-textbox code="investor.investmentRound.form.label.ticker" path="ticker"/>
	<acme:form-moment code="investor.investmentRound.form.label.creation" path="creation"/>
	<acme:form-textbox code="investor.investmentRound.form.label.round" path="round" />
	<acme:form-textbox code="investor.investmentRound.form.label.title" path="title" />
	<acme:form-textarea code="investor.investmentRound.form.label.description" path="description" />
	<acme:form-money code="investor.investmentRound.form.label.money" path="money" />
	<acme:form-url code="investor.investmentRound.form.label.link" path="link" />
	<acme:form-textarea code="investor.investmentRound.form.label.X1" path="X1" />	
	<jstl:if test="${isNotApped }">
	<acme:form-submit code="investor.app.investmenRound.button" method="get"  action="/investor/application/create?InvestmentRoundId=${id}"/>
	</jstl:if>
		
	
	<acme:form-return code="investor.application.form.button.return" />
	
</acme:form>

