package test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import model.*;

public class carteVirus {


	public static void main(String[] args) 
	{
		int cpt =0;
		int paquet[] = PaquetVirus(10);
		System.out.println(Arrays.toString(paquet));
		System.out.println(" ");
		System.out.println(" ");
		while (cpt<38)
		{int toto = aleatoire(paquet);
		paquet[toto]--;
		System.out.println(Arrays.toString(paquet));
		cpt++;}
		System.out.println("fin du test");
	}


	//boolean ouverFront,boolean testPCSortie,boolean testPCRent,

	//--------------
	//Actions types des cartes
	public static void migrGenerale(Planete[] planetes,int nbPassager,boolean affic) 
	{	//System.out.println(" ");
		//System.out.println("Migration generale");
		for(int i=0;i<planetes.length;i++)
		{planetes[i].transfertList(nbPassager, planetes,affic);}
	}	
	public static void migrClimat(Planete[] planetes,int nbPassager,Climat temp1,Climat temp2,boolean affic) 
	{	//System.out.println(" ");
		//System.out.println("Migration Climatique de "+temp1.toString()+" vers "+temp2.toString());
		for(int i=0;i<planetes.length;i++)
		{
			if (planetes[i].getClimat().equals(temp1))
			{
				for(int j=0;j<planetes.length;j++)
				{	
					if (planetes[j].getClimat().equals(temp2))
					{
						planetes[i].transfert(nbPassager, planetes[j],affic);
					}
				}
			}
			else {}
		}
	}
	public static void migrAttract(Planete[] planetes,int nbPassager,Attractiv attr1,Attractiv attr2,boolean affic) 
	{	//System.out.println(" ");
		//System.out.println("Migration attractivite de "+attr1.toString()+"vers "+attr2.toString());
		for(int i=0;i<planetes.length;i++)
		{
			if (planetes[i].getAttract().equals(attr1))
			{
				for(int j=0;j<planetes.length;j++)
				{	
					if (planetes[j].getAttract().equals(attr2))
					{
						if (affic) {System.out.println(planetes[i].getNomPlanete()+" vers "+planetes[j].getNomPlanete());}
						planetes[i].transfert(nbPassager, planetes[j],affic);
					}
				}
			}
			else {}
		}
	}
	public static void migrPoli(Planete[] planetes,int nbPassager,Politique polit1,Politique polit2,boolean affic) 
	{	//System.out.println(" ");
		//System.out.println("Migration politique de "+polit1.toString()+ " vers " + polit2.toString());
		for(int i=0;i<planetes.length;i++)
		{
			if (planetes[i].getPolitique().equals(polit1))
			{
				for(int j=0;j<planetes.length;j++)
				{	
					if (planetes[i].getPolitique().equals(polit2))
					{
						planetes[i].transfert(nbPassager, planetes[j],affic);
					}
				}
			}
			else {}
		}
	}
	public static void migrTaux(Planete[] planetes,int nbPassager,double tauxMax, double tauxVoulu,boolean affic) 
	{	//System.out.println(" ");
		//System.out.println("Migration sanitaire");
		for(int i=0;i<planetes.length;i++)
		{
			if (planetes[i].getTauxConta()>tauxMax)
			{
				for(int j=0;j<planetes.length;j++)
				{	
					if (planetes[j].getTauxConta()<tauxVoulu)
					{
						planetes[i].transfert(nbPassager, planetes[j],affic);
					}
				}
			}
			else {}
		}
	}	
	public static void migrRichesse(Planete[] planetes,int nbPassager,Economique eco1,Economique eco2,boolean affic) 
	{	//System.out.println(" ");
		//System.out.println("Migration economique de "+polit1.toString()+ " vers " + polit2.toString());
		for(int i=0;i<planetes.length;i++)
		{
			if (planetes[i].getEconomique().equals(eco1))
			{
				for(int j=0;j<planetes.length;j++)
				{	
					if (planetes[i].getEconomique().equals(eco2))
					{
						planetes[i].transfert(nbPassager, planetes[j],affic);
					}
				}
			}
			else {}
		}
	}
	//--------------
	public static void modifPolit(Planete[] planetes,Politique poliPast,Politique poliNew)
	{
		for(int i=0;i<planetes.length;i++)
		{if (planetes[i].getPolitique().equals(poliPast))
		{planetes[i].setPolitique(poliNew);
		System.out.println(planetes[i].getNomPlanete()+" est devenue une "+planetes[i].getPolitique());}
		else {}
		}
	}
	public static void modifAttract(Planete[] planetes,Attractiv AttriPast,Attractiv AttriNew)
	{
		for(int i=0;i<planetes.length;i++)
		{if (planetes[i].getAttract().equals(AttriPast))
		{planetes[i].setAttract(AttriNew);
		System.out.println(planetes[i].getNomPlanete()+" a une attrait "+planetes[i].getAttract());}
		else {}
		}
	}
	public static void modifAttractPol(Planete[] planetes,Politique poli,Attractiv AttriPast,Attractiv AttriNew)
	{
		for(int i=0;i<planetes.length;i++)
		{if ((planetes[i].getAttract().equals(AttriPast))&&(planetes[i].getPolitique().equals(poli)))
		{planetes[i].setAttract(AttriNew);
		System.out.println(planetes[i].getNomPlanete()+" a une attrait "+planetes[i].getAttract());}
		else {}
		}
	}
	public static void modifAttracTemp(Planete[] planetes,Climat temp1,Attractiv AttriPast,Attractiv AttriNew)
	{
		for(int i=0;i<planetes.length;i++)
		{if ((planetes[i].getAttract().equals(AttriPast))&&(planetes[i].getClimat().equals(temp1)))
		{planetes[i].setAttract(AttriNew);
		System.out.println(planetes[i].getNomPlanete()+" a une attrait "+planetes[i].getAttract());}
		else {}
		}
	}
	//--------------
	public static void modifcoef(Planete[] planetes,Climat temp1,double multi)
	{
		for(int i=0;i<planetes.length;i++)
		{if (planetes[i].getClimat().equals(temp1))
		{double newcoef = planetes[i].getCoefConta()*multi;
		planetes[i].setCoefConta(newcoef);}
		else {}
		}
	}
	public static void modifmorta(Planete[] planetes,Climat temp1,double multi)
	{
		for(int i=0;i<planetes.length;i++)
		{if (planetes[i].getClimat().equals(temp1))
		{double newcoef = planetes[i].getMortalite()*multi;
		planetes[i].setMortalite(newcoef);}
		else {}
		}
	}
	//--------------
	//--------------


