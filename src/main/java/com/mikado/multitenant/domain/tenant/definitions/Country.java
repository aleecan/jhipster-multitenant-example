package com.mikado.multitenant.domain.tenant.definitions;

import com.mikado.multitenant.domain.base.EntityBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "country")
@Data
public class Country extends EntityBase {

    @Column(name = "code")
    private String code;

    @Column(name = "country")
    private String country;

    @Column(name = "descriptor")
    private String descriptor;

    @Column(name = "uncode")
    private String uncode;
}
