package it.csi.sigit.elencom.presentation.elencom.filter;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.ActionProxyFactory;
import com.opensymphony.xwork2.FileManager;
import com.opensymphony.xwork2.FileManagerFactory;
import com.opensymphony.xwork2.LocaleProvider;
import com.opensymphony.xwork2.ObjectFactory;
import com.opensymphony.xwork2.Result;
import com.opensymphony.xwork2.config.Configuration;
import com.opensymphony.xwork2.config.ConfigurationException;
import com.opensymphony.xwork2.config.ConfigurationManager;
import com.opensymphony.xwork2.config.ConfigurationProvider;
import com.opensymphony.xwork2.config.FileManagerFactoryProvider;
import com.opensymphony.xwork2.config.FileManagerProvider;
import com.opensymphony.xwork2.config.entities.InterceptorMapping;
import com.opensymphony.xwork2.config.entities.InterceptorStackConfig;
import com.opensymphony.xwork2.config.entities.PackageConfig;
import com.opensymphony.xwork2.config.providers.XmlConfigurationProvider;
import com.opensymphony.xwork2.inject.Container;
import com.opensymphony.xwork2.inject.ContainerBuilder;
import com.opensymphony.xwork2.inject.Inject;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.util.ClassLoaderUtil;
import com.opensymphony.xwork2.util.LocalizedTextUtil;
import com.opensymphony.xwork2.util.ValueStack;
import com.opensymphony.xwork2.util.ValueStackFactory;
import com.opensymphony.xwork2.util.location.LocatableProperties;
import com.opensymphony.xwork2.util.location.Location;
import com.opensymphony.xwork2.util.location.LocationUtils;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import com.opensymphony.xwork2.util.profiling.UtilTimerStack;
import freemarker.template.Template;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsConstants;
import org.apache.struts2.StrutsException;
import org.apache.struts2.StrutsStatics;
import org.apache.struts2.config.DefaultBeanSelectionProvider;
import org.apache.struts2.config.DefaultPropertiesProvider;
import org.apache.struts2.config.PropertiesConfigurationProvider;
import org.apache.struts2.config.StrutsXmlConfigurationProvider;
import org.apache.struts2.dispatcher.mapper.ActionMapping;
import org.apache.struts2.dispatcher.Dispatcher;
import org.apache.struts2.dispatcher.DispatcherListener;
import org.apache.struts2.dispatcher.FilterDispatcher;
import org.apache.struts2.dispatcher.RequestMap;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.dispatcher.ApplicationMap;
import org.apache.struts2.dispatcher.StrutsRequestWrapper;
import org.apache.struts2.dispatcher.multipart.MultiPartRequest;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;
import org.apache.struts2.util.AttributeMap;
import org.apache.struts2.util.ObjectFactoryDestroyable;
import org.apache.struts2.util.fs.JBossFileManager;
import org.apache.struts2.views.freemarker.FreemarkerManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * A utility class the actual dispatcher delegates most of its tasks to. Each instance
 * of the primary dispatcher holds an instance of this dispatcher to be shared for
 * all requests.
 *
 * @see org.apache.struts2.dispatcher.FilterDispatcher
 */
public class MDDDispatcher extends Dispatcher {

	/**
	 * Provide a logging instance.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(Dispatcher.class);

	/**
	 * Provide a thread local instance.
	 */
	private static ThreadLocal<Dispatcher> instance = new ThreadLocal<Dispatcher>();

	/**
	 * Store list of DispatcherListeners.
	 */
	private static List<DispatcherListener> dispatcherListeners = new CopyOnWriteArrayList<DispatcherListener>();

	/**
	 * Store ConfigurationManager instance, set on init.
	 */
	private ConfigurationManager configurationManager;

	/**
	 * Store state of StrutsConstants.STRUTS_DEVMODE setting.
	 */
	private boolean devMode;

	/**
	 * Store state of StrutsConstants.DISABLE_REQUEST_ATTRIBUTE_VALUE_STACK_LOOKUP setting.
	 */
	private boolean disableRequestAttributeValueStackLookup;

	/**
	 * Store state of StrutsConstants.STRUTS_I18N_ENCODING setting.
	 */
	private String defaultEncoding;

	/**
	 * Store state of StrutsConstants.STRUTS_LOCALE setting.
	 */
	private String defaultLocale;

	/**
	 * Store state of StrutsConstants.STRUTS_MULTIPART_SAVEDIR setting.
	 */
	private String multipartSaveDir;

	/**
	 * Stores the value of {@link StrutsConstants#STRUTS_MULTIPART_PARSER} setting
	 */
	private String multipartHandlerName;

	/**
	 * Provide list of default configuration files.
	 */
	private static final String DEFAULT_CONFIGURATION_PATHS = "struts-default.xml,struts-plugin.xml,struts.xml";

