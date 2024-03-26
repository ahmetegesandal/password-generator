package generator;

import java.util.Scanner;

import java.util.Random;
import java.util.ArrayList;

public class generator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random rand = new Random();

		String[] harflerK = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
				"s", "t", "u", "v", "w", "x", "y", "z" };
		String[] harflerB = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
				"S", "T", "U", "V", "W", "X", "Y", "Z" };

		String[] sayilar = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", };
		String[] semboller = { "!", "?", ",", ".", "'", "\"", ";", ":", "(", ")", "[", "]", "{", "}", "-", "_", "*",
				"&", "%", "$", "#", "@", "+", "=", "<", ">", "/", "\\" };

		ArrayList<String> kayit = new ArrayList<>();

		short min = 12;
		short max = 24;

		boolean devam = true;

		while (devam) {
			System.out.print("Şifre oluşturmak için 'o' | programdan çıkmak için 'c': ");
			String secim = scanner.nextLine();

			if (secim.equalsIgnoreCase("o")) {
				String sifre = "";
				int minmaxrand = rand.nextInt(max - min + 1) + min;
				int kar = rand.nextInt(4);

				while (sifre.length() < minmaxrand) {

					int randHarfK = rand.nextInt(harflerK.length);
					int randHarfB = rand.nextInt(harflerB.length);
					int randSayi = rand.nextInt(sayilar.length);
					int randSembol = rand.nextInt(semboller.length);

					switch (kar) {
	                case 0:
	                    sifre += harflerK[randHarfK];
	                    sifre += sayilar[randSayi];
	                    sifre += semboller[randSembol];
	                    sifre += harflerB[randHarfB]; 
	                    break;
	                case 1:
	                	sifre += harflerB[randHarfB]; 
	                	sifre += semboller[randSembol];
	                	sifre += sayilar[randSayi];
	                    sifre += harflerK[randHarfK];
	                    break;
	                case 2:
	                	sifre += semboller[randSembol];
	                	sifre += sayilar[randSayi];
	                	sifre += harflerB[randHarfB];
	                	sifre += harflerK[randHarfK];
	                    break;
	                case 3:
	                	sifre += sayilar[randSayi];
	                	sifre += harflerK[randHarfK];
	                	sifre += semboller[randSembol];
	                	sifre += harflerB[randHarfB];
	                    break;
	            }

					

				}
				if (!kayit.contains(sifre)) {
					kayit.add(sifre);
					System.out.println("Şifre: " + sifre);
				} else {
					System.out.println("Oluşturulan şifre zaten kayıtlı.");
				}

			} else if (secim.equalsIgnoreCase("c")) {
				devam = false;
			} else {
				System.out.println("Geçersiz giriş! Lütfen 'o' veya 'c' yazın.");
			}
		}

	}

}
