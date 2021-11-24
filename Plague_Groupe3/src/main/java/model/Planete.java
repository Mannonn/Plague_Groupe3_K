
package model;
import java.util.ArrayList;



public class Planete {

	//Parametres propre de la planete FIXES
	private String nomPlanete;
	private Climat climat;
	private Economique economique;
	private Ere ere;
	//
	//Parametres modifies par tranfert/contamination
	private int popSaine;
	private int popMal;
	// Parametres a ".MAJ()" si transfert/contamination
	private int popTot;
	private int cadavres;
	private double tauxConta;
	//
	//Parametres politique de la planete VARIABLES PAR EVENEMENT
	private Politique politique;
	private Attractiv attract;       
	private boolean ouverFront;
	private boolean testPCRent;
	private boolean testPCSortie;
	//
	//Parametres Virus de la planete VARIABLES PAR ACTION VIRUS/EVENEMENT
	private double coefConta;
	private double mortalite;


	
	public Planete(){}
	public Planete(String nomPlanete, Climat climat, Ere ere ,Economique economique, Politique politique, Attractiv attract,
			boolean ouverFront,boolean testPCSortie,boolean testPCRent, double coefConta,double mortalite, int popSaine, int popMal) {

		this.nomPlanete = nomPlanete;
		this.climat = climat;
		this.ere=ere;
		this.economique=economique;
		
		//
		this.popTot = popSaine+popMal;
		this.tauxConta=(double) popMal/(popTot);
		this.cadavres=0;
		//
		this.popSaine = popSaine;
		this.popMal = popMal;
		//
		this.politique = politique;
		this.ouverFront = ouverFront;
		this.testPCRent = testPCRent;
		this.testPCSortie=testPCSortie;
		this.attract = attract;
		//
		this.coefConta = coefConta;
		this.mortalite= mortalite;
	}

	
	
	public String getNomPlanete() {return nomPlanete;}
	//public void setNomPlanete(String nomPlanete) {this.nomPlanete = nomPlanete;}
	public Climat getClimat() {return climat;}
	//public void setClimat(Climat climat) {this.climat = climat;}
	public Ere getEre() {return ere;}
	//public void setEre(Ere ere) {this.ere = ere;}
	public Economique getEconomique() {return economique;}
	//public void setEconomique(Economique economique) {this.ere = economique;}
	//--------------
	
	public int getPopSaine() {return popSaine;}
	public void setPopSaine(int popSaine) {this.popSaine = popSaine;}

	public int getPopMal() {return popMal;}
	public void setPopMal(int popMal) {this.popMal = popMal;}
	
	public int getPopTot() {return popTot;}
	public void setPopTot(int popTot) {this.popTot = popTot;}

	public int getCadavres() {return cadavres;}
	public void setCadavres(int cadavres) {this.cadavres = cadavres;}
	
	public double getTauxConta() {return tauxConta;}
	public void setTauxConta(double tauxConta) {this.tauxConta = tauxConta;}
	
	//--------------
	
	public Politique getPolitique() {return politique;}
	public void setPolitique(Politique politique) {this.politique = politique;}

	public Attractiv getAttract() {	return attract;}
	public void setAttract(Attractiv attract) {this.attract = attract;}

	public boolean isOuverFront() {return ouverFront;}
	public void setOuverFront(boolean ouverFront) {this.ouverFront = ouverFront;}

	public boolean isTestPCSortie() {return testPCSortie;}
	public void setTestPCSortie(boolean testPCSortie) {this.testPCSortie = testPCSortie;}
	
	public boolean isTestPCRent() {return testPCRent;}
	public void setTestPCRent(boolean testPCRent) {this.testPCRent = testPCRent;}
	
	//--------------	
	
	public double getCoefConta() {return coefConta;}
	public void setCoefConta(double coefConta) {this.coefConta = coefConta;}

	public double getMortalite() {return mortalite;}
	public void setMortalite(double mortalite) {this.mortalite = mortalite;}
	
	@Override
	public String toString() {
		return "Planete [nomPlanete=" + nomPlanete + ", climat=" + climat + ", politique=" + politique + ", attract=" + attract
				+ ", ouverFront=" + ouverFront + ", coefConta=" + coefConta + ", popSaine=" + popSaine + ", popMal="
				+ popMal + ", tauxConta=" + Math.round(tauxConta*100) + "%]";
	}
	public String toStringSimple() {
		return "Planete [nomPlanete=" + nomPlanete + ", testPCReRent=" + testPCRent + ", cadavres=" + cadavres + ", popTot=" + popTot +", popSaine=" + popSaine + ", popMal=" + popMal + ", tauxConta=" + tauxConta*100 + "%]";
	}

