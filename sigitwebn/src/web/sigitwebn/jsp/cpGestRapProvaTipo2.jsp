<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_rapprova -->
<!-- pageId:cpGestRapProvaTipo2 -->

<s:form id="cpGestRapProvaTipo2" action="cpGestRapProvaTipo2" namespace="/base/gestisci_rapprova" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestRapProvaTipo2_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpGestRapProvaTipo2','menu')" >

	


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

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestRapProvaTipo2_udpFunzionalita.jsp"></s:include>

	



			
	
	<div id="p_wpMenuRapProva" class="widgetsPanelBlock"><!-- startFragment:p_wpMenuRapProva -->
	
	

<div class="widgetsPanel" id="wpMenuRapProva">
	
	<customtag:widgetsPanel id="wpMenuRapProvaTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2','menuRapProva')" >

	
<customtag:widgetsPanelColumn 
	 colSpan="2" >



	<csiuicore:ajaxify id="p_wpMenuRapProva" 
		widgetType="tree" 
		pageId="cpGestRapProvaTipo2"
		javascriptDetection="false">
	<customtag:tree
		name="appDatarapProvaMenuTree"
		cssUlClass="tree"
        cssRootClass="treeRoot" cssFolderOpenClass="treeFolderOpen"
        cssFolderClosedClass="treeFolderClosed" cssDotClass="treeDot"
		linkOnTree="true" id="menuRapProva"
		selectionMultiplicity="none"
		requestURI="/sigitwebn/base/gestisci_rapprova/cpGestRapProvaTipo2!handleMenuRapProva_CLICKED.do"
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
		
	
<h4 class="fpLabel"><s:text name="cpGestRapProvaTipo2.fpGestRapProva.label" /></h4>
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
	

	
	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2','ptRappControllo')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo2.ptRappControllo.label')}" labelFor="widg_ptRappControllo" errorFor="widg_ptRappControllo" labelId="ptRappControlloLbl"   >


<!-- widget ptRappControllo -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2','rbInviato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2.rbInviato.label')}" labelFor="widg_rbInviato" errorFor="appDataTipoGF.s1cFlgReeInviato" labelId="rbInviatoLbl"
	  fieldRequired="true">


<!-- widget rbInviato -->

	
<div id="appDataTipoGF.s1cFlgReeInviato" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbInviatoSI" name="appDataTipoGF.s1cFlgReeInviato"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2','rbInviato')"
	cssClass="radio"
	
	/> <label  for="widg_rbInviatoSI1"><s:text name="cpGestRapProvaTipo2.rbInviato.rbInviatoSI.label" /></label>








<s:radio
	
	
	id="widg_rbInviatoNO" name="appDataTipoGF.s1cFlgReeInviato"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2','rbInviato')"
	cssClass="radio"
	
	/> <label  for="widg_rbInviatoNO0"><s:text name="cpGestRapProvaTipo2.rbInviato.rbInviatoNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2','rbBollino')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2.rbBollino.label')}" labelFor="widg_rbBollino" errorFor="appDataTipoGF.s1cFlgReeBollino" labelId="rbBollinoLbl"
	  fieldRequired="true">


<!-- widget rbBollino -->

	
<div id="appDataTipoGF.s1cFlgReeBollino" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbBollinoSI" name="appDataTipoGF.s1cFlgReeBollino"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2','rbBollino')"
	cssClass="radio"
	
	/> <label  for="widg_rbBollinoSI1"><s:text name="cpGestRapProvaTipo2.rbBollino.rbBollinoSI.label" /></label>








<s:radio
	
	
	id="widg_rbBollinoNO" name="appDataTipoGF.s1cFlgReeBollino"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2','rbBollino')"
	cssClass="radio"
	
	/> <label  for="widg_rbBollinoNO0"><s:text name="cpGestRapProvaTipo2.rbBollino.rbBollinoNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2','cbSiglaBollino')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2.cbSiglaBollino.label')}" labelFor="widg_cbSiglaBollino" errorFor="appDataTipoGF.s1cSiglaBollino" labelId="cbSiglaBollinoLbl"
	  >


