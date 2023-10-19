<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_rapprova -->
<!-- pageId:cpGestRapProvaTipo1 -->

<s:form id="cpGestRapProvaTipo1" action="cpGestRapProvaTipo1" namespace="/base/gestisci_rapprova" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestRapProvaTipo1_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','menu')" >

	


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

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestRapProvaTipo1_udpFunzionalita.jsp"></s:include>

	



			
	
	<div id="p_wpMenuRapProva" class="widgetsPanelBlock"><!-- startFragment:p_wpMenuRapProva -->
	
	

<div class="widgetsPanel" id="wpMenuRapProva">
	
	<customtag:widgetsPanel id="wpMenuRapProvaTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','menuRapProva')" >

	
<customtag:widgetsPanelColumn 
	 colSpan="2" >



	<csiuicore:ajaxify id="p_wpMenuRapProva" 
		widgetType="tree" 
		pageId="cpGestRapProvaTipo1"
		javascriptDetection="false">
	<customtag:tree
		name="appDatarapProvaMenuTree"
		cssUlClass="tree"
        cssRootClass="treeRoot" cssFolderOpenClass="treeFolderOpen"
        cssFolderClosedClass="treeFolderClosed" cssDotClass="treeDot"
		linkOnTree="true" id="menuRapProva"
		selectionMultiplicity="none"
		requestURI="/sigitwebn/base/gestisci_rapprova/cpGestRapProvaTipo1!handleMenuRapProva_CLICKED.do"
		nameSpace="/base/gestisci_rapprova"
		showChildNumber="false">
	</customtag:tree>

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpMenuRapProva --></div>

	

	<!-- endFragment:p_fpLeftMenu --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout LEFT PANEL ***** -->


		<!-- ***** UDLRC Layout CENTER PANEL ***** -->
		<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
			<div class="wrapper">

					
	
	<div id="p_fpCenter" class="formPanelBlock"><!-- startFragment:p_fpCenter -->

	
	

	
	
			
	
	<div id="p_fpGestRapProva" class="formPanelBlock"><!-- startFragment:p_fpGestRapProva -->
		
	
<h4 class="fpLabel"><s:text name="cpGestRapProvaTipo1.fpGestRapProva.label" /></h4>
<div class="formPanel" id="fpGestRapProva">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpGestRapProva --></div>

			
	
	<div id="p_stdMsgRapProva" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgRapProva -->
	
	
<div class="stdMessagePanel" id="stdMsgRapProva">
	<customtag:stdMessagePanel id="stdMsgRapProva" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgRapProva --></div>

			
	
	<div id="p_wpDatiGenerali" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiGenerali -->
	
	
<h4 class="wpLabel">1. dati Generali </h4>
<div class="widgetsPanel" id="wpDatiGenerali">
	
	<customtag:widgetsPanel id="wpDatiGeneraliTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','ptRappControllo')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.ptRappControllo.label')}" labelFor="widg_ptRappControllo" errorFor="widg_ptRappControllo" labelId="ptRappControlloLbl"   >


<!-- widget ptRappControllo -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','rbInviato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.rbInviato.label')}" labelFor="widg_rbInviato" errorFor="appDataTipoGT.s1cFlgReeInviato" labelId="rbInviatoLbl"
	  fieldRequired="true">


<!-- widget rbInviato -->

	
<div id="appDataTipoGT.s1cFlgReeInviato" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbInviatoSI" name="appDataTipoGT.s1cFlgReeInviato"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbInviato')"
	cssClass="radio"
	
	/> <label  for="widg_rbInviatoSI1"><s:text name="cpGestRapProvaTipo1.rbInviato.rbInviatoSI.label" /></label>








<s:radio
	
	
	id="widg_rbInviatoNO" name="appDataTipoGT.s1cFlgReeInviato"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbInviato')"
	cssClass="radio"
	
	/> <label  for="widg_rbInviatoNO0"><s:text name="cpGestRapProvaTipo1.rbInviato.rbInviatoNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','rbBollino')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.rbBollino.label')}" labelFor="widg_rbBollino" errorFor="appDataTipoGT.s1cFlgReeBollino" labelId="rbBollinoLbl"
	  fieldRequired="true">


<!-- widget rbBollino -->

	
<div id="appDataTipoGT.s1cFlgReeBollino" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbBollinoSI" name="appDataTipoGT.s1cFlgReeBollino"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbBollino')"
	cssClass="radio"
	
	/> <label  for="widg_rbBollinoSI1"><s:text name="cpGestRapProvaTipo1.rbBollino.rbBollinoSI.label" /></label>








<s:radio
	
	
	id="widg_rbBollinoNO" name="appDataTipoGT.s1cFlgReeBollino"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbBollino')"
	cssClass="radio"
	
	/> <label  for="widg_rbBollinoNO0"><s:text name="cpGestRapProvaTipo1.rbBollino.rbBollinoNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','cbSiglaBollino')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.cbSiglaBollino.label')}" labelFor="widg_cbSiglaBollino" errorFor="appDataTipoGT.s1cSiglaBollino" labelId="cbSiglaBollinoLbl"
	  >


<!-- widget cbSiglaBollino -->
<s:select name="appDataTipoGT.s1cSiglaBollino" id="widg_cbSiglaBollino"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataElencoBolliniRappProva"
	  disabled="isWidgetDisabled('cpGestRapProvaTipo1','cbSiglaBollino')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','tfNumeroBollino')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.tfNumeroBollino.label')}" labelFor="widg_tfNumeroBollino" errorFor="appDataTipoGT.s1cNumBollino" labelId="tfNumeroBollinoLbl"
	  >


<!-- widget tfNumeroBollino -->
<s:textfield 
	
	
	name="appDataTipoGT.s1cNumBollino" id="widg_tfNumeroBollino"
maxlength="11"	disabled="isWidgetDisabled('cpGestRapProvaTipo1','tfNumeroBollino')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','calDataBollino')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.calDataBollino.label')}" labelFor="widg_calDataBollino" errorFor="appDataTipoGT.s1cDataRee" labelId="calDataBollinoLbl"
	  >


<!-- widget calDataBollino -->
<s:textfield 
	
	
	name="appDataTipoGT.s1cDataRee" id="widg_calDataBollino"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','calDataBollino')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','ptImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.ptImpianto.label')}" labelFor="widg_ptImpianto" errorFor="widg_ptImpianto" labelId="ptImpiantoLbl"   >


<!-- widget ptImpianto -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','calDataPrimaInstallazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.calDataPrimaInstallazione.label')}" labelFor="widg_calDataPrimaInstallazione" errorFor="appDataTipoGT.s1eDtPrimaInstallazione" labelId="calDataPrimaInstallazioneLbl"
	  >


