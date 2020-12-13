package com.mikado.multitenant.domain.tenant.process;

import com.mikado.multitenant.domain.base.EntityBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "process_holiday_leave")
@Data
public class ProcessHolidayLeave extends EntityBase {

    @Column(name = "description")
    private String description;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "do_not_update_old_transaction")
    private Boolean doNotUpdateOldTransaction;

    @Column(name = "use_previous_day_schedule_group")
    private Boolean usePreviousDayScheduleGroup;

    @Column(name = "check_other_day_schedule")
    private Boolean checkOtherDaySchedule;

}
