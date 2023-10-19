<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_sanzioni/CpInserisciNotificaSanzioneAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_sanzioni -->
<!-- pageId:cpInserisciNotificaSanzione -->

<s:form id="cpInserisciNotificaSanzione" action="cpInserisciNotificaSanzione" namespace="/base/gestisci_sanzioni" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpInserisciNotificaSanzione_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpInserisciNotificaSanzione','menu')" >

	


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

	
	

	
	
			
	
	<div id="p_fpTitle" class="formPanelBlock"><!-- startFragment:p_fpTitle -->
		
	
<h4 class="fpLabel"><s:text name="cpInserisciNotificaSanzione.fpTitle.label" /></h4>
<div class="formPanel" id="fpTitle">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpTitle --></div>

			
	
	<div id="p_stdErrorMessageInserisciNotificaSanzione" class="stdMessagePanelBlock"><!-- startFragment:p_stdErrorMessageInserisciNotificaSanzione -->
	
	
<div class="stdMessagePanel" id="stdErrorMessageInserisciNotificaSanzione">
	<customtag:stdMessagePanel id="stdErrorMessageInserisciNotificaSanzione" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdErrorMessageInserisciNotificaSanzione --></div>

			
	
	<div id="p_wpInserisciSanzione" class="widgetsPanelBlock"><!-- startFragment:p_wpInserisciSanzione -->
	
	
<h4 class="wpLabel">gestisci sanzione </h4>
<div class="widgetsPanel" id="wpInserisciSanzione">
	
	<customtag:widgetsPanel id="wpInserisciSanzioneTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpInserisciNotificaSanzione','ptId')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpInserisciNotificaSanzione.ptId.label')}" labelFor="widg_ptId" errorFor="appDatadatiInserimentoSanzione.idSanzione" labelId="ptIdLbl"   tdStyleClass="numbers">


<!-- widget ptId -->
<s:property value="appDatadatiInserimentoSanzione.idSanzione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpInserisciNotificaSanzione','ptDataCreazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpInserisciNotificaSanzione.ptDataCreazione.label')}" labelFor="widg_ptDataCreazione" errorFor="appDatadatiInserimentoSanzione.dataCreazione" labelId="ptDataCreazioneLbl"   >


<!-- widget ptDataCreazione -->
<s:property value="appDatadatiInserimentoSanzione.dataCreazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpInserisciNotificaSanzione','ptResponsabilePA')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpInserisciNotificaSanzione.ptResponsabilePA.label')}" labelFor="widg_ptResponsabilePA" errorFor="appDatadatiInserimentoSanzione.responsabilePA" labelId="ptResponsabilePALbl"   >


<!-- widget ptResponsabilePA -->
<s:property value="appDatadatiInserimentoSanzione.responsabilePA" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpInserisciNotificaSanzione','ptIdAccertamento')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpInserisciNotificaSanzione.ptIdAccertamento.label')}" labelFor="widg_ptIdAccertamento" errorFor="appDatadatiInserimentoSanzione.accertamentoAssociato" labelId="ptIdAccertamentoLbl"   >


<!-- widget ptIdAccertamento -->
<s:property value="appDatadatiInserimentoSanzione.accertamentoAssociato" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpInserisciNotificaSanzione','ptIdIspezione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpInserisciNotificaSanzione.ptIdIspezione.label')}" labelFor="widg_ptIdIspezione" errorFor="appDatadatiInserimentoSanzione.ispezioneAssociata" labelId="ptIdIspezioneLbl"   >


<!-- widget ptIdIspezione -->
<s:property value="appDatadatiInserimentoSanzione.ispezioneAssociata" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpInserisciNotificaSanzione','taMotivoSanzione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciNotificaSanzione.taMotivoSanzione.label')}" labelFor="widg_taMotivoSanzione" errorFor="appDatadatiInserimentoSanzione.motivoSanzione" labelId="taMotivoSanzioneLbl"
	  >


<!-- widget taMotivoSanzione -->
<s:textarea 
	
	
	name="appDatadatiInserimentoSanzione.motivoSanzione" id="widg_taMotivoSanzione"
	disabled="isWidgetDisabled('cpInserisciNotificaSanzione','taMotivoSanzione')"
	rows="2"
	cols="30"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpInserisciNotificaSanzione','tfValoreSanzione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciNotificaSanzione.tfValoreSanzione.label')}" labelFor="widg_tfValoreSanzione" errorFor="appDatadatiInserimentoSanzione.valore" labelId="tfValoreSanzioneLbl"
	  >


<!-- widget tfValoreSanzione -->
<s:textfield 
	
	
	name="appDatadatiInserimentoSanzione.valore" id="widg_tfValoreSanzione"
	disabled="isWidgetDisabled('cpInserisciNotificaSanzione','tfValoreSanzione')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpInserisciNotificaSanzione','taNote')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciNotificaSanzione.taNote.label')}" labelFor="widg_taNote" errorFor="appDatadatiInserimentoSanzione.note" labelId="taNoteLbl"
	  >


<!-- widget taNote -->
<s:textarea 
	
	
	name="appDatadatiInserimentoSanzione.note" id="widg_taNote"
	disabled="isWidgetDisabled('cpInserisciNotificaSanzione','taNote')"
	rows="2"
	cols="30"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpInserisciSanzione --></div>

			
	
	
	<div id="p_mpSanzionati" class="panelBlock"><!-- startFragment:p_mpSanzionati -->
		

		
<s:if test="#session.cpInserisciNotificaSanzione_mpSanzionati_selectedMultiPanel == 'cpInserisciNotificaSanzione_mpSanzionati_fpSanzionato'">
	<s:include value="/jsp/multipanels/cpInserisciNotificaSanzione_mpSanzionati_fpSanzionato.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.cpInserisciNotificaSanzione_mpSanzionati_selectedMultiPanel == 'cpInserisciNotificaSanzione_mpSanzionati_fpElencoSanzionati'">
	<s:include value="/jsp/multipanels/cpInserisciNotificaSanzione_mpSanzionati_fpElencoSanzionati.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpSanzionati --></div>

			
	
	<div id="p_cpFunDettaglioSanzione" class="commandPanelBlock"><!-- startFragment:p_cpFunDettaglioSanzione -->
	
	
<div class="commandPanel functional" id="cpFunDettaglioSanzione">

	
	
		
		
<s:if test="isWidgetVisible('cpInserisciNotificaSanzione','btSalvaSanzione')" >

	



<!-- widget btSalvaSanzione -->
<s:submit name="widg_btSalvaSanzione" id="widg_btSalvaSanzione" method="handleBtSalvaSanzione_CLICKED"
	key="cpInserisciNotificaSanzione.btSalvaSanzione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpInserisciNotificaSanzione','btSalvaSanzione')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cpFunDettaglioSanzione --></div>

			
	
	<div id="p_cpNavDettaglioSanzione" class="commandPanelBlock"><!-- startFragment:p_cpNavDettaglioSanzione -->
	
	
<div class="commandPanel navigation" id="cpNavDettaglioSanzione">

	
	
		
		
<s:if test="isWidgetVisible('cpInserisciNotificaSanzione','btIndietro')" >

	



<!-- widget btIndietro -->
<s:submit name="widg_btIndietro" id="widg_btIndietro" method="handleBtIndietro_CLICKED"
	key="cpInserisciNotificaSanzione.btIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpInserisciNotificaSanzione','btIndietro')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cpNavDettaglioSanzione --></div>

	

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
