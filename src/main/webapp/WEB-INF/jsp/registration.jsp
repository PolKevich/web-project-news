<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<div class="newstitle">Breaking News</div>
	
	
  <div align="center">
<form action="controller" method="post"> 
<div>
  <h1>User registration:</h1>
    <input type="text" id="first_name" name="firstName" required>
    <label for="first_name">Name</label><br>
     <br>      
    <input type="text" id="last_name" name="lastName" required>
    <label for="last_name">Surname</label><br>
      <br>            
    <p>gender:</p>
    <input type="radio" id="gender" name="gender" value="male">Male
    <input type="radio" id="gender" name="gender" value="female">Female
    <br>
    
    <input type="email" id="email" name="email" size="42px" required >
    <label for="email">Email</label><br>
     <br>   
    <input type="text" id="login" name="login" required>
    <label for="login">Login</label><br>
    <br>
    <input type="password" id="password" name="password" required>
    <label for="password">Password</label> <br>
    <br>
    <input type="confirmPassword" id="confirmPassword" name="confirmPassword" required>
    <label for="confirmPassword">Confirm Password</label><br>
           
  </div>
  
<c:forEach items="${invalidRegistration}" var="item">
<font color="red"> 
   ${item}
   </font>
</c:forEach>
  <br>
  <div>
    <input type="hidden" name="command" value="do_registration" />
    <input type="submit" value="Registration"/>
    <button type="reset">Reset</button>
  </div>
  
</form>  
  </div>



