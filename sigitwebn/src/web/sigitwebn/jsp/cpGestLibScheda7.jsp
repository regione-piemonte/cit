<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_libretto_scheda7 -->
<!-- pageId:cpGestLibScheda7 -->

<s:form id="cpGestLibScheda7" action="cpGestLibScheda7" namespace="/base/gestisci_libretto_scheda7" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestLibScheda7_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpGestLibScheda7','menu')" >

	


	<s:include value="fragments/menu.jsp"></s:include>

	

</s:if>

	


		
	
	
</div>

	<!-- endFragment:p_menuPanel --></div>

	

	<!-- endFragment:p_fpUpUserInfo --></div>

		</div>
	</div>
	<!-- ================ FINE UDLRC Layout UP PANEL ================ -->


	<!-- ================ UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->
	<div id="westCenterWrapper" class="floatWrapper">
		<!-- ***** UDLRC Layout LEFT PANEL ***** -->
		<div id="westPanel">
			<div class="wrapper">
			
	
	<div id="p_fpLeftMenu" class="formPanelBlock"><!-- startFragment:p_fpLeftMenu -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestLibScheda7_udpFunzionalita.jsp"></s:include>

	



			
	
	<div id="p_wpMenuTree" class="widgetsPanelBlock"><!-- startFragment:p_wpMenuTree -->
	
	

<div class="widgetsPanel" id="wpMenuTree">
	
	<customtag:widgetsPanel id="wpMenuTreeTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda7','menuLibretto')" >

	
<customtag:widgetsPanelColumn 
	 colSpan="2" >



	<csiuicore:ajaxify id="p_fpLeftMenu" 
		widgetType="tree" 
		pageId="cpGestLibScheda7"
		javascriptDetection="false">
	<customtag:tree
		name="appDatalibrettoMenuTree"
		cssUlClass="tree"
        cssRootClass="treeRoot" cssFolderOpenClass="treeFolderOpen"
        cssFolderClosedClass="treeFolderClosed" cssDotClass="treeDot"
		linkOnTree="true" id="menuLibretto"
		selectionMultiplicity="none"
		requestURI="/sigitwebn/base/gestisci_libretto_scheda7/cpGestLibScheda7!handleMenuLibretto_CLICKED.do"
		nameSpace="/base/gestisci_libretto_scheda7"
		showChildNumber="false">
	</customtag:tree>

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpMenuTree --></div>

	

	<!-- endFragment:p_fpLeftMenu --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout LEFT PANEL ***** -->


		<!-- ***** UDLRC Layout CENTER PANEL ***** -->
		<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
			<div class="wrapper">

					
	
	<div id="p_fpCenter" class="formPanelBlock"><!-- startFragment:p_fpCenter -->

	
	

	
	
			
	
	<div id="p_fpSchedaImpianto" class="formPanelBlock"><!-- startFragment:p_fpSchedaImpianto -->
		
	
<h4 class="fpLabel"><s:text name="cpGestLibScheda7.fpSchedaImpianto.label" /></h4>
<div class="formPanel" id="fpSchedaImpianto">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpSchedaImpianto --></div>

			
	
	<div id="p_stdMsgLibretto" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgLibretto -->
	
	
<div class="stdMessagePanel" id="stdMsgLibretto">
	<customtag:stdMessagePanel id="stdMsgLibretto" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgLibretto --></div>

			
	
	<div id="p_wpInfoImpianto" class="widgetsPanelBlock"><!-- startFragment:p_wpInfoImpianto -->
	
	
<h4 class="wpLabel">impianto </h4>
<div class="widgetsPanel" id="wpInfoImpianto">
	
	<customtag:widgetsPanel id="wpInfoImpiantoTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda7','ptCodiceImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda7.ptCodiceImpianto.label')}" labelFor="widg_ptCodiceImpianto" errorFor="appDataidentificativoImpianto.codiceImpianto" labelId="ptCodiceImpiantoLbl"  position="first" >


<!-- widget ptCodiceImpianto -->
<s:property value="appDataidentificativoImpianto.codiceImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda7','ptUbicazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda7.ptUbicazione.label')}" labelFor="widg_ptUbicazione" errorFor="appDataidentificativoImpianto.ubicazione" labelId="ptUbicazioneLbl"  position="last" >


<!-- widget ptUbicazione -->
<s:property value="appDataidentificativoImpianto.ubicazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda7','ptResponsabile')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda7.ptResponsabile.label')}" labelFor="widg_ptResponsabile" errorFor="appDataidentificativoImpianto.responsabile" labelId="ptResponsabileLbl"  position="first" >


