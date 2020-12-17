package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.ScheduleChange;
import com.mikado.multitenant.repository.tenant.ScheduleChangeRepository;
import com.mikado.multitenant.service.dto.tenant.ScheduleChangeDTO;
import com.mikado.multitenant.service.mapper.tenant.ScheduleChangeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link ScheduleChange}.
 */
@Service
@Transactional
public class ScheduleChangeService {

    private final Logger log = LoggerFactory.getLogger(ScheduleChangeService.class);

    private final ScheduleChangeRepository scheduleChangeRepository;

    private final ScheduleChangeMapper scheduleChangeMapper;

    public ScheduleChangeService(ScheduleChangeRepository scheduleChangeRepository, ScheduleChangeMapper scheduleChangeMapper) {
        this.scheduleChangeRepository = scheduleChangeRepository;
        this.scheduleChangeMapper = scheduleChangeMapper;
    }

    /**
     * Save a scheduleChange.
     *
     * @param scheduleChangeDTO the entity to save.
     * @return the persisted entity.
     */
    public ScheduleChangeDTO save(ScheduleChangeDTO scheduleChangeDTO) {
        log.debug("Request to save ScheduleChange : {}", scheduleChangeDTO);
        ScheduleChange scheduleChange = scheduleChangeMapper.toEntity(scheduleChangeDTO);
        scheduleChange = scheduleChangeRepository.save(scheduleChange);
        return scheduleChangeMapper.toDto(scheduleChange);
    }

    /**
     * Get all the scheduleChanges.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<ScheduleChangeDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ScheduleChanges");
        return scheduleChangeRepository.findAll(pageable)
            .map(scheduleChangeMapper::toDto);
    }


    /**
     * Get one scheduleChange by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<ScheduleChangeDTO> findOne(Long id) {
        log.debug("Request to get ScheduleChange : {}", id);
        return scheduleChangeRepository.findById(id)
            .map(scheduleChangeMapper::toDto);
    }

    /**
     * Delete the scheduleChange by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete ScheduleChange : {}", id);
        scheduleChangeRepository.deleteById(id);
    }
}
