<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_ree_tipo3 -->
<!-- pageId:cpGestReeTipo3 -->

<s:form id="cpGestReeTipo3" action="cpGestReeTipo3" namespace="/base/gestisci_ree_tipo3" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestReeTipo3_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpGestReeTipo3','menu')" >

	


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

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestReeTipo3_udpFunzionalita.jsp"></s:include>

	



			
	
	<div id="p_wpMenuTree" class="widgetsPanelBlock"><!-- startFragment:p_wpMenuTree -->
	
	

<div class="widgetsPanel" id="wpMenuTree">
	
	<customtag:widgetsPanel id="wpMenuTreeTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestReeTipo3','menuRee')" >

	
<customtag:widgetsPanelColumn 
	 colSpan="2" >



	<csiuicore:ajaxify id="p_wpMenuTree" 
		widgetType="tree" 
		pageId="cpGestReeTipo3"
		javascriptDetection="false">
	<customtag:tree
		name="appDatareeMenuTree"
		cssUlClass="tree"
        cssRootClass="treeRoot" cssFolderOpenClass="treeFolderOpen"
        cssFolderClosedClass="treeFolderClosed" cssDotClass="treeDot"
		linkOnTree="true" id="menuRee"
		selectionMultiplicity="none"
		requestURI="/sigitwebn/base/gestisci_ree_tipo3/cpGestReeTipo3!handleMenuRee_CLICKED.do"
		nameSpace="/base/gestisci_ree_tipo3"
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
		
	
<h4 class="fpLabel"><s:text name="cpGestReeTipo3.fpGestRee.label" /></h4>
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
	

	
	
<s:if test="isWidgetVisible('cpGestReeTipo3','ptCodiceImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo3.ptCodiceImpianto.label')}" labelFor="widg_ptCodiceImpianto" errorFor="appDataidentificativoImpianto.codiceImpianto" labelId="ptCodiceImpiantoLbl"  position="first" >


<!-- widget ptCodiceImpianto -->
<s:property value="appDataidentificativoImpianto.codiceImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestReeTipo3','ptUbicazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo3.ptUbicazione.label')}" labelFor="widg_ptUbicazione" errorFor="appDataidentificativoImpianto.ubicazione" labelId="ptUbicazioneLbl"  position="last" >


<!-- widget ptUbicazione -->
<s:property value="appDataidentificativoImpianto.ubicazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestReeTipo3','ptResponsabile')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo3.ptResponsabile.label')}" labelFor="widg_ptResponsabile" errorFor="appDataidentificativoImpianto.responsabile" labelId="ptResponsabileLbl"  position="first" >


<!-- widget ptResponsabile -->
<s:property value="appDataidentificativoImpianto.responsabile" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestReeTipo3','wpInfoImpianto_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpInfoImpianto_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestReeTipo3','ptDataControllo')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo3.ptDataControllo.label')}" labelFor="widg_ptDataControllo" errorFor="appDataallegato.dataControllo" labelId="ptDataControlloLbl"  position="first" >


<!-- widget ptDataControllo -->
<s:property value="appDataallegato.dataControllo" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestReeTipo3','ptBollino')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo3.ptBollino.label')}" labelFor="widg_ptBollino" errorFor="appDataallegato.codiceBollino" labelId="ptBollinoLbl"  position="last" >


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
	

	
	
<s:if test="isWidgetVisible('cpGestReeTipo3','tfPotenzaTermicaNomMax')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo3.tfPotenzaTermicaNomMax.label')}" labelFor="widg_tfPotenzaTermicaNomMax" errorFor="appDatareeTipo3.potenzaTermicaNomMax" labelId="tfPotenzaTermicaNomMaxLbl"
	  fieldRequired="true">


<!-- widget tfPotenzaTermicaNomMax -->
<s:textfield 
	
title=""	
	name="appDatareeTipo3.potenzaTermicaNomMax" id="widg_tfPotenzaTermicaNomMax"
maxlength="10"	disabled="isWidgetDisabled('cpGestReeTipo3','tfPotenzaTermicaNomMax')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo3','ptResponsabileImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo3.ptResponsabileImpianto.label')}" labelFor="widg_ptResponsabileImpianto" errorFor="appDatareeTipo3.responsabileImpianto" labelId="ptResponsabileImpiantoLbl"   >


