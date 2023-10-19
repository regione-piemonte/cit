<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_accertamento -->
<!-- pageId:cpDettaglioAccertamentoConf -->

<s:form id="cpDettaglioAccertamentoConf" action="cpDettaglioAccertamentoConf" namespace="/base/gestisci_accertamento" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpDettaglioAccertamentoConf_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpDettaglioAccertamentoConf','menu')" >

	


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

	
	

	
	
			
	
	<div id="p_fpConfermaAccertamento" class="formPanelBlock"><!-- startFragment:p_fpConfermaAccertamento -->
		
	


	
	

	
	
			
	
	<div id="p_fpTitle" class="formPanelBlock"><!-- startFragment:p_fpTitle -->
		
	
<h4 class="fpLabel"><s:text name="cpDettaglioAccertamentoConf.fpTitle.label" /></h4>
<div class="formPanel" id="fpTitle">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpTitle --></div>

			
	
	<div id="p_stdMsg" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsg -->
	
	
<div class="stdMessagePanel" id="stdMsg">
	<customtag:stdMessagePanel id="stdMsg" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsg --></div>

			
	
	<div id="p_wpAccertamento" class="widgetsPanelBlock"><!-- startFragment:p_wpAccertamento -->
	
	
<h4 class="wpLabel">conferma accertamento </h4>
<div class="widgetsPanel" id="wpAccertamento">
	
	<customtag:widgetsPanel id="wpAccertamentoTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpDettaglioAccertamentoConf','ptAccertNumero')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioAccertamentoConf.ptAccertNumero.label')}" labelFor="widg_ptAccertNumero" errorFor="appDataaccertamento.identificativo" labelId="ptAccertNumeroLbl"   >


<!-- widget ptAccertNumero -->
<s:property value="appDataaccertamento.identificativo" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioAccertamentoConf','ptDataCreazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioAccertamentoConf.ptDataCreazione.label')}" labelFor="widg_ptDataCreazione" errorFor="appDataaccertamento.dataCreazione" labelId="ptDataCreazioneLbl"   >


<!-- widget ptDataCreazione -->
<s:property value="appDataaccertamento.dataCreazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioAccertamentoConf','ptProvComp')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioAccertamentoConf.ptProvComp.label')}" labelFor="widg_ptProvComp" errorFor="appDataaccertamento.siglaProv" labelId="ptProvCompLbl"   >


<!-- widget ptProvComp -->
<s:property value="appDataaccertamento.siglaProv" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioAccertamentoConf','ptAssegnatario')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioAccertamentoConf.ptAssegnatario.label')}" labelFor="widg_ptAssegnatario" errorFor="appDataaccertamento.assegnatario" labelId="ptAssegnatarioLbl"   >


<!-- widget ptAssegnatario -->
<s:property value="appDataaccertamento.assegnatario" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioAccertamentoConf','ptCodImp')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioAccertamentoConf.ptCodImp.label')}" labelFor="widg_ptCodImp" errorFor="appDataaccertamento.codiceImpianto" labelId="ptCodImpLbl"   >


<!-- widget ptCodImp -->
<s:property value="appDataaccertamento.codiceImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioAccertamentoConf','ptIndirizzo')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="" labelFor="widg_ptIndirizzo" errorFor="appDataaccertamento.indirizzoImpianto" labelId="ptIndirizzoLbl"   >


<!-- widget ptIndirizzo -->
<s:property value="appDataaccertamento.indirizzoImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioAccertamentoConf','ptTipoAnomalia')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioAccertamentoConf.ptTipoAnomalia.label')}" labelFor="widg_ptTipoAnomalia" errorFor="appDataaccertamento.descTipoAnomalia" labelId="ptTipoAnomaliaLbl"   >


<!-- widget ptTipoAnomalia -->
<s:property value="appDataaccertamento.descTipoAnomalia" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAccertamento --></div>

			
	
	
	<div id="p_mpConcludiAcc" class="panelBlock"><!-- startFragment:p_mpConcludiAcc -->
		

		
<s:if test="#session.cpDettaglioAccertamentoConf_mpConcludiAcc_selectedMultiPanel == 'cpDettaglioAccertamentoConf_mpConcludiAcc_fpConcludiAcc'">
	<s:include value="/jsp/multipanels/cpDettaglioAccertamentoConf_mpConcludiAcc_fpConcludiAcc.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.cpDettaglioAccertamentoConf_mpConcludiAcc_selectedMultiPanel == 'cpDettaglioAccertamentoConf_mpConcludiAcc_fpAssociaAcc'">
	<s:include value="/jsp/multipanels/cpDettaglioAccertamentoConf_mpConcludiAcc_fpAssociaAcc.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.cpDettaglioAccertamentoConf_mpConcludiAcc_selectedMultiPanel == 'cpDettaglioAccertamentoConf_mpConcludiAcc_fpAssociaCodImp'">
	<s:include value="/jsp/multipanels/cpDettaglioAccertamentoConf_mpConcludiAcc_fpAssociaCodImp.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpConcludiAcc --></div>

			
	
	<div id="p_cpNav" class="commandPanelBlock"><!-- startFragment:p_cpNav -->
	
	
<div class="commandPanel navigation" id="cpNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpDettaglioAccertamentoConf','btIndietro')" >

	



<!-- widget btIndietro -->
<s:submit name="widg_btIndietro" id="widg_btIndietro" method="handleBtIndietro_CLICKED"
	key="cpDettaglioAccertamentoConf.btIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioAccertamentoConf','btIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNav --></div>

	

		
	

	<!-- endFragment:p_fpConfermaAccertamento --></div>

	

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
