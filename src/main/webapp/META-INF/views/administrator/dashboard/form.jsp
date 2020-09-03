<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-double code="administrator.dashboard.form.investmentRoundRatio" path="investmentRoundRatio"/>
	<acme:form-double code="administrator.dashboard.form.applicationRatio" path="applicationRatio"/>
	<acme:form-double code="administrator.dashboard.form.application2Ratio" path="application2Ratio"/>
	<acme:form-return code="administrator.dashboard.form.button.return" />
</acme:form>