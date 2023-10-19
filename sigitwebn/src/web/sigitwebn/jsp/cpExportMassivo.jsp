<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/export_massivo -->
<!-- pageId:cpExportMassivo -->

<s:form id="cpExportMassivo" action="cpExportMassivo" namespace="/base/export_massivo" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpExportMassivo_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpExportMassivo','menu')" >

	


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

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpExportMassivo_udpExpMass.jsp"></s:include>

	



			
	
	<div id="p_fpExpMassivo" class="formPanelBlock"><!-- startFragment:p_fpExpMassivo -->
		
	
<h4 class="fpLabel"><s:text name="cpExportMassivo.fpExpMassivo.label" /></h4>
<div class="formPanel" id="fpExpMassivo">


	
	

	
	
			
	
	<div id="p_stdMsgPHome" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgPHome -->
	
	
<div class="stdMessagePanel" id="stdMsgPHome">
	<customtag:stdMessagePanel id="stdMsgPHome" errorMessage="false" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgPHome --></div>

			
	
	<div id="p_wpExpMass" class="widgetsPanelBlock"><!-- startFragment:p_wpExpMass -->
	
	

<div class="widgetsPanel" id="wpExpMass">
	
	<customtag:widgetsPanel id="wpExpMassTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpExportMassivo','taElenCodImp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpExportMassivo.taElenCodImp.label')}" labelFor="widg_taElenCodImp" errorFor="appDataelencoCodImpianto" labelId="taElenCodImpLbl"
	position="first"  >


<!-- widget taElenCodImp -->
<s:textarea 
	
title=""	
	name="appDataelencoCodImpianto" id="widg_taElenCodImp"
	disabled="isWidgetDisabled('cpExportMassivo','taElenCodImp')"
	rows="10"
	cols="30"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue=""  position="first"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpExpMass --></div>

			
	
	<div id="p_cpExpMass" class="commandPanelBlock"><!-- startFragment:p_cpExpMass -->
	
	
<div class="commandPanel functional" id="cpExpMass">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpExportMassivo','btAvviaExport')" >

	



<!-- widget btAvviaExport -->
<s:submit name="widg_btAvviaExport" id="widg_btAvviaExport" method="handleBtAvviaExport_CLICKED"
	key="cpExportMassivo.btAvviaExport.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpExportMassivo','btAvviaExport')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpExpMass --></div>

	

		
	
</div>

	<!-- endFragment:p_fpExpMassivo --></div>

			
	
	<div id="p_cpExpMassBack" class="commandPanelBlock"><!-- startFragment:p_cpExpMassBack -->
	
	
<div class="commandPanel navigation" id="cpExpMassBack">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpExportMassivo','cbIndietro')" >

	



<!-- widget cbIndietro -->
<s:submit name="widg_cbIndietro" id="widg_cbIndietro" method="handleCbIndietro_CLICKED"
	key="cpExportMassivo.cbIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpExportMassivo','cbIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpExpMassBack --></div>

	

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
