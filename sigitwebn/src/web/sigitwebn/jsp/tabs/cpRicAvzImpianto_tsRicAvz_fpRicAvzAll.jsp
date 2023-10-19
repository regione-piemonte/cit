<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpRicAvzAll" class="formPanelBlock"><!-- startFragment:p_fpRicAvzAll -->
		
	
<div class="formPanel" id="fpRicAvzAll">


	
	

	
	
			
	
	<div id="p_wpRicAvzRee" class="widgetsPanelBlock"><!-- startFragment:p_wpRicAvzRee -->
	
	
<h4 class="wpLabel">altro </h4>
<div class="widgetsPanel" id="wpRicAvzRee">
	
	<customtag:widgetsPanel id="wpRicAvzReeTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRicAvzImpianto','cbAllTipoRapp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.cbAllTipoRapp.label')}" labelFor="widg_cbAllTipoRapp" errorFor="appDataricercaAvanzataImpianti.tipoRapporto" labelId="cbAllTipoRappLbl"
	  >


<!-- widget cbAllTipoRapp -->
	<csiuicore:ajaxify id="p_wpRicAvzRee,p_wpTabAllPanel" 
		widgetType="combo" 
		requestUri="/sigitwebn/base/ricerca_avanz_impianti/cpRicAvzImpianto!handleCbAllTipoRapp_VALUE_CHANGED.do"
		pageId="cpRicAvzImpianto"
		formName="cpRicAvzImpianto"
		javascriptDetection="false"
		nameSpace="/base/ricerca_avanz_impianti">

<s:url id="widg_cbAllTipoRappurlComboBoxValueChange"
   action="/sigitwebn/cpRicAvzImpianto!handleCbAllTipoRapp_VALUE_CHANGED" namespace="/base/ricerca_avanz_impianti"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataricercaAvanzataImpianti.tipoRapporto" id="widg_cbAllTipoRapp"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTipoRapporto"
	  disabled="isWidgetDisabled('cpRicAvzImpianto','cbAllTipoRapp')"
	  listKey="code"
	  listValue="description"
	  onclick="onCBClick(this,'confermacbAllTipoRapp','conferma','%{widg_cbAllTipoRappurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbAllTipoRapp','conferma','%{widg_cbAllTipoRappurlComboBoxValueChange}')" 
	  />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','cbRicAvzSic')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.cbRicAvzSic.label')}" labelFor="widg_cbRicAvzSic" errorFor="appDataricercaAvanzataImpianti.sicurezzaImpianti" labelId="cbRicAvzSicLbl"
	  >


<!-- widget cbRicAvzSic -->
<s:select name="appDataricercaAvanzataImpianti.sicurezzaImpianti" id="widg_cbRicAvzSic"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoSiNo"
	  disabled="isWidgetDisabled('cpRicAvzImpianto','cbRicAvzSic')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','chAllConPresc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.chAllConPresc.label')}" labelFor="widg_chAllConPresc" errorFor="appDataricercaAvanzataImpianti.conPrescrizioni" labelId="chAllConPrescLbl"
	  >


<!-- widget chAllConPresc -->
<s:checkbox 
	
	
	name="appDataricercaAvanzataImpianti.conPrescrizioni" id="widg_chAllConPresc"
	disabled="isWidgetDisabled('cpRicAvzImpianto','chAllConPresc')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpRicAvzImpianto','chAllConPresc')" >
	<s:hidden name="__checkbox_appDataricercaAvanzataImpianti.conPrescrizioni" id="__checkbox_widg_chAllConPresc" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','chAllConRacc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.chAllConRacc.label')}" labelFor="widg_chAllConRacc" errorFor="appDataricercaAvanzataImpianti.conRaccomandazioni" labelId="chAllConRaccLbl"
	  >


<!-- widget chAllConRacc -->
<s:checkbox 
	
	
	name="appDataricercaAvanzataImpianti.conRaccomandazioni" id="widg_chAllConRacc"
	disabled="isWidgetDisabled('cpRicAvzImpianto','chAllConRacc')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpRicAvzImpianto','chAllConRacc')" >
	<s:hidden name="__checkbox_appDataricercaAvanzataImpianti.conRaccomandazioni" id="__checkbox_widg_chAllConRacc" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','chAllConOss')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.chAllConOss.label')}" labelFor="widg_chAllConOss" errorFor="appDataricercaAvanzataImpianti.conOsservazioni" labelId="chAllConOssLbl"
	  >


