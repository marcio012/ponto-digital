package website.marcioheleno.pontodigital.services.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import website.marcioheleno.pontodigital.entities.Lancamento;
import website.marcioheleno.pontodigital.repository.LancamentoRepository;
import website.marcioheleno.pontodigital.services.LancamentoService;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class LancamentoServiceImplTest {

    @MockBean
    private LancamentoRepository lancamentoRepository;

    @Autowired
    private LancamentoService lancamentoService;

    @Before
    public void setUp() throws Exception {
        BDDMockito.given(this.lancamentoRepository
            .findByFuncionarioId(Mockito.anyLong(), Mockito.any(PageRequest.class)))
            .willReturn(new PageImpl<Lancamento>(new ArrayList<Lancamento>()));
        BDDMockito.given(this.lancamentoRepository.getOne(Mockito.anyLong())).willReturn(new Lancamento());
        BDDMockito.given(this.lancamentoRepository.save(Mockito.any(Lancamento.class))).willReturn(new Lancamento());
    }

    @Test
    public void buscarPorFuncionarioId() {
        Page<Lancamento> lancamento = this.lancamentoService.buscarPorFuncionarioId(1L, new PageRequest(0, 10));
        assertNotNull(lancamento);
    }

    @Test
    public void buscarPorId() {
        Optional<Lancamento> lancamento = this.lancamentoService.buscarPorId(1L);
        assertTrue(lancamento.isPresent());
    }

    @Test
    public void persistir() {
        Lancamento lancamento = this.lancamentoService.persistir(new Lancamento());
        assertNotNull(lancamento);
    }

    @Test
    public void remover() {

    }
}
