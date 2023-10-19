/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.util;

import java.util.List;
import java.util.stream.Stream;

public interface IObjectConverter<T, R> {

	public List<R> convert(List<T> input);

	public Stream<R> convert(Stream<T> input);

	public R convert(T input);
}
