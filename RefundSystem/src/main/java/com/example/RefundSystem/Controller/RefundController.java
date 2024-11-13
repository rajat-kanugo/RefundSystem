package com.example.RefundSystem.Controller;

import com.example.RefundSystem.Model.RefundRequest;
import com.example.RefundSystem.service.RefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/refunds")
public class RefundController {

    @Autowired
    private RefundService refundService;

    @PostMapping
    public RefundRequest createRefund(@RequestBody RefundRequest request) {
        return refundService.createRefundRequest(request);
    }

    @GetMapping("/{id}")
    public RefundRequest getRefund(@PathVariable Long id) {
        return refundService.getRefundRequest(id).orElse(null);
    }

    @GetMapping
    public List<RefundRequest> getAllRefunds() {
        return refundService.getAllRefundRequests();
    }

    @PutMapping("/{id}")
    public RefundRequest updateRefund(@PathVariable Long id, @RequestBody RefundRequest request) {
        return refundService.updateRefundRequest(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteRefund(@PathVariable Long id) {
        refundService.deleteRefundRequest(id);
    }

    @PostMapping("/process")
    public RefundRequest processRefund(@RequestBody RefundRequest request) {
        return refundService.processRefund(request);
    }
}
