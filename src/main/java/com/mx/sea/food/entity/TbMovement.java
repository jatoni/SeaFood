package com.mx.sea.food.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tb_movements database table.
 * 
 */
@Entity
@Table(name="tb_movements")
@NamedQuery(name="TbMovement.findAll", query="SELECT t FROM TbMovement t")
public class TbMovement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_movements")
	private long idMovements;

	@Temporal(TemporalType.DATE)
	private Date date;

	//bi-directional many-to-one association to TbEmployee
	@ManyToOne
	@JoinColumn(name="id_employee")
	private TbEmployee tbEmployee;

	//bi-directional many-to-one association to TbProduct
	@ManyToOne
	@JoinColumn(name="id_product")
	private TbProduct tbProduct;

	//bi-directional many-to-one association to TbTypemovement
	@ManyToOne
	@JoinColumn(name="id_type")
	private TbTypemovement tbTypemovement;

	public TbMovement() {
	}

	public long getIdMovements() {
		return this.idMovements;
	}

	public void setIdMovements(long idMovements) {
		this.idMovements = idMovements;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public TbEmployee getTbEmployee() {
		return this.tbEmployee;
	}

	public void setTbEmployee(TbEmployee tbEmployee) {
		this.tbEmployee = tbEmployee;
	}

	public TbProduct getTbProduct() {
		return this.tbProduct;
	}

	public void setTbProduct(TbProduct tbProduct) {
		this.tbProduct = tbProduct;
	}

	public TbTypemovement getTbTypemovement() {
		return this.tbTypemovement;
	}

	public void setTbTypemovement(TbTypemovement tbTypemovement) {
		this.tbTypemovement = tbTypemovement;
	}

}