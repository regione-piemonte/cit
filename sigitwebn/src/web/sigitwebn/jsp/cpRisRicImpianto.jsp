<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/risultato_ricerca_impianti/CpRisRicImpiantoAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/risultato_ricerca_impianti -->
<!-- pageId:cpRisRicImpianto -->

<s:form id="cpRisRicImpianto" action="cpRisRicImpianto" namespace="/base/risultato_ricerca_impianti" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpRisRicImpianto_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpRisRicImpianto','menu')" >

	


	<s:include value="fragments/menu.jsp"></s:include>

	

</s:if>

	


		
	
	
</div>

	<!-- endFragment:p_menuPanel --></div>

	

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

	
	

	
	
			
	
	<div id="p_fpRisRicImpianto" class="formPanelBlock"><!-- startFragment:p_fpRisRicImpianto -->
		
	
<h4 class="fpLabel"><s:text name="cpRisRicImpianto.fpRisRicImpianto.label" /></h4>
<div class="formPanel" id="fpRisRicImpianto">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpRisRicImpianto --></div>

			
	
	<div id="p_stdMsgPRisRicImp" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgPRisRicImp -->
	
	
<div class="stdMessagePanel" id="stdMsgPRisRicImp">
	<customtag:stdMessagePanel id="stdMsgPRisRicImp" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgPRisRicImp --></div>

			
	
	<div id="p_wpRisImp" class="widgetsPanelBlock"><!-- startFragment:p_wpRisImp -->
	
	
<h4 class="wpLabel">impianti trovati </h4>
<div class="widgetsPanel" id="wpRisImp">
	

	
	
<s:if test="isWidgetVisible('cpRisRicImpianto','tbRisultatoRicImp')" >

	
<div class="tableWidget">


<!-- widget tbRisultatoRicImp -->
	<csiuicore:ajaxify id="p_wpRisImp" 
		widgetType="table"		
		pageId="cpRisRicImpianto"
		javascriptDetection="false">
<s:set name="cpRisRicImpianto_tbRisultatoRicImp_clearStatus" value="isTableClearStatus('cpRisRicImpianto_tbRisultatoRicImp')" />
<s:url id="cpRisRicImpiantoViewUrl"						   
					   action="cpRisRicImpianto"
					   namespace="/base/risultato_ricerca_impianti"/>
