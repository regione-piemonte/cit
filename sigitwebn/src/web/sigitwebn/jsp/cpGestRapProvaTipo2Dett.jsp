<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_rapprova -->
<!-- pageId:cpGestRapProvaTipo2Dett -->

<s:form id="cpGestRapProvaTipo2Dett" action="cpGestRapProvaTipo2Dett" namespace="/base/gestisci_rapprova" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestRapProvaTipo2Dett_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','menu')" >

	


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

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestRapProvaTipo2Dett_udpFunzionalita.jsp"></s:include>

	



			
	
	<div id="p_wpMenuRapProva" class="widgetsPanelBlock"><!-- startFragment:p_wpMenuRapProva -->
	
	

<div class="widgetsPanel" id="wpMenuRapProva">
	
	<customtag:widgetsPanel id="wpMenuRapProvaTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','menuRapProva')" >

	
<customtag:widgetsPanelColumn 
	 colSpan="2" >



	<csiuicore:ajaxify id="p_wpMenuRapProva" 
		widgetType="tree" 
		pageId="cpGestRapProvaTipo2Dett"
		javascriptDetection="false">
	<customtag:tree
		name="appDatarapProvaMenuTree"
		cssUlClass="tree"
        cssRootClass="treeRoot" cssFolderOpenClass="treeFolderOpen"
        cssFolderClosedClass="treeFolderClosed" cssDotClass="treeDot"
		linkOnTree="true" id="menuRapProva"
		selectionMultiplicity="none"
		requestURI="/sigitwebn/base/gestisci_rapprova/cpGestRapProvaTipo2Dett!handleMenuRapProva_CLICKED.do"
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
		
	
<h4 class="fpLabel"><s:text name="cpGestRapProvaTipo2Dett.fpGestRapProva.label" /></h4>
<div class="formPanel" id="fpGestRapProva">


	
	

	
	
			
	
	<div id="p_stdMsgRapProva" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgRapProva -->
	
	
<div class="stdMessagePanel" id="stdMsgRapProva">
	<customtag:stdMessagePanel id="stdMsgRapProva" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgRapProva --></div>

	

		
	
</div>

	<!-- endFragment:p_fpGestRapProva --></div>

			
	
	<div id="p_wp6" class="widgetsPanelBlock"><!-- startFragment:p_wp6 -->
	
	
<h4 class="wpLabel">6. Gruppo frigo/PDC </h4>
<div class="widgetsPanel" id="wp6">
	
	<customtag:widgetsPanel id="wp6Tbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','pt6a')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.pt6a.label')}" labelFor="widg_pt6a" errorFor="appDataTipoGFDett.GFdesc" labelId="pt6aLbl"   >


<!-- widget pt6a -->
<s:property value="appDataTipoGFDett.GFdesc" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','pt6b')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.pt6b.label')}" labelFor="widg_pt6b" errorFor="appDataTipoGFDett.nCircuiti" labelId="pt6bLbl"   tdStyleClass="numbers">


<!-- widget pt6b -->
<s:property value="appDataTipoGFDett.nCircuiti" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','pt6c')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.pt6c.label')}" labelFor="widg_pt6c" errorFor="appDataTipoGFDett.dataInstallazione" labelId="pt6cLbl"   >


<!-- widget pt6c -->
<s:property value="appDataTipoGFDett.dataInstallazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','pt6d')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.pt6d.label')}" labelFor="widg_pt6d" errorFor="appDataTipoGFDett.marca" labelId="pt6dLbl"   >


<!-- widget pt6d -->
<s:property value="appDataTipoGFDett.marca" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','pt6e')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.pt6e.label')}" labelFor="widg_pt6e" errorFor="appDataTipoGFDett.modello" labelId="pt6eLbl"   >


<!-- widget pt6e -->
<s:property value="appDataTipoGFDett.modello" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','pt6f')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.pt6f.label')}" labelFor="widg_pt6f" errorFor="appDataTipoGFDett.matricola" labelId="pt6fLbl"   >


<!-- widget pt6f -->
<s:property value="appDataTipoGFDett.matricola" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','pt6g')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.pt6g.label')}" labelFor="widg_pt6g" errorFor="appDataTipoGFDett.fluidoFrigo" labelId="pt6gLbl"   >


<!-- widget pt6g -->
<s:property value="appDataTipoGFDett.fluidoFrigo" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','rbFlgInverter')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.rbFlgInverter.label')}" labelFor="widg_rbFlgInverter" errorFor="appDataTipoGFDett.s6hFlgInverter" labelId="rbFlgInverterLbl"
	  >


<!-- widget rbFlgInverter -->

	
<div id="appDataTipoGFDett.s6hFlgInverter" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbFlgInverterSI" name="appDataTipoGFDett.s6hFlgInverter"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','rbFlgInverter')"
	cssClass="radio"
	
	/> <label  for="widg_rbFlgInverterSI1"><s:text name="cpGestRapProvaTipo2Dett.rbFlgInverter.rbFlgInverterSI.label" /></label>








