package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.ApproverCompanyFirm;
import com.mikado.multitenant.repository.tenant.ApproverCompanyFirmRepository;
import com.mikado.multitenant.service.dto.tenant.ApproverCompanyFirmDTO;
import com.mikado.multitenant.service.mapper.tenant.ApproverCompanyFirmMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link ApproverCompanyFirm}.
 */
@Service
@Transactional
public class ApproverCompanyFirmService {

    private final Logger log = LoggerFactory.getLogger(ApproverCompanyFirmService.class);

    private final ApproverCompanyFirmRepository approverCompanyFirmRepository;

    private final ApproverCompanyFirmMapper approverCompanyFirmMapper;

    public ApproverCompanyFirmService(ApproverCompanyFirmRepository approverCompanyFirmRepository, ApproverCompanyFirmMapper approverCompanyFirmMapper) {
        this.approverCompanyFirmRepository = approverCompanyFirmRepository;
        this.approverCompanyFirmMapper = approverCompanyFirmMapper;
    }

    /**
     * Save a approverCompanyFirm.
     *
     * @param approverCompanyFirmDTO the entity to save.
     * @return the persisted entity.
     */
    public ApproverCompanyFirmDTO save(ApproverCompanyFirmDTO approverCompanyFirmDTO) {
        log.debug("Request to save ApproverCompanyFirm : {}", approverCompanyFirmDTO);
        ApproverCompanyFirm approverCompanyFirm = approverCompanyFirmMapper.toEntity(approverCompanyFirmDTO);
        approverCompanyFirm = approverCompanyFirmRepository.save(approverCompanyFirm);
        return approverCompanyFirmMapper.toDto(approverCompanyFirm);
    }

    /**
     * Get all the approverCompanyFirms.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<ApproverCompanyFirmDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ApproverCompanyFirms");
        return approverCompanyFirmRepository.findAll(pageable)
            .map(approverCompanyFirmMapper::toDto);
    }


    /**
     * Get one approverCompanyFirm by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<ApproverCompanyFirmDTO> findOne(Long id) {
        log.debug("Request to get ApproverCompanyFirm : {}", id);
        return approverCompanyFirmRepository.findById(id)
            .map(approverCompanyFirmMapper::toDto);
    }

    /**
     * Delete the approverCompanyFirm by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete ApproverCompanyFirm : {}", id);
        approverCompanyFirmRepository.deleteById(id);
    }
}
