<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpTabRicAvz" class="formPanelBlock"><!-- startFragment:p_fpTabRicAvz -->
		
	
<div class="formPanel" id="fpTabRicAvz">


	
	

	
	
			
	
	<div id="p_wpTabCompPanel" class="widgetsPanelBlock"><!-- startFragment:p_wpTabCompPanel -->
	
	
<h4 class="wpLabel">componenti libretto </h4>
<div class="widgetsPanel" id="wpTabCompPanel">
	
	<customtag:widgetsPanel id="wpTabCompPanelTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRicAvzImpianto','cbTipoComp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.cbTipoComp.label')}" labelFor="widg_cbTipoComp" errorFor="appDataricercaAvanzataImpianti.tipoComponente" labelId="cbTipoCompLbl"
	position="first"  >


<!-- widget cbTipoComp -->
	<csiuicore:ajaxify id="p_wpTabCompPanel" 
		widgetType="combo" 
		requestUri="/sigitwebn/base/ricerca_avanz_impianti/cpRicAvzImpianto!handleCbTipoComp_VALUE_CHANGED.do"
		pageId="cpRicAvzImpianto"
		formName="cpRicAvzImpianto"
		javascriptDetection="false"
		nameSpace="/base/ricerca_avanz_impianti">

<s:url id="widg_cbTipoCompurlComboBoxValueChange"
   action="/sigitwebn/cpRicAvzImpianto!handleCbTipoComp_VALUE_CHANGED" namespace="/base/ricerca_avanz_impianti"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataricercaAvanzataImpianti.tipoComponente" id="widg_cbTipoComp"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTipoComponenti"
	  disabled="isWidgetDisabled('cpRicAvzImpianto','cbTipoComp')"
	  listKey="code"
	  listValue="description"
	  onclick="onCBClick(this,'confermacbTipoComp','conferma','%{widg_cbTipoCompurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbTipoComp','conferma','%{widg_cbTipoCompurlComboBoxValueChange}')" 
	  />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','chAll')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.chAll.label')}" labelFor="widg_chAll" errorFor="appDataricercaAvanzataImpianti.flgDismesse" labelId="chAllLbl"
	position="last"  >


<!-- widget chAll -->
<s:checkbox 
	
	
	name="appDataricercaAvanzataImpianti.flgDismesse" id="widg_chAll"
	disabled="isWidgetDisabled('cpRicAvzImpianto','chAll')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpRicAvzImpianto','chAll')" >
	<s:hidden name="__checkbox_appDataricercaAvanzataImpianti.flgDismesse" id="__checkbox_widg_chAll" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','cbMarca')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.cbMarca.label')}" labelFor="widg_cbMarca" errorFor="appDataricercaAvanzataImpianti.marca" labelId="cbMarcaLbl"
	position="first"  >


<!-- widget cbMarca -->
<s:select name="appDataricercaAvanzataImpianti.marca" id="widg_cbMarca"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoMarche"
	  disabled="isWidgetDisabled('cpRicAvzImpianto','cbMarca')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','wpTabCompPanel_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpTabCompPanel_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','cbCombu')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.cbCombu.label')}" labelFor="widg_cbCombu" errorFor="appDataricercaAvanzataImpianti.combustibile" labelId="cbCombuLbl"
	position="first"  >


<!-- widget cbCombu -->
<s:select name="appDataricercaAvanzataImpianti.combustibile" id="widg_cbCombu"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoCombustibili"
	  disabled="isWidgetDisabled('cpRicAvzImpianto','cbCombu')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','wpTabCompPanel_3_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpTabCompPanel_3_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','tfRendPercDa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.tfRendPercDa.label')}" labelFor="widg_tfRendPercDa" errorFor="appDataricercaAvanzataImpianti.rendimentoPercDa" labelId="tfRendPercDaLbl"
	position="first"  >


<!-- widget tfRendPercDa -->
<s:textfield 
	
	
	name="appDataricercaAvanzataImpianti.rendimentoPercDa" id="widg_tfRendPercDa"
