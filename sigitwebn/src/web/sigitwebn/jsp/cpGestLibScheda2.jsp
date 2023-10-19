<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_libretto_scheda2 -->
<!-- pageId:cpGestLibScheda2 -->

<s:form id="cpGestLibScheda2" action="cpGestLibScheda2" namespace="/base/gestisci_libretto_scheda2" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestLibScheda2_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpGestLibScheda2','menu')" >

	


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

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestLibScheda2_udpFunzionalita.jsp"></s:include>

	



			
	
	<div id="p_wpMenuTree" class="widgetsPanelBlock"><!-- startFragment:p_wpMenuTree -->
	
	

<div class="widgetsPanel" id="wpMenuTree">
	
	<customtag:widgetsPanel id="wpMenuTreeTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda2','menuLibretto')" >

	
<customtag:widgetsPanelColumn 
	 colSpan="2" >



	<csiuicore:ajaxify id="p_fpLeftMenu" 
		widgetType="tree" 
		pageId="cpGestLibScheda2"
		javascriptDetection="false">
	<customtag:tree
		name="appDatalibrettoMenuTree"
		cssUlClass="tree"
        cssRootClass="treeRoot" cssFolderOpenClass="treeFolderOpen"
        cssFolderClosedClass="treeFolderClosed" cssDotClass="treeDot"
		linkOnTree="true" id="menuLibretto"
		selectionMultiplicity="none"
		requestURI="/sigitwebn/base/gestisci_libretto_scheda2/cpGestLibScheda2!handleMenuLibretto_CLICKED.do"
		nameSpace="/base/gestisci_libretto_scheda2"
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

	
	

	
	
			
	
	<div id="p_fpScheda2" class="formPanelBlock"><!-- startFragment:p_fpScheda2 -->
		
	
<h4 class="fpLabel"><s:text name="cpGestLibScheda2.fpScheda2.label" /></h4>
<div class="formPanel" id="fpScheda2">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpScheda2 --></div>

			
	
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
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda2','ptCodiceImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda2.ptCodiceImpianto.label')}" labelFor="widg_ptCodiceImpianto" errorFor="appDataidentificativoImpianto.codiceImpianto" labelId="ptCodiceImpiantoLbl"  position="first" >


<!-- widget ptCodiceImpianto -->
<s:property value="appDataidentificativoImpianto.codiceImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','ptUbicazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda2.ptUbicazione.label')}" labelFor="widg_ptUbicazione" errorFor="appDataidentificativoImpianto.ubicazione" labelId="ptUbicazioneLbl"  position="last" >


<!-- widget ptUbicazione -->
<s:property value="appDataidentificativoImpianto.ubicazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','ptResponsabile')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda2.ptResponsabile.label')}" labelFor="widg_ptResponsabile" errorFor="appDataidentificativoImpianto.responsabile" labelId="ptResponsabileLbl"  position="first" >


<!-- widget ptResponsabile -->
<s:property value="appDataidentificativoImpianto.responsabile" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','wpInfoImpianto_2_2_fictitious_')" >

	
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

			
	
	<div id="p_wpInfoGenerali" class="widgetsPanelBlock"><!-- startFragment:p_wpInfoGenerali -->
	
	
<h4 class="wpLabel">&nbsp; </h4>
<div class="widgetsPanel" id="wpInfoGenerali">
	
	<customtag:widgetsPanel id="wpInfoGeneraliTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		percentCols="30,20,25,25">
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda2','tfClimaM3')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda2.tfClimaM3.label')}" labelFor="widg_tfClimaM3" errorFor="appDatatrattamentoAcqua.l21H2oClimaM3" labelId="tfClimaM3Lbl"
	position="first"  >


<!-- widget tfClimaM3 -->
<s:textfield 
	
	
	name="appDatatrattamentoAcqua.l21H2oClimaM3" id="widg_tfClimaM3"
maxlength="10"	disabled="isWidgetDisabled('cpGestLibScheda2','tfClimaM3')"
	size="25" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','wpInfoGenerali_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpInfoGenerali_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','tfDurezzaFr')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda2.tfDurezzaFr.label')}" labelFor="widg_tfDurezzaFr" errorFor="appDatatrattamentoAcqua.l22DurezzaH2oFr" labelId="tfDurezzaFrLbl"
	position="first"  >


