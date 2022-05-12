package br.com.cometa.pedidoshorti.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cometa.pedidoshorti.dto.InserirPedidoDTO;
import br.com.cometa.pedidoshorti.dto.PedidoAdmDTO;
import br.com.cometa.pedidoshorti.dto.PedidoExportacaoDTO;
import br.com.cometa.pedidoshorti.dto.PedidoRenderDTO;
import br.com.cometa.pedidoshorti.dto.RelatorioPedidoFornecedorDTO;
import br.com.cometa.pedidoshorti.entities.Pedido;
import br.com.cometa.pedidoshorti.services.PedidoService;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin("*")
public class PedidoController {
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	private PedidoService service;
	
	@PostMapping
	public ResponseEntity<Pedido> create(@RequestBody InserirPedidoDTO obj) throws ParseException{
		Pedido newObj = service.create(obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	@GetMapping
	public ResponseEntity<List<Pedido>> findAll(){
		List<Pedido> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> findById(@PathVariable Integer id){
		Pedido obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/data/{data}")
	public ResponseEntity<List<PedidoRenderDTO>> findByData(@PathVariable String data) throws ParseException{
		Date novaData = sdf.parse(data);
		List<PedidoRenderDTO> list = service.findByData(novaData);
		return ResponseEntity.ok().body(list);
	}
	
	@PutMapping
	public ResponseEntity<Pedido> update(@RequestBody InserirPedidoDTO obj){
		Pedido pedido = service.update(obj);
		return ResponseEntity.ok().body(pedido);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/adm/{data}")
	public ResponseEntity<List<PedidoAdmDTO>> findByDataAdm(@PathVariable String data) throws ParseException{
		Date novaData = sdf.parse(data);
		List<PedidoAdmDTO> pedidos= service.findByDataForAdm(novaData);
		return ResponseEntity.ok().body(pedidos);
	}
	
	@GetMapping(value = "/adm/exportacao/{data}")
	public ResponseEntity<List<PedidoExportacaoDTO>> findByDataAdmExportacao(@PathVariable String data) throws ParseException{
		Date novaData = sdf.parse(data);
		List<PedidoExportacaoDTO> pedidos= service.findByDateExportacao(novaData);
		return ResponseEntity.ok().body(pedidos);
	}
	
	@GetMapping(value = "/adm/exportacao/pdf/{data}")
	public ResponseEntity<Void> findByDataAdmExportacaoPdf(@PathVariable String data) throws ParseException{
		Date novaData = sdf.parse(data);
		service.gerarPdf(novaData);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/adm/{data}/fornecedor/{id}")
	public ResponseEntity<List<PedidoAdmDTO>> findByDataAdmFornecedor(@PathVariable String data, @PathVariable Integer id) throws ParseException{
		Date novaData = sdf.parse(data);
		List<PedidoAdmDTO> pedidos= service.findByDataForAdmPorFornecedor(novaData, id);
		return ResponseEntity.ok().body(pedidos);
	}
	
	@GetMapping(value = "/adm/{data}/fornecedoratt/{id}")
	public ResponseEntity<RelatorioPedidoFornecedorDTO> findByDataAdmFornecedorAtt(@PathVariable String data, @PathVariable Integer id) throws ParseException{
		Date novaData = sdf.parse(data);
		RelatorioPedidoFornecedorDTO pedidos= service.findByDataForAdmPorFornecedorAtt(novaData, id);
		return ResponseEntity.ok().body(pedidos);
	}
	
	@GetMapping(value = "/admatt/{data}")
	public ResponseEntity<List<RelatorioPedidoFornecedorDTO>> findByDataAdmatt(@PathVariable String data) throws ParseException{
		Date novaData = sdf.parse(data);
		List<RelatorioPedidoFornecedorDTO> pedidos= service.findByDataForAdmAtt(novaData);
		return ResponseEntity.ok().body(pedidos);
	}
	
	@GetMapping(value = "/data/{data}/loja/{id}")
	public ResponseEntity<List<PedidoRenderDTO>> findByDataByLoja(@PathVariable String data, @PathVariable Integer id) throws ParseException{
		Date novaData = sdf.parse(data);
		List<PedidoRenderDTO> list = service.findByDataAndLoja(novaData, id);
		return ResponseEntity.ok().body(list);
	}
}
