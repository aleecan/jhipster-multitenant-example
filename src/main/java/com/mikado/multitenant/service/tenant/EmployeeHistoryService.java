package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.EmployeeHistory;
import com.mikado.multitenant.repository.tenant.EmployeeHistoryRepository;
import com.mikado.multitenant.service.dto.tenant.EmployeeHistoryDTO;
import com.mikado.multitenant.service.mapper.tenant.EmployeeHistoryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link EmployeeHistory}.
 */
@Service
@Transactional
public class EmployeeHistoryService {

    private final Logger log = LoggerFactory.getLogger(EmployeeHistoryService.class);

    private final EmployeeHistoryRepository employeeHistoryRepository;

    private final EmployeeHistoryMapper employeeHistoryMapper;

    public EmployeeHistoryService(EmployeeHistoryRepository employeeHistoryRepository, EmployeeHistoryMapper employeeHistoryMapper) {
        this.employeeHistoryRepository = employeeHistoryRepository;
        this.employeeHistoryMapper = employeeHistoryMapper;
    }

    /**
     * Save a employeeHistory.
     *
     * @param employeeHistoryDTO the entity to save.
     * @return the persisted entity.
     */
    public EmployeeHistoryDTO save(EmployeeHistoryDTO employeeHistoryDTO) {
        log.debug("Request to save EmployeeHistory : {}", employeeHistoryDTO);
        EmployeeHistory employeeHistory = employeeHistoryMapper.toEntity(employeeHistoryDTO);
        employeeHistory = employeeHistoryRepository.save(employeeHistory);
        return employeeHistoryMapper.toDto(employeeHistory);
    }

    /**
     * Get all the employeeHistories.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<EmployeeHistoryDTO> findAll(Pageable pageable) {
        log.debug("Request to get all EmployeeHistories");
        return employeeHistoryRepository.findAll(pageable)
            .map(employeeHistoryMapper::toDto);
    }


    /**
     * Get one employeeHistory by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<EmployeeHistoryDTO> findOne(Long id) {
        log.debug("Request to get EmployeeHistory : {}", id);
        return employeeHistoryRepository.findById(id)
            .map(employeeHistoryMapper::toDto);
    }

    /**
     * Delete the employeeHistory by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete EmployeeHistory : {}", id);
        employeeHistoryRepository.deleteById(id);
    }
}
