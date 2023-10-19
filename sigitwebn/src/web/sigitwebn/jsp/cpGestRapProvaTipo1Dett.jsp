<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_rapprova -->
<!-- pageId:cpGestRapProvaTipo1Dett -->

<s:form id="cpGestRapProvaTipo1Dett" action="cpGestRapProvaTipo1Dett" namespace="/base/gestisci_rapprova" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestRapProvaTipo1Dett_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','menu')" >

	


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

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestRapProvaTipo1Dett_udpFunzionalita.jsp"></s:include>

	



			
	
	<div id="p_wpMenuRapProva" class="widgetsPanelBlock"><!-- startFragment:p_wpMenuRapProva -->
	
	

<div class="widgetsPanel" id="wpMenuRapProva">
	
	<customtag:widgetsPanel id="wpMenuRapProvaTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','menuRapProva')" >

	
<customtag:widgetsPanelColumn 
	 colSpan="2" >



	<csiuicore:ajaxify id="p_wpMenuRapProva" 
		widgetType="tree" 
		pageId="cpGestRapProvaTipo1Dett"
		javascriptDetection="false">
	<customtag:tree
		name="appDatarapProvaMenuTree"
		cssUlClass="tree"
        cssRootClass="treeRoot" cssFolderOpenClass="treeFolderOpen"
        cssFolderClosedClass="treeFolderClosed" cssDotClass="treeDot"
		linkOnTree="true" id="menuRapProva"
		selectionMultiplicity="none"
		requestURI="/sigitwebn/base/gestisci_rapprova/cpGestRapProvaTipo1Dett!handleMenuRapProva_CLICKED.do"
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
		
	
<h4 class="fpLabel"><s:text name="cpGestRapProvaTipo1Dett.fpGestRapProva.label" /></h4>
<div class="formPanel" id="fpGestRapProva">


	
	

	
	
			
	
	<div id="p_stdMsgRapProvaDett" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgRapProvaDett -->
	
	
<div class="stdMessagePanel" id="stdMsgRapProvaDett">
	<customtag:stdMessagePanel id="stdMsgRapProvaDett" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgRapProvaDett --></div>

	

		
	
</div>

	<!-- endFragment:p_fpGestRapProva --></div>

			
	
	<div id="p_wp6" class="widgetsPanelBlock"><!-- startFragment:p_wp6 -->
	
	
<h4 class="wpLabel">6. generatore </h4>
<div class="widgetsPanel" id="wp6">
	
	<customtag:widgetsPanel id="wp6Tbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','pt6a')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.pt6a.label')}" labelFor="widg_pt6a" errorFor="appDataTipoGTDett.GTdesc" labelId="pt6aLbl"   >


<!-- widget pt6a -->
<s:property value="appDataTipoGTDett.GTdesc" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','pt6a1')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.pt6a1.label')}" labelFor="widg_pt6a1" errorFor="appDataTipoGTDett.combustibile" labelId="pt6a1Lbl"   >


<!-- widget pt6a1 -->
<s:property value="appDataTipoGTDett.combustibile" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','pt6b')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.pt6b.label')}" labelFor="widg_pt6b" errorFor="appDataTipoGTDett.dataInstallazione" labelId="pt6bLbl"   >


<!-- widget pt6b -->
<s:property value="appDataTipoGTDett.dataInstallazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','pt6c')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.pt6c.label')}" labelFor="widg_pt6c" errorFor="appDataTipoGTDett.fluido" labelId="pt6cLbl"   >


<!-- widget pt6c -->
<s:property value="appDataTipoGTDett.fluido" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','cbEvac')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.cbEvac.label')}" labelFor="widg_cbEvac" errorFor="appDataTipoGTDett.s6dFlgEvacuFumi" labelId="cbEvacLbl"
	  fieldRequired="true">


<!-- widget cbEvac -->
<s:select name="appDataTipoGTDett.s6dFlgEvacuFumi" id="widg_cbEvac"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataElencoModalitaEvacuazione"
	  disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','cbEvac')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','pt6e')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.pt6e.label')}" labelFor="widg_pt6e" errorFor="appDataTipoGTDett.marca" labelId="pt6eLbl"   >


<!-- widget pt6e -->
<s:property value="appDataTipoGTDett.marca" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','pt6f')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.pt6f.label')}" labelFor="widg_pt6f" errorFor="appDataTipoGTDett.modelloMatricola" labelId="pt6fLbl"   >


<!-- widget pt6f -->
<s:property value="appDataTipoGTDett.modelloMatricola" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','pt6g')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.pt6g.label')}" labelFor="widg_pt6g" errorFor="appDataTipoGTDett.marcaBruciatori" labelId="pt6gLbl"   >


