<%@taglib uri="/struts-tags" prefix="s" %>
	<s:include value="../fragments/header.jsp" ></s:include>

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<div class="wrapper">
<h3><s:text name="message.confirmlogout.title" /></h3>
<!-- appmoduleId:/secure -->
<!-- pageId:Logout -->
<div id="applicationError">
	<s:text name="message.confirmlogout.warning" />
	<br />
	<s:text name="message.confirmlogout.closemessage" />
	<br />
	<s:text name="message.confirmlogout.certmessage" />
</div>
<div id="applicationError_links" class="commandPanel navigation">
	<div class="button left">
		<s:url id="logoutUrl" action="Logout" namespace="/secure" method="ssoLogout" />
		<s:a href="%{logoutUrl}" cssClass="buttonWidget"><s:text name="message.confirmlogout.btnmsglogout" /></s:a>
	</div>
	<div class="button right">
		<s:url id="homePageUrl" action="HomePage" namespace="/secure" />
		<s:a href="%{homePageUrl}" cssClass="buttonWidget"><s:text name="message.confirmlogout.btnmsghomepage" /></s:a>
	</div>
</div>
				</div>
			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

	<s:include value="../fragments/footer.jsp" ></s:include>
