<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

  <div align="left">
<form action="controller" method="post"> 

<div>
 
		<label> Title:<br />
		<input type="text" name="title" value="${title}" size=20 maxlength=100 /><br /> </label> 
        
        <label> Brief:<br />
		<input type="text" name="briefNews" value="${briefNews}" size=20 maxlength=100 /><br /> </label>
       					
		<label> Content:<br />			
         <style type="text/css"> 
         textarea[name="content"] { resize: none; }
            </style>
         <textarea name="content" cols="90" rows="15">${content}             
            </textarea> <br /> </label>   
            
  
         <label> Date:<br />
		<input type="text" name="newsDate" value="${newsDate}" size=20 maxlength=100/><br /> </label>
  </div>
  <br>
  <div>
    <input type="hidden" name="command" value="do_edit_News" />
    <input type="hidden" name="id" value="${idNews}"/>
    <input type="submit" value="Enter"/>
    <input type="button" onclick="history.back();" value="Back"/>
  </div>
  
  
</form>  
  </div>