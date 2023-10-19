<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_ree_tipo2 -->
<!-- pageId:cpGestReeTipo2 -->

<s:form id="cpGestReeTipo2" action="cpGestReeTipo2" namespace="/base/gestisci_ree_tipo2" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestReeTipo2_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpGestReeTipo2','menu')" >

	


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

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestReeTipo2_udpFunzionalita.jsp"></s:include>

	



			
	
	<div id="p_wpMenuTree" class="widgetsPanelBlock"><!-- startFragment:p_wpMenuTree -->
	
	

<div class="widgetsPanel" id="wpMenuTree">
	
	<customtag:widgetsPanel id="wpMenuTreeTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestReeTipo2','menuRee')" >

	
<customtag:widgetsPanelColumn 
	 colSpan="2" >



	<csiuicore:ajaxify id="p_wpMenuTree" 
		widgetType="tree" 
		pageId="cpGestReeTipo2"
		javascriptDetection="false">
	<customtag:tree
		name="appDatareeMenuTree"
		cssUlClass="tree"
        cssRootClass="treeRoot" cssFolderOpenClass="treeFolderOpen"
        cssFolderClosedClass="treeFolderClosed" cssDotClass="treeDot"
		linkOnTree="true" id="menuRee"
		selectionMultiplicity="none"
		requestURI="/sigitwebn/base/gestisci_ree_tipo2/cpGestReeTipo2!handleMenuRee_CLICKED.do"
		nameSpace="/base/gestisci_ree_tipo2"
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
		
	
<h4 class="fpLabel"><s:text name="cpGestReeTipo2.fpGestRee.label" /></h4>
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
	

	
	
<s:if test="isWidgetVisible('cpGestReeTipo2','ptCodiceImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo2.ptCodiceImpianto.label')}" labelFor="widg_ptCodiceImpianto" errorFor="appDataidentificativoImpianto.codiceImpianto" labelId="ptCodiceImpiantoLbl"  position="first" >


<!-- widget ptCodiceImpianto -->
<s:property value="appDataidentificativoImpianto.codiceImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestReeTipo2','ptUbicazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo2.ptUbicazione.label')}" labelFor="widg_ptUbicazione" errorFor="appDataidentificativoImpianto.ubicazione" labelId="ptUbicazioneLbl"  position="last" >


<!-- widget ptUbicazione -->
<s:property value="appDataidentificativoImpianto.ubicazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestReeTipo2','ptResponsabile')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo2.ptResponsabile.label')}" labelFor="widg_ptResponsabile" errorFor="appDataidentificativoImpianto.responsabile" labelId="ptResponsabileLbl"  position="first" >


<!-- widget ptResponsabile -->
<s:property value="appDataidentificativoImpianto.responsabile" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestReeTipo2','wpInfoImpianto_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpInfoImpianto_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestReeTipo2','ptDataControllo')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo2.ptDataControllo.label')}" labelFor="widg_ptDataControllo" errorFor="appDataallegato.dataControllo" labelId="ptDataControlloLbl"  position="first" >


<!-- widget ptDataControllo -->
<s:property value="appDataallegato.dataControllo" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestReeTipo2','ptBollino')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo2.ptBollino.label')}" labelFor="widg_ptBollino" errorFor="appDataallegato.codiceBollino" labelId="ptBollinoLbl"  position="last" >


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
	

	
	
<s:if test="isWidgetVisible('cpGestReeTipo2','tfPotenzaTermicaNomMax')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo2.tfPotenzaTermicaNomMax.label')}" labelFor="widg_tfPotenzaTermicaNomMax" errorFor="appDatareeTipo2.potenzaTermicaNomMax" labelId="tfPotenzaTermicaNomMaxLbl"
	  fieldRequired="true">


<!-- widget tfPotenzaTermicaNomMax -->
<s:textfield 
	
title=""	
	name="appDatareeTipo2.potenzaTermicaNomMax" id="widg_tfPotenzaTermicaNomMax"
maxlength="10"	disabled="isWidgetDisabled('cpGestReeTipo2','tfPotenzaTermicaNomMax')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2','ptResponsabileImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo2.ptResponsabileImpianto.label')}" labelFor="widg_ptResponsabileImpianto" errorFor="appDatareeTipo2.responsabileImpianto" labelId="ptResponsabileImpiantoLbl"   >


