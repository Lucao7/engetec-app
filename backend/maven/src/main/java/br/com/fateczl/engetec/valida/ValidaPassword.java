package br.com.fateczl.engetec.valida;

public class ValidaPassword {

	private static final int MIN_LEGTH = 5;
	
	//valida se a senha tem no mínimo 6 caracteres
	public static boolean validarTamanho(String password) {
		if (password.length() >= 5) return true;
		return false;
	}
}
