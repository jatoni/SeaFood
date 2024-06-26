package com.mx.sea.food.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_product database table.
 * 
 */
@Entity
@Table(name="tb_product")
@NamedQuery(name="TbProduct.findAll", query="SELECT t FROM TbProduct t")
public class TbProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name="current_stock")
	private int currentStock;

	private String description;

	private String name;

	//bi-directional many-to-one association to TbPiecepackage
	@ManyToOne
	@JoinColumn(name="id_piecePackage")
	private TbPiecepackage tbPiecepackage;

	public TbProduct() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCurrentStock() {
		return this.currentStock;
	}

	public void setCurrentStock(int currentStock) {
		this.currentStock = currentStock;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TbPiecepackage getTbPiecepackage() {
		return this.tbPiecepackage;
	}

	public void setTbPiecepackage(TbPiecepackage tbPiecepackage) {
		this.tbPiecepackage = tbPiecepackage;
	}

}