	/**
	 * Store state of STRUTS_DISPATCHER_PARAMETERSWORKAROUND.
	 * <p/>
	 * The workaround is for WebLogic.
	 * We try to autodect WebLogic on Dispatcher init.
	 * The workaround can also be enabled manually.
	 */
	private boolean paramsWorkaroundEnabled = false;

	/**
	 * Indicates if Dispatcher should handle exception and call sendError()
	 * Introduced to allow integration with other frameworks like Spring Security
	 */
	private boolean handleException;

	/**
	 * Provide the dispatcher instance for the current thread.
	 *
	 * @return The dispatcher instance
	 */
	public static Dispatcher getInstance() {
		return instance.get();
	}

	/**
	 * Store the dispatcher instance for this thread.
	 *
	 * @param instance The instance
	 */
	public static void setInstance(Dispatcher instance) {
		MDDDispatcher.instance.set(instance);
	}

	/**
	 * Add a dispatcher lifecycle listener.
	 *
	 * @param listener The listener to add
	 */
	public static void addDispatcherListener(DispatcherListener listener) {
		dispatcherListeners.add(listener);
	}

	/**
	 * Remove a specific dispatcher lifecycle listener.
	 *
	 * @param listener The listener
	 */
	public static void removeDispatcherListener(DispatcherListener listener) {
		dispatcherListeners.remove(listener);
	}

	private ServletContext servletContext;
	private Map<String, String> initParams;

	private ValueStackFactory valueStackFactory;

	/**
	 * Create the Dispatcher instance for a given ServletContext and set of initialization parameters.
	 *
	 * @param servletContext Our servlet context
	 * @param initParams The set of initialization parameters
	 */
	public MDDDispatcher(ServletContext servletContext, Map<String, String> initParams) {
		super(servletContext, initParams);
		this.servletContext = servletContext;
		this.initParams = initParams;
	}

	/**
	 * Modify state of StrutsConstants.STRUTS_DEVMODE setting.
	 * @param mode New setting
	 */
	@Inject(StrutsConstants.STRUTS_DEVMODE)
	public void setDevMode(String mode) {
		devMode = "true".equals(mode);
	}

	/**
	 * Modify state of StrutsConstants.DISABLE_REQUEST_ATTRIBUTE_VALUE_STACK_LOOKUP setting.
	 * @param disableRequestAttributeValueStackLookup New setting
	 */
	@Inject(value = StrutsConstants.STRUTS_DISABLE_REQUEST_ATTRIBUTE_VALUE_STACK_LOOKUP, required = false)
	public void setDisableRequestAttributeValueStackLookup(String disableRequestAttributeValueStackLookup) {
		this.disableRequestAttributeValueStackLookup = "true".equalsIgnoreCase(disableRequestAttributeValueStackLookup);
	}

	/**
	 * Modify state of StrutsConstants.STRUTS_LOCALE setting.
	 * @param val New setting
	 */
	@Inject(value = StrutsConstants.STRUTS_LOCALE, required = false)
	public void setDefaultLocale(String val) {
		defaultLocale = val;
	}

	/**
	 * Modify state of StrutsConstants.STRUTS_I18N_ENCODING setting.
	 * @param val New setting
	 */
	@Inject(StrutsConstants.STRUTS_I18N_ENCODING)
	public void setDefaultEncoding(String val) {
		defaultEncoding = val;
	}

	/**
	 * Modify state of StrutsConstants.STRUTS_MULTIPART_SAVEDIR setting.
	 * @param val New setting
	 */
	@Inject(StrutsConstants.STRUTS_MULTIPART_SAVEDIR)
	public void setMultipartSaveDir(String val) {
		multipartSaveDir = val;
	}

	@Inject(StrutsConstants.STRUTS_MULTIPART_PARSER)
	public void setMultipartHandler(String val) {
		multipartHandlerName = val;
	}

	@Inject
	public void setValueStackFactory(ValueStackFactory valueStackFactory) {
		this.valueStackFactory = valueStackFactory;
	}

	@Inject(StrutsConstants.STRUTS_HANDLE_EXCEPTION)
	public void setHandleException(String handleException) {
		this.handleException = Boolean.parseBoolean(handleException);
	}

