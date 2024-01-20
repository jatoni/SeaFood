/**
 * 
 */
package com.mx.sea.food.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.mx.sea.food.entity.TbRole;
import com.mx.sea.food.entity.TbTypework;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Es la clase para hacer el data Transfer object, este patron de diseño nos
 * permite transmitir informacion de multiples fuentes de datos o tablas.
 * 
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeDto {

	private long id;

	/*
	 * atributo para el correo electronico
	 */
	@NotNull(message = "El correo no puede ser nulo")
	@Email(message = "El correo debe ser valido")
	private String email;

	/*
	 * Atributo para los apellidos
	 */
	@NotNull(message = "El apellido no puede ser nulo")
	private String lastName;

	private String name;

	private String username;

	private String pass;

	private TbRole tbRole;

	private TbTypework tbTypework;
}