<!-- widget calDataPrimaInstallazione -->
<s:textfield 
	
	
	name="appDataTipoGT.s1eDtPrimaInstallazione" id="widg_calDataPrimaInstallazione"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','calDataPrimaInstallazione')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','tfpotenzafocolare')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.tfpotenzafocolare.label')}" labelFor="widg_tfpotenzafocolare" errorFor="appDataTipoGT.s1ePotFocolareKw" labelId="tfpotenzafocolareLbl"
	  fieldRequired="true">


<!-- widget tfpotenzafocolare -->
<s:textfield 
	
	
	name="appDataTipoGT.s1ePotFocolareKw" id="widg_tfpotenzafocolare"
maxlength="9"	disabled="isWidgetDisabled('cpGestRapProvaTipo1','tfpotenzafocolare')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','tfpotenzautile')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.tfpotenzautile.label')}" labelFor="widg_tfpotenzautile" errorFor="appDataTipoGT.s1ePotUtileKw" labelId="tfpotenzautileLbl"
	  fieldRequired="true">


<!-- widget tfpotenzautile -->
<s:textfield 
	
	
	name="appDataTipoGT.s1ePotUtileKw" id="widg_tfpotenzautile"
maxlength="9"	disabled="isWidgetDisabled('cpGestRapProvaTipo1','tfpotenzautile')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','ptDelegato')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.ptDelegato.label')}" labelFor="widg_ptDelegato" errorFor="widg_ptDelegato" labelId="ptDelegatoLbl"   >


<!-- widget ptDelegato -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','tfCognomeNome')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.tfCognomeNome.label')}" labelFor="widg_tfCognomeNome" errorFor="appDataTipoGT.s1lDenomDelegat" labelId="tfCognomeNomeLbl"
	  >


<!-- widget tfCognomeNome -->
<s:textfield 
	
	
	name="appDataTipoGT.s1lDenomDelegat" id="widg_tfCognomeNome"
maxlength="50"	disabled="isWidgetDisabled('cpGestRapProvaTipo1','tfCognomeNome')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','rbDelegaPresente')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.rbDelegaPresente.label')}" labelFor="widg_rbDelegaPresente" errorFor="appDataTipoGT.s1lFlgDelega" labelId="rbDelegaPresenteLbl"
	  >


<!-- widget rbDelegaPresente -->

	
<div id="appDataTipoGT.s1lFlgDelega" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbDelegaSI" name="appDataTipoGT.s1lFlgDelega"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbDelegaPresente')"
	cssClass="radio"
	
	/> <label  for="widg_rbDelegaSI1"><s:text name="cpGestRapProvaTipo1.rbDelegaPresente.rbDelegaSI.label" /></label>








<s:radio
	
	
	id="widg_rbDelegaNO" name="appDataTipoGT.s1lFlgDelega"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbDelegaPresente')"
	cssClass="radio"
	
	/> <label  for="widg_rbDelegaNO0"><s:text name="cpGestRapProvaTipo1.rbDelegaPresente.rbDelegaNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDatiGenerali --></div>

			
	
	<div id="p_wpDestinazione" class="widgetsPanelBlock"><!-- startFragment:p_wpDestinazione -->
	
	
<h4 class="wpLabel">2. destinazione </h4>
<div class="widgetsPanel" id="wpDestinazione">
	
	<customtag:widgetsPanel id="wpDestinazioneTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','rbSistemiTermoregolazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.rbSistemiTermoregolazione.label')}" labelFor="widg_rbSistemiTermoregolazione" errorFor="appDataTipoGT.s2b1FlgTermoContab" labelId="rbSistemiTermoregolazioneLbl"
	  fieldRequired="true">


<!-- widget rbSistemiTermoregolazione -->

	
<div id="appDataTipoGT.s2b1FlgTermoContab" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbSistemaSI" name="appDataTipoGT.s2b1FlgTermoContab"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbSistemiTermoregolazione')"
	cssClass="radio"
	
	/> <label  for="widg_rbSistemaSI1"><s:text name="cpGestRapProvaTipo1.rbSistemiTermoregolazione.rbSistemaSI.label" /></label>








<s:radio
	
	
	id="widg_rbSistemNO" name="appDataTipoGT.s2b1FlgTermoContab"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbSistemiTermoregolazione')"
	cssClass="radio"
	
	/> <label  for="widg_rbSistemNO0"><s:text name="cpGestRapProvaTipo1.rbSistemiTermoregolazione.rbSistemNO.label" /></label>








<s:radio
	
	
	id="widg_rbSistemaEsentato" name="appDataTipoGT.s2b1FlgTermoContab"
	list="#{'2':'ESENTATO'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbSistemiTermoregolazione')"
	cssClass="radio"
	
	/> <label  for="widg_rbSistemaEsentato2"><s:text name="cpGestRapProvaTipo1.rbSistemiTermoregolazione.rbSistemaEsentato.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','rbUNI')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.rbUNI.label')}" labelFor="widg_rbUNI" errorFor="appDataTipoGT.s2b1FlgUni10200" labelId="rbUNILbl"
	  fieldRequired="true">


<!-- widget rbUNI -->

	
<div id="appDataTipoGT.s2b1FlgUni10200" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbUniSI" name="appDataTipoGT.s2b1FlgUni10200"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbUNI')"
	cssClass="radio"
	
	/> <label  for="widg_rbUniSI1"><s:text name="cpGestRapProvaTipo1.rbUNI.rbUniSI.label" /></label>








<s:radio
	
	
	id="widg_rbUniNO" name="appDataTipoGT.s2b1FlgUni10200"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbUNI')"
	cssClass="radio"
	
	/> <label  for="widg_rbUniNO0"><s:text name="cpGestRapProvaTipo1.rbUNI.rbUniNO.label" /></label>








<s:radio
	
	
	id="widg_rbUNIPS" name="appDataTipoGT.s2b1FlgUni10200"
	list="#{'2':'PRIMA STAGIONE'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbUNI')"
	cssClass="radio"
	
	/> <label  for="widg_rbUNIPS2"><s:text name="cpGestRapProvaTipo1.rbUNI.rbUNIPS.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','ptTrattamento')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.ptTrattamento.label')}" labelFor="widg_ptTrattamento" errorFor="widg_ptTrattamento" labelId="ptTrattamentoLbl"   >


