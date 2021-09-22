package br.com.training.enums;

public enum Muscle {
    PERNA("Perna"),
    PEITORAL("Peitoral"),
    OMBROS("Ombros"),
    BICEPS("Bíceps"),
    COSTA("Costa"),
    TRICEPS("Tríceps"),
    ABDOMINAL("Abdominal");

    private final String description;

    Muscle(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
