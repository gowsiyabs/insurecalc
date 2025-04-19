package com.insurecalc.rules;

import com.insurecalc.model.PolicyDetails;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.function.Predicate;

@Component
public class PremiumScheduleRule implements DateRule {

    @Override
    public Predicate<PolicyDetails> isApplicable() {
        return policy -> policy.getInceptionDate() != null;
    }

    @Override
    public LocalDate calculate(PolicyDetails policy) {
        return policy.getInceptionDate().plusMonths(1);
    }

    @Override
    public void apply(PolicyDetails policy, LocalDate date) {
        policy.setNextPremiumDate(date);
    }
}
