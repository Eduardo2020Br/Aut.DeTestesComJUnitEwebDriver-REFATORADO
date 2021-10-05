package modulos.produtos;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.LoginPage;

import java.time.Duration;

@DisplayName ("Testes WEB do módulo de produtos")
public class ProdutosTest {

    private WebDriver navegador ;

    @BeforeEach
    public void beforeEach () {
        // Abrir o Navegador
        System.setProperty("webdriver.chrome.driver","C:\\driverChrome\\chromedriver.exe");
        //WebDriver navegador = new ChromeDriver(); tenho mudar devido atributo criado
        this.navegador = new ChromeDriver(); // agora SIMMMMM esse atributo recebeu o BROWSER
        // e fazer em todos dentro desse metodo...

        // Maximizar a tela
        this.navegador.manage().window().maximize();

        // Vou definir um tempo de espera padrão
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Navegar para a página da Lojinha WEB
        this.navegador.get("http://165.227.93.41/lojinha-web/v2/");
    }

    @Test
    @DisplayName("Não é permitido registrar um produto com valor igual a ZERO")
    public void testNaoEpermitidoRegistrarProdutoComValorIgualAzero(){

        // Fazer Login
        String mensagemApresentada = new LoginPage(navegador) // Refatorado
                .informarOususario("admin")
                .informarAsenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioAdicaoNovoProduto()
                .informarNomeDoProduto("MacBook Pro")
                .informarValorDoProduto("000")
                .informarCoresDoProduto("verde, rosa")
                .submeterFormularioComErro()
                .capturarMensagemApresentada ();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00",mensagemApresentada);
        
    }
    @AfterEach
    public void afterEach () {
        // Vou fechar o navegador
        navegador.quit();
    }
}
