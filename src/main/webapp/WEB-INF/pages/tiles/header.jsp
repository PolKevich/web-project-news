<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="localization.local" var="loc"/>
<fmt:message bundle="${loc}" key="local.header.newstitle" var="header_newstitle" />
<fmt:message bundle="${loc}" key="local.header.auth.login" var="auth_login" />
<fmt:message bundle="${loc}" key="local.header.auth.password" var="auth_password" />
<fmt:message bundle="${loc}" key="local.header.auth.errorloginpassword" var="error_loginpassword" />
<fmt:message bundle="${loc}" key="local.locbutton.name.ru" var="ru_button" />
<fmt:message bundle="${loc}" key="local.locbutton.name.en" var="en_button" />
<fmt:message bundle="${loc}" key="local.locbutton.name.registration" var="registration_button" />
<fmt:message bundle="${loc}" key="local.locbutton.name.sign.in" var="sign_in_button" />
<fmt:message bundle="${loc}" key="local.locbutton.name.sign.out" var="sign_out_button" />          

<div class="wrapper">
	<div class="newstitle">${header_newstitle}</div>
	
	<div class="local-link">

		<div align="right">

			<a href= controller?command=do_change_locale&local=en&url=rrr >${en_button}</a> &nbsp;&nbsp; 
			<a	href=controller?command=do_change_locale&local=ru&url=rrr> ${ru_button}</a> <br /> <br />
		</div>		
		<c:if test="${sessionScope.user eq 'notActive'}">
			<div align="right">
			
				<form action="controller" method="post">
				
					<input type="hidden" name="command" value="do_sign_in" /> 
					${auth_login} <input type="text" name="login" value="" /><br /> 
					${auth_password}<input type="password" name="password" value="" /><br />
					
					<c:if test="${not (param.AuthenticationError eq null)}">
						<font color="red"> 
						   <c:out value="${error_loginpassword}" />
						</font> 
					</c:if>
										
	<a href="controller?command=go_to_registration_page">${registration_button}</a> <input type="submit" value="${sign_in_button}" /> 
				
				</form>
					
			</div>

		</c:if>		
		
		
		<c:if test="${sessionScope.user eq 'active'}">

			<div align="right">
				<form action="controller" method="post">
					<input type="hidden" name="command" value="do_sign_out" /> 
					<input type="submit" value="${sign_out_button}" /><br />
				</form>
			</div>

		</c:if>
	</div>

</div>
		