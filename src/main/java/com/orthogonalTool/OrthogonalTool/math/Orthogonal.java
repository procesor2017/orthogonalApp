package com.orthogonalTool.OrthogonalTool.math;
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




}
