package examen;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.ArrayList;
import java.util.List;

    /**
     * Created by jordi on 16/04/2018.
     */
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
    public class Alumne {
        int id;
        public String institut;
        List<Operacio> opFetes= new ArrayList<Operacio>();
        public int getIdUser(){return this.id;}
        public List<Operacio> getopFetes(){return this.opFetes;}


        public Alumne(int id, List<Operacio> llista){this.id=id;
            this.opFetes=llista;}
        public Alumne(int dni, String insti){this.id=dni;
        this.institut=insti;}
        public Alumne(){}

        public int getId() {
            return id;
        }

        public String getInstitut() {
            return institut;
        }

        public List<Operacio> getOpFetes() {
            return opFetes;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setInstitut(String institut) {
            this.institut = institut;
        }

        public void setOpFetes(List<Operacio> opFetes) {
            this.opFetes = opFetes;
        }
    }


