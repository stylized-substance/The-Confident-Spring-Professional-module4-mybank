package org.stylizedsubstance.mybank.dto;

import jakarta.validation.constraints.*;

public class TransactionDto {
    @NotBlank
    private String userId;

    @NotBlank
    private String recipient;

    @NotNull
    @Min(0)
    @Max(1000000)
    private Integer amount;

    @NotBlank
    private String reference;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
