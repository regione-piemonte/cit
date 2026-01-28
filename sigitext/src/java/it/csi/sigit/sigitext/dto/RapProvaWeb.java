package it.csi.sigit.sigitext.dto;

import java.util.ArrayList;
import java.util.List;

import it.csi.sigit.sigitext.dto.sigitext.DatiBR;
import it.csi.sigit.sigitext.dto.sigitext.DatiGF;
import it.csi.sigit.sigitext.dto.sigitext.DatiGT;
import it.csi.sigit.sigitext.dto.sigitext.DatiRapProva;
import it.csi.sigit.sigitext.dto.sigitext.UtenteLoggato;

public class RapProvaWeb {

	private UtenteLoggato utenteLoggato;	
	private DatiRapProva datiRapProva;
	private DatiRapProvaWebGt datiRapProvaWebGt;
	private DatiRapProvaWebGf datiRapProvaWebGf;
	private List<DatiGT> listDatiGt;
	private List<DatiGF> listDatiGf;
	private List<DatiBR> listDatiBR;		
	private String docBase64;
	private String docName;

	
	public DatiRapProvaWebGf getDatiRapProvaWebGf() {
		return datiRapProvaWebGf;
	}

	public void setDatiRapProvaWebGf(DatiRapProvaWebGf datiRapProvaWebGf) {
		this.datiRapProvaWebGf = datiRapProvaWebGf;
	}

	public RapProvaWeb() {
		this.listDatiGt = new ArrayList<>();
		this.listDatiBR = new ArrayList<>();
		this.listDatiGf = new ArrayList<>();
	}
	
	public DatiRapProva getDatiRapProva() {
		return datiRapProva;
	}
	public void setDatiRapProva(DatiRapProva datiRapProva) {
		this.datiRapProva = datiRapProva;
	}
	public DatiRapProvaWebGt getDatiRapProvaWebGt() {
		return datiRapProvaWebGt;
	}
	public void setDatiRapProvaWebGt(DatiRapProvaWebGt datiRapProvaWebGt) {
		this.datiRapProvaWebGt = datiRapProvaWebGt;
	}		
	
	public List<DatiGT> getListDatiGt() {
		return listDatiGt;
	}

	public void setListDatiGt(List<DatiGT> listDatiGt) {
		this.listDatiGt = listDatiGt;
	}

	public List<DatiBR> getListDatiBR() {
		return listDatiBR;
	}

	public void setListDatiBR(List<DatiBR> listDatiBR) {
		this.listDatiBR = listDatiBR;
	}		

	public List<DatiGF> getListDatiGf() {
		return listDatiGf;
	}

	public void setListDatiGf(List<DatiGF> listDatiGf) {
		this.listDatiGf = listDatiGf;
	}

	public void addDatiGt(DatiGT datiGT) {
		this.listDatiGt.add(datiGT);
	}
	
	public void addDatiGf(DatiGF datiGf) {
		this.listDatiGf.add(datiGf);
	}
	
	public void addDatiBR(DatiBR datiBR) {
		this.listDatiBR.add(datiBR);
	}

	public UtenteLoggato getUtenteLoggato() {
		return utenteLoggato;
	}

	public void setUtenteLoggato(UtenteLoggato utenteLoggato) {
		this.utenteLoggato = utenteLoggato;
	}

	public String getDocBase64() {
		return docBase64;
	}

	public void setDocBase64(String docBase64) {
		this.docBase64 = docBase64;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}
	
	
}
