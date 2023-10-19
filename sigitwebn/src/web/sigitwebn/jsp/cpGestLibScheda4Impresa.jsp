<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_libretto_scheda4/CpGestLibScheda4ImpresaAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_libretto_scheda4 -->
<!-- pageId:cpGestLibScheda4Impresa -->

<s:form id="cpGestLibScheda4Impresa" action="cpGestLibScheda4Impresa" namespace="/base/gestisci_libretto_scheda4" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestLibScheda4Impresa_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpGestLibScheda4Impresa','menu')" >

	


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

	
	

	
	
			
	
	<div id="p_fpTitolo" class="formPanelBlock"><!-- startFragment:p_fpTitolo -->
		
	
<h4 class="fpLabel"><s:text name="cpGestLibScheda4Impresa.fpTitolo.label" /></h4>
<div class="formPanel" id="fpTitolo">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpTitolo --></div>

			
	
	<div id="p_stdMsgLibretto" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgLibretto -->
	
	
<div class="stdMessagePanel" id="stdMsgLibretto">
	<customtag:stdMessagePanel id="stdMsgLibretto" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgLibretto --></div>

			
	
	<div id="p_wpImpresa" class="widgetsPanelBlock"><!-- startFragment:p_wpImpresa -->
	
	
<h4 class="wpLabel">Ricercare l'impresa a cui associare il componente </h4>
<div class="widgetsPanel" id="wpImpresa">
	
	<customtag:widgetsPanel id="wpImpresaTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda4Impresa','cbImpSiglaRea')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda4Impresa.cbImpSiglaRea.label')}" labelFor="widg_cbImpSiglaRea" errorFor="appDataricercaImprese.siglaRea" labelId="cbImpSiglaReaLbl"
	position="first"  >


<!-- widget cbImpSiglaRea -->
<s:select name="appDataricercaImprese.siglaRea" id="widg_cbImpSiglaRea"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoSiglaRea"
	  disabled="isWidgetDisabled('cpGestLibScheda4Impresa','cbImpSiglaRea')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda4Impresa','tfImpNumRea')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda4Impresa.tfImpNumRea.label')}" labelFor="widg_tfImpNumRea" errorFor="appDataricercaImprese.numeroRea" labelId="tfImpNumReaLbl"
	position="last"  >


<!-- widget tfImpNumRea -->
<s:textfield 
	
	
	name="appDataricercaImprese.numeroRea" id="widg_tfImpNumRea"
maxlength="9"	disabled="isWidgetDisabled('cpGestLibScheda4Impresa','tfImpNumRea')"
	size="20" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda4Impresa','tfImpCf')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda4Impresa.tfImpCf.label')}" labelFor="widg_tfImpCf" errorFor="appDataricercaImprese.codiceFiscale" labelId="tfImpCfLbl"
	position="first"  >


<!-- widget tfImpCf -->
<s:textfield 
	
	
	name="appDataricercaImprese.codiceFiscale" id="widg_tfImpCf"
maxlength="16"	disabled="isWidgetDisabled('cpGestLibScheda4Impresa','tfImpCf')"
	size="20" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda4Impresa','wpImpresa_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpImpresa_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda4Impresa','btnImpCerca')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="first">


<!-- widget btnImpCerca -->
<s:submit name="widg_btnImpCerca" id="widg_btnImpCerca" method="handleBtnImpCerca_CLICKED"
	key="cpGestLibScheda4Impresa.btnImpCerca.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda4Impresa','btnImpCerca')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda4Impresa','wpImpresa_3_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpImpresa_3_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpImpresa --></div>

			
	
	<div id="p_wpImpTrovate" class="widgetsPanelBlock"><!-- startFragment:p_wpImpTrovate -->
	
	

<div class="widgetsPanel" id="wpImpTrovate">
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda4Impresa','tbImpTrovate')" >

	
<div class="tableWidget">


<!-- widget tbImpTrovate -->
	<csiuicore:ajaxify id="p_wpImpTrovate" 
		widgetType="table"		
		pageId="cpGestLibScheda4Impresa"
		javascriptDetection="false">
<s:set name="cpGestLibScheda4Impresa_tbImpTrovate_clearStatus" value="isTableClearStatus('cpGestLibScheda4Impresa_tbImpTrovate')" />
<s:url id="cpGestLibScheda4ImpresaViewUrl"						   
					   action="cpGestLibScheda4Impresa"
					   namespace="/base/gestisci_libretto_scheda4"/>
<display:table name="appDataelencoImprese"  				
			   excludedParams="*"			   export="true"
               id="widg_tbImpTrovate"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpGestLibScheda4ImpresaViewUrl}"  
               clearStatus="${cpGestLibScheda4Impresa_tbImpTrovate_clearStatus}"
               uid="row_tbImpTrovate"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tbImpTrovate.idPersonaGiuridica}" name="appDataidImpresaSelezionata" id="%{'tbImpTrovate-editcell-'+ (#attr.row_tbImpTrovate_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>

		<display:column headerClass="nosort" media="excel pdf">
		</display:column>
		<display:column property="denominazione" titleKey="cpGestLibScheda4Impresa.tbImpTrovate.denominazione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="denominazione" titleKey="cpGestLibScheda4Impresa.tbImpTrovate.denominazione.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="denominazione" titleKey="cpGestLibScheda4Impresa.tbImpTrovate.denominazione.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
		<display:column property="codiceFiscale" titleKey="cpGestLibScheda4Impresa.tbImpTrovate.codiceFiscale.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="codiceFiscale" titleKey="cpGestLibScheda4Impresa.tbImpTrovate.codiceFiscale.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="codiceFiscale" titleKey="cpGestLibScheda4Impresa.tbImpTrovate.codiceFiscale.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
		<display:column property="codiceRea" titleKey="cpGestLibScheda4Impresa.tbImpTrovate.codiceRea.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="codiceRea" titleKey="cpGestLibScheda4Impresa.tbImpTrovate.codiceRea.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="codiceRea" titleKey="cpGestLibScheda4Impresa.tbImpTrovate.codiceRea.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
		<display:column property="descStatoPg" titleKey="cpGestLibScheda4Impresa.tbImpTrovate.descStatoPg.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="descStatoPg" titleKey="cpGestLibScheda4Impresa.tbImpTrovate.descStatoPg.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="descStatoPg" titleKey="cpGestLibScheda4Impresa.tbImpTrovate.descStatoPg.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpImpTrovate --></div>

			
	
	<div id="p_cpFunGest" class="commandPanelBlock"><!-- startFragment:p_cpFunGest -->
	
	
<div class="commandPanel functional" id="cpFunGest">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestLibScheda4Impresa','bSeleziona')" >

	



<!-- widget bSeleziona -->
<s:submit name="widg_bSeleziona" id="widg_bSeleziona" method="handleBSeleziona_CLICKED"
	key="cpGestLibScheda4Impresa.bSeleziona.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda4Impresa','bSeleziona')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunGest --></div>

			
	
	<div id="p_cpNavGest" class="commandPanelBlock"><!-- startFragment:p_cpNavGest -->
	
	
<div class="commandPanel navigation" id="cpNavGest">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestLibScheda4Impresa','btIndietro')" >

	



<!-- widget btIndietro -->
<s:submit name="widg_btIndietro" id="widg_btIndietro" method="handleBtIndietro_CLICKED"
	key="cpGestLibScheda4Impresa.btIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda4Impresa','btIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavGest --></div>

	

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
