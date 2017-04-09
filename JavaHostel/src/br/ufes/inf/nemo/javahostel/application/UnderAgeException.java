package br.ufes.inf.nemo.javahostel.application;

public class UnderAgeException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int age;
	
	public UnderAgeException(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}
	
	
}
