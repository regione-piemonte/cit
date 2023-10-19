<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpNuovaFormazione" class="formPanelBlock"><!-- startFragment:p_fpNuovaFormazione -->
		
	
<div class="formPanel" id="fpNuovaFormazione">


	
	

	
	
			
	
	<div id="p_wpNuovaFormazione" class="widgetsPanelBlock"><!-- startFragment:p_wpNuovaFormazione -->
	
	
<h4 class="wpLabel">Nuova formazione </h4>
<div class="widgetsPanel" id="wpNuovaFormazione">
	
	<customtag:widgetsPanel id="wpNuovaFormazioneTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpAccreditamento','clDataCorso')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.clDataCorso.label')}" labelFor="widg_clDataCorso" errorFor="appDataFormazione.dataCorso" labelId="clDataCorsoLbl"
	position="first"  >


<!-- widget clDataCorso -->
<s:textfield 
	
title=""	
	name="appDataFormazione.dataCorso" id="widg_clDataCorso"
	disabled="isWidgetDisabled('cpAccreditamento','clDataCorso')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue=""  position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','tfDesCorso')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.tfDesCorso.label')}" labelFor="widg_tfDesCorso" errorFor="appDataFormazione.descCorso" labelId="tfDesCorsoLbl"
	position="last"  >


<!-- widget tfDesCorso -->
<s:textfield 
	
	
	name="appDataFormazione.descCorso" id="widg_tfDesCorso"
maxlength="1000"	disabled="isWidgetDisabled('cpAccreditamento','tfDesCorso')"
	size="40" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue=""  position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpNuovaFormazione --></div>

			
	
	<div id="p_cpInsFormazione" class="commandPanelBlock"><!-- startFragment:p_cpInsFormazione -->
	
	
<div class="commandPanel functional" id="cpInsFormazione">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpAccreditamento','btAnnullaFormazione')" >

	



<!-- widget btAnnullaFormazione -->
<s:submit name="widg_btAnnullaFormazione" id="widg_btAnnullaFormazione" method="handleBtAnnullaFormazione_CLICKED"
	key="cpAccreditamento.btAnnullaFormazione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpAccreditamento','btAnnullaFormazione')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpAccreditamento','btSalvaFormazione')" >

	



<!-- widget btSalvaFormazione -->
<s:submit name="widg_btSalvaFormazione" id="widg_btSalvaFormazione" method="handleBtSalvaFormazione_CLICKED"
	key="cpAccreditamento.btSalvaFormazione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpAccreditamento','btSalvaFormazione')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpInsFormazione --></div>

	

		
	
</div>

	<!-- endFragment:p_fpNuovaFormazione --></div>
