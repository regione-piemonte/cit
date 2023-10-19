<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_ree_tipo1/CpGestReeTipo1Action" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_ree_tipo1 -->
<!-- pageId:cpGestReeTipo1 -->

<s:form id="cpGestReeTipo1" action="cpGestReeTipo1" namespace="/base/gestisci_ree_tipo1" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestReeTipo1_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpGestReeTipo1','menu')" >

	


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

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestReeTipo1_udpFunzionalita.jsp"></s:include>

	



			
	
	<div id="p_wpMenuTree" class="widgetsPanelBlock"><!-- startFragment:p_wpMenuTree -->
	
	

<div class="widgetsPanel" id="wpMenuTree">
	
	<customtag:widgetsPanel id="wpMenuTreeTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestReeTipo1','menuRee')" >

	
<customtag:widgetsPanelColumn 
	 colSpan="2" >



	<csiuicore:ajaxify id="p_wpMenuTree" 
		widgetType="tree" 
		pageId="cpGestReeTipo1"
		javascriptDetection="false">
	<customtag:tree
		name="appDatareeMenuTree"
		cssUlClass="tree"
        cssRootClass="treeRoot" cssFolderOpenClass="treeFolderOpen"
        cssFolderClosedClass="treeFolderClosed" cssDotClass="treeDot"
		linkOnTree="true" id="menuRee"
		selectionMultiplicity="none"
		requestURI="/sigitwebn/base/gestisci_ree_tipo1/cpGestReeTipo1!handleMenuRee_CLICKED.do"
		nameSpace="/base/gestisci_ree_tipo1"
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

	
	

	
	
			
	
	
	<div id="p_mpReeTipo1Title" class="panelBlock"><!-- startFragment:p_mpReeTipo1Title -->
		

		
<s:if test="#session.cpGestReeTipo1_mpReeTipo1Title_selectedMultiPanel == 'cpGestReeTipo1_mpReeTipo1Title_fpGestReeTitleTipo1'">
	<s:include value="/jsp/multipanels/cpGestReeTipo1_mpReeTipo1Title_fpGestReeTitleTipo1.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpReeTipo1Title --></div>

			
	
	
	<div id="p_mpReeTipo1BTitle" class="panelBlock"><!-- startFragment:p_mpReeTipo1BTitle -->
		

		
<s:if test="#session.cpGestReeTipo1_mpReeTipo1BTitle_selectedMultiPanel == 'cpGestReeTipo1_mpReeTipo1BTitle_fpGestReeTitleTipo1B'">
	<s:include value="/jsp/multipanels/cpGestReeTipo1_mpReeTipo1BTitle_fpGestReeTitleTipo1B.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpReeTipo1BTitle --></div>

			
	
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
	

	
	
<s:if test="isWidgetVisible('cpGestReeTipo1','ptCodiceImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo1.ptCodiceImpianto.label')}" labelFor="widg_ptCodiceImpianto" errorFor="appDataidentificativoImpianto.codiceImpianto" labelId="ptCodiceImpiantoLbl"  position="first" >


<!-- widget ptCodiceImpianto -->
<s:property value="appDataidentificativoImpianto.codiceImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestReeTipo1','ptUbicazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo1.ptUbicazione.label')}" labelFor="widg_ptUbicazione" errorFor="appDataidentificativoImpianto.ubicazione" labelId="ptUbicazioneLbl"  position="last" >


<!-- widget ptUbicazione -->
<s:property value="appDataidentificativoImpianto.ubicazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestReeTipo1','ptResponsabile')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo1.ptResponsabile.label')}" labelFor="widg_ptResponsabile" errorFor="appDataidentificativoImpianto.responsabile" labelId="ptResponsabileLbl"  position="first" >


<!-- widget ptResponsabile -->
<s:property value="appDataidentificativoImpianto.responsabile" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestReeTipo1','wpInfoImpianto_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpInfoImpianto_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestReeTipo1','ptDataControllo')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo1.ptDataControllo.label')}" labelFor="widg_ptDataControllo" errorFor="appDataallegato.dataControllo" labelId="ptDataControlloLbl"  position="first" >


<!-- widget ptDataControllo -->
<s:property value="appDataallegato.dataControllo" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestReeTipo1','ptBollino')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo1.ptBollino.label')}" labelFor="widg_ptBollino" errorFor="appDataallegato.codiceBollino" labelId="ptBollinoLbl"  position="last" >


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
	

	
	
