<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_libretto_scheda5_2 -->
<!-- pageId:cpGestLibScheda5_2 -->

<s:form id="cpGestLibScheda5_2" action="cpGestLibScheda5_2" namespace="/base/gestisci_libretto_scheda5_2" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestLibScheda5_2_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpGestLibScheda5_2','menu')" >

	


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

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestLibScheda5_2_udpFunzionalita.jsp"></s:include>

	



			
	
	<div id="p_wpMenuTree" class="widgetsPanelBlock"><!-- startFragment:p_wpMenuTree -->
	
	

<div class="widgetsPanel" id="wpMenuTree">
	
	<customtag:widgetsPanel id="wpMenuTreeTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','menuLibretto')" >

	
<customtag:widgetsPanelColumn 
	 colSpan="2" >



	<csiuicore:ajaxify id="p_fpLeftMenu" 
		widgetType="tree" 
		pageId="cpGestLibScheda5_2"
		javascriptDetection="false">
	<customtag:tree
		name="appDatalibrettoMenuTree"
		cssUlClass="tree"
        cssRootClass="treeRoot" cssFolderOpenClass="treeFolderOpen"
        cssFolderClosedClass="treeFolderClosed" cssDotClass="treeDot"
		linkOnTree="true" id="menuLibretto"
		selectionMultiplicity="none"
		requestURI="/sigitwebn/base/gestisci_libretto_scheda5_2/cpGestLibScheda5_2!handleMenuLibretto_CLICKED.do"
		nameSpace="/base/gestisci_libretto_scheda5_2"
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

	
	

	
	
			
	
	<div id="p_fpTitolo" class="formPanelBlock"><!-- startFragment:p_fpTitolo -->
		
	
<h4 class="fpLabel"><s:text name="cpGestLibScheda5_2.fpTitolo.label" /></h4>
<div class="formPanel" id="fpTitolo">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpTitolo --></div>

			
	
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
		>
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','ptCodiceImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda5_2.ptCodiceImpianto.label')}" labelFor="widg_ptCodiceImpianto" errorFor="appDataidentificativoImpianto.codiceImpianto" labelId="ptCodiceImpiantoLbl"  position="first" >


<!-- widget ptCodiceImpianto -->
<s:property value="appDataidentificativoImpianto.codiceImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','ptUbicazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda5_2.ptUbicazione.label')}" labelFor="widg_ptUbicazione" errorFor="appDataidentificativoImpianto.ubicazione" labelId="ptUbicazioneLbl"  position="last" >


<!-- widget ptUbicazione -->
<s:property value="appDataidentificativoImpianto.ubicazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','ptResponsabile')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda5_2.ptResponsabile.label')}" labelFor="widg_ptResponsabile" errorFor="appDataidentificativoImpianto.responsabile" labelId="ptResponsabileLbl"  position="first" >


<!-- widget ptResponsabile -->
<s:property value="appDataidentificativoImpianto.responsabile" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','wpInfoImpianto_2_2_fictitious_')" >

	
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

			
	
	<div id="p_wpScheda5_1RegolazionePrimaria" class="widgetsPanelBlock"><!-- startFragment:p_wpScheda5_1RegolazionePrimaria -->
	
	
<h4 class="wpLabel">5.1 Regolazione primaria </h4>
<div class="widgetsPanel" id="wpScheda5_1RegolazionePrimaria">
	
	<customtag:widgetsPanel id="wpScheda5_1RegolazionePrimariaTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		percentCols="40,10,15,35">
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','l5_1flgSrONOFF')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda5_2.l5_1flgSrONOFF.label')}" labelFor="widg_l5_1flgSrONOFF" errorFor="appDataSistemiRegolazioneContabilizzazione.l5_1flgSrONOFF" labelId="l5_1flgSrONOFFLbl"
	position="first"  >


