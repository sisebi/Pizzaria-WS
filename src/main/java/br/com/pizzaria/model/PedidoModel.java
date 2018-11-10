
package br.com.pizzaria.model;

import br.com.pizzaria.Enum.StatusPedido;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @Eliezer
 */
@Entity
@Table(name = "tb_pedido")
public class PedidoModel implements Serializable{
    @Id
    @SequenceGenerator(name = "pedido_id",
            sequenceName = "seq_pedido_id",
            allocationSize = 1)
    @GeneratedValue(generator = "pedido_id",strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "cliente_id",
            referencedColumnName = "id",
            nullable = false)
    @ForeignKey(name = "fk_cliente_id")
    private PessoaModel cliente_id;
    
    @ManyToOne
    @JoinColumn(name = "entregador_id",
            referencedColumnName = "id",
            nullable = false)
    @ForeignKey(name = "fk_entregador_id")
    private PessoaModel entregador_id;
    
    private Double vlr_ttal;
    
    private Integer qtd_ttal;
    
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dt_pedido;
    
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) NOT NULL DEFAULT 'ABERTO'")
    private StatusPedido status_pedido;    
 
    @Transient //Não criar campo
    private List<Item_PedidoModel> listaItens = new ArrayList<>();

    public PedidoModel() {
    }

    public PedidoModel(Integer id, PessoaModel cliente_id, PessoaModel entregador_id, Double vlr_ttal, Integer qtd_ttal, Date dt_pedido, StatusPedido status_pedido) {
        this.id = id;
        this.cliente_id = cliente_id;
        this.entregador_id = entregador_id;
        this.vlr_ttal = vlr_ttal;
        this.qtd_ttal = qtd_ttal;
        this.dt_pedido = dt_pedido;
        this.status_pedido = status_pedido;
    }

    
    public void addLista(Item_PedidoModel i){
        i.setPedido_id(this.getId());
        this.listaItens.add(i);
    }
    public void deletarLista(int index){
        this.listaItens.remove(index);
    }

    public List<Item_PedidoModel> getListaItens() {
        return listaItens;
    }

    public void setListaItens(List<Item_PedidoModel> listaItens) {
        this.listaItens = listaItens;
    }
    
    public PessoaModel getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(PessoaModel cliente_id) {
        this.cliente_id = cliente_id;
    }

    public PessoaModel getEntregador_id() {
        return entregador_id;
    }

    public void setEntregador_id(PessoaModel entregador_id) {
        this.entregador_id = entregador_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Double getVlr_ttal() {
        return vlr_ttal;
    }

    public void setVlr_ttal(Double vlr_ttal) {
        this.vlr_ttal = vlr_ttal;
    }

    public Integer getQtd_ttal() {
        return qtd_ttal;
    }

    public void setQtd_ttal(Integer qtd_ttal) {
        this.qtd_ttal = qtd_ttal;
    }

    public Date getDt_pedido() {
        return dt_pedido;
    }

    public void setDt_pedido(Date dt_pedido) {
        this.dt_pedido = dt_pedido;
    }

    public StatusPedido getStatus_pedido() {
        return status_pedido;
    }

    public void setStatus_pedido(StatusPedido status_pedido) {
        this.status_pedido = status_pedido;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PedidoModel other = (PedidoModel) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PedidoModel{" + "id=" + id + ", cliente_id=" + cliente_id + ", entregador_id=" + entregador_id + ", vlr_ttal=" + vlr_ttal + ", qtd_ttal=" + qtd_ttal + ", dt_pedido=" + dt_pedido + ", status_pedido=" + status_pedido + '}';
    }
    
   
    
}