<s:if test="isWidgetVisible('cpGestReeTipo1','tfPotenzaTermicaNomMax')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1.tfPotenzaTermicaNomMax.label')}" labelFor="widg_tfPotenzaTermicaNomMax" errorFor="appDatareeTipo1.potenzaTermicaNomMax" labelId="tfPotenzaTermicaNomMaxLbl"
	  >


<!-- widget tfPotenzaTermicaNomMax -->
<s:textfield 
	
	
	name="appDatareeTipo1.potenzaTermicaNomMax" id="widg_tfPotenzaTermicaNomMax"
maxlength="9"	disabled="isWidgetDisabled('cpGestReeTipo1','tfPotenzaTermicaNomMax')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1','ptResponsabileImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo1.ptResponsabileImpianto.label')}" labelFor="widg_ptResponsabileImpianto" errorFor="appDatareeTipo1.responsabileImpianto" labelId="ptResponsabileImpiantoLbl"   >


<!-- widget ptResponsabileImpianto -->
<s:property value="appDatareeTipo1.responsabileImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1','ptImpresaManutInstal')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo1.ptImpresaManutInstal.label')}" labelFor="widg_ptImpresaManutInstal" errorFor="appDatareeTipo1.impresaManutInstal" labelId="ptImpresaManutInstalLbl"   >


<!-- widget ptImpresaManutInstal -->
<s:property value="appDatareeTipo1.impresaManutInstal" escape="false" />

	
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
	

	
	
<s:if test="isWidgetVisible('cpGestReeTipo1','rbDicConf')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1.rbDicConf.label')}" labelFor="widg_rbDicConf" errorFor="appDatareeTipo1.flgDichiarConform" labelId="rbDicConfLbl"
	  >


<!-- widget rbDicConf -->

	
<div id="appDatareeTipo1.flgDichiarConform" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbDicConfSI" name="appDatareeTipo1.flgDichiarConform"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo1','rbDicConf')"
	cssClass="radio"
	
	/> <label  for="widg_rbDicConfSI1"><s:text name="cpGestReeTipo1.rbDicConf.rbDicConfSI.label" /></label>








<s:radio
	
	
	id="widg_rbDicConfNO" name="appDatareeTipo1.flgDichiarConform"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo1','rbDicConf')"
	cssClass="radio"
	
	/> <label  for="widg_rbDicConfNO0"><s:text name="cpGestReeTipo1.rbDicConf.rbDicConfNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1','rbLibImp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1.rbLibImp.label')}" labelFor="widg_rbLibImp" errorFor="appDatareeTipo1.flgLibImp" labelId="rbLibImpLbl"
	  >


<!-- widget rbLibImp -->

	
<div id="appDatareeTipo1.flgLibImp" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbLibImpSI" name="appDatareeTipo1.flgLibImp"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo1','rbLibImp')"
	cssClass="radio"
	
	/> <label  for="widg_rbLibImpSI1"><s:text name="cpGestReeTipo1.rbLibImp.rbLibImpSI.label" /></label>








<s:radio
	
	
	id="widg_rbLibImpNO" name="appDatareeTipo1.flgLibImp"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo1','rbLibImp')"
	cssClass="radio"
	
	/> <label  for="widg_rbLibImpNO0"><s:text name="cpGestReeTipo1.rbLibImp.rbLibImpNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1','rbLibUso')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1.rbLibUso.label')}" labelFor="widg_rbLibUso" errorFor="appDatareeTipo1.flgLibrettoUso" labelId="rbLibUsoLbl"
	  >


<!-- widget rbLibUso -->

	
<div id="appDatareeTipo1.flgLibrettoUso" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbLibUsoSI" name="appDatareeTipo1.flgLibrettoUso"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo1','rbLibUso')"
	cssClass="radio"
	
	/> <label  for="widg_rbLibUsoSI1"><s:text name="cpGestReeTipo1.rbLibUso.rbLibUsoSI.label" /></label>








<s:radio
	
	
	id="widg_rbLibUsoNO" name="appDatareeTipo1.flgLibrettoUso"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo1','rbLibUso')"
	cssClass="radio"
	
	/> <label  for="widg_rbLibUsoNO0"><s:text name="cpGestReeTipo1.rbLibUso.rbLibUsoNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1','rbLibComp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1.rbLibComp.label')}" labelFor="widg_rbLibComp" errorFor="appDatareeTipo1.flgLibCompl" labelId="rbLibCompLbl"
	  >


<!-- widget rbLibComp -->

	
<div id="appDatareeTipo1.flgLibCompl" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbLibCompSI" name="appDatareeTipo1.flgLibCompl"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo1','rbLibComp')"
	cssClass="radio"
	
	/> <label  for="widg_rbLibCompSI1"><s:text name="cpGestReeTipo1.rbLibComp.rbLibCompSI.label" /></label>








