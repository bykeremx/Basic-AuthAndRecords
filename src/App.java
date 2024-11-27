import java.util.Vector;
import javax.swing.JOptionPane;

public class App {

    public static void main(String[] args) {
        // Şifre deneme hakkı
        int hak = 3;  
        String sifre = "1234"; // Doğru şifre
        String girilen_sifre; // Kullanıcının girdiği şifre
        Vector<String> liste = new Vector<>(); // Kayıtların tutulduğu vektör

        // Şifre doğrulama döngüsü
        do {
            girilen_sifre = JOptionPane.showInputDialog("Şifre Giriniz (Kalan Hak: " + hak + ")");
            if (girilen_sifre.equals(sifre)) {
                // Şifre doğru girildiğinde kayıt menüsüne geç
                String message = "";
                message += "Kayıt Menüsü\n";
                message += "*********************\n";
                message += "[1] Kayıt Ekle\n";
                message += "[2] Kayıt Sil\n";
                message += "[3] Kayıt Listele\n";
                message += "[0] Çıkış\n";
                message += "*********************\n";

                // Menü döngüsü
                while (true) {
                    String secim = JOptionPane.showInputDialog(message);
                    if (secim.equals("1")) {
                        // Kayıt ekleme seçeneği
                        String ekle = JOptionPane.showInputDialog("Eklemek istediğiniz kaydı girin:");
                        KayitEkle(ekle, liste);
                    } else if (secim.equals("2")) {
                        // Kayıt silme seçeneği
                        String sil = JOptionPane.showInputDialog("Silmek istediğiniz kaydı girin:");
                        kayitSil(sil, liste);
                    } else if (secim.equals("3")) {
                        // Kayıt listeleme seçeneği
                        listele(liste);
                    } else {
                        // Çıkış seçeneği
                        JOptionPane.showMessageDialog(null, "Güle güle!");
                        System.exit(0);
                    }
                }
            } else {
                // Yanlış şifre durumunda kalan hakkı azalt
                hak--;
                if (hak > 0) {
                    JOptionPane.showMessageDialog(null, "Yanlış şifre! Kalan hak: " + hak);
                } else {
                    JOptionPane.showMessageDialog(null, "Hakkınız kalmadı. Programdan çıkılıyor.");
                }
            }
        } while (hak > 0); // Hak bitene kadar döngü devam eder
    }

    // Yeni kayıt ekleme metodu
    public static void KayitEkle(String kayit, Vector<String> listVector) {
        // Kayıt daha önce eklendi mi kontrol et
        if (listVector.contains(kayit)) {
            JOptionPane.showMessageDialog(null, "Kayıt zaten listede mevcut!");
        } else {
            // Kayıt listede yoksa ekle
            listVector.addElement(kayit);
            JOptionPane.showMessageDialog(null, "'" + kayit + "' başarıyla eklendi!");
        }
    }

    // Kayıt silme metodu
    public static void kayitSil(String kayit, Vector<String> listVector) {
        // Kayıt listede var mı kontrol et
        if (listVector.contains(kayit)) {
            listVector.remove(kayit); // Varsa sil
            JOptionPane.showMessageDialog(null, "'" + kayit + "' başarıyla silindi!");
        } else {
            JOptionPane.showMessageDialog(null, "Silmek istediğiniz kayıt bulunamadı!");
        }
    }

    // Kayıt listeleme metodu
    public static void listele(Vector<String> listVector) {
        // Listeyi ve toplam eleman sayısını görüntüle
        StringBuilder message = new StringBuilder("Kayıt Listesi\n");
        message.append("*****************************\n");
        for (int i = 0; i < listVector.size(); i++) {
            message.append((i + 1)).append(". ").append(listVector.get(i)).append("\n");
        }
        message.append("Toplam kayıt sayısı: ").append(listVector.size()).append("\n");
        message.append("*****************************");
        JOptionPane.showMessageDialog(null, message.toString());
    }
}
