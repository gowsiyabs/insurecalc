package com.insurecalc.config;

import com.insurecalc.rules.DateRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RuleConfiguration {

    @Bean
    public List<DateRule> dateRules(List<DateRule> rules) {
        return rules;
    }
}
