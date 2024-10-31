package org.example;

import java.time.LocalDate;

public class PensionPlan {
    private int planReferenceNumber;
    private LocalDate enrollmentDate;
    private double monthlyContribution;

    public int getPlanReferenceNumber() {
        return planReferenceNumber;
    }

    public void setPlanReferenceNumber(int planReferenceNumber) {
        this.planReferenceNumber = planReferenceNumber;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public double getMontlyContribution() {
        return monthlyContribution;
    }

    public void setMonthlyContribution(double monthlyContribution) {
        this.monthlyContribution = monthlyContribution;
    }
}