<!-- widget pt6g -->
<s:property value="appDataTipoGTDett.marcaBruciatori" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','pt6h')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.pt6h.label')}" labelFor="widg_pt6h" errorFor="appDataTipoGTDett.modelloMatricolaBruciatori" labelId="pt6hLbl"   >


<!-- widget pt6h -->
<s:property value="appDataTipoGTDett.modelloMatricolaBruciatori" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','pt6i')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.pt6i.label')}" labelFor="widg_pt6i" errorFor="appDataTipoGTDett.dettaglioCompGT" labelId="pt6iLbl"   >


<!-- widget pt6i -->
<s:property value="appDataTipoGTDett.dettaglioCompGT" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','cbTipoB')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.cbTipoB.label')}" labelFor="widg_cbTipoB" errorFor="appDataTipoGTDett.s6iFlgTipoB" labelId="cbTipoBLbl"
	  >


<!-- widget cbTipoB -->
<s:checkbox 
	
	
	name="appDataTipoGTDett.s6iFlgTipoB" id="widg_cbTipoB"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','cbTipoB')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestRapProvaTipo1Dett','cbTipoB')" >
	<s:hidden name="__checkbox_appDataTipoGTDett.s6iFlgTipoB" id="__checkbox_widg_cbTipoB" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','cbTipoC')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.cbTipoC.label')}" labelFor="widg_cbTipoC" errorFor="appDataTipoGTDett.s6iFlgTipoC" labelId="cbTipoCLbl"
	  >


<!-- widget cbTipoC -->
<s:checkbox 
	
	
	name="appDataTipoGTDett.s6iFlgTipoC" id="widg_cbTipoC"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','cbTipoC')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestRapProvaTipo1Dett','cbTipoC')" >
	<s:hidden name="__checkbox_appDataTipoGTDett.s6iFlgTipoC" id="__checkbox_widg_cbTipoC" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','classDpr')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.classDpr.label')}" labelFor="widg_classDpr" errorFor="appDataTipoGTDett.s6jFkClassDpr660_96" labelId="classDprLbl"
	  >


<!-- widget classDpr -->
<s:select name="appDataTipoGTDett.s6jFkClassDpr660_96" id="widg_classDpr"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoClassDPR"
	  disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','classDpr')"
	  listKey="id"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','pt6k')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.pt6k.label')}" labelFor="widg_pt6k" errorFor="widg_pt6k" labelId="pt6kLbl"   >


<!-- widget pt6k -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','tfPotTermFoc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.tfPotTermFoc.label')}" labelFor="widg_tfPotTermFoc" errorFor="appDataTipoGTDett.s6kPotTermFocolKw" labelId="tfPotTermFocLbl"
	  fieldRequired="true">


<!-- widget tfPotTermFoc -->
<s:textfield 
	
	
	name="appDataTipoGTDett.s6kPotTermFocolKw" id="widg_tfPotTermFoc"
maxlength="9"	disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','tfPotTermFoc')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','tfPotTermUtile')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.tfPotTermUtile.label')}" labelFor="widg_tfPotTermUtile" errorFor="appDataTipoGTDett.potenzaTermicaCompGT" labelId="tfPotTermUtileLbl"   >


<!-- widget tfPotTermUtile -->
<s:property value="appDataTipoGTDett.potenzaTermicaCompGT" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','tfCampLav')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.tfCampLav.label')}" labelFor="widg_tfCampLav" errorFor="widg_tfCampLav" labelId="tfCampLavLbl"   >


<!-- widget tfCampLav -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','tfDa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.tfDa.label')}" labelFor="widg_tfDa" errorFor="appDataTipoGTDett.s6kBruciatoreDaKw" labelId="tfDaLbl"
	  >


<!-- widget tfDa -->
<s:textfield 
	
	
	name="appDataTipoGTDett.s6kBruciatoreDaKw" id="widg_tfDa"
maxlength="9"	disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','tfDa')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','tfA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.tfA.label')}" labelFor="widg_tfA" errorFor="appDataTipoGTDett.s6kBruciatoreAKw" labelId="tfALbl"
	  >


<!-- widget tfA -->
<s:textfield 
	
	
	name="appDataTipoGTDett.s6kBruciatoreAKw" id="widg_tfA"
maxlength="9"	disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','tfA')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','pt6l')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.pt6l.label')}" labelFor="widg_pt6l" errorFor="widg_pt6l" labelId="pt6lLbl"   >


<!-- widget pt6l -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','tfPrtComb1')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.tfPrtComb1.label')}" labelFor="widg_tfPrtComb1" errorFor="appDataTipoGTDett.s6lPortataCombM3H" labelId="tfPrtComb1Lbl"
	  >


<!-- widget tfPrtComb1 -->
<s:textfield 
	
	
	name="appDataTipoGTDett.s6lPortataCombM3H" id="widg_tfPrtComb1"
