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

	<acme:form-textbox code="entrepreneur.investmentRound.form.label.ticker" path="ticker" placeholder="XXX-12-123456"/>
	<jstl:if test="${command != 'create'}">
		<acme:form-moment code="entrepreneur.investmentRound.form.label.creation" path="creation" readonly="true"/>
	</jstl:if>
	
	<acme:form-select  code="entrepreneur.investmentRound.form.label.round" path="round">
		<acme:form-option code="entrepreneur.investmentRound.form.label.round.seed" value="SEED"/>
		<acme:form-option code="entrepreneur.investmentRound.form.label.round.angel" value="ANGEL"/>
		<acme:form-option code="entrepreneur.investmentRound.form.label.round.seriesA" value="SERIES_A"/>
		<acme:form-option code="entrepreneur.investmentRound.form.label.round.seriesB" value="SERIES_B"/>
		<acme:form-option code="entrepreneur.investmentRound.form.label.round.seriesC" value="SERIES_C"/>
		<acme:form-option code="entrepreneur.investmentRound.form.label.round.bridge" value="BRIDGE"/>
	</acme:form-select>
	
	<acme:form-textbox code="entrepreneur.investmentRound.form.label.title" path="title" />
	<acme:form-textarea code="entrepreneur.investmentRound.form.label.description" path="description" />
	<acme:form-money code="entrepreneur.investmentRound.form.label.money" path="money" />
	<acme:form-url code="entrepreneur.investmentRound.form.label.link" path="link" />
	
	<jstl:if test="${command != 'create'}">
	<acme:form-select code="entrepreneur.investmentRound.form.label.finalMode" path="finalMode">
			<acme:form-option code="entrepreneur.investmentRound.form.label.finalMode.yes" value="true"/>
			<jstl:choose>
				<jstl:when test="${!finalMode}">
					<acme:form-option code="entrepreneur.investmentRound.form.label.finalMode.no" selected = "true" value="false"/>
				</jstl:when>
				<jstl:otherwise>
					<acme:form-option code="entrepreneur.investmentRound.form.label.finalMode.no" value="false"/>
				</jstl:otherwise>
			</jstl:choose>
	</acme:form-select>
	</jstl:if>
	<acme:form-submit test="${command == 'show'}" code="entrepreneur.application.button.list" method="get" 
		action="/entrepreneur/application/list-investment-rounds-app?id=${id}"/>
	
	<jstl:if test="${!finalMode}">		
	<acme:form-submit test="${command != 'create'}"
	 	code="entrepreneur.investmentRound.form.button.createAct" method="get" action="/entrepreneur/activity/create?investmentRoundId=${id}"/>
	 </jstl:if>		
	<acme:form-submit test="${command != 'create'}"
	 	code="entrepreneur.investmentRound.form.button.listAct" method="get" action="/entrepreneur/activity/list-by-investment-rounds?id=${id}"/>
	
	
	<jstl:if test="${!finalMode}">	
	<acme:form-submit test="${command == 'show'}" 
		code="entrepreneur.investment-round.form.button.update"
		action="/entrepreneur/investment-round/update" />
	</jstl:if>		
	<acme:form-submit test="${command == 'show'}" 
		code="entrepreneur.investment-round.form.button.delete"
		action="/entrepreneur/investment-round/delete" />
	<acme:form-submit test="${command == 'create'}" 
		code="entrepreneur.investment-round.form.button.create"
		action="/entrepreneur/investment-round/create" />
	<acme:form-submit test="${command == 'update'}" 
		code="entrepreneur.investment-round.form.button.update"
		action="/entrepreneur/investment-round/update" />
	<acme:form-submit test="${command == 'delete'}" 
		code="entrepreneur.investment-round.form.button.delete"
		action="/entrepreneur/investment-round/delete" />
	<acme:form-return code="entrepreneur.application.form.button.return" />
	
</acme:form>
