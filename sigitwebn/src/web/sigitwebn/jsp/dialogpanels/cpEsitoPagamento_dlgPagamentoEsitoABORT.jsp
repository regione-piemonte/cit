<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dlgPagamentoEsitoABORTForm" action="cpEsitoPagamento" namespace="/base/esito_pagamento_bollini" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<h3><s:text name="cpEsitoPagamento.dlgPagamentoEsitoABORT.label" /></h3>
				<div class="dialogPanel" id="dlgPagamentoEsitoABORT">

		
		
<div id="p_pMsgPagABORT" class="msgBoxPanelBlock"><!-- startFragment:p_pMsgPagABORT -->

	
<div class="msgBoxPanel error" id="pMsgPagABORT">


		
<s:if test="isWidgetVisible('cpEsitoPagamento','txtMsgPagABORT')" >

	
<p>


<!-- widget txtMsgPagABORT -->
<s:text name="cpEsitoPagamento.txtMsgPagABORT.statictext.label" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_pMsgPagABORT --></div>

	
	<div id="p_pCmdPagABORT" class="commandPanelBlock"><!-- startFragment:p_pCmdPagABORT -->
	
	
<div class="commandPanel navigation" id="pCmdPagABORT">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpEsitoPagamento','bHomeABORT')" >

	



<!-- widget bHomeABORT -->
<s:submit name="widg_bHomeABORT" id="widg_bHomeABORT" method="handleBHomeABORT_CLICKED"
	key="cpEsitoPagamento.bHomeABORT.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpEsitoPagamento','bHomeABORT')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pCmdPagABORT --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
