package com.nexsoft.ujian03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import com.nexsoft.ujian03.*;

public class AplikasiHitungKelilingKolam {

Ujian_M3 keliling = new Ujian_M3();

//	1================================================================================================
	@ParameterizedTest
	@DisplayName("Input p, l, t dengan nilai pada tabel keliling kolam")
	@CsvFileSource(resources = "data_KelilingKolam.csv",delimiter = ',',numLinesToSkip = 1)
	public void test_Nilai_Tabel_KelilingKolam(int no, double p,double l, double t,double expected) {
		
		double result = keliling.kelilingKolam(p,l,t);
		assertEquals(expected, result);
	}

//	2================================================================================================	
	@ParameterizedTest
	@DisplayName("Masukan bukan angka")
	@CsvSource("String")
	public void test_Bukan_Angka(String str) {
			assertThrows(IllegalArgumentException.class, ()-> {
				keliling.kelilingKolam(3, 5, Double.parseDouble(str));
			});
			
	}
	
//	3================================================================================================
	@ParameterizedTest
	@DisplayName("Masukan angka negatif")
	@CsvSource(value = {"-2;-3;-4;36",
						"-4;-3;-5;48",
						"-2;-4;-4;40"},
						delimiter = ';')
	public void test_Masukkan_Angka_Negatif(double a, double b, double c, double expected) {
	
			double result = -1*(keliling.kelilingKolam(a, b, c));
			assertEquals(expected, result);
			
	}
	
//	4================================================================================================
	@DisplayName("Test tidak dimasukkan angka")
	@ParameterizedTest
    @CsvSource(value = {",,,0",
						",,,0",
						",,,0"},
						delimiter = ';')
    public void test_Tidak_dimasukkanAngka(String a) {
        
        String arrData[] = a.split(",");
        int jumlahData = arrData.length;
        int arrResult[] = new int[jumlahData];
        
       
        for (int i = 0; i < jumlahData; i++) {
        	if (arrData[i].isEmpty())
        	{
        		arrResult[i] = 0;
        	}
        	else {
        		arrResult[i] = Integer.parseInt(arrData[i]);
        	}
        }
        
        double result = keliling.volumeKolam(arrResult[0], arrResult[1], arrResult[2]);
		assertEquals(arrResult[3], result);
        
    }
	
	
}