<!-- widget cbSiglaBollino -->
<s:select name="appDataTipoGF.s1cSiglaBollino" id="widg_cbSiglaBollino"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataElencoBolliniRappProva"
	  disabled="isWidgetDisabled('cpGestRapProvaTipo2','cbSiglaBollino')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2','tfNumeroBollino')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2.tfNumeroBollino.label')}" labelFor="widg_tfNumeroBollino" errorFor="appDataTipoGF.s1cNumBollino" labelId="tfNumeroBollinoLbl"
	  >


<!-- widget tfNumeroBollino -->
<s:textfield 
	
	
	name="appDataTipoGF.s1cNumBollino" id="widg_tfNumeroBollino"
maxlength="11"	disabled="isWidgetDisabled('cpGestRapProvaTipo2','tfNumeroBollino')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2','calDataBollino')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2.calDataBollino.label')}" labelFor="widg_calDataBollino" errorFor="appDataTipoGF.s1cDataRee" labelId="calDataBollinoLbl"
	  >


<!-- widget calDataBollino -->
<s:textfield 
	
	
	name="appDataTipoGF.s1cDataRee" id="widg_calDataBollino"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2','calDataBollino')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2','ptImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo2.ptImpianto.label')}" labelFor="widg_ptImpianto" errorFor="widg_ptImpianto" labelId="ptImpiantoLbl"   >


<!-- widget ptImpianto -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2','calDataPrimaInstallazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2.calDataPrimaInstallazione.label')}" labelFor="widg_calDataPrimaInstallazione" errorFor="appDataTipoGF.s1eDtPrimaInstallazione" labelId="calDataPrimaInstallazioneLbl"
	  >


<!-- widget calDataPrimaInstallazione -->
<s:textfield 
	
	
	name="appDataTipoGF.s1eDtPrimaInstallazione" id="widg_calDataPrimaInstallazione"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2','calDataPrimaInstallazione')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2','tfpotenzafocolare')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2.tfpotenzafocolare.label')}" labelFor="widg_tfpotenzafocolare" errorFor="appDataTipoGF.s1ePotTermicaMaxKw" labelId="tfpotenzafocolareLbl"
	  fieldRequired="true">


<!-- widget tfpotenzafocolare -->
<s:textfield 
	
	
	name="appDataTipoGF.s1ePotTermicaMaxKw" id="widg_tfpotenzafocolare"
maxlength="9"	disabled="isWidgetDisabled('cpGestRapProvaTipo2','tfpotenzafocolare')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2','ptDelegato')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo2.ptDelegato.label')}" labelFor="widg_ptDelegato" errorFor="widg_ptDelegato" labelId="ptDelegatoLbl"   >


<!-- widget ptDelegato -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2','tfCognomeNome')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2.tfCognomeNome.label')}" labelFor="widg_tfCognomeNome" errorFor="appDataTipoGF.s1lDenomDelegat" labelId="tfCognomeNomeLbl"
	  >


<!-- widget tfCognomeNome -->
<s:textfield 
	
	
	name="appDataTipoGF.s1lDenomDelegat" id="widg_tfCognomeNome"
maxlength="50"	disabled="isWidgetDisabled('cpGestRapProvaTipo2','tfCognomeNome')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2','rbDelegaPresente')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2.rbDelegaPresente.label')}" labelFor="widg_rbDelegaPresente" errorFor="appDataTipoGF.s1lFlgDelega" labelId="rbDelegaPresenteLbl"
	  >


<!-- widget rbDelegaPresente -->

	
<div id="appDataTipoGF.s1lFlgDelega" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbDelegaSI" name="appDataTipoGF.s1lFlgDelega"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2','rbDelegaPresente')"
	cssClass="radio"
	
	/> <label  for="widg_rbDelegaSI1"><s:text name="cpGestRapProvaTipo2.rbDelegaPresente.rbDelegaSI.label" /></label>