<!-- widget ptResponsabileImpianto -->
<s:property value="appDatareeTipo2.responsabileImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2','ptImpresaManutInstal')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo2.ptImpresaManutInstal.label')}" labelFor="widg_ptImpresaManutInstal" errorFor="appDatareeTipo2.impresaManutInstal" labelId="ptImpresaManutInstalLbl"   >


<!-- widget ptImpresaManutInstal -->
<s:property value="appDatareeTipo2.impresaManutInstal" escape="false" />

	
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
	

	
	
<s:if test="isWidgetVisible('cpGestReeTipo2','rbDicConf')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo2.rbDicConf.label')}" labelFor="widg_rbDicConf" errorFor="appDatareeTipo2.flgDichiarConform" labelId="rbDicConfLbl"
	  fieldRequired="true">


<!-- widget rbDicConf -->

	
<div id="appDatareeTipo2.flgDichiarConform" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbDicConfSI" name="appDatareeTipo2.flgDichiarConform"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo2','rbDicConf')"
	cssClass="radio"
	
	/> <label  for="widg_rbDicConfSI1"><s:text name="cpGestReeTipo2.rbDicConf.rbDicConfSI.label" /></label>








<s:radio
	
title=""	
	id="widg_rbDicConfNO" name="appDatareeTipo2.flgDichiarConform"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo2','rbDicConf')"
	cssClass="radio"
	
	/> <label  for="widg_rbDicConfNO0"><s:text name="cpGestReeTipo2.rbDicConf.rbDicConfNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2','rbLibImp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo2.rbLibImp.label')}" labelFor="widg_rbLibImp" errorFor="appDatareeTipo2.flgLibImp" labelId="rbLibImpLbl"
	  fieldRequired="true">


<!-- widget rbLibImp -->

	
<div id="appDatareeTipo2.flgLibImp" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbLibImpSI" name="appDatareeTipo2.flgLibImp"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo2','rbLibImp')"
	cssClass="radio"
	
	/> <label  for="widg_rbLibImpSI1"><s:text name="cpGestReeTipo2.rbLibImp.rbLibImpSI.label" /></label>








<s:radio
	
title=""	
	id="widg_rbLibImpNO" name="appDatareeTipo2.flgLibImp"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo2','rbLibImp')"
	cssClass="radio"
	
	/> <label  for="widg_rbLibImpNO0"><s:text name="cpGestReeTipo2.rbLibImp.rbLibImpNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2','rbLibUso')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo2.rbLibUso.label')}" labelFor="widg_rbLibUso" errorFor="appDatareeTipo2.flgLibrettoUso" labelId="rbLibUsoLbl"
	  fieldRequired="true">


<!-- widget rbLibUso -->

	
<div id="appDatareeTipo2.flgLibrettoUso" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbLibUsoSI" name="appDatareeTipo2.flgLibrettoUso"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo2','rbLibUso')"
	cssClass="radio"
	
	/> <label  for="widg_rbLibUsoSI1"><s:text name="cpGestReeTipo2.rbLibUso.rbLibUsoSI.label" /></label>








<s:radio
	
title=""	
	id="widg_rbLibUsoNO" name="appDatareeTipo2.flgLibrettoUso"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo2','rbLibUso')"
	cssClass="radio"
	
	/> <label  for="widg_rbLibUsoNO0"><s:text name="cpGestReeTipo2.rbLibUso.rbLibUsoNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2','rbLibComp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo2.rbLibComp.label')}" labelFor="widg_rbLibComp" errorFor="appDatareeTipo2.flgLibCompl" labelId="rbLibCompLbl"
	  fieldRequired="true">


<!-- widget rbLibComp -->

	
<div id="appDatareeTipo2.flgLibCompl" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbLibCompSI" name="appDatareeTipo2.flgLibCompl"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo2','rbLibComp')"
	cssClass="radio"
	
	/> <label  for="widg_rbLibCompSI1"><s:text name="cpGestReeTipo2.rbLibComp.rbLibCompSI.label" /></label>








<s:radio
	
title=""	
	id="widg_rbLibCompNO" name="appDatareeTipo2.flgLibCompl"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo2','rbLibComp')"
	cssClass="radio"
	
	/> <label  for="widg_rbLibCompNO0"><s:text name="cpGestReeTipo2.rbLibComp.rbLibCompNO.label" /></label>





	
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
	

	
	
