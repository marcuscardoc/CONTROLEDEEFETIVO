package main.java.controller;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import main.java.DAO.SoldadoDAO;
import main.java.DAO.SoldadoDispMedicaDAO;
import main.java.DAO.SoldadoInpSaudeDAO;
import main.java.DAO.SoldadoTACFDAO;
import main.java.model.Observacao;
import main.java.model.Soldado;
import main.java.model.SoldadoDispMedica;
import main.java.model.SoldadoInpSaude;
import main.java.model.SoldadoTACF;

public class ControleDeEfetivoController {

	// TELA INICIAL(TELA DE APRESENTAÇAO)
	// PANE
	@FXML
	private AnchorPane paneTelaPrincipal;

	// BOTAO
	@FXML
	private Button btnControleMensalTelaPrincipal;

	@FXML
	private Button btnInspeçaoTelaPrincipal;

	@FXML
	private Button btnEfetivoTelaPrincipal;

	@FXML
	private Button btnFeriasTelaPrincipal;

	@FXML
	private Button btnDispMedicaTelaPrincipal;

	@FXML
	private Button btnTACFTelaPrincipal;

//TELA EFETIVO(RESPONSAVEL PELO CRUD DE MANIPULAÇAO DO EFETIVO)	    
	// PANE
	@FXML
	private AnchorPane paneTelaEfetivo;

	// TABLE VIEW
	@FXML
	private TableView<Soldado> tTelaEfetivo;

	// COLUMN
	@FXML
	private TableColumn<Soldado, String> tcNomeTelaEfetivo;

	@FXML
	private TableColumn<Soldado, Integer> tcSaramTelaEfetivo;

	@FXML
	private TableColumn<Soldado, Double> tcTurmaTelaEfetivo;

	@FXML
	private TableColumn<Soldado, String> tcPostoDeSvTelaEfetivo;

	@FXML
	private TableColumn<Soldado, String> tcCpfTelaEfetivo;

	@FXML
	private TableColumn<Soldado, String> tcSenhaPortalTelaEfetivo;

	// TEXTFIELDS
	@FXML
	private TextField tfNomeTelaEfetivo;

	@FXML
	private TextField tfPostoDeSvTelaEfetivo;

	@FXML
	private TextField tfSaramTelaEfetivo;

	@FXML
	private TextField tfTurmaTelaEfetivo;

	@FXML
	private TextField tfCpfTelaEfetivo;

	@FXML
	private TextField tfSenhaPortalTelaEfetivo;

	@FXML
	private TextField tfPesquisarTelaEfetivo;

	// BOTOES
	@FXML
	private Button btnAdicionarTelaEfetivo;

	@FXML
	private Button btnExcluirTelaEfetivo;

	@FXML
	private Button btnModificarTelaEfetivo;

	@FXML
	private Button btnSalvarTelaEfetivo;

	@FXML
	private Button btnPesquisarTelaEfetivo;

//TELA CONTROLE MENSAL(RESPONSAVEL PELO CONTROLE MENSAL DOS SOLDADOS)
	// PANE
	@FXML
	private AnchorPane paneControleMensal;

	// TABLE VIEW
	@FXML
	private TableView<Soldado> tControleMensal;

	// COLUMN
	@FXML
	private TableColumn<Soldado, String> tcNomeControleMensal;

	@FXML
	private TableColumn<Soldado, String> tcObsControleMensal;

	@FXML
	private TableColumn<Soldado, String> tcPostoDeSvControleMensal;

	@FXML
	private TableColumn<Soldado, Integer> tcSaramControleMensal;

	@FXML
	private TableColumn<Soldado, Double> tcTurmaControleMensal;

	// TEXTFIELD
	@FXML
	private TextField tfpesquisarControleMensal;

	// BOTAO
	@FXML
	private Button btnPesquisarControleMensal;

	@FXML
	private Button btnsalvarControleMensal;

	// DATAPICKER
	@FXML
	private DatePicker dpDateControleMensal;

//FERIAS PANE(RESPONSAVEL PELA MANIPULAÇAO DAS FERIAS)   
	// PANE
	@FXML
	private AnchorPane paneFerias;

	// TABLE VIEW
	@FXML
	private TableView<Soldado> tTelaFerias;

	// TABLE COLUMN
	@FXML
	private TableColumn<Soldado, String> tcNomeFerias;

	@FXML
	private TableColumn<Soldado, Integer> tcPeriodoAquisitivoFerias;

	@FXML
	private TableColumn<Soldado, Double> tcTurmaFerias;

	@FXML
	private TableColumn<Soldado, String> tcPostoDeSvFerias;

	@FXML
	private TableColumn<Soldado, String> tcmesFerias;

	@FXML
	private TableColumn<Soldado, String> tcDataInicioFerias;

	@FXML
	private TableColumn<Soldado, String> tcDataTerminoFerias;

	@FXML
	private TableColumn<Soldado, String> tcApInicioFerias;

	@FXML
	private TableColumn<Soldado, String> tcApTerminoFerias;

	// TEXTFIELD
	@FXML
	private TextField tfPesquisarTelaFerias;

	// BUTTON
	@FXML
	private Button btnPesquisarTelaFerias;

//INSPEÇAO DE SAUDE PANE(RESPONSAVEL PELA MANIPULAÇAO DE INSPEÇAO DE SAUDE)   
	// PANE
	@FXML
	private AnchorPane inspeçaoDeSaudePane;

	// TABLE VIEW
	@FXML
	private TableView<SoldadoInpSaude> tInspecaoSaude;

	// TABLE COLUMN
	@FXML
	private TableColumn<SoldadoInpSaude, String> tcDataEntregaSaude;

	@FXML
	private TableColumn<SoldadoInpSaude, String> tcExameSaude;

	@FXML
	private TableColumn<SoldadoInpSaude, String> tcGabSolicitada;

	@FXML
	private TableColumn<SoldadoInpSaude, String> tcNomeSaude;

	@FXML
	private TableColumn<SoldadoInpSaude, String> tcPegouGab;

	@FXML
	private TableColumn<SoldadoInpSaude, Integer> tcSaramSaude;

	@FXML
	private TableColumn<SoldadoInpSaude, Double> tcTurmaSaude;

	// BUTTON
	@FXML
	private Button btnAdicionarSaude;

	@FXML
	private Button btnExcluirSaude;

	@FXML
	private Button btnPesquisarTelaSaude;

	// TEXT FIELD
	@FXML
	private TextField tfNomeSaude;

	@FXML
	private TextField tfSaramSaude;

	@FXML
	private TextField tfTurmaSaude;

	@FXML
	private TextField tfPesquisarTelaSaude;

//PANE DISPENSA MEDICA
	// PANE
	@FXML
	private AnchorPane paneDispMedica;

	// TABLE VIEW
	@FXML
	private TableView<SoldadoDispMedica> TWDispMedica;

	// TABLE COLUMN
	@FXML
	private TableColumn<SoldadoDispMedica, String> TCNomeDispMedica;

