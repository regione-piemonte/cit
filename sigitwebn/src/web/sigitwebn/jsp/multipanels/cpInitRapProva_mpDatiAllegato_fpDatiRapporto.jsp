<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpDatiRapporto" class="formPanelBlock"><!-- startFragment:p_fpDatiRapporto -->
		
	
<div class="formPanel" id="fpDatiRapporto">


	
	

	
	
			
	
	<div id="p_wpDatiRapportoIspeImpianti" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiRapportoIspeImpianti -->
	
	
<h4 class="wpLabel">dati rapporto di prova </h4>
<div class="widgetsPanel" id="wpDatiRapportoIspeImpianti">
	
	<customtag:widgetsPanel id="wpDatiRapportoIspeImpiantiTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpInitRapProva','calDataControllo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInitRapProva.calDataControllo.label')}" labelFor="widg_calDataControllo" errorFor="appDataRicercaApparecchiatureRappProva.dataIspezione" labelId="calDataControlloLbl"
	  >


<!-- widget calDataControllo -->
<s:textfield 
	
	
	name="appDataRicercaApparecchiatureRappProva.dataIspezione" id="widg_calDataControllo"
	disabled="isWidgetDisabled('cpInitRapProva','calDataControllo')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpInitRapProva','tfOra')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInitRapProva.tfOra.label')}" labelFor="widg_tfOra" errorFor="appDataRicercaApparecchiatureRappProva.oraIspezione" labelId="tfOraLbl"
	  >


<!-- widget tfOra -->
<s:textfield 
	
	
	name="appDataRicercaApparecchiatureRappProva.oraIspezione" id="widg_tfOra"
	disabled="isWidgetDisabled('cpInitRapProva','tfOra')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpInitRapProva','cbTipoAllegato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInitRapProva.cbTipoAllegato.label')}" labelFor="widg_cbTipoAllegato" errorFor="appDataRicercaApparecchiatureRappProva.idTipoAllegato" labelId="cbTipoAllegatoLbl"
	  >


<!-- widget cbTipoAllegato -->
<s:select name="appDataRicercaApparecchiatureRappProva.idTipoAllegato" id="widg_cbTipoAllegato"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTipiDocumentoProfilatiIsp"
	  disabled="isWidgetDisabled('cpInitRapProva','cbTipoAllegato')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpInitRapProva','btnCerca')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget btnCerca -->
<s:submit name="widg_btnCerca" id="widg_btnCerca" method="handleBtnCerca_CLICKED"
	key="cpInitRapProva.btnCerca.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpInitRapProva','btnCerca')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpInitRapProva','btnNuovaCerca')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget btnNuovaCerca -->
<s:submit name="widg_btnNuovaCerca" id="widg_btnNuovaCerca" method="handleBtnNuovaCerca_CLICKED"
	key="cpInitRapProva.btnNuovaCerca.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpInitRapProva','btnNuovaCerca')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpInitRapProva','cbCombustibile')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInitRapProva.cbCombustibile.label')}" labelFor="widg_cbCombustibile" errorFor="appDataallegatoIsp.idTipiCombustibile" labelId="cbCombustibileLbl"
	  >


<!-- widget cbCombustibile -->
	<csiuicore:ajaxify id="p_wpDatiRapportoIspeImpianti" 
		widgetType="combo" 
		requestUri="/sigitwebn/base/gestisci_rapprova/cpInitRapProva!handleCbCombustibile_VALUE_CHANGED.do"
		pageId="cpInitRapProva"
		formName="cpInitRapProva"
		javascriptDetection="false"
		nameSpace="/base/gestisci_rapprova">

<s:url id="widg_cbCombustibileurlComboBoxValueChange"
   action="/sigitwebn/cpInitRapProva!handleCbCombustibile_VALUE_CHANGED" namespace="/base/gestisci_rapprova"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataallegatoIsp.idTipiCombustibile" id="widg_cbCombustibile"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTipiCombustibileIsp"
	  disabled="isWidgetDisabled('cpInitRapProva','cbCombustibile')"
	  multiple="true"
	  cssClass="selectMultiple"          
	  size="5"
	  listKey="code"
	  listValue="description"
	  onclick="onCBClick(this,'confermacbCombustibile','conferma','%{widg_cbCombustibileurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbCombustibile','conferma','%{widg_cbCombustibileurlComboBoxValueChange}')" 
	  />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpInitRapProva','cbApparecchiature')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInitRapProva.cbApparecchiature.label')}" labelFor="widg_cbApparecchiature" errorFor="appDataallegatoIsp.idApparecchiature" labelId="cbApparecchiatureLbl"
	  >


<!-- widget cbApparecchiature -->
<s:select name="appDataallegatoIsp.idApparecchiature" id="widg_cbApparecchiature"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoApparecchiatureIsp"
	  disabled="isWidgetDisabled('cpInitRapProva','cbApparecchiature')"
	  multiple="true"
	  cssClass="selectMultiple"          
	  size="5"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDatiRapportoIspeImpianti --></div>

			
	
	<div id="p_cpFunDatiRapporto" class="commandPanelBlock"><!-- startFragment:p_cpFunDatiRapporto -->
	
	
<div class="commandPanel functional" id="cpFunDatiRapporto">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpInitRapProva','btnAnnullaDatiAllegato')" >

	



<!-- widget btnAnnullaDatiAllegato -->
<s:submit name="widg_btnAnnullaDatiAllegato" id="widg_btnAnnullaDatiAllegato" method="handleBtnAnnullaDatiAllegato_CLICKED"
	key="cpInitRapProva.btnAnnullaDatiAllegato.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpInitRapProva','btnAnnullaDatiAllegato')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunDatiRapporto --></div>

			
	
	<div id="p_cpNavDatiRapporto" class="commandPanelBlock"><!-- startFragment:p_cpNavDatiRapporto -->
	
	
<div class="commandPanel navigation" id="cpNavDatiRapporto">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpInitRapProva','btnChiudiDatiAllegato')" >

	



<!-- widget btnChiudiDatiAllegato -->
<s:submit name="widg_btnChiudiDatiAllegato" id="widg_btnChiudiDatiAllegato" method="handleBtnChiudiDatiAllegato_CLICKED"
	key="cpInitRapProva.btnChiudiDatiAllegato.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpInitRapProva','btnChiudiDatiAllegato')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpInitRapProva','btnCreaAllegato')" >

	



<!-- widget btnCreaAllegato -->
<s:submit name="widg_btnCreaAllegato" id="widg_btnCreaAllegato" method="handleBtnCreaAllegato_CLICKED"
	key="cpInitRapProva.btnCreaAllegato.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpInitRapProva','btnCreaAllegato')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavDatiRapporto --></div>

	

		
	
</div>

	<!-- endFragment:p_fpDatiRapporto --></div>
