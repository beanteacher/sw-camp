package com.ohgiraffers.section02.subsection02.qualifier;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext ap = new AnnotationConfigApplicationContext("com.ohgiraffers.section02");
        PokemonService pokemonService =  ap.getBean(PokemonService.class);
        pokemonService.pokemonAttack();

    }
\}
