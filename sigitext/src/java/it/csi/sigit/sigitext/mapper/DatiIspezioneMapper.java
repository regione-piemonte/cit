package it.csi.sigit.sigitext.mapper;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDStatoIspezioneDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTIspezione2018Dto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTUnitaImmobiliareDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitVRicercaImpiantiDto;
import it.csi.sigit.sigitext.dto.sigitext.DatiIspezione;

public class DatiIspezioneMapper {
	
	private DatiIspezioneMapper() {
		
	}

	
	public static DatiIspezione getDatiIspezione(SigitTIspezione2018Dto sigitTIspezione2018Dto, SigitVRicercaImpiantiDto sigitVRicercaImpiantiDto, SigitTUnitaImmobiliareDto sigitTUnitaImmobiliareDtoOut,
			BigDecimal idIspezIspet, String cfUtente, String denomUtente, List<SigitDStatoIspezioneDto> listSigitDStatoIspezioneDto) {
		
		DatiIspezione datiIspezione = new DatiIspezione();
		
		if(sigitTIspezione2018Dto.getIdIspezione2018( )!= null) {
			datiIspezione.setIdIspezione2018(new BigDecimal(sigitTIspezione2018Dto.getIdIspezione2018()));
		}
		
		//datiIspezione.setFkStatoIspezione(sigitTIspezione2018Dto.getFkStatoIspezione());
		datiIspezione.setFkVerifica(sigitTIspezione2018Dto.getFkVerifica());
		datiIspezione.setFkAccertamento(sigitTIspezione2018Dto.getFkAccertamento());
		datiIspezione.setCodiceImpianto(sigitTIspezione2018Dto.getCodiceImpianto());
		datiIspezione.setCfIspettoreSecondario(sigitTIspezione2018Dto.getCfIspettoreSecondario());
		datiIspezione.setEnteCompetente(sigitTIspezione2018Dto.getEnteCompetente());
		datiIspezione.setFlgEsito(sigitTIspezione2018Dto.getFlgEsito());
		if(sigitTIspezione2018Dto.getDtSveglia( )!= null) {			
			datiIspezione.setDtSveglia(sigitTIspezione2018Dto.getDtSveglia().getTime());
		}
		datiIspezione.setNoteSveglia(sigitTIspezione2018Dto.getNoteSveglia());
		datiIspezione.setNote(sigitTIspezione2018Dto.getNote());
		if(sigitTIspezione2018Dto.getIstatComuneCompetenza()!=null && sigitTIspezione2018Dto.getIstatComuneCompetenza().length()>=3) {
			datiIspezione.setIstatProvCompetenza(sigitTIspezione2018Dto.getIstatComuneCompetenza().substring(0,3));
			datiIspezione.setIstatComuneCompetenza(sigitTIspezione2018Dto.getIstatComuneCompetenza());
		}
		datiIspezione.setFlgAccSostitutivo(sigitTIspezione2018Dto.getFlgAccSostitutivo());
		if(sigitTIspezione2018Dto.getDtCreazione( )!= null) {
			datiIspezione.setDtCreazione(sigitTIspezione2018Dto.getDtCreazione().getTime());
		}
		if(sigitTIspezione2018Dto.getDtConclusione( )!= null) {
			datiIspezione.setDtConclusione(sigitTIspezione2018Dto.getDtConclusione().getTime());
		}
		datiIspezione.setFlgIspPagamento(sigitTIspezione2018Dto.getFlgIspPagamento());		
		
		
		datiIspezione.setIndirizzoSitad(sigitTUnitaImmobiliareDtoOut.getIndirizzoSitad());
		datiIspezione.setIndirizzoNonTrovato(sigitTUnitaImmobiliareDtoOut.getIndirizzoNonTrovato());
		datiIspezione.setCivico(sigitTUnitaImmobiliareDtoOut.getCivico());
	    
	    
		datiIspezione.setIdIspezIspet(idIspezIspet);
		datiIspezione.setCfUtenteAssegn(cfUtente);
		datiIspezione.setDenomUtenteAssegn(denomUtente);
		
		for (SigitDStatoIspezioneDto sigitDStatoIspezioneDto : listSigitDStatoIspezioneDto) {
			if(sigitDStatoIspezioneDto.getIdStatoIspezione().equals(sigitTIspezione2018Dto.getFkStatoIspezione())){
				datiIspezione.setFkStatoIspezione(sigitDStatoIspezioneDto.getIdStatoIspezione());
				datiIspezione.setDesStatoIspezione(sigitDStatoIspezioneDto.getDesStatoIspezione());
			}
		}
					    
		if(sigitVRicercaImpiantiDto!=null) {
			datiIspezione.setDenominazioneComune(sigitVRicercaImpiantiDto.getDenominazioneComune());
			if(sigitVRicercaImpiantiDto.getIstatComune() != null && sigitVRicercaImpiantiDto.getIstatComune().length()>=3) {
				datiIspezione.setIstatProvCompetenza(sigitVRicercaImpiantiDto.getIstatComune().substring(0,3));
				datiIspezione.setIstatComuneCompetenza(sigitVRicercaImpiantiDto.getIstatComune());
			}
		}
		
		
		
		return datiIspezione;
	}	
	
	public static SigitTIspezione2018Dto getSigitTIspezione2018Dto(DatiIspezione datiIspezione) {
		SigitTIspezione2018Dto sigitTIspezione2018Dto = new SigitTIspezione2018Dto();
		if(datiIspezione.getIdIspezione2018( )!= null) {
			sigitTIspezione2018Dto.setIdIspezione2018(datiIspezione.getIdIspezione2018().intValue());
		}
		
		sigitTIspezione2018Dto.setFkStatoIspezione(datiIspezione.getFkStatoIspezione());
		sigitTIspezione2018Dto.setFkVerifica(datiIspezione.getFkVerifica());
		sigitTIspezione2018Dto.setFkAccertamento(datiIspezione.getFkAccertamento());
		sigitTIspezione2018Dto.setCodiceImpianto(datiIspezione.getCodiceImpianto());
		sigitTIspezione2018Dto.setCfIspettoreSecondario(datiIspezione.getCfIspettoreSecondario());
		sigitTIspezione2018Dto.setEnteCompetente(datiIspezione.getEnteCompetente());
		sigitTIspezione2018Dto.setFlgEsito(datiIspezione.getFlgEsito());
		if(datiIspezione.getDtSveglia( )!= null) {
			sigitTIspezione2018Dto.setDtSveglia(new Timestamp(datiIspezione.getDtSveglia()));
		}
		
		sigitTIspezione2018Dto.setNoteSveglia(datiIspezione.getNoteSveglia());
		sigitTIspezione2018Dto.setNote(datiIspezione.getNote());
		sigitTIspezione2018Dto.setIstatProvCompetenza(datiIspezione.getIstatComuneCompetenza());
		sigitTIspezione2018Dto.setFlgAccSostitutivo(datiIspezione.getFlgAccSostitutivo());
		if(datiIspezione.getDtCreazione( )!= null) {
			sigitTIspezione2018Dto.setDtCreazione(new Timestamp(datiIspezione.getDtCreazione()));
		}
		if(datiIspezione.getDtConclusione( )!= null) {
			sigitTIspezione2018Dto.setDtConclusione(new Timestamp(datiIspezione.getDtConclusione()));
		}
		
		sigitTIspezione2018Dto.setFlgIspPagamento(datiIspezione.getFlgIspPagamento());
		sigitTIspezione2018Dto.setIstatComuneCompetenza(datiIspezione.getIstatComuneCompetenza());
		
		return sigitTIspezione2018Dto;
	}


}
