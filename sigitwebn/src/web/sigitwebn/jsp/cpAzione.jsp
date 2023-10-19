<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_azioni -->
<!-- pageId:cpAzione -->

<s:form id="cpAzione" action="cpAzione" namespace="/base/gestisci_azioni" method="post" enctype="multipart/form-data">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpAzione_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpAzione','menu')" >

	


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

	
	

	
	
			
	
	<div id="p_fpDettaglioAzione" class="formPanelBlock"><!-- startFragment:p_fpDettaglioAzione -->
		
	
<h4 class="fpLabel"><s:text name="cpAzione.fpDettaglioAzione.label" /></h4>
<div class="formPanel" id="fpDettaglioAzione">


	
	

	
	
			
	
	<div id="p_stdMsg" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsg -->
	
	
<div class="stdMessagePanel" id="stdMsg">
	<customtag:stdMessagePanel id="stdMsg" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsg --></div>

			
	
	<div id="p_wpAzione" class="widgetsPanelBlock"><!-- startFragment:p_wpAzione -->
	
	
<h4 class="wpLabel">imposta azione </h4>
<div class="widgetsPanel" id="wpAzione">
	
	<customtag:widgetsPanel id="wpAzioneTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpAzione','ptDataAzione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpAzione.ptDataAzione.label')}" labelFor="widg_ptDataAzione" errorFor="appDataazione.dataAzione" labelId="ptDataAzioneLbl"   >


<!-- widget ptDataAzione -->
<s:property value="appDataazione.dataAzione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpAzione','ptSu')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpAzione.ptSu.label')}" labelFor="widg_ptSu" errorFor="appDataazione.descrizioneSu" labelId="ptSuLbl"   >


<!-- widget ptSu -->
<s:property value="appDataazione.descrizioneSu" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpAzione','taDes')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAzione.taDes.label')}" labelFor="widg_taDes" errorFor="appDataazione.descrizione" labelId="taDesLbl"
	  fieldRequired="true">


<!-- widget taDes -->
<s:textarea 
	
	
	name="appDataazione.descrizione" id="widg_taDes"
	disabled="isWidgetDisabled('cpAzione','taDes')"
	rows="2"
	cols="30"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpAzione','fuUpload')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAzione.fuUpload.label')}" labelFor="widg_fuUpload" errorFor="widg_fuUpload" labelId="fuUploadLbl"
	  >


<s:file 
	
	
	name="widg_fuUpload" id="widg_fuUpload"
	disabled="isWidgetDisabled('cpAzione','fuUpload')"
	
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAzione --></div>

			
	
	<div id="p_cpFun" class="commandPanelBlock"><!-- startFragment:p_cpFun -->
	
	
<div class="commandPanel functional" id="cpFun">

	
	
		
		
<s:if test="isWidgetVisible('cpAzione','btCarica')" >

	



<!-- widget btCarica -->
<s:submit name="widg_btCarica" id="widg_btCarica" method="handleBtCarica_CLICKED"
	key="cpAzione.btCarica.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpAzione','btCarica')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cpFun --></div>

			
	
	<div id="p_cpNav" class="commandPanelBlock"><!-- startFragment:p_cpNav -->
	
	
<div class="commandPanel navigation" id="cpNav">

	
	
		
		
<s:if test="isWidgetVisible('cpAzione','btIndietro')" >

	



<!-- widget btIndietro -->
<s:submit name="widg_btIndietro" id="widg_btIndietro" method="handleBtIndietro_CLICKED"
	key="cpAzione.btIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpAzione','btIndietro')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cpNav --></div>

	

		
	
</div>

	<!-- endFragment:p_fpDettaglioAzione --></div>

	

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
