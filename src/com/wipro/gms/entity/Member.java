package com.wipro.gms.entity;

public class Member {
	private String memberId;
    private String memberName;
    private String membershipPlan;
    private int remainingSessions;

    public Member(String memberId, String memberName, String membershipPlan, int remainingSessions) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.membershipPlan = membershipPlan;
        this.remainingSessions = remainingSessions;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getMembershipPlan() {
        return membershipPlan;
    }

    public int getRemainingSessions() {
        return remainingSessions;
    }

    public void setRemainingSessions(int remainingSessions) {
        this.remainingSessions = remainingSessions;
    }
}
