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
import website.marcioheleno.pontodigital.entities.Empresa;
import website.marcioheleno.pontodigital.repository.EmpresaRepository;
import website.marcioheleno.pontodigital.services.EmpresaService;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class EmpresaServiceImplTest {

    @MockBean
    private EmpresaRepository empresaRepository;

    @Autowired
    private EmpresaService empresaService;

    private static final String CNPJ = "1234567890123";

    @Before
    public void setUp() throws Exception {
        BDDMockito.given(this.empresaRepository.findByCnpj(Mockito.anyString())).willReturn(new Empresa());
        BDDMockito.given(this.empresaRepository.save(Mockito.any(Empresa.class))).willReturn(new Empresa());
    }

    @Test
    public void buscarPorCnpj() {
        Optional<Empresa> empresa = this.empresaService.buscarPorCnpj(CNPJ);

        assertTrue(empresa.isPresent());
    }

    @Test
    public void persistir() {
        Empresa empresa = this.empresaService.persistir(new Empresa());

        assertNotNull(empresa);
    }
}
