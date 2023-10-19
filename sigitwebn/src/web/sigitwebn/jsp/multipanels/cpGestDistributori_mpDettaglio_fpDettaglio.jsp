<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_distributori/CpGestDistributoriAction" />

	
	<div id="p_fpDettaglio" class="formPanelBlock"><!-- startFragment:p_fpDettaglio -->
		
	
<div class="formPanel" id="fpDettaglio">


	
	

	
	
			
	
	<div id="p_wpDettaglio" class="widgetsPanelBlock"><!-- startFragment:p_wpDettaglio -->
	
	
<h4 class="wpLabel">dettagli acquisizione </h4>
<div class="widgetsPanel" id="wpDettaglio">
	
	<customtag:widgetsPanel id="wpDettaglioTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestDistributori','ptDtInizioElab')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestDistributori.ptDtInizioElab.label')}" labelFor="widg_ptDtInizioElab" errorFor="appDatadettaglioImportDistributori.dataInizioElab" labelId="ptDtInizioElabLbl"   >


<!-- widget ptDtInizioElab -->
<s:property value="appDatadettaglioImportDistributori.dataInizioElab" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestDistributori','ptDtFineElab')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestDistributori.ptDtFineElab.label')}" labelFor="widg_ptDtFineElab" errorFor="appDatadettaglioImportDistributori.dataFineElab" labelId="ptDtFineElabLbl"   >


<!-- widget ptDtFineElab -->
<s:property value="appDatadettaglioImportDistributori.dataFineElab" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestDistributori','ptDtAnnullaElab')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestDistributori.ptDtAnnullaElab.label')}" labelFor="widg_ptDtAnnullaElab" errorFor="appDatadettaglioImportDistributori.dataAnnullamento" labelId="ptDtAnnullaElabLbl"   >


<!-- widget ptDtAnnullaElab -->
<s:property value="appDatadettaglioImportDistributori.dataAnnullamento" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestDistributori','ptNumRecElab')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestDistributori.ptNumRecElab.label')}" labelFor="widg_ptNumRecElab" errorFor="appDatadettaglioImportDistributori.totElaborati" labelId="ptNumRecElabLbl"   tdStyleClass="numbers">


<!-- widget ptNumRecElab -->
<s:property value="appDatadettaglioImportDistributori.totElaborati" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestDistributori','ptNumRecScart')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestDistributori.ptNumRecScart.label')}" labelFor="widg_ptNumRecScart" errorFor="appDatadettaglioImportDistributori.totScartati" labelId="ptNumRecScartLbl"   tdStyleClass="numbers">


<!-- widget ptNumRecScart -->
<s:property value="appDatadettaglioImportDistributori.totScartati" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDettaglio --></div>

			
	
	<div id="p_wpDettaglioErrori" class="widgetsPanelBlock"><!-- startFragment:p_wpDettaglioErrori -->
	
	

<div class="widgetsPanel" id="wpDettaglioErrori">
	

	
	
<s:if test="isWidgetVisible('cpGestDistributori','tbElencoErrori')" >

	
<div class="tableWidget">


<!-- widget tbElencoErrori -->
	<csiuicore:ajaxify id="p_wpDettaglioErrori" 
		widgetType="table"		
		pageId="cpGestDistributori"
		javascriptDetection="false">
<s:set name="cpGestDistributori_tbElencoErrori_clearStatus" value="isTableClearStatus('cpGestDistributori_tbElencoErrori')" />
<s:url id="cpGestDistributoriViewUrl"						   
					   action="cpGestDistributori"
					   namespace="/base/gestisci_distributori"/>
<display:table name="appDataelencoErroriImport"  				
			   excludedParams="*"			   export="false"
               id="widg_tbElencoErrori"
               pagesize="10"
               keepStatus="true"
               requestURI="${cpGestDistributoriViewUrl}"  
               clearStatus="${cpGestDistributori_tbElencoErrori_clearStatus}"
               uid="row_tbElencoErrori"
               summary="" 
               class="dataTable">
	
		<display:column property="idErrore" titleKey="cpGestDistributori.tbElencoErrori.idErrore.label" 
			sortable="false" headerClass="nosort"
			format="{0,number,#,##0}"  class="numbers"  media="html"
			
 >
			
		</display:column>
		<display:column property="descErrore" titleKey="cpGestDistributori.tbElencoErrori.descErrore.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpDettaglioErrori --></div>

			
	
	<div id="p_cpNavErrori" class="commandPanelBlock"><!-- startFragment:p_cpNavErrori -->
	
	
<div class="commandPanel navigation" id="cpNavErrori">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestDistributori','btnChiudiErrori')" >

	



<!-- widget btnChiudiErrori -->
<s:submit name="widg_btnChiudiErrori" id="widg_btnChiudiErrori" method="handleBtnChiudiErrori_CLICKED"
	key="cpGestDistributori.btnChiudiErrori.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestDistributori','btnChiudiErrori')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavErrori --></div>

	

		
	
</div>

	<!-- endFragment:p_fpDettaglio --></div>
