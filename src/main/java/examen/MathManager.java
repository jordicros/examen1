package examen;

import java.util.List;
import java.util.Queue;

/**
 * Created by jordi on 18/04/2018.
 */
public interface MathManager {
    public void realitzarOperacio(Operacio op, Alumne p);
    public Operacio processarOperacio();
    public List<Operacio> operacionsInstitut(String ins);
    public List<Operacio> operacionsAlumne(int id);
    public List<Institut> sortInstisByOperations();

}
