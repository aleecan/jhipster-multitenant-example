package com.mikado.multitenant.domain.tenant;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "annual_leave_group")
public class AnnualLeaveGroup implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 4649585732638053588L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(unique = true, nullable = false, name = "algroup")
	private String alGroup;

	@Column(name = "description")
	private String description;

	@Column
	@Type(type = "text")
	private String alDefl;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the alGroup
	 */
	public String getAlGroup() {
		return alGroup;
	}

	/**
	 * @param alGroup
	 *            the alGroup to set
	 */
	public void setAlGroup(String alGroup) {
		this.alGroup = alGroup;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the alDefl
	 */
	public String getAlDefl() {
		return alDefl;
	}

	/**
	 * @param alDefl
	 *            the alDefl to set
	 */
	public void setAlDefl(String alDefl) {
		this.alDefl = alDefl;
	}
}
