<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/ricerca_bollini -->
<!-- pageId:cpRicBollini -->

<s:form id="cpRicBollini" action="cpRicBollini" namespace="/base/ricerca_bollini" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpRicBollini_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpRicBollini','menu')" >

	


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

	
	

	
	
			
	
	<div id="p_fpRicBollini" class="formPanelBlock"><!-- startFragment:p_fpRicBollini -->
		
	
<h4 class="fpLabel"><s:text name="cpRicBollini.fpRicBollini.label" /></h4>
<div class="formPanel" id="fpRicBollini">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpRicBollini --></div>

			
	
	<div id="p_stdMsgPRicBollini" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgPRicBollini -->
	
	
<div class="stdMessagePanel" id="stdMsgPRicBollini">
	<customtag:stdMessagePanel id="stdMsgPRicBollini" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgPRicBollini --></div>

			
	
	<div id="p_wpRicBolliniCodBoll" class="widgetsPanelBlock"><!-- startFragment:p_wpRicBolliniCodBoll -->
	
	
<h4 class="wpLabel">codice REE </h4>
<div class="widgetsPanel" id="wpRicBolliniCodBoll">
	
	<customtag:widgetsPanel id="wpRicBolliniCodBollTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRicBollini','cbSiglaBollino')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicBollini.cbSiglaBollino.label')}" labelFor="widg_cbSiglaBollino" errorFor="appDataricercaBollini.siglaBollino" labelId="cbSiglaBollinoLbl"
	  >


<!-- widget cbSiglaBollino -->
<s:select name="appDataricercaBollini.siglaBollino" id="widg_cbSiglaBollino"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoSiglaBollini"
	  disabled="isWidgetDisabled('cpRicBollini','cbSiglaBollino')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicBollini','tfNumBoll')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicBollini.tfNumBoll.label')}" labelFor="widg_tfNumBoll" errorFor="appDataricercaBollini.numeroBollino" labelId="tfNumBollLbl"
	  >


<!-- widget tfNumBoll -->
<s:textfield 
	
	
	name="appDataricercaBollini.numeroBollino" id="widg_tfNumBoll"
maxlength="10"	disabled="isWidgetDisabled('cpRicBollini','tfNumBoll')"
	size="20" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicBollini','clDtAcquDa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicBollini.clDtAcquDa.label')}" labelFor="widg_clDtAcquDa" errorFor="appDataricercaBollini.dataAcquisizioneDa" labelId="clDtAcquDaLbl"
	  >


<!-- widget clDtAcquDa -->
<s:textfield 
	
	
	name="appDataricercaBollini.dataAcquisizioneDa" id="widg_clDtAcquDa"
	disabled="isWidgetDisabled('cpRicBollini','clDtAcquDa')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicBollini','clDtAcquA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicBollini.clDtAcquA.label')}" labelFor="widg_clDtAcquA" errorFor="appDataricercaBollini.dataAcquisizioneA" labelId="clDtAcquALbl"
	  >


<!-- widget clDtAcquA -->
<s:textfield 
	
	
	name="appDataricercaBollini.dataAcquisizioneA" id="widg_clDtAcquA"
	disabled="isWidgetDisabled('cpRicBollini','clDtAcquA')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpRicBolliniCodBoll --></div>

			
	
	<div id="p_wpRicBolliniManut" class="widgetsPanelBlock"><!-- startFragment:p_wpRicBolliniManut -->
	
	
<h4 class="wpLabel">impresa </h4>
<div class="widgetsPanel" id="wpRicBolliniManut">
	
	<customtag:widgetsPanel id="wpRicBolliniManutTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRicBollini','cbSiglaRea')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicBollini.cbSiglaRea.label')}" labelFor="widg_cbSiglaRea" errorFor="appDataricercaBollini.idSiglaRea" labelId="cbSiglaReaLbl"
	  >


<!-- widget cbSiglaRea -->
<s:select name="appDataricercaBollini.idSiglaRea" id="widg_cbSiglaRea"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoSiglaRea"
	  disabled="isWidgetDisabled('cpRicBollini','cbSiglaRea')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicBollini','tfNumRea')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicBollini.tfNumRea.label')}" labelFor="widg_tfNumRea" errorFor="appDataricercaBollini.numeroRea" labelId="tfNumReaLbl"
	  >


<!-- widget tfNumRea -->
<s:textfield 
	
	
	name="appDataricercaBollini.numeroRea" id="widg_tfNumRea"
maxlength="9"	disabled="isWidgetDisabled('cpRicBollini','tfNumRea')"
	size="20" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicBollini','tfCF')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicBollini.tfCF.label')}" labelFor="widg_tfCF" errorFor="appDataricercaBollini.codiceFiscale" labelId="tfCFLbl"
	  >


<!-- widget tfCF -->
<s:textfield 
	
	
	name="appDataricercaBollini.codiceFiscale" id="widg_tfCF"
maxlength="16"	disabled="isWidgetDisabled('cpRicBollini','tfCF')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpRicBolliniManut --></div>

			
	
	<div id="p_cpFunAnnulla" class="commandPanelBlock"><!-- startFragment:p_cpFunAnnulla -->
	
	
<div class="commandPanel functional" id="cpFunAnnulla">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRicBollini','btnRicercaBollini')" >

	



<!-- widget btnRicercaBollini -->
<s:submit name="widg_btnRicercaBollini" id="widg_btnRicercaBollini" method="handleBtnRicercaBollini_CLICKED"
	key="cpRicBollini.btnRicercaBollini.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicBollini','btnRicercaBollini')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRicBollini','btAnnulla')" >

	



<!-- widget btAnnulla -->
<s:submit name="widg_btAnnulla" id="widg_btAnnulla" method="handleBtAnnulla_CLICKED"
	key="cpRicBollini.btAnnulla.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicBollini','btAnnulla')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunAnnulla --></div>

			
	
	<div id="p_cpNavRicBollini" class="commandPanelBlock"><!-- startFragment:p_cpNavRicBollini -->
	
	
<div class="commandPanel navigation" id="cpNavRicBollini">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRicBollini','btIndietro')" >

	



<!-- widget btIndietro -->
<s:submit name="widg_btIndietro" id="widg_btIndietro" method="handleBtIndietro_CLICKED"
	key="cpRicBollini.btIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicBollini','btIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavRicBollini --></div>

	

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
