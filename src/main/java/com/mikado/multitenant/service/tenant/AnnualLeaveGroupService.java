package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.AnnualLeaveGroup;
import com.mikado.multitenant.domain.tenant.QAnnualLeaveGroup;
import com.mikado.multitenant.repository.tenant.AnnualLeaveGroupRepository;
import com.querydsl.core.BooleanBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnualLeaveGroupService {

    private AnnualLeaveGroupRepository annualLeaveGroupRepository;

    public AnnualLeaveGroupService(AnnualLeaveGroupRepository annualLeaveGroupRepository) {
        this.annualLeaveGroupRepository = annualLeaveGroupRepository;
    }

    public AnnualLeaveGroup findById(Long id) {
        return annualLeaveGroupRepository.findOne(id);
    }

    public AnnualLeaveGroup save(AnnualLeaveGroup annualLeaveGroup) {
        annualLeaveGroup = annualLeaveGroupRepository.save(annualLeaveGroup);
        return annualLeaveGroup;
    }

    public Page<AnnualLeaveGroup> findAll(BooleanBuilder booleanBuilder, PageRequest pageRequest) {
        Page<AnnualLeaveGroup> page = null;
        if (booleanBuilder != null) {
            page = annualLeaveGroupRepository.findAll(booleanBuilder, pageRequest);
        } else {
            page = annualLeaveGroupRepository.findAll(pageRequest);
        }
        return page;
    }

    public Page<AnnualLeaveGroup> findAll(PageRequest pageRequest) {
        return findAll(null, pageRequest);
    }

    public void delete(AnnualLeaveGroup annualLeaveGroup) {
        annualLeaveGroupRepository.delete(annualLeaveGroup);

    }

    public List<AnnualLeaveGroup> findAll() {
        return annualLeaveGroupRepository.findAll();
    }

    public AnnualLeaveGroup findByCode(String code) {
        return annualLeaveGroupRepository.findOne(QAnnualLeaveGroup.annualLeaveGroup.alGroup.eq(code));
    }
}
