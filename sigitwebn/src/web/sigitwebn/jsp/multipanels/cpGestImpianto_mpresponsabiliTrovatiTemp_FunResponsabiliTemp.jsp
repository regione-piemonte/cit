<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_impianto/CpGestImpiantoAction" />

	
	<div id="p_FunResponsabiliTemp" class="formPanelBlock"><!-- startFragment:p_FunResponsabiliTemp -->
		
	
<div class="formPanel" id="FunResponsabiliTemp">


	
	

	
	
			
	
	<div id="p_wpResponsabiliTrovatiTemp" class="widgetsPanelBlock"><!-- startFragment:p_wpResponsabiliTrovatiTemp -->
	
	
<h4 class="wpLabel">elenco responsabili trovati </h4>
<div class="widgetsPanel" id="wpResponsabiliTrovatiTemp">
	

	
	
<s:if test="isWidgetVisible('cpGestImpianto','tbResponsabiliTrovatiTemp')" >

	
<div class="tableWidget">


<!-- widget tbResponsabiliTrovatiTemp -->
	<csiuicore:ajaxify id="p_wpResponsabiliTrovatiTemp" 
		widgetType="table"		
		pageId="cpGestImpianto"
		javascriptDetection="false">
<s:set name="cpGestImpianto_tbResponsabiliTrovatiTemp_clearStatus" value="isTableClearStatus('cpGestImpianto_tbResponsabiliTrovatiTemp')" />
<s:url id="cpGestImpiantoViewUrl"						   
					   action="cpGestImpianto"
					   namespace="/base/gestisci_impianto"/>
<display:table name="appDataelencoResponsabiliTemp"  				
			   excludedParams="*"			   export="false"
               id="widg_tbResponsabiliTrovatiTemp"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpGestImpiantoViewUrl}"  
               clearStatus="${cpGestImpianto_tbResponsabiliTrovatiTemp_clearStatus}"
               uid="row_tbResponsabiliTrovatiTemp"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tbResponsabiliTrovatiTemp.idResponsabile}" name="appDataidResponsabileSelez" id="%{'tbResponsabiliTrovatiTemp-editcell-'+ (#attr.row_tbResponsabiliTrovatiTemp_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="codiceFiscale" titleKey="cpGestImpianto.tbResponsabiliTrovatiTemp.codiceFiscale.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="codiceRea" titleKey="cpGestImpianto.tbResponsabiliTrovatiTemp.codiceRea.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="denomCompleta" titleKey="cpGestImpianto.tbResponsabiliTrovatiTemp.denomCompleta.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="descComuneProv" titleKey="cpGestImpianto.tbResponsabiliTrovatiTemp.descComuneProv.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dsIndirizzoCompleto" titleKey="cpGestImpianto.tbResponsabiliTrovatiTemp.dsIndirizzoCompleto.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpResponsabiliTrovatiTemp --></div>

			
	
	<div id="p_cpFunResponsabiliTemp" class="commandPanelBlock"><!-- startFragment:p_cpFunResponsabiliTemp -->
	
	
<div class="commandPanel functional" id="cpFunResponsabiliTemp">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestImpianto','btnRespTempAnnulla')" >

	



<!-- widget btnRespTempAnnulla -->
<s:submit name="widg_btnRespTempAnnulla" id="widg_btnRespTempAnnulla" method="handleBtnRespTempAnnulla_CLICKED"
	key="cpGestImpianto.btnRespTempAnnulla.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpianto','btnRespTempAnnulla')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpGestImpianto','btnRespTempSelez')" >

	



<!-- widget btnRespTempSelez -->
<s:submit name="widg_btnRespTempSelez" id="widg_btnRespTempSelez" method="handleBtnRespTempSelez_CLICKED"
	key="cpGestImpianto.btnRespTempSelez.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpianto','btnRespTempSelez')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunResponsabiliTemp --></div>

	

		
	
</div>

	<!-- endFragment:p_FunResponsabiliTemp --></div>
