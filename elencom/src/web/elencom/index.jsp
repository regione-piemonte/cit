<% 
	if (request.getQueryString()==null||request.getQueryString().length()==0){
  		response.sendRedirect(request.getContextPath() + "/secure/HomePage.do");
	}
	else{
		response.sendRedirect(request.getContextPath() + "/secure/HomePage.do?"+request.getQueryString());
	}
%>