<s:if test="isWidgetVisible('cpGestReeTipo2','ptDurezzaH20')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo2.ptDurezzaH20.label')}" labelFor="widg_ptDurezzaH20" errorFor="appDatareeTipo2.durezzaH2OFr" labelId="ptDurezzaH20Lbl"   >


<!-- widget ptDurezzaH20 -->
<s:property value="appDatareeTipo2.durezzaH2OFr" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2','ptTrattamento')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo2.ptTrattamento.label')}" labelFor="widg_ptTrattamento" errorFor="appDatareeTipo2.descTrattClima" labelId="ptTrattamentoLbl"   >


<!-- widget ptTrattamento -->
<s:property value="appDatareeTipo2.descTrattClima" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2','rbTrattClimaNonRic')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo2.rbTrattClimaNonRic.label')}" labelFor="widg_rbTrattClimaNonRic" errorFor="appDatareeTipo2.flgTrattClimaNonRich" labelId="rbTrattClimaNonRicLbl"
	  >


<!-- widget rbTrattClimaNonRic -->

	
<div id="appDatareeTipo2.flgTrattClimaNonRich" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbTrattClimaNonRicSI" name="appDatareeTipo2.flgTrattClimaNonRich"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo2','rbTrattClimaNonRic')"
	cssClass="radio"
	
	/> <label  for="widg_rbTrattClimaNonRicSI1"><s:text name="cpGestReeTipo2.rbTrattClimaNonRic.rbTrattClimaNonRicSI.label" /></label>








<s:radio
	
title=""	
	id="widg_rbTrattClimaNonRicNO" name="appDatareeTipo2.flgTrattClimaNonRich"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo2','rbTrattClimaNonRic')"
	cssClass="radio"
	
	/> <label  for="widg_rbTrattClimaNonRicNO0"><s:text name="cpGestReeTipo2.rbTrattClimaNonRic.rbTrattClimaNonRicNO.label" /></label>





	
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
	

	
	
<s:if test="isWidgetVisible('cpGestReeTipo2','rbLocIntId')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo2.rbLocIntId.label')}" labelFor="widg_rbLocIntId" errorFor="appDatareeTipo2.flgLocaleIntIdoneo" labelId="rbLocIntIdLbl"
	  fieldRequired="true">


<!-- widget rbLocIntId -->

	
<div id="appDatareeTipo2.flgLocaleIntIdoneo" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbLocIntIdSI" name="appDatareeTipo2.flgLocaleIntIdoneo"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo2','rbLocIntId')"
	cssClass="radio"
	
	/> <label  for="widg_rbLocIntIdSI1"><s:text name="cpGestReeTipo2.rbLocIntId.rbLocIntIdSI.label" /></label>








<s:radio
	
title=""	
	id="widg_rbLocIntIdNO" name="appDatareeTipo2.flgLocaleIntIdoneo"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo2','rbLocIntId')"
	cssClass="radio"
	
	/> <label  for="widg_rbLocIntIdNO0"><s:text name="cpGestReeTipo2.rbLocIntId.rbLocIntIdNO.label" /></label>








<s:radio
	
title=""	
	id="widg_rbLocIntIdNC" name="appDatareeTipo2.flgLocaleIntIdoneo"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestReeTipo2','rbLocIntId')"
	cssClass="radio"
	
	/> <label  for="widg_rbLocIntIdNC2"><s:text name="cpGestReeTipo2.rbLocIntId.rbLocIntIdNC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2','rbDimensioniAdeguate')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo2.rbDimensioniAdeguate.label')}" labelFor="widg_rbDimensioniAdeguate" errorFor="appDatareeTipo2.flgApertureAdeguate" labelId="rbDimensioniAdeguateLbl"
	  fieldRequired="true">


<!-- widget rbDimensioniAdeguate -->

	
<div id="appDatareeTipo2.flgApertureAdeguate" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbDimAdegIdSI" name="appDatareeTipo2.flgApertureAdeguate"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo2','rbDimensioniAdeguate')"
	cssClass="radio"
	
	/> <label  for="widg_rbDimAdegIdSI1"><s:text name="cpGestReeTipo2.rbDimensioniAdeguate.rbDimAdegIdSI.label" /></label>








