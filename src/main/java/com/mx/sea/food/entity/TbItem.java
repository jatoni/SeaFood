package com.mx.sea.food.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tb_item database table.
 * 
 */
@Entity
@Table(name="tb_item")
@NamedQuery(name="TbItem.findAll", query="SELECT t FROM TbItem t")
public class TbItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name="input_date")
	private Date inputDate;

	@Column(name="item_name")
	private String itemName;

	@Temporal(TemporalType.DATE)
	@Column(name="output_date")
	private Date outputDate;

	private int stock;

	//bi-directional many-to-one association to TbEmployee
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="input_user_item")
	private TbEmployee tbEmployee1;

	//bi-directional many-to-one association to TbEmployee
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="output_user_item")
	private TbEmployee tbEmployee2;

	//bi-directional many-to-one association to TbPiecepackage
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_piecePackage")
	private TbPiecepackage tbPiecepackage;

	public TbItem() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getInputDate() {
		return this.inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Date getOutputDate() {
		return this.outputDate;
	}

	public void setOutputDate(Date outputDate) {
		this.outputDate = outputDate;
	}

	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public TbEmployee getTbEmployee1() {
		return this.tbEmployee1;
	}

	public void setTbEmployee1(TbEmployee tbEmployee1) {
		this.tbEmployee1 = tbEmployee1;
	}

	public TbEmployee getTbEmployee2() {
		return this.tbEmployee2;
	}

	public void setTbEmployee2(TbEmployee tbEmployee2) {
		this.tbEmployee2 = tbEmployee2;
	}

	public TbPiecepackage getTbPiecepackage() {
		return this.tbPiecepackage;
	}

	public void setTbPiecepackage(TbPiecepackage tbPiecepackage) {
		this.tbPiecepackage = tbPiecepackage;
	}

}