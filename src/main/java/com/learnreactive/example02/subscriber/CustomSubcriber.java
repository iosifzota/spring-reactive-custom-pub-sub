package com.learnreactive.example02.subscriber;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class CustomSubcriber implements Subscriber<Integer> {

    private Subscription sub;

    @Override
    public void onSubscribe(Subscription sub) {
        System.out.println("onSubscribe");
        this.sub = sub;
        sub.request(1);
    }

    @Override
    public void onNext(Integer val) {
        System.out.println("onNext " + val);
        sub.request(1);
    }

    @Override
    public void onError(java.lang.Throwable arg0) {
        System.out.println("onError");
    }

    @Override
    public void onComplete() {
        System.out.println("onComplete");
    }
}
