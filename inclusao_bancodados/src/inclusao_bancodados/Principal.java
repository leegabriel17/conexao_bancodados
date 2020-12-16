package inclusao_bancodados;

import java.util.List;

public class Principal {

	public static void main(String[] args) {
		
		Pessoa  p1 = new Pessoa(1,"Daniel",22);
		Pessoa  p2 = new Pessoa(2,"Gabriel lee",22);
		/*Inserir insert = new Inserir();
		insert.salvar(p1);
		insert.salvar(p2);
		Update att = new Update();
		att.alterar(p2);*/
		Select seleciona = new Select();
		List<Pessoa> list = seleciona.selecionar();
		for(Pessoa p : list){ 
			System.out.println(p); 
		}
		
		/*Delete exclusao = new Delete();
		exclusao.apagar(p1);
		*/
		
		
	}
}

