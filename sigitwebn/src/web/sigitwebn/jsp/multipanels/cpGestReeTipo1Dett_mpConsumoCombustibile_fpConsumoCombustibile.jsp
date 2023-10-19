<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_ree_tipo1/CpGestReeTipo1DettAction" />

	
	<div id="p_fpConsumoCombustibile" class="formPanelBlock"><!-- startFragment:p_fpConsumoCombustibile -->
		
	
<div class="formPanel" id="fpConsumoCombustibile">


	
	

	
	
			
	
	<div id="p_wpConsumoCombustibile" class="widgetsPanelBlock"><!-- startFragment:p_wpConsumoCombustibile -->
	
	
<h4 class="wpLabel">Consumo di combustibile (dato non obbligatorio) </h4>
<div class="widgetsPanel" id="wpConsumoCombustibile">
	

	
	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','tbConsumoCombustibile')" >

	
<div class="tableWidget">


<!-- widget tbConsumoCombustibile -->
<s:set name="cpGestReeTipo1Dett_tbConsumoCombustibile_clearStatus" value="isTableClearStatus('cpGestReeTipo1Dett_tbConsumoCombustibile')" />
<s:url id="cpGestReeTipo1DettViewUrl"						   
					   action="cpGestReeTipo1Dett"
					   namespace="/base/gestisci_ree_tipo1"/>
<display:table name="appDataelencoConsumiTipo1B"  				
			   excludedParams="*"			   export="false"
               id="widg_tbConsumoCombustibile"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpGestReeTipo1DettViewUrl}"  
               clearStatus="${cpGestReeTipo1Dett_tbConsumoCombustibile_clearStatus}"
               uid="row_tbConsumoCombustibile"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:checkboxlist list="%{#attr.row_tbConsumoCombustibile.indice}" name="appDatatipo1BConsumiSelezionati" id="%{'tbConsumoCombustibile-editcell-'+ (#attr.row_tbConsumoCombustibile_rowNum - 1)}" cssClass="checkbox"
			/>
		</display:column>
		<display:column property="indice" titleKey="cpGestReeTipo1Dett.tbConsumoCombustibile.indice.label" 
			sortable="false" headerClass="nosort"
			format="{0,number,#,##0}"  class="numbers"  media="html"
			
 >
			
		</display:column>
		<display:column titleKey="cpGestReeTipo1Dett.tbConsumoCombustibile.idUnitaMisura.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoConsumiTipo1B['+(#attr.row_tbConsumoCombustibile_rowNum - 1)+'].idUnitaMisura'}" headerKey="" headerValue=""  list="appDataelencoUnitaMisuraREE"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column titleKey="cpGestReeTipo1Dett.tbConsumoCombustibile.esercizio.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoConsumiTipo1B['+(#attr.row_tbConsumoCombustibile_rowNum - 1)+'].esercizio'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="cpGestReeTipo1Dett.tbConsumoCombustibile.consumoFinale.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoConsumiTipo1B['+(#attr.row_tbConsumoCombustibile_rowNum - 1)+'].consumoFinale'}"   theme="csi-tableinput-rem" />
		</display:column>
		
</display:table>

<s:hidden name="__tableselectionempty_appDatatipo1BConsumiSelezionati" id="__tableselectionempty_widg_tbConsumoCombustibile" />




	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpConsumoCombustibile --></div>

			
	
	<div id="p_cpConsumoCombustibile" class="commandPanelBlock"><!-- startFragment:p_cpConsumoCombustibile -->
	
	
<div class="commandPanel functional" id="cpConsumoCombustibile">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','btAggiungiRigaConsumoCombustibile')" >

	



<!-- widget btAggiungiRigaConsumoCombustibile -->
<s:submit name="widg_btAggiungiRigaConsumoCombustibile" id="widg_btAggiungiRigaConsumoCombustibile" method="handleBtAggiungiRigaConsumoCombustibile_CLICKED"
	key="cpGestReeTipo1Dett.btAggiungiRigaConsumoCombustibile.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestReeTipo1Dett','btAggiungiRigaConsumoCombustibile')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','btCancellaRigaConsumoCombustibile')" >

	



<!-- widget btCancellaRigaConsumoCombustibile -->
<s:submit name="widg_btCancellaRigaConsumoCombustibile" id="widg_btCancellaRigaConsumoCombustibile" method="handleBtCancellaRigaConsumoCombustibile_CLICKED"
	key="cpGestReeTipo1Dett.btCancellaRigaConsumoCombustibile.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestReeTipo1Dett','btCancellaRigaConsumoCombustibile')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpConsumoCombustibile --></div>

	

		
	
</div>

	<!-- endFragment:p_fpConsumoCombustibile --></div>
