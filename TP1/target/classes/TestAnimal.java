/**
 * @author bruno
 *
 */
import fr.univtln.bruno.c11.tp5.*;


public class TestAnimal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/* Ajout d'animaux dans un enclos (par sa référence) */
		Enclos e1=new Enclos("E1");
		e1.add(new Chien("Rex"));
		
		Enclos e2=new Enclos("E2");
		e2.add(new Chien("Brutus"));

		/* Ajout d'animaux dans un enclos (par son nom) */
		Chat  titi=new Chat("Titi");
		titi.setMalade(true);
		Enclos.addAnimal("E1", titi);
		
		/* Affichage de tous les animaux */
		System.out.println("-- Affichage de tous les animaux.");
		System.out.println(Animal.getFaune());
		
		/* Affichage des enclos */
		System.out.println("-- Affichage de tous les enclos (y compris la faune).");
		for (Enclos e: Enclos.getParc())
			System.out.println(e);
	}
}
