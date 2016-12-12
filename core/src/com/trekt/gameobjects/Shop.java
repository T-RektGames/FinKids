package com.trekt.gameobjects;

import com.trekt.gameworld.GameWorld;
import com.trekt.helpers.AssetLoader;
import com.trekt.ui.RectangleButton;

import java.util.ArrayList;

/**
 * Created by dhruvshah on 30/7/16.
 */
public class Shop {
    private RectangleButton car, house, misc;
    private RectangleButton buyCar, buyHouse, buyGarden, buyPond;
    private RectangleButton doneCar, doneHouse, doneGarden, donePond;
    private float gameWidth = AssetLoader.gameWidth;
    private float gameHeight = AssetLoader.gameHeight;

    public RectangleButton getBuyGarden() {
        return buyGarden;
    }

    public RectangleButton getBuyPond() {
        return buyPond;
    }

    private ArrayList<RectangleButton> shopButtons;
    private GameWorld gameWorld;
    private float costOfCar  = (float)80;
    private float costOfHouse = (float) 200;
    private float costofPond = (float) 100;
    private float costOfGarden = (float) 120;
    private float incomeFromGarden = (float) 5;
    private float incomeFromPond = (float) 3;
    private float carSellingPrice, houseSellingPrice;
    private boolean isCarBought, isPondBought, isGardenBought, isHouseBought;
    private int houseLevel;



    public Shop(GameWorld gameWorld){

        shopButtons = new ArrayList<RectangleButton>();
        car = new RectangleButton(57,gameHeight - 57,45,55);
        house = new RectangleButton(110 ,gameHeight - 50,40,50);
        misc = new RectangleButton(gameWidth - 100,gameHeight - 55,45,50);
        buyGarden = new RectangleButton(gameWidth -33, gameHeight - 93, 17, 8);
        buyPond = new RectangleButton(78, gameHeight - 93, 17, 8);
        buyCar = new RectangleButton(gameWidth - 100,gameHeight - 100, 30, 15);
        buyHouse = new RectangleButton(gameWidth - 100, gameHeight - 100, 30, 15);
        doneGarden = new RectangleButton(gameWidth-33, gameHeight-83, 17, 8);
        doneCar = new RectangleButton(gameWidth - 100, gameHeight - 85, 30, 15);
        doneHouse = new RectangleButton(gameWidth - 100, gameHeight - 85, 30 , 15);
        donePond = new RectangleButton(78, gameHeight-83, 17, 8);
        shopButtons.add(car);
        shopButtons.add(house);
        shopButtons.add(misc);
        shopButtons.add(buyCar);
        shopButtons.add(buyHouse);
        shopButtons.add(buyGarden);
        shopButtons.add(buyPond);
        shopButtons.add(doneCar);
        shopButtons.add(doneHouse);
        shopButtons.add(doneGarden);
        shopButtons.add(donePond);
        isCarBought = AssetLoader.prefs.getBoolean("carBought");
        isPondBought = AssetLoader.prefs.getBoolean("pondBought");
        isGardenBought = AssetLoader.prefs.getBoolean("gardenBought");
        isHouseBought = AssetLoader.prefs.getBoolean("houseBought");
        houseLevel = 1;
        carSellingPrice = 45;
        houseSellingPrice = 175;

        this.gameWorld = gameWorld;




    }

    public void getIncome(){
        if (isGardenBought){
            gameWorld.getBank().deposit(incomeFromGarden);
        }

        if (isPondBought){
            gameWorld.getBank().deposit(incomeFromPond);
        }
    }
    public float getCostOfCar() {
        return costOfCar;
    }

    public float getCostOfHouse() {
        return costOfHouse;
    }

    public float getCostofPond() {
        return costofPond;
    }

    public float getCostOfGarden() {
        return costOfGarden;
    }

    public RectangleButton getCar() {
        return car;
    }

    public void setCar(RectangleButton car) {
        this.car = car;
    }