<!-- widget l5_1flgSrONOFF -->
<s:checkbox 
	
	
	name="appDataSistemiRegolazioneContabilizzazione.l5_1flgSrONOFF" id="widg_l5_1flgSrONOFF"
	disabled="isWidgetDisabled('cpGestLibScheda5_2','l5_1flgSrONOFF')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda5_2','l5_1flgSrONOFF')" >
	<s:hidden name="__checkbox_appDataSistemiRegolazioneContabilizzazione.l5_1flgSrONOFF" id="__checkbox_widg_l5_1flgSrONOFF" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','wpScheda5_1RegolazionePrimaria_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda5_1RegolazionePrimaria_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','l5_1flgSrGeneratore')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda5_2.l5_1flgSrGeneratore.label')}" labelFor="widg_l5_1flgSrGeneratore" errorFor="appDataSistemiRegolazioneContabilizzazione.l5_1flgSrGeneratore" labelId="l5_1flgSrGeneratoreLbl"
	position="first"  >


<!-- widget l5_1flgSrGeneratore -->
<s:checkbox 
	
	
	name="appDataSistemiRegolazioneContabilizzazione.l5_1flgSrGeneratore" id="widg_l5_1flgSrGeneratore"
	disabled="isWidgetDisabled('cpGestLibScheda5_2','l5_1flgSrGeneratore')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda5_2','l5_1flgSrGeneratore')" >
	<s:hidden name="__checkbox_appDataSistemiRegolazioneContabilizzazione.l5_1flgSrGeneratore" id="__checkbox_widg_l5_1flgSrGeneratore" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','wpScheda5_1RegolazionePrimaria_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda5_1RegolazionePrimaria_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','l5_1flgSrIndipendente')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda5_2.l5_1flgSrIndipendente.label')}" labelFor="widg_l5_1flgSrIndipendente" errorFor="appDataSistemiRegolazioneContabilizzazione.l5_1flgSrIndipendente" labelId="l5_1flgSrIndipendenteLbl"
	position="first"  >


<!-- widget l5_1flgSrIndipendente -->
<s:checkbox 
	
	
	name="appDataSistemiRegolazioneContabilizzazione.l5_1flgSrIndipendente" id="widg_l5_1flgSrIndipendente"
	disabled="isWidgetDisabled('cpGestLibScheda5_2','l5_1flgSrIndipendente')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda5_2','l5_1flgSrIndipendente')" >
	<s:hidden name="__checkbox_appDataSistemiRegolazioneContabilizzazione.l5_1flgSrIndipendente" id="__checkbox_widg_l5_1flgSrIndipendente" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','wpScheda5_1RegolazionePrimaria_3_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda5_1RegolazionePrimaria_3_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','l5_1flgSrMultigradino')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda5_2.l5_1flgSrMultigradino.label')}" labelFor="widg_l5_1flgSrMultigradino" errorFor="appDataSistemiRegolazioneContabilizzazione.l5_1flgSrMultigradino" labelId="l5_1flgSrMultigradinoLbl"
	position="first"  >


<!-- widget l5_1flgSrMultigradino -->
<s:checkbox 
	
	
	name="appDataSistemiRegolazioneContabilizzazione.l5_1flgSrMultigradino" id="widg_l5_1flgSrMultigradino"
	disabled="isWidgetDisabled('cpGestLibScheda5_2','l5_1flgSrMultigradino')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda5_2','l5_1flgSrMultigradino')" >
	<s:hidden name="__checkbox_appDataSistemiRegolazioneContabilizzazione.l5_1flgSrMultigradino" id="__checkbox_widg_l5_1flgSrMultigradino" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','wpScheda5_1RegolazionePrimaria_4_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda5_1RegolazionePrimaria_4_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','l5_1flgSrInverter')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda5_2.l5_1flgSrInverter.label')}" labelFor="widg_l5_1flgSrInverter" errorFor="appDataSistemiRegolazioneContabilizzazione.l5_1flgSrInverter" labelId="l5_1flgSrInverterLbl"
	position="first"  >


