<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_ree_confirm -->
<!-- pageId:cpGestReeConfirm -->

<s:form id="cpGestReeConfirm" action="cpGestReeConfirm" namespace="/base/gestisci_ree_confirm" method="post">


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

			
	
	<div id="p_wpGestReeConfirm" class="widgetsPanelBlock"><!-- startFragment:p_wpGestReeConfirm -->
	
	

<div class="widgetsPanel" id="wpGestReeConfirm">
	
	<customtag:widgetsPanel id="wpGestReeConfirmTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestReeConfirm','hvVerificaInvioREE')" >

	
<div class="hidden">


<!-- widget hvVerificaInvioREE -->
<s:hidden name="widg_hvVerificaInvioREE" id="widg_hvVerificaInvioREE" />

	
</div>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpGestReeConfirm --></div>

	

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