<s:radio
	
	
	id="widg_rbFlgInverterNO" name="appDataTipoGFDett.s6hFlgInverter"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','rbFlgInverter')"
	cssClass="radio"
	
	/> <label  for="widg_rbFlgInverterNO0"><s:text name="cpGestRapProvaTipo2Dett.rbFlgInverter.rbFlgInverterNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','pt6i')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.pt6i.label')}" labelFor="widg_pt6i" errorFor="appDataTipoGFDett.sorgenteExt" labelId="pt6iLbl"   >


<!-- widget pt6i -->
<s:property value="appDataTipoGFDett.sorgenteExt" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','pt6j')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.pt6j.label')}" labelFor="widg_pt6j" errorFor="appDataTipoGFDett.fluidoUtenze" labelId="pt6jLbl"   >


<!-- widget pt6j -->
<s:property value="appDataTipoGFDett.fluidoUtenze" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','pt6kDati')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.pt6kDati.label')}" labelFor="widg_pt6kDati" errorFor="widg_pt6kDati" labelId="pt6kDatiLbl"   >


<!-- widget pt6kDati -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','tfriscCop')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.tfriscCop.label')}" labelFor="widg_tfriscCop" errorFor="appDataTipoGFDett.riscaldamentoCop" labelId="tfriscCopLbl"   >


<!-- widget tfriscCop -->
<s:property value="appDataTipoGFDett.riscaldamentoCop" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','tfPotTermNom')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.tfPotTermNom.label')}" labelFor="widg_tfPotTermNom" errorFor="appDataTipoGFDett.potenzaTermicaNominale" labelId="tfPotTermNomLbl"   >


<!-- widget tfPotTermNom -->
<s:property value="appDataTipoGFDett.potenzaTermicaNominale" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','tfPotAssNom')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.tfPotAssNom.label')}" labelFor="widg_tfPotAssNom" errorFor="appDataTipoGFDett.potenzaAssorbitaNominale" labelId="tfPotAssNomLbl"   >


<!-- widget tfPotAssNom -->
<s:property value="appDataTipoGFDett.potenzaAssorbitaNominale" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','pt6l')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.pt6l.label')}" labelFor="widg_pt6l" errorFor="widg_pt6l" labelId="pt6lLbl"   >


<!-- widget pt6l -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','tfEER')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.tfEER.label')}" labelFor="widg_tfEER" errorFor="appDataTipoGFDett.raffrescamentoEER" labelId="tfEERLbl"   >


<!-- widget tfEER -->
<s:property value="appDataTipoGFDett.raffrescamentoEER" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','tfPotFrigNom')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.tfPotFrigNom.label')}" labelFor="widg_tfPotFrigNom" errorFor="appDataTipoGFDett.potenzaFrigoriferaNominale" labelId="tfPotFrigNomLbl"   >


<!-- widget tfPotFrigNom -->
<s:property value="appDataTipoGFDett.potenzaFrigoriferaNominale" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','tfPotAssNomRaff')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.tfPotAssNomRaff.label')}" labelFor="widg_tfPotAssNomRaff" errorFor="appDataTipoGFDett.potenzaAssorbitaNominaleRaff" labelId="tfPotAssNomRaffLbl"   >


<!-- widget tfPotAssNomRaff -->
<s:property value="appDataTipoGFDett.potenzaAssorbitaNominaleRaff" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','tftipoMacc')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.tftipoMacc.label')}" labelFor="widg_tftipoMacc" errorFor="appDataTipoGFDett.tipoMacchina" labelId="tftipoMaccLbl"   >


<!-- widget tftipoMacc -->
<s:property value="appDataTipoGFDett.tipoMacchina" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','pt6n')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.pt6n.label')}" labelFor="widg_pt6n" errorFor="widg_pt6n" labelId="pt6nLbl"   >


<!-- widget pt6n -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','rbDiretta')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.rbDiretta.label')}" labelFor="widg_rbDiretta" errorFor="appDataTipoGFDett.s6nFlgFugaDiretta" labelId="rbDirettaLbl"
	  >


<!-- widget rbDiretta -->

	
<div id="appDataTipoGFDett.s6nFlgFugaDiretta" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbDirettaSI" name="appDataTipoGFDett.s6nFlgFugaDiretta"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','rbDiretta')"
	cssClass="radio"
	
	/> <label  for="widg_rbDirettaSI1"><s:text name="cpGestRapProvaTipo2Dett.rbDiretta.rbDirettaSI.label" /></label>








<s:radio
	
	
	id="widg_rbDirettaNO" name="appDataTipoGFDett.s6nFlgFugaDiretta"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','rbDiretta')"
	cssClass="radio"
	
	/> <label  for="widg_rbDirettaNO0"><s:text name="cpGestRapProvaTipo2Dett.rbDiretta.rbDirettaNO.label" /></label>








