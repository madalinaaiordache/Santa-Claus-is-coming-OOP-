package main;

import checker.Checker;
import factory.PresentFactory;
import flow.FlowInfo;
import flow.InputFilesParserWriter;
import flow.ProjectFlow;
import objects.Input;
import objects.Output;
import objects.PresentInput;

import java.io.IOException;

import static common.Constants.FILES_NUMBER;

/**
 * Class used to run the code
 */
public final class Main {

    private Main() {
        ///constructor for checkstyle
    }
    /**
     * This method is used to call the checker which calculates the score
     * @param args
     *          the arguments used to call the main method
     */
    public static void main(final String[] args) throws IOException {

        InputFilesParserWriter ifp = new InputFilesParserWriter();
        PresentFactory presentFactory = PresentFactory.getInstance();

        // se citeste input-ul din fiecare fisier de test
        for (int i = 1; i <= FILES_NUMBER; i++) {
            Input input = ifp.parser(i);

            // se populeaza array-urile din factory cu fiecare tip de cadou corespunzator
            for (int j = 0; j < input.getInitialData().getSantaGiftsList().
                    size(); j++) {
                PresentInput toAdd = input.getInitialData().getSantaGiftsList().get(j);
                presentFactory.insertPresent(toAdd.getProductName(),
                        toAdd.getPrice(), toAdd.getCategory());
            }

            // se mute input-ul intr-o alta variabila
            FlowInfo flowInfo = new FlowInfo(input, presentFactory);
            ProjectFlow projectFlow = new ProjectFlow(flowInfo);
            // se ruleaza flow-ul pe toti anii corespunzatori
            Output result = projectFlow.runAllYears();

            // se scrie rezultatul in fisierul corespunzator
            ifp.writer(i, result);
            presentFactory.clean();
        }
        Checker.calculateScore();
    }
}
