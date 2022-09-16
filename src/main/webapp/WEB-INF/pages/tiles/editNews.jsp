<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />
<fmt:message bundle="${loc}" key="local.editnews.editnews" var="edit_news" />
<fmt:message bundle="${loc}" key="local.news.title" var="news_title" />
<fmt:message bundle="${loc}" key="local.news.brief" var="news_brief" />
<fmt:message bundle="${loc}" key="local.news.content" var="news_content" />
<fmt:message bundle="${loc}" key="local.news.date" var="news_date" />
<fmt:message bundle="${loc}" key="local.news.enter" var="news_enter" />
<fmt:message bundle="${loc}" key="local.news.back" var="news_back" />
<fmt:message bundle="${loc}" key="local.guestinfo.news" var="news_news" />

  <div align="left">
<form action="controller" method="post"> 
<a href="controller?command=go_to_news_list">${news_news} >> </a> ${edit_news}

<div>
 <br>
        <label> ${news_title}<br />		
		   <style type="text/css"> 
         textarea[name="title"] { resize: none; }
            </style>
         <textarea name="title" cols="90" rows="5">${title}             
            </textarea> <br /> </label>  
        <br>
        
        <label> ${news_brief}<br />
		   <style type="text/css"> 
         textarea[name="briefNews"] { resize: none; }
            </style>
         <textarea name="briefNews" cols="90" rows="5">${briefNews}             
            </textarea> <br /> </label> 
       	<br>	
       				
		<label> ${news_content}<br />			
         <style type="text/css"> 
         textarea[name="content"] { resize: none; }
            </style>
         <textarea name="content" cols="90" rows="15">${content}             
            </textarea> <br /> </label>   
          <br>   
         <label> ${news_date}<br />
		<input type="text" name="newsDate" value="${newsDate}" size=20 maxlength=100/><br /> </label>
  </div>
  <br>
  <div>
    <input type="hidden" name="command" value="do_edit_News" />
    <input type="hidden" name="id" value="${idNews}"/>
    <input type="submit" value="${news_enter}"/>
    
  </div>
  
  
</form>  
  </div>