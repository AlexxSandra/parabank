package org.alexandra.bajura.entity;

public class Cake {
    private String name; //object
    private int terms; //premetive doljny imeti znaceniea
    private float weight;// premetive

    public Cake (String name, int terms, float weight){
       this.name = name;
       this.terms = terms;
       this.weight = weight;
    } ///KONSTRUKTOR


    public Cake () {
        this.name = null;
        this.terms = 0;
        this.weight = 0;
    }


    public String getName (){
       return this.name ; //sozdali method getter vytashiti name, vernuli string getname
    }

    public void setName(String name) {
        this.name = name; ///public void set.name setter dobavleaet
    }
    public int getTerms () {
      return this.terms;  //method body/scope
    }

    public void setTerms(int terms) {
        this.terms = terms;
    }

    public float getWeight() {
        return weight;
    }
    public void setWeight(float weight) {
        this.weight = weight;
    }
}






///// entity pokazyvaem obiekt s kotorym rabotaem
