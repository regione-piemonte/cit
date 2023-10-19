
	
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<fmt:setBundle basename="globalMessages" />

	<jsp:include page="/jsp/fragments/headerNoStruts.jsp" />

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<div class="wrapper">
<h3><fmt:message key="error.javascripterror.title" /></h3>
<div id="applicationError">
	<fmt:message key="error.javascripterror.warning" />
	<br />
	<fmt:message key="error.javascripterror.errormessage" />
	<br />
	<br />
	<fmt:message key="error.javascripterror.actionmessage" />
</div>
<div id="applicationError_links" class="commandPanel navigation">
	<div class="button left">
		<a href="<c:out value='${sessionScope["MDD_PORTAL_HOME"]}' />" class="buttonWidget"><fmt:message key="error.javascripterror.btnmsgportalhome" /></a>
	</div>
	<div class="button right">
		<a href="<%=request.getContextPath()%>/secure/HomePage.do" class="buttonWidget"><fmt:message key="error.javascripterror.btnmsgservicehome" /></a>
	</div>
</div>
				</div>
			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

	<jsp:include page="/jsp/fragments/footer.jsp" />

