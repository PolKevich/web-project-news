<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="script/validation.js"></script>
<title>locale.linkname.headertitle <!-- <bean:message key="locale.linkname.headertitle" />
 -->
</title>

<link rel="stylesheet" type="text/css" href="styles/newsStyle.css">

</head>
<body>
	<div class="page">
	
		<div class="header">
							
				    <c:import url="/WEB-INF/pages/tiles/header.jsp" />
		</div>
		
		<div class="base-layout-wrapper">
					<div class="menu">

				<c:if test="${sessionScope.user eq 'notActive'}">
				    Welcome!!!!!
					<%-- <c:import url=""></c:import> --%>
				</c:if>
				
				<c:if test="${sessionScope.user eq 'active'}">
					<c:import url="/WEB-INF/pages/tiles/menu.jsp" />
				</c:if>
			</div>
			
				<div class="content">

				<c:if test="${sessionScope.user eq 'notActive'}">
					<c:import url="/WEB-INF/pages/tiles/guestInfo.jsp" />
				</c:if>
				
				<c:if test="${sessionScope.user eq 'active'}">
					<c:import url="/WEB-INF/pages/tiles/body.jsp" />
					<%--!body will order to fix what newslist--%>>
				</c:if>
				
				<c:if test="${sessionScope.news eq 'addNews'}">
					<c:import url="/WEB-INF/pages/tiles/addNews.jsp" />
					
				</c:if>
				
				<c:if test="${sessionScope.news eq 'error'}">
					<c:import url="/WEB-INF/pages/tiles/error.jsp" />
					
				</c:if>
               
		             <c:if test="${(sessionScope.user eq 'registration')}">
				     <c:import url="/WEB-INF/jsp/registration.jsp" />
				     </c:if> <br />
				     	
			</div>
			</div>
			

		<div class="footer">

			<c:import url="/WEB-INF/pages/tiles/footer.jsp" />
		</div>
		</div>

</body>
</html>