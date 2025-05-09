package es.ies.puerto.file.dos;

import java.util.List;
import java.util.Objects;

public class Pokedex {
    List<Pokemon> pokemons;

    public Pokedex() {
    }

    public Pokedex(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public Pokedex pokemons(List<Pokemon> pokemons) {
        setPokemons(pokemons);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pokedex)) {
            return false;
        }
        Pokedex pokedex = (Pokedex) o;
        return Objects.equals(pokemons, pokedex.pokemons);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return " pokemons='" + getPokemons();
    }
}
