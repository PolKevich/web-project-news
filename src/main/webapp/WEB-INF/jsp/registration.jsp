<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />
<fmt:message bundle="${loc}" key="local.registration.title" var="registration_title" />
<fmt:message bundle="${loc}" key="local.registration.name" var="registration_name" />
<fmt:message bundle="${loc}" key="local.registration.surname" var="registration_surname" />
<fmt:message bundle="${loc}" key="local.registration.email" var="registration_email" />
<fmt:message bundle="${loc}" key="local.registration.login" var="registration_login" />
<fmt:message bundle="${loc}" key="local.registration.password" var="registration_password" />
<fmt:message bundle="${loc}" key="local.registration.confirmPassword" var="registration_confirmPassword" />
<fmt:message bundle="${loc}" key="local.registration.register" var="registration_register" />
<fmt:message bundle="${loc}" key="local.registration.reset" var="registration_reset" />
<fmt:message bundle="${loc}" key="local.registration.back" var="registration_back" />
<fmt:message bundle="${loc}" key="local.registration.incorrectLogin" var="incorrect_Login" />
<fmt:message bundle="${loc}" key="local.registration.incorrectPassword" var="incorrect_password" />
<fmt:message bundle="${loc}" key="local.registration.passwordNotEqualsConfirmPassword" var="passwordNotEqualsConfirmPassword" />
<fmt:message bundle="${loc}" key="local.registration.incorrectEmail" var="incorrect_email" />

  <div align="left">
<form action="controller" method="post"> 
<p align="center"><c:out value="${registration_title}"/></p>
		<br>
<div>
  
    ${registration_name}: <br> 
    <input type="text" id="first_name" name="firstName"  required placeholder="Ivan"><br />     
     <br> 
    ${registration_surname}: <br> 
    <input type="text" id="last_name" name="lastName" required placeholder="Ivanov"><br />
      <br>            
    
   ${registration_email}: <br> 
    <input type="email" id="email" name="email"  size="42px" required placeholder="Ivanov@mail.com"><br />
  
     <c:if test="${not (sessionScope.email eq null)}">
	   <font color="red"> 
		 <c:out value="${incorrect_email}" />
			</font> 
					</c:if>
					 <br> 
     
    ${registration_login}: <br> 
    <input type="text" id="login" name="login"  required><br />
    
      <c:if test="${not (sessionScope.login eq null)}">
	   <font color="red"> 
		 <c:out value="${incorrect_Login}" />
			</font> 
					</c:if>
					 <br> 

    ${registration_password}:<br> 
     <input type="password" id="password" name="password" required placeholder="abcABC123$"><br />
 
	  <c:if test="${not (sessionScope.password eq null)}">
	   <font color="red"> 
		 <c:out value="${incorrect_password}" />
			</font> 
					</c:if>
					 <br> 
	 
    
    ${registration_confirmPassword}: <br> 
    <input type="password" id="password" name="confirmPassword" required><br />

     <c:if test="${not (sessionScope.confirmPassword eq null)}">
	   <font color="red"> 
		 <c:out value="${passwordNotEqualsConfirmPassword}" />
			</font> 
					</c:if>
					 <br>        
  </div>
  
 
  <div>
    <input type="hidden" name="command" value="do_registration" />
    <input type="submit" value="${registration_register}"    />
    <a href="./">${registration_back}</a>
  </div>
  
  
</form>  
  </div>



