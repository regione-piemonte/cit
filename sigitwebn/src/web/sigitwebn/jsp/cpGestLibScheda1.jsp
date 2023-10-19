<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_libretto_scheda1 -->
<!-- pageId:cpGestLibScheda1 -->

<s:form id="cpGestLibScheda1" action="cpGestLibScheda1" namespace="/base/gestisci_libretto_scheda1" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestLibScheda1_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpGestLibScheda1','menu')" >

	


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

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestLibScheda1_udpFunzionalita.jsp"></s:include>

	



			
	
	<div id="p_wpMenuTree" class="widgetsPanelBlock"><!-- startFragment:p_wpMenuTree -->
	
	

<div class="widgetsPanel" id="wpMenuTree">
	
	<customtag:widgetsPanel id="wpMenuTreeTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda1','menuLibretto')" >

	
<customtag:widgetsPanelColumn 
	 colSpan="2" >



	<csiuicore:ajaxify id="p_fpLeftMenu" 
		widgetType="tree" 
		pageId="cpGestLibScheda1"
		javascriptDetection="false">
	<customtag:tree
		name="appDatalibrettoMenuTree"
		cssUlClass="tree"
        cssRootClass="treeRoot" cssFolderOpenClass="treeFolderOpen"
        cssFolderClosedClass="treeFolderClosed" cssDotClass="treeDot"
		linkOnTree="true" id="menuLibretto"
		selectionMultiplicity="none"
		requestURI="/sigitwebn/base/gestisci_libretto_scheda1/cpGestLibScheda1!handleMenuLibretto_CLICKED.do"
		nameSpace="/base/gestisci_libretto_scheda1"
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

	
	

	
	
			
	
	<div id="p_fpSchedaImpianto" class="formPanelBlock"><!-- startFragment:p_fpSchedaImpianto -->
		
	
<h4 class="fpLabel"><s:text name="cpGestLibScheda1.fpSchedaImpianto.label" /></h4>
<div class="formPanel" id="fpSchedaImpianto">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpSchedaImpianto --></div>

			
	
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
		percentCols="25,25,15,35">
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda1','ptCodiceImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda1.ptCodiceImpianto.label')}" labelFor="widg_ptCodiceImpianto" errorFor="appDataidentificativoImpianto.codiceImpianto" labelId="ptCodiceImpiantoLbl"  position="first" >


<!-- widget ptCodiceImpianto -->
<s:property value="appDataidentificativoImpianto.codiceImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','ptUbicazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda1.ptUbicazione.label')}" labelFor="widg_ptUbicazione" errorFor="appDataidentificativoImpianto.ubicazione" labelId="ptUbicazioneLbl"  position="last" >


<!-- widget ptUbicazione -->
<s:property value="appDataidentificativoImpianto.ubicazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','ptResponsabile')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda1.ptResponsabile.label')}" labelFor="widg_ptResponsabile" errorFor="appDataidentificativoImpianto.responsabile" labelId="ptResponsabileLbl"  position="first" >


<!-- widget ptResponsabile -->
<s:property value="appDataidentificativoImpianto.responsabile" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','wpInfoImpianto_2_2_fictitious_')" >

	
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

			
	
	<div id="p_wpScheda1TipoIntervento" class="widgetsPanelBlock"><!-- startFragment:p_wpScheda1TipoIntervento -->
	
	
<h4 class="wpLabel">1.1 Tipologia Intervento </h4>
<div class="widgetsPanel" id="wpScheda1TipoIntervento">
	
	<customtag:widgetsPanel id="wpScheda1TipoInterventoTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda1','cDataIntervento')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda1.cDataIntervento.label')}" labelFor="widg_cDataIntervento" errorFor="appDatascheda1.dataIntervento" labelId="cDataInterventoLbl"
	position="first"  >


<!-- widget cDataIntervento -->
<s:textfield 
	
	
	name="appDatascheda1.dataIntervento" id="widg_cDataIntervento"
	disabled="isWidgetDisabled('cpGestLibScheda1','cDataIntervento')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','cbTipoIntervento')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda1.cbTipoIntervento.label')}" labelFor="widg_cbTipoIntervento" errorFor="appDatascheda1.idTipoIntervento" labelId="cbTipoInterventoLbl"
	position="first"  fieldRequired="true">