	/**
	 * Releases all instances bound to this dispatcher instance.
	 */
	public void cleanup() {

		// clean up ObjectFactory
		ObjectFactory objectFactory = getContainer().getInstance(ObjectFactory.class);
		if (objectFactory == null) {
			if (LOG.isWarnEnabled()) {
				LOG.warn("Object Factory is null, something is seriously wrong, no clean up will be performed");
			}
		}
		if (objectFactory instanceof ObjectFactoryDestroyable) {
			try {
				((ObjectFactoryDestroyable) objectFactory).destroy();
			} catch (Exception e) {
				// catch any exception that may occurred during destroy() and log it
				LOG.error("exception occurred while destroying ObjectFactory [#0]", e, objectFactory.toString());
			}
		}

		// clean up Dispatcher itself for this thread
		instance.set(null);

		// clean up DispatcherListeners
		if (!dispatcherListeners.isEmpty()) {
			for (DispatcherListener l : dispatcherListeners) {
				l.dispatcherDestroyed(this);
			}
		}

		// clean up all interceptors by calling their destroy() method
		Set<Interceptor> interceptors = new HashSet<Interceptor>();
		Collection<PackageConfig> packageConfigs = configurationManager.getConfiguration().getPackageConfigs().values();
		for (PackageConfig packageConfig : packageConfigs) {
			for (Object config : packageConfig.getAllInterceptorConfigs().values()) {
				if (config instanceof InterceptorStackConfig) {
					for (InterceptorMapping interceptorMapping : ((InterceptorStackConfig) config).getInterceptors()) {
						interceptors.add(interceptorMapping.getInterceptor());
					}
				}
			}
		}
		for (Interceptor interceptor : interceptors) {
			interceptor.destroy();
		}

		// Clear container holder when application is unloaded / server shutdown
		ContainerHolder.clear();

		//cleanup action context
		ActionContext.setContext(null);

		// clean up configuration
		configurationManager.destroyConfiguration();
		configurationManager = null;
	}

	private void init_FileManager() throws ClassNotFoundException {
		if (initParams.containsKey(StrutsConstants.STRUTS_FILE_MANAGER)) {
			final String fileManagerClassName = initParams.get(StrutsConstants.STRUTS_FILE_MANAGER);
			final Class<FileManager> fileManagerClass = (Class<FileManager>) Class.forName(fileManagerClassName);
			if (LOG.isInfoEnabled()) {
				LOG.info("Custom FileManager specified: #0", fileManagerClassName);
			}
			configurationManager
					.addContainerProvider(new FileManagerProvider(fileManagerClass, fileManagerClass.getSimpleName()));
		} else {
			// add any other Struts 2 provided implementations of FileManager
			configurationManager.addContainerProvider(new FileManagerProvider(JBossFileManager.class, "jboss"));
		}
		if (initParams.containsKey(StrutsConstants.STRUTS_FILE_MANAGER_FACTORY)) {
			final String fileManagerFactoryClassName = initParams.get(StrutsConstants.STRUTS_FILE_MANAGER_FACTORY);
			final Class<FileManagerFactory> fileManagerFactoryClass = (Class<FileManagerFactory>) Class
					.forName(fileManagerFactoryClassName);
			if (LOG.isInfoEnabled()) {
				LOG.info("Custom FileManagerFactory specified: #0", fileManagerFactoryClassName);
			}
			configurationManager.addContainerProvider(new FileManagerFactoryProvider(fileManagerFactoryClass));
		}
	}

	private void init_DefaultProperties() {
		configurationManager.addContainerProvider(new DefaultPropertiesProvider());
	}

	private void init_LegacyStrutsProperties() {
		configurationManager.addContainerProvider(new PropertiesConfigurationProvider());
	}

	private void init_TraditionalXmlConfigurations() {
		String configPaths = initParams.get("config");
		if (configPaths == null) {
			configPaths = DEFAULT_CONFIGURATION_PATHS;
		}
		String[] files = configPaths.split("\\s*[,]\\s*");
		for (String file : files) {
			if (file.endsWith(".xml")) {
				if ("xwork.xml".equals(file)) {
					configurationManager.addContainerProvider(createXmlConfigurationProvider(file, false));
				} else {
					configurationManager
							.addContainerProvider(createStrutsXmlConfigurationProvider(file, false, servletContext));
				}
			} else {
				throw new IllegalArgumentException("Invalid configuration file name");
			}
		}
	}

	protected XmlConfigurationProvider createXmlConfigurationProvider(String filename, boolean errorIfMissing) {
		return new XmlConfigurationProvider(filename, errorIfMissing);
	}

	protected XmlConfigurationProvider createStrutsXmlConfigurationProvider(String filename, boolean errorIfMissing,
			ServletContext ctx) {
		return new StrutsXmlConfigurationProvider(filename, errorIfMissing, ctx);
	}

