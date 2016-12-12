package com.trekt.gameworld;

import com.badlogic.gdx.Game;
import com.trekt.finkids.FinGame;
import com.trekt.gameobjects.Bank;
import com.trekt.gameobjects.InsuranceOffice;
import com.trekt.gameobjects.Shop;
import com.trekt.gameobjects.Stock;
import com.trekt.helpers.AssetLoader;
import com.trekt.ui.RectangleButton;

import java.util.ArrayList;

/**
 * Created by AadityaPatwari on 29/7/16.
 */
public class GameWorld {

    private float gameWidth = AssetLoader.gameWidth;
    private float gameHeight = AssetLoader.gameHeight;
    private GameState currentState;
    private Bank bank;
    private Shop shop;
    private Stock stock;
    private InsuranceOffice insuranceOffice;
    private float moneyOnHand;
    private RectangleButton bankButton, insuranceButton, backButton, shopButton, helpButton, stockButton, helpButtonDone;
    private ArrayList<RectangleButton> mainMapButtons;
    private FinGame game;
    private float currentAllowance;
    private float timeElapsed;
    private int day, week, month, year;
    private int gameSubMode = 0;

    /*
    Sub Modes:
    0 - main map
    1 - bank general
    2 - bank loans/transaction
    3 - insurance general
    4 - car / house insurance
    5 - stock general
    6 - stock computer
    7 - shop general
    8 - car shop
    9 - house shop
    10 - misc

     */


    public GameWorld(FinGame game) {
        this.game = game;
        currentState = GameState.MAINMAP;
        moneyOnHand = AssetLoader.prefs.getFloat("moneyInHand");
        bank = new Bank(this);
        shop = new Shop(this);
        stock = new Stock(this);
        insuranceOffice = new InsuranceOffice(this);
        mainMapButtons = new ArrayList<RectangleButton>();
        bankButton = new RectangleButton(6, 7, 70, 45);
        backButton = new RectangleButton(237, 123, 15, (float) (15 * 1.27));
        insuranceButton = new RectangleButton(6, gameHeight - 55, 80, 52);
        shopButton = new RectangleButton(gameWidth - 80, gameHeight - 65, 73, 65);
        helpButton = new RectangleButton(2, gameHeight / 2 - 10, 15, 15);
        stockButton = new RectangleButton(180, 5, 50, 45);
        helpButtonDone = new RectangleButton(gameWidth - 72, gameHeight - 35, 42, 15);
        mainMapButtons.add(stockButton);
        mainMapButtons.add(bankButton);
        mainMapButtons.add(backButton);
        mainMapButtons.add(insuranceButton);
        mainMapButtons.add(shopButton);
        mainMapButtons.add(helpButton);
        mainMapButtons.add(helpButtonDone);
        currentAllowance = 3;
        day = AssetLoader.prefs.getInteger("day");
        week = AssetLoader.prefs.getInteger("week");
        //AssetLoader.prefs.clear();


    }

    public enum GameState {

        MAINMAP, BANK, INSURANCE, STOCK, SHOP, HELP

    }

    public void update(float delta) {


        timeElapsed += delta;

        switch (currentState) {

            default:
                updateMainMap(delta);
                break;

            case MAINMAP:
                updateMainMap(delta);
                break;

            case BANK:
                updateBank(delta);

                break;

            case INSURANCE:
                updateInsurance(delta);
                break;

            case STOCK:
                updateStock(delta);
                break;

            case SHOP:
                updateShop(delta);
                break;
            case HELP:
                updateHelp(delta);
        }

        if (timeElapsed >= 6) {
            day += 1;
            timeElapsed = 0;
        }

        if (day > 6) {
            week += 1;
            day = 0;

            bank.chargeInterest();
            insuranceOffice.chargePremiums();
            addAllowance();
            shop.getIncome();
            stock.getMarketResults();
            insuranceOffice.causeDestruction();

            AssetLoader.prefs.putFloat("moneyInHand", getMoneyOnHand());
            // }

            //if (!prefs.contains("totalBankBalance")) {
            AssetLoader.prefs.putFloat("totalBankBalance", getBank().getTotalBalance());
            // }

            // if (!prefs.contains("unpaidLoanAmount")) {
            AssetLoader.prefs.putFloat("unpaidLoanAmount", getBank().getUnpaidLoanAmount());

//            }

            //          if (!prefs.contains("moneyInvestedInStock")) {
            AssetLoader.prefs.putFloat("moneyInvestedInStock", getStock().getMoneyInvestedInStock());
            //        }

            //      if (!prefs.contains("day")) {
            AssetLoader.prefs.putInteger("day", getDay());
            //    }

            //  if (!prefs.contains("week")) {
            AssetLoader.prefs.putInteger("week", getWeek());
            //}


//            if (!prefs.contains("carBought")) {
            AssetLoader.prefs.putBoolean("carBought", getShop().isCarBought());
            //          }

            //        if (!prefs.contains("houseBought")) {
            AssetLoader.prefs.putBoolean("houseBought", getShop().isHouseBought());
            //      }

            //    if (!prefs.contains("gardenBought")) {
            AssetLoader.prefs.putBoolean("gardenBought", getShop().isGardenBought());
            //  }

            //if (!prefs.contains("pondBought")) {
            AssetLoader.prefs.putBoolean("pondBought", getShop().isPondBought());
            //}

            //if (!prefs.contains("houseInsured")) {
            AssetLoader.prefs.putBoolean("houseInsured", getInsuranceOffice().isHouseInsuranceBought());
            //}

            //if (!prefs.contains("carInsured")) {
            AssetLoader.prefs.putBoolean("carInsured", getInsuranceOffice().isCarInsuranceBought());

            AssetLoader.prefs.flush();
        }


    }

