<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_impresa/CpGestImpresaAction" />

	
	<div id="p_fmDatiCat" class="formPanelBlock"><!-- startFragment:p_fmDatiCat -->
		
	
<div class="formPanel" id="fmDatiCat">


	
	

	
	
			
	
	<div id="p_wpDatiCat" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiCat -->
	
	
<h4 class="wpLabel">Elenco imprese con incarico a soggetto delegato attivo </h4>
<div class="widgetsPanel" id="wpDatiCat">
	

	
	
<s:if test="isWidgetVisible('cpGestImpresa','tbIncTrovate')" >

	
<div class="tableWidget">


<!-- widget tbIncTrovate -->
	<csiuicore:ajaxify id="p_wpDatiCat" 
		widgetType="table"		
		pageId="cpGestImpresa"
		javascriptDetection="false">
<s:set name="cpGestImpresa_tbIncTrovate_clearStatus" value="isTableClearStatus('cpGestImpresa_tbIncTrovate')" />
<s:url id="cpGestImpresaViewUrl"						   
					   action="cpGestImpresa"
					   namespace="/base/gestisci_impresa"/>
<display:table name="appDataelencoIncarichiAttivi"  				
			   excludedParams="*"			   export="true"
               id="widg_tbIncTrovate"
               pagesize="10"
               keepStatus="true"
               requestURI="${cpGestImpresaViewUrl}"  
               clearStatus="${cpGestImpresa_tbIncTrovate_clearStatus}"
               uid="row_tbIncTrovate"
               summary="" 
               class="dataTable">
	
		<display:column property="denominazione" titleKey="cpGestImpresa.tbIncTrovate.denominazione.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="denominazione" titleKey="cpGestImpresa.tbIncTrovate.denominazione.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="denominazione" titleKey="cpGestImpresa.tbIncTrovate.denominazione.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="codiceFiscale" titleKey="cpGestImpresa.tbIncTrovate.codiceFiscale.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="codiceFiscale" titleKey="cpGestImpresa.tbIncTrovate.codiceFiscale.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="codiceFiscale" titleKey="cpGestImpresa.tbIncTrovate.codiceFiscale.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="codiceRea" titleKey="cpGestImpresa.tbIncTrovate.codiceRea.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="codiceRea" titleKey="cpGestImpresa.tbIncTrovate.codiceRea.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="codiceRea" titleKey="cpGestImpresa.tbIncTrovate.codiceRea.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="descFlgInstallatore" titleKey="cpGestImpresa.tbIncTrovate.descFlgInstallatore.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="descFlgInstallatore" titleKey="cpGestImpresa.tbIncTrovate.descFlgInstallatore.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="descFlgInstallatore" titleKey="cpGestImpresa.tbIncTrovate.descFlgInstallatore.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="descFlgManutentore" titleKey="cpGestImpresa.tbIncTrovate.descFlgManutentore.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="descFlgManutentore" titleKey="cpGestImpresa.tbIncTrovate.descFlgManutentore.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="descFlgManutentore" titleKey="cpGestImpresa.tbIncTrovate.descFlgManutentore.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="descFlgAmministratore" titleKey="cpGestImpresa.tbIncTrovate.descFlgAmministratore.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="descFlgAmministratore" titleKey="cpGestImpresa.tbIncTrovate.descFlgAmministratore.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="descFlgAmministratore" titleKey="cpGestImpresa.tbIncTrovate.descFlgAmministratore.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="descFlgTerzoResponsabile" titleKey="cpGestImpresa.tbIncTrovate.descFlgTerzoResponsabile.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="descFlgTerzoResponsabile" titleKey="cpGestImpresa.tbIncTrovate.descFlgTerzoResponsabile.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="descFlgTerzoResponsabile" titleKey="cpGestImpresa.tbIncTrovate.descFlgTerzoResponsabile.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="descFlgDistributore" titleKey="cpGestImpresa.tbIncTrovate.descFlgDistributore.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="descFlgDistributore" titleKey="cpGestImpresa.tbIncTrovate.descFlgDistributore.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="descFlgDistributore" titleKey="cpGestImpresa.tbIncTrovate.descFlgDistributore.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="descFlgCat" titleKey="cpGestImpresa.tbIncTrovate.descFlgCat.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="descFlgCat" titleKey="cpGestImpresa.tbIncTrovate.descFlgCat.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="descFlgCat" titleKey="cpGestImpresa.tbIncTrovate.descFlgCat.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpDatiCat --></div>

			
	
	<div id="p_wpNumRapInv" class="widgetsPanelBlock"><!-- startFragment:p_wpNumRapInv -->
	
	
<h4 class="wpLabel">resoconto sogg. delegato </h4>
<div class="widgetsPanel" id="wpNumRapInv">
	
	<customtag:widgetsPanel id="wpNumRapInvTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestImpresa','ptNumRappInv')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestImpresa.ptNumRappInv.label')}" labelFor="widg_ptNumRappInv" errorFor="appDatanumeroRapportiInviati" labelId="ptNumRappInvLbl"   >


<!-- widget ptNumRappInv -->
<s:property value="appDatanumeroRapportiInviati" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpNumRapInv --></div>

			
	
	<div id="p_cpDatiCat" class="commandPanelBlock"><!-- startFragment:p_cpDatiCat -->
	
	
<div class="commandPanel functional" id="cpDatiCat">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestImpresa','btAnnullaDatiCat')" >

	



<!-- widget btAnnullaDatiCat -->
<s:submit name="widg_btAnnullaDatiCat" id="widg_btAnnullaDatiCat" method="handleBtAnnullaDatiCat_CLICKED"
	key="cpGestImpresa.btAnnullaDatiCat.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpresa','btAnnullaDatiCat')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpDatiCat --></div>

	

		
	
</div>

	<!-- endFragment:p_fmDatiCat --></div>
