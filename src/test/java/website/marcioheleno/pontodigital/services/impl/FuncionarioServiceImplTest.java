package website.marcioheleno.pontodigital.services.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import website.marcioheleno.pontodigital.entities.Funcionario;
import website.marcioheleno.pontodigital.repository.FuncionarioRepository;
import website.marcioheleno.pontodigital.services.FuncionarioService;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class FuncionarioServiceImplTest {

    @MockBean
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private FuncionarioService funcionarioService;

    @Before
    public void setUp() throws Exception {
        BDDMockito.given(this.funcionarioRepository
            .save(Mockito.any(Funcionario.class)))
            .willReturn(new Funcionario());

        BDDMockito.given(this.funcionarioRepository
            .getOne(Mockito.anyLong()))
            .willReturn(new Funcionario());

        BDDMockito.given(this.funcionarioRepository
            .findByEmail(Mockito.anyString()))
            .willReturn(new Funcionario());

        BDDMockito.given(this.funcionarioRepository
            .findByCpf(Mockito.anyString()))
            .willReturn(new Funcionario());
    }

    @Test
    public void persistir() {
        Funcionario funcionario = this.funcionarioService.persistir(new Funcionario());
        assertNotNull(funcionario);
    }

    @Test
    public void buscarPorCpf() {
        Optional<Funcionario> funcionario = this.funcionarioService.buscarPorCpf("1234567890");
        assertTrue(funcionario.isPresent());
    }

    @Test
    public void buscarPorEmail() {
        Optional<Funcionario> funcionario = this.funcionarioService.buscarPorEmail("email@email.com");
        assertTrue(funcionario.isPresent());
    }

    @Test
    public void buscarPorId() {
        Optional<Funcionario> funcionario = this.funcionarioService.buscarPorId(1L);
        assertTrue(funcionario.isPresent());
    }
}