maxlength="9"	disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','tfPrtComb1')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','tfPrtComb2')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.tfPrtComb2.label')}" labelFor="widg_tfPrtComb2" errorFor="appDataTipoGTDett.s6lPortataCombKgH" labelId="tfPrtComb2Lbl"
	  >


<!-- widget tfPrtComb2 -->
<s:textfield 
	
	
	name="appDataTipoGTDett.s6lPortataCombKgH" id="widg_tfPrtComb2"
maxlength="9"	disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','tfPrtComb2')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','tfPtTermFoc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.tfPtTermFoc.label')}" labelFor="widg_tfPtTermFoc" errorFor="appDataTipoGTDett.s6lPotTermFocolKw" labelId="tfPtTermFocLbl"
	  >


<!-- widget tfPtTermFoc -->
<s:textfield 
	
	
	name="appDataTipoGTDett.s6lPotTermFocolKw" id="widg_tfPtTermFoc"
maxlength="9"	disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','tfPtTermFoc')"
	size="15" 
/>

	
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
	

	
	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','pt7a')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.pt7a.label')}" labelFor="widg_pt7a" errorFor="widg_pt7a" labelId="pt7aLbl"   >


<!-- widget pt7a -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','freq')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.freq.label')}" labelFor="widg_freq" errorFor="appDataTipoGTDett.s7aFkFrequenzaManut" labelId="freqLbl"
	  fieldRequired="true">


<!-- widget freq -->
<s:select name="appDataTipoGTDett.s7aFkFrequenzaManut" id="widg_freq"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoFrequenzaManut"
	  disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','freq')"
	  listKey="id"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','tfFreqAltro')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="" labelFor="widg_tfFreqAltro" errorFor="appDataTipoGTDett.s7aFrequenzaManutAltro" labelId="tfFreqAltroLbl"
	  >


<!-- widget tfFreqAltro -->
<s:textfield 
	
	
	name="appDataTipoGTDett.s7aFrequenzaManutAltro" id="widg_tfFreqAltro"
maxlength="50"	disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','tfFreqAltro')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','rbUltManu')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.rbUltManu.label')}" labelFor="widg_rbUltManu" errorFor="appDataTipoGTDett.s7aFlgManutEffettuata" labelId="rbUltManuLbl"
	  fieldRequired="true">


<!-- widget rbUltManu -->

	
<div id="appDataTipoGTDett.s7aFlgManutEffettuata" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbUltManuSI" name="appDataTipoGTDett.s7aFlgManutEffettuata"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','rbUltManu')"
	cssClass="radio"
	
	/> <label  for="widg_rbUltManuSI1"><s:text name="cpGestRapProvaTipo1Dett.rbUltManu.rbUltManuSI.label" /></label>








<s:radio
	
	
	id="widg_rbUltManuNO" name="appDataTipoGTDett.s7aFlgManutEffettuata"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','rbUltManu')"
	cssClass="radio"
	
	/> <label  for="widg_rbUltManuNO0"><s:text name="cpGestRapProvaTipo1Dett.rbUltManu.rbUltManuNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','calManu')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.calManu.label')}" labelFor="widg_calManu" errorFor="appDataTipoGTDett.s7aDataUltimaManut" labelId="calManuLbl"
	  >


<!-- widget calManu -->
<s:textfield 
	
	
	name="appDataTipoGTDett.s7aDataUltimaManut" id="widg_calManu"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','calManu')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','pt7b')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.pt7b.label')}" labelFor="widg_pt7b" errorFor="widg_pt7b" labelId="pt7bLbl"   >


<!-- widget pt7b -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','rbPres')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.rbPres.label')}" labelFor="widg_rbPres" errorFor="appDataTipoGTDett.s7bFlgReePresente" labelId="rbPresLbl"
	  fieldRequired="true">


<!-- widget rbPres -->

	
<div id="appDataTipoGTDett.s7bFlgReePresente" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbPresSI" name="appDataTipoGTDett.s7bFlgReePresente"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','rbPres')"
	cssClass="radio"
	
	/> <label  for="widg_rbPresSI1"><s:text name="cpGestRapProvaTipo1Dett.rbPres.rbPresSI.label" /></label>








<s:radio
	
	
	id="widg_rbPresNO" name="appDataTipoGTDett.s7bFlgReePresente"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','rbPres')"
	cssClass="radio"
	
	/> <label  for="widg_rbPresNO0"><s:text name="cpGestRapProvaTipo1Dett.rbPres.rbPresNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','calPres')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.calPres.label')}" labelFor="widg_calPres" errorFor="appDataTipoGTDett.s7bDataRee" labelId="calPresLbl"
	  >


