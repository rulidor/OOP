package hw3;

public interface IObservable {

	/*
	 * adds observer
	 */
	void add(IObserver observer);
	
	/*
	 * removes observer
	 */
	void remove(IObserver observer);
	
	/*
	 * notify observer
	 */
	void doNotify();
	
	
	
}
