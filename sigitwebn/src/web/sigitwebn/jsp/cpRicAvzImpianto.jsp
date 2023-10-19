<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/ricerca_avanz_impianti -->
<!-- pageId:cpRicAvzImpianto -->

<s:form id="cpRicAvzImpianto" action="cpRicAvzImpianto" namespace="/base/ricerca_avanz_impianti" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpRicAvzImpianto_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpRicAvzImpianto','menu')" >

	


	<s:include value="fragments/menu.jsp"></s:include>

	

</s:if>

	


		
	
	
</div>

	<!-- endFragment:p_menuPanel --></div>

	

	<!-- endFragment:p_fpUpUserInfo --></div>

		</div>
	</div>
	<!-- ================ FINE UDLRC Layout UP PANEL ================ -->


	<!-- ================ UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->
	<div id="centerWrapper" class="floatWrapper">


		<!-- ***** UDLRC Layout CENTER PANEL ***** -->
		<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
			<div class="wrapper">

					
	
	<div id="p_fpCenterRicAvz" class="formPanelBlock"><!-- startFragment:p_fpCenterRicAvz -->

	
	

	
	
			
	
	<div id="p_fpTitleRicAvz" class="formPanelBlock"><!-- startFragment:p_fpTitleRicAvz -->
		
	
<h4 class="fpLabel"><s:text name="cpRicAvzImpianto.fpTitleRicAvz.label" /></h4>
<div class="formPanel" id="fpTitleRicAvz">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpTitleRicAvz --></div>

			
	
	<div id="p_fpRicImpianto" class="formPanelBlock"><!-- startFragment:p_fpRicImpianto -->
		
	


	
	

	
	
			
	
	<div id="p_stdMsgPRicAvzImp" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgPRicAvzImp -->
	
	
<div class="stdMessagePanel" id="stdMsgPRicAvzImp">
	<customtag:stdMessagePanel id="stdMsgPRicAvzImp" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgPRicAvzImp --></div>

			
	
	
<s:include value="/jsp/userpanels/cpRicAvzImpianto_udpMappa.jsp"></s:include>

	



			
	
	<div id="p_wpImpianto" class="widgetsPanelBlock"><!-- startFragment:p_wpImpianto -->
	
	
<h4 class="wpLabel">impianto </h4>
<div class="widgetsPanel" id="wpImpianto">
	
	<customtag:widgetsPanel id="wpImpiantoTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRicAvzImpianto','tfCodImp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.tfCodImp.label')}" labelFor="widg_tfCodImp" errorFor="appDataricercaAvanzataImpianti.codiceImpianto" labelId="tfCodImpLbl"
	position="first"  >


<!-- widget tfCodImp -->
<s:textfield 
	
	
	name="appDataricercaAvanzataImpianti.codiceImpianto" id="widg_tfCodImp"
maxlength="11"	disabled="isWidgetDisabled('cpRicAvzImpianto','tfCodImp')"
	size="20" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','cbProvincia')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.cbProvincia.label')}" labelFor="widg_cbProvincia" errorFor="appDataricercaAvanzataImpianti.idProvincia" labelId="cbProvinciaLbl"
	position="last"  >


<!-- widget cbProvincia -->
	<csiuicore:ajaxify id="p_wpImpianto" 
		widgetType="combo" 
		requestUri="/sigitwebn/base/ricerca_avanz_impianti/cpRicAvzImpianto!handleCbProvincia_VALUE_CHANGED.do"
		pageId="cpRicAvzImpianto"
		formName="cpRicAvzImpianto"
		javascriptDetection="false"
		nameSpace="/base/ricerca_avanz_impianti">

<s:url id="widg_cbProvinciaurlComboBoxValueChange"
   action="/sigitwebn/cpRicAvzImpianto!handleCbProvincia_VALUE_CHANGED" namespace="/base/ricerca_avanz_impianti"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataricercaAvanzataImpianti.idProvincia" id="widg_cbProvincia"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoProvincePiemonte"
	  disabled="isWidgetDisabled('cpRicAvzImpianto','cbProvincia')"
	  listKey="code"
	  listValue="description"
	  onclick="onCBClick(this,'confermacbProvincia','conferma','%{widg_cbProvinciaurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbProvincia','conferma','%{widg_cbProvinciaurlComboBoxValueChange}')" 
	  />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','cbComune')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.cbComune.label')}" labelFor="widg_cbComune" errorFor="appDataricercaAvanzataImpianti.idComune" labelId="cbComuneLbl"
	position="first"  >


