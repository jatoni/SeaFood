package com.mx.sea.food.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


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

	@Column(name="id_employee")
	private BigInteger idEmployee;

	@Column(name="id_product")
	private BigInteger idProduct;

	@Column(name="id_type")
	private BigInteger idType;

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

	public BigInteger getIdEmployee() {
		return this.idEmployee;
	}

	public void setIdEmployee(BigInteger idEmployee) {
		this.idEmployee = idEmployee;
	}

	public BigInteger getIdProduct() {
		return this.idProduct;
	}

	public void setIdProduct(BigInteger idProduct) {
		this.idProduct = idProduct;
	}

	public BigInteger getIdType() {
		return this.idType;
	}

	public void setIdType(BigInteger idType) {
		this.idType = idType;
	}

}