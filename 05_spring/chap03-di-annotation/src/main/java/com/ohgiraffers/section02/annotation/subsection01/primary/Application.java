package com.ohgiraffers.section02.annotation.subsection01.primary;

import com.ohgiraffers.section02.common.Pokemon;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext ap = new AnnotationConfigApplicationContext("com.ohgiraffers.section02");
        PokemonService pokemonService =  ap.getBean(PokemonService.class);
        pokemonService.pokemonAttack();

    }
}
