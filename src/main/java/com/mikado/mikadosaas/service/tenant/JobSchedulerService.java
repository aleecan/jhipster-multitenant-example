package com.mikado.mikadosaas.service.tenant;

import com.mikado.mikadosaas.domain.tenant.JobScheduler;
import com.mikado.mikadosaas.repository.tenant.JobSchedulerRepository;
import com.mikado.mikadosaas.service.dto.tenant.JobSchedulerDTO;
import com.mikado.mikadosaas.service.mapper.tenant.JobSchedulerMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link JobScheduler}.
 */
@Service
@Transactional
public class JobSchedulerService {

    private final Logger log = LoggerFactory.getLogger(JobSchedulerService.class);

    private final JobSchedulerRepository jobSchedulerRepository;

    private final JobSchedulerMapper jobSchedulerMapper;

    public JobSchedulerService(JobSchedulerRepository jobSchedulerRepository, JobSchedulerMapper jobSchedulerMapper) {
        this.jobSchedulerRepository = jobSchedulerRepository;
        this.jobSchedulerMapper = jobSchedulerMapper;
    }

    /**
     * Save a jobScheduler.
     *
     * @param jobSchedulerDTO the entity to save.
     * @return the persisted entity.
     */
    public JobSchedulerDTO save(JobSchedulerDTO jobSchedulerDTO) {
        log.debug("Request to save JobScheduler : {}", jobSchedulerDTO);
        JobScheduler jobScheduler = jobSchedulerMapper.toEntity(jobSchedulerDTO);
        jobScheduler = jobSchedulerRepository.save(jobScheduler);
        return jobSchedulerMapper.toDto(jobScheduler);
    }

    /**
     * Get all the jobSchedulers.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<JobSchedulerDTO> findAll(Pageable pageable) {
        log.debug("Request to get all JobSchedulers");
        return jobSchedulerRepository.findAll(pageable)
            .map(jobSchedulerMapper::toDto);
    }


    /**
     * Get one jobScheduler by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<JobSchedulerDTO> findOne(Long id) {
        log.debug("Request to get JobScheduler : {}", id);
        return jobSchedulerRepository.findById(id)
            .map(jobSchedulerMapper::toDto);
    }

    /**
     * Delete the jobScheduler by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete JobScheduler : {}", id);
        jobSchedulerRepository.deleteById(id);
    }
}
