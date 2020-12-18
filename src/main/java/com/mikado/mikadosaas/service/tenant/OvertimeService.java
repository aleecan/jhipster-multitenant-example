package com.mikado.mikadosaas.service.tenant;

import com.mikado.mikadosaas.domain.tenant.Overtime;
import com.mikado.mikadosaas.repository.tenant.OvertimeRepository;
import com.mikado.mikadosaas.service.dto.tenant.OvertimeDTO;
import com.mikado.mikadosaas.service.mapper.tenant.OvertimeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Overtime}.
 */
@Service
@Transactional
public class OvertimeService {

    private final Logger log = LoggerFactory.getLogger(OvertimeService.class);

    private final OvertimeRepository overtimeRepository;

    private final OvertimeMapper overtimeMapper;

    public OvertimeService(OvertimeRepository overtimeRepository, OvertimeMapper overtimeMapper) {
        this.overtimeRepository = overtimeRepository;
        this.overtimeMapper = overtimeMapper;
    }

    /**
     * Save a overtime.
     *
     * @param overtimeDTO the entity to save.
     * @return the persisted entity.
     */
    public OvertimeDTO save(OvertimeDTO overtimeDTO) {
        log.debug("Request to save Overtime : {}", overtimeDTO);
        Overtime overtime = overtimeMapper.toEntity(overtimeDTO);
        overtime = overtimeRepository.save(overtime);
        return overtimeMapper.toDto(overtime);
    }

    /**
     * Get all the overtimes.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<OvertimeDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Overtimes");
        return overtimeRepository.findAll(pageable)
            .map(overtimeMapper::toDto);
    }


    /**
     * Get one overtime by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<OvertimeDTO> findOne(Long id) {
        log.debug("Request to get Overtime : {}", id);
        return overtimeRepository.findById(id)
            .map(overtimeMapper::toDto);
    }

    /**
     * Delete the overtime by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Overtime : {}", id);
        overtimeRepository.deleteById(id);
    }
}
