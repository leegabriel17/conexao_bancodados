package inclusao_bancodados;

public class Principal {

	public static void main(String[] args) {
		
		Pessoa  p1 = new Pessoa(1,"Daniel",22);
		Pessoa  p2 = new Pessoa(1,"Gabriel",20);
		Inserir insert = new Inserir();
		insert.salvar(p1);
		Update att = new Update();
		att.alterar(p2);
		Select seleciona = new Select();
		seleciona.selecionar(p1);
		Delete exclusao = new Delete();
		exclusao.apagar(p1);
		
		
	}
}

