<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dpConfirmInvioRapProvaForm" action="cpGestRapProvaConfirm" namespace="/base/gestisci_rapprova" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<div class="dialogPanel" id="dpConfirmInvioRapProva">

		
		
<div id="p_msgConfermaInvio" class="msgBoxPanelBlock"><!-- startFragment:p_msgConfermaInvio -->

	
<div class="msgBoxPanel info" id="msgConfermaInvio">


		
<s:if test="isWidgetVisible('cpGestRapProvaConfirm','ptMsgConfermaInvio')" >

	
<p>


<!-- widget ptMsgConfermaInvio -->
<s:property value="appDatamessaggioDinamico" escape="false" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_msgConfermaInvio --></div>

	
	<div id="p_cpDialogPanelInviaRapProva" class="commandPanelBlock"><!-- startFragment:p_cpDialogPanelInviaRapProva -->
	
	
<div class="commandPanel functional" id="cpDialogPanelInviaRapProva">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestRapProvaConfirm','btAnnulla')" >

	



<!-- widget btAnnulla -->
<s:submit name="widg_btAnnulla" id="widg_btAnnulla" method="handleBtAnnulla_CLICKED"
	key="cpGestRapProvaConfirm.btAnnulla.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestRapProvaConfirm','btAnnulla')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpGestRapProvaConfirm','btConferma')" >

	



<!-- widget btConferma -->
<s:submit name="widg_btConferma" id="widg_btConferma" method="handleBtConferma_CLICKED"
	key="cpGestRapProvaConfirm.btConferma.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestRapProvaConfirm','btConferma')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpDialogPanelInviaRapProva --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