<s:radio
	
	
	id="widg_rbDelegaNO" name="appDataTipoGF.s1lFlgDelega"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2','rbDelegaPresente')"
	cssClass="radio"
	
	/> <label  for="widg_rbDelegaNO0"><s:text name="cpGestRapProvaTipo2.rbDelegaPresente.rbDelegaNO.label" /></label>





	
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
	

	
	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2','pt2f')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo2.pt2f.label')}" labelFor="widg_pt2f" errorFor="widg_pt2f" labelId="pt2fLbl"   >


<!-- widget pt2f -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2','ptInRiscaldamento')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo2.ptInRiscaldamento.label')}" labelFor="widg_ptInRiscaldamento" errorFor="appDataTipoGF.inRiscaldamentoDesc" labelId="ptInRiscaldamentoLbl"   >


<!-- widget ptInRiscaldamento -->
<s:property value="appDataTipoGF.inRiscaldamentoDesc" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2','rbNonRichiesto')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2.rbNonRichiesto.label')}" labelFor="widg_rbNonRichiesto" errorFor="appDataTipoGF.s2eFlgTrattH2ONonRich" labelId="rbNonRichiestoLbl"
	  >


<!-- widget rbNonRichiesto -->

	
<div id="appDataTipoGF.s2eFlgTrattH2ONonRich" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbNRSI" name="appDataTipoGF.s2eFlgTrattH2ONonRich"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2','rbNonRichiesto')"
	cssClass="radio"
	
	/> <label  for="widg_rbNRSI1"><s:text name="cpGestRapProvaTipo2.rbNonRichiesto.rbNRSI.label" /></label>








<s:radio
	
	
	id="widg_rbNRNO" name="appDataTipoGF.s2eFlgTrattH2ONonRich"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2','rbNonRichiesto')"
	cssClass="radio"
	
	/> <label  for="widg_rbNRNO0"><s:text name="cpGestRapProvaTipo2.rbNonRichiesto.rbNRNO.label" /></label>





	
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
	

	
	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2','rbInstallazioneinterna')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2.rbInstallazioneinterna.label')}" labelFor="widg_rbInstallazioneinterna" errorFor="appDataTipoGF.s3aFlgLocaleIntIdoneo" labelId="rbInstallazioneinternaLbl"
	  fieldRequired="true">


<!-- widget rbInstallazioneinterna -->

	
<div id="appDataTipoGF.s3aFlgLocaleIntIdoneo" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbinstallazioneinternaSI" name="appDataTipoGF.s3aFlgLocaleIntIdoneo"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2','rbInstallazioneinterna')"
	cssClass="radio"
	
	/> <label  for="widg_rbinstallazioneinternaSI1"><s:text name="cpGestRapProvaTipo2.rbInstallazioneinterna.rbinstallazioneinternaSI.label" /></label>








<s:radio
	
	
	id="widg_rbinstallazioneinternaNO" name="appDataTipoGF.s3aFlgLocaleIntIdoneo"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2','rbInstallazioneinterna')"
	cssClass="radio"
	
	/> <label  for="widg_rbinstallazioneinternaNO0"><s:text name="cpGestRapProvaTipo2.rbInstallazioneinterna.rbinstallazioneinternaNO.label" /></label>








<s:radio
	
	
	id="widg_rbinstallazioneinternaNC" name="appDataTipoGF.s3aFlgLocaleIntIdoneo"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2','rbInstallazioneinterna')"
	cssClass="radio"
	
	/> <label  for="widg_rbinstallazioneinternaNC2"><s:text name="cpGestRapProvaTipo2.rbInstallazioneinterna.rbinstallazioneinternaNC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2','rbInstallazioneest')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2.rbInstallazioneest.label')}" labelFor="widg_rbInstallazioneest" errorFor="appDataTipoGF.s3bFlgLineeElettrIdonee" labelId="rbInstallazioneestLbl"
	  fieldRequired="true">