<s:radio
	
	
	id="widg_rbLibCompNO" name="appDatareeTipo1.flgLibCompl"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo1','rbLibComp')"
	cssClass="radio"
	
	/> <label  for="widg_rbLibCompNO0"><s:text name="cpGestReeTipo1.rbLibComp.rbLibCompNO.label" /></label>





	
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
	

	
	
<s:if test="isWidgetVisible('cpGestReeTipo1','ptDurezzaH20')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo1.ptDurezzaH20.label')}" labelFor="widg_ptDurezzaH20" errorFor="appDatareeTipo1.durezzaH2OFr" labelId="ptDurezzaH20Lbl"   >


<!-- widget ptDurezzaH20 -->
<s:property value="appDatareeTipo1.durezzaH2OFr" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1','ptTrattClima')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo1.ptTrattClima.label')}" labelFor="widg_ptTrattClima" errorFor="appDatareeTipo1.descTrattClima" labelId="ptTrattClimaLbl"   >


<!-- widget ptTrattClima -->
<s:property value="appDatareeTipo1.descTrattClima" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1','rbTrattClimaNonRic')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1.rbTrattClimaNonRic.label')}" labelFor="widg_rbTrattClimaNonRic" errorFor="appDatareeTipo1.flgTrattClimaNonRich" labelId="rbTrattClimaNonRicLbl"
	  >


<!-- widget rbTrattClimaNonRic -->

	
<div id="appDatareeTipo1.flgTrattClimaNonRich" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbTrattClimaNonRicSI" name="appDatareeTipo1.flgTrattClimaNonRich"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo1','rbTrattClimaNonRic')"
	cssClass="radio"
	
	/> <label  for="widg_rbTrattClimaNonRicSI1"><s:text name="cpGestReeTipo1.rbTrattClimaNonRic.rbTrattClimaNonRicSI.label" /></label>








<s:radio
	
	
	id="widg_rbTrattClimaNonRicNO" name="appDatareeTipo1.flgTrattClimaNonRich"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo1','rbTrattClimaNonRic')"
	cssClass="radio"
	
	/> <label  for="widg_rbTrattClimaNonRicNO0"><s:text name="cpGestReeTipo1.rbTrattClimaNonRic.rbTrattClimaNonRicNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1','ptTrattAcs')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo1.ptTrattAcs.label')}" labelFor="widg_ptTrattAcs" errorFor="appDatareeTipo1.descTrattAcs" labelId="ptTrattAcsLbl"   >


<!-- widget ptTrattAcs -->
<s:property value="appDatareeTipo1.descTrattAcs" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1','rbTrattAcsNonRic')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1.rbTrattAcsNonRic.label')}" labelFor="widg_rbTrattAcsNonRic" errorFor="appDatareeTipo1.flgTrattAcsNonRichiesto" labelId="rbTrattAcsNonRicLbl"
	  >


<!-- widget rbTrattAcsNonRic -->

	
<div id="appDatareeTipo1.flgTrattAcsNonRichiesto" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbTrattAcsNonRicSI" name="appDatareeTipo1.flgTrattAcsNonRichiesto"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo1','rbTrattAcsNonRic')"
	cssClass="radio"
	
	/> <label  for="widg_rbTrattAcsNonRicSI1"><s:text name="cpGestReeTipo1.rbTrattAcsNonRic.rbTrattAcsNonRicSI.label" /></label>








<s:radio
	
	
	id="widg_rbTrattAcsNonRicNO" name="appDatareeTipo1.flgTrattAcsNonRichiesto"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo1','rbTrattAcsNonRic')"
	cssClass="radio"
	
	/> <label  for="widg_rbTrattAcsNonRicNO0"><s:text name="cpGestReeTipo1.rbTrattAcsNonRic.rbTrattAcsNonRicNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpC --></div>

			
	
	
	<div id="p_mpAcquaReintegro" class="panelBlock"><!-- startFragment:p_mpAcquaReintegro -->
		

		
<s:if test="#session.cpGestReeTipo1_mpAcquaReintegro_selectedMultiPanel == 'cpGestReeTipo1_mpAcquaReintegro_fpAcquaReintegro'">
	<s:include value="/jsp/multipanels/cpGestReeTipo1_mpAcquaReintegro_fpAcquaReintegro.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpAcquaReintegro --></div>

			
	
	<div id="p_wpD" class="widgetsPanelBlock"><!-- startFragment:p_wpD -->
	
	
