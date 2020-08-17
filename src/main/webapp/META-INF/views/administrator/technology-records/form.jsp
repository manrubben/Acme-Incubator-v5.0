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
	<acme:form-textarea code="administrator.technology-records.form.label.title" path="title" />
	<acme:form-select code="administrator.technology-records.form.label.activitySector" path="activitySector">
		<acme:form-option code="administrator.technology-records.form.label.activitySector.technology" value="Technology" />
		<acme:form-option code="administrator.technology-records.form.label.activitySector.science" value="Science" />
		<acme:form-option code="administrator.technology-records.form.label.activitySector.arts" value="Arts" />
		<acme:form-option code="administrator.technology-records.form.label.activitySector.business" value="Business" />
		<acme:form-option code="administrator.technology-records.form.label.activitySector.health" value="Health" />
	</acme:form-select>
	<acme:form-textbox code="administrator.technology-records.form.label.inventorsName" path="inventorsName" />
	<acme:form-textarea code="administrator.technology-records.form.label.description" path="description" />
	<acme:form-url code="administrator.technology-records.form.label.website" path="website" />
	<acme:form-textbox code="administrator.technology-records.form.label.email" path="email" />
	<acme:form-select code="administrator.technology-records.form.label.indication" path="indication">
		<acme:form-option code="administrator.technology-records.form.label.indication.open-source" value="open_source" />
		<acme:form-option code="administrator.technology-records.form.label.indication.closed-source" value="closed_source" />
	</acme:form-select>
	<acme:form-integer code="administrator.technology-records.form.label.stars" path="stars" placeholder="-5 - 5" />

	<acme:form-submit test="${command == 'show'}" code="administrator.technology-records.form.button.update"
		action="/administrator/technology-records/update" />
	<acme:form-submit test="${command == 'show'}" code="administrator.technology-records.form.button.delete"
		action="/administrator/technology-records/delete" />
	<acme:form-submit test="${command == 'create'}" code="administrator.technology-records.form.button.create"
		action="/administrator/technology-records/create" />
	<acme:form-submit test="${command == 'update'}" code="administrator.technology-records.form.button.update"
		action="/administrator/technology-records/update" />
	<acme:form-submit test="${command == 'delete'}" code="administrator.technology-records.form.button.delete"
		action="/administrator/technology-records/delete" />
	<acme:form-return code="administrator.technology-records.form.button.return" />
</acme:form>