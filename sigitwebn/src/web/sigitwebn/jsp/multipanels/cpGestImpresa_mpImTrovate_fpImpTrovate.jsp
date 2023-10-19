<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_impresa/CpGestImpresaAction" />

	
	<div id="p_fpImpTrovate" class="formPanelBlock"><!-- startFragment:p_fpImpTrovate -->
		
	
<div class="formPanel" id="fpImpTrovate">


	
	

	
	
			
	
	<div id="p_wpImpTrovate" class="widgetsPanelBlock"><!-- startFragment:p_wpImpTrovate -->
	
	

<div class="widgetsPanel" id="wpImpTrovate">
	

	
	
<s:if test="isWidgetVisible('cpGestImpresa','tbImpTrovate')" >

	
<div class="tableWidget">


<!-- widget tbImpTrovate -->
	<csiuicore:ajaxify id="p_wpImpTrovate" 
		widgetType="table"		
		pageId="cpGestImpresa"
		javascriptDetection="false">
<s:set name="cpGestImpresa_tbImpTrovate_clearStatus" value="isTableClearStatus('cpGestImpresa_tbImpTrovate')" />
<s:url id="cpGestImpresaViewUrl"						   
					   action="cpGestImpresa"
					   namespace="/base/gestisci_impresa"/>
<display:table name="appDataelencoImprese"  				
			   excludedParams="*"			   export="true"
               id="widg_tbImpTrovate"
               pagesize="10"
               keepStatus="true"
               requestURI="${cpGestImpresaViewUrl}"  
               clearStatus="${cpGestImpresa_tbImpTrovate_clearStatus}"
               uid="row_tbImpTrovate"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tbImpTrovate.idPersonaGiuridica}" name="appDataidImpresaSelezionata" id="%{'tbImpTrovate-editcell-'+ (#attr.row_tbImpTrovate_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>

		<display:column headerClass="nosort" media="excel pdf">
		</display:column>
		<display:column property="denominazione" titleKey="cpGestImpresa.tbImpTrovate.denominazione.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="denominazione" titleKey="cpGestImpresa.tbImpTrovate.denominazione.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="denominazione" titleKey="cpGestImpresa.tbImpTrovate.denominazione.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="codiceFiscale" titleKey="cpGestImpresa.tbImpTrovate.codiceFiscale.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="codiceFiscale" titleKey="cpGestImpresa.tbImpTrovate.codiceFiscale.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="codiceFiscale" titleKey="cpGestImpresa.tbImpTrovate.codiceFiscale.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="codiceRea" titleKey="cpGestImpresa.tbImpTrovate.codiceRea.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="codiceRea" titleKey="cpGestImpresa.tbImpTrovate.codiceRea.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="codiceRea" titleKey="cpGestImpresa.tbImpTrovate.codiceRea.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="descStatoPg" titleKey="cpGestImpresa.tbImpTrovate.descStatoPg.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="descStatoPg" titleKey="cpGestImpresa.tbImpTrovate.descStatoPg.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="descStatoPg" titleKey="cpGestImpresa.tbImpTrovate.descStatoPg.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="descFlgDm37LetteraC" titleKey="cpGestImpresa.tbImpTrovate.descFlgDm37LetteraC.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="descFlgDm37LetteraC" titleKey="cpGestImpresa.tbImpTrovate.descFlgDm37LetteraC.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="descFlgDm37LetteraC" titleKey="cpGestImpresa.tbImpTrovate.descFlgDm37LetteraC.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="descFlgAltraImpresa" titleKey="cpGestImpresa.tbImpTrovate.descFlgAltraImpresa.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="descFlgAltraImpresa" titleKey="cpGestImpresa.tbImpTrovate.descFlgAltraImpresa.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="descFlgAltraImpresa" titleKey="cpGestImpresa.tbImpTrovate.descFlgAltraImpresa.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="descFlgTerzoResponsabile" titleKey="cpGestImpresa.tbImpTrovate.descFlgTerzoResponsabile.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="descFlgTerzoResponsabile" titleKey="cpGestImpresa.tbImpTrovate.descFlgTerzoResponsabile.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="descFlgTerzoResponsabile" titleKey="cpGestImpresa.tbImpTrovate.descFlgTerzoResponsabile.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="descFlgDistributore" titleKey="cpGestImpresa.tbImpTrovate.descFlgDistributore.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="descFlgDistributore" titleKey="cpGestImpresa.tbImpTrovate.descFlgDistributore.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="descFlgDistributore" titleKey="cpGestImpresa.tbImpTrovate.descFlgDistributore.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="descFlgCat" titleKey="cpGestImpresa.tbImpTrovate.descFlgCat.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="descFlgCat" titleKey="cpGestImpresa.tbImpTrovate.descFlgCat.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="descFlgCat" titleKey="cpGestImpresa.tbImpTrovate.descFlgCat.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpImpTrovate --></div>

			
	
	<div id="p_cpImprese" class="commandPanelBlock"><!-- startFragment:p_cpImprese -->
	
	
<div class="commandPanel functional" id="cpImprese">

	
	
		
		
<s:if test="isWidgetVisible('cpGestImpresa','btDettaglio')" >

	



<!-- widget btDettaglio -->
<s:submit name="widg_btDettaglio" id="widg_btDettaglio" method="handleBtDettaglio_CLICKED"
	key="cpGestImpresa.btDettaglio.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpresa','btDettaglio')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestImpresa','btVisura')" >

	



<!-- widget btVisura -->
<s:submit name="widg_btVisura" id="widg_btVisura" method="handleBtVisura_CLICKED"
	key="cpGestImpresa.btVisura.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpresa','btVisura')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestImpresa','btDaticat')" >

	



<!-- widget btDaticat -->
<s:submit name="widg_btDaticat" id="widg_btDaticat" method="handleBtDaticat_CLICKED"
	key="cpGestImpresa.btDaticat.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpresa','btDaticat')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cpImprese --></div>

	

		
	
</div>

	<!-- endFragment:p_fpImpTrovate --></div>
