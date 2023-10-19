<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_incarico/CpGestIncaricoAction" />

	
	<div id="p_fpIncaricati" class="formPanelBlock"><!-- startFragment:p_fpIncaricati -->
		
	
<div class="formPanel" id="fpIncaricati">


	
	

	
	
			
	
	<div id="p_wpIncaricati" class="widgetsPanelBlock"><!-- startFragment:p_wpIncaricati -->
	
	
<h4 class="wpLabel">elenco incarichi soggetti delegati </h4>
<div class="widgetsPanel" id="wpIncaricati">
	

	
	
<s:if test="isWidgetVisible('cpGestIncarico','tbIncaricatiAssociati')" >

	
<div class="tableWidget">


<!-- widget tbIncaricatiAssociati -->
	<csiuicore:ajaxify id="p_wpIncaricati" 
		widgetType="table"		
		pageId="cpGestIncarico"
		javascriptDetection="false">
<s:set name="cpGestIncarico_tbIncaricatiAssociati_clearStatus" value="isTableClearStatus('cpGestIncarico_tbIncaricatiAssociati')" />
<s:url id="cpGestIncaricoViewUrl"						   
					   action="cpGestIncarico"
					   namespace="/base/gestisci_incarico"/>
<display:table name="appDataelencoIncaricatiAssociati"  				
			   excludedParams="*"			   export="false"
               id="widg_tbIncaricatiAssociati"
               pagesize="10"
               keepStatus="true"
               requestURI="${cpGestIncaricoViewUrl}"  
               clearStatus="${cpGestIncarico_tbIncaricatiAssociati_clearStatus}"
               uid="row_tbIncaricatiAssociati"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tbIncaricatiAssociati.idIncaricato}" name="appDataidIncaricatoAssociatoSelez" id="%{'tbIncaricatiAssociati-editcell-'+ (#attr.row_tbIncaricatiAssociati_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="denominazione" titleKey="cpGestIncarico.tbIncaricatiAssociati.denominazione.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="codiceFiscale" titleKey="cpGestIncarico.tbIncaricatiAssociati.codiceFiscale.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataIncaricoDal" titleKey="cpGestIncarico.tbIncaricatiAssociati.dataIncaricoDal.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataIncaricoAl" titleKey="cpGestIncarico.tbIncaricatiAssociati.dataIncaricoAl.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpIncaricati --></div>

			
	
	<div id="p_cpFunDelegati" class="commandPanelBlock"><!-- startFragment:p_cpFunDelegati -->
	
	
<div class="commandPanel functional" id="cpFunDelegati">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestIncarico','btnInserisciIncarico')" >

	



<!-- widget btnInserisciIncarico -->
<s:submit name="widg_btnInserisciIncarico" id="widg_btnInserisciIncarico" method="handleBtnInserisciIncarico_CLICKED"
	key="cpGestIncarico.btnInserisciIncarico.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestIncarico','btnInserisciIncarico')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestIncarico','btnCessaIncarico')" >

	



<!-- widget btnCessaIncarico -->
<s:submit name="widg_btnCessaIncarico" id="widg_btnCessaIncarico" method="handleBtnCessaIncarico_CLICKED"
	key="cpGestIncarico.btnCessaIncarico.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestIncarico','btnCessaIncarico')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunDelegati --></div>

	

		
	
</div>

	<!-- endFragment:p_fpIncaricati --></div>
