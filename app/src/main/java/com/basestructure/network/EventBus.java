package com.basestructure.network;

public interface EventBus {
    void subscribe(EventSubscriber subscriber);

    void unsubscribe();

    void onNext(Event event);

    void onError(Event event);

    void onCompletion(Event event);

}
