package ProgrPo16Luty.zad1SubjectiInformuje;




public class ObsTypeLowerValue extends Obserwujacy {
    private int wartoscStara;


    ObsTypeLowerValue(final Subject master) {
        super(master, "Obs.MiejszeValue");
    }

    @Override
    public void reactToInfo(  ){
        if (this.wartoscStara > this.getCelObserwacji().getWartosc() ){
            System.out.println(this.getNazwa() + " wychwycił nową wartość: " + this.getCelObserwacji().getWartosc() );
        }
        this.wartoscStara = this.getCelObserwacji().getWartosc();
    }




}
