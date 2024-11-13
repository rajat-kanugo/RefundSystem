package com.example.RefundSystem.serviceimpl;

import com.example.RefundSystem.Model.RefundRequest;
import com.example.RefundSystem.Repository.RefundRequestRepository;
import com.example.RefundSystem.service.RefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RefundServiceImpl implements RefundService {

    @Autowired
    private RefundRequestRepository repository;

    @Override
    public RefundRequest createRefundRequest(RefundRequest request) {
        return repository.save(request);
    }

    @Override
    public Optional<RefundRequest> getRefundRequest(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<RefundRequest> getAllRefundRequests() {
        return repository.findAll();
    }

    @Override
    public RefundRequest updateRefundRequest(Long id, RefundRequest request) {
        request.setId(id);
        return repository.save(request);
    }

    @Override
    public void deleteRefundRequest(Long id) {
        repository.deleteById(id);
    }

    @Override
    public RefundRequest processRefund(RefundRequest request) {
        if (request.getInitiateRefundAmount() == request.getSystemGeneratedRefundAmount()) {
            // Amounts match, process refund immediately
            callRazorPayXAPI(request);
            request.setRefundLink("GeneratedLink");
            request.setRefundStatus("INITIATED");
            repository.save(request);

            // Update status to REFUNDED once processed
            request.setRefundStatus("REFUNDED");
            updateMoEngage(request);
        } else {
            // Amounts don't match, set to PENDING
            request.setRefundStatus("PENDING");
            repository.save(request);
        }
        return request;
    }

    private void callRazorPayXAPI(RefundRequest request) {
        System.out.println("Calling RazorPayX API for refund processing.");
    }

    private void updateMoEngage(RefundRequest request) {
        System.out.println("Updating MoEngage with status: " + request.getRefundStatus());
    }
}
