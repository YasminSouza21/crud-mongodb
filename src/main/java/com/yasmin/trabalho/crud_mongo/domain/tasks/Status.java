package com.yasmin.trabalho.crud_mongo.domain.tasks;

public enum Status {
    PENDENTE("Pendente"),
    FINALIZADO("Finalizado");

    private String statusMessage;

    Status(String statusMessage) {
        this.statusMessage = statusMessage;
    }


    public String getStatusMessage(){
        return statusMessage;
    }


}
