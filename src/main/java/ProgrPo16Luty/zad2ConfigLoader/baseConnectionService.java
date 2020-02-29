package ProgrPo16Luty.zad2ConfigLoader;

import lombok.Getter;

import java.util.*;

@Getter
public class baseConnectionService {
    private static Map<String, String> serwers;
    private static baseConnectionService INSTANCE;
    private static final int DLUGOSC_CONFIG = 10;

    private baseConnectionService() {
        serwers = new HashMap<>();
    }

    public static baseConnectionService getINSTANCE() {
        if (INSTANCE == null){
            INSTANCE = new baseConnectionService();
        }
        return INSTANCE;
    }

    static int getDLUGOSC_CONFIG() {
        return DLUGOSC_CONFIG;
    }

    void dodajSerwer (final String url){
        Random fakeConfigs = new Random();
        StringBuilder znakiDoConfig = new StringBuilder();

        for (int i = 0; i < DLUGOSC_CONFIG; i++) {
            znakiDoConfig.append( (char)(fakeConfigs.nextInt(127) + 48) );
        }

        serwers.put(url, znakiDoConfig.toString());
    }

    String polaczDoSerwera(final String URL ){
        Random losowyCzasPol = new Random();
        try {
            Thread.sleep(losowyCzasPol.nextInt(3000) + 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return serwers.getOrDefault(URL, "");
    }


}
