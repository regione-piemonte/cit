<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/seleziona_ruolo/CpSelezRuoloAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/seleziona_ruolo -->
<!-- pageId:cpSelezRuolo -->

<s:form id="cpSelezRuolo" action="cpSelezRuolo" namespace="/base/seleziona_ruolo" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpSelezRuolo_udpTestalino.jsp"></s:include>

	



	

	<!-- endFragment:p_fpUpUserInfo --></div>

		</div>
	</div>
	<!-- ================ FINE UDLRC Layout UP PANEL ================ -->


	<!-- ================ UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->
	<div id="centerWrapper" class="floatWrapper">


		<!-- ***** UDLRC Layout CENTER PANEL ***** -->
		<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
			<div class="wrapper">

					
	
	<div id="p_fpCenter" class="formPanelBlock"><!-- startFragment:p_fpCenter -->

	
	

	
	
			
	
	<div id="p_fpSelezRuolo" class="formPanelBlock"><!-- startFragment:p_fpSelezRuolo -->
		
	
<div class="formPanel" id="fpSelezRuolo">


	
	

	
	
			
	
	<div id="p_stdMsgSelezRuolo" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgSelezRuolo -->
	
	
<div class="stdMessagePanel" id="stdMsgSelezRuolo">
	<customtag:stdMessagePanel id="stdMsgSelezRuolo" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgSelezRuolo --></div>

			
	
	<div id="p_wpFiltraRuoli" class="widgetsPanelBlock"><!-- startFragment:p_wpFiltraRuoli -->
	
	

<div class="widgetsPanel" id="wpFiltraRuoli">
	
	<customtag:widgetsPanel id="wpFiltraRuoliTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpSelezRuolo','cbFiltroRuoli')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpSelezRuolo.cbFiltroRuoli.label')}" labelFor="widg_cbFiltroRuoli" errorFor="appDatafiltroRuoloSelez" labelId="cbFiltroRuoliLbl"
	position="first"  >


<!-- widget cbFiltroRuoli -->
<s:select name="appDatafiltroRuoloSelez" id="widg_cbFiltroRuoli"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataruoliFiltro"
	  disabled="isWidgetDisabled('cpSelezRuolo','cbFiltroRuoli')"
	  listKey="denomDitta"
	  listValue="denomDitta"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue=""  position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpSelezRuolo','btnFiltraRuoli')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnFiltraRuoli -->
<s:submit name="widg_btnFiltraRuoli" id="widg_btnFiltraRuoli" method="handleBtnFiltraRuoli_CLICKED"
	key="cpSelezRuolo.btnFiltraRuoli.label" cssClass="buttonWidget search"
	disabled="isWidgetDisabled('cpSelezRuolo','btnFiltraRuoli')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue=""  position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpFiltraRuoli --></div>

			
	
	<div id="p_wpSelezRuolo" class="widgetsPanelBlock"><!-- startFragment:p_wpSelezRuolo -->
	
	

<div class="widgetsPanel" id="wpSelezRuolo">
	

	
	
<s:if test="isWidgetVisible('cpSelezRuolo','tbElencoRuoli')" >

	
<div class="tableWidget">


<!-- widget tbElencoRuoli -->
	<csiuicore:ajaxify id="p_wpSelezRuolo" 
		widgetType="table"		
		pageId="cpSelezRuolo"
		javascriptDetection="false">
<s:set name="cpSelezRuolo_tbElencoRuoli_clearStatus" value="isTableClearStatus('cpSelezRuolo_tbElencoRuoli')" />
<s:url id="cpSelezRuoloViewUrl"						   
					   action="cpSelezRuolo"
					   namespace="/base/seleziona_ruolo"/>
<display:table name="appDataruoliTrovatiFiltrati"  				
			   excludedParams="*"			   export="false"
               id="widg_tbElencoRuoli"
               pagesize="20"
               keepStatus="true"
               requestURI="${cpSelezRuoloViewUrl}"  
               clearStatus="${cpSelezRuolo_tbElencoRuoli_clearStatus}"
               uid="row_tbElencoRuoli"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tbElencoRuoli.idRuolo}" name="appDataidRuoloSelez" id="%{'tbElencoRuoli-editcell-'+ (#attr.row_tbElencoRuoli_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="descRuoloCompleto" titleKey="cpSelezRuolo.tbElencoRuoli.descRuoloCompleto.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="denomDitta" titleKey="cpSelezRuolo.tbElencoRuoli.denomDitta.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="codiceRea" titleKey="cpSelezRuolo.tbElencoRuoli.codiceRea.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="codiceFiscale" titleKey="cpSelezRuolo.tbElencoRuoli.codiceFiscale.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataCessazione" titleKey="cpSelezRuolo.tbElencoRuoli.dataCessazione.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="descCat" titleKey="cpSelezRuolo.tbElencoRuoli.descCat.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpSelezRuolo --></div>

			
	
	<div id="p_cpFunSelezRuolo" class="commandPanelBlock"><!-- startFragment:p_cpFunSelezRuolo -->
	
	
<div class="commandPanel functional" id="cpFunSelezRuolo">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpSelezRuolo','btnProseguiSelezRuolo')" >

	



<!-- widget btnProseguiSelezRuolo -->
<s:submit name="widg_btnProseguiSelezRuolo" id="widg_btnProseguiSelezRuolo" method="handleBtnProseguiSelezRuolo_CLICKED"
	key="cpSelezRuolo.btnProseguiSelezRuolo.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpSelezRuolo','btnProseguiSelezRuolo')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunSelezRuolo --></div>

	

		
	
</div>

	<!-- endFragment:p_fpSelezRuolo --></div>

	

	<!-- endFragment:p_fpCenter --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout CENTER PANEL ***** -->



	</div>
	<!-- ================ FINE UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->



</div>
<!-- #################### FINE PANNELLO CONTENUTI #################### -->




</s:form>


	<s:include value="fragments/footer.jsp" ></s:include>
