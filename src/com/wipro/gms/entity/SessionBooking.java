package com.wipro.gms.entity;

public class SessionBooking {
	private String bookingId;
    private String memberId;
    private String trainerId;
    private String sessionDate;
    private String sessionTime;

    public SessionBooking(String bookingId, String memberId, String trainerId,
                          String sessionDate, String sessionTime) {
        this.bookingId = bookingId;
        this.memberId = memberId;
        this.trainerId = trainerId;
        this.sessionDate = sessionDate;
        this.sessionTime = sessionTime;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getTrainerId() {
        return trainerId;
    }

    public String getSessionDate() {
        return sessionDate;
    }

    public String getSessionTime() {
        return sessionTime;
    }
}
