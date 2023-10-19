<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_impresa/CpGestImpresaAction" />

	
	<div id="p_fmVisuraImpresa" class="formPanelBlock"><!-- startFragment:p_fmVisuraImpresa -->
		
	
<div class="formPanel" id="fmVisuraImpresa">


	
	

	
	
			
	
	<div id="p_wpVisuraImpresa" class="widgetsPanelBlock"><!-- startFragment:p_wpVisuraImpresa -->
	
	
<h4 class="wpLabel">Visura impresa </h4>
<div class="widgetsPanel" id="wpVisuraImpresa">
	

	
	
<s:if test="isWidgetVisible('cpGestImpresa','tbVisuraImpresa')" >

	
<div class="tableWidget">


<!-- widget tbVisuraImpresa -->
	<csiuicore:ajaxify id="p_wpVisuraImpresa" 
		widgetType="table"		
		pageId="cpGestImpresa"
		javascriptDetection="false">
<s:set name="cpGestImpresa_tbVisuraImpresa_clearStatus" value="isTableClearStatus('cpGestImpresa_tbVisuraImpresa')" />
<s:url id="cpGestImpresaViewUrl"						   
					   action="cpGestImpresa"
					   namespace="/base/gestisci_impresa"/>
<display:table name="appDataelencoDatiVisura"  				
			   excludedParams="*"			   export="true"
               id="widg_tbVisuraImpresa"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpGestImpresaViewUrl}"  
               clearStatus="${cpGestImpresa_tbVisuraImpresa_clearStatus}"
               uid="row_tbVisuraImpresa"
               summary="" 
               class="dataTable">
	
		<display:column property="label" titleKey="cpGestImpresa.tbVisuraImpresa.label.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="label" titleKey="cpGestImpresa.tbVisuraImpresa.label.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="label" titleKey="cpGestImpresa.tbVisuraImpresa.label.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="value" titleKey="cpGestImpresa.tbVisuraImpresa.value.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="value" titleKey="cpGestImpresa.tbVisuraImpresa.value.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="value" titleKey="cpGestImpresa.tbVisuraImpresa.value.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpVisuraImpresa --></div>

	

		
	
</div>

	<!-- endFragment:p_fmVisuraImpresa --></div>
