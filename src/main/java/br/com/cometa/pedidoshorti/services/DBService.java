package br.com.cometa.pedidoshorti.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.cometa.pedidoshorti.entities.Fornecedor;
import br.com.cometa.pedidoshorti.entities.Loja;
import br.com.cometa.pedidoshorti.entities.Pedido;
import br.com.cometa.pedidoshorti.entities.Produto;
import br.com.cometa.pedidoshorti.entities.Usuario;
import br.com.cometa.pedidoshorti.repositories.FornecedorRepository;
import br.com.cometa.pedidoshorti.repositories.LojaRepository;
import br.com.cometa.pedidoshorti.repositories.PedidoRepository;
import br.com.cometa.pedidoshorti.repositories.ProdutoRepository;
import br.com.cometa.pedidoshorti.repositories.UsuarioRepository;

@Service
public class DBService {
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");	
	@Autowired
	private BCryptPasswordEncoder pr;
	@Autowired
	private FornecedorRepository fornecedorRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private LojaRepository lojaRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;

	
	public void instatiateTestDatabase() throws ParseException {
		
		Fornecedor forn1 = new Fornecedor(null, "Astro", "79");
		Fornecedor forn2 = new Fornecedor(null, "André Do Maracujá","453");
		Fornecedor forn3 = new Fornecedor(null, "Carlinhos","47");
		Fornecedor forn4 = new Fornecedor(null, "Lalau", "11050");
		Fornecedor forn5 = new Fornecedor(null, "Bezerra", "789");
		Fornecedor forn6 = new Fornecedor(null, "Betinho", "987");
		Fornecedor forn7 = new Fornecedor(null, "Josivan", "753");
		Fornecedor forn8 = new Fornecedor(null, "Colom", "357");
		Fornecedor forn9 = new Fornecedor(null, "Leão", "158");
		Fornecedor forn10 = new Fornecedor(null, "Vargas", "157");
		Fornecedor forn11 = new Fornecedor(null, "Iânes", "852");
		
		fornecedorRepository.saveAll(Arrays.asList(forn1, forn2, forn3, forn4, forn5, forn6, forn7, forn8, forn9, forn10, forn11));
		
		Produto prod1 = new Produto(null, "Maracujá", forn2, "123", "KG");
		Produto prod2 = new Produto(null, "Maçã Argentina", forn1, "321", "CX");
		Produto prod3 = new Produto(null, "Maçã Nacional", forn2, "456", "KG");
		Produto prod4 = new Produto(null, "Goiaba", forn6, "789", "KG");
		Produto prod5 = new Produto(null, "Romã", forn6, "987", "CX");
		Produto prod6 = new Produto(null, "Acelga", forn3, "654", "KG");
		Produto prod7 = new Produto(null, "Ata", forn3, "159", "KG");
		Produto prod8 = new Produto(null, "Pimenta de Cheiro", forn8, "951", "CX");
		Produto prod9 = new Produto(null, "Acerola", forn7, "357", "KG");
		Produto prod10 = new Produto(null, "Maxixe", forn4, "753", "CX");
		Produto prod11 = new Produto(null, "Quiabo", forn4, "258", "KG");
		Produto prod12 = new Produto(null, "Beterraba", forn9, "852", "CX");
		Produto prod13 = new Produto(null, "Cenoura", forn9, "147", "KG");
		Produto prod14 = new Produto(null, "Morango", forn5, "741", "CX");
		Produto prod15 = new Produto(null, "Abóbora", forn10, "369", "CX");
		
		produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3, prod4, prod5, prod6, prod7, prod8, prod9, prod10, prod11, prod12, prod13, prod14, prod15));
		
		
		Loja lj1 = new Loja(null, "10 - Júlio Lima",1);
		Loja lj2 = new Loja(null, "09 - Maracanaú", 2);
		Loja lj3 = new Loja(null, "01 - Idelfonso", 2);
		Loja lj4 = new Loja(null, "28 - Jovita",1);
		Loja lj5 = new Loja(null, "30 - Beni",1);
		Loja lj6 = new Loja(null, "30 - Beni",1);
		Loja lj7 = new Loja(null, "30 - Beni",1);
		Loja lj8 = new Loja(null, "30 - Beni",1);
		Loja lj9 = new Loja(null, "30 - Beni",1);
		Loja lj10 = new Loja(null, "30 - Beni",1);
		Loja lj11 = new Loja(null, "30 - Beni",1);
		Loja lj12 = new Loja(null, "30 - Beni",1);
		Loja lj13 = new Loja(null, "30 - Beni",1);
		Loja lj14 = new Loja(null, "30 - Beni",1);
		Loja lj15 = new Loja(null, "30 - Beni",1);
		Loja lj16 = new Loja(null, "30 - Beni",1);
		Loja lj17 = new Loja(null, "30 - Beni",1);
		Loja lj18 = new Loja(null, "30 - Beni",1);
		Loja lj19 = new Loja(null, "30 - Beni",1);
		Loja lj20 = new Loja(null, "30 - Beni",1);
		Loja lj21 = new Loja(null, "30 - Beni",1);
		Loja lj22 = new Loja(null, "30 - Beni",1);
		Loja lj23 = new Loja(null, "30 - Beni",1);
		Loja lj24 = new Loja(null, "30 - Beni",1);
		Loja lj25 = new Loja(null, "30 - Beni",1);
		Loja lj26 = new Loja(null, "30 - Beni",1);
		Loja lj27 = new Loja(null, "30 - Beni",1);
		Loja lj28 = new Loja(null, "30 - Beni",1);
		Loja lj29 = new Loja(null, "30 - Beni",1);
		Loja lj30 = new Loja(null, "30 - Beni",1);
		Loja lj31 = new Loja(null, "30 - Beni",1);
		Loja lj32 = new Loja(null, "30 - Beni",1);
		Loja lj33 = new Loja(null, "30 - Beni",1);
		Loja lj34 = new Loja(null, "30 - Beni",1);
		Loja lj35 = new Loja(null, "30 - Beni",1);
		Loja lj36 = new Loja(null, "30 - Beni",1);
		
		
		lojaRepository.saveAll(Arrays.asList(lj1,lj2,lj3,lj4,lj5, lj6, lj7, lj8, lj9, lj10, lj11, lj12, lj13, lj14, lj15, lj16, lj17, lj18, lj19, lj20, lj21, lj22, lj23, lj24, lj25, lj26, lj27, lj28, lj29, lj30, lj31, lj32, lj33, lj34, lj35, lj36));
	
		Usuario u1 = new Usuario(null, "Nilton", pr.encode("123"), "Desenvolvedor", lj1, "ADM");
		Usuario u2 = new Usuario(null, "Alvaro", pr.encode("123"), "Gestor TI", lj2, "USER");
		Usuario u3 = new Usuario(null, "Alex", pr.encode("123"), "Desenvolvedor", lj3, "USER");
		
		usuarioRepository.saveAll(Arrays.asList(u1,u2,u3));
		
		Pedido ped1 = new Pedido(null, sdf.parse("2022-04-26"), 25.00, 80.00, "SEG", prod1, lj1, forn2);	
		Pedido ped2 = new Pedido(null, sdf.parse("2022-04-26"), 20.00, 10.00, "SEX", prod4, lj2, forn6);	
		Pedido ped3 = new Pedido(null, sdf.parse("2022-04-26"), 10.00, 20.00, "SEG", prod7, lj3, forn3);	
		Pedido ped4 = new Pedido(null, sdf.parse("2022-04-26"), 40.00, 80.00, "SEX", prod3, lj4, forn2);	
		Pedido ped5 = new Pedido(null, sdf.parse("2022-04-26"), 25.00, 75.00, "SEG", prod10, lj5, forn4);	
		Pedido ped6 = new Pedido(null, sdf.parse("2022-04-26"), 44.00, 100.00, "SEX", prod11, lj3, forn4);	
		Pedido ped7 = new Pedido(null, sdf.parse("2022-04-26"), 44.00, 100.00, "SEX", prod12, lj2, forn4);	
		Pedido ped8 = new Pedido(null, sdf.parse("2022-04-26"), 44.00, 100.00, "SEX", prod11, lj4, forn4);	
		Pedido ped9 = new Pedido(null, sdf.parse("2022-04-26"), 44.00, 100.00, "SEX", prod13, lj2, forn4);	
		Pedido ped10 = new Pedido(null, sdf.parse("2022-04-26"), 44.00, 100.00, "SEX", prod11, lj5, forn4);	
		Pedido ped11 = new Pedido(null, sdf.parse("2022-04-26"), 44.00, 100.00, "SEX", prod11, lj1, forn4);	
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2, ped3, ped4, ped5, ped6, ped7, ped8, ped9,ped10, ped11));
	
	}
}
