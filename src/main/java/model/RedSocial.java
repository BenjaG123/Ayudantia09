package model;

public class RedSocial {

	private String usuario;
	private String password;
	private String sitioWeb;

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSitioWeb() {
		return this.sitioWeb;
	}

	public void setSitioWeb(String sitioWeb) {
		this.sitioWeb = sitioWeb;
	}

	public RedSocial(String usuario, String password, String sitioWeb) {
		this.usuario = usuario;
		this.password = password;
		this.sitioWeb = sitioWeb;
	}

	@Override
	public String toString() {
		return "RedSocial{" +
				"Usuario='" + usuario + '\'' +
				", Password='" + password + '\'' +
				", Sitio Web='" + sitioWeb + '\'' +
				'}';
	}

}