<s:radio
	
title=""	
	id="widg_rbDimAdegIdNO" name="appDatareeTipo2.flgApertureAdeguate"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo2','rbDimensioniAdeguate')"
	cssClass="radio"
	
	/> <label  for="widg_rbDimAdegIdNO0"><s:text name="cpGestReeTipo2.rbDimensioniAdeguate.rbDimAdegIdNO.label" /></label>








<s:radio
	
title=""	
	id="widg_rbDimAdegIdNC" name="appDatareeTipo2.flgApertureAdeguate"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestReeTipo2','rbDimensioniAdeguate')"
	cssClass="radio"
	
	/> <label  for="widg_rbDimAdegIdNC2"><s:text name="cpGestReeTipo2.rbDimensioniAdeguate.rbDimAdegIdNC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2','rbApertureLibere')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo2.rbApertureLibere.label')}" labelFor="widg_rbApertureLibere" errorFor="appDatareeTipo2.flgApertureLibere" labelId="rbApertureLibereLbl"
	  fieldRequired="true">


<!-- widget rbApertureLibere -->

	
<div id="appDatareeTipo2.flgApertureLibere" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbApLibIdSI" name="appDatareeTipo2.flgApertureLibere"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo2','rbApertureLibere')"
	cssClass="radio"
	
	/> <label  for="widg_rbApLibIdSI1"><s:text name="cpGestReeTipo2.rbApertureLibere.rbApLibIdSI.label" /></label>








<s:radio
	
title=""	
	id="widg_rbApLibIdNO" name="appDatareeTipo2.flgApertureLibere"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo2','rbApertureLibere')"
	cssClass="radio"
	
	/> <label  for="widg_rbApLibIdNO0"><s:text name="cpGestReeTipo2.rbApertureLibere.rbApLibIdNO.label" /></label>








<s:radio
	
title=""	
	id="widg_rbApLibIdNC" name="appDatareeTipo2.flgApertureLibere"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestReeTipo2','rbApertureLibere')"
	cssClass="radio"
	
	/> <label  for="widg_rbApLibIdNC2"><s:text name="cpGestReeTipo2.rbApertureLibere.rbApLibIdNC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2','rbLineeElet')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo2.rbLineeElet.label')}" labelFor="widg_rbLineeElet" errorFor="appDatareeTipo2.flgLineaElettIdonea" labelId="rbLineeEletLbl"
	  fieldRequired="true">


<!-- widget rbLineeElet -->

	
<div id="appDatareeTipo2.flgLineaElettIdonea" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbLinElIdSI" name="appDatareeTipo2.flgLineaElettIdonea"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo2','rbLineeElet')"
	cssClass="radio"
	
	/> <label  for="widg_rbLinElIdSI1"><s:text name="cpGestReeTipo2.rbLineeElet.rbLinElIdSI.label" /></label>








<s:radio
	
title=""	
	id="widg_rbLinElIdNO" name="appDatareeTipo2.flgLineaElettIdonea"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo2','rbLineeElet')"
	cssClass="radio"
	
	/> <label  for="widg_rbLinElIdNO0"><s:text name="cpGestReeTipo2.rbLineeElet.rbLinElIdNO.label" /></label>








<s:radio
	
title=""	
	id="widg_rbLinElIdNC" name="appDatareeTipo2.flgLineaElettIdonea"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestReeTipo2','rbLineeElet')"
	cssClass="radio"
	
	/> <label  for="widg_rbLinElIdNC2"><s:text name="cpGestReeTipo2.rbLineeElet.rbLinElIdNC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2','rbCoibId')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo2.rbCoibId.label')}" labelFor="widg_rbCoibId" errorFor="appDatareeTipo2.flgCoibentIdonea" labelId="rbCoibIdLbl"
	  fieldRequired="true">


<!-- widget rbCoibId -->

	
<div id="appDatareeTipo2.flgCoibentIdonea" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbCoibIdSI" name="appDatareeTipo2.flgCoibentIdonea"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo2','rbCoibId')"
	cssClass="radio"
	
	/> <label  for="widg_rbCoibIdSI1"><s:text name="cpGestReeTipo2.rbCoibId.rbCoibIdSI.label" /></label>








<s:radio
	
