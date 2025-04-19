package com.insurecalc.rules;

import com.insurecalc.model.PolicyDetails;

import java.time.LocalDate;
import java.util.function.Predicate;

public interface DateRule { // Changed to interface

    Predicate<PolicyDetails> isApplicable();

    LocalDate calculate(PolicyDetails policy);

    void apply(PolicyDetails policy, LocalDate date);
}
