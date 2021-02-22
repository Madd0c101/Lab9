package jdev.domain;

public class Response {
    private final String status;
    private final int code;
   // private final String coord;
   String message;
    boolean success;
    public Response(String status, int code) {
        this.status = status;
        this.code = code;
    //    this.coord=coord;
    }

    public String getStatus() {
        return status;
    }

    public int getCode() {
        return code;
    }

    //public String getCoord() {return coord;}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}