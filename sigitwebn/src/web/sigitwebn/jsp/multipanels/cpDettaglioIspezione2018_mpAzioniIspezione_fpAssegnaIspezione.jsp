<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpAssegnaIspezione" class="formPanelBlock"><!-- startFragment:p_fpAssegnaIspezione -->
		
	
<div class="formPanel" id="fpAssegnaIspezione">


	
	

	
	
			
	
	<div id="p_wpAssegnaIspezione" class="widgetsPanelBlock"><!-- startFragment:p_wpAssegnaIspezione -->
	
	
<h4 class="wpLabel">assegna ispezione </h4>
<div class="widgetsPanel" id="wpAssegnaIspezione">
	
	<customtag:widgetsPanel id="wpAssegnaIspezioneTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','cbElencoIspettori')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioIspezione2018.cbElencoIspettori.label')}" labelFor="widg_cbElencoIspettori" errorFor="appDataIspettoreScelto" labelId="cbElencoIspettoriLbl"
	  >


<!-- widget cbElencoIspettori -->
<s:select name="appDataIspettoreScelto" id="widg_cbElencoIspettori"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoIspettori"
	  disabled="isWidgetDisabled('cpDettaglioIspezione2018','cbElencoIspettori')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAssegnaIspezione --></div>

			
	
	<div id="p_cpAssegna" class="commandPanelBlock"><!-- startFragment:p_cpAssegna -->
	
	
<div class="commandPanel functional" id="cpAssegna">

	
	
		
		
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','btConfermaAssegnazione')" >

	



<!-- widget btConfermaAssegnazione -->
<s:submit name="widg_btConfermaAssegnazione" id="widg_btConfermaAssegnazione" method="handleBtConfermaAssegnazione_CLICKED"
	key="cpDettaglioIspezione2018.btConfermaAssegnazione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioIspezione2018','btConfermaAssegnazione')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','btAnnullaAssegnazione')" >

	



<!-- widget btAnnullaAssegnazione -->
<s:submit name="widg_btAnnullaAssegnazione" id="widg_btAnnullaAssegnazione" method="handleBtAnnullaAssegnazione_CLICKED"
	key="cpDettaglioIspezione2018.btAnnullaAssegnazione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioIspezione2018','btAnnullaAssegnazione')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cpAssegna --></div>

	

		
	
</div>

	<!-- endFragment:p_fpAssegnaIspezione --></div>