<!-- widget tfDurezzaFr -->
<s:textfield 
	
	
	name="appDatatrattamentoAcqua.l22DurezzaH2oFr" id="widg_tfDurezzaFr"
maxlength="5"	disabled="isWidgetDisabled('cpGestLibScheda2','tfDurezzaFr')"
	size="25" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','wpInfoGenerali_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpInfoGenerali_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpInfoGenerali --></div>

			
	
	<div id="p_wpScheda2_3" class="widgetsPanelBlock"><!-- startFragment:p_wpScheda2_3 -->
	
	
<h4 class="wpLabel">2.3 trattamento dell'acqua dell'impianto di climatizzazione (Rif. UNI 8065) </h4>
<div class="widgetsPanel" id="wpScheda2_3">
	
	<customtag:widgetsPanel id="wpScheda2_3Tbl" columns="4" tableStyleClass="formTable"
		summary="" 
		percentCols="30,20,25,25">
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda2','cbFlgClimatizzazioneAssente')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda2.cbFlgClimatizzazioneAssente.label')}" labelFor="widg_cbFlgClimatizzazioneAssente" errorFor="appDatatrattamentoAcqua.l23FlgTrattClimaAssente" labelId="cbFlgClimatizzazioneAssenteLbl"
	position="first"  >


<!-- widget cbFlgClimatizzazioneAssente -->
<s:checkbox 
	
	
	name="appDatatrattamentoAcqua.l23FlgTrattClimaAssente" id="widg_cbFlgClimatizzazioneAssente"
	disabled="isWidgetDisabled('cpGestLibScheda2','cbFlgClimatizzazioneAssente')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda2','cbFlgClimatizzazioneAssente')" >
	<s:hidden name="__checkbox_appDatatrattamentoAcqua.l23FlgTrattClimaAssente" id="__checkbox_widg_cbFlgClimatizzazioneAssente" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','wpScheda2_3_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda2_3_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','cbClimatizzazioneFiltr')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda2.cbClimatizzazioneFiltr.label')}" labelFor="widg_cbClimatizzazioneFiltr" errorFor="appDatatrattamentoAcqua.l23FlgTrattClimaFiltr" labelId="cbClimatizzazioneFiltrLbl"
	position="first"  >


<!-- widget cbClimatizzazioneFiltr -->
<s:checkbox 
	
	
	name="appDatatrattamentoAcqua.l23FlgTrattClimaFiltr" id="widg_cbClimatizzazioneFiltr"
	disabled="isWidgetDisabled('cpGestLibScheda2','cbClimatizzazioneFiltr')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda2','cbClimatizzazioneFiltr')" >
	<s:hidden name="__checkbox_appDatatrattamentoAcqua.l23FlgTrattClimaFiltr" id="__checkbox_widg_cbClimatizzazioneFiltr" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','wpScheda2_3_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda2_3_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','cbClimatizzazioneAddolc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda2.cbClimatizzazioneAddolc.label')}" labelFor="widg_cbClimatizzazioneAddolc" errorFor="appDatatrattamentoAcqua.l23FlgTrattClimaAddolc" labelId="cbClimatizzazioneAddolcLbl"
	position="first"  >


<!-- widget cbClimatizzazioneAddolc -->
<s:checkbox 
	
	
	name="appDatatrattamentoAcqua.l23FlgTrattClimaAddolc" id="widg_cbClimatizzazioneAddolc"
	disabled="isWidgetDisabled('cpGestLibScheda2','cbClimatizzazioneAddolc')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda2','cbClimatizzazioneAddolc')" >
	<s:hidden name="__checkbox_appDatatrattamentoAcqua.l23FlgTrattClimaAddolc" id="__checkbox_widg_cbClimatizzazioneAddolc" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','tfDurezzaTotFr')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda2.tfDurezzaTotFr.label')}" labelFor="widg_tfDurezzaTotFr" errorFor="appDatatrattamentoAcqua.l23DurezzaTotH2oFr" labelId="tfDurezzaTotFrLbl"
	position="last"  >


<!-- widget tfDurezzaTotFr -->
<s:textfield 
	
	
	name="appDatatrattamentoAcqua.l23DurezzaTotH2oFr" id="widg_tfDurezzaTotFr"