<h4 class="wpLabel">D. controllo dell&apos;impianto </h4>
<div class="widgetsPanel" id="wpD">
	
	<customtag:widgetsPanel id="wpDTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestReeTipo1','rbLocIntId')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1.rbLocIntId.label')}" labelFor="widg_rbLocIntId" errorFor="appDatareeTipo1.flgLocaleIntIdoneo" labelId="rbLocIntIdLbl"
	  >


<!-- widget rbLocIntId -->

	
<div id="appDatareeTipo1.flgLocaleIntIdoneo" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbLocIntIdSI" name="appDatareeTipo1.flgLocaleIntIdoneo"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo1','rbLocIntId')"
	cssClass="radio"
	
	/> <label  for="widg_rbLocIntIdSI1"><s:text name="cpGestReeTipo1.rbLocIntId.rbLocIntIdSI.label" /></label>








<s:radio
	
	
	id="widg_rbLocIntIdNO" name="appDatareeTipo1.flgLocaleIntIdoneo"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo1','rbLocIntId')"
	cssClass="radio"
	
	/> <label  for="widg_rbLocIntIdNO0"><s:text name="cpGestReeTipo1.rbLocIntId.rbLocIntIdNO.label" /></label>








<s:radio
	
	
	id="widg_rbLocIntIdNC" name="appDatareeTipo1.flgLocaleIntIdoneo"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestReeTipo1','rbLocIntId')"
	cssClass="radio"
	
	/> <label  for="widg_rbLocIntIdNC2"><s:text name="cpGestReeTipo1.rbLocIntId.rbLocIntIdNC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1','rbGenExtId')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1.rbGenExtId.label')}" labelFor="widg_rbGenExtId" errorFor="appDatareeTipo1.flgGenExtIdoneo" labelId="rbGenExtIdLbl"
	  >


<!-- widget rbGenExtId -->

	
<div id="appDatareeTipo1.flgGenExtIdoneo" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbGenExtIdSI" name="appDatareeTipo1.flgGenExtIdoneo"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo1','rbGenExtId')"
	cssClass="radio"
	
	/> <label  for="widg_rbGenExtIdSI1"><s:text name="cpGestReeTipo1.rbGenExtId.rbGenExtIdSI.label" /></label>








<s:radio
	
	
	id="widg_rbGenExtIdNO" name="appDatareeTipo1.flgGenExtIdoneo"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo1','rbGenExtId')"
	cssClass="radio"
	
	/> <label  for="widg_rbGenExtIdNO0"><s:text name="cpGestReeTipo1.rbGenExtId.rbGenExtIdNO.label" /></label>








<s:radio
	
	
	id="widg_rbGenExtIdNC" name="appDatareeTipo1.flgGenExtIdoneo"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestReeTipo1','rbGenExtId')"
	cssClass="radio"
	
	/> <label  for="widg_rbGenExtIdNC2"><s:text name="cpGestReeTipo1.rbGenExtId.rbGenExtIdNC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1','rbApertLibere')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1.rbApertLibere.label')}" labelFor="widg_rbApertLibere" errorFor="appDatareeTipo1.flgApertureLibere" labelId="rbApertLibereLbl"
	  >


<!-- widget rbApertLibere -->

	
<div id="appDatareeTipo1.flgApertureLibere" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbApertLibereSI" name="appDatareeTipo1.flgApertureLibere"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo1','rbApertLibere')"
	cssClass="radio"
	
	/> <label  for="widg_rbApertLibereSI1"><s:text name="cpGestReeTipo1.rbApertLibere.rbApertLibereSI.label" /></label>








<s:radio
	
	
	id="widg_rbApertLibereNO" name="appDatareeTipo1.flgApertureLibere"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo1','rbApertLibere')"
	cssClass="radio"
	
	/> <label  for="widg_rbApertLibereNO0"><s:text name="cpGestReeTipo1.rbApertLibere.rbApertLibereNO.label" /></label>








<s:radio
	
	
	id="widg_rbApertLibereNC" name="appDatareeTipo1.flgApertureLibere"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestReeTipo1','rbApertLibere')"
	cssClass="radio"
	
	/> <label  for="widg_rbApertLibereNC2"><s:text name="cpGestReeTipo1.rbApertLibere.rbApertLibereNC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1','rbApertAde')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1.rbApertAde.label')}" labelFor="widg_rbApertAde" errorFor="appDatareeTipo1.flgApertureAdeguate" labelId="rbApertAdeLbl"
	  >


