package com.mx.sea.food.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


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

	private int stock;

	//bi-directional many-to-one association to TbEmployee
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="input_user_item")
	private TbEmployee tbEmployee;

	//bi-directional many-to-one association to TbPiecepackage
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_piecePackage")
	private TbPiecepackage tbPiecepackage;

	//bi-directional many-to-one association to Tb_takeOutCeller
	@OneToMany(mappedBy="tbItem")
	private List<Tb_takeOutCeller> tbTakeOutCellers;

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

	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public TbEmployee getTbEmployee() {
		return this.tbEmployee;
	}

	public void setTbEmployee(TbEmployee tbEmployee) {
		this.tbEmployee = tbEmployee;
	}

	public TbPiecepackage getTbPiecepackage() {
		return this.tbPiecepackage;
	}

	public void setTbPiecepackage(TbPiecepackage tbPiecepackage) {
		this.tbPiecepackage = tbPiecepackage;
	}

	public List<Tb_takeOutCeller> getTbTakeOutCellers() {
		return this.tbTakeOutCellers;
	}

	public void setTbTakeOutCellers(List<Tb_takeOutCeller> tbTakeOutCellers) {
		this.tbTakeOutCellers = tbTakeOutCellers;
	}

	public Tb_takeOutCeller addTbTakeOutCeller(Tb_takeOutCeller tbTakeOutCeller) {
		getTbTakeOutCellers().add(tbTakeOutCeller);
		tbTakeOutCeller.setTbItem(this);

		return tbTakeOutCeller;
	}

	public Tb_takeOutCeller removeTbTakeOutCeller(Tb_takeOutCeller tbTakeOutCeller) {
		getTbTakeOutCellers().remove(tbTakeOutCeller);
		tbTakeOutCeller.setTbItem(null);

		return tbTakeOutCeller;
	}

}