<!-- widget l5_1flgSrInverter -->
<s:checkbox 
	
	
	name="appDataSistemiRegolazioneContabilizzazione.l5_1flgSrInverter" id="widg_l5_1flgSrInverter"
	disabled="isWidgetDisabled('cpGestLibScheda5_2','l5_1flgSrInverter')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda5_2','l5_1flgSrInverter')" >
	<s:hidden name="__checkbox_appDataSistemiRegolazioneContabilizzazione.l5_1flgSrInverter" id="__checkbox_widg_l5_1flgSrInverter" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','wpScheda5_1RegolazionePrimaria_5_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda5_1RegolazionePrimaria_5_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','l5_1flgSrAltri')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda5_2.l5_1flgSrAltri.label')}" labelFor="widg_l5_1flgSrAltri" errorFor="appDataSistemiRegolazioneContabilizzazione.l5_1flgSrAltri" labelId="l5_1flgSrAltriLbl"
	position="first"  >


<!-- widget l5_1flgSrAltri -->
<s:checkbox 
	
	
	name="appDataSistemiRegolazioneContabilizzazione.l5_1flgSrAltri" id="widg_l5_1flgSrAltri"
	disabled="isWidgetDisabled('cpGestLibScheda5_2','l5_1flgSrAltri')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda5_2','l5_1flgSrAltri')" >
	<s:hidden name="__checkbox_appDataSistemiRegolazioneContabilizzazione.l5_1flgSrAltri" id="__checkbox_widg_l5_1flgSrAltri" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','l5_1SrDescrizione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda5_2.l5_1SrDescrizione.label')}" labelFor="widg_l5_1SrDescrizione" errorFor="appDataSistemiRegolazioneContabilizzazione.l5_1flgSrDescrizione" labelId="l5_1SrDescrizioneLbl"
	position="last"  >


<!-- widget l5_1SrDescrizione -->
<s:textarea 
	
	
	name="appDataSistemiRegolazioneContabilizzazione.l5_1flgSrDescrizione" id="widg_l5_1SrDescrizione"
	disabled="isWidgetDisabled('cpGestLibScheda5_2','l5_1SrDescrizione')"
	rows="2"
	cols="30"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpScheda5_1RegolazionePrimaria --></div>

			
	
	<div id="p_wpScheda5_2RegolazioneAmbiente" class="widgetsPanelBlock"><!-- startFragment:p_wpScheda5_2RegolazioneAmbiente -->
	
	
<h4 class="wpLabel">5.2 Regolazione singolo ambiente di zona </h4>
<div class="widgetsPanel" id="wpScheda5_2RegolazioneAmbiente">
	
	<customtag:widgetsPanel id="wpScheda5_2RegolazioneAmbienteTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','l5_2tipoRegolazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda5_2.l5_2tipoRegolazione.label')}" labelFor="widg_l5_2tipoRegolazione" errorFor="appDataSistemiRegolazioneContabilizzazione.l5_2flgTipoRegolazione" labelId="l5_2tipoRegolazioneLbl"
	position="first"  >


<!-- widget l5_2tipoRegolazione -->
<s:select name="appDataSistemiRegolazioneContabilizzazione.l5_2flgTipoRegolazione" id="widg_l5_2tipoRegolazione"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTipoRegolazione"
	  disabled="isWidgetDisabled('cpGestLibScheda5_2','l5_2tipoRegolazione')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','wpScheda5_2RegolazioneAmbiente_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda5_2RegolazioneAmbiente_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','l5_2valvoleTermo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda5_2.l5_2valvoleTermo.label')}" labelFor="widg_l5_2valvoleTermo" errorFor="appDataSistemiRegolazioneContabilizzazione.l5_2flgValvoleTermo" labelId="l5_2valvoleTermoLbl"
	position="first"  fieldRequired="true">


