import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;


class Uye {
    private String isim;
    private String soyisim;
    private String email;

    public Uye(String isim, String soyisim, String email) {
        this.isim = isim;
        this.soyisim = soyisim;
        this.email = email;
    }

    public String getIsim() {
        return isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public String getEmail() {
        return email;
    }
}

class ElitUye extends Uye {
    public ElitUye(String isim, String soyisim, String email) {
        super(isim, soyisim, email);
    }
}

class GenelUye extends Uye {
    public GenelUye(String isim, String soyisim, String email) {
        super(isim, soyisim, email);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean a = true;

        while (a) {
            System.out.println("Menü:");
            System.out.println("1- Elit üye ekleme");
            System.out.println("2- Genel Üye ekleme");
            System.out.println("3- Mail Gönderme");

            int b = scanner.nextInt();
            scanner.nextLine();

            switch (b) {
                case 1:
                    System.out.println("Elit üye ekleme");
                    System.out.print("İsim: ");
                    String elitIsim = scanner.nextLine();
                    System.out.print("Soyisim: ");
                    String elitSoyisim = scanner.nextLine();
                    System.out.print("Email: ");
                    String elitEmail = scanner.nextLine();

                    ElitUye elitUye = new ElitUye(elitIsim, elitSoyisim, elitEmail);
                    kaydet("elituyeler.txt", elitUye.getIsim() + "\t" + elitUye.getSoyisim() + "\t" + elitUye.getEmail());

                    System.out.println("Elit üye kaydedildi.");
                    break;

                case 2:
                    System.out.println("Genel Üye ekleme");
                    System.out.print("İsim: ");
                    String genelIsim = scanner.nextLine();
                    System.out.print("Soyisim: ");
                    String genelSoyisim = scanner.nextLine();
                    System.out.print("Email: ");
                    String genelEmail = scanner.nextLine();

                    GenelUye genelUye = new GenelUye(genelIsim, genelSoyisim, genelEmail);
                    kaydet("geneluyeler.txt", genelUye.getIsim() + "\t" + genelUye.getSoyisim() + "\t" + genelUye.getEmail());

                    System.out.println("Genel üye kaydedildi.");
                    break;

                case 3:
                    System.out.println("Mail Gönderme");
                    System.out.println("1- Elit üyelere mail");
                    System.out.println("2- Genel üyelere mail");
                    System.out.println("3- Tüm üyelere mail");
                    int secMail = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Mail konusu: ");
                    String konu = scanner.nextLine();
                    System.out.print("Mail içeriği: ");
                    String icerik = scanner.nextLine();

                    switch (secMail) {
                        case 1:
                            System.out.println("Elit üyelere mail gönderme");
                            // elit üyelere mail gönderme kodları
                            break;
                        case 2:
                            System.out.println("Genel üyelere mail gönderme");
                            // genel üyelere mail gönderme kodları
                            break;
                        case 3:
                            System.out.println("Tüm üyelere mail gönderme");
                            // tüm üyelere mail gönderme kodları
                            break;
                        default:
                            System.out.println("Geçersiz seçim, lütfen tekrar deneyin.");
                    }
                    break;
                default:
                    System.out.println("Geçersiz seçim, lütfen tekrar deneyin.");
            }
        }
    }

    public static void kaydet(String dosyaAdi, String veri) {
        try {
            FileWriter myWriter = new FileWriter(dosyaAdi, true);
            myWriter.write(veri + "\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Dosya yazma hatası: " + e.getMessage());
        }
    }
}