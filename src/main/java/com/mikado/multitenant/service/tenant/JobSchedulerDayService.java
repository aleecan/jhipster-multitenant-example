package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.JobSchedulerDay;
import com.mikado.multitenant.repository.tenant.JobSchedulerDayRepository;
import com.mikado.multitenant.service.dto.tenant.JobSchedulerDayDTO;
import com.mikado.multitenant.service.mapper.tenant.JobSchedulerDayMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link JobSchedulerDay}.
 */
@Service
@Transactional
public class JobSchedulerDayService {

    private final Logger log = LoggerFactory.getLogger(JobSchedulerDayService.class);

    private final JobSchedulerDayRepository jobSchedulerDayRepository;

    private final JobSchedulerDayMapper jobSchedulerDayMapper;

    public JobSchedulerDayService(JobSchedulerDayRepository jobSchedulerDayRepository, JobSchedulerDayMapper jobSchedulerDayMapper) {
        this.jobSchedulerDayRepository = jobSchedulerDayRepository;
        this.jobSchedulerDayMapper = jobSchedulerDayMapper;
    }

    /**
     * Save a jobSchedulerDay.
     *
     * @param jobSchedulerDayDTO the entity to save.
     * @return the persisted entity.
     */
    public JobSchedulerDayDTO save(JobSchedulerDayDTO jobSchedulerDayDTO) {
        log.debug("Request to save JobSchedulerDay : {}", jobSchedulerDayDTO);
        JobSchedulerDay jobSchedulerDay = jobSchedulerDayMapper.toEntity(jobSchedulerDayDTO);
        jobSchedulerDay = jobSchedulerDayRepository.save(jobSchedulerDay);
        return jobSchedulerDayMapper.toDto(jobSchedulerDay);
    }

    /**
     * Get all the jobSchedulerDays.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<JobSchedulerDayDTO> findAll(Pageable pageable) {
        log.debug("Request to get all JobSchedulerDays");
        return jobSchedulerDayRepository.findAll(pageable)
            .map(jobSchedulerDayMapper::toDto);
    }


    /**
     * Get one jobSchedulerDay by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<JobSchedulerDayDTO> findOne(Long id) {
        log.debug("Request to get JobSchedulerDay : {}", id);
        return jobSchedulerDayRepository.findById(id)
            .map(jobSchedulerDayMapper::toDto);
    }

    /**
     * Delete the jobSchedulerDay by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete JobSchedulerDay : {}", id);
        jobSchedulerDayRepository.deleteById(id);
    }
}