	private void init_CustomConfigurationProviders() {
		String configProvs = initParams.get("configProviders");
		if (configProvs != null) {
			String[] classes = configProvs.split("\\s*[,]\\s*");
			for (String cname : classes) {
				try {
					Class cls = ClassLoaderUtil.loadClass(cname, this.getClass());
					ConfigurationProvider prov = (ConfigurationProvider) cls.newInstance();
					configurationManager.addContainerProvider(prov);
				} catch (InstantiationException e) {
					throw new ConfigurationException("Unable to instantiate provider: " + cname, e);
				} catch (IllegalAccessException e) {
					throw new ConfigurationException("Unable to access provider: " + cname, e);
				} catch (ClassNotFoundException e) {
					throw new ConfigurationException("Unable to locate provider class: " + cname, e);
				}
			}
		}
	}

	private void init_FilterInitParameters() {
		configurationManager.addContainerProvider(new ConfigurationProvider() {
			public void destroy() {
				// intenzionalmente vuoto
			}

			public void init(Configuration configuration) throws ConfigurationException {
				// intenzionalmente vuoto
			}

			public void loadPackages() throws ConfigurationException {
				// intenzionalmente vuoto
			}

			public boolean needsReload() {
				return false;
			}

			public void register(ContainerBuilder builder, LocatableProperties props) throws ConfigurationException {
				props.putAll(initParams);
			}
		});
	}

	private void init_AliasStandardObjects() {
		configurationManager.addContainerProvider(new DefaultBeanSelectionProvider());
	}

	private Container init_PreloadConfiguration() {
		Configuration config = configurationManager.getConfiguration();
		Container container = config.getContainer();

		boolean reloadi18n = Boolean.valueOf(container.getInstance(String.class, StrutsConstants.STRUTS_I18N_RELOAD));
		LocalizedTextUtil.setReloadBundles(reloadi18n);

		ContainerHolder.store(container);

		return container;
	}

	private void init_CheckWebLogicWorkaround(Container container) {
		// test whether param-access workaround needs to be enabled
		if (servletContext != null && servletContext.getServerInfo() != null
				&& servletContext.getServerInfo().contains("WebLogic")) {
			if (LOG.isInfoEnabled()) {
				LOG.info("WebLogic server detected. Enabling Struts parameter access work-around.");
			}
			paramsWorkaroundEnabled = true;
		} else {
			paramsWorkaroundEnabled = "true".equals(
					container.getInstance(String.class, StrutsConstants.STRUTS_DISPATCHER_PARAMETERSWORKAROUND));
		}
	}

	/**
	 * Load configurations, including both XML and zero-configuration strategies,
	 * and update optional settings, including whether to reload configurations and resource files.
	 */
	public void init() {

		if (configurationManager == null) {
			configurationManager = createConfigurationManager(DefaultBeanSelectionProvider.DEFAULT_BEAN_NAME);
		}

		try {
			init_FileManager();
			init_DefaultProperties(); // [1]
			init_TraditionalXmlConfigurations(); // [2]
			init_LegacyStrutsProperties(); // [3]
			init_CustomConfigurationProviders(); // [5]
			init_FilterInitParameters(); // [6]
			init_AliasStandardObjects(); // [7]

			Container container = init_PreloadConfiguration();
			container.inject(this);
			init_CheckWebLogicWorkaround(container);

			if (!dispatcherListeners.isEmpty()) {
				for (DispatcherListener l : dispatcherListeners) {
					l.dispatcherInitialized(this);
				}
			}
		} catch (Exception ex) {
			if (LOG.isErrorEnabled())
				LOG.error("Dispatcher initialization failed", ex);
			throw new StrutsException(ex);
		}
	}

	protected ConfigurationManager createConfigurationManager(String name) {
		return new ConfigurationManager(name);
	}

	/**
	 * @deprecated
	 */
	public void serviceAction(HttpServletRequest p_request, HttpServletResponse p_response, ServletContext p_context,
			ActionMapping p_mapping) throws ServletException {
		serviceAction(p_request, p_response, p_mapping);
	}

