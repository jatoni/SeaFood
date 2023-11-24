package com.mx.sea.food.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_role database table.
 * 
 */
@Entity
@Table(name="tb_role")
@NamedQuery(name="TbRole.findAll", query="SELECT t FROM TbRole t")
public class TbRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String name;

	//bi-directional many-to-one association to TbEmployee
	@OneToMany(mappedBy="tbRole")
	private List<TbEmployee> tbEmployees;

	public TbRole() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TbEmployee> getTbEmployees() {
		return this.tbEmployees;
	}

	public void setTbEmployees(List<TbEmployee> tbEmployees) {
		this.tbEmployees = tbEmployees;
	}

	public TbEmployee addTbEmployee(TbEmployee tbEmployee) {
		getTbEmployees().add(tbEmployee);
		tbEmployee.setTbRole(this);

		return tbEmployee;
	}

	public TbEmployee removeTbEmployee(TbEmployee tbEmployee) {
		getTbEmployees().remove(tbEmployee);
		tbEmployee.setTbRole(null);

		return tbEmployee;
	}

}