<!-- widget cbComune -->
<s:select name="appDataricercaAvanzataImpianti.idComune" id="widg_cbComune"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoComuni"
	  disabled="isWidgetDisabled('cpRicAvzImpianto','cbComune')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','tfDescComune')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.tfDescComune.label')}" labelFor="widg_tfDescComune" errorFor="appDataricercaAvanzataImpianti.descComune" labelId="tfDescComuneLbl"
	position="last"  >


<!-- widget tfDescComune -->
<s:textfield 
	
	
	name="appDataricercaAvanzataImpianti.descComune" id="widg_tfDescComune"
maxlength="50"	disabled="isWidgetDisabled('cpRicAvzImpianto','tfDescComune')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','tfIndirizzo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.tfIndirizzo.label')}" labelFor="widg_tfIndirizzo" errorFor="appDataricercaAvanzataImpianti.indirizzo" labelId="tfIndirizzoLbl"
	position="first"  >


<!-- widget tfIndirizzo -->
<s:textfield 
	
	
	name="appDataricercaAvanzataImpianti.indirizzo" id="widg_tfIndirizzo"
maxlength="50"	disabled="isWidgetDisabled('cpRicAvzImpianto','tfIndirizzo')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','wpImpianto_3_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpImpianto_3_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','tfCfResponsabile')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.tfCfResponsabile.label')}" labelFor="widg_tfCfResponsabile" errorFor="appDataricercaAvanzataImpianti.cfResponsabile" labelId="tfCfResponsabileLbl"
	position="first"  >


<!-- widget tfCfResponsabile -->
<s:textfield 
	
	
	name="appDataricercaAvanzataImpianti.cfResponsabile" id="widg_tfCfResponsabile"
maxlength="16"	disabled="isWidgetDisabled('cpRicAvzImpianto','tfCfResponsabile')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','cbStatoImp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.cbStatoImp.label')}" labelFor="widg_cbStatoImp" errorFor="appDataricercaAvanzataImpianti.statoImpianto" labelId="cbStatoImpLbl"
	position="last"  >


<!-- widget cbStatoImp -->
<s:select name="appDataricercaAvanzataImpianti.statoImpianto" id="widg_cbStatoImp"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoStatoImpianto"
	  disabled="isWidgetDisabled('cpRicAvzImpianto','cbStatoImp')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','tfSezione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.tfSezione.label')}" labelFor="widg_tfSezione" errorFor="appDataricercaAvanzataImpianti.sezione" labelId="tfSezioneLbl"
	position="first"  >


<!-- widget tfSezione -->
<s:textfield 
	
	
	name="appDataricercaAvanzataImpianti.sezione" id="widg_tfSezione"
	disabled="isWidgetDisabled('cpRicAvzImpianto','tfSezione')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','tfFoglio')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.tfFoglio.label')}" labelFor="widg_tfFoglio" errorFor="appDataricercaAvanzataImpianti.foglio" labelId="tfFoglioLbl"
	position="last"  >


<!-- widget tfFoglio -->
<s:textfield 
	
	
	name="appDataricercaAvanzataImpianti.foglio" id="widg_tfFoglio"
	disabled="isWidgetDisabled('cpRicAvzImpianto','tfFoglio')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','tfParticella')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.tfParticella.label')}" labelFor="widg_tfParticella" errorFor="appDataricercaAvanzataImpianti.particella" labelId="tfParticellaLbl"
	position="first"  >


<!-- widget tfParticella -->
<s:textfield 
	
	
	name="appDataricercaAvanzataImpianti.particella" id="widg_tfParticella"
	disabled="isWidgetDisabled('cpRicAvzImpianto','tfParticella')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','tfSubalterno')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.tfSubalterno.label')}" labelFor="widg_tfSubalterno" errorFor="appDataricercaAvanzataImpianti.subalterno" labelId="tfSubalternoLbl"
	position="last"  >


