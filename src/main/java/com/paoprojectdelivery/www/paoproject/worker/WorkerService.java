package com.paoprojectdelivery.www.paoproject.worker;

import com.paoprojectdelivery.www.paoproject.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerService {
    private final WorkerRepository workerRepository;

    @Autowired
    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public List<Worker> getWorkers() {
        return workerRepository.findAll();
    }

    public void addNewWorker(Worker worker) {
        Optional<Customer> customerByEmail = workerRepository.findCustomerByEmail(worker.getEmailAddress());
        if (customerByEmail.isPresent())
            throw new IllegalStateException("email taken");

        workerRepository.save(worker);
        System.out.println(worker);
    }

    public void deleteWorker(Long id) {
        boolean existsById = workerRepository.existsById(id);
        if (!existsById)
            throw new IllegalStateException("Worker with id " + id + " does not exist");
        workerRepository.deleteById(id);
    }
}
