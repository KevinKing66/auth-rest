/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.KevinKing66.auth.shared.utils;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author kevin
 */
public class DateHelper {

    /**
     * Agrega horas a la hora actual en milisegundos.
     * 
     * @param hoursToAdd Cantidad de horas a agregar.
     * @return La hora resultante en milisegundos desde el epoch.
     */
    public static long addHoursToCurrentTimeInMs(int hoursToAdd) {
        Instant now = Instant.now();
        Instant updatedTime = now.plusSeconds(hoursToAdd * 3600L);
        return updatedTime.toEpochMilli();
    }

    /**
     * Obtiene la hora actual en formato legible.
     * 
     * @return La hora actual en formato 'yyyy-MM-dd HH:mm:ss'.
     */
    public static String getCurrentFormattedTime() {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }
    
}
