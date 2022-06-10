package com.nexsoft.ujian03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

public class AplikasiHitungVolumeAirKolam {

	Ujian_M3 volume = new Ujian_M3();

//	1================================================================================================
	@ParameterizedTest
	@DisplayName("Input panjang, lebar, tinggi dengan nilai pada tabel volume air kolam")
	@CsvFileSource(resources = "data_VolumeAirKolam.csv",delimiter = ',',numLinesToSkip = 1)
	public void test_Nilai_Tabel_VolumeAirKolam(int no, double p,double l, double t,double expected) {
		
		double result = volume.volumeKolam(p,l,t);
		assertEquals(expected, result);
	}

//	2================================================================================================	
	@ParameterizedTest
	@DisplayName("Masukan bukan angka")
	@CsvSource("String")
	public void test_Bukan_Angka(String str) {
			
			assertThrows(IllegalArgumentException.class, () -> {
				volume.volumeKolam(3, 5, Double.parseDouble(str));
			});
			
	}
	
//	3================================================================================================
	@ParameterizedTest
	@DisplayName("Masukan angka negatif")
	@CsvSource(value = {"-2;-3;-4;24",
						"-4;-3;-5;60",
						"-2;-4;-4;32"},
						delimiter = ';')
	public void test_Masukkan_Angka_Negatif(double a, double b, double c, double expected) {
	
			double result = -1* (volume.volumeKolam(a, b, c));
			assertEquals(expected, result);
			
	}
	
//	4================================================================================================
	@DisplayName("Test tidak dimasukkan angka")
	@ParameterizedTest
    @CsvSource(value = {",,,0",
						",,,0",
						",,,0"},
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
        
        double result = volume.volumeKolam(arrResult[0], arrResult[1], arrResult[2]);
		assertEquals(arrResult[3], result);
        
    }
}