<!-- widget rbInstallazioneest -->

	
<div id="appDataTipoGF.s3bFlgLineeElettrIdonee" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbesternaSI" name="appDataTipoGF.s3bFlgLineeElettrIdonee"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2','rbInstallazioneest')"
	cssClass="radio"
	
	/> <label  for="widg_rbesternaSI1"><s:text name="cpGestRapProvaTipo2.rbInstallazioneest.rbesternaSI.label" /></label>








<s:radio
	
	
	id="widg_rbestenraNO" name="appDataTipoGF.s3bFlgLineeElettrIdonee"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2','rbInstallazioneest')"
	cssClass="radio"
	
	/> <label  for="widg_rbestenraNO0"><s:text name="cpGestRapProvaTipo2.rbInstallazioneest.rbestenraNO.label" /></label>








<s:radio
	
	
	id="widg_rbestenraNC" name="appDataTipoGF.s3bFlgLineeElettrIdonee"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2','rbInstallazioneest')"
	cssClass="radio"
	
	/> <label  for="widg_rbestenraNC2"><s:text name="cpGestRapProvaTipo2.rbInstallazioneest.rbestenraNC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2','rbVentSuff')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2.rbVentSuff.label')}" labelFor="widg_rbVentSuff" errorFor="appDataTipoGF.s3cFlgVentilazAdeguate" labelId="rbVentSuffLbl"
	  fieldRequired="true">


<!-- widget rbVentSuff -->

	
<div id="appDataTipoGF.s3cFlgVentilazAdeguate" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbVentSuffSI" name="appDataTipoGF.s3cFlgVentilazAdeguate"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2','rbVentSuff')"
	cssClass="radio"
	
	/> <label  for="widg_rbVentSuffSI1"><s:text name="cpGestRapProvaTipo2.rbVentSuff.rbVentSuffSI.label" /></label>








<s:radio
	
	
	id="widg_rbVentSuffNO" name="appDataTipoGF.s3cFlgVentilazAdeguate"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2','rbVentSuff')"
	cssClass="radio"
	
	/> <label  for="widg_rbVentSuffNO0"><s:text name="cpGestRapProvaTipo2.rbVentSuff.rbVentSuffNO.label" /></label>








<s:radio
	
	
	id="widg_rbVentSuffNA" name="appDataTipoGF.s3cFlgVentilazAdeguate"
	list="#{'2':'NA'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2','rbVentSuff')"
	cssClass="radio"
	
	/> <label  for="widg_rbVentSuffNA2"><s:text name="cpGestRapProvaTipo2.rbVentSuff.rbVentSuffNA.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2','rbEvaF')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2.rbEvaF.label')}" labelFor="widg_rbEvaF" errorFor="appDataTipoGF.s3dFlgCoibentazioniIdonee" labelId="rbEvaFLbl"
	  fieldRequired="true">


<!-- widget rbEvaF -->

	
<div id="appDataTipoGF.s3dFlgCoibentazioniIdonee" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbEvaFSI" name="appDataTipoGF.s3dFlgCoibentazioniIdonee"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2','rbEvaF')"
	cssClass="radio"
	
	/> <label  for="widg_rbEvaFSI1"><s:text name="cpGestRapProvaTipo2.rbEvaF.rbEvaFSI.label" /></label>








<s:radio
	
	
	id="widg_rbEvaFNO" name="appDataTipoGF.s3dFlgCoibentazioniIdonee"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2','rbEvaF')"
	cssClass="radio"
	
	/> <label  for="widg_rbEvaFNO0"><s:text name="cpGestRapProvaTipo2.rbEvaF.rbEvaFNO.label" /></label>