<!-- widget l5_2valvoleTermo -->
<s:select name="appDataSistemiRegolazioneContabilizzazione.l5_2flgValvoleTermo" id="widg_l5_2valvoleTermo"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoPresenteAssente"
	  disabled="isWidgetDisabled('cpGestLibScheda5_2','l5_2valvoleTermo')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','wpScheda5_2RegolazioneAmbiente_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda5_2RegolazioneAmbiente_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','l5_2valvole2')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda5_2.l5_2valvole2.label')}" labelFor="widg_l5_2valvole2" errorFor="appDataSistemiRegolazioneContabilizzazione.l5_2flgValvole2" labelId="l5_2valvole2Lbl"
	position="first"  fieldRequired="true">


<!-- widget l5_2valvole2 -->
<s:select name="appDataSistemiRegolazioneContabilizzazione.l5_2flgValvole2" id="widg_l5_2valvole2"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoPresenteAssente"
	  disabled="isWidgetDisabled('cpGestLibScheda5_2','l5_2valvole2')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','wpScheda5_2RegolazioneAmbiente_3_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda5_2RegolazioneAmbiente_3_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','l5_2valvole3')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda5_2.l5_2valvole3.label')}" labelFor="widg_l5_2valvole3" errorFor="appDataSistemiRegolazioneContabilizzazione.l5_2flgValvole3" labelId="l5_2valvole3Lbl"
	position="first"  fieldRequired="true">


<!-- widget l5_2valvole3 -->
<s:select name="appDataSistemiRegolazioneContabilizzazione.l5_2flgValvole3" id="widg_l5_2valvole3"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoPresenteAssente"
	  disabled="isWidgetDisabled('cpGestLibScheda5_2','l5_2valvole3')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','wpScheda5_2RegolazioneAmbiente_4_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda5_2RegolazioneAmbiente_4_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','l5_2Note')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda5_2.l5_2Note.label')}" labelFor="widg_l5_2Note" errorFor="appDataSistemiRegolazioneContabilizzazione.l5_2note" labelId="l5_2NoteLbl"
	position="first"  >


<!-- widget l5_2Note -->
<s:textarea 
	
	
	name="appDataSistemiRegolazioneContabilizzazione.l5_2note" id="widg_l5_2Note"
	disabled="isWidgetDisabled('cpGestLibScheda5_2','l5_2Note')"
	rows="2"
	cols="30"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','wpScheda5_2RegolazioneAmbiente_5_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda5_2RegolazioneAmbiente_5_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpScheda5_2RegolazioneAmbiente --></div>

			
	
	<div id="p_wpScheda5_3SistemiTelematici" class="widgetsPanelBlock"><!-- startFragment:p_wpScheda5_3SistemiTelematici -->
	
	
<h4 class="wpLabel">5.3 Sistemi telematici di telelettura e telegestione </h4>
<div class="widgetsPanel" id="wpScheda5_3SistemiTelematici">
	
	<customtag:widgetsPanel id="wpScheda5_3SistemiTelematiciTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','l5_3telelettura')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda5_2.l5_3telelettura.label')}" labelFor="widg_l5_3telelettura" errorFor="appDataSistemiRegolazioneContabilizzazione.l5_3flgTelelettura" labelId="l5_3teleletturaLbl"
	position="first"  fieldRequired="true">


<!-- widget l5_3telelettura -->
<s:select name="appDataSistemiRegolazioneContabilizzazione.l5_3flgTelelettura" id="widg_l5_3telelettura"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoPresenteAssente"
	  disabled="isWidgetDisabled('cpGestLibScheda5_2','l5_3telelettura')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','wpScheda5_3SistemiTelematici_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda5_3SistemiTelematici_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','l5_3telegestione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda5_2.l5_3telegestione.label')}" labelFor="widg_l5_3telegestione" errorFor="appDataSistemiRegolazioneContabilizzazione.l5_3flgTelegestione" labelId="l5_3telegestioneLbl"
	position="first"  fieldRequired="true">


