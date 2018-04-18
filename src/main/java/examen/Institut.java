package examen;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Created by jordi on 18/04/2018.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
public class Institut {
    public String nom;
    public int operacions;
    public Institut(String i){
        this.nom = i;
        this.operacions=0;
    }
}
