package features.java9;

import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class TestDataFlow  {

	Publisher<Integer> publisher = new Publisher<Integer>() {

		public void subscribe(Subscriber<? super Integer> subscriber) {
			int count = 0;
			while(count < 10) {
				subscriber.onNext(++count);
			}
		}
	};
	
	static Subscriber<Integer> subscriber1 = new Subscriber<Integer>() {
		
		public void onSubscribe(Subscription subscription) {
		}
		
		public void onNext(Integer item) {
			System.out.println(item);
		}
		
		public void onError(Throwable throwable) {
		}
		
		public void onComplete() {
		}
	};
	
	static Subscriber<Integer> subscriber2 = new Subscriber<Integer>() {
		
		public void onSubscribe(Subscription subscription) {
		}
		
		public void onNext(Integer item) {
			System.out.println(item);
		}
		
		public void onError(Throwable throwable) {
		}
		
		public void onComplete() {
		}
	};
	
	public static void main(String args[]) {
		new TestDataFlow().publisher.subscribe(subscriber1);
		new TestDataFlow().publisher.subscribe(subscriber2);
	}

}
