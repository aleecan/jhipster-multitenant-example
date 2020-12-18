package com.mikado.mikadosaas.service.tenant;

import com.mikado.mikadosaas.domain.tenant.MonthlySum;
import com.mikado.mikadosaas.repository.tenant.MonthlySumRepository;
import com.mikado.mikadosaas.service.dto.tenant.MonthlySumDTO;
import com.mikado.mikadosaas.service.mapper.tenant.MonthlySumMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link MonthlySum}.
 */
@Service
@Transactional
public class MonthlySumService {

    private final Logger log = LoggerFactory.getLogger(MonthlySumService.class);

    private final MonthlySumRepository monthlySumRepository;

    private final MonthlySumMapper monthlySumMapper;

    public MonthlySumService(MonthlySumRepository monthlySumRepository, MonthlySumMapper monthlySumMapper) {
        this.monthlySumRepository = monthlySumRepository;
        this.monthlySumMapper = monthlySumMapper;
    }

    /**
     * Save a monthlySum.
     *
     * @param monthlySumDTO the entity to save.
     * @return the persisted entity.
     */
    public MonthlySumDTO save(MonthlySumDTO monthlySumDTO) {
        log.debug("Request to save MonthlySum : {}", monthlySumDTO);
        MonthlySum monthlySum = monthlySumMapper.toEntity(monthlySumDTO);
        monthlySum = monthlySumRepository.save(monthlySum);
        return monthlySumMapper.toDto(monthlySum);
    }

    /**
     * Get all the monthlySums.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<MonthlySumDTO> findAll(Pageable pageable) {
        log.debug("Request to get all MonthlySums");
        return monthlySumRepository.findAll(pageable)
            .map(monthlySumMapper::toDto);
    }


    /**
     * Get one monthlySum by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<MonthlySumDTO> findOne(Long id) {
        log.debug("Request to get MonthlySum : {}", id);
        return monthlySumRepository.findById(id)
            .map(monthlySumMapper::toDto);
    }

    /**
     * Delete the monthlySum by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete MonthlySum : {}", id);
        monthlySumRepository.deleteById(id);
    }
}
