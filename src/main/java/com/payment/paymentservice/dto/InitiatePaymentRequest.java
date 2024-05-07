package com.payment.paymentservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InitiatePaymentRequest {
    private String email;
    private String phoneNumber;
    private Long amount;
    private String orderID;
}