<s:radio
	
	
	id="widg_rbDirettaNC" name="appDataTipoGFDett.s6nFlgFugaDiretta"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','rbDiretta')"
	cssClass="radio"
	
	/> <label  for="widg_rbDirettaNC2"><s:text name="cpGestRapProvaTipo2Dett.rbDiretta.rbDirettaNC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','rbInDiretta')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.rbInDiretta.label')}" labelFor="widg_rbInDiretta" errorFor="appDataTipoGFDett.s6nFlgFugaIndiretta" labelId="rbInDirettaLbl"
	  >


<!-- widget rbInDiretta -->

	
<div id="appDataTipoGFDett.s6nFlgFugaIndiretta" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbInDirettaSI" name="appDataTipoGFDett.s6nFlgFugaIndiretta"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','rbInDiretta')"
	cssClass="radio"
	
	/> <label  for="widg_rbInDirettaSI1"><s:text name="cpGestRapProvaTipo2Dett.rbInDiretta.rbInDirettaSI.label" /></label>








<s:radio
	
	
	id="widg_rbInDirettaNO" name="appDataTipoGFDett.s6nFlgFugaIndiretta"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','rbInDiretta')"
	cssClass="radio"
	
	/> <label  for="widg_rbInDirettaNO0"><s:text name="cpGestRapProvaTipo2Dett.rbInDiretta.rbInDirettaNO.label" /></label>








<s:radio
	
	
	id="widg_rbInDirettaNC" name="appDataTipoGFDett.s6nFlgFugaIndiretta"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','rbInDiretta')"
	cssClass="radio"
	
	/> <label  for="widg_rbInDirettaNC2"><s:text name="cpGestRapProvaTipo2Dett.rbInDiretta.rbInDirettaNC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wp6 --></div>

			
	
	<div id="p_wp7" class="widgetsPanelBlock"><!-- startFragment:p_wp7 -->
	
	
<h4 class="wpLabel">7. manutenzione e analisi </h4>
<div class="widgetsPanel" id="wp7">
	
	<customtag:widgetsPanel id="wp7Tbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','freq')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.freq.label')}" labelFor="widg_freq" errorFor="appDataTipoGFDett.s7aFkFrequenzaManut" labelId="freqLbl"
	  fieldRequired="true">


<!-- widget freq -->
<s:select name="appDataTipoGFDett.s7aFkFrequenzaManut" id="widg_freq"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoFrequenzaManut"
	  disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','freq')"
	  listKey="id"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','tfFreqAltro')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="" labelFor="widg_tfFreqAltro" errorFor="appDataTipoGFDett.s7aFrequenzaManutAltro" labelId="tfFreqAltroLbl"
	  >


<!-- widget tfFreqAltro -->
<s:textfield 
	
	
	name="appDataTipoGFDett.s7aFrequenzaManutAltro" id="widg_tfFreqAltro"
maxlength="50"	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','tfFreqAltro')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','rbUltManu')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.rbUltManu.label')}" labelFor="widg_rbUltManu" errorFor="appDataTipoGFDett.s7FlgManutEffettuata" labelId="rbUltManuLbl"
	  fieldRequired="true">


<!-- widget rbUltManu -->

	
<div id="appDataTipoGFDett.s7FlgManutEffettuata" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbUltManuSI" name="appDataTipoGFDett.s7FlgManutEffettuata"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','rbUltManu')"
	cssClass="radio"
	
	/> <label  for="widg_rbUltManuSI1"><s:text name="cpGestRapProvaTipo2Dett.rbUltManu.rbUltManuSI.label" /></label>








<s:radio
	
	
	id="widg_rbUltManuNO" name="appDataTipoGFDett.s7FlgManutEffettuata"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','rbUltManu')"
	cssClass="radio"
	
	/> <label  for="widg_rbUltManuNO0"><s:text name="cpGestRapProvaTipo2Dett.rbUltManu.rbUltManuNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','calManu')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.calManu.label')}" labelFor="widg_calManu" errorFor="appDataTipoGFDett.s7aDataUltimaManut" labelId="calManuLbl"
	  >


<!-- widget calManu -->
<s:textfield 
	
	
	name="appDataTipoGFDett.s7aDataUltimaManut" id="widg_calManu"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','calManu')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','rbRegi')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.rbRegi.label')}" labelFor="widg_rbRegi" errorFor="appDataTipoGFDett.s7bFlgRegistroApparecc" labelId="rbRegiLbl"
	  >


<!-- widget rbRegi -->

	
<div id="appDataTipoGFDett.s7bFlgRegistroApparecc" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbRegi1" name="appDataTipoGFDett.s7bFlgRegistroApparecc"
	list="#{'1':'Regolarmente compilato'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','rbRegi')"
	cssClass="radio"
	
	/> <label  for="widg_rbRegi11"><s:text name="cpGestRapProvaTipo2Dett.rbRegi.rbRegi1.label" /></label>








<s:radio
	
	
	id="widg_rbRegi0" name="appDataTipoGFDett.s7bFlgRegistroApparecc"
	list="#{'0':'Assente o non regolarmente compilato'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','rbRegi')"
	cssClass="radio"
	
	/> <label  for="widg_rbRegi00"><s:text name="cpGestRapProvaTipo2Dett.rbRegi.rbRegi0.label" /></label>








