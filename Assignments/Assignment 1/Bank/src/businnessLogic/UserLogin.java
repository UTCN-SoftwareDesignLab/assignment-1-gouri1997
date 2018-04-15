package businnessLogic;

public class UserLogin {

	private int idlogin;
	private String username;
	private String password;
	private String typeuser;
	private int idclient;

	public UserLogin(int idlogin, String username, String password, String typeuser, int idclient) {
		this.idclient = idclient;
		this.idlogin = idlogin;
		this.password = password;
		this.typeuser = typeuser;
		this.username = username;
	}

	/**
	 * @return the idlogin
	 */
	public int getIdlogin() {
		return idlogin;
	}

	/**
	 * @param idlogin
	 *            the idlogin to set
	 */
	public void setIdlogin(int idlogin) {
		this.idlogin = idlogin;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the typeuser
	 */
	public String getTypeuser() {
		return typeuser;
	}

	/**
	 * @param typeuser
	 *            the typeuser to set
	 */
	public void setTypeuser(String typeuser) {
		this.typeuser = typeuser;
	}

	/**
	 * @return the idclient
	 */
	public int getIdclient() {
		return idclient;
	}

	/**
	 * @param idclient
	 *            the idclient to set
	 */
	public void setIdclient(int idclient) {
		this.idclient = idclient;
	}

}
