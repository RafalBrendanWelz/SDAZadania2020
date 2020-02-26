package ProgrPo16Luty.zad1SubjectiInformuje;




public class ObsTypeChangeOf10 extends Obserwujacy {
    private final int WYMAG_ROZNICA = 10;

    public ObsTypeChangeOf10(final Subject master) {
        super(master, "Obs.Roznica10");
    }

    @Override
    public void reactToInfo(  ){
        if (this.getWartoscStara() >= this.getMaster().getWartosc()+WYMAG_ROZNICA || this.getWartoscStara() <= this.getMaster().getWartosc()-WYMAG_ROZNICA ){
            System.out.println(this.getNazwa() + " wychwycił nową wartość: " + this.getMaster().getWartosc() );
        }
        this.setWartoscStara( this.getMaster().getWartosc() );
    }

    


}