	@FXML
	private TableColumn<SoldadoDispMedica, Integer> TCQuantidadeDispMedica;

	@FXML
	private TableColumn<SoldadoDispMedica, String> TCApartirDeDispMedica;

	@FXML
	private TableColumn<SoldadoDispMedica, String> TCTipoDeDispensa;

	@FXML
	private TableColumn<SoldadoDispMedica, String> TCCidDispMedica;

	@FXML
	private TableColumn<SoldadoDispMedica, String> TCMedicoDispMedica;

	// TEXTFIELD
	@FXML
	private TextField TFNomeDispMedica;

	@FXML
	private TextField TFQuantidadeDispMedica;

	@FXML
	private TextField TFApartirDeDispMedica;

	@FXML
	private TextField TFTipoDeDispensa;

	@FXML
	private TextField TFCidDispMedica;

	@FXML
	private TextField TFMedicoDispMedica;

	@FXML
	private TextField tfPesquisarTelaDispensa;

	// BUTTON
	@FXML
	private Button btnAddDispMedica;

	@FXML
	private Button btnExcluirDispMedica;

	@FXML
	private Button btnPesquisarTelaDispensa;

//TACF
	// PANE
	@FXML
	private AnchorPane paneTACF;

	// TABLEVIEW
	@FXML
	private TableView<Soldado> TVTacf;

	// TABLECOLUMN
	@FXML
	private TableColumn<Soldado, String> tcNomeTacf;

	@FXML
	private TableColumn<Soldado, String> tcData1Etapa;

	@FXML
	private TableColumn<Soldado, String> tcRealizado1Etapa;

	@FXML
	private TableColumn<Soldado, String> tcData2Etapa;

	@FXML
	private TableColumn<Soldado, String> tcRealizado2Etapa;

	// BUTTON
	@FXML
	private Button btnPesquisarTelaTACF;

	// TEXTFIELD
	@FXML
	private TextField tfPesquisarTelaTACF;

//OBSERVABLELIST(ARRAYS)
	@FXML
	private ObservableList<Soldado> soldadosData = FXCollections.observableArrayList();

	@FXML
	private ObservableList<SoldadoInpSaude> soldadosDataSaude = FXCollections.observableArrayList();

	@FXML
	private ObservableList<SoldadoDispMedica> soldadosDataDispMedica = FXCollections.observableArrayList();

	@FXML
	private ObservableList<SoldadoTACF> soldadosTACFData = FXCollections.observableArrayList();

//FILTEREDLIST(LISTA RESPONSAVEL POR FILTRAR OS SOLDADOS)
	@FXML
	private FilteredList<Soldado> filteredData;

//DATA OBJECT
	SoldadoDAO soldadoDAO = new SoldadoDAO();
	SoldadoInpSaudeDAO soldadoInpSaudeDAO = new SoldadoInpSaudeDAO();
	SoldadoDispMedicaDAO soldadoDispMedicaDAO = new SoldadoDispMedicaDAO();
	SoldadoTACFDAO soldadoTACFDAO = new SoldadoTACFDAO();

//-----------------------------------------------------------METODOS--------------------------------------------------------------------       

	// VISIBILIDADE DAS TELAS
	@FXML
	public void acaoBtn(ActionEvent event) {

		try {

			if (event.getSource() == btnEfetivoTelaPrincipal) {
				paneTelaEfetivo.setVisible(true);
				paneControleMensal.setVisible(false);
				inspeçaoDeSaudePane.setVisible(false);
				paneFerias.setVisible(false);
				paneDispMedica.setVisible(false);
				paneTACF.setVisible(false);

			}

			else if (event.getSource() == btnControleMensalTelaPrincipal) {
				paneTelaEfetivo.setVisible(false);
				paneControleMensal.setVisible(true);
				inspeçaoDeSaudePane.setVisible(false);
				paneFerias.setVisible(false);
				paneDispMedica.setVisible(false);
				paneTACF.setVisible(false);
			}

			else if (event.getSource() == btnTACFTelaPrincipal) {
				paneTelaEfetivo.setVisible(false);
				paneControleMensal.setVisible(false);
				inspeçaoDeSaudePane.setVisible(false);
				paneFerias.setVisible(false);
				paneDispMedica.setVisible(false);
				paneTACF.setVisible(true);
			}

			else if (event.getSource() == btnDispMedicaTelaPrincipal) {
				paneTelaEfetivo.setVisible(false);
				paneControleMensal.setVisible(false);
				inspeçaoDeSaudePane.setVisible(false);
				paneFerias.setVisible(false);
				paneDispMedica.setVisible(true);
				paneTACF.setVisible(false);

			}

			else if (event.getSource() == btnInspeçaoTelaPrincipal) {
				paneTelaEfetivo.setVisible(false);
				paneControleMensal.setVisible(false);
				inspeçaoDeSaudePane.setVisible(true);
				paneFerias.setVisible(false);
				paneDispMedica.setVisible(false);
				paneTACF.setVisible(false);
			}

			else if (event.getSource() == btnFeriasTelaPrincipal) {
				paneTelaEfetivo.setVisible(false);
				paneControleMensal.setVisible(false);
				inspeçaoDeSaudePane.setVisible(false);
				paneFerias.setVisible(true);
				paneDispMedica.setVisible(false);
				paneTACF.setVisible(false);
			}
		} catch (Exception e) {

			mostrarAlerta("Erro", "Erro inesperado!", Alert.AlertType.ERROR);
			e.printStackTrace();

		}
	}

