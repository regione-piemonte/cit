
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
<!-- TODO: IMPLEMENTARE CORRETTAMENTE -->
<h3><fmt:message key="error.notfound.title" /></h3>
<!-- appmoduleId:base -->
<!-- pageId:notFoundError -->
<div id="applicationError">
	<fmt:message key="error.notfound.warning" />
	<br/>
	<fmt:message key="error.notfound.message" />
</div>
<div id="applicationError_links" class="commandPanel navigation">
	<div class="button left">
		<a href="<%=request.getContextPath()%>/secure/HomePage.do" class="buttonWidget"><fmt:message key="error.notfound.btnmsg" /></a>
	</div>
</div>
				</div>
			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

	<jsp:include page="/jsp/fragments/footer.jsp" />