<!-- widget ptTrattamento -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','ptInRiscaldamento')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.ptInRiscaldamento.label')}" labelFor="widg_ptInRiscaldamento" errorFor="appDataTipoGT.inRiscaldamentoDesc" labelId="ptInRiscaldamentoLbl"   >


<!-- widget ptInRiscaldamento -->
<s:property value="appDataTipoGT.inRiscaldamentoDesc" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','rbNonRichiesto')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.rbNonRichiesto.label')}" labelFor="widg_rbNonRichiesto" errorFor="appDataTipoGT.s2fFlgTrattClimaNonRich" labelId="rbNonRichiestoLbl"
	  fieldRequired="true">


<!-- widget rbNonRichiesto -->

	
<div id="appDataTipoGT.s2fFlgTrattClimaNonRich" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbNRSI" name="appDataTipoGT.s2fFlgTrattClimaNonRich"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbNonRichiesto')"
	cssClass="radio"
	
	/> <label  for="widg_rbNRSI1"><s:text name="cpGestRapProvaTipo1.rbNonRichiesto.rbNRSI.label" /></label>








<s:radio
	
	
	id="widg_rbNRNO" name="appDataTipoGT.s2fFlgTrattClimaNonRich"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbNonRichiesto')"
	cssClass="radio"
	
	/> <label  for="widg_rbNRNO0"><s:text name="cpGestRapProvaTipo1.rbNonRichiesto.rbNRNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','ptProdACS')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.ptProdACS.label')}" labelFor="widg_ptProdACS" errorFor="appDataTipoGT.inProduzioneACSDesc" labelId="ptProdACSLbl"   >


<!-- widget ptProdACS -->
<s:property value="appDataTipoGT.inProduzioneACSDesc" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','rbNonRichiestoACS')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.rbNonRichiestoACS.label')}" labelFor="widg_rbNonRichiestoACS" errorFor="appDataTipoGT.s2fFlgTrattAcsNonRich" labelId="rbNonRichiestoACSLbl"
	  fieldRequired="true">


<!-- widget rbNonRichiestoACS -->

	
<div id="appDataTipoGT.s2fFlgTrattAcsNonRich" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbNRACSSI" name="appDataTipoGT.s2fFlgTrattAcsNonRich"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbNonRichiestoACS')"
	cssClass="radio"
	
	/> <label  for="widg_rbNRACSSI1"><s:text name="cpGestRapProvaTipo1.rbNonRichiestoACS.rbNRACSSI.label" /></label>








<s:radio
	
	
	id="widg_rbNRACSNO" name="appDataTipoGT.s2fFlgTrattAcsNonRich"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbNonRichiestoACS')"
	cssClass="radio"
	
	/> <label  for="widg_rbNRACSNO0"><s:text name="cpGestRapProvaTipo1.rbNonRichiestoACS.rbNRACSNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDestinazione --></div>

			
	
	<div id="p_wpControllo" class="widgetsPanelBlock"><!-- startFragment:p_wpControllo -->
	
	
<h4 class="wpLabel">3. controllo dell'impianto </h4>
<div class="widgetsPanel" id="wpControllo">
	
	<customtag:widgetsPanel id="wpControlloTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','rbInstallazioneinterna')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.rbInstallazioneinterna.label')}" labelFor="widg_rbInstallazioneinterna" errorFor="appDataTipoGT.s3aFlgLocaleIntIdoneo" labelId="rbInstallazioneinternaLbl"
	  fieldRequired="true">


<!-- widget rbInstallazioneinterna -->

	
<div id="appDataTipoGT.s3aFlgLocaleIntIdoneo" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbinstallazioneinternaSI" name="appDataTipoGT.s3aFlgLocaleIntIdoneo"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbInstallazioneinterna')"
	cssClass="radio"
	
	/> <label  for="widg_rbinstallazioneinternaSI1"><s:text name="cpGestRapProvaTipo1.rbInstallazioneinterna.rbinstallazioneinternaSI.label" /></label>








<s:radio
	
	
	id="widg_rbinstallazioneinternaNO" name="appDataTipoGT.s3aFlgLocaleIntIdoneo"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbInstallazioneinterna')"
	cssClass="radio"
	
	/> <label  for="widg_rbinstallazioneinternaNO0"><s:text name="cpGestRapProvaTipo1.rbInstallazioneinterna.rbinstallazioneinternaNO.label" /></label>








<s:radio
	
	
	id="widg_rbinstallazioneinternaNC" name="appDataTipoGT.s3aFlgLocaleIntIdoneo"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbInstallazioneinterna')"
	cssClass="radio"
	
	/> <label  for="widg_rbinstallazioneinternaNC2"><s:text name="cpGestRapProvaTipo1.rbInstallazioneinterna.rbinstallazioneinternaNC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','rbInstallazioneest')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.rbInstallazioneest.label')}" labelFor="widg_rbInstallazioneest" errorFor="appDataTipoGT.s3bFlgGenExtIdoneo" labelId="rbInstallazioneestLbl"
	  fieldRequired="true">


<!-- widget rbInstallazioneest -->

	
<div id="appDataTipoGT.s3bFlgGenExtIdoneo" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbesternaSI" name="appDataTipoGT.s3bFlgGenExtIdoneo"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbInstallazioneest')"
	cssClass="radio"
	
	/> <label  for="widg_rbesternaSI1"><s:text name="cpGestRapProvaTipo1.rbInstallazioneest.rbesternaSI.label" /></label>








<s:radio
	
	
	id="widg_rbestenraNO" name="appDataTipoGT.s3bFlgGenExtIdoneo"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbInstallazioneest')"
	cssClass="radio"
	
	/> <label  for="widg_rbestenraNO0"><s:text name="cpGestRapProvaTipo1.rbInstallazioneest.rbestenraNO.label" /></label>








<s:radio
	
	
	id="widg_rbestenraNC" name="appDataTipoGT.s3bFlgGenExtIdoneo"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbInstallazioneest')"
	cssClass="radio"
	
	/> <label  for="widg_rbestenraNC2"><s:text name="cpGestRapProvaTipo1.rbInstallazioneest.rbestenraNC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','rbVentSuff')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.rbVentSuff.label')}" labelFor="widg_rbVentSuff" errorFor="appDataTipoGT.s3cFlgVentilazSuff" labelId="rbVentSuffLbl"
	  fieldRequired="true">


<!-- widget rbVentSuff -->

	
<div id="appDataTipoGT.s3cFlgVentilazSuff" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbVentSuffSI" name="appDataTipoGT.s3cFlgVentilazSuff"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbVentSuff')"
	cssClass="radio"
	
	/> <label  for="widg_rbVentSuffSI1"><s:text name="cpGestRapProvaTipo1.rbVentSuff.rbVentSuffSI.label" /></label>








