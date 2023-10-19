<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/ricerca_impianti_graffatura -->
<!-- pageId:cpRicImpiantoGraffatura -->

<s:form id="cpRicImpiantoGraffatura" action="cpRicImpiantoGraffatura" namespace="/base/ricerca_impianti_graffatura" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpRicImpiantoGraffatura_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpRicImpiantoGraffatura','menu')" >

	


	<s:include value="fragments/menu.jsp"></s:include>

	

</s:if>

	


		
	
	
</div>

	<!-- endFragment:p_menuPanel --></div>

	

	<!-- endFragment:p_fpUpUserInfo --></div>

		</div>
	</div>
	<!-- ================ FINE UDLRC Layout UP PANEL ================ -->


	<!-- ================ UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->
	<div id="centerWrapper" class="floatWrapper">


		<!-- ***** UDLRC Layout CENTER PANEL ***** -->
		<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
			<div class="wrapper">

					
	
	<div id="p_fpCenter" class="formPanelBlock"><!-- startFragment:p_fpCenter -->

	
	

	
	
			
	
	<div id="p_fpRicImpiantoGraffatura" class="formPanelBlock"><!-- startFragment:p_fpRicImpiantoGraffatura -->
		
	
<h4 class="fpLabel"><s:text name="cpRicImpiantoGraffatura.fpRicImpiantoGraffatura.label" /></h4>
<div class="formPanel" id="fpRicImpiantoGraffatura">


	
	

	
	
			
	
	<div id="p_stdMsgPRicImp" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgPRicImp -->
	
	
<div class="stdMessagePanel" id="stdMsgPRicImp">
	<customtag:stdMessagePanel id="stdMsgPRicImp" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgPRicImp --></div>

			
	
	<div id="p_wpImpiantoGraffatura" class="widgetsPanelBlock"><!-- startFragment:p_wpImpiantoGraffatura -->
	
	
<h4 class="wpLabel">impianto </h4>
<div class="widgetsPanel" id="wpImpiantoGraffatura">
	
	<customtag:widgetsPanel id="wpImpiantoGraffaturaTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRicImpiantoGraffatura','cbStatiImpianto')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicImpiantoGraffatura.cbStatiImpianto.label')}" labelFor="widg_cbStatiImpianto" errorFor="appDataricercaImpianti.idStatoImp" labelId="cbStatiImpiantoLbl"
	  fieldRequired="true">


<!-- widget cbStatiImpianto -->
<s:select name="appDataricercaImpianti.idStatoImp" id="widg_cbStatiImpianto"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoStatoImpianto"
	  disabled="isWidgetDisabled('cpRicImpiantoGraffatura','cbStatiImpianto')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicImpiantoGraffatura','tfCodImp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicImpiantoGraffatura.tfCodImp.label')}" labelFor="widg_tfCodImp" errorFor="appDataricercaImpianti.codiceImpianto" labelId="tfCodImpLbl"
	  >


<!-- widget tfCodImp -->
<s:textfield 
	
	
	name="appDataricercaImpianti.codiceImpianto" id="widg_tfCodImp"
maxlength="11"	disabled="isWidgetDisabled('cpRicImpiantoGraffatura','tfCodImp')"
	size="20" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicImpiantoGraffatura','cbProvincia')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicImpiantoGraffatura.cbProvincia.label')}" labelFor="widg_cbProvincia" errorFor="appDataricercaImpianti.idProvincia" labelId="cbProvinciaLbl"
	  fieldRequired="true">


<!-- widget cbProvincia -->
	<csiuicore:ajaxify id="p_wpImpiantoGraffatura" 
		widgetType="combo" 
		requestUri="/sigitwebn/base/ricerca_impianti_graffatura/cpRicImpiantoGraffatura!handleCbProvincia_VALUE_CHANGED.do"
		pageId="cpRicImpiantoGraffatura"
		formName="cpRicImpiantoGraffatura"
		javascriptDetection="false"
		nameSpace="/base/ricerca_impianti_graffatura">

<s:url id="widg_cbProvinciaurlComboBoxValueChange"
   action="/sigitwebn/cpRicImpiantoGraffatura!handleCbProvincia_VALUE_CHANGED" namespace="/base/ricerca_impianti_graffatura"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataricercaImpianti.idProvincia" id="widg_cbProvincia"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoProvincePiemonte"
	  disabled="isWidgetDisabled('cpRicImpiantoGraffatura','cbProvincia')"
	  listKey="code"
	  listValue="description"
	  onclick="onCBClick(this,'confermacbProvincia','conferma','%{widg_cbProvinciaurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbProvincia','conferma','%{widg_cbProvinciaurlComboBoxValueChange}')" 
	  />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicImpiantoGraffatura','cbComune')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicImpiantoGraffatura.cbComune.label')}" labelFor="widg_cbComune" errorFor="appDataricercaImpianti.idComune" labelId="cbComuneLbl"
	  >