	// FUNÇAO QUE INICIA AS TABELAS(TODAS)
	@FXML
	private void initialize() {

		// TABELA CRUD EFETIVO
		tTelaEfetivo.setEditable(true);

		tcNomeTelaEfetivo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome()));
		tcNomeTelaEfetivo.setCellFactory(TextFieldTableCell.forTableColumn());
		tcNomeTelaEfetivo.setOnEditCommit(event -> {
			String newValue = event.getNewValue();

			if (newValue == null || newValue.trim().isEmpty()) {
				mostrarAlerta("ERRO!!", "NOME EM BRANCO", Alert.AlertType.ERROR);
				event.consume();
			} else {
				Soldado sd = event.getRowValue();
				sd.setNome(newValue);
				soldadoDAO.salvarModificacoes(sd);
				tControleMensal.refresh();
				TVTacf.refresh();
				tTelaFerias.refresh();
			}
		});

		tcSaramTelaEfetivo
				.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getSaram()).asObject());
		tcSaramTelaEfetivo.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
		tcSaramTelaEfetivo.setOnEditCommit(event -> {
			int newValue = event.getNewValue();
			Soldado sd = event.getRowValue();
			sd.setSaram(newValue);
			soldadoDAO.salvarModificacoes(sd);
		});

		tcTurmaTelaEfetivo
				.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getTurma()).asObject());
		tcTurmaTelaEfetivo.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
		tcTurmaTelaEfetivo.setOnEditCommit(event -> {
			Double newValue = event.getNewValue();
			Soldado sd = event.getRowValue();
			sd.setTurma(newValue);
			soldadoDAO.salvarModificacoes(sd);
		});

		tcPostoDeSvTelaEfetivo
				.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPostoDeSv()));
		tcPostoDeSvTelaEfetivo.setCellFactory(TextFieldTableCell.forTableColumn());
		tcPostoDeSvTelaEfetivo.setOnEditCommit(event -> {
			String newValue = event.getNewValue();

			if (newValue == null || newValue.trim().isEmpty()) {
				mostrarAlerta("ERRO!!", "POSTO DE SERVIÇO EM BRANCO", Alert.AlertType.ERROR);
				event.consume();
			} else {
				Soldado sd = event.getRowValue();
				sd.setPostoDeSv(newValue);
				soldadoDAO.salvarModificacoes(sd);
				tControleMensal.refresh();
				TVTacf.refresh();
				tTelaFerias.refresh();
			}
		});

		tcCpfTelaEfetivo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCpf()));
		tcCpfTelaEfetivo.setCellFactory(TextFieldTableCell.forTableColumn());
		tcCpfTelaEfetivo.setOnEditCommit(event -> {
			String newValue = event.getNewValue();

			if (newValue == null || newValue.trim().isEmpty()) {
				mostrarAlerta("ERRO!!", "CPF EM BRANCO", Alert.AlertType.ERROR);
				event.consume();

			} else if (!newValue.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
				mostrarAlerta("ERRO", "FORMATO INVÁLIDO. O FORMATO CORRETO É NNN.NNN.NNN-NN", Alert.AlertType.ERROR);
				event.consume();
			} else {
				Soldado sd = event.getRowValue();
				sd.setCpf(newValue);
				soldadoDAO.salvarModificacoes(sd);
				tControleMensal.refresh();
				TVTacf.refresh();
				tTelaFerias.refresh();
			}

		});

		tcSenhaPortalTelaEfetivo
				.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSenhaPortal()));
		tcSenhaPortalTelaEfetivo.setCellFactory(TextFieldTableCell.forTableColumn());
		tcSenhaPortalTelaEfetivo.setOnEditCommit(event -> {
			String newValue = event.getNewValue();

			if (newValue == null || newValue.trim().isEmpty()) {
				mostrarAlerta("ERRO!!", "SENHA EM BRANCO", Alert.AlertType.ERROR);
				event.consume();
			} else {
				Soldado sd = event.getRowValue();
				sd.setSenhaPortal(newValue);
				soldadoDAO.salvarModificacoes(sd);
				tControleMensal.refresh();
				TVTacf.refresh();
				tTelaFerias.refresh();
			}
		});

		carregarDadosSoldados();
		tTelaEfetivo.setItems(soldadosData);

		// TABELA CONTROLE MENSAL
		tControleMensal.setEditable(true);

		tcNomeControleMensal.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome()));
		tcSaramControleMensal
				.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getSaram()).asObject());
		tcTurmaControleMensal
				.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getTurma()).asObject());
		tcPostoDeSvControleMensal
				.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPostoDeSv()));

		tcObsControleMensal.setCellValueFactory(cellData -> cellData.getValue().observacaoTempProperty());
		tcObsControleMensal.setCellFactory(TextFieldTableCell.forTableColumn());
		tcObsControleMensal.setOnEditCommit(event -> {
			Soldado soldado = event.getRowValue();
			soldado.setObservacaoTemp(event.getNewValue());
			salvarObservacoes();

		});

		// QUANDO O DATEPICKER FOR ALTERADO MUDA AS OBSERVAÇOES
		dpDateControleMensal.valueProperty().addListener((obs, oldDate, newDate) -> {
			if (newDate != null) {
				carregarObservacoesPorData();
			}
		});

		carregarDadosSoldados();
		tControleMensal.setItems(soldadosData);

		// TABELA FERIAS
		tTelaFerias.setEditable(true);

		tcNomeFerias.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome()));
		tcTurmaFerias
				.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getTurma()).asObject());
		tcPostoDeSvFerias.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPostoDeSv()));

		tcPeriodoAquisitivoFerias.setCellValueFactory(
				cellData -> new SimpleIntegerProperty(cellData.getValue().getPeriodoAquisitivo()).asObject());
		tcPeriodoAquisitivoFerias.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
		tcPeriodoAquisitivoFerias.setOnEditCommit(event -> {
			int newValue = event.getNewValue();
			Soldado sd = event.getRowValue();
			sd.setPeriodoAquisitivo(newValue);
			soldadoDAO.salvarModificacoes(sd);
		});

		tcmesFerias.setCellValueFactory(cellData -> {
			String mesFerias = cellData.getValue().getMesFerias();
			return new SimpleStringProperty(
					mesFerias == null || mesFerias.trim().isEmpty() ? "INSERIR MES" : mesFerias);
		});
		tcmesFerias.setCellFactory(TextFieldTableCell.forTableColumn());
		tcmesFerias.setOnEditCommit(event -> {
			String newValue = event.getNewValue();

			if (newValue == null || newValue.trim().isEmpty()) {
				mostrarAlerta("ERRO", "MES EM BRANCO", Alert.AlertType.ERROR);
				event.consume();
			} else if (newValue.matches(".*\\d.*")) {
				mostrarAlerta("ERRO", "MES NÃO PODE CONTER NÚMEROS", Alert.AlertType.ERROR);
				event.consume();
			} else {
				Soldado sd = event.getRowValue();
				sd.setMesFerias(newValue);
				soldadoDAO.salvarModificacoes(sd);
			}

		});

		tcDataInicioFerias
				.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getdataInicio()));
		tcDataInicioFerias.setCellFactory(TextFieldTableCell.forTableColumn());
		tcDataInicioFerias.setOnEditCommit(event -> {
			String newValue = event.getNewValue();

			if (newValue == null || newValue.trim().isEmpty()) {
				mostrarAlerta("ERRO", "DATA EM BRANCO", Alert.AlertType.ERROR);
				event.consume();
			} else {
				Soldado sd = event.getRowValue();
				sd.setDataInicio(newValue);
				soldadoDAO.salvarModificacoes(sd);
			}
		});

		tcDataTerminoFerias
				.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getdataTermino()));
		tcDataTerminoFerias.setCellFactory(TextFieldTableCell.forTableColumn());
		tcDataTerminoFerias.setOnEditCommit(event -> {
			String newValue = event.getNewValue();

			if (newValue == null || newValue.trim().isEmpty()) {
				mostrarAlerta("ERRO", "DATA EM BRANCO", Alert.AlertType.ERROR);
				event.consume();
			} else {
				Soldado sd = event.getRowValue();
				sd.setDataTermino(newValue);
				soldadoDAO.salvarModificacoes(sd);
			}
		});

		tcApInicioFerias.setCellValueFactory(cellData -> {
			String apInicio = cellData.getValue().getApInicio();
			return new SimpleStringProperty(apInicio == null || apInicio.trim().isEmpty() ? "NAO" : apInicio);
		});
		tcApInicioFerias.setCellFactory(TextFieldTableCell.forTableColumn());
		tcApInicioFerias.setOnEditCommit(event -> {
			String newValue = event.getNewValue();

			if (newValue == null || newValue.trim().isEmpty()) {
				mostrarAlerta("ERRO", "APRESENTAÇAO POR INICIO EM BRANCO", Alert.AlertType.ERROR);
				event.consume();
			} else if (newValue.matches(".*\\d.*")) {
				mostrarAlerta("ERRO", "APRESENTAÇAO POR INICIO NÃO PODE CONTER NÚMEROS", Alert.AlertType.ERROR);
				event.consume();
			} else {
				Soldado sd = event.getRowValue();
				sd.setApInicio(newValue);
				soldadoDAO.salvarModificacoes(sd);
			}

		});

		tcApTerminoFerias.setCellValueFactory(cellData -> {
			String apTermino = cellData.getValue().getApInicio();
			return new SimpleStringProperty(apTermino == null || apTermino.trim().isEmpty() ? "NAO" : apTermino);
		});
		tcApTerminoFerias.setCellFactory(TextFieldTableCell.forTableColumn());
		tcApTerminoFerias.setOnEditCommit(event -> {
			String newValue = event.getNewValue();

			if (newValue == null || newValue.trim().isEmpty()) {
				mostrarAlerta("ERRO", "APRESENTAÇAO POR TERMINO EM BRANCO", Alert.AlertType.ERROR);
				event.consume();
			} else if (newValue.matches(".*\\d.*")) {
				mostrarAlerta("ERRO", "APRESENTAÇAO POR TERMINO NÃO PODE CONTER NÚMEROS", Alert.AlertType.ERROR);
				event.consume();
			} else {
				Soldado sd = event.getRowValue();
				sd.setApTermino(newValue);
				soldadoDAO.salvarModificacoes(sd);
			}

		});

		carregarDadosSoldadosSaude();
		tTelaFerias.setItems(soldadosData);

		// TABELA INSPEÇAO DE SAUDE
		tInspecaoSaude.setEditable(true);

		tcNomeSaude.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome()));
		tcNomeSaude.setCellFactory(TextFieldTableCell.forTableColumn());
		tcNomeSaude.setOnEditCommit(event -> {
			String newValue = event.getNewValue();

			if (newValue == null || newValue.trim().isEmpty()) {
				mostrarAlerta("ERRO", "NOME EM BRANCO", Alert.AlertType.ERROR);
				event.consume();
			} else {
				SoldadoInpSaude sd = event.getRowValue();
				sd.setNome(newValue);
				soldadoInpSaudeDAO.salvarModificacoes(sd);
			}

		});

		tcSaramSaude
				.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getSaram()).asObject());
		tcSaramSaude.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
		tcSaramSaude.setOnEditCommit(event -> {
			int newValue = event.getNewValue();
			SoldadoInpSaude sd = event.getRowValue();
			sd.setSaram(newValue);
			soldadoInpSaudeDAO.salvarModificacoes(sd);
		});

		tcTurmaSaude
				.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getTurma()).asObject());
		tcTurmaSaude.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
		tcTurmaSaude.setOnEditCommit(event -> {
			Double newValue = event.getNewValue();
			SoldadoInpSaude sd = event.getRowValue();
			sd.setTurma(newValue);
			soldadoInpSaudeDAO.salvarModificacoes(sd);
		});

		tcDataEntregaSaude
				.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDataEntrega()));
		tcDataEntregaSaude.setCellFactory(TextFieldTableCell.forTableColumn());
		tcDataEntregaSaude.setOnEditCommit(event -> {
			String newValue = event.getNewValue();

			if (newValue == null || newValue.trim().isEmpty()) {
				mostrarAlerta("ERRO", "DATA EM BRANCO", Alert.AlertType.ERROR);
				event.consume();
			} else {
				SoldadoInpSaude sd = event.getRowValue();
				sd.setDataEntrega(newValue);
				soldadoInpSaudeDAO.salvarModificacoes(sd);
			}

		});

		tcExameSaude.setCellValueFactory(cellData -> {
			String exame = cellData.getValue().getExame();
			return new SimpleStringProperty(exame == null || exame.trim().isEmpty() ? "INSERIR EXAME" : exame);
		});
		tcExameSaude.setCellFactory(TextFieldTableCell.forTableColumn());
		tcExameSaude.setOnEditCommit(event -> {
			String newValue = event.getNewValue();

			if (newValue.matches(".*\\d.*")) {
				mostrarAlerta("ERRO", "EXAME NÃO PODE CONTER NÚMEROS", Alert.AlertType.ERROR);
				event.consume();
			} else {
				SoldadoInpSaude sd = event.getRowValue();
				sd.setExame(newValue);
				soldadoInpSaudeDAO.salvarModificacoes(sd);
			}
		});

		tcGabSolicitada.setCellValueFactory(cellData -> {
			String gabSolicitada = cellData.getValue().getGabSolicitada();
			return new SimpleStringProperty(
					gabSolicitada == null || gabSolicitada.trim().isEmpty() ? "NAO" : gabSolicitada);
		});
		tcGabSolicitada.setCellFactory(TextFieldTableCell.forTableColumn());
		tcGabSolicitada.setOnEditCommit(event -> {
			String newValue = event.getNewValue();

			if (newValue == null || newValue.trim().isEmpty()) {
				mostrarAlerta("ERRO", "GAB SOLICITADA EM BRANCO", Alert.AlertType.ERROR);
				event.consume();
			} else if (newValue.matches(".*\\d.*")) {
				mostrarAlerta("ERRO", "GAB SOLICITADA NÃO PODE CONTER NÚMEROS", Alert.AlertType.ERROR);
				event.consume();
			} else {
				SoldadoInpSaude sd = event.getRowValue();
				sd.setGabSolicitada(newValue);
				soldadoInpSaudeDAO.salvarModificacoes(sd);
			}
		});

		tcPegouGab.setCellValueFactory(cellData -> {
			String pegouGab = cellData.getValue().getPegouGab();
			return new SimpleStringProperty(pegouGab == null || pegouGab.trim().isEmpty() ? "NAO" : pegouGab);
		});
		tcPegouGab.setCellFactory(TextFieldTableCell.forTableColumn());
		tcPegouGab.setOnEditCommit(event -> {
			String newValue = event.getNewValue();

			if (newValue == null || newValue.trim().isEmpty()) {
				mostrarAlerta("ERRO", "PEGOU GAB EM BRANCO", Alert.AlertType.ERROR);
				event.consume();
			} else if (newValue.matches(".*\\d.*")) {
				mostrarAlerta("ERRO", "PEGOU GAB NÃO PODE CONTER NÚMEROS", Alert.AlertType.ERROR);
				event.consume();
			} else {
				SoldadoInpSaude sd = event.getRowValue();
				sd.setPegouGab(newValue);
				soldadoInpSaudeDAO.salvarModificacoes(sd);
			}
		});

		carregarDadosSoldados();
		tInspecaoSaude.setItems(soldadosDataSaude);

		// TABELA DISPENSA MEDICA
		TWDispMedica.setEditable(true);

		TCNomeDispMedica.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome()));
		TCNomeDispMedica.setCellFactory(TextFieldTableCell.forTableColumn());
		TCNomeDispMedica.setOnEditCommit(event -> {
			String newValue = event.getNewValue();

			if (newValue == null || newValue.trim().isEmpty()) {
				mostrarAlerta("ERRO", "NOME EM BRANCO", Alert.AlertType.ERROR);
				event.consume();
			} else if (newValue.matches(".*\\d.*")) {
				mostrarAlerta("ERRO", "NOME NÃO PODE CONTER NÚMEROS", Alert.AlertType.ERROR);
				event.consume();
			} else {
				SoldadoDispMedica sd = event.getRowValue();
				sd.setNome(newValue);
				soldadoDispMedicaDAO.salvarModificacoes(sd);
			}

		});

		// VERIFICA TRATAMENTO PRA INTEGER
		TCQuantidadeDispMedica.setCellValueFactory(
				cellData -> new SimpleIntegerProperty(cellData.getValue().getQuantidade()).asObject());
		TCQuantidadeDispMedica.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
		TCQuantidadeDispMedica.setOnEditCommit(event -> {
			SoldadoDispMedica sd = event.getRowValue();
			sd.setQuantidade(event.getNewValue());
			soldadoDispMedicaDAO.salvarModificacoes(sd);
		});

		TCApartirDeDispMedica
				.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApartirDe()));
		TCApartirDeDispMedica.setCellFactory(TextFieldTableCell.forTableColumn());
		TCApartirDeDispMedica.setOnEditCommit(event -> {
			String newValue = event.getNewValue();

			if (newValue == null || newValue.trim().isEmpty()) {
				mostrarAlerta("ERRO", "DATA EM BRANCO", Alert.AlertType.ERROR);
				event.consume();
			} else {
				SoldadoDispMedica sd = event.getRowValue();
				sd.setApartirDe(newValue);
				soldadoDispMedicaDAO.salvarModificacoes(sd);
			}
		});

		TCTipoDeDispensa
				.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTipoDeDispensa()));
		TCTipoDeDispensa.setCellFactory(TextFieldTableCell.forTableColumn());
		TCTipoDeDispensa.setOnEditCommit(event -> {
			String newValue = event.getNewValue();

			if (newValue == null || newValue.trim().isEmpty()) {
				mostrarAlerta("ERRO", "TIPO DE DISPENSA EM BRANCO", Alert.AlertType.ERROR);
				event.consume();
			} else if (newValue.matches(".*\\d.*")) {
				mostrarAlerta("ERRO", "TIPO DE DISPENSA NÃO PODE CONTER NÚMEROS", Alert.AlertType.ERROR);
				event.consume();
			} else {
				SoldadoDispMedica sd = event.getRowValue();
				sd.setTipoDeDispensa(newValue);
				soldadoDispMedicaDAO.salvarModificacoes(sd);
			}
		});

		TCCidDispMedica.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCid()));
		TCCidDispMedica.setCellFactory(TextFieldTableCell.forTableColumn());
		TCCidDispMedica.setOnEditCommit(event -> {
			String newValue = event.getNewValue();

			if (newValue == null || newValue.trim().isEmpty()) {
				mostrarAlerta("ERRO", "CID EM BRANCO", Alert.AlertType.ERROR);
				event.consume();
			} else {
				SoldadoDispMedica sd = event.getRowValue();
				sd.setCid(newValue);
				soldadoDispMedicaDAO.salvarModificacoes(sd);

			}
		});

		TCMedicoDispMedica
				.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNomeMedico()));
		TCMedicoDispMedica.setCellFactory(TextFieldTableCell.forTableColumn());
		TCMedicoDispMedica.setOnEditCommit(event -> {
			String newValue = event.getNewValue();

			if (newValue == null || newValue.trim().isEmpty()) {
				mostrarAlerta("ERRO", "NOME DO MEDICO EM BRANCO", Alert.AlertType.ERROR);
				event.consume();
			} else if (newValue.matches(".*\\d.*")) {
				mostrarAlerta("ERRO", "NOME DO MEDICO NÃO PODE CONTER NÚMEROS", Alert.AlertType.ERROR);
				event.consume();
			} else {
				SoldadoDispMedica sd = event.getRowValue();
				sd.setNomeMedico(newValue);
				soldadoDispMedicaDAO.salvarModificacoes(sd);
			}

		});

		carregarDadosSoldadosDispMedica();
		TWDispMedica.setItems(soldadosDataDispMedica);

		// TABELA TACF
		TVTacf.setEditable(true);

		tcNomeTacf.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome()));

		tcData1Etapa.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getData1Etapa()));
		tcData1Etapa.setCellFactory(TextFieldTableCell.forTableColumn());
		tcData1Etapa.setOnEditCommit(event -> {
			String newValue = event.getNewValue();

			if (newValue == null || newValue.trim().isEmpty()) {
				mostrarAlerta("ERRO", "DATA EM BRANCO", Alert.AlertType.ERROR);
				event.consume();
			} else {
				Soldado sd = event.getRowValue();
				sd.setData1Etapa(newValue);
				soldadoDAO.salvarModificacoes(sd);
			}

		});

		tcRealizado1Etapa.setCellValueFactory(cellData -> {

			String realizado1etapa = cellData.getValue().getRealizado1Etapa();
			return new SimpleStringProperty(
					realizado1etapa == null || realizado1etapa.trim().isEmpty() ? "NAO" : realizado1etapa);
		});
		tcRealizado1Etapa.setCellFactory(TextFieldTableCell.forTableColumn());
		tcRealizado1Etapa.setOnEditCommit(event -> {
			String newValue = event.getNewValue();

			if (newValue == null || newValue.trim().isEmpty()) {
				mostrarAlerta("ERRO", "REALIZADO PRIMEIRA ETAPA EM BRANCO", Alert.AlertType.ERROR);
				event.consume();
			} else if (newValue.matches(".*\\d.*")) {
				mostrarAlerta("ERRO", "REALIZADO PRIMEIRA ETAPA NÃO PODE CONTER NÚMEROS", Alert.AlertType.ERROR);
				event.consume();
			} else {
				Soldado sd = event.getRowValue();
				sd.setRealizado1Etapa(newValue);
				soldadoDAO.salvarModificacoes(sd);
			}
		});

		tcData2Etapa.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getData2Etapa()));
		tcData2Etapa.setCellFactory(TextFieldTableCell.forTableColumn());
		tcData2Etapa.setOnEditCommit(event -> {
			String newValue = event.getNewValue();

			if (newValue == null || newValue.trim().isEmpty()) {
				mostrarAlerta("ERRO", "DATA EM BRANCO", Alert.AlertType.ERROR);
				event.consume();
			} else {
				Soldado sd = event.getRowValue();
				sd.setData2Etapa(newValue);
				soldadoDAO.salvarModificacoes(sd);
			}
		});

		tcRealizado2Etapa.setCellValueFactory(cellData -> {
			String realizado2etapa = cellData.getValue().getRealizado2Etapa();
			return new SimpleStringProperty(
					realizado2etapa == null || realizado2etapa.trim().isEmpty() ? "NAO" : realizado2etapa);
		});
		tcRealizado2Etapa.setCellFactory(TextFieldTableCell.forTableColumn());
		tcRealizado2Etapa.setOnEditCommit(event -> {
			String newValue = event.getNewValue();

			if (newValue == null || newValue.trim().isEmpty()) {
				mostrarAlerta("ERRO", "REALIZADO SEGUNDA ETAPA EM BRANCO", Alert.AlertType.ERROR);
				event.consume();
			} else if (newValue.matches(".*\\d.*")) {
				mostrarAlerta("ERRO", "REALIZADO SEGUNDA ETAPA NÃO PODE CONTER NÚMEROS", Alert.AlertType.ERROR);
				event.consume();
			} else {
				Soldado sd = event.getRowValue();
				sd.setRealizado2Etapa(newValue);
				soldadoDAO.salvarModificacoes(sd);
			}
		});

		carregarDadosSoldados();
		TVTacf.setItems(soldadosData);

	}

	// FUNÇAO RESPONSAVEL POR CRIAR OS ALETS DA APLICAÇAO
	private void mostrarAlerta(String titulo, String mensagem, Alert.AlertType tipo) {
		Alert alerta = new Alert(tipo);
		alerta.setTitle(titulo);
		alerta.setHeaderText(null);
		alerta.setContentText(mensagem);
		alerta.showAndWait();
	}

	// FUNÇAO RESPONSAVEL POR CARREGAR OS SOLDADOS NA TABLE
	private void carregarDadosSoldados() {
		List<Soldado> soldados = soldadoDAO.buscarSoldados();

		soldadosData.setAll(soldados);
	}

	private void carregarDadosSoldadosSaude() {
		List<SoldadoInpSaude> soldadosSaude = soldadoInpSaudeDAO.buscarSoldados();

		soldadosDataSaude.setAll(soldadosSaude);
	}

	private void carregarDadosSoldadosDispMedica() {
		List<SoldadoDispMedica> soldadosDispMedica = soldadoDispMedicaDAO.buscarSoldados();

		soldadosDataDispMedica.setAll(soldadosDispMedica);
	}

	// FUNÇAO ADD SOLDADO(RESPONSAVEL POR ADICIONAR O SOLDADO AS TABELAS)
	@FXML
	private void addSoldadoDispMedica() {
		try {

			if (TFNomeDispMedica.getText().isEmpty() || TFQuantidadeDispMedica.getText().isEmpty()
					|| TFApartirDeDispMedica.getText().isEmpty() || TFTipoDeDispensa.getText().isEmpty()
					|| TFCidDispMedica.getText().isEmpty() || TFMedicoDispMedica.getText().isEmpty()) {

				mostrarAlerta("Erro de Validação", "Por favor, preencha todos os campos.", Alert.AlertType.ERROR);
				return;
			}
			String nome = TFNomeDispMedica.getText();
			String quantidadee = TFQuantidadeDispMedica.getText();
			String apartirDe = TFApartirDeDispMedica.getText();
			String tipoDeDispensa = TFTipoDeDispensa.getText();
			String cid = TFCidDispMedica.getText();
			String nomeMedico = TFMedicoDispMedica.getText();

			int quantidade;

			try {
				quantidade = Integer.parseInt(quantidadee);
			} catch (NumberFormatException e) {
				mostrarAlerta("Erro de Validação", "O campo 'Quantidade' deve ser um número válido.",
						Alert.AlertType.ERROR);
				return;
			}

			SoldadoDispMedica soldadoDispMedica = new SoldadoDispMedica();
			soldadoDispMedica.setNome(nome);
			soldadoDispMedica.setQuantidade(quantidade);
			soldadoDispMedica.setApartirDe(apartirDe);
			soldadoDispMedica.setTipoDeDispensa(tipoDeDispensa);
			soldadoDispMedica.setCid(cid);
			soldadoDispMedica.setNomeMedico(nomeMedico);

			carregarDadosSoldadosDispMedica();
			soldadoDispMedicaDAO.criarSoldadoDispMedica(soldadoDispMedica);
			soldadosDataDispMedica.add(soldadoDispMedica);
			TWDispMedica.setItems(soldadosDataDispMedica);

			TFNomeDispMedica.clear();
			TFQuantidadeDispMedica.clear();
			TFApartirDeDispMedica.clear();
			TFTipoDeDispensa.clear();
			TFCidDispMedica.clear();
			TFMedicoDispMedica.clear();

		} catch (Exception e) {
			mostrarAlerta("Erro", "Erro inesperado", Alert.AlertType.ERROR);
			e.printStackTrace();
		}
	}

	@FXML
	private void addSoldadoSaude() {
		try {

			if (tfNomeSaude.getText().isEmpty() || tfTurmaSaude.getText().isEmpty()
					|| tfSaramSaude.getText().isEmpty()) {
				mostrarAlerta("Erro de Validação", "Por favor, preencha todos os campos.", Alert.AlertType.ERROR);
				return;
			}

			String nome = tfNomeSaude.getText();
			String turmaa = tfTurmaSaude.getText();
			String saramm = tfSaramSaude.getText();

			int saram;
			Double turma;

			try {
				saram = Integer.parseInt(saramm);
			} catch (NumberFormatException e) {
				mostrarAlerta("Erro de Validação", "O campo 'Saram' deve ser um número válido.", Alert.AlertType.ERROR);
				return;
			}

			try {
				turma = Double.parseDouble(turmaa);
			} catch (NumberFormatException e) {
				mostrarAlerta("Erro de Validação", "O campo 'Turma' deve ser um número válido.", Alert.AlertType.ERROR);
				return;
			}

			SoldadoInpSaude soldadoInpSaude = new SoldadoInpSaude();
			soldadoInpSaude.setNome(nome);
			soldadoInpSaude.setTurma(turma);
			soldadoInpSaude.setSaram(saram);

			carregarDadosSoldadosSaude();
			soldadoInpSaudeDAO.atualizarSoldado(soldadoInpSaude);
			soldadosDataSaude.add(soldadoInpSaude);
			tInspecaoSaude.setItems(soldadosDataSaude);

			tfNomeSaude.clear();
			tfTurmaSaude.clear();
			tfSaramSaude.clear();

		} catch (Exception e) {
			mostrarAlerta("Erro", "Erro inesperado", Alert.AlertType.ERROR);
			e.printStackTrace();
		}
	}

	@FXML
	private void addsoldado() {
		String nome = tfNomeTelaEfetivo.getText();
		String saramm = tfSaramTelaEfetivo.getText();
		String turmaa = tfTurmaTelaEfetivo.getText();
		String postoDeSv = tfPostoDeSvTelaEfetivo.getText();
		String cpf = tfCpfTelaEfetivo.getText();
		String senhaPortal = tfSenhaPortalTelaEfetivo.getText();

		try {

			if (tfNomeTelaEfetivo.getText().isEmpty() || tfSaramTelaEfetivo.getText().isEmpty()
					|| tfTurmaTelaEfetivo.getText().isEmpty() || tfPostoDeSvTelaEfetivo.getText().isEmpty()
					|| tfCpfTelaEfetivo.getText().isEmpty() || tfSenhaPortalTelaEfetivo.getText().isEmpty()) {
				mostrarAlerta("Erro de Validação", "Por favor, preencha todos os campos.", Alert.AlertType.ERROR);
				return;

			} else if (!cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
				mostrarAlerta("ERRO", "FORMATO DE CPF INVÁLIDO. O FORMATO CORRETO É NNN.NNN.NNN-NN",
						Alert.AlertType.ERROR);
				return;
			}

			int saram;
			Double turma;

			try {
				saram = Integer.parseInt(saramm);
			} catch (NumberFormatException e) {
				mostrarAlerta("Erro de Validação", "O campo 'Saram' deve ser um número válido.", Alert.AlertType.ERROR);
				return;
			}

			try {
				turma = Double.parseDouble(turmaa);
			} catch (NumberFormatException e) {
				mostrarAlerta("Erro de Validação", "O campo 'Turma' deve ser um número válido.", Alert.AlertType.ERROR);
				return;
			}

			Soldado soldado = new Soldado();
			soldado.setNome(nome);
			soldado.setSaram(saram);
			soldado.setTurma(turma);
			soldado.setPostoDeSv(postoDeSv);
			soldado.setCpf(cpf);
			soldado.setSenhaPortal(senhaPortal);

			// DAO
			carregarDadosSoldados();
			soldadoDAO.criarSoldado(soldado);
			soldadosData.add(soldado);
			tTelaEfetivo.setItems(soldadosData);

			// CLEAR NOS TEXTFIELDS
			tfNomeTelaEfetivo.clear();
			tfSaramTelaEfetivo.clear();
			tfTurmaTelaEfetivo.clear();
			tfPostoDeSvTelaEfetivo.clear();
			tfCpfTelaEfetivo.clear();
			tfSenhaPortalTelaEfetivo.clear();

		} catch (Exception e) {
			mostrarAlerta("Erro", "Erro inesperado", Alert.AlertType.ERROR);
			e.printStackTrace();
		}
	}

	// FUNÇAO PARA EXCLUIR SOLDADOS
	@FXML
	private void excluirSoldado() {
		Soldado soldadoSelecionado = tTelaEfetivo.getSelectionModel().getSelectedItem();

		if (soldadoSelecionado != null) {
			try {
				soldadoDAO.excluirSoldado(soldadoSelecionado);
				soldadosData.remove(soldadoSelecionado);
			} catch (Exception e) {
				mostrarAlerta("Erro", "Falha ao excluir o soldado", Alert.AlertType.ERROR);
				e.printStackTrace();
			}
		} else {
			mostrarAlerta("Aviso", "Nenhum soldado selecionado!", Alert.AlertType.WARNING);
		}
	}

	@FXML
	private void excluirSoldadoDispMedica() {
		SoldadoDispMedica soldadoSelecionado = TWDispMedica.getSelectionModel().getSelectedItem();

		if (soldadoSelecionado != null) {
			try {
				soldadoDispMedicaDAO.excluirSoldado(soldadoSelecionado);
				soldadosDataDispMedica.remove(soldadoSelecionado);
			} catch (Exception e) {
				mostrarAlerta("Erro", "Falha ao excluir o soldado", Alert.AlertType.ERROR);
				e.printStackTrace();
			}
		} else {
			mostrarAlerta("Aviso", "Nenhum soldado selecionado!", Alert.AlertType.WARNING);
		}
	}

	@FXML
	private void excluirSoldadoInpSaude() {
		SoldadoInpSaude soldadoSelecionado = tInspecaoSaude.getSelectionModel().getSelectedItem();

		if (soldadoSelecionado != null) {
			try {
				soldadoInpSaudeDAO.excluirSoldado(soldadoSelecionado);
				soldadosDataSaude.remove(soldadoSelecionado);
			} catch (Exception e) {
				mostrarAlerta("Erro", "Falha ao excluir o soldado", Alert.AlertType.ERROR);
				e.printStackTrace();
			}
		} else {
			mostrarAlerta("Aviso", "Nenhum soldado selecionado!", Alert.AlertType.WARNING);
		}
	}

	@FXML
	private void carregarObservacoesPorData() {
		LocalDate dataSelecionada = dpDateControleMensal.getValue();

		if (dataSelecionada == null) {
			return;
		}

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("esicontrol");
		EntityManager em = emf.createEntityManager();

		try {
			for (Soldado soldado : soldadosData) {
				Observacao observacao = buscarObservacaoPorSoldadoEData(soldado, dataSelecionada);

				if (observacao != null) {
					soldado.setObservacaoTemp(observacao.getTextObs());
				} else {
					soldado.setObservacaoTemp("");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}

		tControleMensal.refresh();
	}

	@FXML
	// SALVA AS OBSERVAÇOES
	private void salvarObservacoes() {
		LocalDate dataSelecionada = dpDateControleMensal.getValue();

		if (dataSelecionada == null) {
			mostrarAlerta("Erro", "Não foi selecionada nenhuma data", Alert.AlertType.ERROR);
			return;
		}

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("esicontrol");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		try {

			for (Soldado soldado : tControleMensal.getItems()) {

				String novaObservacao = soldado.getObservacaoTemp();

				Observacao observacaoExistente = buscarObservacaoPorSoldadoEData(soldado, dataSelecionada);

				if (observacaoExistente != null) {

					observacaoExistente.setTextObs(novaObservacao);
					em.merge(observacaoExistente);

				} else {

					Observacao novaObs = new Observacao();
					novaObs.setData(dataSelecionada);
					novaObs.setTextObs(novaObservacao);
					novaObs.setSoldado(soldado);
					em.persist(novaObs);

				}
			}

			em.getTransaction().commit();

		} catch (Exception e) {

			em.getTransaction().rollback();
			e.printStackTrace();

		} finally {
			em.close();
			emf.close();
		}
	}

	public Observacao buscarObservacaoPorSoldadoEData(Soldado soldado, LocalDate data) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("esicontrol");
		EntityManager em = emf.createEntityManager();

		try {

			TypedQuery<Observacao> query = em.createQuery(
					"SELECT o FROM Observacao o WHERE o.soldado = :soldado AND o.data = :data", Observacao.class);
			query.setParameter("soldado", soldado);
			query.setParameter("data", data);

			return query.getSingleResult();

		} catch (NoResultException e) {

			return null;
		}

	}

	// METODO QUE FILTRA POR NOME
	@FXML
	public void pesquisarPorNomeSoldadosControleMensal() {
		String nomePesquisa = tfpesquisarControleMensal.getText().trim().toLowerCase();
		List<Soldado> resultados = soldadoDAO.buscarPorNome(nomePesquisa);

		try {

			if (!nomePesquisa.isEmpty()) {
				ObservableList<Soldado> soldadosControleMensalFilteredData = FXCollections
						.observableArrayList(resultados);
				tControleMensal.setItems(soldadosControleMensalFilteredData);

			} else if (resultados.isEmpty()) {
				ObservableList<Soldado> soldadosControleMensalFilteredData = FXCollections
						.observableArrayList(resultados);
				tControleMensal.setItems(soldadosControleMensalFilteredData);

			} else {
				ObservableList<Soldado> soldadosControleMensalFilteredData = FXCollections
						.observableArrayList(resultados);
				tControleMensal.setItems(soldadosControleMensalFilteredData);
			}
		} catch (Exception e) {
			e.printStackTrace();
			mostrarAlerta("Erro", "Erro inesperado", Alert.AlertType.ERROR);
		}
	}

	@FXML
	public void pesquisarPorNomeSoldadosEfetivo() {
		String nomePesquisa = tfPesquisarTelaEfetivo.getText().trim().toLowerCase();
		List<Soldado> resultados = soldadoDAO.buscarPorNome(nomePesquisa);

		try {
			if (nomePesquisa.isEmpty()) {
				ObservableList<Soldado> soldadosEfetivoFilteredData = FXCollections.observableArrayList(resultados);
				tTelaEfetivo.setItems(soldadosEfetivoFilteredData);

			}

			else if (resultados.isEmpty()) {
				ObservableList<Soldado> soldadosEfetivoFilteredData = FXCollections.observableArrayList(resultados);
				tTelaEfetivo.setItems(soldadosEfetivoFilteredData);

			}

			else {
				ObservableList<Soldado> soldadosEfetivoFilteredData = FXCollections.observableArrayList(resultados);
				tTelaEfetivo.setItems(soldadosEfetivoFilteredData);
			}
		} catch (Exception e) {
			e.printStackTrace();
			mostrarAlerta("Erro", "Erro inesperado", Alert.AlertType.ERROR);
		}
	}

	@FXML
	public void pesquisarPorNomeSoldadosFerias() {
		String nomePesquisa = tfPesquisarTelaFerias.getText().trim().toLowerCase();
		List<Soldado> resultados = soldadoDAO.buscarPorNome(nomePesquisa);

		try {

			if (!nomePesquisa.isEmpty()) {
				ObservableList<Soldado> soldadosFeriasFilteredData = FXCollections.observableArrayList(resultados);
				tTelaFerias.setItems(soldadosFeriasFilteredData);

			} else if (resultados.isEmpty()) {
				ObservableList<Soldado> soldadosFeriasFilteredData = FXCollections.observableArrayList(resultados);
				tTelaFerias.setItems(soldadosFeriasFilteredData);

			} else {
				ObservableList<Soldado> soldadosFeriasFilteredData = FXCollections.observableArrayList(resultados);
				tTelaFerias.setItems(soldadosFeriasFilteredData);
			}
		} catch (Exception e) {
			e.printStackTrace();
			mostrarAlerta("Erro", "Erro inesperado", Alert.AlertType.ERROR);
		}
	}

	@FXML
	public void pesquisarPorNomeSoldadosTACF() {
		String nomePesquisa = tfPesquisarTelaTACF.getText().trim().toLowerCase();
		List<Soldado> resultados = soldadoDAO.buscarPorNome(nomePesquisa);
		try {

			if (!nomePesquisa.isEmpty()) {
				ObservableList<Soldado> soldadosTACFFilteredData = FXCollections.observableArrayList(resultados);
				TVTacf.setItems(soldadosTACFFilteredData);

			} else if (resultados.isEmpty()) {
				ObservableList<Soldado> soldadosTACFFilteredData = FXCollections.observableArrayList(resultados);
				TVTacf.setItems(soldadosTACFFilteredData);

			} else {
				ObservableList<Soldado> soldadosTACFFilteredData = FXCollections.observableArrayList(resultados);
				TVTacf.setItems(soldadosTACFFilteredData);
			}
		} catch (Exception e) {
			e.printStackTrace();
			mostrarAlerta("Erro", "Erro inesperado", Alert.AlertType.ERROR);
		}

	}

	@FXML
	public void pesquisarPorNomeSoldadosInpSaude() {
		String nomePesquisa = tfPesquisarTelaSaude.getText().trim().toLowerCase();
		List<SoldadoInpSaude> resultados = soldadoInpSaudeDAO.buscarPorNome(nomePesquisa);

		try {

			if (!nomePesquisa.isEmpty()) {
				ObservableList<SoldadoInpSaude> soldadosInpSaudeFilteredData = FXCollections
						.observableArrayList(resultados);
				tInspecaoSaude.setItems(soldadosInpSaudeFilteredData);

			} else if (resultados.isEmpty()) {
				ObservableList<SoldadoInpSaude> soldadosInpSaudeFilteredData = FXCollections
						.observableArrayList(resultados);
				tInspecaoSaude.setItems(soldadosInpSaudeFilteredData);

			} else {
				ObservableList<SoldadoInpSaude> soldadosInpSaudeFilteredData = FXCollections
						.observableArrayList(resultados);
				tInspecaoSaude.setItems(soldadosInpSaudeFilteredData);
			}
		} catch (Exception e) {
			e.printStackTrace();
			mostrarAlerta("Erro", "Erro inesperado", Alert.AlertType.ERROR);
		}
	}

	@FXML
	public void pesquisarPorNomeSoldadosDispMedica() {
		String nomePesquisa = tfPesquisarTelaDispensa.getText().trim().toLowerCase();
		List<SoldadoDispMedica> resultados = soldadoDispMedicaDAO.buscarPorNome(nomePesquisa);

		try {

			if (!nomePesquisa.isEmpty()) {
				ObservableList<SoldadoDispMedica> soldadosDispMedicaFilteredData = FXCollections
						.observableArrayList(resultados);
				TWDispMedica.setItems(soldadosDispMedicaFilteredData);

			} else if (resultados.isEmpty()) {
				carregarDadosSoldados();

			} else {
				ObservableList<SoldadoDispMedica> soldadosDispMedicaFilteredData = FXCollections
						.observableArrayList(resultados);
				TWDispMedica.setItems(soldadosDispMedicaFilteredData);
			}
		} catch (Exception e) {
			e.printStackTrace();
			mostrarAlerta("Erro", "Erro inesperado", Alert.AlertType.ERROR);
		}
	}

}
