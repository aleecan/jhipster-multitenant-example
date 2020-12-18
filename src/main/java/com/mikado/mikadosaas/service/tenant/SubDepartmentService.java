package com.mikado.mikadosaas.service.tenant;

import com.mikado.mikadosaas.domain.tenant.SubDepartment;
import com.mikado.mikadosaas.repository.tenant.SubDepartmentRepository;
import com.mikado.mikadosaas.service.dto.tenant.SubDepartmentDTO;
import com.mikado.mikadosaas.service.mapper.tenant.SubDepartmentMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link SubDepartment}.
 */
@Service
@Transactional
public class SubDepartmentService {

    private final Logger log = LoggerFactory.getLogger(SubDepartmentService.class);

    private final SubDepartmentRepository subDepartmentRepository;

    private final SubDepartmentMapper subDepartmentMapper;

    public SubDepartmentService(SubDepartmentRepository subDepartmentRepository, SubDepartmentMapper subDepartmentMapper) {
        this.subDepartmentRepository = subDepartmentRepository;
        this.subDepartmentMapper = subDepartmentMapper;
    }

    /**
     * Save a subDepartment.
     *
     * @param subDepartmentDTO the entity to save.
     * @return the persisted entity.
     */
    public SubDepartmentDTO save(SubDepartmentDTO subDepartmentDTO) {
        log.debug("Request to save SubDepartment : {}", subDepartmentDTO);
        SubDepartment subDepartment = subDepartmentMapper.toEntity(subDepartmentDTO);
        subDepartment = subDepartmentRepository.save(subDepartment);
        return subDepartmentMapper.toDto(subDepartment);
    }

    /**
     * Get all the subDepartments.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<SubDepartmentDTO> findAll(Pageable pageable) {
        log.debug("Request to get all SubDepartments");
        return subDepartmentRepository.findAll(pageable)
            .map(subDepartmentMapper::toDto);
    }


    /**
     * Get one subDepartment by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<SubDepartmentDTO> findOne(Long id) {
        log.debug("Request to get SubDepartment : {}", id);
        return subDepartmentRepository.findById(id)
            .map(subDepartmentMapper::toDto);
    }

    /**
     * Delete the subDepartment by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete SubDepartment : {}", id);
        subDepartmentRepository.deleteById(id);
    }
}