<!-- widget cbTipoIntervento -->
<s:select name="appDatascheda1.idTipoIntervento" id="widg_cbTipoIntervento"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTipoIntervento"
	  disabled="isWidgetDisabled('cpGestLibScheda1','cbTipoIntervento')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpScheda1TipoIntervento --></div>

			
	
	<div id="p_wpScheda1DestinazioneEdificio" class="widgetsPanelBlock"><!-- startFragment:p_wpScheda1DestinazioneEdificio -->
	
	
<h4 class="wpLabel">1.2 Destinazione dell'edificio </h4>
<div class="widgetsPanel" id="wpScheda1DestinazioneEdificio">
	
	<customtag:widgetsPanel id="wpScheda1DestinazioneEdificioTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda1','cbSingUnitImmob')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda1.cbSingUnitImmob.label')}" labelFor="widg_cbSingUnitImmob" errorFor="appDatascheda1.flagSingolaUnita" labelId="cbSingUnitImmobLbl"
	position="first"  >


<!-- widget cbSingUnitImmob -->
<s:checkbox 
	
	
	name="appDatascheda1.flagSingolaUnita" id="widg_cbSingUnitImmob"
	disabled="isWidgetDisabled('cpGestLibScheda1','cbSingUnitImmob')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda1','cbSingUnitImmob')" >
	<s:hidden name="__checkbox_appDatascheda1.flagSingolaUnita" id="__checkbox_widg_cbSingUnitImmob" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','cbCategoria')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda1.cbCategoria.label')}" labelFor="widg_cbCategoria" errorFor="appDatascheda1.categoria" labelId="cbCategoriaLbl"
	position="first"  fieldRequired="true">


<!-- widget cbCategoria -->
<s:select name="appDatascheda1.categoria" id="widg_cbCategoria"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoCategoria"
	  disabled="isWidgetDisabled('cpGestLibScheda1','cbCategoria')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','tfVolumeLordoRiscaldato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda1.tfVolumeLordoRiscaldato.label')}" labelFor="widg_tfVolumeLordoRiscaldato" errorFor="appDatascheda1.volumeLordoRiscaldato" labelId="tfVolumeLordoRiscaldatoLbl"
	position="first"  >


<!-- widget tfVolumeLordoRiscaldato -->
<s:textfield 
	
	
	name="appDatascheda1.volumeLordoRiscaldato" id="widg_tfVolumeLordoRiscaldato"
maxlength="10"	disabled="isWidgetDisabled('cpGestLibScheda1','tfVolumeLordoRiscaldato')"
	size="25" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','tfVolumeLordoRaffrescato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda1.tfVolumeLordoRaffrescato.label')}" labelFor="widg_tfVolumeLordoRaffrescato" errorFor="appDatascheda1.volumeLordoRaffrescato" labelId="tfVolumeLordoRaffrescatoLbl"
	position="first"  >


<!-- widget tfVolumeLordoRaffrescato -->
<s:textfield 
	
	
	name="appDatascheda1.volumeLordoRaffrescato" id="widg_tfVolumeLordoRaffrescato"
maxlength="10"	disabled="isWidgetDisabled('cpGestLibScheda1','tfVolumeLordoRaffrescato')"
	size="25" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpScheda1DestinazioneEdificio --></div>

			
	
	<div id="p_wpScheda1ServiziImpianto" class="widgetsPanelBlock"><!-- startFragment:p_wpScheda1ServiziImpianto -->
	
	
<h4 class="wpLabel">1.3 Impianto Termico destinato a soddisfare i seguenti servizi * </h4>
<div class="widgetsPanel" id="wpScheda1ServiziImpianto">
	
	<customtag:widgetsPanel id="wpScheda1ServiziImpiantoTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		percentCols="25,25,15,35">
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda1','cbProduzioneACS')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda1.cbProduzioneACS.label')}" labelFor="widg_cbProduzioneACS" errorFor="appDatascheda1.flagPotenzaUtileProduzioneACS" labelId="cbProduzioneACSLbl"
	position="first"  >


<!-- widget cbProduzioneACS -->
<s:checkbox 
	
	
	name="appDatascheda1.flagPotenzaUtileProduzioneACS" id="widg_cbProduzioneACS"
	disabled="isWidgetDisabled('cpGestLibScheda1','cbProduzioneACS')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda1','cbProduzioneACS')" >
	<s:hidden name="__checkbox_appDatascheda1.flagPotenzaUtileProduzioneACS" id="__checkbox_widg_cbProduzioneACS" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','tfPotenzaUtileACS')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda1.tfPotenzaUtileACS.label')}" labelFor="widg_tfPotenzaUtileACS" errorFor="appDatascheda1.potenzaUtileProduzioneACS" labelId="tfPotenzaUtileACSLbl"
	position="last"  >