<s:radio
	
	
	id="widg_rbVentSuffNO" name="appDataTipoGT.s3cFlgVentilazSuff"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbVentSuff')"
	cssClass="radio"
	
	/> <label  for="widg_rbVentSuffNO0"><s:text name="cpGestRapProvaTipo1.rbVentSuff.rbVentSuffNO.label" /></label>








<s:radio
	
	
	id="widg_rbVentSuffNA" name="appDataTipoGT.s3cFlgVentilazSuff"
	list="#{'2':'NA'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbVentSuff')"
	cssClass="radio"
	
	/> <label  for="widg_rbVentSuffNA2"><s:text name="cpGestRapProvaTipo1.rbVentSuff.rbVentSuffNA.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','rbEvaF')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.rbEvaF.label')}" labelFor="widg_rbEvaF" errorFor="appDataTipoGT.s3dFlgEvacFumiIdoneo" labelId="rbEvaFLbl"
	  fieldRequired="true">


<!-- widget rbEvaF -->

	
<div id="appDataTipoGT.s3dFlgEvacFumiIdoneo" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbEvaFSI" name="appDataTipoGT.s3dFlgEvacFumiIdoneo"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbEvaF')"
	cssClass="radio"
	
	/> <label  for="widg_rbEvaFSI1"><s:text name="cpGestRapProvaTipo1.rbEvaF.rbEvaFSI.label" /></label>








<s:radio
	
	
	id="widg_rbEvaFNO" name="appDataTipoGT.s3dFlgEvacFumiIdoneo"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbEvaF')"
	cssClass="radio"
	
	/> <label  for="widg_rbEvaFNO0"><s:text name="cpGestRapProvaTipo1.rbEvaF.rbEvaFNO.label" /></label>








<s:radio
	
title=""	
	id="widg_rbEvaFNC" name="appDataTipoGT.s3dFlgEvacFumiIdoneo"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbEvaF')"
	cssClass="radio"
	
	/> <label  for="widg_rbEvaFNC2"><s:text name="cpGestRapProvaTipo1.rbEvaF.rbEvaFNC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','rbCartPres')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.rbCartPres.label')}" labelFor="widg_rbCartPres" errorFor="appDataTipoGT.s3eFlgCartelliPresenti" labelId="rbCartPresLbl"
	  fieldRequired="true">


<!-- widget rbCartPres -->

	
<div id="appDataTipoGT.s3eFlgCartelliPresenti" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbCartPresSI" name="appDataTipoGT.s3eFlgCartelliPresenti"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbCartPres')"
	cssClass="radio"
	
	/> <label  for="widg_rbCartPresSI1"><s:text name="cpGestRapProvaTipo1.rbCartPres.rbCartPresSI.label" /></label>








<s:radio
	
	
	id="widg_rbCartPresNO" name="appDataTipoGT.s3eFlgCartelliPresenti"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbCartPres')"
	cssClass="radio"
	
	/> <label  for="widg_rbCartPresNO0"><s:text name="cpGestRapProvaTipo1.rbCartPres.rbCartPresNO.label" /></label>








<s:radio
	
	
	id="widg_rbCartPresNA" name="appDataTipoGT.s3eFlgCartelliPresenti"
	list="#{'2':'NA'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbCartPres')"
	cssClass="radio"
	
	/> <label  for="widg_rbCartPresNA2"><s:text name="cpGestRapProvaTipo1.rbCartPres.rbCartPresNA.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','rbEstIn')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.rbEstIn.label')}" labelFor="widg_rbEstIn" errorFor="appDataTipoGT.s3fFlgEstinzPresenti" labelId="rbEstInLbl"
	  fieldRequired="true">


<!-- widget rbEstIn -->

	
<div id="appDataTipoGT.s3fFlgEstinzPresenti" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbEstInSI" name="appDataTipoGT.s3fFlgEstinzPresenti"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbEstIn')"
	cssClass="radio"
	
	/> <label  for="widg_rbEstInSI1"><s:text name="cpGestRapProvaTipo1.rbEstIn.rbEstInSI.label" /></label>








<s:radio
	
	
	id="widg_rbEstInNO" name="appDataTipoGT.s3fFlgEstinzPresenti"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbEstIn')"
	cssClass="radio"
	
	/> <label  for="widg_rbEstInNO0"><s:text name="cpGestRapProvaTipo1.rbEstIn.rbEstInNO.label" /></label>








<s:radio
	
	
	id="widg_rbEstInNA" name="appDataTipoGT.s3fFlgEstinzPresenti"
	list="#{'2':'NA'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbEstIn')"
	cssClass="radio"
	
	/> <label  for="widg_rbEstInNA2"><s:text name="cpGestRapProvaTipo1.rbEstIn.rbEstInNA.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','rbIntPres')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.rbIntPres.label')}" labelFor="widg_rbIntPres" errorFor="appDataTipoGT.s3gFlgInterrGenPresenti" labelId="rbIntPresLbl"
	  fieldRequired="true">


<!-- widget rbIntPres -->

	
<div id="appDataTipoGT.s3gFlgInterrGenPresenti" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbIntPresSI" name="appDataTipoGT.s3gFlgInterrGenPresenti"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbIntPres')"
	cssClass="radio"
	
	/> <label  for="widg_rbIntPresSI1"><s:text name="cpGestRapProvaTipo1.rbIntPres.rbIntPresSI.label" /></label>








<s:radio
	
	
	id="widg_rbIntPresNO" name="appDataTipoGT.s3gFlgInterrGenPresenti"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbIntPres')"
	cssClass="radio"
	
	/> <label  for="widg_rbIntPresNO0"><s:text name="cpGestRapProvaTipo1.rbIntPres.rbIntPresNO.label" /></label>








<s:radio
	
	
	id="widg_rbIntPresNA" name="appDataTipoGT.s3gFlgInterrGenPresenti"
	list="#{'2':'NA'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbIntPres')"
	cssClass="radio"
	
	/> <label  for="widg_rbIntPresNA2"><s:text name="cpGestRapProvaTipo1.rbIntPres.rbIntPresNA.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','rbRubPres')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.rbRubPres.label')}" labelFor="widg_rbRubPres" errorFor="appDataTipoGT.s3hFlgRubinPresente" labelId="rbRubPresLbl"
	  fieldRequired="true">


<!-- widget rbRubPres -->

	
<div id="appDataTipoGT.s3hFlgRubinPresente" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbRubPresSI" name="appDataTipoGT.s3hFlgRubinPresente"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbRubPres')"
	cssClass="radio"
	
	/> <label  for="widg_rbRubPresSI1"><s:text name="cpGestRapProvaTipo1.rbRubPres.rbRubPresSI.label" /></label>








