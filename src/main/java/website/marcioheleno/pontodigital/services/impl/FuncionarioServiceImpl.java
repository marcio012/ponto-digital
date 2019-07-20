package website.marcioheleno.pontodigital.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import website.marcioheleno.pontodigital.entities.Funcionario;
import website.marcioheleno.pontodigital.repository.FuncionarioRepository;
import website.marcioheleno.pontodigital.services.FuncionarioService;

import java.util.Optional;

@Slf4j
@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;


    @Override
    public Funcionario persistir(Funcionario funcionario) {
        log.info("Persistindo um funcionario no banco de dados => ", funcionario);
        return this.funcionarioRepository.save(funcionario);
    }

    @Override
    public Optional<Funcionario> buscarPorCpf(String cpf) {
        log.info("Buscando um funcionario no banco pelo cpf => ", cpf);
        return Optional.ofNullable(this.funcionarioRepository.findByCpf(cpf));
    }

    @Override
    public Optional<Funcionario> buscarPorEmail(String email) {
        log.info("Buscando um funcionario no banco pelo email => ", email);
        return Optional.ofNullable(this.funcionarioRepository.findByEmail(email));
    }

    @Override
    public Optional<Funcionario> buscarPorId(Long id) {
        log.info("Buscando um funcionario no banco de dados pelo id => ", id);
        return Optional.ofNullable(this.funcionarioRepository.getOne(id));
    }
}
