<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpDatiDocumento" class="formPanelBlock"><!-- startFragment:p_fpDatiDocumento -->
		
	
<div class="formPanel" id="fpDatiDocumento">


	
	

	
	
			
	
	<div id="p_wpFileDocumento" class="widgetsPanelBlock"><!-- startFragment:p_wpFileDocumento -->
	
	
<h4 class="wpLabel">dati documento </h4>
<div class="widgetsPanel" id="wpFileDocumento">
	
	<customtag:widgetsPanel id="wpFileDocumentoTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpElencoDocumentiImpianti','fuUploadDoc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpElencoDocumentiImpianti.fuUploadDoc.label')}" labelFor="widg_fuUploadDoc" errorFor="widg_fuUploadDoc" labelId="fuUploadDocLbl"
	  >


<s:file 
	
	
	name="widg_fuUploadDoc" id="widg_fuUploadDoc"
	disabled="isWidgetDisabled('cpElencoDocumentiImpianti','fuUploadDoc')"
	
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpFileDocumento --></div>

			
	
	<div id="p_wpDatiDocumento" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiDocumento -->
	
	

<div class="widgetsPanel" id="wpDatiDocumento">
	
	<customtag:widgetsPanel id="wpDatiDocumentoTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpElencoDocumentiImpianti','cbTipoDoc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpElencoDocumentiImpianti.cbTipoDoc.label')}" labelFor="widg_cbTipoDoc" errorFor="appDatadocumento.idTipoDocumento" labelId="cbTipoDocLbl"
	  >


<!-- widget cbTipoDoc -->
	<csiuicore:ajaxify id="p_wpDatiDocumento" 
		widgetType="combo" 
		requestUri="/sigitwebn/base/elenco_documenti_impianti/cpElencoDocumentiImpianti!handleCbTipoDoc_VALUE_CHANGED.do"
		pageId="cpElencoDocumentiImpianti"
		formName="cpElencoDocumentiImpianti"
		javascriptDetection="false"
		nameSpace="/base/elenco_documenti_impianti">

<s:url id="widg_cbTipoDocurlComboBoxValueChange"
   action="/sigitwebn/cpElencoDocumentiImpianti!handleCbTipoDoc_VALUE_CHANGED" namespace="/base/elenco_documenti_impianti"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatadocumento.idTipoDocumento" id="widg_cbTipoDoc"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTipiDocumentazione"
	  disabled="isWidgetDisabled('cpElencoDocumentiImpianti','cbTipoDoc')"
	  listKey="code"
	  listValue="description"
	  onclick="onCBClick(this,'confermacbTipoDoc','conferma','%{widg_cbTipoDocurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbTipoDoc','conferma','%{widg_cbTipoDocurlComboBoxValueChange}')" 
	  />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpElencoDocumentiImpianti','tfAltroDoc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpElencoDocumentiImpianti.tfAltroDoc.label')}" labelFor="widg_tfAltroDoc" errorFor="appDatadocumento.descAltroDoc" labelId="tfAltroDocLbl"
	  >


<!-- widget tfAltroDoc -->
<s:textfield 
	
	
	name="appDatadocumento.descAltroDoc" id="widg_tfAltroDoc"
maxlength="100"	disabled="isWidgetDisabled('cpElencoDocumentiImpianti','tfAltroDoc')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDatiDocumento --></div>

			
	
	<div id="p_cpNavDatiDocumento" class="commandPanelBlock"><!-- startFragment:p_cpNavDatiDocumento -->
	
	
<div class="commandPanel navigation" id="cpNavDatiDocumento">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpElencoDocumentiImpianti','btnChiudiDatiDocumento')" >

	



<!-- widget btnChiudiDatiDocumento -->
<s:submit name="widg_btnChiudiDatiDocumento" id="widg_btnChiudiDatiDocumento" method="handleBtnChiudiDatiDocumento_CLICKED"
	key="cpElencoDocumentiImpianti.btnChiudiDatiDocumento.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoDocumentiImpianti','btnChiudiDatiDocumento')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpElencoDocumentiImpianti','btnCaricaDocumento')" >

	



<!-- widget btnCaricaDocumento -->
<s:submit name="widg_btnCaricaDocumento" id="widg_btnCaricaDocumento" method="handleBtnCaricaDocumento_CLICKED"
	key="cpElencoDocumentiImpianti.btnCaricaDocumento.label" cssClass="buttonWidget confirm"
	disabled="isWidgetDisabled('cpElencoDocumentiImpianti','btnCaricaDocumento')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavDatiDocumento --></div>

	

		
	
</div>

	<!-- endFragment:p_fpDatiDocumento --></div>
