package businnessLogic;

public class Account {
	
	private int idaccount;
	private String iban;
	private int amount;
	private String currency;
	private String accounttype;
	private int idclient;
	private String datecreate;

	public Account(int idaccount, String iban, int amount, String currency, String accounttype, int idclient,String datecreate) {
		this.idaccount = idaccount;
		this.iban = iban;
		this.amount = amount;
		this.currency = currency;
		this.accounttype = accounttype;
		this.idclient = idclient;
		this.datecreate = datecreate;
	}

	public Account() {}

	public int getIdaccount() {
		return idaccount;
	}

	public String getIban() {
		return iban;
	}

	public int getAmount() {
		return amount;
	}

	public String getCurrency() {
		return currency;
	}

	public String getAccounttype() {
		return accounttype;
	}

	public int getIdclient() {
		return idclient;
	}

	public String getDatecreate() {
		return datecreate;
	}

}