<!-- widget calPres -->
<s:textfield 
	
	
	name="appDataTipoGTDett.s7bDataRee" id="widg_calPres"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','calPres')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','cbOsser')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.cbOsser.label')}" labelFor="widg_cbOsser" errorFor="appDataTipoGTDett.s7bFlgOsservazioni" labelId="cbOsserLbl"
	  >


<!-- widget cbOsser -->
<s:checkbox 
	
	
	name="appDataTipoGTDett.s7bFlgOsservazioni" id="widg_cbOsser"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','cbOsser')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestRapProvaTipo1Dett','cbOsser')" >
	<s:hidden name="__checkbox_appDataTipoGTDett.s7bFlgOsservazioni" id="__checkbox_widg_cbOsser" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','cbRacc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.cbRacc.label')}" labelFor="widg_cbRacc" errorFor="appDataTipoGTDett.s7bFlgRaccomand" labelId="cbRaccLbl"
	  >


<!-- widget cbRacc -->
<s:checkbox 
	
	
	name="appDataTipoGTDett.s7bFlgRaccomand" id="widg_cbRacc"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','cbRacc')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestRapProvaTipo1Dett','cbRacc')" >
	<s:hidden name="__checkbox_appDataTipoGTDett.s7bFlgRaccomand" id="__checkbox_widg_cbRacc" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','cbPresc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.cbPresc.label')}" labelFor="widg_cbPresc" errorFor="appDataTipoGTDett.s7bFlgPrescr" labelId="cbPrescLbl"
	  >


<!-- widget cbPresc -->
<s:checkbox 
	
	
	name="appDataTipoGTDett.s7bFlgPrescr" id="widg_cbPresc"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','cbPresc')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestRapProvaTipo1Dett','cbPresc')" >
	<s:hidden name="__checkbox_appDataTipoGTDett.s7bFlgPrescr" id="__checkbox_widg_cbPresc" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wp7 --></div>

			
	
	<div id="p_wp8" class="widgetsPanelBlock"><!-- startFragment:p_wp8 -->
	
	
<h4 class="wpLabel">8. misura dei prodotti di combustibile e del rendimento di combustione (UNI 10389-1) </h4>
<div class="widgetsPanel" id="wp8">
	
	<customtag:widgetsPanel id="wp8Tbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','ptElencoModuli')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.ptElencoModuli.label')}" labelFor="widg_ptElencoModuli" errorFor="appDataTipoGTDett.elencoModuliNonComp" labelId="ptElencoModuliLbl"   >


<!-- widget ptElencoModuli -->
<s:property value="appDataTipoGTDett.elencoModuliNonComp" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','cbModuli')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.cbModuli.label')}" labelFor="widg_cbModuli" errorFor="appDatamoduloSelezionatoRappProva" labelId="cbModuliLbl"
	  >


<!-- widget cbModuli -->
	<csiuicore:ajaxify id="p_wp8Modulo,p_wp9" 
		widgetType="combo" 
		requestUri="/sigitwebn/base/gestisci_rapprova/cpGestRapProvaTipo1Dett!handleCbModuli_VALUE_CHANGED.do"
		pageId="cpGestRapProvaTipo1Dett"
		formName="cpGestRapProvaTipo1Dett"
		javascriptDetection="false"
		nameSpace="/base/gestisci_rapprova">

<s:url id="widg_cbModuliurlComboBoxValueChange"
   action="/sigitwebn/cpGestRapProvaTipo1Dett!handleCbModuli_VALUE_CHANGED" namespace="/base/gestisci_rapprova"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatamoduloSelezionatoRappProva" id="widg_cbModuli"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoModuliRappProva"
	  disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','cbModuli')"
	  listKey="code"
	  listValue="description"
	  onclick="onCBClick(this,'confermacbModuli','conferma','%{widg_cbModuliurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbModuli','conferma','%{widg_cbModuliurlComboBoxValueChange}')" 
	  />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wp8 --></div>

			
	
	<div id="p_wp8Modulo" class="widgetsPanelBlock"><!-- startFragment:p_wp8Modulo -->
	
	

<div class="widgetsPanel" id="wp8Modulo">
	
	<customtag:widgetsPanel id="wp8ModuloTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','ptNModuloTermico')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.ptNModuloTermico.label')}" labelFor="widg_ptNModuloTermico" errorFor="appDataTipoGTDettModulo.s8aNModuloTermico" labelId="ptNModuloTermicoLbl"   >


<!-- widget ptNModuloTermico -->
<s:property value="appDataTipoGTDettModulo.s8aNModuloTermico" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','ptIndiceFum')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.ptIndiceFum.label')}" labelFor="widg_ptIndiceFum" errorFor="widg_ptIndiceFum" labelId="ptIndiceFumLbl"   >


