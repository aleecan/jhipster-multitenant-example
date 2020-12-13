package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.Tolerance;
import com.mikado.multitenant.repository.tenant.ToleranceRepository;
import com.mikado.multitenant.service.dto.tenant.ToleranceDTO;
import com.mikado.multitenant.service.mapper.tenant.ToleranceMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Tolerance}.
 */
@Service
@Transactional
public class ToleranceService {

    private final Logger log = LoggerFactory.getLogger(ToleranceService.class);

    private final ToleranceRepository toleranceRepository;

    private final ToleranceMapper toleranceMapper;

    public ToleranceService(ToleranceRepository toleranceRepository, ToleranceMapper toleranceMapper) {
        this.toleranceRepository = toleranceRepository;
        this.toleranceMapper = toleranceMapper;
    }

    /**
     * Save a tolerance.
     *
     * @param toleranceDTO the entity to save.
     * @return the persisted entity.
     */
    public ToleranceDTO save(ToleranceDTO toleranceDTO) {
        log.debug("Request to save Tolerance : {}", toleranceDTO);
        Tolerance tolerance = toleranceMapper.toEntity(toleranceDTO);
        tolerance = toleranceRepository.save(tolerance);
        return toleranceMapper.toDto(tolerance);
    }

    /**
     * Get all the tolerances.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<ToleranceDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Tolerances");
        return toleranceRepository.findAll(pageable)
            .map(toleranceMapper::toDto);
    }


    /**
     * Get one tolerance by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<ToleranceDTO> findOne(Long id) {
        log.debug("Request to get Tolerance : {}", id);
        return toleranceRepository.findById(id)
            .map(toleranceMapper::toDto);
    }

    /**
     * Delete the tolerance by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Tolerance : {}", id);
        toleranceRepository.deleteById(id);
    }
}