<s:radio
	
	
	id="widg_rbRegi2" name="appDataTipoGFDett.s7bFlgRegistroApparecc"
	list="#{'0':'Non applicabile'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','rbRegi')"
	cssClass="radio"
	
	/> <label  for="widg_rbRegi20"><s:text name="cpGestRapProvaTipo2Dett.rbRegi.rbRegi2.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','pt7b')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.pt7b.label')}" labelFor="widg_pt7b" errorFor="widg_pt7b" labelId="pt7bLbl"   >


<!-- widget pt7b -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','rbPres')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.rbPres.label')}" labelFor="widg_rbPres" errorFor="appDataTipoGFDett.s7cFlgReePresente" labelId="rbPresLbl"
	  fieldRequired="true">


<!-- widget rbPres -->

	
<div id="appDataTipoGFDett.s7cFlgReePresente" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbPresSI" name="appDataTipoGFDett.s7cFlgReePresente"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','rbPres')"
	cssClass="radio"
	
	/> <label  for="widg_rbPresSI1"><s:text name="cpGestRapProvaTipo2Dett.rbPres.rbPresSI.label" /></label>








<s:radio
	
	
	id="widg_rbPresNO" name="appDataTipoGFDett.s7cFlgReePresente"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','rbPres')"
	cssClass="radio"
	
	/> <label  for="widg_rbPresNO0"><s:text name="cpGestRapProvaTipo2Dett.rbPres.rbPresNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','calPres')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.calPres.label')}" labelFor="widg_calPres" errorFor="appDataTipoGFDett.s7bDataRee" labelId="calPresLbl"
	  >


<!-- widget calPres -->
<s:textfield 
	
	
	name="appDataTipoGFDett.s7bDataRee" id="widg_calPres"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','calPres')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','cbOsser')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.cbOsser.label')}" labelFor="widg_cbOsser" errorFor="appDataTipoGFDett.s7bFlgOsservazioni" labelId="cbOsserLbl"
	  >


<!-- widget cbOsser -->
<s:checkbox 
	
	
	name="appDataTipoGFDett.s7bFlgOsservazioni" id="widg_cbOsser"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','cbOsser')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestRapProvaTipo2Dett','cbOsser')" >
	<s:hidden name="__checkbox_appDataTipoGFDett.s7bFlgOsservazioni" id="__checkbox_widg_cbOsser" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','cbRacc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.cbRacc.label')}" labelFor="widg_cbRacc" errorFor="appDataTipoGFDett.s7bFlgRaccomand" labelId="cbRaccLbl"
	  >


<!-- widget cbRacc -->
<s:checkbox 
	
	
	name="appDataTipoGFDett.s7bFlgRaccomand" id="widg_cbRacc"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','cbRacc')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestRapProvaTipo2Dett','cbRacc')" >
	<s:hidden name="__checkbox_appDataTipoGFDett.s7bFlgRaccomand" id="__checkbox_widg_cbRacc" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','cbPresc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.cbPresc.label')}" labelFor="widg_cbPresc" errorFor="appDataTipoGFDett.s7bFlgPrescr" labelId="cbPrescLbl"
	  >


<!-- widget cbPresc -->
<s:checkbox 
	
	
	name="appDataTipoGFDett.s7bFlgPrescr" id="widg_cbPresc"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','cbPresc')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestRapProvaTipo2Dett','cbPresc')" >
	<s:hidden name="__checkbox_appDataTipoGFDett.s7bFlgPrescr" id="__checkbox_widg_cbPresc" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wp7 --></div>

			
	
	<div id="p_wp8" class="widgetsPanelBlock"><!-- startFragment:p_wp8 -->
	
	
<h4 class="wpLabel">8. controllo e verifica energetica </h4>
<div class="widgetsPanel" id="wp8">
	
	<customtag:widgetsPanel id="wp8Tbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','ptElencoCircuiti')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.ptElencoCircuiti.label')}" labelFor="widg_ptElencoCircuiti" errorFor="appDataTipoGFDett.elencoCircuitiNonComp" labelId="ptElencoCircuitiLbl"   >


<!-- widget ptElencoCircuiti -->
<s:property value="appDataTipoGFDett.elencoCircuitiNonComp" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','cbCircuiti')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.cbCircuiti.label')}" labelFor="widg_cbCircuiti" errorFor="appDatacircuitoSelezionatoRappProva" labelId="cbCircuitiLbl"
	  >


<!-- widget cbCircuiti -->
	<csiuicore:ajaxify id="p_wp8Circuito,p_wp9" 
		widgetType="combo" 
		requestUri="/sigitwebn/base/gestisci_rapprova/cpGestRapProvaTipo2Dett!handleCbCircuiti_VALUE_CHANGED.do"
		pageId="cpGestRapProvaTipo2Dett"
		formName="cpGestRapProvaTipo2Dett"
		javascriptDetection="false"
		nameSpace="/base/gestisci_rapprova">

