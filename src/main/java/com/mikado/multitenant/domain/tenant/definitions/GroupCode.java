package com.mikado.multitenant.domain.tenant.definitions;

import com.mikado.multitenant.domain.base.TenantAbstractAuditingEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "group_code")
@Data
public class GroupCode extends TenantAbstractAuditingEntity implements Serializable {

	private static final long serialVersionUID = 5092109171178551444L;

	@Column(nullable = false)
	private String code;

	@Column
	private String description;

}
