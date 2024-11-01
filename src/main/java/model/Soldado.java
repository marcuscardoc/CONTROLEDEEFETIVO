package main.java.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


@Entity
public class Soldado {
	private Integer id;
	
	//CONTROLE DE EFETIVO
	private StringProperty nome = new SimpleStringProperty();
	private IntegerProperty saram = new SimpleIntegerProperty();
	private DoubleProperty turma = new SimpleDoubleProperty();
	private StringProperty postoDeSv = new SimpleStringProperty();
	private StringProperty cpf = new SimpleStringProperty();
	private StringProperty senhaPortal = new SimpleStringProperty();
	private StringProperty mesFerias = new SimpleStringProperty();
	private StringProperty observacaoTemp = new SimpleStringProperty();
	
	//FERIAS
	private StringProperty apInicio = new SimpleStringProperty();
	private StringProperty apTermino = new SimpleStringProperty();
	private StringProperty dataInicio = new SimpleStringProperty();
	private StringProperty dataTermino = new SimpleStringProperty();
	private IntegerProperty periodoAquisitivo = new SimpleIntegerProperty();
	
	//TACF
	private StringProperty data1etapa = new SimpleStringProperty();
	private StringProperty data2etapa = new SimpleStringProperty();
	private StringProperty realizado1etapa = new SimpleStringProperty();
	private StringProperty realizado2etapa = new SimpleStringProperty();
	
	//SOLDADO	
	public Soldado() {}
	
@Id
@Column(name = "id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
	// ID
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer soldadoId) {
		this.id = soldadoId;
	}
	
@Column(name = "NOME")
	// NOME
	public String getNome() {
		return nome.get();
	}
	
	public void setNome(String nome) {
		this.nome.set(nome);
	}
	
@Column(name = "SARAM")
	// SARAM
	public int getSaram() {
		return saram.get();
	}
	
	public void setSaram(Integer saram) {
		this.saram.set(saram);
	}
		
@Column(name = "TURMA")
	// TURMA
	public Double getTurma() {
		return turma.get();
	}
	
	public void setTurma(Double turma) {
		this.turma.set(turma);
	}

	public DoubleProperty TurmaProperty() {
		return turma;
	}
	
@Column(name = "CPF")
	// CPF
	public String getCpf() {
		return cpf.get();
	}
	
	public void setCpf(String cpf) {
		this.cpf.set(cpf);
	}
		
@Column(name = "SENHA_PORTAL")
	// SENHA PORTAL
	public String getSenhaPortal() {
		return senhaPortal.get();
	}
	
	public void setSenhaPortal(String senhaPortal) {
		this.senhaPortal.set(senhaPortal);
	}
		
@Column(name = "POSTO_DE_SV")
	// POSTO DE SERVIÇO
	public String getPostoDeSv() {
		return postoDeSv.get();
	}
	
	public void setPostoDeSv(String postoDeSv) {
		this.postoDeSv.set(postoDeSv);
	}
		
@Column(name = "AP_INICIO")
	// APRESENTAÇAO POR INICIO
	public String getApInicio() {
		return apInicio.get();
	}
	
	public void setApInicio(String apIFerias) {
		this.apInicio.set(apIFerias);
	}
	
@Column(name = "AP_TERMINO")
	// APRESENTAÇAO POR TERMINO
	public String getApTermino() {
		return apTermino.get();
	}
	
	public void setApTermino(String apTFerias) {
		this.apTermino.set(apTFerias);
	}
	
@Column(name = "DATA_INICIO")
	// DATA INICIO
	public String getdataInicio() {
		return dataInicio.get();
	}
	
	public void setDataInicio(String dIFerias) {
		this.dataInicio.set(dIFerias);
	}
	
@Column(name = "DATA_TERMINO")
	// DATA TERMINO
	public String getdataTermino() {
		return dataTermino.get();
	}
	
	public void setDataTermino(String dtFerias) {
		this.dataTermino.set(dtFerias);
	}
	
@Column(name = "MES_FERIAS")
	// MES FERIAS
	public String getMesFerias() {
		return mesFerias.get();
	}

	public void setMesFerias(String mFerias) {
		this.mesFerias.set(mFerias);
	}
	
@Column(name = "PERIODO_AQUISITIVO")
	// MES FERIAS
	public Integer getPeriodoAquisitivo() {
		return periodoAquisitivo.get();
	}

	public void setPeriodoAquisitivo(Integer periodoAquisitivo) {
		this.periodoAquisitivo.set(periodoAquisitivo);
	}
		
@Column(name = "DATA1ETAPA")
	// DATA 1 ETAPA
	public String getData1Etapa() {
		return data1etapa.get();
	}

	public void setData1Etapa(String data1etapa) {
		this.data1etapa.set(data1etapa);
	}
	
@Column(name = "DATA2ETAPA")
	// NOME
	public String getData2Etapa() {
		return data2etapa.get();
	}

	public void setData2Etapa(String data2etapa) {
		this.data2etapa.set(data2etapa);
	}
	
@Column(name = "REALIZADO1ETAPA")
	// NOME
	public String getRealizado1Etapa() {
		return realizado1etapa.get();
	}

	public void setRealizado1Etapa(String realizado1etapa) {
		this.realizado1etapa.set(realizado1etapa);
	}
	
@Column(name = "REALIZADO2ETAPA")
	// NOME
	public String getRealizado2Etapa() {
		return realizado2etapa.get();
	}

	public void setRealizado2Etapa(String realizado2etapa) {
		this.realizado2etapa.set(realizado2etapa);
	}

	
	 public String getObservacaoTemp() {
        return observacaoTemp.get();
    }

	//OBSERVAÇAO TEMPORARIA
    public void setObservacaoTemp(String observacao) {
        this.observacaoTemp.set(observacao);
    }

    public StringProperty observacaoTempProperty() {
        return observacaoTemp;
    }
}
