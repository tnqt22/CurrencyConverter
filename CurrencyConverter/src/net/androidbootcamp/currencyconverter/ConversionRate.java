package net.androidbootcamp.currencyconverter;

public class ConversionRate {

	private String to;
	private float rate;
	private String from;

	public float getRate() {
		return rate;
	}

	@Override
	public String toString() {
		String s = "ConversionRate" +
				" [to=" + to + 
				", rate=" + rate +
				", from=" + from
				+ "]";
		return s;
	}

}
