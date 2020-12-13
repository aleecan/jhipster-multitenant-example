package com.mikado.multitenant.domain.tenant;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mikado.multitenant.domain.base.TenantAbstractAuditingEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "company_firm")
@Data
public class Firm extends TenantAbstractAuditingEntity implements Serializable {

	private static final long serialVersionUID = 5092109171178551444L;

	@Column(nullable = false)
	private String code;

	@Column
	private String description;

    @OneToMany(mappedBy = "firm", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JsonManagedReference
    private List<SubFirm> subFirms;

}
