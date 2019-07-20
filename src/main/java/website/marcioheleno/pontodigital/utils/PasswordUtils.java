package website.marcioheleno.pontodigital.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PasswordUtils {


    /**
     * Gera um hash utilizando o BCrypt
     *
     * @param senha
     * @return String
     */
    public static String gerarBCrypt(String senha) {
        if (senha == null) {
            return senha;
        }

        log.info("Gerando hash com o BCrypt");
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(senha);
    }

}
