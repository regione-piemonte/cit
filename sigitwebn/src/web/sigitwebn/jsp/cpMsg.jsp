<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/main -->
<!-- pageId:cpMsg -->

<s:form id="cpMsg" action="cpMsg" namespace="/base/main" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">



	<!-- ================ UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->
	<div id="centerWrapper" class="floatWrapper">


		<!-- ***** UDLRC Layout CENTER PANEL ***** -->
		<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
			<div class="wrapper">

					
	
	<div id="p_fpMsg" class="formPanelBlock"><!-- startFragment:p_fpMsg -->

	
	

	
	
			
	
	<div id="p_stdMsgPError" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgPError -->
	
	
<div class="stdMessagePanel" id="stdMsgPError">
	<customtag:stdMessagePanel id="stdMsgPError" errorMessage="false" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgPError --></div>

			
	
<div id="p_msgbError" class="msgBoxPanelBlock"><!-- startFragment:p_msgbError -->

		
<s:if test="isWidgetVisible('cpMsg','ptMsgError')" >

	
<p>


<!-- widget ptMsgError -->
<s:property value="appDatamessaggioDinamico" escape="false" />

	
</p>

</s:if>

	

<!-- endFragment:p_msgbError --></div>

	

	<!-- endFragment:p_fpMsg --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout CENTER PANEL ***** -->



	</div>
	<!-- ================ FINE UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->



</div>
<!-- #################### FINE PANNELLO CONTENUTI #################### -->




</s:form>


	<s:include value="fragments/footer.jsp" ></s:include>
