package bank;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class RellenarFichero {
	public static void main(String[] args) {

		App app=new App();
		
		app.arrayListFiller();
		for (Owner o : app.getMyOwners()) {
			System.out.println(o.getName()+"--->"+o.getNif());
		}
		
	}

}
