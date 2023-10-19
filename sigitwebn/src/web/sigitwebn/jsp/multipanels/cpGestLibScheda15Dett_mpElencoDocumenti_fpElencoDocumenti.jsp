<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_libretto_scheda15/CpGestLibScheda15DettAction" />

	
	<div id="p_fpElencoDocumenti" class="formPanelBlock"><!-- startFragment:p_fpElencoDocumenti -->
		
	
<div class="formPanel" id="fpElencoDocumenti">


	
	

	
	
			
	
	<div id="p_wpElencoDocumenti" class="widgetsPanelBlock"><!-- startFragment:p_wpElencoDocumenti -->
	
	

<div class="widgetsPanel" id="wpElencoDocumenti">
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda15Dett','tblElencoDocumenti')" >

	
<div class="tableWidget">


<!-- widget tblElencoDocumenti -->
	<csiuicore:ajaxify id="p_wpElencoDocumenti" 
		widgetType="table"		
		pageId="cpGestLibScheda15Dett"
		javascriptDetection="false">
<s:set name="cpGestLibScheda15Dett_tblElencoDocumenti_clearStatus" value="isTableClearStatus('cpGestLibScheda15Dett_tblElencoDocumenti')" />
<s:url id="cpGestLibScheda15DettViewUrl"						   
					   action="cpGestLibScheda15Dett"
					   namespace="/base/gestisci_libretto_scheda15"/>
<display:table name="appDataelencoDocumenti"  				
			   excludedParams="*"			   export="true"
               id="widg_tblElencoDocumenti"
               pagesize="10"
               keepStatus="true"
               requestURI="${cpGestLibScheda15DettViewUrl}"  
               clearStatus="${cpGestLibScheda15Dett_tblElencoDocumenti_clearStatus}"
               uid="row_tblElencoDocumenti"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tblElencoDocumenti.idDocumento}" name="appDataidDocumentoSelezionato" id="%{'tblElencoDocumenti-editcell-'+ (#attr.row_tblElencoDocumenti_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>

		<display:column headerClass="nosort" media="excel pdf">
		</display:column>
		<display:column property="nomeDocOrig" titleKey="cpGestLibScheda15Dett.tblElencoDocumenti.nomeDocOrig.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="nomeDocOrig" titleKey="cpGestLibScheda15Dett.tblElencoDocumenti.nomeDocOrig.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="nomeDocOrig" titleKey="cpGestLibScheda15Dett.tblElencoDocumenti.nomeDocOrig.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="descAltroDoc" titleKey="cpGestLibScheda15Dett.tblElencoDocumenti.descAltroDoc.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="descAltroDoc" titleKey="cpGestLibScheda15Dett.tblElencoDocumenti.descAltroDoc.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="descAltroDoc" titleKey="cpGestLibScheda15Dett.tblElencoDocumenti.descAltroDoc.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="dataUpload" titleKey="cpGestLibScheda15Dett.tblElencoDocumenti.dataUpload.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="dataUpload" titleKey="cpGestLibScheda15Dett.tblElencoDocumenti.dataUpload.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="dataUpload" titleKey="cpGestLibScheda15Dett.tblElencoDocumenti.dataUpload.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="descStatoDocumento" titleKey="cpGestLibScheda15Dett.tblElencoDocumenti.descStatoDocumento.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="descStatoDocumento" titleKey="cpGestLibScheda15Dett.tblElencoDocumenti.descStatoDocumento.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="descStatoDocumento" titleKey="cpGestLibScheda15Dett.tblElencoDocumenti.descStatoDocumento.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpElencoDocumenti --></div>

			
	
	<div id="p_cpFunzElencoDocumenti" class="commandPanelBlock"><!-- startFragment:p_cpFunzElencoDocumenti -->
	
	
<div class="commandPanel functional" id="cpFunzElencoDocumenti">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestLibScheda15Dett','btnVisualizzaDoc')" >

	



<!-- widget btnVisualizzaDoc -->
<s:submit name="widg_btnVisualizzaDoc" id="widg_btnVisualizzaDoc" method="handleBtnVisualizzaDoc_CLICKED"
	key="cpGestLibScheda15Dett.btnVisualizzaDoc.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpGestLibScheda15Dett','btnVisualizzaDoc')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestLibScheda15Dett','btnInserisciDocumento')" >

	



<!-- widget btnInserisciDocumento -->
<s:submit name="widg_btnInserisciDocumento" id="widg_btnInserisciDocumento" method="handleBtnInserisciDocumento_CLICKED"
	key="cpGestLibScheda15Dett.btnInserisciDocumento.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda15Dett','btnInserisciDocumento')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestLibScheda15Dett','btnEliminaDocumento')" >

	



<!-- widget btnEliminaDocumento -->
<s:submit name="widg_btnEliminaDocumento" id="widg_btnEliminaDocumento" method="handleBtnEliminaDocumento_CLICKED"
	key="cpGestLibScheda15Dett.btnEliminaDocumento.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda15Dett','btnEliminaDocumento')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunzElencoDocumenti --></div>

	

		
	
</div>

	<!-- endFragment:p_fpElencoDocumenti --></div>
