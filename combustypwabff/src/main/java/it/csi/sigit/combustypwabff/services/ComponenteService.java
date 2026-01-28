package it.csi.sigit.combustypwabff.services;

import it.csi.sigit.combustypwabff.bff.dto.CodiceDescrizione;
import it.csi.sigit.combustypwabff.exceptions.CombustyPwaBffException;
import it.csi.sigit.combustypwabff.resources.SigitextResource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ComponenteService {

    @Inject
    SigitextResource sigitextResource;

    public List<CodiceDescrizione> getCombustibile() throws CombustyPwaBffException {

        return sigitextResource.getCombustibile();
    }

    public List<CodiceDescrizione> getUnitaMisura() throws CombustyPwaBffException {

        return sigitextResource.getUnitaMisura();
    }
}
