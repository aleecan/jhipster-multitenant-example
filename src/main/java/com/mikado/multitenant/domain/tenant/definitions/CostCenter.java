package com.mikado.multitenant.domain.tenant.definitions;

import com.mikado.multitenant.domain.base.TenantAbstractAuditingEntity;
import com.mikado.multitenant.domain.tenant.Employee;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "cost_center")
@Data
public class CostCenter extends TenantAbstractAuditingEntity implements Serializable {

	private static final long serialVersionUID = 5092109171178551444L;

	@Column(nullable = false)
	private String code;

	@Column
	private String description;

    @ManyToOne
    private Employee employee;

}
