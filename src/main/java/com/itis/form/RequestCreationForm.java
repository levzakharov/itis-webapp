package com.itis.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author aleksandrpliskin on 25.05.17.
 */
public class RequestCreationForm {

    @NotNull
    @Max(message = "Максимум 20 справок", value = 20)
    @Min(message = "Минимум 1 справка",value = 1)
    private int amount;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}