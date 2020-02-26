package ProgrPo16Luty.zad1SubjectiInformuje;


public class ObsTypeChangeOf10 extends Obserwujacy {
    private final int WYMAG_ROZNICA = 10;
    private int wartoscStara;

    ObsTypeChangeOf10(final Subject master) {
        super(master, "Obs.Roznica10");
    }

    @Override
    public void reactToInfo(  ){
        if (this.wartoscStara >= this.getCelObserwacji().getWartosc()+WYMAG_ROZNICA  ||  this.wartoscStara <= this.getCelObserwacji().getWartosc()-WYMAG_ROZNICA ){
            System.out.println(this.getNazwa() + " wychwycił nową wartość: " + this.getCelObserwacji().getWartosc() );
        }
        this.wartoscStara = this.getCelObserwacji().getWartosc() ;
    }

    


}
