package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.ToleranceGroup;
import com.mikado.multitenant.repository.tenant.ToleranceGroupRepository;
import com.mikado.multitenant.service.dto.tenant.ToleranceGroupDTO;
import com.mikado.multitenant.service.mapper.tenant.ToleranceGroupMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link ToleranceGroup}.
 */
@Service
@Transactional
public class ToleranceGroupService {

    private final Logger log = LoggerFactory.getLogger(ToleranceGroupService.class);

    private final ToleranceGroupRepository toleranceGroupRepository;

    private final ToleranceGroupMapper toleranceGroupMapper;

    public ToleranceGroupService(ToleranceGroupRepository toleranceGroupRepository, ToleranceGroupMapper toleranceGroupMapper) {
        this.toleranceGroupRepository = toleranceGroupRepository;
        this.toleranceGroupMapper = toleranceGroupMapper;
    }

    /**
     * Save a toleranceGroup.
     *
     * @param toleranceGroupDTO the entity to save.
     * @return the persisted entity.
     */
    public ToleranceGroupDTO save(ToleranceGroupDTO toleranceGroupDTO) {
        log.debug("Request to save ToleranceGroup : {}", toleranceGroupDTO);
        ToleranceGroup toleranceGroup = toleranceGroupMapper.toEntity(toleranceGroupDTO);
        toleranceGroup = toleranceGroupRepository.save(toleranceGroup);
        return toleranceGroupMapper.toDto(toleranceGroup);
    }

    /**
     * Get all the toleranceGroups.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<ToleranceGroupDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ToleranceGroups");
        return toleranceGroupRepository.findAll(pageable)
            .map(toleranceGroupMapper::toDto);
    }


    /**
     * Get one toleranceGroup by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<ToleranceGroupDTO> findOne(Long id) {
        log.debug("Request to get ToleranceGroup : {}", id);
        return toleranceGroupRepository.findById(id)
            .map(toleranceGroupMapper::toDto);
    }

    /**
     * Delete the toleranceGroup by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete ToleranceGroup : {}", id);
        toleranceGroupRepository.deleteById(id);
    }
}
