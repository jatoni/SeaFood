package com.mx.sea.food.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_typemovements database table.
 * 
 */
@Entity
@Table(name="tb_typemovements")
@NamedQuery(name="TbTypemovement.findAll", query="SELECT t FROM TbTypemovement t")
public class TbTypemovement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String name;

	public TbTypemovement() {
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

}