<!-- widget tfPotenzaUtileACS -->
<s:textfield 
	
	
	name="appDatascheda1.potenzaUtileProduzioneACS" id="widg_tfPotenzaUtileACS"
maxlength="9"	disabled="isWidgetDisabled('cpGestLibScheda1','tfPotenzaUtileACS')"
	size="25" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','cbClimatizzazioneInvernale')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda1.cbClimatizzazioneInvernale.label')}" labelFor="widg_cbClimatizzazioneInvernale" errorFor="appDatascheda1.flagPotenzaUtileClimatInvernale" labelId="cbClimatizzazioneInvernaleLbl"
	position="first"  >


<!-- widget cbClimatizzazioneInvernale -->
<s:checkbox 
	
	
	name="appDatascheda1.flagPotenzaUtileClimatInvernale" id="widg_cbClimatizzazioneInvernale"
	disabled="isWidgetDisabled('cpGestLibScheda1','cbClimatizzazioneInvernale')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda1','cbClimatizzazioneInvernale')" >
	<s:hidden name="__checkbox_appDatascheda1.flagPotenzaUtileClimatInvernale" id="__checkbox_widg_cbClimatizzazioneInvernale" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','tfPotenzaUtileClimatInvernale')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda1.tfPotenzaUtileClimatInvernale.label')}" labelFor="widg_tfPotenzaUtileClimatInvernale" errorFor="appDatascheda1.potenzaUtileClimatInvernale" labelId="tfPotenzaUtileClimatInvernaleLbl"
	position="last"  >


<!-- widget tfPotenzaUtileClimatInvernale -->
<s:textfield 
	
	
	name="appDatascheda1.potenzaUtileClimatInvernale" id="widg_tfPotenzaUtileClimatInvernale"
maxlength="9"	disabled="isWidgetDisabled('cpGestLibScheda1','tfPotenzaUtileClimatInvernale')"
	size="25" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','cbClimatizzazioneEstiva')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda1.cbClimatizzazioneEstiva.label')}" labelFor="widg_cbClimatizzazioneEstiva" errorFor="appDatascheda1.flagPotenzaUtileClimatEstiva" labelId="cbClimatizzazioneEstivaLbl"
	position="first"  >


<!-- widget cbClimatizzazioneEstiva -->
<s:checkbox 
	
	
	name="appDatascheda1.flagPotenzaUtileClimatEstiva" id="widg_cbClimatizzazioneEstiva"
	disabled="isWidgetDisabled('cpGestLibScheda1','cbClimatizzazioneEstiva')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda1','cbClimatizzazioneEstiva')" >
	<s:hidden name="__checkbox_appDatascheda1.flagPotenzaUtileClimatEstiva" id="__checkbox_widg_cbClimatizzazioneEstiva" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','tfPotenzaUtileClimatEstiva')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda1.tfPotenzaUtileClimatEstiva.label')}" labelFor="widg_tfPotenzaUtileClimatEstiva" errorFor="appDatascheda1.potenzaUtileClimatEstiva" labelId="tfPotenzaUtileClimatEstivaLbl"
	position="last"  >


<!-- widget tfPotenzaUtileClimatEstiva -->
<s:textfield 
	
	
	name="appDatascheda1.potenzaUtileClimatEstiva" id="widg_tfPotenzaUtileClimatEstiva"
maxlength="9"	disabled="isWidgetDisabled('cpGestLibScheda1','tfPotenzaUtileClimatEstiva')"
	size="25" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','cbAltriServizi')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda1.cbAltriServizi.label')}" labelFor="widg_cbAltriServizi" errorFor="appDatascheda1.flagPotenzaUtileAltro" labelId="cbAltriServiziLbl"
	position="first"  >


<!-- widget cbAltriServizi -->
<s:checkbox 
	
	
	name="appDatascheda1.flagPotenzaUtileAltro" id="widg_cbAltriServizi"
	disabled="isWidgetDisabled('cpGestLibScheda1','cbAltriServizi')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda1','cbAltriServizi')" >
	<s:hidden name="__checkbox_appDatascheda1.flagPotenzaUtileAltro" id="__checkbox_widg_cbAltriServizi" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','tfPotenzaUtileAltriServizi')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="" labelFor="widg_tfPotenzaUtileAltriServizi" errorFor="appDatascheda1.potenzaUtileAltro" labelId="tfPotenzaUtileAltriServiziLbl"
	position="last"  >