	/**
	 * Load Action class for mapping and invoke the appropriate Action method, or go directly to the Result.
	 * <p/>
	 * This method first creates the action context from the given parameters,
	 * and then loads an <tt>ActionProxy</tt> from the given action name and namespace.
	 * After that, the Action method is executed and output channels through the response object.
	 * Actions not found are sent back to the user via the {@link Dispatcher#sendError} method,
	 * using the 404 return code.
	 * All other errors are reported by throwing a ServletException.
	 *
	 * @param request  the HttpServletRequest object
	 * @param response the HttpServletResponse object
	 * @param mapping  the action mapping object
	 * @throws ServletException when an unknown error occurs (not a 404, but typically something that
	 *                          would end up as a 5xx by the servlet container)
	 * @param context Our ServletContext object
	 */
	public void serviceAction(HttpServletRequest p_request, HttpServletResponse p_response, ActionMapping p_mapping)
			throws ServletException {
		HttpServletRequest request = p_request;
		HttpServletResponse response = p_response;
		ActionMapping mapping = p_mapping;
		Map<String, Object> extraContext = createContextMap(request, response, mapping, servletContext);

		// If there was a previous value stack, then create a new copy and pass it in to be used by the new Action
		ValueStack stack = (ValueStack) request.getAttribute(ServletActionContext.STRUTS_VALUESTACK_KEY);
		boolean nullStack = stack == null;
		if (nullStack) {
			ActionContext ctx = ActionContext.getContext();
			if (ctx != null) {
				stack = ctx.getValueStack();
			}
		}
		if (stack != null) {
			extraContext.put(ActionContext.VALUE_STACK, valueStackFactory.createValueStack(stack));
		}

		String timerKey = "Handling request from Dispatcher";
		try {
			UtilTimerStack.push(timerKey);
			String namespace = mapping.getNamespace();
			// L'unica variazione inizia qui...
			//// per qualche motivo con struts 2.3.16.3 il mapping non arriva correttamente configurato

			mapping = adjustMappingWithMethod(request, mapping);

			Configuration config = configurationManager.getConfiguration();
			ActionProxy proxy = config.getContainer().getInstance(ActionProxyFactory.class).createActionProxy(namespace,
					mapping.getName(), mapping.getMethod(), extraContext, true, false);

			// ... e finisce qui
			request.setAttribute(ServletActionContext.STRUTS_VALUESTACK_KEY, proxy.getInvocation().getStack());

			// if the ActionMapping says to go straight to a result, do it!
			if (mapping.getResult() != null) {
				Result result = mapping.getResult();
				result.execute(proxy.getInvocation());
			} else {
				proxy.execute();
			}

			// If there was a previous value stack then set it back onto the request
			if (!nullStack) {
				request.setAttribute(ServletActionContext.STRUTS_VALUESTACK_KEY, stack);
			}
		} catch (ConfigurationException e) {
			logConfigurationException(request, e);
			sendError(request, response, servletContext, HttpServletResponse.SC_NOT_FOUND, e);
		} catch (Exception e) { //NOSONAR  Reason:dubbia classificazione severity (gia' cosi' in src struts2
			if (handleException || devMode) {
				sendError(request, response, servletContext, HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e);
			} else {
				throw new ServletException(e);
			}
		} finally {
			UtilTimerStack.pop(timerKey);
		}
	}

	static final String METHOD_PARAM_PREFIX = "method:";

	/**
	 * corregge il mapping ricercando un parametro method:*** o una forma action!method nel name
	 */
	private ActionMapping adjustMappingWithMethod(HttpServletRequest req, ActionMapping mapping) {
		// nel caso in cui sia gia' impostato non fa piu' niente
		String actualMethodName = mapping.getMethod();
		if (actualMethodName != null && actualMethodName.length() > 0) {
			return mapping;
		} else {
			// prima cerca nel name (per vedere se della forma action!method[?parametri] )
			actualMethodName = getMethodNameOnly(mapping.getName());
			if (actualMethodName == null || actualMethodName.length() == 0) {
				// se non ancora impostato cerca tra i parametri un parametro con nome tipo "method:xxxxx"
				java.util.Enumeration<String> eParamNames = req.getParameterNames();
				while (eParamNames.hasMoreElements()) {
					String currParamName = eParamNames.nextElement();
					if (currParamName.startsWith(METHOD_PARAM_PREFIX)) {
						// trovato!
						actualMethodName = normalizeMethodName(currParamName.substring(7));
					}
				}
				mapping.setMethod(actualMethodName);
			} else {
				// trovato nel name
				mapping.setMethod(actualMethodName);
				mapping.setName(getActionNameOnly(mapping.getName()));
			}
			return mapping;
		}
	}

	/**
	 * Ripulisce il nome del metodo eliminando eventuali caratteri aggiuntivi utilizzati
	 * per trasportare parametri (dopo un eventuale '?').
	 * @param origMethodName
	 * @return
	 */
	private String normalizeMethodName(String origMethodName) {
		String method = null;
		if (origMethodName != null && origMethodName.contains("?")) {
			method = origMethodName.substring(0, origMethodName.indexOf("?"));
		} else
			method = origMethodName;
		return method;

	}

	/**
	 * estrae il nome della action da una struttura che potenzialmente
	 * contiene anche il nome del metodo nel formato:
	 * nomeAction!nomeMetodo
	 * @param origActionAndMethod la stringa originale
	 * @return
	 */
	private String getActionNameOnly(String origActionAndMethod) {
		if (origActionAndMethod.contains("!")) {
			return origActionAndMethod.substring(0, origActionAndMethod.indexOf('!'));
		} else {
			return origActionAndMethod;
		}
	}

