/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.tarea2;

import javax.swing.JOptionPane;

public class Menu {
    private SistemaPrestamo sistema;

    public Menu() {
        this.sistema = new SistemaPrestamo();
    }

    public void iniciar() {
        int opcion;
        do {
            String entrada = JOptionPane.showInputDialog(
                "=== SISTEMA DE PRÉSTAMO ===\n" +
                "1. Consultar catálogo\n" +
                "2. Prestar equipo\n" +
                "3. Devolver equipo\n" +
                "4. Consultar multas\n" +
                "5. Mostrar resumen\n" +
                "6. Salir\n\n" +
                "Seleccione una opción:"
            );

            // Si el usuario presiona Cancelar o cierra la ventana
            if (entrada == null) {
                opcion = 6;
            } else {
                try {
                    opcion = Integer.parseInt(entrada);
                } catch (NumberFormatException e) {
                    opcion = 0; // opción inválida
                }
            }

            switch (opcion) {
                case 1:
                    JOptionPane.showMessageDialog(null, sistema.consultarCatalogo());
                    break;
                case 2:
                    String posPrestar = JOptionPane.showInputDialog("Posición a prestar (0-4):");
                    if (posPrestar != null) {
                        try {
                            int pos = Integer.parseInt(posPrestar);
                            JOptionPane.showMessageDialog(null, sistema.prestarEquipo(pos));
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Debe ingresar un número");
                        }
                    }
                    break;
                case 3:
                    String posDevolver = JOptionPane.showInputDialog("Posición a devolver (0-4):");
                    if (posDevolver != null) {
                        try {
                            int pos = Integer.parseInt(posDevolver);
                            String diasStr = JOptionPane.showInputDialog("Días de atraso:");
                            if (diasStr != null) {
                                int dias = Integer.parseInt(diasStr);
                                JOptionPane.showMessageDialog(null, sistema.devolverEquipo(pos, dias));
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Debe ingresar números válidos");
                        }
                    }
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, sistema.consultarMultas());
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, sistema.mostrarResumen());
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        } while (opcion != 6);
    }
}