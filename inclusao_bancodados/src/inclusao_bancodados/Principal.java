package inclusao_bancodados;

public class Principal {

	public static void main(String[] args) {
		
		Pessoa  p1 = new Pessoa(1,"Gabriel",22);
		Pessoadao pdao = new Pessoadao();
		pdao.salvar(p1);
	}
}

