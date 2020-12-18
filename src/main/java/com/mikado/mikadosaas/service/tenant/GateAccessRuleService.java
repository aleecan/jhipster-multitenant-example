package com.mikado.mikadosaas.service.tenant;

import com.mikado.mikadosaas.domain.tenant.GateAccessRule;
import com.mikado.mikadosaas.repository.tenant.GateAccessRuleRepository;
import com.mikado.mikadosaas.service.dto.tenant.GateAccessRuleDTO;
import com.mikado.mikadosaas.service.mapper.tenant.GateAccessRuleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link GateAccessRule}.
 */
@Service
@Transactional
public class GateAccessRuleService {

    private final Logger log = LoggerFactory.getLogger(GateAccessRuleService.class);

    private final GateAccessRuleRepository gateAccessRuleRepository;

    private final GateAccessRuleMapper gateAccessRuleMapper;

    public GateAccessRuleService(GateAccessRuleRepository gateAccessRuleRepository, GateAccessRuleMapper gateAccessRuleMapper) {
        this.gateAccessRuleRepository = gateAccessRuleRepository;
        this.gateAccessRuleMapper = gateAccessRuleMapper;
    }

    /**
     * Save a gateAccessRule.
     *
     * @param gateAccessRuleDTO the entity to save.
     * @return the persisted entity.
     */
    public GateAccessRuleDTO save(GateAccessRuleDTO gateAccessRuleDTO) {
        log.debug("Request to save GateAccessRule : {}", gateAccessRuleDTO);
        GateAccessRule gateAccessRule = gateAccessRuleMapper.toEntity(gateAccessRuleDTO);
        gateAccessRule = gateAccessRuleRepository.save(gateAccessRule);
        return gateAccessRuleMapper.toDto(gateAccessRule);
    }

    /**
     * Get all the gateAccessRules.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<GateAccessRuleDTO> findAll(Pageable pageable) {
        log.debug("Request to get all GateAccessRules");
        return gateAccessRuleRepository.findAll(pageable)
            .map(gateAccessRuleMapper::toDto);
    }


    /**
     * Get one gateAccessRule by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<GateAccessRuleDTO> findOne(Long id) {
        log.debug("Request to get GateAccessRule : {}", id);
        return gateAccessRuleRepository.findById(id)
            .map(gateAccessRuleMapper::toDto);
    }

    /**
     * Delete the gateAccessRule by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete GateAccessRule : {}", id);
        gateAccessRuleRepository.deleteById(id);
    }
}
