<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/paga_bollini -->
<!-- pageId:cpPagaBollini -->

<s:form id="cpPagaBollini" action="cpPagaBollini" namespace="/base/paga_bollini" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpPagaBollini_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpPagaBollini','menu')" >

	


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

	
	

	
	
			
	
	<div id="p_fpPagaBollini" class="formPanelBlock"><!-- startFragment:p_fpPagaBollini -->
		
	
<div class="formPanel" id="fpPagaBollini">


	
	

	
	
			
	
	<div id="p_stdMsgPPagaBol" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgPPagaBol -->
	
	
<div class="stdMessagePanel" id="stdMsgPPagaBol">
	<customtag:stdMessagePanel id="stdMsgPPagaBol" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgPPagaBol --></div>

			
	
	<div id="p_wpPagaBollini" class="widgetsPanelBlock"><!-- startFragment:p_wpPagaBollini -->
	
	

<div class="widgetsPanel" id="wpPagaBollini">
	
	<customtag:widgetsPanel id="wpPagaBolliniTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpPagaBollini','cbGestModPagamento')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpPagaBollini.cbGestModPagamento.label')}" labelFor="widg_cbGestModPagamento" errorFor="appDatadatiPagamento.idGestorePagamento" labelId="cbGestModPagamentoLbl"
	  >


<!-- widget cbGestModPagamento -->
<s:select name="appDatadatiPagamento.idGestorePagamento" id="widg_cbGestModPagamento"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoGestoriPagamento"
	  disabled="isWidgetDisabled('cpPagaBollini','cbGestModPagamento')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpPagaBollini','ptImporto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpPagaBollini.ptImporto.label')}" labelFor="widg_ptImporto" errorFor="appDatadatiPagamento.importo" labelId="ptImportoLbl"   >


<!-- widget ptImporto -->
<s:property value="appDatadatiPagamento.importo" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpPagaBollini','ptDataValuta')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpPagaBollini.ptDataValuta.label')}" labelFor="widg_ptDataValuta" errorFor="appDatadatiPagamento.dataValuta" labelId="ptDataValutaLbl"   >


<!-- widget ptDataValuta -->
<s:property value="appDatadatiPagamento.dataValuta" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpPagaBollini','ptCausale')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpPagaBollini.ptCausale.label')}" labelFor="widg_ptCausale" errorFor="appDatadatiPagamento.causale" labelId="ptCausaleLbl"   >


<!-- widget ptCausale -->
<s:property value="appDatadatiPagamento.causale" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpPagaBollini','ptModPagamento')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpPagaBollini.ptModPagamento.label')}" labelFor="widg_ptModPagamento" errorFor="appDatadatiPagamento.descMetodoPagamento" labelId="ptModPagamentoLbl"   >


<!-- widget ptModPagamento -->
<s:property value="appDatadatiPagamento.descMetodoPagamento" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpPagaBollini --></div>

			
	
	<div id="p_cpNavPagaBollini" class="commandPanelBlock"><!-- startFragment:p_cpNavPagaBollini -->
	
	
<div class="commandPanel navigation" id="cpNavPagaBollini">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpPagaBollini','btAnnulla')" >

	



<!-- widget btAnnulla -->
<s:submit name="widg_btAnnulla" id="widg_btAnnulla" method="handleBtAnnulla_CLICKED"
	key="cpPagaBollini.btAnnulla.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpPagaBollini','btAnnulla')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpPagaBollini','btConferma')" >

	



<!-- widget btConferma -->
<s:submit name="widg_btConferma" id="widg_btConferma" method="handleBtConferma_CLICKED"
	key="cpPagaBollini.btConferma.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpPagaBollini','btConferma')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavPagaBollini --></div>

	

		
	
</div>

	<!-- endFragment:p_fpPagaBollini --></div>

	

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
