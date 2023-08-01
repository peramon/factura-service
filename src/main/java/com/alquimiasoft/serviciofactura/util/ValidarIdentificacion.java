package com.alquimiasoft.serviciofactura.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ValidarIdentificacion {
    public static boolean isValidCedulaRuc(String cedulaRuc) {
        // Eliminar espacios y guiones para facilitar la validación
        cedulaRuc = cedulaRuc.replaceAll("[ -]", "");

        // Verificar la longitud de la cadena
        if (cedulaRuc.length() != 10 && cedulaRuc.length() != 13) {
            return false;
        }

        // Validar el formato de cédula (10 dígitos) o RUC (13 dígitos)
        if (!cedulaRuc.matches("\\d+")) {
            return false;
        }

        // Validar el dígito verificador para cédulas y RUC
        if (cedulaRuc.length() == 10 && !validarDigitoVerificadorCedula(cedulaRuc)) {
            return false;
        } else if (cedulaRuc.length() == 13 && !validarDigitoVerificadorRUC(cedulaRuc)) {
            return false;
        }

        return true;
    }

    private static boolean validarDigitoVerificadorCedula(String cedula) {
        int sum = 0;
        int length = cedula.length();
        for (int i = 0; i < length - 1; i++) {
            int digit = Character.getNumericValue(cedula.charAt(i));
            if (i % 2 == 0) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }
            sum += digit;
        }
        int lastDigit = Character.getNumericValue(cedula.charAt(length - 1));
        int calculatedDigit = 10 - (sum % 10);
        if (calculatedDigit == 10) {
            calculatedDigit = 0;
        }
        return calculatedDigit == lastDigit;
    }

    private static boolean validarDigitoVerificadorRUC(String ruc) {
        int lastDigit = Character.getNumericValue(ruc.charAt(9));
        return lastDigit >= 0 && lastDigit <= 5 && validarDigitoVerificadorCedula(ruc);
    }
}
