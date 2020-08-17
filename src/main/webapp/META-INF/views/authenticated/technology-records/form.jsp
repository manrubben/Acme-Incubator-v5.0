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
	<acme:form-textbox code="authenticated.technology-records.form.label.title" path="title" />
	<acme:form-select code="authenticated.technology-records.form.label.activitySector" path="activitySector">
		<acme:form-option code="authenticated.technology-records.form.label.activitySector.technology" value="Technology" />
		<acme:form-option code="authenticated.technology-records.form.label.activitySector.science" value="Science" />
		<acme:form-option code="authenticated.technology-records.form.label.activitySector.arts" value="Arts" />
		<acme:form-option code="authenticated.technology-records.form.label.activitySector.business" value="Business" />
		<acme:form-option code="authenticated.technology-records.form.label.activitySector.health" value="Health" />
	</acme:form-select>
	<acme:form-textbox code="authenticated.technology-records.form.label.inventorsName" path="inventorsName"/>
	<acme:form-textarea code="authenticated.technology-records.form.label.description" path="description"/>
	<acme:form-url code="authenticated.technology-records.form.label.website" path="website"/>
	<acme:form-textbox code="authenticated.technology-records.form.label.email" path="email"/>
	<acme:form-select code="authenticated.technology-records.form.label.indication" path="indication">
		<acme:form-option code="authenticated.technology-records.form.label.indication.open-source" value="open_source" />
		<acme:form-option code="authenticated.technology-records.form.label.indication.closed-source" value="closed_source" />
	</acme:form-select>
	<acme:form-integer code="authenticated.technology-records.form.label.stars" path="stars" placeholder="-5 - 5"/>
	
	<acme:form-return code="authenticated.technology-records.form.button.return"/>
</acme:form>