<!-- widget rbApertAde -->

	
<div id="appDatareeTipo1.flgApertureAdeguate" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbApertAdeSI" name="appDatareeTipo1.flgApertureAdeguate"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo1','rbApertAde')"
	cssClass="radio"
	
	/> <label  for="widg_rbApertAdeSI1"><s:text name="cpGestReeTipo1.rbApertAde.rbApertAdeSI.label" /></label>








<s:radio
	
	
	id="widg_rbApertAdeNO" name="appDatareeTipo1.flgApertureAdeguate"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo1','rbApertAde')"
	cssClass="radio"
	
	/> <label  for="widg_rbApertAdeNO0"><s:text name="cpGestReeTipo1.rbApertAde.rbApertAdeNO.label" /></label>








<s:radio
	
	
	id="widg_rbApertAdeNC" name="appDatareeTipo1.flgApertureAdeguate"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestReeTipo1','rbApertAde')"
	cssClass="radio"
	
	/> <label  for="widg_rbApertAdeNC2"><s:text name="cpGestReeTipo1.rbApertAde.rbApertAdeNC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1','rbScaricoId')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1.rbScaricoId.label')}" labelFor="widg_rbScaricoId" errorFor="appDatareeTipo1.flgScaricoIdoneo" labelId="rbScaricoIdLbl"
	  >


<!-- widget rbScaricoId -->

	
<div id="appDatareeTipo1.flgScaricoIdoneo" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbScaricoIdSI" name="appDatareeTipo1.flgScaricoIdoneo"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo1','rbScaricoId')"
	cssClass="radio"
	
	/> <label  for="widg_rbScaricoIdSI1"><s:text name="cpGestReeTipo1.rbScaricoId.rbScaricoIdSI.label" /></label>








<s:radio
	
	
	id="widg_rbScaricoIdNO" name="appDatareeTipo1.flgScaricoIdoneo"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo1','rbScaricoId')"
	cssClass="radio"
	
	/> <label  for="widg_rbScaricoIdNO0"><s:text name="cpGestReeTipo1.rbScaricoId.rbScaricoIdNO.label" /></label>








<s:radio
	
	
	id="widg_rbScaricoIdNC" name="appDatareeTipo1.flgScaricoIdoneo"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestReeTipo1','rbScaricoId')"
	cssClass="radio"
	
	/> <label  for="widg_rbScaricoIdNC2"><s:text name="cpGestReeTipo1.rbScaricoId.rbScaricoIdNC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1','rbTempAmbFunz')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1.rbTempAmbFunz.label')}" labelFor="widg_rbTempAmbFunz" errorFor="appDatareeTipo1.flgTempAmbFunz" labelId="rbTempAmbFunzLbl"
	  >


<!-- widget rbTempAmbFunz -->

	
<div id="appDatareeTipo1.flgTempAmbFunz" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbTempAmbFunzSI" name="appDatareeTipo1.flgTempAmbFunz"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo1','rbTempAmbFunz')"
	cssClass="radio"
	
	/> <label  for="widg_rbTempAmbFunzSI1"><s:text name="cpGestReeTipo1.rbTempAmbFunz.rbTempAmbFunzSI.label" /></label>








<s:radio
	
	
	id="widg_rbTempAmbFunzNO" name="appDatareeTipo1.flgTempAmbFunz"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo1','rbTempAmbFunz')"
	cssClass="radio"
	
	/> <label  for="widg_rbTempAmbFunzNO0"><s:text name="cpGestReeTipo1.rbTempAmbFunz.rbTempAmbFunzNO.label" /></label>








<s:radio
	
	
	id="widg_rbTempAmbFunzNC" name="appDatareeTipo1.flgTempAmbFunz"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestReeTipo1','rbTempAmbFunz')"
	cssClass="radio"
	
	/> <label  for="widg_rbTempAmbFunzNC2"><s:text name="cpGestReeTipo1.rbTempAmbFunz.rbTempAmbFunzNC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1','rbAssPerdComb')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1.rbAssPerdComb.label')}" labelFor="widg_rbAssPerdComb" errorFor="appDatareeTipo1.flgAssenzaPerdComb" labelId="rbAssPerdCombLbl"
	  >


<!-- widget rbAssPerdComb -->

	
<div id="appDatareeTipo1.flgAssenzaPerdComb" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbAssPerdCombSI" name="appDatareeTipo1.flgAssenzaPerdComb"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo1','rbAssPerdComb')"
	cssClass="radio"
	
	/> <label  for="widg_rbAssPerdCombSI1"><s:text name="cpGestReeTipo1.rbAssPerdComb.rbAssPerdCombSI.label" /></label>








