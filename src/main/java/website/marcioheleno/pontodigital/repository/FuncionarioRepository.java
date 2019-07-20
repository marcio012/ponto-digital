package website.marcioheleno.pontodigital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import website.marcioheleno.pontodigital.entities.Funcionario;

@Transactional(readOnly = true)
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {


    Funcionario findByCpf(String cpf);
    Funcionario findByEmail(String email);
    Funcionario findByCpfOrEmail(String cpf, String email);
}
