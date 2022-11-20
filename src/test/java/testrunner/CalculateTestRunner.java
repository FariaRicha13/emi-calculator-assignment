package testrunner;

import dataset.Dataset;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import screens.EmiCalcPage;
import setup.Setup;

import java.util.concurrent.TimeUnit;

public class CalculateTestRunner extends Setup {
    EmiCalcPage calcPage;
    public static int ln;

    @BeforeTest
    public void startEMICalculator() {
        calcPage = new EmiCalcPage(driver);
        calcPage.btnStart.click();

    }

    @Test(dataProvider = "data-provider", dataProviderClass = Dataset.class)
    public void doCalculateEMI(int loanAmount, double rInterest, int period, double pFee, int mEMI, int tInterest, int tpFee, int tPayment) throws InterruptedException {
        calcPage = new EmiCalcPage(driver);

        calcPage.calculateEMI(loanAmount, rInterest, period, pFee);

        String monthlyEMI = calcPage.txtMonthlyElement.getText();
        String totalInterest = calcPage.txtTotalInterest.getText();
        String totalProcessingFee = calcPage.txtProcessingFee.getText();
        String totalPayment = calcPage.txtTotalPayment.getText();

        monthlyEMI = String.valueOf((int) Math.round(Double.parseDouble(monthlyEMI.replace(",", ""))));
        totalInterest = String.valueOf((int) Math.round(Double.parseDouble(totalInterest.replace(",", ""))));
        totalProcessingFee = String.valueOf((int) Math.round(Double.parseDouble(totalProcessingFee.replace(",", ""))));
        totalPayment = String.valueOf((int) Math.round(Double.parseDouble(totalPayment.replace(",", ""))));

        Assert.assertEquals(monthlyEMI, String.valueOf(mEMI));
        Assert.assertEquals(totalInterest, String.valueOf(tInterest));
        Assert.assertEquals(totalProcessingFee, String.valueOf(tpFee));
        Assert.assertEquals(totalPayment, String.valueOf(tPayment));
        Thread.sleep(1000);
        calcPage.btnReset.click();
        Thread.sleep(1000);

    }


}