<!-- widget ptIndiceFum -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','tfTemp1')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.tfTemp1.label')}" labelFor="widg_tfTemp1" errorFor="appDataTipoGTDettModulo.s8bFumoMis1" labelId="tfTemp1Lbl"
	  >


<!-- widget tfTemp1 -->
<s:textfield 
	
	
	name="appDataTipoGTDettModulo.s8bFumoMis1" id="widg_tfTemp1"
maxlength="9"	disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','tfTemp1')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','tfTemp2')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.tfTemp2.label')}" labelFor="widg_tfTemp2" errorFor="appDataTipoGTDettModulo.s8bFumoMis2" labelId="tfTemp2Lbl"
	  >


<!-- widget tfTemp2 -->
<s:textfield 
	
	
	name="appDataTipoGTDettModulo.s8bFumoMis2" id="widg_tfTemp2"
maxlength="9"	disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','tfTemp2')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','tfTemp3')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.tfTemp3.label')}" labelFor="widg_tfTemp3" errorFor="appDataTipoGTDettModulo.s8bFumoMis3" labelId="tfTemp3Lbl"
	  >


<!-- widget tfTemp3 -->
<s:textfield 
	
	
	name="appDataTipoGTDettModulo.s8bFumoMis3" id="widg_tfTemp3"
maxlength="9"	disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','tfTemp3')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','ptStrumentoutilizzato')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.ptStrumentoutilizzato.label')}" labelFor="widg_ptStrumentoutilizzato" errorFor="widg_ptStrumentoutilizzato" labelId="ptStrumentoutilizzatoLbl"   >


<!-- widget ptStrumentoutilizzato -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','tfMarca')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.tfMarca.label')}" labelFor="widg_tfMarca" errorFor="appDataTipoGTDettModulo.s8cMarcaStrumMisura" labelId="tfMarcaLbl"
	  fieldRequired="true">


<!-- widget tfMarca -->
<s:textfield 
	
	
	name="appDataTipoGTDettModulo.s8cMarcaStrumMisura" id="widg_tfMarca"
maxlength="100"	disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','tfMarca')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','tfModello')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.tfModello.label')}" labelFor="widg_tfModello" errorFor="appDataTipoGTDettModulo.s8cModelloStrumMisura" labelId="tfModelloLbl"
	  fieldRequired="true">


<!-- widget tfModello -->
<s:textfield 
	
	
	name="appDataTipoGTDettModulo.s8cModelloStrumMisura" id="widg_tfModello"
maxlength="100"	disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','tfModello')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','tfMatricola')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.tfMatricola.label')}" labelFor="widg_tfMatricola" errorFor="appDataTipoGTDettModulo.s8cMatricolaStrumMisura" labelId="tfMatricolaLbl"
	  fieldRequired="true">


<!-- widget tfMatricola -->
<s:textfield 
	
	
	name="appDataTipoGTDettModulo.s8cMatricolaStrumMisura" id="widg_tfMatricola"
maxlength="30"	disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','tfMatricola')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','wp8d')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.wp8d.label')}" labelFor="widg_wp8d" errorFor="widg_wp8d" labelId="wp8dLbl"   >


<!-- widget wp8d -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','tfTempFluido')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.tfTempFluido.label')}" labelFor="widg_tfTempFluido" errorFor="appDataTipoGTDettModulo.s8dTempFluidoMandataC" labelId="tfTempFluidoLbl"
	  fieldRequired="true">


<!-- widget tfTempFluido -->
<s:textfield 
	
	
	name="appDataTipoGTDettModulo.s8dTempFluidoMandataC" id="widg_tfTempFluido"
maxlength="7"	disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','tfTempFluido')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','tfTempAria')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.tfTempAria.label')}" labelFor="widg_tfTempAria" errorFor="appDataTipoGTDettModulo.s8dTempAria_c" labelId="tfTempAriaLbl"
	  fieldRequired="true">


<!-- widget tfTempAria -->
<s:textfield 
	
	
	name="appDataTipoGTDettModulo.s8dTempAria_c" id="widg_tfTempAria"
maxlength="7"	disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','tfTempAria')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','tfTempFumi')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.tfTempFumi.label')}" labelFor="widg_tfTempFumi" errorFor="appDataTipoGTDettModulo.s8dTempFumiC" labelId="tfTempFumiLbl"
	  fieldRequired="true">


<!-- widget tfTempFumi -->
<s:textfield 
	
	
	name="appDataTipoGTDettModulo.s8dTempFumiC" id="widg_tfTempFumi"
maxlength="7"	disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','tfTempFumi')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','percDi')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.percDi.label')}" labelFor="widg_percDi" errorFor="appDataTipoGTDettModulo.s8dSceltaPerc" labelId="percDiLbl"
	  fieldRequired="true">


