package com.mikado.mikadosaas.service.tenant;

import com.mikado.mikadosaas.domain.tenant.WeeklyDetails;
import com.mikado.mikadosaas.repository.tenant.WeeklyDetailsRepository;
import com.mikado.mikadosaas.service.dto.tenant.WeeklyDetailsDTO;
import com.mikado.mikadosaas.service.mapper.tenant.WeeklyDetailsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link WeeklyDetails}.
 */
@Service
@Transactional
public class WeeklyDetailsService {

    private final Logger log = LoggerFactory.getLogger(WeeklyDetailsService.class);

    private final WeeklyDetailsRepository weeklyDetailsRepository;

    private final WeeklyDetailsMapper weeklyDetailsMapper;

    public WeeklyDetailsService(WeeklyDetailsRepository weeklyDetailsRepository, WeeklyDetailsMapper weeklyDetailsMapper) {
        this.weeklyDetailsRepository = weeklyDetailsRepository;
        this.weeklyDetailsMapper = weeklyDetailsMapper;
    }

    /**
     * Save a weeklyDetails.
     *
     * @param weeklyDetailsDTO the entity to save.
     * @return the persisted entity.
     */
    public WeeklyDetailsDTO save(WeeklyDetailsDTO weeklyDetailsDTO) {
        log.debug("Request to save WeeklyDetails : {}", weeklyDetailsDTO);
        WeeklyDetails weeklyDetails = weeklyDetailsMapper.toEntity(weeklyDetailsDTO);
        weeklyDetails = weeklyDetailsRepository.save(weeklyDetails);
        return weeklyDetailsMapper.toDto(weeklyDetails);
    }

    /**
     * Get all the weeklyDetails.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<WeeklyDetailsDTO> findAll(Pageable pageable) {
        log.debug("Request to get all WeeklyDetails");
        return weeklyDetailsRepository.findAll(pageable)
            .map(weeklyDetailsMapper::toDto);
    }


    /**
     * Get one weeklyDetails by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<WeeklyDetailsDTO> findOne(Long id) {
        log.debug("Request to get WeeklyDetails : {}", id);
        return weeklyDetailsRepository.findById(id)
            .map(weeklyDetailsMapper::toDto);
    }

    /**
     * Delete the weeklyDetails by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete WeeklyDetails : {}", id);
        weeklyDetailsRepository.deleteById(id);
    }
}