<!-- widget cbComune -->
<s:select name="appDataricercaImpianti.idComune" id="widg_cbComune"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoComuni"
	  disabled="isWidgetDisabled('cpRicImpiantoGraffatura','cbComune')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicImpiantoGraffatura','tfDescComune')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicImpiantoGraffatura.tfDescComune.label')}" labelFor="widg_tfDescComune" errorFor="appDataricercaImpianti.descComune" labelId="tfDescComuneLbl"
	  >


<!-- widget tfDescComune -->
<s:textfield 
	
	
	name="appDataricercaImpianti.descComune" id="widg_tfDescComune"
maxlength="50"	disabled="isWidgetDisabled('cpRicImpiantoGraffatura','tfDescComune')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicImpiantoGraffatura','tfIndirizzo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicImpiantoGraffatura.tfIndirizzo.label')}" labelFor="widg_tfIndirizzo" errorFor="appDataricercaImpianti.indirizzo" labelId="tfIndirizzoLbl"
	  >


<!-- widget tfIndirizzo -->
<s:textfield 
	
	
	name="appDataricercaImpianti.indirizzo" id="widg_tfIndirizzo"
maxlength="50"	disabled="isWidgetDisabled('cpRicImpiantoGraffatura','tfIndirizzo')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicImpiantoGraffatura','tfCfResponsabile')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicImpiantoGraffatura.tfCfResponsabile.label')}" labelFor="widg_tfCfResponsabile" errorFor="appDataricercaImpianti.cfResponsabile" labelId="tfCfResponsabileLbl"
	  >


<!-- widget tfCfResponsabile -->
<s:textfield 
	
	
	name="appDataricercaImpianti.cfResponsabile" id="widg_tfCfResponsabile"
maxlength="16"	disabled="isWidgetDisabled('cpRicImpiantoGraffatura','tfCfResponsabile')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicImpiantoGraffatura','tfCfProprietario')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicImpiantoGraffatura.tfCfProprietario.label')}" labelFor="widg_tfCfProprietario" errorFor="appDataricercaImpianti.cfProprietario" labelId="tfCfProprietarioLbl"
	  >


<!-- widget tfCfProprietario -->
<s:textfield 
	
	
	name="appDataricercaImpianti.cfProprietario" id="widg_tfCfProprietario"
maxlength="16"	disabled="isWidgetDisabled('cpRicImpiantoGraffatura','tfCfProprietario')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicImpiantoGraffatura','tfCf3Responsabile')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicImpiantoGraffatura.tfCf3Responsabile.label')}" labelFor="widg_tfCf3Responsabile" errorFor="appDataricercaImpianti.cf3Responsabile" labelId="tfCf3ResponsabileLbl"
	  >


<!-- widget tfCf3Responsabile -->
<s:textfield 
	
	
	name="appDataricercaImpianti.cf3Responsabile" id="widg_tfCf3Responsabile"
maxlength="16"	disabled="isWidgetDisabled('cpRicImpiantoGraffatura','tfCf3Responsabile')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpImpiantoGraffatura --></div>

			
	
	<div id="p_cpFunRicImpianto" class="commandPanelBlock"><!-- startFragment:p_cpFunRicImpianto -->
	
	
<div class="commandPanel functional" id="cpFunRicImpianto">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRicImpiantoGraffatura','btRicIns')" >

	



<!-- widget btRicIns -->
<s:submit name="widg_btRicIns" id="widg_btRicIns" method="handleBtRicIns_CLICKED"
	key="cpRicImpiantoGraffatura.btRicIns.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicImpiantoGraffatura','btRicIns')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunRicImpianto --></div>

			
	
	<div id="p_cpNavRicImpianto" class="commandPanelBlock"><!-- startFragment:p_cpNavRicImpianto -->
	
	
<div class="commandPanel navigation" id="cpNavRicImpianto">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRicImpiantoGraffatura','btIndietro')" >

	



<!-- widget btIndietro -->
<s:submit name="widg_btIndietro" id="widg_btIndietro" method="handleBtIndietro_CLICKED"
	key="cpRicImpiantoGraffatura.btIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicImpiantoGraffatura','btIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavRicImpianto --></div>

	

		
	
</div>

	<!-- endFragment:p_fpRicImpiantoGraffatura --></div>

	

	<!-- endFragment:p_fpCenter --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout CENTER PANEL ***** -->



	</div>
	<!-- ================ FINE UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->



</div>
<!-- #################### FINE PANNELLO CONTENUTI #################### -->




</s:form>


	<s:include value="fragments/footer.jsp" ></s:include>
