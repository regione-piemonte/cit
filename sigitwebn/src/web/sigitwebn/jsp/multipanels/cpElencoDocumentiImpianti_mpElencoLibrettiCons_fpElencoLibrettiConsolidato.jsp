<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/elenco_documenti_impianti/CpElencoDocumentiImpiantiAction" />

	
	<div id="p_fpElencoLibrettiConsolidato" class="formPanelBlock"><!-- startFragment:p_fpElencoLibrettiConsolidato -->
		
	
<div class="formPanel" id="fpElencoLibrettiConsolidato">


	
	

	
	
			
	
	<div id="p_wpArchivioLibrettiConsolidatiStorico" class="widgetsPanelBlock"><!-- startFragment:p_wpArchivioLibrettiConsolidatiStorico -->
	
	
<h4 class="wpLabel">archivio libretti consolidati (Storico) </h4>
<div class="widgetsPanel" id="wpArchivioLibrettiConsolidatiStorico">
	

	
	
<s:if test="isWidgetVisible('cpElencoDocumentiImpianti','tbArchivioElencoLibrettiConsolidatiStorico')" >

	
<div class="tableWidget">


<!-- widget tbArchivioElencoLibrettiConsolidatiStorico -->
<s:set name="cpElencoDocumentiImpianti_tbArchivioElencoLibrettiConsolidatiStorico_clearStatus" value="isTableClearStatus('cpElencoDocumentiImpianti_tbArchivioElencoLibrettiConsolidatiStorico')" />
<s:url id="cpElencoDocumentiImpiantiViewUrl"						   
					   action="cpElencoDocumentiImpianti"
					   namespace="/base/elenco_documenti_impianti"/>
<display:table name="appDatalistaLibretti"  				
			   excludedParams="*"			   export="false"
               id="widg_tbArchivioElencoLibrettiConsolidatiStorico"
               pagesize="5"
               keepStatus="true"
               requestURI="${cpElencoDocumentiImpiantiViewUrl}"  
               clearStatus="${cpElencoDocumentiImpianti_tbArchivioElencoLibrettiConsolidatiStorico_clearStatus}"
               uid="row_tbArchivioElencoLibrettiConsolidatiStorico"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tbArchivioElencoLibrettiConsolidatiStorico.idLibretto}" name="appDatarigaSelezionata" id="%{'tbArchivioElencoLibrettiConsolidatiStorico-editcell-'+ (#attr.row_tbArchivioElencoLibrettiConsolidatiStorico_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="dataConsolidamento" titleKey="cpElencoDocumentiImpianti.tbArchivioElencoLibrettiConsolidatiStorico.dataConsolidamento.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="descTipoIntervento" titleKey="cpElencoDocumentiImpianti.tbArchivioElencoLibrettiConsolidatiStorico.descTipoIntervento.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpArchivioLibrettiConsolidatiStorico --></div>

			
	
	<div id="p_cpVisualizzaLibrettoCons" class="commandPanelBlock"><!-- startFragment:p_cpVisualizzaLibrettoCons -->
	
	
<div class="commandPanel functional" id="cpVisualizzaLibrettoCons">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpElencoDocumentiImpianti','btLibretto')" >

	



<!-- widget btLibretto -->
<s:submit name="widg_btLibretto" id="widg_btLibretto" method="handleBtLibretto_CLICKED"
	key="cpElencoDocumentiImpianti.btLibretto.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpElencoDocumentiImpianti','btLibretto')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpVisualizzaLibrettoCons --></div>

	

		
	
</div>

	<!-- endFragment:p_fpElencoLibrettiConsolidato --></div>
