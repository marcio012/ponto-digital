package website.marcioheleno.pontodigital.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import website.marcioheleno.pontodigital.entities.Lancamento;
import website.marcioheleno.pontodigital.repository.LancamentoRepository;
import website.marcioheleno.pontodigital.services.LancamentoService;

import java.util.Optional;

@Slf4j
@Service
public class LancamentoServiceImpl implements LancamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @Override
    public Page<Lancamento> buscarPorFuncionarioId(Long funcionarioId, PageRequest pageRequest) {
        log.info("buscando lacamentos para o funcionario de id => ", funcionarioId);
        return this.lancamentoRepository.findByFuncionarioId(funcionarioId, pageRequest);
    }

    @Override
    public Optional<Lancamento> buscarPorId(Long id) {
        log.info("buscando lacamentos pelo id do funcionario => ", id);
        return Optional.ofNullable(this.lancamentoRepository.getOne(id));
    }

    @Override
    public Lancamento persistir(Lancamento lancamento) {
        log.info("salvando lacamentos => ", lancamento);
        return this.lancamentoRepository.save(lancamento);
    }

    @Override
    public void remover(Long id) {
        log.info("removendo lacamentos de id => ", id);
        this.lancamentoRepository.deleteById(id);

    }
}
