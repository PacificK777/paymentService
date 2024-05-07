package com.payment.paymentservice.Controller;

import com.payment.paymentservice.Strategy.PaymentGatewaySelectionStrategy;
import com.payment.paymentservice.dto.InitiatePaymentRequest;
import com.payment.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class paymentController {

    private PaymentService razorpayPaymentService;
    private PaymentService stripePaymentService;
    private PaymentGatewaySelectionStrategy paymentGatewaySelectionStrategy;

    public paymentController(
            @Qualifier("razorpay") PaymentService razorPaymentService,
            @Qualifier("stripe") PaymentService stripePaymentService,
            PaymentGatewaySelectionStrategy paymentGateWaySelectionStrategy){

        this.razorpayPaymentService = razorpayPaymentService;
        this.stripePaymentService = stripePaymentService;
        this.paymentGatewaySelectionStrategy = paymentGatewaySelectionStrategy;
    }

    @PostMapping("/payment")
    public String initiatePayment(@RequestBody InitiatePaymentRequest requestdto){
        //Here decide which payment gateway user wants to use
        int paymentGatewayOptions = choosePaymentGateway();
        switch (paymentGatewayOptions){
            case 1:
                return razorpayPaymentService.doPayment(requestdto.getEmail(),
                        requestdto.getPhoneNumber(),
                        requestdto.getAmount(),
                        requestdto.getOrderID());
            case 2:
                return stripePaymentService.doPayment(requestdto.getEmail(),
                        requestdto.getPhoneNumber(),
                        requestdto.getAmount(),
                        requestdto.getOrderID());
        }
        return null;
    }
    public int choosePaymentGateway(){
        return paymentGatewaySelectionStrategy.choosePaymentGateway();
    }
}
