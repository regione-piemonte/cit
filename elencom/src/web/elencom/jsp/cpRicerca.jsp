<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/elencom/presentation/elencom/action/ricerca_module/CpRicercaAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/ricerca_module -->
<!-- pageId:cpRicerca -->

<s:form id="cpRicerca" action="cpRicerca" namespace="/base/ricerca_module" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">



	<!-- ================ UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->
	<div id="westCenterWrapper" class="floatWrapper">
		<!-- ***** UDLRC Layout LEFT PANEL ***** -->
		<div id="westPanel">
			<div class="wrapper">
			
	
	<div id="p_pMenu" class="formPanelBlock"><!-- startFragment:p_pMenu -->

	
	

	
	
			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel vertical" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpRicerca','menuView')" >

	


	<s:include value="fragments/menu.jsp"></s:include>

	

</s:if>

	


		
	
	
</div>

	<!-- endFragment:p_menuPanel --></div>

	

	<!-- endFragment:p_pMenu --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout LEFT PANEL ***** -->


		<!-- ***** UDLRC Layout CENTER PANEL ***** -->
		<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
			<div class="wrapper">
				<!-- titolo pannello PRIMO livello -->
				<h3><s:text name="cpRicerca.pRicerca.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_pnErroriInRicerca" class="stdMessagePanelBlock"><!-- startFragment:p_pnErroriInRicerca -->
	
	
<div class="stdMessagePanel" id="pnErroriInRicerca">
	<customtag:stdMessagePanel id="pnErroriInRicerca" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pnErroriInRicerca --></div>

			
	
	<div id="p_wRicerca" class="widgetsPanelBlock"><!-- startFragment:p_wRicerca -->
	
	

<div class="widgetsPanel" id="wRicerca">
	
	<customtag:widgetsPanel id="wRicercaTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRicerca','cbProvince')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicerca.cbProvince.label')}" labelFor="widg_cbProvince" errorFor="appDatafiltroManutentore.provincia" labelId="cbProvinceLbl"
	  >


<!-- widget cbProvince -->
	<csiuicore:ajaxify id="p_wRicerca" 
		widgetType="combo" 
		requestUri="/elencom/base/ricerca_module/cpRicerca!handleCbProvince_VALUE_CHANGED.do"
		pageId="cpRicerca"
		formName="cpRicerca"
		javascriptDetection="false"
		nameSpace="/base/ricerca_module">

<s:url id="widg_cbProvinceurlComboBoxValueChange"
   action="/elencom/cpRicerca!handleCbProvince_VALUE_CHANGED" namespace="/base/ricerca_module"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatafiltroManutentore.provincia" id="widg_cbProvince"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDatacomboProvince"
	  disabled="isWidgetDisabled('cpRicerca','cbProvince')"
	  listKey="codice"
	  listValue="descrizione"
	  onclick="onCBClick(this,'confermacbProvince','conferma','%{widg_cbProvinceurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbProvince','conferma','%{widg_cbProvinceurlComboBoxValueChange}')" 
	  />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicerca','cbComuni')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicerca.cbComuni.label')}" labelFor="widg_cbComuni" errorFor="appDatafiltroManutentore.comune" labelId="cbComuniLbl"
	  >


<!-- widget cbComuni -->
	<csiuicore:ajaxify id="p_wRicerca" 
		widgetType="combo" 
		requestUri="/elencom/base/ricerca_module/cpRicerca!handleCbComuni_VALUE_CHANGED.do"
		pageId="cpRicerca"
		formName="cpRicerca"
		javascriptDetection="false"
		nameSpace="/base/ricerca_module">

<s:url id="widg_cbComuniurlComboBoxValueChange"
   action="/elencom/cpRicerca!handleCbComuni_VALUE_CHANGED" namespace="/base/ricerca_module"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatafiltroManutentore.comune" id="widg_cbComuni"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDatacomboComuni"
	  disabled="isWidgetDisabled('cpRicerca','cbComuni')"
	  listKey="codice"
	  listValue="descrizione"
	  onclick="onCBClick(this,'confermacbComuni','conferma','%{widg_cbComuniurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbComuni','conferma','%{widg_cbComuniurlComboBoxValueChange}')" 
	  />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicerca','Denominazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicerca.Denominazione.label')}" labelFor="widg_Denominazione" errorFor="appDatafiltroManutentore.denominazione" labelId="DenominazioneLbl"
	  >


<!-- widget Denominazione -->
<s:textfield 
	
	
	name="appDatafiltroManutentore.denominazione" id="widg_Denominazione"
	disabled="isWidgetDisabled('cpRicerca','Denominazione')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicerca','hvDettWMS')" >

	
<div class="hidden">


<!-- widget hvDettWMS -->
<s:hidden name="widg_hvDettWMS" id="widg_hvDettWMS" />

	
</div>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wRicerca --></div>

			
	
	<div id="p_pComandiTabella" class="commandPanelBlock"><!-- startFragment:p_pComandiTabella -->
	
	
<div class="commandPanel functional" id="pComandiTabella">

	
	
		
		
<s:if test="isWidgetVisible('cpRicerca','btRicNew')" >

	



<!-- widget btRicNew -->
<s:submit name="widg_btRicNew" id="widg_btRicNew" method="handleBtRicNew_CLICKED"
	key="cpRicerca.btRicNew.label" cssClass="buttonWidget search"
	disabled="isWidgetDisabled('cpRicerca','btRicNew')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_pComandiTabella --></div>

			
	
	
	<div id="p_mpManu" class="panelBlock"><!-- startFragment:p_mpManu -->
		

		
<s:if test="#session.cpRicerca_mpManu_selectedMultiPanel == 'cpRicerca_mpManu_fpTab'">
	<s:include value="/jsp/multipanels/cpRicerca_mpManu_fpTab.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpManu --></div>

	

	<!-- endFragment:p_pCenter --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout CENTER PANEL ***** -->



	</div>
	<!-- ================ FINE UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->



</div>
<!-- #################### FINE PANNELLO CONTENUTI #################### -->




</s:form>


	<s:include value="fragments/footer.jsp" ></s:include>
