<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/risultato_ricerca_bollini/CpRisRicBolliniAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/risultato_ricerca_bollini -->
<!-- pageId:cpRisRicBollini -->

<s:form id="cpRisRicBollini" action="cpRisRicBollini" namespace="/base/risultato_ricerca_bollini" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpRisRicBollini_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpRisRicBollini','menu')" >

	


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

	
	

	
	
			
	
	<div id="p_fpRisRicBollini" class="formPanelBlock"><!-- startFragment:p_fpRisRicBollini -->
		
	
<h4 class="fpLabel"><s:text name="cpRisRicBollini.fpRisRicBollini.label" /></h4>
<div class="formPanel" id="fpRisRicBollini">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpRisRicBollini --></div>

			
	
	<div id="p_stdMsgPRisRicBollini" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgPRisRicBollini -->
	
	
<div class="stdMessagePanel" id="stdMsgPRisRicBollini">
	<customtag:stdMessagePanel id="stdMsgPRisRicBollini" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgPRisRicBollini --></div>

			
	
	<div id="p_wpRisRicBollini" class="widgetsPanelBlock"><!-- startFragment:p_wpRisRicBollini -->
	
	

<div class="widgetsPanel" id="wpRisRicBollini">
	

	
	
<s:if test="isWidgetVisible('cpRisRicBollini','tbRisultatoRicBollini')" >

	
<div class="tableWidget">


<!-- widget tbRisultatoRicBollini -->
	<csiuicore:ajaxify id="p_wpRisRicBollini" 
		widgetType="table"		
		pageId="cpRisRicBollini"
		javascriptDetection="false">
<s:set name="cpRisRicBollini_tbRisultatoRicBollini_clearStatus" value="isTableClearStatus('cpRisRicBollini_tbRisultatoRicBollini')" />
<s:url id="cpRisRicBolliniViewUrl"						   
					   action="cpRisRicBollini"
					   namespace="/base/risultato_ricerca_bollini"/>
<display:table name="appDataelencoBollini"  				
			   excludedParams="*"			   export="false"
               id="widg_tbRisultatoRicBollini"
               pagesize="10"
               keepStatus="true"
               requestURI="${cpRisRicBolliniViewUrl}"  
               clearStatus="${cpRisRicBollini_tbRisultatoRicBollini_clearStatus}"
               uid="row_tbRisultatoRicBollini"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tbRisultatoRicBollini.idTransazione}" name="appDataidBollinoSelez" id="%{'tbRisultatoRicBollini-editcell-'+ (#attr.row_tbRisultatoRicBollini_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="codiceRea" titleKey="cpRisRicBollini.tbRisultatoRicBollini.codiceRea.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="codiceFiscale" titleKey="cpRisRicBollini.tbRisultatoRicBollini.codiceFiscale.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="denominazione" titleKey="cpRisRicBollini.tbRisultatoRicBollini.denominazione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="codiceFiscaleOp" titleKey="cpRisRicBollini.tbRisultatoRicBollini.codiceFiscaleOp.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataTransazione" titleKey="cpRisRicBollini.tbRisultatoRicBollini.dataTransazione.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="siglaBollino" titleKey="cpRisRicBollini.tbRisultatoRicBollini.siglaBollino.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="totCodici" titleKey="cpRisRicBollini.tbRisultatoRicBollini.totCodici.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="intervalloCodici" titleKey="cpRisRicBollini.tbRisultatoRicBollini.intervalloCodici.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpRisRicBollini --></div>

			
	
	<div id="p_cpFunRisRicBollini" class="commandPanelBlock"><!-- startFragment:p_cpFunRisRicBollini -->
	
	
<div class="commandPanel functional" id="cpFunRisRicBollini">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRisRicBollini','btnAcquistaBollini')" >

	



<!-- widget btnAcquistaBollini -->
<s:submit name="widg_btnAcquistaBollini" id="widg_btnAcquistaBollini" method="handleBtnAcquistaBollini_CLICKED"
	key="cpRisRicBollini.btnAcquistaBollini.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisRicBollini','btnAcquistaBollini')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRisRicBollini','btnStampaRicevuta')" >

	



<!-- widget btnStampaRicevuta -->
<s:submit name="widg_btnStampaRicevuta" id="widg_btnStampaRicevuta" method="handleBtnStampaRicevuta_CLICKED"
	key="cpRisRicBollini.btnStampaRicevuta.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisRicBollini','btnStampaRicevuta')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunRisRicBollini --></div>

			
	
	<div id="p_cpNavRisRicBollini" class="commandPanelBlock"><!-- startFragment:p_cpNavRisRicBollini -->
	
	
<div class="commandPanel navigation" id="cpNavRisRicBollini">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRisRicBollini','btnIndietro')" >

	



<!-- widget btnIndietro -->
<s:submit name="widg_btnIndietro" id="widg_btnIndietro" method="handleBtnIndietro_CLICKED"
	key="cpRisRicBollini.btnIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisRicBollini','btnIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavRisRicBollini --></div>

	

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
