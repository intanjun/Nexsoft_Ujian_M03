package com.nexsoft.ujian03;

import javax.annotation.processing.FilerException;

public class Ujian_M3 {

	//Kolam 
	public double kelilingKolam(double p, double l,double t) {
		return (4*(p+l+t));
	}
	
	
	
	public double volumeKolam(double p, double l,double t) {
		return p*l*t;
	}
	
	//Konversi suhu
	public float konversiSuhu(float f) {
		return (f-32)* 5/9;
	}
}

