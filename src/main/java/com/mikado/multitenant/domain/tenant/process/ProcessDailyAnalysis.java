package com.mikado.multitenant.domain.tenant.process;

import com.mikado.multitenant.domain.base.TenantAbstractAuditingEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "process_daily_analysis")
@Data
public class ProcessDailyAnalysis extends TenantAbstractAuditingEntity {

    @Column(name = "description")
    private String description;

    @Column(name = "run_for_all_employee")
    private Boolean runForAllEmployee;

    @Column(name = "apply_tolerances")
    private Boolean applyTolerances;

    @Column(name = "check_early_entry_late_exit")
    private Boolean checkEarlyEntryLateExit;

    @Column(name = "check_late_entry_early_exit")
    private Boolean checkLateEntryEarlyExit;

    @Column(name = "apply_tolerance_first_entry_last_exit")
    private Boolean applyToleranceFirstEntryLastExit;

    @Column(name = "check_prev_and_next_day_schedule")
    private Boolean checkPrevAndNextDaySchedule;

    @Column(name = "use_prev_day_shift_group")
    private Boolean usePrevDayShiftGroup;

    @Column(name = "use_first_entry_last_exit")
    private Boolean useFirstEntryLastExit;

    @Column(name = "complete_work_when_missing_entry_exit")
    private Boolean completeWorkWhenMissingEntryExit;

}
