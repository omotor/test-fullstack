package com.test.model.api.response;

/**
 * Created by DEK on 26/04/2017.
 */
public enum  StatusEnum {
    STATUS_OK(1), INVALID_EMAIL(2);
    private final int codigo;

    StatusEnum(int codigo) { this.codigo = codigo; }

    int codigo() { return codigo; }

    public static StatusEnum byCode(int codigo) {
        for (StatusEnum cor: StatusEnum.values()) {
            if (codigo == cor.codigo()) return cor;
        }
        throw new IllegalArgumentException("codigo invalido");
    }

}
