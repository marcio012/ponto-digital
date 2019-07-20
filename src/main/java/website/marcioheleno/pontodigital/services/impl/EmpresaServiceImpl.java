package website.marcioheleno.pontodigital.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import website.marcioheleno.pontodigital.entities.Empresa;
import website.marcioheleno.pontodigital.repository.EmpresaRepository;
import website.marcioheleno.pontodigital.services.EmpresaService;

import java.util.Optional;

@Slf4j
@Service
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public Optional<Empresa> buscarPorCnpj(String cnpj) {
        log.info("Buscando uma empresa pelo cnpj => ", cnpj);
        return Optional.ofNullable(empresaRepository.findByCnpj(cnpj));
    }

    @Override
    public Empresa persistir(Empresa empresa) {
        log.info("Persistindo no banco a empresa => ", empresa);
        return this.empresaRepository.save(empresa);
    }
}