maxlength="5"	disabled="isWidgetDisabled('cpGestLibScheda2','tfDurezzaTotFr')"
	size="25" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','cbClimatizzazioneChimico')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda2.cbClimatizzazioneChimico.label')}" labelFor="widg_cbClimatizzazioneChimico" errorFor="appDatatrattamentoAcqua.l23FlgTrattClimaChimico" labelId="cbClimatizzazioneChimicoLbl"
	position="first"  >


<!-- widget cbClimatizzazioneChimico -->
<s:checkbox 
	
	
	name="appDatatrattamentoAcqua.l23FlgTrattClimaChimico" id="widg_cbClimatizzazioneChimico"
	disabled="isWidgetDisabled('cpGestLibScheda2','cbClimatizzazioneChimico')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda2','cbClimatizzazioneChimico')" >
	<s:hidden name="__checkbox_appDatatrattamentoAcqua.l23FlgTrattClimaChimico" id="__checkbox_widg_cbClimatizzazioneChimico" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','wpScheda2_3_4_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda2_3_4_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','ptProtezioneDelGelo')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda2.ptProtezioneDelGelo.label')}" labelFor="widg_ptProtezioneDelGelo" errorFor="widg_ptProtezioneDelGelo" labelId="ptProtezioneDelGeloLbl"  position="first" >


<!-- widget ptProtezioneDelGelo -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','wpScheda2_3_5_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda2_3_5_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','cbGeloAssente')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda2.cbGeloAssente.label')}" labelFor="widg_cbGeloAssente" errorFor="appDatatrattamentoAcqua.l23FlgTrattGeloAssente" labelId="cbGeloAssenteLbl"
	position="first"  >


<!-- widget cbGeloAssente -->
<s:checkbox 
	
	
	name="appDatatrattamentoAcqua.l23FlgTrattGeloAssente" id="widg_cbGeloAssente"
	disabled="isWidgetDisabled('cpGestLibScheda2','cbGeloAssente')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda2','cbGeloAssente')" >
	<s:hidden name="__checkbox_appDatatrattamentoAcqua.l23FlgTrattGeloAssente" id="__checkbox_widg_cbGeloAssente" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','wpScheda2_3_6_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda2_3_6_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','cbGeloGliEtil')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda2.cbGeloGliEtil.label')}" labelFor="widg_cbGeloGliEtil" errorFor="appDatatrattamentoAcqua.l23FlgTrattGeloGliEtil" labelId="cbGeloGliEtilLbl"
	position="first"  >


<!-- widget cbGeloGliEtil -->
<s:checkbox 
	
	
	name="appDatatrattamentoAcqua.l23FlgTrattGeloGliEtil" id="widg_cbGeloGliEtil"
	disabled="isWidgetDisabled('cpGestLibScheda2','cbGeloGliEtil')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda2','cbGeloGliEtil')" >
	<s:hidden name="__checkbox_appDatatrattamentoAcqua.l23FlgTrattGeloGliEtil" id="__checkbox_widg_cbGeloGliEtil" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','tfPercGliEtil')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda2.tfPercGliEtil.label')}" labelFor="widg_tfPercGliEtil" errorFor="appDatatrattamentoAcqua.l23PercGliEtil" labelId="tfPercGliEtilLbl"
	position="last"  >


<!-- widget tfPercGliEtil -->
<s:textfield 
	
	
	name="appDatatrattamentoAcqua.l23PercGliEtil" id="widg_tfPercGliEtil"
maxlength="6"	disabled="isWidgetDisabled('cpGestLibScheda2','tfPercGliEtil')"
	size="25" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','wpScheda2_3_8_1_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget wpScheda2_3_8_1_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','tfPhGliEtil')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda2.tfPhGliEtil.label')}" labelFor="widg_tfPhGliEtil" errorFor="appDatatrattamentoAcqua.l23PhGliEtil" labelId="tfPhGliEtilLbl"
	position="last"  >


<!-- widget tfPhGliEtil -->
<s:textfield 
	
	
	name="appDatatrattamentoAcqua.l23PhGliEtil" id="widg_tfPhGliEtil"
