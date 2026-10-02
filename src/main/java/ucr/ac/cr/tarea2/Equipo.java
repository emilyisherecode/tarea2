/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.tarea2;


public class Equipo {
    private String codigo;
    private String nombre;
    private String tipo;
    private boolean disponible;
    private double tarifaMulta;

    public Equipo(String codigo, String nombre, String tipo, double tarifaMulta) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.tarifaMulta = tarifaMulta;
        this.disponible = true; // Todo equipo inicia disponible
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    public double getTarifaMulta() { return tarifaMulta; }
    public void setTarifaMulta(double tarifaMulta) { this.tarifaMulta = tarifaMulta; }

    public void prestar() {
        this.disponible = false;
    }

    public void devolver() {
        this.disponible = true;
    }

    public double calcularMulta(int diasAtraso) {
        return this.tarifaMulta * diasAtraso;
    }

    public String mostrarInfo() {
        String estado = disponible ? "Disponible" : "Prestado";
        return "Código: " + codigo + "\n" +
               "Nombre: " + nombre + "\n" +
               "Tipo: " + tipo + "\n" +
               "Estado: " + estado + "\n" +
               "Tarifa de multa: " + tarifaMulta + " por día";
    }
}