<s:url id="widg_cbCircuitiurlComboBoxValueChange"
   action="/sigitwebn/cpGestRapProvaTipo2Dett!handleCbCircuiti_VALUE_CHANGED" namespace="/base/gestisci_rapprova"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatacircuitoSelezionatoRappProva" id="widg_cbCircuiti"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoCircuitiRappProva"
	  disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','cbCircuiti')"
	  listKey="code"
	  listValue="description"
	  onclick="onCBClick(this,'confermacbCircuiti','conferma','%{widg_cbCircuitiurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbCircuiti','conferma','%{widg_cbCircuitiurlComboBoxValueChange}')" 
	  />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wp8 --></div>

			
	
	<div id="p_wp8Circuito" class="widgetsPanelBlock"><!-- startFragment:p_wp8Circuito -->
	
	

<div class="widgetsPanel" id="wp8Circuito">
	
	<customtag:widgetsPanel id="wp8CircuitoTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','ptNCircuito')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.ptNCircuito.label')}" labelFor="widg_ptNCircuito" errorFor="appDataTipoGFDettCircuito.s8aNCircuito" labelId="ptNCircuitoLbl"   >


<!-- widget ptNCircuito -->
<s:property value="appDataTipoGFDettCircuito.s8aNCircuito" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','ptProva')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.ptProva.label')}" labelFor="widg_ptProva" errorFor="widg_ptProva" labelId="ptProvaLbl"   >


<!-- widget ptProva -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','cbRaffresc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.cbRaffresc.label')}" labelFor="widg_cbRaffresc" errorFor="appDataTipoGFDettCircuito.s8bFlgProveRaffrescamento" labelId="cbRaffrescLbl"
	  >


<!-- widget cbRaffresc -->
<s:checkbox 
	
	
	name="appDataTipoGFDettCircuito.s8bFlgProveRaffrescamento" id="widg_cbRaffresc"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','cbRaffresc')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestRapProvaTipo2Dett','cbRaffresc')" >
	<s:hidden name="__checkbox_appDataTipoGFDettCircuito.s8bFlgProveRaffrescamento" id="__checkbox_widg_cbRaffresc" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','cbRiscal')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.cbRiscal.label')}" labelFor="widg_cbRiscal" errorFor="appDataTipoGFDettCircuito.s8bFlgProveRiscaldamento" labelId="cbRiscalLbl"
	  >


<!-- widget cbRiscal -->
<s:checkbox 
	
	
	name="appDataTipoGFDettCircuito.s8bFlgProveRiscaldamento" id="widg_cbRiscal"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','cbRiscal')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestRapProvaTipo2Dett','cbRiscal')" >
	<s:hidden name="__checkbox_appDataTipoGFDettCircuito.s8bFlgProveRiscaldamento" id="__checkbox_widg_cbRiscal" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','rbFiltri')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.rbFiltri.label')}" labelFor="widg_rbFiltri" errorFor="appDataTipoGFDettCircuito.s8cFlgFiltriPuliti" labelId="rbFiltriLbl"
	  fieldRequired="true">


<!-- widget rbFiltri -->

	
<div id="appDataTipoGFDettCircuito.s8cFlgFiltriPuliti" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbFiltriSI" name="appDataTipoGFDettCircuito.s8cFlgFiltriPuliti"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','rbFiltri')"
	cssClass="radio"
	
	/> <label  for="widg_rbFiltriSI1"><s:text name="cpGestRapProvaTipo2Dett.rbFiltri.rbFiltriSI.label" /></label>








<s:radio
	
	
	id="widg_rbFiltriNO" name="appDataTipoGFDettCircuito.s8cFlgFiltriPuliti"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','rbFiltri')"
	cssClass="radio"
	
	/> <label  for="widg_rbFiltriNO0"><s:text name="cpGestRapProvaTipo2Dett.rbFiltri.rbFiltriNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','rbNoPerd')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.rbNoPerd.label')}" labelFor="widg_rbNoPerd" errorFor="appDataTipoGFDettCircuito.s8dFlgAssenzaPerditeGas" labelId="rbNoPerdLbl"
	  fieldRequired="true">


<!-- widget rbNoPerd -->

	
<div id="appDataTipoGFDettCircuito.s8dFlgAssenzaPerditeGas" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbNoPerdSI" name="appDataTipoGFDettCircuito.s8dFlgAssenzaPerditeGas"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','rbNoPerd')"
	cssClass="radio"
	
	/> <label  for="widg_rbNoPerdSI1"><s:text name="cpGestRapProvaTipo2Dett.rbNoPerd.rbNoPerdSI.label" /></label>








<s:radio
	
	
	id="widg_rbNoPerdNO" name="appDataTipoGFDettCircuito.s8dFlgAssenzaPerditeGas"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','rbNoPerd')"
	cssClass="radio"
	
	/> <label  for="widg_rbNoPerdNO0"><s:text name="cpGestRapProvaTipo2Dett.rbNoPerd.rbNoPerdNO.label" /></label>