<!-- widget chAllConOss -->
<s:checkbox 
	
	
	name="appDataricercaAvanzataImpianti.conOsservazioni" id="widg_chAllConOss"
	disabled="isWidgetDisabled('cpRicAvzImpianto','chAllConOss')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpRicAvzImpianto','chAllConOss')" >
	<s:hidden name="__checkbox_appDataricercaAvanzataImpianti.conOsservazioni" id="__checkbox_widg_chAllConOss" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','cbAllVerAss')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.cbAllVerAss.label')}" labelFor="widg_cbAllVerAss" errorFor="appDataricercaAvanzataImpianti.flgVerificaAssociata" labelId="cbAllVerAssLbl"
	  >


<!-- widget cbAllVerAss -->
<s:select name="appDataricercaAvanzataImpianti.flgVerificaAssociata" id="widg_cbAllVerAss"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoSiNo"
	  disabled="isWidgetDisabled('cpRicAvzImpianto','cbAllVerAss')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpRicAvzRee --></div>

			
	
	<div id="p_wpTabAllPanel" class="widgetsPanelBlock"><!-- startFragment:p_wpTabAllPanel -->
	
	
<h4 class="wpLabel">rapporti di controllo </h4>
<div class="widgetsPanel" id="wpTabAllPanel">
	
	<customtag:widgetsPanel id="wpTabAllPanelTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRicAvzImpianto','clAllDatContrDa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.clAllDatContrDa.label')}" labelFor="widg_clAllDatContrDa" errorFor="appDataricercaAvanzataImpianti.dataControlloDa" labelId="clAllDatContrDaLbl"
	position="first"  >


<!-- widget clAllDatContrDa -->
<s:textfield 
	
	
	name="appDataricercaAvanzataImpianti.dataControlloDa" id="widg_clAllDatContrDa"
	disabled="isWidgetDisabled('cpRicAvzImpianto','clAllDatContrDa')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','clAllDatContrA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.clAllDatContrA.label')}" labelFor="widg_clAllDatContrA" errorFor="appDataricercaAvanzataImpianti.dataControlloA" labelId="clAllDatContrALbl"
	position="last"  >


<!-- widget clAllDatContrA -->
<s:textfield 
	
	
	name="appDataricercaAvanzataImpianti.dataControlloA" id="widg_clAllDatContrA"
	disabled="isWidgetDisabled('cpRicAvzImpianto','clAllDatContrA')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','clAllIntManRaccDa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.clAllIntManRaccDa.label')}" labelFor="widg_clAllIntManRaccDa" errorFor="appDataricercaAvanzataImpianti.interventoManutentivoDa" labelId="clAllIntManRaccDaLbl"
	position="first"  >


<!-- widget clAllIntManRaccDa -->
<s:textfield 
	
	
	name="appDataricercaAvanzataImpianti.interventoManutentivoDa" id="widg_clAllIntManRaccDa"
	disabled="isWidgetDisabled('cpRicAvzImpianto','clAllIntManRaccDa')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','clAllIntMantRaccA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.clAllIntMantRaccA.label')}" labelFor="widg_clAllIntMantRaccA" errorFor="appDataricercaAvanzataImpianti.interventoManutentivoA" labelId="clAllIntMantRaccALbl"
	position="last"  >


<!-- widget clAllIntMantRaccA -->
<s:textfield 
	
	
	name="appDataricercaAvanzataImpianti.interventoManutentivoA" id="widg_clAllIntMantRaccA"
	disabled="isWidgetDisabled('cpRicAvzImpianto','clAllIntMantRaccA')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','tfNumGiorniDopoDataControllo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.tfNumGiorniDopoDataControllo.label')}" labelFor="widg_tfNumGiorniDopoDataControllo" errorFor="appDataricercaAvanzataImpianti.numGiorniInviatoDopoDataControllo" labelId="tfNumGiorniDopoDataControlloLbl"
	position="first"  >


<!-- widget tfNumGiorniDopoDataControllo -->
<s:textfield 
	
	
	name="appDataricercaAvanzataImpianti.numGiorniInviatoDopoDataControllo" id="widg_tfNumGiorniDopoDataControllo"
	disabled="isWidgetDisabled('cpRicAvzImpianto','tfNumGiorniDopoDataControllo')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','ptNumGiorniDopoDataControllogg')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpRicAvzImpianto.ptNumGiorniDopoDataControllogg.label')}" labelFor="widg_ptNumGiorniDopoDataControllogg" errorFor="widg_ptNumGiorniDopoDataControllogg" labelId="ptNumGiorniDopoDataControlloggLbl"  position="last" >


