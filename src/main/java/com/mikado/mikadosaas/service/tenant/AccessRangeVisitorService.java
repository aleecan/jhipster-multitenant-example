package com.mikado.mikadosaas.service.tenant;

import com.mikado.mikadosaas.domain.tenant.AccessRangeVisitor;
import com.mikado.mikadosaas.repository.tenant.AccessRangeVisitorRepository;
import com.mikado.mikadosaas.service.dto.tenant.AccessRangeVisitorDTO;
import com.mikado.mikadosaas.service.mapper.tenant.AccessRangeVisitorMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link AccessRangeVisitor}.
 */
@Service
@Transactional
public class AccessRangeVisitorService {

    private final Logger log = LoggerFactory.getLogger(AccessRangeVisitorService.class);

    private final AccessRangeVisitorRepository accessRangeVisitorRepository;

    private final AccessRangeVisitorMapper accessRangeVisitorMapper;

    public AccessRangeVisitorService(AccessRangeVisitorRepository accessRangeVisitorRepository, AccessRangeVisitorMapper accessRangeVisitorMapper) {
        this.accessRangeVisitorRepository = accessRangeVisitorRepository;
        this.accessRangeVisitorMapper = accessRangeVisitorMapper;
    }

    /**
     * Save a accessRangeVisitor.
     *
     * @param accessRangeVisitorDTO the entity to save.
     * @return the persisted entity.
     */
    public AccessRangeVisitorDTO save(AccessRangeVisitorDTO accessRangeVisitorDTO) {
        log.debug("Request to save AccessRangeVisitor : {}", accessRangeVisitorDTO);
        AccessRangeVisitor accessRangeVisitor = accessRangeVisitorMapper.toEntity(accessRangeVisitorDTO);
        accessRangeVisitor = accessRangeVisitorRepository.save(accessRangeVisitor);
        return accessRangeVisitorMapper.toDto(accessRangeVisitor);
    }

    /**
     * Get all the accessRangeVisitors.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<AccessRangeVisitorDTO> findAll(Pageable pageable) {
        log.debug("Request to get all AccessRangeVisitors");
        return accessRangeVisitorRepository.findAll(pageable)
            .map(accessRangeVisitorMapper::toDto);
    }


    /**
     * Get one accessRangeVisitor by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<AccessRangeVisitorDTO> findOne(Long id) {
        log.debug("Request to get AccessRangeVisitor : {}", id);
        return accessRangeVisitorRepository.findById(id)
            .map(accessRangeVisitorMapper::toDto);
    }

    /**
     * Delete the accessRangeVisitor by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete AccessRangeVisitor : {}", id);
        accessRangeVisitorRepository.deleteById(id);
    }
}
