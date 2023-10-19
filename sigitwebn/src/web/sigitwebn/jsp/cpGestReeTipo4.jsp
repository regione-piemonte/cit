<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_ree_tipo4 -->
<!-- pageId:cpGestReeTipo4 -->

<s:form id="cpGestReeTipo4" action="cpGestReeTipo4" namespace="/base/gestisci_ree_tipo4" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestReeTipo4_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpGestReeTipo4','menu')" >

	


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

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestReeTipo4_udpFunzionalita.jsp"></s:include>

	



			
	
	<div id="p_wpMenuTree" class="widgetsPanelBlock"><!-- startFragment:p_wpMenuTree -->
	
	

<div class="widgetsPanel" id="wpMenuTree">
	
	<customtag:widgetsPanel id="wpMenuTreeTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestReeTipo4','menuRee')" >

	
<customtag:widgetsPanelColumn 
	 colSpan="2" >



	<csiuicore:ajaxify id="p_wpMenuTree" 
		widgetType="tree" 
		pageId="cpGestReeTipo4"
		javascriptDetection="false">
	<customtag:tree
		name="appDatareeMenuTree"
		cssUlClass="tree"
        cssRootClass="treeRoot" cssFolderOpenClass="treeFolderOpen"
        cssFolderClosedClass="treeFolderClosed" cssDotClass="treeDot"
		linkOnTree="true" id="menuRee"
		selectionMultiplicity="none"
		requestURI="/sigitwebn/base/gestisci_ree_tipo4/cpGestReeTipo4!handleMenuRee_CLICKED.do"
		nameSpace="/base/gestisci_ree_tipo4"
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

	
	

	
	
			
	
	<div id="p_fpGestRee" class="formPanelBlock"><!-- startFragment:p_fpGestRee -->
		
	
<h4 class="fpLabel"><s:text name="cpGestReeTipo4.fpGestRee.label" /></h4>
<div class="formPanel" id="fpGestRee">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpGestRee --></div>

			
	
	<div id="p_stdMsgRee" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgRee -->
	
	
<div class="stdMessagePanel" id="stdMsgRee">
	<customtag:stdMessagePanel id="stdMsgRee" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgRee --></div>

			
	
	<div id="p_wpInfoImpianto" class="widgetsPanelBlock"><!-- startFragment:p_wpInfoImpianto -->
	
	
<h4 class="wpLabel">impianto </h4>
<div class="widgetsPanel" id="wpInfoImpianto">
	
	<customtag:widgetsPanel id="wpInfoImpiantoTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestReeTipo4','ptCodiceImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo4.ptCodiceImpianto.label')}" labelFor="widg_ptCodiceImpianto" errorFor="appDataidentificativoImpianto.codiceImpianto" labelId="ptCodiceImpiantoLbl"  position="first" >


<!-- widget ptCodiceImpianto -->
<s:property value="appDataidentificativoImpianto.codiceImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestReeTipo4','ptUbicazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo4.ptUbicazione.label')}" labelFor="widg_ptUbicazione" errorFor="appDataidentificativoImpianto.ubicazione" labelId="ptUbicazioneLbl"  position="last" >


<!-- widget ptUbicazione -->
<s:property value="appDataidentificativoImpianto.ubicazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestReeTipo4','ptResponsabile')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo4.ptResponsabile.label')}" labelFor="widg_ptResponsabile" errorFor="appDataidentificativoImpianto.responsabile" labelId="ptResponsabileLbl"  position="first" >


<!-- widget ptResponsabile -->
<s:property value="appDataidentificativoImpianto.responsabile" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestReeTipo4','wpInfoImpianto_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpInfoImpianto_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestReeTipo4','ptDataControllo')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo4.ptDataControllo.label')}" labelFor="widg_ptDataControllo" errorFor="appDataallegato.dataControllo" labelId="ptDataControlloLbl"  position="first" >


<!-- widget ptDataControllo -->
<s:property value="appDataallegato.dataControllo" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestReeTipo4','ptBollino')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo4.ptBollino.label')}" labelFor="widg_ptBollino" errorFor="appDataallegato.codiceBollino" labelId="ptBollinoLbl"  position="last" >


<!-- widget ptBollino -->
<s:property value="appDataallegato.codiceBollino" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpInfoImpianto --></div>

			
	
	<div id="p_wpA" class="widgetsPanelBlock"><!-- startFragment:p_wpA -->
	
	
