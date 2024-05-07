package com.payment.paymentservice.service;

import com.razorpay.RazorpayException;
import org.springframework.stereotype.Service;

@Service
public interface PaymentService {
    String doPayment(String email,
                     String phoneNumber,
                     Long amount,
                     String orderId) throws RazorpayException;
}
