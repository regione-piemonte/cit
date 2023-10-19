<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_accertamento/CpDettaglioAccertamentoAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_accertamento -->
<!-- pageId:cpDettaglioAccertamento -->

<s:form id="cpDettaglioAccertamento" action="cpDettaglioAccertamento" namespace="/base/gestisci_accertamento" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpDettaglioAccertamento_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpDettaglioAccertamento','menu')" >

	


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

	
	

	
	
			
	
	<div id="p_fpDettaglioAccertamento2" class="formPanelBlock"><!-- startFragment:p_fpDettaglioAccertamento2 -->
		
	
<h4 class="fpLabel"><s:text name="cpDettaglioAccertamento.fpDettaglioAccertamento2.label" /></h4>
<div class="formPanel" id="fpDettaglioAccertamento2">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpDettaglioAccertamento2 --></div>

			
	
	<div id="p_stdMsg" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsg -->
	
	
<div class="stdMessagePanel" id="stdMsg">
	<customtag:stdMessagePanel id="stdMsg" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsg --></div>

			
	
	<div id="p_wpAccertamento" class="widgetsPanelBlock"><!-- startFragment:p_wpAccertamento -->
	
	
<h4 class="wpLabel">dettaglio accertamento </h4>
<div class="widgetsPanel" id="wpAccertamento">
	
	<customtag:widgetsPanel id="wpAccertamentoTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpDettaglioAccertamento','ptAccertNumero')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioAccertamento.ptAccertNumero.label')}" labelFor="widg_ptAccertNumero" errorFor="appDataaccertamento.identificativo" labelId="ptAccertNumeroLbl"   >


<!-- widget ptAccertNumero -->
<s:property value="appDataaccertamento.identificativo" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioAccertamento','ptDataCreazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioAccertamento.ptDataCreazione.label')}" labelFor="widg_ptDataCreazione" errorFor="appDataaccertamento.dataCreazione" labelId="ptDataCreazioneLbl"   >


<!-- widget ptDataCreazione -->
<s:property value="appDataaccertamento.dataCreazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioAccertamento','ptProvComp')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioAccertamento.ptProvComp.label')}" labelFor="widg_ptProvComp" errorFor="appDataaccertamento.siglaProv" labelId="ptProvCompLbl"   >


<!-- widget ptProvComp -->
<s:property value="appDataaccertamento.siglaProv" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioAccertamento','ptComComp')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioAccertamento.ptComComp.label')}" labelFor="widg_ptComComp" errorFor="appDataaccertamento.denomComune" labelId="ptComCompLbl"   >


<!-- widget ptComComp -->
<s:property value="appDataaccertamento.denomComune" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioAccertamento','ptAssegnatario')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioAccertamento.ptAssegnatario.label')}" labelFor="widg_ptAssegnatario" errorFor="appDataaccertamento.assegnatario" labelId="ptAssegnatarioLbl"   >


<!-- widget ptAssegnatario -->
<s:property value="appDataaccertamento.assegnatario" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioAccertamento','ptStato')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioAccertamento.ptStato.label')}" labelFor="widg_ptStato" errorFor="appDataaccertamento.descStatoAccertamento" labelId="ptStatoLbl"   >


<!-- widget ptStato -->
<s:property value="appDataaccertamento.descStatoAccertamento" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioAccertamento','ptCodImp')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioAccertamento.ptCodImp.label')}" labelFor="widg_ptCodImp" errorFor="appDataaccertamento.codiceImpianto" labelId="ptCodImpLbl"   >


<!-- widget ptCodImp -->
<s:property value="appDataaccertamento.codiceImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioAccertamento','ptIndirizzo')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="" labelFor="widg_ptIndirizzo" errorFor="appDataaccertamento.indirizzoImpianto" labelId="ptIndirizzoLbl"   >


<!-- widget ptIndirizzo -->
<s:property value="appDataaccertamento.indirizzoImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioAccertamento','ptDataConclusione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioAccertamento.ptDataConclusione.label')}" labelFor="widg_ptDataConclusione" errorFor="appDataaccertamento.dataConclusione" labelId="ptDataConclusioneLbl"   >


<!-- widget ptDataConclusione -->
<s:property value="appDataaccertamento.dataConclusione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioAccertamento','ptTipoConclusione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioAccertamento.ptTipoConclusione.label')}" labelFor="widg_ptTipoConclusione" errorFor="appDataaccertamento.descTipoConclusione" labelId="ptTipoConclusioneLbl"   >