<s:radio
	
	
	id="widg_rbEvaFNC" name="appDataTipoGF.s3dFlgCoibentazioniIdonee"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2','rbEvaF')"
	cssClass="radio"
	
	/> <label  for="widg_rbEvaFNC2"><s:text name="cpGestRapProvaTipo2.rbEvaF.rbEvaFNC.label" /></label>





	
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
	

	
	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2','rbLibrPres')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2.rbLibrPres.label')}" labelFor="widg_rbLibrPres" errorFor="appDataTipoGF.s4aFlgLibImpPresente" labelId="rbLibrPresLbl"
	  fieldRequired="true">


<!-- widget rbLibrPres -->

	
<div id="appDataTipoGF.s4aFlgLibImpPresente" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbLibrPresSI" name="appDataTipoGF.s4aFlgLibImpPresente"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2','rbLibrPres')"
	cssClass="radio"
	
	/> <label  for="widg_rbLibrPresSI1"><s:text name="cpGestRapProvaTipo2.rbLibrPres.rbLibrPresSI.label" /></label>








<s:radio
	
	
	id="widg_rbLibrPresNO" name="appDataTipoGF.s4aFlgLibImpPresente"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2','rbLibrPres')"
	cssClass="radio"
	
	/> <label  for="widg_rbLibrPresNO0"><s:text name="cpGestRapProvaTipo2.rbLibrPres.rbLibrPresNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2','rbLibrComp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2.rbLibrComp.label')}" labelFor="widg_rbLibrComp" errorFor="appDataTipoGF.s4bFlgLibCompilato" labelId="rbLibrCompLbl"
	  fieldRequired="true">


<!-- widget rbLibrComp -->

	
<div id="appDataTipoGF.s4bFlgLibCompilato" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbLibrCompSI" name="appDataTipoGF.s4bFlgLibCompilato"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2','rbLibrComp')"
	cssClass="radio"
	
	/> <label  for="widg_rbLibrCompSI1"><s:text name="cpGestRapProvaTipo2.rbLibrComp.rbLibrCompSI.label" /></label>








<s:radio
	
	
	id="widg_rbLibrCompNO" name="appDataTipoGF.s4bFlgLibCompilato"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2','rbLibrComp')"
	cssClass="radio"
	
	/> <label  for="widg_rbLibrCompNO0"><s:text name="cpGestRapProvaTipo2.rbLibrComp.rbLibrCompNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2','rbDicConfPres')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2.rbDicConfPres.label')}" labelFor="widg_rbDicConfPres" errorFor="appDataTipoGF.s4cFlgConformitaPresente" labelId="rbDicConfPresLbl"
	  fieldRequired="true">


<!-- widget rbDicConfPres -->

	
<div id="appDataTipoGF.s4cFlgConformitaPresente" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbDicConfPresSI" name="appDataTipoGF.s4cFlgConformitaPresente"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2','rbDicConfPres')"
	cssClass="radio"
	
	/> <label  for="widg_rbDicConfPresSI1"><s:text name="cpGestRapProvaTipo2.rbDicConfPres.rbDicConfPresSI.label" /></label>








<s:radio
	
	
	id="widg_rbDicConfPresNO" name="appDataTipoGF.s4cFlgConformitaPresente"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2','rbDicConfPres')"
	cssClass="radio"
	
	/> <label  for="widg_rbDicConfPresNO0"><s:text name="cpGestRapProvaTipo2.rbDicConfPres.rbDicConfPresNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2','rbManutPres')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2.rbManutPres.label')}" labelFor="widg_rbManutPres" errorFor="appDataTipoGF.s4dFlgLibUsoPresente" labelId="rbManutPresLbl"
	  fieldRequired="true">


<!-- widget rbManutPres -->

	
<div id="appDataTipoGF.s4dFlgLibUsoPresente" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbManutPresSI" name="appDataTipoGF.s4dFlgLibUsoPresente"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2','rbManutPres')"
	cssClass="radio"
	
	/> <label  for="widg_rbManutPresSI1"><s:text name="cpGestRapProvaTipo2.rbManutPres.rbManutPresSI.label" /></label>








