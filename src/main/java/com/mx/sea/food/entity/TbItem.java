package com.mx.sea.food.entity;

import java.io.Serializable;
import javax.persistence.*;
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

	private int date;

	private String description;

	private int stock;

	//bi-directional many-to-one association to TbIncome
	@OneToMany(mappedBy="tbItem")
	private List<TbIncome> tbIncomes;

	//bi-directional many-to-one association to TbPiecepackage
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_piecePackage")
	private TbPiecepackage tbPiecepackage;

	//bi-directional many-to-one association to TbWarehouseoutlet
	@OneToMany(mappedBy="tbItem")
	private List<TbWarehouseoutlet> tbWarehouseoutlets;

	public TbItem() {
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public List<TbIncome> getTbIncomes() {
		return this.tbIncomes;
	}

	public void setTbIncomes(List<TbIncome> tbIncomes) {
		this.tbIncomes = tbIncomes;
	}

	public TbIncome addTbIncome(TbIncome tbIncome) {
		getTbIncomes().add(tbIncome);
		tbIncome.setTbItem(this);

		return tbIncome;
	}

	public TbIncome removeTbIncome(TbIncome tbIncome) {
		getTbIncomes().remove(tbIncome);
		tbIncome.setTbItem(null);

		return tbIncome;
	}

	public TbPiecepackage getTbPiecepackage() {
		return this.tbPiecepackage;
	}

	public void setTbPiecepackage(TbPiecepackage tbPiecepackage) {
		this.tbPiecepackage = tbPiecepackage;
	}

	public List<TbWarehouseoutlet> getTbWarehouseoutlets() {
		return this.tbWarehouseoutlets;
	}

	public void setTbWarehouseoutlets(List<TbWarehouseoutlet> tbWarehouseoutlets) {
		this.tbWarehouseoutlets = tbWarehouseoutlets;
	}

	public TbWarehouseoutlet addTbWarehouseoutlet(TbWarehouseoutlet tbWarehouseoutlet) {
		getTbWarehouseoutlets().add(tbWarehouseoutlet);
		tbWarehouseoutlet.setTbItem(this);

		return tbWarehouseoutlet;
	}

	public TbWarehouseoutlet removeTbWarehouseoutlet(TbWarehouseoutlet tbWarehouseoutlet) {
		getTbWarehouseoutlets().remove(tbWarehouseoutlet);
		tbWarehouseoutlet.setTbItem(null);

		return tbWarehouseoutlet;
	}

}