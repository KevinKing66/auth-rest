/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.KevinKing66.auth.shared.validators;

import java.util.regex.Pattern;

/**
 *
 * @author kevin
 */
public class EmailValidator {
    

    // Expresión regular para validar emails
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    /**
     * Valida si un email tiene un formato válido.
     * 
     * @param email El email a validar.
     * @return true si el email es válido, false en caso contrario.
     */
    public static boolean isValid(String email) {
        if (email == null || email.isEmpty()) {
            return false; // Emails vacíos o nulos no son válidos
        }
        return EMAIL_PATTERN.matcher(email).matches();
    }

    /**
     * Lanza una excepción si el email no es válido.
     * 
     * @param email El email a validar.
     * @throws IllegalArgumentException Si el email no tiene un formato válido.
     */
    public static void validate(String email) {
        if (!isValid(email)) {
            throw new IllegalArgumentException("Invalid email format: " + email);
        }
    }
}
