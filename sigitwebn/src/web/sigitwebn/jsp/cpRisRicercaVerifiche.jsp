<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/risultato_ricerca_verifiche/CpRisRicercaVerificheAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/risultato_ricerca_verifiche -->
<!-- pageId:cpRisRicercaVerifiche -->

<s:form id="cpRisRicercaVerifiche" action="cpRisRicercaVerifiche" namespace="/base/risultato_ricerca_verifiche" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpRisRicercaVerifiche_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpRisRicercaVerifiche','menu')" >

	


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
		
	
<h4 class="fpLabel"><s:text name="cpRisRicercaVerifiche.fpTitle.label" /></h4>
<div class="formPanel" id="fpTitle">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpTitle --></div>

			
	
	<div id="p_stdMsg" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsg -->
	
	
<div class="stdMessagePanel" id="stdMsg">
	<customtag:stdMessagePanel id="stdMsg" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsg --></div>

			
	
	<div id="p_wpRisVer" class="widgetsPanelBlock"><!-- startFragment:p_wpRisVer -->
	
	
<h4 class="wpLabel">verifiche trovate </h4>
<div class="widgetsPanel" id="wpRisVer">
	

	
	
<s:if test="isWidgetVisible('cpRisRicercaVerifiche','tbRisultatoRicercaVerifiche')" >

	
<div class="tableWidget">


<!-- widget tbRisultatoRicercaVerifiche -->
	<csiuicore:ajaxify id="p_wpRisVer" 
		widgetType="table"		
		pageId="cpRisRicercaVerifiche"
		javascriptDetection="false">
<s:set name="cpRisRicercaVerifiche_tbRisultatoRicercaVerifiche_clearStatus" value="isTableClearStatus('cpRisRicercaVerifiche_tbRisultatoRicercaVerifiche')" />
<s:url id="cpRisRicercaVerificheViewUrl"						   
					   action="cpRisRicercaVerifiche"
					   namespace="/base/risultato_ricerca_verifiche"/>
<display:table name="appDataelencoVerifiche"  				
			   excludedParams="*"			   export="false"
               id="widg_tbRisultatoRicercaVerifiche"
               pagesize="20"
               keepStatus="true"
               requestURI="${cpRisRicercaVerificheViewUrl}"  
               clearStatus="${cpRisRicercaVerifiche_tbRisultatoRicercaVerifiche_clearStatus}"
               uid="row_tbRisultatoRicercaVerifiche"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tbRisultatoRicercaVerifiche.identificativo}" name="appDataidVerificaSelezionata" id="%{'tbRisultatoRicercaVerifiche-editcell-'+ (#attr.row_tbRisultatoRicercaVerifiche_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="identificativo" titleKey="cpRisRicercaVerifiche.tbRisultatoRicercaVerifiche.identificativo.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="eseguitoDa" titleKey="cpRisRicercaVerifiche.tbRisultatoRicercaVerifiche.eseguitoDa.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataCaricamento" titleKey="cpRisRicercaVerifiche.tbRisultatoRicercaVerifiche.dataCaricamento.label" 
			sortable="true" headerClass="sortable"
			 comparator="it.csi.sigit.sigitwebn.presentation.sigitwebn.comparator.CsiDateComparator"   media="html"
			
 >
			
		</display:column>
		<display:column property="descrizioneTipoVerifica" titleKey="cpRisRicercaVerifiche.tbRisultatoRicercaVerifiche.descrizioneTipoVerifica.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="codiceImpianto" titleKey="cpRisRicercaVerifiche.tbRisultatoRicercaVerifiche.codiceImpianto.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="risultatoBollino" titleKey="cpRisRicercaVerifiche.tbRisultatoRicercaVerifiche.risultatoBollino.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="idDatoDistributore" titleKey="cpRisRicercaVerifiche.tbRisultatoRicercaVerifiche.idDatoDistributore.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpRisVer --></div>

			
	
	<div id="p_cpExportEcel" class="commandPanelBlock"><!-- startFragment:p_cpExportEcel -->
	
	
<div class="commandPanel functional" id="cpExportEcel">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRisRicercaVerifiche','btExportExcel')" >

	



<!-- widget btExportExcel -->
<s:submit name="widg_btExportExcel" id="widg_btExportExcel" method="handleBtExportExcel_CLICKED"
	key="cpRisRicercaVerifiche.btExportExcel.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpRisRicercaVerifiche','btExportExcel')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpExportEcel --></div>

			
	
	<div id="p_cpFun" class="commandPanelBlock"><!-- startFragment:p_cpFun -->
	
	
<div class="commandPanel functional" id="cpFun">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRisRicercaVerifiche','btInserisci')" >

	



<!-- widget btInserisci -->
<s:submit name="widg_btInserisci" id="widg_btInserisci" method="handleBtInserisci_CLICKED"
	key="cpRisRicercaVerifiche.btInserisci.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisRicercaVerifiche','btInserisci')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRisRicercaVerifiche','btVisualizzaModifica')" >

	



<!-- widget btVisualizzaModifica -->
<s:submit name="widg_btVisualizzaModifica" id="widg_btVisualizzaModifica" method="handleBtVisualizzaModifica_CLICKED"
	key="cpRisRicercaVerifiche.btVisualizzaModifica.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisRicercaVerifiche','btVisualizzaModifica')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRisRicercaVerifiche','btElimina')" >

	



<!-- widget btElimina -->
<s:submit name="widg_btElimina" id="widg_btElimina" method="handleBtElimina_CLICKED"
	key="cpRisRicercaVerifiche.btElimina.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisRicercaVerifiche','btElimina')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFun --></div>

			
	
	<div id="p_cpNav" class="commandPanelBlock"><!-- startFragment:p_cpNav -->
	
	
<div class="commandPanel navigation" id="cpNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRisRicercaVerifiche','btIndietro')" >

	



<!-- widget btIndietro -->
<s:submit name="widg_btIndietro" id="widg_btIndietro" method="handleBtIndietro_CLICKED"
	key="cpRisRicercaVerifiche.btIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisRicercaVerifiche','btIndietro')" />

	


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
