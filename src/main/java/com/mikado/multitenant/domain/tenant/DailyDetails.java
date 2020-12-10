package com.mikado.multitenant.domain.tenant;

import com.mikado.multitenant.domain.base.EntityBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "daily_details")
@Data
@EqualsAndHashCode(callSuper = true)
public class DailyDetails extends EntityBase {

	@Column(name = "day_length")
	private String dayLength;

    @Column(name = "day_count")
    private Double dayCount;

    @Column(name = "day_lenthh")
    private Double dayLengthDouble;

	@ManyToOne
	@JoinColumn(name = "daily_id", referencedColumnName = "id")
	private Daily daily;

	@ManyToOne
	@JoinColumn(name = "category_id", referencedColumnName = "id")
	private Category category;

}
