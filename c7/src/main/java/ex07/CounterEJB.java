package ex07;

import javax.ejb.Stateful;

@Stateful
public class CounterEJB {

	private int count = 0;

	public int count() {
		return count;
	}

	public int increment() {
		return ++count;
	}

}
