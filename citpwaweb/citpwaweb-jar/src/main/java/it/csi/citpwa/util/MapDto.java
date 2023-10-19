package it.csi.citpwa.util;

import it.csi.citpwa.model.ManutFormModel;
import it.csi.citpwa.model.enums.StelleEnum;
import it.csi.citpwa.model.sigitext.CodiceDescrizione;
import it.csi.citpwa.model.sigitext.UtenteLoggato;
import it.csi.citpwa.model.xml.ree.*;
import it.csi.citpwa.model.xsd.controllo1.*;
import it.csi.citpwa.model.xsd.controllo1B.MODIIB;
import it.csi.citpwa.model.xsd.controllo1B.RowAcquaReintegro;
import it.csi.citpwa.model.xsd.controllo1B.RowAllegatoIIB;
import it.csi.citpwa.model.xsd.controllo1B.RowCombustibile;
import it.csi.citpwa.model.xsd.controllo2.MODIII;
import it.csi.citpwa.model.xsd.controllo2.RowAllegatoIII;
import it.csi.citpwa.model.xsd.controllo3.MODIV;
import it.csi.citpwa.model.xsd.controllo3.RowAllegatoIV;
import it.csi.citpwa.model.xsd.controllo4.MODV;
import it.csi.citpwa.model.xsd.controllo4.RowAllegatoV;
import it.csi.citpwa.model.xsd.manutgt.DatiImpresa;
import it.csi.citpwa.model.xsd.manutgt.DatiManutenzione;
import it.csi.citpwa.model.xsd.manutgt.MANUTENZIONE;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.StringWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MapDto {
	public static MODII mod1reeModelToDto(MODModel ree) {
		MODII modii = new MODII();
		it.csi.citpwa.model.xsd.controllo1.Richiesta ric = new it.csi.citpwa.model.xsd.controllo1.Richiesta();
		it.csi.citpwa.model.xsd.controllo1.DatiAllegato datiAllegato = new it.csi.citpwa.model.xsd.controllo1.DatiAllegato();
		List<RowFumi> rowFumiList = new ArrayList<>();
		List<RowAllegatoII> rowAllegatoIIList = new ArrayList<>();

		for (RowAllegatoModel source : ree.getRichiesta().getDatiAllegato().getAllegato().getRowAllegato()) {
			it.csi.citpwa.model.xsd.controllo1.RowAllegatoII target = new it.csi.citpwa.model.xsd.controllo1.RowAllegatoII();
			target.setAENumGT(source.getNum());
			ControlloVerificaEnergetica controlloVerificaEnergetica = ControlloVerificaEnergeticaModel.tipo1ModelToDto.convert(source.getControlloVerificaEnergetica());
			target.setControlloVerificaEnergetica(controlloVerificaEnergetica);
			for (RowFumiModel source2 : source.getTabFumi().getRowFumi()) {
				RowFumi target2 = RowFumiModel.tipo1ModelToDto.convert(source2);
				rowFumiList.add(target2);
			}
			RowAllegatoII.TabFumi tabFumi = new RowAllegatoII.TabFumi();
			tabFumi.getRowFumi().addAll(rowFumiList);
			target.setTabFumi(tabFumi);
			rowAllegatoIIList.add(target);
		}
		DatiAllegato.AllegatoII allegatoII = new DatiAllegato.AllegatoII();
		allegatoII.getRowAllegatoII().addAll(rowAllegatoIIList);

		DatiManutentore datiManutentore = DatiManutentoreModel.tipo1ModelToDto.convert(ree.getRichiesta().getDatiManutentore());
		it.csi.citpwa.model.xsd.controllo1.DatiIntestazione datiIntestazione = DatiIntestazioneModel.tipo1ModelToDto.convert(ree.getRichiesta().getDatiIntestazione());
		it.csi.citpwa.model.xsd.controllo1.DatiTecnico datiTecnico = DatiTecnicoModel.tipo1ModelToDto.convert(ree.getRichiesta().getDatiAllegato().getDatiTecnico());
		it.csi.citpwa.model.xsd.controllo1.DatiIdentificativi datiIdentificativi = DatiIdentificativiModel.tipo1ModelToDto.convert(ree.getRichiesta().getDatiAllegato().getDatiIdentificativi());
		it.csi.citpwa.model.xsd.controllo1.DocumentazioneTecnica documentazioneTecnica = DocumentazioneTecnicaModel.tipo1ModelToDto.convert(ree.getRichiesta().getDatiAllegato()
				.getDocumentazioneTecnica());
		it.csi.citpwa.model.xsd.controllo1.TrattamentoAcqua trattamentoAcqua = TrattamentoAcquaModel.tipo1ModelToDto.convert(ree.getRichiesta().getDatiAllegato().getTrattamentoAcqua());
		it.csi.citpwa.model.xsd.controllo1.ControlloImpianto controlloImpianto = ControlloImpiantoModel.tipo1ModelToDto.convert(ree.getRichiesta().getDatiAllegato().getControlloImpianto());
		it.csi.citpwa.model.xsd.controllo1.CheckList checkList = CheckListModel.tipo1ModelToDto.convert(ree.getRichiesta().getDatiAllegato().getCheckList());

		ric.setDatiManutentore(datiManutentore);
		datiAllegato.setDatiIdentificativi(datiIdentificativi);
		datiAllegato.setDocumentazioneTecnica(documentazioneTecnica);
		datiAllegato.setTrattamentoAcqua(trattamentoAcqua);
		datiAllegato.setControlloImpianto(controlloImpianto);
		datiAllegato.setCheckList(checkList);
		datiAllegato.setDatiTecnico(datiTecnico);
		datiAllegato.setAllegatoII(allegatoII);
		ric.setDatiAllegato(datiAllegato);
		ric.setDatiIntestazione(datiIntestazione);
		modii.setRichiesta(ric);

		return modii;
	}

	public static MODModel mod1reeDtoToModel(MODII ree) {
		MODModel modii = new MODModel();
		RichiestaModel ric = new RichiestaModel();
		DatiAllegatoModel datiAllegato = new DatiAllegatoModel();
		List<RowFumiModel> rowFumiList = new ArrayList<>();
		List<RowAllegatoModel> rowAllegatoIIList = new ArrayList<>();

		for (RowAllegatoII source : ree.getRichiesta().getDatiAllegato().getAllegatoII().getRowAllegatoII()) {
			RowAllegatoModel target = new RowAllegatoModel();
			target.setNum(source.getAENumGT());
			ControlloVerificaEnergeticaModel controlloVerificaEnergetica = ControlloVerificaEnergeticaModel.tipo1DtoToModel.convert(source.getControlloVerificaEnergetica());
			target.setControlloVerificaEnergetica(controlloVerificaEnergetica);
			for (RowFumi source2 : source.getTabFumi().getRowFumi()) {
				RowFumiModel target2 = RowFumiModel.tipo1DtoToModel.convert(source2);
				rowFumiList.add(target2);
			}
			TabFumiModel tabFumi = new TabFumiModel();
			tabFumi.getRowFumi().addAll(rowFumiList);
			target.setTabFumi(tabFumi);
			rowAllegatoIIList.add(target);
		}
		AllegatoModel allegatoII = new AllegatoModel();
		allegatoII.getRowAllegato().addAll(rowAllegatoIIList);

		DatiManutentoreModel datiManutentore = DatiManutentoreModel.tipo1DtoToModel.convert(ree.getRichiesta().getDatiManutentore());
		DatiIntestazioneModel datiIntestazione = DatiIntestazioneModel.tipo1DtoToModel.convert(ree.getRichiesta().getDatiIntestazione());
		DatiTecnicoModel datiTecnico = DatiTecnicoModel.tipo1DtoToModel.convert(ree.getRichiesta().getDatiAllegato().getDatiTecnico());
		DatiIdentificativiModel datiIdentificativi = DatiIdentificativiModel.tipo1DtoToModel.convert(ree.getRichiesta().getDatiAllegato().getDatiIdentificativi());
		DocumentazioneTecnicaModel documentazioneTecnica = DocumentazioneTecnicaModel.tipo1DtoToModel.convert(ree.getRichiesta().getDatiAllegato().getDocumentazioneTecnica());
		TrattamentoAcquaModel trattamentoAcqua = TrattamentoAcquaModel.tipo1DtoToModel.convert(ree.getRichiesta().getDatiAllegato().getTrattamentoAcqua());
		ControlloImpiantoModel controlloImpianto = ControlloImpiantoModel.tipo1DtoToModel.convert(ree.getRichiesta().getDatiAllegato().getControlloImpianto());
		CheckListModel checkList = CheckListModel.tipo1DtoToModel.convert(ree.getRichiesta().getDatiAllegato().getCheckList());

		ric.setDatiManutentore(datiManutentore);
		datiAllegato.setDatiIdentificativi(datiIdentificativi);
		datiAllegato.setDocumentazioneTecnica(documentazioneTecnica);
		datiAllegato.setTrattamentoAcqua(trattamentoAcqua);
		datiAllegato.setControlloImpianto(controlloImpianto);
		datiAllegato.setCheckList(checkList);
		datiAllegato.setDatiTecnico(datiTecnico);
		datiAllegato.setAllegato(allegatoII);
		ric.setDatiAllegato(datiAllegato);
		ric.setDatiIntestazione(datiIntestazione);
		modii.setRichiesta(ric);
		return modii;
	}

	public static MODIIB mod1BreeModelToDto(MODModel ree) {
		MODIIB modii = new MODIIB();
		it.csi.citpwa.model.xsd.controllo1B.DatiAllegato.AllegatoIIB allegatoII = new it.csi.citpwa.model.xsd.controllo1B.DatiAllegato.AllegatoIIB();
		it.csi.citpwa.model.xsd.controllo1B.Richiesta ric = new it.csi.citpwa.model.xsd.controllo1B.Richiesta();
		it.csi.citpwa.model.xsd.controllo1B.DatiAllegato datiAllegato = new it.csi.citpwa.model.xsd.controllo1B.DatiAllegato();

		for (RowAllegatoModel source : ree.getRichiesta().getDatiAllegato().getAllegato().getRowAllegato()) {
			RowAllegatoIIB.TabFumi tabFumi = new RowAllegatoIIB.TabFumi();
			RowAllegatoIIB.TabCombustibile tabCombustibile = new RowAllegatoIIB.TabCombustibile();
			it.csi.citpwa.model.xsd.controllo1B.RowAllegatoIIB target = new it.csi.citpwa.model.xsd.controllo1B.RowAllegatoIIB();
			target.setAENumGT(source.getNum());
			it.csi.citpwa.model.xsd.controllo1B.ControlloVerificaEnergetica controlloVerificaEnergetica = ControlloVerificaEnergeticaModel.tipo1BModelToDto.convert(source.getControlloVerificaEnergetica());
			target.setControlloVerificaEnergetica(controlloVerificaEnergetica);
			System.out.println(target.getControlloVerificaEnergetica());
			for (RowFumiModel source2 : source.getTabFumi().getRowFumi()) {
				it.csi.citpwa.model.xsd.controllo1B.RowFumi target2 = RowFumiModel.tipo1BModelToDto.convert(source2);
				tabFumi.getRowFumi().add(target2);
			}
			if (source.getTabCombustibile() != null) {
				for (RowCombustibileModel rowCombustibile : source.getTabCombustibile().getRowCombustibile()) {
					tabCombustibile.getRowCombustibile().add(RowCombustibileModel.tipo1BModelToDto.convert(rowCombustibile));
				}
				target.setTabCombustibile(tabCombustibile);
			}
			target.setTabFumi(tabFumi);
			allegatoII.getRowAllegatoIIB().add(target);
		}
		it.csi.citpwa.model.xsd.controllo1B.DatiManutentore datiManutentore = DatiManutentoreModel.tipo1BModelToDto.convert(ree.getRichiesta().getDatiManutentore());
		it.csi.citpwa.model.xsd.controllo1B.DatiIntestazione datiIntestazione = DatiIntestazioneModel.tipo1BModelToDto.convert(ree.getRichiesta().getDatiIntestazione());
		it.csi.citpwa.model.xsd.controllo1B.DatiTecnico datiTecnico = DatiTecnicoModel.tipo1BModelToDto.convert(ree.getRichiesta().getDatiAllegato().getDatiTecnico());
		it.csi.citpwa.model.xsd.controllo1B.DatiIdentificativi datiIdentificativi = DatiIdentificativiModel.tipo1BModelToDto.convert(ree.getRichiesta().getDatiAllegato().getDatiIdentificativi());
		it.csi.citpwa.model.xsd.controllo1B.DocumentazioneTecnica documentazioneTecnica = DocumentazioneTecnicaModel.tipo1BModelToDto.convert(ree.getRichiesta().getDatiAllegato()
				.getDocumentazioneTecnica());
		it.csi.citpwa.model.xsd.controllo1B.TrattamentoAcqua trattamentoAcqua = TrattamentoAcquaModel.tipo1BModelToDto.convert(ree.getRichiesta().getDatiAllegato().getTrattamentoAcqua());
		it.csi.citpwa.model.xsd.controllo1B.TrattamentoAcqua.ACAcquaReintegro acAcquaReintegro = new it.csi.citpwa.model.xsd.controllo1B.TrattamentoAcqua.ACAcquaReintegro();
		if (ree.getRichiesta().getDatiAllegato().getTrattamentoAcqua().getTabAcquaReintegro() != null) {
			for (RowAcquaReintegroModel rowAcquaReintegroModel : ree.getRichiesta().getDatiAllegato().getTrattamentoAcqua().getTabAcquaReintegro().getRowAcquaReintegro()) {
				acAcquaReintegro.getRowAcquaReintegro().add(RowAcquaReintegroModel.tipo1BModelToDto.convert(rowAcquaReintegroModel));
			}
			trattamentoAcqua.setACAcquaReintegro(acAcquaReintegro);
		}
		it.csi.citpwa.model.xsd.controllo1B.ControlloImpianto controlloImpianto = ControlloImpiantoModel.tipo1BModelToDto.convert(ree.getRichiesta().getDatiAllegato().getControlloImpianto());
		it.csi.citpwa.model.xsd.controllo1B.CheckList checkList = CheckListModel.tipo1BModelToDto.convert(ree.getRichiesta().getDatiAllegato().getCheckList());

		ric.setDatiManutentore(datiManutentore);
		datiAllegato.setDatiIdentificativi(datiIdentificativi);
		datiAllegato.setDocumentazioneTecnica(documentazioneTecnica);
		datiAllegato.setTrattamentoAcqua(trattamentoAcqua);
		datiAllegato.setControlloImpianto(controlloImpianto);
		datiAllegato.setCheckList(checkList);
		datiAllegato.setDatiTecnico(datiTecnico);
		datiAllegato.setAllegatoIIB(allegatoII);
		ric.setDatiAllegato(datiAllegato);
		ric.setDatiIntestazione(datiIntestazione);
		modii.setRichiesta(ric);

		return modii;
	}

	public static MODModel mod1BreeDtoToModel(MODIIB ree) {
		MODModel modModel = new MODModel();
		AllegatoModel allegatoModel = new AllegatoModel();
		RichiestaModel ric = new RichiestaModel();
		DatiAllegatoModel datiAllegato = new DatiAllegatoModel();

		for (RowAllegatoIIB source : ree.getRichiesta().getDatiAllegato().getAllegatoIIB().getRowAllegatoIIB()) {
			TabFumiModel tabFumi = new TabFumiModel();
			TabCombustibileModel tabCombustibile = new TabCombustibileModel();
			RowAllegatoModel target = new RowAllegatoModel();
			target.setNum(source.getAENumGT());
			ControlloVerificaEnergeticaModel controlloVerificaEnergetica = ControlloVerificaEnergeticaModel.tipo1BDtoToModel.convert(source.getControlloVerificaEnergetica());
			target.setControlloVerificaEnergetica(controlloVerificaEnergetica);
			for (it.csi.citpwa.model.xsd.controllo1B.RowFumi source2 : source.getTabFumi().getRowFumi()) {
				RowFumiModel target2 = RowFumiModel.tipo1BDtoToModel.convert(source2);
				tabFumi.getRowFumi().add(target2);
			}
			if (source.getTabCombustibile() != null) {
				for (RowCombustibile rowCombustibile : source.getTabCombustibile().getRowCombustibile()) {
					tabCombustibile.getRowCombustibile().add(RowCombustibileModel.tipo1BDtoToModel.convert(rowCombustibile));
				}
				target.setTabCombustibile(tabCombustibile);
			}
			target.setTabFumi(tabFumi);
			allegatoModel.getRowAllegato().add(target);
		}
		DatiManutentoreModel datiManutentore = DatiManutentoreModel.tipo1BDtoToModel.convert(ree.getRichiesta().getDatiManutentore());
		DatiIntestazioneModel datiIntestazione = DatiIntestazioneModel.tipo1BDtoToModel.convert(ree.getRichiesta().getDatiIntestazione());
		DatiTecnicoModel datiTecnico = DatiTecnicoModel.tipo1BDtoToModel.convert(ree.getRichiesta().getDatiAllegato().getDatiTecnico());
		DatiIdentificativiModel datiIdentificativi = DatiIdentificativiModel.tipo1BDtoToModel.convert(ree.getRichiesta().getDatiAllegato().getDatiIdentificativi());
		DocumentazioneTecnicaModel documentazioneTecnica = DocumentazioneTecnicaModel.tipo1BDtoToModel.convert(ree.getRichiesta().getDatiAllegato().getDocumentazioneTecnica());
		TrattamentoAcquaModel trattamentoAcqua = TrattamentoAcquaModel.tipo1BDtoToModel.convert(ree.getRichiesta().getDatiAllegato().getTrattamentoAcqua());
		TabAcquaReintegroModel tabAcquaReintegroModel = new TabAcquaReintegroModel();
		if (ree.getRichiesta().getDatiAllegato().getTrattamentoAcqua().getACAcquaReintegro() != null) {
			for (RowAcquaReintegro rowAcquaReintegro : ree.getRichiesta().getDatiAllegato().getTrattamentoAcqua().getACAcquaReintegro().getRowAcquaReintegro()) {
				tabAcquaReintegroModel.getRowAcquaReintegro().add(RowAcquaReintegroModel.tipo1BDtoToModel.convert(rowAcquaReintegro));
			}
			trattamentoAcqua.setTabAcquaReintegro(tabAcquaReintegroModel);
		}
		ControlloImpiantoModel controlloImpianto = ControlloImpiantoModel.tipo1BDtoToModel.convert(ree.getRichiesta().getDatiAllegato().getControlloImpianto());
		CheckListModel checkList = CheckListModel.tipo1BDtoToModel.convert(ree.getRichiesta().getDatiAllegato().getCheckList());

		ric.setDatiManutentore(datiManutentore);
		datiAllegato.setDatiIdentificativi(datiIdentificativi);
		datiAllegato.setDocumentazioneTecnica(documentazioneTecnica);
		datiAllegato.setTrattamentoAcqua(trattamentoAcqua);
		datiAllegato.setControlloImpianto(controlloImpianto);
		datiAllegato.setCheckList(checkList);
		datiAllegato.setDatiTecnico(datiTecnico);
		datiAllegato.setAllegato(allegatoModel);
		ric.setDatiAllegato(datiAllegato);
		ric.setDatiIntestazione(datiIntestazione);
		modModel.setRichiesta(ric);

		return modModel;
	}

	public static MODIII mod2reeModelToDto(MODModel ree) {
		System.out.println(ree);
		MODIII modiii = new MODIII();
		it.csi.citpwa.model.xsd.controllo2.Richiesta ric = new it.csi.citpwa.model.xsd.controllo2.Richiesta();
		it.csi.citpwa.model.xsd.controllo2.DatiAllegato datiAllegato = new it.csi.citpwa.model.xsd.controllo2.DatiAllegato();
		List<it.csi.citpwa.model.xsd.controllo2.RowFumi> rowFumiList = new ArrayList<>();
		List<RowAllegatoIII> rowAllegatoIIList = new ArrayList<>();

		for (RowAllegatoModel source : ree.getRichiesta().getDatiAllegato().getAllegato().getRowAllegato()) {
			it.csi.citpwa.model.xsd.controllo2.RowAllegatoIII target = new it.csi.citpwa.model.xsd.controllo2.RowAllegatoIII();
			target.setAENumGF(source.getNum());
			it.csi.citpwa.model.xsd.controllo2.ControlloVerificaEnergetica controlloVerificaEnergetica = ControlloVerificaEnergeticaModel.tipo2ModelToDto.convert(source.getControlloVerificaEnergetica());
			target.setControlloVerificaEnergetica(controlloVerificaEnergetica);
			for (RowFumiModel source2 : source.getTabFumi().getRowFumi()) {
				it.csi.citpwa.model.xsd.controllo2.RowFumi target2 = RowFumiModel.tipo2ModelToDto.convert(source2);
				rowFumiList.add(target2);
			}
			RowAllegatoIII.TabFumi tabFumi = new RowAllegatoIII.TabFumi();
			tabFumi.getRowFumi().addAll(rowFumiList);
			target.setTabFumi(tabFumi);
			rowAllegatoIIList.add(target);
		}
		it.csi.citpwa.model.xsd.controllo2.DatiAllegato.AllegatoIII allegatoIII = new it.csi.citpwa.model.xsd.controllo2.DatiAllegato.AllegatoIII();
		allegatoIII.getRowAllegatoIII().addAll(rowAllegatoIIList);

		it.csi.citpwa.model.xsd.controllo2.DatiManutentore datiManutentore = DatiManutentoreModel.tipo2ModelToDto.convert(ree.getRichiesta().getDatiManutentore());
		it.csi.citpwa.model.xsd.controllo2.DatiIntestazione datiIntestazione = DatiIntestazioneModel.tipo2ModelToDto.convert(ree.getRichiesta().getDatiIntestazione());
		it.csi.citpwa.model.xsd.controllo2.DatiTecnico datiTecnico = DatiTecnicoModel.tipo2ModelToDto.convert(ree.getRichiesta().getDatiAllegato().getDatiTecnico());
		it.csi.citpwa.model.xsd.controllo2.DatiIdentificativi datiIdentificativi = DatiIdentificativiModel.tipo2ModelToDto.convert(ree.getRichiesta().getDatiAllegato().getDatiIdentificativi());
		it.csi.citpwa.model.xsd.controllo2.DocumentazioneTecnica documentazioneTecnica = DocumentazioneTecnicaModel.tipo2ModelToDto.convert(ree.getRichiesta().getDatiAllegato()
				.getDocumentazioneTecnica());
		it.csi.citpwa.model.xsd.controllo2.TrattamentoAcqua trattamentoAcqua = TrattamentoAcquaModel.tipo2ModelToDto.convert(ree.getRichiesta().getDatiAllegato().getTrattamentoAcqua());
		it.csi.citpwa.model.xsd.controllo2.ControlloImpianto controlloImpianto = ControlloImpiantoModel.tipo2ModelToDto.convert(ree.getRichiesta().getDatiAllegato().getControlloImpianto());
		it.csi.citpwa.model.xsd.controllo2.CheckList checkList = CheckListModel.tipo2ModelToDto.convert(ree.getRichiesta().getDatiAllegato().getCheckList());

		ric.setDatiManutentore(datiManutentore);
		datiAllegato.setDatiIdentificativi(datiIdentificativi);
		datiAllegato.setDocumentazioneTecnica(documentazioneTecnica);
		datiAllegato.setTrattamentoAcqua(trattamentoAcqua);
		datiAllegato.setControlloImpianto(controlloImpianto);
		datiAllegato.setCheckList(checkList);
		datiAllegato.setDatiTecnico(datiTecnico);
		datiAllegato.setAllegatoIII(allegatoIII);
		ric.setDatiAllegato(datiAllegato);
		ric.setDatiIntestazione(datiIntestazione);
		modiii.setRichiesta(ric);

		return modiii;
	}

	public static MODModel mod2reeDtoToModel(MODIII ree) {
		MODModel modModel = new MODModel();
		AllegatoModel allegatoModel = new AllegatoModel();
		RichiestaModel ric = new RichiestaModel();
		DatiAllegatoModel datiAllegato = new DatiAllegatoModel();

		for (RowAllegatoIII source : ree.getRichiesta().getDatiAllegato().getAllegatoIII().getRowAllegatoIII()) {
			TabFumiModel tabFumi = new TabFumiModel();
			RowAllegatoModel target = new RowAllegatoModel();
			target.setNum(source.getAENumGF());
			ControlloVerificaEnergeticaModel controlloVerificaEnergetica = ControlloVerificaEnergeticaModel.tipo2DtoToModel.convert(source.getControlloVerificaEnergetica());
			target.setControlloVerificaEnergetica(controlloVerificaEnergetica);
			for (it.csi.citpwa.model.xsd.controllo2.RowFumi source2 : source.getTabFumi().getRowFumi()) {
				RowFumiModel target2 = RowFumiModel.tipo2DtoToModel.convert(source2);
				tabFumi.getRowFumi().add(target2);
			}
			target.setTabFumi(tabFumi);
			allegatoModel.getRowAllegato().add(target);
		}
		DatiManutentoreModel datiManutentore = DatiManutentoreModel.tipo2DtoToModel.convert(ree.getRichiesta().getDatiManutentore());
		DatiIntestazioneModel datiIntestazione = DatiIntestazioneModel.tipo2DtoToModel.convert(ree.getRichiesta().getDatiIntestazione());
		DatiTecnicoModel datiTecnico = DatiTecnicoModel.tipo2DtoToModel.convert(ree.getRichiesta().getDatiAllegato().getDatiTecnico());
		DatiIdentificativiModel datiIdentificativi = DatiIdentificativiModel.tipo2DtoToModel.convert(ree.getRichiesta().getDatiAllegato().getDatiIdentificativi());
		DocumentazioneTecnicaModel documentazioneTecnica = DocumentazioneTecnicaModel.tipo2DtoToModel.convert(ree.getRichiesta().getDatiAllegato().getDocumentazioneTecnica());
		TrattamentoAcquaModel trattamentoAcqua = TrattamentoAcquaModel.tipo2DtoToModel.convert(ree.getRichiesta().getDatiAllegato().getTrattamentoAcqua());
		ControlloImpiantoModel controlloImpianto = ControlloImpiantoModel.tipo2DtoToModel.convert(ree.getRichiesta().getDatiAllegato().getControlloImpianto());
		CheckListModel checkList = CheckListModel.tipo2DtoToModel.convert(ree.getRichiesta().getDatiAllegato().getCheckList());

		ric.setDatiManutentore(datiManutentore);
		datiAllegato.setDatiIdentificativi(datiIdentificativi);
		datiAllegato.setDocumentazioneTecnica(documentazioneTecnica);
		datiAllegato.setTrattamentoAcqua(trattamentoAcqua);
		datiAllegato.setControlloImpianto(controlloImpianto);
		datiAllegato.setCheckList(checkList);
		datiAllegato.setDatiTecnico(datiTecnico);
		datiAllegato.setAllegato(allegatoModel);
		ric.setDatiAllegato(datiAllegato);
		ric.setDatiIntestazione(datiIntestazione);
		modModel.setRichiesta(ric);

		return modModel;
	}

	public static MODIV mod3reeModelToDto(MODModel ree) {
		System.out.println(ree);
		MODIV modiii = new MODIV();
		it.csi.citpwa.model.xsd.controllo3.Richiesta ric = new it.csi.citpwa.model.xsd.controllo3.Richiesta();
		it.csi.citpwa.model.xsd.controllo3.DatiAllegato datiAllegato = new it.csi.citpwa.model.xsd.controllo3.DatiAllegato();
		it.csi.citpwa.model.xsd.controllo3.RowFumi rowFumi = new it.csi.citpwa.model.xsd.controllo3.RowFumi();
		List<RowAllegatoIV> rowAllegatoIIList = new ArrayList<>();

		for (RowAllegatoModel source : ree.getRichiesta().getDatiAllegato().getAllegato().getRowAllegato()) {
			it.csi.citpwa.model.xsd.controllo3.RowAllegatoIV target = new it.csi.citpwa.model.xsd.controllo3.RowAllegatoIV();
			target.setAENumSC(source.getNum());
			it.csi.citpwa.model.xsd.controllo3.ControlloVerificaEnergetica controlloVerificaEnergetica = ControlloVerificaEnergeticaModel.tipo3ModelToDto.convert(source.getControlloVerificaEnergetica());
			target.setControlloVerificaEnergetica(controlloVerificaEnergetica);
			for (RowFumiModel source3 : source.getTabFumi().getRowFumi()) {
				rowFumi = RowFumiModel.tipo3ModelToDto.convert(source3);
			}
			RowAllegatoIV.TabFumi tabFumi = new RowAllegatoIV.TabFumi();
			tabFumi.setRowFumi(rowFumi);
			target.setTabFumi(tabFumi);
			rowAllegatoIIList.add(target);
		}
		it.csi.citpwa.model.xsd.controllo3.DatiAllegato.AllegatoIV allegatoIII = new it.csi.citpwa.model.xsd.controllo3.DatiAllegato.AllegatoIV();
		allegatoIII.getRowAllegatoIV().addAll(rowAllegatoIIList);

		it.csi.citpwa.model.xsd.controllo3.DatiManutentore datiManutentore = DatiManutentoreModel.tipo3ModelToDto.convert(ree.getRichiesta().getDatiManutentore());
		it.csi.citpwa.model.xsd.controllo3.DatiIntestazione datiIntestazione = DatiIntestazioneModel.tipo3ModelToDto.convert(ree.getRichiesta().getDatiIntestazione());
		it.csi.citpwa.model.xsd.controllo3.DatiTecnico datiTecnico = DatiTecnicoModel.tipo3ModelToDto.convert(ree.getRichiesta().getDatiAllegato().getDatiTecnico());
		it.csi.citpwa.model.xsd.controllo3.DatiIdentificativi datiIdentificativi = DatiIdentificativiModel.tipo3ModelToDto.convert(ree.getRichiesta().getDatiAllegato().getDatiIdentificativi());
		it.csi.citpwa.model.xsd.controllo3.DocumentazioneTecnica documentazioneTecnica = DocumentazioneTecnicaModel.tipo3ModelToDto.convert(ree.getRichiesta().getDatiAllegato()
				.getDocumentazioneTecnica());
		it.csi.citpwa.model.xsd.controllo3.TrattamentoAcqua trattamentoAcqua = TrattamentoAcquaModel.tipo3ModelToDto.convert(ree.getRichiesta().getDatiAllegato().getTrattamentoAcqua());
		it.csi.citpwa.model.xsd.controllo3.ControlloImpianto controlloImpianto = ControlloImpiantoModel.tipo3ModelToDto.convert(ree.getRichiesta().getDatiAllegato().getControlloImpianto());
		it.csi.citpwa.model.xsd.controllo3.CheckList checkList = CheckListModel.tipo3ModelToDto.convert(ree.getRichiesta().getDatiAllegato().getCheckList());

		ric.setDatiManutentore(datiManutentore);
		datiAllegato.setDatiIdentificativi(datiIdentificativi);
		datiAllegato.setDocumentazioneTecnica(documentazioneTecnica);
		datiAllegato.setTrattamentoAcqua(trattamentoAcqua);
		datiAllegato.setControlloImpianto(controlloImpianto);
		datiAllegato.setCheckList(checkList);
		datiAllegato.setDatiTecnico(datiTecnico);
		datiAllegato.setAllegatoIV(allegatoIII);
		ric.setDatiAllegato(datiAllegato);
		ric.setDatiIntestazione(datiIntestazione);
		modiii.setRichiesta(ric);

		return modiii;
	}

	public static MODModel mod3reeDtoToModel(MODIV ree) {
		MODModel modModel = new MODModel();
		AllegatoModel allegatoModel = new AllegatoModel();
		RichiestaModel ric = new RichiestaModel();
		DatiAllegatoModel datiAllegato = new DatiAllegatoModel();

		for (RowAllegatoIV source : ree.getRichiesta().getDatiAllegato().getAllegatoIV().getRowAllegatoIV()) {
			TabFumiModel tabFumi = new TabFumiModel();
			TabCombustibileModel tabCombustibile = new TabCombustibileModel();
			RowAllegatoModel target = new RowAllegatoModel();
			target.setNum(source.getAENumSC());
			ControlloVerificaEnergeticaModel controlloVerificaEnergetica = ControlloVerificaEnergeticaModel.tipo3DtoToModel.convert(source.getControlloVerificaEnergetica());
			target.setControlloVerificaEnergetica(controlloVerificaEnergetica);
			RowFumiModel target3 = RowFumiModel.tipo3DtoToModel.convert(source.getTabFumi().getRowFumi());
			tabFumi.getRowFumi().add(target3);
			target.setTabFumi(tabFumi);
			allegatoModel.getRowAllegato().add(target);
		}
		DatiManutentoreModel datiManutentore = DatiManutentoreModel.tipo3DtoToModel.convert(ree.getRichiesta().getDatiManutentore());
		DatiIntestazioneModel datiIntestazione = DatiIntestazioneModel.tipo3DtoToModel.convert(ree.getRichiesta().getDatiIntestazione());
		DatiTecnicoModel datiTecnico = DatiTecnicoModel.tipo3DtoToModel.convert(ree.getRichiesta().getDatiAllegato().getDatiTecnico());
		DatiIdentificativiModel datiIdentificativi = DatiIdentificativiModel.tipo3DtoToModel.convert(ree.getRichiesta().getDatiAllegato().getDatiIdentificativi());
		DocumentazioneTecnicaModel documentazioneTecnica = DocumentazioneTecnicaModel.tipo3DtoToModel.convert(ree.getRichiesta().getDatiAllegato().getDocumentazioneTecnica());
		TrattamentoAcquaModel trattamentoAcqua = TrattamentoAcquaModel.tipo3DtoToModel.convert(ree.getRichiesta().getDatiAllegato().getTrattamentoAcqua());
		ControlloImpiantoModel controlloImpianto = ControlloImpiantoModel.tipo3DtoToModel.convert(ree.getRichiesta().getDatiAllegato().getControlloImpianto());
		CheckListModel checkList = CheckListModel.tipo3DtoToModel.convert(ree.getRichiesta().getDatiAllegato().getCheckList());

		ric.setDatiManutentore(datiManutentore);
		datiAllegato.setDatiIdentificativi(datiIdentificativi);
		datiAllegato.setDocumentazioneTecnica(documentazioneTecnica);
		datiAllegato.setTrattamentoAcqua(trattamentoAcqua);
		datiAllegato.setControlloImpianto(controlloImpianto);
		datiAllegato.setCheckList(checkList);
		datiAllegato.setDatiTecnico(datiTecnico);
		datiAllegato.setAllegato(allegatoModel);
		ric.setDatiAllegato(datiAllegato);
		ric.setDatiIntestazione(datiIntestazione);
		modModel.setRichiesta(ric);

		return modModel;
	}

	public static MODV mod4reeModelToDto(MODModel ree) {
		System.out.println(ree);
		MODV modiii = new MODV();
		it.csi.citpwa.model.xsd.controllo4.Richiesta ric = new it.csi.citpwa.model.xsd.controllo4.Richiesta();
		it.csi.citpwa.model.xsd.controllo4.DatiAllegato datiAllegato = new it.csi.citpwa.model.xsd.controllo4.DatiAllegato();
		it.csi.citpwa.model.xsd.controllo4.RowFumi rowFumi = new it.csi.citpwa.model.xsd.controllo4.RowFumi();
		List<RowAllegatoV> rowAllegatoIIList = new ArrayList<>();

		for (RowAllegatoModel source : ree.getRichiesta().getDatiAllegato().getAllegato().getRowAllegato()) {
			it.csi.citpwa.model.xsd.controllo4.RowAllegatoV target = new it.csi.citpwa.model.xsd.controllo4.RowAllegatoV();
			target.setAENumCG(source.getNum());
			it.csi.citpwa.model.xsd.controllo4.ControlloVerificaEnergetica controlloVerificaEnergetica = ControlloVerificaEnergeticaModel.tipo4ModelToDto.convert(source.getControlloVerificaEnergetica());
			target.setControlloVerificaEnergetica(controlloVerificaEnergetica);
			for (RowFumiModel source4 : source.getTabFumi().getRowFumi()) {
				rowFumi = RowFumiModel.tipo4ModelToDto.convert(source4);
			}
			RowAllegatoV.TabFumi tabFumi = new RowAllegatoV.TabFumi();
			tabFumi.setRowFumi(rowFumi);
			target.setTabFumi(tabFumi);
			rowAllegatoIIList.add(target);
		}
		it.csi.citpwa.model.xsd.controllo4.DatiAllegato.AllegatoV allegatoIII = new it.csi.citpwa.model.xsd.controllo4.DatiAllegato.AllegatoV();
		allegatoIII.getRowAllegatoV().addAll(rowAllegatoIIList);

		it.csi.citpwa.model.xsd.controllo4.DatiManutentore datiManutentore = DatiManutentoreModel.tipo4ModelToDto.convert(ree.getRichiesta().getDatiManutentore());
		it.csi.citpwa.model.xsd.controllo4.DatiIntestazione datiIntestazione = DatiIntestazioneModel.tipo4ModelToDto.convert(ree.getRichiesta().getDatiIntestazione());
		it.csi.citpwa.model.xsd.controllo4.DatiTecnico datiTecnico = DatiTecnicoModel.tipo4ModelToDto.convert(ree.getRichiesta().getDatiAllegato().getDatiTecnico());
		it.csi.citpwa.model.xsd.controllo4.DatiIdentificativi datiIdentificativi = DatiIdentificativiModel.tipo4ModelToDto.convert(ree.getRichiesta().getDatiAllegato().getDatiIdentificativi());
		it.csi.citpwa.model.xsd.controllo4.DocumentazioneTecnica documentazioneTecnica = DocumentazioneTecnicaModel.tipo4ModelToDto.convert(ree.getRichiesta().getDatiAllegato()
				.getDocumentazioneTecnica());
		it.csi.citpwa.model.xsd.controllo4.TrattamentoAcqua trattamentoAcqua = TrattamentoAcquaModel.tipo4ModelToDto.convert(ree.getRichiesta().getDatiAllegato().getTrattamentoAcqua());
		it.csi.citpwa.model.xsd.controllo4.ControlloImpianto controlloImpianto = ControlloImpiantoModel.tipo4ModelToDto.convert(ree.getRichiesta().getDatiAllegato().getControlloImpianto());
		it.csi.citpwa.model.xsd.controllo4.CheckList checkList = CheckListModel.tipo4ModelToDto.convert(ree.getRichiesta().getDatiAllegato().getCheckList());

		ric.setDatiManutentore(datiManutentore);
		datiAllegato.setDatiIdentificativi(datiIdentificativi);
		datiAllegato.setDocumentazioneTecnica(documentazioneTecnica);
		datiAllegato.setTrattamentoAcqua(trattamentoAcqua);
		datiAllegato.setControlloImpianto(controlloImpianto);
		datiAllegato.setCheckList(checkList);
		datiAllegato.setDatiTecnico(datiTecnico);
		datiAllegato.setAllegatoV(allegatoIII);
		ric.setDatiAllegato(datiAllegato);
		ric.setDatiIntestazione(datiIntestazione);
		modiii.setRichiesta(ric);

		return modiii;
	}

	public static MODModel mod4reeDtoToModel(MODV ree) {
		MODModel modModel = new MODModel();
		AllegatoModel allegatoModel = new AllegatoModel();
		RichiestaModel ric = new RichiestaModel();
		DatiAllegatoModel datiAllegato = new DatiAllegatoModel();

		for (RowAllegatoV source : ree.getRichiesta().getDatiAllegato().getAllegatoV().getRowAllegatoV()) {
			TabFumiModel tabFumi = new TabFumiModel();
			RowAllegatoModel target = new RowAllegatoModel();
			target.setNum(source.getAENumCG());
			ControlloVerificaEnergeticaModel controlloVerificaEnergetica = ControlloVerificaEnergeticaModel.tipo4DtoToModel.convert(source.getControlloVerificaEnergetica());
			target.setControlloVerificaEnergetica(controlloVerificaEnergetica);
			RowFumiModel target4 = RowFumiModel.tipo4DtoToModel.convert(source.getTabFumi().getRowFumi());
			tabFumi.getRowFumi().add(target4);
			target.setTabFumi(tabFumi);
			allegatoModel.getRowAllegato().add(target);
		}
		DatiManutentoreModel datiManutentore = DatiManutentoreModel.tipo4DtoToModel.convert(ree.getRichiesta().getDatiManutentore());
		DatiIntestazioneModel datiIntestazione = DatiIntestazioneModel.tipo4DtoToModel.convert(ree.getRichiesta().getDatiIntestazione());
		DatiTecnicoModel datiTecnico = DatiTecnicoModel.tipo4DtoToModel.convert(ree.getRichiesta().getDatiAllegato().getDatiTecnico());
		DatiIdentificativiModel datiIdentificativi = DatiIdentificativiModel.tipo4DtoToModel.convert(ree.getRichiesta().getDatiAllegato().getDatiIdentificativi());
		DocumentazioneTecnicaModel documentazioneTecnica = DocumentazioneTecnicaModel.tipo4DtoToModel.convert(ree.getRichiesta().getDatiAllegato().getDocumentazioneTecnica());
		TrattamentoAcquaModel trattamentoAcqua = TrattamentoAcquaModel.tipo4DtoToModel.convert(ree.getRichiesta().getDatiAllegato().getTrattamentoAcqua());
		ControlloImpiantoModel controlloImpianto = ControlloImpiantoModel.tipo4DtoToModel.convert(ree.getRichiesta().getDatiAllegato().getControlloImpianto());
		CheckListModel checkList = CheckListModel.tipo4DtoToModel.convert(ree.getRichiesta().getDatiAllegato().getCheckList());

		ric.setDatiManutentore(datiManutentore);
		datiAllegato.setDatiIdentificativi(datiIdentificativi);
		datiAllegato.setDocumentazioneTecnica(documentazioneTecnica);
		datiAllegato.setTrattamentoAcqua(trattamentoAcqua);
		datiAllegato.setControlloImpianto(controlloImpianto);
		datiAllegato.setCheckList(checkList);
		datiAllegato.setDatiTecnico(datiTecnico);
		datiAllegato.setAllegato(allegatoModel);
		ric.setDatiAllegato(datiAllegato);
		ric.setDatiIntestazione(datiIntestazione);
		modModel.setRichiesta(ric);

		return modModel;
	}

	public static String createManutenzioneGTXML(ManutFormModel manutFormModel, String nome, String cognome, XMLGregorianCalendar dataProssimoIntervento, XMLGregorianCalendar dataControllo, String codiceImpianto, UtenteLoggato user)
			throws JAXBException {
		DatiManutenzione datiManutenzioneGT = new DatiManutenzione();
		it.csi.citpwa.model.xsd.manutgt.CheckList checkListGT = new it.csi.citpwa.model.xsd.manutgt.CheckList();
		checkListGT.setAFOsservazioni(manutFormModel.getOsservazioni());
		checkListGT.setAFPrescrizioni(manutFormModel.getPrescrizioni());
		checkListGT.setAFRaccomandazioni(manutFormModel.getRaccomandazioni());
		datiManutenzioneGT.setCheckList(checkListGT);
		it.csi.citpwa.model.xsd.manutgt.DatiTecnico datiTecnicoGT = new it.csi.citpwa.model.xsd.manutgt.DatiTecnico();
		datiTecnicoGT.setAFNomeTecnico(nome != null ? nome.toUpperCase(Locale.ROOT) : "");
		datiTecnicoGT.setAFCognomeTecnico(cognome != null ? cognome.toUpperCase(Locale.ROOT) : "");
		datiTecnicoGT.setAFDataIntervento(dataProssimoIntervento);
		datiTecnicoGT.setAFOrarioArrivo(manutFormModel.getOraArrivo());
		datiTecnicoGT.setAFOrarioPartenza(manutFormModel.getOraPartenza());
		datiManutenzioneGT.setDatiTecnico(datiTecnicoGT);
		DatiManutenzione.DettManutenzione dettManutenzioneGT = new DatiManutenzione.DettManutenzione();
		dettManutenzioneGT.getAENumGT().add(BigInteger.valueOf(manutFormModel.getProgressivo()));
		datiManutenzioneGT.setDettManutenzione(dettManutenzioneGT);
		it.csi.citpwa.model.xsd.manutgt.DatiIntestazione datiIntestazioneGT = new it.csi.citpwa.model.xsd.manutgt.DatiIntestazione();
		datiIntestazioneGT.setAFDataControllo(dataControllo);
		datiIntestazioneGT.setTipoIntervento(new BigInteger(manutFormModel.getTipoIntervento()));
		datiIntestazioneGT.setCodiceCatasto(codiceImpianto);
		MANUTENZIONE manutenzioneGT = new MANUTENZIONE();
		manutenzioneGT.setRichiesta(new it.csi.citpwa.model.xsd.manutgt.Richiesta());
		manutenzioneGT.getRichiesta().setDatiManutenzione(datiManutenzioneGT);
		manutenzioneGT.getRichiesta().setDatiIntestazione(datiIntestazioneGT);
		DatiImpresa datiImpresaGT = new DatiImpresa();
		datiImpresaGT.setCodiceFiscale(manutFormModel.getCodiceFiscale());
		datiImpresaGT.setNumeroREA(manutFormModel.getNumeroRea());
		datiImpresaGT.setSiglaREA(manutFormModel.getSiglaRea());
		manutenzioneGT.getRichiesta().setDatiImpresa(datiImpresaGT);
		JAXBContext jaxbContext = JAXBContext.newInstance(MANUTENZIONE.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		StringWriter sw = new StringWriter();
		jaxbMarshaller.marshal(manutenzioneGT, sw);
		return sw.toString();
	}

	public static String createManutenzioneCGXML(ManutFormModel manutFormModel, String nome, String cognome, XMLGregorianCalendar dataProssimoIntervento, XMLGregorianCalendar dataControllo, String codiceImpianto, UtenteLoggato user)
			throws JAXBException {
		it.csi.citpwa.model.xsd.manutcg.DatiManutenzione datiManutenzioneCG = new it.csi.citpwa.model.xsd.manutcg.DatiManutenzione();
		it.csi.citpwa.model.xsd.manutcg.CheckList checkListCG = new it.csi.citpwa.model.xsd.manutcg.CheckList();
		checkListCG.setAFOsservazioni(manutFormModel.getOsservazioni());
		checkListCG.setAFPrescrizioni(manutFormModel.getPrescrizioni());
		checkListCG.setAFRaccomandazioni(manutFormModel.getRaccomandazioni());
		datiManutenzioneCG.setCheckList(checkListCG);
		it.csi.citpwa.model.xsd.manutcg.DatiTecnico datiTecnicoCG = new it.csi.citpwa.model.xsd.manutcg.DatiTecnico();
		datiTecnicoCG.setAFNomeTecnico(nome != null ? nome.toUpperCase(Locale.ROOT) : "");
		datiTecnicoCG.setAFCognomeTecnico(cognome != null ? cognome.toUpperCase(Locale.ROOT) : "");
		datiTecnicoCG.setAFDataIntervento(dataProssimoIntervento);
		datiTecnicoCG.setAFOrarioArrivo(manutFormModel.getOraArrivo());
		datiTecnicoCG.setAFOrarioPartenza(manutFormModel.getOraPartenza());
		datiManutenzioneCG.setDatiTecnico(datiTecnicoCG);
		it.csi.citpwa.model.xsd.manutcg.DatiManutenzione.DettManutenzione dettManutenzioneCG = new it.csi.citpwa.model.xsd.manutcg.DatiManutenzione.DettManutenzione();
		dettManutenzioneCG.getAENumCG().add(BigInteger.valueOf(manutFormModel.getProgressivo()));
		datiManutenzioneCG.setDettManutenzione(dettManutenzioneCG);
		it.csi.citpwa.model.xsd.manutcg.DatiIntestazione datiIntestazioneCG = new it.csi.citpwa.model.xsd.manutcg.DatiIntestazione();
		datiIntestazioneCG.setAFDataControllo(dataControllo);
		datiIntestazioneCG.setTipoIntervento(new BigInteger(manutFormModel.getTipoIntervento()));
		datiIntestazioneCG.setCodiceCatasto(codiceImpianto);
		it.csi.citpwa.model.xsd.manutcg.MANUTENZIONE manutenzioneCG = new it.csi.citpwa.model.xsd.manutcg.MANUTENZIONE();
		manutenzioneCG.setRichiesta(new it.csi.citpwa.model.xsd.manutcg.Richiesta());
		manutenzioneCG.getRichiesta().setDatiManutenzione(datiManutenzioneCG);
		manutenzioneCG.getRichiesta().setDatiIntestazione(datiIntestazioneCG);
		it.csi.citpwa.model.xsd.manutcg.DatiImpresa datiImpresaCG = new it.csi.citpwa.model.xsd.manutcg.DatiImpresa();
		datiImpresaCG.setCodiceFiscale(manutFormModel.getCodiceFiscale());
		datiImpresaCG.setNumeroREA(manutFormModel.getNumeroRea());
		datiImpresaCG.setSiglaREA(manutFormModel.getSiglaRea());
		manutenzioneCG.getRichiesta().setDatiImpresa(datiImpresaCG);
		JAXBContext jaxbContext = JAXBContext.newInstance(it.csi.citpwa.model.xsd.manutcg.MANUTENZIONE.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		StringWriter sw = new StringWriter();
		jaxbMarshaller.marshal(manutenzioneCG, sw);
		return sw.toString();
	}

	public static String createManutenzioneSCXML(ManutFormModel manutFormModel, String nome, String cognome, XMLGregorianCalendar dataProssimoIntervento, XMLGregorianCalendar dataControllo, String codiceImpianto, UtenteLoggato user)
			throws JAXBException {
		it.csi.citpwa.model.xsd.manutsc.DatiManutenzione datiManutenzioneSC = new it.csi.citpwa.model.xsd.manutsc.DatiManutenzione();
		it.csi.citpwa.model.xsd.manutsc.CheckList checkListSC = new it.csi.citpwa.model.xsd.manutsc.CheckList();
		checkListSC.setAFOsservazioni(manutFormModel.getOsservazioni());
		checkListSC.setAFPrescrizioni(manutFormModel.getPrescrizioni());
		checkListSC.setAFRaccomandazioni(manutFormModel.getRaccomandazioni());
		datiManutenzioneSC.setCheckList(checkListSC);
		it.csi.citpwa.model.xsd.manutsc.DatiTecnico datiTecnicoSC = new it.csi.citpwa.model.xsd.manutsc.DatiTecnico();
		datiTecnicoSC.setAFNomeTecnico(nome != null ? nome.toUpperCase(Locale.ROOT) : "");
		datiTecnicoSC.setAFCognomeTecnico(cognome != null ? cognome.toUpperCase(Locale.ROOT) : "");
		datiTecnicoSC.setAFDataIntervento(dataProssimoIntervento);
		datiTecnicoSC.setAFOrarioArrivo(manutFormModel.getOraArrivo());
		datiTecnicoSC.setAFOrarioPartenza(manutFormModel.getOraPartenza());
		datiManutenzioneSC.setDatiTecnico(datiTecnicoSC);
		it.csi.citpwa.model.xsd.manutsc.DatiManutenzione.DettManutenzione dettManutenzioneSC = new it.csi.citpwa.model.xsd.manutsc.DatiManutenzione.DettManutenzione();
		dettManutenzioneSC.getAENumSC().add(BigInteger.valueOf(manutFormModel.getProgressivo()));
		datiManutenzioneSC.setDettManutenzione(dettManutenzioneSC);
		it.csi.citpwa.model.xsd.manutsc.DatiIntestazione datiIntestazioneSC = new it.csi.citpwa.model.xsd.manutsc.DatiIntestazione();
		datiIntestazioneSC.setAFDataControllo(dataControllo);
		datiIntestazioneSC.setTipoIntervento(new BigInteger(manutFormModel.getTipoIntervento()));
		datiIntestazioneSC.setCodiceCatasto(codiceImpianto);
		it.csi.citpwa.model.xsd.manutsc.MANUTENZIONE manutenzioneSC = new it.csi.citpwa.model.xsd.manutsc.MANUTENZIONE();
		manutenzioneSC.setRichiesta(new it.csi.citpwa.model.xsd.manutsc.Richiesta());
		manutenzioneSC.getRichiesta().setDatiManutenzione(datiManutenzioneSC);
		manutenzioneSC.getRichiesta().setDatiIntestazione(datiIntestazioneSC);
		it.csi.citpwa.model.xsd.manutsc.DatiImpresa datiImpresaSC = new it.csi.citpwa.model.xsd.manutsc.DatiImpresa();
		datiImpresaSC.setCodiceFiscale(manutFormModel.getCodiceFiscale());
		datiImpresaSC.setNumeroREA(manutFormModel.getNumeroRea());
		datiImpresaSC.setSiglaREA(manutFormModel.getSiglaRea());
		manutenzioneSC.getRichiesta().setDatiImpresa(datiImpresaSC);
		JAXBContext jaxbContext = JAXBContext.newInstance(it.csi.citpwa.model.xsd.manutsc.MANUTENZIONE.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		StringWriter sw = new StringWriter();
		jaxbMarshaller.marshal(manutenzioneSC, sw);
		return sw.toString();
	}

	public static String createManutenzioneGFXML(ManutFormModel manutFormModel, String nome, String cognome, XMLGregorianCalendar dataProssimoIntervento, XMLGregorianCalendar dataControllo, String codiceImpianto, UtenteLoggato user)
			throws JAXBException {
		it.csi.citpwa.model.xsd.manutgf.DatiManutenzione datiManutenzioneGF = new it.csi.citpwa.model.xsd.manutgf.DatiManutenzione();
		it.csi.citpwa.model.xsd.manutgf.CheckList checkListGF = new it.csi.citpwa.model.xsd.manutgf.CheckList();
		checkListGF.setAFOsservazioni(manutFormModel.getOsservazioni());
		checkListGF.setAFPrescrizioni(manutFormModel.getPrescrizioni());
		checkListGF.setAFRaccomandazioni(manutFormModel.getRaccomandazioni());
		datiManutenzioneGF.setCheckList(checkListGF);
		it.csi.citpwa.model.xsd.manutgf.DatiTecnico datiTecnicoGF = new it.csi.citpwa.model.xsd.manutgf.DatiTecnico();
		datiTecnicoGF.setAFNomeTecnico(nome != null ? nome.toUpperCase(Locale.ROOT) : "");
		datiTecnicoGF.setAFCognomeTecnico(cognome != null ? cognome.toUpperCase(Locale.ROOT) : "");
		datiTecnicoGF.setAFDataIntervento(dataProssimoIntervento);
		datiTecnicoGF.setAFOrarioArrivo(manutFormModel.getOraArrivo());
		datiTecnicoGF.setAFOrarioPartenza(manutFormModel.getOraPartenza());
		datiManutenzioneGF.setDatiTecnico(datiTecnicoGF);
		it.csi.citpwa.model.xsd.manutgf.DatiManutenzione.DettManutenzione dettManutenzioneGF = new it.csi.citpwa.model.xsd.manutgf.DatiManutenzione.DettManutenzione();
		dettManutenzioneGF.getAENumGF().add(BigInteger.valueOf(manutFormModel.getProgressivo()));
		datiManutenzioneGF.setDettManutenzione(dettManutenzioneGF);
		it.csi.citpwa.model.xsd.manutgf.DatiIntestazione datiIntestazioneGF = new it.csi.citpwa.model.xsd.manutgf.DatiIntestazione();
		datiIntestazioneGF.setAFDataControllo(dataControllo);
		datiIntestazioneGF.setTipoIntervento(new BigInteger(manutFormModel.getTipoIntervento()));
		datiIntestazioneGF.setCodiceCatasto(codiceImpianto);
		it.csi.citpwa.model.xsd.manutgf.MANUTENZIONE manutenzioneGF = new it.csi.citpwa.model.xsd.manutgf.MANUTENZIONE();
		manutenzioneGF.setRichiesta(new it.csi.citpwa.model.xsd.manutgf.Richiesta());
		manutenzioneGF.getRichiesta().setDatiManutenzione(datiManutenzioneGF);
		manutenzioneGF.getRichiesta().setDatiIntestazione(datiIntestazioneGF);
		it.csi.citpwa.model.xsd.manutgf.DatiImpresa datiImpresaGF = new it.csi.citpwa.model.xsd.manutgf.DatiImpresa();
		datiImpresaGF.setCodiceFiscale(manutFormModel.getCodiceFiscale());
		datiImpresaGF.setNumeroREA(manutFormModel.getNumeroRea());
		datiImpresaGF.setSiglaREA(manutFormModel.getSiglaRea());
		manutenzioneGF.getRichiesta().setDatiImpresa(datiImpresaGF);
		JAXBContext jaxbContext = JAXBContext.newInstance(it.csi.citpwa.model.xsd.manutgf.MANUTENZIONE.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		StringWriter sw = new StringWriter();
		jaxbMarshaller.marshal(manutenzioneGF, sw);
		return sw.toString();
	}

	public static CodiceDescrizione[] mapStelle(CodiceDescrizione[] stelle) {
		List<CodiceDescrizione> codiceDescrizione = new ArrayList<>();
		for(CodiceDescrizione elem:stelle){
			CodiceDescrizione newCodiceDescr = new CodiceDescrizione();
			StelleEnum stella = StelleEnum.valueOfIdPwa(elem.getCodice());
			if(stella!=null){
				newCodiceDescr.setCodice(stella.idXsd);
			}
			newCodiceDescr.setDescrizione(elem.getDescrizione());
			codiceDescrizione.add(newCodiceDescr);
		}
		return codiceDescrizione.toArray(new CodiceDescrizione[0]);
	}
}
