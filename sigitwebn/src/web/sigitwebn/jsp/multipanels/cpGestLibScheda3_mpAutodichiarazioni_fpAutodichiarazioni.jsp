<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_libretto_scheda3/CpGestLibScheda3Action" />

	
	<div id="p_fpAutodichiarazioni" class="formPanelBlock"><!-- startFragment:p_fpAutodichiarazioni -->
		
	
<div class="formPanel" id="fpAutodichiarazioni">


	
	

	
	
			
	
	<div id="p_wpAutodichiarazioni" class="widgetsPanelBlock"><!-- startFragment:p_wpAutodichiarazioni -->
	
	
<h4 class="wpLabel">Autodichiarazione dei titoli e dello stato dell'impianto </h4>
<div class="widgetsPanel" id="wpAutodichiarazioni">
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda3','tbAutodichiarazioni')" >

	
<div class="tableWidget">


<!-- widget tbAutodichiarazioni -->
	<csiuicore:ajaxify id="p_wpAutodichiarazioni" 
		widgetType="table"		
		pageId="cpGestLibScheda3"
		javascriptDetection="false">
<s:set name="cpGestLibScheda3_tbAutodichiarazioni_clearStatus" value="isTableClearStatus('cpGestLibScheda3_tbAutodichiarazioni')" />
<s:url id="cpGestLibScheda3ViewUrl"						   
					   action="cpGestLibScheda3"
					   namespace="/base/gestisci_libretto_scheda3"/>
<display:table name="appDataelencoAutodichiarazioni"  				
			   excludedParams="*"			   export="true"
               id="widg_tbAutodichiarazioni"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpGestLibScheda3ViewUrl}"  
               clearStatus="${cpGestLibScheda3_tbAutodichiarazioni_clearStatus}"
               uid="row_tbAutodichiarazioni"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:checkboxlist list="%{#attr.row_tbAutodichiarazioni.id}" name="appDataelencoIdSelezionati" id="%{'tbAutodichiarazioni-editcell-'+ (#attr.row_tbAutodichiarazioni_rowNum - 1)}" cssClass="checkbox"
			/>
		</display:column>

		<display:column headerClass="nosort" media="excel pdf">
		</display:column>
		<display:column property="description" titleKey="cpGestLibScheda3.tbAutodichiarazioni.description.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="description" titleKey="cpGestLibScheda3.tbAutodichiarazioni.description.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="description" titleKey="cpGestLibScheda3.tbAutodichiarazioni.description.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
</display:table>

<s:hidden name="__tableselectionempty_appDataelencoIdSelezionati" id="__tableselectionempty_widg_tbAutodichiarazioni" />


	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpAutodichiarazioni --></div>

	

		
	
</div>

	<!-- endFragment:p_fpAutodichiarazioni --></div>