<!-- widget percDi -->
<s:select name="appDataTipoGTDettModulo.s8dSceltaPerc" id="widg_percDi"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataElencoO2CO2"
	  disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','percDi')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','tfValore')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.tfValore.label')}" labelFor="widg_tfValore" errorFor="appDataTipoGTDettModulo.s8dPerc" labelId="tfValoreLbl"
	  fieldRequired="true">


<!-- widget tfValore -->
<s:textfield 
	
	
	name="appDataTipoGTDettModulo.s8dPerc" id="widg_tfValore"
maxlength="6"	disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','tfValore')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','tfCoFumi')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.tfCoFumi.label')}" labelFor="widg_tfCoFumi" errorFor="appDataTipoGTDettModulo.s8dCoFumiSecchiPpm" labelId="tfCoFumiLbl"
	  fieldRequired="true">


<!-- widget tfCoFumi -->
<s:textfield 
	
	
	name="appDataTipoGTDettModulo.s8dCoFumiSecchiPpm" id="widg_tfCoFumi"
maxlength="10"	disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','tfCoFumi')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','tfNoOssigeno')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.tfNoOssigeno.label')}" labelFor="widg_tfNoOssigeno" errorFor="appDataTipoGTDettModulo.s8dNoMgKwH" labelId="tfNoOssigenoLbl"
	  fieldRequired="true">


<!-- widget tfNoOssigeno -->
<s:textfield 
	
	
	name="appDataTipoGTDettModulo.s8dNoMgKwH" id="widg_tfNoOssigeno"
maxlength="10"	disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','tfNoOssigeno')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','wp8e')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.wp8e.label')}" labelFor="widg_wp8e" errorFor="widg_wp8e" labelId="wp8eLbl"   >


<!-- widget wp8e -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','tfIndAria')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.tfIndAria.label')}" labelFor="widg_tfIndAria" errorFor="appDataTipoGTDettModulo.s8eIndiceAria" labelId="tfIndAriaLbl"
	  fieldRequired="true">


<!-- widget tfIndAria -->
<s:textfield 
	
	
	name="appDataTipoGTDettModulo.s8eIndiceAria" id="widg_tfIndAria"
maxlength="15"	disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','tfIndAria')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','tfCoFumiSecchi')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.tfCoFumiSecchi.label')}" labelFor="widg_tfCoFumiSecchi" errorFor="appDataTipoGTDettModulo.s8eFumiSecchiNoAriaPpm" labelId="tfCoFumiSecchiLbl"
	  fieldRequired="true">


<!-- widget tfCoFumiSecchi -->
<s:textfield 
	
	
	name="appDataTipoGTDettModulo.s8eFumiSecchiNoAriaPpm" id="widg_tfCoFumiSecchi"
maxlength="10"	disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','tfCoFumiSecchi')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','tfPotTermPers')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.tfPotTermPers.label')}" labelFor="widg_tfPotTermPers" errorFor="appDataTipoGTDettModulo.s8eQsPerc" labelId="tfPotTermPersLbl"
	  fieldRequired="true">


<!-- widget tfPotTermPers -->
<s:textfield 
	
	
	name="appDataTipoGTDettModulo.s8eQsPerc" id="widg_tfPotTermPers"
maxlength="6"	disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','tfPotTermPers')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','tfRecCalore')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.tfRecCalore.label')}" labelFor="widg_tfRecCalore" errorFor="appDataTipoGTDettModulo.s8eEtPerc" labelId="tfRecCaloreLbl"
	  fieldRequired="true">


<!-- widget tfRecCalore -->
<s:textfield 
	
	
	name="appDataTipoGTDettModulo.s8eEtPerc" id="widg_tfRecCalore"
maxlength="6"	disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','tfRecCalore')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','tfRecCombust')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.tfRecCombust.label')}" labelFor="widg_tfRecCombust" errorFor="appDataTipoGTDettModulo.s8eRendCombPerc" labelId="tfRecCombustLbl"
	  fieldRequired="true">


<!-- widget tfRecCombust -->
<s:textfield 
	
	
	name="appDataTipoGTDettModulo.s8eRendCombPerc" id="widg_tfRecCombust"
maxlength="6"	disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','tfRecCombust')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','tfNOxOss')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.tfNOxOss.label')}" labelFor="widg_tfNOxOss" errorFor="appDataTipoGTDettModulo.s8eNoxMgKwH" labelId="tfNOxOssLbl"
	  fieldRequired="true">


<!-- widget tfNOxOss -->
<s:textfield 
	
	
	name="appDataTipoGTDettModulo.s8eNoxMgKwH" id="widg_tfNOxOss"
maxlength="10"	disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','tfNOxOss')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wp8Modulo --></div>

			
	
	<div id="p_wp9" class="widgetsPanelBlock"><!-- startFragment:p_wp9 -->
	
	
