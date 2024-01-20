package com.mx.sea.food.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the tb_employee database table.
 * 
 */
@Entity
@Table(name = "tb_employee")
@NamedQuery(name = "TbEmployee.findAll", query = "SELECT t FROM TbEmployee t")
public class TbEmployee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String email;

	private String lastName;

	private String name;

	private String pass;

	private String username;

	// bi-directional many-to-one association to TbRole
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_role")
	private TbRole tbRole;

	// bi-directional many-to-one association to TbTypework
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_typeWork")
	private TbTypework tbTypework;

	// bi-directional many-to-one association to TbItem
	@OneToMany(mappedBy = "tbEmployee")
	private List<TbItem> tbItems;

	// bi-directional many-to-one association to Tb_takeOutCeller
	@OneToMany(mappedBy = "tbEmployee")
	private List<Tb_takeOutCeller> tbTakeOutCellers;

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

	public List<TbItem> getTbItems() {
		return this.tbItems;
	}

	public void setTbItems(List<TbItem> tbItems) {
		this.tbItems = tbItems;
	}

	public TbItem addTbItem(TbItem tbItem) {
		getTbItems().add(tbItem);
		tbItem.setTbEmployee(this);

		return tbItem;
	}

	public TbItem removeTbItem(TbItem tbItem) {
		getTbItems().remove(tbItem);
		tbItem.setTbEmployee(null);

		return tbItem;
	}

	public List<Tb_takeOutCeller> getTbTakeOutCellers() {
		return this.tbTakeOutCellers;
	}

	public void setTbTakeOutCellers(List<Tb_takeOutCeller> tbTakeOutCellers) {
		this.tbTakeOutCellers = tbTakeOutCellers;
	}

	public Tb_takeOutCeller addTbTakeOutCeller(Tb_takeOutCeller tbTakeOutCeller) {
		getTbTakeOutCellers().add(tbTakeOutCeller);
		tbTakeOutCeller.setTbEmployee(this);

		return tbTakeOutCeller;
	}

	public Tb_takeOutCeller removeTbTakeOutCeller(Tb_takeOutCeller tbTakeOutCeller) {
		getTbTakeOutCellers().remove(tbTakeOutCeller);
		tbTakeOutCeller.setTbEmployee(null);

		return tbTakeOutCeller;
	}

}