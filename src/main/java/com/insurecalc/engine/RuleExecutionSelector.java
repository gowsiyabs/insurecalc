package com.insurecalc.engine;

import com.insurecalc.model.PolicyDetails;
import com.insurecalc.rules.DateRule;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.function.Predicate;

@Component
public class RuleExecutionSelector {
    private boolean isReprocessing;

    public RuleExecutionSelector() {
        this.isReprocessing = false; // or default value
    }

    public void setReprocessing(boolean isReprocessing) {
        this.isReprocessing = isReprocessing;
    }

    public static RuleExecutionSelector selectExecutor(boolean isReprocessing) {
        RuleExecutionSelector selector = new RuleExecutionSelector();
        selector.setReprocessing(isReprocessing);
        return selector;
    }

    public LocalDate applyRule(PolicyDetails policy, DateRule rule) {
        return rule.calculate(policy);
    }

    public Predicate<PolicyDetails> getApplicability(DateRule rule) {
        return isReprocessing ? policy -> true : rule.isApplicable();
    }
}
