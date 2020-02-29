package ProgrPo16Luty.zad2ConfigLoader;


public class configLoadPROXY implements ConfigLoader{
    private String savedConfig;
    private String serwerURL;

    public configLoadPROXY(final String serwerURL) {
        this.serwerURL = serwerURL;
        this.savedConfig = "";
    }

    @Override
    public String load() {
        if (this.savedConfig.length() != baseConnectionService.getDLUGOSC_CONFIG() ){
            configLoadFromSerwer conectService = new configLoadFromSerwer(this.serwerURL);
            this.savedConfig = conectService.load();
        }else {
            System.out.println("Pobrano konfigurację z serwera " + this.serwerURL);
        }

        return this.savedConfig;
    }

    public void changeURL (final String nowyURL){
        if ( !this.serwerURL.equals(nowyURL)){
            this.serwerURL = nowyURL;
            this.savedConfig = "";
        }
    }




}
