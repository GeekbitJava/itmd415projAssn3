package groupproject.itmd515finalproject;


import java.util.List;

import groupproject.itmd515finalproject.Payment;

public interface IpaymentDAO {

    Payment findOne(int pid);

    List<Payment> findAll();

    void create(Payment entity);

    Payment update(Payment entity);

    void delete(Payment entity);

    void deleteById(long entityId);

}