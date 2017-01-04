package c14;


import javax.jws.WebService;

@WebService(endpointInterface = "c14.Validator")
public class CardValidator implements Validator {

	@Override
	public boolean validate(CreditCard creditCard) {
		Character lastDigit = creditCard.getNumber().charAt(creditCard.getNumber().length() - 1);
		if (Integer.parseInt(lastDigit.toString()) % 2 == 0) {
			return true;
		}
		return false;
	}

}
