<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dpEliminaAccertamentoForm" action="cpDettaglioAccertamento" namespace="/base/gestisci_accertamento" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<div class="dialogPanel" id="dpEliminaAccertamento">

		
		
<div id="p_mbConfEliminaAccertamento" class="msgBoxPanelBlock"><!-- startFragment:p_mbConfEliminaAccertamento -->

	
<div class="msgBoxPanel info" id="mbConfEliminaAccertamento">


		
<s:if test="isWidgetVisible('cpDettaglioAccertamento','ptMsg')" >

	
<p>


<!-- widget ptMsg -->
<s:property value="appDatamessaggioDinamico" escape="false" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_mbConfEliminaAccertamento --></div>

	
	<div id="p_cpConfEliminaAccertamento" class="commandPanelBlock"><!-- startFragment:p_cpConfEliminaAccertamento -->
	
	
<div class="commandPanel functional" id="cpConfEliminaAccertamento">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpDettaglioAccertamento','btAnnulla')" >

	



<!-- widget btAnnulla -->
<s:submit name="widg_btAnnulla" id="widg_btAnnulla" method="handleBtAnnulla_CLICKED"
	key="cpDettaglioAccertamento.btAnnulla.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioAccertamento','btAnnulla')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpDettaglioAccertamento','btConferma')" >

	



<!-- widget btConferma -->
<s:submit name="widg_btConferma" id="widg_btConferma" method="handleBtConferma_CLICKED"
	key="cpDettaglioAccertamento.btConferma.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioAccertamento','btConferma')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpConfEliminaAccertamento --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