<!-- widget tfPotenzaUtileAltriServizi -->
<s:textarea 
	
	
	name="appDatascheda1.potenzaUtileAltro" id="widg_tfPotenzaUtileAltriServizi"
	disabled="isWidgetDisabled('cpGestLibScheda1','tfPotenzaUtileAltriServizi')"
	rows="3"
	cols="25"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpScheda1ServiziImpianto --></div>

			
	
	<div id="p_wpScheda1TipologiaFluidoVettore" class="widgetsPanelBlock"><!-- startFragment:p_wpScheda1TipologiaFluidoVettore -->
	
	
<h4 class="wpLabel">1.4 Tipologia Fluido Vettore * </h4>
<div class="widgetsPanel" id="wpScheda1TipologiaFluidoVettore">
	
	<customtag:widgetsPanel id="wpScheda1TipologiaFluidoVettoreTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		percentCols="25,25,15,35">
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda1','cbTipoFluidoAcqua')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda1.cbTipoFluidoAcqua.label')}" labelFor="widg_cbTipoFluidoAcqua" errorFor="appDatascheda1.flagTipologiaFluidoAcqua" labelId="cbTipoFluidoAcquaLbl"
	position="first"  >


<!-- widget cbTipoFluidoAcqua -->
<s:checkbox 
	
	
	name="appDatascheda1.flagTipologiaFluidoAcqua" id="widg_cbTipoFluidoAcqua"
	disabled="isWidgetDisabled('cpGestLibScheda1','cbTipoFluidoAcqua')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda1','cbTipoFluidoAcqua')" >
	<s:hidden name="__checkbox_appDatascheda1.flagTipologiaFluidoAcqua" id="__checkbox_widg_cbTipoFluidoAcqua" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','wpScheda1TipologiaFluidoVettore_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda1TipologiaFluidoVettore_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','cbTipoFluidoAria')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda1.cbTipoFluidoAria.label')}" labelFor="widg_cbTipoFluidoAria" errorFor="appDatascheda1.flagTipologiaFluidoAria" labelId="cbTipoFluidoAriaLbl"
	position="first"  >


<!-- widget cbTipoFluidoAria -->
<s:checkbox 
	
	
	name="appDatascheda1.flagTipologiaFluidoAria" id="widg_cbTipoFluidoAria"
	disabled="isWidgetDisabled('cpGestLibScheda1','cbTipoFluidoAria')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda1','cbTipoFluidoAria')" >
	<s:hidden name="__checkbox_appDatascheda1.flagTipologiaFluidoAria" id="__checkbox_widg_cbTipoFluidoAria" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','wpScheda1TipologiaFluidoVettore_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda1TipologiaFluidoVettore_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','cbFluidoAltro')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda1.cbFluidoAltro.label')}" labelFor="widg_cbFluidoAltro" errorFor="appDatascheda1.flagTipologiaFluidoAltro" labelId="cbFluidoAltroLbl"
	position="first"  >


<!-- widget cbFluidoAltro -->
<s:checkbox 
	
	
	name="appDatascheda1.flagTipologiaFluidoAltro" id="widg_cbFluidoAltro"
	disabled="isWidgetDisabled('cpGestLibScheda1','cbFluidoAltro')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda1','cbFluidoAltro')" >
	<s:hidden name="__checkbox_appDatascheda1.flagTipologiaFluidoAltro" id="__checkbox_widg_cbFluidoAltro" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','tfFluidoAltro')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="" labelFor="widg_tfFluidoAltro" errorFor="appDatascheda1.tipologiaFluidoAltro" labelId="tfFluidoAltroLbl"
	position="last"  >


<!-- widget tfFluidoAltro -->
<s:textarea 
	
	
	name="appDatascheda1.tipologiaFluidoAltro" id="widg_tfFluidoAltro"
	disabled="isWidgetDisabled('cpGestLibScheda1','tfFluidoAltro')"
	rows="3"
	cols="25"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpScheda1TipologiaFluidoVettore --></div>

			
	
	<div id="p_wpScheda1TipologiaGeneratori" class="widgetsPanelBlock"><!-- startFragment:p_wpScheda1TipologiaGeneratori -->
	
	
