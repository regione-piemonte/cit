<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpAssociaAcc" class="formPanelBlock"><!-- startFragment:p_fpAssociaAcc -->
		
	
<div class="formPanel" id="fpAssociaAcc">


	
	

	
	
			
	
	<div id="p_wpAssociaAcc" class="widgetsPanelBlock"><!-- startFragment:p_wpAssociaAcc -->
	
	
<h4 class="wpLabel">assegna accertamento </h4>
<div class="widgetsPanel" id="wpAssociaAcc">
	
	<customtag:widgetsPanel id="wpAssociaAccTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpDettaglioAccertamentoConf','cbElencoValidatori')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioAccertamentoConf.cbElencoValidatori.label')}" labelFor="widg_cbElencoValidatori" errorFor="appDataaccertamento.idValidatore" labelId="cbElencoValidatoriLbl"
	  >


<!-- widget cbElencoValidatori -->
<s:select name="appDataaccertamento.idValidatore" id="widg_cbElencoValidatori"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoValidatori"
	  disabled="isWidgetDisabled('cpDettaglioAccertamentoConf','cbElencoValidatori')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAssociaAcc --></div>

			
	
	<div id="p_cpFunAssociaAcc" class="commandPanelBlock"><!-- startFragment:p_cpFunAssociaAcc -->
	
	
<div class="commandPanel functional" id="cpFunAssociaAcc">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpDettaglioAccertamentoConf','btSalvaAssociaAcc')" >

	



<!-- widget btSalvaAssociaAcc -->
<s:submit name="widg_btSalvaAssociaAcc" id="widg_btSalvaAssociaAcc" method="handleBtSalvaAssociaAcc_CLICKED"
	key="cpDettaglioAccertamentoConf.btSalvaAssociaAcc.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioAccertamentoConf','btSalvaAssociaAcc')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunAssociaAcc --></div>

	

		
	
</div>

	<!-- endFragment:p_fpAssociaAcc --></div>