	/**
	 * estrae il nome del metodo da una struttura che potenzialmente
	 * lo contiene:
	 * nomeAction!nomeMetodo
	 * se il metodo non e' presente viene restituita la stringa vuota.
	 * Il risultato viene ulteriormente depurato di eventuali parametri,
	 * tramite il metodo "normalizeMethodName()"
	 * @param origActionAndMethod la stringa originale
	 * @return
	 */
	private String getMethodNameOnly(String origActionAndMethod) {
		if (origActionAndMethod.contains("!")) {
			return normalizeMethodName(origActionAndMethod.substring(origActionAndMethod.indexOf('!') + 1));
		} else {
			return "";
		}
	}

	/**
	 * Performs logging of missing action/result configuration exception
	 *
	 * @param request current {@link HttpServletRequest}
	 * @param e {@link ConfigurationException} that occurred
	 */
	protected void logConfigurationException(HttpServletRequest request, ConfigurationException e) {
		// WW-2874 Only log error if in devMode
		String uri = request.getRequestURI();
		if (request.getQueryString() != null) {
			uri = uri + "?" + request.getQueryString();
		}
		if (devMode) {
			LOG.error("Could not find action or result\n#0", e, uri);
		} else if (LOG.isWarnEnabled()) {
			LOG.warn("Could not find action or result: #0", e, uri);
		}
	}

	/**
	 * Create a context map containing all the wrapped request objects
	 *
	 * @param request The servlet request
	 * @param response The servlet response
	 * @param mapping The action mapping
	 * @param context The servlet context
	 * @return A map of context objects
	 */
	public Map<String, Object> createContextMap(HttpServletRequest request, HttpServletResponse response,
			ActionMapping mapping, ServletContext context) {

		// request map wrapping the http request objects
		Map requestMap = new RequestMap(request);

		// parameters map wrapping the http parameters.  ActionMapping parameters are now handled and applied separately
		Map params = new HashMap(request.getParameterMap());

		// session map wrapping the http session
		Map session = new SessionMap(request);

		// application map wrapping the ServletContext
		Map application = new ApplicationMap(context);

		Map<String, Object> extraContext = createContextMap(requestMap, params, session, application, request, response,
				context);

		if (mapping != null) {
			extraContext.put(ServletActionContext.ACTION_MAPPING, mapping);
		}
		return extraContext;
	}

	/**
	 * Merge all application and servlet attributes into a single <tt>HashMap</tt> to represent the entire
	 * <tt>Action</tt> context.
	 *
	 * @param requestMap     a Map of all request attributes.
	 * @param parameterMap   a Map of all request parameters.
	 * @param sessionMap     a Map of all session attributes.
	 * @param applicationMap a Map of all servlet context attributes.
	 * @param request        the HttpServletRequest object.
	 * @param response       the HttpServletResponse object.
	 * @param servletContext the ServletContextmapping object.
	 * @return a HashMap representing the <tt>Action</tt> context.
	 */
	public HashMap<String, Object> createContextMap(Map requestMap, Map parameterMap, Map sessionMap,
			Map applicationMap, HttpServletRequest request, HttpServletResponse response,
			ServletContext servletContext) {
		HashMap<String, Object> extraContext = new HashMap<String, Object>();
		extraContext.put(ActionContext.PARAMETERS, new HashMap(parameterMap));
		extraContext.put(ActionContext.SESSION, sessionMap);
		extraContext.put(ActionContext.APPLICATION, applicationMap);

		Locale locale;
		if (defaultLocale != null) {
			locale = LocalizedTextUtil.localeFromString(defaultLocale, request.getLocale());
		} else {
			locale = request.getLocale();
		}

		extraContext.put(ActionContext.LOCALE, locale);

		extraContext.put(StrutsStatics.HTTP_REQUEST, request);
		extraContext.put(StrutsStatics.HTTP_RESPONSE, response);
		extraContext.put(StrutsStatics.SERVLET_CONTEXT, servletContext);

		// helpers to get access to request/session/application scope
		extraContext.put("request", requestMap);
		extraContext.put("session", sessionMap);
		extraContext.put("application", applicationMap);
		extraContext.put("parameters", parameterMap);

		AttributeMap attrMap = new AttributeMap(extraContext);
		extraContext.put("attr", attrMap);

		return extraContext;
	}

