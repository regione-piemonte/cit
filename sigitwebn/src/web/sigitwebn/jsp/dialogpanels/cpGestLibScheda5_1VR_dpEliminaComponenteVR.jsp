<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dpEliminaComponenteVRForm" action="cpGestLibScheda5_1VR" namespace="/base/gestisci_libretto_scheda5_1VR" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<div class="dialogPanel" id="dpEliminaComponenteVR">

		
		
<div id="p_mbpConfEliminaComp" class="msgBoxPanelBlock"><!-- startFragment:p_mbpConfEliminaComp -->

	
<div class="msgBoxPanel info" id="mbpConfEliminaComp">


		
<s:if test="isWidgetVisible('cpGestLibScheda5_1VR','ptMessaggioDinamico')" >

	
<p>


<!-- widget ptMessaggioDinamico -->
<s:property value="appDatamessaggioDinamico" escape="false" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_mbpConfEliminaComp --></div>

	
	<div id="p_cpDialogPanelEliminaComp" class="commandPanelBlock"><!-- startFragment:p_cpDialogPanelEliminaComp -->
	
	
<div class="commandPanel functional" id="cpDialogPanelEliminaComp">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestLibScheda5_1VR','btAnnullaElim')" >

	



<!-- widget btAnnullaElim -->
<s:submit name="widg_btAnnullaElim" id="widg_btAnnullaElim" method="handleBtAnnullaElim_CLICKED"
	key="cpGestLibScheda5_1VR.btAnnullaElim.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda5_1VR','btAnnullaElim')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpGestLibScheda5_1VR','btConfermaElim')" >

	



<!-- widget btConfermaElim -->
<s:submit name="widg_btConfermaElim" id="widg_btConfermaElim" method="handleBtConfermaElim_CLICKED"
	key="cpGestLibScheda5_1VR.btConfermaElim.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda5_1VR','btConfermaElim')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpDialogPanelEliminaComp --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
