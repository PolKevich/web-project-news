<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>


<form action="controller" method="post"> 
  <h1>Регистрация пользователя:</h1>
  <div>
    <input type="text" id="first_name" name="firstName" required>
    <label for="first_name">Имя</label><br><br>
           
    <input type="text" id="last_name" name="lastName" required>
    <label for="last_name">Фамилия</label><br><br>
                  
    <p>Пол:</p>
    <input type="radio" id="gender" name="gender" value="male">Мужской
    <input type="radio" id="gender" name="gender" value="female">Женский
    <br><br>
    
    <input type="email" id="email" name="email" size="42px" required >
    <label for="email">Email</label><br><br>
    

    
    <input type="text" id="login" name="login" required>
    <label for="login">Логин</label>
    <br><br>
    
    <input type="password" id="password" name="password" required>
    <label for="password">Пароль</label>
    <br><br>
    
    <input type="confirmPassword" id="confirmPassword" name="confirmPassword" required>
    <label for="confirmPassword">Подтвердите пароль</label>
           
  </div><br/>
  
  <div>
    <input type="hidden" name="command" value="do_registration" />
    <input type="submit" value="Зарегистрироваться"/>
    <button type="reset">Очистить форму</button>
  </div>
  
</form>  
  
       


</body>
</html>
