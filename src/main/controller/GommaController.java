package main.controller;

import java.util.List;

import main.MainDispatcher;
import main.model.Gomma;
import main.service.GommaService;

public class GommaController implements Controller {
	private GommaService gommaService;


    @Override
    public void doControl(Request request) {
    	this.gommaService = new GommaService();
        int choice = (int) request.get("choice");
	        switch (choice) {
	            case 1:
	               request.put("mode", "insert");
	               break;
	            case 2:
	            	List<Gomma> gomme = gommaService.getAllGomme();
	            	request.put("listaGomma", gomme);
	                request.put("mode", "all");
	                break;
	            case 3:
	            	Gomma newGomma=new Gomma();
	            	newGomma=(Gomma) request.get("newGomma");
	                gommaService.insertGomma(newGomma);
	                MainDispatcher.getInstance().callView("Home", null);
	                break;
	        }
        MainDispatcher.getInstance().callView("Gomma", request);

    }
}
