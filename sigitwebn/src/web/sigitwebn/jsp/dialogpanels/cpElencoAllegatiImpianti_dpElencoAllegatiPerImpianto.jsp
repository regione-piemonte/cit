<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dpElencoAllegatiPerImpiantoForm" action="cpElencoAllegatiImpianti" namespace="/base/elenco_allegati_impianti" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<div class="dialogPanel" id="dpElencoAllegatiPerImpianto">

		
		
<div id="p_mbpConfInviaAllegati" class="msgBoxPanelBlock"><!-- startFragment:p_mbpConfInviaAllegati -->

	
<div class="msgBoxPanel info" id="mbpConfInviaAllegati">


		
<s:if test="isWidgetVisible('cpElencoAllegatiImpianti','ptMessaggioDinamicoInvia')" >

	
<p>


<!-- widget ptMessaggioDinamicoInvia -->
<s:property value="appDatamessaggioDinamico" escape="false" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_mbpConfInviaAllegati --></div>

	
	<div id="p_cpDialogPanelElenAllegImpianto" class="commandPanelBlock"><!-- startFragment:p_cpDialogPanelElenAllegImpianto -->
	
	
<div class="commandPanel functional" id="cpDialogPanelElenAllegImpianto">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpElencoAllegatiImpianti','btAnnulla')" >

	



<!-- widget btAnnulla -->
<s:submit name="widg_btAnnulla" id="widg_btAnnulla" method="handleBtAnnulla_CLICKED"
	key="cpElencoAllegatiImpianti.btAnnulla.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoAllegatiImpianti','btAnnulla')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpElencoAllegatiImpianti','btConferma')" >

	



<!-- widget btConferma -->
<s:submit name="widg_btConferma" id="widg_btConferma" method="handleBtConferma_CLICKED"
	key="cpElencoAllegatiImpianti.btConferma.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoAllegatiImpianti','btConferma')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpDialogPanelElenAllegImpianto --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
