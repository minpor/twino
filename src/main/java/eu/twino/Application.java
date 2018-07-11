package eu.twino;

import eu.twino.dw.Dataware;
import eu.twino.dw.Table;

public class Application {

	public static void main(String[] args) {
		Dataware dataware = new Table(12,10);
		dataware.put(1,1, "value 11");
		dataware.put(2,1, "value 21");
		System.out.println(dataware.get(1,1));
		System.out.println(dataware.get(2,1));
	}
}
