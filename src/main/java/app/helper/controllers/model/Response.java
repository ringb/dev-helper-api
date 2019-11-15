package app.helper.controllers.model;

import app.helper.constants.Status;

public class Response {

    public Response() {
    }

    public Response(Status status) {
        this.status = status;
    }

    Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