<s:radio
	
	
	id="widg_rbManutPresNO" name="appDataTipoGF.s4dFlgLibUsoPresente"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2','rbManutPres')"
	cssClass="radio"
	
	/> <label  for="widg_rbManutPresNO0"><s:text name="cpGestRapProvaTipo2.rbManutPres.rbManutPresNO.label" /></label>





	
</div>



	
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
	

	
	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2','pt5a')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo2.pt5a.label')}" labelFor="widg_pt5a" errorFor="widg_pt5a" labelId="pt5aLbl"   >


<!-- widget pt5a -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2','cbAdValvTer')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2.cbAdValvTer.label')}" labelFor="widg_cbAdValvTer" errorFor="appDataTipoGF.s5aFlgSostituzMacchineReg" labelId="cbAdValvTerLbl"
	  >


<!-- widget cbAdValvTer -->
<s:checkbox 
	
	
	name="appDataTipoGF.s5aFlgSostituzMacchineReg" id="widg_cbAdValvTer"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2','cbAdValvTer')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestRapProvaTipo2','cbAdValvTer')" >
	<s:hidden name="__checkbox_appDataTipoGF.s5aFlgSostituzMacchineReg" id="__checkbox_widg_cbAdValvTer" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2','cbIsRete')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2.cbIsRete.label')}" labelFor="widg_cbIsRete" errorFor="appDataTipoGF.s5aFlgSostituzSistemiReg" labelId="cbIsReteLbl"
	  >


<!-- widget cbIsRete -->
<s:checkbox 
	
	
	name="appDataTipoGF.s5aFlgSostituzSistemiReg" id="widg_cbIsRete"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2','cbIsRete')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestRapProvaTipo2','cbIsRete')" >
	<s:hidden name="__checkbox_appDataTipoGF.s5aFlgSostituzSistemiReg" id="__checkbox_widg_cbIsRete" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2','cbAdozSistTratt')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2.cbAdozSistTratt.label')}" labelFor="widg_cbAdozSistTratt" errorFor="appDataTipoGF.s5aFlgIsolamReteDistrib" labelId="cbAdozSistTrattLbl"
	  >


<!-- widget cbAdozSistTratt -->
<s:checkbox 
	
	
	name="appDataTipoGF.s5aFlgIsolamReteDistrib" id="widg_cbAdozSistTratt"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2','cbAdozSistTratt')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestRapProvaTipo2','cbAdozSistTratt')" >
	<s:hidden name="__checkbox_appDataTipoGF.s5aFlgIsolamReteDistrib" id="__checkbox_widg_cbAdozSistTratt" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2','cbSostSistReg')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2.cbSostSistReg.label')}" labelFor="widg_cbSostSistReg" errorFor="appDataTipoGF.s5aFlgIsolamCanaliDistrib" labelId="cbSostSistRegLbl"
	  >


<!-- widget cbSostSistReg -->
<s:checkbox 
	
	
	name="appDataTipoGF.s5aFlgIsolamCanaliDistrib" id="widg_cbSostSistReg"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2','cbSostSistReg')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestRapProvaTipo2','cbSostSistReg')" >
	<s:hidden name="__checkbox_appDataTipoGF.s5aFlgIsolamCanaliDistrib" id="__checkbox_widg_cbSostSistReg" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2','pt5b')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo2.pt5b.label')}" labelFor="widg_pt5b" errorFor="widg_pt5b" labelId="pt5bLbl"   >


<!-- widget pt5b -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2','cbIntConv')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2.cbIntConv.label')}" labelFor="widg_cbIntConv" errorFor="appDataTipoGF.s5bFlgNoIntervConv" labelId="cbIntConvLbl"
	  >