<!-- widget l5_3telegestione -->
<s:select name="appDataSistemiRegolazioneContabilizzazione.l5_3flgTelegestione" id="widg_l5_3telegestione"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoPresenteAssente"
	  disabled="isWidgetDisabled('cpGestLibScheda5_2','l5_3telegestione')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','wpScheda5_3SistemiTelematici_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda5_3SistemiTelematici_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','l5_3DesSistemaInstallaz')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda5_2.l5_3DesSistemaInstallaz.label')}" labelFor="widg_l5_3DesSistemaInstallaz" errorFor="appDataSistemiRegolazioneContabilizzazione.l5_3desSistemaInstallaz" labelId="l5_3DesSistemaInstallazLbl"
	position="first"  >


<!-- widget l5_3DesSistemaInstallaz -->
<s:textarea 
	
	
	name="appDataSistemiRegolazioneContabilizzazione.l5_3desSistemaInstallaz" id="widg_l5_3DesSistemaInstallaz"
	disabled="isWidgetDisabled('cpGestLibScheda5_2','l5_3DesSistemaInstallaz')"
	rows="2"
	cols="30"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','wpScheda5_3SistemiTelematici_3_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda5_3SistemiTelematici_3_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','l5_3DataSostituz')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda5_2.l5_3DataSostituz.label')}" labelFor="widg_l5_3DataSostituz" errorFor="appDataSistemiRegolazioneContabilizzazione.l5_3dataSostituz" labelId="l5_3DataSostituzLbl"
	position="first"  >


<!-- widget l5_3DataSostituz -->
<s:textfield 
	
	
	name="appDataSistemiRegolazioneContabilizzazione.l5_3dataSostituz" id="widg_l5_3DataSostituz"
	disabled="isWidgetDisabled('cpGestLibScheda5_2','l5_3DataSostituz')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','wpScheda5_3SistemiTelematici_4_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda5_3SistemiTelematici_4_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','l5_3DesSistemaSostituz')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda5_2.l5_3DesSistemaSostituz.label')}" labelFor="widg_l5_3DesSistemaSostituz" errorFor="appDataSistemiRegolazioneContabilizzazione.l5_3desSistemaSostituz" labelId="l5_3DesSistemaSostituzLbl"
	position="first"  >


<!-- widget l5_3DesSistemaSostituz -->
<s:textarea 
	
	
	name="appDataSistemiRegolazioneContabilizzazione.l5_3desSistemaSostituz" id="widg_l5_3DesSistemaSostituz"
	disabled="isWidgetDisabled('cpGestLibScheda5_2','l5_3DesSistemaSostituz')"
	rows="2"
	cols="30"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','wpScheda5_3SistemiTelematici_5_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda5_3SistemiTelematici_5_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpScheda5_3SistemiTelematici --></div>

			
	
	<div id="p_wpScheda5_4Contabilizzazione" class="widgetsPanelBlock"><!-- startFragment:p_wpScheda5_4Contabilizzazione -->
	
	
<h4 class="wpLabel">5.4 Contabilizzazione </h4>
<div class="widgetsPanel" id="wpScheda5_4Contabilizzazione">
	
	<customtag:widgetsPanel id="wpScheda5_4ContabilizzazioneTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','l5_4FlgUic')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda5_2.l5_4FlgUic.label')}" labelFor="widg_l5_4FlgUic" errorFor="appDataSistemiRegolazioneContabilizzazione.l5_4flgUic" labelId="l5_4FlgUicLbl"
	position="first"  fieldRequired="true">