<!-- widget ptResponsabile -->
<s:property value="appDataidentificativoImpianto.responsabile" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda7','wpInfoImpianto_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpInfoImpianto_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpInfoImpianto --></div>

			
	
	<div id="p_wpSistemaEmissione" class="widgetsPanelBlock"><!-- startFragment:p_wpSistemaEmissione -->
	
	
<h4 class="wpLabel">7.1 Sistema di emissione </h4>
<div class="widgetsPanel" id="wpSistemaEmissione">
	
	<customtag:widgetsPanel id="wpSistemaEmissioneTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda7','cbRadiatori')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda7.cbRadiatori.label')}" labelFor="widg_cbRadiatori" errorFor="appDatasistemaEmissione.flagRadiatori" labelId="cbRadiatoriLbl"
	position="first"  >


<!-- widget cbRadiatori -->
<s:checkbox 
	
	
	name="appDatasistemaEmissione.flagRadiatori" id="widg_cbRadiatori"
	disabled="isWidgetDisabled('cpGestLibScheda7','cbRadiatori')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda7','cbRadiatori')" >
	<s:hidden name="__checkbox_appDatasistemaEmissione.flagRadiatori" id="__checkbox_widg_cbRadiatori" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda7','wpSistemaEmissione_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpSistemaEmissione_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda7','cbTermoconvettori')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda7.cbTermoconvettori.label')}" labelFor="widg_cbTermoconvettori" errorFor="appDatasistemaEmissione.flagTermoconvettori" labelId="cbTermoconvettoriLbl"
	position="first"  >


<!-- widget cbTermoconvettori -->
<s:checkbox 
	
	
	name="appDatasistemaEmissione.flagTermoconvettori" id="widg_cbTermoconvettori"
	disabled="isWidgetDisabled('cpGestLibScheda7','cbTermoconvettori')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda7','cbTermoconvettori')" >
	<s:hidden name="__checkbox_appDatasistemaEmissione.flagTermoconvettori" id="__checkbox_widg_cbTermoconvettori" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda7','wpSistemaEmissione_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpSistemaEmissione_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda7','cbVentilconvettori')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda7.cbVentilconvettori.label')}" labelFor="widg_cbVentilconvettori" errorFor="appDatasistemaEmissione.flagVentilconvettori" labelId="cbVentilconvettoriLbl"
	position="first"  >


<!-- widget cbVentilconvettori -->
<s:checkbox 
	
	
	name="appDatasistemaEmissione.flagVentilconvettori" id="widg_cbVentilconvettori"
	disabled="isWidgetDisabled('cpGestLibScheda7','cbVentilconvettori')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda7','cbVentilconvettori')" >
	<s:hidden name="__checkbox_appDatasistemaEmissione.flagVentilconvettori" id="__checkbox_widg_cbVentilconvettori" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda7','wpSistemaEmissione_3_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpSistemaEmissione_3_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda7','cbPanelliRadianti')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda7.cbPanelliRadianti.label')}" labelFor="widg_cbPanelliRadianti" errorFor="appDatasistemaEmissione.flagPannelliRadianti" labelId="cbPanelliRadiantiLbl"
	position="first"  >


<!-- widget cbPanelliRadianti -->
<s:checkbox 
	
	
	name="appDatasistemaEmissione.flagPannelliRadianti" id="widg_cbPanelliRadianti"
	disabled="isWidgetDisabled('cpGestLibScheda7','cbPanelliRadianti')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda7','cbPanelliRadianti')" >
	<s:hidden name="__checkbox_appDatasistemaEmissione.flagPannelliRadianti" id="__checkbox_widg_cbPanelliRadianti" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda7','wpSistemaEmissione_4_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpSistemaEmissione_4_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda7','cbBocchette')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda7.cbBocchette.label')}" labelFor="widg_cbBocchette" errorFor="appDatasistemaEmissione.flagBocchette" labelId="cbBocchetteLbl"
	position="first"  >


<!-- widget cbBocchette -->
<s:checkbox 
	
	
	name="appDatasistemaEmissione.flagBocchette" id="widg_cbBocchette"
	disabled="isWidgetDisabled('cpGestLibScheda7','cbBocchette')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda7','cbBocchette')" >
	<s:hidden name="__checkbox_appDatasistemaEmissione.flagBocchette" id="__checkbox_widg_cbBocchette" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda7','wpSistemaEmissione_5_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpSistemaEmissione_5_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda7','cbStrisceRadianti')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda7.cbStrisceRadianti.label')}" labelFor="widg_cbStrisceRadianti" errorFor="appDatasistemaEmissione.flagStrisceRadianti" labelId="cbStrisceRadiantiLbl"
	position="first"  >


