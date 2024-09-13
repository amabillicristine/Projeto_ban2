package Enums;

public enum StatusEnum {
    ATIVO(1),
    INATIVO(2);

    private final int value;

    StatusEnum(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