<s:radio
	
	
	id="widg_rbAssPerdCombNO" name="appDatareeTipo1.flgAssenzaPerdComb"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo1','rbAssPerdComb')"
	cssClass="radio"
	
	/> <label  for="widg_rbAssPerdCombNO0"><s:text name="cpGestReeTipo1.rbAssPerdComb.rbAssPerdCombNO.label" /></label>








<s:radio
	
	
	id="widg_rbAssPerdCombNC" name="appDatareeTipo1.flgAssenzaPerdComb"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestReeTipo1','rbAssPerdComb')"
	cssClass="radio"
	
	/> <label  for="widg_rbAssPerdCombNC2"><s:text name="cpGestReeTipo1.rbAssPerdComb.rbAssPerdCombNC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1','rbIdoTenImpInt')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1.rbIdoTenImpInt.label')}" labelFor="widg_rbIdoTenImpInt" errorFor="appDatareeTipo1.flgIdoTenImpInt" labelId="rbIdoTenImpIntLbl"
	  >


<!-- widget rbIdoTenImpInt -->

	
<div id="appDatareeTipo1.flgIdoTenImpInt" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbIdoTenImpIntSI" name="appDatareeTipo1.flgIdoTenImpInt"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo1','rbIdoTenImpInt')"
	cssClass="radio"
	
	/> <label  for="widg_rbIdoTenImpIntSI1"><s:text name="cpGestReeTipo1.rbIdoTenImpInt.rbIdoTenImpIntSI.label" /></label>








<s:radio
	
title=""	
	id="widg_rbIdoTenImpIntNO" name="appDatareeTipo1.flgIdoTenImpInt"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo1','rbIdoTenImpInt')"
	cssClass="radio"
	
	/> <label  for="widg_rbIdoTenImpIntNO0"><s:text name="cpGestReeTipo1.rbIdoTenImpInt.rbIdoTenImpIntNO.label" /></label>








<s:radio
	
	
	id="widg_rbIdoTenImpIntNC" name="appDatareeTipo1.flgIdoTenImpInt"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestReeTipo1','rbIdoTenImpInt')"
	cssClass="radio"
	
	/> <label  for="widg_rbIdoTenImpIntNC2"><s:text name="cpGestReeTipo1.rbIdoTenImpInt.rbIdoTenImpIntNC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1','rbIdoTenImpIntTipo1B')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1.rbIdoTenImpIntTipo1B.label')}" labelFor="widg_rbIdoTenImpIntTipo1B" errorFor="appDatareeTipo1.flgIdoTenImpInt" labelId="rbIdoTenImpIntTipo1BLbl"
	  >


<!-- widget rbIdoTenImpIntTipo1B -->

	
<div id="appDatareeTipo1.flgIdoTenImpInt" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbIdoTenImpIntSI" name="appDatareeTipo1.flgIdoTenImpInt"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo1','rbIdoTenImpIntTipo1B')"
	cssClass="radio"
	
	/> <label  for="widg_rbIdoTenImpIntSI1"><s:text name="cpGestReeTipo1.rbIdoTenImpIntTipo1B.rbIdoTenImpIntSI.label" /></label>








<s:radio
	
title=""	
	id="widg_rbIdoTenImpIntNO" name="appDatareeTipo1.flgIdoTenImpInt"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo1','rbIdoTenImpIntTipo1B')"
	cssClass="radio"
	
	/> <label  for="widg_rbIdoTenImpIntNO0"><s:text name="cpGestReeTipo1.rbIdoTenImpIntTipo1B.rbIdoTenImpIntNO.label" /></label>








<s:radio
	
	
	id="widg_rbIdoTenImpIntNC" name="appDatareeTipo1.flgIdoTenImpInt"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestReeTipo1','rbIdoTenImpIntTipo1B')"
	cssClass="radio"
	
	/> <label  for="widg_rbIdoTenImpIntNC2"><s:text name="cpGestReeTipo1.rbIdoTenImpIntTipo1B.rbIdoTenImpIntNC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1','rbPuliziaCamino')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1.rbPuliziaCamino.label')}" labelFor="widg_rbPuliziaCamino" errorFor="appDatareeTipo1.flgPuliziaCamino" labelId="rbPuliziaCaminoLbl"
	  >


