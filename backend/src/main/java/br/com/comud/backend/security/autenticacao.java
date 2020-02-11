package br.com.comud.backend.security;

import javax.xml.bind.DatatypeConverter;

import br.com.comud.backend.model.usuario;

public class autenticacao {
	private static final String PREFIXO="*CoMuD|";
	public static String generateToken(usuario usuario) {
		String token = PREFIXO+usuario.toString();
		token = DatatypeConverter.printHexBinary(token.getBytes());
		return token;
	}
	public static boolean isValid(String token) {
		byte[] vetor = DatatypeConverter.parseHexBinary(token);
		String credencial = new String(vetor);
		if(credencial.startsWith(PREFIXO)) {
			return true;
		}
		return false;
	}
}