	/**
	 * Return the path to save uploaded files to (this is configurable).
	 *
	 * @return the path to save uploaded files to
	 * @param servletContext Our ServletContext
	 */
	private String getSaveDir(ServletContext servletContext) {
		String saveDir = multipartSaveDir.trim();

		if (saveDir.equals("")) {
			File tempdir = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
			if (LOG.isInfoEnabled()) {
				LOG.info(
						"Unable to find 'struts.multipart.saveDir' property setting. Defaulting to javax.servlet.context.tempdir");
			}

			if (tempdir != null) {
				saveDir = tempdir.toString();
				setMultipartSaveDir(saveDir);
			}
		} else {
			File multipartSaveDir = new File(saveDir);

			if (!multipartSaveDir.exists()) {
				if (!multipartSaveDir.mkdirs()) {
					String logMessage;
					try {
						logMessage = "Could not find create multipart save directory '"
								+ multipartSaveDir.getCanonicalPath() + "'.";
					} catch (IOException e) { //NOSONAR  Reason:dubbia classificazione severity (gia' cosi' in src struts2
						logMessage = "Could not find create multipart save directory '" + multipartSaveDir.toString()
								+ "'.";
					}
					if (devMode) {
						LOG.error(logMessage);
					} else {
						if (LOG.isWarnEnabled()) {
							LOG.warn(logMessage);
						}
					}
				}
			}
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("saveDir=" + saveDir);
		}

		return saveDir;
	}

	/**
	 * Prepare a request, including setting the encoding and locale.
	 *
	 * @param request The request
	 * @param response The response
	 */
	public void prepare(HttpServletRequest request, HttpServletResponse response) {
		String encoding = null;
		if (defaultEncoding != null) {
			encoding = defaultEncoding;
		}
		// check for Ajax request to use UTF-8 encoding strictly http://www.w3.org/TR/XMLHttpRequest/#the-send-method
		if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
			encoding = "UTF-8";
		}

		Locale locale = null;
		if (defaultLocale != null) {
			locale = LocalizedTextUtil.localeFromString(defaultLocale, request.getLocale());
		}

		if (encoding != null) {
			applyEncoding(request, encoding);
		}

		if (locale != null) {
			response.setLocale(locale);
		}

