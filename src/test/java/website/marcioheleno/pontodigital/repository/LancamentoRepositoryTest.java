package website.marcioheleno.pontodigital.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import website.marcioheleno.pontodigital.entities.Empresa;
import website.marcioheleno.pontodigital.entities.Funcionario;
import website.marcioheleno.pontodigital.entities.Lancamento;
import website.marcioheleno.pontodigital.entities.enums.PerfilEnum;
import website.marcioheleno.pontodigital.entities.enums.TipoEnum;
import website.marcioheleno.pontodigital.utils.PasswordUtils;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class LancamentoRepositoryTest {

    @Autowired
    LancamentoRepository lancamentoRepository;

    @Autowired
    FuncionarioRepository funcionarioRepository;

    @Autowired
    EmpresaRepository empresaRepository;

    private Long funcionarioId;

    private Empresa gerarUmaEmpresa() {
        Empresa empresa = new Empresa();
        empresa.setRazaoSocial("Empresa do Universos");
        empresa.setCnpj("12345678901234");
        return empresa;
    }

    private Funcionario gerarUmFuncionario(Empresa empresa) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Senhor do Universo");
        funcionario.setPerfilEnum(PerfilEnum.ROLE_USUARIO);
        funcionario.setSenha(PasswordUtils.gerarBCrypt("123456"));
        funcionario.setCpf("12345678901");
        funcionario.setEmail("suniverso@email.com");
        funcionario.setEmpresa(empresa);
        return funcionario;
    }

    private Lancamento gerarUmLancamento(Funcionario funcionario) {
        Lancamento lancamento = new Lancamento();
        lancamento.setData(new Date());
        lancamento.setTipo(TipoEnum.INICIO_ALMOÇO);
        lancamento.setFuncionario(funcionario);
        return lancamento;
    }

    @Before
    public void setUp() throws Exception {
        Empresa empresa = this.empresaRepository.save(gerarUmaEmpresa());
        Funcionario funcionario = this.funcionarioRepository.save(gerarUmFuncionario(empresa));

        this.funcionarioId = funcionario.getId();

        this.lancamentoRepository.save(gerarUmLancamento(funcionario));
        this.lancamentoRepository.save(gerarUmLancamento(funcionario));

    }

    @After
    public void tearDown() throws Exception {
        this.empresaRepository.deleteAll();
    }


    @Test
    public void testBuscarLancamentosPorFuncionarioId() {
        List<Lancamento> lancamentos = this.lancamentoRepository.findByFuncionarioId(funcionarioId);

        assertEquals(2, lancamentos.size());
    }

    @Test
    public void testBuscarLancamentosPorFuncionarioIdPaginado() {
        PageRequest page = new PageRequest(0, 10);
        Page<Lancamento> lancamentos = this.lancamentoRepository.findByFuncionarioId(funcionarioId, page);

        assertEquals(2, lancamentos.getTotalElements());
    }
}
