package test;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import dao.*;

import java.math.*;
import model.*;
import test.*;
public class Plague {



	public static String saisieString(String msg)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrer votre "+ msg);
		String valeur= sc.nextLine();
		return valeur;
	}

	public static int saisieInt(String msg)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrer votre "+ msg);
		int valeur= sc.nextInt();
		return valeur;
	}

	public static double saisieDouble(String msg)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrer votre "+ msg);
		double valeur= sc.nextDouble();
		return valeur;
	}
	
	
	
	
	
	public static void main(String[] args) {

	
		// PARAMETRES DE LA PARTIE
		
		
		System.out.println("AF Connexion du joueur");
		Compte c1 = new Compte(2, "login", "password", Type_compte.Joueur, "nom", "prenom");
		System.out.println(" ");
		System.out.println("AF Choix de la difficulte du medecin");
		Medecin m1 = new Medecin(4, "Raoult", 3, Difficulte.medium);
		System.out.println("AF Choix du medecin dispo");
		System.out.println(" ");




		Virus v1 = CreationVirus();
		Partie pa1 = CreationPartie(c1,m1,v1);

		Planete ptot[] =genePlanete(10);
		int etatIni[] = contaIni(v1,ptot);
		int tourmax = Math.min(30, saisieInt("Saisisez le nombre de tour (30 max)"));
		int [] nbCarte = carteVirus.PaquetVirus(tourmax);

		ptot = caJoue(tourmax, ptot, nbCarte);
		
		finPartie(pa1, c1, ptot, etatIni);



	}

	


	private static Partie CreationPartie(Compte c1, Medecin m1, Virus v1) {	
		int toto = saisieInt("Saisisez l'ID de la partie");
		int tata =3;
		boolean choix = false;
		String diffi = "ghj";
		
		while (!choix)
		{
			tata = saisieInt("Saisisez la difficulte: Facile(0) Medium(1) Difficile(2)");
			if (tata==0) {diffi = "easy"; choix = true;}
			else if (tata==1) {diffi = "medium"; choix = true;}
			else if (tata==2) {diffi = "hard"; choix = true;}
		}
		
		Partie pa1 = new Partie(toto, c1.getId(), v1.getId(), m1.getId(), Difficulte.valueOf(diffi), true, 0);
		return pa1;
	}

	private static Virus CreationVirus() {	
		int toto = saisieInt("ID du virus");
		String nom = saisieString("nom du virus");
		double propag = 0;
		double morta =0;
		
		int tata =3;
		boolean choix = false;
		String diffi = "ghj";
		
		while (!choix)
		{
			tata = saisieInt("difficulte: Facile(0) Medium(1) Difficile(2)");
			if (tata==0) {diffi = "easy"; choix = true;propag=0.5; morta=0.4;}
			else if (tata==1) {diffi = "medium"; choix = true;propag=0.6; morta=0.6;}
			else if (tata==2) {diffi = "hard"; choix = true;propag=0.7; morta=0.7;}
		}
		System.out.println("Creation du virus ok");
		Virus v1 = new Virus(toto,nom, Difficulte.valueOf(diffi),propag,morta);
		return v1;
	}

	public static int[] etatGalax(Planete[] planetes,String msg) 
	{
		int malIni[] = new int[planetes.length];
		int sainIni[] = new int[planetes.length];
		int cadaIni[] = new int[planetes.length];
		int mal = 0; int sain =0; int cada =0;
		System.out.println(" ");
		System.out.println("Voici l'etat de votre galaxie "+msg);
		for(int i=0;i<planetes.length;i++)
		{
			System.out.println(planetes[i].toStringSimple());
			sainIni[i]=planetes[i].getPopSaine(); sain+=sainIni[i];
			malIni[i]=planetes[i].getPopMal(); mal+=malIni[i];
			cadaIni[i]=planetes[i].getCadavres(); cada+=cadaIni[i];
		}
		int etatIni[] = {sain,mal,cada};
		System.out.println(" ");
		return etatIni;
	}

	public static Planete[] genePlanete(int nbPlanete)
	{
		System.out.println("Votre gaalxie contient "+ nbPlanete + " planetes");
		
		Planete p1 = new Planete("Terre",Climat.Chaud, Ere.Actuelle, Economique.Moyenne, Politique.Neutre, Attractiv.Faible, true,false,true, 0,0, 5000, 0);
		Planete p2 = new Planete("Mars",Climat.Froid, Ere.Future, Economique.Pauvre, Politique.Guerre, Attractiv.Moyenne, true,false,false, 0,0,8000, 0);
		Planete p3 = new Planete("Venus",Climat.Desertique, Ere.MoyenAge, Economique.Riche, Politique.Libertaire, Attractiv.Forte, true,false,false, 0,0,2000, 0);
		Planete p4 = new Planete("Jupiter",Climat.Tempere, Ere.Prehistorique, Economique.Riche, Politique.Dictature, Attractiv.Faible, true,false,false, 0,0,4000, 0);
		Planete ptot[] = {p1,p2,p3,p4};	
		
		System.out.println(" AF allez chercher la base sur sql");

		return ptot;
		
	}
	
	private static int[] contaIni(Virus v1, Planete[] ptot) {
		
		
		System.out.println(" ");
		System.out.println("AF Contamination initiale aleatoire selon difficulte");
		for(int i=0;i<ptot.length;i++)
		{ptot[i].setCoefConta(v1.getPropagation());ptot[i].setMortalite(v1.getMortalite());}
		System.out.println(" ");
		Random r  = new Random();
		int alea = r.nextInt(ptot.length);int alea2 =alea; int alea3 = alea;
		ptot[alea].setPopMal(50);ptot[alea].setPopSaine(ptot[alea].getPopSaine()-50);
		ptot[alea].MAJ();

		if (v1.getDifficulte().equals(Difficulte.medium) || v1.getDifficulte().equals(Difficulte.hard))
		{
			while(alea==alea2) {alea2 = r.nextInt(ptot.length);}
			ptot[alea2].setPopMal(100);ptot[alea2].setPopSaine(ptot[alea].getPopSaine()-100);
			ptot[alea2].MAJ();
		}

		if (v1.getDifficulte().equals(Difficulte.hard)) 
		{
			while(alea3==alea || alea3==alea2) {alea3 = r.nextInt(ptot.length);}
			ptot[alea3].setPopMal(100);ptot[alea3].setPopSaine(ptot[alea3].getPopSaine()-100);
			ptot[alea3].MAJ();
		}
		int etatIni[] =etatGalax(ptot,"initial");
		return etatIni;
	}

	private static Planete[] caJoue(int tourmax,Planete ptot[],int nbCarte[]) 
	{
		System.out.println(" ");
		System.out.println("Que la partie commence");
		
		boolean joue = false;
		int tour = 0;
		while (tour<tourmax)
		{	
			joue = false;
			System.out.println("Tour numero "+ (tour+1));
			carteVirus.tirageCarte(ptot, 50, nbCarte);
			ptot[0].contaminList(ptot,true);
			ActionMedecin.medecinJoue();
			//while (!joue) {int toto = saisieInt("jouer oui-1 ou non-0");if (toto==1) {joue=true;}}
			System.out.println(" ");
			tour++;
		}
		return ptot;
	}
	
	public static void finPartie(Partie pa1,Compte c1,Planete ptot[], int etatIni[]) 
	{
		System.out.println(" ");
		System.out.println("Affichage etat final");
		int etatFin[] =etatGalax(ptot,"final");
		calculscore(etatIni,etatFin,pa1,c1);
		System.out.println(" ");
		System.out.println("AF Stockage score sur SQL");
	}

	public static void calculscore(int[] etatIni,int[] etatFin,Partie pa1,Compte c1)
	{	double scorevivant = (double) 100*(etatFin[0]+etatFin[1])/(etatIni[0]+etatIni[1]);
	double scoresain = (double) 100*(etatFin[0])/(etatIni[0]);
	pa1.setScore(etatFin[0]+etatFin[1]);
	System.out.println(c1.getPrenom()+" a gagne "+ pa1.getScore()+" points");
	System.out.println("Vous avez sauvé "+ scorevivant +" % de la population");
	System.out.println("Vous avez preservé de la maladie "+ scoresain +" % de la population");}




}

