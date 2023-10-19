<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dlgPagamentoEsitoANOMALForm" action="cpEsitoPagamento" namespace="/base/esito_pagamento_bollini" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<h3><s:text name="cpEsitoPagamento.dlgPagamentoEsitoANOMAL.label" /></h3>
				<div class="dialogPanel" id="dlgPagamentoEsitoANOMAL">

		
		
<div id="p_pMsgPagANOMAL" class="msgBoxPanelBlock"><!-- startFragment:p_pMsgPagANOMAL -->

	
<div class="msgBoxPanel error" id="pMsgPagANOMAL">


		
<s:if test="isWidgetVisible('cpEsitoPagamento','txtMsgPagANOMAL1')" >

	
<p>


<!-- widget txtMsgPagANOMAL1 -->
<s:text name="cpEsitoPagamento.txtMsgPagANOMAL1.statictext.label" />

	
</p>

</s:if>

		
<s:if test="isWidgetVisible('cpEsitoPagamento','txtMsgPagANOMAL2')" >

	
<p>


<!-- widget txtMsgPagANOMAL2 -->
<s:text name="cpEsitoPagamento.txtMsgPagANOMAL2.statictext.label" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_pMsgPagANOMAL --></div>

	
	<div id="p_pCmdPagANOMAL" class="commandPanelBlock"><!-- startFragment:p_pCmdPagANOMAL -->
	
	
<div class="commandPanel navigation" id="pCmdPagANOMAL">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpEsitoPagamento','bHomeANOMAL')" >

	



<!-- widget bHomeANOMAL -->
<s:submit name="widg_bHomeANOMAL" id="widg_bHomeANOMAL" method="handleBHomeANOMAL_CLICKED"
	key="cpEsitoPagamento.bHomeANOMAL.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpEsitoPagamento','bHomeANOMAL')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pCmdPagANOMAL --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
