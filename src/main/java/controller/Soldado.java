package main.java.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


@Entity
public class Soldado {
	private Integer id;
	private StringProperty nome = new SimpleStringProperty();
	private IntegerProperty saram = new SimpleIntegerProperty();
	private DoubleProperty turma = new SimpleDoubleProperty();
	private StringProperty postoDeSv = new SimpleStringProperty();
	private StringProperty cpf = new SimpleStringProperty();
	private StringProperty senhaPortal = new SimpleStringProperty();
	private StringProperty mesFerias = new SimpleStringProperty();
	private StringProperty apInicio = new SimpleStringProperty();
	private StringProperty apTermino = new SimpleStringProperty();
	private StringProperty dataInicio = new SimpleStringProperty();
	private StringProperty dataTermino = new SimpleStringProperty();
	private StringProperty observacaoTemp = new SimpleStringProperty();
	private IntegerProperty periodoAquisitivo = new SimpleIntegerProperty();
	private StringProperty data1etapa = new SimpleStringProperty();
	private StringProperty data2etapa = new SimpleStringProperty();
	private StringProperty realizado1etapa = new SimpleStringProperty();
	private StringProperty realizado2etapa = new SimpleStringProperty();
	

	//DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/mm/yyyy");

	public Soldado() {
		
	}
	
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

	public StringProperty NomeProperty() {
		return nome;
	}
	@Column(name = "SARAM")
	// SARAM
	public int getSaram() {
		return saram.get();
	}
	
	public void setSaram(Integer saram) {
		this.saram.set(saram);
	}

	public IntegerProperty SaramProperty() {
		return saram;
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

	public StringProperty cpfProperty() {
		return cpf;
	}
	@Column(name = "SENHA_PORTAL")
	// SENHA PORTAL
	public String getSenhaPortal() {
		return senhaPortal.get();
	}
	
	public void setSenhaPortal(String senhaPortal) {
		this.senhaPortal.set(senhaPortal);
	}

	public StringProperty SenhaPortalProperty() {
		return senhaPortal;
	}
	@Column(name = "POSTO_DE_SV")
	// POSTO DE SERVIÇO
	public String getPostoDeSv() {
		return postoDeSv.get();
	}
	
	public void setPostoDeSv(String postoDeSv) {
		this.postoDeSv.set(postoDeSv);
	}

	public StringProperty PostoDeSvProperty() {
		return postoDeSv;
	}
	
	@Column(name = "AP_INICIO")
	// APRESENTAÇAO POR INICIO
	public String getApInicio() {
		return apInicio.get();
	}
	
	public void setApInicio(String apIFerias) {
		this.apInicio.set(apIFerias);
	}

	public StringProperty ApInicioProperty() {
		return apInicio;
	}

	
	
	@Column(name = "AP_TERMINO")
	// APRESENTAÇAO POR TERMINO
	public String getApTermino() {
		return apTermino.get();
	}
	
	public void setApTermino(String apTFerias) {
		this.apTermino.set(apTFerias);
	}

	public StringProperty ApTerminoProperty() {
		return apTermino;
	}

	
	@Column(name = "DATA_INICIO")
	// DATA INICIO
	public String getdataInicio() {
		return dataInicio.get();
	}
	
	public void setDataInicio(String dIFerias) {
		this.dataInicio.set(dIFerias);
	}

	public StringProperty dataInicioProperty() {
		return dataInicio;
	}

	@Column(name = "DATA_TERMINO")
	// DATA TERMINO
	public String getdataTermino() {
		return dataTermino.get();
	}
	
	public void setDataTermino(String dtFerias) {
		this.dataTermino.set(dtFerias);
	}

	public StringProperty dataTerminoProperty() {
		return dataTermino;
	}

	@Column(name = "MES_FERIAS")
	// MES FERIAS
	public String getMesFerias() {
		return mesFerias.get();
	}

	public void setMesFerias(String mFerias) {
		this.mesFerias.set(mFerias);
	}
	
	public StringProperty mesFeriasProperty() {
		return mesFerias;
	}

	@Column(name = "PERIODO_AQUISITIVO")
	// MES FERIAS
	public Integer getPeriodoAquisitivo() {
		return periodoAquisitivo.get();
	}

	public void setPeriodoAquisitivo(Integer periodoAquisitivo) {
		this.periodoAquisitivo.set(periodoAquisitivo);
	}
	
	public IntegerProperty periodoAquisitivoProperty() {
		return periodoAquisitivo;
	}
	
	@Column(name = "DATA1ETAPA")
	// DATA 1 ETAPA
	public String getData1Etapa() {
		return data1etapa.get();
	}

	public void setData1Etapa(String data1etapa) {
		this.data1etapa.set(data1etapa);
	}

	public StringProperty Data1EtapaProperty() {
		return data1etapa;
	}

	@Column(name = "DATA2ETAPA")
	// NOME
	public String getData2Etapa() {
		return data2etapa.get();
	}

	public void setData2Etapa(String data2etapa) {
		this.data2etapa.set(data2etapa);
	}

	public StringProperty Data2EtapaProperty() {
		return data2etapa;
	}

	@Column(name = "REALIZADO1ETAPA")
	// NOME
	public String getRealizado1Etapa() {
		return realizado1etapa.get();
	}

	public void setRealizado1Etapa(String realizado1etapa) {
		this.realizado1etapa.set(realizado1etapa);
	}

	public StringProperty Realizado1EtapaProperty() {
		return realizado1etapa;
	}

	@Column(name = "REALIZADO2ETAPA")
	// NOME
	public String getRealizado2Etapa() {
		return realizado2etapa.get();
	}

	public void setRealizado2Etapa(String realizado2etapa) {
		this.realizado2etapa.set(realizado2etapa);
	}

	public StringProperty Realizado2EtapaProperty() {
		return realizado2etapa;
	}
	
	//@OneToMany(mappedBy = "soldado", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	//@Column(name = "OBSERVAÇAO")
	 public String getObservacaoTemp() {
        return observacaoTemp.get();
    }

    public void setObservacaoTemp(String observacao) {
        this.observacaoTemp.set(observacao);
    }

    public StringProperty observacaoTempProperty() {
        return observacaoTemp;
    }

}
