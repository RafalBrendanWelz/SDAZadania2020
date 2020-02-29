package ProgrPo23Luty.zad1PlecakiRozsz.PlecakiZadCopy;


import lombok.Getter;

import java.util.List;

@Getter
public class Plecak {
    private List<OpisTest> testy;


    public Plecak(final List<OpisTest> testy) {
        this.testy = testy;
    }

    public Long dajSumeCzasow(){
        return testy.stream().mapToLong( OpisTest::getCzasMilisek ).sum();
    }

    public void dolozTest(final OpisTest tenTest){
        this.testy.add(tenTest);
    }




}
