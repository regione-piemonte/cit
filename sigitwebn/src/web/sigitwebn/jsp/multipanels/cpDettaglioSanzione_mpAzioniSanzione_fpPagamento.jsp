<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpPagamento" class="formPanelBlock"><!-- startFragment:p_fpPagamento -->
		
	
<div class="formPanel" id="fpPagamento">


	
	

	
	
			
	
	<div id="p_wpPagamento" class="widgetsPanelBlock"><!-- startFragment:p_wpPagamento -->
	
	
<h4 class="wpLabel">dati pagamento </h4>
<div class="widgetsPanel" id="wpPagamento">
	
	<customtag:widgetsPanel id="wpPagamentoTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpDettaglioSanzione','dtPagamentoFormPaga')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioSanzione.dtPagamentoFormPaga.label')}" labelFor="widg_dtPagamentoFormPaga" errorFor="appDatadataPagamento" labelId="dtPagamentoFormPagaLbl"
	  >


<!-- widget dtPagamentoFormPaga -->
<s:textfield 
	
	
	name="appDatadataPagamento" id="widg_dtPagamentoFormPaga"
	disabled="isWidgetDisabled('cpDettaglioSanzione','dtPagamentoFormPaga')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpPagamento --></div>

			
	
	<div id="p_cpPagamento" class="commandPanelBlock"><!-- startFragment:p_cpPagamento -->
	
	
<div class="commandPanel functional" id="cpPagamento">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpDettaglioSanzione','btnConfermaPagamento')" >

	



<!-- widget btnConfermaPagamento -->
<s:submit name="widg_btnConfermaPagamento" id="widg_btnConfermaPagamento" method="handleBtnConfermaPagamento_CLICKED"
	key="cpDettaglioSanzione.btnConfermaPagamento.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioSanzione','btnConfermaPagamento')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpDettaglioSanzione','btnAnnullaPagamento')" >

	



<!-- widget btnAnnullaPagamento -->
<s:submit name="widg_btnAnnullaPagamento" id="widg_btnAnnullaPagamento" method="handleBtnAnnullaPagamento_CLICKED"
	key="cpDettaglioSanzione.btnAnnullaPagamento.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioSanzione','btnAnnullaPagamento')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpPagamento --></div>

	

		
	
</div>

	<!-- endFragment:p_fpPagamento --></div>
