package com.trekt.gameobjects;

import com.trekt.gameworld.GameWorld;
import com.trekt.helpers.AssetLoader;
import com.trekt.ui.RectangleButton;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by AadityaPatwari on 30/7/16.
 */
public class InsuranceOffice {

    private float gameWidth = AssetLoader.gameWidth;
    private float gameHeight = AssetLoader.gameHeight;
    private GameWorld gameWorld;

    private int initialHouseCost = 0;
    private int initialCarCost = 0;
    private int weeklyHousePremium = 13;
    private int weeklyCarPremium = 7;
    private Random random;
    private int isCarOrHouseDestroyed = 0;

    private boolean houseInsuranceBought, carInsuranceBought;

    private RectangleButton carInsuranceButton, houseInsuranceButton, carInsuranceBuyButton, carInsuranceDoneButton,
            houseInsuranceBuyButton, houseInsuranceDoneButton, carInsuranceRevokeButton, houseInsuranceRevokeButton, insuranceClaimDoneButton;
    private ArrayList<RectangleButton> insuranceOfficeButtons;

    public InsuranceOffice(GameWorld gameWorld) {

        this.gameWorld = gameWorld;
        carInsuranceBought = AssetLoader.prefs.getBoolean("carInsured");
        houseInsuranceBought = AssetLoader.prefs.getBoolean("houseInsured");

        insuranceOfficeButtons = new ArrayList<RectangleButton>();
        houseInsuranceButton = new RectangleButton(4, 22, 68, 10);
        carInsuranceButton = new RectangleButton(gameWidth - 79, 25, 70, 10);
        houseInsuranceBuyButton = new RectangleButton(20, 80, 35, 10);
        //houseInsuranceRevokeButton = new RectangleButton(20, 90, 35, 10);
        houseInsuranceDoneButton = new RectangleButton(20, 90, 35, 10);

        carInsuranceBuyButton = new RectangleButton(gameWidth-58, 80, 35, 10);
        //carInsuranceRevokeButton = new RectangleButton(gameWidth-80, 80, 50, 10);
        carInsuranceDoneButton = new RectangleButton(gameWidth-58, 90, 35, 10);
        insuranceClaimDoneButton = new RectangleButton(gameWidth - 100, gameHeight - 85, 30, 15);

        insuranceOfficeButtons.add(carInsuranceButton);
        insuranceOfficeButtons.add(houseInsuranceButton);

        insuranceOfficeButtons.add(houseInsuranceBuyButton);
        insuranceOfficeButtons.add(houseInsuranceDoneButton);
        //insuranceOfficeButtons.add(houseInsuranceRevokeButton);
        insuranceOfficeButtons.add(carInsuranceBuyButton);
        insuranceOfficeButtons.add(carInsuranceDoneButton);
        insuranceOfficeButtons.add(insuranceClaimDoneButton);
        //insuranceOfficeButtons.add(carInsuranceRevokeButton);

        random = new Random();

    }


    public void update() {

    }

    public void chargePremiums(){
        if (houseInsuranceBought){
            if (gameWorld.getBank().getTotalBalance()>= weeklyHousePremium) {
                gameWorld.getBank().withdraw(weeklyHousePremium);
            }   else {
                gameWorld.getInsuranceOffice().setHouseInsuranceBought(false);
            }
        }

        if (carInsuranceBought){
            if (gameWorld.getBank().getTotalBalance()>= weeklyCarPremium) {
                gameWorld.getBank().withdraw(weeklyCarPremium);
            }   else {
                gameWorld.getInsuranceOffice().setCarInsuranceBought(false);
            }
        }
    }

    public void causeDestruction(){


        if (random.nextInt(101) <6) {
            if (gameWorld.getShop().isHouseBought()) {
                gameWorld.getShop().setIsHouseBought(false);
                insuranceClaimDoneButton.setEnabled(true);
                if (houseInsuranceBought) {
                    gameWorld.setMoneyOnHand(gameWorld.getMoneyOnHand() + gameWorld.getShop().getCostOfHouse());

                }
                isCarOrHouseDestroyed = 1;
            }
        }   else if (random.nextInt(101)<16){

            if (gameWorld.getShop().isCarBought()) {
                gameWorld.getShop().setIsCarBought(false);
                insuranceClaimDoneButton.setEnabled(true);
                if (carInsuranceBought) {
                    gameWorld.setMoneyOnHand(gameWorld.getMoneyOnHand() + gameWorld.getShop().getCostOfCar());
                }
                isCarOrHouseDestroyed = 2;
            }
        }
    }

    public RectangleButton getCarInsuranceButton() {
        return carInsuranceButton;
    }

    public RectangleButton getHouseInsuranceButton() {
        return houseInsuranceButton;
    }

    public ArrayList<RectangleButton> getInsuranceOfficeButtons() {
        return insuranceOfficeButtons;
    }

    public RectangleButton getCarInsuranceBuyButton() {
        return carInsuranceBuyButton;
    }

    public RectangleButton getCarInsuranceDoneButton() {
        return carInsuranceDoneButton;
    }

    public RectangleButton getHouseInsuranceBuyButton() {
        return houseInsuranceBuyButton;
    }

    public RectangleButton getHouseInsuranceDoneButton() {
        return houseInsuranceDoneButton;
    }



//    public RectangleButton getCarInsuranceRevokeButton() {
//        return carInsuranceRevokeButton;
//    }
//
//    public RectangleButton getHouseInsuranceRevokeButton() {
//        return houseInsuranceRevokeButton;
//    }

    public boolean isHouseInsuranceBought() {
        return houseInsuranceBought;
    }

    public void setHouseInsuranceBought(boolean houseInsuranceBought) {
        this.houseInsuranceBought = houseInsuranceBought;
    }

    public boolean isCarInsuranceBought() {
        return carInsuranceBought;
    }

    public void setCarInsuranceBought(boolean carInsuranceBought) {
        this.carInsuranceBought = carInsuranceBought;
    }

    public int getInitialHouseCost() {
        return initialHouseCost;
    }

    public int getInitialCarCost() {
        return initialCarCost;
    }

    public int getWeeklyHousePremium() {
        return weeklyHousePremium;
    }

    public int getWeeklyCarPremium() {
        return weeklyCarPremium;
    }

    public RectangleButton getInsuranceClaimDoneButton() {
        return insuranceClaimDoneButton;
    }


    public int getIsCarOrHouseDestroyed() {
        return isCarOrHouseDestroyed;
    }

    public void setIsCarOrHouseDestroyed(int isCarOrHouseDestroyed) {
        this.isCarOrHouseDestroyed = isCarOrHouseDestroyed;
    }
}
