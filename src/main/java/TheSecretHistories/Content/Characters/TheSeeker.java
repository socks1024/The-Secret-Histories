package TheSecretHistories.Content.Characters;

import TheSecretHistories.Content.Cards.Fragments.FragmentLantern;
import TheSecretHistories.Content.Cards.Starters.Strike;
import TheSecretHistories.ModCore.TheSecretHistories;
import TheSecretHistories.Content.Relics.TemporaryHeadquarters;
import TheSecretHistories.Utils.StringUtils;
import basemod.abstracts.CustomPlayer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.evacipated.cardcrawl.modthespire.lib.SpireEnum;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.EnergyManager;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.cutscenes.CutscenePanel;
import com.megacrit.cardcrawl.events.city.Vampires;
import com.megacrit.cardcrawl.helpers.CardLibrary;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.helpers.ScreenShake;
import com.megacrit.cardcrawl.localization.CharacterStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.screens.CharSelectInfo;

import java.util.ArrayList;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerColorEnum.THE_SEEKER;

public class TheSeeker extends CustomPlayer {
    private static final String THE_SEEKER_SHOULDER_1 = "TheSecretHistories/img/character/TheSeekerShoulder.png";
    private static final String THE_SEEKER_SHOULDER_2 = "TheSecretHistories/img/character/TheSeekerShoulder.png";
    private static final String CORPSE_IMG = "TheSecretHistories/img/character/char/corpse.png";
    private static final String[] ORB_TEXTURES = new String[]{

            "TheSecretHistories/img/UI/cultOrb/1.png",
            "TheSecretHistories/img/UI/cultOrb/2a.png",
            "TheSecretHistories/img/UI/cultOrb/2b.png",
            "TheSecretHistories/img/UI/cultOrb/3.png",
            "TheSecretHistories/img/UI/cultOrb/4.png",
            "TheSecretHistories/img/UI/cultOrb/5.png",
            "TheSecretHistories/img/UI/cultOrb/border.png",
            "TheSecretHistories/img/UI/cultOrb/1d.png",
            "TheSecretHistories/img/UI/cultOrb/2ad.png",
            "TheSecretHistories/img/UI/cultOrb/2bd.png",
            "TheSecretHistories/img/UI/cultOrb/3d.png",
            "TheSecretHistories/img/UI/cultOrb/4d.png",
            "TheSecretHistories/img/UI/cultOrb/5d.png",


    };
    private static final float[] LAYER_SPEED = new float[]{0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0f, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F};
    private static final CharacterStrings characterStrings = CardCrawlGame.languagePack.getCharacterString(StringUtils.MakeID(TheSeeker.class.getSimpleName()));

    public TheSeeker(String name){
        super(name,THE_SEEKER,ORB_TEXTURES,"TheSecretHistories/img/UI/cultOrb/splendid.png",LAYER_SPEED,null,null);

        this.dialogX = this.drawX + 0.0f * Settings.scale;
        this.dialogY = this.drawY + 150.0f * Settings.scale;

        this.initializeClass(
                "TheSecretHistories/img/character/TheSeeker.png",//人物图
                THE_SEEKER_SHOULDER_2,THE_SEEKER_SHOULDER_1,
                CORPSE_IMG,
                this.getLoadout(),
                0.0f,0.0f,
                200.0f,220.0f,
                new EnergyManager(3)
        );
    }

    public ArrayList<String> getStartingDeck(){
        ArrayList<String> retVal = new ArrayList<>();

        retVal.add(FragmentLantern.ID);
        retVal.add(FragmentLantern.ID);
        retVal.add(FragmentLantern.ID);
        retVal.add(FragmentLantern.ID);
        retVal.add(FragmentLantern.ID);

        retVal.add(Strike.ID);
        retVal.add(Strike.ID);
        retVal.add(Strike.ID);
        retVal.add(Strike.ID);
        retVal.add(Strike.ID);

        return retVal;
    }

    public ArrayList<String> getStartingRelics(){
        ArrayList<String> retVal = new ArrayList<>();
        retVal.add(TemporaryHeadquarters.ID);
        return retVal;
    }

    public CharSelectInfo getLoadout(){
        return new CharSelectInfo(
                characterStrings.NAMES[0],
                characterStrings.TEXT[0],
                75,
                75,
                0,
                99,
                5,
                this,
                this.getStartingRelics(),
                this.getStartingDeck(),
                false
        );
    }