<!-- widget tfSubalterno -->
<s:textfield 
	
	
	name="appDataricercaAvanzataImpianti.subalterno" id="widg_tfSubalterno"
	disabled="isWidgetDisabled('cpRicAvzImpianto','tfSubalterno')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','tfPod')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.tfPod.label')}" labelFor="widg_tfPod" errorFor="appDataricercaAvanzataImpianti.pod" labelId="tfPodLbl"
	position="first"  >


<!-- widget tfPod -->
<s:textfield 
	
	
	name="appDataricercaAvanzataImpianti.pod" id="widg_tfPod"
maxlength="20"	disabled="isWidgetDisabled('cpRicAvzImpianto','tfPod')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','tfPdr')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.tfPdr.label')}" labelFor="widg_tfPdr" errorFor="appDataricercaAvanzataImpianti.pdr" labelId="tfPdrLbl"
	position="last"  >


<!-- widget tfPdr -->
<s:textfield 
	
	
	name="appDataricercaAvanzataImpianti.pdr" id="widg_tfPdr"
maxlength="20"	disabled="isWidgetDisabled('cpRicAvzImpianto','tfPdr')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','cbNoPdr')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.cbNoPdr.label')}" labelFor="widg_cbNoPdr" errorFor="appDataricercaAvanzataImpianti.senzaPdr" labelId="cbNoPdrLbl"
	position="first"  >


<!-- widget cbNoPdr -->
<s:checkbox 
	
	
	name="appDataricercaAvanzataImpianti.senzaPdr" id="widg_cbNoPdr"
	disabled="isWidgetDisabled('cpRicAvzImpianto','cbNoPdr')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpRicAvzImpianto','cbNoPdr')" >
	<s:hidden name="__checkbox_appDataricercaAvanzataImpianti.senzaPdr" id="__checkbox_widg_cbNoPdr" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','wpImpianto_8_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpImpianto_8_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','tfPotAcsDa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.tfPotAcsDa.label')}" labelFor="widg_tfPotAcsDa" errorFor="appDataricercaAvanzataImpianti.potenzaAcsDa" labelId="tfPotAcsDaLbl"
	position="first"  >


<!-- widget tfPotAcsDa -->
<s:textfield 
	
	
	name="appDataricercaAvanzataImpianti.potenzaAcsDa" id="widg_tfPotAcsDa"
maxlength="8"	disabled="isWidgetDisabled('cpRicAvzImpianto','tfPotAcsDa')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','tfPotAcsA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.tfPotAcsA.label')}" labelFor="widg_tfPotAcsA" errorFor="appDataricercaAvanzataImpianti.potenzaAcsA" labelId="tfPotAcsALbl"
	position="last"  >


<!-- widget tfPotAcsA -->
<s:textfield 
	
	
	name="appDataricercaAvanzataImpianti.potenzaAcsA" id="widg_tfPotAcsA"
maxlength="8"	disabled="isWidgetDisabled('cpRicAvzImpianto','tfPotAcsA')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','tfPotClmInvDa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.tfPotClmInvDa.label')}" labelFor="widg_tfPotClmInvDa" errorFor="appDataricercaAvanzataImpianti.potenzaClimaInvDa" labelId="tfPotClmInvDaLbl"
	position="first"  >


<!-- widget tfPotClmInvDa -->
<s:textfield 
	
	
	name="appDataricercaAvanzataImpianti.potenzaClimaInvDa" id="widg_tfPotClmInvDa"
maxlength="8"	disabled="isWidgetDisabled('cpRicAvzImpianto','tfPotClmInvDa')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','tfPotClmInvA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.tfPotClmInvA.label')}" labelFor="widg_tfPotClmInvA" errorFor="appDataricercaAvanzataImpianti.potenzaClimaInvA" labelId="tfPotClmInvALbl"
	position="last"  >


<!-- widget tfPotClmInvA -->
<s:textfield 
	
	
	name="appDataricercaAvanzataImpianti.potenzaClimaInvA" id="widg_tfPotClmInvA"
maxlength="8"	disabled="isWidgetDisabled('cpRicAvzImpianto','tfPotClmInvA')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','tfPotClmEstDa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.tfPotClmEstDa.label')}" labelFor="widg_tfPotClmEstDa" errorFor="appDataricercaAvanzataImpianti.potenzaClimaEstDa" labelId="tfPotClmEstDaLbl"
	position="first"  >


