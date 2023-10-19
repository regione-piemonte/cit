package it.csi.sigit.sigitwebn.presentation.sigitwebn.converter;

import java.util.Map;

import it.csi.sigit.sigitwebn.dto.libretto.UDTFormattedDouble;

import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.conversion.TypeConversionException;

/*PROTECTED REGION ID(R-781409485) ENABLED START*/
//inserire qui eventuali import aggiuntivi
//import it.csi.sigit.sigitwebn.dto.libretto.UDTFormattedDouble;
/*PROTECTED REGION END*/

/**
 * Custom Type Converter per lo user defined type [FormattedDouble].
 * 
 * @author [GUIGEN]
 * @generated
 */
public class UDTFormattedDoubleConverter extends StrutsTypeConverter {

	/**
	 * Trasforma una rappresentazione a stringa di un oggetto di tipo
	 * UDTFormattedDouble.
	 * @param  context
	 * @param  values
	 * @param  toClass
	 * @return
	 * @see org.apache.struts2.util.StrutsTypeConverter#convertFromString(java.util.Map, java.lang.String[], java.lang.Class)
	 */
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		/*PROTECTED REGION ID(R-65716698) ENABLED START*/
		java.text.DecimalFormat df = UDTFormattedDouble.createFormat();
		if (values != null && values.length > 0 && values[0] != null && values[0].trim().length() > 0) {
			String s = values[0].trim();
			if (!s.matches("\\d+(\\.\\d+)?")) {
				throw new TypeConversionException("impossibile convertire l'intera stringa");
			}
			return new UDTFormattedDouble(Double.parseDouble(s));
		}
		return null;
		/*PROTECTED REGION END*/
	}

	/**
	 * Trasforma una istanza di UDTFormattedDouble nella rappresentazione a stringa.
	 * @param
	 * @param
	 * @return
	 * @see org.apache.struts2.util.StrutsTypeConverter#convertToString(java.util.Map, java.lang.Object)
	 */
	@Override
	public String convertToString(Map context, Object o) {
		UDTFormattedDouble val = (UDTFormattedDouble) o;
		/*PROTECTED REGION ID(R1054280439) ENABLED START*/
		if (o instanceof UDTFormattedDouble) {
			if (val.getValue() != null) {
				java.text.DecimalFormat df = UDTFormattedDouble.createFormat();
				return df.format(((UDTFormattedDouble) o).getValue());
			}
		}
		return val.toString();

		/*PROTECTED REGION END*/
	}

}