<s:radio
	
	
	id="widg_rbRubPresNO" name="appDataTipoGT.s3hFlgRubinPresente"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbRubPres')"
	cssClass="radio"
	
	/> <label  for="widg_rbRubPresNO0"><s:text name="cpGestRapProvaTipo1.rbRubPres.rbRubPresNO.label" /></label>








<s:radio
	
	
	id="widg_rbRubPresNA" name="appDataTipoGT.s3hFlgRubinPresente"
	list="#{'2':'NA'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbRubPres')"
	cssClass="radio"
	
	/> <label  for="widg_rbRubPresNA2"><s:text name="cpGestRapProvaTipo1.rbRubPres.rbRubPresNA.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','rbAssPerd')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.rbAssPerd.label')}" labelFor="widg_rbAssPerd" errorFor="appDataTipoGT.s3iFlgAssenzaPerdComb" labelId="rbAssPerdLbl"
	  fieldRequired="true">


<!-- widget rbAssPerd -->

	
<div id="appDataTipoGT.s3iFlgAssenzaPerdComb" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbAssPerdSI" name="appDataTipoGT.s3iFlgAssenzaPerdComb"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbAssPerd')"
	cssClass="radio"
	
	/> <label  for="widg_rbAssPerdSI1"><s:text name="cpGestRapProvaTipo1.rbAssPerd.rbAssPerdSI.label" /></label>








<s:radio
	
	
	id="widg_rbAssPerdNO" name="appDataTipoGT.s3iFlgAssenzaPerdComb"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbAssPerd')"
	cssClass="radio"
	
	/> <label  for="widg_rbAssPerdNO0"><s:text name="cpGestRapProvaTipo1.rbAssPerd.rbAssPerdNO.label" /></label>








<s:radio
	
	
	id="widg_rbAssPerdNC" name="appDataTipoGT.s3iFlgAssenzaPerdComb"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbAssPerd')"
	cssClass="radio"
	
	/> <label  for="widg_rbAssPerdNC2"><s:text name="cpGestRapProvaTipo1.rbAssPerd.rbAssPerdNC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','rbRegTemp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.rbRegTemp.label')}" labelFor="widg_rbRegTemp" errorFor="appDataTipoGT.s3jFlgTempAmbFunz" labelId="rbRegTempLbl"
	  fieldRequired="true">


<!-- widget rbRegTemp -->

	
<div id="appDataTipoGT.s3jFlgTempAmbFunz" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbRegTempSI" name="appDataTipoGT.s3jFlgTempAmbFunz"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbRegTemp')"
	cssClass="radio"
	
	/> <label  for="widg_rbRegTempSI1"><s:text name="cpGestRapProvaTipo1.rbRegTemp.rbRegTempSI.label" /></label>








<s:radio
	
	
	id="widg_rbRegTempNO" name="appDataTipoGT.s3jFlgTempAmbFunz"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbRegTemp')"
	cssClass="radio"
	
	/> <label  for="widg_rbRegTempNO0"><s:text name="cpGestRapProvaTipo1.rbRegTemp.rbRegTempNO.label" /></label>








<s:radio
	
	
	id="widg_rbRegTempNC" name="appDataTipoGT.s3jFlgTempAmbFunz"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbRegTemp')"
	cssClass="radio"
	
	/> <label  for="widg_rbRegTempNC2"><s:text name="cpGestRapProvaTipo1.rbRegTemp.rbRegTempNC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','rbAssDisp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.rbAssDisp.label')}" labelFor="widg_rbAssDisp" errorFor="appDataTipoGT.s3kFlgDm_1_12_1975" labelId="rbAssDispLbl"
	  fieldRequired="true">


<!-- widget rbAssDisp -->

	
<div id="appDataTipoGT.s3kFlgDm_1_12_1975" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbAssDispSI" name="appDataTipoGT.s3kFlgDm_1_12_1975"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbAssDisp')"
	cssClass="radio"
	
	/> <label  for="widg_rbAssDispSI1"><s:text name="cpGestRapProvaTipo1.rbAssDisp.rbAssDispSI.label" /></label>








<s:radio
	
	
	id="widg_rbAssDispNO" name="appDataTipoGT.s3kFlgDm_1_12_1975"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbAssDisp')"
	cssClass="radio"
	
	/> <label  for="widg_rbAssDispNO0"><s:text name="cpGestRapProvaTipo1.rbAssDisp.rbAssDispNO.label" /></label>








<s:radio
	
	
	id="widg_rbAssDispNA" name="appDataTipoGT.s3kFlgDm_1_12_1975"
	list="#{'2':'NA'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbAssDisp')"
	cssClass="radio"
	
	/> <label  for="widg_rbAssDispNA2"><s:text name="cpGestRapProvaTipo1.rbAssDisp.rbAssDispNA.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpControllo --></div>

			
	
	<div id="p_wpStatoDoc" class="widgetsPanelBlock"><!-- startFragment:p_wpStatoDoc -->
	
	
<h4 class="wpLabel">4. stato della documentazione </h4>
<div class="widgetsPanel" id="wpStatoDoc">
	
	<customtag:widgetsPanel id="wpStatoDocTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','rbLibrPres')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.rbLibrPres.label')}" labelFor="widg_rbLibrPres" errorFor="appDataTipoGT.s4aFlgLibImpPresente" labelId="rbLibrPresLbl"
	  fieldRequired="true">


<!-- widget rbLibrPres -->

	
<div id="appDataTipoGT.s4aFlgLibImpPresente" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbLibrPresSI" name="appDataTipoGT.s4aFlgLibImpPresente"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbLibrPres')"
	cssClass="radio"
	
	/> <label  for="widg_rbLibrPresSI1"><s:text name="cpGestRapProvaTipo1.rbLibrPres.rbLibrPresSI.label" /></label>








<s:radio
	
	
	id="widg_rbLibrPresNO" name="appDataTipoGT.s4aFlgLibImpPresente"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbLibrPres')"
	cssClass="radio"
	
	/> <label  for="widg_rbLibrPresNO0"><s:text name="cpGestRapProvaTipo1.rbLibrPres.rbLibrPresNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','rbLibrComp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.rbLibrComp.label')}" labelFor="widg_rbLibrComp" errorFor="appDataTipoGT.s4bFlgLibCompilato" labelId="rbLibrCompLbl"
	  fieldRequired="true">


