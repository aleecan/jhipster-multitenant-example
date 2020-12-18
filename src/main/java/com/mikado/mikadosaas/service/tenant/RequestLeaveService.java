package com.mikado.mikadosaas.service.tenant;

import com.mikado.mikadosaas.domain.tenant.RequestLeave;
import com.mikado.mikadosaas.repository.tenant.RequestLeaveRepository;
import com.mikado.mikadosaas.service.dto.tenant.RequestLeaveDTO;
import com.mikado.mikadosaas.service.mapper.tenant.RequestLeaveMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link RequestLeave}.
 */
@Service
@Transactional
public class RequestLeaveService {

    private final Logger log = LoggerFactory.getLogger(RequestLeaveService.class);

    private final RequestLeaveRepository requestLeaveRepository;

    private final RequestLeaveMapper requestLeaveMapper;

    public RequestLeaveService(RequestLeaveRepository requestLeaveRepository, RequestLeaveMapper requestLeaveMapper) {
        this.requestLeaveRepository = requestLeaveRepository;
        this.requestLeaveMapper = requestLeaveMapper;
    }

    /**
     * Save a requestLeave.
     *
     * @param requestLeaveDTO the entity to save.
     * @return the persisted entity.
     */
    public RequestLeaveDTO save(RequestLeaveDTO requestLeaveDTO) {
        log.debug("Request to save RequestLeave : {}", requestLeaveDTO);
        RequestLeave requestLeave = requestLeaveMapper.toEntity(requestLeaveDTO);
        requestLeave = requestLeaveRepository.save(requestLeave);
        return requestLeaveMapper.toDto(requestLeave);
    }

    /**
     * Get all the requestLeaves.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<RequestLeaveDTO> findAll(Pageable pageable) {
        log.debug("Request to get all RequestLeaves");
        return requestLeaveRepository.findAll(pageable)
            .map(requestLeaveMapper::toDto);
    }


    /**
     * Get one requestLeave by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<RequestLeaveDTO> findOne(Long id) {
        log.debug("Request to get RequestLeave : {}", id);
        return requestLeaveRepository.findById(id)
            .map(requestLeaveMapper::toDto);
    }

    /**
     * Delete the requestLeave by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete RequestLeave : {}", id);
        requestLeaveRepository.deleteById(id);
    }
}
