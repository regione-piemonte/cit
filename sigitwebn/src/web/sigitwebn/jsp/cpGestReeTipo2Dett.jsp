<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_ree_tipo2 -->
<!-- pageId:cpGestReeTipo2Dett -->

<s:form id="cpGestReeTipo2Dett" action="cpGestReeTipo2Dett" namespace="/base/gestisci_ree_tipo2" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestReeTipo2Dett_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpGestReeTipo2Dett','menu')" >

	


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

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestReeTipo2Dett_udpFunzionalita.jsp"></s:include>

	



			
	
	<div id="p_wpMenuTree" class="widgetsPanelBlock"><!-- startFragment:p_wpMenuTree -->
	
	

<div class="widgetsPanel" id="wpMenuTree">
	
	<customtag:widgetsPanel id="wpMenuTreeTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestReeTipo2Dett','menuRee')" >

	
<customtag:widgetsPanelColumn 
	 colSpan="2" >



	<csiuicore:ajaxify id="p_wpMenuTree" 
		widgetType="tree" 
		pageId="cpGestReeTipo2Dett"
		javascriptDetection="false">
	<customtag:tree
		name="appDatareeMenuTree"
		cssUlClass="tree"
        cssRootClass="treeRoot" cssFolderOpenClass="treeFolderOpen"
        cssFolderClosedClass="treeFolderClosed" cssDotClass="treeDot"
		linkOnTree="true" id="menuRee"
		selectionMultiplicity="none"
		requestURI="/sigitwebn/base/gestisci_ree_tipo2/cpGestReeTipo2Dett!handleMenuRee_CLICKED.do"
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
		
	
<h4 class="fpLabel"><s:text name="cpGestReeTipo2Dett.fpGestRee.label" /></h4>
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
	

	
	
<s:if test="isWidgetVisible('cpGestReeTipo2Dett','ptCodiceImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo2Dett.ptCodiceImpianto.label')}" labelFor="widg_ptCodiceImpianto" errorFor="appDataidentificativoImpianto.codiceImpianto" labelId="ptCodiceImpiantoLbl"  position="first" >


<!-- widget ptCodiceImpianto -->
<s:property value="appDataidentificativoImpianto.codiceImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestReeTipo2Dett','ptUbicazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo2Dett.ptUbicazione.label')}" labelFor="widg_ptUbicazione" errorFor="appDataidentificativoImpianto.ubicazione" labelId="ptUbicazioneLbl"  position="last" >


<!-- widget ptUbicazione -->
<s:property value="appDataidentificativoImpianto.ubicazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestReeTipo2Dett','ptResponsabile')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo2Dett.ptResponsabile.label')}" labelFor="widg_ptResponsabile" errorFor="appDataidentificativoImpianto.responsabile" labelId="ptResponsabileLbl"  position="first" >


<!-- widget ptResponsabile -->
<s:property value="appDataidentificativoImpianto.responsabile" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestReeTipo2Dett','wpInfoImpianto_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpInfoImpianto_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestReeTipo2Dett','ptDataControllo')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo2Dett.ptDataControllo.label')}" labelFor="widg_ptDataControllo" errorFor="appDataallegato.dataControllo" labelId="ptDataControlloLbl"  position="first" >


<!-- widget ptDataControllo -->
<s:property value="appDataallegato.dataControllo" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestReeTipo2Dett','ptBollino')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo2Dett.ptBollino.label')}" labelFor="widg_ptBollino" errorFor="appDataallegato.codiceBollino" labelId="ptBollinoLbl"  position="last" >


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

			
	
	<div id="p_wpE" class="widgetsPanelBlock"><!-- startFragment:p_wpE -->
	
	
<h4 class="wpLabel">E. Controllo e verifica energetica del gruppo frigo </h4>
<div class="widgetsPanel" id="wpE">
	
	<customtag:widgetsPanel id="wpETbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestReeTipo2Dett','ptComponente')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo2Dett.ptComponente.label')}" labelFor="widg_ptComponente" errorFor="appDatareeTipo2Dett.descComponente" labelId="ptComponenteLbl"   >


<!-- widget ptComponente -->
<s:property value="appDatareeTipo2Dett.descComponente" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2Dett','ptFabb')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo2Dett.ptFabb.label')}" labelFor="widg_ptFabb" errorFor="appDatareeTipo2Dett.marca" labelId="ptFabbLbl"   >


