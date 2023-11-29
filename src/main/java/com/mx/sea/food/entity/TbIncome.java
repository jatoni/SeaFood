package com.mx.sea.food.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_income database table.
 * 
 */
@Entity
@Table(name="tb_income")
@NamedQuery(name="TbIncome.findAll", query="SELECT t FROM TbIncome t")
public class TbIncome implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private int date;

	private int quantity;

	//bi-directional many-to-one association to TbEmployee
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_employee")
	private TbEmployee tbEmployee;

	//bi-directional many-to-one association to TbItem
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_item")
	private TbItem tbItem;

	public TbIncome() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getDate() {
		return this.date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public TbEmployee getTbEmployee() {
		return this.tbEmployee;
	}

	public void setTbEmployee(TbEmployee tbEmployee) {
		this.tbEmployee = tbEmployee;
	}

	public TbItem getTbItem() {
		return this.tbItem;
	}

	public void setTbItem(TbItem tbItem) {
		this.tbItem = tbItem;
	}

}