<display:table name="appDatarisultatoRicercaImpianti"  				
			   excludedParams="*"			   export="false"
               id="widg_tbRisultatoRicImp"
               pagesize="20"
               keepStatus="true"
               requestURI="${cpRisRicImpiantoViewUrl}"  
               clearStatus="${cpRisRicImpianto_tbRisultatoRicImp_clearStatus}"
               uid="row_tbRisultatoRicImp"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tbRisultatoRicImp.codiceImpianto}" name="appDataidImpiantoSelez" id="%{'tbRisultatoRicImp-editcell-'+ (#attr.row_tbRisultatoRicImp_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="codiceImpianto" titleKey="cpRisRicImpianto.tbRisultatoRicImp.codiceImpianto.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="descComune" titleKey="cpRisRicImpianto.tbRisultatoRicImp.descComune.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="indirizzo" titleKey="cpRisRicImpianto.tbRisultatoRicImp.indirizzo.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="denomResponsabile" titleKey="cpRisRicImpianto.tbRisultatoRicImp.denomResponsabile.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="statoImpianto" titleKey="cpRisRicImpianto.tbRisultatoRicImp.statoImpianto.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpRisImp --></div>

			
	
	<div id="p_cpExportExcel" class="commandPanelBlock"><!-- startFragment:p_cpExportExcel -->
	
	
<div class="commandPanel functional" id="cpExportExcel">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRisRicImpianto','btExportExcel')" >

	



<!-- widget btExportExcel -->
<s:submit name="widg_btExportExcel" id="widg_btExportExcel" method="handleBtExportExcel_CLICKED"
	key="cpRisRicImpianto.btExportExcel.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpRisRicImpianto','btExportExcel')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpExportExcel --></div>

			
	
	<div id="p_cpFunRisRicImpianto" class="commandPanelBlock"><!-- startFragment:p_cpFunRisRicImpianto -->
	
	
<div class="commandPanel functional" id="cpFunRisRicImpianto">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRisRicImpianto','btnInsImpianto')" >

	



<!-- widget btnInsImpianto -->
<s:submit name="widg_btnInsImpianto" id="widg_btnInsImpianto" method="handleBtnInsImpianto_CLICKED"
	key="cpRisRicImpianto.btnInsImpianto.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisRicImpianto','btnInsImpianto')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRisRicImpianto','btnInsImpiantoResp')" >

	



<!-- widget btnInsImpiantoResp -->
<s:submit name="widg_btnInsImpiantoResp" id="widg_btnInsImpiantoResp" method="handleBtnInsImpiantoResp_CLICKED"
	key="cpRisRicImpianto.btnInsImpiantoResp.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisRicImpianto','btnInsImpiantoResp')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRisRicImpianto','btnModImpianto')" >

	



<!-- widget btnModImpianto -->
<s:submit name="widg_btnModImpianto" id="widg_btnModImpianto" method="handleBtnModImpianto_CLICKED"
	key="cpRisRicImpianto.btnModImpianto.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisRicImpianto','btnModImpianto')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRisRicImpianto','btnModImpiantoResp')" >

	



<!-- widget btnModImpiantoResp -->
<s:submit name="widg_btnModImpiantoResp" id="widg_btnModImpiantoResp" method="handleBtnModImpiantoResp_CLICKED"
	key="cpRisRicImpianto.btnModImpiantoResp.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisRicImpianto','btnModImpiantoResp')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRisRicImpianto','btnVisImpianto')" >

	



<!-- widget btnVisImpianto -->
<s:submit name="widg_btnVisImpianto" id="widg_btnVisImpianto" method="handleBtnVisImpianto_CLICKED"
	key="cpRisRicImpianto.btnVisImpianto.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisRicImpianto','btnVisImpianto')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRisRicImpianto','btnElimImpianto')" >

	



<!-- widget btnElimImpianto -->
<s:submit name="widg_btnElimImpianto" id="widg_btnElimImpianto" method="handleBtnElimImpianto_CLICKED"
	key="cpRisRicImpianto.btnElimImpianto.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisRicImpianto','btnElimImpianto')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRisRicImpianto','btnVisRappControllo')" >

	



<!-- widget btnVisRappControllo -->
<s:submit name="widg_btnVisRappControllo" id="widg_btnVisRappControllo" method="handleBtnVisRappControllo_CLICKED"
	key="cpRisRicImpianto.btnVisRappControllo.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisRicImpianto','btnVisRappControllo')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRisRicImpianto','btnInsVerifica')" >

	



<!-- widget btnInsVerifica -->
<s:submit name="widg_btnInsVerifica" id="widg_btnInsVerifica" method="handleBtnInsVerifica_CLICKED"
	key="cpRisRicImpianto.btnInsVerifica.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisRicImpianto','btnInsVerifica')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRisRicImpianto','btnVisIspezioniOLD')" >

	



<!-- widget btnVisIspezioniOLD -->
<s:submit name="widg_btnVisIspezioniOLD" id="widg_btnVisIspezioniOLD" method="handleBtnVisIspezioniOLD_CLICKED"
	key="cpRisRicImpianto.btnVisIspezioniOLD.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisRicImpianto','btnVisIspezioniOLD')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRisRicImpianto','btnVisDocumentazione')" >

	



<!-- widget btnVisDocumentazione -->
<s:submit name="widg_btnVisDocumentazione" id="widg_btnVisDocumentazione" method="handleBtnVisDocumentazione_CLICKED"
	key="cpRisRicImpianto.btnVisDocumentazione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisRicImpianto','btnVisDocumentazione')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRisRicImpianto','btnVisLibrettoWeb')" >

	



<!-- widget btnVisLibrettoWeb -->
<s:submit name="widg_btnVisLibrettoWeb" id="widg_btnVisLibrettoWeb" method="handleBtnVisLibrettoWeb_CLICKED"
	key="cpRisRicImpianto.btnVisLibrettoWeb.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisRicImpianto','btnVisLibrettoWeb')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunRisRicImpianto --></div>

			
	
	<div id="p_cpNavRisRicImpianto" class="commandPanelBlock"><!-- startFragment:p_cpNavRisRicImpianto -->
	
	
<div class="commandPanel navigation" id="cpNavRisRicImpianto">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRisRicImpianto','btnIndietro')" >

	



<!-- widget btnIndietro -->
<s:submit name="widg_btnIndietro" id="widg_btnIndietro" method="handleBtnIndietro_CLICKED"
	key="cpRisRicImpianto.btnIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisRicImpianto','btnIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavRisRicImpianto --></div>

	

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