<!-- widget ptFabb -->
<s:property value="appDatareeTipo2Dett.marca" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2Dett','ptModello')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo2Dett.ptModello.label')}" labelFor="widg_ptModello" errorFor="appDatareeTipo2Dett.modello" labelId="ptModelloLbl"   >


<!-- widget ptModello -->
<s:property value="appDatareeTipo2Dett.modello" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2Dett','ptMatricola')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo2Dett.ptMatricola.label')}" labelFor="widg_ptMatricola" errorFor="appDatareeTipo2Dett.matricola" labelId="ptMatricolaLbl"   >


<!-- widget ptMatricola -->
<s:property value="appDatareeTipo2Dett.matricola" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2Dett','ptTipo')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo2Dett.ptTipo.label')}" labelFor="widg_ptTipo" errorFor="appDatareeTipo2Dett.tipo" labelId="ptTipoLbl"   >


<!-- widget ptTipo -->
<s:property value="appDatareeTipo2Dett.tipo" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2Dett','ptCombustibile')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo2Dett.ptCombustibile.label')}" labelFor="widg_ptCombustibile" errorFor="appDatareeTipo2Dett.combustibile" labelId="ptCombustibileLbl"   >


<!-- widget ptCombustibile -->
<s:property value="appDatareeTipo2Dett.combustibile" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2Dett','ptCircuiti')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo2Dett.ptCircuiti.label')}" labelFor="widg_ptCircuiti" errorFor="appDatareeTipo2Dett.nCircuiti" labelId="ptCircuitiLbl"   >


<!-- widget ptCircuiti -->
<s:property value="appDatareeTipo2Dett.nCircuiti" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2Dett','ptPotFrig')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo2Dett.ptPotFrig.label')}" labelFor="widg_ptPotFrig" errorFor="appDatareeTipo2Dett.raffPotenzaKw" labelId="ptPotFrigLbl"   >


<!-- widget ptPotFrig -->
<s:property value="appDatareeTipo2Dett.raffPotenzaKw" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2Dett','ptPotTerm')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo2Dett.ptPotTerm.label')}" labelFor="widg_ptPotTerm" errorFor="appDatareeTipo2Dett.riscPotenzaKw" labelId="ptPotTermLbl"   >


<!-- widget ptPotTerm -->
<s:property value="appDatareeTipo2Dett.riscPotenzaKw" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2Dett','rbModalita')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo2Dett.rbModalita.label')}" labelFor="widg_rbModalita" errorFor="appDatareeTipo2Dett.flgModProva" labelId="rbModalitaLbl"
	  fieldRequired="true">


<!-- widget rbModalita -->

	
<div id="appDatareeTipo2Dett.flgModProva" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbRaff" name="appDatareeTipo2Dett.flgModProva"
	list="#{'RAF':'Raffrescamento'}"
	disabled="isWidgetDisabled('cpGestReeTipo2Dett','rbModalita')"
	cssClass="radio"
	
	/> <label  for="widg_rbRaffRAF"><s:text name="cpGestReeTipo2Dett.rbModalita.rbRaff.label" /></label>








<s:radio
	
	
	id="widg_rbRisc" name="appDatareeTipo2Dett.flgModProva"
	list="#{'RIS':'Riscaldamento'}"
	disabled="isWidgetDisabled('cpGestReeTipo2Dett','rbModalita')"
	cssClass="radio"
	
	/> <label  for="widg_rbRiscRIS"><s:text name="cpGestReeTipo2Dett.rbModalita.rbRisc.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2Dett','rbAssPerd')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo2Dett.rbAssPerd.label')}" labelFor="widg_rbAssPerd" errorFor="appDatareeTipo2Dett.flgPerditaGas" labelId="rbAssPerdLbl"
	  fieldRequired="true">


<!-- widget rbAssPerd -->

	
<div id="appDatareeTipo2Dett.flgPerditaGas" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbAssPerdIdSI" name="appDatareeTipo2Dett.flgPerditaGas"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo2Dett','rbAssPerd')"
	cssClass="radio"
	
	/> <label  for="widg_rbAssPerdIdSI1"><s:text name="cpGestReeTipo2Dett.rbAssPerd.rbAssPerdIdSI.label" /></label>








