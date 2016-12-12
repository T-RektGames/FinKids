package com.trekt.helpers;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.trekt.gameobjects.Bank;
import com.trekt.gameobjects.InsuranceOffice;
import com.trekt.gameobjects.Shop;
import com.trekt.gameobjects.Stock;
import com.trekt.gameworld.GameWorld;
import com.trekt.ui.RectangleButton;

import java.util.ArrayList;


/**
 * Created by AadityaPatwari on 29/7/16.
 */
public class InputHandler implements InputProcessor {

    private float scaleFactorX;
    private float scaleFactorY;
    private GameWorld gameWorld;
    float gameWidth = AssetLoader.gameWidth;
    float gameHeight = AssetLoader.gameHeight;
    private Bank bank;
    private Shop shop;
    private InsuranceOffice insuranceOffice;
    private Stock stock;
    private float currentTempLoanAmount;
    private ArrayList<RectangleButton> bankButtons,  insuranceOfficeButtons, shopButtons, stockButtons;

    public InputHandler(GameWorld gameWorld, float scaleFactorX, float scaleFactorY) {
        this.scaleFactorX = scaleFactorX;
        this.scaleFactorY = scaleFactorY;
        this.gameWorld = gameWorld;
        this.bank = gameWorld.getBank();
        this.shop = gameWorld.getShop();
        this.insuranceOffice = gameWorld.getInsuranceOffice();
        this.stock = gameWorld.getStock();
        bankButtons = gameWorld.getBank().getBankButtons();
        //mainMapButtons = gameWorld.getMainMapButtons();
        insuranceOfficeButtons = gameWorld.getInsuranceOffice().getInsuranceOfficeButtons();
        shopButtons = gameWorld.getShop().getShopButtons();
        stockButtons = gameWorld.getStock().getStockButtons();

        //skin = new Skin();
        //textField = new TextField("aaaaaaaaaa", skin);
        //scroll = new ScrollPane(textField);
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        screenX = scaleX(screenX);
        screenY = scaleY(screenY);

        if (gameWorld.getBackButton().isClicked(screenX, screenY)) {
            gameWorld.changeState(GameWorld.GameState.MAINMAP);
            bank.getTransactionButton().setEnabled(false);
            bank.getLoanButton().setEnabled(false);
            insuranceOffice.getCarInsuranceButton().setEnabled(false);
            insuranceOffice.getHouseInsuranceButton().setEnabled(false);
            shop.getMisc().setEnabled(false);
            shop.getCar().setEnabled(false);
            shop.getHouse().setEnabled(false);
            stock.getStockComputerButton().setEnabled(false);
            gameWorld.setGameSubMode(0);
           // if (!prefs.contains("moneyInHand")) {
                AssetLoader.prefs.putFloat("moneyInHand", gameWorld.getMoneyOnHand());
           // }

            //if (!prefs.contains("totalBankBalance")) {
                AssetLoader.prefs.putFloat("totalBankBalance", gameWorld.getBank().getTotalBalance());
           // }

           // if (!prefs.contains("unpaidLoanAmount")) {
                AssetLoader.prefs.putFloat("unpaidLoanAmount", gameWorld.getBank().getUnpaidLoanAmount());

//            }

  //          if (!prefs.contains("moneyInvestedInStock")) {
                AssetLoader.prefs.putFloat("moneyInvestedInStock", gameWorld.getStock().getMoneyInvestedInStock());
    //        }

      //      if (!prefs.contains("day")) {
                AssetLoader.prefs.putInteger("day", gameWorld.getDay());
        //    }

          //  if (!prefs.contains("week")) {
                AssetLoader.prefs.putInteger("week", gameWorld.getWeek());
            //}


//            if (!prefs.contains("carBought")) {
                AssetLoader.prefs.putBoolean("carBought", gameWorld.getShop().isCarBought());
  //          }

    //        if (!prefs.contains("houseBought")) {
                AssetLoader.prefs.putBoolean("houseBought", gameWorld.getShop().isHouseBought());
      //      }

        //    if (!prefs.contains("gardenBought")) {
                AssetLoader.prefs.putBoolean("gardenBought", gameWorld.getShop().isGardenBought());
          //  }

            //if (!prefs.contains("pondBought")) {
                AssetLoader.prefs.putBoolean("pondBought", gameWorld.getShop().isPondBought());
            //}

            //if (!prefs.contains("houseInsured")) {
                AssetLoader.prefs.putBoolean("houseInsured", gameWorld.getInsuranceOffice().isHouseInsuranceBought());
            //}

            //if (!prefs.contains("carInsured")) {
                AssetLoader.prefs.putBoolean("carInsured", gameWorld.getInsuranceOffice().isCarInsuranceBought());

                AssetLoader.prefs.flush();
            //}

        } else if (gameWorld.isMainMap()) {

            if (gameWorld.getBankButton().isClicked(screenX, screenY)) {
                gameWorld.changeState(GameWorld.GameState.BANK);
                bank.getTransactionButton().setEnabled(true);
                bank.getLoanButton().setEnabled(true);
                gameWorld.getBankButton().setEnabled(false);
                gameWorld.getInsuranceButton().setEnabled(false);
                gameWorld.getShopButton().setEnabled(false);
                gameWorld.getStockButton().setEnabled(false);
                gameWorld.setGameSubMode(1);
                //gameWorld.getBank().getBankHelpButton().setEnabled(true);
                //gameWorld.getHelpButton().setEnabled(false);

                //System.out.println("kkkk");
            } else if (gameWorld.getInsuranceButton().isClicked(screenX, screenY)) {
                gameWorld.changeState(GameWorld.GameState.INSURANCE);
                gameWorld.getInsuranceButton().setEnabled(false);
                gameWorld.getBankButton().setEnabled(false);
                insuranceOffice.getCarInsuranceButton().setEnabled(true);
                insuranceOffice.getHouseInsuranceButton().setEnabled(true);
                gameWorld.getShopButton().setEnabled(false);
                gameWorld.getStockButton().setEnabled(false);
                gameWorld.setGameSubMode(3);
                //gameWorld.getHelpButton().setEnabled(false);

            }   else if (gameWorld.getShopButton().isClicked(screenX, screenY)) {
                gameWorld.changeState(GameWorld.GameState.SHOP);
                shop.getCar().setEnabled(true);
                shop.getHouse().setEnabled(true);
                shop.getMisc().setEnabled(true);
                gameWorld.getShopButton().setEnabled(false);
                gameWorld.getBankButton().setEnabled(false);
                gameWorld.getInsuranceButton().setEnabled(false);
                gameWorld.getStockButton().setEnabled(false);
                gameWorld.setGameSubMode(7);
                //gameWorld.getHelpButton().setEnabled(false);

            }   else if(gameWorld.getStockButton().isClicked(screenX,screenY)){
                gameWorld.changeState(GameWorld.GameState.STOCK);
                stock.getStockAddButton().setEnabled(false);
                stock.getStockSubtractButton().setEnabled(false);
                stock.getStockDoneButton().setEnabled(false);
                gameWorld.getBankButton().setEnabled(false);
                gameWorld.getShopButton().setEnabled(false);
                gameWorld.getStockButton().setEnabled(false);
                gameWorld.getInsuranceButton().setEnabled(false);
                gameWorld.getStock().getStockComputerButton().setEnabled(true);
                gameWorld.setGameSubMode(5);
                //gameWorld.getHelpButton().setEnabled(false);
            }   else if (gameWorld.getInsuranceOffice().getInsuranceClaimDoneButton().isClicked(screenX, screenY)){
                gameWorld.getInsuranceOffice().getInsuranceClaimDoneButton().setEnabled(false);
            }



        } else if (gameWorld.isBank()) {


            if (bank.getTransactionButton().isClicked(screenX, screenY)) {
                bank.getTransactionAddButton().setEnabled(true);
                bank.getTransactionWithdrawButton().setEnabled(true);
                bank.getTransactionDoneButton().setEnabled(true);
                bank.getTransactionButton().setEnabled(false);
                gameWorld.getBackButton().setEnabled(false);
                gameWorld.setGameSubMode(2);


            } else if (bank.getTransactionDoneButton().isClicked(screenX, screenY)) {
                bank.getTransactionAddButton().setEnabled(false);
                bank.getTransactionWithdrawButton().setEnabled(false);
                bank.getTransactionDoneButton().setEnabled(false);
                bank.getTransactionButton().setEnabled(true);
                gameWorld.getBackButton().setEnabled(true);
                if (!gameWorld.getBank().getLoanDoneButton().isEnabled()) {
                    gameWorld.setGameSubMode(1);
                }

            } else if (bank.getTransactionAddButton().isClicked(screenX, screenY)) {
                if (gameWorld.getMoneyOnHand() - 1 >= 0) {
                    bank.deposit(1);
                    gameWorld.setMoneyOnHand(gameWorld.getMoneyOnHand() - 1);
                }   else if (gameWorld.getMoneyOnHand()>0){
                    bank.deposit(gameWorld.getMoneyOnHand());
                    gameWorld.setMoneyOnHand(0);
                }
            } else if (bank.getTransactionWithdrawButton().isClicked(screenX, screenY)) {
                if (bank.getTotalBalance() - 1 >= 0) {
                    bank.withdraw(1);
                    gameWorld.setMoneyOnHand(gameWorld.getMoneyOnHand() + 1);
                }   else if (bank.getTotalBalance()>0){

                    gameWorld.setMoneyOnHand(gameWorld.getMoneyOnHand()+bank.getTotalBalance());
                    bank.withdraw(bank.getTotalBalance());
                }
            } else if (bank.getLoanButton().isClicked(screenX, screenY)) {
                currentTempLoanAmount = bank.getUnpaidLoanAmount();
                gameWorld.setGameSubMode(2);
                if (bank.getUnpaidLoanAmount() == 0) {
                    bank.getLoanAddButton().setEnabled(true);
                    bank.getLoanWithdrawButton().setEnabled(true);
                    bank.getLoanDoneButton().setEnabled(true);
                    bank.getLoanButton().setEnabled(false);
                    gameWorld.getBackButton().setEnabled(false);

                }

                if (bank.getUnpaidLoanAmount() > 0) {
                    bank.getLoanRepayAddButton().setEnabled(true);
                    bank.getLoanRepayWithdrawButton().setEnabled(true);
                    bank.getLoanDoneButton().setEnabled(true);
                    bank.getLoanButton().setEnabled(false);
                    gameWorld.getBackButton().setEnabled(false);
                }
            } else if (bank.getLoanAddButton().isClicked(screenX, screenY)) {

                bank.addLoan(1);
                //gameWorld.setMoneyOnHand(gameWorld.getMoneyOnHand()+1);
            } else if (bank.getLoanWithdrawButton().isClicked(screenX, screenY)) {
                if (gameWorld.getMoneyOnHand() - 1 >= 0 && gameWorld.getBank().getUnpaidLoanAmount() - 1 >= 0) {
                    bank.addLoan(-1);
                    //  gameWorld.setMoneyOnHand(gameWorld.getMoneyOnHand()-1);
                }   else if (gameWorld.getMoneyOnHand()>0){
                    bank.addLoan((gameWorld.getMoneyOnHand()*-1));
                }
            } else if (bank.getLoanRepayAddButton().isClicked(screenX, screenY)) {
                if (bank.getUnpaidLoanAmount() < currentTempLoanAmount) {
                    bank.addLoan(1);
                    //gameWorld.setMoneyOnHand(gameWorld.getMoneyOnHand()+1);
                }

            } else if (bank.getLoanRepayWithdrawButton().isClicked(screenX, screenY)) {
                if (gameWorld.getMoneyOnHand() - 1 >= 0 && gameWorld.getBank().getUnpaidLoanAmount() - 1 >= 0) {
                    bank.addLoan(-1);
                    //gameWorld.setMoneyOnHand(gameWorld.getMoneyOnHand()-1);
                }   else if (gameWorld.getMoneyOnHand()>0 && gameWorld.getBank().getUnpaidLoanAmount()>0){
                    bank.addLoan(gameWorld.getBank().getUnpaidLoanAmount()*-1);
                }
            } else if (bank.getLoanDoneButton().isClicked(screenX, screenY)) {
                bank.getLoanAddButton().setEnabled(false);
                bank.getLoanWithdrawButton().setEnabled(false);
                bank.getLoanDoneButton().setEnabled(false);
                bank.getLoanRepayAddButton().setEnabled(false);
                bank.getLoanRepayWithdrawButton().setEnabled(false);
                bank.getLoanButton().setEnabled(true);
                gameWorld.getBackButton().setEnabled(true);
                if (!gameWorld.getBank().getTransactionDoneButton().isEnabled()) {
                    gameWorld.setGameSubMode(1);
                }
            }



        } else if (gameWorld.isInsurance()) {

            if (insuranceOffice.getHouseInsuranceButton().isClicked(screenX, screenY)) {
                insuranceOffice.getHouseInsuranceButton().setEnabled(false);
                gameWorld.getBackButton().setEnabled(false);
                insuranceOffice.getHouseInsuranceBuyButton().setEnabled(true);
                insuranceOffice.getHouseInsuranceDoneButton().setEnabled(true);
                gameWorld.setGameSubMode(4);
            } else if (insuranceOffice.getHouseInsuranceBuyButton().isClicked(screenX, screenY)) {
                if (insuranceOffice.isHouseInsuranceBought() == false) {
                    if (gameWorld.getMoneyOnHand() - insuranceOffice.getInitialHouseCost() >= 0) {
                        insuranceOffice.setHouseInsuranceBought(true);
                        gameWorld.setMoneyOnHand(gameWorld.getMoneyOnHand() - insuranceOffice.getInitialHouseCost());
                    }
                } else {
                    insuranceOffice.setHouseInsuranceBought(false);
                }
            } else if (insuranceOffice.getHouseInsuranceDoneButton().isClicked(screenX, screenY)) {
                insuranceOffice.getHouseInsuranceButton().setEnabled(true);
                gameWorld.getBackButton().setEnabled(true);
                insuranceOffice.getHouseInsuranceBuyButton().setEnabled(false);
                insuranceOffice.getHouseInsuranceDoneButton().setEnabled(false);
                if (!gameWorld.getInsuranceOffice().getCarInsuranceButton().isEnabled()){
                    gameWorld.setGameSubMode(3);
                }
            } else if (insuranceOffice.getCarInsuranceButton().isClicked(screenX, screenY)) {
                insuranceOffice.getCarInsuranceButton().setEnabled(false);
                gameWorld.getBackButton().setEnabled(false);
                insuranceOffice.getCarInsuranceBuyButton().setEnabled(true);
                insuranceOffice.getCarInsuranceDoneButton().setEnabled(true);
                gameWorld.setGameSubMode(4);
            } else if (insuranceOffice.getCarInsuranceBuyButton().isClicked(screenX, screenY)) {
                if (insuranceOffice.isCarInsuranceBought() == false) {
                    if (gameWorld.getMoneyOnHand() - insuranceOffice.getInitialCarCost() >= 0) {
                        insuranceOffice.setCarInsuranceBought(true);
                        gameWorld.setMoneyOnHand(gameWorld.getMoneyOnHand()-insuranceOffice.getInitialCarCost());
                    }
                } else {
                    insuranceOffice.setCarInsuranceBought(false);
                }
            } else if (insuranceOffice.getCarInsuranceDoneButton().isClicked(screenX, screenY)) {
                insuranceOffice.getCarInsuranceButton().setEnabled(true);
                gameWorld.getBackButton().setEnabled(true);
                insuranceOffice.getCarInsuranceBuyButton().setEnabled(false);
                insuranceOffice.getCarInsuranceDoneButton().setEnabled(false);
                if (!gameWorld.getInsuranceOffice().getHouseInsuranceButton().isEnabled()){
                    gameWorld.setGameSubMode(3);
                }
            }


        } else if (gameWorld.isShop()) {

            if (shop.getHouse().isClicked(screenX, screenY)) {
                shop.getBuyHouse().setEnabled(true);
                shop.getHouse().setEnabled(false);
                shop.getCar().setEnabled(false);
                shop.getMisc().setEnabled(false);
                shop.getDoneHouse().setEnabled(true);
                gameWorld.getBackButton().setEnabled(false);
                gameWorld.setGameSubMode(9);

            } else if (shop.getCar().isClicked(screenX, screenY)) {
                shop.getBuyCar().setEnabled(true);
                shop.getCar().setEnabled(false);
                shop.getHouse().setEnabled(false);
                shop.getMisc().setEnabled(false);
                shop.getDoneCar().setEnabled(true);
                gameWorld.getBackButton().setEnabled(false);
                gameWorld.setGameSubMode(8);
            } else if (shop.getMisc().isClicked(screenX, screenY)) {
                shop.getBuyGarden().setEnabled(true);
                shop.getBuyPond().setEnabled(true);
                shop.getMisc().setEnabled(false);
                shop.getHouse().setEnabled(false);
                shop.getCar().setEnabled(false);
                shop.getDoneGarden().setEnabled(true);
                shop.getDonePond().setEnabled(true);
                gameWorld.getBackButton().setEnabled(false);
                gameWorld.setGameSubMode(10);
            } else if (shop.getDoneCar().isClicked(screenX, screenY)) {
                shop.getCar().setEnabled(true);
                shop.getHouse().setEnabled(true);
                shop.getMisc().setEnabled(true);
                shop.getBuyCar().setEnabled(false);
                //shop.getBuyGarden().setEnabled(false);
                //shop.getBuyPond().setEnabled(false);
                //shop.getBuyHouse().setEnabled(false);
                shop.getDoneCar().setEnabled(false);
                //shop.getDoneMisc().setEnabled(false);
                //shop.getDoneHouse().setEnabled(false);
                gameWorld.getBackButton().setEnabled(true);
                gameWorld.setGameSubMode(7);

            } else if (shop.getDoneHouse().isClicked(screenX, screenY)) {
                shop.getCar().setEnabled(true);
                shop.getHouse().setEnabled(true);
                shop.getMisc().setEnabled(true);
                //shop.getBuyCar().setEnabled(false);
                //shop.getBuyGarden().setEnabled(false);
                //shop.getBuyPond().setEnabled(false);
                shop.getBuyHouse().setEnabled(false);
                //shop.getDoneCar().setEnabled(false);
                //shop.getDoneMisc().setEnabled(false);
                shop.getDoneHouse().setEnabled(false);
                gameWorld.getBackButton().setEnabled(true);
                gameWorld.setGameSubMode(7);


            } else if (shop.getDoneGarden().isClicked(screenX, screenY)) {
                if (shop.getDonePond().isEnabled()==false) {
                    shop.getCar().setEnabled(true);
                    shop.getHouse().setEnabled(true);
                    shop.getMisc().setEnabled(true);
                    gameWorld.setGameSubMode(7);
                }
                    shop.getBuyGarden().setEnabled(false);
                    shop.getDoneGarden().setEnabled(false);

                //gameWorld.getBackButton().setEnabled(true);

            }   else if (shop.getDonePond().isClicked(screenX, screenY)){
                if (shop.getDoneGarden().isEnabled() == false) {
                    shop.getCar().setEnabled(true);
                    shop.getHouse().setEnabled(true);
                    shop.getMisc().setEnabled(true);
                    gameWorld.setGameSubMode(7);
                }
                //shop.getBuyCar().setEnabled(false);
                //shop.getBuyGarden().setEnabled(false);
                shop.getBuyPond().setEnabled(false);
                //shop.getBuyHouse().setEnabled(false);
                //shop.getDoneCar().setEnabled(false);
                //shop.getDoneGarden().setEnabled(false);
                //shop.getDoneHouse().setEnabled(false);
                shop.getDonePond().setEnabled(false);
               // gameWorld.getBackButton().setEnabled(true);

            } else if (shop.getBuyCar().isClicked(screenX, screenY)){


                    if (shop.isCarBought()==false) {

                        if (gameWorld.getMoneyOnHand() - shop.getCostOfCar() >=0) {
                            shop.setIsCarBought(true);
                            gameWorld.setMoneyOnHand(gameWorld.getMoneyOnHand() - shop.getCostOfCar());
                        }
                    } else {
                        shop.setIsCarBought(false);
                        gameWorld.setMoneyOnHand(gameWorld.getMoneyOnHand()+ shop.getCarSellingPrice());

                    }

            }   else if (shop.getBuyHouse().isClicked(screenX, screenY)){

                if (shop.isHouseBought() == false){
                    if (gameWorld.getMoneyOnHand() - shop.getCostOfHouse() >= 0) {
                        shop.setIsHouseBought(true);
                        gameWorld.setMoneyOnHand(gameWorld.getMoneyOnHand() - shop.getCostOfHouse());
                    }
                }   else {
                    shop.setIsHouseBought(false);
                    gameWorld.setMoneyOnHand(gameWorld.getMoneyOnHand()+ shop.getHouseSellingPrice());
                }

            }   else if (shop.getBuyPond().isClicked(screenX, screenY)){
                if (gameWorld.getMoneyOnHand() - shop.getCostofPond() >=0) {
                    shop.setIsPondBought(true);
                    gameWorld.setMoneyOnHand(gameWorld.getMoneyOnHand() - shop.getCostofPond());
                }

            }   else if (shop.getBuyGarden().isClicked(screenX, screenY)){
                if (gameWorld.getMoneyOnHand()- shop.getCostOfGarden() >=0) {
                    shop.setIsGardenBought(true);
                    gameWorld.setMoneyOnHand(gameWorld.getMoneyOnHand() - shop.getCostOfGarden());
                }
            }
        }

        else if(gameWorld.isStock()){
            if(stock.getStockAddButton().isClicked(screenX,screenY)){
                gameWorld.getBackButton().setEnabled(false);
                if(gameWorld.getMoneyOnHand() -1> 0){
                    stock.increase(1);

                }   else if (gameWorld.getMoneyOnHand()>0){
                    stock.increase(gameWorld.getMoneyOnHand());
                }
            }
            else if(stock.getStockSubtractButton().isClicked(screenX,screenY)){
                gameWorld.getBackButton().setEnabled(false);
                if(stock.getMoneyInvestedInStock()-1>0){
                    stock.decrease(1);
                }   else if (stock.getMoneyInvestedInStock()>0){
                    stock.decrease(stock.getMoneyInvestedInStock());
                }
            }
            else if(stock.getStockDoneButton().isClicked(screenX,screenY)){
                stock.getStockSubtractButton().setEnabled(false);
                stock.getStockAddButton().setEnabled(false);
                gameWorld.getBackButton().setEnabled(true);
                stock.getStockDoneButton().setEnabled(false);
                stock.getStockComputerButton().setEnabled(true);
                gameWorld.setGameSubMode(5);

            }   else if (stock.getStockComputerButton().isClicked(screenX, screenY)){
                stock.getStockComputerButton().setEnabled(false);
                stock.getStockAddButton().setEnabled(true);
                stock.getStockSubtractButton().setEnabled(true);
                stock.getStockDoneButton().setEnabled(true);
                gameWorld.getBackButton().setEnabled(false);
                gameWorld.setGameSubMode(6);
            }
        }

        else if (gameWorld.isHelp()){
            if (gameWorld.getHelpButtonDone().isClicked(screenX, screenY)){
                gameWorld.getHelpButtonDone().setEnabled(false);
                gameWorld.changeState(GameWorld.GameState.MAINMAP);
//                bank.getTransactionButton().setEnabled(false);
//                bank.getLoanButton().setEnabled(false);
//                insuranceOffice.getCarInsuranceButton().setEnabled(false);
//                insuranceOffice.getHouseInsuranceButton().setEnabled(false);
//                shop.getMisc().setEnabled(false);
//                shop.getCar().setEnabled(false);
//                shop.getHouse().setEnabled(false);
//                stock.getStockComputerButton().setEnabled(false);
            }
        }


        if (gameWorld.getHelpButton().isClicked(screenX, screenY)){
            //gameWorld.changeState(GameWorld.GameState.HELP);
            // bank.getTransactionButton().setEnabled(true);
            // bank.getLoanButton().setEnabled(true);
            gameWorld.getHelpButtonDone().setEnabled(true);
            gameWorld.getBankButton().setEnabled(false);
            gameWorld.getInsuranceButton().setEnabled(false);
            gameWorld.getShopButton().setEnabled(false);
            gameWorld.getStockButton().setEnabled(false);
            gameWorld.getBackButton().setEnabled(false);
            gameWorld.getHelpButton().setEnabled(false);

            switch (gameWorld.getCurrentState()) {



                case MAINMAP:
                    //updateMainMap(delta);

                    break;

                case BANK:
                    //updateBank(delta);

                    for (int i = 0; i <bankButtons.size(); i++){
                        bankButtons.get(i).setEnabled(false);
                    }
                    break;

                case INSURANCE:
                    //updateInsurance(delta);
                    for (int i = 0; i <insuranceOfficeButtons.size(); i++){
                        insuranceOfficeButtons.get(i).setEnabled(false);
                    }
                    break;

                case STOCK:
                    //updateStock(delta);
                    for (int i = 0; i <stockButtons.size(); i++){
                        stockButtons.get(i).setEnabled(false);
                    }
                    break;

                case SHOP:
                    //updateShop(delta);
                    for (int i = 0; i <shopButtons.size(); i++){
                        shopButtons.get(i).setEnabled(false);
                    }
                    break;

                    //updateHelp(delta);
            }

            //gameWorld.getHelpButton().setEnabled(false);

        }

        if (gameWorld.getHelpButtonDone().isClicked(screenX, screenY)){
            gameWorld.getHelpButtonDone().setEnabled(false);
            gameWorld.getHelpButton().setEnabled(true);

            switch (gameWorld.getCurrentState()) {



                case MAINMAP:
                    //updateMainMap(delta);

                    break;

                case BANK:
                    //updateBank(delta);
                    gameWorld.getBank().getTransactionButton().setEnabled(true);
                    gameWorld.getBank().getLoanButton().setEnabled(true);
                    break;

                case INSURANCE:
                    //updateInsurance(delta);
                    gameWorld.getInsuranceOffice().getHouseInsuranceButton().setEnabled(true);
                    gameWorld.getInsuranceOffice().getCarInsuranceButton().setEnabled(true);
                    break;

                case STOCK:
                    //updateStock(delta);
                    gameWorld.getStock().getStockComputerButton().setEnabled(true);
                    break;

                case SHOP:
                    //updateShop(delta);
                    gameWorld.getShop().getHouse().setEnabled(true);
                    gameWorld.getShop().getCar().setEnabled(true);
                    gameWorld.getShop().getMisc().setEnabled(true);
                    break;

                //updateHelp(delta);
            }
        }


        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    private int scaleX(int screenX) {
        return (int) (screenX / scaleFactorX);
    }

    private int scaleY(int screenY) {
        return (int) (screenY / scaleFactorY);
    }


}