title=""	
	id="widg_rbCoibIdNO" name="appDatareeTipo2.flgCoibentIdonea"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo2','rbCoibId')"
	cssClass="radio"
	
	/> <label  for="widg_rbCoibIdNO0"><s:text name="cpGestReeTipo2.rbCoibId.rbCoibIdNO.label" /></label>








<s:radio
	
title=""	
	id="widg_rbCoibIdNC" name="appDatareeTipo2.flgCoibentIdonea"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestReeTipo2','rbCoibId')"
	cssClass="radio"
	
	/> <label  for="widg_rbCoibIdNC2"><s:text name="cpGestReeTipo2.rbCoibId.rbCoibIdNC.label" /></label>





	
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
	

	
	
<s:if test="isWidgetVisible('cpGestReeTipo2','ptPossEventi')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo2.ptPossEventi.label')}" labelFor="widg_ptPossEventi" errorFor="widg_ptPossEventi" labelId="ptPossEventiLbl"   >


<!-- widget ptPossEventi -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2','cbSostGen')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo2.cbSostGen.label')}" labelFor="widg_cbSostGen" errorFor="appDatareeTipo2.flgSostituzGeneratori" labelId="cbSostGenLbl"
	  >


<!-- widget cbSostGen -->
<s:checkbox 
	
	
	name="appDatareeTipo2.flgSostituzGeneratori" id="widg_cbSostGen"
	disabled="isWidgetDisabled('cpGestReeTipo2','cbSostGen')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestReeTipo2','cbSostGen')" >
	<s:hidden name="__checkbox_appDatareeTipo2.flgSostituzGeneratori" id="__checkbox_widg_cbSostGen" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2','cbSostSist')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo2.cbSostSist.label')}" labelFor="widg_cbSostSist" errorFor="appDatareeTipo2.flgSostituzRestemiReg" labelId="cbSostSistLbl"
	  >


<!-- widget cbSostSist -->
<s:checkbox 
	
	
	name="appDatareeTipo2.flgSostituzRestemiReg" id="widg_cbSostSist"
	disabled="isWidgetDisabled('cpGestReeTipo2','cbSostSist')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestReeTipo2','cbSostSist')" >
	<s:hidden name="__checkbox_appDatareeTipo2.flgSostituzRestemiReg" id="__checkbox_widg_cbSostSist" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2','cbIsolDis')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo2.cbIsolDis.label')}" labelFor="widg_cbIsolDis" errorFor="appDatareeTipo2.flgIsolDistribuzH2o" labelId="cbIsolDisLbl"
	  >


<!-- widget cbIsolDis -->
<s:checkbox 
	
	
	name="appDatareeTipo2.flgIsolDistribuzH2o" id="widg_cbIsolDis"
	disabled="isWidgetDisabled('cpGestReeTipo2','cbIsolDis')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestReeTipo2','cbIsolDis')" >
	<s:hidden name="__checkbox_appDatareeTipo2.flgIsolDistribuzH2o" id="__checkbox_widg_cbIsolDis" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2','cbIsolAria')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo2.cbIsolAria.label')}" labelFor="widg_cbIsolAria" errorFor="appDatareeTipo2.flgIsolDistribuzAria" labelId="cbIsolAriaLbl"
	  >


<!-- widget cbIsolAria -->
<s:checkbox 
	
	
	name="appDatareeTipo2.flgIsolDistribuzAria" id="widg_cbIsolAria"
	disabled="isWidgetDisabled('cpGestReeTipo2','cbIsolAria')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestReeTipo2','cbIsolAria')" >
	<s:hidden name="__checkbox_appDatareeTipo2.flgIsolDistribuzAria" id="__checkbox_widg_cbIsolAria" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2','taOss')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo2.taOss.label')}" labelFor="widg_taOss" errorFor="appDatareeTipo2.osservazioni" labelId="taOssLbl"
	  >


<!-- widget taOss -->
<s:textarea 
	
	
	name="appDatareeTipo2.osservazioni" id="widg_taOss"
	disabled="isWidgetDisabled('cpGestReeTipo2','taOss')"
	rows="3"
	cols="25"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2','taRacc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo2.taRacc.label')}" labelFor="widg_taRacc" errorFor="appDatareeTipo2.raccomandazioni" labelId="taRaccLbl"
	  >


