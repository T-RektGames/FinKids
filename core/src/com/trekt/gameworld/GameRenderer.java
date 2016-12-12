package com.trekt.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Align;
import com.trekt.helpers.AssetLoader;
import com.trekt.ui.RectangleButton;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * Created by AadityaPatwari on 29/7/16.
 */
public class GameRenderer {

    private GameWorld gameWorld;
    private ArrayList<RectangleButton> bankButtons, mainMapButtons, insuranceOfficeButtons, shopButtons, stockButtons;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;
    private float gameWidth = AssetLoader.gameWidth;
    private float gameHeight = AssetLoader.gameHeight;
    private SpriteBatch batcher;
    private float currentBankBalance, currentUnpaidLoanAmount;
    private boolean transanctionPopUpOpen = false;
    private NumberFormat format1DP, format0DP;
    private String bankHelpString, insuranceHelpString, mainMapHelpString, stockHelpString, shopHelpString;




    public GameRenderer(GameWorld world, int gameHeight) {
        this.gameWorld = world;
        bankButtons = gameWorld.getBank().getBankButtons();
        mainMapButtons = gameWorld.getMainMapButtons();
        insuranceOfficeButtons = gameWorld.getInsuranceOffice().getInsuranceOfficeButtons();
        shopButtons = gameWorld.getShop().getShopButtons();
        stockButtons = gameWorld.getStock().getStockButtons();
        cam = new OrthographicCamera();
        cam.setToOrtho(true, gameWidth, gameHeight);
        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(cam.combined);

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);

