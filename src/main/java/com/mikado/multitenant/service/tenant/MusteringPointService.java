package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.MusteringPoint;
import com.mikado.multitenant.repository.tenant.MusteringPointRepository;
import com.mikado.multitenant.service.dto.tenant.MusteringPointDTO;
import com.mikado.multitenant.service.mapper.tenant.MusteringPointMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link MusteringPoint}.
 */
@Service
@Transactional
public class MusteringPointService {

    private final Logger log = LoggerFactory.getLogger(MusteringPointService.class);

    private final MusteringPointRepository musteringPointRepository;

    private final MusteringPointMapper musteringPointMapper;

    public MusteringPointService(MusteringPointRepository musteringPointRepository, MusteringPointMapper musteringPointMapper) {
        this.musteringPointRepository = musteringPointRepository;
        this.musteringPointMapper = musteringPointMapper;
    }

    /**
     * Save a musteringPoint.
     *
     * @param musteringPointDTO the entity to save.
     * @return the persisted entity.
     */
    public MusteringPointDTO save(MusteringPointDTO musteringPointDTO) {
        log.debug("Request to save MusteringPoint : {}", musteringPointDTO);
        MusteringPoint musteringPoint = musteringPointMapper.toEntity(musteringPointDTO);
        musteringPoint = musteringPointRepository.save(musteringPoint);
        return musteringPointMapper.toDto(musteringPoint);
    }

    /**
     * Get all the musteringPoints.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<MusteringPointDTO> findAll(Pageable pageable) {
        log.debug("Request to get all MusteringPoints");
        return musteringPointRepository.findAll(pageable)
            .map(musteringPointMapper::toDto);
    }


    /**
     * Get one musteringPoint by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<MusteringPointDTO> findOne(Long id) {
        log.debug("Request to get MusteringPoint : {}", id);
        return musteringPointRepository.findById(id)
            .map(musteringPointMapper::toDto);
    }

    /**
     * Delete the musteringPoint by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete MusteringPoint : {}", id);
        musteringPointRepository.deleteById(id);
    }
}
