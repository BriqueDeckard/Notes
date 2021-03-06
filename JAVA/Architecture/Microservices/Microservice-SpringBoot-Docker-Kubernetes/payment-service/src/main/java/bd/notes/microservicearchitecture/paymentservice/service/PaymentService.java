package bd.notes.microservicearchitecture.paymentservice.service;

import bd.notes.microservicearchitecture.paymentservice.model.Payment;
import bd.notes.microservicearchitecture.paymentservice.model.PaymentList;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PaymentService {
    public PaymentList getAllPayments() {
        List<Payment> list = Arrays.asList(
                new Payment(0, 100.50),
                new Payment(1, 50.20),
                new Payment(2, 30.10),
                new Payment(3, 15),
                new Payment(4, 200.90)
        );
        PaymentList paymentList = new PaymentList(list);
        return paymentList;
    }
}