<!-- widget ptResponsabileImpianto -->
<s:property value="appDatareeTipo3.responsabileImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo3','ptImpresaManutInstal')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo3.ptImpresaManutInstal.label')}" labelFor="widg_ptImpresaManutInstal" errorFor="appDatareeTipo3.impresaManutInstal" labelId="ptImpresaManutInstalLbl"   >


<!-- widget ptImpresaManutInstal -->
<s:property value="appDatareeTipo3.impresaManutInstal" escape="false" />

	
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
	

	
	
<s:if test="isWidgetVisible('cpGestReeTipo3','rbDicConf')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo3.rbDicConf.label')}" labelFor="widg_rbDicConf" errorFor="appDatareeTipo3.flgDichiarConform" labelId="rbDicConfLbl"
	  fieldRequired="true">


<!-- widget rbDicConf -->

	
<div id="appDatareeTipo3.flgDichiarConform" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbDicConfSI" name="appDatareeTipo3.flgDichiarConform"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo3','rbDicConf')"
	cssClass="radio"
	
	/> <label  for="widg_rbDicConfSI1"><s:text name="cpGestReeTipo3.rbDicConf.rbDicConfSI.label" /></label>








<s:radio
	
title=""	
	id="widg_rbDicConfNO" name="appDatareeTipo3.flgDichiarConform"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo3','rbDicConf')"
	cssClass="radio"
	
	/> <label  for="widg_rbDicConfNO0"><s:text name="cpGestReeTipo3.rbDicConf.rbDicConfNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo3','rbLibImp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo3.rbLibImp.label')}" labelFor="widg_rbLibImp" errorFor="appDatareeTipo3.flgLibImp" labelId="rbLibImpLbl"
	  fieldRequired="true">


<!-- widget rbLibImp -->

	
<div id="appDatareeTipo3.flgLibImp" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbLibImpSI" name="appDatareeTipo3.flgLibImp"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo3','rbLibImp')"
	cssClass="radio"
	
	/> <label  for="widg_rbLibImpSI1"><s:text name="cpGestReeTipo3.rbLibImp.rbLibImpSI.label" /></label>








<s:radio
	
title=""	
	id="widg_rbLibImpNO" name="appDatareeTipo3.flgLibImp"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo3','rbLibImp')"
	cssClass="radio"
	
	/> <label  for="widg_rbLibImpNO0"><s:text name="cpGestReeTipo3.rbLibImp.rbLibImpNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo3','rbLibUso')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo3.rbLibUso.label')}" labelFor="widg_rbLibUso" errorFor="appDatareeTipo3.flgLibrettoUso" labelId="rbLibUsoLbl"
	  fieldRequired="true">


<!-- widget rbLibUso -->

	
<div id="appDatareeTipo3.flgLibrettoUso" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbLibUsoSI" name="appDatareeTipo3.flgLibrettoUso"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo3','rbLibUso')"
	cssClass="radio"
	
	/> <label  for="widg_rbLibUsoSI1"><s:text name="cpGestReeTipo3.rbLibUso.rbLibUsoSI.label" /></label>








<s:radio
	
title=""	
	id="widg_rbLibUsoNO" name="appDatareeTipo3.flgLibrettoUso"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo3','rbLibUso')"
	cssClass="radio"
	
	/> <label  for="widg_rbLibUsoNO0"><s:text name="cpGestReeTipo3.rbLibUso.rbLibUsoNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo3','rbLibComp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo3.rbLibComp.label')}" labelFor="widg_rbLibComp" errorFor="appDatareeTipo3.flgLibCompl" labelId="rbLibCompLbl"
	  fieldRequired="true">


<!-- widget rbLibComp -->

	
<div id="appDatareeTipo3.flgLibCompl" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbLibCompSI" name="appDatareeTipo3.flgLibCompl"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo3','rbLibComp')"
	cssClass="radio"
	
	/> <label  for="widg_rbLibCompSI1"><s:text name="cpGestReeTipo3.rbLibComp.rbLibCompSI.label" /></label>








<s:radio
	
title=""	
	id="widg_rbLibCompNO" name="appDatareeTipo3.flgLibCompl"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo3','rbLibComp')"
	cssClass="radio"
	
	/> <label  for="widg_rbLibCompNO0"><s:text name="cpGestReeTipo3.rbLibComp.rbLibCompNO.label" /></label>





	
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
	

	
	