<h4 class="wpLabel">1.5 Individuazione della tipologia dei generatori * </h4>
<div class="widgetsPanel" id="wpScheda1TipologiaGeneratori">
	
	<customtag:widgetsPanel id="wpScheda1TipologiaGeneratoriTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		percentCols="25,25,15,35">
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda1','cbTipoGeneratoriCombustione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda1.cbTipoGeneratoriCombustione.label')}" labelFor="widg_cbTipoGeneratoriCombustione" errorFor="appDatascheda1.flagGeneratoreCombustione" labelId="cbTipoGeneratoriCombustioneLbl"
	position="first"  >


<!-- widget cbTipoGeneratoriCombustione -->
<s:checkbox 
	
	
	name="appDatascheda1.flagGeneratoreCombustione" id="widg_cbTipoGeneratoriCombustione"
	disabled="isWidgetDisabled('cpGestLibScheda1','cbTipoGeneratoriCombustione')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda1','cbTipoGeneratoriCombustione')" >
	<s:hidden name="__checkbox_appDatascheda1.flagGeneratoreCombustione" id="__checkbox_widg_cbTipoGeneratoriCombustione" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','wpScheda1TipologiaGeneratori_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda1TipologiaGeneratori_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','cbTipoGeneratorePompaCalore')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda1.cbTipoGeneratorePompaCalore.label')}" labelFor="widg_cbTipoGeneratorePompaCalore" errorFor="appDatascheda1.flagPompaDiCalore" labelId="cbTipoGeneratorePompaCaloreLbl"
	position="first"  >


<!-- widget cbTipoGeneratorePompaCalore -->
<s:checkbox 
	
	
	name="appDatascheda1.flagPompaDiCalore" id="widg_cbTipoGeneratorePompaCalore"
	disabled="isWidgetDisabled('cpGestLibScheda1','cbTipoGeneratorePompaCalore')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda1','cbTipoGeneratorePompaCalore')" >
	<s:hidden name="__checkbox_appDatascheda1.flagPompaDiCalore" id="__checkbox_widg_cbTipoGeneratorePompaCalore" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','wpScheda1TipologiaGeneratori_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda1TipologiaGeneratori_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','cbTipoGeneratoreMacchinaFrigorifera')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda1.cbTipoGeneratoreMacchinaFrigorifera.label')}" labelFor="widg_cbTipoGeneratoreMacchinaFrigorifera" errorFor="appDatascheda1.flagGeneratoreMacchinaFrigorifera" labelId="cbTipoGeneratoreMacchinaFrigoriferaLbl"
	position="first"  >


<!-- widget cbTipoGeneratoreMacchinaFrigorifera -->
<s:checkbox 
	
	
	name="appDatascheda1.flagGeneratoreMacchinaFrigorifera" id="widg_cbTipoGeneratoreMacchinaFrigorifera"
	disabled="isWidgetDisabled('cpGestLibScheda1','cbTipoGeneratoreMacchinaFrigorifera')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda1','cbTipoGeneratoreMacchinaFrigorifera')" >
	<s:hidden name="__checkbox_appDatascheda1.flagGeneratoreMacchinaFrigorifera" id="__checkbox_widg_cbTipoGeneratoreMacchinaFrigorifera" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','wpScheda1TipologiaGeneratori_3_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda1TipologiaGeneratori_3_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','cbTipoGeneratoriTeleriscaldamento')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda1.cbTipoGeneratoriTeleriscaldamento.label')}" labelFor="widg_cbTipoGeneratoriTeleriscaldamento" errorFor="appDatascheda1.flagGeneratoreTeleriscaldamento" labelId="cbTipoGeneratoriTeleriscaldamentoLbl"
	position="first"  >


<!-- widget cbTipoGeneratoriTeleriscaldamento -->
<s:checkbox 
	
	
	name="appDatascheda1.flagGeneratoreTeleriscaldamento" id="widg_cbTipoGeneratoriTeleriscaldamento"
	disabled="isWidgetDisabled('cpGestLibScheda1','cbTipoGeneratoriTeleriscaldamento')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda1','cbTipoGeneratoriTeleriscaldamento')" >
	<s:hidden name="__checkbox_appDatascheda1.flagGeneratoreTeleriscaldamento" id="__checkbox_widg_cbTipoGeneratoriTeleriscaldamento" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','wpScheda1TipologiaGeneratori_4_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda1TipologiaGeneratori_4_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','cbTipoGeneratoreTeleraffrescamento')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda1.cbTipoGeneratoreTeleraffrescamento.label')}" labelFor="widg_cbTipoGeneratoreTeleraffrescamento" errorFor="appDatascheda1.flagGeneratoreTeleraffrescamento" labelId="cbTipoGeneratoreTeleraffrescamentoLbl"
	position="first"  >


