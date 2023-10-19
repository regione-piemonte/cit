<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/risultato_ricerca_impianti_graffati/CpRisRicImpiantoGraffatoAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/risultato_ricerca_impianti_graffati -->
<!-- pageId:cpRisRicImpiantoGraffato -->

<s:form id="cpRisRicImpiantoGraffato" action="cpRisRicImpiantoGraffato" namespace="/base/risultato_ricerca_impianti_graffati" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpRisRicImpiantoGraffato_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpRisRicImpiantoGraffato','menu')" >

	


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
		
	
<h4 class="fpLabel"><s:text name="cpRisRicImpiantoGraffato.fpRisRicImpianto.label" /></h4>
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
	

	
	
<s:if test="isWidgetVisible('cpRisRicImpiantoGraffato','tbRisultatoRicImp')" >

	
<div class="tableWidget">


<!-- widget tbRisultatoRicImp -->
	<csiuicore:ajaxify id="p_wpRisImp" 
		widgetType="table"		
		pageId="cpRisRicImpiantoGraffato"
		javascriptDetection="false">
<s:set name="cpRisRicImpiantoGraffato_tbRisultatoRicImp_clearStatus" value="isTableClearStatus('cpRisRicImpiantoGraffato_tbRisultatoRicImp')" />
<s:url id="cpRisRicImpiantoGraffatoViewUrl"						   
					   action="cpRisRicImpiantoGraffato"
					   namespace="/base/risultato_ricerca_impianti_graffati"/>
<display:table name="appDatarisultatoRicercaImpianti"  				
			   excludedParams="*"			   export="false"
               id="widg_tbRisultatoRicImp"
               pagesize="20"
               keepStatus="true"
               requestURI="${cpRisRicImpiantoGraffatoViewUrl}"  
               clearStatus="${cpRisRicImpiantoGraffato_tbRisultatoRicImp_clearStatus}"
               uid="row_tbRisultatoRicImp"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tbRisultatoRicImp.codiceImpianto}" name="appDataidImpiantoSelez" id="%{'tbRisultatoRicImp-editcell-'+ (#attr.row_tbRisultatoRicImp_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="codiceImpianto" titleKey="cpRisRicImpiantoGraffato.tbRisultatoRicImp.codiceImpianto.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="descComune" titleKey="cpRisRicImpiantoGraffato.tbRisultatoRicImp.descComune.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="indirizzo" titleKey="cpRisRicImpiantoGraffato.tbRisultatoRicImp.indirizzo.label" 
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

			
	
	<div id="p_cpFunRisRicImpianto" class="commandPanelBlock"><!-- startFragment:p_cpFunRisRicImpianto -->
	
	
<div class="commandPanel functional" id="cpFunRisRicImpianto">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRisRicImpiantoGraffato','btnInsImpianto')" >

	



<!-- widget btnInsImpianto -->
<s:submit name="widg_btnInsImpianto" id="widg_btnInsImpianto" method="handleBtnInsImpianto_CLICKED"
	key="cpRisRicImpiantoGraffato.btnInsImpianto.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisRicImpiantoGraffato','btnInsImpianto')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunRisRicImpianto --></div>

			
	
	<div id="p_cpNavRisRicImpianto" class="commandPanelBlock"><!-- startFragment:p_cpNavRisRicImpianto -->
	
	
<div class="commandPanel navigation" id="cpNavRisRicImpianto">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRisRicImpiantoGraffato','btnIndietro')" >

	



<!-- widget btnIndietro -->
<s:submit name="widg_btnIndietro" id="widg_btnIndietro" method="handleBtnIndietro_CLICKED"
	key="cpRisRicImpiantoGraffato.btnIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisRicImpiantoGraffato','btnIndietro')" />

	


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
