package edu.learn.java.rxjava;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
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
        //integerObservable.flatMap((entry)->Observable.just(entry).subscribeOn(Schedulers.computation()).map((e)-> { try {Thread.currentThread().sleep(800); } catch(Exception ex) {} System.out.println(Thread.currentThread().getName()+" 2222 : "+e); return e;})).subscribe((e)->{ System.out.println(e); });
        //Subscription subscription=mergedObservable.subscribe(new EventIntegerSubscriber());

        //try { Thread.sleep(50000); } catch(Exception ex) {}

        /*Observable<Integer> neverObserve=never();
        log("before never");
        neverObserve.subscribe((s)->log(s.toString()));
        log("after never");

        Observable<Integer> emptyObserver=empty();
        log("before empty");
        emptyObserver.subscribe((s)->log(s.toString()), Throwable::printStackTrace, () -> { System.out.println("OnCompleted");} );
        log("after empty");

        Observable<Integer> rangeObservable=range(20,30).distinct();
        log("before range");
        rangeObservable.subscribe((s)->log(s.toString()), Throwable::printStackTrace, () -> { System.out.println("OnCompleted");});
        rangeObservable.subscribe((s)->log(s.toString()), Throwable::printStackTrace, () -> { System.out.println("OnCompleted");});
        log("after range"); */
        //sumofAllOddNumbers(1,10);
        createUnboundedObservable();


    }

    private static void createUnboundedObservable() {

        Subscriber<BigInteger> bigIntegerSubscriber = new Subscriber<BigInteger>() {

            @Override
            public void onStart() {
                super.onStart();
                System.out.println("onStart . . .");
            }

            @Override
            public void onCompleted() {
                System.out.println("onCompleted . . .");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError . . .");
            }

            @Override
            public void onNext(BigInteger bigInteger) {
                System.out.println("onNext   "+Thread.currentThread().getName()+". . ."+bigInteger);
            }
        };

        Observable<BigInteger> naturalNumbers=Observable.create(
            new Observable.OnSubscribe<BigInteger>() {
                @Override
                public void call(Subscriber<? super BigInteger> subscriber) {
                    Runnable r = new Runnable() {
                        @Override
                        public void run() {
                            BigInteger n=BigInteger.ZERO;

                            subscriber.onStart();
                            while(!subscriber.isUnsubscribed()) {
                                subscriber.onNext(n);
                                n = n.add(BigInteger.ONE);
                                try { Thread.currentThread().sleep(50); } catch (InterruptedException ie) {}
                            }
                            subscriber.onCompleted();
                        }
                    };
                    Thread t=new Thread(r);
                    t.setName("Observable-1");
                    t.start();
                    try { Thread.currentThread().sleep(100); } catch(InterruptedException ie ) {}
                    subscriber.add(Subscriptions.create(new Action0() {
                        @Override
                        public void call() {
                            System.out.println("Unsubscribed . . . . "+Thread.currentThread().getName());
                            t.interrupt();
                        }
                    }));
                }
            }
        );



        naturalNumbers.subscribe(bigIntegerSubscriber);

        bigIntegerSubscriber.add(Subscriptions.create(new Action0() {
            @Override
            public void call() {
                Thread.currentThread().interrupt();
            }
        }));

        try { Thread.sleep(1000); } catch(InterruptedException ie) {}
        bigIntegerSubscriber.unsubscribe();
    }


    private static  void sumofAllOddNumbers(int start, int end) {
        if(end<=start) {
            return;
        }
        //Observable.range(start,(end-start)).subscribe()
        List<Integer> setOfIntegers = new ArrayList<>();

        for(int i=start;i<=end;i++) {
            setOfIntegers.add(i);
        }

        Predicate<Integer> oddPredicate=new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer.intValue()%2==1;
            }
        };

        Predicate<Integer> evenPredicate=new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer.intValue()%2==0;
            }
        };

        //int oddsum = setOfIntegers.stream().filter(oddPredicate).reduce(0,Integer::sum);
        int oddsum = setOfIntegers.stream().filter(oddPredicate).mapToInt(Integer::intValue).sum();
        int evensum = setOfIntegers.stream().filter(evenPredicate).reduce(0,Integer::sum);

        System.out.println("The sum of all odd integers "+oddsum);
        System.out.println("The sum of all even integers "+evensum);

        IntSummaryStatistics sumStats=setOfIntegers.stream().filter(oddPredicate).mapToInt(Integer::intValue).summaryStatistics();
        System.out.println(String.format("Min : %d - Max : %d, Average : %f, Count : %d Sum : %d",sumStats.getMin(),sumStats.getMax(),sumStats.getAverage(),sumStats.getCount(),sumStats.getSum()));
        sumStats=setOfIntegers.stream().filter(evenPredicate).mapToInt(Integer::intValue).summaryStatistics();
        System.out.println(String.format("Min : %d - Max : %d, Average : %f, Count : %d Sum : %d",sumStats.getMin(),sumStats.getMax(),sumStats.getAverage(),sumStats.getCount(),sumStats.getSum()));

        oddsum = setOfIntegers.stream().filter(oddPredicate).reduce(0,(a,b)->a+b);
        System.out.println("The sum of all odd integers "+oddsum);
    }


    static <T> Observable<T> never() {
        return Observable.create(subscriber -> {

        });
    }

    static <T> Observable<T> empty() {
        return Observable.create(subscriber -> {
            subscriber.onCompleted();
        });
    }

    static Observable<Integer> range(Integer i1,Integer i2) {
        return Observable.create(subscriber -> {
            log("Creating range Observable");
            for(int i=i1;i<i2;i++) {
                subscriber.onNext(i);
            }
            subscriber.onCompleted();
        });
    }

}
