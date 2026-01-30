package com.wipro.gms.service;
import java.util.ArrayList;
import com.wipro.gms.entity.*;
import com.wipro.gms.util.*;

public class GymService {

    private ArrayList<Member> members;
    private ArrayList<Trainer> trainers;
    private ArrayList<SessionBooking> sessions;
    private int bookingCounter = 1001;

    public GymService(ArrayList<Member> members,
                      ArrayList<Trainer> trainers,
                      ArrayList<SessionBooking> sessions) {
        this.members = members;
        this.trainers = trainers;
        this.sessions = sessions;
    }

    public boolean validateMember(String memberId) throws InvalidMemberException {
        for (Member m : members) {
            if (m.getMemberId().equals(memberId)) {
                return true;
            }
        }
        throw new InvalidMemberException();
    }

    public boolean checkTrainerAvailability(String trainerId)
            throws TrainerNotAvailableException {
        for (Trainer t : trainers) {
            if (t.getTrainerId().equals(trainerId)) {
                if (t.getCurrentClients() < t.getMaxClientsPerSession()) {
                    return true;
                }
                throw new TrainerNotAvailableException();
            }
        }
        throw new TrainerNotAvailableException();
    }

    public SessionBooking bookSession(String memberId, String trainerId,
                                      String date, String time) throws Exception {

        validateMember(memberId);
        checkTrainerAvailability(trainerId);

        Member member = null;
        Trainer trainer = null;

        for (Member m : members) {
            if (m.getMemberId().equals(memberId)) {
                member = m;
            }
        }

        if (member.getRemainingSessions() <= 0) {
            throw new SessionException();
        }

        for (Trainer t : trainers) {
            if (t.getTrainerId().equals(trainerId)) {
                trainer = t;
            }
        }

        trainer.setCurrentClients(trainer.getCurrentClients() + 1);
        member.setRemainingSessions(member.getRemainingSessions() - 1);

        String bookingId = "B" + bookingCounter++;
        SessionBooking sb = new SessionBooking(
                bookingId, memberId, trainerId, date, time);

        sessions.add(sb);
        return sb;
    }

    public boolean cancelSession(String bookingId) throws SessionException {
        for (SessionBooking sb : sessions) {
            if (sb.getBookingId().equals(bookingId)) {

                for (Trainer t : trainers) {
                    if (t.getTrainerId().equals(sb.getTrainerId())) {
                        t.setCurrentClients(t.getCurrentClients() - 1);
                    }
                }

                for (Member m : members) {
                    if (m.getMemberId().equals(sb.getMemberId())) {
                        m.setRemainingSessions(m.getRemainingSessions() + 1);
                    }
                }

                sessions.remove(sb);
                return true;
            }
        }
        throw new SessionException();
    }

    public void printMemberSessions(String memberId) {
        for (SessionBooking sb : sessions) {
            if (sb.getMemberId().equals(memberId)) {
                System.out.println("Booking ID: " + sb.getBookingId()
                        + ", Trainer ID: " + sb.getTrainerId()
                        + ", Date: " + sb.getSessionDate()
                        + ", Time: " + sb.getSessionTime());
            }
        }
    }
}
