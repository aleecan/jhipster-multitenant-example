package com.mikado.mikadosaas.service.tenant;

import com.mikado.mikadosaas.domain.tenant.VisitReason;
import com.mikado.mikadosaas.repository.tenant.VisitReasonRepository;
import com.mikado.mikadosaas.service.dto.tenant.VisitReasonDTO;
import com.mikado.mikadosaas.service.mapper.tenant.VisitReasonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link VisitReason}.
 */
@Service
@Transactional
public class VisitReasonService {

    private final Logger log = LoggerFactory.getLogger(VisitReasonService.class);

    private final VisitReasonRepository visitReasonRepository;

    private final VisitReasonMapper visitReasonMapper;

    public VisitReasonService(VisitReasonRepository visitReasonRepository, VisitReasonMapper visitReasonMapper) {
        this.visitReasonRepository = visitReasonRepository;
        this.visitReasonMapper = visitReasonMapper;
    }

    /**
     * Save a visitReason.
     *
     * @param visitReasonDTO the entity to save.
     * @return the persisted entity.
     */
    public VisitReasonDTO save(VisitReasonDTO visitReasonDTO) {
        log.debug("Request to save VisitReason : {}", visitReasonDTO);
        VisitReason visitReason = visitReasonMapper.toEntity(visitReasonDTO);
        visitReason = visitReasonRepository.save(visitReason);
        return visitReasonMapper.toDto(visitReason);
    }

    /**
     * Get all the visitReasons.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<VisitReasonDTO> findAll(Pageable pageable) {
        log.debug("Request to get all VisitReasons");
        return visitReasonRepository.findAll(pageable)
            .map(visitReasonMapper::toDto);
    }


    /**
     * Get one visitReason by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<VisitReasonDTO> findOne(Long id) {
        log.debug("Request to get VisitReason : {}", id);
        return visitReasonRepository.findById(id)
            .map(visitReasonMapper::toDto);
    }

    /**
     * Delete the visitReason by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete VisitReason : {}", id);
        visitReasonRepository.deleteById(id);
    }
}
