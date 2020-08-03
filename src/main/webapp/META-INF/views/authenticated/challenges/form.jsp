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
	<acme:form-textbox code="authenticated.challenges.form.label.title" path="title"/>
	<acme:form-textbox code="authenticated.challenges.form.label.deadline" path="deadline"/>
	<acme:form-textarea code="authenticated.challenges.form.label.description" path="description"/>
	
	<acme:form-panel code="authenticated.challenges.form.label.expert">
		<acme:form-textarea code="authenticated.challenges.form.label.expertGoal" path="expertGoal"/>
		<acme:form-money code="authenticated.challenges.form.label.expertReward" path="expertReward"/>
	</acme:form-panel>
	
	
	<acme:form-panel code="authenticated.challenges.form.label.average">
		<acme:form-textarea code="authenticated.challenges.form.label.averageGoal" path="averageGoal"/>
		<acme:form-money code="authenticated.challenges.form.label.averageReward" path="averageReward"/>
	</acme:form-panel>
	
	
	<acme:form-panel code="authenticated.challenges.form.label.rookie">
		<acme:form-textarea code="authenticated.challenges.form.label.rookieGoal" path="rookieGoal"/>
		<acme:form-money code="authenticated.challenges.form.label.rookieReward" path="rookieReward"/>
	</acme:form-panel>
	
  	<acme:form-return code="authenticated.challenges.form.button.return"/>
</acme:form>