<!-- widget taRacc -->
<s:textarea 
	
	
	name="appDatareeTipo2.raccomandazioni" id="widg_taRacc"
	disabled="isWidgetDisabled('cpGestReeTipo2','taRacc')"
	rows="3"
	cols="25"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2','taPre')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo2.taPre.label')}" labelFor="widg_taPre" errorFor="appDatareeTipo2.prescrizioni" labelId="taPreLbl"
	  >


<!-- widget taPre -->
<s:textarea 
	
	
	name="appDatareeTipo2.prescrizioni" id="widg_taPre"
	disabled="isWidgetDisabled('cpGestReeTipo2','taPre')"
	rows="3"
	cols="25"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2','rbFunz')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo2.rbFunz.label')}" labelFor="widg_rbFunz" errorFor="appDatareeTipo2.flgPuoFunzionare" labelId="rbFunzLbl"
	  fieldRequired="true">


<!-- widget rbFunz -->

	
<div id="appDatareeTipo2.flgPuoFunzionare" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbFunzSI" name="appDatareeTipo2.flgPuoFunzionare"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo2','rbFunz')"
	cssClass="radio"
	
	/> <label  for="widg_rbFunzSI1"><s:text name="cpGestReeTipo2.rbFunz.rbFunzSI.label" /></label>








<s:radio
	
title=""	
	id="widg_rbFunzNO" name="appDatareeTipo2.flgPuoFunzionare"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo2','rbFunz')"
	cssClass="radio"
	
	/> <label  for="widg_rbFunzNO0"><s:text name="cpGestReeTipo2.rbFunz.rbFunzNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2','cIntEntro')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo2.cIntEntro.label')}" labelFor="widg_cIntEntro" errorFor="appDatareeTipo2.interventoEntro" labelId="cIntEntroLbl"
	  >


<!-- widget cIntEntro -->
<s:textfield 
	
	
	name="appDatareeTipo2.interventoEntro" id="widg_cIntEntro"
	disabled="isWidgetDisabled('cpGestReeTipo2','cIntEntro')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2','tfOraArrivo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo2.tfOraArrivo.label')}" labelFor="widg_tfOraArrivo" errorFor="appDatareeTipo2.oraArrivo" labelId="tfOraArrivoLbl"
	  >


<!-- widget tfOraArrivo -->
<s:textfield 
	
	
	name="appDatareeTipo2.oraArrivo" id="widg_tfOraArrivo"
maxlength="10"	disabled="isWidgetDisabled('cpGestReeTipo2','tfOraArrivo')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2','tfOraPart')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo2.tfOraPart.label')}" labelFor="widg_tfOraPart" errorFor="appDatareeTipo2.oraPartenza" labelId="tfOraPartLbl"
	  >


<!-- widget tfOraPart -->
<s:textfield 
	
	
	name="appDatareeTipo2.oraPartenza" id="widg_tfOraPart"
maxlength="10"	disabled="isWidgetDisabled('cpGestReeTipo2','tfOraPart')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2','tfTec')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo2.tfTec.label')}" labelFor="widg_tfTec" errorFor="appDatareeTipo2.denominazTecnico" labelId="tfTecLbl"
	  fieldRequired="true">


<!-- widget tfTec -->
<s:textfield 
	
	
	name="appDatareeTipo2.denominazTecnico" id="widg_tfTec"
maxlength="100"	disabled="isWidgetDisabled('cpGestReeTipo2','tfTec')"
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
		
<s:if test="isWidgetVisible('cpGestReeTipo2','bSalvaRee')" >

	



<!-- widget bSalvaRee -->
<s:submit name="widg_bSalvaRee" id="widg_bSalvaRee" method="handleBSalvaRee_CLICKED"
	key="cpGestReeTipo2.bSalvaRee.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestReeTipo2','bSalvaRee')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunGestRee --></div>

			
	
	<div id="p_cpNavGestRee" class="commandPanelBlock"><!-- startFragment:p_cpNavGestRee -->
	
	
<div class="commandPanel navigation" id="cpNavGestRee">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestReeTipo2','btnIndietro')" >

	



<!-- widget btnIndietro -->
<s:submit name="widg_btnIndietro" id="widg_btnIndietro" method="handleBtnIndietro_CLICKED"
	key="cpGestReeTipo2.btnIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestReeTipo2','btnIndietro')" />

	


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
