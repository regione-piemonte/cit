package it.csi.sigit.sigitwebn.presentation.sigitwebn.converter;

import java.util.Map;

import it.csi.sigit.sigitwebn.dto.common.UDTPositiveInteger;

import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.conversion.TypeConversionException;

/*PROTECTED REGION ID(R-1497573801) ENABLED START*/
//inserire qui eventuali import aggiuntivi

/*PROTECTED REGION END*/

/**
 * Custom Type Converter per lo user defined type [PositiveInteger].
 * 
 * @author [GUIGEN]
 * @generated
 */
public class UDTPositiveIntegerConverter extends StrutsTypeConverter {

	/**
	 * Trasforma una rappresentazione a stringa di un oggetto di tipo
	 * UDTPositiveInteger.
	 * @param  context
	 * @param  values
	 * @param  toClass
	 * @return
	 * @see org.apache.struts2.util.StrutsTypeConverter#convertFromString(java.util.Map, java.lang.String[], java.lang.Class)
	 */
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		/*PROTECTED REGION ID(R1729015758) ENABLED START*/
		if (values != null && values.length > 0 && values[0] != null && values[0].trim().length() > 0) {
			String s = values[0].trim();
			java.util.Locale.setDefault(java.util.Locale.ITALY);
			java.text.DecimalFormat df = new java.text.DecimalFormat("############");

			//df.setMaximumFractionDigits(0);
			//df.setMinimumFractionDigits(0);

			try {

				java.text.ParsePosition parsePosition = new java.text.ParsePosition(0);
				Number n = df.parse(s, parsePosition);

				if (!s.matches("^[0-9]*")) {
					throw new java.text.ParseException("impossibile convertire l'intera stringa",
							parsePosition.getIndex());
				}

				if (parsePosition.getIndex() != s.length()) {
					throw new java.text.ParseException("impossibile convertire l'intera stringa",
							parsePosition.getIndex());
				}
				if (n.intValue() < 0) {
					throw new java.text.ParseException("sono permessi solo numeri positivi", parsePosition.getIndex());
				}

				return new UDTPositiveInteger(n.intValue());
			} catch (java.text.ParseException e) {
				throw new TypeConversionException(e);
			}

		}
		return null;
		/*PROTECTED REGION END*/
	}

	/**
	 * Trasforma una istanza di UDTPositiveInteger nella rappresentazione a stringa.
	 * @param
	 * @param
	 * @return
	 * @see org.apache.struts2.util.StrutsTypeConverter#convertToString(java.util.Map, java.lang.Object)
	 */
	@Override
	public String convertToString(Map context, Object o) {
		UDTPositiveInteger val = (UDTPositiveInteger) o;
		/*PROTECTED REGION ID(R1632683679) ENABLED START*/
		if (o instanceof UDTPositiveInteger) {
			if (val.getValue() != null) {
				java.util.Locale.setDefault(java.util.Locale.ITALY);
				java.text.DecimalFormat df = new java.text.DecimalFormat("############");
				//df.setMinimumFractionDigits(0);
				//df.setMaximumFractionDigits(0);
				return df.format(((UDTPositiveInteger) o).getValue());
			}
		}

		return val.toString();
		/*PROTECTED REGION END*/
	}

}
