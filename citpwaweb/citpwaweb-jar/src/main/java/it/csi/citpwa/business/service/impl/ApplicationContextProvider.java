package it.csi.citpwa.business.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import it.csi.citpwa.util.AppServletContextListener;
import it.csi.citpwa.util.Constants;

@Lazy(false)
@Component
public class ApplicationContextProvider implements ApplicationContextAware{

	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME);
	
	private static ApplicationContext context;
	
	public static synchronized ApplicationContext getContext() {
    	return context;
    }

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context = applicationContext;
		loadComuniEstesi();
	}
	
//	@Scheduled(cron = "0/30 * * ? * *")
	@Scheduled(cron = "0 0 2 ? * *")
	private void loadComuniEstesi() {
		log.info("AppServletContextListener::loadComuniEstesi():  Ricaricamento comuni estesi");
		if(context != null) {
			try {
				SvistaServiceImpl svistaServiceBean = (SvistaServiceImpl) context.getBean("svistaServiceImpl");
				AppServletContextListener.getSc().setAttribute("comuniEstesi", svistaServiceBean.cercaTuttiIComuniEstesi());
				log.info("Comuni estesi reloaded in Servlet Context at: " + java.time.LocalDateTime.now()); 
			}catch (Exception e) {
				log.error("[AppServletContextListener::contextInitialized] errore inizializzazione comuni estesi", e);
			}
		}
	}


}
