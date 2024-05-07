package com.payment.paymentservice.Strategy;

public class PaymentGatewayStrategyImp implements PaymentGatewaySelectionStrategy {
    @Override
    public int choosePaymentGateway() {
        //the logic of choosing gateway
        //out of 10,7 should go to razorpay
        //Math.random(1-10) if val<=7 return 1 else return 2
        int randomNo = (int)(Math.random() * 10);
        if(randomNo <= 6){ //0-6 7/10
            return 1;
        }else return 2;
    }
}