<s:if test="isWidgetVisible('cpGestReeTipo3','ptDurezzaH20')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo3.ptDurezzaH20.label')}" labelFor="widg_ptDurezzaH20" errorFor="appDatareeTipo3.durezzaH2OFr" labelId="ptDurezzaH20Lbl"   >


<!-- widget ptDurezzaH20 -->
<s:property value="appDatareeTipo3.durezzaH2OFr" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo3','ptTrattamentoRisc')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo3.ptTrattamentoRisc.label')}" labelFor="widg_ptTrattamentoRisc" errorFor="appDatareeTipo3.descTrattClima" labelId="ptTrattamentoRiscLbl"   >


<!-- widget ptTrattamentoRisc -->
<s:property value="appDatareeTipo3.descTrattClima" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo3','rbTrattClimaNonRic')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo3.rbTrattClimaNonRic.label')}" labelFor="widg_rbTrattClimaNonRic" errorFor="appDatareeTipo3.flgTrattClimaNonRich" labelId="rbTrattClimaNonRicLbl"
	  >


<!-- widget rbTrattClimaNonRic -->

	
<div id="appDatareeTipo3.flgTrattClimaNonRich" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbTrattClimaNonRicSI" name="appDatareeTipo3.flgTrattClimaNonRich"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo3','rbTrattClimaNonRic')"
	cssClass="radio"
	
	/> <label  for="widg_rbTrattClimaNonRicSI1"><s:text name="cpGestReeTipo3.rbTrattClimaNonRic.rbTrattClimaNonRicSI.label" /></label>








<s:radio
	
title=""	
	id="widg_rbTrattClimaNonRicNO" name="appDatareeTipo3.flgTrattClimaNonRich"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo3','rbTrattClimaNonRic')"
	cssClass="radio"
	
	/> <label  for="widg_rbTrattClimaNonRicNO0"><s:text name="cpGestReeTipo3.rbTrattClimaNonRic.rbTrattClimaNonRicNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo3','descTrattAcs')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo3.descTrattAcs.label')}" labelFor="widg_descTrattAcs" errorFor="appDatareeTipo3.descTrattAcs" labelId="descTrattAcsLbl"   >


<!-- widget descTrattAcs -->
<s:property value="appDatareeTipo3.descTrattAcs" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo3','rbTrattAcsNonRic')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo3.rbTrattAcsNonRic.label')}" labelFor="widg_rbTrattAcsNonRic" errorFor="appDatareeTipo3.flgTrattAcsNonRichiesto" labelId="rbTrattAcsNonRicLbl"
	  >


<!-- widget rbTrattAcsNonRic -->

	
<div id="appDatareeTipo3.flgTrattAcsNonRichiesto" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbTrattAcsNonRicSI" name="appDatareeTipo3.flgTrattAcsNonRichiesto"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo3','rbTrattAcsNonRic')"
	cssClass="radio"
	
	/> <label  for="widg_rbTrattAcsNonRicSI1"><s:text name="cpGestReeTipo3.rbTrattAcsNonRic.rbTrattAcsNonRicSI.label" /></label>








<s:radio
	
title=""	
	id="widg_rbTrattAcsNonRicNO" name="appDatareeTipo3.flgTrattAcsNonRichiesto"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo3','rbTrattAcsNonRic')"
	cssClass="radio"
	
	/> <label  for="widg_rbTrattAcsNonRicNO0"><s:text name="cpGestReeTipo3.rbTrattAcsNonRic.rbTrattAcsNonRicNO.label" /></label>





	
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
	

	
	
<s:if test="isWidgetVisible('cpGestReeTipo3','rbLocIntId')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo3.rbLocIntId.label')}" labelFor="widg_rbLocIntId" errorFor="appDatareeTipo3.flgLocaleIntIdoneo" labelId="rbLocIntIdLbl"
	  fieldRequired="true">


<!-- widget rbLocIntId -->

	
<div id="appDatareeTipo3.flgLocaleIntIdoneo" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbLocIntIdSI" name="appDatareeTipo3.flgLocaleIntIdoneo"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo3','rbLocIntId')"
	cssClass="radio"
	
	/> <label  for="widg_rbLocIntIdSI1"><s:text name="cpGestReeTipo3.rbLocIntId.rbLocIntIdSI.label" /></label>








<s:radio
	
