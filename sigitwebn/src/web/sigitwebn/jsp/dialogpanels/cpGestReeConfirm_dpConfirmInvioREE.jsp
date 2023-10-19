<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dpConfirmInvioREEForm" action="cpGestReeConfirm" namespace="/base/gestisci_ree_confirm" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<div class="dialogPanel" id="dpConfirmInvioREE">

		
		
<div id="p_msgConfermaInvio" class="msgBoxPanelBlock"><!-- startFragment:p_msgConfermaInvio -->

	
<div class="msgBoxPanel info" id="msgConfermaInvio">


		
<s:if test="isWidgetVisible('cpGestReeConfirm','ptMsgConfermaInvio')" >

	
<p>


<!-- widget ptMsgConfermaInvio -->
<s:property value="appDatamessaggioDinamico" escape="false" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_msgConfermaInvio --></div>

	
	<div id="p_cpDialogPanelInviaREE" class="commandPanelBlock"><!-- startFragment:p_cpDialogPanelInviaREE -->
	
	
<div class="commandPanel functional" id="cpDialogPanelInviaREE">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestReeConfirm','btAnnulla')" >

	



<!-- widget btAnnulla -->
<s:submit name="widg_btAnnulla" id="widg_btAnnulla" method="handleBtAnnulla_CLICKED"
	key="cpGestReeConfirm.btAnnulla.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestReeConfirm','btAnnulla')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpGestReeConfirm','btConferma')" >

	



<!-- widget btConferma -->
<s:submit name="widg_btConferma" id="widg_btConferma" method="handleBtConferma_CLICKED"
	key="cpGestReeConfirm.btConferma.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestReeConfirm','btConferma')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpDialogPanelInviaREE --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