		if (paramsWorkaroundEnabled) {
			request.getParameter("foo"); // simply read any parameter (existing or not) to "prime" the request
		}
	}

	private void applyEncoding(HttpServletRequest request, String encoding) {
		try {
			if (!encoding.equals(request.getCharacterEncoding())) {
				// if the encoding is already correctly set and the parameters have been already read
				// do not try to set encoding because it is useless and will cause an error
				request.setCharacterEncoding(encoding);
			}
		} catch (Exception e) { //NOSONAR  Reason:dubbia classificazione severity (gia' cosi' in src struts2
			LOG.error("Error setting character encoding to '" + encoding + "' - ignoring.", e);
		}
	}

	/**
	 * @deprecated
	 */
	public HttpServletRequest wrapRequest(HttpServletRequest request, ServletContext servletContext)
			throws IOException {
		return wrapRequest(request);
	}

	/**
	 * Wrap and return the given request or return the original request object.
	 * </p>
	 * This method transparently handles multipart data as a wrapped class around the given request.
	 * Override this method to handle multipart requests in a special way or to handle other types of requests.
	 * Note, {@link org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper} is
	 * flexible - look first to that object before overriding this method to handle multipart data.
	 *
	 * @param request the HttpServletRequest object.
	 * @param servletContext Our ServletContext object
	 * @return a wrapped request or original request.
	 * @see org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper
	 * @throws java.io.IOException on any error.
	 */
	public HttpServletRequest wrapRequest(HttpServletRequest request) throws IOException {
		// don't wrap more than once
		if (request instanceof StrutsRequestWrapper) {
			return request;
		}

		String content_type = request.getContentType();
		if (content_type != null && content_type.contains("multipart/form-data")) {
			MultiPartRequest mpr = getMultiPartRequest();
			LocaleProvider provider = getContainer().getInstance(LocaleProvider.class);
			request = new MultiPartRequestWrapper(mpr, request, getSaveDir(servletContext), provider);
		} else {
			request = new StrutsRequestWrapper(request, disableRequestAttributeValueStackLookup);
		}

		return request;
	}

	/**
	 * On each request it must return a new instance as implementation could be not thread safe
	 * and thus ensure of resource clean up
	 *
	 * @return
	 */
	protected MultiPartRequest getMultiPartRequest() {
		MultiPartRequest mpr = null;
		//check for alternate implementations of MultiPartRequest
		Set<String> multiNames = getContainer().getInstanceNames(MultiPartRequest.class);
		for (String multiName : multiNames) {
			if (multiName.equals(multipartHandlerName)) {
				mpr = getContainer().getInstance(MultiPartRequest.class, multiName);
			}
		}
		if (mpr == null) {
			mpr = getContainer().getInstance(MultiPartRequest.class);
		}
		return mpr;
	}

	/**
	 * Removes all the files created by MultiPartRequestWrapper.
	 *
	 * @param request the HttpServletRequest object.
	 * @see org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper
	 */
	public void cleanUpRequest(HttpServletRequest request) {
		ContainerHolder.clear();
		if (!(request instanceof MultiPartRequestWrapper)) {
			return;
		}
		MultiPartRequestWrapper multiWrapper = (MultiPartRequestWrapper) request;
		multiWrapper.cleanUp();
	}

	/**
	 * Send an HTTP error response code.
	 *
	 * @param request  the HttpServletRequest object.
	 * @param response the HttpServletResponse object.
	 * @param code     the HttpServletResponse error code (see {@link javax.servlet.http.HttpServletResponse} for possible error codes).
	 * @param e        the Exception that is reported.
	 * @param ctx      the ServletContext object.
	 */
	public void sendError(HttpServletRequest request, HttpServletResponse response, ServletContext ctx, int code,
			Exception e) {
		Boolean devModeOverride = FilterDispatcher.getDevModeOverride();
		if (devModeOverride != null ? devModeOverride : devMode) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("Exception occurred during processing request: #0", e, e.getMessage());
			}
			try {
				FreemarkerManager mgr = getContainer().getInstance(FreemarkerManager.class);

				freemarker.template.Configuration config = mgr.getConfiguration(ctx);
				Template template = config.getTemplate("/org/apache/struts2/dispatcher/error.ftl");

				List<Throwable> chain = new ArrayList<Throwable>();
				Throwable cur = e;
				chain.add(cur);
				while ((cur = cur.getCause()) != null) {
					chain.add(cur);
				}

				HashMap<String, Object> data = new HashMap<String, Object>();
				data.put("exception", e);
				data.put("unknown", Location.UNKNOWN);
				data.put("chain", chain);
				data.put("locator", new Locator());

				Writer writer = new StringWriter();
				template.process(data, writer);

				response.setContentType("text/html");
				response.getWriter().write(writer.toString());
				response.getWriter().close();
			} catch (Exception exp) {
				try {
					if (LOG.isDebugEnabled()) {
						LOG.debug("Cannot show problem report!", exp);
					}
					response.sendError(code,
							"Unable to show problem report:\n" + exp + "\n\n" + LocationUtils.getLocation(exp));
				} catch (IOException ex) { //NOSONAR  Reason:dubbia classificazione severity (gia' cosi' in src struts2
					// we're already sending an error, not much else we can do if more stuff breaks
				}
			}
		} else {
			try {
				// WW-1977: Only put errors in the request when code is a 500 error
				if (code == HttpServletResponse.SC_INTERNAL_SERVER_ERROR) {
					// WW-4103: Only logs error when application error occurred, not Struts error
					if (LOG.isErrorEnabled()) {
						LOG.error("Exception occurred during processing request: #0", e, e.getMessage());
					}
					// send a http error response to use the servlet defined error handler
					// make the exception availible to the web.xml defined error page
					request.setAttribute("javax.servlet.error.exception", e);

					// for compatibility
					request.setAttribute("javax.servlet.jsp.jspException", e);
				}

				// send the error response
				response.sendError(code, e.getMessage());
			} catch (IOException e1) { //NOSONAR  Reason:dubbia classificazione severity (gia' cosi' in src struts2
				// we're already sending an error, not much else we can do if more stuff breaks
			}
		}
	}

	/**
	 * Cleanup any resources used to initialise Dispatcher
	 */
	public void cleanUpAfterInit() {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Cleaning up resources used to init Dispatcher");
		}
		ContainerHolder.clear();
	}

	/**
	 * Provide an accessor class for static XWork utility.
	 */
	public static class Locator {
		public Location getLocation(Object obj) {
			Location loc = LocationUtils.getLocation(obj);
			if (loc == null) {
				return Location.UNKNOWN;
			}
			return loc;
		}
	}

	/**
	 * Expose the ConfigurationManager instance.
	 *
	 * @return The instance
	 */
	public ConfigurationManager getConfigurationManager() {
		return configurationManager;
	}

	/**
	 * Modify the ConfigurationManager instance
	 *
	 * @param mgr The configuration manager
	 * @deprecated should be removed as is used only in tests
	 */
	public void setConfigurationManager(ConfigurationManager mgr) {
		ContainerHolder.clear();
		this.configurationManager = mgr;
	}

	/**
	 * Expose the dependency injection container.
	 * @return Our dependency injection container
	 */
	public Container getContainer() {
		if (ContainerHolder.get() != null) {
			return ContainerHolder.get();
		}
		ConfigurationManager mgr = getConfigurationManager();
		if (mgr == null) {
			throw new IllegalStateException("The configuration manager shouldn't be null");
		} else {
			Configuration config = mgr.getConfiguration();
			if (config == null) {
				throw new IllegalStateException("Unable to load configuration");
			} else {
				Container container = config.getContainer();
				ContainerHolder.store(container);
				return container;
			}
		}
	}

}
