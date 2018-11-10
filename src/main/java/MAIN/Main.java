package MAIN;

import br.com.pizzaria.Enum.StatusPedido;
import br.com.pizzaria.dao.PedidoDAO;
import br.com.pizzaria.dao.PessoaDAO;
import br.com.pizzaria.Enum.TipoPessoa;
import br.com.pizzaria.dao.Item_PedidoDAO;
import br.com.pizzaria.model.Item_PedidoModel;
import br.com.pizzaria.model.PedidoModel;
import br.com.pizzaria.model.PessoaModel;
import br.com.pizzaria.util.ErroSistema;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @Eliezer
 */
public class Main {

    public static void main(String[] args) throws ErroSistema {
        
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WS_PIZZARIA");
//        emf.close();
        
//        PessoaDAO dao = new PessoaDAO();
//        PessoaModel p = new PessoaModel();
        
//        p.setId(4);
//        p.setNome("Eliezer Bignati");
//        p.setCpf("662.268.642-49");
//        p.setRg("763.633");
//        p.setCep("13188-072");
//        p.setRua("Rua 6");
//        p.setBairro("J.Amanda l");
//        p.setCidade("Hortolandia");
//        p.setEmail("eliezer@gmail.com");
//        p.setFone("(019)3819-2370");
//        p.setUf("sp");
//        p.setNr("126");
//        p.setTipo(TipoPessoa.CLIENTE);
//        dao.salvar(p);
        
//        p.setNome("Tutinha Miranda");
//        p.setCpf("222.222.222-22");
//        p.setRg("222.222.22");
//        p.setCep("13188-072");
//        p.setRua("Rua 6");
//        p.setBairro("J.Amanda l");
//        p.setCidade("Hortolandia");
//        p.setEmail("tuia@gmail.com");
//        p.setFone("(019)3819-2370");
//        p.setUf("sp");
//        p.setNr("222");
//        p.setTipo(TipoPessoa.CLIENTE);
//        dao.salvar(p);
//
//        p = new PessoaModel();
//        p.setNome("Nivia Miranda");
//        p.setCpf("333.333.333-33");
//        p.setRg("33.222.22");
//        p.setCep("13188-072");
//        p.setRua("Rua 6");
//        p.setBairro("J.Amanda l");
//        p.setCidade("Hortolandia");
//        p.setEmail("nivia@gmail.com");
//        p.setFone("(019)3819-2370");
//        p.setUf("sp");
//        p.setNr("33");
//        p.setTipo(TipoPessoa.ENTREGADOR);
//        dao.salvar(p);
        
//        dao.deletar(1);
//        List<PessoaModel> lista = dao.getListaNomes("miranda");
//        for (PessoaModel pess : lista ) {
//            System.out.println("NOME :" + pess.getNome());
//        }

//    PedidoDAO dao = new PedidoDAO();
//    PessoaDAO pessDAO = new PessoaDAO();
    
//    PedidoModel p = new PedidoModel();
//    p.setCliente_id(pessDAO.getId(1));
//    p.setDt_pedido(new Date());
//    p.setEntregador_id(pessDAO.getId(3));
//    p.setQtd_ttal(2);
//    p.setStatus_pedido(StatusPedido.AGENDADO);
//    p.setVlr_ttal(65.00);
//    dao.salvar(p);

//    PedidoModel p = new PedidoModel();
//    p.setCliente_id(pessDAO.getId(2));
//    p.setDt_pedido(new Date());
//    p.setEntregador_id(pessDAO.getId(3));
//    p.setQtd_ttal(2);
//    p.setStatus_pedido(StatusPedido.AGENDADO);
//    p.setVlr_ttal(22.00);
//    dao.salvar(p);

//        Item_PedidoDAO itemDAO = new Item_PedidoDAO();
//        
//        Item_PedidoModel item = new Item_PedidoModel(1,"Pizza calabresa", 2, 3.00, 6.00);
//        Item_PedidoModel item = new Item_PedidoModel(2,"Cerveja", 2, 3.00, 6.00);
//        itemDAO.salvar(item);

//    PedidoModel p = dao.getCpfCliente("662.268.642-49");
//        System.out.println("CPF......."+p.getCliente_id().getNome()+"-----"+p.getListaItens().toString());
           
//    List<PedidoModel> listaP = dao.getLista();
//    for (PedidoModel p : listaP){
//        System.out.println("ITEMSSSS  :"+p.getListaItens().toString());
//    }
//    PedidoModel p = dao.getId(1);
//    List<Item_PedidoModel> lista = p.getListaItens();
//    for (Item_PedidoModel i : lista){
//        System.out.println("DESCRIÇÃO....."+i.getDescricao());
//    }
    String cpf = "662.269.642-4999";

    if (cpf.length() != 14){
          System.out.println("OK validou...."+cpf.length());    
        }

    }

}
