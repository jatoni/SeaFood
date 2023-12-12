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

	//bi-directional many-to-one association to TbItem
	@OneToMany(mappedBy="tbEmployee1")
	private List<TbItem> tbItems1;

	//bi-directional many-to-one association to TbItem
	@OneToMany(mappedBy="tbEmployee2")
	private List<TbItem> tbItems2;

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

	public List<TbItem> getTbItems1() {
		return this.tbItems1;
	}

	public void setTbItems1(List<TbItem> tbItems1) {
		this.tbItems1 = tbItems1;
	}

	public TbItem addTbItems1(TbItem tbItems1) {
		getTbItems1().add(tbItems1);
		tbItems1.setTbEmployee1(this);

		return tbItems1;
	}

	public TbItem removeTbItems1(TbItem tbItems1) {
		getTbItems1().remove(tbItems1);
		tbItems1.setTbEmployee1(null);

		return tbItems1;
	}

	public List<TbItem> getTbItems2() {
		return this.tbItems2;
	}

	public void setTbItems2(List<TbItem> tbItems2) {
		this.tbItems2 = tbItems2;
	}

	public TbItem addTbItems2(TbItem tbItems2) {
		getTbItems2().add(tbItems2);
		tbItems2.setTbEmployee2(this);

		return tbItems2;
	}

	public TbItem removeTbItems2(TbItem tbItems2) {
		getTbItems2().remove(tbItems2);
		tbItems2.setTbEmployee2(null);

		return tbItems2;
	}

}