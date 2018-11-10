
package br.com.pizzaria.model;

import br.com.pizzaria.Enum.TipoPessoa;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @Eliezer
 */
@Entity
@Table(name = "tb_pessoa", uniqueConstraints = {
                                     @UniqueConstraint(name = "uk_unique_cpf", columnNames = "cpf")
                                    ,@UniqueConstraint(name = "uk_unique_rg", columnNames = "rg")})
public class PessoaModel implements Serializable{
    @Id
    @SequenceGenerator(name = "pessoa_id",
            sequenceName = "seq_pessoa_id",
            allocationSize = 1)
    @GeneratedValue(generator = "pessoa_id",strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(length = 100, nullable = false)
    private String nome;
    
    @Column(name = "cpf", length = 14, nullable = false)
    private String cpf;
    
    @Column(name = "rg",length = 30,nullable = false)
    private String rg;
    
    @Enumerated(EnumType.STRING)
    private TipoPessoa tipo;
    
    @Column(length = 14)
    private String fone;
    
    @Column(length = 16,columnDefinition = "")
    private String celular;
    
    @Column(length = 50)
    private String email;
    
    @Column(length = 9)
    private String cep;
    
    @Column(length = 100)
    private String rua;
    
    @Column(length = 5)
    private String nr;
    
    @Column(length = 30,columnDefinition = "")    
    private String complemento;
    
    @Column(length = 100)
    private String bairro;
    
    @Column(length = 100)
    private String cidade;
    
    @Column(length = 2)
    private String uf;    

    public PessoaModel(){
    }

    public PessoaModel(Integer id, String nome, String cpf, String rg, TipoPessoa tipo, String fone, String celular, String email, String cep, String rua, String nr, String complemento, String bairro, String cidade, String uf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.tipo = tipo;
        this.fone = fone;
        this.celular = celular;
        this.email = email;
        this.cep = cep;
        this.rua = rua;
        this.nr = nr;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular.toUpperCase().replace("(", "")
                .replace(")", "").replace("-", "").trim();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.toUpperCase().trim();
    }
    

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf.toUpperCase().trim();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf.toUpperCase().trim();
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg.toUpperCase().trim();
    }

    public TipoPessoa getTipo() {
        return tipo;
    }

    public void setTipo(TipoPessoa tipo) {
        this.tipo = tipo;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone.toUpperCase().replace("(", "")
                .replace(")", "").replace("-", "").trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.toUpperCase().trim();
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep.toUpperCase().trim();
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua.toUpperCase().trim();
    }

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento.toUpperCase().trim();
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro.toUpperCase().trim();
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade.toUpperCase().trim();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final PessoaModel other = (PessoaModel) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PessoaModel{" + "id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", tipo=" + tipo + ", fone=" + fone + ", celular=" + celular + ", email=" + email + ", cep=" + cep + ", rua=" + rua + ", nr=" + nr + ", complemento=" + complemento + ", bairro=" + bairro + ", cidade=" + cidade + ", uf=" + uf + '}';
    }
    
    
}
