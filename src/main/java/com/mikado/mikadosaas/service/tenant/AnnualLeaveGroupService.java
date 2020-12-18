package com.mikado.mikadosaas.service.tenant;

import com.mikado.mikadosaas.domain.tenant.AnnualLeaveGroup;
import com.mikado.mikadosaas.repository.tenant.AnnualLeaveGroupRepository;
import com.mikado.mikadosaas.service.dto.tenant.AnnualLeaveGroupDTO;
import com.mikado.mikadosaas.service.mapper.tenant.AnnualLeaveGroupMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link AnnualLeaveGroup}.
 */
@Service
@Transactional
public class AnnualLeaveGroupService {

    private final Logger log = LoggerFactory.getLogger(AnnualLeaveGroupService.class);

    private final AnnualLeaveGroupRepository annualLeaveGroupRepository;

    private final AnnualLeaveGroupMapper annualLeaveGroupMapper;

    public AnnualLeaveGroupService(AnnualLeaveGroupRepository annualLeaveGroupRepository, AnnualLeaveGroupMapper annualLeaveGroupMapper) {
        this.annualLeaveGroupRepository = annualLeaveGroupRepository;
        this.annualLeaveGroupMapper = annualLeaveGroupMapper;
    }

    /**
     * Save a annualLeaveGroup.
     *
     * @param annualLeaveGroupDTO the entity to save.
     * @return the persisted entity.
     */
    public AnnualLeaveGroupDTO save(AnnualLeaveGroupDTO annualLeaveGroupDTO) {
        log.debug("Request to save AnnualLeaveGroup : {}", annualLeaveGroupDTO);
        AnnualLeaveGroup annualLeaveGroup = annualLeaveGroupMapper.toEntity(annualLeaveGroupDTO);
        annualLeaveGroup = annualLeaveGroupRepository.save(annualLeaveGroup);
        return annualLeaveGroupMapper.toDto(annualLeaveGroup);
    }

    /**
     * Get all the annualLeaveGroups.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<AnnualLeaveGroupDTO> findAll(Pageable pageable) {
        log.debug("Request to get all AnnualLeaveGroups");
        return annualLeaveGroupRepository.findAll(pageable)
            .map(annualLeaveGroupMapper::toDto);
    }


    /**
     * Get one annualLeaveGroup by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<AnnualLeaveGroupDTO> findOne(Long id) {
        log.debug("Request to get AnnualLeaveGroup : {}", id);
        return annualLeaveGroupRepository.findById(id)
            .map(annualLeaveGroupMapper::toDto);
    }

    /**
     * Delete the annualLeaveGroup by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete AnnualLeaveGroup : {}", id);
        annualLeaveGroupRepository.deleteById(id);
    }
}
