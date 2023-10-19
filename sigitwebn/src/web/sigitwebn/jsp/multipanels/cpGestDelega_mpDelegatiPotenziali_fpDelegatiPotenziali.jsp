<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_delega/CpGestDelegaAction" />

	
	<div id="p_fpDelegatiPotenziali" class="formPanelBlock"><!-- startFragment:p_fpDelegatiPotenziali -->
		
	
<div class="formPanel" id="fpDelegatiPotenziali">


	
	

	
	
			
	
	<div id="p_wpDelegatiPotenziali" class="widgetsPanelBlock"><!-- startFragment:p_wpDelegatiPotenziali -->
	
	
<h4 class="wpLabel">elenco potenziali delegati </h4>
<div class="widgetsPanel" id="wpDelegatiPotenziali">
	

	
	
<s:if test="isWidgetVisible('cpGestDelega','tbDelegatiPotenziali')" >

	
<div class="tableWidget">


<!-- widget tbDelegatiPotenziali -->
	<csiuicore:ajaxify id="p_wpDelegatiPotenziali" 
		widgetType="table"		
		pageId="cpGestDelega"
		javascriptDetection="false">
<s:set name="cpGestDelega_tbDelegatiPotenziali_clearStatus" value="isTableClearStatus('cpGestDelega_tbDelegatiPotenziali')" />
<s:url id="cpGestDelegaViewUrl"						   
					   action="cpGestDelega"
					   namespace="/base/gestisci_delega"/>
<display:table name="appDataelencoDelegatiPotenziali"  				
			   excludedParams="*"			   export="false"
               id="widg_tbDelegatiPotenziali"
               pagesize="10"
               keepStatus="true"
               requestURI="${cpGestDelegaViewUrl}"  
               clearStatus="${cpGestDelega_tbDelegatiPotenziali_clearStatus}"
               uid="row_tbDelegatiPotenziali"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tbDelegatiPotenziali.idDelegato}" name="appDataidDelegatoPotenzialeSelez" id="%{'tbDelegatiPotenziali-editcell-'+ (#attr.row_tbDelegatiPotenziali_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="cognome" titleKey="cpGestDelega.tbDelegatiPotenziali.cognome.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="nome" titleKey="cpGestDelega.tbDelegatiPotenziali.nome.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="codiceFiscale" titleKey="cpGestDelega.tbDelegatiPotenziali.codiceFiscale.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpDelegatiPotenziali --></div>

			
	
	<div id="p_cpFunDelegatiPotenziali" class="commandPanelBlock"><!-- startFragment:p_cpFunDelegatiPotenziali -->
	
	
<div class="commandPanel functional" id="cpFunDelegatiPotenziali">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestDelega','btnAnnullaPelegatoPot')" >

	



<!-- widget btnAnnullaPelegatoPot -->
<s:submit name="widg_btnAnnullaPelegatoPot" id="widg_btnAnnullaPelegatoPot" method="handleBtnAnnullaPelegatoPot_CLICKED"
	key="cpGestDelega.btnAnnullaPelegatoPot.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestDelega','btnAnnullaPelegatoPot')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpGestDelega','btnSelezionaDelegatoPot')" >

	



<!-- widget btnSelezionaDelegatoPot -->
<s:submit name="widg_btnSelezionaDelegatoPot" id="widg_btnSelezionaDelegatoPot" method="handleBtnSelezionaDelegatoPot_CLICKED"
	key="cpGestDelega.btnSelezionaDelegatoPot.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestDelega','btnSelezionaDelegatoPot')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunDelegatiPotenziali --></div>

	

		
	
</div>

	<!-- endFragment:p_fpDelegatiPotenziali --></div>
