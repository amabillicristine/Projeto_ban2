package Enums;

public enum TipoEnum {
    ADMINISTRADOR(1),
    USUARIO(2);
    
    private final int value;

    TipoEnum(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