<!-- widget ptNumGiorniDopoDataControllogg -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','cbAllUMisNox')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.cbAllUMisNox.label')}" labelFor="widg_cbAllUMisNox" errorFor="appDataricercaAvanzataImpianti.idTipoUnitaMisura" labelId="cbAllUMisNoxLbl"
	position="first"  >


<!-- widget cbAllUMisNox -->
<s:select name="appDataricercaAvanzataImpianti.idTipoUnitaMisura" id="widg_cbAllUMisNox"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoUnitMisuraNox"
	  disabled="isWidgetDisabled('cpRicAvzImpianto','cbAllUMisNox')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','wpTabAllPanel_4_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpTabAllPanel_4_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','tfNoxDa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.tfNoxDa.label')}" labelFor="widg_tfNoxDa" errorFor="appDataricercaAvanzataImpianti.noxDa" labelId="tfNoxDaLbl"
	position="first"  >


<!-- widget tfNoxDa -->
<s:textfield 
	
	
	name="appDataricercaAvanzataImpianti.noxDa" id="widg_tfNoxDa"
maxlength="6"	disabled="isWidgetDisabled('cpRicAvzImpianto','tfNoxDa')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','tfNoxA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.tfNoxA.label')}" labelFor="widg_tfNoxA" errorFor="appDataricercaAvanzataImpianti.noxA" labelId="tfNoxALbl"
	position="last"  >


<!-- widget tfNoxA -->
<s:textfield 
	
	
	name="appDataricercaAvanzataImpianti.noxA" id="widg_tfNoxA"
maxlength="6"	disabled="isWidgetDisabled('cpRicAvzImpianto','tfNoxA')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','cbAllSigleBoll')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.cbAllSigleBoll.label')}" labelFor="widg_cbAllSigleBoll" errorFor="appDataricercaAvanzataImpianti.siglaBollino" labelId="cbAllSigleBollLbl"
	position="first"  >


<!-- widget cbAllSigleBoll -->
<s:select name="appDataricercaAvanzataImpianti.siglaBollino" id="widg_cbAllSigleBoll"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoSigleBollino"
	  disabled="isWidgetDisabled('cpRicAvzImpianto','cbAllSigleBoll')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','tfAllNumBoll')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.tfAllNumBoll.label')}" labelFor="widg_tfAllNumBoll" errorFor="appDataricercaAvanzataImpianti.numeroBollino" labelId="tfAllNumBollLbl"
	position="last"  >


<!-- widget tfAllNumBoll -->
<s:textfield 
	
	
	name="appDataricercaAvanzataImpianti.numeroBollino" id="widg_tfAllNumBoll"
maxlength="11"	disabled="isWidgetDisabled('cpRicAvzImpianto','tfAllNumBoll')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','cbElencoCat')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.cbElencoCat.label')}" labelFor="widg_cbElencoCat" errorFor="appDataricercaAvanzataImpianti.idIncaricato" labelId="cbElencoCatLbl"
	position="first"  >


<!-- widget cbElencoCat -->
<s:select name="appDataricercaAvanzataImpianti.idIncaricato" id="widg_cbElencoCat"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoCat"
	  disabled="isWidgetDisabled('cpRicAvzImpianto','cbElencoCat')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','wpTabAllPanel_7_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpTabAllPanel_7_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpTabAllPanel --></div>

			
	
	<div id="p_cpFunRicAvzImpiantoAll" class="commandPanelBlock"><!-- startFragment:p_cpFunRicAvzImpiantoAll -->
	
	
<div class="commandPanel functional" id="cpFunRicAvzImpiantoAll">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRicAvzImpianto','btRicAll')" >

	



<!-- widget btRicAll -->
<s:submit name="widg_btRicAll" id="widg_btRicAll" method="handleBtRicAll_CLICKED"
	key="cpRicAvzImpianto.btRicAll.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicAvzImpianto','btRicAll')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRicAvzImpianto','btnAnnullaRicImpiantoAll')" >

	



<!-- widget btnAnnullaRicImpiantoAll -->
<s:submit name="widg_btnAnnullaRicImpiantoAll" id="widg_btnAnnullaRicImpiantoAll" method="handleBtnAnnullaRicImpiantoAll_CLICKED"
	key="cpRicAvzImpianto.btnAnnullaRicImpiantoAll.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicAvzImpianto','btnAnnullaRicImpiantoAll')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunRicAvzImpiantoAll --></div>

	

		
	
</div>

	<!-- endFragment:p_fpRicAvzAll --></div>