<s:radio
	
title=""	
	id="widg_rbAssPerdIdNO" name="appDatareeTipo2Dett.flgPerditaGas"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo2Dett','rbAssPerd')"
	cssClass="radio"
	
	/> <label  for="widg_rbAssPerdIdNO0"><s:text name="cpGestReeTipo2Dett.rbAssPerd.rbAssPerdIdNO.label" /></label>








<s:radio
	
title=""	
	id="widg_rbAssPerdIdNC" name="appDatareeTipo2Dett.flgPerditaGas"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestReeTipo2Dett','rbAssPerd')"
	cssClass="radio"
	
	/> <label  for="widg_rbAssPerdIdNC2"><s:text name="cpGestReeTipo2Dett.rbAssPerd.rbAssPerdIdNC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2Dett','rbLdete')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo2Dett.rbLdete.label')}" labelFor="widg_rbLdete" errorFor="appDatareeTipo2Dett.flgLeakDirector" labelId="rbLdeteLbl"
	  fieldRequired="true">


<!-- widget rbLdete -->

	
<div id="appDatareeTipo2Dett.flgLeakDirector" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbLeakDIdSI" name="appDatareeTipo2Dett.flgLeakDirector"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo2Dett','rbLdete')"
	cssClass="radio"
	
	/> <label  for="widg_rbLeakDIdSI1"><s:text name="cpGestReeTipo2Dett.rbLdete.rbLeakDIdSI.label" /></label>








<s:radio
	
title=""	
	id="widg_rbLeakDIdNO" name="appDatareeTipo2Dett.flgLeakDirector"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo2Dett','rbLdete')"
	cssClass="radio"
	
	/> <label  for="widg_rbLeakDIdNO0"><s:text name="cpGestReeTipo2Dett.rbLdete.rbLeakDIdNO.label" /></label>








<s:radio
	
title=""	
	id="widg_rbLeakDIdNC" name="appDatareeTipo2Dett.flgLeakDirector"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestReeTipo2Dett','rbLdete')"
	cssClass="radio"
	
	/> <label  for="widg_rbLeakDIdNC2"><s:text name="cpGestReeTipo2Dett.rbLdete.rbLeakDIdNC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2Dett','rbRilInd')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo2Dett.rbRilInd.label')}" labelFor="widg_rbRilInd" errorFor="appDatareeTipo2Dett.flgParamTermodinam" labelId="rbRilIndLbl"
	  fieldRequired="true">


<!-- widget rbRilInd -->

	
<div id="appDatareeTipo2Dett.flgParamTermodinam" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbRilIndIdSI" name="appDatareeTipo2Dett.flgParamTermodinam"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo2Dett','rbRilInd')"
	cssClass="radio"
	
	/> <label  for="widg_rbRilIndIdSI1"><s:text name="cpGestReeTipo2Dett.rbRilInd.rbRilIndIdSI.label" /></label>








<s:radio
	
title=""	
	id="widg_rbRilIndIdNO" name="appDatareeTipo2Dett.flgParamTermodinam"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo2Dett','rbRilInd')"
	cssClass="radio"
	
	/> <label  for="widg_rbRilIndIdNO0"><s:text name="cpGestReeTipo2Dett.rbRilInd.rbRilIndIdNO.label" /></label>








<s:radio
	
title=""	
	id="widg_rbRilIndIdNC" name="appDatareeTipo2Dett.flgParamTermodinam"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestReeTipo2Dett','rbRilInd')"
	cssClass="radio"
	
	/> <label  for="widg_rbRilIndIdNC2"><s:text name="cpGestReeTipo2Dett.rbRilInd.rbRilIndIdNC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2Dett','rbSca')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo2Dett.rbSca.label')}" labelFor="widg_rbSca" errorFor="appDatareeTipo2Dett.flgIncrostazioni" labelId="rbScaLbl"
	  fieldRequired="true">


<!-- widget rbSca -->

	
<div id="appDatareeTipo2Dett.flgIncrostazioni" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbScaIdSI" name="appDatareeTipo2Dett.flgIncrostazioni"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo2Dett','rbSca')"
	cssClass="radio"
	
	/> <label  for="widg_rbScaIdSI1"><s:text name="cpGestReeTipo2Dett.rbSca.rbScaIdSI.label" /></label>