<s:radio
	
	
	id="widg_rbNoPerdNC" name="appDataTipoGFDettCircuito.s8dFlgAssenzaPerditeGas"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','rbNoPerd')"
	cssClass="radio"
	
	/> <label  for="widg_rbNoPerdNC2"><s:text name="cpGestRapProvaTipo2Dett.rbNoPerd.rbNoPerdNC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','ptStrumentoutilizzato')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.ptStrumentoutilizzato.label')}" labelFor="widg_ptStrumentoutilizzato" errorFor="widg_ptStrumentoutilizzato" labelId="ptStrumentoutilizzatoLbl"   >


<!-- widget ptStrumentoutilizzato -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','tfMarca')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.tfMarca.label')}" labelFor="widg_tfMarca" errorFor="appDataTipoGFDettCircuito.s8cMarcaStrumMisura" labelId="tfMarcaLbl"
	  >


<!-- widget tfMarca -->
<s:textfield 
	
	
	name="appDataTipoGFDettCircuito.s8cMarcaStrumMisura" id="widg_tfMarca"
maxlength="100"	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','tfMarca')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','tfModello')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.tfModello.label')}" labelFor="widg_tfModello" errorFor="appDataTipoGFDettCircuito.s8cModelloStrumMisura" labelId="tfModelloLbl"
	  >


<!-- widget tfModello -->
<s:textfield 
	
	
	name="appDataTipoGFDettCircuito.s8cModelloStrumMisura" id="widg_tfModello"
maxlength="100"	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','tfModello')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','tfMatricola')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.tfMatricola.label')}" labelFor="widg_tfMatricola" errorFor="appDataTipoGFDettCircuito.s8cMatricolaStrumMisura" labelId="tfMatricolaLbl"
	  >


<!-- widget tfMatricola -->
<s:textfield 
	
	
	name="appDataTipoGFDettCircuito.s8cMatricolaStrumMisura" id="widg_tfMatricola"
maxlength="30"	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','tfMatricola')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','s8fPotAssorbitaKw')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.s8fPotAssorbitaKw.label')}" labelFor="widg_s8fPotAssorbitaKw" errorFor="appDataTipoGFDettCircuito.s8fPotAssorbitaKw" labelId="s8fPotAssorbitaKwLbl"
	  >


<!-- widget s8fPotAssorbitaKw -->
<s:textfield 
	
	
	name="appDataTipoGFDettCircuito.s8fPotAssorbitaKw" id="widg_s8fPotAssorbitaKw"
maxlength="9"	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','s8fPotAssorbitaKw')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','rbStrum')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.rbStrum.label')}" labelFor="widg_rbStrum" errorFor="appDataTipoGFDettCircuito.s8gFlgStrumentazioneFissa" labelId="rbStrumLbl"
	  >


<!-- widget rbStrum -->

	
<div id="appDataTipoGFDettCircuito.s8gFlgStrumentazioneFissa" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbStrumSI" name="appDataTipoGFDettCircuito.s8gFlgStrumentazioneFissa"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','rbStrum')"
	cssClass="radio"
	
	/> <label  for="widg_rbStrumSI1"><s:text name="cpGestRapProvaTipo2Dett.rbStrum.rbStrumSI.label" /></label>








<s:radio
	
title=""	
	id="widg_rbStrumNO" name="appDataTipoGFDettCircuito.s8gFlgStrumentazioneFissa"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','rbStrum')"
	cssClass="radio"
	
	/> <label  for="widg_rbStrumNO0"><s:text name="cpGestRapProvaTipo2Dett.rbStrum.rbStrumNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','wp8d')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.wp8d.label')}" labelFor="widg_wp8d" errorFor="widg_wp8d" labelId="wp8dLbl"   >


<!-- widget wp8d -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','ptCognome')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.ptCognome.label')}" labelFor="widg_ptCognome" errorFor="appDataTipoGFDettCircuito.s8hOperatoreDenominazione" labelId="ptCognomeLbl"   >


<!-- widget ptCognome -->
<s:property value="appDataTipoGFDettCircuito.s8hOperatoreDenominazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','ptIscr')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.ptIscr.label')}" labelFor="widg_ptIscr" errorFor="appDataTipoGFDettCircuito.s8iOperatoreNumIscriz" labelId="ptIscrLbl"   >


<!-- widget ptIscr -->
<s:property value="appDataTipoGFDettCircuito.s8iOperatoreNumIscriz" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','wp8j')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.wp8j.label')}" labelFor="widg_wp8j" errorFor="widg_wp8j" labelId="wp8jLbl"   >


<!-- widget wp8j -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','tfSurriscaldamento')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.tfSurriscaldamento.label')}" labelFor="widg_tfSurriscaldamento" errorFor="appDataTipoGFDettCircuito.s8jSurriscaldamentok" labelId="tfSurriscaldamentoLbl"
	  >