<h4 class="wpLabel">A. dati identificativi </h4>
<div class="widgetsPanel" id="wpA">
	
	<customtag:widgetsPanel id="wpATbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestReeTipo4','tfPotenzaTermicaNomMax')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4.tfPotenzaTermicaNomMax.label')}" labelFor="widg_tfPotenzaTermicaNomMax" errorFor="appDatareeTipo4.potenzaTermicaNomMax" labelId="tfPotenzaTermicaNomMaxLbl"
	  >


<!-- widget tfPotenzaTermicaNomMax -->
<s:textfield 
	
	
	name="appDatareeTipo4.potenzaTermicaNomMax" id="widg_tfPotenzaTermicaNomMax"
maxlength="9"	disabled="isWidgetDisabled('cpGestReeTipo4','tfPotenzaTermicaNomMax')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4','ptResponsabileImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo4.ptResponsabileImpianto.label')}" labelFor="widg_ptResponsabileImpianto" errorFor="appDatareeTipo4.responsabileImpianto" labelId="ptResponsabileImpiantoLbl"   >


<!-- widget ptResponsabileImpianto -->
<s:property value="appDatareeTipo4.responsabileImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4','ptImpresaManutInstal')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo4.ptImpresaManutInstal.label')}" labelFor="widg_ptImpresaManutInstal" errorFor="appDatareeTipo4.impresaManutInstal" labelId="ptImpresaManutInstalLbl"   >


<!-- widget ptImpresaManutInstal -->
<s:property value="appDatareeTipo4.impresaManutInstal" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpA --></div>

			
	
	<div id="p_wpB" class="widgetsPanelBlock"><!-- startFragment:p_wpB -->
	
	
<h4 class="wpLabel">B. documentazione tecnica a corredo </h4>
<div class="widgetsPanel" id="wpB">
	
	<customtag:widgetsPanel id="wpBTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestReeTipo4','rbDicConf')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4.rbDicConf.label')}" labelFor="widg_rbDicConf" errorFor="appDatareeTipo4.flgDichiarConform" labelId="rbDicConfLbl"
	  >


<!-- widget rbDicConf -->

	
<div id="appDatareeTipo4.flgDichiarConform" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbDicConfSI" name="appDatareeTipo4.flgDichiarConform"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo4','rbDicConf')"
	cssClass="radio"
	
	/> <label  for="widg_rbDicConfSI1"><s:text name="cpGestReeTipo4.rbDicConf.rbDicConfSI.label" /></label>








<s:radio
	
	
	id="widg_rbDicConfNO" name="appDatareeTipo4.flgDichiarConform"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo4','rbDicConf')"
	cssClass="radio"
	
	/> <label  for="widg_rbDicConfNO0"><s:text name="cpGestReeTipo4.rbDicConf.rbDicConfNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4','rbLibImp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4.rbLibImp.label')}" labelFor="widg_rbLibImp" errorFor="appDatareeTipo4.flgLibImp" labelId="rbLibImpLbl"
	  >


<!-- widget rbLibImp -->

	
<div id="appDatareeTipo4.flgLibImp" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbLibImpSI" name="appDatareeTipo4.flgLibImp"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo4','rbLibImp')"
	cssClass="radio"
	
	/> <label  for="widg_rbLibImpSI1"><s:text name="cpGestReeTipo4.rbLibImp.rbLibImpSI.label" /></label>








<s:radio
	
	
	id="widg_rbLibImpNO" name="appDatareeTipo4.flgLibImp"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo4','rbLibImp')"
	cssClass="radio"
	
	/> <label  for="widg_rbLibImpNO0"><s:text name="cpGestReeTipo4.rbLibImp.rbLibImpNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4','rbLibUso')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4.rbLibUso.label')}" labelFor="widg_rbLibUso" errorFor="appDatareeTipo4.flgLibrettoUso" labelId="rbLibUsoLbl"
	  >


<!-- widget rbLibUso -->

	
<div id="appDatareeTipo4.flgLibrettoUso" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbLibUsoSI" name="appDatareeTipo4.flgLibrettoUso"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo4','rbLibUso')"
	cssClass="radio"
	
	/> <label  for="widg_rbLibUsoSI1"><s:text name="cpGestReeTipo4.rbLibUso.rbLibUsoSI.label" /></label>








<s:radio
	
	
	id="widg_rbLibUsoNO" name="appDatareeTipo4.flgLibrettoUso"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo4','rbLibUso')"
	cssClass="radio"
	
	/> <label  for="widg_rbLibUsoNO0"><s:text name="cpGestReeTipo4.rbLibUso.rbLibUsoNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4','rbLibComp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4.rbLibComp.label')}" labelFor="widg_rbLibComp" errorFor="appDatareeTipo4.flgLibCompl" labelId="rbLibCompLbl"
	  >


