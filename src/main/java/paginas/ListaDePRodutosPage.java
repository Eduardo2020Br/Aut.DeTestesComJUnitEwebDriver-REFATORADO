package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListaDePRodutosPage {
    private WebDriver navegador;

    public ListaDePRodutosPage (WebDriver navegador) {
        this.navegador = navegador;
    }

    public FormularioDeAdicaoDeProdutoPage acessarFormularioAdicaoNovoProduto () {

        navegador.findElement(By.linkText("ADICIONAR PRODUTO")).click();

        return new FormularioDeAdicaoDeProdutoPage(navegador);
    }
    public String capturarMensagemApresentada () {
        return navegador.findElement(By.cssSelector(".toast.rounded")).getText();
    }
}
