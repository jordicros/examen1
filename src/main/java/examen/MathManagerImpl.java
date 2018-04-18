package examen;


import java.util.*;
import java.util.logging.Logger;


/**
 * Created by jordi on 15/04/2018.
 */
public class MathManagerImpl implements MathManager {
    private static MathManagerImpl ourInstance;
    private Queue<Operacio> operationQueue;
    private List<Institut> instituts;
    private List<Alumne> alumnes;
    private Logger log;
    //SINGLETON
    public static MathManagerImpl getInstance(){
        if(ourInstance==null) {
            ourInstance = new MathManagerImpl();
            return ourInstance;
        }
        else
            return ourInstance;
    }
    private MathManagerImpl(){

        this.operationQueue = new LinkedList<Operacio>();
        this.alumnes = new ArrayList<Alumne>();
        this.instituts = new ArrayList<Institut>();
        this.log = Logger.getLogger("Log4J");
        log.info("Construint instancia");
    }
    public static void reset(){
        ourInstance = new MathManagerImpl();
    }
    public Queue<Operacio> getOperationQueue() {
        return operationQueue;
    }
    public List<Institut> getInstituts() {
        return instituts;
    }
    public List<Alumne> getAlumnes() {
        return alumnes;
    }

    //Funtionalities
    public List<Operacio> operacionsInstitut(String ins) {
        List<Operacio> llista = new ArrayList<Operacio>();
        int i=0;
        log.info("Inici del recorregut");
        while(i<this.alumnes.size())
        {
            //COMPORTAMENT EXTRANY
            Alumne a = this.alumnes.get(i);
            if(a.institut.equals(ins))
                for(int j=0;i<a.opFetes.size();j++)
                {log.info("S'ha trobat un alumne de: "+a.institut);
                Operacio o = a.opFetes.get(j);
                log.info("Hi");
                llista.add(o);}
                log.info("Hi");
                i++;
        }
        log.info("Retornant operacions fetes des d'un institut");
        return llista;
    }
    public List<Operacio> operacionsAlumne(int id){
        int i=0,trobat=0;
        while(i<this.alumnes.size()&&trobat==0)
        {
            if(this.alumnes.get(i).id == id)
                trobat=1;
            else
                i++;
        }
        if(trobat==1) {
            log.info("Retornant operacions fetes per un alumne");
            return this.getAlumnes().get(i).opFetes;
        }
        else
            log.warning("Alumne no trobat");
            return null;
    }
    public List<Institut> sortInstisByOperations(){
        Comparator<Institut> comp1 = new Comparator<Institut>() {

            public int compare(Institut p1, Institut p2){
                if(p1.operacions>=p2.operacions)
                    return -1; //DESCENDING
                else
                    return 0;
            }
        };
        Collections.sort(this.instituts,comp1);
        log.info("Retornant llista d'insituts ordenada per operacions demanades.");
        return this.instituts;
    }
    public void realitzarOperacio(Operacio op, Alumne p){
        int i=0,trobat=0;

        while(i<instituts.size()&&trobat==0){
            if(instituts.get(i).nom==p.institut)
                trobat=1;
            else
                i++;
        }
        if(trobat==1){
            instituts.get(i).operacions++;
        log.info("L'institut ja existia, algú ha demanat operacio des d'alla.");}
        else {
            log.info("Primera consulta des d'un institut");
            Institut insti = new Institut(p.institut);
            insti.operacions++;
            instituts.add(insti);
        }
        op.idSolicitant = p.getIdUser();
        operationQueue.add(op);
        log.info("Operacio afegida a la cua.");
    }
    public Operacio processarOperacio(){
        ReversePolishNotationImpl calculadora = new ReversePolishNotationImpl();
        if(this.operationQueue.size() ==0)
            return null;
        else
        {
        Operacio result = this.getOperationQueue().poll();
        result = calculadora.processarOperacio(result);
        int i=0;
        int trobat=0;
        while(i<alumnes.size()&& trobat==0)
        {
            if(alumnes.get(i).id == result.idSolicitant)
                trobat=1;
            else i++;
        }
        if(trobat==1)
        {
            alumnes.get(i).opFetes.add(result);
            log.info("Operacio afegida al historial");
        }
        else
            log.warning("Alumne no trobat");


        return result;}
    }





}

