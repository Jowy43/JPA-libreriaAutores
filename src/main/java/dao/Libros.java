package dao;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Libros")
public class Libros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLibro;
    @Column(name = "Titulo")
    private String titulo;
    @Column(name = "Precio")
    private double precio;

    @ManyToMany(cascade = {CascadeType.ALL}, mappedBy = "libros")
    private Set<Autores> autores;

    @ManyToOne()
    @JoinColumn(name = "idAutor")
    private Autores autor;

    @OneToOne(mappedBy = "libro")
    private Autores autor2;

    public Libros(String titulo, double precio) {
        this.titulo = titulo;
        this.precio = precio;
    }

}
