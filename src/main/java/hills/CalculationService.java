package hills;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

@Stateless
public class CalculationService {

    public int calculate(List<Integer> input) {
        int result = doCalculation(input);
        Collections.reverse(input);
        result += doCalculation(input);
        return result;
    }

    private static int doCalculation(List<Integer> input) {
        List<Integer> copy = new ArrayList<>(input);
        int result = 0;
        for (ListIterator<Integer> iterator = input.listIterator(); iterator.hasNext(); ) {
            final int firstHill = iterator.next();
            int tempResult = 0;
            int lowerHillsSize = 0;
            while (iterator.hasNext()) {
                final int nextHill = iterator.next();
                if (nextHill >= firstHill) {
                    iterator.previous();
                    result += tempResult;
                    copy = copy.subList(lowerHillsSize + 1, copy.size());
                    break;
                } else {
                    tempResult += firstHill - nextHill;
                    lowerHillsSize++;
                }
            }
        }
        input.clear();
        input.addAll(copy);
        return result;
    }
}