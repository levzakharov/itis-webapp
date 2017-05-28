package com.itis.form;

import javax.validation.constraints.NotNull;

/**
 * @author aleksandrpliskin on 25.05.17.
 */
public class RequestCreationForm {

    @NotNull
    private int amount;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}