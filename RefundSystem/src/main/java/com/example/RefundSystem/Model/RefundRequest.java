package com.example.RefundSystem.Model;

import jakarta.persistence.*;

@Entity
public class RefundRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double initiateRefundAmount;
    private double systemGeneratedRefundAmount;
    private String refundLink;
    private String refundStatus;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getInitiateRefundAmount() {
        return initiateRefundAmount;
    }

    public void setInitiateRefundAmount(double initiateRefundAmount) {
        this.initiateRefundAmount = initiateRefundAmount;
    }

    public double getSystemGeneratedRefundAmount() {
        return systemGeneratedRefundAmount;
    }

    public void setSystemGeneratedRefundAmount(double systemGeneratedRefundAmount) {
        this.systemGeneratedRefundAmount = systemGeneratedRefundAmount;
    }

    public String getRefundLink() {
        return refundLink;
    }

    public void setRefundLink(String refundLink) {
        this.refundLink = refundLink;
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }
}