<s:radio
	
title=""	
	id="widg_rbScaIdNO" name="appDatareeTipo2Dett.flgIncrostazioni"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo2Dett','rbSca')"
	cssClass="radio"
	
	/> <label  for="widg_rbScaIdNO0"><s:text name="cpGestReeTipo2Dett.rbSca.rbScaIdNO.label" /></label>








<s:radio
	
title=""	
	id="widg_rbScaIdNC" name="appDatareeTipo2Dett.flgIncrostazioni"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestReeTipo2Dett','rbSca')"
	cssClass="radio"
	
	/> <label  for="widg_rbScaIdNC2"><s:text name="cpGestReeTipo2Dett.rbSca.rbScaIdNC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpE --></div>

			
	
	<div id="p_wpElencoNonCompilati" class="widgetsPanelBlock"><!-- startFragment:p_wpElencoNonCompilati -->
	
	
<h4 class="wpLabel">elenco circuiti da compilare per procedere </h4>
<div class="widgetsPanel" id="wpElencoNonCompilati">
	
	<customtag:widgetsPanel id="wpElencoNonCompilatiTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestReeTipo2Dett','ptElencoCircuiti')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo2Dett.ptElencoCircuiti.label')}" labelFor="widg_ptElencoCircuiti" errorFor="appDatareeTipo2Dett.elencoCircuitiNonComp" labelId="ptElencoCircuitiLbl"   >


<!-- widget ptElencoCircuiti -->
<s:property value="appDatareeTipo2Dett.elencoCircuitiNonComp" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2Dett','cbCircuiti')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo2Dett.cbCircuiti.label')}" labelFor="widg_cbCircuiti" errorFor="appDatamoduloSelezionato" labelId="cbCircuitiLbl"
	  >


<!-- widget cbCircuiti -->
	<csiuicore:ajaxify id="p_wpCircuito,p_stdMsgRee" 
		widgetType="combo" 
		requestUri="/sigitwebn/base/gestisci_ree_tipo2/cpGestReeTipo2Dett!handleCbCircuiti_VALUE_CHANGED.do"
		pageId="cpGestReeTipo2Dett"
		formName="cpGestReeTipo2Dett"
		javascriptDetection="false"
		nameSpace="/base/gestisci_ree_tipo2">

<s:url id="widg_cbCircuitiurlComboBoxValueChange"
   action="/sigitwebn/cpGestReeTipo2Dett!handleCbCircuiti_VALUE_CHANGED" namespace="/base/gestisci_ree_tipo2"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatamoduloSelezionato" id="widg_cbCircuiti"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoModuli"
	  disabled="isWidgetDisabled('cpGestReeTipo2Dett','cbCircuiti')"
	  listKey="code"
	  listValue="description"
	  onclick="onCBClick(this,'confermacbCircuiti','conferma','%{widg_cbCircuitiurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbCircuiti','conferma','%{widg_cbCircuitiurlComboBoxValueChange}')" 
	  />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpElencoNonCompilati --></div>

			
	
	<div id="p_wpCircuito" class="widgetsPanelBlock"><!-- startFragment:p_wpCircuito -->
	
	
<h4 class="wpLabel">compila circuito </h4>
<div class="widgetsPanel" id="wpCircuito">
	
	<customtag:widgetsPanel id="wpCircuitoTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestReeTipo2Dett','ptNCircuito')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo2Dett.ptNCircuito.label')}" labelFor="widg_ptNCircuito" errorFor="appDatareeTipo2DettCircuito.numCircuito" labelId="ptNCircuitoLbl"   tdStyleClass="numbers">


<!-- widget ptNCircuito -->
<s:property value="appDatareeTipo2DettCircuito.numCircuito" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2Dett','tfSurrisc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo2Dett.tfSurrisc.label')}" labelFor="widg_tfSurrisc" errorFor="appDatareeTipo2DettCircuito.surrisc" labelId="tfSurriscLbl"
	  >


<!-- widget tfSurrisc -->
<s:textfield 
	
	
	name="appDatareeTipo2DettCircuito.surrisc" id="widg_tfSurrisc"
