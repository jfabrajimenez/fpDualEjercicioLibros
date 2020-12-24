package es.fpdual.ejerciciolibros.vista.managedbeans;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.fpdual.ejerciciolibros.capadatos.modelo.Libro;
import es.fpdual.ejerciciolibros.servicio.interfaz.ServicioLibro;

@ViewScoped
@Component
public class MantenimientoLibroVista {

	@Autowired
	private ServicioLibro servicioLibro;

	private List<Libro> libros;

	private String isbnViejo;

	private String isbn;

	private String titulo;

	private BigDecimal precio;

	@PostConstruct
	public void inicializar() {
		this.libros = this.servicioLibro.get();
	}

	public void guardar() {
		Libro libro = new Libro();
		libro.setIsbn(this.isbn);
		libro.setTitulo(this.titulo);
		libro.setPrecio(this.precio);

		if (isbnViejo == null || isbnViejo.isEmpty()) {
			this.servicioLibro.guardar(libro);
		} else {
			this.servicioLibro.modificar(isbnViejo, libro);
		}
	}

	public void borrar() {
		if (this.isbnViejo != null && !isbnViejo.isEmpty()) {
			this.servicioLibro.borrar(isbnViejo);
		}
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public String getIsbnViejo() {
		return isbnViejo;
	}

	public void setIsbnViejo(String isbnViejo) {
		this.isbnViejo = isbnViejo;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setServicioLibro(ServicioLibro servicioLibro) {
		this.servicioLibro = servicioLibro;
	}

}
