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
	<jstl:if test="${status == 'PENDING'}">
	<acme:form-select code="entrepreneur.application.form.label.status" path="status">
	<acme:form-option code="entrepreneur.application.form.label.status.pending" selected="${pend}" value="PENDING"/>
	<acme:form-option code="entrepreneur.application.form.label.status.accept" selected="${accept}" value="ACCEPTED"/>
	<acme:form-option code="entrepreneur.application.form.label.status.reject" selected="${reject}" value="REJECTED"/>
	</acme:form-select>
	</jstl:if>
	<acme:form-textarea readonly="true" code="entrepreneur.application.form.label.statement" path="statement" />
	<acme:form-money readonly="true" code="entrepreneur.application.form.label.money" path="money" />
	<jstl:if test="${status == 'PENDING'}">
	<acme:form-textarea code="entrepreneur.application.form.label.justification"  path="justification"/>
	</jstl:if>
	<jstl:if test="${status == 'PENDING'}">
	<acme:form-submit code="entrepreneur.application.form.button.update"  action="/entrepreneur/application/update?id=${id}"/>
	</jstl:if>
	
	<acme:form-return code="entrepreneur.application.form.button.return" />
</acme:form>
