<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpGestioneSveglia" class="formPanelBlock"><!-- startFragment:p_fpGestioneSveglia -->
		
	
<div class="formPanel" id="fpGestioneSveglia">


	
	

	
	
			
	
	<div id="p_stdMsgSveglia" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgSveglia -->
	
	
<div class="stdMessagePanel" id="stdMsgSveglia">
	<customtag:stdMessagePanel id="stdMsgSveglia" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgSveglia --></div>

			
	
	<div id="p_wpGestioneSveglia" class="widgetsPanelBlock"><!-- startFragment:p_wpGestioneSveglia -->
	
	
<h4 class="wpLabel">gestione sveglia </h4>
<div class="widgetsPanel" id="wpGestioneSveglia">
	
	<customtag:widgetsPanel id="wpGestioneSvegliaTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpDettaglioVerifica','ptAttivita')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioVerifica.ptAttivita.label')}" labelFor="widg_ptAttivita" errorFor="appDatasveglia.identificativoExtended" labelId="ptAttivitaLbl"   >


<!-- widget ptAttivita -->
<s:property value="appDatasveglia.identificativoExtended" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioVerifica','ptSvegliaAttuale')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioVerifica.ptSvegliaAttuale.label')}" labelFor="widg_ptSvegliaAttuale" errorFor="appDatasveglia.dataSvegliaDes" labelId="ptSvegliaAttualeLbl"   >


<!-- widget ptSvegliaAttuale -->
<s:property value="appDatasveglia.dataSvegliaDes" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioVerifica','ptDescrizioneSveglia')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioVerifica.ptDescrizioneSveglia.label')}" labelFor="widg_ptDescrizioneSveglia" errorFor="appDatasveglia.noteSveglia" labelId="ptDescrizioneSvegliaLbl"   >


<!-- widget ptDescrizioneSveglia -->
<s:property value="appDatasveglia.noteSveglia" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpGestioneSveglia --></div>

			
	
	<div id="p_cpFun" class="commandPanelBlock"><!-- startFragment:p_cpFun -->
	
	
<div class="commandPanel functional" id="cpFun">

	
	
		
		
<s:if test="isWidgetVisible('cpDettaglioVerifica','btImpostaNuova')" >

	



<!-- widget btImpostaNuova -->
<s:submit name="widg_btImpostaNuova" id="widg_btImpostaNuova" method="handleBtImpostaNuova_CLICKED"
	key="cpDettaglioVerifica.btImpostaNuova.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioVerifica','btImpostaNuova')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpDettaglioVerifica','btEliminaSveglia')" >

	



<!-- widget btEliminaSveglia -->
<s:submit name="widg_btEliminaSveglia" id="widg_btEliminaSveglia" method="handleBtEliminaSveglia_CLICKED"
	key="cpDettaglioVerifica.btEliminaSveglia.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioVerifica','btEliminaSveglia')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cpFun --></div>

			
	
	<div id="p_cpFun2" class="commandPanelBlock"><!-- startFragment:p_cpFun2 -->
	
	
<div class="commandPanel functional" id="cpFun2">

	
	
		
		
<s:if test="isWidgetVisible('cpDettaglioVerifica','btChiudi')" >

	



<!-- widget btChiudi -->
<s:submit name="widg_btChiudi" id="widg_btChiudi" method="handleBtChiudi_CLICKED"
	key="cpDettaglioVerifica.btChiudi.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioVerifica','btChiudi')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cpFun2 --></div>

	

		
	
</div>

	<!-- endFragment:p_fpGestioneSveglia --></div>
