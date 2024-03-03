package com.redemob.cadastro.exceptions;

public class ValidaCpf {

    public static boolean validadoCpf(String cpf) {
        return cpf.matches("\\d{11}");
    }
    
}