maxlength="5"	disabled="isWidgetDisabled('cpGestLibScheda2','tfPhGliEtil')"
	size="25" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','cbGeloGliProp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda2.cbGeloGliProp.label')}" labelFor="widg_cbGeloGliProp" errorFor="appDatatrattamentoAcqua.l23FlgTrattGeloGliProp" labelId="cbGeloGliPropLbl"
	position="first"  >


<!-- widget cbGeloGliProp -->
<s:checkbox 
	
	
	name="appDatatrattamentoAcqua.l23FlgTrattGeloGliProp" id="widg_cbGeloGliProp"
	disabled="isWidgetDisabled('cpGestLibScheda2','cbGeloGliProp')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda2','cbGeloGliProp')" >
	<s:hidden name="__checkbox_appDatatrattamentoAcqua.l23FlgTrattGeloGliProp" id="__checkbox_widg_cbGeloGliProp" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','tfPercGliProp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda2.tfPercGliProp.label')}" labelFor="widg_tfPercGliProp" errorFor="appDatatrattamentoAcqua.l23PercGliProp" labelId="tfPercGliPropLbl"
	position="last"  >


<!-- widget tfPercGliProp -->
<s:textfield 
	
	
	name="appDatatrattamentoAcqua.l23PercGliProp" id="widg_tfPercGliProp"
maxlength="6"	disabled="isWidgetDisabled('cpGestLibScheda2','tfPercGliProp')"
	size="25" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','wpScheda2_3_10_1_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget wpScheda2_3_10_1_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','tfPhGliProp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda2.tfPhGliProp.label')}" labelFor="widg_tfPhGliProp" errorFor="appDatatrattamentoAcqua.l23PhGliProp" labelId="tfPhGliPropLbl"
	position="last"  >


<!-- widget tfPhGliProp -->
<s:textfield 
	
	
	name="appDatatrattamentoAcqua.l23PhGliProp" id="widg_tfPhGliProp"
maxlength="5"	disabled="isWidgetDisabled('cpGestLibScheda2','tfPhGliProp')"
	size="25" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpScheda2_3 --></div>

			
	
	<div id="p_wpScheda2_4" class="widgetsPanelBlock"><!-- startFragment:p_wpScheda2_4 -->
	
	
<h4 class="wpLabel">2.4 trattamento dell'acqua calda sanitaria (Rif. UNI 8065) </h4>
<div class="widgetsPanel" id="wpScheda2_4">
	
	<customtag:widgetsPanel id="wpScheda2_4Tbl" columns="4" tableStyleClass="formTable"
		summary="" 
		percentCols="30,20,25,25">
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda2','cbAcsAssente')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda2.cbAcsAssente.label')}" labelFor="widg_cbAcsAssente" errorFor="appDatatrattamentoAcqua.l24FlgTrattAcsAssente" labelId="cbAcsAssenteLbl"
	position="first"  >


<!-- widget cbAcsAssente -->
<s:checkbox 
	
	
	name="appDatatrattamentoAcqua.l24FlgTrattAcsAssente" id="widg_cbAcsAssente"
	disabled="isWidgetDisabled('cpGestLibScheda2','cbAcsAssente')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda2','cbAcsAssente')" >
	<s:hidden name="__checkbox_appDatatrattamentoAcqua.l24FlgTrattAcsAssente" id="__checkbox_widg_cbAcsAssente" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','wpScheda2_4_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda2_4_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','cbAcsFiltr')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda2.cbAcsFiltr.label')}" labelFor="widg_cbAcsFiltr" errorFor="appDatatrattamentoAcqua.l24FlgTrattAcsFiltr" labelId="cbAcsFiltrLbl"
	position="first"  >


<!-- widget cbAcsFiltr -->
<s:checkbox 
	
	
	name="appDatatrattamentoAcqua.l24FlgTrattAcsFiltr" id="widg_cbAcsFiltr"
	disabled="isWidgetDisabled('cpGestLibScheda2','cbAcsFiltr')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda2','cbAcsFiltr')" >
	<s:hidden name="__checkbox_appDatatrattamentoAcqua.l24FlgTrattAcsFiltr" id="__checkbox_widg_cbAcsFiltr" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','wpScheda2_4_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda2_4_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','cbAcsAddolc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda2.cbAcsAddolc.label')}" labelFor="widg_cbAcsAddolc" errorFor="appDatatrattamentoAcqua.l24FlgTrattAcsAddolc" labelId="cbAcsAddolcLbl"
	position="first"  >


