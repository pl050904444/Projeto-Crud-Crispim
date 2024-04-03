import Entidades.Orcamento;
import Interfaces.OrcamentoService;
import Proxy.OrcamentoServiceProxy;
import Services.OrcamentoServiceImpl;

public class Main {
    public static void main(String[] args) {
        // Criando serviço real e proxy
        OrcamentoService orcamentoService = new OrcamentoServiceImpl();
        OrcamentoService orcamentoServiceProxy = new OrcamentoServiceProxy(orcamentoService);

        // Criando e manipulando orcamentos
        Orcamento orcamento1 = new Orcamento();
        orcamento1.setId(1);
        orcamento1.setValor(100.0);
        orcamento1.setQtdItens(5);
        orcamento1.setDesconto(10.0);

        orcamentoServiceProxy.criarOrcamento(orcamento1);

        Orcamento orcamentoRecuperado = orcamentoServiceProxy.getOrcamento(1);
        System.out.println("Orcamento recuperado: " + orcamentoRecuperado);

        // Testando o atraso na primeira chamada
        long startTime = System.currentTimeMillis();
        orcamentoRecuperado = orcamentoServiceProxy.getOrcamento(1);
        long endTime = System.currentTimeMillis();
        System.out.println("Tempo de execução da segunda chamada: " + (endTime - startTime) + "ms");

        // Deletando orcamento
        orcamentoServiceProxy.deletarOrcamento(1);
    }
}