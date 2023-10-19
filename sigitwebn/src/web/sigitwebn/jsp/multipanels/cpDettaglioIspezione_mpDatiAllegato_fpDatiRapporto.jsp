<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpDatiRapporto" class="formPanelBlock"><!-- startFragment:p_fpDatiRapporto -->
		
	
<div class="formPanel" id="fpDatiRapporto">


	
	

	
	
			
	
	<div id="p_wpDatiRapportoIspeImpianti" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiRapportoIspeImpianti -->
	
	
<h4 class="wpLabel">dati REE </h4>
<div class="widgetsPanel" id="wpDatiRapportoIspeImpianti">
	
	<customtag:widgetsPanel id="wpDatiRapportoIspeImpiantiTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpDettaglioIspezione','calDataControllo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioIspezione.calDataControllo.label')}" labelFor="widg_calDataControllo" errorFor="appDataRicercaApparecchiatureRappProva.dataIspezione" labelId="calDataControlloLbl"
	  >


<!-- widget calDataControllo -->
<s:textfield 
	
	
	name="appDataRicercaApparecchiatureRappProva.dataIspezione" id="widg_calDataControllo"
	disabled="isWidgetDisabled('cpDettaglioIspezione','calDataControllo')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioIspezione','tfOra')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioIspezione.tfOra.label')}" labelFor="widg_tfOra" errorFor="appDataRicercaApparecchiatureRappProva.oraIspezione" labelId="tfOraLbl"
	  >


<!-- widget tfOra -->
<s:textfield 
	
	
	name="appDataRicercaApparecchiatureRappProva.oraIspezione" id="widg_tfOra"
	disabled="isWidgetDisabled('cpDettaglioIspezione','tfOra')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioIspezione','cbTipoAllegato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioIspezione.cbTipoAllegato.label')}" labelFor="widg_cbTipoAllegato" errorFor="appDataRicercaApparecchiatureRappProva.idTipoAllegato" labelId="cbTipoAllegatoLbl"
	  >


<!-- widget cbTipoAllegato -->
	<csiuicore:ajaxify id="p_fpDatiRapporto" 
		widgetType="combo" 
		requestUri="/sigitwebn/base/elenco_ispezioni_impianti/cpDettaglioIspezione!handleCbTipoAllegato_VALUE_CHANGED.do"
		pageId="cpDettaglioIspezione"
		formName="cpDettaglioIspezione"
		javascriptDetection="false"
		nameSpace="/base/elenco_ispezioni_impianti">

<s:url id="widg_cbTipoAllegatourlComboBoxValueChange"
   action="/sigitwebn/cpDettaglioIspezione!handleCbTipoAllegato_VALUE_CHANGED" namespace="/base/elenco_ispezioni_impianti"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataRicercaApparecchiatureRappProva.idTipoAllegato" id="widg_cbTipoAllegato"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTipiDocumentoProfilatiIsp"
	  disabled="isWidgetDisabled('cpDettaglioIspezione','cbTipoAllegato')"
	  listKey="code"
	  listValue="description"
	  onclick="onCBClick(this,'confermacbTipoAllegato','conferma','%{widg_cbTipoAllegatourlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbTipoAllegato','conferma','%{widg_cbTipoAllegatourlComboBoxValueChange}')" 
	  />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioIspezione','btnCerca')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget btnCerca -->
<s:submit name="widg_btnCerca" id="widg_btnCerca" method="handleBtnCerca_CLICKED"
	key="cpDettaglioIspezione.btnCerca.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioIspezione','btnCerca')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioIspezione','btnNuovaCerca')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget btnNuovaCerca -->
<s:submit name="widg_btnNuovaCerca" id="widg_btnNuovaCerca" method="handleBtnNuovaCerca_CLICKED"
	key="cpDettaglioIspezione.btnNuovaCerca.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioIspezione','btnNuovaCerca')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioIspezione','cbCombustibile')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioIspezione.cbCombustibile.label')}" labelFor="widg_cbCombustibile" errorFor="appDataallegatoIsp.idTipiCombustibile" labelId="cbCombustibileLbl"
	  >