<!-- widget rbLibComp -->

	
<div id="appDatareeTipo4.flgLibCompl" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbLibCompSI" name="appDatareeTipo4.flgLibCompl"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo4','rbLibComp')"
	cssClass="radio"
	
	/> <label  for="widg_rbLibCompSI1"><s:text name="cpGestReeTipo4.rbLibComp.rbLibCompSI.label" /></label>








<s:radio
	
	
	id="widg_rbLibCompNO" name="appDatareeTipo4.flgLibCompl"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo4','rbLibComp')"
	cssClass="radio"
	
	/> <label  for="widg_rbLibCompNO0"><s:text name="cpGestReeTipo4.rbLibComp.rbLibCompNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpB --></div>

			
	
	<div id="p_wpC" class="widgetsPanelBlock"><!-- startFragment:p_wpC -->
	
	
<h4 class="wpLabel">C. trattamento dell&apos;acqua </h4>
<div class="widgetsPanel" id="wpC">
	
	<customtag:widgetsPanel id="wpCTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestReeTipo4','ptDurezzaH20')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo4.ptDurezzaH20.label')}" labelFor="widg_ptDurezzaH20" errorFor="appDatareeTipo4.durezzaH2OFr" labelId="ptDurezzaH20Lbl"   >


<!-- widget ptDurezzaH20 -->
<s:property value="appDatareeTipo4.durezzaH2OFr" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4','ptTrattClima')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo4.ptTrattClima.label')}" labelFor="widg_ptTrattClima" errorFor="appDatareeTipo4.descTrattClima" labelId="ptTrattClimaLbl"   >


<!-- widget ptTrattClima -->
<s:property value="appDatareeTipo4.descTrattClima" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4','rbTrattClimaNonRic')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4.rbTrattClimaNonRic.label')}" labelFor="widg_rbTrattClimaNonRic" errorFor="appDatareeTipo4.flgTrattClimaNonRich" labelId="rbTrattClimaNonRicLbl"
	  >


<!-- widget rbTrattClimaNonRic -->

	
<div id="appDatareeTipo4.flgTrattClimaNonRich" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbTrattClimaNonRicSI" name="appDatareeTipo4.flgTrattClimaNonRich"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo4','rbTrattClimaNonRic')"
	cssClass="radio"
	
	/> <label  for="widg_rbTrattClimaNonRicSI1"><s:text name="cpGestReeTipo4.rbTrattClimaNonRic.rbTrattClimaNonRicSI.label" /></label>








<s:radio
	
	
	id="widg_rbTrattClimaNonRicNO" name="appDatareeTipo4.flgTrattClimaNonRich"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo4','rbTrattClimaNonRic')"
	cssClass="radio"
	
	/> <label  for="widg_rbTrattClimaNonRicNO0"><s:text name="cpGestReeTipo4.rbTrattClimaNonRic.rbTrattClimaNonRicNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpC --></div>

			
	
	<div id="p_wpD" class="widgetsPanelBlock"><!-- startFragment:p_wpD -->
	
	
<h4 class="wpLabel">D. controllo dell&apos;impianto </h4>
<div class="widgetsPanel" id="wpD">
	
	<customtag:widgetsPanel id="wpDTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestReeTipo4','rbLuogoIdoneo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4.rbLuogoIdoneo.label')}" labelFor="widg_rbLuogoIdoneo" errorFor="appDatareeTipo4.flgLuogoIdoneo" labelId="rbLuogoIdoneoLbl"
	  >


<!-- widget rbLuogoIdoneo -->

	
<div id="appDatareeTipo4.flgLuogoIdoneo" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbLuogoIdoneoSI" name="appDatareeTipo4.flgLuogoIdoneo"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo4','rbLuogoIdoneo')"
	cssClass="radio"
	
	/> <label  for="widg_rbLuogoIdoneoSI1"><s:text name="cpGestReeTipo4.rbLuogoIdoneo.rbLuogoIdoneoSI.label" /></label>








<s:radio
	
	
	id="widg_rbLuogoIdoneoNO" name="appDatareeTipo4.flgLuogoIdoneo"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo4','rbLuogoIdoneo')"
	cssClass="radio"
	
	/> <label  for="widg_rbLuogoIdoneoNO0"><s:text name="cpGestReeTipo4.rbLuogoIdoneo.rbLuogoIdoneoNO.label" /></label>








