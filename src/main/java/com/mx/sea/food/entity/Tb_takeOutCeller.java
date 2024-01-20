package com.mx.sea.food.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tb_takeOutCeller database table.
 * 
 */
@Entity
@Table(name="tb_takeOutCeller")
@NamedQuery(name="Tb_takeOutCeller.findAll", query="SELECT t FROM Tb_takeOutCeller t")
public class Tb_takeOutCeller implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_takeOutCeller;

	@Temporal(TemporalType.DATE)
	@Column(name="output_date")
	private Date outputDate;

	//bi-directional many-to-one association to TbEmployee
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_employee")
	private TbEmployee tbEmployee;

	//bi-directional many-to-one association to TbItem
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_item")
	private TbItem tbItem;

	public Tb_takeOutCeller() {
	}

	public long getId_takeOutCeller() {
		return this.id_takeOutCeller;
	}

	public void setId_takeOutCeller(long id_takeOutCeller) {
		this.id_takeOutCeller = id_takeOutCeller;
	}

	public Date getOutputDate() {
		return this.outputDate;
	}

	public void setOutputDate(Date outputDate) {
		this.outputDate = outputDate;
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