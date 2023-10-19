<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_sanzioni/CpDettaglioSanzioneAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_sanzioni -->
<!-- pageId:cpDettaglioSanzione -->

<s:form id="cpDettaglioSanzione" action="cpDettaglioSanzione" namespace="/base/gestisci_sanzioni" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpDettaglioSanzione_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpDettaglioSanzione','menu')" >

	


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
		
	
<h4 class="fpLabel"><s:text name="cpDettaglioSanzione.fpTitle.label" /></h4>
<div class="formPanel" id="fpTitle">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpTitle --></div>

			
	
	<div id="p_stdErrorMessageDettaglioSanzione" class="stdMessagePanelBlock"><!-- startFragment:p_stdErrorMessageDettaglioSanzione -->
	
	
<div class="stdMessagePanel" id="stdErrorMessageDettaglioSanzione">
	<customtag:stdMessagePanel id="stdErrorMessageDettaglioSanzione" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdErrorMessageDettaglioSanzione --></div>

			
	
	<div id="p_wpDettaglioSanzione" class="widgetsPanelBlock"><!-- startFragment:p_wpDettaglioSanzione -->
	
	
<h4 class="wpLabel">dettaglio sanzione </h4>
<div class="widgetsPanel" id="wpDettaglioSanzione">
	
	<customtag:widgetsPanel id="wpDettaglioSanzioneTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpDettaglioSanzione','ptId')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioSanzione.ptId.label')}" labelFor="widg_ptId" errorFor="appDatasanzione.idSanzione" labelId="ptIdLbl"   tdStyleClass="numbers">


<!-- widget ptId -->
<s:property value="appDatasanzione.idSanzione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioSanzione','ptDataCreazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioSanzione.ptDataCreazione.label')}" labelFor="widg_ptDataCreazione" errorFor="appDatasanzione.dataCreazione" labelId="ptDataCreazioneLbl"   >


<!-- widget ptDataCreazione -->
<s:property value="appDatasanzione.dataCreazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioSanzione','ptResponsabilePA')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioSanzione.ptResponsabilePA.label')}" labelFor="widg_ptResponsabilePA" errorFor="appDatasanzione.responsabilePA" labelId="ptResponsabilePALbl"   >


<!-- widget ptResponsabilePA -->
<s:property value="appDatasanzione.responsabilePA" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioSanzione','ptStato')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioSanzione.ptStato.label')}" labelFor="widg_ptStato" errorFor="appDatasanzione.descStatoSanzione" labelId="ptStatoLbl"   >


<!-- widget ptStato -->
<s:property value="appDatasanzione.descStatoSanzione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioSanzione','ptIdAccertamento')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioSanzione.ptIdAccertamento.label')}" labelFor="widg_ptIdAccertamento" errorFor="appDatasanzione.accertamentoAssociato" labelId="ptIdAccertamentoLbl"   >


<!-- widget ptIdAccertamento -->
<s:property value="appDatasanzione.accertamentoAssociato" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioSanzione','ptIdIspezione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioSanzione.ptIdIspezione.label')}" labelFor="widg_ptIdIspezione" errorFor="appDatasanzione.ispezioneAssociata" labelId="ptIdIspezioneLbl"   >


<!-- widget ptIdIspezione -->
<s:property value="appDatasanzione.ispezioneAssociata" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioSanzione','ptPersFis')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioSanzione.ptPersFis.label')}" labelFor="widg_ptPersFis" errorFor="appDatasanzione.pfSanzionata" labelId="ptPersFisLbl"   >


<!-- widget ptPersFis -->
<s:property value="appDatasanzione.pfSanzionata" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioSanzione','ptPersGiur')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioSanzione.ptPersGiur.label')}" labelFor="widg_ptPersGiur" errorFor="appDatasanzione.pgSanzionata" labelId="ptPersGiurLbl"   >


<!-- widget ptPersGiur -->
<s:property value="appDatasanzione.pgSanzionata" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioSanzione','ptMotivo')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioSanzione.ptMotivo.label')}" labelFor="widg_ptMotivo" errorFor="appDatasanzione.descMotivoSanzione" labelId="ptMotivoLbl"   >


<!-- widget ptMotivo -->
<s:property value="appDatasanzione.descMotivoSanzione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioSanzione','ptValore')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioSanzione.ptValore.label')}" labelFor="widg_ptValore" errorFor="appDatasanzione.valore" labelId="ptValoreLbl"   >


<!-- widget ptValore -->
<s:property value="appDatasanzione.valore" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioSanzione','ptDataNotifica')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioSanzione.ptDataNotifica.label')}" labelFor="widg_ptDataNotifica" errorFor="appDatasanzione.dataComunicazione" labelId="ptDataNotificaLbl"   >


<!-- widget ptDataNotifica -->
<s:property value="appDatasanzione.dataComunicazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioSanzione','ptDataPagamento')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioSanzione.ptDataPagamento.label')}" labelFor="widg_ptDataPagamento" errorFor="appDatasanzione.dataPagamento" labelId="ptDataPagamentoLbl"   >


