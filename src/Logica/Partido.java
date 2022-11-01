package logica;

public class Partido {

	private int id;
	private Pais adversario;
	private String resultado;
	private int goles;
	
	public Partido(int id, Pais adversario, String resultado, int goles) {
		super();
		this.id = id;
		this.adversario = adversario;
		this.resultado = resultado;
		this.goles = goles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pais getAdversario() {
		return adversario;
	}

	public void setAdversario(Pais adversario) {
		this.adversario = adversario;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public int getGoles() {
		return goles;
	}

	public void setGoles(int goles) {
		this.goles = goles;
	}

	@Override
	public String toString() {
		return "Partido [id=" + id + ", adversario=" + adversario + ", resultado=" + resultado + ", goles=" + goles
				+ "]";
	}
	
	
}
