package edu.learn.java.jdk8;
/*
import rx.Observable;
import rx.Subscriber;

/**
 * Created by egnanasigamony on 16/05/2017.
 * /
public class RxJavaDemo {

    public static void main(String ...args) {
        Observable<String> myObservable = Observable.create(
                new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> sub) {
                        sub.onNext("Hello, world!");
                        sub.onCompleted();
                    }
                }
        );


        Subscriber<String> mySubscriber = new Subscriber<String>() {
            @Override
            public void onNext(String s) { System.out.println(s); }

            @Override
            public void onCompleted() { }

            @Override
            public void onError(Throwable e) { }
        };

        myObservable.subscribe(mySubscriber);


    }
}
*/