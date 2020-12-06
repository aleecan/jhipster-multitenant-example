package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.domain.tenant.AnnualLeaveGroup;
import com.mikado.multitenant.service.base.ServiceResult;
import com.mikado.multitenant.service.tenant.AnnualLeaveGroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AnnualLeaveGroupResource {

    private final Logger log = LoggerFactory.getLogger(AnnualLeaveGroup.class);

    private AnnualLeaveGroupService annualLeaveGroupService;

    public AnnualLeaveGroupResource(AnnualLeaveGroupService annualLeaveGroupService){
        this.annualLeaveGroupService = annualLeaveGroupService;
    }

    @GetMapping("/annualleavegroup")
    public ResponseEntity<List<AnnualLeaveGroup>> allAnnualLeaveGroups(){
        ServiceResult<List<AnnualLeaveGroup>> serviceResult = annualLeaveGroupService.findAll();
        return ResponseEntity.ok(serviceResult.getData());
    }

    @PostMapping("/annualleavegroup")
    public ResponseEntity<AnnualLeaveGroup> save(@RequestBody AnnualLeaveGroup annualLeaveGroup){
        ServiceResult<AnnualLeaveGroup> serviceResult = annualLeaveGroupService.save(annualLeaveGroup);
        return ResponseEntity.ok(serviceResult.getData());
    }

}
