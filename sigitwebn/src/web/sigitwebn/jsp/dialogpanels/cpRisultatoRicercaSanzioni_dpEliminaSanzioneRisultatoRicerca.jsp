<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dpEliminaSanzioneRisultatoRicercaForm" action="cpRisultatoRicercaSanzioni" namespace="/base/gestisci_sanzioni" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<div class="dialogPanel" id="dpEliminaSanzioneRisultatoRicerca">

		
		
<div id="p_mbConfEliminaSanzione" class="msgBoxPanelBlock"><!-- startFragment:p_mbConfEliminaSanzione -->

	
<div class="msgBoxPanel info" id="mbConfEliminaSanzione">


		
<s:if test="isWidgetVisible('cpRisultatoRicercaSanzioni','ptMsg')" >

	
<p>


<!-- widget ptMsg -->
<s:property value="appDatamessaggioDinamico" escape="false" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_mbConfEliminaSanzione --></div>

	
	<div id="p_cpConfEliminaSanzione" class="commandPanelBlock"><!-- startFragment:p_cpConfEliminaSanzione -->
	
	
<div class="commandPanel functional" id="cpConfEliminaSanzione">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRisultatoRicercaSanzioni','btAnnulla')" >

	



<!-- widget btAnnulla -->
<s:submit name="widg_btAnnulla" id="widg_btAnnulla" method="handleBtAnnulla_CLICKED"
	key="cpRisultatoRicercaSanzioni.btAnnulla.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisultatoRicercaSanzioni','btAnnulla')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpRisultatoRicercaSanzioni','btConferma')" >

	



<!-- widget btConferma -->
<s:submit name="widg_btConferma" id="widg_btConferma" method="handleBtConferma_CLICKED"
	key="cpRisultatoRicercaSanzioni.btConferma.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisultatoRicercaSanzioni','btConferma')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpConfEliminaSanzione --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
