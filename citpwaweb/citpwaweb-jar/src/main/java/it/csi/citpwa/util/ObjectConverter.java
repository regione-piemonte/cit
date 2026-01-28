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
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ObjectConverter<T, R> implements IObjectConverter<T, R> {

	private final Function<T, R> mapper;

	public ObjectConverter(Function<T, R> mapper) {
		super();
		this.mapper = mapper;
	}

	@Override
	public List<R> convert(List<T> input) {
		return input.parallelStream().map(mapper).collect(Collectors.toList());
	}

	@Override
	public Stream<R> convert(Stream<T> input) {
		return input.map(mapper);
	}

	@Override
	public R convert(T input) {
		return mapper.apply(input);
	}

}
