<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpSanzionato" class="formPanelBlock"><!-- startFragment:p_fpSanzionato -->
		
	
<div class="formPanel" id="fpSanzionato">


	
	

	
	
			
	
	<div id="p_wpPersonaSanzionata" class="widgetsPanelBlock"><!-- startFragment:p_wpPersonaSanzionata -->
	
	
<h4 class="wpLabel">persona sanzionata </h4>
<div class="widgetsPanel" id="wpPersonaSanzionata">
	
	<customtag:widgetsPanel id="wpPersonaSanzionataTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpInserisciNotificaSanzione','rbRespIsImpresa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciNotificaSanzione.rbRespIsImpresa.label')}" labelFor="widg_rbRespIsImpresa" errorFor="appDatadatiInserimentoSanzione.flgEnteImpresa" labelId="rbRespIsImpresaLbl"
	position="first"  >


<!-- widget rbRespIsImpresa -->

	
<div id="appDatadatiInserimentoSanzione.flgEnteImpresa" class="radiobuttons ">







<s:url id="widg_rbRespIsImpresaurlRadioButtonValueChange"
   action="/sigitwebn/cpInserisciNotificaSanzione!handleRbRespIsImpresa_VALUE_CHANGED" namespace="/base/gestisci_sanzioni"  
   includeParams="all" portletUrlType="action" 
/>

<s:radio
	
	
	id="widg_rbIsImpresaSI" name="appDatadatiInserimentoSanzione.flgEnteImpresa"
	list="#{'true':'SI'}"
	disabled="isWidgetDisabled('cpInserisciNotificaSanzione','rbRespIsImpresa')"
	cssClass="radio"
	onclick="onRBClick('%{widg_rbRespIsImpresaurlRadioButtonValueChange}')" 
	/> <label  for="widg_rbIsImpresaSItrue"><s:text name="cpInserisciNotificaSanzione.rbRespIsImpresa.rbIsImpresaSI.label" /></label>








<s:radio
	
	
	id="widg_rbIsImpresaNO" name="appDatadatiInserimentoSanzione.flgEnteImpresa"
	list="#{'false':'NO'}"
	disabled="isWidgetDisabled('cpInserisciNotificaSanzione','rbRespIsImpresa')"
	cssClass="radio"
	onclick="onRBClick('%{widg_rbRespIsImpresaurlRadioButtonValueChange}')" 
	/> <label  for="widg_rbIsImpresaNOfalse"><s:text name="cpInserisciNotificaSanzione.rbRespIsImpresa.rbIsImpresaNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciNotificaSanzione','wpPersonaSanzionata_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpPersonaSanzionata_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciNotificaSanzione','tfCodiceFiscale')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciNotificaSanzione.tfCodiceFiscale.label')}" labelFor="widg_tfCodiceFiscale" errorFor="appDatadatiInserimentoSanzione.codiceFiscale" labelId="tfCodiceFiscaleLbl"
	position="first"  >


<!-- widget tfCodiceFiscale -->
<s:textfield 
	
	
	name="appDatadatiInserimentoSanzione.codiceFiscale" id="widg_tfCodiceFiscale"
	disabled="isWidgetDisabled('cpInserisciNotificaSanzione','tfCodiceFiscale')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciNotificaSanzione','btCercaCodiceFiscale')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btCercaCodiceFiscale -->
<s:submit name="widg_btCercaCodiceFiscale" id="widg_btCercaCodiceFiscale" method="handleBtCercaCodiceFiscale_CLICKED"
	key="cpInserisciNotificaSanzione.btCercaCodiceFiscale.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpInserisciNotificaSanzione','btCercaCodiceFiscale')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciNotificaSanzione','tfCognome')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciNotificaSanzione.tfCognome.label')}" labelFor="widg_tfCognome" errorFor="appDatadatiInserimentoSanzione.denominazione" labelId="tfCognomeLbl"
	position="first"  >


<!-- widget tfCognome -->
<s:textfield 
	
	
	name="appDatadatiInserimentoSanzione.denominazione" id="widg_tfCognome"
	disabled="isWidgetDisabled('cpInserisciNotificaSanzione','tfCognome')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciNotificaSanzione','btNuovaRicerca')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btNuovaRicerca -->
<s:submit name="widg_btNuovaRicerca" id="widg_btNuovaRicerca" method="handleBtNuovaRicerca_CLICKED"
	key="cpInserisciNotificaSanzione.btNuovaRicerca.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpInserisciNotificaSanzione','btNuovaRicerca')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciNotificaSanzione','tfNome')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciNotificaSanzione.tfNome.label')}" labelFor="widg_tfNome" errorFor="appDatadatiInserimentoSanzione.nome" labelId="tfNomeLbl"
	position="first"  >


<!-- widget tfNome -->
<s:textfield 
	
	
	name="appDatadatiInserimentoSanzione.nome" id="widg_tfNome"
	disabled="isWidgetDisabled('cpInserisciNotificaSanzione','tfNome')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciNotificaSanzione','wpPersonaSanzionata_4_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpPersonaSanzionata_4_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciNotificaSanzione','cbRespIndirizzoEst')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciNotificaSanzione.cbRespIndirizzoEst.label')}" labelFor="widg_cbRespIndirizzoEst" errorFor="appDatadatiInserimentoSanzione.flgIndirizzoEstero" labelId="cbRespIndirizzoEstLbl"
	position="first"  >