<!-- widget rbLibrComp -->

	
<div id="appDataTipoGT.s4bFlgLibCompilato" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbLibrCompSI" name="appDataTipoGT.s4bFlgLibCompilato"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbLibrComp')"
	cssClass="radio"
	
	/> <label  for="widg_rbLibrCompSI1"><s:text name="cpGestRapProvaTipo1.rbLibrComp.rbLibrCompSI.label" /></label>








<s:radio
	
	
	id="widg_rbLibrCompNO" name="appDataTipoGT.s4bFlgLibCompilato"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbLibrComp')"
	cssClass="radio"
	
	/> <label  for="widg_rbLibrCompNO0"><s:text name="cpGestRapProvaTipo1.rbLibrComp.rbLibrCompNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','rbDicConfPres')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.rbDicConfPres.label')}" labelFor="widg_rbDicConfPres" errorFor="appDataTipoGT.s4cFlgConformitaPresente" labelId="rbDicConfPresLbl"
	  fieldRequired="true">


<!-- widget rbDicConfPres -->

	
<div id="appDataTipoGT.s4cFlgConformitaPresente" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbDicConfPresSI" name="appDataTipoGT.s4cFlgConformitaPresente"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbDicConfPres')"
	cssClass="radio"
	
	/> <label  for="widg_rbDicConfPresSI1"><s:text name="cpGestRapProvaTipo1.rbDicConfPres.rbDicConfPresSI.label" /></label>








<s:radio
	
	
	id="widg_rbDicConfPresNO" name="appDataTipoGT.s4cFlgConformitaPresente"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbDicConfPres')"
	cssClass="radio"
	
	/> <label  for="widg_rbDicConfPresNO0"><s:text name="cpGestRapProvaTipo1.rbDicConfPres.rbDicConfPresNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','rbManutPres')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.rbManutPres.label')}" labelFor="widg_rbManutPres" errorFor="appDataTipoGT.s4dFlgLibUsoPresente" labelId="rbManutPresLbl"
	  fieldRequired="true">


<!-- widget rbManutPres -->

	
<div id="appDataTipoGT.s4dFlgLibUsoPresente" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbManutPresSI" name="appDataTipoGT.s4dFlgLibUsoPresente"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbManutPres')"
	cssClass="radio"
	
	/> <label  for="widg_rbManutPresSI1"><s:text name="cpGestRapProvaTipo1.rbManutPres.rbManutPresSI.label" /></label>








<s:radio
	
	
	id="widg_rbManutPresNO" name="appDataTipoGT.s4dFlgLibUsoPresente"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbManutPres')"
	cssClass="radio"
	
	/> <label  for="widg_rbManutPresNO0"><s:text name="cpGestRapProvaTipo1.rbManutPres.rbManutPresNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','rbPratiPres')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.rbPratiPres.label')}" labelFor="widg_rbPratiPres" errorFor="appDataTipoGT.s4eFlgPraticaVvfPresente" labelId="rbPratiPresLbl"
	  fieldRequired="true">


<!-- widget rbPratiPres -->

	
<div id="appDataTipoGT.s4eFlgPraticaVvfPresente" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbPratiPresSI" name="appDataTipoGT.s4eFlgPraticaVvfPresente"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbPratiPres')"
	cssClass="radio"
	
	/> <label  for="widg_rbPratiPresSI1"><s:text name="cpGestRapProvaTipo1.rbPratiPres.rbPratiPresSI.label" /></label>








<s:radio
	
	
	id="widg_rbPratiPresNO" name="appDataTipoGT.s4eFlgPraticaVvfPresente"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbPratiPres')"
	cssClass="radio"
	
	/> <label  for="widg_rbPratiPresNO0"><s:text name="cpGestRapProvaTipo1.rbPratiPres.rbPratiPresNO.label" /></label>








<s:radio
	
	
	id="widg_rbPratiPresNA" name="appDataTipoGT.s4eFlgPraticaVvfPresente"
	list="#{'2':'NA'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbPratiPres')"
	cssClass="radio"
	
	/> <label  for="widg_rbPratiPresNA2"><s:text name="cpGestRapProvaTipo1.rbPratiPres.rbPratiPresNA.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','rbPratINAIL')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.rbPratINAIL.label')}" labelFor="widg_rbPratINAIL" errorFor="appDataTipoGT.s4fFlgPraticaInailPresente" labelId="rbPratINAILLbl"
	  fieldRequired="true">


<!-- widget rbPratINAIL -->

	
<div id="appDataTipoGT.s4fFlgPraticaInailPresente" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbPratINAILSI" name="appDataTipoGT.s4fFlgPraticaInailPresente"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbPratINAIL')"
	cssClass="radio"
	
	/> <label  for="widg_rbPratINAILSI1"><s:text name="cpGestRapProvaTipo1.rbPratINAIL.rbPratINAILSI.label" /></label>








<s:radio
	
	
	id="widg_rbPratINAILNO" name="appDataTipoGT.s4fFlgPraticaInailPresente"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbPratINAIL')"
	cssClass="radio"
	
	/> <label  for="widg_rbPratINAILNO0"><s:text name="cpGestRapProvaTipo1.rbPratINAIL.rbPratINAILNO.label" /></label>








<s:radio
	
	
	id="widg_rbPratINAILNA" name="appDataTipoGT.s4fFlgPraticaInailPresente"
	list="#{'2':'NA'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbPratINAIL')"
	cssClass="radio"
	
	/> <label  for="widg_rbPratINAILNA2"><s:text name="cpGestRapProvaTipo1.rbPratINAIL.rbPratINAILNA.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','rbMatricola')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.rbMatricola.label')}" labelFor="widg_rbMatricola" errorFor="appDataTipoGT.s4gFlgDm12_1975" labelId="rbMatricolaLbl"
	  fieldRequired="true">


<!-- widget rbMatricola -->

	
<div id="appDataTipoGT.s4gFlgDm12_1975" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbMatricolaSI" name="appDataTipoGT.s4gFlgDm12_1975"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbMatricola')"
	cssClass="radio"
	
	/> <label  for="widg_rbMatricolaSI1"><s:text name="cpGestRapProvaTipo1.rbMatricola.rbMatricolaSI.label" /></label>








<s:radio
	
	
	id="widg_rbMatricolaNO" name="appDataTipoGT.s4gFlgDm12_1975"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbMatricola')"
	cssClass="radio"
	
	/> <label  for="widg_rbMatricolaNO0"><s:text name="cpGestRapProvaTipo1.rbMatricola.rbMatricolaNO.label" /></label>