<!-- widget cbCombustibile -->
<s:select name="appDataallegatoIsp.idTipiCombustibile" id="widg_cbCombustibile"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTipiCombustibileIsp"
	  disabled="isWidgetDisabled('cpDettaglioIspezione','cbCombustibile')"
	  multiple="true"
	  cssClass="selectMultiple"          
	  size="5"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioIspezione','ptCombustibili')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioIspezione.ptCombustibili.label')}" labelFor="widg_ptCombustibili" errorFor="appDataallegatoIsp.elencoCombustibili" labelId="ptCombustibiliLbl"   >


<!-- widget ptCombustibili -->
<s:property value="appDataallegatoIsp.elencoCombustibili" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioIspezione','btnFiltraComp')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget btnFiltraComp -->
<s:submit name="widg_btnFiltraComp" id="widg_btnFiltraComp" method="handleBtnFiltraComp_CLICKED"
	key="cpDettaglioIspezione.btnFiltraComp.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioIspezione','btnFiltraComp')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioIspezione','cbApparecchiature')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioIspezione.cbApparecchiature.label')}" labelFor="widg_cbApparecchiature" errorFor="appDataallegatoIsp.idApparecchiature" labelId="cbApparecchiatureLbl"
	  >


<!-- widget cbApparecchiature -->
<s:select name="appDataallegatoIsp.idApparecchiature" id="widg_cbApparecchiature"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoApparecchiatureIsp"
	  disabled="isWidgetDisabled('cpDettaglioIspezione','cbApparecchiature')"
	  multiple="true"
	  cssClass="selectMultiple"          
	  size="5"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioIspezione','ptApparecchiature')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioIspezione.ptApparecchiature.label')}" labelFor="widg_ptApparecchiature" errorFor="appDataallegatoIsp.elencoApparecchiature" labelId="ptApparecchiatureLbl"   >


<!-- widget ptApparecchiature -->
<s:property value="appDataallegatoIsp.elencoApparecchiature" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioIspezione','ptSiglaBollino')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioIspezione.ptSiglaBollino.label')}" labelFor="widg_ptSiglaBollino" errorFor="appDataallegatoIsp.siglaBollino" labelId="ptSiglaBollinoLbl"   >


<!-- widget ptSiglaBollino -->
<s:property value="appDataallegatoIsp.siglaBollino" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioIspezione','ptNumeroBollinoVerde')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioIspezione.ptNumeroBollinoVerde.label')}" labelFor="widg_ptNumeroBollinoVerde" errorFor="appDataallegatoIsp.numeroBollinoVerde" labelId="ptNumeroBollinoVerdeLbl"   >


<!-- widget ptNumeroBollinoVerde -->
<s:property value="appDataallegatoIsp.numeroBollinoVerde" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDatiRapportoIspeImpianti --></div>

			
	
	<div id="p_cpFunDatiRapporto" class="commandPanelBlock"><!-- startFragment:p_cpFunDatiRapporto -->
	
	
<div class="commandPanel functional" id="cpFunDatiRapporto">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpDettaglioIspezione','btnAnnullaDatiAllegato')" >

	



<!-- widget btnAnnullaDatiAllegato -->
<s:submit name="widg_btnAnnullaDatiAllegato" id="widg_btnAnnullaDatiAllegato" method="handleBtnAnnullaDatiAllegato_CLICKED"
	key="cpDettaglioIspezione.btnAnnullaDatiAllegato.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioIspezione','btnAnnullaDatiAllegato')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunDatiRapporto --></div>

			
	
	<div id="p_cpNavDatiRapporto" class="commandPanelBlock"><!-- startFragment:p_cpNavDatiRapporto -->
	
	
<div class="commandPanel navigation" id="cpNavDatiRapporto">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpDettaglioIspezione','btnChiudiDatiAllegato')" >

	



<!-- widget btnChiudiDatiAllegato -->
<s:submit name="widg_btnChiudiDatiAllegato" id="widg_btnChiudiDatiAllegato" method="handleBtnChiudiDatiAllegato_CLICKED"
	key="cpDettaglioIspezione.btnChiudiDatiAllegato.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioIspezione','btnChiudiDatiAllegato')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpDettaglioIspezione','btnCreaAllegato')" >

	



<!-- widget btnCreaAllegato -->
<s:submit name="widg_btnCreaAllegato" id="widg_btnCreaAllegato" method="handleBtnCreaAllegato_CLICKED"
	key="cpDettaglioIspezione.btnCreaAllegato.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioIspezione','btnCreaAllegato')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavDatiRapporto --></div>

	

		
	
</div>

	<!-- endFragment:p_fpDatiRapporto --></div>
