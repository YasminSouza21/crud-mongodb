package com.yasmin.trabalho.crud_mongo.domain.tasks;

public enum Status {
    PENDENTE("pendente"),
    FINALIZADO("finalizado");

    private String statusMessage;

    Status(String statusMessage) {
        this.statusMessage = statusMessage;
    }


    public String getStatusMessage(){
        return statusMessage;
    }


}
