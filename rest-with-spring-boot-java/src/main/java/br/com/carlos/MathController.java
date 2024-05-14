package br.com.carlos;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.carlos.exceptions.UnsupportedMathOperationException;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class MathController {
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}",method = RequestMethod.GET)
	public Double sum(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo")String numberTwo
			) throws Exception{			

		if (!isNumeric(numberOne) || !isNumeric(numberTwo)){
			throw new UnsupportedMathOperationException("Please, set a numeric value");
		}
		
		return convertToDouble(numberOne)  +  convertToDouble(numberTwo);
}

	private Double convertToDouble(String StrNumber) {
		if(StrNumber == null) return 0D;
		String number = StrNumber.replaceAll(",",".");
		if(isNumeric(number)) return Double.parseDouble(StrNumber);
		return 0D;
	}

	private boolean isNumeric(String StrNumber) {
		if(StrNumber ==null) return false;
		String number = StrNumber.replaceAll(",",".");		
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}