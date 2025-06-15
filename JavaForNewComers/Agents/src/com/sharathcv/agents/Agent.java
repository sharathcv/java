package com.sharathcv.agents;

public class Agent {
    private String firstName;
    private String lastName;
    private Integer codeName;

    public Agent(String firstName, String lastName, Integer codeName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.codeName = codeName;
    }

    public String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String toString() {
        return firstName + " " + lastName;
    }

    public Integer getCodeName() {
        return codeName;
    }

    private void setCodeName(Integer codeName) {
        this.codeName = codeName;
    }
}
