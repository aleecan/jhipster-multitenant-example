package com.mikado.multitenant.domain.tenant.definitions;

import com.mikado.multitenant.domain.base.TenantAbstractAuditingEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "overtime_reason")
@Data
@EqualsAndHashCode(callSuper = true)
public class OvertimeReason extends TenantAbstractAuditingEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	private String code;

	@Column(name = "description")
	private String description;

}