<s:radio
	
	
	id="widg_rbLuogoIdoneoNC" name="appDatareeTipo4.flgLuogoIdoneo"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestReeTipo4','rbLuogoIdoneo')"
	cssClass="radio"
	
	/> <label  for="widg_rbLuogoIdoneoNC2"><s:text name="cpGestReeTipo4.rbLuogoIdoneo.rbLuogoIdoneoNC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4','rbVentilazAdeg')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4.rbVentilazAdeg.label')}" labelFor="widg_rbVentilazAdeg" errorFor="appDatareeTipo4.flgVentilazAdeg" labelId="rbVentilazAdegLbl"
	  >


<!-- widget rbVentilazAdeg -->

	
<div id="appDatareeTipo4.flgVentilazAdeg" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbVentilazAdegSI" name="appDatareeTipo4.flgVentilazAdeg"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo4','rbVentilazAdeg')"
	cssClass="radio"
	
	/> <label  for="widg_rbVentilazAdegSI1"><s:text name="cpGestReeTipo4.rbVentilazAdeg.rbVentilazAdegSI.label" /></label>








<s:radio
	
	
	id="widg_rbVentilazAdegNO" name="appDatareeTipo4.flgVentilazAdeg"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo4','rbVentilazAdeg')"
	cssClass="radio"
	
	/> <label  for="widg_rbVentilazAdegNO0"><s:text name="cpGestReeTipo4.rbVentilazAdeg.rbVentilazAdegNO.label" /></label>








<s:radio
	
	
	id="widg_rbVentilazAdegNC" name="appDatareeTipo4.flgVentilazAdeg"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestReeTipo4','rbVentilazAdeg')"
	cssClass="radio"
	
	/> <label  for="widg_rbVentilazAdegNC2"><s:text name="cpGestReeTipo4.rbVentilazAdeg.rbVentilazAdegNC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4','rbVentilazLibera')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4.rbVentilazLibera.label')}" labelFor="widg_rbVentilazLibera" errorFor="appDatareeTipo4.flgVentilazLibera" labelId="rbVentilazLiberaLbl"
	  >


<!-- widget rbVentilazLibera -->

	
<div id="appDatareeTipo4.flgVentilazLibera" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbVentilazLiberaSI" name="appDatareeTipo4.flgVentilazLibera"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo4','rbVentilazLibera')"
	cssClass="radio"
	
	/> <label  for="widg_rbVentilazLiberaSI1"><s:text name="cpGestReeTipo4.rbVentilazLibera.rbVentilazLiberaSI.label" /></label>








<s:radio
	
	
	id="widg_rbVentilazLiberaNO" name="appDatareeTipo4.flgVentilazLibera"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo4','rbVentilazLibera')"
	cssClass="radio"
	
	/> <label  for="widg_rbVentilazLiberaNO0"><s:text name="cpGestReeTipo4.rbVentilazLibera.rbVentilazLiberaNO.label" /></label>








<s:radio
	
	
	id="widg_rbVentilazLiberaNC" name="appDatareeTipo4.flgVentilazLibera"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestReeTipo4','rbVentilazLibera')"
	cssClass="radio"
	
	/> <label  for="widg_rbVentilazLiberaNC2"><s:text name="cpGestReeTipo4.rbVentilazLibera.rbVentilazLiberaNC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4','rbLineaElettIdonea')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4.rbLineaElettIdonea.label')}" labelFor="widg_rbLineaElettIdonea" errorFor="appDatareeTipo4.flgLineaElettIdonea" labelId="rbLineaElettIdoneaLbl"
	  >


<!-- widget rbLineaElettIdonea -->

	
<div id="appDatareeTipo4.flgLineaElettIdonea" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbLineaElettIdoneaSI" name="appDatareeTipo4.flgLineaElettIdonea"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo4','rbLineaElettIdonea')"
	cssClass="radio"
	
	/> <label  for="widg_rbLineaElettIdoneaSI1"><s:text name="cpGestReeTipo4.rbLineaElettIdonea.rbLineaElettIdoneaSI.label" /></label>








<s:radio
	
	
	id="widg_rbLineaElettIdoneaNO" name="appDatareeTipo4.flgLineaElettIdonea"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo4','rbLineaElettIdonea')"
	cssClass="radio"
	
	/> <label  for="widg_rbLineaElettIdoneaNO0"><s:text name="cpGestReeTipo4.rbLineaElettIdonea.rbLineaElettIdoneaNO.label" /></label>