    public RectangleButton getHouse() {
        return house;
    }

    public void setHouse(RectangleButton house) {
        this.house = house;
    }

    public RectangleButton getMisc() {
        return misc;
    }

    public void setMisc(RectangleButton misc) {
        this.misc = misc;
    }

    public RectangleButton getBuyCar() {
        return buyCar;
    }

    public void setBuyCar(RectangleButton buyCar) {
        this.buyCar = buyCar;
    }

    public RectangleButton getBuyHouse() {
        return buyHouse;
    }

    public void setBuyHouse(RectangleButton buyHouse) {
        this.buyHouse = buyHouse;
    }


    public RectangleButton getDoneCar() {
        return doneCar;
    }

    public void setDoneCar(RectangleButton doneCar) {
        this.doneCar = doneCar;
    }

    public RectangleButton getDoneHouse() {
        return doneHouse;
    }

    public void setDoneHouse(RectangleButton doneHouse) {
        this.doneHouse = doneHouse;
    }

    public RectangleButton getDoneGarden() {
        return doneGarden;
    }

    public void setDoneGarden(RectangleButton doneGarden) {
        this.doneGarden = doneGarden;
    }

    public float getGameWidth() {
        return gameWidth;
    }

    public void setGameWidth(float gameWidth) {
        this.gameWidth = gameWidth;
    }

    public float getGameHeight() {
        return gameHeight;
    }

    public void setGameHeight(float gameHeight) {
        this.gameHeight = gameHeight;
    }

    public ArrayList<RectangleButton> getShopButtons() {
        return shopButtons;
    }

    public void setShopButtons(ArrayList<RectangleButton> shopButtons) {
        this.shopButtons = shopButtons;
    }

    public GameWorld getGameWorld() {
        return gameWorld;
    }

    public void setGameWorld(GameWorld gameWorld) {
        this.gameWorld = gameWorld;
    }

    public void setCostOfCar(float costOfCar) {
        this.costOfCar = costOfCar;
    }

    public void setCostOfHouse(float costOfHouse) {
        this.costOfHouse = costOfHouse;
    }

    public void setCostofPond(float costofPond) {
        this.costofPond = costofPond;
    }

    public void setCostOfGarden(float costOfGarden) {
        this.costOfGarden = costOfGarden;
    }

    public float getIncomeFromGarden() {
        return incomeFromGarden;
    }

    public void setIncomeFromGarden(float incomeFromGarden) {
        this.incomeFromGarden = incomeFromGarden;
    }

    public float getIncomeFromPond() {
        return incomeFromPond;
    }

    public void setIncomeFromPond(float incomeFromPond) {
        this.incomeFromPond = incomeFromPond;
    }

    public boolean isCarBought() {
        return isCarBought;
    }

    public void setIsCarBought(boolean isCarBought) {
        this.isCarBought = isCarBought;
    }

    public boolean isPondBought() {
        return isPondBought;
    }

    public void setIsPondBought(boolean isPondBought) {
        this.isPondBought = isPondBought;
    }

    public boolean isGardenBought() {
        return isGardenBought;
    }

    public void setIsGardenBought(boolean isGardenBought) {
        this.isGardenBought = isGardenBought;
    }

    public int getHouseLevel() {
        return houseLevel;
    }

    public void setHouseLevel(int houseLevel) {
        this.houseLevel = houseLevel;
    }

    public boolean isHouseBought() {
        return isHouseBought;
    }

    public void setIsHouseBought(boolean isHouseBought) {
        this.isHouseBought = isHouseBought;
    }

    public float getCarSellingPrice() {
        return carSellingPrice;
    }

    public float getHouseSellingPrice() {
        return houseSellingPrice;
    }

    public RectangleButton getDonePond() {
        return donePond;
    }

    public void setDonePond(RectangleButton donePond) {
        this.donePond = donePond;
    }
}
