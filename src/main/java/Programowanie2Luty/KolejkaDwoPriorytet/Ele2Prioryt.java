package Programowanie2Luty.KolejkaDwoPriorytet;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Ele2Prioryt <T, V extends Comparable<V>, K extends Comparable<K>> implements Comparable{
    private T wartosc;
    private V priorytetGlowny;
    private K priorytDodatk;


    @Override
    public int compareTo(final Object o) {
        if (o instanceof Ele2Prioryt){
            Ele2Prioryt<T, V, K> nowy = (Ele2Prioryt<T, V, K>) o;
            int porownanie = this.priorytetGlowny.compareTo(nowy.priorytetGlowny);

            if (porownanie == 0){
                return this.priorytDodatk.compareTo(nowy.priorytDodatk);
            }

            return porownanie;
        }

        return 0;
    }


}