<!-- widget tfPotClmEstDa -->
<s:textfield 
	
	
	name="appDataricercaAvanzataImpianti.potenzaClimaEstDa" id="widg_tfPotClmEstDa"
maxlength="8"	disabled="isWidgetDisabled('cpRicAvzImpianto','tfPotClmEstDa')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','tfPotClmEstA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.tfPotClmEstA.label')}" labelFor="widg_tfPotClmEstA" errorFor="appDataricercaAvanzataImpianti.potenzaClimaEstA" labelId="tfPotClmEstALbl"
	position="last"  >


<!-- widget tfPotClmEstA -->
<s:textfield 
	
	
	name="appDataricercaAvanzataImpianti.potenzaClimaEstA" id="widg_tfPotClmEstA"
maxlength="8"	disabled="isWidgetDisabled('cpRicAvzImpianto','tfPotClmEstA')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','cbImpTipo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.cbImpTipo.label')}" labelFor="widg_cbImpTipo" errorFor="appDataricercaAvanzataImpianti.tipoImpianto" labelId="cbImpTipoLbl"
	position="first"  >


<!-- widget cbImpTipo -->
<s:select name="appDataricercaAvanzataImpianti.tipoImpianto" id="widg_cbImpTipo"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTipoImpianto"
	  disabled="isWidgetDisabled('cpRicAvzImpianto','cbImpTipo')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','cbUiExt')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.cbUiExt.label')}" labelFor="widg_cbUiExt" errorFor="appDataricercaAvanzataImpianti.flgAppareccUiExt" labelId="cbUiExtLbl"
	position="last"  >


<!-- widget cbUiExt -->
<s:select name="appDataricercaAvanzataImpianti.flgAppareccUiExt" id="widg_cbUiExt"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoSiNo"
	  disabled="isWidgetDisabled('cpRicAvzImpianto','cbUiExt')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','cbContabilizzazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.cbContabilizzazione.label')}" labelFor="widg_cbContabilizzazione" errorFor="appDataricercaAvanzataImpianti.flgContabilizzatore" labelId="cbContabilizzazioneLbl"
	position="first"  >


<!-- widget cbContabilizzazione -->
<s:select name="appDataricercaAvanzataImpianti.flgContabilizzatore" id="widg_cbContabilizzazione"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoSiNo"
	  disabled="isWidgetDisabled('cpRicAvzImpianto','cbContabilizzazione')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','wpImpianto_13_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpImpianto_13_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpImpianto --></div>

			
	
	<div id="p_wpImpresa" class="widgetsPanelBlock"><!-- startFragment:p_wpImpresa -->
	
	
<h4 class="wpLabel">impresa </h4>
<div class="widgetsPanel" id="wpImpresa">
	
	<customtag:widgetsPanel id="wpImpresaTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRicAvzImpianto','cbSglReaComp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.cbSglReaComp.label')}" labelFor="widg_cbSglReaComp" errorFor="appDataricercaAvanzataImpianti.idSiglaRea" labelId="cbSglReaCompLbl"
	  >


<!-- widget cbSglReaComp -->
<s:select name="appDataricercaAvanzataImpianti.idSiglaRea" id="widg_cbSglReaComp"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoSiglaRea"
	  disabled="isWidgetDisabled('cpRicAvzImpianto','cbSglReaComp')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','tfNumeroRea')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.tfNumeroRea.label')}" labelFor="widg_tfNumeroRea" errorFor="appDataricercaAvanzataImpianti.numeroRea" labelId="tfNumeroReaLbl"
	  >


<!-- widget tfNumeroRea -->
<s:textfield 
	
	
	name="appDataricercaAvanzataImpianti.numeroRea" id="widg_tfNumeroRea"
maxlength="11"	disabled="isWidgetDisabled('cpRicAvzImpianto','tfNumeroRea')"
	size="20" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','tfCfImpresa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.tfCfImpresa.label')}" labelFor="widg_tfCfImpresa" errorFor="appDataricercaAvanzataImpianti.cfImpresa" labelId="tfCfImpresaLbl"
	  >