<!-- widget cbStrisceRadianti -->
<s:checkbox 
	
	
	name="appDatasistemaEmissione.flagStrisceRadianti" id="widg_cbStrisceRadianti"
	disabled="isWidgetDisabled('cpGestLibScheda7','cbStrisceRadianti')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda7','cbStrisceRadianti')" >
	<s:hidden name="__checkbox_appDatasistemaEmissione.flagStrisceRadianti" id="__checkbox_widg_cbStrisceRadianti" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda7','wpSistemaEmissione_6_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpSistemaEmissione_6_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda7','cbTraviFredde')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda7.cbTraviFredde.label')}" labelFor="widg_cbTraviFredde" errorFor="appDatasistemaEmissione.flagTraviFredde" labelId="cbTraviFreddeLbl"
	position="first"  >


<!-- widget cbTraviFredde -->
<s:checkbox 
	
	
	name="appDatasistemaEmissione.flagTraviFredde" id="widg_cbTraviFredde"
	disabled="isWidgetDisabled('cpGestLibScheda7','cbTraviFredde')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda7','cbTraviFredde')" >
	<s:hidden name="__checkbox_appDatasistemaEmissione.flagTraviFredde" id="__checkbox_widg_cbTraviFredde" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda7','wpSistemaEmissione_7_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpSistemaEmissione_7_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda7','cbAltro')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda7.cbAltro.label')}" labelFor="widg_cbAltro" errorFor="appDatasistemaEmissione.flagAltro" labelId="cbAltroLbl"
	position="first"  >


<!-- widget cbAltro -->
<s:checkbox 
	
	
	name="appDatasistemaEmissione.flagAltro" id="widg_cbAltro"
	disabled="isWidgetDisabled('cpGestLibScheda7','cbAltro')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda7','cbAltro')" >
	<s:hidden name="__checkbox_appDatasistemaEmissione.flagAltro" id="__checkbox_widg_cbAltro" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda7','wpSistemaEmissione_8_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpSistemaEmissione_8_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda7','tfAltro')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda7.tfAltro.label')}" labelFor="widg_tfAltro" errorFor="appDatasistemaEmissione.altro" labelId="tfAltroLbl"
	position="first"  >


<!-- widget tfAltro -->
<s:textarea 
	
	
	name="appDatasistemaEmissione.altro" id="widg_tfAltro"
	disabled="isWidgetDisabled('cpGestLibScheda7','tfAltro')"
	rows="2"
	cols="100"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda7','wpSistemaEmissione_9_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpSistemaEmissione_9_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpSistemaEmissione --></div>

			
	
	<div id="p_cpFunGestScheda7" class="commandPanelBlock"><!-- startFragment:p_cpFunGestScheda7 -->
	
	
<div class="commandPanel functional" id="cpFunGestScheda7">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestLibScheda7','bSalvaScheda7')" >

	



<!-- widget bSalvaScheda7 -->
<s:submit name="widg_bSalvaScheda7" id="widg_bSalvaScheda7" method="handleBSalvaScheda7_CLICKED"
	key="cpGestLibScheda7.bSalvaScheda7.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda7','bSalvaScheda7')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestLibScheda7','bRipristinaAttuale7')" >

	



<!-- widget bRipristinaAttuale7 -->
<s:submit name="widg_bRipristinaAttuale7" id="widg_bRipristinaAttuale7" method="handleBRipristinaAttuale7_CLICKED"
	key="cpGestLibScheda7.bRipristinaAttuale7.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda7','bRipristinaAttuale7')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunGestScheda7 --></div>

			
	
	<div id="p_cpNavGestScheda7" class="commandPanelBlock"><!-- startFragment:p_cpNavGestScheda7 -->
	
	
<div class="commandPanel navigation" id="cpNavGestScheda7">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestLibScheda7','btnIndietro')" >

	



<!-- widget btnIndietro -->
<s:submit name="widg_btnIndietro" id="widg_btnIndietro" method="handleBtnIndietro_CLICKED"
	key="cpGestLibScheda7.btnIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda7','btnIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavGestScheda7 --></div>

	

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