<s:radio
	
	
	id="widg_rbLineaElettIdoneaNC" name="appDatareeTipo4.flgLineaElettIdonea"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestReeTipo4','rbLineaElettIdonea')"
	cssClass="radio"
	
	/> <label  for="widg_rbLineaElettIdoneaNC2"><s:text name="cpGestReeTipo4.rbLineaElettIdonea.rbLineaElettIdoneaNC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4','rbCaminoIdoneo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4.rbCaminoIdoneo.label')}" labelFor="widg_rbCaminoIdoneo" errorFor="appDatareeTipo4.flgCaminoIdoneo" labelId="rbCaminoIdoneoLbl"
	  >


<!-- widget rbCaminoIdoneo -->

	
<div id="appDatareeTipo4.flgCaminoIdoneo" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbCaminoIdoneoIdSI" name="appDatareeTipo4.flgCaminoIdoneo"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo4','rbCaminoIdoneo')"
	cssClass="radio"
	
	/> <label  for="widg_rbCaminoIdoneoIdSI1"><s:text name="cpGestReeTipo4.rbCaminoIdoneo.rbCaminoIdoneoIdSI.label" /></label>








<s:radio
	
	
	id="widg_rbCaminoIdoneoNO" name="appDatareeTipo4.flgCaminoIdoneo"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo4','rbCaminoIdoneo')"
	cssClass="radio"
	
	/> <label  for="widg_rbCaminoIdoneoNO0"><s:text name="cpGestReeTipo4.rbCaminoIdoneo.rbCaminoIdoneoNO.label" /></label>








<s:radio
	
	
	id="widg_rbCaminoIdoneoNC" name="appDatareeTipo4.flgCaminoIdoneo"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestReeTipo4','rbCaminoIdoneo')"
	cssClass="radio"
	
	/> <label  for="widg_rbCaminoIdoneoNC2"><s:text name="cpGestReeTipo4.rbCaminoIdoneo.rbCaminoIdoneoNC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4','rbCapsulaIdonea')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4.rbCapsulaIdonea.label')}" labelFor="widg_rbCapsulaIdonea" errorFor="appDatareeTipo4.flgCapsulaIdonea" labelId="rbCapsulaIdoneaLbl"
	  >


<!-- widget rbCapsulaIdonea -->

	
<div id="appDatareeTipo4.flgCapsulaIdonea" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbCapsulaIdoneaSI" name="appDatareeTipo4.flgCapsulaIdonea"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo4','rbCapsulaIdonea')"
	cssClass="radio"
	
	/> <label  for="widg_rbCapsulaIdoneaSI1"><s:text name="cpGestReeTipo4.rbCapsulaIdonea.rbCapsulaIdoneaSI.label" /></label>








<s:radio
	
	
	id="widg_rbCapsulaIdoneaNO" name="appDatareeTipo4.flgCapsulaIdonea"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo4','rbCapsulaIdonea')"
	cssClass="radio"
	
	/> <label  for="widg_rbCapsulaIdoneaNO0"><s:text name="cpGestReeTipo4.rbCapsulaIdonea.rbCapsulaIdoneaNO.label" /></label>








<s:radio
	
	
	id="widg_rbCapsulaIdoneaNC" name="appDatareeTipo4.flgCapsulaIdonea"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestReeTipo4','rbCapsulaIdonea')"
	cssClass="radio"
	
	/> <label  for="widg_rbCapsulaIdoneaNC2"><s:text name="cpGestReeTipo4.rbCapsulaIdonea.rbCapsulaIdoneaNC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4','rbCircIdrIdoneo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4.rbCircIdrIdoneo.label')}" labelFor="widg_rbCircIdrIdoneo" errorFor="appDatareeTipo4.flgCircIdrIdoneo" labelId="rbCircIdrIdoneoLbl"
	  >


<!-- widget rbCircIdrIdoneo -->

	
<div id="appDatareeTipo4.flgCircIdrIdoneo" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbCircIdrIdoneoSI" name="appDatareeTipo4.flgCircIdrIdoneo"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo4','rbCircIdrIdoneo')"
	cssClass="radio"
	
	/> <label  for="widg_rbCircIdrIdoneoSI1"><s:text name="cpGestReeTipo4.rbCircIdrIdoneo.rbCircIdrIdoneoSI.label" /></label>








<s:radio
	
	
	id="widg_rbCircIdrIdoneoNO" name="appDatareeTipo4.flgCircIdrIdoneo"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo4','rbCircIdrIdoneo')"
	cssClass="radio"
	
	/> <label  for="widg_rbCircIdrIdoneoNO0"><s:text name="cpGestReeTipo4.rbCircIdrIdoneo.rbCircIdrIdoneoNO.label" /></label>








