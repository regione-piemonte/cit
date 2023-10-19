<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_rapprova -->
<!-- pageId:cpGestRapProvaConfirm -->

<s:form id="cpGestRapProvaConfirm" action="cpGestRapProvaConfirm" namespace="/base/gestisci_rapprova" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">



	<!-- ================ UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->
	<div id="centerWrapper" class="floatWrapper">


		<!-- ***** UDLRC Layout CENTER PANEL ***** -->
		<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
			<div class="wrapper">

					
	
	<div id="p_fpCenter" class="formPanelBlock"><!-- startFragment:p_fpCenter -->

	
	

	
	
			
	
	<div id="p_stdMsgConfirm" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgConfirm -->
	
	
<div class="stdMessagePanel" id="stdMsgConfirm">
	<customtag:stdMessagePanel id="stdMsgConfirm" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgConfirm --></div>

			
	
	<div id="p_wpGestRapProvaConfirm" class="widgetsPanelBlock"><!-- startFragment:p_wpGestRapProvaConfirm -->
	
	

<div class="widgetsPanel" id="wpGestRapProvaConfirm">
	
	<customtag:widgetsPanel id="wpGestRapProvaConfirmTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestRapProvaConfirm','hvVerificaInvioRapProva')" >

	
<div class="hidden">


<!-- widget hvVerificaInvioRapProva -->
<s:hidden name="widg_hvVerificaInvioRapProva" id="widg_hvVerificaInvioRapProva" />

	
</div>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpGestRapProvaConfirm --></div>

	

	<!-- endFragment:p_fpCenter --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout CENTER PANEL ***** -->



	</div>
	<!-- ================ FINE UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->



</div>
<!-- #################### FINE PANNELLO CONTENUTI #################### -->




</s:form>


	<s:include value="fragments/footer.jsp" ></s:include>
