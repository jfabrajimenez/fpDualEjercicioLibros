package es.fpdual.ejerciciolibros.servicio.implementacion;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.fpdual.ejerciciolibros.capadatos.modelo.Libro;
import es.fpdual.ejerciciolibros.repositorio.interfaz.RepositorioLibro;
import es.fpdual.ejerciciolibros.servicio.interfaz.ServicioLibro;

@Service
public class ServicioLibroImpl implements ServicioLibro {

	@Autowired
	private RepositorioLibro repositorioLibro;

	@Override
	public List<Libro> get() {
		return repositorioLibro.findAll();
	}

	@Override
	@Transactional
	public Libro guardar(Libro libro) {
		return this.repositorioLibro.save(libro);
	}

	@Override
	@Transactional
	public Libro modificar(String isbnLibroViejo, Libro libroNuevo) {
		Libro libroViejo = this.repositorioLibro.findByIsbn(isbnLibroViejo);

		if (libroViejo != null) {
			this.borrar(libroViejo);
			return this.guardar(libroNuevo);
		}

		return null;
	}

	@Override
	@Transactional
	public void borrar(String isbn) {
		Libro libro = this.repositorioLibro.findByIsbn(isbn);

		this.borrar(libro);
	}

	private void borrar(Libro libro) {
		Optional<Libro> libroAEliminar = this.repositorioLibro.findById(libro.getId());

		libroAEliminar.map(Libro::getId).ifPresent(this.repositorioLibro::borrar);
	}

}
