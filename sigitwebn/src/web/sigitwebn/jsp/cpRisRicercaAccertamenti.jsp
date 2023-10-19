<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/risultato_ricerca_accertamenti/CpRisRicercaAccertamentiAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/risultato_ricerca_accertamenti -->
<!-- pageId:cpRisRicercaAccertamenti -->

<s:form id="cpRisRicercaAccertamenti" action="cpRisRicercaAccertamenti" namespace="/base/risultato_ricerca_accertamenti" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpRisRicercaAccertamenti_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpRisRicercaAccertamenti','menu')" >

	


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

	
	

	
	
			
	
	<div id="p_fpTitle" class="formPanelBlock"><!-- startFragment:p_fpTitle -->
		
	
<h4 class="fpLabel"><s:text name="cpRisRicercaAccertamenti.fpTitle.label" /></h4>
<div class="formPanel" id="fpTitle">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpTitle --></div>

			
	
	<div id="p_stdMsg" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsg -->
	
	
<div class="stdMessagePanel" id="stdMsg">
	<customtag:stdMessagePanel id="stdMsg" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsg --></div>

			
	
	<div id="p_wpRisAcc" class="widgetsPanelBlock"><!-- startFragment:p_wpRisAcc -->
	
	
<h4 class="wpLabel">accertamenti trovati </h4>
<div class="widgetsPanel" id="wpRisAcc">
	

	
	
<s:if test="isWidgetVisible('cpRisRicercaAccertamenti','tbRisultatoRicercaAccertamenti')" >

	
<div class="tableWidget">


<!-- widget tbRisultatoRicercaAccertamenti -->
	<csiuicore:ajaxify id="p_wpRisAcc" 
		widgetType="table"		
		pageId="cpRisRicercaAccertamenti"
		javascriptDetection="false">
<s:set name="cpRisRicercaAccertamenti_tbRisultatoRicercaAccertamenti_clearStatus" value="isTableClearStatus('cpRisRicercaAccertamenti_tbRisultatoRicercaAccertamenti')" />
<s:url id="cpRisRicercaAccertamentiViewUrl"						   
					   action="cpRisRicercaAccertamenti"
					   namespace="/base/risultato_ricerca_accertamenti"/>
<display:table name="appDataelencoAccertamenti"  				
			   excludedParams="*"			   export="false"
               id="widg_tbRisultatoRicercaAccertamenti"
               pagesize="20"
               keepStatus="true"
               requestURI="${cpRisRicercaAccertamentiViewUrl}"  
               clearStatus="${cpRisRicercaAccertamenti_tbRisultatoRicercaAccertamenti_clearStatus}"
               uid="row_tbRisultatoRicercaAccertamenti"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tbRisultatoRicercaAccertamenti.identificativo}" name="appDataidAccertamentoSelezionato" id="%{'tbRisultatoRicercaAccertamenti-editcell-'+ (#attr.row_tbRisultatoRicercaAccertamenti_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="identificativo" titleKey="cpRisRicercaAccertamenti.tbRisultatoRicercaAccertamenti.identificativo.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="assegnatario" titleKey="cpRisRicercaAccertamenti.tbRisultatoRicercaAccertamenti.assegnatario.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataCreazione" titleKey="cpRisRicercaAccertamenti.tbRisultatoRicercaAccertamenti.dataCreazione.label" 
			sortable="true" headerClass="sortable"
			 comparator="it.csi.sigit.sigitwebn.presentation.sigitwebn.comparator.CsiDateComparator"   media="html"
			
 >
			
		</display:column>
		<display:column property="dataConclusione" titleKey="cpRisRicercaAccertamenti.tbRisultatoRicercaAccertamenti.dataConclusione.label" 
			sortable="true" headerClass="sortable"
			 comparator="it.csi.sigit.sigitwebn.presentation.sigitwebn.comparator.CsiDateComparator"   media="html"
			
 >
			
		</display:column>
		<display:column property="descStatoAccertamento" titleKey="cpRisRicercaAccertamenti.tbRisultatoRicercaAccertamenti.descStatoAccertamento.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="codiceImpianto" titleKey="cpRisRicercaAccertamenti.tbRisultatoRicercaAccertamenti.codiceImpianto.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="descTipoAnomalia" titleKey="cpRisRicercaAccertamenti.tbRisultatoRicercaAccertamenti.descTipoAnomalia.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="siglaProv" titleKey="cpRisRicercaAccertamenti.tbRisultatoRicercaAccertamenti.siglaProv.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpRisAcc --></div>

			
	
	<div id="p_cpExportExcel" class="commandPanelBlock"><!-- startFragment:p_cpExportExcel -->
	
	
<div class="commandPanel functional" id="cpExportExcel">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRisRicercaAccertamenti','btExportExcel')" >

	



<!-- widget btExportExcel -->
<s:submit name="widg_btExportExcel" id="widg_btExportExcel" method="handleBtExportExcel_CLICKED"
	key="cpRisRicercaAccertamenti.btExportExcel.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpRisRicercaAccertamenti','btExportExcel')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpExportExcel --></div>

			
	
	<div id="p_cpFun" class="commandPanelBlock"><!-- startFragment:p_cpFun -->
	
	
<div class="commandPanel functional" id="cpFun">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRisRicercaAccertamenti','btVisualizzaModifica')" >

	



<!-- widget btVisualizzaModifica -->
<s:submit name="widg_btVisualizzaModifica" id="widg_btVisualizzaModifica" method="handleBtVisualizzaModifica_CLICKED"
	key="cpRisRicercaAccertamenti.btVisualizzaModifica.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisRicercaAccertamenti','btVisualizzaModifica')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFun --></div>

			
	
	<div id="p_cpNav" class="commandPanelBlock"><!-- startFragment:p_cpNav -->
	
	
<div class="commandPanel navigation" id="cpNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRisRicercaAccertamenti','btIndietro')" >

	



<!-- widget btIndietro -->
<s:submit name="widg_btIndietro" id="widg_btIndietro" method="handleBtIndietro_CLICKED"
	key="cpRisRicercaAccertamenti.btIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisRicercaAccertamenti','btIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNav --></div>

	

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
