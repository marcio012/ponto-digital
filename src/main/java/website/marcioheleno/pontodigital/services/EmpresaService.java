package website.marcioheleno.pontodigital.services;

import website.marcioheleno.pontodigital.entities.Empresa;

import java.util.Optional;

public interface EmpresaService {

    /**
     * @param cnpj
     * @return Optional<Empresa>
     */
    Optional<Empresa> buscarPorCnpj(String cnpj);

    /**
     * @param empresa
     * @return Empresa
     */
    Empresa persistir(Empresa empresa);
}
