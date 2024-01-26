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

	private String password;

	private String username;

	//bi-directional many-to-one association to TbRole
	@ManyToOne
	@JoinColumn(name="id_role")
	private TbRole tbRole;

	//bi-directional many-to-one association to TbMovement
	@OneToMany(mappedBy="tbEmployee")
	private List<TbMovement> tbMovements;

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

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public List<TbMovement> getTbMovements() {
		return this.tbMovements;
	}

	public void setTbMovements(List<TbMovement> tbMovements) {
		this.tbMovements = tbMovements;
	}

	public TbMovement addTbMovement(TbMovement tbMovement) {
		getTbMovements().add(tbMovement);
		tbMovement.setTbEmployee(this);

		return tbMovement;
	}

	public TbMovement removeTbMovement(TbMovement tbMovement) {
		getTbMovements().remove(tbMovement);
		tbMovement.setTbEmployee(null);

		return tbMovement;
	}

}