package ui;

import java.time.LocalDate;
import java.util.Scanner;

import exceptions.DayException;
import exceptions.TypeException;
import model.Store;


public class Menu {

    private final static int NEW_RECORD = 1;
    private final static int NUM_ATTEMPTS = 2;
    private final static int NUM_RECORDS = 3;
    private final static int EXIT = 4;

    private static Scanner sc = new Scanner(System.in);
    private Store store;

    public Menu() {
        store = new Store();
        System.out.println("Bienvenido al minimercado *MI BARRIO TE QUIERE");
    }

    private void optionsOfMenu() {
        System.out.println("*************************");
        System.out.println("*  Menu de opciones     *");
        System.out.println("*************************");
        System.out.println("1. Agregar un registro");
        System.out.println("2. Consultar la cantidad de personas que han intentado ingresar al minimercado");
        System.out.println("3. Consultar cantidad de registros");
        System.out.println("4. Salir");
        System.out.println("");
    }

    public String addRecord() {
	
	    boolean validType = false;
	    int selection = 0;
	
	    do {
	        System.out.println("***********************************");
	        System.out.println("*Ingresa el tipo de identificación*");
	        System.out.println("***********************************");
	        System.out.println("1- TI, Tarjeta de Identidad");
	        System.out.println("2- CC, Cédula de Ciudadanía");
	        System.out.println("3- PP, Pasaporte");
	        System.out.println("4- CE, Cédula de Extranjería");
	        System.out.println("");
	
	        selection = Integer.parseInt(sc.nextLine());
	
	        if (selection == 1 || selection == 2 || selection == 3 || selection == 4) {
	            validType = true;
	        }
	    } while (!validType);
	
	    System.out.println("");
	    System.out.println("Ingresa el número de identificación");
	    System.out.println("");
	    int idNumber = -1;
	    do {
	        try {
	            idNumber = Integer.parseInt(sc.nextLine());
	        } catch (NumberFormatException e) {
	            System.out.println("No se pudo añadir el registro, solo se aceptan caracteres numericos");
	            System.out.println("");
	        }
	    } while (idNumber == -1);
	
	    try {
	        store.addRecord(LocalDate.now(), selection - 1, idNumber);
	        
	        System.out.println("********************");
	        System.out.println("*Registro añadido  *");
	        System.out.println("********************");
	    } catch (TypeException e) {
	    	
	        System.out.println("No se pudo añadir el registro, no pueden ingresar personas menores de edad");
	        System.out.println("");

	    } catch (DayException e) {
	        System.out.println("No se pudo añadir el registro, no puedes ingresar a la minitienda este día");
	        System.out.println("");

	    }
	
	    store.addCount();
	
	    return "Intento añadido";
	}

	public void doOperation(int choice) {
        switch (choice) {
        case NEW_RECORD:
            System.out.println("");
            System.out.println(addRecord());
            System.out.println("");
            break;

        case NUM_ATTEMPTS:
            System.out.println("");
            System.out.println(attendsCount());
            System.out.println("");
            break;

        case NUM_RECORDS:
            System.out.println("");
            System.out.println(recordsCount());
            System.out.println("");
            break;

        case EXIT:
            System.out.println("***********");
            System.out.println("* GRACIAS *");
            System.out.println("***********");
            break;

        default:
            System.out.println("");
            System.out.println("Ingrese una opción valida");
            System.out.println("");
            break;
        }
    }

    public int readOption() {

        int choice = Integer.parseInt(sc.nextLine());
        return choice;
    }

    public String attendsCount() {
	    return store.getCount() + " Intentos de registro";
	}

	public void startProgram() {
        int option;
        do {
            optionsOfMenu();
            option = readOption();
            doOperation(option);
        } while (option != 4);
    }


    public String recordsCount() {
        return store.getRecords().size() + " registros actualmente";
    }
}