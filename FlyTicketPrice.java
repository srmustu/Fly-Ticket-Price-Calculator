import java.util.Scanner;

public class FlyTicketPrice {
    public static void main(String[] args) {
        /*
        Java ile mesafeye ve şartlara göre uçak bileti fiyatı hesaplayan programı yapın.
        Kullanıcıdan Mesafe (KM),yaşı ve yolculuk tipi (Tek Yön, Gidiş-Dönüş) bilgilerini alın.
        Mesafe başına ücret 0,10 TL / km olarak alın.
        İlk olarak uçuşun toplam fiyatını hesaplayın ve sonrasında ki koşullara göre müşteriye aşağıdaki indirimleri uygulayın ;
        Kullanıcıdan alınan değerler geçerli (mesafe ve yaş değerleri pozitif sayı, yolculuk tipi ise 1 veya 2) olmalıdır.
        Aksi takdirde kullanıcıya "Hatalı Veri Girdiniz !" şeklinde bir uyarı verilmelidir.
        Kişi 12 yaşından küçükse bilet fiyatı üzerinden %50 indirim uygulanır.
        Kişi 12-24 yaşları arasında ise bilet fiyatı üzerinden %10 indirim uygulanır.
        Kişi 65 yaşından büyük ise bilet fiyatı üzerinden %30 indirim uygulanır.
        Kişi "Yolculuk Tipini" gidiş dönüş seçmiş ise bilet fiyatı üzerinden %20 indirim uygulanır.

        */

        Scanner entry = new Scanner(System.in);

        int age, km, tripType, priceKm, calculator1, calculator2, calculator3, calculator4, calculator5, calculator6, calculator7, calculator8;
        String message1, message2, message3, message4, message5, message6, message7, message8,message9,message10,message11;

        priceKm = 10;

        message1 = "Welcome to pegasus airlines. ";
        message2 = "Please enter your age : ";
        message3 = "Enter how many kilometers away your destination is : ";
        message4 = "Choose your ticket type \n(Click 1) One way ticket \n(Click 2) Round trip ticket \nYour chocice : ";
        message5 = "You entered incorrect data. ";
        message6 = "Total price : ";
        message7 = "Discounts you benefit from : ";
        message8 = "Round trip discount (+ %20) ";
        message9 = "Child discount (+ %50) ";
        message10 = "Youth discount (+ %10) ";
        message11 = "Senior citizen discount (+ %10) ";

        System.out.print(message1 + "\n" + message2);
        age = entry.nextInt();
        if (age < 1) {
            System.out.println(message5);
        }

        System.out.print(message3);
        km = entry.nextInt();
        if (km < 150) {
            System.out.println(message5);
        }

        System.out.print(message4);
        tripType = entry.nextInt();
        if ((tripType != 1) && (tripType != 2)) {
            System.out.println(message5);
        }

        calculator1 = km * priceKm; // normal ücret
        calculator2 = calculator1 / 2; // tek yön 11 yaş ve altı
        calculator3 = (calculator2 / 10) * 8; // gidiş-geliş 11 yaş ve altı

        calculator4 = (calculator1 / 10) * 9; // tek yön 12 yaş ve üstü - 24 yaş altı
        calculator5 = (calculator4 / 10) * 8; // gidiş-geliş 12 yaş ve üstü - 24 yaş altı
        calculator6 = (calculator1 / 10) * 7; // tek yön 65 yaş üstü
        calculator7 = (calculator6 / 10) * 8; // gidiş-geliş 65 yaş üstü
        calculator8 = (calculator1 / 10) * 8; // gidiş - geliş 24 yaş ve üstü - 65 yaş ve altı

        if (age >= 24 && age <= 65) {
            if (tripType == 2) {
                System.out.println(message6 + calculator8 + "\n" + message7 + message8);
            } else {
                System.out.println(message6 + calculator1);
            }
        } else if (age <= 11) {
            if (tripType == 2) {
                System.out.println(message6 + calculator3 + "\n" + message7 + message9 + message8);
            } else {
                System.out.println(message6 + calculator2 + "\n" + message7 + message9);
            }
        } else if (age >= 12 && age < 24) {
            if (tripType == 2){
                System.out.println(message6 + calculator5 + "\n" + message7 + message10 + message8);
            } else {
            System.out.println(message6 + calculator4 + "\n" + message7 + message10);
            }
        } else if (age > 65) {
            if (tripType == 2) {
                System.out.println(message6 + calculator7 + "\n" + message7 + message11 + message8);
            } else {
                System.out.println(message6 + calculator6 + "\n" + message7 + message11);
            }
        }
    }
}
