package team;

public enum Sport {

    Chess(1),
    Padle(2),
    Basketball(5);

    private int value;
    Sport(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
