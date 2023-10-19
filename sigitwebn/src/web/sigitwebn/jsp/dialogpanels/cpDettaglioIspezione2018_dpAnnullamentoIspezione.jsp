<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dpAnnullamentoIspezioneForm" action="cpDettaglioIspezione2018" namespace="/base/elenco_ispezioni_impianti" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<div class="dialogPanel" id="dpAnnullamentoIspezione">

		
		
<div id="p_mbpConfAnnullamentoIspezione" class="msgBoxPanelBlock"><!-- startFragment:p_mbpConfAnnullamentoIspezione -->

	
<div class="msgBoxPanel info" id="mbpConfAnnullamentoIspezione">


		
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','ptMessaggioDinamicoAnnullamentoIspezione')" >

	
<p>


<!-- widget ptMessaggioDinamicoAnnullamentoIspezione -->
<s:property value="appDatamessaggioDinamico" escape="false" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_mbpConfAnnullamentoIspezione --></div>

	
	<div id="p_cpDialogPanelAnnullaIspezione" class="commandPanelBlock"><!-- startFragment:p_cpDialogPanelAnnullaIspezione -->
	
	
<div class="commandPanel functional" id="cpDialogPanelAnnullaIspezione">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','btAnnullaAnnullamentoIspezione')" >

	



<!-- widget btAnnullaAnnullamentoIspezione -->
<s:submit name="widg_btAnnullaAnnullamentoIspezione" id="widg_btAnnullaAnnullamentoIspezione" method="handleBtAnnullaAnnullamentoIspezione_CLICKED"
	key="cpDettaglioIspezione2018.btAnnullaAnnullamentoIspezione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioIspezione2018','btAnnullaAnnullamentoIspezione')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','btConfermaAnnullamentoIspezione')" >

	



<!-- widget btConfermaAnnullamentoIspezione -->
<s:submit name="widg_btConfermaAnnullamentoIspezione" id="widg_btConfermaAnnullamentoIspezione" method="handleBtConfermaAnnullamentoIspezione_CLICKED"
	key="cpDettaglioIspezione2018.btConfermaAnnullamentoIspezione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioIspezione2018','btConfermaAnnullamentoIspezione')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpDialogPanelAnnullaIspezione --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
