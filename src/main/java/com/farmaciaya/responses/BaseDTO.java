package com.farmaciaya.responses;

/**
 * Created by nachogarrone on 8/10/15.
 */
public class BaseDTO {
    public static final BaseDTO SUCCESS = new BaseDTO(Status.SUCCESS);
    private Status status;
    private String message;
    private Object data;
    public BaseDTO() {
    }
    public BaseDTO(Status status) {
        this.status = status;
    }

    public BaseDTO(Status status, Object data) {
        this.status = status;
        this.data = data;
    }

    public BaseDTO(Status status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message.toString();
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static enum Status {
        SUCCESS, ERROR;
    }

    public static enum Message {
        NOT_FOUND("Not found"),
        UNATHENTICATED("SessionNotFound"),
        UNKNOWN("UnknownError"),
        WRONG_PASSWORD("WrongPassword"),
        USERNAME_TAKEN("UsernameTaken"),
        INVALID_REQUEST("InvalidRequest");

        private String message;

        Message(String msg) {
            this.message = msg;
        }

        @Override
        public String toString() {
            return message;
        }

    }
}
