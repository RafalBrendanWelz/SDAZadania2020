package Programowanie2Luty.KolejkaDwoPriorytet;


import java.util.*;


public class Kolejka2Prioryt <T, V extends Comparable<V>, K extends Comparable<K>> extends AbstractQueue {
    private LinkedList<Ele2Prioryt<T, V, K> > kolejka;
    private V defaultGlowny;
    private K defaultDodatk;


    public Kolejka2Prioryt(V domyslnyGlow, K domyslnyDodat) {
        this.defaultGlowny = domyslnyGlow;
        this.defaultDodatk = domyslnyDodat;
        this.kolejka = new LinkedList<>();
    }

    @Override
    public int size() {
        return this.kolejka.size();
    }
    @Override
    public boolean isEmpty() {
        return this.kolejka.isEmpty();
    }
    @Override
    public boolean contains(final Object o) {
        if (o instanceof Ele2Prioryt){
            return this.kolejka.contains(o);
        }else {
            return false;
        }
    }
    @Override
    public Iterator iterator() {
        return this.kolejka.iterator();
    }
    @Override
    public Object[] toArray() {
        return new Object[0];
    }
    @Override
    public Object[] toArray(final Object[] a) {
        return new Object[0];
    }

    @Override
    public boolean remove(final Object o) {
        return false;
    }

    @Override
    public boolean addAll(final Collection c) {
        if (c.iterator().next() instanceof Ele2Prioryt){
            c.forEach( this::add );
            return true;

        }else {
            return false;
        }
    }
    @Override
    public boolean retainAll(final Collection c) {
        return false;
    }
    @Override
    public boolean removeAll(final Collection c) {
        if ( c.iterator().next() instanceof Ele2Prioryt ){
            return this.kolejka.removeAll(c);
        }else {
            return false;
        }
    }
    @Override
    public boolean containsAll(final Collection c) {
        return false;
    }
    @Override
    public void clear() {
        this.kolejka = new LinkedList<>();
    }

    @Override
    public boolean add(final Object wartosc) {
        return false;
    }
    @Override
    public boolean offer(final Object o) {
        if (o instanceof Ele2Prioryt){
            Ele2Prioryt<T,V,K> nowy = (Ele2Prioryt) o;
            return oferuj(nowy);

        }else if ( this.kolejka.isEmpty() ){
            T nowaWart = (T) o;
            return this.oferuj(nowaWart);
        }else {
            return false;
        }
    }
    public boolean oferuj(final T wartosc, final V priorytGlowny, final K priorytDodatk) {
        Ele2Prioryt<T, V, K> nowy = new Ele2Prioryt<>(wartosc, priorytGlowny, priorytDodatk);

        if (this.kolejka.isEmpty()){
            return this.kolejka.add( nowy );
        }

        for (int i = 0; i < this.size(); i++) {
            if ( this.kolejka.get(i).compareTo(nowy) >= 0 ){
                this.kolejka.add(i, nowy);
                return true;
            }
        }

        this.kolejka.addLast(nowy);
        return true;
    }
    public boolean oferuj(final Ele2Prioryt element) {
        Ele2Prioryt<T, V, K> nowy = element;

        if (this.kolejka.isEmpty()){
            return this.kolejka.add( nowy );
        }

        for (int i = 0; i < this.size(); i++) {
            if ( this.kolejka.get(i).compareTo(nowy) >= 0 ){
                this.kolejka.add(i, nowy);
                return true;
            }
        }

        this.kolejka.addLast(nowy);
        return true;
    }
    public boolean oferuj(final T wartosc) {
        return this.oferuj(wartosc, defaultGlowny, defaultDodatk);
    }
    public boolean oferuj(final T wartosc, final V priorytGlowny) {
        return this.oferuj(wartosc, priorytGlowny, defaultDodatk);
    }



    @Override
    public Object remove() {
        return this.kolejka.remove();
    }
    @Override
    public Object poll() {
        return this.kolejka.poll();
    }
    @Override
    public Object peek() {
        return this.kolejka.peek();
    }
}
