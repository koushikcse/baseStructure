package com.basestructure.network;

public class CompletionEvent implements Event {

    private int requestCode;

    public CompletionEvent(int requestCode) {
        this.requestCode = requestCode;
    }

    public CompletionEvent() {

    }

    @Override
    public int getType() {
        return TYPE_COMPLETION;
    }

    @Override
    public <T> T getResult() {
        return null;
    }

    @Override
    public int getRequestCode() {
        return requestCode;
    }

}