maxlength="6"	disabled="isWidgetDisabled('cpRicAvzImpianto','tfRendPercDa')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','tfRendPercA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.tfRendPercA.label')}" labelFor="widg_tfRendPercA" errorFor="appDataricercaAvanzataImpianti.rendimentoPercA" labelId="tfRendPercALbl"
	position="last"  >


<!-- widget tfRendPercA -->
<s:textfield 
	
	
	name="appDataricercaAvanzataImpianti.rendimentoPercA" id="widg_tfRendPercA"
maxlength="6"	disabled="isWidgetDisabled('cpRicAvzImpianto','tfRendPercA')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','tfPotenzaDa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.tfPotenzaDa.label')}" labelFor="widg_tfPotenzaDa" errorFor="appDataricercaAvanzataImpianti.potenzaTermicaDa" labelId="tfPotenzaDaLbl"
	position="first"  >


<!-- widget tfPotenzaDa -->
<s:textfield 
	
	
	name="appDataricercaAvanzataImpianti.potenzaTermicaDa" id="widg_tfPotenzaDa"
maxlength="6"	disabled="isWidgetDisabled('cpRicAvzImpianto','tfPotenzaDa')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','tfPotenzaA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.tfPotenzaA.label')}" labelFor="widg_tfPotenzaA" errorFor="appDataricercaAvanzataImpianti.potenzaTermicaA" labelId="tfPotenzaALbl"
	position="last"  >


<!-- widget tfPotenzaA -->
<s:textfield 
	
	
	name="appDataricercaAvanzataImpianti.potenzaTermicaA" id="widg_tfPotenzaA"
maxlength="6"	disabled="isWidgetDisabled('cpRicAvzImpianto','tfPotenzaA')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','clDtInstallDa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.clDtInstallDa.label')}" labelFor="widg_clDtInstallDa" errorFor="appDataricercaAvanzataImpianti.dataInstallazioneDa" labelId="clDtInstallDaLbl"
	position="first"  >


<!-- widget clDtInstallDa -->
<s:textfield 
	
	
	name="appDataricercaAvanzataImpianti.dataInstallazioneDa" id="widg_clDtInstallDa"
	disabled="isWidgetDisabled('cpRicAvzImpianto','clDtInstallDa')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','clDtInstallA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.clDtInstallA.label')}" labelFor="widg_clDtInstallA" errorFor="appDataricercaAvanzataImpianti.dataInstallazioneA" labelId="clDtInstallALbl"
	position="last"  >


<!-- widget clDtInstallA -->
<s:textfield 
	
	
	name="appDataricercaAvanzataImpianti.dataInstallazioneA" id="widg_clDtInstallA"
	disabled="isWidgetDisabled('cpRicAvzImpianto','clDtInstallA')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpTabCompPanel --></div>

			
	
	<div id="p_cpFunRicImpianto" class="commandPanelBlock"><!-- startFragment:p_cpFunRicImpianto -->
	
	
<div class="commandPanel functional" id="cpFunRicImpianto">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRicAvzImpianto','btRicComp')" >

	



<!-- widget btRicComp -->
<s:submit name="widg_btRicComp" id="widg_btRicComp" method="handleBtRicComp_CLICKED"
	key="cpRicAvzImpianto.btRicComp.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicAvzImpianto','btRicComp')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRicAvzImpianto','btnAnnullaRicImpiantoCom')" >

	



<!-- widget btnAnnullaRicImpiantoCom -->
<s:submit name="widg_btnAnnullaRicImpiantoCom" id="widg_btnAnnullaRicImpiantoCom" method="handleBtnAnnullaRicImpiantoCom_CLICKED"
	key="cpRicAvzImpianto.btnAnnullaRicImpiantoCom.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicAvzImpianto','btnAnnullaRicImpiantoCom')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunRicImpianto --></div>

	

		
	
</div>

	<!-- endFragment:p_fpTabRicAvz --></div>
