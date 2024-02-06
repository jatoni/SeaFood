package com.mx.sea.food.dto;

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
	private int currentStock;
	private String name;
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
	public ProductDto(String description, int currentStock, String name, TbPiecepackage tbPiecepackage) {
		super();
		this.description = description;
		this.currentStock = currentStock;
		this.name = name;
		this.tbPiecepackage = tbPiecepackage;
	}

}
