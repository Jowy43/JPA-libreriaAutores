package dao;

import java.util.Set;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Autores")
public class Autores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "DNI")
    private String dni;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Nacionalidad")
    private String nacionalidad;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Autor_Libro",
            joinColumns = @JoinColumn(name = "idAutor"),
            inverseJoinColumns = @JoinColumn(name = "idLibro")
    )
    private Set<Libros> libros;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "libros")
    @JoinColumn(name = "idLibro")
    private Set<Libros> libros2;

    @OneToOne()
    @PrimaryKeyJoinColumn
    private Telefonos telefono;

    public Autores(String dni, String nombre, String nacionalidad) {
        this.dni = dni;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }
}
