package com.mx.sea.food.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_piecepackage database table.
 * 
 */
@Entity
@Table(name="tb_piecepackage")
@NamedQuery(name="TbPiecepackage.findAll", query="SELECT t FROM TbPiecepackage t")
public class TbPiecepackage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String description;

	private String type;

	//bi-directional many-to-one association to TbProduct
	@OneToMany(mappedBy="tbPiecepackage")
	private List<TbProduct> tbProducts;

	public TbPiecepackage() {
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

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<TbProduct> getTbProducts() {
		return this.tbProducts;
	}

	public void setTbProducts(List<TbProduct> tbProducts) {
		this.tbProducts = tbProducts;
	}

	public TbProduct addTbProduct(TbProduct tbProduct) {
		getTbProducts().add(tbProduct);
		tbProduct.setTbPiecepackage(this);

		return tbProduct;
	}

	public TbProduct removeTbProduct(TbProduct tbProduct) {
		getTbProducts().remove(tbProduct);
		tbProduct.setTbPiecepackage(null);

		return tbProduct;
	}

}