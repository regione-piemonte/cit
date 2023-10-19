<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/elenco_ispezioni_impianti/CpDettaglioIspezione2018Action" />

	
	<div id="p_fpElenchi" class="formPanelBlock"><!-- startFragment:p_fpElenchi -->
		
	


	
	

	
	
			
	
	<div id="p_fpElencoSanzioni" class="formPanelBlock"><!-- startFragment:p_fpElencoSanzioni -->
		
	
<div class="formPanel" id="fpElencoSanzioni">


	
	

	
	
			
	
	<div id="p_wpSanzioni" class="widgetsPanelBlock"><!-- startFragment:p_wpSanzioni -->
	
	
<h4 class="wpLabel">elenco sanzioni associate </h4>
<div class="widgetsPanel" id="wpSanzioni">
	

	
	
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','tbSazioni')" >

	
<div class="tableWidget">


<!-- widget tbSazioni -->
	<csiuicore:ajaxify id="p_wpSanzioni" 
		widgetType="table"		
		pageId="cpDettaglioIspezione2018"
		javascriptDetection="false">
<s:set name="cpDettaglioIspezione2018_tbSazioni_clearStatus" value="isTableClearStatus('cpDettaglioIspezione2018_tbSazioni')" />
<s:url id="cpDettaglioIspezione2018ViewUrl"						   
					   action="cpDettaglioIspezione2018"
					   namespace="/base/elenco_ispezioni_impianti"/>