<!-- widget tfCfImpresa -->
<s:textfield 
	
	
	name="appDataricercaAvanzataImpianti.cfImpresa" id="widg_tfCfImpresa"
maxlength="16"	disabled="isWidgetDisabled('cpRicAvzImpianto','tfCfImpresa')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpImpresa --></div>

			
	
	<div id="p_wpRicAvzGen" class="widgetsPanelBlock"><!-- startFragment:p_wpRicAvzGen -->
	
	
<h4 class="wpLabel">altro </h4>
<div class="widgetsPanel" id="wpRicAvzGen">
	
	<customtag:widgetsPanel id="wpRicAvzGenTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRicAvzImpianto','cbAllTipoDoc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.cbAllTipoDoc.label')}" labelFor="widg_cbAllTipoDoc" errorFor="appDataricercaAvanzataImpianti.idTipoDocumento" labelId="cbAllTipoDocLbl"
	  >


<!-- widget cbAllTipoDoc -->
<s:select name="appDataricercaAvanzataImpianti.idTipoDocumento" id="widg_cbAllTipoDoc"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTipiDocumentazione"
	  disabled="isWidgetDisabled('cpRicAvzImpianto','cbAllTipoDoc')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpRicAvzGen --></div>

			
	
	
	<div class="tabSetPanelContent">
	<div id="p_tsRicAvz" class="tabSetPanelBlock"><!-- startFragment:p_tsRicAvz -->
	
	
<div class="tabSetPanel" id="tsRicAvz">
	<ul>
		<s:url id="cpRicAvzImpianto_tsRicAvz_fpTabRicAvz_URL" action="cpRicAvzImpianto" namespace="/base/ricerca_avanz_impianti" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'cpRicAvzImpianto_tsRicAvz_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'cpRicAvzImpianto_tsRicAvz_fpTabRicAvz'}" />
		</s:url>
		<s:if test="%{#session.cpRicAvzImpianto_tsRicAvz_selectedMultiPanel == 'cpRicAvzImpianto_tsRicAvz_fpTabRicAvz' || #session.cpRicAvzImpianto_tsRicAvz_selectedMultiPanel == null}">
			<li class="item-1 active"
			title="componenti"
			>
			<span class="activeItem"><s:text name="cpRicAvzImpianto.fpTabRicAvz.label" /></span></li>
		</s:if>
		<s:else>
			<li class="item-1">

	<csiuicore:ajaxify id="p_tsRicAvz" 
		widgetType="button" 
		requestUri="/sigitwebn/base/ricerca_avanz_impianti/cpRicAvzImpianto!handle_CpRicAvzImpianto_TsRicAvz_FpTabRicAvz_CLICKED.do" 
		pageId="cpRicAvzImpianto" 
		formName="cpRicAvzImpianto"
		javascriptDetection="false">
				<s:submit name="tsRicAvz"
				          id="tsRicAvz_fpTabRicAvz"
				          method="handle_CpRicAvzImpianto_TsRicAvz_FpTabRicAvz_CLICKED"
				          title="componenti"
				          key="cpRicAvzImpianto.fpTabRicAvz.label" />
					
	</csiuicore:ajaxify>
			</li>
		</s:else>
		<s:url id="cpRicAvzImpianto_tsRicAvz_fpRicAvzAll_URL" action="cpRicAvzImpianto" namespace="/base/ricerca_avanz_impianti" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'cpRicAvzImpianto_tsRicAvz_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'cpRicAvzImpianto_tsRicAvz_fpRicAvzAll'}" />
		</s:url>
		<s:if test="%{#session.cpRicAvzImpianto_tsRicAvz_selectedMultiPanel == 'cpRicAvzImpianto_tsRicAvz_fpRicAvzAll'}">
			<li class="item-2 active"
			title="Rapporti e manutenzioni"
			>
			<span class="activeItem"><s:text name="cpRicAvzImpianto.fpRicAvzAll.label" /></span></li>
		</s:if>
		<s:else>
			<li class="item-2">

	<csiuicore:ajaxify id="p_tsRicAvz" 
		widgetType="button" 
		requestUri="/sigitwebn/base/ricerca_avanz_impianti/cpRicAvzImpianto!handle_CpRicAvzImpianto_TsRicAvz_FpRicAvzAll_CLICKED.do" 
		pageId="cpRicAvzImpianto" 
		formName="cpRicAvzImpianto"
		javascriptDetection="false">
				<s:submit name="tsRicAvz"
				          id="tsRicAvz_fpRicAvzAll"
				          method="handle_CpRicAvzImpianto_TsRicAvz_FpRicAvzAll_CLICKED"
				          title="Rapporti e manutenzioni"
				          key="cpRicAvzImpianto.fpRicAvzAll.label" />
					
	</csiuicore:ajaxify>
			</li>
		</s:else>
		<s:url id="cpRicAvzImpianto_tsRicAvz_fpRicAvz3Resp_URL" action="cpRicAvzImpianto" namespace="/base/ricerca_avanz_impianti" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'cpRicAvzImpianto_tsRicAvz_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'cpRicAvzImpianto_tsRicAvz_fpRicAvz3Resp'}" />
		</s:url>
		<s:if test="%{#session.cpRicAvzImpianto_tsRicAvz_selectedMultiPanel == 'cpRicAvzImpianto_tsRicAvz_fpRicAvz3Resp'}">
			<li class="item-3 active"
			title="3° resp"
			>
			<span class="activeItem"><s:text name="cpRicAvzImpianto.fpRicAvz3Resp.label" /></span></li>
		</s:if>
		<s:else>
			<li class="item-3">

	<csiuicore:ajaxify id="p_tsRicAvz" 
		widgetType="button" 
		requestUri="/sigitwebn/base/ricerca_avanz_impianti/cpRicAvzImpianto!handle_CpRicAvzImpianto_TsRicAvz_FpRicAvz3Resp_CLICKED.do" 
		pageId="cpRicAvzImpianto" 
		formName="cpRicAvzImpianto"
		javascriptDetection="false">
				<s:submit name="tsRicAvz"
				          id="tsRicAvz_fpRicAvz3Resp"
				          method="handle_CpRicAvzImpianto_TsRicAvz_FpRicAvz3Resp_CLICKED"
				          title="3° resp"
				          key="cpRicAvzImpianto.fpRicAvz3Resp.label" />
					
	</csiuicore:ajaxify>
			</li>
		</s:else>
	</ul>
