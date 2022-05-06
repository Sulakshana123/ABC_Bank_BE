package com.ABCBank.ABC.ABCBank.Services;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.ABCBank.ABC.ABCBank.model.Account;
import com.ABCBank.ABC.ABCBank.model.Transaction;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PdfExporterService {
//	private TransactionService transactionService;
//	private List<Transaction> tansactionList;
	
    private Account acc;
	private AccountService accountSer;
    
    public PdfExporterService(Account acc, AccountService accountSer) {
	super();
	this.acc = acc;
	this.accountSer = accountSer;
}

    

	public PdfExporterService() {
		super();
		// TODO Auto-generated constructor stub
	}




	
	
//	public PdfExporterService(TransactionService transactionService, List<Transaction> tansactionList) {
//		super();
//		this.transactionService= transactionService;
//		this.tansactionList = tansactionList;
//	}



	public void createPdf(HttpServletResponse response) throws DocumentException, IOException {
		Date date = new Date();
        String strDateFormat = "hh:mm:ss a";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        String formattedDate= dateFormat.format(date);
        System.out.println("Current time of the day using Date - 12 hour format: " + formattedDate);
		

		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		document.open();
		
		Paragraph header = new Paragraph();
		header.add("Sukshana Transaction Service!");
		document.add(header);
		document.add(new Phrase("ABC Bank Report"));
		document.add(new Paragraph("Date : "+formattedDate));
		document.add(new Paragraph("Owner Identity Number: " + acc.getOwner().getUser_id()));
		document.add(new Paragraph("Full Name: " + acc.getOwner().getFirst_name()+"   " + acc.getOwner().getLast_name()));
		document.add(new Paragraph("My Email: " + acc.getOwner().getEmail()));
		document.add(new Paragraph("My Address: " + acc.getOwner().getAddress()));
		document.add(new Paragraph("My Password: " + acc.getOwner().getPassword()));
		PdfPTable table = new PdfPTable(6);
		table.setSpacingBefore(20);
		table.setWidthPercentage(90);

		PdfPCell cell = new PdfPCell();

		cell.setPhrase(new Phrase("Transaction_ID"));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase("Account_ID"));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase("Tranfered_Amount"));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase("Date & Time"));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase("Tranfer_Type"));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase("Destination_ID"));
	    table.addCell(cell);
	   

    
	    for(Transaction transaction : acc.getTransaction()) {
	    	table.addCell(Integer.toString(transaction.getTransaction_id()));
	    	table.addCell(Integer.toString(transaction.getAccount_Id()));
	    	table.addCell(Float.toString(transaction.getAmount()));
	    	table.addCell(transaction.getDateTime().toString());
	    	table.addCell(transaction.getType());
	    	table.addCell(Integer.toString(transaction.getDestinationAccId() ));
	    }
//	    adding table to doc
	    document.add(table);
	    

		document.close();
	}
	

}
