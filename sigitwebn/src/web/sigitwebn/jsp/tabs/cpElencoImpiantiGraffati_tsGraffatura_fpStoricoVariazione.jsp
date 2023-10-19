<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/elenco_impianti_graffati/CpElencoImpiantiGraffatiAction" />

	
	<div id="p_fpStoricoVariazione" class="formPanelBlock"><!-- startFragment:p_fpStoricoVariazione -->
		
	
<div class="formPanel" id="fpStoricoVariazione">


	
	

	
	
			
	
	<div id="p_stdMsgPElImpGraf" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgPElImpGraf -->
	
	
<div class="stdMessagePanel" id="stdMsgPElImpGraf">
	<customtag:stdMessagePanel id="stdMsgPElImpGraf" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgPElImpGraf --></div>

			
	
	<div id="p_wpStoricoVariazione" class="widgetsPanelBlock"><!-- startFragment:p_wpStoricoVariazione -->
	
	
<h4 class="wpLabel">impianti trovati </h4>
<div class="widgetsPanel" id="wpStoricoVariazione">
	

	
	
<s:if test="isWidgetVisible('cpElencoImpiantiGraffati','tbStorico')" >

	
<div class="tableWidget">


<!-- widget tbStorico -->
	<csiuicore:ajaxify id="p_wpStoricoVariazione" 
		widgetType="table"		
		pageId="cpElencoImpiantiGraffati"
		javascriptDetection="false">
<s:set name="cpElencoImpiantiGraffati_tbStorico_clearStatus" value="isTableClearStatus('cpElencoImpiantiGraffati_tbStorico')" />
<s:url id="cpElencoImpiantiGraffatiViewUrl"						   
					   action="cpElencoImpiantiGraffati"
					   namespace="/base/elenco_impianti_graffati"/>
<display:table name="appDataelencoStoricoVariazioniStatoImpianto"  				
			   excludedParams="*"			   export="false"
               id="widg_tbStorico"
               pagesize="20"
               keepStatus="true"
               requestURI="${cpElencoImpiantiGraffatiViewUrl}"  
               clearStatus="${cpElencoImpiantiGraffati_tbStorico_clearStatus}"
               uid="row_tbStorico"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tbStorico.id}" name="appDataidStoricoStatoSelez" id="%{'tbStorico-editcell-'+ (#attr.row_tbStorico_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="dataEvento" titleKey="cpElencoImpiantiGraffati.tbStorico.dataEvento.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataVariazione" titleKey="cpElencoImpiantiGraffati.tbStorico.dataVariazione.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="motivo" titleKey="cpElencoImpiantiGraffati.tbStorico.motivo.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="statoDa" titleKey="cpElencoImpiantiGraffati.tbStorico.statoDa.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="statoA" titleKey="cpElencoImpiantiGraffati.tbStorico.statoA.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpStoricoVariazione --></div>

			
	
	<div id="p_cpNavStorico" class="commandPanelBlock"><!-- startFragment:p_cpNavStorico -->
	
	
<div class="commandPanel navigation" id="cpNavStorico">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpElencoImpiantiGraffati','btnIndietroStorico')" >

	



<!-- widget btnIndietroStorico -->
<s:submit name="widg_btnIndietroStorico" id="widg_btnIndietroStorico" method="handleBtnIndietroStorico_CLICKED"
	key="cpElencoImpiantiGraffati.btnIndietroStorico.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoImpiantiGraffati','btnIndietroStorico')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavStorico --></div>

	

		
	
</div>

	<!-- endFragment:p_fpStoricoVariazione --></div>
