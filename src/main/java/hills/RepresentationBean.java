package hills;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class RepresentationBean {

    private String hillsInput;
    private String result;

    @Inject
    private CalculationService calculationService;

    public void proceedCalculation() {
        final List<Integer> list = new ArrayList<>();
        try {
            final String[] split = hillsInput.split(",");
            for (String s : split) {
                list.add(Integer.parseInt(s.trim()));
            }
        } catch (IllegalArgumentException e) {
            // logging error here
            result = "Errors while calculating results. Check input parameters!";
            return;
        }
        
        result = String.valueOf(calculationService.calculate(list));
    }

    public String getHillsInput() {
        return hillsInput;
    }

    public void setHillsInput(String hillsInput) {
        this.hillsInput = hillsInput;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}