    private void updateMainMap(float delta) {

        if (helpButtonDone.isEnabled() == false) {
            if (bankButton.isEnabled() == false) {
                bankButton.setEnabled(true);
            }

            if (insuranceButton.isEnabled() == false) {
                insuranceButton.setEnabled(true);
            }

            if (backButton.isEnabled() == true) {
                backButton.setEnabled(false);
            }

            if (shopButton.isEnabled() == false) {
                shopButton.setEnabled(true);
            }

            if (helpButton.isEnabled() == false) {
                helpButton.setEnabled(true);
            }
            if (stockButton.isEnabled() == false) {
                stockButton.setEnabled(true);
            }
        }


    }

    private void updateBank(float delta) {
        bank.update();
        if (backButton.isEnabled() == false && (bank.getTransactionDoneButton().isEnabled() == false && bank.getLoanDoneButton().isEnabled() == false && getHelpButtonDone().isEnabled() == false)) {
            backButton.setEnabled(true);
        }
    }


    private void updateInsurance(float delta) {
        if (backButton.isEnabled() == false && insuranceOffice.getHouseInsuranceDoneButton().isEnabled() == false && insuranceOffice.getCarInsuranceDoneButton().isEnabled() == false && getHelpButtonDone().isEnabled() == false) {
            backButton.setEnabled(true);
        }
        insuranceOffice.update();


    }


    private void updateShop(float delta) {
        if (backButton.isEnabled() == false && shop.getBuyCar().isEnabled() == false && shop.getBuyGarden().isEnabled() == false
                && shop.getBuyPond().isEnabled() == false && shop.getBuyHouse().isEnabled() == false && getHelpButtonDone().isEnabled() == false) {
            backButton.setEnabled(true);
        }

    }

    private void updateStock(float delta) {
        if (backButton.isEnabled() == false && (stock.getStockComputerButton().isEnabled() == true && getHelpButtonDone().isEnabled() == false)) {
            backButton.setEnabled(true);
        }

    }


    private void updateHelp(float delta) {

    }

    public boolean isMainMap() {
        return currentState == GameState.MAINMAP;
    }

    public boolean isBank() {
        return currentState == GameState.BANK;
    }

    public boolean isHelp() {
        return currentState == GameState.HELP;
    }

    public boolean isStock() {
        return currentState == GameState.STOCK;
    }

    public boolean isInsurance() {
        return currentState == GameState.INSURANCE;
    }

    public boolean isShop() {
        return currentState == GameState.SHOP;
    }

    public void changeState(GameState gameState) {
        currentState = gameState;
    }

    public Bank getBank() {
        return bank;
    }

    public float getMoneyOnHand() {
        return moneyOnHand;
    }

    public GameState getCurrentState() {
        return currentState;
    }

    public void setMoneyOnHand(float moneyOnHand) {
        this.moneyOnHand = moneyOnHand;
    }

    public RectangleButton getBankButton() {
        return bankButton;
    }

    public RectangleButton getInsuranceButton() {
        return insuranceButton;
    }

    public ArrayList<RectangleButton> getMainMapButtons() {
        return mainMapButtons;
    }

    public FinGame getGame() {
        return game;
    }

    public RectangleButton getBackButton() {
        return backButton;
    }

    public float getCurrentAllowance() {
        return currentAllowance;
    }

    public void setCurrentAllowance(float currentAllowance) {
        this.currentAllowance = currentAllowance;
    }

    public InsuranceOffice getInsuranceOffice() {
        return insuranceOffice;
    }

    public float getTimeElapsed() {
        return timeElapsed;
    }

    private void addAllowance() {
        moneyOnHand += currentAllowance;
    }

    public Shop getShop() {
        return shop;
    }

    public RectangleButton getShopButton() {
        return shopButton;
    }

    public Stock getStock() {
        return stock;
    }

    public RectangleButton getStockButton() {
        return stockButton;
    }

    public RectangleButton getHelpButton() {
        return helpButton;
    }

    public RectangleButton getHelpButtonDone() {
        return helpButtonDone;
    }

    public int getDay() {
        return day;
    }

    public int getWeek() {
        return week;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getGameSubMode() {
        return gameSubMode;
    }

    public void setGameSubMode(int gameSubMode) {
        this.gameSubMode = gameSubMode;
    }
}

