<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_accertamento -->
<!-- pageId:cpGestAccertamento -->

<s:form id="cpGestAccertamento" action="cpGestAccertamento" namespace="/base/gestisci_accertamento" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestAccertamento_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpGestAccertamento','menu')" >

	


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

	
	

	
	
			
	
	<div id="p_fpInserisciAccertamento" class="formPanelBlock"><!-- startFragment:p_fpInserisciAccertamento -->
		
	
<h4 class="fpLabel"><s:text name="cpGestAccertamento.fpInserisciAccertamento.label" /></h4>
<div class="formPanel" id="fpInserisciAccertamento">


	
	

	
	
			
	
	<div id="p_stdMsg" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsg -->
	
	
<div class="stdMessagePanel" id="stdMsg">
	<customtag:stdMessagePanel id="stdMsg" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsg --></div>

			
	
	<div id="p_wpAccertamento" class="widgetsPanelBlock"><!-- startFragment:p_wpAccertamento -->
	
	
<h4 class="wpLabel">inserisci accertamento </h4>
<div class="widgetsPanel" id="wpAccertamento">
	
	<customtag:widgetsPanel id="wpAccertamentoTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestAccertamento','ptAccertNumero')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestAccertamento.ptAccertNumero.label')}" labelFor="widg_ptAccertNumero" errorFor="appDataaccertamento.identificativo" labelId="ptAccertNumeroLbl"   >


<!-- widget ptAccertNumero -->
<s:property value="appDataaccertamento.identificativo" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestAccertamento','ptDataCreazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestAccertamento.ptDataCreazione.label')}" labelFor="widg_ptDataCreazione" errorFor="appDataaccertamento.dataCreazione" labelId="ptDataCreazioneLbl"   >


<!-- widget ptDataCreazione -->
<s:property value="appDataaccertamento.dataCreazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestAccertamento','cbProvComp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestAccertamento.cbProvComp.label')}" labelFor="widg_cbProvComp" errorFor="appDataaccertamento.codIstatProv" labelId="cbProvCompLbl"
	  >


<!-- widget cbProvComp -->
	<csiuicore:ajaxify id="p_wpAccertamento" 
		widgetType="combo" 
		requestUri="/sigitwebn/base/gestisci_accertamento/cpGestAccertamento!handleCbProvComp_VALUE_CHANGED.do"
		pageId="cpGestAccertamento"
		formName="cpGestAccertamento"
		javascriptDetection="false"
		nameSpace="/base/gestisci_accertamento">

<s:url id="widg_cbProvCompurlComboBoxValueChange"
   action="/sigitwebn/cpGestAccertamento!handleCbProvComp_VALUE_CHANGED" namespace="/base/gestisci_accertamento"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataaccertamento.codIstatProv" id="widg_cbProvComp"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoProvincePiemonteIstat"
	  disabled="isWidgetDisabled('cpGestAccertamento','cbProvComp')"
	  listKey="code"
	  listValue="description"
	  onclick="onCBClick(this,'confermacbProvComp','conferma','%{widg_cbProvCompurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbProvComp','conferma','%{widg_cbProvCompurlComboBoxValueChange}')" 
	  />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestAccertamento','cbComComp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestAccertamento.cbComComp.label')}" labelFor="widg_cbComComp" errorFor="appDataaccertamento.codIstatCom" labelId="cbComCompLbl"
	  >


<!-- widget cbComComp -->
<s:select name="appDataaccertamento.codIstatCom" id="widg_cbComComp"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoComuniPiemonteIstat"
	  disabled="isWidgetDisabled('cpGestAccertamento','cbComComp')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestAccertamento','ptAssegnatario')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestAccertamento.ptAssegnatario.label')}" labelFor="widg_ptAssegnatario" errorFor="appDataaccertamento.assegnatario" labelId="ptAssegnatarioLbl"   >


<!-- widget ptAssegnatario -->
<s:property value="appDataaccertamento.assegnatario" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestAccertamento','ptCodImp')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestAccertamento.ptCodImp.label')}" labelFor="widg_ptCodImp" errorFor="appDataaccertamento.codiceImpianto" labelId="ptCodImpLbl"   >


<!-- widget ptCodImp -->
<s:property value="appDataaccertamento.codiceImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestAccertamento','ptIndirizzo')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="" labelFor="widg_ptIndirizzo" errorFor="appDataaccertamento.indirizzoImpianto" labelId="ptIndirizzoLbl"   >


<!-- widget ptIndirizzo -->
<s:property value="appDataaccertamento.indirizzoImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestAccertamento','cbTipoAnomalia')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestAccertamento.cbTipoAnomalia.label')}" labelFor="widg_cbTipoAnomalia" errorFor="appDataaccertamento.idTipoAnomalia" labelId="cbTipoAnomaliaLbl"
	  >


<!-- widget cbTipoAnomalia -->
<s:select name="appDataaccertamento.idTipoAnomalia" id="widg_cbTipoAnomalia"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTipoAnomalie"
	  disabled="isWidgetDisabled('cpGestAccertamento','cbTipoAnomalia')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestAccertamento','taNote')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestAccertamento.taNote.label')}" labelFor="widg_taNote" errorFor="appDataaccertamento.note" labelId="taNoteLbl"
	  >


<!-- widget taNote -->
<s:textarea 
	
	
	name="appDataaccertamento.note" id="widg_taNote"
	disabled="isWidgetDisabled('cpGestAccertamento','taNote')"
	rows="2"
	cols="100"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAccertamento --></div>

			
	
	<div id="p_cpFun" class="commandPanelBlock"><!-- startFragment:p_cpFun -->
	
	
<div class="commandPanel functional" id="cpFun">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestAccertamento','btSalva')" >

	



<!-- widget btSalva -->
<s:submit name="widg_btSalva" id="widg_btSalva" method="handleBtSalva_CLICKED"
	key="cpGestAccertamento.btSalva.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestAccertamento','btSalva')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFun --></div>

			
	
	<div id="p_cpNav" class="commandPanelBlock"><!-- startFragment:p_cpNav -->
	
	
<div class="commandPanel navigation" id="cpNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestAccertamento','btIndietro')" >

	



<!-- widget btIndietro -->
<s:submit name="widg_btIndietro" id="widg_btIndietro" method="handleBtIndietro_CLICKED"
	key="cpGestAccertamento.btIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestAccertamento','btIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNav --></div>

	

		
	
</div>

	<!-- endFragment:p_fpInserisciAccertamento --></div>

	

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
