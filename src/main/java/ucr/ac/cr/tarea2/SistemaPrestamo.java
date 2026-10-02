/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.tarea2;

public class SistemaPrestamo {
    private Equipo[] equipos = new Equipo[5];
    private int[] diasAtraso = new int[5];

    public SistemaPrestamo() {
        // Posición 0: EQ01
        equipos[0] = new Equipo("EQ01", "Cámara DSLR", "Cámara", 500);
        // Posición 1: EQ02
        equipos[1] = new Equipo("EQ02", "Trípode", "Soporte", 500);
        // Posición 2: EQ03
        equipos[2] = new Equipo("EQ03", "Micrófono", "Audio", 500);
        // Posición 3: EQ04
        equipos[3] = new Equipo("EQ04", "Tableta gráfica", "Diseño", 500);
        // Posición 4 queda null (no se usa, pero el arreglo es de tamaño 5)

        // diasAtraso se inicializa en 0 automáticamente
    }

    public String consultarCatalogo() {
        String resultado = "=== CATÁLOGO DE EQUIPOS ===\n\n";
        for (int i = 0; i < equipos.length; i++) {
            if (equipos[i] != null) {
                resultado += "Posición: " + i + "\n" + equipos[i].mostrarInfo() + "\n\n";
            }
        }
        return resultado;
    }

    public String prestarEquipo(int posicion) {
        // Validar rango
        if (posicion < 0 || posicion >= equipos.length) {
            return "Error: posición fuera de rango (0-" + (equipos.length - 1) + ")";
        }
        // Validar que exista
        if (equipos[posicion] == null) {
            return "Error: no hay equipo en esa posición";
        }
        // Validar disponibilidad
        if (!equipos[posicion].isDisponible()) {
            return "Error: el equipo ya está prestado";
        }
        equipos[posicion].prestar();
        return "Equipo prestado exitosamente:\n" + equipos[posicion].mostrarInfo();
    }

    public String devolverEquipo(int posicion, int dias) {
        if (posicion < 0 || posicion >= equipos.length) {
            return "Error: posición fuera de rango";
        }
        if (equipos[posicion] == null) {
            return "Error: no hay equipo en esa posición";
        }
        if (equipos[posicion].isDisponible()) {
            return "Error: ese equipo no estaba prestado";
        }
        if (dias < 0) {
            return "Error: los días de atraso no pueden ser negativos";
        }
        equipos[posicion].devolver();
        diasAtraso[posicion] = dias; // guardar en el arreglo por índice
        double multa = equipos[posicion].calcularMulta(dias);
        return "Equipo devuelto.\nDías de atraso: " + dias + "\nMulta: " + multa;
    }

    public String consultarMultas() {
        String resultado = "=== MULTAS REGISTRADAS ===\n\n";
        for (int i = 0; i < equipos.length; i++) {
            if (equipos[i] != null) {
                double multa = equipos[i].calcularMulta(diasAtraso[i]);
                resultado += "Posición " + i + " - " + equipos[i].getNombre() +
                             "\nDías: " + diasAtraso[i] +
                             "\nMulta: " + multa + "\n\n";
            }
        }
        return resultado;
    }

    public String mostrarResumen() {
        int disponibles = 0;
        int prestados = 0;
        int totalDias = 0;
        double totalMultas = 0;

        for (int i = 0; i < equipos.length; i++) {
            if (equipos[i] != null) {
                if (equipos[i].isDisponible()) {
                    disponibles++;
                } else {
                    prestados++;
                }
                totalDias += diasAtraso[i];
                totalMultas += equipos[i].calcularMulta(diasAtraso[i]);
            }
        }

        return "=== RESUMEN ===\n" +
               "Disponibles: " + disponibles + "\n" +
               "Prestados: " + prestados + "\n" +
               "Total días de atraso: " + totalDias + "\n" +
               "Total multas: " + totalMultas;
    }
}