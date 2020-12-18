package com.mikado.mikadosaas.service.tenant;

import com.mikado.mikadosaas.domain.tenant.AccessRangeEmployee;
import com.mikado.mikadosaas.repository.tenant.AccessRangeEmployeeRepository;
import com.mikado.mikadosaas.service.dto.tenant.AccessRangeEmployeeDTO;
import com.mikado.mikadosaas.service.mapper.tenant.AccessRangeEmployeeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link AccessRangeEmployee}.
 */
@Service
@Transactional
public class AccessRangeEmployeeService {

    private final Logger log = LoggerFactory.getLogger(AccessRangeEmployeeService.class);

    private final AccessRangeEmployeeRepository accessRangeEmployeeRepository;

    private final AccessRangeEmployeeMapper accessRangeEmployeeMapper;

    public AccessRangeEmployeeService(AccessRangeEmployeeRepository accessRangeEmployeeRepository, AccessRangeEmployeeMapper accessRangeEmployeeMapper) {
        this.accessRangeEmployeeRepository = accessRangeEmployeeRepository;
        this.accessRangeEmployeeMapper = accessRangeEmployeeMapper;
    }

    /**
     * Save a accessRangeEmployee.
     *
     * @param accessRangeEmployeeDTO the entity to save.
     * @return the persisted entity.
     */
    public AccessRangeEmployeeDTO save(AccessRangeEmployeeDTO accessRangeEmployeeDTO) {
        log.debug("Request to save AccessRangeEmployee : {}", accessRangeEmployeeDTO);
        AccessRangeEmployee accessRangeEmployee = accessRangeEmployeeMapper.toEntity(accessRangeEmployeeDTO);
        accessRangeEmployee = accessRangeEmployeeRepository.save(accessRangeEmployee);
        return accessRangeEmployeeMapper.toDto(accessRangeEmployee);
    }

    /**
     * Get all the accessRangeEmployees.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<AccessRangeEmployeeDTO> findAll(Pageable pageable) {
        log.debug("Request to get all AccessRangeEmployees");
        return accessRangeEmployeeRepository.findAll(pageable)
            .map(accessRangeEmployeeMapper::toDto);
    }


    /**
     * Get one accessRangeEmployee by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<AccessRangeEmployeeDTO> findOne(Long id) {
        log.debug("Request to get AccessRangeEmployee : {}", id);
        return accessRangeEmployeeRepository.findById(id)
            .map(accessRangeEmployeeMapper::toDto);
    }

    /**
     * Delete the accessRangeEmployee by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete AccessRangeEmployee : {}", id);
        accessRangeEmployeeRepository.deleteById(id);
    }
}
