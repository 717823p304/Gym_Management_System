package com.wipro.gms.util;

public class TrainerNotAvailableException extends Exception{
	public String toString() {
        return "Trainer Not Available: Trainer is fully booked";
    }
}
