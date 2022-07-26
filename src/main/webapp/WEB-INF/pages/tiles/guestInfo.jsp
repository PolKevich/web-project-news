<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

    <fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />
<fmt:message bundle="${loc}" key="local.guestinfo" var="guest_info" />
<fmt:message bundle="${loc}" key="local.guestinfo.news" var="news_news" />
<fmt:message bundle="${loc}" key="local.guestinfo.latestnews" var="latest_news" />
<fmt:message bundle="${loc}" key="local.nonews" var="no_news" />

${guest_info}

<div class="body-title">
	<a href="">${news_news} >> </a> ${latest_news}
</div>

<form action="command.do?method=delete" method="post">
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
			</div>
		</div>

	</c:forEach>

	<div class="no-news">
		<c:if test="${requestScope.news eq null}">
        ${no_news}.
	</c:if>
	</div>

</form>