package com.insurecalc.engine;

import com.insurecalc.model.PolicyDetails;
import com.insurecalc.rules.DateRule;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.function.Predicate;

public interface RuleProcessor {
    LocalDate process(PolicyDetails policy, DateRule rule);
    Predicate<PolicyDetails> getApplicability(DateRule rule);
}
