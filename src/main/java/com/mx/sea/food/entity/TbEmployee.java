package com.mx.sea.food.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_employee database table.
 * 
 */
@Entity
@Table(name="tb_employee")
@NamedQuery(name="TbEmployee.findAll", query="SELECT t FROM TbEmployee t")
public class TbEmployee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String email;

	private String lastName;

	private String name;

	private String pass;

	private String username;

	//bi-directional many-to-one association to TbRole
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_role")
	private TbRole tbRole;

	//bi-directional many-to-one association to TbTypework
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_typeWork")
	private TbTypework tbTypework;

	//bi-directional many-to-one association to TbIncome
	@OneToMany(mappedBy="tbEmployee")
	private List<TbIncome> tbIncomes;

	//bi-directional many-to-one association to TbWarehouseoutlet
	@OneToMany(mappedBy="tbEmployee")
	private List<TbWarehouseoutlet> tbWarehouseoutlets;

	public TbEmployee() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public TbRole getTbRole() {
		return this.tbRole;
	}

	public void setTbRole(TbRole tbRole) {
		this.tbRole = tbRole;
	}

	public TbTypework getTbTypework() {
		return this.tbTypework;
	}

	public void setTbTypework(TbTypework tbTypework) {
		this.tbTypework = tbTypework;
	}

	public List<TbIncome> getTbIncomes() {
		return this.tbIncomes;
	}

	public void setTbIncomes(List<TbIncome> tbIncomes) {
		this.tbIncomes = tbIncomes;
	}

	public TbIncome addTbIncome(TbIncome tbIncome) {
		getTbIncomes().add(tbIncome);
		tbIncome.setTbEmployee(this);

		return tbIncome;
	}

	public TbIncome removeTbIncome(TbIncome tbIncome) {
		getTbIncomes().remove(tbIncome);
		tbIncome.setTbEmployee(null);

		return tbIncome;
	}

	public List<TbWarehouseoutlet> getTbWarehouseoutlets() {
		return this.tbWarehouseoutlets;
	}

	public void setTbWarehouseoutlets(List<TbWarehouseoutlet> tbWarehouseoutlets) {
		this.tbWarehouseoutlets = tbWarehouseoutlets;
	}

	public TbWarehouseoutlet addTbWarehouseoutlet(TbWarehouseoutlet tbWarehouseoutlet) {
		getTbWarehouseoutlets().add(tbWarehouseoutlet);
		tbWarehouseoutlet.setTbEmployee(this);

		return tbWarehouseoutlet;
	}

	public TbWarehouseoutlet removeTbWarehouseoutlet(TbWarehouseoutlet tbWarehouseoutlet) {
		getTbWarehouseoutlets().remove(tbWarehouseoutlet);
		tbWarehouseoutlet.setTbEmployee(null);

		return tbWarehouseoutlet;
	}

}