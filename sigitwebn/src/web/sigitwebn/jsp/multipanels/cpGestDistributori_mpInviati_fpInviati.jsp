<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_distributori/CpGestDistributoriAction" />

	
	<div id="p_fpInviati" class="formPanelBlock"><!-- startFragment:p_fpInviati -->
		
	
<div class="formPanel" id="fpInviati">


	
	

	
	
			
	
	<div id="p_wpInviati" class="widgetsPanelBlock"><!-- startFragment:p_wpInviati -->
	
	
<h4 class="wpLabel">dati inviati </h4>
<div class="widgetsPanel" id="wpInviati">
	

	
	
<s:if test="isWidgetVisible('cpGestDistributori','tbDatiInviati')" >

	
<div class="tableWidget">


<!-- widget tbDatiInviati -->
	<csiuicore:ajaxify id="p_wpInviati" 
		widgetType="table"		
		pageId="cpGestDistributori"
		javascriptDetection="false">
<s:set name="cpGestDistributori_tbDatiInviati_clearStatus" value="isTableClearStatus('cpGestDistributori_tbDatiInviati')" />
<s:url id="cpGestDistributoriViewUrl"						   
					   action="cpGestDistributori"
					   namespace="/base/gestisci_distributori"/>
<display:table name="appDataelencoImportDistributori"  				
			   excludedParams="*"			   export="false"
               id="widg_tbDatiInviati"
               pagesize="10"
               keepStatus="true"
               requestURI="${cpGestDistributoriViewUrl}"  
               clearStatus="${cpGestDistributori_tbDatiInviati_clearStatus}"
               uid="row_tbDatiInviati"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tbDatiInviati.idFileInviato}" name="appDataidFileInviatoSelez" id="%{'tbDatiInviati-editcell-'+ (#attr.row_tbDatiInviati_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="dataInizioElab" titleKey="cpGestDistributori.tbDatiInviati.dataInizioElab.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="nomeFile" titleKey="cpGestDistributori.tbDatiInviati.nomeFile.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="annoRiferimento" titleKey="cpGestDistributori.tbDatiInviati.annoRiferimento.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="descStato" titleKey="cpGestDistributori.tbDatiInviati.descStato.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpInviati --></div>

			
	
	<div id="p_cpFunInviati" class="commandPanelBlock"><!-- startFragment:p_cpFunInviati -->
	
	
<div class="commandPanel functional" id="cpFunInviati">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestDistributori','btnImporta')" >

	



<!-- widget btnImporta -->
<s:submit name="widg_btnImporta" id="widg_btnImporta" method="handleBtnImporta_CLICKED"
	key="cpGestDistributori.btnImporta.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestDistributori','btnImporta')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestDistributori','btnSostituisci')" >

	



<!-- widget btnSostituisci -->
<s:submit name="widg_btnSostituisci" id="widg_btnSostituisci" method="handleBtnSostituisci_CLICKED"
	key="cpGestDistributori.btnSostituisci.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestDistributori','btnSostituisci')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestDistributori','btnDettaglio')" >

	



<!-- widget btnDettaglio -->
<s:submit name="widg_btnDettaglio" id="widg_btnDettaglio" method="handleBtnDettaglio_CLICKED"
	key="cpGestDistributori.btnDettaglio.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestDistributori','btnDettaglio')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestDistributori','btnAnnulla')" >

	



<!-- widget btnAnnulla -->
<s:submit name="widg_btnAnnulla" id="widg_btnAnnulla" method="handleBtnAnnulla_CLICKED"
	key="cpGestDistributori.btnAnnulla.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestDistributori','btnAnnulla')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestDistributori','btnRicevuta')" >

	



<!-- widget btnRicevuta -->
<s:submit name="widg_btnRicevuta" id="widg_btnRicevuta" method="handleBtnRicevuta_CLICKED"
	key="cpGestDistributori.btnRicevuta.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpGestDistributori','btnRicevuta')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestDistributori','btnInserimento')" >

	



<!-- widget btnInserimento -->
<s:submit name="widg_btnInserimento" id="widg_btnInserimento" method="handleBtnInserimento_CLICKED"
	key="cpGestDistributori.btnInserimento.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestDistributori','btnInserimento')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestDistributori','btnDettCaricaManuale')" >

	



<!-- widget btnDettCaricaManuale -->
<s:submit name="widg_btnDettCaricaManuale" id="widg_btnDettCaricaManuale" method="handleBtnDettCaricaManuale_CLICKED"
	key="cpGestDistributori.btnDettCaricaManuale.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestDistributori','btnDettCaricaManuale')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunInviati --></div>

	

		
	
</div>

	<!-- endFragment:p_fpInviati --></div>