</div>


	
		

		
<s:if test="#session.cpRicAvzImpianto_tsRicAvz_selectedMultiPanel == 'cpRicAvzImpianto_tsRicAvz_fpTabRicAvz' || #session.cpRicAvzImpianto_tsRicAvz_selectedMultiPanel == null">
	<s:include value="/jsp/tabs/cpRicAvzImpianto_tsRicAvz_fpTabRicAvz.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.cpRicAvzImpianto_tsRicAvz_selectedMultiPanel == 'cpRicAvzImpianto_tsRicAvz_fpRicAvzAll'">
	<s:include value="/jsp/tabs/cpRicAvzImpianto_tsRicAvz_fpRicAvzAll.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.cpRicAvzImpianto_tsRicAvz_selectedMultiPanel == 'cpRicAvzImpianto_tsRicAvz_fpRicAvz3Resp'">
	<s:include value="/jsp/tabs/cpRicAvzImpianto_tsRicAvz_fpRicAvz3Resp.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_tsRicAvz --></div>
	</div>

			
	
	<div id="p_cpNavRicImpianto" class="commandPanelBlock"><!-- startFragment:p_cpNavRicImpianto -->
	
	
<div class="commandPanel navigation" id="cpNavRicImpianto">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRicAvzImpianto','btIndietro')" >

	



<!-- widget btIndietro -->
<s:submit name="widg_btIndietro" id="widg_btIndietro" method="handleBtIndietro_CLICKED"
	key="cpRicAvzImpianto.btIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicAvzImpianto','btIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavRicImpianto --></div>

	

		
	

	<!-- endFragment:p_fpRicImpianto --></div>

	

	<!-- endFragment:p_fpCenterRicAvz --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout CENTER PANEL ***** -->



	</div>
	<!-- ================ FINE UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->



</div>
<!-- #################### FINE PANNELLO CONTENUTI #################### -->




</s:form>


	<s:include value="fragments/footer.jsp" ></s:include>
