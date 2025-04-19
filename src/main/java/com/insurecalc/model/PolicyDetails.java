package com.insurecalc.model;

import java.time.LocalDate;

public class PolicyDetails {
    private Long policyId;
    private String productType; // e.g., "Auto", "Home", "Life" (renamed from policyType)
    private LocalDate inceptionDate; // Renamed from policyStartDate
    private LocalDate expiryDate; // Renamed from policyEndDate
    private LocalDate nextPremiumDate; // Renamed from premiumDueDate
    private LocalDate claimFiledDate; // Renamed from claimReportDate
    private LocalDate claimSettlementDate;
    private String riskProfile; // Renamed from riskCategory
    private boolean isReinsured; // Renamed from isReinsuranceApplicable

    // Getters and setters
    public Long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Long policyId) {
        this.policyId = policyId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public LocalDate getInceptionDate() {
        return inceptionDate;
    }

    public void setInceptionDate(LocalDate inceptionDate) {
        this.inceptionDate = inceptionDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public LocalDate getNextPremiumDate() {
        return nextPremiumDate;
    }

    public void setNextPremiumDate(LocalDate nextPremiumDate) {
        this.nextPremiumDate = nextPremiumDate;
    }

    public LocalDate getClaimFiledDate() {
        return claimFiledDate;
    }

    public void setClaimFiledDate(LocalDate claimFiledDate) {
        this.claimFiledDate = claimFiledDate;
    }

    public LocalDate getClaimSettlementDate() {
        return claimSettlementDate;
    }

    public void setClaimSettlementDate(LocalDate claimSettlementDate) {
        this.claimSettlementDate = claimSettlementDate;
    }

    public String getRiskProfile() {
        return riskProfile;
    }

    public void setRiskProfile(String riskProfile) {
        this.riskProfile = riskProfile;
    }

    public boolean isReinsured() {
        return isReinsured;
    }

    public void setReinsured(boolean reinsured) {
        isReinsured = reinsured;
    }
}
