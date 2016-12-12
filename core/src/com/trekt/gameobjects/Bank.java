package com.trekt.gameobjects;

import com.badlogic.gdx.math.Rectangle;
import com.trekt.gameworld.GameWorld;
import com.trekt.helpers.AssetLoader;
import com.trekt.ui.RectangleButton;

import java.util.ArrayList;

/**
 * Created by AadityaPatwari on 29/7/16.
 */
public class Bank {

    private RectangleButton transactionButton, transactionAddButton, transactionWithdrawButton, transactionDoneButton; //bankHelpButton, bankHelpDoneButton;
    private RectangleButton loanButton, loanAddButton, loanWithdrawButton, loanDoneButton, loanRepayAddButton, loanRepayWithdrawButton;
    private float gameWidth = AssetLoader.gameWidth;
    private float gameHeight = AssetLoader.gameHeight;
    private float totalBalance;
   // private BankAccount bankAccount;
    private ArrayList<RectangleButton> bankButtons;
    private float interestRate = (float) 0.02;
    private float unpaidLoanAmount;
    private float loanInterestRate = (float) 0.05;
    private GameWorld gameWorld;


    public Bank(GameWorld gameWorld){
        //bankAccount = new
        // BankAccount(initialBalance);
        bankButtons = new ArrayList<RectangleButton>();
        transactionButton = new RectangleButton(4, 25 , 73, 10);
        transactionAddButton = new RectangleButton(19, 79, 16, 16);
        transactionWithdrawButton = new RectangleButton(43, 79, 16, 16);
        transactionDoneButton = new RectangleButton(23, 100, 35, 10);
        loanButton = new RectangleButton(gameWidth- 62, 27, 33, 8);
        loanAddButton = new RectangleButton(gameWidth-61, 82, 16,16);
        loanWithdrawButton = new RectangleButton(gameWidth-35, 82, 16, 16);
        loanDoneButton = new RectangleButton(gameWidth - 58, 103, 35, 10);
        loanRepayAddButton = new RectangleButton(gameWidth - 61, 82, 16, 16);
        loanRepayWithdrawButton = new RectangleButton(gameWidth-35, 82, 16, 16);
        //bankHelpButton = new RectangleButton(gameWidth-35, 82, 10, 20);
        //bankHelpDoneButton = new RectangleButton(gameWidth-72, gameHeight-35, 42, 15);
        bankButtons.add(transactionButton);
        bankButtons.add(transactionAddButton);
        bankButtons.add(transactionDoneButton);
        bankButtons.add(transactionWithdrawButton);
        bankButtons.add(loanAddButton);
        bankButtons.add(loanWithdrawButton);
        bankButtons.add(loanButton);
        bankButtons.add(loanDoneButton);
        bankButtons.add(loanRepayAddButton);
        bankButtons.add(loanRepayWithdrawButton);
        //bankButtons.add(bankHelpButton);
        //bankButtons.add(bankHelpDoneButton);
        this.gameWorld = gameWorld;
        totalBalance = AssetLoader.prefs.getFloat("totalBankBalance");
        unpaidLoanAmount = AssetLoader.prefs.getFloat("unpaidLoanAmount");



    }

    public void update(){
      //  bankAccount.update();

    }

    public void deposit(float depositSum){
        totalBalance += depositSum;
    }

    public void withdraw(float withdrawSum){
        totalBalance -= withdrawSum;
    }

    public void grow(){
        totalBalance *= 1 + interestRate;
    }

    public void chargeInterest(){
        unpaidLoanAmount *= 1+loanInterestRate;
    }

    public void addLoan(float addFactor){

        if (addFactor>0) {
            if (unpaidLoanAmount < (int) gameWorld.getCurrentAllowance() * 20 / 10) {
                unpaidLoanAmount += addFactor;
                gameWorld.setMoneyOnHand(gameWorld.getMoneyOnHand() + addFactor);
            }
        }

        if (addFactor<0){
            if (unpaidLoanAmount>0){
                unpaidLoanAmount += addFactor;
                gameWorld.setMoneyOnHand(gameWorld.getMoneyOnHand() + addFactor);
            }
        }
    }

    public RectangleButton getTransactionButton() {
        return transactionButton;
    }

   // public float getInitialBalance() {
     //   return initialBalance;
   // }

    public float getTotalBalance() {
        return totalBalance;
    }

   // public BankAccount getBankAccount() {
        //return bankAccount;
    //}

    public RectangleButton getTransactionAddButton() {
        return transactionAddButton;
    }

    public RectangleButton getTransactionWithdrawButton() {
        return transactionWithdrawButton;
    }

    public RectangleButton getTransactionDoneButton() {
        return transactionDoneButton;
    }

    public ArrayList<RectangleButton> getBankButtons() {
        return bankButtons;
    }

    public float getUnpaidLoanAmount() {
        return unpaidLoanAmount;
    }

    public float getLoanInterestRate() {
        return loanInterestRate;
    }

    public RectangleButton getLoanButton() {
        return loanButton;
    }

    public RectangleButton getLoanAddButton() {
        return loanAddButton;
    }

    public RectangleButton getLoanWithdrawButton() {
        return loanWithdrawButton;
    }

    public RectangleButton getLoanDoneButton() {
        return loanDoneButton;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public RectangleButton getLoanRepayAddButton() {
        return loanRepayAddButton;
    }

    public RectangleButton getLoanRepayWithdrawButton() {
        return loanRepayWithdrawButton;
    }

//    public RectangleButton getBankHelpButton() {
//        return bankHelpButton;
//    }
//
//    public RectangleButton getBankHelpDoneButton() {
//        return bankHelpDoneButton;
//    }
}
