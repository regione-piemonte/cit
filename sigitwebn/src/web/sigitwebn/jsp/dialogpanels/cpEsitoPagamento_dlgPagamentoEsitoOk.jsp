<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dlgPagamentoEsitoOkForm" action="cpEsitoPagamento" namespace="/base/esito_pagamento_bollini" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<h3><s:text name="cpEsitoPagamento.dlgPagamentoEsitoOk.label" /></h3>
				<div class="dialogPanel" id="dlgPagamentoEsitoOk">

		
		
<div id="p_pMsgPagOK" class="msgBoxPanelBlock"><!-- startFragment:p_pMsgPagOK -->

	
<div class="msgBoxPanel info" id="pMsgPagOK">


		
<s:if test="isWidgetVisible('cpEsitoPagamento','txtMsgPagOK')" >

	
<p>


<!-- widget txtMsgPagOK -->
<s:property value="appDatamsgPagamento" escape="false" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_pMsgPagOK --></div>

	
	<div id="p_pCmdPagOK" class="commandPanelBlock"><!-- startFragment:p_pCmdPagOK -->
	
	
<div class="commandPanel navigation" id="pCmdPagOK">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpEsitoPagamento','bStampaRicevutaPag')" >

	



<!-- widget bStampaRicevutaPag -->
<s:submit name="widg_bStampaRicevutaPag" id="widg_bStampaRicevutaPag" method="handleBStampaRicevutaPag_CLICKED"
	key="cpEsitoPagamento.bStampaRicevutaPag.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpEsitoPagamento','bStampaRicevutaPag')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpEsitoPagamento','bHomeOK')" >

	



<!-- widget bHomeOK -->
<s:submit name="widg_bHomeOK" id="widg_bHomeOK" method="handleBHomeOK_CLICKED"
	key="cpEsitoPagamento.bHomeOK.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpEsitoPagamento','bHomeOK')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pCmdPagOK --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
