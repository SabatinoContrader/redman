package main.view;
import main.MainDispatcher;
import main.controller.Request;
import main.model.Gomma;
import main.dao.GommaDAO;
import main.service.GommaService;

import java.util.List;
import java.util.Scanner;

public class GommaView implements View {

    private GommaService gommaService;
    private String mode="";
    private Gomma newGomma;

  public GommaView () {
      this.gommaService = new GommaService();
  }

    @Override
    public void showResults(Request request) {
       this.mode  = (String) request.get("mode");
       if (mode.compareTo("all")==0) {
       List<Gomma> gomme = (List<Gomma>) request.get("listaGomma");
       System.out.println("----- Gomme disponibili -----");
       System.out.println();
       gomme.forEach(gomma -> System.out.println(gomma));
       }
    }

    @Override
    public void showOptions() {
        switch (mode) {
            case "insert":
                Scanner scanner = new Scanner(System.in);
                System.out.println("Inserisci i dati della nuova gomma:");
                System.out.println("Modello:");
                String model = getInput();
                System.out.println("Produttore:");
                String manufacturer = getInput();
                System.out.println("Prezzo:");
                double price = Double.parseDouble(getInput());
                newGomma=new Gomma(model, manufacturer, price);
                //double price = Double.parseDouble(getInput());
                //gommaService.insertGomma(new Gomma(model, manufacturer, price));
        }
    }

    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
  }

    @Override
    public void submit() {
    	Request request=new Request();
    	if(mode.equals("insert")){
    		request.put("newGomma", newGomma);
    		request.put("choice", 3);
    		MainDispatcher.getInstance().callAction("Gomma", "doControl", request);
    	}
    	else
    		MainDispatcher.getInstance().callAction("Home", "doControl", null);
    }



}
