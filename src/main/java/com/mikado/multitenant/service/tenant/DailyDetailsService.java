package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.DailyDetails;
import com.mikado.multitenant.repository.tenant.DailyDetailsRepository;
import com.mikado.multitenant.service.dto.tenant.DailyDetailsDTO;
import com.mikado.multitenant.service.mapper.tenant.DailyDetailsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link DailyDetails}.
 */
@Service
@Transactional
public class DailyDetailsService {

    private final Logger log = LoggerFactory.getLogger(DailyDetailsService.class);

    private final DailyDetailsRepository dailyDetailsRepository;

    private final DailyDetailsMapper dailyDetailsMapper;

    public DailyDetailsService(DailyDetailsRepository dailyDetailsRepository, DailyDetailsMapper dailyDetailsMapper) {
        this.dailyDetailsRepository = dailyDetailsRepository;
        this.dailyDetailsMapper = dailyDetailsMapper;
    }

    /**
     * Save a dailyDetails.
     *
     * @param dailyDetailsDTO the entity to save.
     * @return the persisted entity.
     */
    public DailyDetailsDTO save(DailyDetailsDTO dailyDetailsDTO) {
        log.debug("Request to save DailyDetails : {}", dailyDetailsDTO);
        DailyDetails dailyDetails = dailyDetailsMapper.toEntity(dailyDetailsDTO);
        dailyDetails = dailyDetailsRepository.save(dailyDetails);
        return dailyDetailsMapper.toDto(dailyDetails);
    }

    /**
     * Get all the dailyDetails.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<DailyDetailsDTO> findAll(Pageable pageable) {
        log.debug("Request to get all DailyDetails");
        return dailyDetailsRepository.findAll(pageable)
            .map(dailyDetailsMapper::toDto);
    }


    /**
     * Get one dailyDetails by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<DailyDetailsDTO> findOne(Long id) {
        log.debug("Request to get DailyDetails : {}", id);
        return dailyDetailsRepository.findById(id)
            .map(dailyDetailsMapper::toDto);
    }

    /**
     * Delete the dailyDetails by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete DailyDetails : {}", id);
        dailyDetailsRepository.deleteById(id);
    }
}