<!-- widget tfSurriscaldamento -->
<s:textfield 
	
	
	name="appDataTipoGFDettCircuito.s8jSurriscaldamentok" id="widg_tfSurriscaldamento"
maxlength="15"	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','tfSurriscaldamento')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','tfSottoraffreddamento')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.tfSottoraffreddamento.label')}" labelFor="widg_tfSottoraffreddamento" errorFor="appDataTipoGFDettCircuito.s8jSottoraffreddamentoK" labelId="tfSottoraffreddamentoLbl"
	  >


<!-- widget tfSottoraffreddamento -->
<s:textfield 
	
	
	name="appDataTipoGFDettCircuito.s8jSottoraffreddamentoK" id="widg_tfSottoraffreddamento"
maxlength="15"	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','tfSottoraffreddamento')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','tfs8jTempCondensazioneC')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.tfs8jTempCondensazioneC.label')}" labelFor="widg_tfs8jTempCondensazioneC" errorFor="appDataTipoGFDettCircuito.s8jTempCondensazioneC" labelId="tfs8jTempCondensazioneCLbl"
	  >


<!-- widget tfs8jTempCondensazioneC -->
<s:textfield 
	
	
	name="appDataTipoGFDettCircuito.s8jTempCondensazioneC" id="widg_tfs8jTempCondensazioneC"
maxlength="15"	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','tfs8jTempCondensazioneC')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','tfs8jTempEvaporazioneC')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.tfs8jTempEvaporazioneC.label')}" labelFor="widg_tfs8jTempEvaporazioneC" errorFor="appDataTipoGFDettCircuito.s8jTempEvaporazioneC" labelId="tfs8jTempEvaporazioneCLbl"
	  >


<!-- widget tfs8jTempEvaporazioneC -->
<s:textfield 
	
	
	name="appDataTipoGFDettCircuito.s8jTempEvaporazioneC" id="widg_tfs8jTempEvaporazioneC"
maxlength="15"	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','tfs8jTempEvaporazioneC')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','tfs8jTempSorgIngressoC')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.tfs8jTempSorgIngressoC.label')}" labelFor="widg_tfs8jTempSorgIngressoC" errorFor="appDataTipoGFDettCircuito.s8jTempSorgIngressoC" labelId="tfs8jTempSorgIngressoCLbl"
	  >


<!-- widget tfs8jTempSorgIngressoC -->
<s:textfield 
	
	
	name="appDataTipoGFDettCircuito.s8jTempSorgIngressoC" id="widg_tfs8jTempSorgIngressoC"
maxlength="15"	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','tfs8jTempSorgIngressoC')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','tfs8jTempSorgUscitaC')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.tfs8jTempSorgUscitaC.label')}" labelFor="widg_tfs8jTempSorgUscitaC" errorFor="appDataTipoGFDettCircuito.s8jTempSorgUscitaC" labelId="tfs8jTempSorgUscitaCLbl"
	  >


<!-- widget tfs8jTempSorgUscitaC -->
<s:textfield 
	
title=""	
	name="appDataTipoGFDettCircuito.s8jTempSorgUscitaC" id="widg_tfs8jTempSorgUscitaC"
maxlength="15"	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','tfs8jTempSorgUscitaC')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','tfs8jTempIngressoFluidoC')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.tfs8jTempIngressoFluidoC.label')}" labelFor="widg_tfs8jTempIngressoFluidoC" errorFor="appDataTipoGFDettCircuito.s8jTempIngressoFluidoC" labelId="tfs8jTempIngressoFluidoCLbl"
	  >


<!-- widget tfs8jTempIngressoFluidoC -->
<s:textfield 
	
	
	name="appDataTipoGFDettCircuito.s8jTempIngressoFluidoC" id="widg_tfs8jTempIngressoFluidoC"
maxlength="15"	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','tfs8jTempIngressoFluidoC')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','tfs8jTempUscitaFluidoC')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.tfs8jTempUscitaFluidoC.label')}" labelFor="widg_tfs8jTempUscitaFluidoC" errorFor="appDataTipoGFDettCircuito.s8jTempUscitaFluidoC" labelId="tfs8jTempUscitaFluidoCLbl"
	  >


<!-- widget tfs8jTempUscitaFluidoC -->
<s:textfield 
	
	
	name="appDataTipoGFDettCircuito.s8jTempUscitaFluidoC" id="widg_tfs8jTempUscitaFluidoC"
maxlength="15"	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','tfs8jTempUscitaFluidoC')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wp8Circuito --></div>

			
	
	<div id="p_wp9" class="widgetsPanelBlock"><!-- startFragment:p_wp9 -->
	
	
<h4 class="wpLabel">9. esito della prova </h4>
<div class="widgetsPanel" id="wp9">
	
	<customtag:widgetsPanel id="wp9Tbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','rbVerSup')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.rbVerSup.label')}" labelFor="widg_rbVerSup" errorFor="appDataTipoGFDettCircuito.s9verificaSuperata" labelId="rbVerSupLbl"
	  >


