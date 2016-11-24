package com.microservice.training.model;

public class Enrollment {
    private String name;
    private String phone;
    private String eventId;

    public Enrollment() {}

    public Enrollment(String name, String phone, String eventId) {
        this.name = name;
        this.phone = phone;
        this.eventId = eventId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEventId() {
        return eventId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", eventId='" + eventId + '\'' +
                '}';
    }
}