<s:radio
	
	
	id="widg_rbCircIdrIdoneoNC" name="appDatareeTipo4.flgCircIdrIdoneo"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestReeTipo4','rbCircIdrIdoneo')"
	cssClass="radio"
	
	/> <label  for="widg_rbCircIdrIdoneoNC2"><s:text name="cpGestReeTipo4.rbCircIdrIdoneo.rbCircIdrIdoneoNC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4','rbCircOlioIdoneo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4.rbCircOlioIdoneo.label')}" labelFor="widg_rbCircOlioIdoneo" errorFor="appDatareeTipo4.flgCircOlioIdoneo" labelId="rbCircOlioIdoneoLbl"
	  >


<!-- widget rbCircOlioIdoneo -->

	
<div id="appDatareeTipo4.flgCircOlioIdoneo" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbCircOlioIdoneoSI" name="appDatareeTipo4.flgCircOlioIdoneo"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo4','rbCircOlioIdoneo')"
	cssClass="radio"
	
	/> <label  for="widg_rbCircOlioIdoneoSI1"><s:text name="cpGestReeTipo4.rbCircOlioIdoneo.rbCircOlioIdoneoSI.label" /></label>








<s:radio
	
title=""	
	id="widg_rbCircOlioIdoneoNO" name="appDatareeTipo4.flgCircOlioIdoneo"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo4','rbCircOlioIdoneo')"
	cssClass="radio"
	
	/> <label  for="widg_rbCircOlioIdoneoNO0"><s:text name="cpGestReeTipo4.rbCircOlioIdoneo.rbCircOlioIdoneoNO.label" /></label>








<s:radio
	
	
	id="widg_rbCircOlioIdoneoNC" name="appDatareeTipo4.flgCircOlioIdoneo"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestReeTipo4','rbCircOlioIdoneo')"
	cssClass="radio"
	
	/> <label  for="widg_rbCircOlioIdoneoNC2"><s:text name="cpGestReeTipo4.rbCircOlioIdoneo.rbCircOlioIdoneoNC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4','rbCircCombIdoneo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4.rbCircCombIdoneo.label')}" labelFor="widg_rbCircCombIdoneo" errorFor="appDatareeTipo4.flgCircCombIdoneo" labelId="rbCircCombIdoneoLbl"
	  >


<!-- widget rbCircCombIdoneo -->

	
<div id="appDatareeTipo4.flgCircCombIdoneo" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbCircCombIdoneoSI" name="appDatareeTipo4.flgCircCombIdoneo"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo4','rbCircCombIdoneo')"
	cssClass="radio"
	
	/> <label  for="widg_rbCircCombIdoneoSI1"><s:text name="cpGestReeTipo4.rbCircCombIdoneo.rbCircCombIdoneoSI.label" /></label>








<s:radio
	
	
	id="widg_rbCircCombIdoneoNO" name="appDatareeTipo4.flgCircCombIdoneo"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo4','rbCircCombIdoneo')"
	cssClass="radio"
	
	/> <label  for="widg_rbCircCombIdoneoNO0"><s:text name="cpGestReeTipo4.rbCircCombIdoneo.rbCircCombIdoneoNO.label" /></label>








<s:radio
	
	
	id="widg_rbCircCombIdoneoNC" name="appDatareeTipo4.flgCircCombIdoneo"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestReeTipo4','rbCircCombIdoneo')"
	cssClass="radio"
	
	/> <label  for="widg_rbCircCombIdoneoNC2"><s:text name="cpGestReeTipo4.rbCircCombIdoneo.rbCircCombIdoneoNC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4','rbFunzScambIdonea')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4.rbFunzScambIdonea.label')}" labelFor="widg_rbFunzScambIdonea" errorFor="appDatareeTipo4.flgFunzScambIdonea" labelId="rbFunzScambIdoneaLbl"
	  >


<!-- widget rbFunzScambIdonea -->

	
<div id="appDatareeTipo4.flgFunzScambIdonea" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbFunzScambIdoneaSI" name="appDatareeTipo4.flgFunzScambIdonea"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo4','rbFunzScambIdonea')"
	cssClass="radio"
	
	/> <label  for="widg_rbFunzScambIdoneaSI1"><s:text name="cpGestReeTipo4.rbFunzScambIdonea.rbFunzScambIdoneaSI.label" /></label>








