package com.mikado.mikadosaas.service.tenant;

import com.mikado.mikadosaas.domain.tenant.AccessLog;
import com.mikado.mikadosaas.repository.tenant.AccessLogRepository;
import com.mikado.mikadosaas.service.dto.tenant.AccessLogDTO;
import com.mikado.mikadosaas.service.mapper.tenant.AccessLogMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link AccessLog}.
 */
@Service
@Transactional
public class AccessLogService {

    private final Logger log = LoggerFactory.getLogger(AccessLogService.class);

    private final AccessLogRepository accessLogRepository;

    private final AccessLogMapper accessLogMapper;

    public AccessLogService(AccessLogRepository accessLogRepository, AccessLogMapper accessLogMapper) {
        this.accessLogRepository = accessLogRepository;
        this.accessLogMapper = accessLogMapper;
    }

    /**
     * Save a accessLog.
     *
     * @param accessLogDTO the entity to save.
     * @return the persisted entity.
     */
    public AccessLogDTO save(AccessLogDTO accessLogDTO) {
        log.debug("Request to save AccessLog : {}", accessLogDTO);
        AccessLog accessLog = accessLogMapper.toEntity(accessLogDTO);
        accessLog = accessLogRepository.save(accessLog);
        return accessLogMapper.toDto(accessLog);
    }

    /**
     * Get all the accessLogs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<AccessLogDTO> findAll(Pageable pageable) {
        log.debug("Request to get all AccessLogs");
        return accessLogRepository.findAll(pageable)
            .map(accessLogMapper::toDto);
    }


    /**
     * Get one accessLog by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<AccessLogDTO> findOne(Long id) {
        log.debug("Request to get AccessLog : {}", id);
        return accessLogRepository.findById(id)
            .map(accessLogMapper::toDto);
    }

    /**
     * Delete the accessLog by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete AccessLog : {}", id);
        accessLogRepository.deleteById(id);
    }
}