maxlength="8"	disabled="isWidgetDisabled('cpGestReeTipo2Dett','tfSurrisc')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2Dett','tfSottoraffredd')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo2Dett.tfSottoraffredd.label')}" labelFor="widg_tfSottoraffredd" errorFor="appDatareeTipo2DettCircuito.sottoraffredd" labelId="tfSottoraffreddLbl"
	  >


<!-- widget tfSottoraffredd -->
<s:textfield 
	
	
	name="appDatareeTipo2DettCircuito.sottoraffredd" id="widg_tfSottoraffredd"
maxlength="8"	disabled="isWidgetDisabled('cpGestReeTipo2Dett','tfSottoraffredd')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2Dett','tfCondensazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo2Dett.tfCondensazione.label')}" labelFor="widg_tfCondensazione" errorFor="appDatareeTipo2DettCircuito.condensazione" labelId="tfCondensazioneLbl"
	  >


<!-- widget tfCondensazione -->
<s:textfield 
	
	
	name="appDatareeTipo2DettCircuito.condensazione" id="widg_tfCondensazione"
maxlength="8"	disabled="isWidgetDisabled('cpGestReeTipo2Dett','tfCondensazione')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2Dett','tfEvaporazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo2Dett.tfEvaporazione.label')}" labelFor="widg_tfEvaporazione" errorFor="appDatareeTipo2DettCircuito.evaporazione" labelId="tfEvaporazioneLbl"
	  >


<!-- widget tfEvaporazione -->
<s:textfield 
	
	
	name="appDatareeTipo2DettCircuito.evaporazione" id="widg_tfEvaporazione"
maxlength="8"	disabled="isWidgetDisabled('cpGestReeTipo2Dett','tfEvaporazione')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2Dett','tfInLatoEst')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo2Dett.tfInLatoEst.label')}" labelFor="widg_tfInLatoEst" errorFor="appDatareeTipo2DettCircuito.inLatoEst" labelId="tfInLatoEstLbl"
	  >


<!-- widget tfInLatoEst -->
<s:textfield 
	
	
	name="appDatareeTipo2DettCircuito.inLatoEst" id="widg_tfInLatoEst"
maxlength="8"	disabled="isWidgetDisabled('cpGestReeTipo2Dett','tfInLatoEst')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2Dett','tfOutLatoEst')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo2Dett.tfOutLatoEst.label')}" labelFor="widg_tfOutLatoEst" errorFor="appDatareeTipo2DettCircuito.outLatoEst" labelId="tfOutLatoEstLbl"
	  >


<!-- widget tfOutLatoEst -->
<s:textfield 
	
	
	name="appDatareeTipo2DettCircuito.outLatoEst" id="widg_tfOutLatoEst"
maxlength="8"	disabled="isWidgetDisabled('cpGestReeTipo2Dett','tfOutLatoEst')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2Dett','tfInLatoUtenze')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo2Dett.tfInLatoUtenze.label')}" labelFor="widg_tfInLatoUtenze" errorFor="appDatareeTipo2DettCircuito.inLatoUtenze" labelId="tfInLatoUtenzeLbl"
	  >


<!-- widget tfInLatoUtenze -->
<s:textfield 
	
	
	name="appDatareeTipo2DettCircuito.inLatoUtenze" id="widg_tfInLatoUtenze"
maxlength="8"	disabled="isWidgetDisabled('cpGestReeTipo2Dett','tfInLatoUtenze')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2Dett','tfOutLatoUtenze')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo2Dett.tfOutLatoUtenze.label')}" labelFor="widg_tfOutLatoUtenze" errorFor="appDatareeTipo2DettCircuito.outLatoUtenze" labelId="tfOutLatoUtenzeLbl"
	  >


<!-- widget tfOutLatoUtenze -->
<s:textfield 
	
	
	name="appDatareeTipo2DettCircuito.outLatoUtenze" id="widg_tfOutLatoUtenze"
maxlength="8"	disabled="isWidgetDisabled('cpGestReeTipo2Dett','tfOutLatoUtenze')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2Dett','tfTorreOutFluido')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo2Dett.tfTorreOutFluido.label')}" labelFor="widg_tfTorreOutFluido" errorFor="appDatareeTipo2DettCircuito.torreOutFluido" labelId="tfTorreOutFluidoLbl"
	  >


<!-- widget tfTorreOutFluido -->
<s:textfield 
	
	
	name="appDatareeTipo2DettCircuito.torreOutFluido" id="widg_tfTorreOutFluido"