<!-- widget cbTipoGeneratoreTeleraffrescamento -->
<s:checkbox 
	
	
	name="appDatascheda1.flagGeneratoreTeleraffrescamento" id="widg_cbTipoGeneratoreTeleraffrescamento"
	disabled="isWidgetDisabled('cpGestLibScheda1','cbTipoGeneratoreTeleraffrescamento')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda1','cbTipoGeneratoreTeleraffrescamento')" >
	<s:hidden name="__checkbox_appDatascheda1.flagGeneratoreTeleraffrescamento" id="__checkbox_widg_cbTipoGeneratoreTeleraffrescamento" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','wpScheda1TipologiaGeneratori_5_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda1TipologiaGeneratori_5_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','cbTipoGeneratoreCoTrigenerazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda1.cbTipoGeneratoreCoTrigenerazione.label')}" labelFor="widg_cbTipoGeneratoreCoTrigenerazione" errorFor="appDatascheda1.flagCogenerazioneTrigenerazione" labelId="cbTipoGeneratoreCoTrigenerazioneLbl"
	position="first"  >


<!-- widget cbTipoGeneratoreCoTrigenerazione -->
<s:checkbox 
	
	
	name="appDatascheda1.flagCogenerazioneTrigenerazione" id="widg_cbTipoGeneratoreCoTrigenerazione"
	disabled="isWidgetDisabled('cpGestLibScheda1','cbTipoGeneratoreCoTrigenerazione')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda1','cbTipoGeneratoreCoTrigenerazione')" >
	<s:hidden name="__checkbox_appDatascheda1.flagCogenerazioneTrigenerazione" id="__checkbox_widg_cbTipoGeneratoreCoTrigenerazione" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','wpScheda1TipologiaGeneratori_6_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda1TipologiaGeneratori_6_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','cbTipoGeneratoreAltro')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda1.cbTipoGeneratoreAltro.label')}" labelFor="widg_cbTipoGeneratoreAltro" errorFor="appDatascheda1.flagAltroTipoGeneratori" labelId="cbTipoGeneratoreAltroLbl"
	position="first"  >


<!-- widget cbTipoGeneratoreAltro -->
<s:checkbox 
	
	
	name="appDatascheda1.flagAltroTipoGeneratori" id="widg_cbTipoGeneratoreAltro"
	disabled="isWidgetDisabled('cpGestLibScheda1','cbTipoGeneratoreAltro')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda1','cbTipoGeneratoreAltro')" >
	<s:hidden name="__checkbox_appDatascheda1.flagAltroTipoGeneratori" id="__checkbox_widg_cbTipoGeneratoreAltro" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','tfTipoGeneratoreAltro')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="" labelFor="widg_tfTipoGeneratoreAltro" errorFor="appDatascheda1.altroTipoGeneratori" labelId="tfTipoGeneratoreAltroLbl"
	position="last"  >


<!-- widget tfTipoGeneratoreAltro -->
<s:textarea 
	
	
	name="appDatascheda1.altroTipoGeneratori" id="widg_tfTipoGeneratoreAltro"
	disabled="isWidgetDisabled('cpGestLibScheda1','tfTipoGeneratoreAltro')"
	rows="3"
	cols="25"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','ptIntegrazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda1.ptIntegrazione.label')}" labelFor="widg_ptIntegrazione" errorFor="widg_ptIntegrazione" labelId="ptIntegrazioneLbl"  position="first" >


<!-- widget ptIntegrazione -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','wpScheda1TipologiaGeneratori_8_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda1TipologiaGeneratori_8_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','cbIntegrazioniPannelliSolari')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda1.cbIntegrazioniPannelliSolari.label')}" labelFor="widg_cbIntegrazioniPannelliSolari" errorFor="appDatascheda1.flagPannelliSolari" labelId="cbIntegrazioniPannelliSolariLbl"
	position="first"  >


<!-- widget cbIntegrazioniPannelliSolari -->
<s:checkbox 
	
	
	name="appDatascheda1.flagPannelliSolari" id="widg_cbIntegrazioniPannelliSolari"
	disabled="isWidgetDisabled('cpGestLibScheda1','cbIntegrazioniPannelliSolari')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda1','cbIntegrazioniPannelliSolari')" >
	<s:hidden name="__checkbox_appDatascheda1.flagPannelliSolari" id="__checkbox_widg_cbIntegrazioniPannelliSolari" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','tfIntegrazioniPannelliSolari')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda1.tfIntegrazioniPannelliSolari.label')}" labelFor="widg_tfIntegrazioniPannelliSolari" errorFor="appDatascheda1.totaleSuperficieLorda" labelId="tfIntegrazioniPannelliSolariLbl"
	position="last"  >


