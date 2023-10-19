<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/elencom/presentation/elencom/action/ricerca_module/CpRicercaAction" />

	
	<div id="p_fpTab" class="formPanelBlock"><!-- startFragment:p_fpTab -->
		
	


	
	

	
	
			
	
	<div id="p_pTabella" class="widgetsPanelBlock"><!-- startFragment:p_pTabella -->
	
	
<h4 class="wpLabel">Elenco persone giuridiche <span id="toggle_pTabella"></span></h4>
<div class="widgetsPanel" id="pTabella">
	

	
	
<s:if test="isWidgetVisible('cpRicerca','tbElenco')" >

	
<div class="tableWidget">


<!-- widget tbElenco -->
	<csiuicore:ajaxify id="p_pTabella" 
		widgetType="table"		
		pageId="cpRicerca"
		javascriptDetection="false">
<s:set name="cpRicerca_tbElenco_clearStatus" value="isTableClearStatus('cpRicerca_tbElenco')" />
<s:url id="cpRicercaViewUrl"						   
					   action="cpRicerca"
					   namespace="/base/ricerca_module"/>
<display:table name="appDatamanutentoriAppData"  				
			   excludedParams="*"			   export="true"
               id="widg_tbElenco"
               pagesize="20"
               keepStatus="true"
               requestURI="${cpRicercaViewUrl}"  
               clearStatus="${cpRicerca_tbElenco_clearStatus}"
               uid="row_tbElenco"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tbElenco.idManutentore}" name="appDataidManutentoreSelezionato" id="%{'tbElenco-editcell-'+ (#attr.row_tbElenco_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>

		<display:column headerClass="nosort" media="excel pdf">
		</display:column>
		<display:column property="denominazione" titleKey="cpRicerca.tbElenco.denominazione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="denominazione" titleKey="cpRicerca.tbElenco.denominazione.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="denominazione" titleKey="cpRicerca.tbElenco.denominazione.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
		<display:column property="provincia" titleKey="cpRicerca.tbElenco.provincia.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="provincia" titleKey="cpRicerca.tbElenco.provincia.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="provincia" titleKey="cpRicerca.tbElenco.provincia.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="comune" titleKey="cpRicerca.tbElenco.comune.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="comune" titleKey="cpRicerca.tbElenco.comune.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="comune" titleKey="cpRicerca.tbElenco.comune.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="indirizzo" titleKey="cpRicerca.tbElenco.indirizzo.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="indirizzo" titleKey="cpRicerca.tbElenco.indirizzo.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="indirizzo" titleKey="cpRicerca.tbElenco.indirizzo.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="civico" titleKey="cpRicerca.tbElenco.civico.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="civico" titleKey="cpRicerca.tbElenco.civico.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="civico" titleKey="cpRicerca.tbElenco.civico.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
		<display:column property="flgManutentore" titleKey="cpRicerca.tbElenco.flgManutentore.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="flgManutentore" titleKey="cpRicerca.tbElenco.flgManutentore.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="flgManutentore" titleKey="cpRicerca.tbElenco.flgManutentore.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
		<display:column property="flgTerzoResponsabile" titleKey="cpRicerca.tbElenco.flgTerzoResponsabile.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="flgTerzoResponsabile" titleKey="cpRicerca.tbElenco.flgTerzoResponsabile.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="flgTerzoResponsabile" titleKey="cpRicerca.tbElenco.flgTerzoResponsabile.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_pTabella --></div>

			
	
	<div id="p_cpDettMan" class="commandPanelBlock"><!-- startFragment:p_cpDettMan -->
	
	
<div class="commandPanel functional" id="cpDettMan">

	
	
		
		
<s:if test="isWidgetVisible('cpRicerca','btDettaglio')" >

	



<!-- widget btDettaglio -->
<s:submit name="widg_btDettaglio" id="widg_btDettaglio" method="handleBtDettaglio_CLICKED"
	key="cpRicerca.btDettaglio.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicerca','btDettaglio')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cpDettMan --></div>

			
	
	
	<div id="p_mpDettManu" class="panelBlock"><!-- startFragment:p_mpDettManu -->
		

		
<s:if test="#session.cpRicerca_mpDettManu_selectedMultiPanel == 'cpRicerca_mpDettManu_fpCorsi'">
	<s:include value="/jsp/multipanels/cpRicerca_mpDettManu_fpCorsi.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpDettManu --></div>

	

		
	

	<!-- endFragment:p_fpTab --></div>