<!-- widget cbAcsAddolc -->
<s:checkbox 
	
	
	name="appDatatrattamentoAcqua.l24FlgTrattAcsAddolc" id="widg_cbAcsAddolc"
	disabled="isWidgetDisabled('cpGestLibScheda2','cbAcsAddolc')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda2','cbAcsAddolc')" >
	<s:hidden name="__checkbox_appDatatrattamentoAcqua.l24FlgTrattAcsAddolc" id="__checkbox_widg_cbAcsAddolc" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','tfDurezzaAddolcFr')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda2.tfDurezzaAddolcFr.label')}" labelFor="widg_tfDurezzaAddolcFr" errorFor="appDatatrattamentoAcqua.l24DurezzaAddolcFr" labelId="tfDurezzaAddolcFrLbl"
	position="last"  >


<!-- widget tfDurezzaAddolcFr -->
<s:textfield 
	
	
	name="appDatatrattamentoAcqua.l24DurezzaAddolcFr" id="widg_tfDurezzaAddolcFr"
maxlength="5"	disabled="isWidgetDisabled('cpGestLibScheda2','tfDurezzaAddolcFr')"
	size="25" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','cbAcsChimico')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda2.cbAcsChimico.label')}" labelFor="widg_cbAcsChimico" errorFor="appDatatrattamentoAcqua.l24FlgTrattAcsChimico" labelId="cbAcsChimicoLbl"
	position="first"  >


<!-- widget cbAcsChimico -->
<s:checkbox 
	
	
	name="appDatatrattamentoAcqua.l24FlgTrattAcsChimico" id="widg_cbAcsChimico"
	disabled="isWidgetDisabled('cpGestLibScheda2','cbAcsChimico')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda2','cbAcsChimico')" >
	<s:hidden name="__checkbox_appDatatrattamentoAcqua.l24FlgTrattAcsChimico" id="__checkbox_widg_cbAcsChimico" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','wpScheda2_4_4_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda2_4_4_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpScheda2_4 --></div>

			
	
	<div id="p_wpScheda2_5" class="widgetsPanelBlock"><!-- startFragment:p_wpScheda2_5 -->
	
	
<h4 class="wpLabel">2.5 trattamento dell'acqua di raffreddamento dell'impianto di climatizzazione estiva </h4>
<div class="widgetsPanel" id="wpScheda2_5">
	
	<customtag:widgetsPanel id="wpScheda2_5Tbl" columns="4" tableStyleClass="formTable"
		summary="" 
		percentCols="30,20,25,25">
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda2','cbAssente')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda2.cbAssente.label')}" labelFor="widg_cbAssente" errorFor="appDatatrattamentoAcqua.l25FlgTrattRaffAssente" labelId="cbAssenteLbl"
	position="first"  >


<!-- widget cbAssente -->
<s:checkbox 
	
	
	name="appDatatrattamentoAcqua.l25FlgTrattRaffAssente" id="widg_cbAssente"
	disabled="isWidgetDisabled('cpGestLibScheda2','cbAssente')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda2','cbAssente')" >
	<s:hidden name="__checkbox_appDatatrattamentoAcqua.l25FlgTrattRaffAssente" id="__checkbox_widg_cbAssente" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','wpScheda2_5_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda2_5_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','cbTipologiaCircuitoRaffreddamento')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda2.cbTipologiaCircuitoRaffreddamento.label')}" labelFor="widg_cbTipologiaCircuitoRaffreddamento" errorFor="appDatatrattamentoAcqua.l25FlgTrattRaff" labelId="cbTipologiaCircuitoRaffreddamentoLbl"
	position="first"  >


<!-- widget cbTipologiaCircuitoRaffreddamento -->
<s:select name="appDatatrattamentoAcqua.l25FlgTrattRaff" id="widg_cbTipologiaCircuitoRaffreddamento"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTipologiaCircuitoRaffreddamento"
	  disabled="isWidgetDisabled('cpGestLibScheda2','cbTipologiaCircuitoRaffreddamento')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','wpScheda2_5_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda2_5_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','cbOrigineAcquaDiAlimento')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda2.cbOrigineAcquaDiAlimento.label')}" labelFor="widg_cbOrigineAcquaDiAlimento" errorFor="appDatatrattamentoAcqua.l25OrigAcquaAlim" labelId="cbOrigineAcquaDiAlimentoLbl"
	position="first"  >


