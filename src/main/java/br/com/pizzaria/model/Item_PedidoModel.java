
package br.com.pizzaria.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @Eliezer
 */
@Entity
@Table(name = "tb_item_pedido")
public class Item_PedidoModel implements Serializable{
    @Id
    @SequenceGenerator(name = "pedido_id"
            ,sequenceName = "seq_item_id"
            ,allocationSize = 1)
    @GeneratedValue(generator = "pedido_id",strategy = GenerationType.SEQUENCE)
    private Integer id;
    
//    @ManyToOne
//    @JoinColumn(name = "pedido_id",
//            referencedColumnName = "id",
//            nullable = false)
//    @ForeignKey(name = "fk_pedido_id")
    private Integer pedido_id;
    
    @Column(length = 100,nullable = false)
    private String descricao;
    
    @Column(nullable = false)
    private int qtd;
    
    @Column(nullable = false)
    private Double vlr_un;
    
    @Column(nullable = false)
    private Double vlr_un_ttal;

    public Item_PedidoModel() {
    }

    public Item_PedidoModel(Integer pedido_id, String descricao, int qtd, Double vlr_un, Double vlr_un_ttal) {
        this.pedido_id = pedido_id;
        this.descricao = descricao;
        this.qtd = qtd;
        this.vlr_un = vlr_un;
        this.vlr_un_ttal = vlr_un_ttal;
    }
     

    public Item_PedidoModel(Integer id, Integer pedido_id, String descricao, int qtd, Double vlr_un, Double vlr_un_ttal) {
        this.id = id;
        this.pedido_id = pedido_id;
        this.descricao = descricao;
        this.qtd = qtd;
        this.vlr_un = vlr_un;
        this.vlr_un_ttal = vlr_un_ttal;
    }

    public Double getVlr_un_ttal() {
        return vlr_un_ttal;
    }

    public void setVlr_un_ttal(Double vlr_un_ttal) {
        this.vlr_un_ttal = vlr_un_ttal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPedido_id() {
        return pedido_id;
    }

    public void setPedido_id(Integer pedido_id) {
        this.pedido_id = pedido_id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao.toUpperCase();
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public Double getVlr_un() {
        return vlr_un;
    }

    public void setVlr_un(Double vlr_un) {
        this.vlr_un = vlr_un;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Item_PedidoModel other = (Item_PedidoModel) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Item_Pedido{" + "id=" + id + ", pedido_id=" + pedido_id + ", descricao=" + descricao + ", qtd=" + qtd + ", vlr_un=" + vlr_un + ", vlr_un_ttal=" + vlr_un_ttal + '}';
    }
    
    
    
    
    
}