<display:table name="appDataelencoSanzioni"  				
			   excludedParams="*"			   export="true"
               id="widg_tbSazioni"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpDettaglioIspezione2018ViewUrl}"  
               clearStatus="${cpDettaglioIspezione2018_tbSazioni_clearStatus}"
               uid="row_tbSazioni"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tbSazioni.idSanzione}" name="appDataidSanzioneSelezionata" id="%{'tbSazioni-editcell-'+ (#attr.row_tbSazioni_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>

		<display:column headerClass="nosort" media="excel pdf">
		</display:column>
		<display:column property="idSanzione" titleKey="cpDettaglioIspezione2018.tbSazioni.idSanzione.label" 
			sortable="false" headerClass="nosort"
			format="{0,number,#,##0}"  class="numbers"  media="html"
			
 >
			
		</display:column>

		<display:column property="idSanzione" titleKey="cpDettaglioIspezione2018.tbSazioni.idSanzione.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="idSanzione" titleKey="cpDettaglioIspezione2018.tbSazioni.idSanzione.export.label"
			sortable="false" headerClass="nosort"
			format="{0,number,#,##0}" 
			media="pdf" />	
		<display:column property="dataCreazione" titleKey="cpDettaglioIspezione2018.tbSazioni.dataCreazione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="dataCreazione" titleKey="cpDettaglioIspezione2018.tbSazioni.dataCreazione.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="dataCreazione" titleKey="cpDettaglioIspezione2018.tbSazioni.dataCreazione.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
		<display:column property="descMotivoSanzione" titleKey="cpDettaglioIspezione2018.tbSazioni.descMotivoSanzione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="descMotivoSanzione" titleKey="cpDettaglioIspezione2018.tbSazioni.descMotivoSanzione.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="descMotivoSanzione" titleKey="cpDettaglioIspezione2018.tbSazioni.descMotivoSanzione.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
		<display:column property="descStatoSanzione" titleKey="cpDettaglioIspezione2018.tbSazioni.descStatoSanzione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="descStatoSanzione" titleKey="cpDettaglioIspezione2018.tbSazioni.descStatoSanzione.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="descStatoSanzione" titleKey="cpDettaglioIspezione2018.tbSazioni.descStatoSanzione.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
		<display:column property="valore" titleKey="cpDettaglioIspezione2018.tbSazioni.valore.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="valore" titleKey="cpDettaglioIspezione2018.tbSazioni.valore.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="valore" titleKey="cpDettaglioIspezione2018.tbSazioni.valore.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpSanzioni --></div>

			
	
	<div id="p_cpFunSanzioni" class="commandPanelBlock"><!-- startFragment:p_cpFunSanzioni -->
	
	
<div class="commandPanel functional" id="cpFunSanzioni">

	
	
		
		
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','btAvviaSanzione')" >

	



<!-- widget btAvviaSanzione -->
<s:submit name="widg_btAvviaSanzione" id="widg_btAvviaSanzione" method="handleBtAvviaSanzione_CLICKED"
	key="cpDettaglioIspezione2018.btAvviaSanzione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioIspezione2018','btAvviaSanzione')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','btVisualizzaSanzione')" >

	



<!-- widget btVisualizzaSanzione -->
<s:submit name="widg_btVisualizzaSanzione" id="widg_btVisualizzaSanzione" method="handleBtVisualizzaSanzione_CLICKED"
	key="cpDettaglioIspezione2018.btVisualizzaSanzione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioIspezione2018','btVisualizzaSanzione')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cpFunSanzioni --></div>

	

		
	
</div>

	<!-- endFragment:p_fpElencoSanzioni --></div>

			
	
	<div id="p_fpElencoRapProva" class="formPanelBlock"><!-- startFragment:p_fpElencoRapProva -->
		
	


	
	

	
	
			
	
	<div id="p_wpRapportiProva" class="widgetsPanelBlock"><!-- startFragment:p_wpRapportiProva -->
	
	
<h4 class="wpLabel">rapporti di prova </h4>
<div class="widgetsPanel" id="wpRapportiProva">
	

	
	
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','tbRapportiProva')" >

	
<div class="tableWidget">


<!-- widget tbRapportiProva -->
<s:set name="cpDettaglioIspezione2018_tbRapportiProva_clearStatus" value="isTableClearStatus('cpDettaglioIspezione2018_tbRapportiProva')" />
<s:url id="cpDettaglioIspezione2018ViewUrl"						   
					   action="cpDettaglioIspezione2018"
					   namespace="/base/elenco_ispezioni_impianti"/>
<display:table name="appDataelencoAllegatiIsp"  				
			   excludedParams="*"			   export="true"
               id="widg_tbRapportiProva"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpDettaglioIspezione2018ViewUrl}"  
               clearStatus="${cpDettaglioIspezione2018_tbRapportiProva_clearStatus}"
               uid="row_tbRapportiProva"
               summary="" 
decorator="it.csi.sigit.sigitwebn.presentation.decorator.elenco_ispezioni_impianti.CpDettaglioIspezione2018TbRapportiProvaCustomDecorator"               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tbRapportiProva.idAllegato}" name="appDataidAllegatoIspSelezionato" id="%{'tbRapportiProva-editcell-'+ (#attr.row_tbRapportiProva_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>

		<display:column headerClass="nosort" media="excel pdf">
		</display:column>
		<display:column property="dataControllo" titleKey="cpDettaglioIspezione2018.tbRapportiProva.dataControllo.label" 
			sortable="true" headerClass="sortable"
			 comparator="it.csi.sigit.sigitwebn.presentation.sigitwebn.comparator.CsiDateComparator"   media="html"
			
 >
			
		</display:column>

		<display:column property="dataControllo" titleKey="cpDettaglioIspezione2018.tbRapportiProva.dataControllo.export.label"
			sortable="true" headerClass="sortable"
			comparator="it.csi.sigit.sigitwebn.presentation.sigitwebn.comparator.CsiDateComparator"
			media="excel" />
		<display:column property="dataControllo" titleKey="cpDettaglioIspezione2018.tbRapportiProva.dataControllo.export.label"
			sortable="true" headerClass="sortable"
			 comparator="it.csi.sigit.sigitwebn.presentation.sigitwebn.comparator.CsiDateComparator"
			media="pdf" />	
		<display:column property="elencoApparecchiature" titleKey="cpDettaglioIspezione2018.tbRapportiProva.elencoApparecchiature.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="elencoApparecchiature" titleKey="cpDettaglioIspezione2018.tbRapportiProva.elencoApparecchiature.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="elencoApparecchiature" titleKey="cpDettaglioIspezione2018.tbRapportiProva.elencoApparecchiature.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="statoAllegato" titleKey="cpDettaglioIspezione2018.tbRapportiProva.statoAllegato.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="statoAllegato" titleKey="cpDettaglioIspezione2018.tbRapportiProva.statoAllegato.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="statoAllegato" titleKey="cpDettaglioIspezione2018.tbRapportiProva.statoAllegato.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="labelFileFirmato" titleKey="cpDettaglioIspezione2018.tbRapportiProva.labelFileFirmato.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="labelFileFirmato" titleKey="cpDettaglioIspezione2018.tbRapportiProva.labelFileFirmato.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="labelFileFirmato" titleKey="cpDettaglioIspezione2018.tbRapportiProva.labelFileFirmato.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpRapportiProva --></div>

			
	
	<div id="p_cpFunRappProva" class="commandPanelBlock"><!-- startFragment:p_cpFunRappProva -->
	
	
<div class="commandPanel functional" id="cpFunRappProva">

	
	
		
		
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','btInserisciRapProva')" >

	



<!-- widget btInserisciRapProva -->
<s:submit name="widg_btInserisciRapProva" id="widg_btInserisciRapProva" method="handleBtInserisciRapProva_CLICKED"
	key="cpDettaglioIspezione2018.btInserisciRapProva.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioIspezione2018','btInserisciRapProva')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','btModificaRapProva')" >

	



<!-- widget btModificaRapProva -->
<s:submit name="widg_btModificaRapProva" id="widg_btModificaRapProva" method="handleBtModificaRapProva_CLICKED"
	key="cpDettaglioIspezione2018.btModificaRapProva.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioIspezione2018','btModificaRapProva')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','btDettaglioRapProva')" >

	



<!-- widget btDettaglioRapProva -->
<s:submit name="widg_btDettaglioRapProva" id="widg_btDettaglioRapProva" method="handleBtDettaglioRapProva_CLICKED"
	key="cpDettaglioIspezione2018.btDettaglioRapProva.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpDettaglioIspezione2018','btDettaglioRapProva')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','btAnnullaRapProva')" >

	



<!-- widget btAnnullaRapProva -->
<s:submit name="widg_btAnnullaRapProva" id="widg_btAnnullaRapProva" method="handleBtAnnullaRapProva_CLICKED"
	key="cpDettaglioIspezione2018.btAnnullaRapProva.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioIspezione2018','btAnnullaRapProva')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','btConsolidaRapProva')" >

	



<!-- widget btConsolidaRapProva -->
<s:submit name="widg_btConsolidaRapProva" id="widg_btConsolidaRapProva" method="handleBtConsolidaRapProva_CLICKED"
	key="cpDettaglioIspezione2018.btConsolidaRapProva.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioIspezione2018','btConsolidaRapProva')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','btCaricaRapProvaFirmato')" >

	



<!-- widget btCaricaRapProvaFirmato -->
<s:submit name="widg_btCaricaRapProvaFirmato" id="widg_btCaricaRapProvaFirmato" method="handleBtCaricaRapProvaFirmato_CLICKED"
	key="cpDettaglioIspezione2018.btCaricaRapProvaFirmato.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioIspezione2018','btCaricaRapProvaFirmato')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cpFunRappProva --></div>

			
	
	
	<div id="p_mpUploadRappProvaFirmato" class="panelBlock"><!-- startFragment:p_mpUploadRappProvaFirmato -->
		

		
<s:if test="#session.cpDettaglioIspezione2018_mpUploadRappProvaFirmato_selectedMultiPanel == 'cpDettaglioIspezione2018_mpUploadRappProvaFirmato_fpUploadRappProvaFirmato'">
	<s:include value="/jsp/multipanels/cpDettaglioIspezione2018_mpUploadRappProvaFirmato_fpUploadRappProvaFirmato.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpUploadRappProvaFirmato --></div>

	

		
	

	<!-- endFragment:p_fpElencoRapProva --></div>

			
	
	<div id="p_fpElencoAzioni" class="formPanelBlock"><!-- startFragment:p_fpElencoAzioni -->
		
	
<div class="formPanel" id="fpElencoAzioni">


	
	

	
	
			
	
	<div id="p_wpAzioniSvolte" class="widgetsPanelBlock"><!-- startFragment:p_wpAzioniSvolte -->
	
	
<h4 class="wpLabel">azioni svolte </h4>
<div class="widgetsPanel" id="wpAzioniSvolte">
	

	
	
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','tbAzioniSvolte')" >

	
<div class="tableWidget">


<!-- widget tbAzioniSvolte -->
<s:set name="cpDettaglioIspezione2018_tbAzioniSvolte_clearStatus" value="isTableClearStatus('cpDettaglioIspezione2018_tbAzioniSvolte')" />
<s:url id="cpDettaglioIspezione2018ViewUrl"						   
					   action="cpDettaglioIspezione2018"
					   namespace="/base/elenco_ispezioni_impianti"/>
<display:table name="appDataelencoAzioni"  				
			   excludedParams="*"			   export="true"
               id="widg_tbAzioniSvolte"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpDettaglioIspezione2018ViewUrl}"  
               clearStatus="${cpDettaglioIspezione2018_tbAzioniSvolte_clearStatus}"
               uid="row_tbAzioniSvolte"
               summary="" 
decorator="it.csi.sigit.sigitwebn.presentation.decorator.elenco_ispezioni_impianti.CpDettaglioIspezione2018TbAzioniSvolteCustomDecorator"               class="dataTable">
	
		<display:column property="dataAzione" titleKey="cpDettaglioIspezione2018.tbAzioniSvolte.dataAzione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="dataAzione" titleKey="cpDettaglioIspezione2018.tbAzioniSvolte.dataAzione.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="dataAzione" titleKey="cpDettaglioIspezione2018.tbAzioniSvolte.dataAzione.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
		<display:column property="descrizioneUtente" titleKey="cpDettaglioIspezione2018.tbAzioniSvolte.descrizioneUtente.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="descrizioneUtente" titleKey="cpDettaglioIspezione2018.tbAzioniSvolte.descrizioneUtente.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="descrizioneUtente" titleKey="cpDettaglioIspezione2018.tbAzioniSvolte.descrizioneUtente.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
		<display:column property="descrizione" titleKey="cpDettaglioIspezione2018.tbAzioniSvolte.descrizione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="descrizione" titleKey="cpDettaglioIspezione2018.tbAzioniSvolte.descrizione.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="descrizione" titleKey="cpDettaglioIspezione2018.tbAzioniSvolte.descrizione.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
		<display:column property="nomeDoc" titleKey="cpDettaglioIspezione2018.tbAzioniSvolte.nomeDoc.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="nomeDoc" titleKey="cpDettaglioIspezione2018.tbAzioniSvolte.nomeDoc.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="nomeDoc" titleKey="cpDettaglioIspezione2018.tbAzioniSvolte.nomeDoc.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpAzioniSvolte --></div>

			
	
	<div id="p_cpFunAzioni" class="commandPanelBlock"><!-- startFragment:p_cpFunAzioni -->
	
	
<div class="commandPanel functional" id="cpFunAzioni">

	
	
		
		
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','btInserisciAzione')" >

	



<!-- widget btInserisciAzione -->
<s:submit name="widg_btInserisciAzione" id="widg_btInserisciAzione" method="handleBtInserisciAzione_CLICKED"
	key="cpDettaglioIspezione2018.btInserisciAzione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioIspezione2018','btInserisciAzione')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','btGestisciSveglia')" >

	



<!-- widget btGestisciSveglia -->
<s:submit name="widg_btGestisciSveglia" id="widg_btGestisciSveglia" method="handleBtGestisciSveglia_CLICKED"
	key="cpDettaglioIspezione2018.btGestisciSveglia.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioIspezione2018','btGestisciSveglia')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','btVisualizzaVerifica')" >

	



<!-- widget btVisualizzaVerifica -->
<s:submit name="widg_btVisualizzaVerifica" id="widg_btVisualizzaVerifica" method="handleBtVisualizzaVerifica_CLICKED"
	key="cpDettaglioIspezione2018.btVisualizzaVerifica.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioIspezione2018','btVisualizzaVerifica')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','btVisualizzaAccertamento')" >

	



<!-- widget btVisualizzaAccertamento -->
<s:submit name="widg_btVisualizzaAccertamento" id="widg_btVisualizzaAccertamento" method="handleBtVisualizzaAccertamento_CLICKED"
	key="cpDettaglioIspezione2018.btVisualizzaAccertamento.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioIspezione2018','btVisualizzaAccertamento')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','btConcludiIspezione')" >

	



<!-- widget btConcludiIspezione -->
<s:submit name="widg_btConcludiIspezione" id="widg_btConcludiIspezione" method="handleBtConcludiIspezione_CLICKED"
	key="cpDettaglioIspezione2018.btConcludiIspezione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioIspezione2018','btConcludiIspezione')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','btAnnullaIspezione')" >

	



<!-- widget btAnnullaIspezione -->
<s:submit name="widg_btAnnullaIspezione" id="widg_btAnnullaIspezione" method="handleBtAnnullaIspezione_CLICKED"
	key="cpDettaglioIspezione2018.btAnnullaIspezione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioIspezione2018','btAnnullaIspezione')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','btAssegna')" >

	



<!-- widget btAssegna -->
<s:submit name="widg_btAssegna" id="widg_btAssegna" method="handleBtAssegna_CLICKED"
	key="cpDettaglioIspezione2018.btAssegna.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioIspezione2018','btAssegna')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','btAssociaCodiceImpianto')" >

	



<!-- widget btAssociaCodiceImpianto -->
<s:submit name="widg_btAssociaCodiceImpianto" id="widg_btAssociaCodiceImpianto" method="handleBtAssociaCodiceImpianto_CLICKED"
	key="cpDettaglioIspezione2018.btAssociaCodiceImpianto.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioIspezione2018','btAssociaCodiceImpianto')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cpFunAzioni --></div>

	

		
	
</div>

	<!-- endFragment:p_fpElencoAzioni --></div>

			
	
	
	<div id="p_mpAzioniIspezione" class="panelBlock"><!-- startFragment:p_mpAzioniIspezione -->
		

		
<s:if test="#session.cpDettaglioIspezione2018_mpAzioniIspezione_selectedMultiPanel == 'cpDettaglioIspezione2018_mpAzioniIspezione_fpConcludiIspezione'">
	<s:include value="/jsp/multipanels/cpDettaglioIspezione2018_mpAzioniIspezione_fpConcludiIspezione.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.cpDettaglioIspezione2018_mpAzioniIspezione_selectedMultiPanel == 'cpDettaglioIspezione2018_mpAzioniIspezione_fpAssegnaIspezione'">
	<s:include value="/jsp/multipanels/cpDettaglioIspezione2018_mpAzioniIspezione_fpAssegnaIspezione.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.cpDettaglioIspezione2018_mpAzioniIspezione_selectedMultiPanel == 'cpDettaglioIspezione2018_mpAzioniIspezione_fpAssociaCodiceImpianto'">
	<s:include value="/jsp/multipanels/cpDettaglioIspezione2018_mpAzioniIspezione_fpAssociaCodiceImpianto.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpAzioniIspezione --></div>

	

		
	

	<!-- endFragment:p_fpElenchi --></div>