<!-- widget cbRespIndirizzoEst -->
<s:checkbox 
	
	
	name="appDatadatiInserimentoSanzione.flgIndirizzoEstero" id="widg_cbRespIndirizzoEst"
	disabled="isWidgetDisabled('cpInserisciNotificaSanzione','cbRespIndirizzoEst')"
	cssClass="checkbox"
	onclick="onRBClick('/sigitwebn/base/gestisci_sanzioni/cpInserisciNotificaSanzione!handleCbRespIndirizzoEst_VALUE_CHANGED.do')" 
	/> 
<s:if test="!isWidgetDisabled('cpInserisciNotificaSanzione','cbRespIndirizzoEst')" >
	<s:hidden name="__checkbox_appDatadatiInserimentoSanzione.flgIndirizzoEstero" id="__checkbox_widg_cbRespIndirizzoEst" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciNotificaSanzione','wpPersonaSanzionata_5_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpPersonaSanzionata_5_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciNotificaSanzione','cbProvincia')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciNotificaSanzione.cbProvincia.label')}" labelFor="widg_cbProvincia" errorFor="appDatadatiInserimentoSanzione.idProvincia" labelId="cbProvinciaLbl"
	position="first"  >


<!-- widget cbProvincia -->
	<csiuicore:ajaxify id="p_wpPersonaSanzionata" 
		widgetType="combo" 
		requestUri="/sigitwebn/base/gestisci_sanzioni/cpInserisciNotificaSanzione!handleCbProvincia_VALUE_CHANGED.do"
		pageId="cpInserisciNotificaSanzione"
		formName="cpInserisciNotificaSanzione"
		javascriptDetection="false"
		nameSpace="/base/gestisci_sanzioni">

<s:url id="widg_cbProvinciaurlComboBoxValueChange"
   action="/sigitwebn/cpInserisciNotificaSanzione!handleCbProvincia_VALUE_CHANGED" namespace="/base/gestisci_sanzioni"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatadatiInserimentoSanzione.idProvincia" id="widg_cbProvincia"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoProvince"
	  disabled="isWidgetDisabled('cpInserisciNotificaSanzione','cbProvincia')"
	  listKey="code"
	  listValue="description"
	  onclick="onCBClick(this,'confermacbProvincia','conferma','%{widg_cbProvinciaurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbProvincia','conferma','%{widg_cbProvinciaurlComboBoxValueChange}')" 
	  />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciNotificaSanzione','wpPersonaSanzionata_6_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpPersonaSanzionata_6_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciNotificaSanzione','cbComune')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciNotificaSanzione.cbComune.label')}" labelFor="widg_cbComune" errorFor="appDatadatiInserimentoSanzione.idComune" labelId="cbComuneLbl"
	position="first"  >


<!-- widget cbComune -->
<s:select name="appDatadatiInserimentoSanzione.idComune" id="widg_cbComune"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoComuni"
	  disabled="isWidgetDisabled('cpInserisciNotificaSanzione','cbComune')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciNotificaSanzione','wpPersonaSanzionata_7_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpPersonaSanzionata_7_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciNotificaSanzione','tfIndirizzo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciNotificaSanzione.tfIndirizzo.label')}" labelFor="widg_tfIndirizzo" errorFor="appDatadatiInserimentoSanzione.indirizzo" labelId="tfIndirizzoLbl"
	position="first"  >


<!-- widget tfIndirizzo -->
<s:textfield 
	
	
	name="appDatadatiInserimentoSanzione.indirizzo" id="widg_tfIndirizzo"
	disabled="isWidgetDisabled('cpInserisciNotificaSanzione','tfIndirizzo')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciNotificaSanzione','btnCercaIndirizzo')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnCercaIndirizzo -->
<s:submit name="widg_btnCercaIndirizzo" id="widg_btnCercaIndirizzo" method="handleBtnCercaIndirizzo_CLICKED"
	key="cpInserisciNotificaSanzione.btnCercaIndirizzo.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpInserisciNotificaSanzione','btnCercaIndirizzo')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciNotificaSanzione','cbIndirizzo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciNotificaSanzione.cbIndirizzo.label')}" labelFor="widg_cbIndirizzo" errorFor="appDatadatiInserimentoSanzione.idIndirizzo" labelId="cbIndirizzoLbl"
	position="first"  >


<!-- widget cbIndirizzo -->
<s:select name="appDatadatiInserimentoSanzione.idIndirizzo" id="widg_cbIndirizzo"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoIndirizziSanzionato"
	  disabled="isWidgetDisabled('cpInserisciNotificaSanzione','cbIndirizzo')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciNotificaSanzione','btnNuovaRicercaIndirizzo')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnNuovaRicercaIndirizzo -->
