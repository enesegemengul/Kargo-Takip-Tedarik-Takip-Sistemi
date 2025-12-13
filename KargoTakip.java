




import java.util.Scanner;

public class KargoTakip{

   
    static int[] kargoID = new int[100];
    static String[] aliciAdi = new String[100];
    static String[] adres = new String[100];
    static String[] durum = new String[100];
    static int index = 0;  

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        menu(); 
    }

   
    public static void menu() {
        System.out.println("\n=== KARGO TAKIP SISTEMI ===");
        System.out.println("1- Kargo Ekle");
        System.out.println("2- Kargo Listele");
        System.out.println("3- Kargo Ara");
        System.out.println("4- Kargo Guncelle");
        System.out.println("5- Kargo Sil");
        System.out.println("6- Cikis");
        System.out.print("Secim: ");
    
        int secim = input.nextInt();
        input.nextLine();

        switch (secim) {
            case 1: kargoEkle(); break;
            case 2: listele(); break;
            case 3: araMenu(); break;
            case 4: guncelle(); break;
            case 5: sil(); break;
            case 6:System.out.println("Program sonlandi.");
            return;
            default:System.out.println("Hatali giris!");
        }

        menu();  
    }

   
    public static void kargoEkle() {

        System.out.print("Kargo ID gir: ");
        int id = input.nextInt();
        input.nextLine();

        System.out.print("Alici adini gir: ");
        String musteri = input.nextLine();

        System.out.print("Adres gir: ");
        String adr = input.nextLine();

        System.out.print("Durum gir (Yolda/Dagitimda/Teslim): ");
        String dr = input.nextLine();

        kargoID[index] = id;
        aliciAdi[index] = musteri;
        adres[index] = adr;
        durum[index] = dr;

        index++;  

        System.out.println("Kargo basariyla eklendi.");
    }

  
    public static void listele() {
        if (index == 0) {
            System.out.println("Henuz kargo yok.");
            return;
        }

        System.out.println("\n--- TUM KARGOLAR ---");
        for (int i = 0; i < index; i++) {
            System.out.println("ID: " + kargoID[i] +
                    " | Alici: " + aliciAdi[i] +
                    " | Adres: " + adres[i] +
                    " | Durum: " + durum[i]);
        }
    }

   
    public static void araMenu() {
        System.out.println("1- ID ile ara");
        System.out.println("2- Alici adi ile ara");
        System.out.print("Secim: ");

        int secim = input.nextInt();
        input.nextLine();

        if (secim == 1) {
            System.out.print("ID gir: ");
            int id = input.nextInt();
            ara(id);    
        } else if (secim == 2) {
            System.out.print("Alici adi gir: ");
            String ad = input.nextLine();
             ara(ad);   
        } else {
            System.out.println("Hatali secim.");
        }
    }

    
    public static void ara(int id) {
        boolean bulundu = false;

        for (int i = 0; i < index; i++) {
            if (kargoID[i] == id) {
                System.out.println("Bulundu -> " +
                        "ID: " + kargoID[i] +
                        ", Alici: " + aliciAdi[i] +
                        ", Adres: " + adres[i] +
                        ", Durum: " + durum[i]);
                bulundu = true;
            }
        }

        if (!bulundu) {
            System.out.println("Bu ID'de kargo yok.");
        }
    }

   
   

       

    public static void guncelle() {

        System.out.print("Guncellenecek ID: ");
        int id = input.nextInt();
        input.nextLine();

        for (int i = 0; i < index; i++) {
            if (kargoID[i] == id) {

                System.out.print("Yeni alici adi: ");
                aliciAdi[i] = input.nextLine();

                System.out.print("Yeni adres: ");
                adres[i] = input.nextLine();

                System.out.print("Yeni durum: ");
                durum[i] = input.nextLine();

                System.out.println("Kargo guncellendi.");
                return;
            }
        }

        System.out.println("ID bulunamadi.");
    }

    public static void sil() {
        System.out.print("Silinecek ID: ");
        int id = input.nextInt();

        for (int i = 0; i < index; i++) {
            if (kargoID[i] == id) {

                
                for (int j = i; j < index - 1; j++) {
                    kargoID[j] = kargoID[j + 1];
                    aliciAdi[j] = aliciAdi[j + 1];
                    adres[j] = adres[j + 1];
                    durum[j] = durum[j + 1];
                }

                index--;
                System.out.println("Kargo silindi.");
                return;
            }
        }

        System.out.println("ID bulunamadi.");
    }
}



    

