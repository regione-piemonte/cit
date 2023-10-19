<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/import_massivo -->
<!-- pageId:cpImportMassivo -->

<s:form id="cpImportMassivo" action="cpImportMassivo" namespace="/base/import_massivo" method="post" enctype="multipart/form-data">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpImportMassivo_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpImportMassivo','menu')" >

	


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

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpImportMassivo_udpImpMass.jsp"></s:include>

	



			
	
	<div id="p_fpImpMassivo" class="formPanelBlock"><!-- startFragment:p_fpImpMassivo -->
		
	
<h4 class="fpLabel"><s:text name="cpImportMassivo.fpImpMassivo.label" /></h4>
<div class="formPanel" id="fpImpMassivo">


	
	

	
	
			
	
	<div id="p_stdMsgPHome" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgPHome -->
	
	
<div class="stdMessagePanel" id="stdMsgPHome">
	<customtag:stdMessagePanel id="stdMsgPHome" errorMessage="false" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgPHome --></div>

			
	
	<div id="p_wpRecBozze" class="widgetsPanelBlock"><!-- startFragment:p_wpRecBozze -->
	
	

<div class="widgetsPanel" id="wpRecBozze">
	
	<customtag:widgetsPanel id="wpRecBozzeTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpImportMassivo','fuImpMass')" >

	
<customtag:widgetsPanelColumn  tooltip="selezionare il file xml da inviare" labelField="true" textLabel="%{getText('cpImportMassivo.fuImpMass.label')}" labelFor="widg_fuImpMass" errorFor="widg_fuImpMass" labelId="fuImpMassLbl"
	position="first"  >


<s:file 
	
title="selezionare il file xml da inviare"	
	name="widg_fuImpMass" id="widg_fuImpMass"
	disabled="isWidgetDisabled('cpImportMassivo','fuImpMass')"
	
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue=""  position="first"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpRecBozze --></div>

			
	
	<div id="p_cpImpMass" class="commandPanelBlock"><!-- startFragment:p_cpImpMass -->
	
	
<div class="commandPanel functional" id="cpImpMass">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpImportMassivo','btAvviaImport')" >

	



<!-- widget btAvviaImport -->
<s:submit name="widg_btAvviaImport" id="widg_btAvviaImport" method="handleBtAvviaImport_CLICKED"
	key="cpImportMassivo.btAvviaImport.label" cssClass="buttonWidget confirm"
	disabled="isWidgetDisabled('cpImportMassivo','btAvviaImport')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpImpMass --></div>

	

		
	
</div>

	<!-- endFragment:p_fpImpMassivo --></div>

			
	
	<div id="p_cpImpMassBack" class="commandPanelBlock"><!-- startFragment:p_cpImpMassBack -->
	
	
<div class="commandPanel navigation" id="cpImpMassBack">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpImportMassivo','cbIndietro')" >

	



<!-- widget cbIndietro -->
<s:submit name="widg_cbIndietro" id="widg_cbIndietro" method="handleCbIndietro_CLICKED"
	key="cpImportMassivo.cbIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpImportMassivo','cbIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpImpMassBack --></div>

	

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
