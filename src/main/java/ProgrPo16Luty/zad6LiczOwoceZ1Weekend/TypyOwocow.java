package ProgrPo16Luty.zad6LiczOwoceZ1Weekend;

import lombok.Getter;

@Getter
public enum TypyOwocow {
    JABKO("Jabłko"),
    MAGICAL_GRAPE("Banan"),
    BANAN("Magical Grape");

    private final String nazwa;

    TypyOwocow(final String nazwa) {
        this.nazwa = nazwa;
    }


}
