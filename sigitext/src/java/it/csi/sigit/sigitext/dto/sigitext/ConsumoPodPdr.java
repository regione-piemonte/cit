package it.csi.sigit.sigitext.dto.sigitext;

import java.io.Serializable;
import java.math.BigDecimal;

public class ConsumoPodPdr implements Serializable {

	private static final long serialVersionUID = 1L;
	

	/** 
	 * Anno di riferimento per il consumo	 
	 * 
	 */
	protected BigDecimal anno;
	
	/**
	 * POD o PDR dell’impianto					 
	 * 
	 */
	protected String podPdr;
	
	/** 
	 * Consumo di riferimento per quell’anno
	 * 
	 */
	protected BigDecimal consumoAnno;

	public ConsumoPodPdr() {
		super();
	}

	public BigDecimal getAnno() {
		return anno;
	}

	public void setAnno(BigDecimal anno) {
		this.anno = anno;
	}

	public String getPodPdr() {
		return podPdr;
	}

	public void setPodPdr(String podPdr) {
		this.podPdr = podPdr;
	}

	public BigDecimal getConsumoAnno() {
		return consumoAnno;
	}

	public void setConsumoAnno(BigDecimal consumoAnno) {
		this.consumoAnno = consumoAnno;
	}

	@Override
	public String toString() {
		return "ConsumoPodPdr ["
				+ "anno=" + anno + 
				", podPdr=" + podPdr + 
				", consumoAnno=" + consumoAnno + 
				"]";
	}
	
	
	

	
}
