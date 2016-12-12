package com.trekt.gameobjects;

import com.trekt.gameworld.GameWorld;
import com.trekt.helpers.AssetLoader;
import com.trekt.ui.RectangleButton;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.control.RadioMenuItem;

/**
 * Created by dhruvshah on 30/7/16.
 */
public class Stock {
    private RectangleButton stockAddButton, stockSubtractButton, stockDoneButton, stockComputerButton;
    private float gameWidth = AssetLoader.gameWidth;
    private float gameHeight = AssetLoader.gameHeight;
    private ArrayList<RectangleButton> stockButtons;
    private GameWorld gameWorld;
    private float cost = (float) 1.0;
    private Random random;
    //private float growthFactor;
    private float moneyInvestedInStock;

    public Stock(GameWorld gameWorld){
        stockButtons = new ArrayList<RectangleButton>();
        stockAddButton = new RectangleButton(111,gameHeight- 49,16,16);
        stockSubtractButton = new RectangleButton(135,gameHeight - 49,16,16);
        stockDoneButton = new RectangleButton(114,gameHeight-27,35,10);
        stockComputerButton = new RectangleButton(95, 70, 60, 60);
        stockButtons.add(stockAddButton);
        stockButtons.add(stockSubtractButton);
        stockButtons.add(stockDoneButton);
        stockButtons.add(stockComputerButton);
        this.gameWorld = gameWorld;
        random = new Random();
        moneyInvestedInStock = AssetLoader.prefs.getFloat("moneyInvestedInStock");
    }

    public void increase(float addFactor){
        moneyInvestedInStock+= addFactor;
        gameWorld.setMoneyOnHand(gameWorld.getMoneyOnHand() - cost*addFactor);

    }
    public void decrease(float addFactor){
        moneyInvestedInStock-= addFactor;
        gameWorld.setMoneyOnHand(gameWorld.getMoneyOnHand() + cost*addFactor);
    }

    public void getMarketResults(){
        double growthFactor = (float) (random.nextInt(101)-50)/100;
        moneyInvestedInStock *= (1+growthFactor);

    }

    public RectangleButton getStockAddButton() {
        return stockAddButton;
    }

    public void setStockAddButton(RectangleButton stockAddButton) {
        this.stockAddButton = stockAddButton;
    }

    public RectangleButton getStockSubtractButton() {
        return stockSubtractButton;
    }

    public void setStockSubtractButton(RectangleButton stockSubtractButton) {
        this.stockSubtractButton = stockSubtractButton;
    }

    public RectangleButton getStockDoneButton() {
        return stockDoneButton;
    }

    public void setStockDoneButton(RectangleButton stockDoneButton) {
        this.stockDoneButton = stockDoneButton;
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

    public ArrayList<RectangleButton> getStockButtons() {
        return stockButtons;
    }

    public void setStockButtons(ArrayList<RectangleButton> stockButtons) {
        this.stockButtons = stockButtons;
    }

    public GameWorld getGameWorld() {
        return gameWorld;
    }

    public void setGameWorld(GameWorld gameWorld) {
        this.gameWorld = gameWorld;
    }

    public float getCost() {
        return cost;
    }

    public float getMoneyInvestedInStock() {
        return moneyInvestedInStock;
    }

    public RectangleButton getStockComputerButton() {
        return stockComputerButton;
    }
}
