<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/esito_pagamento_bollini -->
<!-- pageId:cpEsitoPagamento -->

<s:form id="cpEsitoPagamento" action="cpEsitoPagamento" namespace="/base/esito_pagamento_bollini" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpEsitoPagamento_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpEsitoPagamento','menu')" >

	


	<s:include value="fragments/menu.jsp"></s:include>

	

</s:if>

	


		
	
	
</div>

	<!-- endFragment:p_menuPanel --></div>

	

	<!-- endFragment:p_fpUpUserInfo --></div>

		</div>
	</div>
	<!-- ================ FINE UDLRC Layout UP PANEL ================ -->


	<!-- ================ UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->
	<div id="centerWrapper" class="floatWrapper">


		<!-- ***** UDLRC Layout CENTER PANEL ***** -->
		<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
			<div class="wrapper">

					
	
	<div id="p_fpCenter" class="formPanelBlock"><!-- startFragment:p_fpCenter -->

	
	

	
	
			
	
	<div id="p_fpEsitoPagamento" class="formPanelBlock"><!-- startFragment:p_fpEsitoPagamento -->
		
	
<div class="formPanel" id="fpEsitoPagamento">


	
	

	
	
			
	
	<div id="p_stdMsgPEsitoPagamento" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgPEsitoPagamento -->
	
	
<div class="stdMessagePanel" id="stdMsgPEsitoPagamento">
	<customtag:stdMessagePanel id="stdMsgPEsitoPagamento" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgPEsitoPagamento --></div>

			
	
	<div id="p_pEsitoPagamento" class="widgetsPanelBlock"><!-- startFragment:p_pEsitoPagamento -->
	
	

<div class="widgetsPanel" id="pEsitoPagamento">
	
	<customtag:widgetsPanel id="pEsitoPagamentoTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpEsitoPagamento','hvPagamentoOK')" >

	
<div class="hidden">


<!-- widget hvPagamentoOK -->
<s:hidden name="widg_hvPagamentoOK" id="widg_hvPagamentoOK" />

	
</div>

</s:if>

	


	
<s:if test="isWidgetVisible('cpEsitoPagamento','hvPagamentoKO')" >

	
<div class="hidden">


<!-- widget hvPagamentoKO -->
<s:hidden name="widg_hvPagamentoKO" id="widg_hvPagamentoKO" />

	
</div>

</s:if>

	


	
<s:if test="isWidgetVisible('cpEsitoPagamento','hvPagamentoABORT')" >

	
<div class="hidden">


<!-- widget hvPagamentoABORT -->
<s:hidden name="widg_hvPagamentoABORT" id="widg_hvPagamentoABORT" />

	
</div>

</s:if>

	


	
<s:if test="isWidgetVisible('cpEsitoPagamento','hvPagamentoANOMAL')" >

	
<div class="hidden">


<!-- widget hvPagamentoANOMAL -->
<s:hidden name="widg_hvPagamentoANOMAL" id="widg_hvPagamentoANOMAL" />

	
</div>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pEsitoPagamento --></div>

	

		
	
</div>

	<!-- endFragment:p_fpEsitoPagamento --></div>

	

	<!-- endFragment:p_fpCenter --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout CENTER PANEL ***** -->



	</div>
	<!-- ================ FINE UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->



</div>
<!-- #################### FINE PANNELLO CONTENUTI #################### -->




</s:form>


	<s:include value="fragments/footer.jsp" ></s:include>