        format1DP = new DecimalFormat("#0.0");
        format0DP = new DecimalFormat("#0");

//        bankHelpString = "Instead of keeping all your money in hard cash, you can choose to store your money in a bank. A bank is a trusted institution , often regulated by the government, that stores your money safely for you. One advantage of storing your money in a bank, is that increases over time, based on a interest rate offered by a bank. To store money in the bank, you must first create a account with a bank. For your first time, the simplest account to create will be a savers account, which allows you to retrieve money at immediate notice, but will have a small interest rate. To create an account you need to provide a form of personal verification like a IC or Student pass. Some accounts will also require minimum deposit amount to create. \n" +
//                "\n" +
//                "The interest rate, is the amount your money increases in a fixed time, and is based on your current balance. There are two types of interest, simple and compounded. Simple interest is only based on the amount of money deposited. For example, if you deposit a amount of $50, and the interest is 10% per year, at the end of the year the additional money you gain is $5. Compounded interest, however, also acts on the amount of interest accumulated over time. For example the account has a 10% interest per year, with interest compounded monthly and you deposit $50, Hence at the end of the first month, you will have $50.4. The seconds month’s interest will be based upon, $50.4 instead of $50. Hence at the end of the year you will gain $5.2.\n" +
//                "\n" +
//                "\n" +
//                "However the money you deposit in the bank doesn't just stay put in the bank. How the bank keeps the flow of money going is by lending the money you deposit in the bank to others, in the form of loans. So it is a fact, that if everyone tries to withdraw money at the same time, or if an extremely large group of people are unable to return their loans, the bank might not have enough money for you to withdraw from your own account. That might alarm you, but there are regulations, especially from the government that force banks to have certain amount of cash reserves. At the same time, events where the bank doesn't have enough money are extremely rare, and  if it does happen it is often prevented by the government by injecting the national budget into banks to revive them. This is called a bailout. As such banks are considered a rather safe avenue to save and grow your wealth.\n" +
//                "\n" +
//                "When buying something extremely expensive like a car or a house, it is common to see, people not being able or comfortable enough to pay the entire price for the item. Hence, Banks, provide loans, where they give will give you a sum of money that you can use first to buy the good. However, over time, you are required by law, to pay the banks back, with interest. Hence, in the end you will need to pay a amount greater than the sum you borrowed, to the bank, but since it is spread out over a longer period of time it becomes more manageable. In the case you are not able to pay back the loan, the bank will seize all your assets, such as your house and car.";

    }

    private void drawBoundingShapes() {
        shapeRenderer.setColor(Color.BLUE);
        for (int i = 0; i < bankButtons.size(); i++) {
            if (bankButtons.get(i).isEnabled()) {
                shapeRenderer.rect(bankButtons.get(i).getX(), bankButtons.get(i).getY(), bankButtons.get(i).getWidth(), bankButtons.get(i).getHeight());
            }

        }

        for (int i = 0; i < mainMapButtons.size(); i++) {
            if (mainMapButtons.get(i).isEnabled()) {
                shapeRenderer.rect(mainMapButtons.get(i).getX(), mainMapButtons.get(i).getY(), mainMapButtons.get(i).getWidth(), mainMapButtons.get(i).getHeight());
            }
        }

        for (int i = 0; i < insuranceOfficeButtons.size(); i++) {
            if (insuranceOfficeButtons.get(i).isEnabled()) {
                shapeRenderer.rect(insuranceOfficeButtons.get(i).getX(), insuranceOfficeButtons.get(i).getY(), insuranceOfficeButtons.get(i).getWidth(), insuranceOfficeButtons.get(i).getHeight());
            }
        }

        for (int i = 0; i < shopButtons.size(); i++) {
            if (shopButtons.get(i).isEnabled()) {
                shapeRenderer.rect(shopButtons.get(i).getX(), shopButtons.get(i).getY(), shopButtons.get(i).getWidth(), shopButtons.get(i).getHeight());
            }
        }

        for (int i = 0; i < stockButtons.size(); i++) {
            if (stockButtons.get(i).isEnabled()) {
                shapeRenderer.rect(stockButtons.get(i).getX(), stockButtons.get(i).getY(), stockButtons.get(i).getWidth(), stockButtons.get(i).getHeight());
            }


        }
    }

    private void drawBackHelpButtons(){

        if (gameWorld.getBackButton().isEnabled()) {
            batcher.draw(AssetLoader.backTr, 237, 123,  15, (float) (15*1.27));
        }

        if (gameWorld.getHelpButton().isEnabled()){
            batcher.draw(AssetLoader.helpTr, 2, gameHeight/2-10, 15, 15);
        }
    }

    private void drawMainMap(){
        batcher.draw(AssetLoader.mainMapTr, 0, 0, gameWidth, gameHeight);
        if (gameWorld.getShop().isCarBought()) {
            batcher.draw(AssetLoader.carTr, 50, 65, (float) (25 * 1.783), 25);
        }

        if (!gameWorld.getShop().isHouseBought()) {
            batcher.draw(AssetLoader.lousyHouseTr, 96, 24, 75, 60);
        }   else {
            batcher.draw(AssetLoader.betterHouseTr, 93, 27, (float) (60*1.565), 60);
        }

        if (gameWorld.getShop().isGardenBought()) {
            batcher.draw(AssetLoader.gardenTr, 100, 80, (float) (26 * 2.4), 26);
        }

        if (gameWorld.getShop().isPondBought()) {
            batcher.draw(AssetLoader.pondTr, 170, 60, (float) (26 * 2.67), 26);
        }

        renderInsuranceClaimPopUp();

        //renderMainMapHelp();
    }


    private void drawBank(){
        batcher.draw(AssetLoader.bankTr, 0, 0, gameWidth, gameHeight);
        renderTransactionPopUp();
        renderGetLoanPopUp();

    }

    private void drawInsuranceOffice(){
        batcher.draw(AssetLoader.insuranceOfficeTr, 0, 0, gameWidth, gameHeight);
        renderGetHouseInsurancePopUp();
        renderGetCarInsurancePopUp();
    }

    private void drawShop(){
        batcher.draw(AssetLoader.shopTr, 0, 0, gameWidth, gameHeight);
        renderGetCarBuyPopUp();
        renderGetHouseBuyPopUp();
        renderGetGardenBuyPopUp();
        renderGetPondBuyPopUp();
    }


    private void drawStock()
    {
        batcher.draw(AssetLoader.stockTr, 0, 0, gameWidth, gameHeight);
        renderStockMarketPopUp();
    }
    private void drawHelp(){
//        renderMainMapHelp();
//        renderBankHelp();


        if (gameWorld.getHelpButtonDone().isEnabled()){

            Gdx.gl.glClearColor(0, 0, 0, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            batcher.draw(AssetLoader.shopDonePopupTr, 0, 0, gameWidth, gameHeight);

            if (gameWorld.getGameSubMode() == 0) {

                AssetLoader.OCRASmall.draw(batcher," This game is meant to simulate the real-life financial decisions one is confronted with, as he/she becomes older. There are 4 main buildings in this game, and each building is meant to convey an important financial concepts, to improve financial literacy among children aged 12 and above. The bank aims to teach basic concepts of interest and credit in the form of savings accounts and loans. The stock exchange aims to point out the existence of more riskier forms of investment, and how the stock exchange works. The Insurance Company aims to teach them the basics of how insurance works, as well as the importance of risk management. Lastly the shop, is meant to teach them about financial planning, and the importance of assets. The game ends when the person becomes bankrupt or homeless.\n" +
                        "\n" +
                        "You will have a weekly allowance of $3, and the money on your hand is constantly shown on the top right hand corner. " , 8, 5, (int) gameWidth-10, Align.left, true);
            }

            else if (gameWorld.getGameSubMode() == 1) {

                AssetLoader.OCRASmall.draw(batcher,"Instead of keeping all your money in hard cash, you can choose to store your money in a bank. A bank is a trusted institution , often regulated by the government, that stores your money safely for you. One advantage of storing your money in a bank, is that increases over time, based on a interest rate offered by a bank. To create an account you need to provide a form of personal verification like a IC or Student pass. Some accounts will also require minimum deposit amount to create. \n" +
                        "\n" +
                        "The interest rate, is the amount your money increases in a fixed time, and is based on your current balance. There are two types of interest, simple and compounded. Simple interest is only based on the amount of money deposited. For example, if you deposit a amount of $50, and the interest is 10% per year, at the end of the year the additional money you gain is $5. Compounded interest, however, also acts on the amount of interest accumulated over time. For example the account has a 10% interest per year, with interest compounded yearly and you deposit $50, Hence at the end of the first year, you will have $55.0, and at the end of the second year you will gain $60.5.\n"
                         , 8, 5, (int) gameWidth-10, Align.left, true);
            }

            else if (gameWorld.getGameSubMode() ==2) {

                AssetLoader.OCRASmall.draw(batcher,
                        "You can either choose to withdraw or deposit money into your bank account from your hand. Based on the amount you deposit, money stored in the bank will increase over time based on the interest rate. The interest rate is : 2% weekly compounded \n" +
                        "\n" +
                        "When buying something extremely expensive like a car or a house, it is common to see, people not being able or comfortable enough to pay the entire price for the item. Hence, the bank can provide provide loans, where they give will give you a sum of money that you can use first to buy the good. However, over time, you are required by law, to pay the banks back, with interest. Hence, in the end you will need to pay a amount greater than the sum you borrowed, to the bank, but since it is spread out over a longer period of time it becomes more manageable. In the case you are not able to pay back the loan, the bank will seize all your assets, such as your house and car. The loan interest rate is : 5% weekly compounded\n"
                         , 8, 5, (int) gameWidth - 10, Align.left, true);
            }

            else if (gameWorld.getGameSubMode() == 3) {

                AssetLoader.OCRASmall.draw(batcher,"In life there are always unpredictable events that we cannot prepare for, and some events come at great cost to yourself, or your most valued possessions. For example, an accident on the road can leave your car completely wrecked or worse, cause lasting injuries to you, A natural disaster could potentially destroy your home, leaving you homeless. In order to manage such risk, there is a financial products called insurance, that can help reduce the cost incurred by you during such accidents.Insurance companies sell you various insurances, from car insurance to house insurance that last for a certain period. Lets take the example of a car insurance to to illustrate how they work. Upon buying a car insurance that perhaps lasts for 20 years, you can be reassured that in the event that your car gets damaged during that time period, the company will give you money to cover your losses. But in return, until you car has not damaged, you will have to pay monthly fees to the company, called premiums. In the event that your car does not get damaged in the twenty years, you will get no money back and all the methyl premiums you paid will be gone." , 8, 5, (int) gameWidth - 10, Align.left, true);
            }

            else if (gameWorld.getGameSubMode() == 4) {

                AssetLoader.OCRASmall.draw(batcher,"These insurances have no upfront costs, but they do have a monthly premium you need to pay. This premium will automatically be deducted from your bank account and cannot be paid from your hand. So remember to put in sufficient money in your bank account, or your insurance will be revoked." , 8, 5, (int) gameWidth-10, Align.left, true);
            }

            else if (gameWorld.getGameSubMode() == 5) {

                AssetLoader.OCRASmall.draw(batcher,"There are two types of firms, namely private and public firms. Private firms are mostly owned by a small group of stakeholders, and ownership of the company is not open to the public. Stakeholders are essentially anyone who owns a certain percentage of the company. However a private company can go public, by offering shares(small percentage ownership of the company) to the public. The stock exchange is basically where the buying and selling of these shares occurs, by match willing sellers and buyers. The control of the company is retained by the group or person with the majority of shares.\n"
                        , 8, 5, (int) gameWidth-10, Align.left, true);
            }

            else if (gameWorld.getGameSubMode() == 6) {

                AssetLoader.OCRASmall.draw(batcher,"Stocks are a common avenue for investment(buying something now to sell at a profit later.However, compared to banks, they are volatile which means there are very large fluctuations in price. As such while you can make a lot of profit very quickly, you can also lose a lot of money very fast. As such it is not recommended for first-time investors to take part in the stock market, as seeing the trends requires some amount of knowledge and experience. \n" +
                        "\n" +
                        "Hence here you can choose to put money inside the stock market, and over time the money inside might decrease or increase. Choose wisely, as you have no control over profit or loss." , 8, 5, (int) gameWidth-10, Align.left, true);
            }

            else if (gameWorld.getGameSubMode() == 7) {

                AssetLoader.OCRASmall.draw(batcher,"People often want to earn money, so that they can buy better quality goods, and live a better life. However apart from that, buying better quality goods can also serve as an investment. an investment is anything you buy in the present, that can potentially lead to profits in the future." , 8, 5, (int) gameWidth-10, Align.left, true);
            }

            else if (gameWorld.getGameSubMode() == 8) {

                AssetLoader.OCRASmall.draw(batcher, "Live the high life, with your brand new sports car. But remember, theres always a chance it may be destroyed in an accident. If you are in need of money you can always sell you car, but the sell price will be lesser than the price you bought the car at.", 8, 5, (int) gameWidth-10, Align.left, true);
            }

            else if (gameWorld.getGameSubMode() == 9) {

                AssetLoader.OCRASmall.draw(batcher,"Enjoy a lavish lifestyle with the modern mansion. But the frequency of natural disasters is increasing! You can sell your house, but the value of your house will go down with time so the sell price will be lesser than the price you bought the house at." , 8, 5, (int) gameWidth-10, Align.left, true);
            }

            else if (gameWorld.getGameSubMode() == 10) {

                AssetLoader.OCRASmall.draw(batcher,"Buying the garden allows you to sell flowers, and buying the pond allows you to sell fish.\n" +
                        "\n" +
                        "Apart from your allowance, the garden and pond can act as another source of your income. Hence allowing you to get money faster, apart from being able to get a larger loan. \n" +
                        "\n"
                        , 8, 5, (int) gameWidth-10, Align.left, true);
            }





        }

    }

    private void drawMoneyOnHand(){
        AssetLoader.OCRAMedium.draw(batcher, format1DP.format(gameWorld.getMoneyOnHand()), gameWidth - 35, 17);
    }

    public void render(float runTime){
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batcher.begin();

        if (gameWorld.isMainMap()){
            drawMainMap();
            drawMoneyOnHand();
            //drawBackHelpButtons();
        }

        else if (gameWorld.isBank()) {

            Gdx.gl.glClearColor(255, 255, 255, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            drawBank();
            drawMoneyOnHand();

        }

        else if (gameWorld.isStock()){
            drawStock();
            drawMoneyOnHand();
        }

        else if (gameWorld.isInsurance()){
            drawInsuranceOffice();
            drawMoneyOnHand();
        }

        else if (gameWorld.isShop()){
            drawShop();
            drawMoneyOnHand();
        }

        else if (gameWorld.isHelp()){
            drawHelp();
        }

        drawHelp();
        drawBackHelpButtons();
        batcher.end();

    }

    public void renderTransactionPopUp(){
        if (gameWorld.getBank().getTransactionDoneButton().isEnabled()) {
            batcher.draw(AssetLoader.popupTr, 4, 34, 70, 88);
            currentBankBalance = gameWorld.getBank().getTotalBalance();
            AssetLoader.OCRAMedium.setColor(Color.BLACK);
            AssetLoader.OCRASmall.setColor(Color.BLACK);
            AssetLoader.OCRAMedium.draw(batcher, "$" + format1DP.format(currentBankBalance), 25, 55);
            AssetLoader.OCRASmall.draw(batcher, "DEFAULT AMT", 15, 45);
        }
    }

    public void renderGetLoanPopUp(){
        if (gameWorld.getBank().getLoanDoneButton().isEnabled()){
            batcher.draw(AssetLoader.popupTr, gameWidth - 75, 36, 70, 88);
            currentUnpaidLoanAmount = gameWorld.getBank().getUnpaidLoanAmount();
            AssetLoader.OCRAMedium.draw(batcher, "$"+format1DP.format(currentUnpaidLoanAmount), gameWidth - 50, 57);
            AssetLoader.OCRASmall.draw(batcher, "DEFAULT AMT", gameWidth - 60, 47);
        }
    }

    public void renderGetHouseInsurancePopUp(){
        if (gameWorld.getInsuranceOffice().getHouseInsuranceDoneButton().isEnabled()) {


            if (gameWorld.getInsuranceOffice().isHouseInsuranceBought() == true) {
                batcher.draw(AssetLoader.insurancePopupRevokeTr, 4, 34, 70, 75);
                AssetLoader.OCRABig.draw(batcher, "BOUGHT", 13, 50);
            }

            else {
                batcher.draw(AssetLoader.insurancePopupTr, 4, 34, 70, 75);
                AssetLoader.OCRABig.draw(batcher, "$" + format1DP.format(gameWorld.getInsuranceOffice().getWeeklyHousePremium()) + "/w", 9, 50);
            }
        }
    }

    public void renderGetCarInsurancePopUp(){
        if (gameWorld.getInsuranceOffice().getCarInsuranceDoneButton().isEnabled()) {


            if (gameWorld.getInsuranceOffice().isCarInsuranceBought() == true) {
                batcher.draw(AssetLoader.insurancePopupRevokeTr, gameWidth-75, 34, 70, 75);
                AssetLoader.OCRABig.draw(batcher, "BOUGHT", gameWidth-65, 50);
            }

            else {
                batcher.draw(AssetLoader.insurancePopupTr, gameWidth-75, 34, 70, 75);
                AssetLoader.OCRABig.draw(batcher, "$" + format1DP.format(gameWorld.getInsuranceOffice().getWeeklyCarPremium()) + "/w", gameWidth-65, 50);
            }
        }
    }

    public void renderGetCarBuyPopUp(){
        if (gameWorld.getShop().getDoneCar().isEnabled()){
            if (gameWorld.getShop().isCarBought()) {
                batcher.draw(AssetLoader.shopSellPopupTr, 50, 5, 150, 75);
            }   else {
                batcher.draw(AssetLoader.shopSinglePopupTr, 50, 5, 150, 75);
                AssetLoader.OCRABig.draw(batcher, "$" + format1DP.format(gameWorld.getShop().getCostOfCar()), 150, 20);
            }

            batcher.draw(AssetLoader.carTr, 60, 18, (float) (50*1.78), 50);
        }
    }

    public void renderGetHouseBuyPopUp(){
        if (gameWorld.getShop().getDoneHouse().isEnabled()){

            if (gameWorld.getShop().isHouseBought()) {
                batcher.draw(AssetLoader.shopSellPopupTr, 50, 5, 150, 75);
            } else {
                batcher.draw(AssetLoader.shopSinglePopupTr, 50, 5, 150, 75);
                AssetLoader.OCRABig.draw(batcher, "$" + format1DP.format(gameWorld.getShop().getCostOfHouse()), 143, 20);
            }

            batcher.draw(AssetLoader.betterHouseTr, 65, 18, (float) (50*1.56), 50);
        }
    }

    public void renderGetGardenBuyPopUp(){
        if (gameWorld.getShop().getDoneGarden().isEnabled()){
            if (gameWorld.getShop().isGardenBought()) {
                batcher.draw(AssetLoader.shopDonePopupTr, 150, 25, 100, 50);
            }   else {
                batcher.draw(AssetLoader.shopSinglePopupTr, 150, 25, 100, 50);
                AssetLoader.OCRAMedium.draw(batcher, "$" + format1DP.format(gameWorld.getShop().getCostOfGarden()), 210, 35);
                //AssetLoader.OCRABig.
            }

            batcher.draw(AssetLoader.gardenTr, 155, 35, (float) (30*1.70), 30);
        }
    }

    public void renderGetPondBuyPopUp(){
        if (gameWorld.getShop().getDonePond().isEnabled()){

            if (gameWorld.getShop().isPondBought()) {
                batcher.draw(AssetLoader.shopDonePopupTr, 6, 25, 100, 50);
            }   else {
                batcher.draw(AssetLoader.shopSinglePopupTr, 6, 25, 100, 50);
                AssetLoader.OCRAMedium.draw(batcher, "$" + format1DP.format(gameWorld.getShop().getCostofPond()), 65, 35);
            }

            batcher.draw(AssetLoader.pondTr, 10, 40, (float) (18*2.67), 18);


        }
    }

    public void renderStockMarketPopUp(){
        if (gameWorld.getStock().getStockDoneButton().isEnabled()){
            batcher.draw(AssetLoader.popupTr, 96, 50, 70, 88);
            AssetLoader.OCRABig.draw(batcher, "$"+format1DP.format(gameWorld.getStock().getMoneyInvestedInStock()), 110, 68);
        }


    }

    public void renderInsuranceClaimPopUp() {
        if (gameWorld.getInsuranceOffice().getInsuranceClaimDoneButton().isEnabled()) {
            batcher.draw(AssetLoader.shopDonePopupTr, 50, 5, 150, 75);
            if (gameWorld.getInsuranceOffice().getIsCarOrHouseDestroyed() == 1) {
                AssetLoader.OCRASmall.draw(batcher, "Due to a natural disaster, your house got destroyed! If you are insured, you will get the money you lost", 54, 29, 142, Align.center, true);
                //AssetLoader.OCRASmall.draw(batcher, "If you are insured, you will get the money you lost", 50, 60);

            } else if (gameWorld.getInsuranceOffice().getIsCarOrHouseDestroyed() == 2) {
                AssetLoader.OCRASmall.draw(batcher, "Due to a crash, your car got destroyed! If you are insured, you will get the money you lost", 54, 29, 142, Align.center, true);
                //AssetLoader.OCRASmall.draw(batcher, "If you are insured, you will get the money you lost", 50, 60);
            }

        }
    }

//    public void renderMainMapHelp(){
//        if (gameWorld.getHelpButtonDone().isEnabled()){
//            batcher.draw(AssetLoader.shopDonePopupTr, 0, 0, gameWidth, gameHeight);
//            AssetLoader.OCRAMedium.draw(batcher, "i am a beast auf4bwifubalwi4ubfalwi4ubfliw4ubfliw4ufliwu4bfiwu4bfliu4bfl4ubfl4ubfl4ubf", 0, 0, (int) gameWidth, Align.center,  true);
//            //AssetLoader.OCRASmall.draw()
//            //AssetLoader.OCRABig.dr
//        }
//    }
//
//    public void renderBankHelp(){
//
//    }






    public boolean isTransanctionPopUpOpen() {
        return transanctionPopUpOpen;
    }

    public void setTransanctionPopUpOpen(boolean transanctionPopUpOpen) {
        this.transanctionPopUpOpen = transanctionPopUpOpen;
    }
}
