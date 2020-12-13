package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.AdditionalGroup;
import com.mikado.multitenant.repository.tenant.AdditionalGroupRepository;
import com.mikado.multitenant.service.dto.tenant.AdditionalGroupDTO;
import com.mikado.multitenant.service.mapper.tenant.AdditionalGroupMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link AdditionalGroup}.
 */
@Service
@Transactional
public class AdditionalGroupService {

    private final Logger log = LoggerFactory.getLogger(AdditionalGroupService.class);

    private final AdditionalGroupRepository additionalGroupRepository;

    private final AdditionalGroupMapper additionalGroupMapper;

    public AdditionalGroupService(AdditionalGroupRepository additionalGroupRepository, AdditionalGroupMapper additionalGroupMapper) {
        this.additionalGroupRepository = additionalGroupRepository;
        this.additionalGroupMapper = additionalGroupMapper;
    }

    /**
     * Save a additionalGroup.
     *
     * @param additionalGroupDTO the entity to save.
     * @return the persisted entity.
     */
    public AdditionalGroupDTO save(AdditionalGroupDTO additionalGroupDTO) {
        log.debug("Request to save AdditionalGroup : {}", additionalGroupDTO);
        AdditionalGroup additionalGroup = additionalGroupMapper.toEntity(additionalGroupDTO);
        additionalGroup = additionalGroupRepository.save(additionalGroup);
        return additionalGroupMapper.toDto(additionalGroup);
    }

    /**
     * Get all the additionalGroups.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<AdditionalGroupDTO> findAll(Pageable pageable) {
        log.debug("Request to get all AdditionalGroups");
        return additionalGroupRepository.findAll(pageable)
            .map(additionalGroupMapper::toDto);
    }


    /**
     * Get one additionalGroup by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<AdditionalGroupDTO> findOne(Long id) {
        log.debug("Request to get AdditionalGroup : {}", id);
        return additionalGroupRepository.findById(id)
            .map(additionalGroupMapper::toDto);
    }

    /**
     * Delete the additionalGroup by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete AdditionalGroup : {}", id);
        additionalGroupRepository.deleteById(id);
    }
}