title=""	
	id="widg_rbLocIntIdNO" name="appDatareeTipo3.flgLocaleIntIdoneo"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo3','rbLocIntId')"
	cssClass="radio"
	
	/> <label  for="widg_rbLocIntIdNO0"><s:text name="cpGestReeTipo3.rbLocIntId.rbLocIntIdNO.label" /></label>








<s:radio
	
title=""	
	id="widg_rbLocIntIdNC" name="appDatareeTipo3.flgLocaleIntIdoneo"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestReeTipo3','rbLocIntId')"
	cssClass="radio"
	
	/> <label  for="widg_rbLocIntIdNC2"><s:text name="cpGestReeTipo3.rbLocIntId.rbLocIntIdNC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo3','rbLinEletId')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo3.rbLinEletId.label')}" labelFor="widg_rbLinEletId" errorFor="appDatareeTipo3.flgLineaElettIdonea" labelId="rbLinEletIdLbl"
	  fieldRequired="true">


<!-- widget rbLinEletId -->

	
<div id="appDatareeTipo3.flgLineaElettIdonea" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbLinEletIdSI" name="appDatareeTipo3.flgLineaElettIdonea"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo3','rbLinEletId')"
	cssClass="radio"
	
	/> <label  for="widg_rbLinEletIdSI1"><s:text name="cpGestReeTipo3.rbLinEletId.rbLinEletIdSI.label" /></label>








<s:radio
	
title=""	
	id="widg_rbLinEletIdNO" name="appDatareeTipo3.flgLineaElettIdonea"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo3','rbLinEletId')"
	cssClass="radio"
	
	/> <label  for="widg_rbLinEletIdNO0"><s:text name="cpGestReeTipo3.rbLinEletId.rbLinEletIdNO.label" /></label>








<s:radio
	
title=""	
	id="widg_rbLinEletIdNC" name="appDatareeTipo3.flgLineaElettIdonea"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestReeTipo3','rbLinEletId')"
	cssClass="radio"
	
	/> <label  for="widg_rbLinEletIdNC2"><s:text name="cpGestReeTipo3.rbLinEletId.rbLinEletIdNC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo3','rbCoibentId')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo3.rbCoibentId.label')}" labelFor="widg_rbCoibentId" errorFor="appDatareeTipo3.flgCoibentIdonea" labelId="rbCoibentIdLbl"
	  fieldRequired="true">


<!-- widget rbCoibentId -->

	
<div id="appDatareeTipo3.flgCoibentIdonea" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbCoibentIdSI" name="appDatareeTipo3.flgCoibentIdonea"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo3','rbCoibentId')"
	cssClass="radio"
	
	/> <label  for="widg_rbCoibentIdSI1"><s:text name="cpGestReeTipo3.rbCoibentId.rbCoibentIdSI.label" /></label>








<s:radio
	
title=""	
	id="widg_rbCoibentIdNO" name="appDatareeTipo3.flgCoibentIdonea"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo3','rbCoibentId')"
	cssClass="radio"
	
	/> <label  for="widg_rbCoibentIdNO0"><s:text name="cpGestReeTipo3.rbCoibentId.rbCoibentIdNO.label" /></label>








<s:radio
	
title=""	
	id="widg_rbCoibentIdNC" name="appDatareeTipo3.flgCoibentIdonea"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestReeTipo3','rbCoibentId')"
	cssClass="radio"
	
	/> <label  for="widg_rbCoibentIdNC2"><s:text name="cpGestReeTipo3.rbCoibentId.rbCoibentIdNC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo3','rbAssenzaPerditeId')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo3.rbAssenzaPerditeId.label')}" labelFor="widg_rbAssenzaPerditeId" errorFor="appDatareeTipo3.flgAssenzaPerdite" labelId="rbAssenzaPerditeIdLbl"
	  fieldRequired="true">


<!-- widget rbAssenzaPerditeId -->

	
<div id="appDatareeTipo3.flgAssenzaPerdite" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbAssenzaPerditeIdSI" name="appDatareeTipo3.flgAssenzaPerdite"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo3','rbAssenzaPerditeId')"
	cssClass="radio"
	
	/> <label  for="widg_rbAssenzaPerditeIdSI1"><s:text name="cpGestReeTipo3.rbAssenzaPerditeId.rbAssenzaPerditeIdSI.label" /></label>








<s:radio
	
title=""	
	id="widg_rbAssenzaPerditeIdNO" name="appDatareeTipo3.flgAssenzaPerdite"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo3','rbAssenzaPerditeId')"
	cssClass="radio"
	
	/> <label  for="widg_rbAssenzaPerditeIdNO0"><s:text name="cpGestReeTipo3.rbAssenzaPerditeId.rbAssenzaPerditeIdNO.label" /></label>








