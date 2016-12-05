/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jn.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;    
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author josmar
 */
@Entity
@Table(name = "candidato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Candidato.findAll", query = "SELECT c FROM Candidato c")
    , @NamedQuery(name = "Candidato.findById", query = "SELECT c FROM Candidato c WHERE c.id = :id")
    , @NamedQuery(name = "Candidato.findByInscricao", query = "SELECT c FROM Candidato c WHERE c.inscricao = :inscricao")
    , @NamedQuery(name = "Candidato.findByCpf", query = "SELECT c FROM Candidato c WHERE c.cpf = :cpf")
    , @NamedQuery(name = "Candidato.findByNome", query = "SELECT c FROM Candidato c WHERE c.nome = :nome")
    , @NamedQuery(name = "Candidato.findByLinha1", query = "SELECT c FROM Candidato c WHERE c.linha1 = :linha1")
    , @NamedQuery(name = "Candidato.findByLinha2", query = "SELECT c FROM Candidato c WHERE c.linha2 = :linha2")
    , @NamedQuery(name = "Candidato.findByOrientador1", query = "SELECT c FROM Candidato c WHERE c.orientador1 = :orientador1")
    , @NamedQuery(name = "Candidato.findByDia", query = "SELECT c FROM Candidato c WHERE c.dia = :dia")
    , @NamedQuery(name = "Candidato.findByLocal", query = "SELECT c FROM Candidato c WHERE c.local = :local")
    , @NamedQuery(name = "Candidato.findByHorario", query = "SELECT c FROM Candidato c WHERE c.horario = :horario")
    , @NamedQuery(name = "Candidato.findByNotaEliminatoria", query = "SELECT c FROM Candidato c WHERE c.notaEliminatoria = :notaEliminatoria")
    , @NamedQuery(name = "Candidato.findByOrientador2", query = "SELECT c FROM Candidato c WHERE c.orientador2 = :orientador2")
    , @NamedQuery(name = "Candidato.findByOrientador3", query = "SELECT c FROM Candidato c WHERE c.orientador3 = :orientador3")
    , @NamedQuery(name = "Candidato.findByOldOrientador", query = "SELECT c FROM Candidato c WHERE c.oldOrientador = :oldOrientador")
    , @NamedQuery(name = "Candidato.findByPoscomp", query = "SELECT c FROM Candidato c WHERE c.poscomp = :poscomp")
    , @NamedQuery(name = "Candidato.findByAnoPoscomp", query = "SELECT c FROM Candidato c WHERE c.anoPoscomp = :anoPoscomp")
    , @NamedQuery(name = "Candidato.findByNotaPoscomp", query = "SELECT c FROM Candidato c WHERE c.notaPoscomp = :notaPoscomp")
    , @NamedQuery(name = "Candidato.findByBolsa", query = "SELECT c FROM Candidato c WHERE c.bolsa = :bolsa")
    , @NamedQuery(name = "Candidato.findByAvaliadorEliminatoria", query = "SELECT c FROM Candidato c WHERE c.avaliadorEliminatoria = :avaliadorEliminatoria")
    , @NamedQuery(name = "Candidato.findByNotaAvaliador", query = "SELECT c FROM Candidato c WHERE c.notaAvaliador = :notaAvaliador")
    , @NamedQuery(name = "Candidato.findByNotaProvaEscrita", query = "SELECT c FROM Candidato c WHERE c.notaProvaEscrita = :notaProvaEscrita")
    , @NamedQuery(name = "Candidato.findByNotaEntrevista", query = "SELECT c FROM Candidato c WHERE c.notaEntrevista = :notaEntrevista")
    , @NamedQuery(name = "Candidato.findBySituacao", query = "SELECT c FROM Candidato c WHERE c.situacao = :situacao")
    , @NamedQuery(name = "Candidato.findByURLLattes", query = "SELECT c FROM Candidato c WHERE c.uRLLattes = :uRLLattes")
    , @NamedQuery(name = "Candidato.findByHistorico", query = "SELECT c FROM Candidato c WHERE c.historico = :historico")
    , @NamedQuery(name = "Candidato.findByOrientador", query = "SELECT c FROM Candidato c WHERE c.orientador = :orientador")
    , @NamedQuery(name = "Candidato.findByCoOrientador", query = "SELECT c FROM Candidato c WHERE c.coOrientador = :coOrientador")
    , @NamedQuery(name = "Candidato.findByNotaBolsas", query = "SELECT c FROM Candidato c WHERE c.notaBolsas = :notaBolsas")})
