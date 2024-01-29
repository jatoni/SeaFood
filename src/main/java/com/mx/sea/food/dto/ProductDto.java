package com.mx.sea.food.dto;

import java.util.Date;

import com.mx.sea.food.entity.TbEmployee;
import com.mx.sea.food.entity.TbPiecepackage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
	private long id;
	private String description;
	private Date inputDate;
	private int stock;
	private String itemName;
	private TbEmployee tbEmployee;
	private TbPiecepackage tbPiecepackage;

	/**
	 * @param description
	 * @param inputDate
	 * @param stock
	 * @param itemName
	 * @param tbEmployee
	 * @param tbPiecepackage
	 */
	public ProductDto(String description, Date inputDate, int stock, String itemName, TbEmployee tbEmployee,
			TbPiecepackage tbPiecepackage) {
		super();
		this.description = description;
		this.inputDate = inputDate;
		this.stock = stock;
		this.itemName = itemName;
		this.tbEmployee = tbEmployee;
		this.tbPiecepackage = tbPiecepackage;
	}

}
