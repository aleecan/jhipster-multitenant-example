package com.mikado.multitenant.domain.tenant;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mikado.multitenant.domain.base.TenantAbstractAuditingEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "company_sub_firm")
@Data
public class SubFirm extends TenantAbstractAuditingEntity implements Serializable {

	private static final long serialVersionUID = 5092109171178551444L;

	@Column(nullable = false)
	private String code;

	@Column
	private String description;

    @ManyToOne
    @JoinColumn(name = "company_firm_id", nullable = false)
    @JsonBackReference
    private Firm firm;

}
