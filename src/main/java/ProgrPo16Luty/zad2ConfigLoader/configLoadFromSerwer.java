package ProgrPo16Luty.zad2ConfigLoader;


public class configLoadFromSerwer implements ConfigLoader {
    private String serwerURL;

    configLoadFromSerwer(final String serwerURL) {
        this.serwerURL = serwerURL;
    }

    @Override
    public String load() {
        String configuration = baseConnectionService.getINSTANCE().polaczDoSerwera(this.serwerURL);

        if (configuration.length() != baseConnectionService.getDLUGOSC_CONFIG()){
            System.out.println("Nie udało się połączyć z serwerem ");
        }else {
            System.out.println("Pobrano konfigurację z serwera " + this.serwerURL);
        }
        return configuration;
    }




}