<s:submit name="widg_btnNuovaRicercaIndirizzo" id="widg_btnNuovaRicercaIndirizzo" method="handleBtnNuovaRicercaIndirizzo_CLICKED"
	key="cpInserisciNotificaSanzione.btnNuovaRicercaIndirizzo.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpInserisciNotificaSanzione','btnNuovaRicercaIndirizzo')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciNotificaSanzione','tfNoStradario')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciNotificaSanzione.tfNoStradario.label')}" labelFor="widg_tfNoStradario" errorFor="appDatadatiInserimentoSanzione.indirizzoNoStradario" labelId="tfNoStradarioLbl"
	position="first"  >


<!-- widget tfNoStradario -->
<s:textfield 
	
	
	name="appDatadatiInserimentoSanzione.indirizzoNoStradario" id="widg_tfNoStradario"
maxlength="200"	disabled="isWidgetDisabled('cpInserisciNotificaSanzione','tfNoStradario')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciNotificaSanzione','wpPersonaSanzionata_10_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpPersonaSanzionata_10_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciNotificaSanzione','tfCivico')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciNotificaSanzione.tfCivico.label')}" labelFor="widg_tfCivico" errorFor="appDatadatiInserimentoSanzione.civico" labelId="tfCivicoLbl"
	position="first"  >


<!-- widget tfCivico -->
<s:textfield 
	
	
	name="appDatadatiInserimentoSanzione.civico" id="widg_tfCivico"
	disabled="isWidgetDisabled('cpInserisciNotificaSanzione','tfCivico')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciNotificaSanzione','wpPersonaSanzionata_11_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpPersonaSanzionata_11_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciNotificaSanzione','tfStatoEstero')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciNotificaSanzione.tfStatoEstero.label')}" labelFor="widg_tfStatoEstero" errorFor="appDatadatiInserimentoSanzione.statoEstero" labelId="tfStatoEsteroLbl"
	position="first"  >


<!-- widget tfStatoEstero -->
<s:textfield 
	
	
	name="appDatadatiInserimentoSanzione.statoEstero" id="widg_tfStatoEstero"
	disabled="isWidgetDisabled('cpInserisciNotificaSanzione','tfStatoEstero')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciNotificaSanzione','wpPersonaSanzionata_12_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpPersonaSanzionata_12_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciNotificaSanzione','tfCittaEstera')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciNotificaSanzione.tfCittaEstera.label')}" labelFor="widg_tfCittaEstera" errorFor="appDatadatiInserimentoSanzione.comuneEstero" labelId="tfCittaEsteraLbl"
	position="first"  >


<!-- widget tfCittaEstera -->
<s:textfield 
	
	
	name="appDatadatiInserimentoSanzione.comuneEstero" id="widg_tfCittaEstera"
	disabled="isWidgetDisabled('cpInserisciNotificaSanzione','tfCittaEstera')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciNotificaSanzione','wpPersonaSanzionata_13_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpPersonaSanzionata_13_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciNotificaSanzione','tfIndirizzoEstero')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciNotificaSanzione.tfIndirizzoEstero.label')}" labelFor="widg_tfIndirizzoEstero" errorFor="appDatadatiInserimentoSanzione.indirizzoEstero" labelId="tfIndirizzoEsteroLbl"
	position="first"  >


<!-- widget tfIndirizzoEstero -->
<s:textfield 
	
	
	name="appDatadatiInserimentoSanzione.indirizzoEstero" id="widg_tfIndirizzoEstero"
	disabled="isWidgetDisabled('cpInserisciNotificaSanzione','tfIndirizzoEstero')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciNotificaSanzione','wpPersonaSanzionata_14_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpPersonaSanzionata_14_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciNotificaSanzione','tfCivicoEstero')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciNotificaSanzione.tfCivicoEstero.label')}" labelFor="widg_tfCivicoEstero" errorFor="appDatadatiInserimentoSanzione.civicoEstero" labelId="tfCivicoEsteroLbl"
	position="first"  >


<!-- widget tfCivicoEstero -->
<s:textfield 
	
	
	name="appDatadatiInserimentoSanzione.civicoEstero" id="widg_tfCivicoEstero"
	disabled="isWidgetDisabled('cpInserisciNotificaSanzione','tfCivicoEstero')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciNotificaSanzione','wpPersonaSanzionata_15_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpPersonaSanzionata_15_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciNotificaSanzione','tfCapEstero')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciNotificaSanzione.tfCapEstero.label')}" labelFor="widg_tfCapEstero" errorFor="appDatadatiInserimentoSanzione.capEstero" labelId="tfCapEsteroLbl"
	position="first"  >


<!-- widget tfCapEstero -->
<s:textfield 
	
	
	name="appDatadatiInserimentoSanzione.capEstero" id="widg_tfCapEstero"
	disabled="isWidgetDisabled('cpInserisciNotificaSanzione','tfCapEstero')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciNotificaSanzione','wpPersonaSanzionata_16_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpPersonaSanzionata_16_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpPersonaSanzionata --></div>

	

		
	
</div>

	<!-- endFragment:p_fpSanzionato --></div>
