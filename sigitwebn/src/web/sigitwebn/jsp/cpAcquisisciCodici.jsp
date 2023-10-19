<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/acquisisci_codici_impianto -->
<!-- pageId:cpAcquisisciCodici -->

<s:form id="cpAcquisisciCodici" action="cpAcquisisciCodici" namespace="/base/acquisisci_codici_impianto" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpAcquisisciCodici_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpAcquisisciCodici','menu')" >

	


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

	
	

	
	
			
	
	<div id="p_fpAcqCodTitolo" class="formPanelBlock"><!-- startFragment:p_fpAcqCodTitolo -->
		
	
<h4 class="fpLabel"><s:text name="cpAcquisisciCodici.fpAcqCodTitolo.label" /></h4>
<div class="formPanel" id="fpAcqCodTitolo">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpAcqCodTitolo --></div>

			
	
	<div id="p_fpAcqCod" class="formPanelBlock"><!-- startFragment:p_fpAcqCod -->
		
	
<div class="formPanel" id="fpAcqCod">


	
	

	
	
			
	
	<div id="p_stdMsgPAcqCod" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgPAcqCod -->
	
	
<div class="stdMessagePanel" id="stdMsgPAcqCod">
	<customtag:stdMessagePanel id="stdMsgPAcqCod" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgPAcqCod --></div>

			
	
	<div id="p_wpAcqCodManut" class="widgetsPanelBlock"><!-- startFragment:p_wpAcqCodManut -->
	
	
<h4 class="wpLabel">impresa </h4>
<div class="widgetsPanel" id="wpAcqCodManut">
	
	<customtag:widgetsPanel id="wpAcqCodManutTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpAcquisisciCodici','cbSiglaRea')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAcquisisciCodici.cbSiglaRea.label')}" labelFor="widg_cbSiglaRea" errorFor="appDataacquisizioneCodiciImpianto.idSiglaRea" labelId="cbSiglaReaLbl"
	  >


<!-- widget cbSiglaRea -->
<s:select name="appDataacquisizioneCodiciImpianto.idSiglaRea" id="widg_cbSiglaRea"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoSiglaRea"
	  disabled="isWidgetDisabled('cpAcquisisciCodici','cbSiglaRea')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpAcquisisciCodici','tfNumRea')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAcquisisciCodici.tfNumRea.label')}" labelFor="widg_tfNumRea" errorFor="appDataacquisizioneCodiciImpianto.numeroRea" labelId="tfNumReaLbl"
	  >


<!-- widget tfNumRea -->
<s:textfield 
	
	
	name="appDataacquisizioneCodiciImpianto.numeroRea" id="widg_tfNumRea"
maxlength="9"	disabled="isWidgetDisabled('cpAcquisisciCodici','tfNumRea')"
	size="20" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpAcquisisciCodici','tfCF')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAcquisisciCodici.tfCF.label')}" labelFor="widg_tfCF" errorFor="appDataacquisizioneCodiciImpianto.codiceFiscale" labelId="tfCFLbl"
	  >


<!-- widget tfCF -->
<s:textfield 
	
	
	name="appDataacquisizioneCodiciImpianto.codiceFiscale" id="widg_tfCF"
maxlength="16"	disabled="isWidgetDisabled('cpAcquisisciCodici','tfCF')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpAcquisisciCodici','btnCercaInst')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget btnCercaInst -->
<s:submit name="widg_btnCercaInst" id="widg_btnCercaInst" method="handleBtnCercaInst_CLICKED"
	key="cpAcquisisciCodici.btnCercaInst.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpAcquisisciCodici','btnCercaInst')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpAcquisisciCodici','btnNuovaRicercaInst')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget btnNuovaRicercaInst -->
<s:submit name="widg_btnNuovaRicercaInst" id="widg_btnNuovaRicercaInst" method="handleBtnNuovaRicercaInst_CLICKED"
	key="cpAcquisisciCodici.btnNuovaRicercaInst.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpAcquisisciCodici','btnNuovaRicercaInst')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpAcquisisciCodici','tfDitta')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAcquisisciCodici.tfDitta.label')}" labelFor="widg_tfDitta" errorFor="appDataacquisizioneCodiciImpianto.impresa" labelId="tfDittaLbl"
	  >


