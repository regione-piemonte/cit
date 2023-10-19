<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dpInviaAllegatoForm" action="cpRisultatoRicercaAllegati" namespace="/base/risultato_ricerca_allegati_module" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<div class="dialogPanel" id="dpInviaAllegato">

		
		
<div id="p_mbpConfInvioAllegato" class="msgBoxPanelBlock"><!-- startFragment:p_mbpConfInvioAllegato -->

	
<div class="msgBoxPanel info" id="mbpConfInvioAllegato">


		
<s:if test="isWidgetVisible('cpRisultatoRicercaAllegati','ptMessaggioConferma')" >

	
<p>


<!-- widget ptMessaggioConferma -->
<s:property value="appDatamessaggioDinamico" escape="false" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_mbpConfInvioAllegato --></div>

	
	<div id="p_cpDialogPanelInviaAllegato" class="commandPanelBlock"><!-- startFragment:p_cpDialogPanelInviaAllegato -->
	
	
<div class="commandPanel functional" id="cpDialogPanelInviaAllegato">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRisultatoRicercaAllegati','btnAnnullaInvio')" >

	



<!-- widget btnAnnullaInvio -->
<s:submit name="widg_btnAnnullaInvio" id="widg_btnAnnullaInvio" method="handleBtnAnnullaInvio_CLICKED"
	key="cpRisultatoRicercaAllegati.btnAnnullaInvio.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisultatoRicercaAllegati','btnAnnullaInvio')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpRisultatoRicercaAllegati','btnConfermaInvio')" >

	



<!-- widget btnConfermaInvio -->
<s:submit name="widg_btnConfermaInvio" id="widg_btnConfermaInvio" method="handleBtnConfermaInvio_CLICKED"
	key="cpRisultatoRicercaAllegati.btnConfermaInvio.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisultatoRicercaAllegati','btnConfermaInvio')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpDialogPanelInviaAllegato --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