<!-- widget rbVerSup -->

	
<div id="appDataTipoGFDettCircuito.s9verificaSuperata" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbrbVerSupSI" name="appDataTipoGFDettCircuito.s9verificaSuperata"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','rbVerSup')"
	cssClass="radio"
	
	/> <label  for="widg_rbrbVerSupSI1"><s:text name="cpGestRapProvaTipo2Dett.rbVerSup.rbrbVerSupSI.label" /></label>








<s:radio
	
	
	id="widg_rbrbVerSupNO" name="appDataTipoGFDettCircuito.s9verificaSuperata"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','rbVerSup')"
	cssClass="radio"
	
	/> <label  for="widg_rbrbVerSupNO0"><s:text name="cpGestRapProvaTipo2Dett.rbVerSup.rbrbVerSupNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','flgnorm')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.flgnorm.label')}" labelFor="widg_flgnorm" errorFor="appDataTipoGFDettCircuito.s9eFlgRispettoNormativa" labelId="flgnormLbl"
	  >


<!-- widget flgnorm -->
<s:checkbox 
	
	
	name="appDataTipoGFDettCircuito.s9eFlgRispettoNormativa" id="widg_flgnorm"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','flgnorm')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestRapProvaTipo2Dett','flgnorm')" >
	<s:hidden name="__checkbox_appDataTipoGFDettCircuito.s9eFlgRispettoNormativa" id="__checkbox_widg_flgnorm" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','pt9check')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.pt9check.label')}" labelFor="widg_pt9check" errorFor="widg_pt9check" labelId="pt9checkLbl"   >


<!-- widget pt9check -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','7a')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.7a.label')}" labelFor="widg_7a" errorFor="appDataTipoGFDettCircuito.s9eFlgNoRispetto7a" labelId="7aLbl"
	  >


<!-- widget 7a -->
<s:checkbox 
	
	
	name="appDataTipoGFDettCircuito.s9eFlgNoRispetto7a" id="widg_7a"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','7a')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestRapProvaTipo2Dett','7a')" >
	<s:hidden name="__checkbox_appDataTipoGFDettCircuito.s9eFlgNoRispetto7a" id="__checkbox_widg_7a" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','7c')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.7c.label')}" labelFor="widg_7c" errorFor="appDataTipoGFDettCircuito.s9eFlgNoRispetto7c" labelId="7cLbl"
	  >


<!-- widget 7c -->
<s:checkbox 
	
	
	name="appDataTipoGFDettCircuito.s9eFlgNoRispetto7c" id="widg_7c"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','7c')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestRapProvaTipo2Dett','7c')" >
	<s:hidden name="__checkbox_appDataTipoGFDettCircuito.s9eFlgNoRispetto7c" id="__checkbox_widg_7c" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','8d')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.8d.label')}" labelFor="widg_8d" errorFor="appDataTipoGFDettCircuito.s9eFlgNoRispetto8d" labelId="8dLbl"
	  >


<!-- widget 8d -->
<s:checkbox 
	
	
	name="appDataTipoGFDettCircuito.s9eFlgNoRispetto8d" id="widg_8d"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','8d')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestRapProvaTipo2Dett','8d')" >
	<s:hidden name="__checkbox_appDataTipoGFDettCircuito.s9eFlgNoRispetto8d" id="__checkbox_widg_8d" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','9a')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo2Dett.9a.label')}" labelFor="widg_9a" errorFor="appDataTipoGFDettCircuito.s9eFlgNoRispetto9a" labelId="9aLbl"
	  >


<!-- widget 9a -->
<s:checkbox 
	
	
	name="appDataTipoGFDettCircuito.s9eFlgNoRispetto9a" id="widg_9a"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','9a')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestRapProvaTipo2Dett','9a')" >
	<s:hidden name="__checkbox_appDataTipoGFDettCircuito.s9eFlgNoRispetto9a" id="__checkbox_widg_9a" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wp9 --></div>

			
	
	<div id="p_cpFunGestRapProva" class="commandPanelBlock"><!-- startFragment:p_cpFunGestRapProva -->
	
	
<div class="commandPanel functional" id="cpFunGestRapProva">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','bSalvaRapProva')" >

	



<!-- widget bSalvaRapProva -->
<s:submit name="widg_bSalvaRapProva" id="widg_bSalvaRapProva" method="handleBSalvaRapProva_CLICKED"
	key="cpGestRapProvaTipo2Dett.bSalvaRapProva.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','bSalvaRapProva')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunGestRapProva --></div>

			
	
	<div id="p_cpNavGestRapProvaDett" class="commandPanelBlock"><!-- startFragment:p_cpNavGestRapProvaDett -->
	
	
<div class="commandPanel navigation" id="cpNavGestRapProvaDett">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestRapProvaTipo2Dett','btnIndietro')" >

	



<!-- widget btnIndietro -->
<s:submit name="widg_btnIndietro" id="widg_btnIndietro" method="handleBtnIndietro_CLICKED"
	key="cpGestRapProvaTipo2Dett.btnIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestRapProvaTipo2Dett','btnIndietro')" />

	


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