<!-- widget cbIntConv -->
<s:checkbox 
	
	
	name="appDataTipoGF.s5bFlgNoIntervConv" id="widg_cbIntConv"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2','cbIntConv')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestRapProvaTipo2','cbIntConv')" >
	<s:hidden name="__checkbox_appDataTipoGF.s5bFlgNoIntervConv" id="__checkbox_widg_cbIntConv" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2','cbRelDett')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2.cbRelDett.label')}" labelFor="widg_cbRelDett" errorFor="appDataTipoGF.s5bFlgRelazDettaglio" labelId="cbRelDettLbl"
	  >


<!-- widget cbRelDett -->
<s:checkbox 
	
	
	name="appDataTipoGF.s5bFlgRelazDettaglio" id="widg_cbRelDett"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2','cbRelDett')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestRapProvaTipo2','cbRelDett')" >
	<s:hidden name="__checkbox_appDataTipoGF.s5bFlgRelazDettaglio" id="__checkbox_widg_cbRelDett" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2','cbRelDettSucc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2.cbRelDettSucc.label')}" labelFor="widg_cbRelDettSucc" errorFor="appDataTipoGF.s5bFlgRelazDettaglioSucc" labelId="cbRelDettSuccLbl"
	  >


<!-- widget cbRelDettSucc -->
<s:checkbox 
	
	
	name="appDataTipoGF.s5bFlgRelazDettaglioSucc" id="widg_cbRelDettSucc"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2','cbRelDettSucc')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestRapProvaTipo2','cbRelDettSucc')" >
	<s:hidden name="__checkbox_appDataTipoGF.s5bFlgRelazDettaglioSucc" id="__checkbox_widg_cbRelDettSucc" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2','cbValutazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2.cbValutazione.label')}" labelFor="widg_cbValutazione" errorFor="appDataTipoGF.s5bFlgValutazNonEseguita" labelId="cbValutazioneLbl"
	  >


<!-- widget cbValutazione -->
<s:checkbox 
	
	
	name="appDataTipoGF.s5bFlgValutazNonEseguita" id="widg_cbValutazione"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2','cbValutazione')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestRapProvaTipo2','cbValutazione')" >
	<s:hidden name="__checkbox_appDataTipoGF.s5bFlgValutazNonEseguita" id="__checkbox_widg_cbValutazione" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2','tfMotivo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2.tfMotivo.label')}" labelFor="widg_tfMotivo" errorFor="appDataTipoGF.s5bMotivoRelazNonEseg" labelId="tfMotivoLbl"
	  >


<!-- widget tfMotivo -->
<s:textfield 
	
	
	name="appDataTipoGF.s5bMotivoRelazNonEseg" id="widg_tfMotivo"
maxlength="100"	disabled="isWidgetDisabled('cpGestRapProvaTipo2','tfMotivo')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2','pt5c')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo2.pt5c.label')}" labelFor="widg_pt5c" errorFor="widg_pt5c" labelId="pt5cLbl"   >


<!-- widget pt5c -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2','cbDimensionamentoOK')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2.cbDimensionamentoOK.label')}" labelFor="widg_cbDimensionamentoOK" errorFor="appDataTipoGF.s5cFlgDimensCorretto" labelId="cbDimensionamentoOKLbl"
	  >


<!-- widget cbDimensionamentoOK -->
<s:checkbox 
	
	
	name="appDataTipoGF.s5cFlgDimensCorretto" id="widg_cbDimensionamentoOK"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2','cbDimensionamentoOK')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestRapProvaTipo2','cbDimensionamentoOK')" >
	<s:hidden name="__checkbox_appDataTipoGF.s5cFlgDimensCorretto" id="__checkbox_widg_cbDimensionamentoOK" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2','cbDimensionamentoKO')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2.cbDimensionamentoKO.label')}" labelFor="widg_cbDimensionamentoKO" errorFor="appDataTipoGF.s5cFlgDimensNonCorretto" labelId="cbDimensionamentoKOLbl"
	  >


