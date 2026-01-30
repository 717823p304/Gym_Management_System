package com.wipro.gms.util;

public class InvalidMemberException extends Exception{
	public String toString() {
        return "Invalid Member: Member does not exist";
    }
}
