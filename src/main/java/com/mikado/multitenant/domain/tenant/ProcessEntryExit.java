package com.mikado.multitenant.domain.tenant;

import com.mikado.multitenant.domain.base.TenantAbstractAuditingEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "process_entry_exit")
@Data
public class ProcessEntryExit extends TenantAbstractAuditingEntity {

    @Column(name = "description")
    private String description;

    @Column(name = "not_process_prev_day")
    private Boolean notProcessPrevDay;

    @Column(name = "process_missing_entry_exit")
    private Boolean processMissingEntryExit;

    @Column(name = "process_unworked_day")
    private Boolean processUnworkedDay;

    @Column(name = "find_best_matching_schedule")
    private Boolean findBestMatchingSchedule;

    @Column(name = "assign_matching_schedule_as_waiting")
    private Boolean assignMatchingScheduleAsWaiting;

    @Column(name = "flexible_weekend")
    private Boolean flexibleWeekend;

    @Column(name = "check_only_on_weekend_day")
    private Boolean checkOnlyOnWeekendDay;

    @Column(name = "use_prev_day_shift_group")
    private Boolean usePrevDayShiftGroup;

}
