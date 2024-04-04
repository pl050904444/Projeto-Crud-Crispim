package Services;

import Entidades.Orcamento;
import Interfaces.OrcamentoService;

import java.sql.*;

public class OrcamentoServiceImpl implements OrcamentoService {
    private Connection connection;

    public OrcamentoServiceImpl() {
        try {
            String url = "jdbc:mysql://localhost/money?useSSL=false&serverTimezone=UTC";
            String user = "root";
            String password = "money123";
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Orcamento getOrcamento(int id) {
        Orcamento orcamento = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM orcamento WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                orcamento = new Orcamento();
                orcamento.setId(resultSet.getInt("id"));
                orcamento.setValor(resultSet.getDouble("valor"));
                orcamento.setQtdItens(resultSet.getInt("qtd_itens"));
                orcamento.setDesconto(resultSet.getDouble("desconto"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orcamento;
    }

    @Override
    public void criarOrcamento(Orcamento orcamento) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO orcamento (id, valor, qtd_itens, desconto) VALUES (?, ?, ?, ?)");
            statement.setInt(1, orcamento.getId());
            statement.setDouble(2, orcamento.getValor());
            statement.setInt(3, orcamento.getQtdItens());
            statement.setDouble(4, orcamento.getDesconto());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizarOrcamento(Orcamento orcamento) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE orcamento SET valor = ?, qtd_itens = ?, desconto = ? WHERE id = ?");
            statement.setDouble(1, orcamento.getValor());
            statement.setInt(2, orcamento.getQtdItens());
            statement.setDouble(3, orcamento.getDesconto());
            statement.setInt(4, orcamento.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletarOrcamento(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM orcamento WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}