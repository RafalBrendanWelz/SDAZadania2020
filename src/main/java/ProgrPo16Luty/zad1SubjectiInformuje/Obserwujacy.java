package ProgrPo16Luty.zad1SubjectiInformuje;


import lombok.Getter;

@Getter
public abstract class Obserwujacy {
    protected final Subject celObserwacji;
    private String nazwa;

    public Obserwujacy(final Subject celObserwacji, final String nazwa) {
        this.celObserwacji = celObserwacji;
        this.nazwa = nazwa;
        celObserwacji.dodajObserwujacego(this);
    }

    public abstract void reactToInfo();




}
