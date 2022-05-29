package com.paoprojectdelivery.www.paoproject.worker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/worker")
public class WorkerController {
    private final WorkerService workerService;

    @Autowired
    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @GetMapping
    public List<Worker> getWorkers() {
        return workerService.getWorkers();
    }

    @PostMapping
    public void registerNewWorker(@RequestBody Worker worker) {
        workerService.addNewWorker(worker);
    }

    @DeleteMapping(path = {"{workerId}"})
    public void deleteWorker(@PathVariable("workerId") Long id) {
        workerService.deleteWorker(id);
    }
}
