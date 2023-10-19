<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_libretto_aggiornamenti/CpGestLibAggiornamentiAction" />

	
	<div id="p_fpElencoLibretti" class="formPanelBlock"><!-- startFragment:p_fpElencoLibretti -->
		
	
<div class="formPanel" id="fpElencoLibretti">


	
	

	
	
			
	
	<div id="p_wpElencoLibretti" class="widgetsPanelBlock"><!-- startFragment:p_wpElencoLibretti -->
	
	
<h4 class="wpLabel">archivio libretti consolidati </h4>
<div class="widgetsPanel" id="wpElencoLibretti">
	

	
	
<s:if test="isWidgetVisible('cpGestLibAggiornamenti','tbElencoLibretti')" >

	
<div class="tableWidget">


<!-- widget tbElencoLibretti -->
<s:set name="cpGestLibAggiornamenti_tbElencoLibretti_clearStatus" value="isTableClearStatus('cpGestLibAggiornamenti_tbElencoLibretti')" />
<s:url id="cpGestLibAggiornamentiViewUrl"						   
					   action="cpGestLibAggiornamenti"
					   namespace="/base/gestisci_libretto_aggiornamenti"/>
<display:table name="appDatalistaLibretti"  				
			   excludedParams="*"			   export="false"
               id="widg_tbElencoLibretti"
               pagesize="10"
               keepStatus="true"
               requestURI="${cpGestLibAggiornamentiViewUrl}"  
               clearStatus="${cpGestLibAggiornamenti_tbElencoLibretti_clearStatus}"
               uid="row_tbElencoLibretti"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tbElencoLibretti.idLibretto}" name="appDatarigaSelezionata" id="%{'tbElencoLibretti-editcell-'+ (#attr.row_tbElencoLibretti_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="dataConsolidamento" titleKey="cpGestLibAggiornamenti.tbElencoLibretti.dataConsolidamento.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="descTipoIntervento" titleKey="cpGestLibAggiornamenti.tbElencoLibretti.descTipoIntervento.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpElencoLibretti --></div>

			
	
	<div id="p_cpFunGestAggiornamenti" class="commandPanelBlock"><!-- startFragment:p_cpFunGestAggiornamenti -->
	
	
<div class="commandPanel functional" id="cpFunGestAggiornamenti">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestLibAggiornamenti','btLibretto')" >

	



<!-- widget btLibretto -->
<s:submit name="widg_btLibretto" id="widg_btLibretto" method="handleBtLibretto_CLICKED"
	key="cpGestLibAggiornamenti.btLibretto.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpGestLibAggiornamenti','btLibretto')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunGestAggiornamenti --></div>

	

		
	
</div>

	<!-- endFragment:p_fpElencoLibretti --></div>
