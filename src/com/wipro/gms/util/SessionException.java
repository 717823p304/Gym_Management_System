package com.wipro.gms.util;

public class SessionException extends Exception{
	public String toString() {
        return "Session Error: Invalid or duplicate session booking";
    }
}
