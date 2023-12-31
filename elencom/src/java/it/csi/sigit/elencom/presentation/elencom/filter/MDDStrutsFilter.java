package it.csi.sigit.elencom.presentation.elencom.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.StrutsStatics;
import org.apache.struts2.dispatcher.Dispatcher;
import org.apache.struts2.dispatcher.mapper.ActionMapping;
import org.apache.struts2.dispatcher.ng.ExecuteOperations;
import org.apache.struts2.dispatcher.ng.InitOperations;
import org.apache.struts2.dispatcher.ng.PrepareOperations;
import org.apache.struts2.dispatcher.ng.filter.FilterHostConfig;
import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;
import java.util.regex.Pattern;

/**
 * Implementazione custom del filter di Struts2 necessaria per poter utilizzare un 
 * dispatcher custom.
 */
public class MDDStrutsFilter implements StrutsStatics, Filter {
	protected PrepareOperations prepare;
	protected ExecuteOperations execute;
	protected List<Pattern> excludedPatterns = null;

	public void init(FilterConfig filterConfig) throws ServletException {
		// Le variazioni iniziano qui....
		MDDInitOperations init = new MDDInitOperations();
		// ... e finiscono qui
		try {
			FilterHostConfig config = new FilterHostConfig(filterConfig);
			init.initLogging(config);
			Dispatcher dispatcher = init.initDispatcher(config);
			init.initStaticContentLoader(config, dispatcher);

			prepare = new PrepareOperations(filterConfig.getServletContext(), dispatcher);
			execute = new ExecuteOperations(filterConfig.getServletContext(), dispatcher);
			this.excludedPatterns = init.buildExcludedPatternsList(dispatcher);

			postInit(dispatcher, filterConfig);
		} finally {
			init.cleanup();
		}

	}

	/**
	 * Callback for post initialization
	 */
	protected void postInit(Dispatcher dispatcher, FilterConfig filterConfig) {
		//nothing to do
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		try {
			prepare.setEncodingAndLocale(request, response);
			prepare.createActionContext(request, response);
			prepare.assignDispatcherToThread();
			if (excludedPatterns != null && prepare.isUrlExcluded(request, excludedPatterns)) {
				chain.doFilter(request, response);
			} else {
				request = prepare.wrapRequest(request);
				ActionMapping mapping = prepare.findActionMapping(request, response, true);
				if (mapping == null) {
					boolean handled = execute.executeStaticResourceRequest(request, response);
					if (!handled) {
						chain.doFilter(request, response);
					}
				} else {
					execute.executeAction(request, response, mapping);
				}
			}
		} finally {
			prepare.cleanupRequest(request);
		}
	}

	public void destroy() {
		prepare.cleanupDispatcher();
	}
}
