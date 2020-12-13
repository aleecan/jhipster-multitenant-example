package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.ZoneAccessRule;
import com.mikado.multitenant.repository.tenant.ZoneAccessRuleRepository;
import com.mikado.multitenant.service.dto.tenant.ZoneAccessRuleDTO;
import com.mikado.multitenant.service.mapper.tenant.ZoneAccessRuleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link ZoneAccessRule}.
 */
@Service
@Transactional
public class ZoneAccessRuleService {

    private final Logger log = LoggerFactory.getLogger(ZoneAccessRuleService.class);

    private final ZoneAccessRuleRepository zoneAccessRuleRepository;

    private final ZoneAccessRuleMapper zoneAccessRuleMapper;

    public ZoneAccessRuleService(ZoneAccessRuleRepository zoneAccessRuleRepository, ZoneAccessRuleMapper zoneAccessRuleMapper) {
        this.zoneAccessRuleRepository = zoneAccessRuleRepository;
        this.zoneAccessRuleMapper = zoneAccessRuleMapper;
    }

    /**
     * Save a zoneAccessRule.
     *
     * @param zoneAccessRuleDTO the entity to save.
     * @return the persisted entity.
     */
    public ZoneAccessRuleDTO save(ZoneAccessRuleDTO zoneAccessRuleDTO) {
        log.debug("Request to save ZoneAccessRule : {}", zoneAccessRuleDTO);
        ZoneAccessRule zoneAccessRule = zoneAccessRuleMapper.toEntity(zoneAccessRuleDTO);
        zoneAccessRule = zoneAccessRuleRepository.save(zoneAccessRule);
        return zoneAccessRuleMapper.toDto(zoneAccessRule);
    }

    /**
     * Get all the zoneAccessRules.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<ZoneAccessRuleDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ZoneAccessRules");
        return zoneAccessRuleRepository.findAll(pageable)
            .map(zoneAccessRuleMapper::toDto);
    }


    /**
     * Get one zoneAccessRule by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<ZoneAccessRuleDTO> findOne(Long id) {
        log.debug("Request to get ZoneAccessRule : {}", id);
        return zoneAccessRuleRepository.findById(id)
            .map(zoneAccessRuleMapper::toDto);
    }

    /**
     * Delete the zoneAccessRule by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete ZoneAccessRule : {}", id);
        zoneAccessRuleRepository.deleteById(id);
    }
}
