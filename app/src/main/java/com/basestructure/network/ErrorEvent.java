package com.basestructure.network;

public class ErrorEvent implements Event {


    private Throwable throwable;
    private int requestCode;

    public ErrorEvent(Throwable throwable, int requestCode) {
        this.throwable = throwable;
        this.requestCode = requestCode;
    }

    public ErrorEvent(Throwable throwable) {
        this.throwable = throwable;
    }

    @Override
    public int getType() {
        return TYPE_ERROR;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Throwable getResult() {
        return throwable;
    }

    @Override
    public int getRequestCode() {
        return requestCode;
    }

}
