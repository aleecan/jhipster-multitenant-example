package com.mikado.multitenant.domain.tenant;

import com.mikado.multitenant.domain.base.TenantAbstractAuditingEntity;
import com.mikado.multitenant.domain.tenant.definitions.CostCenter;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "approver_cost_center")
@Data
@EqualsAndHashCode(callSuper = true)
public class ApproverCostCenter extends TenantAbstractAuditingEntity implements Serializable {

	private static final long serialVersionUID = 4738674006008424141L;

	@Column(name = "level")
	private Integer level;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name="cost_center_id")
    private CostCenter costCenter;

}
