package sptech.school.exemplo_hexagonal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// Teste basico para validar se o contexto Spring inicia corretamente.
@SpringBootTest(classes = ExemploHexagonalApplication.class)
class ExemploHexagonalApplicationTests {

    @Test
    // Se a aplicacao subir sem excecao, o teste passa.
    void contextLoads() {
    }
}