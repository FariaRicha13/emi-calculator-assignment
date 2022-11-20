package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.aspectj.weaver.ast.And;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static setup.Setup.PACKAGE_NAME;

public class EmiCalcPage {
    @FindBy(id = PACKAGE_NAME + ":id/btnStart")
    public AndroidElement btnStart;
    @FindBy(id = PACKAGE_NAME + ":id/etLoanAmount")
    AndroidElement txtLoanAmount;
    @FindBy(id = PACKAGE_NAME + ":id/etInterest")
    AndroidElement txtInterest;
    @FindBy(id = PACKAGE_NAME + ":id/etYears")
    AndroidElement txtPeriod;
    @FindBy(id = PACKAGE_NAME + ":id/etEMI")
    AndroidElement txtEMIAmount;
    @FindBy(id = PACKAGE_NAME + ":id/etFee")
    AndroidElement txtPFee;
    @FindBy(id = PACKAGE_NAME + ":id/btnCalculate")
    AndroidElement btnCalculate;

    @FindBy(id = PACKAGE_NAME + ":id/monthly_emi_result")
    public AndroidElement txtMonthlyElement;
    @FindBy(id = PACKAGE_NAME + ":id/total_interest_result")
    public AndroidElement txtTotalInterest;
    @FindBy(id = PACKAGE_NAME + ":id/processing_fee_result")
    public AndroidElement txtProcessingFee;
    @FindBy(id = PACKAGE_NAME + ":id/total_payment_result")
    public AndroidElement txtTotalPayment;
    @FindBy(id = PACKAGE_NAME + ":id/btnReset")
    public AndroidElement btnReset;

    public EmiCalcPage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void calculateEMI(int loanAmount, double interest, int period, double processing_fee) {
        txtLoanAmount.sendKeys(""+loanAmount+"");
        txtInterest.sendKeys(""+interest+"");
        txtPeriod.sendKeys(""+period+"");
        txtPFee.sendKeys(""+processing_fee+"");
        btnCalculate.click();
    }
}
