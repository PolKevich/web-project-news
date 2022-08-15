<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

  <div align="left">
<form action="controller" method="post"> 
<div>
  
    Name: <br> 
    <input type="text" id="first_name" name="firstName"  required placeholder="Ivan"><br />     
     <br> 
    Surname: <br> 
    <input type="text" id="last_name" name="lastName" required placeholder="Ivanov"><br />
      <br>            
    gender: <input type="radio" id="gender" name="gender" value="male">Male
    <input type="radio" id="gender" name="gender" value="female">Female
    <br>
    <br> 
    
    Email: <br> 
    <input type="email" id="email" name="email"  size="42px" required placeholder="Ivanov@mail.com"><br />
    <font color="red"> 
	<c:out value="${email}" />
	</font>      
     <br>  
     
    Login: <br> 
    <input type="text" id="login" name="login"  required><br />
    <font color="red"> 
	<c:out value="${login}" />
	</font>
    <br>

    Password:<br> 
     <input type="password" id="password" name="password" required placeholder="abcABC123$"><br />
    <font color="red"> 
	 <c:out value="${password}" />
	</font>
	 
    <br>
    Confirm Password: <br> 
    <input type="password" id="password" name="confirmPassword" required><br />
     <font color="red"> 
	<c:out value="${confirmPassword}" />
	</font>
           
  </div>
  
  <br>
  <div>
    <input type="hidden" name="command" value="do_registration" />
    <input type="submit" value="Registration"/>
    <button type="reset">Reset</button>
    <input type="button" onclick="history.back();" value="Back"/>
  </div>
  
  
</form>  
  </div>



