package dev.verosampedro.SupportAppProject.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.verosampedro.SupportAppProject.models.Request;
import dev.verosampedro.SupportAppProject.repositories.RequestRepository;

import java.util.List;

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;

    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }

    public Request saveRequest(Request request) {
        return requestRepository.save(request);
    }

    public void deleteRequest(Long id) {
        requestRepository.deleteById(id);
    }
}
