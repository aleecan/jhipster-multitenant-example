package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.MailScheduler;
import com.mikado.multitenant.repository.tenant.MailSchedulerRepository;
import com.mikado.multitenant.service.dto.tenant.MailSchedulerDTO;
import com.mikado.multitenant.service.mapper.tenant.MailSchedulerMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link MailScheduler}.
 */
@Service
@Transactional
public class MailSchedulerService {

    private final Logger log = LoggerFactory.getLogger(MailSchedulerService.class);

    private final MailSchedulerRepository mailSchedulerRepository;

    private final MailSchedulerMapper mailSchedulerMapper;

    public MailSchedulerService(MailSchedulerRepository mailSchedulerRepository, MailSchedulerMapper mailSchedulerMapper) {
        this.mailSchedulerRepository = mailSchedulerRepository;
        this.mailSchedulerMapper = mailSchedulerMapper;
    }

    /**
     * Save a mailScheduler.
     *
     * @param mailSchedulerDTO the entity to save.
     * @return the persisted entity.
     */
    public MailSchedulerDTO save(MailSchedulerDTO mailSchedulerDTO) {
        log.debug("Request to save MailScheduler : {}", mailSchedulerDTO);
        MailScheduler mailScheduler = mailSchedulerMapper.toEntity(mailSchedulerDTO);
        mailScheduler = mailSchedulerRepository.save(mailScheduler);
        return mailSchedulerMapper.toDto(mailScheduler);
    }

    /**
     * Get all the mailSchedulers.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<MailSchedulerDTO> findAll(Pageable pageable) {
        log.debug("Request to get all MailSchedulers");
        return mailSchedulerRepository.findAll(pageable)
            .map(mailSchedulerMapper::toDto);
    }


    /**
     * Get one mailScheduler by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<MailSchedulerDTO> findOne(Long id) {
        log.debug("Request to get MailScheduler : {}", id);
        return mailSchedulerRepository.findById(id)
            .map(mailSchedulerMapper::toDto);
    }

    /**
     * Delete the mailScheduler by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete MailScheduler : {}", id);
        mailSchedulerRepository.deleteById(id);
    }
}
