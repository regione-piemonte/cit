<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_terzo_responsabile/CpGest3RespAction" />

	
	<div id="p_fpRespImp2" class="formPanelBlock"><!-- startFragment:p_fpRespImp2 -->
		
	
<div class="formPanel" id="fpRespImp2">


	
	

	
	
			
	
	<div id="p_wpRespImpianto2" class="widgetsPanelBlock"><!-- startFragment:p_wpRespImpianto2 -->
	
	
<h4 class="wpLabel">Responsabili dell'impianto </h4>
<div class="widgetsPanel" id="wpRespImpianto2">
	

	
	
<s:if test="isWidgetVisible('cpGest3Resp','tbRespImpianto3Resp')" >

	
<div class="tableWidget">


<!-- widget tbRespImpianto3Resp -->
	<csiuicore:ajaxify id="p_wpRespImpianto2" 
		widgetType="table"		
		pageId="cpGest3Resp"
		javascriptDetection="false">
<s:set name="cpGest3Resp_tbRespImpianto3Resp_clearStatus" value="isTableClearStatus('cpGest3Resp_tbRespImpianto3Resp')" />
<s:url id="cpGest3RespViewUrl"						   
					   action="cpGest3Resp"
					   namespace="/base/gestisci_terzo_responsabile"/>
<display:table name="appDataelencoResponsabiliImpianto"  				
			   excludedParams="*"			   export="true"
               id="widg_tbRespImpianto3Resp"
               pagesize="4"
               keepStatus="true"
               requestURI="${cpGest3RespViewUrl}"  
               clearStatus="${cpGest3Resp_tbRespImpianto3Resp_clearStatus}"
               uid="row_tbRespImpianto3Resp"
               summary="" 
               class="dataTable">
	
		<display:column property="denominazione" titleKey="cpGest3Resp.tbRespImpianto3Resp.denominazione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="denominazione" titleKey="cpGest3Resp.tbRespImpianto3Resp.denominazione.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="denominazione" titleKey="cpGest3Resp.tbRespImpianto3Resp.denominazione.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
		<display:column property="descTitolo" titleKey="cpGest3Resp.tbRespImpianto3Resp.descTitolo.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="descTitolo" titleKey="cpGest3Resp.tbRespImpianto3Resp.descTitolo.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="descTitolo" titleKey="cpGest3Resp.tbRespImpianto3Resp.descTitolo.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
		<display:column property="dataRespDal" titleKey="cpGest3Resp.tbRespImpianto3Resp.dataRespDal.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="dataRespDal" titleKey="cpGest3Resp.tbRespImpianto3Resp.dataRespDal.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="dataRespDal" titleKey="cpGest3Resp.tbRespImpianto3Resp.dataRespDal.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
		<display:column property="dataRespAl" titleKey="cpGest3Resp.tbRespImpianto3Resp.dataRespAl.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="dataRespAl" titleKey="cpGest3Resp.tbRespImpianto3Resp.dataRespAl.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="dataRespAl" titleKey="cpGest3Resp.tbRespImpianto3Resp.dataRespAl.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpRespImpianto2 --></div>

	

		
	
</div>

	<!-- endFragment:p_fpRespImp2 --></div>
