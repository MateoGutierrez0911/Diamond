package com.JMS.Diamond.modelo;

public enum Role {
	
    USER("USER"),
    ADMIN("ADMIN"),
	OPERADOR("DOMICILIARIO");

    private final String value;

    private Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

