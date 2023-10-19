<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpAssegnaA" class="formPanelBlock"><!-- startFragment:p_fpAssegnaA -->
		
	
<div class="formPanel" id="fpAssegnaA">


	
	

	
	
			
	
	<div id="p_wpAssegnaA" class="widgetsPanelBlock"><!-- startFragment:p_wpAssegnaA -->
	
	
<h4 class="wpLabel">dati assegnazione </h4>
<div class="widgetsPanel" id="wpAssegnaA">
	
	<customtag:widgetsPanel id="wpAssegnaATbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpDettaglioSanzione','cbComboValidatori')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioSanzione.cbComboValidatori.label')}" labelFor="widg_cbComboValidatori" errorFor="appDatasanzione.idValidatoreScelto" labelId="cbComboValidatoriLbl"
	  >


<!-- widget cbComboValidatori -->
<s:select name="appDatasanzione.idValidatoreScelto" id="widg_cbComboValidatori"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoValidatori"
	  disabled="isWidgetDisabled('cpDettaglioSanzione','cbComboValidatori')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioSanzione','cbComboIspettori')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioSanzione.cbComboIspettori.label')}" labelFor="widg_cbComboIspettori" errorFor="appDatasanzione.idIspettoreScelto" labelId="cbComboIspettoriLbl"
	  >


<!-- widget cbComboIspettori -->
<s:select name="appDatasanzione.idIspettoreScelto" id="widg_cbComboIspettori"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoIspettori"
	  disabled="isWidgetDisabled('cpDettaglioSanzione','cbComboIspettori')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAssegnaA --></div>

			
	
	<div id="p_cpAssegnaA" class="commandPanelBlock"><!-- startFragment:p_cpAssegnaA -->
	
	
<div class="commandPanel functional" id="cpAssegnaA">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpDettaglioSanzione','btnConfermaAssegnazione')" >

	



<!-- widget btnConfermaAssegnazione -->
<s:submit name="widg_btnConfermaAssegnazione" id="widg_btnConfermaAssegnazione" method="handleBtnConfermaAssegnazione_CLICKED"
	key="cpDettaglioSanzione.btnConfermaAssegnazione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioSanzione','btnConfermaAssegnazione')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpDettaglioSanzione','btnAnnullaAssegnazione')" >

	



<!-- widget btnAnnullaAssegnazione -->
<s:submit name="widg_btnAnnullaAssegnazione" id="widg_btnAnnullaAssegnazione" method="handleBtnAnnullaAssegnazione_CLICKED"
	key="cpDettaglioSanzione.btnAnnullaAssegnazione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioSanzione','btnAnnullaAssegnazione')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpAssegnaA --></div>

	

		
	
</div>

	<!-- endFragment:p_fpAssegnaA --></div>
