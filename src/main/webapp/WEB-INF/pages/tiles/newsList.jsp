<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />
<fmt:message bundle="${loc}" key="local.guestinfo.news" var="news_news" />
<fmt:message bundle="${loc}" key="local.newslist" var="news_list" />
<fmt:message bundle="${loc}" key="local.nonews" var="no_news" />
<fmt:message bundle="${loc}" key="local.newslist.edit" var="newslist_edit" />
<fmt:message bundle="${loc}" key="local.newslist.view" var="newslist_view" />
<fmt:message bundle="${loc}" key="local.locbutton.name.delete" var="delete_news" />


<div class="body-title">
	<a href="">${news_news} >> </a> ${news_list}
</div>

<form action="controller" method="post">
	<c:forEach var="news" items="${requestScope.news}">
		<div class="single-news-wrapper">
			<div class="single-news-header-wrapper">
				<div class="news-title">
					<c:out value="${news.title}" />
				</div>
				<div class="news-date">
					<c:out value="${news.newsDate}" />
				</div>

				<div class="news-content">
					<c:out value="${news.briefNews}" />
				</div>
				<div class="news-link-to-wrapper">
					<div class="link-position">
						<c:if test="${sessionScope.role eq 'admin'}">
						      <a href="controller?command=go_to_edit_news&id=${news.idNews}">${newslist_edit} </a> 
						</c:if>
						
						<a href="controller?command=go_to_view_news&id=${news.idNews}">${newslist_view} </a> 
   					    
   					    <c:if test="${sessionScope.role eq 'admin'}">
   					         <input type="checkbox" name="id" value="${news.idNews}" />
   					         
   					    </c:if>
					</div>
				</div>

			</div>
		</div>

	</c:forEach>

	<div class="no-news">
		<c:if test="${requestScope.news eq null}">
        ${no_news}.
	</c:if>
	</div>
	   	<c:if test="${sessionScope.role eq 'admin'}">
	       <br/><div align="right">
   			<input type="hidden" name="command" value="do_delete_news" /> 
   			   <input type="submit" value="${delete_news}" /> 
			    </div>
   			     </c:if>
   			     
   	<br/><div align="center">
     <c:if test="${requestScope.pageCount.size()>1}">
     <c:forEach var="pageNumber" items="${requestScope.pageCount}">
          <a href="controller?command=go_to_news_list&pageNumber=${pageNumber}">${pageNumber}&nbsp </a>
        </c:forEach>
             </c:if>
               </div>

</form>