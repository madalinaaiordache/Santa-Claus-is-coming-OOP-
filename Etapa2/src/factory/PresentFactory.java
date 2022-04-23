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
                              Double price, final Category category,
                              final int quantity) {

        PresentInput newPresent = null;
        if (category.equals(Category.BOARD_GAMES)) {
            boardGamesPresents.add(new BoardGamesPresent(productName,
                    price, category, quantity));
        } else if (category.equals(Category.BOOKS)) {
            booksPresents.add(new BooksPresent(productName,
                    price, category, quantity));
        } else if (category.equals(Category.CLOTHES)) {
            clothesPresents.add(new ClothesPresent(productName,
                    price, category, quantity));
        } else if (category.equals(Category.SWEETS)) {
            sweetPresents.add(new SweetPresent(productName,
                    price, category, quantity));
        } else if (category.equals(Category.TECHNOLOGY)) {
           technologyPresents.add(new TechnologyPresent(productName,
                   price, category, quantity));
        } else if (category.equals(Category.TOYS)) {
            toyPresents.add(new ToyPresent(productName,
                    price, category, quantity));
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

    /**
     * Returneaza cadoul cel mai ieftin dintr-o anumita categorie
     * @param category
     * @return
     */
    public Present getCheapestPresent(final Category category) {
        if (category.equals(Category.BOARD_GAMES)) {
            return iterateListForPresent(this.boardGamesPresents, false);
        } else if (category.equals(Category.BOOKS)) {
            return iterateListForPresent(this.booksPresents, false);
        } else if (category.equals(Category.CLOTHES)) {
            return iterateListForPresent(this.clothesPresents, false);
        } else if (category.equals(Category.SWEETS)) {
           return iterateListForPresent(this.sweetPresents, false);
        } else if (category.equals(Category.TECHNOLOGY)) {
            return iterateListForPresent(this.technologyPresents, false);
        } else if (category.equals(Category.TOYS)) {
            return iterateListForPresent(this.toyPresents, false);
        }
        return null;
    }

    /**
     * Itereaza lista o lista pentru a gasi primul cadou care nu are cantitatea 0
     */
    public Present iterateListForPresent(final ArrayList<? extends Present> presents,
                                         final boolean zeroQuantityAllowed) {
        if (!zeroQuantityAllowed) {
            int iter = 0;
            while (iter != presents.size()) {
                if (presents.get(iter).getQuantity() != 0) {
                    return presents.get(iter);
                }
                iter++;
            }
            return null;
        } else {
            if (presents.size() != 0) {
                return presents.get(0);
            }
        }
        return null;
    }

    /**
     * Returneaza primul cadou, cel mai ieftin dintr-o anumita categorie
     * @param category
     * @return
     */
    public Present getFirstPresent(final Category category) {
        if (category.equals(Category.BOARD_GAMES)) {
           return  iterateListForPresent(boardGamesPresents, true);
        } else if (category.equals(Category.BOOKS)) {
            return iterateListForPresent(booksPresents, true);
        } else if (category.equals(Category.CLOTHES)) {
            return iterateListForPresent(clothesPresents, true);
        } else if (category.equals(Category.SWEETS)) {
            return iterateListForPresent(sweetPresents, true);
        } else if (category.equals(Category.TECHNOLOGY)) {
            return iterateListForPresent(technologyPresents, true);
        } else if (category.equals(Category.TOYS)) {
            return iterateListForPresent(toyPresents, true);
        }
        return null;
    }


    /**
     * Scade cantitatea unui cadou
     * @param present
     */
    public void decreaseQuantity(final Present present) {
        Category category = present.getCategory();
        String name = present.getProductName();
        if (category.equals(Category.BOARD_GAMES)) {
            searchPresentForDecrease(this.boardGamesPresents, name);
        } else if (category.equals(Category.BOOKS)) {
            searchPresentForDecrease(this.booksPresents, name);
        } else if (category.equals(Category.CLOTHES)) {
            searchPresentForDecrease(this.clothesPresents, name);
        } else if (category.equals(Category.SWEETS)) {
            searchPresentForDecrease(this.sweetPresents, name);
        } else if (category.equals(Category.TECHNOLOGY)) {
            searchPresentForDecrease(this.technologyPresents, name);
        } else if (category.equals(Category.TOYS)) {
            searchPresentForDecrease(this.toyPresents, name);
        }
    }

    /**
     * Parcurge lista de cadouri pentru a scadea cantitatea unui anumit cadou cu 1
     * @param presents
     * @param name
     */
    public void searchPresentForDecrease(final ArrayList<? extends Present> presents,
                                         final String name) {
        int iter = 0;
        while (iter != presents.size()) {
            if (presents.get(iter).getProductName().equals(name)) {
                int oldQuantity = presents.get(iter).getQuantity();
                presents.get(iter).setQuantity(oldQuantity - 1);
            }
            iter++;
        }
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
