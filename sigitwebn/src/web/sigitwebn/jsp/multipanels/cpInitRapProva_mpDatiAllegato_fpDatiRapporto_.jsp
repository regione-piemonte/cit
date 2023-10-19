<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpDatiRapporto_" class="formPanelBlock"><!-- startFragment:p_fpDatiRapporto_ -->
		
	
<div class="formPanel" id="fpDatiRapporto_">


	
	

	
	
			
	
	<div id="p_wpDatiRapportoIspeImpianti_" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiRapportoIspeImpianti_ -->
	
	
<h4 class="wpLabel">dati rapporto di prova </h4>
<div class="widgetsPanel" id="wpDatiRapportoIspeImpianti_">
	
	<customtag:widgetsPanel id="wpDatiRapportoIspeImpianti_Tbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpInitRapProva','calDataControllo_')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInitRapProva.calDataControllo_.label')}" labelFor="widg_calDataControllo_" errorFor="appDataRicercaApparecchiatureRappProva.dataIspezione" labelId="calDataControllo_Lbl"
	  >


<!-- widget calDataControllo_ -->
<s:textfield 
	
	
	name="appDataRicercaApparecchiatureRappProva.dataIspezione" id="widg_calDataControllo_"
	disabled="isWidgetDisabled('cpInitRapProva','calDataControllo_')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpInitRapProva','tfOra_')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInitRapProva.tfOra_.label')}" labelFor="widg_tfOra_" errorFor="appDataRicercaApparecchiatureRappProva.oraIspezione" labelId="tfOra_Lbl"
	  >


<!-- widget tfOra_ -->
<s:textfield 
	
	
	name="appDataRicercaApparecchiatureRappProva.oraIspezione" id="widg_tfOra_"
	disabled="isWidgetDisabled('cpInitRapProva','tfOra_')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpInitRapProva','cbTipoAllegato_')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInitRapProva.cbTipoAllegato_.label')}" labelFor="widg_cbTipoAllegato_" errorFor="appDataRicercaApparecchiatureRappProva.idTipoAllegato" labelId="cbTipoAllegato_Lbl"
	  >


<!-- widget cbTipoAllegato_ -->
<s:select name="appDataRicercaApparecchiatureRappProva.idTipoAllegato" id="widg_cbTipoAllegato_"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTipiDocumentoProfilatiIsp"
	  disabled="isWidgetDisabled('cpInitRapProva','cbTipoAllegato_')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpInitRapProva','cbCombustibile_')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInitRapProva.cbCombustibile_.label')}" labelFor="widg_cbCombustibile_" errorFor="appDataallegatoIsp.idTipiCombustibile" labelId="cbCombustibile_Lbl"
	  >


<!-- widget cbCombustibile_ -->
	<csiuicore:ajaxify id="p_wpDatiRapportoIspeImpianti_" 
		widgetType="combo" 
		requestUri="/sigitwebn/base/gestisci_rapprova/cpInitRapProva!handleCbCombustibile__VALUE_CHANGED.do"
		pageId="cpInitRapProva"
		formName="cpInitRapProva"
		javascriptDetection="false"
		nameSpace="/base/gestisci_rapprova">

<s:url id="widg_cbCombustibile_urlComboBoxValueChange"
   action="/sigitwebn/cpInitRapProva!handleCbCombustibile__VALUE_CHANGED" namespace="/base/gestisci_rapprova"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataallegatoIsp.idTipiCombustibile" id="widg_cbCombustibile_"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTipiCombustibileIsp"
	  disabled="isWidgetDisabled('cpInitRapProva','cbCombustibile_')"
	  multiple="true"
	  cssClass="selectMultiple"          
	  size="5"
	  listKey="code"
	  listValue="description"
	  onclick="onCBClick(this,'confermacbCombustibile_','conferma','%{widg_cbCombustibile_urlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbCombustibile_','conferma','%{widg_cbCombustibile_urlComboBoxValueChange}')" 
	  />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpInitRapProva','cbApparecchiature_')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInitRapProva.cbApparecchiature_.label')}" labelFor="widg_cbApparecchiature_" errorFor="appDataallegatoIsp.idApparecchiature" labelId="cbApparecchiature_Lbl"
	  >


<!-- widget cbApparecchiature_ -->
<s:select name="appDataallegatoIsp.idApparecchiature" id="widg_cbApparecchiature_"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoApparecchiatureIsp"
	  disabled="isWidgetDisabled('cpInitRapProva','cbApparecchiature_')"
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

	<!-- endFragment:p_wpDatiRapportoIspeImpianti_ --></div>

			
	
	<div id="p_cpFunDatiRapporto_" class="commandPanelBlock"><!-- startFragment:p_cpFunDatiRapporto_ -->
	
	
<div class="commandPanel functional" id="cpFunDatiRapporto_">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpInitRapProva','btnAnnullaDatiAllegato_')" >

	



<!-- widget btnAnnullaDatiAllegato_ -->
<s:submit name="widg_btnAnnullaDatiAllegato_" id="widg_btnAnnullaDatiAllegato_" method="handleBtnAnnullaDatiAllegato__CLICKED"
	key="cpInitRapProva.btnAnnullaDatiAllegato_.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpInitRapProva','btnAnnullaDatiAllegato_')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunDatiRapporto_ --></div>

			
	
	<div id="p_cpNavDatiRapporto_" class="commandPanelBlock"><!-- startFragment:p_cpNavDatiRapporto_ -->
	
	
<div class="commandPanel navigation" id="cpNavDatiRapporto_">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpInitRapProva','btnChiudiDatiAllegato_')" >

	



<!-- widget btnChiudiDatiAllegato_ -->
<s:submit name="widg_btnChiudiDatiAllegato_" id="widg_btnChiudiDatiAllegato_" method="handleBtnChiudiDatiAllegato__CLICKED"
	key="cpInitRapProva.btnChiudiDatiAllegato_.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpInitRapProva','btnChiudiDatiAllegato_')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpInitRapProva','btnCreaAllegato_')" >

	



<!-- widget btnCreaAllegato_ -->
<s:submit name="widg_btnCreaAllegato_" id="widg_btnCreaAllegato_" method="handleBtnCreaAllegato__CLICKED"
	key="cpInitRapProva.btnCreaAllegato_.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpInitRapProva','btnCreaAllegato_')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavDatiRapporto_ --></div>

	

		
	
</div>

	<!-- endFragment:p_fpDatiRapporto_ --></div>