<!-- widget l5_4FlgUic -->
<s:select name="appDataSistemiRegolazioneContabilizzazione.l5_4flgUic" id="widg_l5_4FlgUic"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoSiNo"
	  disabled="isWidgetDisabled('cpGestLibScheda5_2','l5_4FlgUic')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','wpScheda5_4Contabilizzazione_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda5_4Contabilizzazione_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','l5_4Label')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda5_2.l5_4Label.label')}" labelFor="widg_l5_4Label" errorFor="widg_l5_4Label" labelId="l5_4LabelLbl"  position="first" >


<!-- widget l5_4Label -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','wpScheda5_4Contabilizzazione_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda5_4Contabilizzazione_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','l5_4flgRisc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda5_2.l5_4flgRisc.label')}" labelFor="widg_l5_4flgRisc" errorFor="appDataSistemiRegolazioneContabilizzazione.l5_4flgRisc" labelId="l5_4flgRiscLbl"
	position="first"  >


<!-- widget l5_4flgRisc -->
<s:checkbox 
	
	
	name="appDataSistemiRegolazioneContabilizzazione.l5_4flgRisc" id="widg_l5_4flgRisc"
	disabled="isWidgetDisabled('cpGestLibScheda5_2','l5_4flgRisc')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda5_2','l5_4flgRisc')" >
	<s:hidden name="__checkbox_appDataSistemiRegolazioneContabilizzazione.l5_4flgRisc" id="__checkbox_widg_l5_4flgRisc" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','wpScheda5_4Contabilizzazione_3_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda5_4Contabilizzazione_3_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','l5_4flgRaff')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda5_2.l5_4flgRaff.label')}" labelFor="widg_l5_4flgRaff" errorFor="appDataSistemiRegolazioneContabilizzazione.l5_4flgRaff" labelId="l5_4flgRaffLbl"
	position="first"  >


<!-- widget l5_4flgRaff -->
<s:checkbox 
	
	
	name="appDataSistemiRegolazioneContabilizzazione.l5_4flgRaff" id="widg_l5_4flgRaff"
	disabled="isWidgetDisabled('cpGestLibScheda5_2','l5_4flgRaff')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda5_2','l5_4flgRaff')" >
	<s:hidden name="__checkbox_appDataSistemiRegolazioneContabilizzazione.l5_4flgRaff" id="__checkbox_widg_l5_4flgRaff" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','wpScheda5_4Contabilizzazione_4_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda5_4Contabilizzazione_4_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','l5_4flgAcs')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda5_2.l5_4flgAcs.label')}" labelFor="widg_l5_4flgAcs" errorFor="appDataSistemiRegolazioneContabilizzazione.l5_4flgAcs" labelId="l5_4flgAcsLbl"
	position="first"  >


<!-- widget l5_4flgAcs -->
<s:checkbox 
	
	
	name="appDataSistemiRegolazioneContabilizzazione.l5_4flgAcs" id="widg_l5_4flgAcs"
	disabled="isWidgetDisabled('cpGestLibScheda5_2','l5_4flgAcs')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda5_2','l5_4flgAcs')" >
	<s:hidden name="__checkbox_appDataSistemiRegolazioneContabilizzazione.l5_4flgAcs" id="__checkbox_widg_l5_4flgAcs" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','wpScheda5_4Contabilizzazione_5_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda5_4Contabilizzazione_5_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','l5_4FlgTipologia')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda5_2.l5_4FlgTipologia.label')}" labelFor="widg_l5_4FlgTipologia" errorFor="appDataSistemiRegolazioneContabilizzazione.l5_4flgTipologia" labelId="l5_4FlgTipologiaLbl"
	position="first"  >


<!-- widget l5_4FlgTipologia -->
<s:select name="appDataSistemiRegolazioneContabilizzazione.l5_4flgTipologia" id="widg_l5_4FlgTipologia"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTipologiaSistema"
	  disabled="isWidgetDisabled('cpGestLibScheda5_2','l5_4FlgTipologia')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','wpScheda5_4Contabilizzazione_6_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda5_4Contabilizzazione_6_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','l5_4DesSistemaInstallaz')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda5_2.l5_4DesSistemaInstallaz.label')}" labelFor="widg_l5_4DesSistemaInstallaz" errorFor="appDataSistemiRegolazioneContabilizzazione.l5_4desSistemaInstallaz" labelId="l5_4DesSistemaInstallazLbl"
	position="first"  >


