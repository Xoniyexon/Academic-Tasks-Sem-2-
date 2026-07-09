package tugas;
	import java.text.ParseException;
	import java.text.SimpleDateFormat;
	import java.util.Date;

	public class ValidationHelper {

	    public static boolean isValidDate(String date) {
	        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	        sdf.setLenient(false);
	        try {
	            sdf.parse(date);
	            return true;
	        } catch (ParseException e) {
	            return false;
	        }
	    }

	    public static boolean isReturnDateValid(String borrowDate, String returnDate) {
	        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	        sdf.setLenient(false);
	        try {
	            Date borrow = sdf.parse(borrowDate);
	            Date returnD = sdf.parse(returnDate);
	            
	            return returnD.after(borrow); 
	        } catch (ParseException e) {
	            return false;
	        }
	    }


	    public static boolean isUniqueLoanId(Loan head, int loanId) {
	        Loan current = head;
	        
	        while (current != null) {
	            if (current.loanId == loanId) {
	                return false;
	            }
	            current = current.next;
	        }
	        return true;
	        }
	}