<!-- widget rbPuliziaCamino -->

	
<div id="appDatareeTipo1.flgPuliziaCamino" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbPuliziaCaminoSI" name="appDatareeTipo1.flgPuliziaCamino"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo1','rbPuliziaCamino')"
	cssClass="radio"
	
	/> <label  for="widg_rbPuliziaCaminoSI1"><s:text name="cpGestReeTipo1.rbPuliziaCamino.rbPuliziaCaminoSI.label" /></label>








<s:radio
	
	
	id="widg_rbPuliziaCaminoNO" name="appDatareeTipo1.flgPuliziaCamino"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo1','rbPuliziaCamino')"
	cssClass="radio"
	
	/> <label  for="widg_rbPuliziaCaminoNO0"><s:text name="cpGestReeTipo1.rbPuliziaCamino.rbPuliziaCaminoNO.label" /></label>








<s:radio
	
	
	id="widg_rbPuliziaCaminoNC" name="appDatareeTipo1.flgPuliziaCamino"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestReeTipo1','rbPuliziaCamino')"
	cssClass="radio"
	
	/> <label  for="widg_rbPuliziaCaminoNC2"><s:text name="cpGestReeTipo1.rbPuliziaCamino.rbPuliziaCaminoNC.label" /></label>





	
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
	

	
	
<s:if test="isWidgetVisible('cpGestReeTipo1','ptPossEventi')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo1.ptPossEventi.label')}" labelFor="widg_ptPossEventi" errorFor="widg_ptPossEventi" labelId="ptPossEventiLbl"   >


<!-- widget ptPossEventi -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1','cbAdValvTer')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1.cbAdValvTer.label')}" labelFor="widg_cbAdValvTer" errorFor="appDatareeTipo1.flgAdozioneValvoleTerm" labelId="cbAdValvTerLbl"
	  >


<!-- widget cbAdValvTer -->
<s:checkbox 
	
	
	name="appDatareeTipo1.flgAdozioneValvoleTerm" id="widg_cbAdValvTer"
	disabled="isWidgetDisabled('cpGestReeTipo1','cbAdValvTer')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestReeTipo1','cbAdValvTer')" >
	<s:hidden name="__checkbox_appDatareeTipo1.flgAdozioneValvoleTerm" id="__checkbox_widg_cbAdValvTer" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1','cbIsRete')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1.cbIsRete.label')}" labelFor="widg_cbIsRete" errorFor="appDatareeTipo1.flgIsolamentoRete" labelId="cbIsReteLbl"
	  >


<!-- widget cbIsRete -->
<s:checkbox 
	
	
	name="appDatareeTipo1.flgIsolamentoRete" id="widg_cbIsRete"
	disabled="isWidgetDisabled('cpGestReeTipo1','cbIsRete')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestReeTipo1','cbIsRete')" >
	<s:hidden name="__checkbox_appDatareeTipo1.flgIsolamentoRete" id="__checkbox_widg_cbIsRete" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1','cbAdozSistTratt')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1.cbAdozSistTratt.label')}" labelFor="widg_cbAdozSistTratt" errorFor="appDatareeTipo1.flgAdozSistTrattamH2O" labelId="cbAdozSistTrattLbl"
	  >


<!-- widget cbAdozSistTratt -->
<s:checkbox 
	
	
	name="appDatareeTipo1.flgAdozSistTrattamH2O" id="widg_cbAdozSistTratt"
	disabled="isWidgetDisabled('cpGestReeTipo1','cbAdozSistTratt')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestReeTipo1','cbAdozSistTratt')" >
	<s:hidden name="__checkbox_appDatareeTipo1.flgAdozSistTrattamH2O" id="__checkbox_widg_cbAdozSistTratt" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1','cbSostSistReg')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1.cbSostSistReg.label')}" labelFor="widg_cbSostSistReg" errorFor="appDatareeTipo1.flgSostituzSistRegolaz" labelId="cbSostSistRegLbl"
	  >


<!-- widget cbSostSistReg -->
<s:checkbox 
	
	
	name="appDatareeTipo1.flgSostituzSistRegolaz" id="widg_cbSostSistReg"
	disabled="isWidgetDisabled('cpGestReeTipo1','cbSostSistReg')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestReeTipo1','cbSostSistReg')" >
	<s:hidden name="__checkbox_appDatareeTipo1.flgSostituzSistRegolaz" id="__checkbox_widg_cbSostSistReg" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1','taOss')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1.taOss.label')}" labelFor="widg_taOss" errorFor="appDatareeTipo1.osservazioni" labelId="taOssLbl"
	  >


