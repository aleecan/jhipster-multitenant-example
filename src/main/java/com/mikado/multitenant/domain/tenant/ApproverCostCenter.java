package com.mikado.multitenant.domain.tenant;

import com.mikado.multitenant.domain.base.TenantAbstractAuditingEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

/*@Entity
@Table(name = "approver_cost_center")
@Data
@EqualsAndHashCode*/
public class ApproverCostCenter extends TenantAbstractAuditingEntity implements Serializable {

	private static final long serialVersionUID = 4738674006008424141L;
	/*@ManyToOne
	@JoinColumn(name="employee_id")
	private Employee employee;

	@ManyToOne
	@JoinColumn(name="costcenter_id")
	private CostCenter costCenter;
	*/

    @Column(name = "employee_id")
    private Long employeeId;

    @JoinColumn(name="costcenter_id")
    private Long costCenterId;

	@Column(name = "level")
	private Integer level;

}
