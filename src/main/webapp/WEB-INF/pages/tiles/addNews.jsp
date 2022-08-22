<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

  <div align="left">
<form action="controller" method="post"> 

<div>
  
		<label> Title:<br />
		<input type="text" name="title" value="" size=20 maxlength=100 required="required"/><br /> </label>
        
        <label> Brief:<br />
		<input type="text" name="briefNews" value="" size=20 maxlength=100 required="required"/><br /> </label>
       					
		<label> Content:<br />	
         <style type="text/css"> 
           textarea[name="content"] { resize: none; }
            </style>
            <textarea name="content" cols="90" rows="15" required="required"/></textarea> <br /> </label>
            
            <label>Date:<br />
		<input type="date" name="newsData"/><br /> </label>
           
  </div>
  
  <br>
  <div>
    <input type="hidden" name="command" value="do_add_News" />
    <input type="submit" value="Enter"/>
    <input type="button" onclick="history.back();" value="Back"/>
  </div>
  
  
</form>  
  </div>