<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_sanzioni/CpInserisciNotificaSanzioneAction" />

	
	<div id="p_fpElencoSanzionati" class="formPanelBlock"><!-- startFragment:p_fpElencoSanzionati -->
		
	
<div class="formPanel" id="fpElencoSanzionati">


	
	

	
	
			
	
	<div id="p_wpElencoSanzionati" class="widgetsPanelBlock"><!-- startFragment:p_wpElencoSanzionati -->
	
	

<div class="widgetsPanel" id="wpElencoSanzionati">
	

	
	
<s:if test="isWidgetVisible('cpInserisciNotificaSanzione','tbElencoSanzionabili')" >

	
<div class="tableWidget">


<!-- widget tbElencoSanzionabili -->
	<csiuicore:ajaxify id="p_wpElencoSanzionati" 
		widgetType="table"		
		pageId="cpInserisciNotificaSanzione"
		javascriptDetection="false">
<s:set name="cpInserisciNotificaSanzione_tbElencoSanzionabili_clearStatus" value="isTableClearStatus('cpInserisciNotificaSanzione_tbElencoSanzionabili')" />
<s:url id="cpInserisciNotificaSanzioneViewUrl"						   
					   action="cpInserisciNotificaSanzione"
					   namespace="/base/gestisci_sanzioni"/>
<display:table name="appDataelencoCandidatiSanzionati"  				
			   excludedParams="*"			   export="false"
               id="widg_tbElencoSanzionabili"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpInserisciNotificaSanzioneViewUrl}"  
               clearStatus="${cpInserisciNotificaSanzione_tbElencoSanzionabili_clearStatus}"
               uid="row_tbElencoSanzionabili"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tbElencoSanzionabili.id}" name="appDataidSanzionatoScelto" id="%{'tbElencoSanzionabili-editcell-'+ (#attr.row_tbElencoSanzionabili_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="codiceFiscale" titleKey="cpInserisciNotificaSanzione.tbElencoSanzionabili.codiceFiscale.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="denomCompleta" titleKey="cpInserisciNotificaSanzione.tbElencoSanzionabili.denomCompleta.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="descComuneProv" titleKey="cpInserisciNotificaSanzione.tbElencoSanzionabili.descComuneProv.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dsIndirizzoCompleto" titleKey="cpInserisciNotificaSanzione.tbElencoSanzionabili.dsIndirizzoCompleto.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpElencoSanzionati --></div>

			
	
	<div id="p_cpElencoSanzionabili" class="commandPanelBlock"><!-- startFragment:p_cpElencoSanzionabili -->
	
	
<div class="commandPanel functional" id="cpElencoSanzionabili">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpInserisciNotificaSanzione','btnAnnullaSceltaSanzionato')" >

	



<!-- widget btnAnnullaSceltaSanzionato -->
<s:submit name="widg_btnAnnullaSceltaSanzionato" id="widg_btnAnnullaSceltaSanzionato" method="handleBtnAnnullaSceltaSanzionato_CLICKED"
	key="cpInserisciNotificaSanzione.btnAnnullaSceltaSanzionato.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpInserisciNotificaSanzione','btnAnnullaSceltaSanzionato')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpInserisciNotificaSanzione','btnSelezionaSanzionato')" >

	



<!-- widget btnSelezionaSanzionato -->
<s:submit name="widg_btnSelezionaSanzionato" id="widg_btnSelezionaSanzionato" method="handleBtnSelezionaSanzionato_CLICKED"
	key="cpInserisciNotificaSanzione.btnSelezionaSanzionato.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpInserisciNotificaSanzione','btnSelezionaSanzionato')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpElencoSanzionabili --></div>

	

		
	
</div>

	<!-- endFragment:p_fpElencoSanzionati --></div>
