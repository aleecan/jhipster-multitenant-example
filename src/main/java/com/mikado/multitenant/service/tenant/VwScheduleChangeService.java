package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.VwScheduleChange;
import com.mikado.multitenant.repository.tenant.VwScheduleChangeRepository;
import com.mikado.multitenant.service.dto.tenant.VwScheduleChangeDTO;
import com.mikado.multitenant.service.mapper.tenant.VwScheduleChangeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link VwScheduleChange}.
 */
@Service
@Transactional
public class VwScheduleChangeService {

    private final Logger log = LoggerFactory.getLogger(VwScheduleChangeService.class);

    private final VwScheduleChangeRepository vwScheduleChangeRepository;

    private final VwScheduleChangeMapper vwScheduleChangeMapper;

    public VwScheduleChangeService(VwScheduleChangeRepository vwScheduleChangeRepository, VwScheduleChangeMapper vwScheduleChangeMapper) {
        this.vwScheduleChangeRepository = vwScheduleChangeRepository;
        this.vwScheduleChangeMapper = vwScheduleChangeMapper;
    }

    /**
     * Save a vwScheduleChange.
     *
     * @param vwScheduleChangeDTO the entity to save.
     * @return the persisted entity.
     */
    public VwScheduleChangeDTO save(VwScheduleChangeDTO vwScheduleChangeDTO) {
        log.debug("Request to save VwScheduleChange : {}", vwScheduleChangeDTO);
        VwScheduleChange vwScheduleChange = vwScheduleChangeMapper.toEntity(vwScheduleChangeDTO);
        vwScheduleChange = vwScheduleChangeRepository.save(vwScheduleChange);
        return vwScheduleChangeMapper.toDto(vwScheduleChange);
    }

    /**
     * Get all the vwScheduleChanges.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<VwScheduleChangeDTO> findAll(Pageable pageable) {
        log.debug("Request to get all VwScheduleChanges");
        return vwScheduleChangeRepository.findAll(pageable)
            .map(vwScheduleChangeMapper::toDto);
    }


    /**
     * Get one vwScheduleChange by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<VwScheduleChangeDTO> findOne(Long id) {
        log.debug("Request to get VwScheduleChange : {}", id);
        return vwScheduleChangeRepository.findById(id)
            .map(vwScheduleChangeMapper::toDto);
    }

    /**
     * Delete the vwScheduleChange by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete VwScheduleChange : {}", id);
        vwScheduleChangeRepository.deleteById(id);
    }
}
