package es.fpdual.ejerciciolibros.vista.managedbeans;

import java.math.BigDecimal;

import org.junit.Test;
import org.mockito.Mockito;

import es.fpdual.ejerciciolibros.capadatos.modelo.Libro;
import es.fpdual.ejerciciolibros.servicio.interfaz.ServicioLibro;

public class MantenimientoLibroVistaTest {

	@Test
	public void guardarIsbnViejoNulo() {
		String isbn = "isbn";
		String titulo = "titulo";
		BigDecimal precio = new BigDecimal(23.14);

		ServicioLibro servicioLibro = Mockito.mock(ServicioLibro.class);
		MantenimientoLibroVista vista = new MantenimientoLibroVista();
		vista.setServicioLibro(servicioLibro);
		vista.setIsbn(isbn);
		vista.setTitulo(titulo);
		vista.setPrecio(precio);

		vista.guardar();

		Libro libroEsperado = new Libro();
		libroEsperado.setIsbn(isbn);
		libroEsperado.setTitulo(titulo);
		libroEsperado.setPrecio(precio);

		Mockito.verify(servicioLibro).guardar(libroEsperado);
	}

	@Test
	public void guardarIsbnViejoNoNulo() {
		String isbnViejo = "isbnViejo";
		String isbn = "isbn";
		String titulo = "titulo";
		BigDecimal precio = new BigDecimal(23.14);

		ServicioLibro servicioLibro = Mockito.mock(ServicioLibro.class);
		MantenimientoLibroVista vista = new MantenimientoLibroVista();
		vista.setServicioLibro(servicioLibro);
		vista.setIsbnViejo(isbnViejo);
		vista.setIsbn(isbn);
		vista.setTitulo(titulo);
		vista.setPrecio(precio);

		vista.guardar();

		Libro libroEsperado = new Libro();
		libroEsperado.setIsbn(isbn);
		libroEsperado.setTitulo(titulo);
		libroEsperado.setPrecio(precio);

		Mockito.verify(servicioLibro).modificar(isbnViejo, libroEsperado);
	}
}
