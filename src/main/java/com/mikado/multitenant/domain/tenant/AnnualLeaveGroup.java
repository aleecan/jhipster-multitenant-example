package com.mikado.multitenant.domain.tenant;

import com.mikado.multitenant.domain.base.TenantAbstractAuditingEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "annual_leave_group")
@Data
public class AnnualLeaveGroup extends TenantAbstractAuditingEntity implements Serializable {

	private static final long serialVersionUID = 4649585732638053588L;

	@Column(name = "code")
	private Integer code;

	@Column(name = "description")
	private String description;

}
