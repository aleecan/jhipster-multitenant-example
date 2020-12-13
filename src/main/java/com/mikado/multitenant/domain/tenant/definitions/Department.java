package com.mikado.multitenant.domain.tenant.definitions;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mikado.multitenant.domain.base.TenantAbstractAuditingEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "department")
@Data
public class Department extends TenantAbstractAuditingEntity implements Serializable {

	private static final long serialVersionUID = 5092109171178551444L;

	@Column(nullable = false)
	private String code;

	@Column
	private String description;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JsonManagedReference
    private List<SubDepartment> subDepartments;

}
