<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_libretto_scheda3/CpGestLibScheda3Action" />

	
	<div id="p_fpMpRevoca" class="formPanelBlock"><!-- startFragment:p_fpMpRevoca -->
		
	


	
	

	
	
			
	
	<div id="p_wpRevResp" class="widgetsPanelBlock"><!-- startFragment:p_wpRevResp -->
	
	

<div class="widgetsPanel" id="wpRevResp">
	
	<customtag:widgetsPanel id="wpRevRespTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda3','cbTipiCessazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda3.cbTipiCessazione.label')}" labelFor="widg_cbTipiCessazione" errorFor="appDatadatiRevocaResponsabile.idTipoCessazione" labelId="cbTipiCessazioneLbl"
	  >


<!-- widget cbTipiCessazione -->
	<csiuicore:ajaxify id="p_mpAutodichiarazioni" 
		widgetType="combo" 
		requestUri="/sigitwebn/base/gestisci_libretto_scheda3/cpGestLibScheda3!handleCbTipiCessazione_VALUE_CHANGED.do"
		pageId="cpGestLibScheda3"
		formName="cpGestLibScheda3"
		javascriptDetection="false"
		nameSpace="/base/gestisci_libretto_scheda3">

<s:url id="widg_cbTipiCessazioneurlComboBoxValueChange"
   action="/sigitwebn/cpGestLibScheda3!handleCbTipiCessazione_VALUE_CHANGED" namespace="/base/gestisci_libretto_scheda3"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatadatiRevocaResponsabile.idTipoCessazione" id="widg_cbTipiCessazione"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTipiCessazione"
	  disabled="isWidgetDisabled('cpGestLibScheda3','cbTipiCessazione')"
	  listKey="id"
	  listValue="description"
	  onclick="onCBClick(this,'confermacbTipiCessazione','conferma','%{widg_cbTipiCessazioneurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbTipiCessazione','conferma','%{widg_cbTipiCessazioneurlComboBoxValueChange}')" 
	  />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda3','clDataRevoca')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda3.clDataRevoca.label')}" labelFor="widg_clDataRevoca" errorFor="appDatadatiRevocaResponsabile.dataCessazione" labelId="clDataRevocaLbl"
	  >


<!-- widget clDataRevoca -->
<s:textfield 
	
	
	name="appDatadatiRevocaResponsabile.dataCessazione" id="widg_clDataRevoca"
	disabled="isWidgetDisabled('cpGestLibScheda3','clDataRevoca')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda3','taMotivoCessazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda3.taMotivoCessazione.label')}" labelFor="widg_taMotivoCessazione" errorFor="appDatadatiRevocaResponsabile.motivoCessazione" labelId="taMotivoCessazioneLbl"
	  >


<!-- widget taMotivoCessazione -->
<s:textarea 
	
	
	name="appDatadatiRevocaResponsabile.motivoCessazione" id="widg_taMotivoCessazione"
	disabled="isWidgetDisabled('cpGestLibScheda3','taMotivoCessazione')"
	rows="2"
	cols="30"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda3','ptNote')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget ptNote -->
<s:text name="cpGestLibScheda3.ptNote.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpRevResp --></div>

			
	
	
	<div id="p_mpAutodichiarazioni" class="panelBlock"><!-- startFragment:p_mpAutodichiarazioni -->
		

		
<s:if test="#session.cpGestLibScheda3_mpAutodichiarazioni_selectedMultiPanel == 'cpGestLibScheda3_mpAutodichiarazioni_fpAutodichiarazioni'">
	<s:include value="/jsp/multipanels/cpGestLibScheda3_mpAutodichiarazioni_fpAutodichiarazioni.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpAutodichiarazioni --></div>

			
	
	<div id="p_cpConfRevoca3" class="commandPanelBlock"><!-- startFragment:p_cpConfRevoca3 -->
	
	
<div class="commandPanel functional" id="cpConfRevoca3">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpGestLibScheda3','btConfermaRevoca')" >

	



<!-- widget btConfermaRevoca -->
<s:submit name="widg_btConfermaRevoca" id="widg_btConfermaRevoca" method="handleBtConfermaRevoca_CLICKED"
	key="cpGestLibScheda3.btConfermaRevoca.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda3','btConfermaRevoca')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpConfRevoca3 --></div>

			
	
	<div id="p_cpIndietroConfRevoca3" class="commandPanelBlock"><!-- startFragment:p_cpIndietroConfRevoca3 -->
	
	
<div class="commandPanel navigation" id="cpIndietroConfRevoca3">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestLibScheda3','btIndietroConfermaCessazione')" >

	



<!-- widget btIndietroConfermaCessazione -->
<s:submit name="widg_btIndietroConfermaCessazione" id="widg_btIndietroConfermaCessazione" method="handleBtIndietroConfermaCessazione_CLICKED"
	key="cpGestLibScheda3.btIndietroConfermaCessazione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda3','btIndietroConfermaCessazione')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpIndietroConfRevoca3 --></div>

	

		
	

	<!-- endFragment:p_fpMpRevoca --></div>
