package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.QuotaType;
import com.mikado.multitenant.repository.tenant.QuotaTypeRepository;
import com.mikado.multitenant.service.dto.tenant.QuotaTypeDTO;
import com.mikado.multitenant.service.mapper.tenant.QuotaTypeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link QuotaType}.
 */
@Service
@Transactional
public class QuotaTypeService {

    private final Logger log = LoggerFactory.getLogger(QuotaTypeService.class);

    private final QuotaTypeRepository quotaTypeRepository;

    private final QuotaTypeMapper quotaTypeMapper;

    public QuotaTypeService(QuotaTypeRepository quotaTypeRepository, QuotaTypeMapper quotaTypeMapper) {
        this.quotaTypeRepository = quotaTypeRepository;
        this.quotaTypeMapper = quotaTypeMapper;
    }

    /**
     * Save a quotaType.
     *
     * @param quotaTypeDTO the entity to save.
     * @return the persisted entity.
     */
    public QuotaTypeDTO save(QuotaTypeDTO quotaTypeDTO) {
        log.debug("Request to save QuotaType : {}", quotaTypeDTO);
        QuotaType quotaType = quotaTypeMapper.toEntity(quotaTypeDTO);
        quotaType = quotaTypeRepository.save(quotaType);
        return quotaTypeMapper.toDto(quotaType);
    }

    /**
     * Get all the quotaTypes.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<QuotaTypeDTO> findAll(Pageable pageable) {
        log.debug("Request to get all QuotaTypes");
        return quotaTypeRepository.findAll(pageable)
            .map(quotaTypeMapper::toDto);
    }


    /**
     * Get one quotaType by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<QuotaTypeDTO> findOne(Long id) {
        log.debug("Request to get QuotaType : {}", id);
        return quotaTypeRepository.findById(id)
            .map(quotaTypeMapper::toDto);
    }

    /**
     * Delete the quotaType by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete QuotaType : {}", id);
        quotaTypeRepository.deleteById(id);
    }
}
