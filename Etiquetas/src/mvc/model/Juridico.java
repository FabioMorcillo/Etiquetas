package mvc.model;

public class Juridico 
{
	private int id;
	private String vara;
	private String juizo;
	private String comarca;
	private String processo;
	private String autor;
	private String reu;
	
	public Juridico()
	{
	
	}
	
	public Juridico( int id, String vara, String juizo, String comarca, String processo, String autor, String reu )
	{
		this.id = id;
		this.vara = vara;
		this.juizo = juizo;
		this.comarca = comarca;
		this.processo = processo;
		this.autor = autor;
		this.reu = reu;
	}
				
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getVara() {
		return vara;
	}
	public void setVara(String vara) {
		this.vara = vara;
	}
	public String getJuizo() {
		return juizo;
	}
	public void setJuizo(String juizo) {
		this.juizo = juizo;
	}
	public String getComarca() {
		return comarca;
	}
	public void setComarca(String comarca) {
		this.comarca = comarca;
	}
	
	public String getProcesso() {
		return processo;
	}

	public void setProcesso(String processo) {
		this.processo = processo;
	}

	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getReu() {
		return reu;
	}
	public void setReu(String reu) {
		this.reu = reu;
	}
	
	
}
