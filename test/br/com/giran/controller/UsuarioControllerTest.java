package br.com.giran.controller;

import static org.mockito.Mockito.verify;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.util.test.MockResult;
import br.com.giran.model.Usuario;
import br.com.giran.repository.UsuarioRepository;

public class UsuarioControllerTest {

	private UsuarioController controller;

	@Mock
	private UsuarioRepository repository;

	@Spy
	private Result result = new MockResult();
	private Usuario usuario;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		controller = new UsuarioController(repository, result);
	}

	@Test
	public void deveriaListagemTest() throws Exception{
		// given
		
		// when
		controller.listagem();
		
		// then
		verify(repository).loadAll();
		verify(result).include("usuarioList", new ArrayList<Usuario>());
	}
	
	@Test
	public void deveriaSalvarTest() throws Exception {
		// given
		dadoQueTenhoUmUsuarioChamado("Deivid");

		// when
		controller.salvar(usuario);

		// then
		verify(repository).save(usuario);
		verify(result).include("message", "Usuário salvo com sucesso!");
	}

	@Test
	public void deveriaEditarTest() throws Exception {
		// given
		dadoQueTenhoUmUsuarioChamado("André Lima");

		// when
		controller.editar(usuario);

		//then
		usuario = verify(repository).loadById(usuario.getId());
		verify(result).include("usuario", usuario);
	}

	@Test
	public void deveriaExibirTest() throws Exception {
		// given
		dadoQueTenhoUmUsuarioChamado("Rodolfo");

		// when
		controller.editar(usuario);

		//then
		usuario = verify(repository).loadById(usuario.getId());
		verify(result).include("usuario", usuario);
	}

	private void dadoQueTenhoUmUsuarioChamado(String nome) {
		usuario = new Usuario();
		usuario.setId(42l);
		usuario.setNome(nome);
	}

}