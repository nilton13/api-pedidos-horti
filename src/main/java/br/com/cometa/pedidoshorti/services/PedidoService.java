package br.com.cometa.pedidoshorti.services;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.draw.LineSeparator;

import br.com.cometa.pedidoshorti.dto.InserirPedidoDTO;
import br.com.cometa.pedidoshorti.dto.PedidoAdmDTO;
import br.com.cometa.pedidoshorti.dto.PedidoExportacaoDTO;
import br.com.cometa.pedidoshorti.dto.PedidoRenderDTO;
import br.com.cometa.pedidoshorti.dto.ProdutoRelatorioDTO;
import br.com.cometa.pedidoshorti.dto.RelatorioPedidoFornecedorDTO;
import br.com.cometa.pedidoshorti.entities.Fornecedor;
import br.com.cometa.pedidoshorti.entities.Loja;
import br.com.cometa.pedidoshorti.entities.Pedido;
import br.com.cometa.pedidoshorti.entities.Produto;
import br.com.cometa.pedidoshorti.repositories.FornecedorRepository;
import br.com.cometa.pedidoshorti.repositories.LojaRepository;
import br.com.cometa.pedidoshorti.repositories.PedidoRepository;
import br.com.cometa.pedidoshorti.repositories.ProdutoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private LojaRepository lojaRepository;
	@Autowired
	private FornecedorRepository fornecedorRepository;

	public List<Pedido> findAll() {
		List<Pedido> list = repository.findAll();
		return list;
	}

	public Pedido create(InserirPedidoDTO obj) {
		Pedido pedido = fromDTO(obj);
		return repository.save(pedido);
	}

	public Pedido findById(Integer id) {
		Pedido obj = repository.findById(id).get();
		return obj;
	}

	public Pedido update(InserirPedidoDTO obj) {
		Pedido pedido = fromDTO(obj);
		return repository.save(pedido);
	}

	public Pedido fromDTO(InserirPedidoDTO obj) {
		Produto produto = produtoRepository.findById(obj.getProduto()).get();
		Loja loja = lojaRepository.findById(obj.getLoja()).get();
		Fornecedor fornecedor = fornecedorRepository.findById(obj.getFornecedor()).get();
		Pedido pedido = new Pedido(obj.getId(), obj.getData(), obj.getQuantidade_total(), obj.getQuantidade_pedida(),
				obj.getDia_pedido(), produto, loja, fornecedor);
		return pedido;
	}

	public List<PedidoRenderDTO> findByData(Date data) {
		List<Pedido> pedidos = repository.findByData(data);

		List<PedidoRenderDTO> pedidosFiltrados = new ArrayList<>();
		List<Fornecedor> fornecedores = fornecedorRepository.findAll();

		for (Fornecedor forn : fornecedores) {
			pedidosFiltrados.add(new PedidoRenderDTO(forn.getNome()));
		}

		for (Pedido ped : pedidos) {
			for (PedidoRenderDTO pedRender : pedidosFiltrados) {
				if (ped.getFornecedor().getNome() == pedRender.getFornecedor()) {
					pedRender.setPedidos(ped);
				}
			}
		}

		return pedidosFiltrados;
	}

	public List<PedidoExportacaoDTO> findByDateExportacao(Date data) {
		List<Pedido> pedidos = repository.findByData(data);
		List<Fornecedor> fornecedores = fornecedorRepository.findAll();
		List<Loja> lojas = lojaRepository.findAll();
		List<PedidoExportacaoDTO> pedidosFiltrados = new ArrayList<>();

		// Alimentando Lista com as lojas.
		for (Loja loja : lojas) {
			pedidosFiltrados.add(new PedidoExportacaoDTO(loja.getNome()));
		}

		// Alimentando pedido com Fornecedores
		for (Fornecedor fornecedor : fornecedores) {
			for (PedidoExportacaoDTO pedido : pedidosFiltrados) {
				pedido.setPedidos(new PedidoRenderDTO(fornecedor.getNome()));
			}
		}

		// Filtrando Pedidos para cada LOJA/FORNECEDOR
		for (PedidoExportacaoDTO pedidoFiltrado : pedidosFiltrados) {
			for (Pedido pedido : pedidos) {
				if (pedidoFiltrado.getLoja() == pedido.getLoja().getNome()) {
					for (PedidoRenderDTO pedi : pedidoFiltrado.getPedidos()) {
						if (pedi.getFornecedor() == pedido.getFornecedor().getNome()) {
							pedi.setPedidos(pedido);
						}
					}
				}
			}
		}

		return pedidosFiltrados;

	}

	public List<PedidoAdmDTO> findByDataForAdm(Date data) {
		List<Pedido> pedidos = repository.findByData(data);
		List<Loja> lojas = lojaRepository.findAll();

		List<PedidoAdmDTO> pedidosFiltrados = new ArrayList<>();
		List<Produto> produtos = produtoRepository.findAll();

		for (Produto produto : produtos) {
			pedidosFiltrados.add(new PedidoAdmDTO(produto.getFornecedor().getNome(), produto.getNome(), 0.0));
		}

		for (PedidoAdmDTO pedi : pedidosFiltrados) {
			for (Loja loja : lojas) {
				pedi.setLojas(loja.getId());
			}
		}

		for (Pedido ped : pedidos) {
			for (PedidoAdmDTO pedRender : pedidosFiltrados) {
				if (ped.getProduto().getNome() == pedRender.getProduto()
						&& ped.getFornecedor().getNome() == pedRender.getFornecedor()) {
					pedRender.setQuantidades(ped.getLoja().getId(), ped.getQuantidade_pedida());
					pedRender.setTotal(ped.getQuantidade_pedida());
				}
			}
		}

		return pedidosFiltrados;
	}

	public List<PedidoAdmDTO> findByDataForAdmPorFornecedor(Date data, Integer id) {
		List<Pedido> pedidos = repository.findByData(data);
		List<Loja> lojas = lojaRepository.findAll();
		List<Produto> produtos = produtoRepository.findAll();
		Fornecedor fornecedor = fornecedorRepository.findById(id).get();

		List<PedidoAdmDTO> pedidosFiltrados = new ArrayList<>();

		for (Produto produto : produtos) {
			if (produto.getFornecedor().getNome() == fornecedor.getNome()) {
				pedidosFiltrados.add(new PedidoAdmDTO(fornecedor.getNome(), produto.getNome(), 0.0));
			}
		}

		for (PedidoAdmDTO pedi : pedidosFiltrados) {
			for (Loja loja : lojas) {
				pedi.setLojas(loja.getId());
			}
		}

		for (Pedido ped : pedidos) {
			for (PedidoAdmDTO pedRender : pedidosFiltrados) {
				if (ped.getProduto().getNome() == pedRender.getProduto()) {
					pedRender.setQuantidades(ped.getLoja().getId(), ped.getQuantidade_pedida());
					pedRender.setTotal(ped.getQuantidade_pedida());
				}
			}
		}

		return pedidosFiltrados;
	}

	public RelatorioPedidoFornecedorDTO findByDataForAdmPorFornecedorAtt(Date data, Integer id) {
		List<Pedido> pedidos = repository.findByData(data);
		List<Loja> lojas = lojaRepository.findAll();
		List<Produto> produtos = produtoRepository.findAll();
		Fornecedor fornecedor = fornecedorRepository.findById(id).get();

		RelatorioPedidoFornecedorDTO relatorio = new RelatorioPedidoFornecedorDTO(fornecedor.getNome());

		// Inserindo na lista todos os produtos
		for (Produto produto : produtos) {
			if (produto.getFornecedor() == fornecedor) {
				relatorio.setProdutos(new ProdutoRelatorioDTO(produto.getNome(), 0.0));
			}
		}

		// Adicionando TODAS as lojas as Contagens
		for (ProdutoRelatorioDTO produto : relatorio.getProdutos()) {
			for (Loja loja : lojas) {
				produto.criarQuantidades(loja.getId(), 0.0);
			}
		}

		for (ProdutoRelatorioDTO produto : relatorio.getProdutos())
			for (Pedido pedido : pedidos) {
				if (pedido.getFornecedor() == fornecedor) {
					if (pedido.getProduto().getNome() == produto.getProduto()) {
						produto.setQuantidades(pedido.getId(), pedido.getQuantidade_pedida());
						produto.setTotal(pedido.getQuantidade_pedida());
					}
				}
			}

		return relatorio;
	}

	public List<RelatorioPedidoFornecedorDTO> findByDataForAdmAtt(Date data) {
		List<Pedido> pedidos = repository.findByData(data);
		List<Loja> lojas = lojaRepository.findAll();
		List<Produto> produtos = produtoRepository.findAll();
		List<Fornecedor> fornecedores = fornecedorRepository.findAll();

		List<RelatorioPedidoFornecedorDTO> relatorios = new ArrayList<>();

		// Inserindo Fornecedores
		for (Fornecedor fornecedor : fornecedores) {
			relatorios.add(new RelatorioPedidoFornecedorDTO(fornecedor.getNome()));
		}

		// Inserindo Produtos
		for (RelatorioPedidoFornecedorDTO relatorio : relatorios) {
			for (Produto produto : produtos) {
				if (produto.getFornecedor().getNome() == relatorio.getFornecedor()) {
					relatorio.getProdutos().add(new ProdutoRelatorioDTO(produto.getNome(), 0.0));
				}
			}
		}

		// Inserindo lojas e Iniciando quantidade
		for (RelatorioPedidoFornecedorDTO relatorio : relatorios) {
			for (ProdutoRelatorioDTO produto : relatorio.getProdutos()) {
				for (Loja loja : lojas) {
					produto.criarQuantidades(loja.getId(), 0.0);
				}
			}

		}
		// Inserindo Pedidos
		for (RelatorioPedidoFornecedorDTO relatorio : relatorios) {
			for (Pedido pedido : pedidos) {
				if (pedido.getFornecedor().getNome() == relatorio.getFornecedor()) {
					for (ProdutoRelatorioDTO produto : relatorio.getProdutos()) {
						if (pedido.getProduto().getNome() == produto.getProduto()) {
							produto.setQuantidades(pedido.getId(), pedido.getQuantidade_pedida());
							produto.setTotal(pedido.getQuantidade_pedida());
						}
					}
				}
			}
		}

		return relatorios;
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

	public List<PedidoRenderDTO> findByDataAndLoja(Date data, Integer loja) {
		List<Pedido> pedidosData = repository.findByData(data);
		Loja lojaRecuperada = lojaRepository.findById(loja).get();
		List<Fornecedor> fornecedores = fornecedorRepository.findAll();

		List<PedidoRenderDTO> pedidos = new ArrayList<>();

		for (Fornecedor fornecedor : fornecedores) {
			pedidos.add(new PedidoRenderDTO(fornecedor.getNome()));
		}

		for (Pedido pedido : pedidosData) {
			for (PedidoRenderDTO pedRender : pedidos) {
				if (pedido.getFornecedor().getNome() == pedRender.getFornecedor()) {
					if (pedido.getLoja() == lojaRecuperada) {
						pedRender.setPedidos(pedido);
					}
				}
			}
		}

		return pedidos;
	}
	
	// Gerando PDF de pedidos de todas as Lojas
	public void gerarPdf(Date data) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		List<PedidoExportacaoDTO> pedidos = findByDateExportacao(data);

		try {
			Font font = new Font(Font.HELVETICA, 8);
			Font fontBody = new Font(Font.HELVETICA, 7);
			Document doc = new Document();
			PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(sdf.format(data)+"-pedidoCeasa.pdf"));
			doc.open();

			Paragraph titulo = new Paragraph();
			titulo.setAlignment(Element.ALIGN_CENTER);
			titulo.add(new Chunk("Pedidos Ceasa Cometa Supermercados", new Font(Font.HELVETICA, 15)));
			
			doc.add(titulo);
			
			Paragraph dataPedido = new Paragraph();
			dataPedido.setAlignment(Element.ALIGN_CENTER);
			dataPedido.add(new Chunk("Data "+ sdf.format(data), new Font(Font.HELVETICA, 10, Font.ITALIC)));
			
			doc.add(dataPedido);

			
			doc.add(new Paragraph(" "));
			
			//Instanciando nova tabela
			PdfPTable table = new PdfPTable(4);
			table.setWidthPercentage(100);
			// Largura das Colunas
			table.setWidths(new float[] { 6.0f, 6.0f, 6.0f, 6.0f });
			PdfPCell cell = new PdfPCell();
			// Cabeçalho das Tabelas
			cell.setPhrase(new Phrase("Produto", font));
			cell.setBackgroundColor(Color.lightGray);
			table.addCell(cell);
			cell.setPhrase(new Phrase("Embalagem", font));
			table.addCell(cell);
			cell.setPhrase(new Phrase("Estoque", font));
			table.addCell(cell);
			cell.setPhrase(new Phrase("Quantidade", font));
			table.addCell(cell);

			for (PedidoExportacaoDTO pedido : pedidos) {
				Paragraph subtitulo = new Paragraph();
				subtitulo.setAlignment(Element.ALIGN_CENTER);
				subtitulo.add(new Chunk(pedido.getLoja(), new Font(Font.HELVETICA, 11, Font.BOLD)));
				
				doc.add(subtitulo);
				doc.add(dataPedido);
				doc.add(new Paragraph(" "));
				doc.add(new LineSeparator());
				// doc.add(new Paragraph(" "));
				

				for (PedidoRenderDTO pedi : pedido.getPedidos()) {
					Paragraph fornecedor = new Paragraph();
					fornecedor.add(new Chunk("Fornecedor: " + pedi.getFornecedor(), new Font(Font.HELVETICA, 10, Font.ITALIC)));
					doc.add(fornecedor);

					if(!pedi.getPedidos().isEmpty()) {
						for (Pedido ped : pedi.getPedidos()) {
							table.addCell(new Phrase(ped.getProduto().getNome(), fontBody));
							table.addCell(new Phrase(ped.getProduto().getEmbalagem(), fontBody));
							table.addCell(new Phrase(ped.getQuantidade_total().toString(), fontBody));
							table.addCell(new Phrase(ped.getQuantidade_pedida().toString(), fontBody));
						}
						
					}

					doc.add(table);
					//doc.add(new Paragraph("  "));
					table.deleteBodyRows();
					//doc.newPage();
					
					cell.setPhrase(new Phrase("Produto", font));
					table.addCell(cell);
					cell.setPhrase(new Phrase("Embalagem", font));
					table.addCell(cell);
					cell.setPhrase(new Phrase("Estoque", font));
					table.addCell(cell);
					cell.setPhrase(new Phrase("Quantidade", font));
					table.addCell(cell);
					
				}
				//Quebrando Linha
				doc.newPage();
			}

			// doc.add(titulo);
			// doc.add(subtitulo);
			// doc.add(table);
			doc.close();

		} catch (DocumentException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