<s:radio
	
title=""	
	id="widg_rbAssenzaPerditeIdNC" name="appDatareeTipo3.flgAssenzaPerdite"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestReeTipo3','rbAssenzaPerditeId')"
	cssClass="radio"
	
	/> <label  for="widg_rbAssenzaPerditeIdNC2"><s:text name="cpGestReeTipo3.rbAssenzaPerditeId.rbAssenzaPerditeIdNC.label" /></label>





	
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
	

	
	
<s:if test="isWidgetVisible('cpGestReeTipo3','ptPossEventi')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo3.ptPossEventi.label')}" labelFor="widg_ptPossEventi" errorFor="widg_ptPossEventi" labelId="ptPossEventiLbl"   >


<!-- widget ptPossEventi -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo3','cbAdValvTer')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo3.cbAdValvTer.label')}" labelFor="widg_cbAdValvTer" errorFor="appDatareeTipo3.flgAdozioneValvoleTerm" labelId="cbAdValvTerLbl"
	  >


<!-- widget cbAdValvTer -->
<s:checkbox 
	
	
	name="appDatareeTipo3.flgAdozioneValvoleTerm" id="widg_cbAdValvTer"
	disabled="isWidgetDisabled('cpGestReeTipo3','cbAdValvTer')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestReeTipo3','cbAdValvTer')" >
	<s:hidden name="__checkbox_appDatareeTipo3.flgAdozioneValvoleTerm" id="__checkbox_widg_cbAdValvTer" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo3','cbVerificaPar')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo3.cbVerificaPar.label')}" labelFor="widg_cbVerificaPar" errorFor="appDatareeTipo3.flgVerificaParam" labelId="cbVerificaParLbl"
	  >


<!-- widget cbVerificaPar -->
<s:checkbox 
	
	
	name="appDatareeTipo3.flgVerificaParam" id="widg_cbVerificaPar"
	disabled="isWidgetDisabled('cpGestReeTipo3','cbVerificaPar')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestReeTipo3','cbVerificaPar')" >
	<s:hidden name="__checkbox_appDatareeTipo3.flgVerificaParam" id="__checkbox_widg_cbVerificaPar" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo3','cbVerificaPerdite')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo3.cbVerificaPerdite.label')}" labelFor="widg_cbVerificaPerdite" errorFor="appDatareeTipo3.flgPerditeH2O" labelId="cbVerificaPerditeLbl"
	  >


<!-- widget cbVerificaPerdite -->
<s:checkbox 
	
	
	name="appDatareeTipo3.flgPerditeH2O" id="widg_cbVerificaPerdite"
	disabled="isWidgetDisabled('cpGestReeTipo3','cbVerificaPerdite')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestReeTipo3','cbVerificaPerdite')" >
	<s:hidden name="__checkbox_appDatareeTipo3.flgPerditeH2O" id="__checkbox_widg_cbVerificaPerdite" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo3','cbInstallInvolucro')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo3.cbInstallInvolucro.label')}" labelFor="widg_cbInstallInvolucro" errorFor="appDatareeTipo3.flgInstallInvolucro" labelId="cbInstallInvolucroLbl"
	  >


<!-- widget cbInstallInvolucro -->
<s:checkbox 
	
	
	name="appDatareeTipo3.flgInstallInvolucro" id="widg_cbInstallInvolucro"
	disabled="isWidgetDisabled('cpGestReeTipo3','cbInstallInvolucro')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestReeTipo3','cbInstallInvolucro')" >
	<s:hidden name="__checkbox_appDatareeTipo3.flgInstallInvolucro" id="__checkbox_widg_cbInstallInvolucro" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo3','taOss')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo3.taOss.label')}" labelFor="widg_taOss" errorFor="appDatareeTipo3.osservazioni" labelId="taOssLbl"
	  >


<!-- widget taOss -->
<s:textarea 
	
	
	name="appDatareeTipo3.osservazioni" id="widg_taOss"
	disabled="isWidgetDisabled('cpGestReeTipo3','taOss')"
	rows="3"
	cols="25"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo3','taRacc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo3.taRacc.label')}" labelFor="widg_taRacc" errorFor="appDatareeTipo3.raccomandazioni" labelId="taRaccLbl"
	  >