<!-- widget cbOrigineAcquaDiAlimento -->
<s:select name="appDatatrattamentoAcqua.l25OrigAcquaAlim" id="widg_cbOrigineAcquaDiAlimento"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoOrigineAcquaAlimento"
	  disabled="isWidgetDisabled('cpGestLibScheda2','cbOrigineAcquaDiAlimento')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','wpScheda2_5_3_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda2_5_3_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','cbFiltrazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda2.cbFiltrazione.label')}" labelFor="widg_cbFiltrazione" errorFor="appDatatrattamentoAcqua.l25FlgTrattF" labelId="cbFiltrazioneLbl"
	position="first"  >


<!-- widget cbFiltrazione -->
<s:select name="appDatatrattamentoAcqua.l25FlgTrattF" id="widg_cbFiltrazione"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTrattamentiAcquaFiltrazione"
	  disabled="isWidgetDisabled('cpGestLibScheda2','cbFiltrazione')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','tfFiltrazioneAltro')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda2.tfFiltrazioneAltro.label')}" labelFor="widg_tfFiltrazioneAltro" errorFor="appDatatrattamentoAcqua.l25TrattFAltro" labelId="tfFiltrazioneAltroLbl"
	position="last"  >


<!-- widget tfFiltrazioneAltro -->
<s:textarea 
	
	
	name="appDatatrattamentoAcqua.l25TrattFAltro" id="widg_tfFiltrazioneAltro"
	disabled="isWidgetDisabled('cpGestLibScheda2','tfFiltrazioneAltro')"
	rows="2"
	cols="25"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','cbTrattamentoAcqua')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda2.cbTrattamentoAcqua.label')}" labelFor="widg_cbTrattamentoAcqua" errorFor="appDatatrattamentoAcqua.l25FlgTrattT" labelId="cbTrattamentoAcquaLbl"
	position="first"  >


<!-- widget cbTrattamentoAcqua -->
<s:select name="appDatatrattamentoAcqua.l25FlgTrattT" id="widg_cbTrattamentoAcqua"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTrattamentiAcquaTrattamentoAcqua"
	  disabled="isWidgetDisabled('cpGestLibScheda2','cbTrattamentoAcqua')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','tfTrattamentoAcquaAltro')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda2.tfTrattamentoAcquaAltro.label')}" labelFor="widg_tfTrattamentoAcquaAltro" errorFor="appDatatrattamentoAcqua.l25TrattTAltro" labelId="tfTrattamentoAcquaAltroLbl"
	position="last"  >


<!-- widget tfTrattamentoAcquaAltro -->
<s:textarea 
	
	
	name="appDatatrattamentoAcqua.l25TrattTAltro" id="widg_tfTrattamentoAcquaAltro"
	disabled="isWidgetDisabled('cpGestLibScheda2','tfTrattamentoAcquaAltro')"
	rows="2"
	cols="25"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','cbCondizionamentoChimico')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda2.cbCondizionamentoChimico.label')}" labelFor="widg_cbCondizionamentoChimico" errorFor="appDatatrattamentoAcqua.l25FlgTrattC" labelId="cbCondizionamentoChimicoLbl"
	position="first"  >


<!-- widget cbCondizionamentoChimico -->
<s:select name="appDatatrattamentoAcqua.l25FlgTrattC" id="widg_cbCondizionamentoChimico"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTrattamentiAcquaCondizionamentoChimico"
	  disabled="isWidgetDisabled('cpGestLibScheda2','cbCondizionamentoChimico')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','tfCondizionamentoChimicoAltro')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda2.tfCondizionamentoChimicoAltro.label')}" labelFor="widg_tfCondizionamentoChimicoAltro" errorFor="appDatatrattamentoAcqua.l25TrattCAltro" labelId="tfCondizionamentoChimicoAltroLbl"
	position="last"  >