<!-- widget ptDataPagamento -->
<s:property value="appDatasanzione.dataPagamento" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioSanzione','ptDataAnnullamento')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioSanzione.ptDataAnnullamento.label')}" labelFor="widg_ptDataAnnullamento" errorFor="appDatasanzione.dataAnnullamento" labelId="ptDataAnnullamentoLbl"   >


<!-- widget ptDataAnnullamento -->
<s:property value="appDatasanzione.dataAnnullamento" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioSanzione','ptMotivoAnnullamento')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioSanzione.ptMotivoAnnullamento.label')}" labelFor="widg_ptMotivoAnnullamento" errorFor="appDatasanzione.descMotivoAnnullamento" labelId="ptMotivoAnnullamentoLbl"   >


<!-- widget ptMotivoAnnullamento -->
<s:property value="appDatasanzione.descMotivoAnnullamento" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioSanzione','ptSveglia')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioSanzione.ptSveglia.label')}" labelFor="widg_ptSveglia" errorFor="appDatasanzione.descSveglia" labelId="ptSvegliaLbl"   >


<!-- widget ptSveglia -->
<s:property value="appDatasanzione.descSveglia" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioSanzione','taNote')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioSanzione.taNote.label')}" labelFor="widg_taNote" errorFor="appDatasanzione.note" labelId="taNoteLbl"
	  >


<!-- widget taNote -->
<s:textarea 
	
	
	name="appDatasanzione.note" id="widg_taNote"
	disabled="isWidgetDisabled('cpDettaglioSanzione','taNote')"
	rows="2"
	cols="30"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioSanzione','btnSalva')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget btnSalva -->
<s:submit name="widg_btnSalva" id="widg_btnSalva" method="handleBtnSalva_CLICKED"
	key="cpDettaglioSanzione.btnSalva.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioSanzione','btnSalva')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDettaglioSanzione --></div>

			
	
	<div id="p_wpAzioni" class="widgetsPanelBlock"><!-- startFragment:p_wpAzioni -->
	
	
<h4 class="wpLabel">azioni svolte </h4>
<div class="widgetsPanel" id="wpAzioni">
	

	
	
<s:if test="isWidgetVisible('cpDettaglioSanzione','tbAzioniSvolte')" >

	
<div class="tableWidget">


<!-- widget tbAzioniSvolte -->
<s:set name="cpDettaglioSanzione_tbAzioniSvolte_clearStatus" value="isTableClearStatus('cpDettaglioSanzione_tbAzioniSvolte')" />
<s:url id="cpDettaglioSanzioneViewUrl"						   
					   action="cpDettaglioSanzione"
					   namespace="/base/gestisci_sanzioni"/>
<display:table name="appDataelencoAzioni"  				
			   excludedParams="*"			   export="true"
               id="widg_tbAzioniSvolte"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpDettaglioSanzioneViewUrl}"  
               clearStatus="${cpDettaglioSanzione_tbAzioniSvolte_clearStatus}"
               uid="row_tbAzioniSvolte"
               summary="" 
decorator="it.csi.sigit.sigitwebn.presentation.decorator.gestisci_sanzioni.CpDettaglioSanzioneTbAzioniSvolteCustomDecorator"               class="dataTable">
	
		<display:column property="dataAzione" titleKey="cpDettaglioSanzione.tbAzioniSvolte.dataAzione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="dataAzione" titleKey="cpDettaglioSanzione.tbAzioniSvolte.dataAzione.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="dataAzione" titleKey="cpDettaglioSanzione.tbAzioniSvolte.dataAzione.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
		<display:column property="descrizioneUtente" titleKey="cpDettaglioSanzione.tbAzioniSvolte.descrizioneUtente.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="descrizioneUtente" titleKey="cpDettaglioSanzione.tbAzioniSvolte.descrizioneUtente.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="descrizioneUtente" titleKey="cpDettaglioSanzione.tbAzioniSvolte.descrizioneUtente.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
		<display:column property="descrizione" titleKey="cpDettaglioSanzione.tbAzioniSvolte.descrizione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="descrizione" titleKey="cpDettaglioSanzione.tbAzioniSvolte.descrizione.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="descrizione" titleKey="cpDettaglioSanzione.tbAzioniSvolte.descrizione.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
		<display:column property="nomeDoc" titleKey="cpDettaglioSanzione.tbAzioniSvolte.nomeDoc.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="nomeDoc" titleKey="cpDettaglioSanzione.tbAzioniSvolte.nomeDoc.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="nomeDoc" titleKey="cpDettaglioSanzione.tbAzioniSvolte.nomeDoc.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpAzioni --></div>

			
	
	<div id="p_cpFunDettaglioSanzione" class="commandPanelBlock"><!-- startFragment:p_cpFunDettaglioSanzione -->
	
	
<div class="commandPanel functional" id="cpFunDettaglioSanzione">

	
	
		
		
