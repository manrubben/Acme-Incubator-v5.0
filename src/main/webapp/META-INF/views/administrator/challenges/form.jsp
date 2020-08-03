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
	<acme:form-textbox code="administrator.challenges.form.label.title" path="title"/>
	<acme:form-moment code="administrator.challenges.form.label.deadline" path="deadline"/>
	<acme:form-textarea code="administrator.challenges.form.label.description" path="description"/>
	
	<acme:form-panel code="administrator.challenges.form.label.expert">
		<acme:form-textarea code="administrator.challenges.form.label.expertGoal" path="expertGoal"/>
		<acme:form-money code="administrator.challenges.form.label.expertReward" path="expertReward"/>
	</acme:form-panel>
	
	
	<acme:form-panel code="administrator.challenges.form.label.average">
		<acme:form-textarea code="administrator.challenges.form.label.averageGoal" path="averageGoal"/>
		<acme:form-money code="administrator.challenges.form.label.averageReward" path="averageReward"/>
	</acme:form-panel>
	
	
	<acme:form-panel code="administrator.challenges.form.label.rookie">
		<acme:form-textarea code="administrator.challenges.form.label.rookieGoal" path="rookieGoal"/>
		<acme:form-money code="administrator.challenges.form.label.rookieReward" path="rookieReward"/>
	</acme:form-panel>
	
  	<acme:form-submit test="${command == 'show'}" 
	code="administrator.challenges.form.button.update" 
	action="/administrator/challenges/update"/>
	
	<acme:form-submit test="${command == 'show'}" 
	code="administrator.challenges.form.button.delete" 
	action="/administrator/challenges/delete"/>
	
	<acme:form-submit test="${command == 'create'}" 
	code="administrator.challenges.form.button.create" 
	action="/administrator/challenges/create"/>
	
	<acme:form-submit test="${command == 'update'}" 
	code="administrator.challenges.form.button.update" 
	action="/administrator/challenges/update"/>
	
	<acme:form-submit test="${command == 'delete'}" 
	code="administrator.challenges.form.button.delete" 
	action="/administrator/challenges/delete"/>
	
	<acme:form-return code="administrator.challenges.form.button.return"/>
	
</acme:form>