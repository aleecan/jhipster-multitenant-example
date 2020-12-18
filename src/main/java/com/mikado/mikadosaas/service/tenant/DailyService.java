package com.mikado.mikadosaas.service.tenant;

import com.mikado.mikadosaas.domain.tenant.Daily;
import com.mikado.mikadosaas.repository.tenant.DailyRepository;
import com.mikado.mikadosaas.service.dto.tenant.DailyDTO;
import com.mikado.mikadosaas.service.mapper.tenant.DailyMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Daily}.
 */
@Service
@Transactional
public class DailyService {

    private final Logger log = LoggerFactory.getLogger(DailyService.class);

    private final DailyRepository dailyRepository;

    private final DailyMapper dailyMapper;

    public DailyService(DailyRepository dailyRepository, DailyMapper dailyMapper) {
        this.dailyRepository = dailyRepository;
        this.dailyMapper = dailyMapper;
    }

    /**
     * Save a daily.
     *
     * @param dailyDTO the entity to save.
     * @return the persisted entity.
     */
    public DailyDTO save(DailyDTO dailyDTO) {
        log.debug("Request to save Daily : {}", dailyDTO);
        Daily daily = dailyMapper.toEntity(dailyDTO);
        daily = dailyRepository.save(daily);
        return dailyMapper.toDto(daily);
    }

    /**
     * Get all the dailies.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<DailyDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Dailies");
        return dailyRepository.findAll(pageable)
            .map(dailyMapper::toDto);
    }


    /**
     * Get one daily by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<DailyDTO> findOne(Long id) {
        log.debug("Request to get Daily : {}", id);
        return dailyRepository.findById(id)
            .map(dailyMapper::toDto);
    }

    /**
     * Delete the daily by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Daily : {}", id);
        dailyRepository.deleteById(id);
    }
}
