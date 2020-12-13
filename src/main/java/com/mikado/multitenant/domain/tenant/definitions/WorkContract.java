package com.mikado.multitenant.domain.tenant.definitions;

import com.mikado.multitenant.domain.base.TenantAbstractAuditingEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "work_contract")
@Data
@EqualsAndHashCode(callSuper = true)
public class WorkContract extends TenantAbstractAuditingEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "code", nullable = false)
	private String code;

	@Column(name = "description")
	private String description;

}
