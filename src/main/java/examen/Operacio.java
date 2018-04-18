package examen;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Created by jordi on 18/04/2018.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
public class Operacio {
    public double resultat;
    public String[] expressio;
    public int idSolicitant;
    public String institut;
    public Operacio(int id, String[] str){
        this.idSolicitant = id;
        this.resultat=0;
        this.expressio = str;
    }
    public Operacio(){}

}
