package businnessLogic;

import database.*;

public class Transactions {
	TransactionsDB transactionsdb = new TransactionsDB();

	public String getReport(String datefrom, String dateto, String iban) throws ClassNotFoundException {
		return transactionsdb.getreport(datefrom, dateto, iban);
	}

	public String getReportbyAdmin(String datefrom, String dateto) throws ClassNotFoundException {
		return transactionsdb.selectreportbyadmin(datefrom, dateto);
	}

}
