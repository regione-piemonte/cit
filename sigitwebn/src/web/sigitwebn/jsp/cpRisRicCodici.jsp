<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/risultato_ricerca_codici_impianto/CpRisRicCodiciAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/risultato_ricerca_codici_impianto -->
<!-- pageId:cpRisRicCodici -->

<s:form id="cpRisRicCodici" action="cpRisRicCodici" namespace="/base/risultato_ricerca_codici_impianto" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpRisRicCodici_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpRisRicCodici','menu')" >

	


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

	
	

	
	
			
	
	<div id="p_fpRisRicCodici" class="formPanelBlock"><!-- startFragment:p_fpRisRicCodici -->
		
	
<h4 class="fpLabel"><s:text name="cpRisRicCodici.fpRisRicCodici.label" /></h4>
<div class="formPanel" id="fpRisRicCodici">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpRisRicCodici --></div>

			
	
	<div id="p_stdMsgPRisRicCod" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgPRisRicCod -->
	
	
<div class="stdMessagePanel" id="stdMsgPRisRicCod">
	<customtag:stdMessagePanel id="stdMsgPRisRicCod" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgPRisRicCod --></div>

			
	
	<div id="p_wpRisRicCodici" class="widgetsPanelBlock"><!-- startFragment:p_wpRisRicCodici -->
	
	

<div class="widgetsPanel" id="wpRisRicCodici">
	

	
	
<s:if test="isWidgetVisible('cpRisRicCodici','tbRisultatoRicCodici')" >

	
<div class="tableWidget">


<!-- widget tbRisultatoRicCodici -->
	<csiuicore:ajaxify id="p_wpRisRicCodici" 
		widgetType="table"		
		pageId="cpRisRicCodici"
		javascriptDetection="false">
<s:set name="cpRisRicCodici_tbRisultatoRicCodici_clearStatus" value="isTableClearStatus('cpRisRicCodici_tbRisultatoRicCodici')" />
<s:url id="cpRisRicCodiciViewUrl"						   
					   action="cpRisRicCodici"
					   namespace="/base/risultato_ricerca_codici_impianto"/>
<display:table name="appDataelencoCodImpianto"  				
			   excludedParams="*"			   export="false"
               id="widg_tbRisultatoRicCodici"
               pagesize="10"
               keepStatus="true"
               requestURI="${cpRisRicCodiciViewUrl}"  
               clearStatus="${cpRisRicCodici_tbRisultatoRicCodici_clearStatus}"
               uid="row_tbRisultatoRicCodici"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tbRisultatoRicCodici.idTransazione}" name="appDataidCodImpiantoSelez" id="%{'tbRisultatoRicCodici-editcell-'+ (#attr.row_tbRisultatoRicCodici_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="codiceRea" titleKey="cpRisRicCodici.tbRisultatoRicCodici.codiceRea.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="codiceFiscale" titleKey="cpRisRicCodici.tbRisultatoRicCodici.codiceFiscale.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="denominazione" titleKey="cpRisRicCodici.tbRisultatoRicCodici.denominazione.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="codiceFiscaleOp" titleKey="cpRisRicCodici.tbRisultatoRicCodici.codiceFiscaleOp.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataTransazione" titleKey="cpRisRicCodici.tbRisultatoRicCodici.dataTransazione.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="totCodici" titleKey="cpRisRicCodici.tbRisultatoRicCodici.totCodici.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="totCodiciLiberi" titleKey="cpRisRicCodici.tbRisultatoRicCodici.totCodiciLiberi.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="intervalloCodici" titleKey="cpRisRicCodici.tbRisultatoRicCodici.intervalloCodici.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpRisRicCodici --></div>

			
	
	<div id="p_cpFunRisRicCod" class="commandPanelBlock"><!-- startFragment:p_cpFunRisRicCod -->
	
	
<div class="commandPanel functional" id="cpFunRisRicCod">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRisRicCodici','btnAcquisisciCodici')" >

	



<!-- widget btnAcquisisciCodici -->
<s:submit name="widg_btnAcquisisciCodici" id="widg_btnAcquisisciCodici" method="handleBtnAcquisisciCodici_CLICKED"
	key="cpRisRicCodici.btnAcquisisciCodici.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisRicCodici','btnAcquisisciCodici')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRisRicCodici','btnDettaglioCodici')" >

	



<!-- widget btnDettaglioCodici -->
<s:submit name="widg_btnDettaglioCodici" id="widg_btnDettaglioCodici" method="handleBtnDettaglioCodici_CLICKED"
	key="cpRisRicCodici.btnDettaglioCodici.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisRicCodici','btnDettaglioCodici')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunRisRicCod --></div>

			
	
	<div id="p_cpNavRisRicCod" class="commandPanelBlock"><!-- startFragment:p_cpNavRisRicCod -->
	
	
<div class="commandPanel navigation" id="cpNavRisRicCod">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRisRicCodici','btnIndietro')" >

	



<!-- widget btnIndietro -->
<s:submit name="widg_btnIndietro" id="widg_btnIndietro" method="handleBtnIndietro_CLICKED"
	key="cpRisRicCodici.btnIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisRicCodici','btnIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavRisRicCod --></div>

	

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
