package com.librosapi.challenge.localapi.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "autores")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre", nullable = false)
    private String firstName;
    @Column(name = "apellido", nullable = false)
    private String lastName;
    private String fechaNacimiento;
    private String fechaFallecimiento;
    @ManyToMany(mappedBy = "authors")
    private List<Book> books = new ArrayList<>();
    @Column(name = "nombreCompleto", unique = true, nullable = false)
    private String name;

    public Author (){

    }

    public Author(Long id, String firstName, String lastName, String fechaNacimiento, String fechaFallecimiento, List<Book> books, String name) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaFallecimiento = fechaFallecimiento;
        this.books = books;
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFechaFallecimiento() {
        return fechaFallecimiento;
    }

    public void setFechaFallecimiento(String fechaFallecimiento) {
        this.fechaFallecimiento = fechaFallecimiento;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id) && Objects.equals(firstName, author.firstName) && Objects.equals(lastName, author.lastName) && Objects.equals(fechaNacimiento, author.fechaNacimiento) && Objects.equals(fechaFallecimiento, author.fechaFallecimiento) && Objects.equals(books, author.books) && Objects.equals(name, author.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, fechaNacimiento, fechaFallecimiento, books, name);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", fechaFallecimiento='" + fechaFallecimiento + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