<!-- widget ptTipoConclusione -->
<s:property value="appDataaccertamento.descTipoConclusione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioAccertamento','cbTipoAnomalia')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioAccertamento.cbTipoAnomalia.label')}" labelFor="widg_cbTipoAnomalia" errorFor="appDataaccertamento.idTipoAnomalia" labelId="cbTipoAnomaliaLbl"
	  >


<!-- widget cbTipoAnomalia -->
<s:select name="appDataaccertamento.idTipoAnomalia" id="widg_cbTipoAnomalia"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTipoAnomalie"
	  disabled="isWidgetDisabled('cpDettaglioAccertamento','cbTipoAnomalia')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioAccertamento','ptSveglia')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioAccertamento.ptSveglia.label')}" labelFor="widg_ptSveglia" errorFor="appDataaccertamento.descrizioneSveglia" labelId="ptSvegliaLbl"   >


<!-- widget ptSveglia -->
<s:property value="appDataaccertamento.descrizioneSveglia" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioAccertamento','taNote')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioAccertamento.taNote.label')}" labelFor="widg_taNote" errorFor="appDataaccertamento.note" labelId="taNoteLbl"
	  >


<!-- widget taNote -->
<s:textarea 
	
	
	name="appDataaccertamento.note" id="widg_taNote"
	disabled="isWidgetDisabled('cpDettaglioAccertamento','taNote')"
	rows="2"
	cols="100"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAccertamento --></div>

			
	
	<div id="p_cpSalva" class="commandPanelBlock"><!-- startFragment:p_cpSalva -->
	
	
<div class="commandPanel functional" id="cpSalva">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpDettaglioAccertamento','btSalva')" >

	



<!-- widget btSalva -->
<s:submit name="widg_btSalva" id="widg_btSalva" method="handleBtSalva_CLICKED"
	key="cpDettaglioAccertamento.btSalva.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioAccertamento','btSalva')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpSalva --></div>

			
	
	<div id="p_wpIspezioni" class="widgetsPanelBlock"><!-- startFragment:p_wpIspezioni -->
	
	
<h4 class="wpLabel">elenco ispezioni associate </h4>
<div class="widgetsPanel" id="wpIspezioni">
	

	
	
<s:if test="isWidgetVisible('cpDettaglioAccertamento','tbIspezioni')" >

	
<div class="tableWidget">


<!-- widget tbIspezioni -->
<s:set name="cpDettaglioAccertamento_tbIspezioni_clearStatus" value="isTableClearStatus('cpDettaglioAccertamento_tbIspezioni')" />
<s:url id="cpDettaglioAccertamentoViewUrl"						   
					   action="cpDettaglioAccertamento"
					   namespace="/base/gestisci_accertamento"/>
