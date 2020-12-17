package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.GroupCode;
import com.mikado.multitenant.repository.tenant.GroupCodeRepository;
import com.mikado.multitenant.service.dto.tenant.GroupCodeDTO;
import com.mikado.multitenant.service.mapper.tenant.GroupCodeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link GroupCode}.
 */
@Service
@Transactional
public class GroupCodeService {

    private final Logger log = LoggerFactory.getLogger(GroupCodeService.class);

    private final GroupCodeRepository groupCodeRepository;

    private final GroupCodeMapper groupCodeMapper;

    public GroupCodeService(GroupCodeRepository groupCodeRepository, GroupCodeMapper groupCodeMapper) {
        this.groupCodeRepository = groupCodeRepository;
        this.groupCodeMapper = groupCodeMapper;
    }

    /**
     * Save a groupCode.
     *
     * @param groupCodeDTO the entity to save.
     * @return the persisted entity.
     */
    public GroupCodeDTO save(GroupCodeDTO groupCodeDTO) {
        log.debug("Request to save GroupCode : {}", groupCodeDTO);
        GroupCode groupCode = groupCodeMapper.toEntity(groupCodeDTO);
        groupCode = groupCodeRepository.save(groupCode);
        return groupCodeMapper.toDto(groupCode);
    }

    /**
     * Get all the groupCodes.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<GroupCodeDTO> findAll(Pageable pageable) {
        log.debug("Request to get all GroupCodes");
        return groupCodeRepository.findAll(pageable)
            .map(groupCodeMapper::toDto);
    }


    /**
     * Get one groupCode by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<GroupCodeDTO> findOne(Long id) {
        log.debug("Request to get GroupCode : {}", id);
        return groupCodeRepository.findById(id)
            .map(groupCodeMapper::toDto);
    }

    /**
     * Delete the groupCode by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete GroupCode : {}", id);
        groupCodeRepository.deleteById(id);
    }
}
