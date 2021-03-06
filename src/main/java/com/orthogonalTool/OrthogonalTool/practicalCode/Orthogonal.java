package com.orthogonalTool.OrthogonalTool.practicalCode;

import com.orthogonalTool.OrthogonalTool.matrix.FiveOnX;
import com.orthogonalTool.OrthogonalTool.matrix.FourOnX;
import com.orthogonalTool.OrthogonalTool.matrix.ThreeOnX;
import com.orthogonalTool.OrthogonalTool.matrix.TwoOnX;
import com.orthogonalTool.OrthogonalTool.model.OrthogonalTable;
import net.minidev.json.JSONArray;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Orthogonal {
    public void createOrthogonal(long values, long factors){
        // zápis 2^3 určí že 3 sloupečky (faktory) mají pokaždé 2 hodnoty
        long idealTestPlan = (long) Math.pow(values, factors); //Ideální množství všech Test plánů
        long fact = combinations(factors, 2); // Počet dvojic v parametru
        long doubleValue = (long) Math.pow(values, 2); //Dvojice může nabývat těchto hodnot
        long numberParametersDouble = fact * doubleValue; // Celokvý počet parametrických dvojic
        long idealTC = numberParametersDouble / fact; // U ideálního uspořádání stačí tolik testů

        System.out.println("Ideální množství TC: " + idealTestPlan);
        System.out.println("Počet dvojic: " + fact);
        System.out.println("Každá dvojice může nabývat tolika hodnot: " + doubleValue);
        System.out.println("Celkový počet všech parametrických párů: " + numberParametersDouble);
        System.out.println("Když dáme ideální uspořádání tak potřebujeme jen : " + idealTC +  " testů");


    }

    private long combinations(long number1, long number2){
        long n3 = number1 - number2;
        long fact = factorial(number1) / (factorial(n3) * factorial(number2));
        return fact;
    }

    private long factorial(long number){
        int i, fact = 1;
        for(i=1; i<= number; i++){
            fact=fact*i;
        }
        return fact;
    }

    public OrthogonalTable chooseOrthogonalTable(List<Integer> valueList, JSONArray myArr){
        //TODO: Předělat pak na cyklus který projde list ve kterém porovná value list s tabulkama které mám a pak podle výsledné hodnoty bude jen switch
        // Value list funguje jako array s hodnotami řádky, sloupečky, řádky, sloupečky etc.
        System.out.println("========== Start find OT for back to user new table =====================");
        JsonReader jsonReader = new JsonReader();
        TwoOnX twoOnX = new TwoOnX();
        ThreeOnX threeOnX = new ThreeOnX();
        FourOnX fourOnX = new FourOnX();
        FiveOnX fiveOnX = new FiveOnX();
        
        System.out.println("Value list is: " + valueList);
        System.out.println("Value size is:" + valueList.size());  //Počet hodnot v listu



        int i = 0;
        try {
            //Rovnoměrná tabulka, prostě počet sloupečků s řádkama které jsou všechny zaplněný
            if (valueList.size() <= 2) {
                if (valueList.get(i) <= 2) {
                    if (valueList.get(i + 1) <= 3) {
                        return twoOnX.twoOnThree(jsonReader.getTableFromJson(myArr, 3));
                    }else if(valueList.get(i + 1) <= 11){
                        return twoOnX.twoOnEleven(jsonReader.getTableFromJson(myArr,11));
                    }
                }
                else if (valueList.get(i) == 3){
                    if (valueList.get(i + 1) <= 4){
                        return threeOnX.ThreeOnFour(jsonReader.getTableFromJson(myArr, 4));
                    }
                }
                else if (valueList.get(i) == 4) {
                    if (valueList.get(i + 1) <= 5) {
                        return fourOnX.FourOnFive(jsonReader.getTableFromJson(myArr, 5));
                    }
                }
                else if (valueList.get(i) == 5){
                    if (valueList.get(i + 1) <= 6) {
                        return fiveOnX.FiveOnSix(jsonReader.getTableFromJson(myArr, 6));
                    }
                }
                else{
                    return null;
                }
            } 
            else if (valueList.size() == 4) {
                if (valueList.get(i) <= 2 && valueList.get(i + 1) <= 2) {
                    if (valueList.get(i + 2) <= 6 && valueList.get(i + 3) <= 1) {
                        return twoOnX.twoOnTwoAndOneOnSix(jsonReader.getTableFromJson(myArr, 3));
                    }
                    //2^2 10^1  [2,2,10,1]
                    else if (valueList.get(i + 2) <= 10 && valueList.get(i + 3) <= 1) {
                        return twoOnX.twoOnTwoAndTenOnOne(jsonReader.getTableFromJson(myArr, 3));
                    }
                    else{
                        return null;
                    }
                }
                // tabulka má 2 možnosti ve čtyřech sloupečkách
                else if (valueList.get(i) <= 2 && valueList.get(i + 1) <= 4) {
                    // a 3 možnosti v jednom sloupečku 2^4 3^1 [2,4,3,1]
                    if (valueList.get(i + 2) <= 3 && valueList.get(i + 3) <= 1) {
                        return twoOnX.twoOnFourAndOneOnThree(jsonReader.getTableFromJson(myArr, 5));
                    }
                    else if (valueList.get(i + 2) <= 4 && valueList.get(i + 3) <= 1) {
                        return twoOnX.twoOnFourAndOneOnFour(jsonReader.getTableFromJson(myArr, 5));
                    }
                    else{
                        return null;
                    }
                }else if (valueList.get(i) <= 2 && valueList.get(i + 1) <= 8) {
                    // 2^8 5^1 [2,8,5,1]
                    if (valueList.get(i + 2) <= 5 && valueList.get(i + 3) <= 1){
                        
                        return twoOnX.twoOnEightAndFiveOnOne(jsonReader.getTableFromJson(myArr, 9));
                    }
                    // 2^8 8^1 [2,8,8,1]
                    else if (valueList.get(i + 2) <= 8 && valueList.get(i + 3) <= 1) {
                        return twoOnX.twoOnEightAndOneOnEight(jsonReader.getTableFromJson(myArr, 9));
                    }

                    else{
                        return null;
                    }
                }
                else if (valueList.get(i) <= 3 && valueList.get(i + 1) <= 6){
                    if (valueList.get(i + 2) <= 6 && valueList.get(i + 3) <= 1) {
                        // 3^6 6^1 [3,6,6,1]
                        return threeOnX.ThreeOnSixAndSixOnOne(jsonReader.getTableFromJson(myArr, 7));
                    }
                    else{
                        return null;
                    }
                } 
                else if (valueList.get(i) <= 3 && valueList.get(i + 1) <= 9){
                    if (valueList.get(i + 2) <= 9 && valueList.get(i + 3) <= 1) {
                        // 3^9 9^1 [3,9,9,1]
                        return threeOnX.ThreeOnNinexAndNineOnOne(jsonReader.getTableFromJson(myArr, 10));
                    }else{
                        return null;
                    }
                } 
                else if (valueList.get(i) <= 4 && valueList.get(i + 1) <= 8){
                    if (valueList.get(i + 2) <= 8 && valueList.get(i + 3) <= 1) {
                        // 4^8 8^1 [3,9,9,1]
                        return fourOnX.FourOnEightAndEightOnOne(jsonReader.getTableFromJson(myArr, 9));
                    }
                    else{
                        return null;
                    }
                }else{
                    return null;
                }
            }
            else if (valueList.size() == 6){
                if (valueList.get(i) <= 2 && valueList.get(i + 1) <= 3){
                    if (valueList.get(i + 2) <= 3 && valueList.get(i + 3) <= 2){
                        if (valueList.get(i + 4) <= 6 && valueList.get(i + 5) <= 3){
                            //[2, 4, 3, 1, 6, 3]
                            return twoOnX.twoOnThreeAndThreeOnTwoAndSixOnThree(jsonReader.getTableFromJson(myArr, 8));
                        }
                        else{
                            return null;
                        }
                    }else{
                        return null;
                    }
                }
                else if (valueList.get(i) <= 2 && valueList.get(i + 1) <= 4){
                    if (valueList.get(i + 2) <= 3 && valueList.get(i + 3) <= 1){
                        if (valueList.get(i + 4) <= 6 && valueList.get(i + 5) <= 3){
                            //[2, 4, 3, 1, 6, 3]
                            return twoOnX.twoOnFourAndThreeOnOneAndSixOnThree(jsonReader.getTableFromJson(myArr, 8));
                        }
                        else{
                            return null;
                        }
                    }else{
                        return null;
                    }
                }
                else{
                    return null;
                }       
            } else if (valueList.size() == 8){
                if (valueList.get(i) <= 2 && valueList.get(i + 1) <= 5){
                    if (valueList.get(i + 2) <= 3 && valueList.get(i + 3) == 3){
                        if (valueList.get(i + 4) <= 4 && valueList.get(i + 5) <= 1){
                            if (valueList.get(i + 6) <= 6 && valueList.get(i + 7) == 7){
                                return twoOnX.twoOnFiveAndThreeOnThreeAndFourOnOneAndSixOnSeven(jsonReader.getTableFromJson(myArr, 16));
                            }else{
                                return null;
                            }
                        }else{
                            return null;
                        }
                    }else{
                        return null;
                    }
                }else{
                    return null;
                }
            }else{
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("=============  End fint OT =======================");
        return null;
    }
}
