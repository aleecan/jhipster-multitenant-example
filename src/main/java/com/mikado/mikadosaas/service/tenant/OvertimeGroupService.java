package com.mikado.mikadosaas.service.tenant;

import com.mikado.mikadosaas.domain.tenant.OvertimeGroup;
import com.mikado.mikadosaas.repository.tenant.OvertimeGroupRepository;
import com.mikado.mikadosaas.service.dto.tenant.OvertimeGroupDTO;
import com.mikado.mikadosaas.service.mapper.tenant.OvertimeGroupMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link OvertimeGroup}.
 */
@Service
@Transactional
public class OvertimeGroupService {

    private final Logger log = LoggerFactory.getLogger(OvertimeGroupService.class);

    private final OvertimeGroupRepository overtimeGroupRepository;

    private final OvertimeGroupMapper overtimeGroupMapper;

    public OvertimeGroupService(OvertimeGroupRepository overtimeGroupRepository, OvertimeGroupMapper overtimeGroupMapper) {
        this.overtimeGroupRepository = overtimeGroupRepository;
        this.overtimeGroupMapper = overtimeGroupMapper;
    }

    /**
     * Save a overtimeGroup.
     *
     * @param overtimeGroupDTO the entity to save.
     * @return the persisted entity.
     */
    public OvertimeGroupDTO save(OvertimeGroupDTO overtimeGroupDTO) {
        log.debug("Request to save OvertimeGroup : {}", overtimeGroupDTO);
        OvertimeGroup overtimeGroup = overtimeGroupMapper.toEntity(overtimeGroupDTO);
        overtimeGroup = overtimeGroupRepository.save(overtimeGroup);
        return overtimeGroupMapper.toDto(overtimeGroup);
    }

    /**
     * Get all the overtimeGroups.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<OvertimeGroupDTO> findAll(Pageable pageable) {
        log.debug("Request to get all OvertimeGroups");
        return overtimeGroupRepository.findAll(pageable)
            .map(overtimeGroupMapper::toDto);
    }


    /**
     * Get one overtimeGroup by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<OvertimeGroupDTO> findOne(Long id) {
        log.debug("Request to get OvertimeGroup : {}", id);
        return overtimeGroupRepository.findById(id)
            .map(overtimeGroupMapper::toDto);
    }

    /**
     * Delete the overtimeGroup by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete OvertimeGroup : {}", id);
        overtimeGroupRepository.deleteById(id);
    }
}