<s:radio
	
	
	id="widg_rbFunzScambIdoneaNO" name="appDatareeTipo4.flgFunzScambIdonea"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo4','rbFunzScambIdonea')"
	cssClass="radio"
	
	/> <label  for="widg_rbFunzScambIdoneaNO0"><s:text name="cpGestReeTipo4.rbFunzScambIdonea.rbFunzScambIdoneaNO.label" /></label>








<s:radio
	
	
	id="widg_rbFunzScambIdoneaNC" name="appDatareeTipo4.flgFunzScambIdonea"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestReeTipo4','rbFunzScambIdonea')"
	cssClass="radio"
	
	/> <label  for="widg_rbFunzScambIdoneaNC2"><s:text name="cpGestReeTipo4.rbFunzScambIdonea.rbFunzScambIdoneaNC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpD --></div>

			
	
	<div id="p_wpF" class="widgetsPanelBlock"><!-- startFragment:p_wpF -->
	
	
<h4 class="wpLabel">F. check-list </h4>
<div class="widgetsPanel" id="wpF">
	
	<customtag:widgetsPanel id="wpFTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestReeTipo4','ptPossEventi')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo4.ptPossEventi.label')}" labelFor="widg_ptPossEventi" errorFor="widg_ptPossEventi" labelId="ptPossEventiLbl"   >


<!-- widget ptPossEventi -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4','cbAdValvTer')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4.cbAdValvTer.label')}" labelFor="widg_cbAdValvTer" errorFor="appDatareeTipo4.flgAdozioneValvoleTerm" labelId="cbAdValvTerLbl"
	  >


<!-- widget cbAdValvTer -->
<s:checkbox 
	
	
	name="appDatareeTipo4.flgAdozioneValvoleTerm" id="widg_cbAdValvTer"
	disabled="isWidgetDisabled('cpGestReeTipo4','cbAdValvTer')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestReeTipo4','cbAdValvTer')" >
	<s:hidden name="__checkbox_appDatareeTipo4.flgAdozioneValvoleTerm" id="__checkbox_widg_cbAdValvTer" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4','cbIsRete')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4.cbIsRete.label')}" labelFor="widg_cbIsRete" errorFor="appDatareeTipo4.flgIsolamentoRete" labelId="cbIsReteLbl"
	  >


<!-- widget cbIsRete -->
<s:checkbox 
	
	
	name="appDatareeTipo4.flgIsolamentoRete" id="widg_cbIsRete"
	disabled="isWidgetDisabled('cpGestReeTipo4','cbIsRete')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestReeTipo4','cbIsRete')" >
	<s:hidden name="__checkbox_appDatareeTipo4.flgIsolamentoRete" id="__checkbox_widg_cbIsRete" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4','cbAdozSistTratt')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4.cbAdozSistTratt.label')}" labelFor="widg_cbAdozSistTratt" errorFor="appDatareeTipo4.flgSistemaTrattH2O" labelId="cbAdozSistTrattLbl"
	  >


<!-- widget cbAdozSistTratt -->
<s:checkbox 
	
	
	name="appDatareeTipo4.flgSistemaTrattH2O" id="widg_cbAdozSistTratt"
	disabled="isWidgetDisabled('cpGestReeTipo4','cbAdozSistTratt')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestReeTipo4','cbAdozSistTratt')" >
	<s:hidden name="__checkbox_appDatareeTipo4.flgSistemaTrattH2O" id="__checkbox_widg_cbAdozSistTratt" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4','cbSostSistReg')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4.cbSostSistReg.label')}" labelFor="widg_cbSostSistReg" errorFor="appDatareeTipo4.flgSostSistemaRegolaz" labelId="cbSostSistRegLbl"
	  >


<!-- widget cbSostSistReg -->
<s:checkbox 
	
	
	name="appDatareeTipo4.flgSostSistemaRegolaz" id="widg_cbSostSistReg"
	disabled="isWidgetDisabled('cpGestReeTipo4','cbSostSistReg')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestReeTipo4','cbSostSistReg')" >
	<s:hidden name="__checkbox_appDatareeTipo4.flgSostSistemaRegolaz" id="__checkbox_widg_cbSostSistReg" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4','taOss')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4.taOss.label')}" labelFor="widg_taOss" errorFor="appDatareeTipo4.osservazioni" labelId="taOssLbl"
	  >


<!-- widget taOss -->
<s:textarea 
	
	
	name="appDatareeTipo4.osservazioni" id="widg_taOss"
	disabled="isWidgetDisabled('cpGestReeTipo4','taOss')"
	rows="3"
	cols="25"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4','taRacc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4.taRacc.label')}" labelFor="widg_taRacc" errorFor="appDatareeTipo4.raccomandazioni" labelId="taRaccLbl"
	  >