maxlength="8"	disabled="isWidgetDisabled('cpGestReeTipo2Dett','tfTorreOutFluido')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2Dett','tfTorreBulboUmido')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo2Dett.tfTorreBulboUmido.label')}" labelFor="widg_tfTorreBulboUmido" errorFor="appDatareeTipo2DettCircuito.torreBulboUmido" labelId="tfTorreBulboUmidoLbl"
	  >


<!-- widget tfTorreBulboUmido -->
<s:textfield 
	
	
	name="appDatareeTipo2DettCircuito.torreBulboUmido" id="widg_tfTorreBulboUmido"
maxlength="8"	disabled="isWidgetDisabled('cpGestReeTipo2Dett','tfTorreBulboUmido')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2Dett','tfScambiatoreInExt')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo2Dett.tfScambiatoreInExt.label')}" labelFor="widg_tfScambiatoreInExt" errorFor="appDatareeTipo2DettCircuito.scambiatoreInExt" labelId="tfScambiatoreInExtLbl"
	  >


<!-- widget tfScambiatoreInExt -->
<s:textfield 
	
	
	name="appDatareeTipo2DettCircuito.scambiatoreInExt" id="widg_tfScambiatoreInExt"
maxlength="8"	disabled="isWidgetDisabled('cpGestReeTipo2Dett','tfScambiatoreInExt')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2Dett','tfScambiatoreOutExt')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo2Dett.tfScambiatoreOutExt.label')}" labelFor="widg_tfScambiatoreOutExt" errorFor="appDatareeTipo2DettCircuito.scambiatoreOutExt" labelId="tfScambiatoreOutExtLbl"
	  >


<!-- widget tfScambiatoreOutExt -->
<s:textfield 
	
	
	name="appDatareeTipo2DettCircuito.scambiatoreOutExt" id="widg_tfScambiatoreOutExt"
maxlength="8"	disabled="isWidgetDisabled('cpGestReeTipo2Dett','tfScambiatoreOutExt')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2Dett','tfScambiatoreInMacchina')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo2Dett.tfScambiatoreInMacchina.label')}" labelFor="widg_tfScambiatoreInMacchina" errorFor="appDatareeTipo2DettCircuito.scambiatoreInMacchina" labelId="tfScambiatoreInMacchinaLbl"
	  >


<!-- widget tfScambiatoreInMacchina -->
<s:textfield 
	
	
	name="appDatareeTipo2DettCircuito.scambiatoreInMacchina" id="widg_tfScambiatoreInMacchina"
maxlength="8"	disabled="isWidgetDisabled('cpGestReeTipo2Dett','tfScambiatoreInMacchina')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2Dett','tfScambiatoreOutMacchina')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo2Dett.tfScambiatoreOutMacchina.label')}" labelFor="widg_tfScambiatoreOutMacchina" errorFor="appDatareeTipo2DettCircuito.scambiatoreOutMacchina" labelId="tfScambiatoreOutMacchinaLbl"
	  >


<!-- widget tfScambiatoreOutMacchina -->
<s:textfield 
	
	
	name="appDatareeTipo2DettCircuito.scambiatoreOutMacchina" id="widg_tfScambiatoreOutMacchina"
maxlength="8"	disabled="isWidgetDisabled('cpGestReeTipo2Dett','tfScambiatoreOutMacchina')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2Dett','tfPotenzaAssorbitaKw')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo2Dett.tfPotenzaAssorbitaKw.label')}" labelFor="widg_tfPotenzaAssorbitaKw" errorFor="appDatareeTipo2DettCircuito.potenzaAssorbitaKw" labelId="tfPotenzaAssorbitaKwLbl"
	  >


<!-- widget tfPotenzaAssorbitaKw -->
<s:textfield 
	
title=""	
	name="appDatareeTipo2DettCircuito.potenzaAssorbitaKw" id="widg_tfPotenzaAssorbitaKw"
maxlength="8"	disabled="isWidgetDisabled('cpGestReeTipo2Dett','tfPotenzaAssorbitaKw')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2Dett','rbFlgPulizaFiltri')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo2Dett.rbFlgPulizaFiltri.label')}" labelFor="widg_rbFlgPulizaFiltri" errorFor="appDatareeTipo2DettCircuito.flgPulizaFiltri" labelId="rbFlgPulizaFiltriLbl"
	  >


