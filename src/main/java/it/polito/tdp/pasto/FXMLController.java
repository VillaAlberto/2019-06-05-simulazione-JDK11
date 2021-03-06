package it.polito.tdp.pasto;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import com.jfoenix.controls.JFXToggleButton;

import it.polito.tdp.pasto.model.Condimento;
import it.polito.tdp.pasto.model.Model;
import it.polito.tdp.pasto.model.Ordinazione;
import it.polito.tdp.pasto.model.Pasta;
import it.polito.tdp.pasto.model.Piatto;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;

public class FXMLController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private JFXTimePicker pickArrivo;

	@FXML
	private JFXTimePicker pickOrdinazione;

	@FXML
	private JFXTimePicker pickServizio;

	@FXML
	private JFXTimePicker pickScontrino;

	@FXML
	private JFXDatePicker pickGiorno;

	@FXML
	private JFXComboBox<Pasta> cmbPasta;

	@FXML
	private JFXComboBox<Condimento> cmbCondimento;

	@FXML
	private JFXComboBox<Piatto> cmbPiatto;

	@FXML
	private JFXTextArea txtRiepilogoTavolo;

	@FXML
	private JFXTextField txtPersoneServite;

	@FXML
	private JFXTextField txtImporto;

	@FXML
	private JFXButton btnSalvaTavolo;

	@FXML
	private JFXButton btnPulisciTavolo;

	@FXML
	private JFXButton btnAggiungiOrdinazione;

	@FXML
	private JFXRadioButton radUltimaSettimana;

	@FXML
	private ToggleGroup periodo;

	@FXML
	private JFXRadioButton radUltimoMese;

	@FXML
	private JFXRadioButton radUltimiMesi;

	@FXML
	private JFXRadioButton radMinClienti;

	@FXML
	private ToggleGroup clienti;

	@FXML
	private JFXRadioButton radMinFatturato;

	@FXML
	private ToggleGroup fatturato;

	@FXML
	private JFXRadioButton radMinTempi;

	@FXML
	private ToggleGroup tempi;

	@FXML
	private JFXRadioButton radMaxClienti;

	@FXML
	private JFXRadioButton radMaxFatturato;

	@FXML
	private JFXRadioButton radMaxTempi;

	@FXML
	private JFXButton AvviaRicorsione;

	@FXML
	private JFXTextArea txtParametriSignificativi;

	@FXML
	private JFXTextArea txtRisultatoRicorsione;

	@FXML
	private JFXToggleButton bDehors;

	@FXML
	private Slider sldDehors;

	@FXML
	private JFXToggleButton bAsporto;

	@FXML
	private JFXToggleButton bPastaFresca;

	@FXML
	private Slider sldAsporto;

	@FXML
	private JFXToggleButton bPiattoFreddo;

	@FXML
	private Slider sldPiattoFreddo;

	@FXML
	private JFXToggleButton bCucinaIdeale;

	@FXML
	private Slider sldCucinaIdeale;

	@FXML
	private JFXToggleButton bSanificazioneIdeale;

	@FXML
	private Slider sldSanificazioneIdeale;

	@FXML
	private JFXToggleButton bErroreInCucina;

	@FXML
	private Slider sldErroreInCucina;

	@FXML
	private JFXButton btnBEST;

	@FXML
	private JFXButton WORST;

	@FXML
	private JFXToggleButton bAttesaIllimitata;

	@FXML
	private Slider sldAttesaIllimitata;

	@FXML
	private JFXButton btnAvviaSimulazione;

	@FXML
	private JFXTextField txtBestSoddisfatti;

	@FXML
	private JFXTextField txtWorstSoddisfatti;

	@FXML
	private JFXTextField txtSimulazioneSoddisfatti;

	@FXML
	private JFXTextField txtBestInsoddisfatti;

	@FXML
	private JFXTextField txtWorstInsoddisfatti;

	@FXML
	private JFXTextField txtSimulazioneInsoddisfatti;

	@FXML
	private JFXTextField txtBestSoddisfazione;

	@FXML
	private JFXTextField txtWorstSoddisfazione;

	@FXML
	private JFXTextField txtSimulazioneSoddisfazione;

	@FXML
	private JFXTextField txtBestAttesa;

	@FXML
	private JFXTextField txtWorstAttesa;

	@FXML
	private JFXTextField txtSimulazioneAttesa;

	@FXML
	private JFXTextField txtBestAsporto;

	@FXML
	private JFXTextField txtWorstAsporto;

	@FXML
	private JFXTextField txtSimulazioneAsporto;

	@FXML
	private JFXTextField txtBestPreparati;

	@FXML
	private JFXTextField txtWorstPreparati;

	@FXML
	private JFXTextField txtSimulazionePreparati;

	@FXML
	private JFXTextField txtBestFatturato;

	@FXML
	private JFXTextField txtWorstFatturato;

	@FXML
	private JFXTextField txtSimulazioneFatturato;

	@FXML
	private Label numeroClienti;

	private Model model;

	@FXML
	void AggiornaServizio(ActionEvent event) {
		pickServizio.setValue(pickOrdinazione.getValue());
		pickOrdinazione.setDisable(false);
		pickScontrino.setDisable(true);
		pickServizio.setDisable(false);
	}

	@FXML
	void abilitaAsporto(ActionEvent event) {
		if (!bAsporto.isSelected()) {
			sldAsporto.setDisable(true);
		} else {
			sldAsporto.setDisable(false);
		}
	}

	@FXML
	void abilitaAttesaIllimitata(ActionEvent event) {
		if (bAttesaIllimitata.isSelected()) {
			sldAttesaIllimitata.setDisable(true);
		} else {
			sldAttesaIllimitata.setDisable(false);
		}
	}

	@FXML
	void abilitaCucinaIdeale(ActionEvent event) {
		if (bCucinaIdeale.isSelected()) {
			sldCucinaIdeale.setDisable(true);
		} else {
			sldCucinaIdeale.setDisable(false);
		}
	}

	@FXML
	void abilitaDehors(ActionEvent event) {
		if (!bDehors.isSelected()) {
			sldDehors.setDisable(true);
		} else {
			sldDehors.setDisable(false);
		}

	}

	@FXML
	void abilitaErroreInCucina(ActionEvent event) {
		if (!bErroreInCucina.isSelected()) {
			sldErroreInCucina.setDisable(true);
		} else {
			sldErroreInCucina.setDisable(false);
		}
	}

	@FXML
	void abilitaPiattoFreddo(ActionEvent event) {
		if (!bPiattoFreddo.isSelected()) {
			sldPiattoFreddo.setDisable(true);
		} else {
			sldPiattoFreddo.setDisable(false);
		}
	}

	@FXML
	void abilitaSanificazioneIdeale(ActionEvent event) {
		if (bSanificazioneIdeale.isSelected()) {
			sldSanificazioneIdeale.setDisable(true);
		} else {
			sldSanificazioneIdeale.setDisable(false);
		}
	}

	@FXML
	void aggiornaOrdinazione(ActionEvent event) {
		pickOrdinazione.setValue(pickArrivo.getValue());
		pickOrdinazione.setDisable(false);
		pickScontrino.setDisable(true);
		pickServizio.setDisable(true);
	}

	@FXML
	void aggiornaScontrino(ActionEvent event) {
		pickScontrino.setValue(pickServizio.getValue());
		pickOrdinazione.setDisable(false);
		pickScontrino.setDisable(false);
		pickServizio.setDisable(false);

	}

	@FXML
	void doAggiungiOrdinazione(ActionEvent event) {
		txtRiepilogoTavolo.clear();
		btnPulisciTavolo.setDisable(false);
		cmbPiatto.setDisable(false);
		cmbPasta.setDisable(false);
		cmbCondimento.setDisable(true);

		// Tutte le condizioni per cui non posso inserire l'ordinazione
		if (selezioniCorrette()&&tempiEDataAmmissibili()) {
			
			//txtRiepilogoTavolo.setText("Posso inserire questa ordinazione\n");
			//Aggiungo nella lista
			boolean daCondire=false;
			
			if (cmbCondimento.getValue()!=null)
				daCondire=true;
			if (daCondire)
			{model.aggiungiInListaTavolo(new Ordinazione(-1, -1, daCondire, null, cmbPasta.getValue(), cmbCondimento.getValue()));}
			else { System.out.println(cmbPiatto.getValue());
				model.aggiungiInListaTavolo(new Ordinazione(-1,-1,daCondire, cmbPiatto.getValue(), null, null));}
			//Stampo la lista nella boxArea
			
				List<Ordinazione> ls= model.dammiLista();
				for (Ordinazione o: ls)
				{
					txtRiepilogoTavolo.appendText(o.toString()+"\n");
				}
			
			//Aggiorno il numero di clienti serviti
				
				txtPersoneServite.setText(String.valueOf(ls.size()));
				txtImporto.setText(String.valueOf(ls.size()*11.50));
				
				if(ls.size()>=1)
					btnSalvaTavolo.setDisable(false);
		} else {
			txtRiepilogoTavolo.appendText("Ordinazione non ammissibile\n");
		}

		cmbPiatto.setValue(null);
		cmbPasta.setValue(null);
		cmbCondimento.setValue(null);
		cmbPiatto.setDisable(false);
		cmbPasta.setDisable(false);
		cmbCondimento.setDisable(true);

	}

	private boolean selezioniCorrette() {
		if ((cmbPiatto.getValue() != null) || (cmbPasta.getValue() != null && cmbCondimento.getValue() != null)) {
			return true;
		} else {
			txtRiepilogoTavolo.setText("Problema nella selezione del pasto\n");
			return false;
		}
	}

	private boolean tempiEDataAmmissibili() {
		if (pickGiorno.getValue() != null && pickArrivo.getValue().compareTo(pickOrdinazione.getValue()) < 0
				&& pickOrdinazione.getValue().compareTo(pickServizio.getValue()) < 0
				&& pickServizio.getValue().compareTo(pickScontrino.getValue()) < 0) {
			return true;
		} else {
			txtRiepilogoTavolo.setText("Problema nell'inserimento dei tempi\n");
			return false;
		}

	}

	@FXML
	void doPulisciTavolo(ActionEvent event) {
		btnSalvaTavolo.setDisable(true);
		pickArrivo.setDisable(false);
		pickGiorno.setDisable(false);
		pickOrdinazione.setDisable(false);
		pickScontrino.setDisable(false);
		pickServizio.setDisable(false);
		cmbPiatto.setValue(null);
		cmbPasta.setValue(null);
		cmbCondimento.setValue(null);
		cmbPiatto.setDisable(false);
		cmbPasta.setDisable(false);
		cmbCondimento.setDisable(true);
		txtRiepilogoTavolo.clear();
		model.pulisciListaTavolo();
		txtPersoneServite.setText("0");
		txtImporto.setText("10.00");
	}

	@FXML
	void doSalvaTavolo(ActionEvent event) {
		double importo;
		//Guardo se l'importo è ammissibile
		try {
			importo= Double.parseDouble(txtImporto.getText());
		}
		catch (NumberFormatException e) {
			txtRiepilogoTavolo.setText("Introdotto un importo non parsabile");
			return;
		}
		
		
		//salvo il tavolo
		if (model.salvaTavolo(pickGiorno.getValue(), pickArrivo.getValue(), pickOrdinazione.getValue(), pickServizio.getValue(), pickScontrino.getValue(),importo))
		{
			txtRiepilogoTavolo.setText("Tavolo aggiunto correttamente\n");
		}
		else txtRiepilogoTavolo.setText("Errore nell'inserimento del tavolo\n");
		
		//Reimposto tutto per aggiungere il tavolo successivo
		txtImporto.clear();
		txtPersoneServite.setText("0");
		pickGiorno.setValue(LocalDate.now());
		pickArrivo.setValue(LocalTime.of(12, 0));
		pickGiorno.setDisable(false);
		pickArrivo.setDisable(false);
		pickOrdinazione.setDisable(true);
		pickScontrino.setDisable(true);
		pickServizio.setDisable(true);
		btnAggiungiOrdinazione.setDisable(true);
		btnPulisciTavolo.setDisable(true);
		btnSalvaTavolo.setDisable(true);
		cmbCondimento.setDisable(true);
	}

	@FXML
	void doSimulazione(ActionEvent event) {
		int giorniDehors;
		double percAsporto;
		double perFreddo;
		double tempoRiassetto;
		double tempoSanificazione;
		int frequenzaErrore;
		int tempoAttesa;
		boolean pastaFresca=bPastaFresca.isSelected();
		
		if (bDehors.isSelected())
			giorniDehors=(int) sldDehors.getValue();
		else giorniDehors=0;
		
		if(bAsporto.isSelected())
			percAsporto= sldAsporto.getValue();
		else percAsporto=0;
		
		if(bPiattoFreddo.isSelected())
			perFreddo=sldPiattoFreddo.getValue();
		else perFreddo=0;
		
		if(bCucinaIdeale.isSelected())
			tempoRiassetto=0;
		else tempoRiassetto=(int) sldCucinaIdeale.getValue();
		
		if(bSanificazioneIdeale.isSelected())
			tempoSanificazione=0;
		else tempoSanificazione=(int) sldSanificazioneIdeale.getValue();
		
		if(bErroreInCucina.isSelected())
			frequenzaErrore=(int) sldErroreInCucina.getValue();
		else frequenzaErrore=10000;
		
		if(bAttesaIllimitata.isSelected())
			tempoAttesa=60*1000;	
		else tempoAttesa=(int) sldAttesaIllimitata.getValue();
		//MIA SIMULAZIONE
		//Avvio la simulazione
		model.avviaSimulazione(giorniDehors, percAsporto, perFreddo, tempoRiassetto, tempoSanificazione, frequenzaErrore, tempoAttesa, pastaFresca);
		numeroClienti.setText(String.valueOf(model.getTotali()));
		//Raccolgo i parametri
		txtSimulazioneSoddisfatti.setText(String.format("%d", model.getSoddisfatti()));
		txtSimulazioneInsoddisfatti.setText(String.format("%d", model.getInsoddisfatti()));
		txtSimulazioneSoddisfazione.setText(String.format("%.2f%%",(double) model.getSoddisfatti()*100/model.getTotali()));
		int contatore=0;
		int somma=0;
		for (Integer i: model.getListaAttese())
		{
			somma+=i;
			contatore++;
		}
		txtSimulazioneAttesa.setText(String.format("%.2f min", 1.0*somma/contatore));
		txtSimulazioneAsporto.setText(String.format("%.2f%%", (double)model.getAsporti()*100/model.getSoddisfatti()));
		txtSimulazionePreparati.setText(String.format("%.2f%%", (double)model.getPreparati()*100/model.getSoddisfatti()));
		txtSimulazioneFatturato.setText(String.format("%.2f€", model.getFatturato()/100));
		
	
		
		//BEST
		
		//Avvio la simulazione
				model.avviaSimulazione(6, 1, 1, 0, 0, 10000, 10000, true);
				//Raccolgo i parametri
				txtBestSoddisfatti.setText(String.format("%d", model.getSoddisfatti()));
				txtBestInsoddisfatti.setText(String.format("%d", model.getInsoddisfatti()));
				txtBestSoddisfazione.setText(String.format("%.2f%%",(double) model.getSoddisfatti()*100/model.getTotali()));
				int contatore1=0;
				int somma1=0;
				for (Integer i: model.getListaAttese())
				{
					somma1+=i;
					contatore1++;
				}
				txtBestAttesa.setText(String.format("%.2f min", 1.0*somma1/contatore1));
				txtBestAsporto.setText(String.format("%.2f%%", (double)model.getAsporti()*100/model.getSoddisfatti()));
				txtBestPreparati.setText(String.format("%.2f%%", (double)model.getPreparati()*100/model.getSoddisfatti()));
				txtBestFatturato.setText(String.format("%.2f€", model.getFatturato()/100));
				
		
		//WORST
				
				//Avvio la simulazione
				model.avviaSimulazione(0, 0, 0, 10, 4, 5, 5, false);
				//Raccolgo i parametri
				txtWorstSoddisfatti.setText(String.format("%d", model.getSoddisfatti()));
				txtWorstInsoddisfatti.setText(String.format("%d", model.getInsoddisfatti()));
				txtWorstSoddisfazione.setText(String.format("%.2f%%",(double) model.getSoddisfatti()*100/model.getTotali()));
				int contatore2=0;
				int somma2=0;
				for (Integer i: model.getListaAttese())
				{
					somma2+=i;
					contatore2++;
				}
				txtWorstAttesa.setText(String.format("%.2f min", 1.0*somma2/contatore2));
				txtWorstAsporto.setText(String.format("%.2f%%", (double)model.getAsporti()*100/model.getSoddisfatti()));
				txtWorstPreparati.setText(String.format("%.2f%%", (double)model.getPreparati()*100/model.getSoddisfatti()));
				txtWorstFatturato.setText(String.format("%.2f€", model.getFatturato()/100));
				
	}

	@FXML
	void liberaOrdinazione(ActionEvent event) {
		btnAggiungiOrdinazione.setDisable(false);
		pickArrivo.setDisable(true);
		pickGiorno.setDisable(true);
		pickOrdinazione.setDisable(true);
		pickScontrino.setDisable(true);
		pickServizio.setDisable(true);
	}

	@FXML
	void setBest(ActionEvent event) {
		bDehors.setSelected(true);
		sldDehors.setValue(6);
		bAsporto.setSelected(true);
		sldAsporto.setValue(1.0);
		bPiattoFreddo.setSelected(true);
		sldPiattoFreddo.setValue(1.0);
		bCucinaIdeale.setSelected(true);
		sldCucinaIdeale.setValue(0);
		bSanificazioneIdeale.setSelected(true);
		sldSanificazioneIdeale.setValue(0);
		bErroreInCucina.setSelected(false);
		bAttesaIllimitata.setSelected(true);
		bPastaFresca.setSelected(true);
		sldCucinaIdeale.setDisable(true);
		sldSanificazioneIdeale.setDisable(true);
		sldErroreInCucina.setDisable(true);
		sldAttesaIllimitata.setDisable(true);
		sldDehors.setDisable(false);
		sldAsporto.setDisable(false);
		sldPiattoFreddo.setDisable(false);
	}

	@FXML
	void setWorst(ActionEvent event) {
		sldCucinaIdeale.setDisable(false);
		sldSanificazioneIdeale.setDisable(false);
		sldErroreInCucina.setDisable(false);
		sldAttesaIllimitata.setDisable(false);
		sldDehors.setDisable(true);
		sldAsporto.setDisable(true);
		sldPiattoFreddo.setDisable(true);
		bDehors.setSelected(false);
		sldDehors.setValue(0);
		bAsporto.setSelected(false);
		sldAsporto.setValue(0);
		bPiattoFreddo.setSelected(false);
		sldPiattoFreddo.setValue(0);
		bCucinaIdeale.setSelected(false);
		sldCucinaIdeale.setValue(10);
		bSanificazioneIdeale.setSelected(false);
		sldSanificazioneIdeale.setValue(4);
		bErroreInCucina.setSelected(true);
		sldErroreInCucina.setValue(5);
		bAttesaIllimitata.setSelected(false);
		sldAttesaIllimitata.setValue(5);
		bPastaFresca.setSelected(false);

	}

	@FXML
	void soRicorsione(ActionEvent event) {
		btnAvviaSimulazione.setDisable(false);
		int numGiorni=0;
		if (radUltimaSettimana.isSelected())
			numGiorni=6;
		if (radUltimoMese.isSelected())
			numGiorni=12;
		if (radUltimiMesi.isSelected())
			numGiorni=24;
		
		//Prendo dal database i miei dati
		model.prendiDati(numGiorni);
		txtParametriSignificativi.setText("Dati ottenuti correttamente dal DB\n");
		txtParametriSignificativi.appendText(String.format("Serviti %d clienti in %d giorni con fatturato totale di %.2f€\n", model.numeroDiClienti(), model.giorniEffettivi(numGiorni), model.fatturato()));
		txtParametriSignificativi.appendText(String.format("Tempo medio INTERARRIVO: %d minuti\n", model.tempoMedioInterarrivo(numGiorni)));
		txtParametriSignificativi.appendText(String.format("Tempo medio PRESA COMANDA: %d minuti\n", model.tempoMedioPresaComanda()));
		txtParametriSignificativi.appendText(String.format("Tempo medio CUCINA: %d minuti\n", model.tempoMedioCucina()));
		txtParametriSignificativi.appendText(String.format("Tempo medio CONSUMAZIONE: %d minuti\n", model.tempoMedioConsumazione()));
		txtParametriSignificativi.appendText(String.format("Piatti cucinati: %d/%d, %.2f %%piatti cucinati, %.2f %%piatti già pronti", model.porzioniDiPastaServite(), model.numeroDiClienti(), model.percentualePasta(), model.percentualePiatto()));
		boolean maxClienti=false;
		boolean maxFatturato=false;
		boolean maxTempi=false;
		if (radMaxClienti.isSelected())
			maxClienti=true;
		if (radMaxFatturato.isSelected())
			maxFatturato=true;
		if (radMaxTempi.isSelected())
			maxTempi=true;
		
			model.doRicorsione(maxClienti, maxFatturato, maxTempi);
			txtRisultatoRicorsione.setText("Ricorsione in corso\n");
			txtRisultatoRicorsione.setText(String.format("La simulazione avverrà con le ordinazioni reali di %d clienti\n L'importo totale da incassare è di %.2f €\n La cucina lavorerà idealmente per %d minuti", model.clientidaSimulare(), model.fatturatoDaSimulare(), model.tempoDaSimulare()));
	}

	@FXML
	void disabilitaPasta(ActionEvent event) {
		cmbPasta.setDisable(true);
	}

	@FXML
	void abilitaCondimentoDisabilitaPiatto(ActionEvent event) {
		cmbPiatto.setDisable(true);
		cmbCondimento.setDisable(false);
	}

	@FXML
	void initialize() {
		assert pickArrivo != null : "fx:id=\"pickArrivo\" was not injected: check your FXML file 'Scene.fxml'.";
		assert pickOrdinazione != null : "fx:id=\"pickOrdinazione\" was not injected: check your FXML file 'Scene.fxml'.";
		assert pickServizio != null : "fx:id=\"pickServizio\" was not injected: check your FXML file 'Scene.fxml'.";
		assert pickScontrino != null : "fx:id=\"pickScontrino\" was not injected: check your FXML file 'Scene.fxml'.";
		assert pickGiorno != null : "fx:id=\"pickGiorno\" was not injected: check your FXML file 'Scene.fxml'.";
		assert cmbPasta != null : "fx:id=\"cmbPasta\" was not injected: check your FXML file 'Scene.fxml'.";
		assert cmbCondimento != null : "fx:id=\"cmbCondimento\" was not injected: check your FXML file 'Scene.fxml'.";
		assert cmbPiatto != null : "fx:id=\"cmbPiatto\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtRiepilogoTavolo != null : "fx:id=\"txtRiepilogoTavolo\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtPersoneServite != null : "fx:id=\"txtPersoneServite\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtImporto != null : "fx:id=\"txtImporto\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnSalvaTavolo != null : "fx:id=\"btnSalvaTavolo\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnPulisciTavolo != null : "fx:id=\"btnPulisciTavolo\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnAggiungiOrdinazione != null : "fx:id=\"btnAggiungiOrdinazione\" was not injected: check your FXML file 'Scene.fxml'.";
		assert radUltimaSettimana != null : "fx:id=\"radUltimaSettimana\" was not injected: check your FXML file 'Scene.fxml'.";
		assert periodo != null : "fx:id=\"periodo\" was not injected: check your FXML file 'Scene.fxml'.";
		assert radUltimoMese != null : "fx:id=\"radUltimoMese\" was not injected: check your FXML file 'Scene.fxml'.";
		assert radUltimiMesi != null : "fx:id=\"radUltimiMesi\" was not injected: check your FXML file 'Scene.fxml'.";
		assert radMinClienti != null : "fx:id=\"radMinClienti\" was not injected: check your FXML file 'Scene.fxml'.";
		assert clienti != null : "fx:id=\"clienti\" was not injected: check your FXML file 'Scene.fxml'.";
		assert radMinFatturato != null : "fx:id=\"radMinFatturato\" was not injected: check your FXML file 'Scene.fxml'.";
		assert fatturato != null : "fx:id=\"fatturato\" was not injected: check your FXML file 'Scene.fxml'.";
		assert radMinTempi != null : "fx:id=\"radMinTempi\" was not injected: check your FXML file 'Scene.fxml'.";
		assert tempi != null : "fx:id=\"tempi\" was not injected: check your FXML file 'Scene.fxml'.";
		assert radMaxClienti != null : "fx:id=\"radMaxClienti\" was not injected: check your FXML file 'Scene.fxml'.";
		assert radMaxFatturato != null : "fx:id=\"radMaxFatturato\" was not injected: check your FXML file 'Scene.fxml'.";
		assert radMaxTempi != null : "fx:id=\"radMaxTempi\" was not injected: check your FXML file 'Scene.fxml'.";
		assert AvviaRicorsione != null : "fx:id=\"AvviaRicorsione\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtParametriSignificativi != null : "fx:id=\"txtParametriSignificativi\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtRisultatoRicorsione != null : "fx:id=\"txtRisultatoRicorsione\" was not injected: check your FXML file 'Scene.fxml'.";
		assert bDehors != null : "fx:id=\"bDehors\" was not injected: check your FXML file 'Scene.fxml'.";
		assert sldDehors != null : "fx:id=\"sldDehors\" was not injected: check your FXML file 'Scene.fxml'.";
		assert bAsporto != null : "fx:id=\"bAsporto\" was not injected: check your FXML file 'Scene.fxml'.";
		assert bPastaFresca != null : "fx:id=\"bPastaFresca\" was not injected: check your FXML file 'Scene.fxml'.";
		assert sldAsporto != null : "fx:id=\"sldAsporto\" was not injected: check your FXML file 'Scene.fxml'.";
		assert bPiattoFreddo != null : "fx:id=\"bPiattoFreddo\" was not injected: check your FXML file 'Scene.fxml'.";
		assert sldPiattoFreddo != null : "fx:id=\"sldPiattoFreddo\" was not injected: check your FXML file 'Scene.fxml'.";
		assert bCucinaIdeale != null : "fx:id=\"bCucinaIdeale\" was not injected: check your FXML file 'Scene.fxml'.";
		assert sldCucinaIdeale != null : "fx:id=\"sldCucinaIdeale\" was not injected: check your FXML file 'Scene.fxml'.";
		assert bSanificazioneIdeale != null : "fx:id=\"bSanificazioneIdeale\" was not injected: check your FXML file 'Scene.fxml'.";
		assert sldSanificazioneIdeale != null : "fx:id=\"sldSanificazioneIdeale\" was not injected: check your FXML file 'Scene.fxml'.";
		assert bErroreInCucina != null : "fx:id=\"bErroreInCucina\" was not injected: check your FXML file 'Scene.fxml'.";
		assert sldErroreInCucina != null : "fx:id=\"sldErroreInCucina\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnBEST != null : "fx:id=\"btnBEST\" was not injected: check your FXML file 'Scene.fxml'.";
		assert WORST != null : "fx:id=\"WORST\" was not injected: check your FXML file 'Scene.fxml'.";
		assert bAttesaIllimitata != null : "fx:id=\"bAttesaIllimitata\" was not injected: check your FXML file 'Scene.fxml'.";
		assert sldAttesaIllimitata != null : "fx:id=\"sldAttesaIllimitata\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnAvviaSimulazione != null : "fx:id=\"btnAvviaSimulazione\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtBestSoddisfatti != null : "fx:id=\"txtBestSoddisfatti\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtWorstSoddisfatti != null : "fx:id=\"txtWorstSoddisfatti\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtSimulazioneSoddisfatti != null : "fx:id=\"txtSimulazioneSoddisfatti\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtBestInsoddisfatti != null : "fx:id=\"txtBestInsoddisfatti\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtWorstInsoddisfatti != null : "fx:id=\"txtWorstInsoddisfatti\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtSimulazioneInsoddisfatti != null : "fx:id=\"txtSimulazioneInsoddisfatti\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtBestSoddisfazione != null : "fx:id=\"txtBestSoddisfazione\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtWorstSoddisfazione != null : "fx:id=\"txtWorstSoddisfazione\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtSimulazioneSoddisfazione != null : "fx:id=\"txtSimulazioneSoddisfazione\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtBestAttesa != null : "fx:id=\"txtBestAttesa\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtWorstAttesa != null : "fx:id=\"txtWorstAttesa\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtSimulazioneAttesa != null : "fx:id=\"txtSimulazioneAttesa\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtBestAsporto != null : "fx:id=\"txtBestAsporto\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtWorstAsporto != null : "fx:id=\"txtWorstAsporto\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtSimulazioneAsporto != null : "fx:id=\"txtSimulazioneAsporto\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtBestPreparati != null : "fx:id=\"txtBestPreparati\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtWorstPreparati != null : "fx:id=\"txtWorstPreparati\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtSimulazionePreparati != null : "fx:id=\"txtSimulazionePreparati\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtBestFatturato != null : "fx:id=\"txtBestFatturato\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtWorstFatturato != null : "fx:id=\"txtWorstFatturato\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtSimulazioneFatturato != null : "fx:id=\"txtSimulazioneFatturato\" was not injected: check your FXML file 'Scene.fxml'.";
		assert numeroClienti != null : "fx:id=\"numeroClienti\" was not injected: check your FXML file 'Scene.fxml'.";

		Model model = new Model();
		pickGiorno.setValue(LocalDate.now());
		pickArrivo.setValue(LocalTime.of(12, 0));
		pickOrdinazione.setDisable(true);
		pickScontrino.setDisable(true);
		pickServizio.setDisable(true);
		btnAggiungiOrdinazione.setDisable(true);
		btnPulisciTavolo.setDisable(true);
		btnSalvaTavolo.setDisable(true);
		cmbCondimento.setDisable(true);
		cmbPasta.getItems().setAll(model.listAllPasta());
		cmbCondimento.getItems().setAll(model.listAllCondimenti());
		cmbPiatto.getItems().setAll(model.listtAllPiatti());

	}

	public void setModel(Model model) {
		this.model = model;

	}

}
