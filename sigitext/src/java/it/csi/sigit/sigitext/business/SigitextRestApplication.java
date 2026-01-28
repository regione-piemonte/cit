package it.csi.sigit.sigitext.business;

import it.csi.sigit.sigitext.business.be.impl.*;
import it.csi.sigit.sigitext.business.util.SpringSupportedResource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;


@ApplicationPath("restfacade/be")
public class SigitextRestApplication extends Application{
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> empty = new HashSet<Class<?>>();
	public SigitextRestApplication(){

		singletons.add(new SigitextApiServiceImpl());
		singletons.add(new ImpiantoApiServiceImpl());
		singletons.add(new LibrettoApiServiceImpl());
		singletons.add(new UserApiServiceImpl());
		singletons.add(new ComponentApiServiceImpl());
		singletons.add(new ControlloApiServiceImpl());
		singletons.add(new DocumentoApiServiceImpl());
		singletons.add(new AccreditamentoApiServiceImpl());
		singletons.add(new NominaTerzoResponsabileApiServiceImpl());
		singletons.add(new VerificheApiServiceImpl());
		singletons.add(new AzioneApiServiceImpl());
		singletons.add(new IspezioneApiServiceImpl());
		singletons.add(new RapProvaApiServiceImpl());
		singletons.add(new DistributoreApiServiceImpl());
		singletons.add(new SvistaApiServiceImpl());


		for (Object c : singletons) {
			if (c instanceof SpringSupportedResource) {
				SpringApplicationContextHelper.registerRestEasyController(c);
			}
		}
	}
	@Override
	public Set<Class<?>> getClasses() {
		return empty;
	}
	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}