<!-- widget taRacc -->
<s:textarea 
	
	
	name="appDatareeTipo4.raccomandazioni" id="widg_taRacc"
	disabled="isWidgetDisabled('cpGestReeTipo4','taRacc')"
	rows="3"
	cols="25"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4','taPre')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4.taPre.label')}" labelFor="widg_taPre" errorFor="appDatareeTipo4.prescrizioni" labelId="taPreLbl"
	  >


<!-- widget taPre -->
<s:textarea 
	
	
	name="appDatareeTipo4.prescrizioni" id="widg_taPre"
	disabled="isWidgetDisabled('cpGestReeTipo4','taPre')"
	rows="3"
	cols="25"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4','rbFunz')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4.rbFunz.label')}" labelFor="widg_rbFunz" errorFor="appDatareeTipo4.flgPuoFunzionare" labelId="rbFunzLbl"
	  >


<!-- widget rbFunz -->

	
<div id="appDatareeTipo4.flgPuoFunzionare" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbFunzSI" name="appDatareeTipo4.flgPuoFunzionare"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo4','rbFunz')"
	cssClass="radio"
	
	/> <label  for="widg_rbFunzSI1"><s:text name="cpGestReeTipo4.rbFunz.rbFunzSI.label" /></label>








<s:radio
	
	
	id="widg_rbFunzNO" name="appDatareeTipo4.flgPuoFunzionare"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo4','rbFunz')"
	cssClass="radio"
	
	/> <label  for="widg_rbFunzNO0"><s:text name="cpGestReeTipo4.rbFunz.rbFunzNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4','cIntEntro')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4.cIntEntro.label')}" labelFor="widg_cIntEntro" errorFor="appDatareeTipo4.interventoEntro" labelId="cIntEntroLbl"
	  >


<!-- widget cIntEntro -->
<s:textfield 
	
	
	name="appDatareeTipo4.interventoEntro" id="widg_cIntEntro"
	disabled="isWidgetDisabled('cpGestReeTipo4','cIntEntro')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4','tfOraArrivo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4.tfOraArrivo.label')}" labelFor="widg_tfOraArrivo" errorFor="appDatareeTipo4.oraArrivo" labelId="tfOraArrivoLbl"
	  >


<!-- widget tfOraArrivo -->
<s:textfield 
	
	
	name="appDatareeTipo4.oraArrivo" id="widg_tfOraArrivo"
maxlength="10"	disabled="isWidgetDisabled('cpGestReeTipo4','tfOraArrivo')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4','tfOraPart')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4.tfOraPart.label')}" labelFor="widg_tfOraPart" errorFor="appDatareeTipo4.oraPartenza" labelId="tfOraPartLbl"
	  >


<!-- widget tfOraPart -->
<s:textfield 
	
	
	name="appDatareeTipo4.oraPartenza" id="widg_tfOraPart"
maxlength="10"	disabled="isWidgetDisabled('cpGestReeTipo4','tfOraPart')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4','tfTec')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4.tfTec.label')}" labelFor="widg_tfTec" errorFor="appDatareeTipo4.denominazTecnico" labelId="tfTecLbl"
	  fieldRequired="true">


<!-- widget tfTec -->
<s:textfield 
	
	
	name="appDatareeTipo4.denominazTecnico" id="widg_tfTec"
maxlength="100"	disabled="isWidgetDisabled('cpGestReeTipo4','tfTec')"
	size="60" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpF --></div>

			
	
	<div id="p_cpFunGestRee" class="commandPanelBlock"><!-- startFragment:p_cpFunGestRee -->
	
	
<div class="commandPanel functional" id="cpFunGestRee">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestReeTipo4','bSalvaRee')" >

	



<!-- widget bSalvaRee -->
<s:submit name="widg_bSalvaRee" id="widg_bSalvaRee" method="handleBSalvaRee_CLICKED"
	key="cpGestReeTipo4.bSalvaRee.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestReeTipo4','bSalvaRee')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunGestRee --></div>

			
	
	<div id="p_cpNavGestRee" class="commandPanelBlock"><!-- startFragment:p_cpNavGestRee -->
	
	
<div class="commandPanel navigation" id="cpNavGestRee">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestReeTipo4','btnIndietro')" >

	



<!-- widget btnIndietro -->
<s:submit name="widg_btnIndietro" id="widg_btnIndietro" method="handleBtnIndietro_CLICKED"
	key="cpGestReeTipo4.btnIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestReeTipo4','btnIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavGestRee --></div>

	

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