<!-- widget cbDimensionamentoKO -->
<s:checkbox 
	
	
	name="appDataTipoGF.s5cFlgDimensNonCorretto" id="widg_cbDimensionamentoKO"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2','cbDimensionamentoKO')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestRapProvaTipo2','cbDimensionamentoKO')" >
	<s:hidden name="__checkbox_appDataTipoGF.s5cFlgDimensNonCorretto" id="__checkbox_widg_cbDimensionamentoKO" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2','cbNonCont')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2.cbNonCont.label')}" labelFor="widg_cbNonCont" errorFor="appDataTipoGF.s5cFlgDimensNonControll" labelId="cbNonContLbl"
	  >


<!-- widget cbNonCont -->
<s:checkbox 
	
	
	name="appDataTipoGF.s5cFlgDimensNonControll" id="widg_cbNonCont"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2','cbNonCont')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestRapProvaTipo2','cbNonCont')" >
	<s:hidden name="__checkbox_appDataTipoGF.s5cFlgDimensNonControll" id="__checkbox_widg_cbNonCont" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2','cbRelDettSuccC')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2.cbRelDettSuccC.label')}" labelFor="widg_cbRelDettSuccC" errorFor="appDataTipoGF.s5cFlgDimensRelazSucces" labelId="cbRelDettSuccCLbl"
	  >


<!-- widget cbRelDettSuccC -->
<s:checkbox 
	
	
	name="appDataTipoGF.s5cFlgDimensRelazSucces" id="widg_cbRelDettSuccC"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2','cbRelDettSuccC')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestRapProvaTipo2','cbRelDettSuccC')" >
	<s:hidden name="__checkbox_appDataTipoGF.s5cFlgDimensRelazSucces" id="__checkbox_widg_cbRelDettSuccC" />
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
	

	
	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2','taOss')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="" labelFor="widg_taOss" errorFor="appDataallegatoIsp.osservazioni" labelId="taOssLbl"
	  >


<!-- widget taOss -->
<s:textarea 
	
	
	name="appDataallegatoIsp.osservazioni" id="widg_taOss"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2','taOss')"
	rows="3"
	cols="25"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wp10 --></div>

			
	
	<div id="p_wp11" class="widgetsPanelBlock"><!-- startFragment:p_wp11 -->
	
	
<h4 class="wpLabel">11. prescrizioni </h4>
<div class="widgetsPanel" id="wp11">
	
	<customtag:widgetsPanel id="wp11Tbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2','taPre')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="" labelFor="widg_taPre" errorFor="appDataallegatoIsp.prescrizioni" labelId="taPreLbl"
	  >


<!-- widget taPre -->
<s:textarea 
	
	
	name="appDataallegatoIsp.prescrizioni" id="widg_taPre"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2','taPre')"
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
	

	
	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2','taRacc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="" labelFor="widg_taRacc" errorFor="appDataallegatoIsp.raccomandazioni" labelId="taRaccLbl"
	  >


<!-- widget taRacc -->
<s:textarea 
	
	
	name="appDataallegatoIsp.raccomandazioni" id="widg_taRacc"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2','taRacc')"
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
		
<s:if test="isWidgetVisible('cpGestRapProvaTipo2','bSalvaRapProva')" >

	



<!-- widget bSalvaRapProva -->
<s:submit name="widg_bSalvaRapProva" id="widg_bSalvaRapProva" method="handleBSalvaRapProva_CLICKED"
	key="cpGestRapProvaTipo2.bSalvaRapProva.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2','bSalvaRapProva')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunGestRapProva --></div>

			
	
	<div id="p_cpNavGestRapProvaDett" class="commandPanelBlock"><!-- startFragment:p_cpNavGestRapProvaDett -->
	
	
<div class="commandPanel navigation" id="cpNavGestRapProvaDett">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestRapProvaTipo2','btnIndietro')" >

	



<!-- widget btnIndietro -->
<s:submit name="widg_btnIndietro" id="widg_btnIndietro" method="handleBtnIndietro_CLICKED"
	key="cpGestRapProvaTipo2.btnIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2','btnIndietro')" />

	


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
