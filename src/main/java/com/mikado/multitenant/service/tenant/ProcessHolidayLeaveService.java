package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.ProcessHolidayLeave;
import com.mikado.multitenant.repository.tenant.ProcessHolidayLeaveRepository;
import com.mikado.multitenant.service.dto.tenant.ProcessHolidayLeaveDTO;
import com.mikado.multitenant.service.mapper.tenant.ProcessHolidayLeaveMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link ProcessHolidayLeave}.
 */
@Service
@Transactional
public class ProcessHolidayLeaveService {

    private final Logger log = LoggerFactory.getLogger(ProcessHolidayLeaveService.class);

    private final ProcessHolidayLeaveRepository processHolidayLeaveRepository;

    private final ProcessHolidayLeaveMapper processHolidayLeaveMapper;

    public ProcessHolidayLeaveService(ProcessHolidayLeaveRepository processHolidayLeaveRepository, ProcessHolidayLeaveMapper processHolidayLeaveMapper) {
        this.processHolidayLeaveRepository = processHolidayLeaveRepository;
        this.processHolidayLeaveMapper = processHolidayLeaveMapper;
    }

    /**
     * Save a processHolidayLeave.
     *
     * @param processHolidayLeaveDTO the entity to save.
     * @return the persisted entity.
     */
    public ProcessHolidayLeaveDTO save(ProcessHolidayLeaveDTO processHolidayLeaveDTO) {
        log.debug("Request to save ProcessHolidayLeave : {}", processHolidayLeaveDTO);
        ProcessHolidayLeave processHolidayLeave = processHolidayLeaveMapper.toEntity(processHolidayLeaveDTO);
        processHolidayLeave = processHolidayLeaveRepository.save(processHolidayLeave);
        return processHolidayLeaveMapper.toDto(processHolidayLeave);
    }

    /**
     * Get all the processHolidayLeaves.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<ProcessHolidayLeaveDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ProcessHolidayLeaves");
        return processHolidayLeaveRepository.findAll(pageable)
            .map(processHolidayLeaveMapper::toDto);
    }


    /**
     * Get one processHolidayLeave by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<ProcessHolidayLeaveDTO> findOne(Long id) {
        log.debug("Request to get ProcessHolidayLeave : {}", id);
        return processHolidayLeaveRepository.findById(id)
            .map(processHolidayLeaveMapper::toDto);
    }

    /**
     * Delete the processHolidayLeave by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete ProcessHolidayLeave : {}", id);
        processHolidayLeaveRepository.deleteById(id);
    }
}