<!-- widget tfCondizionamentoChimicoAltro -->
<s:textarea 
	
	
	name="appDatatrattamentoAcqua.l25TrattCAltro" id="widg_tfCondizionamentoChimicoAltro"
	disabled="isWidgetDisabled('cpGestLibScheda2','tfCondizionamentoChimicoAltro')"
	rows="2"
	cols="25"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','ptGestioneTorreRaffreddamento')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda2.ptGestioneTorreRaffreddamento.label')}" labelFor="widg_ptGestioneTorreRaffreddamento" errorFor="widg_ptGestioneTorreRaffreddamento" labelId="ptGestioneTorreRaffreddamentoLbl"  position="first" >


<!-- widget ptGestioneTorreRaffreddamento -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','wpScheda2_5_7_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda2_5_7_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','cbSpurgoAutomatico')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda2.cbSpurgoAutomatico.label')}" labelFor="widg_cbSpurgoAutomatico" errorFor="appDatatrattamentoAcqua.l25FlgSpurgoAutom" labelId="cbSpurgoAutomaticoLbl"
	position="first"  >


<!-- widget cbSpurgoAutomatico -->
<s:checkbox 
	
	
	name="appDatatrattamentoAcqua.l25FlgSpurgoAutom" id="widg_cbSpurgoAutomatico"
	disabled="isWidgetDisabled('cpGestLibScheda2','cbSpurgoAutomatico')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda2','cbSpurgoAutomatico')" >
	<s:hidden name="__checkbox_appDatatrattamentoAcqua.l25FlgSpurgoAutom" id="__checkbox_widg_cbSpurgoAutomatico" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','wpScheda2_5_8_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda2_5_8_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','tfconducIngresso')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda2.tfconducIngresso.label')}" labelFor="widg_tfconducIngresso" errorFor="appDatatrattamentoAcqua.l25ConducH2oIng" labelId="tfconducIngressoLbl"
	position="first"  >


<!-- widget tfconducIngresso -->
<s:textfield 
	
	
	name="appDatatrattamentoAcqua.l25ConducH2oIng" id="widg_tfconducIngresso"
maxlength="10"	disabled="isWidgetDisabled('cpGestLibScheda2','tfconducIngresso')"
	size="25" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','wpScheda2_5_9_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda2_5_9_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','tfTaratura')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda2.tfTaratura.label')}" labelFor="widg_tfTaratura" errorFor="appDatatrattamentoAcqua.l25Taratura" labelId="tfTaraturaLbl"
	position="first"  >


<!-- widget tfTaratura -->
<s:textfield 
	
	
	name="appDatatrattamentoAcqua.l25Taratura" id="widg_tfTaratura"
maxlength="10"	disabled="isWidgetDisabled('cpGestLibScheda2','tfTaratura')"
	size="25" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda2','wpScheda2_5_10_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda2_5_10_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpScheda2_5 --></div>

			
	
	<div id="p_cpFunGestScheda2" class="commandPanelBlock"><!-- startFragment:p_cpFunGestScheda2 -->
	
	
<div class="commandPanel functional" id="cpFunGestScheda2">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestLibScheda2','bSalvaScheda2')" >

	



<!-- widget bSalvaScheda2 -->
<s:submit name="widg_bSalvaScheda2" id="widg_bSalvaScheda2" method="handleBSalvaScheda2_CLICKED"
	key="cpGestLibScheda2.bSalvaScheda2.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda2','bSalvaScheda2')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestLibScheda2','bRipristinaAttuale2')" >

	



<!-- widget bRipristinaAttuale2 -->
<s:submit name="widg_bRipristinaAttuale2" id="widg_bRipristinaAttuale2" method="handleBRipristinaAttuale2_CLICKED"
	key="cpGestLibScheda2.bRipristinaAttuale2.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda2','bRipristinaAttuale2')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunGestScheda2 --></div>

			
	
	<div id="p_cpNavGestScheda2" class="commandPanelBlock"><!-- startFragment:p_cpNavGestScheda2 -->
	
	
<div class="commandPanel navigation" id="cpNavGestScheda2">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestLibScheda2','btnIndietro')" >

	



<!-- widget btnIndietro -->
<s:submit name="widg_btnIndietro" id="widg_btnIndietro" method="handleBtnIndietro_CLICKED"
	key="cpGestLibScheda2.btnIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda2','btnIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavGestScheda2 --></div>

	

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