<h4 class="wpLabel">9. esito della prova </h4>
<div class="widgetsPanel" id="wp9">
	
	<customtag:widgetsPanel id="wp9Tbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','pt9a')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.pt9a.label')}" labelFor="widg_pt9a" errorFor="appDataTipoGTDettModulo.s9aFlgMonossidoCarb" labelId="pt9aLbl"   >


<!-- widget pt9a -->
<s:property value="appDataTipoGTDettModulo.s9aFlgMonossidoCarb" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','cbFumosita')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.cbFumosita.label')}" labelFor="widg_cbFumosita" errorFor="appDataTipoGTDettModulo.s9bFlgFumosita" labelId="cbFumositaLbl"
	  fieldRequired="true">


<!-- widget cbFumosita -->
<s:select name="appDataTipoGTDettModulo.s9bFlgFumosita" id="widg_cbFumosita"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataElencoIndiceFumosita"
	  disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','cbFumosita')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','pt9c')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.pt9c.label')}" labelFor="widg_pt9c" errorFor="widg_pt9c" labelId="pt9cLbl"   >


<!-- widget pt9c -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','tf9Rend')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.tf9Rend.label')}" labelFor="widg_tf9Rend" errorFor="appDataTipoGTDettModulo.s9cRendMinCombustPerc" labelId="tf9RendLbl"
	  fieldRequired="true">


<!-- widget tf9Rend -->
<s:textfield 
	
	
	name="appDataTipoGTDettModulo.s9cRendMinCombustPerc" id="widg_tf9Rend"
maxlength="6"	disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','tf9Rend')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','pt9rilevato')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="" labelFor="widg_pt9rilevato" errorFor="appDataTipoGTDettModulo.valoreRilevatoPiuDue" labelId="pt9rilevatoLbl"   >


<!-- widget pt9rilevato -->
<s:property value="appDataTipoGTDettModulo.valoreRilevatoPiuDue" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','cbRenCombSuff')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="" labelFor="widg_cbRenCombSuff" errorFor="appDataTipoGTDettModulo.s9cFlgRendCombustSuff" labelId="cbRenCombSuffLbl"
	  >


<!-- widget cbRenCombSuff -->
<s:select name="appDataTipoGTDettModulo.s9cFlgRendCombustSuff" id="widg_cbRenCombSuff"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataElencoSufficienteNonSufficiente"
	  disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','cbRenCombSuff')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','pt9ossidi')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.pt9ossidi.label')}" labelFor="widg_pt9ossidi" errorFor="widg_pt9ossidi" labelId="pt9ossidiLbl"   >


<!-- widget pt9ossidi -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','tf9MinDi')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.tf9MinDi.label')}" labelFor="widg_tf9MinDi" errorFor="appDataTipoGTDettModulo.s9dOssidiAzotoLimMgKwH" labelId="tf9MinDiLbl"
	  fieldRequired="true">


<!-- widget tf9MinDi -->
<s:textfield 
	
	
	name="appDataTipoGTDettModulo.s9dOssidiAzotoLimMgKwH" id="widg_tf9MinDi"
maxlength="10"	disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','tf9MinDi')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','pt9rilevato2')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="" labelFor="widg_pt9rilevato2" errorFor="appDataTipoGTDettModulo.valoreRilevatoMenoVenti" labelId="pt9rilevato2Lbl"   >


<!-- widget pt9rilevato2 -->
<s:property value="appDataTipoGTDettModulo.valoreRilevatoMenoVenti" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','cbOssidiAzoto')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="" labelFor="widg_cbOssidiAzoto" errorFor="appDataTipoGTDettModulo.s9dFlgOssidiAzoto" labelId="cbOssidiAzotoLbl"
	  >


<!-- widget cbOssidiAzoto -->
<s:select name="appDataTipoGTDettModulo.s9dFlgOssidiAzoto" id="widg_cbOssidiAzoto"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataElencoRegolareIrregolare"
	  disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','cbOssidiAzoto')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','flgnorm')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.flgnorm.label')}" labelFor="widg_flgnorm" errorFor="appDataTipoGTDettModulo.s9eFlgRispettoNormativa" labelId="flgnormLbl"
	  >


<!-- widget flgnorm -->
<s:checkbox 
	
	
	name="appDataTipoGTDettModulo.s9eFlgRispettoNormativa" id="widg_flgnorm"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','flgnorm')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestRapProvaTipo1Dett','flgnorm')" >
	<s:hidden name="__checkbox_appDataTipoGTDettModulo.s9eFlgRispettoNormativa" id="__checkbox_widg_flgnorm" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','pt9check')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.pt9check.label')}" labelFor="widg_pt9check" errorFor="widg_pt9check" labelId="pt9checkLbl"   >


