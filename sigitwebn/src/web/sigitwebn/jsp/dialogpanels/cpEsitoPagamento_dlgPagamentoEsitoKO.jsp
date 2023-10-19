<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dlgPagamentoEsitoKOForm" action="cpEsitoPagamento" namespace="/base/esito_pagamento_bollini" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<h3><s:text name="cpEsitoPagamento.dlgPagamentoEsitoKO.label" /></h3>
				<div class="dialogPanel" id="dlgPagamentoEsitoKO">

		
		
<div id="p_pMsgPagKO" class="msgBoxPanelBlock"><!-- startFragment:p_pMsgPagKO -->

	
<div class="msgBoxPanel error" id="pMsgPagKO">


		
<s:if test="isWidgetVisible('cpEsitoPagamento','txtMsgPagKO1')" >

	
<p>


<!-- widget txtMsgPagKO1 -->
<s:text name="cpEsitoPagamento.txtMsgPagKO1.statictext.label" />

	
</p>

</s:if>

		
<s:if test="isWidgetVisible('cpEsitoPagamento','txtMsgPagKO2')" >

	
<p>


<!-- widget txtMsgPagKO2 -->
<s:text name="cpEsitoPagamento.txtMsgPagKO2.statictext.label" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_pMsgPagKO --></div>

	
	<div id="p_pCmdPagKO" class="commandPanelBlock"><!-- startFragment:p_pCmdPagKO -->
	
	
<div class="commandPanel navigation" id="pCmdPagKO">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpEsitoPagamento','bHomeKO')" >

	



<!-- widget bHomeKO -->
<s:submit name="widg_bHomeKO" id="widg_bHomeKO" method="handleBHomeKO_CLICKED"
	key="cpEsitoPagamento.bHomeKO.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpEsitoPagamento','bHomeKO')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pCmdPagKO --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
