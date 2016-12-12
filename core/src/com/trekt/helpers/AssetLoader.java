package com.trekt.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

/**
 * Created by AadityaPatwari on 29/7/16.
 */
public class AssetLoader {

    public static float screenWidth = Gdx.graphics.getWidth();
    public static float screenHeight = Gdx.graphics.getHeight();
    public static float gameWidth = 256;
    public static float gameHeight = 144;

    public static Texture mainMap, bank, popup, insuranceOffice, insurancePopup, insurancePopupRevoke, shop, shopSinglePopup, shopSellPopup, shopDonePopup, stock, car, lousyHouse, betterHouse, garden, pond, back, help;
    public static TextureRegion mainMapTr, bankTr, popupTr, insuranceOfficeTr, insurancePopupTr, insurancePopupRevokeTr, shopTr, shopSinglePopupTr, shopSellPopupTr, shopDonePopupTr, stockTr, carTr, lousyHouseTr, betterHouseTr, gardenTr, pondTr, backTr, helpTr;

    public static FreeTypeFontGenerator OCRAFontGenerator;
    public static FreeTypeFontGenerator.FreeTypeFontParameter freeTypeFontParameter;
    public static BitmapFont OCRAMedium,  OCRASmall, OCRABig;

    public static Preferences prefs;


    public AssetLoader(){

    }

    public static void load(){
        mainMap = new Texture(Gdx.files.internal("data/FinkidMap.png"));
        mainMap.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        mainMapTr = new TextureRegion(mainMap, 0, 137, mainMap.getWidth(), 722);
        mainMapTr.flip(false, true);

        bank = new Texture(Gdx.files.internal("data/bankinside.png"));
        bank.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        bankTr = new TextureRegion(bank, 0, 229, bank.getWidth(), 562);
        bankTr.flip(false, true);

        shop = new Texture(Gdx.files.internal("data/shop.png"));
        shop.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        shopTr = new TextureRegion(shop, 0, 216, shop.getWidth(), 572);
        shopTr.flip(false, true);


        insuranceOffice = new Texture(Gdx.files.internal("data/insuranceoffice.png"));
        insuranceOffice.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        insuranceOfficeTr = new TextureRegion(insuranceOffice, 0, 272, insuranceOffice.getWidth(), 561);
        insuranceOfficeTr.flip(false, true);

        stock = new Texture(Gdx.files.internal("data/stockmarket.png"));
        stock.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        stockTr = new TextureRegion(stock, 0, 230, 1024, 562);
        stockTr.flip(false, true);

        popup = new Texture(Gdx.files.internal("data/popup.png"));
        popup.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        popupTr = new TextureRegion(popup, 108, 65, 288, 374);
        popupTr.flip(false, true);

        insurancePopup = new Texture(Gdx.files.internal("data/insurancepopup.png"));
        insurancePopup.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        insurancePopupTr = new TextureRegion(insurancePopup, 108, 65, 288, 374);
        insurancePopupTr.flip(false, true);

        insurancePopupRevoke = new Texture(Gdx.files.internal("data/insurancepopuprevoke.png"));
        insurancePopupRevoke.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        insurancePopupRevokeTr = new TextureRegion(insurancePopupRevoke, 108, 65, 288, 374);
        insurancePopupRevokeTr.flip(false, true);

        shopSinglePopup = new Texture(Gdx.files.internal("data/shopsinglepopup.png"));
        shopSinglePopup.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        shopSinglePopupTr = new TextureRegion(shopSinglePopup, 130, 73, 730, 372);
        shopSinglePopupTr.flip(false, true);

        shopSellPopup = new Texture(Gdx.files.internal("data/shopsellpopup.png"));
        shopSellPopup.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        shopSellPopupTr = new TextureRegion(shopSellPopup, 130, 73, 730, 372);
        shopSellPopupTr.flip(false, true);

        shopDonePopup = new Texture(Gdx.files.internal("data/shopdonepopup.png"));
        shopDonePopup.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        shopDonePopupTr = new TextureRegion(shopDonePopup, 130, 73, 730, 372);
        shopDonePopupTr.flip(false, true);

        car = new Texture(Gdx.files.internal("data/car.png"));
        car.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        carTr = new TextureRegion(car, 72, 251, 858, 481);
        carTr.flip(false, true);

        lousyHouse = new Texture(Gdx.files.internal("data/lousyhouse.png"));
        lousyHouse.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        lousyHouseTr = new TextureRegion(lousyHouse, 123, 224, 718, 573);
        lousyHouseTr.flip(false, true);

        betterHouse = new Texture(Gdx.files.internal("data/betterhouse.png"));
        betterHouse.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        betterHouseTr = new TextureRegion(betterHouse, 119, 25, 834, 533);
        betterHouseTr.flip(false, true);

        garden = new Texture(Gdx.files.internal("data/garden.png"));
        garden.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        gardenTr = new TextureRegion(garden, 6,61 , 240, 141);
        gardenTr.flip(false, true);

        pond = new Texture(Gdx.files.internal("data/pond.png"));
        pond.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        pondTr = new TextureRegion(pond, 0, 5, 256, 96);
        pondTr.flip(false, true);

        back = new Texture(Gdx.files.internal("data/Back.png"));
        back.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        backTr = new TextureRegion(back, 0, 0, 336, 427);
        backTr.flip(false, true);

        help = new Texture(Gdx.files.internal("data/Question-mark.png"));
        help.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        helpTr = new TextureRegion(help, 0, 0, 356, 356);
        helpTr.flip(false, true);

        freeTypeFontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        freeTypeFontParameter.size = 80;
        OCRAFontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("data/Helvetica_Normal.ttf"));
        OCRASmall = OCRAFontGenerator.generateFont(freeTypeFontParameter);
        OCRASmall.getData().setScale(0.08f, -0.08f);
        OCRAMedium = OCRAFontGenerator.generateFont(freeTypeFontParameter);
        OCRAMedium.getData().setScale(0.15f, -0.15f);
        OCRABig = OCRAFontGenerator.generateFont(freeTypeFontParameter);
        OCRABig.getData().setScale(0.19f, -0.19f);
        OCRAMedium.setColor(Color.BLACK);
        OCRASmall.setColor(Color.BLACK);
        OCRABig.setColor(Color.BLACK);

