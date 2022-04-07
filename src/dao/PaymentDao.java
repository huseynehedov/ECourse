package dao;

import model.Payment;

import java.util.List;

public interface PaymentDao {
    List<Payment> getPaymentList() throws Exception;

    void addPayment(Payment payment) throws Exception;

    Payment getPaymentById(Long paymentId) throws Exception;

    void updatePayment(Payment payment) throws Exception;

    void deletePayment(Long paymentId) throws Exception;
}