<s:radio
	
	
	id="widg_rbMatricolaNA" name="appDataTipoGT.s4gFlgDm12_1975"
	list="#{'2':'NA'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','rbMatricola')"
	cssClass="radio"
	
	/> <label  for="widg_rbMatricolaNA2"><s:text name="cpGestRapProvaTipo1.rbMatricola.rbMatricolaNA.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','tfNumero')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.tfNumero.label')}" labelFor="widg_tfNumero" errorFor="appDataTipoGT.s4gMatricolaDm_1_12_1975" labelId="tfNumeroLbl"
	  >


<!-- widget tfNumero -->
<s:textfield 
	
	
	name="appDataTipoGT.s4gMatricolaDm_1_12_1975" id="widg_tfNumero"
maxlength="10"	disabled="isWidgetDisabled('cpGestRapProvaTipo1','tfNumero')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpStatoDoc --></div>

			
	
	<div id="p_wp5" class="widgetsPanelBlock"><!-- startFragment:p_wp5 -->
	
	
<h4 class="wpLabel">5. interventi di miglioramento energetico dell'impianto </h4>
<div class="widgetsPanel" id="wp5">
	
	<customtag:widgetsPanel id="wp5Tbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','pt5a')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.pt5a.label')}" labelFor="widg_pt5a" errorFor="widg_pt5a" labelId="pt5aLbl"   >


<!-- widget pt5a -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','cbAdValvTer')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.cbAdValvTer.label')}" labelFor="widg_cbAdValvTer" errorFor="appDataTipoGT.s5aFlgAdozioneValvoleTerm" labelId="cbAdValvTerLbl"
	  >


<!-- widget cbAdValvTer -->
<s:checkbox 
	
	
	name="appDataTipoGT.s5aFlgAdozioneValvoleTerm" id="widg_cbAdValvTer"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','cbAdValvTer')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestRapProvaTipo1','cbAdValvTer')" >
	<s:hidden name="__checkbox_appDataTipoGT.s5aFlgAdozioneValvoleTerm" id="__checkbox_widg_cbAdValvTer" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','cbIsRete')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.cbIsRete.label')}" labelFor="widg_cbIsRete" errorFor="appDataTipoGT.s5aFlgIsolamenteRete" labelId="cbIsReteLbl"
	  >


<!-- widget cbIsRete -->
<s:checkbox 
	
	
	name="appDataTipoGT.s5aFlgIsolamenteRete" id="widg_cbIsRete"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','cbIsRete')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestRapProvaTipo1','cbIsRete')" >
	<s:hidden name="__checkbox_appDataTipoGT.s5aFlgIsolamenteRete" id="__checkbox_widg_cbIsRete" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','cbAdozSistTratt')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.cbAdozSistTratt.label')}" labelFor="widg_cbAdozSistTratt" errorFor="appDataTipoGT.s5aFlgAdozSistTrattamH2o" labelId="cbAdozSistTrattLbl"
	  >


<!-- widget cbAdozSistTratt -->
<s:checkbox 
	
	
	name="appDataTipoGT.s5aFlgAdozSistTrattamH2o" id="widg_cbAdozSistTratt"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','cbAdozSistTratt')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestRapProvaTipo1','cbAdozSistTratt')" >
	<s:hidden name="__checkbox_appDataTipoGT.s5aFlgAdozSistTrattamH2o" id="__checkbox_widg_cbAdozSistTratt" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','cbSostSistReg')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.cbSostSistReg.label')}" labelFor="widg_cbSostSistReg" errorFor="appDataTipoGT.s5aFlgSostituzSistRegolaz" labelId="cbSostSistRegLbl"
	  >


<!-- widget cbSostSistReg -->
<s:checkbox 
	
	
	name="appDataTipoGT.s5aFlgSostituzSistRegolaz" id="widg_cbSostSistReg"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','cbSostSistReg')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestRapProvaTipo1','cbSostSistReg')" >
	<s:hidden name="__checkbox_appDataTipoGT.s5aFlgSostituzSistRegolaz" id="__checkbox_widg_cbSostSistReg" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','pt5b')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.pt5b.label')}" labelFor="widg_pt5b" errorFor="widg_pt5b" labelId="pt5bLbl"   >


<!-- widget pt5b -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','cbIntConv')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.cbIntConv.label')}" labelFor="widg_cbIntConv" errorFor="appDataTipoGT.s5bFlgNoIntervConv" labelId="cbIntConvLbl"
	  >


<!-- widget cbIntConv -->
<s:checkbox 
	
	
	name="appDataTipoGT.s5bFlgNoIntervConv" id="widg_cbIntConv"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','cbIntConv')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestRapProvaTipo1','cbIntConv')" >
	<s:hidden name="__checkbox_appDataTipoGT.s5bFlgNoIntervConv" id="__checkbox_widg_cbIntConv" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','cbRelDett')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.cbRelDett.label')}" labelFor="widg_cbRelDett" errorFor="appDataTipoGT.s5bFlgRelazDettaglio" labelId="cbRelDettLbl"
	  >


<!-- widget cbRelDett -->
<s:checkbox 
	
	
	name="appDataTipoGT.s5bFlgRelazDettaglio" id="widg_cbRelDett"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','cbRelDett')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestRapProvaTipo1','cbRelDett')" >
	<s:hidden name="__checkbox_appDataTipoGT.s5bFlgRelazDettaglio" id="__checkbox_widg_cbRelDett" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','cbRelDettSucc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.cbRelDettSucc.label')}" labelFor="widg_cbRelDettSucc" errorFor="appDataTipoGT.s5bFlgRelazDettaglioSucc" labelId="cbRelDettSuccLbl"
	  >


<!-- widget cbRelDettSucc -->
<s:checkbox 
	
	
	name="appDataTipoGT.s5bFlgRelazDettaglioSucc" id="widg_cbRelDettSucc"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','cbRelDettSucc')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestRapProvaTipo1','cbRelDettSucc')" >
	<s:hidden name="__checkbox_appDataTipoGT.s5bFlgRelazDettaglioSucc" id="__checkbox_widg_cbRelDettSucc" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','cbValutazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.cbValutazione.label')}" labelFor="widg_cbValutazione" errorFor="appDataTipoGT.s5bFlgValutazNonEseguita" labelId="cbValutazioneLbl"
	  >


<!-- widget cbValutazione -->
<s:checkbox 
	
	
	name="appDataTipoGT.s5bFlgValutazNonEseguita" id="widg_cbValutazione"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','cbValutazione')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestRapProvaTipo1','cbValutazione')" >
	<s:hidden name="__checkbox_appDataTipoGT.s5bFlgValutazNonEseguita" id="__checkbox_widg_cbValutazione" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','tfMotivo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.tfMotivo.label')}" labelFor="widg_tfMotivo" errorFor="appDataTipoGT.s5bMotivoRelazNonEseg" labelId="tfMotivoLbl"
	  >


