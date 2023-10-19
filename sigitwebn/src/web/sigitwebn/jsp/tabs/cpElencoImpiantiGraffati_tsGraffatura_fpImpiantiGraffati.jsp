<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/elenco_impianti_graffati/CpElencoImpiantiGraffatiAction" />

	
	<div id="p_fpImpiantiGraffati" class="formPanelBlock"><!-- startFragment:p_fpImpiantiGraffati -->
		
	
<div class="formPanel" id="fpImpiantiGraffati">


	
	

	
	
			
	
	<div id="p_stdMsgPElImpGraf" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgPElImpGraf -->
	
	
<div class="stdMessagePanel" id="stdMsgPElImpGraf">
	<customtag:stdMessagePanel id="stdMsgPElImpGraf" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgPElImpGraf --></div>

			
	
	<div id="p_wpElenImpGraf" class="widgetsPanelBlock"><!-- startFragment:p_wpElenImpGraf -->
	
	
<h4 class="wpLabel">impianti trovati </h4>
<div class="widgetsPanel" id="wpElenImpGraf">
	

	
	
<s:if test="isWidgetVisible('cpElencoImpiantiGraffati','tbElencoImpGraf')" >

	
<div class="tableWidget">


<!-- widget tbElencoImpGraf -->
	<csiuicore:ajaxify id="p_wpElenImpGraf" 
		widgetType="table"		
		pageId="cpElencoImpiantiGraffati"
		javascriptDetection="false">
<s:set name="cpElencoImpiantiGraffati_tbElencoImpGraf_clearStatus" value="isTableClearStatus('cpElencoImpiantiGraffati_tbElencoImpGraf')" />
<s:url id="cpElencoImpiantiGraffatiViewUrl"						   
					   action="cpElencoImpiantiGraffati"
					   namespace="/base/elenco_impianti_graffati"/>
<display:table name="appDataelencoImpiantiGraffati"  				
			   excludedParams="*"			   export="false"
               id="widg_tbElencoImpGraf"
               pagesize="20"
               keepStatus="true"
               requestURI="${cpElencoImpiantiGraffatiViewUrl}"  
               clearStatus="${cpElencoImpiantiGraffati_tbElencoImpGraf_clearStatus}"
               uid="row_tbElencoImpGraf"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tbElencoImpGraf.chiaveGraff}" name="appDataidImpiantoGrafSelez" id="%{'tbElencoImpGraf-editcell-'+ (#attr.row_tbElencoImpGraf_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="codiceImpianto" titleKey="cpElencoImpiantiGraffati.tbElencoImpGraf.codiceImpianto.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="descComune" titleKey="cpElencoImpiantiGraffati.tbElencoImpGraf.descComune.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="indirizzo" titleKey="cpElencoImpiantiGraffati.tbElencoImpGraf.indirizzo.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="denomResponsabile" titleKey="cpElencoImpiantiGraffati.tbElencoImpGraf.denomResponsabile.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="denom3Responsabile" titleKey="cpElencoImpiantiGraffati.tbElencoImpGraf.denom3Responsabile.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpElenImpGraf --></div>

			
	
	<div id="p_cpFunImpGraff" class="commandPanelBlock"><!-- startFragment:p_cpFunImpGraff -->
	
	
<div class="commandPanel functional" id="cpFunImpGraff">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpElencoImpiantiGraffati','btnInsImpiantoGraf')" >

	



<!-- widget btnInsImpiantoGraf -->
<s:submit name="widg_btnInsImpiantoGraf" id="widg_btnInsImpiantoGraf" method="handleBtnInsImpiantoGraf_CLICKED"
	key="cpElencoImpiantiGraffati.btnInsImpiantoGraf.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoImpiantiGraffati','btnInsImpiantoGraf')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpElencoImpiantiGraffati','btnVisImpiantogGraf')" >

	



<!-- widget btnVisImpiantogGraf -->
<s:submit name="widg_btnVisImpiantogGraf" id="widg_btnVisImpiantogGraf" method="handleBtnVisImpiantogGraf_CLICKED"
	key="cpElencoImpiantiGraffati.btnVisImpiantogGraf.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoImpiantiGraffati','btnVisImpiantogGraf')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpElencoImpiantiGraffati','btnElimImpiantoGraf')" >

	



<!-- widget btnElimImpiantoGraf -->
<s:submit name="widg_btnElimImpiantoGraf" id="widg_btnElimImpiantoGraf" method="handleBtnElimImpiantoGraf_CLICKED"
	key="cpElencoImpiantiGraffati.btnElimImpiantoGraf.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoImpiantiGraffati','btnElimImpiantoGraf')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunImpGraff --></div>

			
	
	<div id="p_cpNavImpGraf" class="commandPanelBlock"><!-- startFragment:p_cpNavImpGraf -->
	
	
<div class="commandPanel navigation" id="cpNavImpGraf">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpElencoImpiantiGraffati','btnIndietro')" >

	



<!-- widget btnIndietro -->
<s:submit name="widg_btnIndietro" id="widg_btnIndietro" method="handleBtnIndietro_CLICKED"
	key="cpElencoImpiantiGraffati.btnIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoImpiantiGraffati','btnIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavImpGraf --></div>

	

		
	
</div>

	<!-- endFragment:p_fpImpiantiGraffati --></div>
