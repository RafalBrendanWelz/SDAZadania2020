package ProgrPo16Luty.zad2ConfigLoader;

public class zad2Demo {

    public static void main(String[] args) {
        String urlSerwer1 = "pierwszySerwer.html";
        String urlSerwer2 = "drugiSerwer.html";

        baseConnectionService.getINSTANCE().dodajSerwer(urlSerwer1);
        baseConnectionService.getINSTANCE().dodajSerwer(urlSerwer2);

        configLoadPROXY serwisDoLaczenia = new configLoadPROXY(urlSerwer1);
        System.out.println(serwisDoLaczenia.load());
        System.out.println(serwisDoLaczenia.load());
        System.out.println(serwisDoLaczenia.load());

        serwisDoLaczenia.changeURL(urlSerwer2);

        System.out.println(serwisDoLaczenia.load());
        System.out.println(serwisDoLaczenia.load());
        System.out.println(serwisDoLaczenia.load());

    }

}
