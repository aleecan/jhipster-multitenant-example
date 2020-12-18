package com.mikado.mikadosaas.service.tenant;

import com.mikado.mikadosaas.domain.tenant.MailSchedulerDay;
import com.mikado.mikadosaas.repository.tenant.MailSchedulerDayRepository;
import com.mikado.mikadosaas.service.dto.tenant.MailSchedulerDayDTO;
import com.mikado.mikadosaas.service.mapper.tenant.MailSchedulerDayMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link MailSchedulerDay}.
 */
@Service
@Transactional
public class MailSchedulerDayService {

    private final Logger log = LoggerFactory.getLogger(MailSchedulerDayService.class);

    private final MailSchedulerDayRepository mailSchedulerDayRepository;

    private final MailSchedulerDayMapper mailSchedulerDayMapper;

    public MailSchedulerDayService(MailSchedulerDayRepository mailSchedulerDayRepository, MailSchedulerDayMapper mailSchedulerDayMapper) {
        this.mailSchedulerDayRepository = mailSchedulerDayRepository;
        this.mailSchedulerDayMapper = mailSchedulerDayMapper;
    }

    /**
     * Save a mailSchedulerDay.
     *
     * @param mailSchedulerDayDTO the entity to save.
     * @return the persisted entity.
     */
    public MailSchedulerDayDTO save(MailSchedulerDayDTO mailSchedulerDayDTO) {
        log.debug("Request to save MailSchedulerDay : {}", mailSchedulerDayDTO);
        MailSchedulerDay mailSchedulerDay = mailSchedulerDayMapper.toEntity(mailSchedulerDayDTO);
        mailSchedulerDay = mailSchedulerDayRepository.save(mailSchedulerDay);
        return mailSchedulerDayMapper.toDto(mailSchedulerDay);
    }

    /**
     * Get all the mailSchedulerDays.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<MailSchedulerDayDTO> findAll(Pageable pageable) {
        log.debug("Request to get all MailSchedulerDays");
        return mailSchedulerDayRepository.findAll(pageable)
            .map(mailSchedulerDayMapper::toDto);
    }


    /**
     * Get one mailSchedulerDay by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<MailSchedulerDayDTO> findOne(Long id) {
        log.debug("Request to get MailSchedulerDay : {}", id);
        return mailSchedulerDayRepository.findById(id)
            .map(mailSchedulerDayMapper::toDto);
    }

    /**
     * Delete the mailSchedulerDay by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete MailSchedulerDay : {}", id);
        mailSchedulerDayRepository.deleteById(id);
    }
}
