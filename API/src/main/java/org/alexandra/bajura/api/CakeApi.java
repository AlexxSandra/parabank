package org.alexandra.bajura.api;

import org.alexandra.bajura.entity.Cake;

import java.util.ArrayList;
import java.util.List;

public class CakeApi {
    private  List<Cake> listOfCakes;   //pole acces modifier/ data type/ name

    public CakeApi(List<Cake> listOfCakes) { //access modifire(private/public)/ tip dannyh/ argument list
        this.listOfCakes = listOfCakes; //method body

    }  // konstruktor s argumentom/

    public CakeApi() {
        this.listOfCakes = new ArrayList<>();
    }//konstruktor

    public Cake getCakeByPosition(int positionCake) { //(argument)
        return listOfCakes.get(positionCake);
    }//functsiea vernuti cake ot pozitsii v spiske

    public List<Cake> getListOfCakes() {
        return listOfCakes;
    } //vernuli list vseh cakes

    public void addCake(String name, int terms, float weight) {
        Cake cake = new Cake(name, terms, weight);  ///sozdali novyi obiekt(tip danny/class, nazvabnie obiecra (konstruktor)
       boolean b = listOfCakes.add(cake); //POLE

        if(b) {
            System.out.println("Cake successful added");
        }
        else {
            System.out.println("Cake is not added");
        }
    }
    public void addCake(Cake cake) {/// overload funktsiea imeet odni i te je parametry no raznye argumenty
        listOfCakes.add(cake);
    }

}




import io.restassured.RestAssured;
        import io.restassured.response.Response;
        import org.testng.annotations.Test;

public class ApiTests {
    @Test
    public void testGetBooksAPI() {
        Response response = RestAssured.get("https://your-api-url/api/books");
        int statusCode = response.getStatusCode();
        // Add assertions to verify status code and response data
    }
}