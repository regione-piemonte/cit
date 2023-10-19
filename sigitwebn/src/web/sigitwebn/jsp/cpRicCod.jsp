<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/ricerca_codici_impianto -->
<!-- pageId:cpRicCod -->

<s:form id="cpRicCod" action="cpRicCod" namespace="/base/ricerca_codici_impianto" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpRicCod_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpRicCod','menu')" >

	


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

	
	

	
	
			
	
	<div id="p_fpRicCod" class="formPanelBlock"><!-- startFragment:p_fpRicCod -->
		
	
<h4 class="fpLabel"><s:text name="cpRicCod.fpRicCod.label" /></h4>
<div class="formPanel" id="fpRicCod">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpRicCod --></div>

			
	
	<div id="p_stdMsgPRicCod" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgPRicCod -->
	
	
<div class="stdMessagePanel" id="stdMsgPRicCod">
	<customtag:stdMessagePanel id="stdMsgPRicCod" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgPRicCod --></div>

			
	
	<div id="p_wpRicCod" class="widgetsPanelBlock"><!-- startFragment:p_wpRicCod -->
	
	
<h4 class="wpLabel">codice impianto </h4>
<div class="widgetsPanel" id="wpRicCod">
	
	<customtag:widgetsPanel id="wpRicCodTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRicCod','tfCodImp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicCod.tfCodImp.label')}" labelFor="widg_tfCodImp" errorFor="appDataricercaCodImpianto.codiceImpianto" labelId="tfCodImpLbl"
	  >


<!-- widget tfCodImp -->
<s:textfield 
	
	
	name="appDataricercaCodImpianto.codiceImpianto" id="widg_tfCodImp"
maxlength="10"	disabled="isWidgetDisabled('cpRicCod','tfCodImp')"
	size="20" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicCod','clDtAcquDa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicCod.clDtAcquDa.label')}" labelFor="widg_clDtAcquDa" errorFor="appDataricercaCodImpianto.dataAcquisizioneDa" labelId="clDtAcquDaLbl"
	  >


<!-- widget clDtAcquDa -->
<s:textfield 
	
	
	name="appDataricercaCodImpianto.dataAcquisizioneDa" id="widg_clDtAcquDa"
	disabled="isWidgetDisabled('cpRicCod','clDtAcquDa')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicCod','clDtAcquA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicCod.clDtAcquA.label')}" labelFor="widg_clDtAcquA" errorFor="appDataricercaCodImpianto.dataAcquisizioneA" labelId="clDtAcquALbl"
	  >


<!-- widget clDtAcquA -->
<s:textfield 
	
	
	name="appDataricercaCodImpianto.dataAcquisizioneA" id="widg_clDtAcquA"
	disabled="isWidgetDisabled('cpRicCod','clDtAcquA')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpRicCod --></div>

			
	
	<div id="p_wpRicCodManut" class="widgetsPanelBlock"><!-- startFragment:p_wpRicCodManut -->
	
	
<h4 class="wpLabel">impresa </h4>
<div class="widgetsPanel" id="wpRicCodManut">
	
	<customtag:widgetsPanel id="wpRicCodManutTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRicCod','cbSiglaRea')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicCod.cbSiglaRea.label')}" labelFor="widg_cbSiglaRea" errorFor="appDataricercaCodImpianto.idSiglaRea" labelId="cbSiglaReaLbl"
	  >


<!-- widget cbSiglaRea -->
<s:select name="appDataricercaCodImpianto.idSiglaRea" id="widg_cbSiglaRea"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoSiglaRea"
	  disabled="isWidgetDisabled('cpRicCod','cbSiglaRea')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicCod','tfNumRea')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicCod.tfNumRea.label')}" labelFor="widg_tfNumRea" errorFor="appDataricercaCodImpianto.numeroRea" labelId="tfNumReaLbl"
	  >


<!-- widget tfNumRea -->
<s:textfield 
	
	
	name="appDataricercaCodImpianto.numeroRea" id="widg_tfNumRea"
maxlength="9"	disabled="isWidgetDisabled('cpRicCod','tfNumRea')"
	size="20" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicCod','tfCF')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicCod.tfCF.label')}" labelFor="widg_tfCF" errorFor="appDataricercaCodImpianto.codiceFiscale" labelId="tfCFLbl"
	  >


<!-- widget tfCF -->
<s:textfield 
	
	
	name="appDataricercaCodImpianto.codiceFiscale" id="widg_tfCF"
maxlength="16"	disabled="isWidgetDisabled('cpRicCod','tfCF')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpRicCodManut --></div>

			
	
	<div id="p_cpFunRicCod" class="commandPanelBlock"><!-- startFragment:p_cpFunRicCod -->
	
	
<div class="commandPanel functional" id="cpFunRicCod">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRicCod','btnRicercaCodici')" >

	



<!-- widget btnRicercaCodici -->
<s:submit name="widg_btnRicercaCodici" id="widg_btnRicercaCodici" method="handleBtnRicercaCodici_CLICKED"
	key="cpRicCod.btnRicercaCodici.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicCod','btnRicercaCodici')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRicCod','btnAnnullaRicCod')" >

	



<!-- widget btnAnnullaRicCod -->
<s:submit name="widg_btnAnnullaRicCod" id="widg_btnAnnullaRicCod" method="handleBtnAnnullaRicCod_CLICKED"
	key="cpRicCod.btnAnnullaRicCod.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicCod','btnAnnullaRicCod')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunRicCod --></div>

			
	
	<div id="p_cpNavRicCod" class="commandPanelBlock"><!-- startFragment:p_cpNavRicCod -->
	
	
<div class="commandPanel navigation" id="cpNavRicCod">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRicCod','btIndietro')" >

	



<!-- widget btIndietro -->
<s:submit name="widg_btIndietro" id="widg_btIndietro" method="handleBtIndietro_CLICKED"
	key="cpRicCod.btIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicCod','btIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavRicCod --></div>

	

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
