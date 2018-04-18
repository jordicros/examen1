
import examen.Alumne;
import examen.MathManagerImpl;
import examen.Operacio;
import examen.ReversePolishNotationImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by jordi on 18/04/2018.
 */
public class JUnitTests {
    @Test
    public void provaCalcul(){
        ReversePolishNotationImpl calc = new ReversePolishNotationImpl();
        String[] expressio = new String[3];
        expressio[0] = "2";
        expressio[1] = "2";
        expressio[2] = "-";
        Operacio op = new Operacio(5,expressio);
        Operacio resultat = calc.processarOperacio(op);
        assertEquals(0, (int)resultat.resultat); //Faig el cast perquè està obsolet amb DOUBLE
        //OBSOLET????
    }
    @Test
    public void setUp(){
        MathManagerImpl p = MathManagerImpl.getInstance();
        List<Alumne> llista= p.getAlumnes();
        assertEquals(new LinkedList<Alumne>(),p.getAlumnes());
        Alumne u = new Alumne(5, "IESJaume");
        llista.add(u);
        MathManagerImpl p2 = MathManagerImpl.getInstance();
        assertEquals(llista.get(0),p2.getAlumnes().get(0));
    }
    @Test
    public void tearDown(){
        MathManagerImpl p = MathManagerImpl.getInstance();
        List<Alumne> llista= p.getAlumnes();
        assertEquals(new LinkedList<Alumne>(),p.getAlumnes());
        Alumne u = new Alumne(5, "IESJaume");
        llista.add(u);
        MathManagerImpl.reset();
        MathManagerImpl p2 = MathManagerImpl.getInstance();
        assertEquals(new LinkedList<Alumne>(),p2.getAlumnes());
    }
    @Test
    public void realizarOperacio()
    {
        MathManagerImpl p = MathManagerImpl.getInstance();
        Alumne u = new Alumne(5, "IESJaume");
        String[] expressio = new String[3];
        expressio[0] = "2";
        expressio[1] = "2";
        expressio[2] = "-";
        Operacio l = new Operacio(5, expressio);
        p.realitzarOperacio(l,u);
        assertEquals(l,p.getOperationQueue().peek());
    }
    @Test
    public void procesarOperacio(){
        //Preparem un mathmanager amb un element a la cua.
        MathManagerImpl p = MathManagerImpl.getInstance();
        Alumne u = new Alumne(5, "IESJaume");
        p.getAlumnes().add(u);
        String[] expressio = new String[3];
        expressio[0] = "2";
        expressio[1] = "2";
        expressio[2] = "-";
        Operacio l = new Operacio(5, expressio);
        p.realitzarOperacio(l,u);
        p.processarOperacio();
        assertEquals(0,(int) p.getAlumnes().get(0).getopFetes().get(0).resultat);
    }
}