<!-- widget tfIntegrazioniPannelliSolari -->
<s:textfield 
	
	
	name="appDatascheda1.totaleSuperficieLorda" id="widg_tfIntegrazioniPannelliSolari"
maxlength="7"	disabled="isWidgetDisabled('cpGestLibScheda1','tfIntegrazioniPannelliSolari')"
	size="25" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','cbIntegrazioniAltro')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda1.cbIntegrazioniAltro.label')}" labelFor="widg_cbIntegrazioniAltro" errorFor="appDatascheda1.flagAltraIntegrazione" labelId="cbIntegrazioniAltroLbl"
	position="first"  >


<!-- widget cbIntegrazioniAltro -->
<s:checkbox 
	
	
	name="appDatascheda1.flagAltraIntegrazione" id="widg_cbIntegrazioniAltro"
	disabled="isWidgetDisabled('cpGestLibScheda1','cbIntegrazioniAltro')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda1','cbIntegrazioniAltro')" >
	<s:hidden name="__checkbox_appDatascheda1.flagAltraIntegrazione" id="__checkbox_widg_cbIntegrazioniAltro" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','tfAltraIntegrazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="" labelFor="widg_tfAltraIntegrazione" errorFor="appDatascheda1.altraIntegrazione" labelId="tfAltraIntegrazioneLbl"
	position="last"  >


<!-- widget tfAltraIntegrazione -->
<s:textarea 
	
	
	name="appDatascheda1.altraIntegrazione" id="widg_tfAltraIntegrazione"
	disabled="isWidgetDisabled('cpGestLibScheda1','tfAltraIntegrazione')"
	rows="3"
	cols="25"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','wpScheda1TipologiaGeneratori_11_1_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget wpScheda1TipologiaGeneratori_11_1_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','tfIntegrazioniPotenzaUtile')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda1.tfIntegrazioniPotenzaUtile.label')}" labelFor="widg_tfIntegrazioniPotenzaUtile" errorFor="appDatascheda1.potenzaUtileAltraIntegrazione" labelId="tfIntegrazioniPotenzaUtileLbl"
	position="last"  >


<!-- widget tfIntegrazioniPotenzaUtile -->
<s:textfield 
	
	
	name="appDatascheda1.potenzaUtileAltraIntegrazione" id="widg_tfIntegrazioniPotenzaUtile"
maxlength="8"	disabled="isWidgetDisabled('cpGestLibScheda1','tfIntegrazioniPotenzaUtile')"
	size="25" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','ptPer')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda1.ptPer.label')}" labelFor="widg_ptPer" errorFor="widg_ptPer" labelId="ptPerLbl"  position="first" >


<!-- widget ptPer -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','wpScheda1TipologiaGeneratori_12_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda1TipologiaGeneratori_12_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','cbTipoGeneratoriClimatInvernale')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda1.cbTipoGeneratoriClimatInvernale.label')}" labelFor="widg_cbTipoGeneratoriClimatInvernale" errorFor="appDatascheda1.flagTipoGeneratoriClimatInvernale" labelId="cbTipoGeneratoriClimatInvernaleLbl"
	position="first"  >


<!-- widget cbTipoGeneratoriClimatInvernale -->
<s:checkbox 
	
	
	name="appDatascheda1.flagTipoGeneratoriClimatInvernale" id="widg_cbTipoGeneratoriClimatInvernale"
	disabled="isWidgetDisabled('cpGestLibScheda1','cbTipoGeneratoriClimatInvernale')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda1','cbTipoGeneratoriClimatInvernale')" >
	<s:hidden name="__checkbox_appDatascheda1.flagTipoGeneratoriClimatInvernale" id="__checkbox_widg_cbTipoGeneratoriClimatInvernale" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','wpScheda1TipologiaGeneratori_13_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda1TipologiaGeneratori_13_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','cbTipologiaGeneratoriClimatEstiva')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda1.cbTipologiaGeneratoriClimatEstiva.label')}" labelFor="widg_cbTipologiaGeneratoriClimatEstiva" errorFor="appDatascheda1.flagTipoGeneratoriClimatEstiva" labelId="cbTipologiaGeneratoriClimatEstivaLbl"
	position="first"  >