<!-- widget pt9check -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','7a')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.7a.label')}" labelFor="widg_7a" errorFor="appDataTipoGTDettModulo.s9eFlgNoRispetto7a" labelId="7aLbl"
	  >


<!-- widget 7a -->
<s:checkbox 
	
	
	name="appDataTipoGTDettModulo.s9eFlgNoRispetto7a" id="widg_7a"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','7a')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestRapProvaTipo1Dett','7a')" >
	<s:hidden name="__checkbox_appDataTipoGTDettModulo.s9eFlgNoRispetto7a" id="__checkbox_widg_7a" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','7b')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.7b.label')}" labelFor="widg_7b" errorFor="appDataTipoGTDettModulo.s9eFlgNoRispetto7b" labelId="7bLbl"
	  >


<!-- widget 7b -->
<s:checkbox 
	
	
	name="appDataTipoGTDettModulo.s9eFlgNoRispetto7b" id="widg_7b"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','7b')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestRapProvaTipo1Dett','7b')" >
	<s:hidden name="__checkbox_appDataTipoGTDettModulo.s9eFlgNoRispetto7b" id="__checkbox_widg_7b" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','9a')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.9a.label')}" labelFor="widg_9a" errorFor="appDataTipoGTDettModulo.s9eFlgNoRispetto9a" labelId="9aLbl"
	  >


<!-- widget 9a -->
<s:checkbox 
	
	
	name="appDataTipoGTDettModulo.s9eFlgNoRispetto9a" id="widg_9a"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','9a')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestRapProvaTipo1Dett','9a')" >
	<s:hidden name="__checkbox_appDataTipoGTDettModulo.s9eFlgNoRispetto9a" id="__checkbox_widg_9a" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','9b')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.9b.label')}" labelFor="widg_9b" errorFor="appDataTipoGTDettModulo.s9eFlgNoRispetto9b" labelId="9bLbl"
	  >


<!-- widget 9b -->
<s:checkbox 
	
	
	name="appDataTipoGTDettModulo.s9eFlgNoRispetto9b" id="widg_9b"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','9b')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestRapProvaTipo1Dett','9b')" >
	<s:hidden name="__checkbox_appDataTipoGTDettModulo.s9eFlgNoRispetto9b" id="__checkbox_widg_9b" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','9c')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.9c.label')}" labelFor="widg_9c" errorFor="appDataTipoGTDettModulo.s9eFlgNoRispetto9c" labelId="9cLbl"
	  >


<!-- widget 9c -->
<s:checkbox 
	
	
	name="appDataTipoGTDettModulo.s9eFlgNoRispetto9c" id="widg_9c"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','9c')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestRapProvaTipo1Dett','9c')" >
	<s:hidden name="__checkbox_appDataTipoGTDettModulo.s9eFlgNoRispetto9c" id="__checkbox_widg_9c" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','9d')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestRapProvaTipo1Dett.9d.label')}" labelFor="widg_9d" errorFor="appDataTipoGTDettModulo.s9eFlgNoRispetto9d" labelId="9dLbl"
	  >


<!-- widget 9d -->
<s:checkbox 
	
	
	name="appDataTipoGTDettModulo.s9eFlgNoRispetto9d" id="widg_9d"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','9d')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestRapProvaTipo1Dett','9d')" >
	<s:hidden name="__checkbox_appDataTipoGTDettModulo.s9eFlgNoRispetto9d" id="__checkbox_widg_9d" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wp9 --></div>

			
	
	<div id="p_cpFunGestRapProvaDett" class="commandPanelBlock"><!-- startFragment:p_cpFunGestRapProvaDett -->
	
	
<div class="commandPanel functional" id="cpFunGestRapProvaDett">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','bSalvaRapProvaDett')" >

	



<!-- widget bSalvaRapProvaDett -->
<s:submit name="widg_bSalvaRapProvaDett" id="widg_bSalvaRapProvaDett" method="handleBSalvaRapProvaDett_CLICKED"
	key="cpGestRapProvaTipo1Dett.bSalvaRapProvaDett.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','bSalvaRapProvaDett')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunGestRapProvaDett --></div>

			
	
	<div id="p_cpNavGestRapProvaDett" class="commandPanelBlock"><!-- startFragment:p_cpNavGestRapProvaDett -->
	
	
<div class="commandPanel navigation" id="cpNavGestRapProvaDett">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestRapProvaTipo1Dett','btnIndietro')" >

	



<!-- widget btnIndietro -->
<s:submit name="widg_btnIndietro" id="widg_btnIndietro" method="handleBtnIndietro_CLICKED"
	key="cpGestRapProvaTipo1Dett.btnIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestRapProvaTipo1Dett','btnIndietro')" />

	


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
