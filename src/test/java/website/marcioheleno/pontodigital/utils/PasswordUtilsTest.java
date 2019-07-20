package website.marcioheleno.pontodigital.utils;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.Assert.*;

public class PasswordUtilsTest {

    private static final String SENHA = "123456";

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Test
    public void gerarSenhaNula() {
        assertNull(PasswordUtils.gerarBCrypt(null));
    }

    @Test
    public void gerarBCrypt() {
        String hash = PasswordUtils.gerarBCrypt(SENHA);

        assertTrue(bCryptPasswordEncoder.matches(SENHA, hash));
    }
}
