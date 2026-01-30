package com.wipro.gms.entity;

public class Trainer {
	private String trainerId;
    private String trainerName;
    private String specialization;
    private int maxClientsPerSession;
    private int currentClients;

    public Trainer(String trainerId, String trainerName, String specialization,
                   int maxClientsPerSession, int currentClients) {
        this.trainerId = trainerId;
        this.trainerName = trainerName;
        this.specialization = specialization;
        this.maxClientsPerSession = maxClientsPerSession;
        this.currentClients = currentClients;
    }

    public String getTrainerId() {
        return trainerId;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public int getMaxClientsPerSession() {
        return maxClientsPerSession;
    }

    public int getCurrentClients() {
        return currentClients;
    }

    public void setCurrentClients(int currentClients) {
        this.currentClients = currentClients;
    }
}