<!-- widget taRacc -->
<s:textarea 
	
	
	name="appDatareeTipo3.raccomandazioni" id="widg_taRacc"
	disabled="isWidgetDisabled('cpGestReeTipo3','taRacc')"
	rows="3"
	cols="25"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo3','taPre')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo3.taPre.label')}" labelFor="widg_taPre" errorFor="appDatareeTipo3.prescrizioni" labelId="taPreLbl"
	  >


<!-- widget taPre -->
<s:textarea 
	
	
	name="appDatareeTipo3.prescrizioni" id="widg_taPre"
	disabled="isWidgetDisabled('cpGestReeTipo3','taPre')"
	rows="3"
	cols="25"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo3','rbFunz')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo3.rbFunz.label')}" labelFor="widg_rbFunz" errorFor="appDatareeTipo3.flgPuoFunzionare" labelId="rbFunzLbl"
	  fieldRequired="true">


<!-- widget rbFunz -->

	
<div id="appDatareeTipo3.flgPuoFunzionare" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbFunzSI" name="appDatareeTipo3.flgPuoFunzionare"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo3','rbFunz')"
	cssClass="radio"
	
	/> <label  for="widg_rbFunzSI1"><s:text name="cpGestReeTipo3.rbFunz.rbFunzSI.label" /></label>








<s:radio
	
title=""	
	id="widg_rbFunzNO" name="appDatareeTipo3.flgPuoFunzionare"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo3','rbFunz')"
	cssClass="radio"
	
	/> <label  for="widg_rbFunzNO0"><s:text name="cpGestReeTipo3.rbFunz.rbFunzNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo3','cIntEntro')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo3.cIntEntro.label')}" labelFor="widg_cIntEntro" errorFor="appDatareeTipo3.interventoEntro" labelId="cIntEntroLbl"
	  >


<!-- widget cIntEntro -->
<s:textfield 
	
	
	name="appDatareeTipo3.interventoEntro" id="widg_cIntEntro"
	disabled="isWidgetDisabled('cpGestReeTipo3','cIntEntro')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo3','tfOraArrivo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo3.tfOraArrivo.label')}" labelFor="widg_tfOraArrivo" errorFor="appDatareeTipo3.oraArrivo" labelId="tfOraArrivoLbl"
	  >


<!-- widget tfOraArrivo -->
<s:textfield 
	
	
	name="appDatareeTipo3.oraArrivo" id="widg_tfOraArrivo"
maxlength="10"	disabled="isWidgetDisabled('cpGestReeTipo3','tfOraArrivo')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo3','tfOraPart')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo3.tfOraPart.label')}" labelFor="widg_tfOraPart" errorFor="appDatareeTipo3.oraPartenza" labelId="tfOraPartLbl"
	  >


<!-- widget tfOraPart -->
<s:textfield 
	
	
	name="appDatareeTipo3.oraPartenza" id="widg_tfOraPart"
maxlength="10"	disabled="isWidgetDisabled('cpGestReeTipo3','tfOraPart')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo3','tfTec')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo3.tfTec.label')}" labelFor="widg_tfTec" errorFor="appDatareeTipo3.denominazTecnico" labelId="tfTecLbl"
	  fieldRequired="true">


<!-- widget tfTec -->
<s:textfield 
	
	
	name="appDatareeTipo3.denominazTecnico" id="widg_tfTec"
maxlength="100"	disabled="isWidgetDisabled('cpGestReeTipo3','tfTec')"
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
		
<s:if test="isWidgetVisible('cpGestReeTipo3','bSalvaRee')" >

	



<!-- widget bSalvaRee -->
<s:submit name="widg_bSalvaRee" id="widg_bSalvaRee" method="handleBSalvaRee_CLICKED"
	key="cpGestReeTipo3.bSalvaRee.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestReeTipo3','bSalvaRee')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunGestRee --></div>

			
	
	<div id="p_cpNavGestRee" class="commandPanelBlock"><!-- startFragment:p_cpNavGestRee -->
	
	
<div class="commandPanel navigation" id="cpNavGestRee">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestReeTipo3','btnIndietro')" >

	



<!-- widget btnIndietro -->
<s:submit name="widg_btnIndietro" id="widg_btnIndietro" method="handleBtnIndietro_CLICKED"
	key="cpGestReeTipo3.btnIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestReeTipo3','btnIndietro')" />

	


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
