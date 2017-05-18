package edu.learn.java.rxjava;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;

import java.util.stream.Stream;

/**
 * Created by egnanasigamony on 17/05/2017.
 */
public class Exercise1 {

    private static void log(String msg) {
        System.out.println(Thread.currentThread().getName()+" : "+msg);
    }

    public static void main(String ...args) {
        Observable<Integer> intObs=Observable.just(new Integer("100"));
        //intObs.subscribe(System.out::println);
        Observable<Integer> intArrayObs=Observable.just(100,101,102,103);
        //intArrayObs.subscribe(System.out::println,System.out::println,()->System.out.println("Completed"));

        Observable<Integer> intArrayfromObs=Observable.from(new Integer[] {100,101,102,103});
        //intArrayfromObs.subscribe(System.out::println,System.out::println,()->System.out.println("Completed"));

        Observable<Integer> intRangeObjs=Observable.range(1001,100);
        //intRangeObjs.subscribe(System.out::println,System.out::println,()->System.out.println("Completed Observable.range(1000,100)"));

        Observable combinedObs=Observable.merge(Observable.error(new Exception("new Edwin created exception"))).mergeWith(Observable.range(2001,100)).mergeWith(intArrayfromObs).mergeWith(Observable.error(new Exception("new Edwin created exception"))).mergeWith(intRangeObjs);

        //Observable combinedObs=Observable.merge(intArrayfromObs,intRangeObjs,Observable.error(new Exception("Edwin created Exception")));
        //combinedObs.subscribe(System.out::println,System.out::println,()->System.out.println("Completed combined Observable"));

        /*Observable.range(1,10).subscribe((i)-> {
            System.out.println(" Thread : "+Thread.currentThread().getName()+"  "+(i*i));
        }); */

        class EvenIntegerObservable implements Observable.OnSubscribe<Integer> {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                subscriber.onStart();
                log("Beginning call");
                for(int i=0;i<100;i++) {
                    subscriber.onNext(i);
                }
                subscriber.onCompleted();
            }
        }

        class EventIntegerSubscriber extends Subscriber<Integer> {



            @Override
            public void onCompleted() {
                log("EventSubscriber :: onCompleted");
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onNext(Integer integer) {
                log("EventIntegerSubscriber - onNext : "+integer);
            }
        }

        Observable<Integer> integerObservable=Observable.create(new EvenIntegerObservable());

        //Observable mergedObservable=Observable.merge(integerObservable,integerObservable).flatMap((entry)->Observable.just(entry)).subscribe(System.out::println));
        //Observable.merge(integerObservable,integerObservable).flatMap((entry)->Observable.just(entry)).subscribeOn(Schedulers.computation()).map((e)-> { System.out.println(Thread.currentThread().getName()+" 2222 : "+e); return e;}).subscribe(e1->{ System.out.println(Thread.currentThread().getName()+" : Number received : "+e1);});
        integerObservable.flatMap((entry)->Observable.just(entry).subscribeOn(Schedulers.computation()).map((e)-> { try {Thread.currentThread().sleep(800); } catch(Exception ex) {} System.out.println(Thread.currentThread().getName()+" 2222 : "+e); return e;})).subscribe((e)->{ System.out.println(e); });
        //Subscription subscription=mergedObservable.subscribe(new EventIntegerSubscriber());

        try { Thread.sleep(50000); } catch(Exception ex) {}

    }
}