<!-- widget tfMotivo -->
<s:textfield 
	
	
	name="appDataTipoGT.s5bMotivoRelazNonEseg" id="widg_tfMotivo"
maxlength="100"	disabled="isWidgetDisabled('cpGestRapProvaTipo1','tfMotivo')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','pt5c')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.pt5c.label')}" labelFor="widg_pt5c" errorFor="widg_pt5c" labelId="pt5cLbl"   >


<!-- widget pt5c -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','cbDimensionamentoOK')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.cbDimensionamentoOK.label')}" labelFor="widg_cbDimensionamentoOK" errorFor="appDataTipoGT.s5cFlgDimensCorretto" labelId="cbDimensionamentoOKLbl"
	  >


<!-- widget cbDimensionamentoOK -->
<s:checkbox 
	
	
	name="appDataTipoGT.s5cFlgDimensCorretto" id="widg_cbDimensionamentoOK"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','cbDimensionamentoOK')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestRapProvaTipo1','cbDimensionamentoOK')" >
	<s:hidden name="__checkbox_appDataTipoGT.s5cFlgDimensCorretto" id="__checkbox_widg_cbDimensionamentoOK" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','cbDimensionamentoKO')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.cbDimensionamentoKO.label')}" labelFor="widg_cbDimensionamentoKO" errorFor="appDataTipoGT.s5cFlgDimensNonCorretto" labelId="cbDimensionamentoKOLbl"
	  >


<!-- widget cbDimensionamentoKO -->
<s:checkbox 
	
	
	name="appDataTipoGT.s5cFlgDimensNonCorretto" id="widg_cbDimensionamentoKO"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','cbDimensionamentoKO')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestRapProvaTipo1','cbDimensionamentoKO')" >
	<s:hidden name="__checkbox_appDataTipoGT.s5cFlgDimensNonCorretto" id="__checkbox_widg_cbDimensionamentoKO" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','cbNonCont')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.cbNonCont.label')}" labelFor="widg_cbNonCont" errorFor="appDataTipoGT.s5cFlgDimensNonControll" labelId="cbNonContLbl"
	  >


<!-- widget cbNonCont -->
<s:checkbox 
	
	
	name="appDataTipoGT.s5cFlgDimensNonControll" id="widg_cbNonCont"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','cbNonCont')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestRapProvaTipo1','cbNonCont')" >
	<s:hidden name="__checkbox_appDataTipoGT.s5cFlgDimensNonControll" id="__checkbox_widg_cbNonCont" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','cbRelDettSuccC')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1.cbRelDettSuccC.label')}" labelFor="widg_cbRelDettSuccC" errorFor="appDataTipoGT.s5cFlgDimensRelazSucces" labelId="cbRelDettSuccCLbl"
	  >


<!-- widget cbRelDettSuccC -->
<s:checkbox 
	
	
	name="appDataTipoGT.s5cFlgDimensRelazSucces" id="widg_cbRelDettSuccC"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','cbRelDettSuccC')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestRapProvaTipo1','cbRelDettSuccC')" >
	<s:hidden name="__checkbox_appDataTipoGT.s5cFlgDimensRelazSucces" id="__checkbox_widg_cbRelDettSuccC" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wp5 --></div>

			
	
	<div id="p_wp10" class="widgetsPanelBlock"><!-- startFragment:p_wp10 -->
	
	
<h4 class="wpLabel">10. osservazioni </h4>
<div class="widgetsPanel" id="wp10">
	
	<customtag:widgetsPanel id="wp10Tbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','taOss')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="" labelFor="widg_taOss" errorFor="appDataallegatoIsp.osservazioni" labelId="taOssLbl"
	  >


<!-- widget taOss -->
<s:textarea 
	
	
	name="appDataallegatoIsp.osservazioni" id="widg_taOss"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','taOss')"
	rows="3"
	cols="25"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wp10 --></div>

			
	
	<div id="p_wp11" class="widgetsPanelBlock"><!-- startFragment:p_wp11 -->
	
	
<h4 class="wpLabel">11.prescrizioni </h4>
<div class="widgetsPanel" id="wp11">
	
	<customtag:widgetsPanel id="wp11Tbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','taPre')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="" labelFor="widg_taPre" errorFor="appDataallegatoIsp.prescrizioni" labelId="taPreLbl"
	  >


<!-- widget taPre -->
<s:textarea 
	
	
	name="appDataallegatoIsp.prescrizioni" id="widg_taPre"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','taPre')"
	rows="3"
	cols="25"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wp11 --></div>

			
	
	<div id="p_wp12" class="widgetsPanelBlock"><!-- startFragment:p_wp12 -->
	
	
<h4 class="wpLabel">12. dichiarazioni del responsabile dell'impianto </h4>
<div class="widgetsPanel" id="wp12">
	
	<customtag:widgetsPanel id="wp12Tbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','taRacc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="" labelFor="widg_taRacc" errorFor="appDataallegatoIsp.raccomandazioni" labelId="taRaccLbl"
	  >


<!-- widget taRacc -->
<s:textarea 
	
	
	name="appDataallegatoIsp.raccomandazioni" id="widg_taRacc"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','taRacc')"
	rows="3"
	cols="25"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wp12 --></div>

			
	
	<div id="p_cpFunGestRapProva" class="commandPanelBlock"><!-- startFragment:p_cpFunGestRapProva -->
	
	
<div class="commandPanel functional" id="cpFunGestRapProva">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','bSalvaRapProva')" >

	



<!-- widget bSalvaRapProva -->
<s:submit name="widg_bSalvaRapProva" id="widg_bSalvaRapProva" method="handleBSalvaRapProva_CLICKED"
	key="cpGestRapProvaTipo1.bSalvaRapProva.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','bSalvaRapProva')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunGestRapProva --></div>

			
	
	<div id="p_cpNavGestRapProvaDett" class="commandPanelBlock"><!-- startFragment:p_cpNavGestRapProvaDett -->
	
	
<div class="commandPanel navigation" id="cpNavGestRapProvaDett">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestRapProvaTipo1','btnIndietro')" >

	



<!-- widget btnIndietro -->
<s:submit name="widg_btnIndietro" id="widg_btnIndietro" method="handleBtnIndietro_CLICKED"
	key="cpGestRapProvaTipo1.btnIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1','btnIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavGestRapProvaDett --></div>

	

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
