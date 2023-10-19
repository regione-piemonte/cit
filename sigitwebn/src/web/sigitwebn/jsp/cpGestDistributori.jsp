<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_distributori/CpGestDistributoriAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_distributori -->
<!-- pageId:cpGestDistributori -->

<s:form id="cpGestDistributori" action="cpGestDistributori" namespace="/base/gestisci_distributori" method="post" enctype="multipart/form-data">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestDistributori_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpGestDistributori','menu')" >

	


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

	
	

	
	
			
	
	<div id="p_fpGestDistributoriTitolo" class="formPanelBlock"><!-- startFragment:p_fpGestDistributoriTitolo -->
		
	
<h4 class="fpLabel"><s:text name="cpGestDistributori.fpGestDistributoriTitolo.label" /></h4>
<div class="formPanel" id="fpGestDistributoriTitolo">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpGestDistributoriTitolo --></div>

			
	
	<div id="p_fpGestDistributori" class="formPanelBlock"><!-- startFragment:p_fpGestDistributori -->
		
	
<div class="formPanel" id="fpGestDistributori">


	
	

	
	
			
	
	<div id="p_stdMsgPGestDistr" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgPGestDistr -->
	
	
<div class="stdMessagePanel" id="stdMsgPGestDistr">
	<customtag:stdMessagePanel id="stdMsgPGestDistr" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgPGestDistr --></div>

			
	
	<div id="p_wpImpresa" class="widgetsPanelBlock"><!-- startFragment:p_wpImpresa -->
	
	
<h4 class="wpLabel">distributore </h4>
<div class="widgetsPanel" id="wpImpresa">
	
	<customtag:widgetsPanel id="wpImpresaTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestDistributori','cbImpSiglaRea')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestDistributori.cbImpSiglaRea.label')}" labelFor="widg_cbImpSiglaRea" errorFor="appDatadistributori.distrIdSiglaRea" labelId="cbImpSiglaReaLbl"
	position="first"  >


<!-- widget cbImpSiglaRea -->
<s:select name="appDatadistributori.distrIdSiglaRea" id="widg_cbImpSiglaRea"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoSiglaRea"
	  disabled="isWidgetDisabled('cpGestDistributori','cbImpSiglaRea')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestDistributori','tfImpNumRea')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestDistributori.tfImpNumRea.label')}" labelFor="widg_tfImpNumRea" errorFor="appDatadistributori.distrNumeroRea" labelId="tfImpNumReaLbl"
	position="last"  >


<!-- widget tfImpNumRea -->
<s:textfield 
	
	
	name="appDatadistributori.distrNumeroRea" id="widg_tfImpNumRea"
maxlength="9"	disabled="isWidgetDisabled('cpGestDistributori','tfImpNumRea')"
	size="20" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestDistributori','tfInstCf')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestDistributori.tfInstCf.label')}" labelFor="widg_tfInstCf" errorFor="appDatadistributori.distrCf" labelId="tfInstCfLbl"
	position="first"  >


<!-- widget tfInstCf -->
<s:textfield 
	
	
	name="appDatadistributori.distrCf" id="widg_tfInstCf"
maxlength="16"	disabled="isWidgetDisabled('cpGestDistributori','tfInstCf')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestDistributori','wpImpresa_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpImpresa_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestDistributori','btnImpCercaCF')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="first">


<!-- widget btnImpCercaCF -->
<s:submit name="widg_btnImpCercaCF" id="widg_btnImpCercaCF" method="handleBtnImpCercaCF_CLICKED"
	key="cpGestDistributori.btnImpCercaCF.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestDistributori','btnImpCercaCF')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestDistributori','btnImpNuovaRicercaCF')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnImpNuovaRicercaCF -->
<s:submit name="widg_btnImpNuovaRicercaCF" id="widg_btnImpNuovaRicercaCF" method="handleBtnImpNuovaRicercaCF_CLICKED"
	key="cpGestDistributori.btnImpNuovaRicercaCF.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestDistributori','btnImpNuovaRicercaCF')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestDistributori','tfImpImpresa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestDistributori.tfImpImpresa.label')}" labelFor="widg_tfImpImpresa" errorFor="appDatadistributori.distrImpresa" labelId="tfImpImpresaLbl"
	position="first"  >


<!-- widget tfImpImpresa -->
<s:textfield 
	
	
	name="appDatadistributori.distrImpresa" id="widg_tfImpImpresa"
maxlength="50"	disabled="isWidgetDisabled('cpGestDistributori','tfImpImpresa')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestDistributori','wpImpresa_4_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpImpresa_4_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpImpresa --></div>

	

		
	
</div>

	<!-- endFragment:p_fpGestDistributori --></div>

			
	
	
	<div id="p_mpInviati" class="panelBlock"><!-- startFragment:p_mpInviati -->
		

		
<s:if test="#session.cpGestDistributori_mpInviati_selectedMultiPanel == 'cpGestDistributori_mpInviati_fpInviati'">
	<s:include value="/jsp/multipanels/cpGestDistributori_mpInviati_fpInviati.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpInviati --></div>

			
	
	
	<div id="p_mpImport" class="panelBlock"><!-- startFragment:p_mpImport -->
		

		
<s:if test="#session.cpGestDistributori_mpImport_selectedMultiPanel == 'cpGestDistributori_mpImport_fpImport'">
	<s:include value="/jsp/multipanels/cpGestDistributori_mpImport_fpImport.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpImport --></div>

			
	
	
	<div id="p_mpDettaglio" class="panelBlock"><!-- startFragment:p_mpDettaglio -->
		

		
<s:if test="#session.cpGestDistributori_mpDettaglio_selectedMultiPanel == 'cpGestDistributori_mpDettaglio_fpDettaglio'">
	<s:include value="/jsp/multipanels/cpGestDistributori_mpDettaglio_fpDettaglio.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpDettaglio --></div>

			
	
	<div id="p_cpNavGestDistributori" class="commandPanelBlock"><!-- startFragment:p_cpNavGestDistributori -->
	
	
<div class="commandPanel navigation" id="cpNavGestDistributori">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestDistributori','btnDistrIndietro')" >

	



<!-- widget btnDistrIndietro -->
<s:submit name="widg_btnDistrIndietro" id="widg_btnDistrIndietro" method="handleBtnDistrIndietro_CLICKED"
	key="cpGestDistributori.btnDistrIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestDistributori','btnDistrIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavGestDistributori --></div>

	

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