        prefs = Gdx.app.getPreferences("FinKids");

        if (!prefs.contains("moneyInHand")) {
            prefs.putFloat("moneyInHand", 500);
        }

        if (!prefs.contains("totalBankBalance")) {
            prefs.putFloat("totalBankBalance", 0);
        }

        if (!prefs.contains("unpaidLoanAmount")) {
            prefs.putFloat("unpaidLoanAmount", 0);

        }

        if (!prefs.contains("moneyInvestedInStock")) {
            prefs.putFloat("moneyInvestedInStock", 0);
        }

        if (!prefs.contains("day")) {
            prefs.putInteger("day", 0);
        }

        if (!prefs.contains("week")) {
            prefs.putInteger("week", 0);
        }


        if (!prefs.contains("carBought")) {
            prefs.putBoolean("carBought", false);
        }

        if (!prefs.contains("houseBought")) {
            prefs.putBoolean("houseBought", false);
        }

        if (!prefs.contains("gardenBought")) {
            prefs.putBoolean("gardenBought", false);
        }

        if (!prefs.contains("pondBought")) {
            prefs.putBoolean("pondBought", false);
        }

        if (!prefs.contains("houseInsured")) {
            prefs.putBoolean("houseInsured", false);
        }

        if (!prefs.contains("carInsured")) {
            prefs.putBoolean("carInsured", false);
        }

        prefs.flush();
    }

    public static void dispose(){

        mainMap.dispose();
        bank.dispose();
        popup.dispose();
        insuranceOffice.dispose();
        insurancePopup.dispose();
        insurancePopupRevoke.dispose();
        shop.dispose();
        shopSellPopup.dispose();
        shopDonePopup.dispose();
        OCRABig.dispose();
        OCRASmall.dispose();
        OCRAMedium.dispose();
        stock.dispose();
        car.dispose();
        lousyHouse.dispose();
        betterHouse.dispose();
        pond.dispose();
        back.dispose();
        help.dispose();
        garden.dispose();

    }


}
