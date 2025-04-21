## DSL-Driven Insurance Date Calculation Framework

### 📂 Project Overview

This Spring Boot application demonstrates the power of Domain-Specific Languages (DSLs) for rule-driven systems using the example of **insurance policy date calculations**. The project includes modular rule components, an execution engine, and a RESTful API that simulates how real-world business logic can be expressed, applied, and extended cleanly using DSL principles.

---

### 🗂 Code Structure & Component Description

#### `PolicyDetails.java` (`model`)
Defines the data model representing an insurance policy.  
Fields include policy ID, product type, inception date, expiry date, premium due date, risk profile, reinsurance status, and claim-related dates.

---

#### `DateRule.java` (`rules`)
An interface representing the DSL for date rules.  
Each rule defines:
- `isApplicable()` → whether it should be applied to a given policy  
- `calculate(...)` → how to compute the target date  
- `apply(...)` → how to update the policy with the computed value

---

#### `PolicyExpirationRule.java` (`rules`)
Implements `DateRule` to compute the **policy expiration date** by adding one year to the inception date.  
Applies only when the product type is `"Auto"`.

---

#### `PremiumScheduleRule.java` (`rules`)
Implements `DateRule` to compute the **next premium due date**, one month after the policy's inception date.  
Applies to all policies with a valid inception date.

---

#### `RuleExecutionSelector.java` (`engine`)
Controls rule applicability and execution logic:
- Supports **"reprocessing mode"**: when enabled, all rules apply regardless of condition.
- Contains logic to invoke `calculate(...)` and `isApplicable()` based on context.

---

#### `PolicyDateService.java` (`service`)
Core service that loops through all injected `DateRule`s.  
For each applicable rule, it calculates and updates the policy accordingly.

---

#### `RuleConfiguration.java` (`config`)
Spring configuration file that wires up all available `DateRule` beans into a list for use in `PolicyDateService`.

---

#### `CalculationController.java` (`api`)
REST controller that exposes a single endpoint:
```
POST /api/insurance/process?reprocess=false
```
It accepts a JSON payload representing a policy and returns the policy with calculated fields like `expiryDate` and `nextPremiumDate`.

---

### Running the Project

#### Requirements
- **JDK 21**
- **Maven or Gradle** to build the project
- **Postman** or any API client to test

#### Sample API Request

**POST** `http://localhost:8080/api/insurance/process?reprocess=false`  
**Headers:**
```
Content-Type: application/json
```

**Body:**
```json
{
  "policyId": 12345,
  "productType": "Auto",
  "inceptionDate": "2023-11-06",
  "riskProfile": "Medium",
  "isReinsured": false
}
```

**Expected Response:**
```json
{
  "policyId": 12345,
  "productType": "Auto",
  "inceptionDate": "2023-11-06",
  "expiryDate": "2024-11-06",
  "nextPremiumDate": "2023-12-06",
  "claimFiledDate": null,
  "claimSettlementDate": null,
  "riskProfile": "Medium",
  "reinsured": false
}
```

---

### Key Takeaways

- Built with **Spring Initializr** and designed to show modular rule composition.
- Easily extensible to new rule types (e.g., Claim Rules, Compliance Rules).
- Demonstrates the power of DSLs for expressing domain logic clearly and declaratively.

