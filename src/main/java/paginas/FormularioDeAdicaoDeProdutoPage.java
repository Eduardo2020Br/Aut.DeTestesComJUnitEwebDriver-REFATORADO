package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormularioDeAdicaoDeProdutoPage {

    private WebDriver navegador;

    public FormularioDeAdicaoDeProdutoPage (WebDriver navegador) {
        this.navegador = navegador;
    }

    public FormularioDeAdicaoDeProdutoPage informarNomeDoProduto (String produtoNome) {
        navegador.findElement(By.id("produtonome")).sendKeys(produtoNome);
        return this; // Quero retornar essa mesma pagina onde estou
    }

    public FormularioDeAdicaoDeProdutoPage informarValorDoProduto ( String produtoValor) {
        navegador.findElement(By.name("produtovalor")).sendKeys(produtoValor);
        return this; //
    }

    public FormularioDeAdicaoDeProdutoPage informarCoresDoProduto ( String coresProduto) {
        navegador.findElement(By.id("produtocores")).sendKeys(coresProduto);
        return this;
    }
    // Aqui não vai mais ficar NESTA PAGINA
    public ListaDePRodutosPage submeterFormularioComErro () {
        navegador.findElement(By.cssSelector("button[type='submit']")).click();

        return new ListaDePRodutosPage(navegador);
    }

}
