<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_ree_tipo1/CpGestReeTipo1Action" />

	
	<div id="p_fpAcquaReintegro" class="formPanelBlock"><!-- startFragment:p_fpAcquaReintegro -->
		
	
<div class="formPanel" id="fpAcquaReintegro">


	
	

	
	
			
	
	<div id="p_wpAcquaReintegro" class="widgetsPanelBlock"><!-- startFragment:p_wpAcquaReintegro -->
	
	
<h4 class="wpLabel">Acqua di reintegro nel circuito dell'impianto termico in presenza di contatore (dato non obbligatorio) </h4>
<div class="widgetsPanel" id="wpAcquaReintegro">
	

	
	
<s:if test="isWidgetVisible('cpGestReeTipo1','tbAcquaReintegro')" >

	
<div class="tableWidget">


<!-- widget tbAcquaReintegro -->
<s:set name="cpGestReeTipo1_tbAcquaReintegro_clearStatus" value="isTableClearStatus('cpGestReeTipo1_tbAcquaReintegro')" />
<s:url id="cpGestReeTipo1ViewUrl"						   
					   action="cpGestReeTipo1"
					   namespace="/base/gestisci_ree_tipo1"/>
<display:table name="appDataelencoConsumiTipo1B"  				
			   excludedParams="*"			   export="false"
               id="widg_tbAcquaReintegro"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpGestReeTipo1ViewUrl}"  
               clearStatus="${cpGestReeTipo1_tbAcquaReintegro_clearStatus}"
               uid="row_tbAcquaReintegro"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:checkboxlist list="%{#attr.row_tbAcquaReintegro.indice}" name="appDatatipo1BConsumiSelezionati" id="%{'tbAcquaReintegro-editcell-'+ (#attr.row_tbAcquaReintegro_rowNum - 1)}" cssClass="checkbox"
			/>
		</display:column>
		<display:column property="indice" titleKey="cpGestReeTipo1.tbAcquaReintegro.indice.label" 
			sortable="false" headerClass="nosort"
			format="{0,number,#,##0}"  class="numbers"  media="html"
			
 >
			
		</display:column>
		<display:column titleKey="cpGestReeTipo1.tbAcquaReintegro.esercizio.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoConsumiTipo1B['+(#attr.row_tbAcquaReintegro_rowNum - 1)+'].esercizio'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="cpGestReeTipo1.tbAcquaReintegro.letturaIniziale.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoConsumiTipo1B['+(#attr.row_tbAcquaReintegro_rowNum - 1)+'].letturaIniziale'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="cpGestReeTipo1.tbAcquaReintegro.letturaFinale.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoConsumiTipo1B['+(#attr.row_tbAcquaReintegro_rowNum - 1)+'].letturaFinale'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="cpGestReeTipo1.tbAcquaReintegro.consumoFinale.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoConsumiTipo1B['+(#attr.row_tbAcquaReintegro_rowNum - 1)+'].consumoFinale'}"   theme="csi-tableinput-rem" />
		</display:column>
		
</display:table>

<s:hidden name="__tableselectionempty_appDatatipo1BConsumiSelezionati" id="__tableselectionempty_widg_tbAcquaReintegro" />




	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpAcquaReintegro --></div>

			
	
	<div id="p_cpAcquaReintegro" class="commandPanelBlock"><!-- startFragment:p_cpAcquaReintegro -->
	
	
<div class="commandPanel functional" id="cpAcquaReintegro">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestReeTipo1','btAggiungiRigaAcquaReintegro')" >

	



<!-- widget btAggiungiRigaAcquaReintegro -->
<s:submit name="widg_btAggiungiRigaAcquaReintegro" id="widg_btAggiungiRigaAcquaReintegro" method="handleBtAggiungiRigaAcquaReintegro_CLICKED"
	key="cpGestReeTipo1.btAggiungiRigaAcquaReintegro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestReeTipo1','btAggiungiRigaAcquaReintegro')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestReeTipo1','btCancellaRigaAcquaReintegro')" >

	



<!-- widget btCancellaRigaAcquaReintegro -->
<s:submit name="widg_btCancellaRigaAcquaReintegro" id="widg_btCancellaRigaAcquaReintegro" method="handleBtCancellaRigaAcquaReintegro_CLICKED"
	key="cpGestReeTipo1.btCancellaRigaAcquaReintegro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestReeTipo1','btCancellaRigaAcquaReintegro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpAcquaReintegro --></div>

	

		
	
</div>

	<!-- endFragment:p_fpAcquaReintegro --></div>
