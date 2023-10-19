	<%@taglib uri="/struts-tags" prefix="s" %>
	<s:include value="../fragments/header.jsp" ></s:include>

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<div class="wrapper">
<!-- TODO: IMPLEMENTARE CORRETTAMENTE -->
<h3><s:text name="error.applicationerror.title" /></h3>
<!-- appmoduleId:base -->
<!-- pageId:applicationError -->
<div id="applicationError">
	<s:text name="error.applicationerror.warning" /> <s:text name="error.applicationerror.message" />
	<br />
	<s:property value="%{exception.message}"/>
</div>
<div id="applicationError_links" class="commandPanel navigation">
	<div class="button left">
		<s:url id="homePageUrl" action="HomePage" namespace="/secure" />
		<s:a href="%{homePageUrl}" cssClass="buttonWidget"><s:text name="error.applicationerror.btnmsg" /></s:a>
	</div>
</div>
				</div>
			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

	<s:include value="../fragments/footer.jsp" ></s:include>

