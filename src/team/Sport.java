package team;

public enum Sport {

    Chess(1),
    Padel(2),
    Basketball(5);

    private int value;
    Sport(int value) {
        this.value = value;
    }
}