<!-- widget taOss -->
<s:textarea 
	
	
	name="appDatareeTipo1.osservazioni" id="widg_taOss"
	disabled="isWidgetDisabled('cpGestReeTipo1','taOss')"
	rows="3"
	cols="25"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1','taRacc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1.taRacc.label')}" labelFor="widg_taRacc" errorFor="appDatareeTipo1.raccomandazioni" labelId="taRaccLbl"
	  >


<!-- widget taRacc -->
<s:textarea 
	
	
	name="appDatareeTipo1.raccomandazioni" id="widg_taRacc"
	disabled="isWidgetDisabled('cpGestReeTipo1','taRacc')"
	rows="3"
	cols="25"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1','taPre')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1.taPre.label')}" labelFor="widg_taPre" errorFor="appDatareeTipo1.prescrizioni" labelId="taPreLbl"
	  >


<!-- widget taPre -->
<s:textarea 
	
	
	name="appDatareeTipo1.prescrizioni" id="widg_taPre"
	disabled="isWidgetDisabled('cpGestReeTipo1','taPre')"
	rows="3"
	cols="25"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1','rbFunz')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1.rbFunz.label')}" labelFor="widg_rbFunz" errorFor="appDatareeTipo1.flgPuoFunzionare" labelId="rbFunzLbl"
	  >


<!-- widget rbFunz -->

	
<div id="appDatareeTipo1.flgPuoFunzionare" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbFunzSI" name="appDatareeTipo1.flgPuoFunzionare"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo1','rbFunz')"
	cssClass="radio"
	
	/> <label  for="widg_rbFunzSI1"><s:text name="cpGestReeTipo1.rbFunz.rbFunzSI.label" /></label>








<s:radio
	
	
	id="widg_rbFunzNO" name="appDatareeTipo1.flgPuoFunzionare"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo1','rbFunz')"
	cssClass="radio"
	
	/> <label  for="widg_rbFunzNO0"><s:text name="cpGestReeTipo1.rbFunz.rbFunzNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1','cIntEntro')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1.cIntEntro.label')}" labelFor="widg_cIntEntro" errorFor="appDatareeTipo1.interventoEntro" labelId="cIntEntroLbl"
	  >


<!-- widget cIntEntro -->
<s:textfield 
	
	
	name="appDatareeTipo1.interventoEntro" id="widg_cIntEntro"
	disabled="isWidgetDisabled('cpGestReeTipo1','cIntEntro')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1','tfOraArrivo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1.tfOraArrivo.label')}" labelFor="widg_tfOraArrivo" errorFor="appDatareeTipo1.oraArrivo" labelId="tfOraArrivoLbl"
	  >


<!-- widget tfOraArrivo -->
<s:textfield 
	
	
	name="appDatareeTipo1.oraArrivo" id="widg_tfOraArrivo"
maxlength="10"	disabled="isWidgetDisabled('cpGestReeTipo1','tfOraArrivo')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1','tfOraPart')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1.tfOraPart.label')}" labelFor="widg_tfOraPart" errorFor="appDatareeTipo1.oraPartenza" labelId="tfOraPartLbl"
	  >


<!-- widget tfOraPart -->
<s:textfield 
	
	
	name="appDatareeTipo1.oraPartenza" id="widg_tfOraPart"
maxlength="10"	disabled="isWidgetDisabled('cpGestReeTipo1','tfOraPart')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1','tfTec')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1.tfTec.label')}" labelFor="widg_tfTec" errorFor="appDatareeTipo1.denominazTecnico" labelId="tfTecLbl"
	  fieldRequired="true">


<!-- widget tfTec -->
<s:textfield 
	
	
	name="appDatareeTipo1.denominazTecnico" id="widg_tfTec"
maxlength="100"	disabled="isWidgetDisabled('cpGestReeTipo1','tfTec')"
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
		
<s:if test="isWidgetVisible('cpGestReeTipo1','bSalvaRee')" >

	



<!-- widget bSalvaRee -->
<s:submit name="widg_bSalvaRee" id="widg_bSalvaRee" method="handleBSalvaRee_CLICKED"
	key="cpGestReeTipo1.bSalvaRee.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestReeTipo1','bSalvaRee')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunGestRee --></div>

			
	
	<div id="p_cpNavGestRee" class="commandPanelBlock"><!-- startFragment:p_cpNavGestRee -->
	
	
<div class="commandPanel navigation" id="cpNavGestRee">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestReeTipo1','btnIndietro')" >

	



<!-- widget btnIndietro -->
<s:submit name="widg_btnIndietro" id="widg_btnIndietro" method="handleBtnIndietro_CLICKED"
	key="cpGestReeTipo1.btnIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestReeTipo1','btnIndietro')" />

	


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
