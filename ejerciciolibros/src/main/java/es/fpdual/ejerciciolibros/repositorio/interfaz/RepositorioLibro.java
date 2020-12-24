package es.fpdual.ejerciciolibros.repositorio.interfaz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import es.fpdual.ejerciciolibros.capadatos.modelo.Libro;

public interface RepositorioLibro extends JpaRepository<Libro, Long> {
	public Libro findByIsbn(String isbn);

	@Modifying
	@Query("delete from Libro libro where libro.id = :id")
	void borrar(Long id);
}
