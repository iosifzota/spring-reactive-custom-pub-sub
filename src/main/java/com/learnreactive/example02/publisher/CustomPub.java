package com.learnreactive.example02.publisher;

import java.util.List;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class CustomPub implements Publisher<Integer> {

    private final List<Integer> m_list;

    public CustomPub(List<Integer> m_list) {
        this.m_list = m_list;
    }

    @Override
    public void subscribe(Subscriber<? super Integer> subscriber) {
        subscriber.onSubscribe(new Subscription() {

            private int counter = 0;

            @Override
            public void cancel() {
            }

            @Override
            public void request(long arg0) {
                if (counter < m_list.size()) {
                    subscriber.onNext(m_list.get(counter++));
                    return;
                }
                subscriber.onComplete();
            }
        });
    }
}
