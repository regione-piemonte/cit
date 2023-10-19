<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpAnnullamento" class="formPanelBlock"><!-- startFragment:p_fpAnnullamento -->
		
	
<div class="formPanel" id="fpAnnullamento">


	
	

	
	
			
	
	<div id="p_wpAnnullamento" class="widgetsPanelBlock"><!-- startFragment:p_wpAnnullamento -->
	
	
<h4 class="wpLabel">dati annullamento </h4>
<div class="widgetsPanel" id="wpAnnullamento">
	
	<customtag:widgetsPanel id="wpAnnullamentoTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpDettaglioSanzione','taNoteAnnullamento')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioSanzione.taNoteAnnullamento.label')}" labelFor="widg_taNoteAnnullamento" errorFor="appDatamotivoAnnullamentoSanzione" labelId="taNoteAnnullamentoLbl"
	  >


<!-- widget taNoteAnnullamento -->
<s:textarea 
	
	
	name="appDatamotivoAnnullamentoSanzione" id="widg_taNoteAnnullamento"
	disabled="isWidgetDisabled('cpDettaglioSanzione','taNoteAnnullamento')"
	rows="2"
	cols="30"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAnnullamento --></div>

			
	
	<div id="p_cpConfEliminaSanzione" class="commandPanelBlock"><!-- startFragment:p_cpConfEliminaSanzione -->
	
	
<div class="commandPanel functional" id="cpConfEliminaSanzione">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpDettaglioSanzione','btConferma')" >

	



<!-- widget btConferma -->
<s:submit name="widg_btConferma" id="widg_btConferma" method="handleBtConferma_CLICKED"
	key="cpDettaglioSanzione.btConferma.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioSanzione','btConferma')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpDettaglioSanzione','btAnnulla')" >

	



<!-- widget btAnnulla -->
<s:submit name="widg_btAnnulla" id="widg_btAnnulla" method="handleBtAnnulla_CLICKED"
	key="cpDettaglioSanzione.btAnnulla.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioSanzione','btAnnulla')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpConfEliminaSanzione --></div>

	

		
	
</div>

	<!-- endFragment:p_fpAnnullamento --></div>
