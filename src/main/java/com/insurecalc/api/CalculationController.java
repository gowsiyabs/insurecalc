package com.insurecalc.api;

import com.insurecalc.model.PolicyDetails;
import com.insurecalc.service.PolicyDateService;
import com.insurecalc.engine.RuleExecutionSelector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/insurance")
public class CalculationController {

    @Autowired
    private PolicyDateService policyDateService;

    @PostMapping("/process") // Changed endpoint name
    public ResponseEntity<PolicyDetails> processPolicyDates(@RequestBody PolicyDetails policy,
                                                            @RequestParam(defaultValue = "false") boolean reprocess) { // Added as request param
        final RuleExecutionSelector executionSelector = RuleExecutionSelector.selectExecutor(reprocess);
        PolicyDetails updatedPolicy = policyDateService.calculatePolicyDates(policy, executionSelector);
        return ResponseEntity.ok(updatedPolicy);
    }
}
