package br.com.giran.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.giran.model.Usuario;
import br.com.giran.repository.UsuarioRepository;

@Resource
public class UsuarioController {

	private final UsuarioRepository usuarioRepository;
	private final Result result;

	UsuarioController(UsuarioRepository usuarioRepository,Result result) {
		this.usuarioRepository = usuarioRepository;
		this.result = result;
	}

	@Get("/usuario/novo")
	public void novo() {

	}

	@Get("/usuario")
	public void listagem() {
		try {
			result.include("usuarioList", usuarioRepository.loadAll());
		} catch (Exception e) {
			e.printStackTrace();
			result.include("error", e.getMessage()).redirectTo(IndexController.class).index();
		}
	}

	@Post("/usuario")
	public void salvar(Usuario usuario) {
		try {
			usuarioRepository.save(usuario);
		} catch (Exception e) {
			e.printStackTrace();
			result.include("error", e.getMessage()).forwardTo(this).novo();
		}

		result.include("message", "Usu‡rio salvo com sucesso!").forwardTo(this).listagem();
	}
	
	@Put("/usuario")
	public void editar(Usuario usuario) {
		try {
			usuario = usuarioRepository.loadById(usuario.getId());
			result.include("usuario", usuario).forwardTo(this).novo();
		} catch (Exception e) {
			e.printStackTrace();
			result.redirectTo(this).exibir(usuario);
		}
	}

	@Get("/usuario/{usuario.id}")
	public void exibir(Usuario usuario) {
		try {
			result.include("usuario", usuarioRepository.loadById(usuario.getId()));
		} catch (Exception e) {
			e.printStackTrace();
			result.include("error", e.getMessage()).redirectTo(this).listagem();
		}
	}

}