package website.marcioheleno.pontodigital.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import website.marcioheleno.pontodigital.entities.Lancamento;

import java.util.Optional;

public interface LancamentoService {

    /**
     * @param funcionarioId
     * @param pageRequest
     * @return Page<Lancamento>
     */
    Page<Lancamento> buscarPorFuncionarioId(Long funcionarioId, PageRequest pageRequest);

    /**
     * @param id
     * @return Optional<Lancamento>
     */
    Optional<Lancamento> buscarPorId(Long id);

    /**
     * @param lancamento
     * @return lancamento
     */
    Lancamento persistir(Lancamento lancamento);

    /**
     * @param id
     */
    void remover(Long id);
}
