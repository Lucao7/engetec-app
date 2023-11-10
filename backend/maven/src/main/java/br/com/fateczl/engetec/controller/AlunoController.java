package br.com.fateczl.engetec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.fateczl.engetec.dto.AlunoDTO;
import br.com.fateczl.engetec.entity.Disco;
import br.com.fateczl.engetec.repository.AlunoRepository;
import br.com.fateczl.engetec.repository.UsuarioRepository;
import br.com.fateczl.engetec.service.AlunoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
	
	@Autowired
	private Disco disco;
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private AlunoService alunoService;
	
	@GetMapping(path = "")
	public ResponseEntity<?> selecionar() {
		return alunoService.selecionar();
	}
	
	@GetMapping(path = "/{ra}")
	public ResponseEntity<?> selecionarPeloRa(@PathVariable Long ra) {
		return alunoService.selecionarPeloRa(ra);
	}
	
	@GetMapping("/count")
	public Long countAlunos() {
		return alunoRepository.count();
	}
	
//	@GetMapping("/ordenarNomesAsc")
//	public List<Aluno> ordenarNomesAsc() {
//		return alunoRepository.findByOrderByNomeAsc();
//	}
//	
//	@GetMapping("/ordenarNomesDesc")
//	public List<Aluno> ordenarNomesDesc() {
//		return alunoRepository.findByOrderByNomeDesc();
//	}
//	
//	@GetMapping("/filtrarNomes/{nome}")
//	public List<Aluno> filtrarNomes(@PathVariable String nome) {
//		return alunoRepository.findByNome(nome);
//	}
//	
//	@GetMapping("/filtrarNomesOrdenarRaDesc/{nome}")
//	public List<Aluno> filtrarNomesOrdenarPorRaDesc(@PathVariable String nome) {
//		return alunoRepository.findByNomeOrderByRaDesc(nome);
//	}
//	
//	@GetMapping("/nomeContem/{termo}")
//	public List<Aluno> nomeContem(@PathVariable String termo) {
//		return alunoRepository.findByNomeContaining(termo);
//	}
//	
//	@GetMapping("/nomeComecaCom/{termo}")
//	public List<Aluno> nomeComecaCom(@PathVariable String termo) {
//		return alunoRepository.findByNomeStartsWith(termo);
//	}
//	
//	@GetMapping("/nomeTerminaCom/{termo}")
//	public List<Aluno> nomeTerminaCom(@PathVariable String termo) {
//		return alunoRepository.findByNomeEndsWith(termo);
//	}
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@Valid @RequestBody AlunoDTO data) {

//		
//		this.usuarioRepository
		return alunoService.cadastrar(data);
	}
	
	@PostMapping(path = "/addArtigo")
	public void addArtigo(@RequestParam MultipartFile arquivo) {
		disco.salvarArtigo(arquivo);
	}
//	
//	@PostMapping(path = "/login")
//	public ResponseEntity<?> logar(@Valid @RequestBody AlunoLogin alunoLogin) {
//		return alunoService.logar(alunoLogin);
//	}
	
//	@PutMapping(path = "")
//	public ResponseEntity<?> editar(@Valid @RequestBody AlunoDTO alunoDTO) {
//		return alunoService.editar(alunoDTO);
//	}
	
//	@PatchMapping(path = "/edit/email")
//	public ResponseEntity<?> editarEmail(Long ra, String email) {
//		return alunoService.e
//	}
	
//	@PatchMapping(path = "/edit/email")
//	public ResponseEntity<?> editarEmail(Long ra, String novoEmail) {
//		return alunoService.ed
//	}
	
//	@DeleteMapping(path = "/{ra}")
//	public ResponseEntity<?> remover(@PathVariable Long ra) {
//		return alunoService.remover(ra);
//	}

	@GetMapping("/status")
	public ResponseEntity<?> status() {
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
