package com.mikado.multitenant.domain.tenant.definitions;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mikado.multitenant.domain.base.TenantAbstractAuditingEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "sub_department")
@Data
public class SubDepartment extends TenantAbstractAuditingEntity implements Serializable {

	private static final long serialVersionUID = 105629051914778867L;

	@Column(unique = true, nullable = false)
	private String code;

	@Column(name = "description")
	private String description;

	@ManyToOne
	@JoinColumn(name = "department_id", nullable = false)
	@JsonBackReference
	private Department department;

}
