package com.payment.paymentservice.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/razorpayWebHook")
public class RazorpayWebhookController {
    @PostMapping("")
    public ResponseEntity acceptWebHookRequest(){
        //redirect to URL
        return null;
    }
}
