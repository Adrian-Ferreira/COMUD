package br.com.comud.backend.security;

import javax.xml.bind.DatatypeConverter;

import br.com.comud.backend.models.Usuario;

public class autenticacao {
	private static final String PREFIXO="*CoMuD:";
	public static token generateToken(Usuario usuario) {
		token token = new token();
		String str = PREFIXO+usuario.toString();
		String strToken = DatatypeConverter.printHexBinary(str.getBytes());
		
		token.setToken(strToken);
		return token;
		
	}
	
	public static boolean isValid(String token) {
		byte[] vetor = DatatypeConverter.parseHexBinary(token);
		//converte o código hexadecimal de volta para texto
	    String novaString = new String(vetor);
	    if (novaString.startsWith(PREFIXO)) {
	    	return true;
	    }
	    return false;
	}
	
	public static Usuario extractUser(String token) {
		
		byte[] vetor = DatatypeConverter.parseHexBinary(token);
		String novaString = new String(vetor);
		String partes[] = novaString.split(":");
		
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(Integer.parseInt(partes[1]));
		usuario.setEmail(partes[3]);
		usuario.setNome(partes[2]);
		return usuario;
	}

}