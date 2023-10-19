<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpMpRevoca" class="formPanelBlock"><!-- startFragment:p_fpMpRevoca -->
		
	
<h4 class="fpLabel"><s:text name="cpRisRicImpianto.fpMpRevoca.label" /></h4>
<div class="formPanel" id="fpMpRevoca">


	
	

	
	
			
	
	<div id="p_wpRevResp" class="widgetsPanelBlock"><!-- startFragment:p_wpRevResp -->
	
	

<div class="widgetsPanel" id="wpRevResp">
	
	<customtag:widgetsPanel id="wpRevRespTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRisRicImpianto','clDataRevoca')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRisRicImpianto.clDataRevoca.label')}" labelFor="widg_clDataRevoca" errorFor="appDatadataRevocaResponsabileOld" labelId="clDataRevocaLbl"
	position="first"  >


<!-- widget clDataRevoca -->
<s:textfield 
	
	
	name="appDatadataRevocaResponsabileOld" id="widg_clDataRevoca"
	disabled="isWidgetDisabled('cpRisRicImpianto','clDataRevoca')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue=""  position="first"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpRevResp --></div>

			
	
	<div id="p_cpConfRevoca3" class="commandPanelBlock"><!-- startFragment:p_cpConfRevoca3 -->
	
	
<div class="commandPanel functional" id="cpConfRevoca3">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRisRicImpianto','btAnnullaRevoca')" >

	



<!-- widget btAnnullaRevoca -->
<s:submit name="widg_btAnnullaRevoca" id="widg_btAnnullaRevoca" method="handleBtAnnullaRevoca_CLICKED"
	key="cpRisRicImpianto.btAnnullaRevoca.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisRicImpianto','btAnnullaRevoca')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpRisRicImpianto','btConfermaRevoca')" >

	



<!-- widget btConfermaRevoca -->
<s:submit name="widg_btConfermaRevoca" id="widg_btConfermaRevoca" method="handleBtConfermaRevoca_CLICKED"
	key="cpRisRicImpianto.btConfermaRevoca.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisRicImpianto','btConfermaRevoca')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpConfRevoca3 --></div>

	

		
	
</div>

	<!-- endFragment:p_fpMpRevoca --></div>