<!-- widget cbTipologiaGeneratoriClimatEstiva -->
<s:checkbox 
	
	
	name="appDatascheda1.flagTipoGeneratoriClimatEstiva" id="widg_cbTipologiaGeneratoriClimatEstiva"
	disabled="isWidgetDisabled('cpGestLibScheda1','cbTipologiaGeneratoriClimatEstiva')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda1','cbTipologiaGeneratoriClimatEstiva')" >
	<s:hidden name="__checkbox_appDatascheda1.flagTipoGeneratoriClimatEstiva" id="__checkbox_widg_cbTipologiaGeneratoriClimatEstiva" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','wpScheda1TipologiaGeneratori_14_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda1TipologiaGeneratori_14_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','cbTipologiaGeneratoriProdACS')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda1.cbTipologiaGeneratoriProdACS.label')}" labelFor="widg_cbTipologiaGeneratoriProdACS" errorFor="appDatascheda1.flagTipologiaGeneratoriProdACS" labelId="cbTipologiaGeneratoriProdACSLbl"
	position="first"  >


<!-- widget cbTipologiaGeneratoriProdACS -->
<s:checkbox 
	
	
	name="appDatascheda1.flagTipologiaGeneratoriProdACS" id="widg_cbTipologiaGeneratoriProdACS"
	disabled="isWidgetDisabled('cpGestLibScheda1','cbTipologiaGeneratoriProdACS')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda1','cbTipologiaGeneratoriProdACS')" >
	<s:hidden name="__checkbox_appDatascheda1.flagTipologiaGeneratoriProdACS" id="__checkbox_widg_cbTipologiaGeneratoriProdACS" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','wpScheda1TipologiaGeneratori_15_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda1TipologiaGeneratori_15_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','cbAltroTipologiaGeneratori')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda1.cbAltroTipologiaGeneratori.label')}" labelFor="widg_cbAltroTipologiaGeneratori" errorFor="appDatascheda1.flagAltroTipologiaGeneratori" labelId="cbAltroTipologiaGeneratoriLbl"
	position="first"  >


<!-- widget cbAltroTipologiaGeneratori -->
<s:checkbox 
	
	
	name="appDatascheda1.flagAltroTipologiaGeneratori" id="widg_cbAltroTipologiaGeneratori"
	disabled="isWidgetDisabled('cpGestLibScheda1','cbAltroTipologiaGeneratori')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda1','cbAltroTipologiaGeneratori')" >
	<s:hidden name="__checkbox_appDatascheda1.flagAltroTipologiaGeneratori" id="__checkbox_widg_cbAltroTipologiaGeneratori" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1','tfAltroTipologiaGeneratori')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="" labelFor="widg_tfAltroTipologiaGeneratori" errorFor="appDatascheda1.altroTipologiaGeneratori" labelId="tfAltroTipologiaGeneratoriLbl"
	position="last"  >


<!-- widget tfAltroTipologiaGeneratori -->
<s:textarea 
	
	
	name="appDatascheda1.altroTipologiaGeneratori" id="widg_tfAltroTipologiaGeneratori"
	disabled="isWidgetDisabled('cpGestLibScheda1','tfAltroTipologiaGeneratori')"
	rows="3"
	cols="25"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpScheda1TipologiaGeneratori --></div>

			
	
	<div id="p_cpFunGestScheda1" class="commandPanelBlock"><!-- startFragment:p_cpFunGestScheda1 -->
	
	
<div class="commandPanel functional" id="cpFunGestScheda1">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestLibScheda1','bSalvaScheda1')" >

	



<!-- widget bSalvaScheda1 -->
<s:submit name="widg_bSalvaScheda1" id="widg_bSalvaScheda1" method="handleBSalvaScheda1_CLICKED"
	key="cpGestLibScheda1.bSalvaScheda1.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda1','bSalvaScheda1')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunGestScheda1 --></div>

			
	
	<div id="p_cpNavGestScheda1" class="commandPanelBlock"><!-- startFragment:p_cpNavGestScheda1 -->
	
	
<div class="commandPanel navigation" id="cpNavGestScheda1">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestLibScheda1','btnIndietro')" >

	



<!-- widget btnIndietro -->
<s:submit name="widg_btnIndietro" id="widg_btnIndietro" method="handleBtnIndietro_CLICKED"
	key="cpGestLibScheda1.btnIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda1','btnIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavGestScheda1 --></div>

	

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
