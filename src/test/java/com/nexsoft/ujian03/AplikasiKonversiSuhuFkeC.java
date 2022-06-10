package com.nexsoft.ujian03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

public class AplikasiKonversiSuhuFkeC {

	Ujian_M3 konversi = new Ujian_M3();

//	1================================================================================================
	@ParameterizedTest
	@DisplayName("Input suhu F dengan nilai pada tabel F ke C")
	@CsvFileSource(resources = "data_FkeC.csv",delimiter = ',',numLinesToSkip = 1)
	public void test_Nilai_Tabel_VolumeAirKolam(int no, float f, float expected) {
		
		float result = konversi.konversiSuhu(f);
		assertEquals(expected, result);
	}
	
//	2================================================================================================	
	@ParameterizedTest
	@DisplayName("Masukan bukan angka")
	@CsvSource("String")
	public void test_Bukan_Angka(String str) {
			assertThrows(IllegalArgumentException.class, ()-> {
				konversi.konversiSuhu(Float.parseFloat(str));
			});
			
	}
	
//	3================================================================================================
	@ParameterizedTest
	@DisplayName("Masukan angka negatif")
	@CsvSource(value = {"-2"},
						delimiter = ';')
	public void test_Masukkan_Angka_Negatif(float a, double expected) {
	
			double result = (konversi.konversiSuhu(a));
			assertEquals(expected, result);
			
	}
	
//	4================================================================================================
	@DisplayName("Test tidak dimasukkan angka")
	@ParameterizedTest
    @CsvSource(value = {",,,0"},
						delimiter = ';')
    public void test_Volume_TidakAngka(String a) {
        
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
        
        double result = konversi.konversiSuhu(arrResult[0]);
		assertEquals(arrResult[3], result);
        
    }

}
