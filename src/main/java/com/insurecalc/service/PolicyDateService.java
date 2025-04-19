package com.insurecalc.service;

import com.insurecalc.model.PolicyDetails;
import com.insurecalc.rules.DateRule;
import com.insurecalc.engine.RuleProcessor;
import com.insurecalc.engine.RuleExecutionSelector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class PolicyDateService {

    @Autowired
    private List<DateRule> dateRules;

    public PolicyDetails calculatePolicyDates(PolicyDetails policy, RuleExecutionSelector ruleExecutionSelector) {
        for (DateRule rule : dateRules) {
            if (ruleExecutionSelector.getApplicability(rule).test(policy)) {
                LocalDate calculatedDate = ruleExecutionSelector.applyRule(policy, rule);
                rule.apply(policy, calculatedDate);
            }
        }
        return policy;
    }
}