<display:table name="appDataelencoIspezioniAccertamento"  				
			   excludedParams="*"			   export="false"
               id="widg_tbIspezioni"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpDettaglioAccertamentoViewUrl}"  
               clearStatus="${cpDettaglioAccertamento_tbIspezioni_clearStatus}"
               uid="row_tbIspezioni"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tbIspezioni.idIspezione}" name="appDataidIspezioneSelezionato" id="%{'tbIspezioni-editcell-'+ (#attr.row_tbIspezioni_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="idIspezione" titleKey="cpDettaglioAccertamento.tbIspezioni.idIspezione.label" 
			sortable="false" headerClass="nosort"
			format="{0,number,#,##0}"  class="numbers"  media="html"
			
 >
			
		</display:column>
		<display:column property="descStatoIspezione" titleKey="cpDettaglioAccertamento.tbIspezioni.descStatoIspezione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="descIspPagamento" titleKey="cpDettaglioAccertamento.tbIspezioni.descIspPagamento.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpIspezioni --></div>

			
	
	<div id="p_cpFunzioniIsp" class="commandPanelBlock"><!-- startFragment:p_cpFunzioniIsp -->
	
	
<div class="commandPanel functional" id="cpFunzioniIsp">

	
	
		
		
<s:if test="isWidgetVisible('cpDettaglioAccertamento','btAvviaIspezione')" >

	



<!-- widget btAvviaIspezione -->
<s:submit name="widg_btAvviaIspezione" id="widg_btAvviaIspezione" method="handleBtAvviaIspezione_CLICKED"
	key="cpDettaglioAccertamento.btAvviaIspezione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioAccertamento','btAvviaIspezione')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpDettaglioAccertamento','btVisualizzaIspezione')" >

	



<!-- widget btVisualizzaIspezione -->
<s:submit name="widg_btVisualizzaIspezione" id="widg_btVisualizzaIspezione" method="handleBtVisualizzaIspezione_CLICKED"
	key="cpDettaglioAccertamento.btVisualizzaIspezione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioAccertamento','btVisualizzaIspezione')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cpFunzioniIsp --></div>

			
	
	<div id="p_wpSanzioni" class="widgetsPanelBlock"><!-- startFragment:p_wpSanzioni -->
	
	
<h4 class="wpLabel">elenco sanzioni associate </h4>
<div class="widgetsPanel" id="wpSanzioni">
	

	
	
<s:if test="isWidgetVisible('cpDettaglioAccertamento','tbSanzioni')" >

	
<div class="tableWidget">


<!-- widget tbSanzioni -->
<s:set name="cpDettaglioAccertamento_tbSanzioni_clearStatus" value="isTableClearStatus('cpDettaglioAccertamento_tbSanzioni')" />
<s:url id="cpDettaglioAccertamentoViewUrl"						   
					   action="cpDettaglioAccertamento"
					   namespace="/base/gestisci_accertamento"/>
<display:table name="appDataelencoSanzioni"  				
			   excludedParams="*"			   export="false"
               id="widg_tbSanzioni"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpDettaglioAccertamentoViewUrl}"  
               clearStatus="${cpDettaglioAccertamento_tbSanzioni_clearStatus}"
               uid="row_tbSanzioni"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tbSanzioni.idSanzione}" name="appDataidSanzioneSelezionata" id="%{'tbSanzioni-editcell-'+ (#attr.row_tbSanzioni_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="idSanzione" titleKey="cpDettaglioAccertamento.tbSanzioni.idSanzione.label" 
			sortable="false" headerClass="nosort"
			format="{0,number,#,##0}"  class="numbers"  media="html"
			
 >
			
		</display:column>
		<display:column property="dataCreazione" titleKey="cpDettaglioAccertamento.tbSanzioni.dataCreazione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="descMotivoSanzione" titleKey="cpDettaglioAccertamento.tbSanzioni.descMotivoSanzione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="descStatoSanzione" titleKey="cpDettaglioAccertamento.tbSanzioni.descStatoSanzione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="valore" titleKey="cpDettaglioAccertamento.tbSanzioni.valore.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpSanzioni --></div>

			
	
	<div id="p_cpFunzioniSanz" class="commandPanelBlock"><!-- startFragment:p_cpFunzioniSanz -->
	
	
<div class="commandPanel functional" id="cpFunzioniSanz">

	
	
		
		
<s:if test="isWidgetVisible('cpDettaglioAccertamento','btAvviaSanzione')" >

	



<!-- widget btAvviaSanzione -->
<s:submit name="widg_btAvviaSanzione" id="widg_btAvviaSanzione" method="handleBtAvviaSanzione_CLICKED"
	key="cpDettaglioAccertamento.btAvviaSanzione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioAccertamento','btAvviaSanzione')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpDettaglioAccertamento','btVisualizzaSanzione')" >

	



<!-- widget btVisualizzaSanzione -->
<s:submit name="widg_btVisualizzaSanzione" id="widg_btVisualizzaSanzione" method="handleBtVisualizzaSanzione_CLICKED"
	key="cpDettaglioAccertamento.btVisualizzaSanzione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioAccertamento','btVisualizzaSanzione')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cpFunzioniSanz --></div>

			
	
	<div id="p_wpAzioni" class="widgetsPanelBlock"><!-- startFragment:p_wpAzioni -->
	
	
<h4 class="wpLabel">azioni svolte </h4>
<div class="widgetsPanel" id="wpAzioni">
	

	
	
<s:if test="isWidgetVisible('cpDettaglioAccertamento','tbAzioni')" >

	
<div class="tableWidget">


<!-- widget tbAzioni -->
<s:set name="cpDettaglioAccertamento_tbAzioni_clearStatus" value="isTableClearStatus('cpDettaglioAccertamento_tbAzioni')" />
<s:url id="cpDettaglioAccertamentoViewUrl"						   
					   action="cpDettaglioAccertamento"
					   namespace="/base/gestisci_accertamento"/>
<display:table name="appDataelencoAzioni"  				
			   excludedParams="*"			   export="false"
               id="widg_tbAzioni"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpDettaglioAccertamentoViewUrl}"  
               clearStatus="${cpDettaglioAccertamento_tbAzioni_clearStatus}"
               uid="row_tbAzioni"
               summary="" 
decorator="it.csi.sigit.sigitwebn.presentation.decorator.gestisci_accertamento.CpDettaglioAccertamentoTbAzioniCustomDecorator"               class="dataTable">
	
		<display:column property="dataAzione" titleKey="cpDettaglioAccertamento.tbAzioni.dataAzione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="descrizioneUtente" titleKey="cpDettaglioAccertamento.tbAzioni.descrizioneUtente.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="descrizione" titleKey="cpDettaglioAccertamento.tbAzioni.descrizione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="nomeDoc" titleKey="cpDettaglioAccertamento.tbAzioni.nomeDoc.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpAzioni --></div>

			
	
	<div id="p_cpFunzioni" class="commandPanelBlock"><!-- startFragment:p_cpFunzioni -->
	
	
<div class="commandPanel functional" id="cpFunzioni">

	
	
		
		
<s:if test="isWidgetVisible('cpDettaglioAccertamento','btInserisciAzione')" >

	



<!-- widget btInserisciAzione -->
<s:submit name="widg_btInserisciAzione" id="widg_btInserisciAzione" method="handleBtInserisciAzione_CLICKED"
	key="cpDettaglioAccertamento.btInserisciAzione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioAccertamento','btInserisciAzione')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpDettaglioAccertamento','btIGestisciSveglia')" >

	



<!-- widget btIGestisciSveglia -->
<s:submit name="widg_btIGestisciSveglia" id="widg_btIGestisciSveglia" method="handleBtIGestisciSveglia_CLICKED"
	key="cpDettaglioAccertamento.btIGestisciSveglia.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioAccertamento','btIGestisciSveglia')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpDettaglioAccertamento','btVisVerifica')" >

	



<!-- widget btVisVerifica -->
<s:submit name="widg_btVisVerifica" id="widg_btVisVerifica" method="handleBtVisVerifica_CLICKED"
	key="cpDettaglioAccertamento.btVisVerifica.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioAccertamento','btVisVerifica')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpDettaglioAccertamento','btConclAccert')" >

	



<!-- widget btConclAccert -->
<s:submit name="widg_btConclAccert" id="widg_btConclAccert" method="handleBtConclAccert_CLICKED"
	key="cpDettaglioAccertamento.btConclAccert.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioAccertamento','btConclAccert')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpDettaglioAccertamento','btAnnullaAccert')" >

	



<!-- widget btAnnullaAccert -->
<s:submit name="widg_btAnnullaAccert" id="widg_btAnnullaAccert" method="handleBtAnnullaAccert_CLICKED"
	key="cpDettaglioAccertamento.btAnnullaAccert.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioAccertamento','btAnnullaAccert')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpDettaglioAccertamento','btSblocca3R')" >

	



<!-- widget btSblocca3R -->
<s:submit name="widg_btSblocca3R" id="widg_btSblocca3R" method="handleBtSblocca3R_CLICKED"
	key="cpDettaglioAccertamento.btSblocca3R.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioAccertamento','btSblocca3R')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpDettaglioAccertamento','btAssocia')" >

	



<!-- widget btAssocia -->
<s:submit name="widg_btAssocia" id="widg_btAssocia" method="handleBtAssocia_CLICKED"
	key="cpDettaglioAccertamento.btAssocia.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioAccertamento','btAssocia')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpDettaglioAccertamento','btAssociaCodiceImpianto')" >

	



<!-- widget btAssociaCodiceImpianto -->
<s:submit name="widg_btAssociaCodiceImpianto" id="widg_btAssociaCodiceImpianto" method="handleBtAssociaCodiceImpianto_CLICKED"
	key="cpDettaglioAccertamento.btAssociaCodiceImpianto.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioAccertamento','btAssociaCodiceImpianto')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cpFunzioni --></div>

			
	
	<div id="p_cpNav" class="commandPanelBlock"><!-- startFragment:p_cpNav -->
	
	
<div class="commandPanel navigation" id="cpNav">

	
	
		
		
<s:if test="isWidgetVisible('cpDettaglioAccertamento','btIndietro')" >

	



<!-- widget btIndietro -->
<s:submit name="widg_btIndietro" id="widg_btIndietro" method="handleBtIndietro_CLICKED"
	key="cpDettaglioAccertamento.btIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioAccertamento','btIndietro')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cpNav --></div>

	

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