	public void MAJ() {
		int popTot2 = this.popSaine+this.popMal;
		this.popTot = popTot2;
		this.tauxConta=(double) this.popMal/popTot2;
	}

	public boolean verifDep(int nbVoy,boolean affic)
	{
		boolean bolll = false;
		if ((this.ouverFront) && (nbVoy<=(this.popTot))){bolll=true;}
		else {if (affic) {System.out.println("Depart de la "+ this.nomPlanete+" de "+nbVoy+" personnes impossible");}}
		return bolll;
	}

	public boolean verifArr(int nbVoy,boolean affic)
	{
		boolean bolll = false;
		if (this.ouverFront){bolll=true;}
		else {if (affic) {System.out.println("Arrivee sur "+ this.nomPlanete+" de "+nbVoy+" personnes impossible");}}
		return bolll;
	}

	public int[] depart(int nbVoy,boolean affic) 
	{
		int voyageurs[]= new int[2];
		boolean PcrSort = this.testPCSortie;
		if((this.verifDep((int) (nbVoy*(1+this.tauxConta/100)),affic)) && PcrSort)
		{if (affic) {System.out.println("Test PCR au depart de "+this.nomPlanete);}
		this.popSaine -=nbVoy;voyageurs[0]= nbVoy;voyageurs[1]= 0;}
		else if(this.verifDep(nbVoy,affic) && !PcrSort) 
		{
			int nbVoyMal = (int) Math.round(nbVoy*tauxConta);
			int nbVoySain = (int) nbVoy - nbVoyMal ;

			this.popSaine -=nbVoySain;
			this.popMal -=nbVoyMal;
			voyageurs[0]= nbVoySain;
			voyageurs[1]= nbVoyMal;
		}

		else {voyageurs[0]= 0;voyageurs[1]= 0;}
		this.MAJ();
		return voyageurs;
	}

	public void arrivee(int[] listVoy,boolean affic)
	{	int voyy = listVoy[0]+listVoy[1];
	boolean PcrArr = this.testPCRent;
	if (this.verifArr(voyy,affic))
	{this.popSaine +=listVoy[0];	
	if (PcrArr && affic) {System.out.println("Test PCR a l'arrivee sur "+this.nomPlanete);}
	else		{this.popMal +=listVoy[1];}
	}
	this.MAJ();
	}

	public void transfertList(int nbPassager,Planete planDest[],boolean affic) 
	{
		for(int i=0;i<planDest.length;i++)
		{this.transfert(nbPassager, planDest[i],affic);}
	}

	public void transfert(int nbPassager, Planete planDest,boolean affic)
	{	int vaisseau1[] = this.depart(nbPassager,affic);
	int vaisseau2[] = new int[2];
	int voyyMal = vaisseau1[1];vaisseau2[1]=voyyMal;
	boolean PcrArr = planDest.testPCRent;
	if (planDest.verifArr(nbPassager,affic) && this.verifDep(nbPassager,affic))
	{
		planDest.arrivee(vaisseau1,affic);
		if (PcrArr)
		{
			this.popMal +=voyyMal;this.MAJ();
			if (affic) {System.out.println("Arrivee de "+ vaisseau1[0]+ " passagers saines sur " + planDest.nomPlanete +
					" et retour de "+vaisseau1[1]+" malades sur "+this.nomPlanete);}}
		else {if (affic) {System.out.println("Transfert de "+ nbPassager+ " passagers de " +this.nomPlanete + " à "+ planDest.nomPlanete+ " dont "+ voyyMal +" malades");}}

	}
	}

	public void contamin(boolean affic) 
	{int contaNew;int contaAnc =this.popMal;int mort;
	int contaNew1;int mort1;
	mort1 = (int) Math.round(this.mortalite*contaAnc);
	contaNew1= (int) Math.round(this.coefConta*contaAnc);
	
	contaNew = (int) Math.min(contaNew1, this.popSaine);
	mort = (int) Math.min(mort1,this.popMal);
	this.popSaine-=contaNew;
	this.popMal+=contaNew;
	this.popMal-=mort;
	this.cadavres+=mort;
	if (affic) 
	{System.out.println("Contamination de "+contaNew+" personnes et mort de "+ mort+" personnes sur "+this.nomPlanete);}
	this.MAJ();
	}

	public void contaminList(Planete planDest[],boolean affic) 
	{	System.out.println("Contamination globale");
	for(int i=0;i<planDest.length;i++)
	{planDest[i].contamin(affic);}
	}

}









	





