<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dpEliminaAllegatiForm" action="cpRisultatoRicercaAllegati" namespace="/base/risultato_ricerca_allegati_module" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<div class="dialogPanel" id="dpEliminaAllegati">

		
		
<div id="p_mbpConfEliminaAllegati" class="msgBoxPanelBlock"><!-- startFragment:p_mbpConfEliminaAllegati -->

	
<div class="msgBoxPanel info" id="mbpConfEliminaAllegati">


		
<s:if test="isWidgetVisible('cpRisultatoRicercaAllegati','ptMessaggioDinamico')" >

	
<p>


<!-- widget ptMessaggioDinamico -->
<s:property value="appDatamessaggioDinamico" escape="false" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_mbpConfEliminaAllegati --></div>

	
	<div id="p_cpDialogPanelEliminaAllegati" class="commandPanelBlock"><!-- startFragment:p_cpDialogPanelEliminaAllegati -->
	
	
<div class="commandPanel functional" id="cpDialogPanelEliminaAllegati">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRisultatoRicercaAllegati','btAnnullaElim')" >

	



<!-- widget btAnnullaElim -->
<s:submit name="widg_btAnnullaElim" id="widg_btAnnullaElim" method="handleBtAnnullaElim_CLICKED"
	key="cpRisultatoRicercaAllegati.btAnnullaElim.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisultatoRicercaAllegati','btAnnullaElim')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpRisultatoRicercaAllegati','btConfermaElim')" >

	



<!-- widget btConfermaElim -->
<s:submit name="widg_btConfermaElim" id="widg_btConfermaElim" method="handleBtConfermaElim_CLICKED"
	key="cpRisultatoRicercaAllegati.btConfermaElim.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisultatoRicercaAllegati','btConfermaElim')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpDialogPanelEliminaAllegati --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
