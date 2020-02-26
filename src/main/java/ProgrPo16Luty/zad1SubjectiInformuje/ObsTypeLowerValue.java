package ProgrPo16Luty.zad1SubjectiInformuje;




public class ObsTypeLowerValue extends Obserwujacy {

    public ObsTypeLowerValue(final Subject master) {
        super(master, "Obs.MiejszeValue");
    }

    @Override
    public void reactToInfo(  ){
        if (this.getWartoscStara() > this.getMaster().getWartosc() ){
            System.out.println(this.getNazwa() + " wychwycił nową wartość: " + this.getMaster().getWartosc() );
        }
        this.setWartoscStara( this.getMaster().getWartosc() );
    }




}