<s:if test="isWidgetVisible('cpDettaglioSanzione','btnInsAzione')" >

	



<!-- widget btnInsAzione -->
<s:submit name="widg_btnInsAzione" id="widg_btnInsAzione" method="handleBtnInsAzione_CLICKED"
	key="cpDettaglioSanzione.btnInsAzione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioSanzione','btnInsAzione')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpDettaglioSanzione','btnGestisciSveglia')" >

	



<!-- widget btnGestisciSveglia -->
<s:submit name="widg_btnGestisciSveglia" id="widg_btnGestisciSveglia" method="handleBtnGestisciSveglia_CLICKED"
	key="cpDettaglioSanzione.btnGestisciSveglia.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioSanzione','btnGestisciSveglia')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpDettaglioSanzione','btVisualizzaAccertamento')" >

	



<!-- widget btVisualizzaAccertamento -->
<s:submit name="widg_btVisualizzaAccertamento" id="widg_btVisualizzaAccertamento" method="handleBtVisualizzaAccertamento_CLICKED"
	key="cpDettaglioSanzione.btVisualizzaAccertamento.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioSanzione','btVisualizzaAccertamento')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpDettaglioSanzione','btVisualizzaIspezione')" >

	



<!-- widget btVisualizzaIspezione -->
<s:submit name="widg_btVisualizzaIspezione" id="widg_btVisualizzaIspezione" method="handleBtVisualizzaIspezione_CLICKED"
	key="cpDettaglioSanzione.btVisualizzaIspezione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioSanzione','btVisualizzaIspezione')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpDettaglioSanzione','btNotificaSanzione')" >

	



<!-- widget btNotificaSanzione -->
<s:submit name="widg_btNotificaSanzione" id="widg_btNotificaSanzione" method="handleBtNotificaSanzione_CLICKED"
	key="cpDettaglioSanzione.btNotificaSanzione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioSanzione','btNotificaSanzione')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpDettaglioSanzione','btPagaSanzione')" >

	



<!-- widget btPagaSanzione -->
<s:submit name="widg_btPagaSanzione" id="widg_btPagaSanzione" method="handleBtPagaSanzione_CLICKED"
	key="cpDettaglioSanzione.btPagaSanzione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioSanzione','btPagaSanzione')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpDettaglioSanzione','btAnnullaSanzione')" >

	



<!-- widget btAnnullaSanzione -->
<s:submit name="widg_btAnnullaSanzione" id="widg_btAnnullaSanzione" method="handleBtAnnullaSanzione_CLICKED"
	key="cpDettaglioSanzione.btAnnullaSanzione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioSanzione','btAnnullaSanzione')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpDettaglioSanzione','btAssegnaSanzione')" >

	



<!-- widget btAssegnaSanzione -->
<s:submit name="widg_btAssegnaSanzione" id="widg_btAssegnaSanzione" method="handleBtAssegnaSanzione_CLICKED"
	key="cpDettaglioSanzione.btAssegnaSanzione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioSanzione','btAssegnaSanzione')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cpFunDettaglioSanzione --></div>

			
	
	
	<div id="p_mpAzioniSanzione" class="panelBlock"><!-- startFragment:p_mpAzioniSanzione -->
		

		
<s:if test="#session.cpDettaglioSanzione_mpAzioniSanzione_selectedMultiPanel == 'cpDettaglioSanzione_mpAzioniSanzione_fpPagamento'">
	<s:include value="/jsp/multipanels/cpDettaglioSanzione_mpAzioniSanzione_fpPagamento.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.cpDettaglioSanzione_mpAzioniSanzione_selectedMultiPanel == 'cpDettaglioSanzione_mpAzioniSanzione_fpAssegnaA'">
	<s:include value="/jsp/multipanels/cpDettaglioSanzione_mpAzioniSanzione_fpAssegnaA.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.cpDettaglioSanzione_mpAzioniSanzione_selectedMultiPanel == 'cpDettaglioSanzione_mpAzioniSanzione_fpAnnullamento'">
	<s:include value="/jsp/multipanels/cpDettaglioSanzione_mpAzioniSanzione_fpAnnullamento.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpAzioniSanzione --></div>

			
	
	<div id="p_cpNavDettaglioSanzione" class="commandPanelBlock"><!-- startFragment:p_cpNavDettaglioSanzione -->
	
	
<div class="commandPanel navigation" id="cpNavDettaglioSanzione">

	
	
		
		
<s:if test="isWidgetVisible('cpDettaglioSanzione','btnIndietroDettaglioSanzione')" >

	



<!-- widget btnIndietroDettaglioSanzione -->
<s:submit name="widg_btnIndietroDettaglioSanzione" id="widg_btnIndietroDettaglioSanzione" method="handleBtnIndietroDettaglioSanzione_CLICKED"
	key="cpDettaglioSanzione.btnIndietroDettaglioSanzione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioSanzione','btnIndietroDettaglioSanzione')" />

	


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
