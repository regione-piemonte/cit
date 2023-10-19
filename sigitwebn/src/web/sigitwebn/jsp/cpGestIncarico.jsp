<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_incarico/CpGestIncaricoAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_incarico -->
<!-- pageId:cpGestIncarico -->

<s:form id="cpGestIncarico" action="cpGestIncarico" namespace="/base/gestisci_incarico" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestIncarico_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpGestIncarico','menu')" >

	


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

	
	

	
	
			
	
	<div id="p_fpGestIncaricoTitolo" class="formPanelBlock"><!-- startFragment:p_fpGestIncaricoTitolo -->
		
	
<h4 class="fpLabel"><s:text name="cpGestIncarico.fpGestIncaricoTitolo.label" /></h4>
<div class="formPanel" id="fpGestIncaricoTitolo">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpGestIncaricoTitolo --></div>

			
	
	<div id="p_fpGestIncarico" class="formPanelBlock"><!-- startFragment:p_fpGestIncarico -->
		
	


	
	

	
	
			
	
	<div id="p_stdMsgPGestInc" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgPGestInc -->
	
	
<div class="stdMessagePanel" id="stdMsgPGestInc">
	<customtag:stdMessagePanel id="stdMsgPGestInc" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgPGestInc --></div>

			
	
	<div id="p_wpImpresa" class="widgetsPanelBlock"><!-- startFragment:p_wpImpresa -->
	
	
<h4 class="wpLabel">impresa </h4>
<div class="widgetsPanel" id="wpImpresa">
	
	<customtag:widgetsPanel id="wpImpresaTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestIncarico','cbImpSiglaRea')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestIncarico.cbImpSiglaRea.label')}" labelFor="widg_cbImpSiglaRea" errorFor="appDataincarico.impIdSiglaRea" labelId="cbImpSiglaReaLbl"
	position="first"  >


<!-- widget cbImpSiglaRea -->
<s:select name="appDataincarico.impIdSiglaRea" id="widg_cbImpSiglaRea"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoSiglaRea"
	  disabled="isWidgetDisabled('cpGestIncarico','cbImpSiglaRea')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestIncarico','tfImpNumRea')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestIncarico.tfImpNumRea.label')}" labelFor="widg_tfImpNumRea" errorFor="appDataincarico.impNumeroRea" labelId="tfImpNumReaLbl"
	position="last"  >


<!-- widget tfImpNumRea -->
<s:textfield 
	
	
	name="appDataincarico.impNumeroRea" id="widg_tfImpNumRea"
maxlength="9"	disabled="isWidgetDisabled('cpGestIncarico','tfImpNumRea')"
	size="20" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestIncarico','tfInstCf')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestIncarico.tfInstCf.label')}" labelFor="widg_tfInstCf" errorFor="appDataincarico.impCf" labelId="tfInstCfLbl"
	position="first"  >


<!-- widget tfInstCf -->
<s:textfield 
	
title=""	
	name="appDataincarico.impCf" id="widg_tfInstCf"
maxlength="16"	disabled="isWidgetDisabled('cpGestIncarico','tfInstCf')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestIncarico','wpImpresa_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpImpresa_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestIncarico','btnImpCercaCF')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="first">


<!-- widget btnImpCercaCF -->
<s:submit name="widg_btnImpCercaCF" id="widg_btnImpCercaCF" method="handleBtnImpCercaCF_CLICKED"
	key="cpGestIncarico.btnImpCercaCF.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestIncarico','btnImpCercaCF')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestIncarico','btnImpNuovaRicercaCF')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnImpNuovaRicercaCF -->
<s:submit name="widg_btnImpNuovaRicercaCF" id="widg_btnImpNuovaRicercaCF" method="handleBtnImpNuovaRicercaCF_CLICKED"
	key="cpGestIncarico.btnImpNuovaRicercaCF.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestIncarico','btnImpNuovaRicercaCF')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestIncarico','tfImpImpresa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestIncarico.tfImpImpresa.label')}" labelFor="widg_tfImpImpresa" errorFor="appDataincarico.impImpresa" labelId="tfImpImpresaLbl"
	position="first"  >


<!-- widget tfImpImpresa -->
<s:textfield 
	
	
	name="appDataincarico.impImpresa" id="widg_tfImpImpresa"
maxlength="50"	disabled="isWidgetDisabled('cpGestIncarico','tfImpImpresa')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestIncarico','wpImpresa_4_2_fictitious_')" >

	
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

			
	
	
	<div id="p_mpIncaricati" class="panelBlock"><!-- startFragment:p_mpIncaricati -->
		

		
<s:if test="#session.cpGestIncarico_mpIncaricati_selectedMultiPanel == 'cpGestIncarico_mpIncaricati_fpIncaricati'">
	<s:include value="/jsp/multipanels/cpGestIncarico_mpIncaricati_fpIncaricati.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpIncaricati --></div>

			
	
	
	<div id="p_mpInsIncarico" class="panelBlock"><!-- startFragment:p_mpInsIncarico -->
		

		
<s:if test="#session.cpGestIncarico_mpInsIncarico_selectedMultiPanel == 'cpGestIncarico_mpInsIncarico_fpInsIncarico'">
	<s:include value="/jsp/multipanels/cpGestIncarico_mpInsIncarico_fpInsIncarico.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpInsIncarico --></div>

			
	
	<div id="p_cpNavGestIncarico" class="commandPanelBlock"><!-- startFragment:p_cpNavGestIncarico -->
	
	
<div class="commandPanel navigation" id="cpNavGestIncarico">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestIncarico','btnIncIndietro')" >

	



<!-- widget btnIncIndietro -->
<s:submit name="widg_btnIncIndietro" id="widg_btnIncIndietro" method="handleBtnIncIndietro_CLICKED"
	key="cpGestIncarico.btnIncIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestIncarico','btnIncIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavGestIncarico --></div>

	

		
	

	<!-- endFragment:p_fpGestIncarico --></div>

	

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