public class Candidato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 20)
    @Column(name = "Inscricao")
    private String inscricao;
    @Size(max = 14)
    @Column(name = "cpf")
    private String cpf;
    @Size(max = 50)
    @Column(name = "Nome")
    private String nome;
    @Size(max = 50)
    @Column(name = "Linha1")
    private String linha1;
    @Size(max = 50)
    @Column(name = "Linha2")
    private String linha2;
    @Size(max = 50)
    @Column(name = "Orientador1")
    private String orientador1;
    @Size(max = 255)
    @Column(name = "Dia")
    private String dia;
    @Size(max = 255)
    @Column(name = "Local")
    private String local;
    @Size(max = 255)
    @Column(name = "Horario")
    private String horario;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "NotaEliminatoria")
    private Double notaEliminatoria;
    @Size(max = 50)
    @Column(name = "Orientador2")
    private String orientador2;
    @Size(max = 50)
    @Column(name = "Orientador3")
    private String orientador3;
    @Size(max = 255)
    @Column(name = "oldOrientador")
    private String oldOrientador;
    @Size(max = 255)
    @Column(name = "Poscomp")
    private String poscomp;
    @Size(max = 4)
    @Column(name = "AnoPoscomp")
    private String anoPoscomp;
    @Column(name = "NotaPoscomp")
    private Double notaPoscomp;
    @Size(max = 255)
    @Column(name = "Bolsa")
    private String bolsa;
    @Size(max = 255)
    @Column(name = "AvaliadorEliminatoria")
    private String avaliadorEliminatoria;
    @Column(name = "NotaAvaliador")
    private Double notaAvaliador;
    @Column(name = "NotaProvaEscrita")
    private Double notaProvaEscrita;
    @Column(name = "NotaEntrevista")
    private Double notaEntrevista;
    @Size(max = 2)
    @Column(name = "Situacao")
    private String situacao;
    @Size(max = 255)
    @Column(name = "URL_Lattes")
    private String uRLLattes;
    @Size(max = 255)
    @Column(name = "Historico")
    private String historico;
    @Size(max = 255)
    @Column(name = "Orientador")
    private String orientador;
    @Size(max = 255)
    @Column(name = "Co_Orientador")
    private String coOrientador;
    @Column(name = "Nota_Bolsas")
    private Double notaBolsas;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "Documentacao")
    private String documentacao;

    public Candidato() {
    }

    public Candidato(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInscricao() {
        return inscricao;
    }

    public void setInscricao(String inscricao) {
        this.inscricao = inscricao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLinha1() {
        return linha1;
    }

    public void setLinha1(String linha1) {
        this.linha1 = linha1;
    }

    public String getLinha2() {
        return linha2;
    }

    public void setLinha2(String linha2) {
        this.linha2 = linha2;
    }

    public String getOrientador1() {
        return orientador1;
    }

    public void setOrientador1(String orientador1) {
        this.orientador1 = orientador1;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Double getNotaEliminatoria() {
        return notaEliminatoria;
    }

    public void setNotaEliminatoria(Double notaEliminatoria) {
        this.notaEliminatoria = notaEliminatoria;
    }

    public String getOrientador2() {
        return orientador2;
    }

    public void setOrientador2(String orientador2) {
        this.orientador2 = orientador2;
    }

    public String getOrientador3() {
        return orientador3;
    }

    public void setOrientador3(String orientador3) {
        this.orientador3 = orientador3;
    }

    public String getOldOrientador() {
        return oldOrientador;
    }

    public void setOldOrientador(String oldOrientador) {
        this.oldOrientador = oldOrientador;
    }

    public String getPoscomp() {
        return poscomp;
    }

    public void setPoscomp(String poscomp) {
        this.poscomp = poscomp;
    }

    public String getAnoPoscomp() {
        return anoPoscomp;
    }

    public void setAnoPoscomp(String anoPoscomp) {
        this.anoPoscomp = anoPoscomp;
    }

    public Double getNotaPoscomp() {
        return notaPoscomp;
    }

    public void setNotaPoscomp(Double notaPoscomp) {
        this.notaPoscomp = notaPoscomp;
    }

    public String getBolsa() {
        return bolsa;
    }

    public void setBolsa(String bolsa) {
        this.bolsa = bolsa;
    }

    public String getAvaliadorEliminatoria() {
        return avaliadorEliminatoria;
    }

    public void setAvaliadorEliminatoria(String avaliadorEliminatoria) {
        this.avaliadorEliminatoria = avaliadorEliminatoria;
    }

    public Double getNotaAvaliador() {
        return notaAvaliador;
    }

    public void setNotaAvaliador(Double notaAvaliador) {
        this.notaAvaliador = notaAvaliador;
    }

    public Double getNotaProvaEscrita() {
        return notaProvaEscrita;
    }

    public void setNotaProvaEscrita(Double notaProvaEscrita) {
        this.notaProvaEscrita = notaProvaEscrita;
    }

    public Double getNotaEntrevista() {
        return notaEntrevista;
    }

    public void setNotaEntrevista(Double notaEntrevista) {
        this.notaEntrevista = notaEntrevista;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getURLLattes() {
        return uRLLattes;
    }

    public void setURLLattes(String uRLLattes) {
        this.uRLLattes = uRLLattes;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public String getOrientador() {
        return orientador;
    }

    public void setOrientador(String orientador) {
        this.orientador = orientador;
    }

    public String getCoOrientador() {
        return coOrientador;
    }

    public void setCoOrientador(String coOrientador) {
        this.coOrientador = coOrientador;
    }

    public Double getNotaBolsas() {
        return notaBolsas;
    }

    public void setNotaBolsas(Double notaBolsas) {
        this.notaBolsas = notaBolsas;
    }

    public String getDocumentacao() {
        return documentacao;
    }

    public void setDocumentacao(String documentacao) {
        this.documentacao = documentacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Candidato)) {
            return false;
        }
        Candidato other = (Candidato) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.jn.controller.Candidato[ id=" + id + " ]";
    }
    
}
