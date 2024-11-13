package com.example.RefundSystem.service;

import com.example.RefundSystem.Model.RefundRequest;

import java.util.List;
import java.util.Optional;

public interface RefundService {
    RefundRequest createRefundRequest(RefundRequest request);
    Optional<RefundRequest> getRefundRequest(Long id);
    List<RefundRequest> getAllRefundRequests();
    RefundRequest updateRefundRequest(Long id, RefundRequest request);
    void deleteRefundRequest(Long id);
    RefundRequest processRefund(RefundRequest request);
}
