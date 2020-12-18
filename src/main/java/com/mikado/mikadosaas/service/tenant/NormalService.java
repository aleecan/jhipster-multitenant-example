package com.mikado.mikadosaas.service.tenant;

import com.mikado.mikadosaas.domain.tenant.Normal;
import com.mikado.mikadosaas.repository.tenant.NormalRepository;
import com.mikado.mikadosaas.service.dto.tenant.NormalDTO;
import com.mikado.mikadosaas.service.mapper.tenant.NormalMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Normal}.
 */
@Service
@Transactional
public class NormalService {

    private final Logger log = LoggerFactory.getLogger(NormalService.class);

    private final NormalRepository normalRepository;

    private final NormalMapper normalMapper;

    public NormalService(NormalRepository normalRepository, NormalMapper normalMapper) {
        this.normalRepository = normalRepository;
        this.normalMapper = normalMapper;
    }

    /**
     * Save a normal.
     *
     * @param normalDTO the entity to save.
     * @return the persisted entity.
     */
    public NormalDTO save(NormalDTO normalDTO) {
        log.debug("Request to save Normal : {}", normalDTO);
        Normal normal = normalMapper.toEntity(normalDTO);
        normal = normalRepository.save(normal);
        return normalMapper.toDto(normal);
    }

    /**
     * Get all the normals.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<NormalDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Normals");
        return normalRepository.findAll(pageable)
            .map(normalMapper::toDto);
    }


    /**
     * Get one normal by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<NormalDTO> findOne(Long id) {
        log.debug("Request to get Normal : {}", id);
        return normalRepository.findById(id)
            .map(normalMapper::toDto);
    }

    /**
     * Delete the normal by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Normal : {}", id);
        normalRepository.deleteById(id);
    }
}
