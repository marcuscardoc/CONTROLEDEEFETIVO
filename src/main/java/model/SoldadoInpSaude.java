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
public class SoldadoInpSaude {
	private Integer id;
	private StringProperty nome = new SimpleStringProperty();
	private DoubleProperty turma = new SimpleDoubleProperty();
	private IntegerProperty saram = new SimpleIntegerProperty();
	private StringProperty gabSolicitada = new SimpleStringProperty();
	private StringProperty pegouGab = new SimpleStringProperty();
	private StringProperty exame = new SimpleStringProperty();
	private StringProperty dataEntrega = new SimpleStringProperty();

	public SoldadoInpSaude() {
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// ID
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "NOME")
	// NOME
	public String getNome() {
		return nome.get();
	}

	public void setNome(String nome) {
		this.nome.set(nome);
	}

	public StringProperty nomeProperty() {
		return nome;
	}

	@Column(name = "TURMA")
	// TURMA
	public Double getTurma() {
		return turma.get();
	}

	public void setTurma(Double turma) {
		this.turma.set(turma);
	}

	public DoubleProperty turmaProperty() {
		return turma;
	}

	@Column(name = "SARAM")
	// SARAM
	public Integer getSaram() {
		return saram.get();
	}

	public void setSaram(Integer saram) {
		this.saram.set(saram);
		;
	}

	public IntegerProperty saramProperty() {
		return saram;
	}

	@Column(name = "GAB_SOLICITADA")
	// GAB SOLICITADA
	public String getGabSolicitada() {
		return gabSolicitada.get();
	}

	public void setGabSolicitada(String gabSolicitada) {
		this.gabSolicitada.set(gabSolicitada);
		;
	}

	public StringProperty gabSolicitadaProperty() {
		return gabSolicitada;
	}

	@Column(name = "PEGOU_GAB")
	// PEGOU GAB
	public String getPegouGab() {
		return pegouGab.get();
	}

	public void setPegouGab(String pegouGab) {
		this.pegouGab.set(pegouGab);
		;
	}

	public StringProperty pegouGabProperty() {
		return pegouGab;
	}

	@Column(name = "EXAME")
	// EXAME
	public String getExame() {
		return exame.get();
	}

	public void setExame(String exame) {
		this.exame.set(exame);
		;
	}

	public StringProperty exameProperty() {
		return exame;
	}

	@Column(name = "DATA_ENTREGA")
	// DATA ENTREGA
	public String getDataEntrega() {
		return dataEntrega.get();
	}

	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega.set(dataEntrega);
		;
	}

	public StringProperty dataEntregaProperty() {
		return dataEntrega;
	}

}
