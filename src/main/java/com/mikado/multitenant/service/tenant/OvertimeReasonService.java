package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.OvertimeReason;
import com.mikado.multitenant.repository.tenant.OvertimeReasonRepository;
import com.mikado.multitenant.service.dto.tenant.OvertimeReasonDTO;
import com.mikado.multitenant.service.mapper.tenant.OvertimeReasonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link OvertimeReason}.
 */
@Service
@Transactional
public class OvertimeReasonService {

    private final Logger log = LoggerFactory.getLogger(OvertimeReasonService.class);

    private final OvertimeReasonRepository overtimeReasonRepository;

    private final OvertimeReasonMapper overtimeReasonMapper;

    public OvertimeReasonService(OvertimeReasonRepository overtimeReasonRepository, OvertimeReasonMapper overtimeReasonMapper) {
        this.overtimeReasonRepository = overtimeReasonRepository;
        this.overtimeReasonMapper = overtimeReasonMapper;
    }

    /**
     * Save a overtimeReason.
     *
     * @param overtimeReasonDTO the entity to save.
     * @return the persisted entity.
     */
    public OvertimeReasonDTO save(OvertimeReasonDTO overtimeReasonDTO) {
        log.debug("Request to save OvertimeReason : {}", overtimeReasonDTO);
        OvertimeReason overtimeReason = overtimeReasonMapper.toEntity(overtimeReasonDTO);
        overtimeReason = overtimeReasonRepository.save(overtimeReason);
        return overtimeReasonMapper.toDto(overtimeReason);
    }

    /**
     * Get all the overtimeReasons.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<OvertimeReasonDTO> findAll(Pageable pageable) {
        log.debug("Request to get all OvertimeReasons");
        return overtimeReasonRepository.findAll(pageable)
            .map(overtimeReasonMapper::toDto);
    }


    /**
     * Get one overtimeReason by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<OvertimeReasonDTO> findOne(Long id) {
        log.debug("Request to get OvertimeReason : {}", id);
        return overtimeReasonRepository.findById(id)
            .map(overtimeReasonMapper::toDto);
    }

    /**
     * Delete the overtimeReason by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete OvertimeReason : {}", id);
        overtimeReasonRepository.deleteById(id);
    }
}
