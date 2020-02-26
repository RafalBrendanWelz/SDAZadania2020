package ProgrPo16Luty.zad1SubjectiInformuje;




public class ObsTypeAllValue extends Obserwujacy {


    public ObsTypeAllValue(final Subject master) {
        super(master, "Obs.AllValue");
    }

    @Override
    public void reactToInfo(  ){
        System.out.println(this.getNazwa() + " wychwycił nową wartość: " + this.getMaster().getWartosc() );
    }


}
