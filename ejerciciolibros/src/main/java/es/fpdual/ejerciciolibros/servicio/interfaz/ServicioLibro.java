package es.fpdual.ejerciciolibros.servicio.interfaz;

import java.util.List;

import es.fpdual.ejerciciolibros.capadatos.modelo.Libro;

public interface ServicioLibro {
	public List<Libro> get();

	public Libro guardar(Libro libro);

	public Libro modificar(String isbnLibroViejo, Libro libroNuevo);

	public void borrar(String isbn);

}