<!-- widget l5_4DesSistemaInstallaz -->
<s:textarea 
	
	
	name="appDataSistemiRegolazioneContabilizzazione.l5_4desSistemaInstallaz" id="widg_l5_4DesSistemaInstallaz"
	disabled="isWidgetDisabled('cpGestLibScheda5_2','l5_4DesSistemaInstallaz')"
	rows="2"
	cols="30"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','wpScheda5_4Contabilizzazione_7_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda5_4Contabilizzazione_7_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','l5_4DataSostituz')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda5_2.l5_4DataSostituz.label')}" labelFor="widg_l5_4DataSostituz" errorFor="appDataSistemiRegolazioneContabilizzazione.l5_4dataSostituz" labelId="l5_4DataSostituzLbl"
	position="first"  >


<!-- widget l5_4DataSostituz -->
<s:textfield 
	
	
	name="appDataSistemiRegolazioneContabilizzazione.l5_4dataSostituz" id="widg_l5_4DataSostituz"
	disabled="isWidgetDisabled('cpGestLibScheda5_2','l5_4DataSostituz')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','wpScheda5_4Contabilizzazione_8_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda5_4Contabilizzazione_8_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','l5_4DesSistemaSostituz')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda5_2.l5_4DesSistemaSostituz.label')}" labelFor="widg_l5_4DesSistemaSostituz" errorFor="appDataSistemiRegolazioneContabilizzazione.l5_4desSistemaSostituz" labelId="l5_4DesSistemaSostituzLbl"
	position="first"  >


<!-- widget l5_4DesSistemaSostituz -->
<s:textarea 
	
	
	name="appDataSistemiRegolazioneContabilizzazione.l5_4desSistemaSostituz" id="widg_l5_4DesSistemaSostituz"
	disabled="isWidgetDisabled('cpGestLibScheda5_2','l5_4DesSistemaSostituz')"
	rows="2"
	cols="30"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_2','wpScheda5_4Contabilizzazione_9_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpScheda5_4Contabilizzazione_9_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpScheda5_4Contabilizzazione --></div>

			
	
	<div id="p_cpFunGest" class="commandPanelBlock"><!-- startFragment:p_cpFunGest -->
	
	
<div class="commandPanel functional" id="cpFunGest">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestLibScheda5_2','bSalvaScheda5')" >

	



<!-- widget bSalvaScheda5 -->
<s:submit name="widg_bSalvaScheda5" id="widg_bSalvaScheda5" method="handleBSalvaScheda5_CLICKED"
	key="cpGestLibScheda5_2.bSalvaScheda5.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda5_2','bSalvaScheda5')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestLibScheda5_2','bRipristinaAttuale')" >

	



<!-- widget bRipristinaAttuale -->
<s:submit name="widg_bRipristinaAttuale" id="widg_bRipristinaAttuale" method="handleBRipristinaAttuale_CLICKED"
	key="cpGestLibScheda5_2.bRipristinaAttuale.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda5_2','bRipristinaAttuale')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunGest --></div>

			
	
	<div id="p_cpNavGest" class="commandPanelBlock"><!-- startFragment:p_cpNavGest -->
	
	
<div class="commandPanel navigation" id="cpNavGest">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestLibScheda5_2','btIndietro')" >

	



<!-- widget btIndietro -->
<s:submit name="widg_btIndietro" id="widg_btIndietro" method="handleBtIndietro_CLICKED"
	key="cpGestLibScheda5_2.btIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda5_2','btIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavGest --></div>

	

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
