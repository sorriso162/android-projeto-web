package br.usjt.projeto.semestral.Controller;

import br.usjt.projeto.semestral.Model.Solucionador;

public class StaticClass {
private static Solucionador id;



public static Solucionador getId() {
	return id;
}

public static void setId(Solucionador id) {
	StaticClass.id = id;
}



}
