<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_delega/CpGestDelegaAction" />

	
	<div id="p_fpDelegati" class="formPanelBlock"><!-- startFragment:p_fpDelegati -->
		
	
<div class="formPanel" id="fpDelegati">


	
	

	
	
			
	
	<div id="p_wpDelegati" class="widgetsPanelBlock"><!-- startFragment:p_wpDelegati -->
	
	
<h4 class="wpLabel">elenco delegati </h4>
<div class="widgetsPanel" id="wpDelegati">
	

	
	
<s:if test="isWidgetVisible('cpGestDelega','tbDelegatiAssociati')" >

	
<div class="tableWidget">


<!-- widget tbDelegatiAssociati -->
	<csiuicore:ajaxify id="p_wpDelegati" 
		widgetType="table"		
		pageId="cpGestDelega"
		javascriptDetection="false">
<s:set name="cpGestDelega_tbDelegatiAssociati_clearStatus" value="isTableClearStatus('cpGestDelega_tbDelegatiAssociati')" />
<s:url id="cpGestDelegaViewUrl"						   
					   action="cpGestDelega"
					   namespace="/base/gestisci_delega"/>
<display:table name="appDataelencoDelegatiAssociati"  				
			   excludedParams="*"			   export="false"
               id="widg_tbDelegatiAssociati"
               pagesize="10"
               keepStatus="true"
               requestURI="${cpGestDelegaViewUrl}"  
               clearStatus="${cpGestDelega_tbDelegatiAssociati_clearStatus}"
               uid="row_tbDelegatiAssociati"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tbDelegatiAssociati.idDelegato}" name="appDataidDelegatoAssociatoSelez" id="%{'tbDelegatiAssociati-editcell-'+ (#attr.row_tbDelegatiAssociati_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="cognome" titleKey="cpGestDelega.tbDelegatiAssociati.cognome.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="nome" titleKey="cpGestDelega.tbDelegatiAssociati.nome.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="codiceFiscale" titleKey="cpGestDelega.tbDelegatiAssociati.codiceFiscale.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataDelegaDal" titleKey="cpGestDelega.tbDelegatiAssociati.dataDelegaDal.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataDelegaAl" titleKey="cpGestDelega.tbDelegatiAssociati.dataDelegaAl.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="descTipoLegame" titleKey="cpGestDelega.tbDelegatiAssociati.descTipoLegame.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpDelegati --></div>

			
	
	<div id="p_cpFunDelegati" class="commandPanelBlock"><!-- startFragment:p_cpFunDelegati -->
	
	
<div class="commandPanel functional" id="cpFunDelegati">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestDelega','btnInserisciDelegato')" >

	



<!-- widget btnInserisciDelegato -->
<s:submit name="widg_btnInserisciDelegato" id="widg_btnInserisciDelegato" method="handleBtnInserisciDelegato_CLICKED"
	key="cpGestDelega.btnInserisciDelegato.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestDelega','btnInserisciDelegato')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestDelega','btnCessaDelegato')" >

	



<!-- widget btnCessaDelegato -->
<s:submit name="widg_btnCessaDelegato" id="widg_btnCessaDelegato" method="handleBtnCessaDelegato_CLICKED"
	key="cpGestDelega.btnCessaDelegato.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestDelega','btnCessaDelegato')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunDelegati --></div>

	

		
	
</div>

	<!-- endFragment:p_fpDelegati --></div>
