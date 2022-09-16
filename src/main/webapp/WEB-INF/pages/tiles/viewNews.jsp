<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />
<fmt:message bundle="${loc}" key="local.news.date" var="news_date" />
<fmt:message bundle="${loc}" key="local.news.title" var="news_title" />
<fmt:message bundle="${loc}" key="local.news.brief" var="news_brief" />
<fmt:message bundle="${loc}" key="local.news.content" var="news_content" />
<fmt:message bundle="${loc}" key="local.locbutton.name.delete" var="delete_news" />
<fmt:message bundle="${loc}" key="local.locbutton.name.edit" var="edit_news" />
<fmt:message bundle="${loc}" key="local.guestinfo.news" var="news_news" />
<fmt:message bundle="${loc}" key="local.viewnews" var="view_news" />


<div class="body-title">
	<a href="controller?command=go_to_news_list">${news_news} >> </a> ${view_news}
</div>

<div class="add-table-margin">
	<table class="news_text_format">
		<tr>
			<td class="space_around_title_text">${news_title}</td>

			<td class="space_around_view_text"><div class="word-breaker">
					<c:out value="${requestScope.news.title }" />
				</div></td>
		</tr>
		<tr>
			<td class="space_around_title_text">${news_date}</td>

			<td class="space_around_view_text"><div class="word-breaker">
					<c:out value="${requestScope.news.newsDate }" />
				</div></td>
		</tr>
		<tr>
			<td class="space_around_title_text">${news_brief}</td>
			<td class="space_around_view_text"><div class="word-breaker">
					<c:out value="${requestScope.news.briefNews }" />
				</div></td>
		</tr>
		<tr>
			<td class="space_around_title_text">${news_content}</td>
			<td class="space_around_view_text"><div class="word-breaker">
					<c:out value="${requestScope.news.content }" />
				</div></td>
		</tr>
	</table>
</div>


<c:if test="${sessionScope.role eq 'admin'}">

<div class="left">
	<form action="controller" method="post">
	<input type="hidden" name="command" value="go_to_edit_news" /> <input
			type="hidden" name="id" value="${news.idNews}" /> <input
			type="submit" value="${edit_news}" /> 
			
	</form>
</div>
 <br>
<div class="left">
	<form action="controller" method="post">
		<input type="hidden" name="command" value="do_delete_news" /> <input
			type="hidden" name="id" value="${news.idNews}" /> <input
            type="submit" value="${delete_news}" />
	</form>
</div>
</c:if>
