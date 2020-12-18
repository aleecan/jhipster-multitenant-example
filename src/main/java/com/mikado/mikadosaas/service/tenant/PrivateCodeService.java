package com.mikado.mikadosaas.service.tenant;

import com.mikado.mikadosaas.domain.tenant.PrivateCode;
import com.mikado.mikadosaas.repository.tenant.PrivateCodeRepository;
import com.mikado.mikadosaas.service.dto.tenant.PrivateCodeDTO;
import com.mikado.mikadosaas.service.mapper.tenant.PrivateCodeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link PrivateCode}.
 */
@Service
@Transactional
public class PrivateCodeService {

    private final Logger log = LoggerFactory.getLogger(PrivateCodeService.class);

    private final PrivateCodeRepository privateCodeRepository;

    private final PrivateCodeMapper privateCodeMapper;

    public PrivateCodeService(PrivateCodeRepository privateCodeRepository, PrivateCodeMapper privateCodeMapper) {
        this.privateCodeRepository = privateCodeRepository;
        this.privateCodeMapper = privateCodeMapper;
    }

    /**
     * Save a privateCode.
     *
     * @param privateCodeDTO the entity to save.
     * @return the persisted entity.
     */
    public PrivateCodeDTO save(PrivateCodeDTO privateCodeDTO) {
        log.debug("Request to save PrivateCode : {}", privateCodeDTO);
        PrivateCode privateCode = privateCodeMapper.toEntity(privateCodeDTO);
        privateCode = privateCodeRepository.save(privateCode);
        return privateCodeMapper.toDto(privateCode);
    }

    /**
     * Get all the privateCodes.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<PrivateCodeDTO> findAll(Pageable pageable) {
        log.debug("Request to get all PrivateCodes");
        return privateCodeRepository.findAll(pageable)
            .map(privateCodeMapper::toDto);
    }


    /**
     * Get one privateCode by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<PrivateCodeDTO> findOne(Long id) {
        log.debug("Request to get PrivateCode : {}", id);
        return privateCodeRepository.findById(id)
            .map(privateCodeMapper::toDto);
    }

    /**
     * Delete the privateCode by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete PrivateCode : {}", id);
        privateCodeRepository.deleteById(id);
    }
}
