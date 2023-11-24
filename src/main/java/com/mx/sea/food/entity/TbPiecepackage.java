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

	//bi-directional many-to-one association to TbItem
	@OneToMany(mappedBy="tbPiecepackage")
	private List<TbItem> tbItems;

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

	public List<TbItem> getTbItems() {
		return this.tbItems;
	}

	public void setTbItems(List<TbItem> tbItems) {
		this.tbItems = tbItems;
	}

	public TbItem addTbItem(TbItem tbItem) {
		getTbItems().add(tbItem);
		tbItem.setTbPiecepackage(this);

		return tbItem;
	}

	public TbItem removeTbItem(TbItem tbItem) {
		getTbItems().remove(tbItem);
		tbItem.setTbPiecepackage(null);

		return tbItem;
	}

}