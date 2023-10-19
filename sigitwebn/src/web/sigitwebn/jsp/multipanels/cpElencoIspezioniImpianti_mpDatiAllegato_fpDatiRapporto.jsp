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
	

	
	
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','calDataControllo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpElencoIspezioniImpianti.calDataControllo.label')}" labelFor="widg_calDataControllo" errorFor="appDataallegatoIsp.dataControllo" labelId="calDataControlloLbl"
	  >


<!-- widget calDataControllo -->
<s:textfield 
	
	
	name="appDataallegatoIsp.dataControllo" id="widg_calDataControllo"
	disabled="isWidgetDisabled('cpElencoIspezioniImpianti','calDataControllo')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','cbTipoAllegato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpElencoIspezioniImpianti.cbTipoAllegato.label')}" labelFor="widg_cbTipoAllegato" errorFor="appDataallegatoIsp.idTipoAllegato" labelId="cbTipoAllegatoLbl"
	  >


<!-- widget cbTipoAllegato -->
	<csiuicore:ajaxify id="p_fpCenter" 
		widgetType="combo" 
		requestUri="/sigitwebn/base/elenco_ispezioni_impianti/cpElencoIspezioniImpianti!handleCbTipoAllegato_VALUE_CHANGED.do"
		pageId="cpElencoIspezioniImpianti"
		formName="cpElencoIspezioniImpianti"
		javascriptDetection="false"
		nameSpace="/base/elenco_ispezioni_impianti">

<s:url id="widg_cbTipoAllegatourlComboBoxValueChange"
   action="/sigitwebn/cpElencoIspezioniImpianti!handleCbTipoAllegato_VALUE_CHANGED" namespace="/base/elenco_ispezioni_impianti"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataallegatoIsp.idTipoAllegato" id="widg_cbTipoAllegato"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTipiDocumentoProfilatiIsp"
	  disabled="isWidgetDisabled('cpElencoIspezioniImpianti','cbTipoAllegato')"
	  listKey="code"
	  listValue="description"
	  onclick="onCBClick(this,'confermacbTipoAllegato','conferma','%{widg_cbTipoAllegatourlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbTipoAllegato','conferma','%{widg_cbTipoAllegatourlComboBoxValueChange}')" 
	  />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','cbCombustibile')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpElencoIspezioniImpianti.cbCombustibile.label')}" labelFor="widg_cbCombustibile" errorFor="appDataallegatoIsp.idTipiCombustibile" labelId="cbCombustibileLbl"
	  >


<!-- widget cbCombustibile -->
<s:select name="appDataallegatoIsp.idTipiCombustibile" id="widg_cbCombustibile"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTipiCombustibileIsp"
	  disabled="isWidgetDisabled('cpElencoIspezioniImpianti','cbCombustibile')"
	  multiple="true"
	  cssClass="selectMultiple"          
	  size="5"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','ptCombustibili')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpElencoIspezioniImpianti.ptCombustibili.label')}" labelFor="widg_ptCombustibili" errorFor="appDataallegatoIsp.elencoCombustibili" labelId="ptCombustibiliLbl"   >


<!-- widget ptCombustibili -->
<s:property value="appDataallegatoIsp.elencoCombustibili" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','btnFiltraComp')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget btnFiltraComp -->
<s:submit name="widg_btnFiltraComp" id="widg_btnFiltraComp" method="handleBtnFiltraComp_CLICKED"
	key="cpElencoIspezioniImpianti.btnFiltraComp.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoIspezioniImpianti','btnFiltraComp')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','cbApparecchiature')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpElencoIspezioniImpianti.cbApparecchiature.label')}" labelFor="widg_cbApparecchiature" errorFor="appDataallegatoIsp.idApparecchiature" labelId="cbApparecchiatureLbl"
	  >


<!-- widget cbApparecchiature -->
<s:select name="appDataallegatoIsp.idApparecchiature" id="widg_cbApparecchiature"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoApparecchiatureIsp"
	  disabled="isWidgetDisabled('cpElencoIspezioniImpianti','cbApparecchiature')"
	  multiple="true"
	  cssClass="selectMultiple"          
	  size="5"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','ptApparecchiature')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpElencoIspezioniImpianti.ptApparecchiature.label')}" labelFor="widg_ptApparecchiature" errorFor="appDataallegatoIsp.elencoApparecchiature" labelId="ptApparecchiatureLbl"   >


<!-- widget ptApparecchiature -->
<s:property value="appDataallegatoIsp.elencoApparecchiature" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','ptSiglaBollino')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpElencoIspezioniImpianti.ptSiglaBollino.label')}" labelFor="widg_ptSiglaBollino" errorFor="appDataallegatoIsp.siglaBollino" labelId="ptSiglaBollinoLbl"   >


<!-- widget ptSiglaBollino -->
<s:property value="appDataallegatoIsp.siglaBollino" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','ptNumeroBollinoVerde')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpElencoIspezioniImpianti.ptNumeroBollinoVerde.label')}" labelFor="widg_ptNumeroBollinoVerde" errorFor="appDataallegatoIsp.numeroBollinoVerde" labelId="ptNumeroBollinoVerdeLbl"   >


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
		
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','btnAnnullaDatiAllegato')" >

	



<!-- widget btnAnnullaDatiAllegato -->
<s:submit name="widg_btnAnnullaDatiAllegato" id="widg_btnAnnullaDatiAllegato" method="handleBtnAnnullaDatiAllegato_CLICKED"
	key="cpElencoIspezioniImpianti.btnAnnullaDatiAllegato.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoIspezioniImpianti','btnAnnullaDatiAllegato')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunDatiRapporto --></div>

			
	
	<div id="p_cpNavDatiRapporto" class="commandPanelBlock"><!-- startFragment:p_cpNavDatiRapporto -->
	
	
<div class="commandPanel navigation" id="cpNavDatiRapporto">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','btnChiudiDatiAllegato')" >

	



<!-- widget btnChiudiDatiAllegato -->
<s:submit name="widg_btnChiudiDatiAllegato" id="widg_btnChiudiDatiAllegato" method="handleBtnChiudiDatiAllegato_CLICKED"
	key="cpElencoIspezioniImpianti.btnChiudiDatiAllegato.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoIspezioniImpianti','btnChiudiDatiAllegato')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','btnCreaAllegato')" >

	



<!-- widget btnCreaAllegato -->
<s:submit name="widg_btnCreaAllegato" id="widg_btnCreaAllegato" method="handleBtnCreaAllegato_CLICKED"
	key="cpElencoIspezioniImpianti.btnCreaAllegato.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoIspezioniImpianti','btnCreaAllegato')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavDatiRapporto --></div>

	

		
	
</div>

	<!-- endFragment:p_fpDatiRapporto --></div>
