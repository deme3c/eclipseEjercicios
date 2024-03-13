package videoclub;

public class Pelicula {

	private int codigo;
	static private int idCodigo=10000;
	private String titulo;
	private boolean disponible;
	private int categoria;  //1:Novedad, 2:Semi-novedad, 3:Antigua
	
	public Pelicula(String titulo, int categoria) {
		super();
		this.titulo = titulo;
		this.categoria = categoria;
		this.codigo = idCodigo;
		idCodigo++;
		this.disponible = true;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public static int getIdCodigo() {
		return idCodigo;
	}

	public static void setIdCodigo(int idCodigo) {
		Pelicula.idCodigo = idCodigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		if(this.categoria == 1) {
			return "Pelicula [codigo=" + codigo + ", titulo=" + titulo + ", disponible=" + disponible + ", categoria= Novedad";
		}
		else if(this.categoria == 2) {
			return "Pelicula [codigo=" + codigo + ", titulo=" + titulo + ", disponible=" + disponible + ", categoria= Semi-novedad";
		}
		else {
			return "Pelicula [codigo=" + codigo + ", titulo=" + titulo + ", disponible=" + disponible + ", categoria= Antigua";
		}
	}
	
	
	
	
	
}
