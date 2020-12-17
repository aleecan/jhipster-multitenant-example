package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.ApproverDepartment;
import com.mikado.multitenant.repository.tenant.ApproverDepartmentRepository;
import com.mikado.multitenant.service.dto.tenant.ApproverDepartmentDTO;
import com.mikado.multitenant.service.mapper.tenant.ApproverDepartmentMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link ApproverDepartment}.
 */
@Service
@Transactional
public class ApproverDepartmentService {

    private final Logger log = LoggerFactory.getLogger(ApproverDepartmentService.class);

    private final ApproverDepartmentRepository approverDepartmentRepository;

    private final ApproverDepartmentMapper approverDepartmentMapper;

    public ApproverDepartmentService(ApproverDepartmentRepository approverDepartmentRepository, ApproverDepartmentMapper approverDepartmentMapper) {
        this.approverDepartmentRepository = approverDepartmentRepository;
        this.approverDepartmentMapper = approverDepartmentMapper;
    }

    /**
     * Save a approverDepartment.
     *
     * @param approverDepartmentDTO the entity to save.
     * @return the persisted entity.
     */
    public ApproverDepartmentDTO save(ApproverDepartmentDTO approverDepartmentDTO) {
        log.debug("Request to save ApproverDepartment : {}", approverDepartmentDTO);
        ApproverDepartment approverDepartment = approverDepartmentMapper.toEntity(approverDepartmentDTO);
        approverDepartment = approverDepartmentRepository.save(approverDepartment);
        return approverDepartmentMapper.toDto(approverDepartment);
    }

    /**
     * Get all the approverDepartments.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<ApproverDepartmentDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ApproverDepartments");
        return approverDepartmentRepository.findAll(pageable)
            .map(approverDepartmentMapper::toDto);
    }


    /**
     * Get one approverDepartment by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<ApproverDepartmentDTO> findOne(Long id) {
        log.debug("Request to get ApproverDepartment : {}", id);
        return approverDepartmentRepository.findById(id)
            .map(approverDepartmentMapper::toDto);
    }

    /**
     * Delete the approverDepartment by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete ApproverDepartment : {}", id);
        approverDepartmentRepository.deleteById(id);
    }
}
