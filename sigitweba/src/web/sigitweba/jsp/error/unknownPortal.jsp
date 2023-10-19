
	<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="globalMessages" />

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<div class="wrapper">
					<h3><fmt:message key="error.unknownportal.title" /></h3>
					<div id="applicationError">
						<fmt:message key="error.unknownportal.warning" />
						<br />
						<fmt:message key="error.unknownportal.resources" />
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