	public static void ViveleSoleil(Planete[] planetes,int nbPassager, boolean affic)
	{	System.out.println("Il y en a marre du froid, je veux du soleil et un beau teint homard");
	migrClimat(planetes, nbPassager,Climat.Froid,Climat.Chaud,affic);}

	public static void ToutSchuss(Planete[] planetes,int nbPassager,boolean affic)
	{	System.out.println("Comment ca tu fais de la raquette, le ski Hors piste c'est la vie!");
	migrClimat(planetes, nbPassager,Climat.Froid,Climat.Chaud,affic);}

	public static void GrandeVacances(Planete[] planetes,int nbPassager,boolean affic)
	{	System.out.println("Tu es plutot juilletiste ou aoutien?");
	migrGenerale(planetes, nbPassager,affic);}

	public static void Disney(Planete[] planetes,int nbPassager, boolean affic)
	{	System.out.println("QUOI le fast pass est devenu payant, c'est une honte. Viens on va a ratatouille");
	migrAttract(planetes, nbPassager, Attractiv.Faible,Attractiv.Forte,affic);}

	public static void Tsunami(Planete[] planetes,int nbPassager)
	{	System.out.println("TSUNAMI");
	modifAttracTemp(planetes,Climat.Chaud,Attractiv.Moyenne,Attractiv.Faible);
	modifAttracTemp(planetes,Climat.Chaud,Attractiv.Forte,Attractiv.Moyenne);
	}

	public static void Revolution(Planete[] planetes,int nbPassager)
	{	System.out.println("Le roi est mort, vive l'anarchie");
	modifPolit(planetes,Politique.Dictature,Politique.Anarchie);
	}

	public static void GuerreEco(Planete[] planetes,int nbPassager)
	{	System.out.println("Fuir la misere, vers une utopie");
	migrRichesse(planetes, nbPassager,Economique.Pauvre, Economique.Riche, false);;
	}

	public static void GreveGenerale()
	{	System.out.println("Greve des pilotes!!!!!");}

	public static void HopitalSature(Planete[] planetes,int nbPassager,boolean affic) 
	{System.out.println("Marre des masques,  l'air est plus pur chez les autres");
	migrTaux(planetes, nbPassager, 0.2, 0.05,affic);
	}

	// ------------ Tirage des cartes

	
	
	public static int aleatoire(int[] nbCarte)
	{
		Random r  = new Random();
		int alea = r.nextInt(nbCarte.length);
        int allea = 0;int cpt =0;
        while (nbCarte[alea]==0) 
		{
			if (alea<nbCarte.length-1) {alea++;}
			else {alea=0;}
			cpt++;
			if (cpt>=nbCarte.length) {System.out.println("Plus de carte diponibles");break;}
		}
		return alea;
	}
	
	public static void tirageCarte(Planete[] planetes, int nbPassager, int[] nbCarte) {
		int alea = aleatoire (nbCarte);
		switch(alea)
		{
		case 0 : ViveleSoleil(planetes, nbPassager,false);break; // connection admin (secretaire ou medecin)
		case 1 : ToutSchuss(planetes, nbPassager,false);break; //enregistrement patient
		case 2 : GrandeVacances(planetes, nbPassager*2,false);break;
		case 3 : Disney(planetes, nbPassager,false);break; // connection admin (secretaire ou medecin)
		case 4 : Tsunami(planetes, nbPassager);break; //enregistrement patient
		case 5 : Revolution(planetes, nbPassager);break;
		case 6 : GuerreEco(planetes, nbPassager);break;
		case 7 : GreveGenerale();break;
		case 8 : HopitalSature(planetes, nbPassager,false);break;
		}
		nbCarte[alea]--;
	}

	public static int[] PaquetVirus(int nombreTour)
	{
		System.out.println("Creation du paquet virus");

		Random r  = new Random();
		int nbCarte[] = new int[9];
		int nbTotCarte =0;
		int cpt = 0;
		boolean taille = false;
		while(!taille && cpt<10)
		{	nbTotCarte=0;
			for(int i=0;i<nbCarte.length;i++) {int allea = r.nextInt(3);nbCarte[i]=allea+1;}
			for(int i=0;i<nbCarte.length;i++) {nbTotCarte+=nbCarte[i];}
			if (nbTotCarte >=Math.max(20,(nombreTour+2))) {taille = true;}
			cpt++;
		}
		if (nbTotCarte <=Math.max(20,(nombreTour+2)))
		{
			for(int i=0;i<nbCarte.length;i++) {nbCarte[i]+=nbCarte[i];}
			nbTotCarte=nbTotCarte*2;
		}
		System.out.println("Le virus a un paquet de "+ nbTotCarte + " cartes");
		return nbCarte;
	}
}