<!-- widget tfDitta -->
<s:textfield 
	
	
	name="appDataacquisizioneCodiciImpianto.impresa" id="widg_tfDitta"
	disabled="isWidgetDisabled('cpAcquisisciCodici','tfDitta')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAcqCodManut --></div>

			
	
	<div id="p_wpAcqCodImp" class="widgetsPanelBlock"><!-- startFragment:p_wpAcqCodImp -->
	
	
<h4 class="wpLabel">dati impianto </h4>
<div class="widgetsPanel" id="wpAcqCodImp">
	
	<customtag:widgetsPanel id="wpAcqCodImpTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpAcquisisciCodici','tfDataConsegna')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAcquisisciCodici.tfDataConsegna.label')}" labelFor="widg_tfDataConsegna" errorFor="appDataacquisizioneCodiciImpianto.dataConsegna" labelId="tfDataConsegnaLbl"
	  >


<!-- widget tfDataConsegna -->
<s:textfield 
	
	
	name="appDataacquisizioneCodiciImpianto.dataConsegna" id="widg_tfDataConsegna"
maxlength="10"	disabled="isWidgetDisabled('cpAcquisisciCodici','tfDataConsegna')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpAcquisisciCodici','tfAcquisitiDa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAcquisisciCodici.tfAcquisitiDa.label')}" labelFor="widg_tfAcquisitiDa" errorFor="appDataacquisizioneCodiciImpianto.acquisitiDa" labelId="tfAcquisitiDaLbl"
	  >


<!-- widget tfAcquisitiDa -->
<s:textfield 
	
	
	name="appDataacquisizioneCodiciImpianto.acquisitiDa" id="widg_tfAcquisitiDa"
maxlength="16"	disabled="isWidgetDisabled('cpAcquisisciCodici','tfAcquisitiDa')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpAcquisisciCodici','tfQuantita')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAcquisisciCodici.tfQuantita.label')}" labelFor="widg_tfQuantita" errorFor="appDataacquisizioneCodiciImpianto.quantita" labelId="tfQuantitaLbl"
	  >


<!-- widget tfQuantita -->
<s:textfield 
	
	
	name="appDataacquisizioneCodiciImpianto.quantita" id="widg_tfQuantita"
maxlength="5"	disabled="isWidgetDisabled('cpAcquisisciCodici','tfQuantita')"
	size="20" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAcqCodImp --></div>

			
	
	<div id="p_cpFunAcqCod" class="commandPanelBlock"><!-- startFragment:p_cpFunAcqCod -->
	
	
<div class="commandPanel functional" id="cpFunAcqCod">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpAcquisisciCodici','btnAnnullaInsCod')" >

	



<!-- widget btnAnnullaInsCod -->
<s:submit name="widg_btnAnnullaInsCod" id="widg_btnAnnullaInsCod" method="handleBtnAnnullaInsCod_CLICKED"
	key="cpAcquisisciCodici.btnAnnullaInsCod.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpAcquisisciCodici','btnAnnullaInsCod')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunAcqCod --></div>

			
	
	<div id="p_cpNavAcqCod" class="commandPanelBlock"><!-- startFragment:p_cpNavAcqCod -->
	
	
<div class="commandPanel navigation" id="cpNavAcqCod">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpAcquisisciCodici','btnIndietro')" >

	



<!-- widget btnIndietro -->
<s:submit name="widg_btnIndietro" id="widg_btnIndietro" method="handleBtnIndietro_CLICKED"
	key="cpAcquisisciCodici.btnIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpAcquisisciCodici','btnIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpAcquisisciCodici','btnAcquisisci')" >

	



<!-- widget btnAcquisisci -->
<s:submit name="widg_btnAcquisisci" id="widg_btnAcquisisci" method="handleBtnAcquisisci_CLICKED"
	key="cpAcquisisciCodici.btnAcquisisci.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpAcquisisciCodici','btnAcquisisci')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavAcqCod --></div>

	

		
	
</div>

	<!-- endFragment:p_fpAcqCod --></div>

	

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