<!-- widget rbFlgPulizaFiltri -->

	
<div id="appDatareeTipo2DettCircuito.flgPulizaFiltri" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbFlgPulizaFiltriSI" name="appDatareeTipo2DettCircuito.flgPulizaFiltri"
	list="#{'true':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo2Dett','rbFlgPulizaFiltri')"
	cssClass="radio"
	
	/> <label  for="widg_rbFlgPulizaFiltriSItrue"><s:text name="cpGestReeTipo2Dett.rbFlgPulizaFiltri.rbFlgPulizaFiltriSI.label" /></label>








<s:radio
	
	
	id="widg_rbFlgPulizaFiltriNO" name="appDatareeTipo2DettCircuito.flgPulizaFiltri"
	list="#{'false':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo2Dett','rbFlgPulizaFiltri')"
	cssClass="radio"
	
	/> <label  for="widg_rbFlgPulizaFiltriNOfalse"><s:text name="cpGestReeTipo2Dett.rbFlgPulizaFiltri.rbFlgPulizaFiltriNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2Dett','rbFlgVerificaSuperata')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo2Dett.rbFlgVerificaSuperata.label')}" labelFor="widg_rbFlgVerificaSuperata" errorFor="appDatareeTipo2DettCircuito.flgVerificaSuperata" labelId="rbFlgVerificaSuperataLbl"
	  >


<!-- widget rbFlgVerificaSuperata -->

	
<div id="appDatareeTipo2DettCircuito.flgVerificaSuperata" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbFlgVerificaSuperataSI" name="appDatareeTipo2DettCircuito.flgVerificaSuperata"
	list="#{'true':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo2Dett','rbFlgVerificaSuperata')"
	cssClass="radio"
	
	/> <label  for="widg_rbFlgVerificaSuperataSItrue"><s:text name="cpGestReeTipo2Dett.rbFlgVerificaSuperata.rbFlgVerificaSuperataSI.label" /></label>








<s:radio
	
	
	id="widg_rbFlgVerificaSuperataNO" name="appDatareeTipo2DettCircuito.flgVerificaSuperata"
	list="#{'false':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo2Dett','rbFlgVerificaSuperata')"
	cssClass="radio"
	
	/> <label  for="widg_rbFlgVerificaSuperataNOfalse"><s:text name="cpGestReeTipo2Dett.rbFlgVerificaSuperata.rbFlgVerificaSuperataNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo2Dett','cDataRipristino')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo2Dett.cDataRipristino.label')}" labelFor="widg_cDataRipristino" errorFor="appDatareeTipo2DettCircuito.dataRipristino" labelId="cDataRipristinoLbl"
	  >


<!-- widget cDataRipristino -->
<s:textfield 
	
	
	name="appDatareeTipo2DettCircuito.dataRipristino" id="widg_cDataRipristino"
	disabled="isWidgetDisabled('cpGestReeTipo2Dett','cDataRipristino')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpCircuito --></div>

			
	
	<div id="p_cpFunGestReeDett" class="commandPanelBlock"><!-- startFragment:p_cpFunGestReeDett -->
	
	
<div class="commandPanel functional" id="cpFunGestReeDett">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestReeTipo2Dett','bSalvaReeDett')" >

	



<!-- widget bSalvaReeDett -->
<s:submit name="widg_bSalvaReeDett" id="widg_bSalvaReeDett" method="handleBSalvaReeDett_CLICKED"
	key="cpGestReeTipo2Dett.bSalvaReeDett.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestReeTipo2Dett','bSalvaReeDett')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunGestReeDett --></div>

			
	
	<div id="p_cpNavGestReeDett" class="commandPanelBlock"><!-- startFragment:p_cpNavGestReeDett -->
	
	
<div class="commandPanel navigation" id="cpNavGestReeDett">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestReeTipo2Dett','btnIndietro')" >

	



<!-- widget btnIndietro -->
<s:submit name="widg_btnIndietro" id="widg_btnIndietro" method="handleBtnIndietro_CLICKED"
	key="cpGestReeTipo2Dett.btnIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestReeTipo2Dett','btnIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavGestReeDett --></div>

	

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
