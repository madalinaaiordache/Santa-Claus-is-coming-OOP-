package factory;

import common.PresentSorter;
import enums.Category;
import objects.PresentInput;

import java.util.ArrayList;
import java.util.Collections;

public final class PresentFactory {

    private static PresentFactory instance = null;

    /**
     * Singleton
     * @return
     */
    public static PresentFactory getInstance() {
        if (instance == null) {
            instance = new PresentFactory();
        }
        return instance;
    }

    private ArrayList<BoardGamesPresent> boardGamesPresents = new ArrayList<>();
    private ArrayList<BooksPresent> booksPresents = new ArrayList<>();
    private ArrayList<ClothesPresent> clothesPresents = new ArrayList<>();
    private ArrayList<SweetPresent> sweetPresents = new ArrayList<>();
    private ArrayList<TechnologyPresent> technologyPresents = new ArrayList<>();
    private ArrayList<ToyPresent> toyPresents = new ArrayList<>();

    /**
     * Functie care adauga un cadou in array ul corespunzator
     * @param productName
     * @param price
     * @param category
     */
    public void insertPresent(final String productName, final
                              Double price, final Category category) {

        PresentInput newPresent = null;
        if (category.equals(Category.BOARD_GAMES)) {
            boardGamesPresents.add(new BoardGamesPresent(productName,
                    price, category));
        } else if (category.equals(Category.BOOKS)) {
            booksPresents.add(new BooksPresent(productName,
                    price, category));
        } else if (category.equals(Category.CLOTHES)) {
            clothesPresents.add(new ClothesPresent(productName,
                    price, category));
        } else if (category.equals(Category.SWEETS)) {
            sweetPresents.add(new SweetPresent(productName,
                    price, category));
        } else if (category.equals(Category.TECHNOLOGY)) {
           technologyPresents.add(new TechnologyPresent(productName,
                   price, category));
        } else if (category.equals(Category.TOYS)) {
            toyPresents.add(new ToyPresent(productName,
                    price, category));
        }
    }
    /**
     * Curata pentru testul urmator
     */
    public void clean() {
        this.boardGamesPresents = new ArrayList<>();
        this.booksPresents = new ArrayList<>();
        this.clothesPresents = new ArrayList<>();
        this.sweetPresents = new ArrayList<>();
        this.technologyPresents = new ArrayList<>();
        this.toyPresents = new ArrayList<>();
    }

    /**
     * Functie pentru sortarea listelor in functie de pret, de la cel mai mic
     */
    public void sortPresents() {
        Collections.sort(this.boardGamesPresents, new PresentSorter());
        Collections.sort(this.booksPresents, new PresentSorter());
        Collections.sort(this.clothesPresents, new PresentSorter());
        Collections.sort(this.sweetPresents, new PresentSorter());
        Collections.sort(this.technologyPresents, new PresentSorter());
        Collections.sort(this.toyPresents, new PresentSorter());
    }

    public static void setInstance(final PresentFactory instance) {
        PresentFactory.instance = instance;
    }

    public ArrayList<BoardGamesPresent> getBoardGamesPresents() {
        return boardGamesPresents;
    }

    public void setBoardGamesPresents(final ArrayList<BoardGamesPresent> boardGamesPresents) {
        this.boardGamesPresents = boardGamesPresents;
    }

    public ArrayList<BooksPresent> getBooksPresents() {
        return booksPresents;
    }

    public void setBooksPresents(final ArrayList<BooksPresent> booksPresents) {
        this.booksPresents = booksPresents;
    }

    public ArrayList<ClothesPresent> getClothesPresents() {
        return clothesPresents;
    }

    public void setClothesPresents(final ArrayList<ClothesPresent> clothesPresents) {
        this.clothesPresents = clothesPresents;
    }

    public ArrayList<SweetPresent> getSweetPresents() {
        return sweetPresents;
    }

    public void setSweetPresents(final ArrayList<SweetPresent> sweetPresents) {
        this.sweetPresents = sweetPresents;
    }

    public ArrayList<TechnologyPresent> getTechnologyPresents() {
        return technologyPresents;
    }

    public void setTechnologyPresents(final ArrayList<TechnologyPresent> technologyPresents) {
        this.technologyPresents = technologyPresents;
    }

    public ArrayList<ToyPresent> getToyPresents() {
        return toyPresents;
    }

    public void setToyPresents(final ArrayList<ToyPresent> toyPresents) {
        this.toyPresents = toyPresents;
    }
}