    @Override
    public String getTitle(PlayerClass playerClass){
        return characterStrings.NAMES[0];
    }

    @Override
    public AbstractCard.CardColor getCardColor(){
        return PlayerColorEnum.CULT_BLUE;
    }

    @Override
    public AbstractCard getStartCardForEvent(){
        return null;//这里return初始牌
    }

    @Override
    public Color getCardTrailColor(){
        return TheSecretHistories.CULT_BLUE;
    }

    @Override
    public int getAscensionMaxHPLoss(){
        return 5;
    }

    @Override
    public BitmapFont getEnergyNumFont(){
        return FontHelper.energyNumFontBlue;
    }

    @Override
    public void doCharSelectScreenSelectEffect(){
        CardCrawlGame.screenShake.shake(ScreenShake.ShakeIntensity.MED,ScreenShake.ShakeDur.SHORT,false);
    }

    @Override
    public ArrayList<CutscenePanel> getCutscenePanels(){
        ArrayList<CutscenePanel> panels = new ArrayList<>();

        panels.add(new CutscenePanel("",""));//参数1：图片；参数2：音效
        panels.add(new CutscenePanel(""));
        panels.add(new CutscenePanel(""));

        return panels;
    }

    @Override
    public String getCustomModeCharacterButtonSoundKey(){
        return "ATTACK_HEAVY";
    }

    @Override
    public String getLocalizedCharacterName(){
        return characterStrings.NAMES[0];
    }

    @Override
    public AbstractPlayer newInstance(){
        return new TheSeeker(this.name);
    }

    @Override
    public String getSpireHeartText(){
        return characterStrings.TEXT[1];
    }

    @Override
    public Color getSlashAttackColor(){
        return TheSecretHistories.CULT_BLUE;
    }

    @Override
    public String getVampireText(){
        return Vampires.DESCRIPTIONS[0];//返回男性？或许后续会删除这个事件
    }

    @Override
    public Color getCardRenderColor(){
        return TheSecretHistories.CULT_BLUE;
    }

    @Override
    public AbstractGameAction.AttackEffect[] getSpireHeartSlashEffect() {
        return new AbstractGameAction.AttackEffect[]{AbstractGameAction.AttackEffect.SLASH_HEAVY, AbstractGameAction.AttackEffect.FIRE, AbstractGameAction.AttackEffect.SLASH_DIAGONAL, AbstractGameAction.AttackEffect.SLASH_HEAVY, AbstractGameAction.AttackEffect.FIRE, AbstractGameAction.AttackEffect.SLASH_DIAGONAL};
    }

    public static class PlayerColorEnum{
        @SpireEnum
        public static AbstractPlayer.PlayerClass THE_SEEKER;

        @SpireEnum
        public static AbstractCard.CardColor CULT_BLUE;
    }

    public static class PlayerLibraryEnum{

        @SpireEnum
        public static CardLibrary.LibraryType CULT_BLUE;
    }

    public static class PlayerTagEnum{
        @SpireEnum
        public static AbstractCard.CardTags FRAGMENT;
        @SpireEnum
        public static AbstractCard.CardTags INFLUENCE;
        @SpireEnum
        public static AbstractCard.CardTags TOOL;
        @SpireEnum
        public static AbstractCard.CardTags INGREDIENT;
        @SpireEnum
        public static AbstractCard.CardTags FOLLOWER;
        @SpireEnum
        public static AbstractCard.CardTags SPONSOR;
        @SpireEnum
        public static AbstractCard.CardTags HUNTER;
        @SpireEnum
        public static AbstractCard.CardTags RITE;
        @SpireEnum
        public static AbstractCard.CardTags SPIRIT;

        @SpireEnum
        public static AbstractCard.CardTags LANTERN;
        @SpireEnum
        public static AbstractCard.CardTags FORGE;
        @SpireEnum
        public static AbstractCard.CardTags EDGE;
        @SpireEnum
        public static AbstractCard.CardTags WINTER;
        @SpireEnum
        public static AbstractCard.CardTags HEART;
        @SpireEnum
        public static AbstractCard.CardTags GRAIL;
        @SpireEnum
        public static AbstractCard.CardTags MOTH;
        @SpireEnum
        public static AbstractCard.CardTags KNOCK;
        @SpireEnum
        public static AbstractCard.CardTags SECRETHISTORY;

        @SpireEnum
        public static AbstractPower.PowerType PRINCIPLE;


    }


}
