package br.com.fateczl.engetec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.fateczl.engetec.dto.AlunoDTO;
import br.com.fateczl.engetec.entity.Aluno;
import br.com.fateczl.engetec.entity.Mensagem;
//import br.com.fateczl.engetec.entity.Role;
import br.com.fateczl.engetec.entity.Usuario;
import br.com.fateczl.engetec.entity.UsuarioRole;
import br.com.fateczl.engetec.repository.AlunoRepository;
import br.com.fateczl.engetec.valida.ValidaPassword;

@Service
public class AlunoService {

	@Autowired
	private Mensagem mensagem;
	
//	@Autowired
//	private HashSenha hashSenha;
//	
	@Autowired
	private AlunoRepository alunoRepository;
	
//	@Autowired 
//	private UsuarioUtilService alunoUsuarioUtilService;
	
	//Método para cadastrar alunos 
	public ResponseEntity<?> cadastrar(AlunoDTO alunoDTO) {
//		if (!ValidaPassword.validarTamanho(alunoDTO.password())) 
//			return new ResponseEntity<>
//		("A senha deve ter no mínimo 6 caracteres", HttpStatus.BAD_REQUEST);
		
		//comentei o q esta abaixo agr
//		if(alunoUsuarioUtilService.usuarioServiceFindByEmail(alunoDTO.email()) != null) {
//			mensagem.setMensagem("email já existe");
//			return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
//		} else if(alunoRepository.countByRa(alunoDTO.ra())!=0){
//			mensagem.setMensagem("RA já existe");
//			return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
//		}
		
		if(alunoRepository.findByEmail(alunoDTO.email()) != null) {
			mensagem.setMensagem("email já existe");
			return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
		} else if(alunoRepository.countByRa(alunoDTO.ra())!=0){
			mensagem.setMensagem("RA já existe");
			return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
		}
		String encryptedPassword = new BCryptPasswordEncoder().encode(alunoDTO.password());
		System.out.println(alunoDTO.email());
		Usuario usuario = new Usuario(alunoDTO.email(), alunoDTO.nome(), encryptedPassword, UsuarioRole.ALUNO);
		Aluno aluno = new Aluno(alunoDTO.ra(), usuario);
		
		return new ResponseEntity<>(alunoRepository.save(aluno), HttpStatus.CREATED);
	}
	
	//Método para selecionar alunos
	public ResponseEntity<?> selecionar(){
		return new ResponseEntity<>(alunoRepository.findAll(), HttpStatus.OK);
	}
	
	//Método para selecionar alunos através do RA
	public ResponseEntity<?> selecionarPeloRa(Long ra) {
		//procurando no banco de dados se existe algum aluno com o Ra do parâmetro
		if(alunoRepository.countByRa(ra)==0) {
			mensagem.setMensagem("Não foi econtrada nenhum aluno com o RA informado");
			return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(alunoRepository.findByRa(ra), HttpStatus.OK);
		}
	}
	
//	// Método para editar dados
//	public ResponseEntity<?> editar(AlunoDTO alunoDTO){
//		if(alunoRepository.countByRa(alunoDTO.getRa()) == 0) {
//			mensagem.setMensagem("O RA informado não existe.");
//			return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
//		} else {
//			Aluno alunoNew = alunoDtoToAluno(alunoDTO);
//			Usuario usuarioNew = alunoDtoToUsuario(alunoDTO);
//			alunoNew.setUsuario(usuarioNew);
//			
//			Aluno alunoOld = findByRa(alunoDTO.getRa());
//			
//			if(usuarioService.countByEmail(alunoDTO.getEmail())!=0){
//			mensagem.setMensagem("email já existe");
//			return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
//			return new ResponseEntity<>(alunoRepository.save(aluno), HttpStatus.OK);
//			}
//		}
//		
//	}
	
//	// Método para editar dados
//	public ResponseEntity<?> editarEmail(Long ra, String novoEmail){
//		if(alunoRepository.countByRa(ra) == 0) {
//			mensagem.setMensagem("O RA informado não existe.");
//			return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
//		} else {
//			Aluno aluno = alunoRepository.findByRa(ra);
//			Usuario usuarioNew = alunoDtoToUsuario(alunoDTO);
//			alunoNew.setUsuario(usuarioNew);
//			
//			Aluno alunoOld = findByRa(alunoDTO.getRa());
//			
//			if(usuarioService.countByEmail(alunoDTO.getEmail())!=0){
//			mensagem.setMensagem("email já existe");
//			return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
//			return new ResponseEntity<>(alunoRepository.save(aluno), HttpStatus.OK);
//			}
//		}
//		
//	}
	
	public ResponseEntity<?> addArtigo(Long ra){
		
		if(alunoRepository.countByRa(ra) == 0) {
			mensagem.setMensagem("O RA informado não existe.");
			return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
		}else {
			Aluno aluno = findByRa(ra);
			alunoRepository.delete(aluno);
			
			mensagem.setMensagem("Pessoa removida com sucesso");
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		}
		
	} 
	
//	public Aluno findByUsuario(Usuario usuario) {
//		return alunoRepository.findByUsuario(usuario);
//	}
	
//	// Método para remover registros
//	public ResponseEntity<?> remover(Long ra){
//		
//		if(alunoRepository.countByRa(ra) == 0) {
//			mensagem.setMensagem("O RA informado não existe.");
//			return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
//		}else {
//			Aluno aluno = findByRa(ra);
//			alunoRepository.delete(aluno);
//			
//			mensagem.setMensagem("Pessoa removida com sucesso");
//			return new ResponseEntity<>(mensagem, HttpStatus.OK);
//		}
//		
//	}

	public Aluno findByRa(Long ra) {
		return alunoRepository.findByRa(ra);
	}
	
	// para o post
	private Aluno alunoDtoToAluno(AlunoDTO alunoDTO) {
		Aluno aluno = new Aluno(alunoDTO.ra());
		return aluno;
	}
		
	private Usuario alunoDtoToUsuario(AlunoDTO alunoDTO) {
//		String nomeRole = "ROLE_ALUNO";
//		Role role = new Role(nomeRole);
		Usuario usuario = new Usuario(alunoDTO.email(), alunoDTO.nome() /*role*/);
		return usuario;
	}
	// para o put
//	private Aluno alunoDtoToAluno(AlunoDTO alunoDTO) {
//		Aluno aluno = new Aluno(Long.parseLong(alunoDTO.getRa()), alunoDTO.getEmail(), 
//				alunoDTO.getNome());
//		return aluno;
//	}

	public ResponseEntity<?> delete(Long documento) {
		if(alunoRepository.countByRa(documento)!=0) {
			
			alunoRepository.deleteById(
					alunoRepository.findByRa(documento).getId());
			return new ResponseEntity(HttpStatus.OK);
		}
		String mensagem = "Não há esse RA";
		return new ResponseEntity(mensagem, HttpStatus.NOT_FOUND);
	}
			
}
