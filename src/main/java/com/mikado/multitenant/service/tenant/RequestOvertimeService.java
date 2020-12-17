package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.RequestOvertime;
import com.mikado.multitenant.repository.tenant.RequestOvertimeRepository;
import com.mikado.multitenant.service.dto.tenant.RequestOvertimeDTO;
import com.mikado.multitenant.service.mapper.tenant.RequestOvertimeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link RequestOvertime}.
 */
@Service
@Transactional
public class RequestOvertimeService {

    private final Logger log = LoggerFactory.getLogger(RequestOvertimeService.class);

    private final RequestOvertimeRepository requestOvertimeRepository;

    private final RequestOvertimeMapper requestOvertimeMapper;

    public RequestOvertimeService(RequestOvertimeRepository requestOvertimeRepository, RequestOvertimeMapper requestOvertimeMapper) {
        this.requestOvertimeRepository = requestOvertimeRepository;
        this.requestOvertimeMapper = requestOvertimeMapper;
    }

    /**
     * Save a requestOvertime.
     *
     * @param requestOvertimeDTO the entity to save.
     * @return the persisted entity.
     */
    public RequestOvertimeDTO save(RequestOvertimeDTO requestOvertimeDTO) {
        log.debug("Request to save RequestOvertime : {}", requestOvertimeDTO);
        RequestOvertime requestOvertime = requestOvertimeMapper.toEntity(requestOvertimeDTO);
        requestOvertime = requestOvertimeRepository.save(requestOvertime);
        return requestOvertimeMapper.toDto(requestOvertime);
    }

    /**
     * Get all the requestOvertimes.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<RequestOvertimeDTO> findAll(Pageable pageable) {
        log.debug("Request to get all RequestOvertimes");
        return requestOvertimeRepository.findAll(pageable)
            .map(requestOvertimeMapper::toDto);
    }


    /**
     * Get one requestOvertime by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<RequestOvertimeDTO> findOne(Long id) {
        log.debug("Request to get RequestOvertime : {}", id);
        return requestOvertimeRepository.findById(id)
            .map(requestOvertimeMapper::toDto);
    }

    /**
     * Delete the requestOvertime by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete RequestOvertime : {}", id);
        requestOvertimeRepository.deleteById(id);
    }
}
