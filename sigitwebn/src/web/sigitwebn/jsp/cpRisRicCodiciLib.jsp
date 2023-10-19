<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/risultato_ricerca_codici_impianto_liberi/CpRisRicCodiciLibAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/risultato_ricerca_codici_impianto_liberi -->
<!-- pageId:cpRisRicCodiciLib -->

<s:form id="cpRisRicCodiciLib" action="cpRisRicCodiciLib" namespace="/base/risultato_ricerca_codici_impianto_liberi" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpRisRicCodiciLib_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpRisRicCodiciLib','menu')" >

	


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

	
	

	
	
			
	
	<div id="p_fpRisRicCodiciLib" class="formPanelBlock"><!-- startFragment:p_fpRisRicCodiciLib -->
		
	
<h4 class="fpLabel"><s:text name="cpRisRicCodiciLib.fpRisRicCodiciLib.label" /></h4>
<div class="formPanel" id="fpRisRicCodiciLib">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpRisRicCodiciLib --></div>

			
	
	<div id="p_stdMsgPRisRicCodLib" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgPRisRicCodLib -->
	
	
<div class="stdMessagePanel" id="stdMsgPRisRicCodLib">
	<customtag:stdMessagePanel id="stdMsgPRisRicCodLib" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgPRisRicCodLib --></div>

			
	
	<div id="p_wpRisRicCodiciLib" class="widgetsPanelBlock"><!-- startFragment:p_wpRisRicCodiciLib -->
	
	

<div class="widgetsPanel" id="wpRisRicCodiciLib">
	

	
	
<s:if test="isWidgetVisible('cpRisRicCodiciLib','tbRisultatoRicCodiciLib')" >

	
<div class="tableWidget">


<!-- widget tbRisultatoRicCodiciLib -->
	<csiuicore:ajaxify id="p_wpRisRicCodiciLib" 
		widgetType="table"		
		pageId="cpRisRicCodiciLib"
		javascriptDetection="false">
<s:set name="cpRisRicCodiciLib_tbRisultatoRicCodiciLib_clearStatus" value="isTableClearStatus('cpRisRicCodiciLib_tbRisultatoRicCodiciLib')" />
<s:url id="cpRisRicCodiciLibViewUrl"						   
					   action="cpRisRicCodiciLib"
					   namespace="/base/risultato_ricerca_codici_impianto_liberi"/>
<display:table name="appDataelencoCodImpiantoLiberi"  				
			   excludedParams="*"			   export="false"
               id="widg_tbRisultatoRicCodiciLib"
               pagesize="10"
               keepStatus="true"
               requestURI="${cpRisRicCodiciLibViewUrl}"  
               clearStatus="${cpRisRicCodiciLib_tbRisultatoRicCodiciLib_clearStatus}"
               uid="row_tbRisultatoRicCodiciLib"
               summary="" 
               class="dataTable">
	
		<display:column property="codiceRea" titleKey="cpRisRicCodiciLib.tbRisultatoRicCodiciLib.codiceRea.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="codiceFiscale" titleKey="cpRisRicCodiciLib.tbRisultatoRicCodiciLib.codiceFiscale.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="denominazione" titleKey="cpRisRicCodiciLib.tbRisultatoRicCodiciLib.denominazione.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="codiceImpianto" titleKey="cpRisRicCodiciLib.tbRisultatoRicCodiciLib.codiceImpianto.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="flgPotLibero" titleKey="cpRisRicCodiciLib.tbRisultatoRicCodiciLib.flgPotLibero.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpRisRicCodiciLib --></div>

			
	
	<div id="p_cpNavRisRicCod" class="commandPanelBlock"><!-- startFragment:p_cpNavRisRicCod -->
	
	
<div class="commandPanel navigation" id="cpNavRisRicCod">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRisRicCodiciLib','btnIndietro')" >

	



<!-- widget btnIndietro -->
<s:submit name="widg_btnIndietro" id="widg_btnIndietro" method="handleBtnIndietro_CLICKED"
	key="cpRisRicCodiciLib.btnIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisRicCodiciLib','btnIndietro')" />

	


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
