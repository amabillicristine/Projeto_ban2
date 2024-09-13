package Enums;

public enum GeneroEnum {
    MASCULINO(1),
    FEMININO(2),
    OUTROS(3);

    private final int value;

    GeneroEnum(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
