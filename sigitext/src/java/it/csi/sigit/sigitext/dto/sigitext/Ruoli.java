package it.csi.sigit.sigitext.dto.sigitext;

public class Ruoli implements java.io.Serializable {

	static final long serialVersionUID = 1;

	private PFLoggato pfLoggato = null;

	public void setPfLoggato(PFLoggato val) {
		pfLoggato = val;
	}

	public PFLoggato getPfLoggato() {
		return pfLoggato;
	}

	private RuoloPF[] ruoliPF = null;

	public void setRuoliPF(RuoloPF[] val) {
		if (val == null) {
			ruoliPF = null;
		} else {
			// non si puo' usare System.arrayCopy perche' i DTO devono essere compilati Java 1.3
			ruoliPF = new RuoloPF[val.length];
			for (int i = 0; i < val.length; i++) { //NOSONAR  Reason:NOTINJ13
				ruoliPF[i] = val[i]; //NOSONAR  Reason:NOTINJ13
			} //NOSONAR  Reason:NOTINJ13
		}
	}

	public RuoloPF[] getRuoliPF() {
		if (ruoliPF == null) {
			return null;
		} else {
			// non si puo' usare System.arrayCopy perche' i DTO devono essere compilati Java 1.3
			RuoloPF[] copy = new RuoloPF[ruoliPF.length];
			for (int i = 0; i < ruoliPF.length; i++) { //NOSONAR  Reason:NOTINJ13
				copy[i] = ruoliPF[i]; //NOSONAR  Reason:NOTINJ13
			} //NOSONAR  Reason:NOTINJ13
			return copy;
		}
	}

	private RuoloPG[] ruoliPG = null;

	public void setRuoliPG(RuoloPG[] val) {
		if (val == null) {
			ruoliPG = null;
		} else {
			// non si puo' usare System.arrayCopy perche' i DTO devono essere compilati Java 1.3
			ruoliPG = new RuoloPG[val.length];
			for (int i = 0; i < val.length; i++) { //NOSONAR  Reason:NOTINJ13
				ruoliPG[i] = val[i]; //NOSONAR  Reason:NOTINJ13
			} //NOSONAR  Reason:NOTINJ13
		}
	}

	public RuoloPG[] getRuoliPG() {
		if (ruoliPG == null) {
			return null;
		} else {
			// non si puo' usare System.arrayCopy perche' i DTO devono essere compilati Java 1.3
			RuoloPG[] copy = new RuoloPG[ruoliPG.length];
			for (int i = 0; i < ruoliPG.length; i++) { //NOSONAR  Reason:NOTINJ13
				copy[i] = ruoliPG[i]; //NOSONAR  Reason:NOTINJ13
			} //NOSONAR  Reason:NOTINJ13
			return copy;
		}
	}

	private RuoloPA[] ruoliPA = null;

	public void setRuoliPA(RuoloPA[] val) {
		if (val == null) {
			ruoliPA = null;
		} else {
			// non si puo' usare System.arrayCopy perche' i DTO devono essere compilati Java 1.3
			ruoliPA = new RuoloPA[val.length];
			for (int i = 0; i < val.length; i++) { //NOSONAR  Reason:NOTINJ13
				ruoliPA[i] = val[i]; //NOSONAR  Reason:NOTINJ13
			} //NOSONAR  Reason:NOTINJ13
		}
	}

	public RuoloPA[] getRuoliPA() {
		if (ruoliPA == null) {
			return null;
		} else {
			// non si puo' usare System.arrayCopy perche' i DTO devono essere compilati Java 1.3
			RuoloPA[] copy = new RuoloPA[ruoliPA.length];
			for (int i = 0; i < ruoliPA.length; i++) { //NOSONAR  Reason:NOTINJ13
				copy[i] = ruoliPA[i]; //NOSONAR  Reason:NOTINJ13
			} //NOSONAR  Reason:NOTINJ13
			return copy;
		}
	}
}
