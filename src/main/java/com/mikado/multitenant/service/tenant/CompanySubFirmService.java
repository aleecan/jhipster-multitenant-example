package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.CompanySubFirm;
import com.mikado.multitenant.repository.tenant.CompanySubFirmRepository;
import com.mikado.multitenant.service.dto.tenant.CompanySubFirmDTO;
import com.mikado.multitenant.service.mapper.tenant.CompanySubFirmMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link CompanySubFirm}.
 */
@Service
@Transactional
public class CompanySubFirmService {

    private final Logger log = LoggerFactory.getLogger(CompanySubFirmService.class);

    private final CompanySubFirmRepository companySubFirmRepository;

    private final CompanySubFirmMapper companySubFirmMapper;

    public CompanySubFirmService(CompanySubFirmRepository companySubFirmRepository, CompanySubFirmMapper companySubFirmMapper) {
        this.companySubFirmRepository = companySubFirmRepository;
        this.companySubFirmMapper = companySubFirmMapper;
    }

    /**
     * Save a companySubFirm.
     *
     * @param companySubFirmDTO the entity to save.
     * @return the persisted entity.
     */
    public CompanySubFirmDTO save(CompanySubFirmDTO companySubFirmDTO) {
        log.debug("Request to save CompanySubFirm : {}", companySubFirmDTO);
        CompanySubFirm companySubFirm = companySubFirmMapper.toEntity(companySubFirmDTO);
        companySubFirm = companySubFirmRepository.save(companySubFirm);
        return companySubFirmMapper.toDto(companySubFirm);
    }

    /**
     * Get all the companySubFirms.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<CompanySubFirmDTO> findAll(Pageable pageable) {
        log.debug("Request to get all CompanySubFirms");
        return companySubFirmRepository.findAll(pageable)
            .map(companySubFirmMapper::toDto);
    }


    /**
     * Get one companySubFirm by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<CompanySubFirmDTO> findOne(Long id) {
        log.debug("Request to get CompanySubFirm : {}", id);
        return companySubFirmRepository.findById(id)
            .map(companySubFirmMapper::toDto);
    }

    /**
     * Delete the companySubFirm by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete CompanySubFirm : {}", id);
        companySubFirmRepository.deleteById(id);
    }
}
