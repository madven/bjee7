package c14;


import javax.jws.WebService;

@WebService
public interface Validator {

	public boolean validate(CreditCard creditCard);

}
