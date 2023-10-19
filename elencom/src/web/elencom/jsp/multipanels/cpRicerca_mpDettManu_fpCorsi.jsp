<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/elencom/presentation/elencom/action/ricerca_module/CpRicercaAction" />

	
	<div id="p_fpCorsi" class="formPanelBlock"><!-- startFragment:p_fpCorsi -->
		
	
<div class="formPanel" id="fpCorsi">


	
	

	
	
			
	
	<div id="p_wpDettImpresa" class="widgetsPanelBlock"><!-- startFragment:p_wpDettImpresa -->
	
	

<div class="widgetsPanel" id="wpDettImpresa">
	
	<customtag:widgetsPanel id="wpDettImpresaTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRicerca','tfDenomImpresa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicerca.tfDenomImpresa.label')}" labelFor="widg_tfDenomImpresa" errorFor="appDatamanutentoreAppData.denominazione" labelId="tfDenomImpresaLbl"
	position="first" colSpan="3" >


<!-- widget tfDenomImpresa -->
<s:textfield 
	
	
	name="appDatamanutentoreAppData.denominazione" id="widg_tfDenomImpresa"
	disabled="isWidgetDisabled('cpRicerca','tfDenomImpresa')"
	size="100" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicerca','tfUbicazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicerca.tfUbicazione.label')}" labelFor="widg_tfUbicazione" errorFor="appDatamanutentoreAppData.ubicazione" labelId="tfUbicazioneLbl"
	position="first" colSpan="3" >


<!-- widget tfUbicazione -->
<s:textfield 
	
	
	name="appDatamanutentoreAppData.ubicazione" id="widg_tfUbicazione"
	disabled="isWidgetDisabled('cpRicerca','tfUbicazione')"
	size="100" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicerca','tfDettImpresaMan')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicerca.tfDettImpresaMan.label')}" labelFor="widg_tfDettImpresaMan" errorFor="appDatamanutentoreAppData.flgManutentore" labelId="tfDettImpresaManLbl"
	position="first"  >


<!-- widget tfDettImpresaMan -->
<s:textfield 
	
	
	name="appDatamanutentoreAppData.flgManutentore" id="widg_tfDettImpresaMan"
	disabled="isWidgetDisabled('cpRicerca','tfDettImpresaMan')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicerca','tfDettImpresa3resp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicerca.tfDettImpresa3resp.label')}" labelFor="widg_tfDettImpresa3resp" errorFor="appDatamanutentoreAppData.flgTerzoResponsabile" labelId="tfDettImpresa3respLbl"
	position="last"  >


<!-- widget tfDettImpresa3resp -->
<s:textfield 
	
	
	name="appDatamanutentoreAppData.flgTerzoResponsabile" id="widg_tfDettImpresa3resp"
	disabled="isWidgetDisabled('cpRicerca','tfDettImpresa3resp')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDettImpresa --></div>

			
	
	<div id="p_wpCorsi" class="widgetsPanelBlock"><!-- startFragment:p_wpCorsi -->
	
	
<h4 class="wpLabel">Elenco corsi <span id="toggle_wpCorsi"></span></h4>
<div class="widgetsPanel" id="wpCorsi">
	

	
	
<s:if test="isWidgetVisible('cpRicerca','tbCorsi')" >

	
<div class="tableWidget">


<!-- widget tbCorsi -->
	<csiuicore:ajaxify id="p_wpCorsi" 
		widgetType="table"		
		pageId="cpRicerca"
		javascriptDetection="false">
<s:set name="cpRicerca_tbCorsi_clearStatus" value="isTableClearStatus('cpRicerca_tbCorsi')" />
<s:url id="cpRicercaViewUrl"						   
					   action="cpRicerca"
					   namespace="/base/ricerca_module"/>
<display:table name="appDataelencoCorsi"  				
			   excludedParams="*"			   export="true"
               id="widg_tbCorsi"
               pagesize="10"
               keepStatus="true"
               requestURI="${cpRicercaViewUrl}"  
               clearStatus="${cpRicerca_tbCorsi_clearStatus}"
               uid="row_tbCorsi"
               summary="" 
               class="dataTable">
	
		<display:column property="dataCorso" titleKey="cpRicerca.tbCorsi.dataCorso.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="dataCorso" titleKey="cpRicerca.tbCorsi.dataCorso.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="dataCorso" titleKey="cpRicerca.tbCorsi.dataCorso.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
		<display:column property="descrizione" titleKey="cpRicerca.tbCorsi.descrizione.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="descrizione" titleKey="cpRicerca.tbCorsi.descrizione.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="descrizione" titleKey="cpRicerca.tbCorsi.descrizione.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpCorsi --></div>

	

		
	
</div>

	<!-- endFragment:p_fpCorsi --></div>
