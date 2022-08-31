<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="localization.local" var="loc"/>
<fmt:message bundle="${loc}" key="local.loctitle.name.management"
             var="management"/>
 <fmt:message bundle="${loc}" key="local.locbutton.name.ru"
             var="ru_button"/>
<fmt:message bundle="${loc}" key="local.locbutton.name.en"
             var="en_button"/>            

<div class="wrapper">
	<div class="newstitle">${management}</div>
	
	<div class="local-link">

		<div align="right">

			<a href= controller?command=do_change_locale&local=en&url=rrr >${en_button}</a> &nbsp;&nbsp; 
			<a	href=controller?command=do_change_locale&local=ru&url=rrr> ${ru_button}</a> <br /> <br />
		</div>		
		<c:if test="${sessionScope.user eq 'notActive'}">
			<div align="right">
			
				<form action="controller" method="post">
				
					<input type="hidden" name="command" value="do_sign_in" /> 
					Enter login: <input type="text" name="login" value="" /><br /> 
					Enter password: <input type="password" name="password" value="" /><br />
					
					<c:if test="${not (param.AuthenticationError eq null)}">
						<font color="red"> 
						   <c:out value="${param.AuthenticationError}" />
						</font> 
					</c:if>
										
	<a href="controller?command=go_to_registration_page">Registration</a> <input type="submit" value="Sign In" /> 
				
				</form>
					
			</div>

		</c:if>		
		
		<div align="right">
				<c:if test="${(sessionScope.user eq 'registration')}">
				     User registration:
				     </div>
				     </c:if> 
		
		<c:if test="${sessionScope.user eq 'active'}">

			<div align="right">
				<form action="controller" method="post">
					<input type="hidden" name="command" value="do_sign_out" /> 
					<input type="submit" value="Sign Out" /><br />
				</form>
			</div>

		</c:if>
	</div>

</div>
		