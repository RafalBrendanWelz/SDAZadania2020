package ProgrPo16Luty.zad1SubjectiInformuje;


import lombok.Getter;

@Getter
public abstract class Obserwujacy {
    private final Subject master;
    private String nazwa;
    private int wartoscStara;

    public Obserwujacy(final Subject master, final String nazwa) {
        this.master = master;
        this.nazwa = nazwa;
        master.dodajObserwujacego(this);
    }

    public void setWartoscStara(final int wartoscStara) {
        this.wartoscStara = wartoscStara;
    }

    public abstract void reactToInfo();




}
