<%--
- menu.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"
	import="acme.framework.helpers.PrincipalHelper,acme.entities.roles.Provider,acme.entities.roles.Consumer"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:menu-bar code="master.menu.home">
	<acme:menu-left>
		<acme:menu-option code="master.menu.anonymous" access="isAnonymous()">
			<acme:menu-suboption code="master.menu.anonymous.favourite-link.manu"
				action="https://github.com/manrubben" />
			<acme:menu-suboption code="master.menu.anonymous.favourite-link.adri"
				action="https://github.com/adrmadfer" />
			<acme:menu-suboption
				code="master.menu.anonymous.favourite-link.ignacio"
				action="https://github.com/ignsanalo" />
			<acme:menu-suboption
				code="master.menu.anonymous.favourite-link.alvaro"
				action="https://github.com/alvdiaasc97" />
			<acme:menu-suboption
				code="master.menu.anonymous.favourite-link.josema"
				action="https://github.com/josgalbal" />
			<acme:menu-suboption
				code="master.menu.anonymous.favourite-link.guille"
				action="https://github.com/guipavvar" />
			<acme:menu-suboption
				code="master.menu.anonymous.technology-records.list"
				action="/anonymous/technology-records/list" />
			<acme:menu-suboption code="master.menu.anonymous.tool-records.list"
				action="/anonymous/tool-records/list" />
			<acme:menu-suboption code="master.menu.anonymous.notices.list"
				action="/anonymous/notices/list" />
		</acme:menu-option>

		<acme:menu-option code="master.menu.authenticated"
			access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.authenticated.list-notices"
				action="/authenticated/notices/list" />
			<acme:menu-suboption
				code="master.menu.authenticated.list-technology-records"
				action="/authenticated/technology-records/list" />
			<acme:menu-suboption
				code="master.menu.authenticated.list-tool-records"
				action="/authenticated/tool-records/list" />
			<acme:menu-suboption code="master.menu.authenticated.overtures"
				action="/authenticated/overtures/list" />
			<acme:menu-suboption code="master.menu.authenticated.inquiries"
				action="/authenticated/inquiries/list" />
			<acme:menu-suboption code="master.menu.authenticated.challenges"
				action="/authenticated/challenges/list" />
				<acme:menu-suboption code="master.menu.authenticated.investment-round"
				action="/authenticated/investment-round/list" />
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.entrepreneur" access="hasRole('Entrepreneur')">
			<acme:menu-suboption code="master.menu.entrepreneur.investmentRound.list" action="/entrepreneur/investment-round/list-mine" />
		</acme:menu-option>

		<acme:menu-option code="master.menu.administrator"
			access="hasRole('Administrator')">
			
			<acme:menu-suboption code="master.menu.administrator.notices"
				action="/administrator/notices/list" />
			<acme:menu-suboption code="master.menu.administrator.technology-records.list"
				action="/administrator/technology-records/list" />
			<acme:menu-suboption code="master.menu.administrator.list-tool-records"
				action="/administrator/tool-records/list" />
			<acme:menu-suboption code="master.menu.administrator.overtures.list" 
				action="/administrator/overtures/list" />
			<acme:menu-suboption code="master.menu.administrator.inquiries.list" 
				action="/administrator/inquiries/list" />
			<acme:menu-suboption code="master.menu.administrator.challenges.list" 
				action="/administrator/challenges/list" />
				
			<acme:menu-separator/>
			
			<acme:menu-suboption code="master.menu.administrator.notices.create" 
				action="/administrator/notices/create" />
			<acme:menu-suboption code="master.menu.administrator.technology-records.create"
				action="/administrator/technology-records/create" />
			<acme:menu-suboption code="master.menu.administrator.create-tool-records"
				action="/administrator/tool-records/create" />
			<acme:menu-suboption code="master.menu.administrator.overtures.create" 
				action="/administrator/overtures/create" />
			<acme:menu-suboption code="master.menu.administrator.inquiries.create" 
				action="/administrator/inquiries/create" />
			<acme:menu-suboption code="master.menu.administrator.challenges.create" 
				action="/administrator/challenges/create" />
			
			<acme:menu-separator/>

			<acme:menu-suboption code="master.menu.administrator.user-accounts"
				action="/administrator/user-account/list" />
			<acme:menu-suboption code="master.menu.administrator.shutdown"
				action="/master/shutdown" />
			
		</acme:menu-option>

		<acme:menu-option code="master.menu.provider"
			access="hasRole('Provider')">
			<acme:menu-suboption code="master.menu.provider.favourite-link"
				action="http://www.example.com/" />
		</acme:menu-option>

		<acme:menu-option code="master.menu.consumer"
			access="hasRole('Consumer')">
			<acme:menu-suboption code="master.menu.consumer.favourite-link"
				action="http://www.example.com/" />
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.investor" access="hasRole('Investor')">
			<acme:menu-suboption code="master.menu.investor.application.list-mine" action="/investor/application/list-mine"/>
		</acme:menu-option>
	</acme:menu-left>

	<acme:menu-right>
		<acme:menu-option code="master.menu.sign-up"
			action="/anonymous/user-account/create" access="isAnonymous()" />
		<acme:menu-option code="master.menu.sign-in" action="/master/sign-in"
			access="isAnonymous()" />

		<acme:menu-option code="master.menu.user-account"
			access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.user-account.general-data"
				action="/authenticated/user-account/update" />
			<acme:menu-suboption code="master.menu.user-account.become-provider"
				action="/authenticated/provider/create"
				access="!hasRole('Provider')" />
			<acme:menu-suboption code="master.menu.user-account.provider"
				action="/authenticated/provider/update" access="hasRole('Provider')" />
			<acme:menu-suboption code="master.menu.user-account.become-consumer"
				action="/authenticated/consumer/create"
				access="!hasRole('Consumer')" />
			<acme:menu-suboption code="master.menu.user-account.consumer"
				action="/authenticated/consumer/update" access="hasRole('Consumer')" />
		</acme:menu-option>

		<acme:menu-option code="master.menu.sign-out"
			action="/master/sign-out" access="isAuthenticated()" />
	</acme:menu-right>
</acme:menu-bar>

