/**
 * 
 */
package com.mx.sea.food.tools;

import org.modelmapper.ModelMapper;

/**
 * @author jat_a Esta clase es para poder tener herramientas que nos podran
 *         servir en el proyecto
 */
public class ToolsSeaFood {

	private final static ModelMapper mapper = new ModelMapper();

	public ToolsSeaFood() {

	}

	public static <T1, T2> T2 map(T1 object, T2 objectClass) {
		T2 map = (T2) mapper.map(object, objectClass.getClass());
		return map;
	}

}
