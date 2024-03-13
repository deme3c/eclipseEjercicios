package videoclub;

public class CD {

	private int codigo;
	static private int idCodigo=20000;
	private String titulo;
	private String autor;
	private double precio;
	private boolean disponible;
	
	public CD(String titulo, String autor, double precio) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.precio = precio;
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
		CD.idCodigo = idCodigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	@Override
	public String toString() {
		return "CD [codigo=" + codigo + ", titulo=" + titulo + ", autor=" + autor + ", precio=" + precio
				+ ", disponible=" + disponible + "]";
	}
	
	
	
}
