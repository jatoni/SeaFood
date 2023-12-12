package com.mx.sea.food.dto;

import java.util.Date;

import com.mx.sea.food.entity.TbEmployee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseProductDto {
	private long id;
	private String description;
	private Date inputDate;
	private Date outputDate;
	private int stock;
	private String itemName;
	private TbEmployee tbEmployee1;
	private TbEmployee tbEmployee2;
}
