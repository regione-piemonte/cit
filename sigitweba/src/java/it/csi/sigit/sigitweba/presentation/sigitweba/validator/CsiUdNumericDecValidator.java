package it.csi.sigit.sigitweba.presentation.sigitweba.validator;

import java.lang.reflect.Method;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;

import com.opensymphony.xwork2.validator.*;
import com.opensymphony.xwork2.validator.validators.*;

import org.apache.log4j.Logger;

import it.csi.sigit.sigitweba.util.*;

/**
 * CsiUdNumericDecValidator Simple Type User Defined Validator Class.
 *
 * @author GuiGen
 */
public class CsiUdNumericDecValidator extends DoubleRangeFieldValidator {

	protected static final Logger LOG = Logger.getLogger(Constants.APPLICATION_CODE + ".presentation.validator");

	/**
	 * validazione effettiva
	 * @param object
	 */
	@Override
	public void validate(Object object) throws ValidationException {
		// nome del campo da validare
		String fieldName = getFieldName();

		// valore del campo (questo e' il SimpleType User Defined)
		Object fieldObj = (Object) this.getFieldValue(fieldName, object);
		if (fieldObj == null) {
			return;
		}

		// reperisco il valore del SimpleType User Defined chiamando il metodo getValue()
		// se non c'e' nessun valore non faccio nessuna validazione
		// se e' obbligatorio un valore, allora deve essere aggiunto sul campo un required validator
		Object obj;
		try {
			Method readMethod = findReadMethod("value", fieldObj.getClass());
			obj = readMethod.invoke(fieldObj, new Object[]{});
			if (obj == null) {
				return;
			}
		} catch (Exception e) {
			LOG.error(
					"[CsiUdNumericDecValidator::validate] Errore nel reperimento o invocazione del metodo getValue, classe:"
							+ object.getClass().getName() + ": " + e,
					e);
			throw new ValidationException("Errore nel reperimento o invocazione del metodo getValue, classe:"
					+ fieldObj.getClass().getName() + ": " + e);
		}

		// da qui in avanti c'e' la logica del metodo originale DoubleRangeFieldValidator.validate()
		Double value;
		try {
			value = Double.valueOf(obj.toString());
		} catch (NumberFormatException e) {
			return;
		}

		Double minInclusiveValue = getMinInclusive();
		Double maxInclusiveValue = getMaxInclusive();
		Double minExclusiveValue = getMinExclusive();
		Double maxExclusiveValue = getMaxExclusive();

		if ((maxInclusiveValue != null && value.compareTo(maxInclusiveValue) > 0)
				|| (minInclusiveValue != null && value.compareTo(minInclusiveValue) < 0)
				|| (maxExclusiveValue != null && value.compareTo(maxExclusiveValue) >= 0)
				|| (minExclusiveValue != null && value.compareTo(minExclusiveValue) <= 0)) {
			addFieldError(fieldName, object);
		}

	}

	////////////////////////////////////////////////////////////////////////////////////////
	// PROPRIETA' E METODI DEL VALIDATORE ORIGINALE SOVRASCRITTI O COPIATI
	////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////
	// INTROSPECTION METHODS
	////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * objClass
	 */
	private Class objClass;

	/**
	 * objClass
	 */
	private Class getObjClass() {
		return objClass;
	}

	/**
	 * objClass
	 */
	private void setObjClass(Class cl) {
		objClass = cl;
	}

	/**
	 * reperisce il metodo di read nella classe
	 * @param pName
	 * @param cl
	 * @throws IntrospectionException
	 */
	private Method findReadMethod(String pName, Class cl) throws IntrospectionException {
		String name = (pName.startsWith("get") || pName.startsWith("set")
				? pName.substring(3)
				: pName.startsWith("is") ? pName.substring(2) : pName);
		BeanInfo bi = java.beans.Introspector.getBeanInfo(cl);
		PropertyDescriptor[] pds = bi.getPropertyDescriptors();
		for (int i = 0; i < pds.length; i++) {
			PropertyDescriptor currPd = pds[i];
			if (currPd.getName().equalsIgnoreCase(name))
				return currPd.getReadMethod();
		}
		return null;
	}

	/**
	 * reperisce il metodo di write nella classe
	 * @param pName
	 * @param cl
	 * @throws IntrospectionException
	 */
	private Method findWriteMethod(String pName, Class cl) throws IntrospectionException {
		String name = (pName.startsWith("get") || pName.startsWith("set")
				? pName.substring(3)
				: pName.startsWith("is") ? pName.substring(2) : pName);
		BeanInfo bi = java.beans.Introspector.getBeanInfo(cl);
		PropertyDescriptor[] pds = bi.getPropertyDescriptors();
		for (int i = 0; i < pds.length; i++) {
			PropertyDescriptor currPd = pds[i];
			if (currPd.getName().equalsIgnoreCase(name))
				return currPd.getWriteMethod();
		}
		return null;
	}

}
