package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusWay;

import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusPrinciple.*;
import TheSecretHistories.Content.Cards.Template.TemplateOptionCard;
import TheSecretHistories.Content.Powers.Principles.*;
import TheSecretHistories.Content.Powers.UniqueCards.ToolKnockFPower;
import TheSecretHistories.Utils.DeckUtils;
import TheSecretHistories.Utils.PrincipleUtils;
import com.megacrit.cardcrawl.actions.watcher.ChooseOneAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import java.util.ArrayList;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerColorEnum.CULT_BLUE;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.*;

public abstract class AbstractMansusWay extends TemplateOptionCard {

    private static final CardColor COLOR = CULT_BLUE;

    protected final CardTags[] relatedPrincipleTags;

    protected final int relatedPrincipleLevel;

    public AbstractMansusWay(String id, String imgName, CardTags[] relatedPrincipleTags, int relatedPrincipleLevel) {
        super(id, imgName, COLOR);
        this.relatedPrincipleTags = relatedPrincipleTags;
        this.relatedPrincipleLevel = relatedPrincipleLevel;
    }

    @Override
    public void OnChoseThisOption(AbstractPlayer p) {
        ArrayList<AbstractCard> principles = new ArrayList<>();

        for (CardTags tag : GetAvailableTags()) {
            principles.add(GetMansusPrinciple(tag));
        }

        addToBot(new ChooseOneAction(principles));

        ArrayList<AbstractCard> locations = new ArrayList<>();

        // 设置地点三选牌（两暗一明）
    }

    private AbstractMansusPrinciple GetMansusPrinciple(CardTags tag) {
        AbstractMansusPrinciple principle = null;

        if(tag.equals(LANTERN)){principle = new MansusPrincipleLantern();}
        if(tag.equals(FORGE)){principle = new MansusPrincipleForge();}
        if(tag.equals(EDGE)){principle = new MansusPrincipleEdge();}
        if(tag.equals(WINTER)){principle = new MansusPrincipleWinter();}
        if(tag.equals(HEART)){principle = new MansusPrincipleHeart();}
        if(tag.equals(GRAIL)){principle = new MansusPrincipleGrail();}
        if(tag.equals(MOTH)){principle = new MansusPrincipleMoth();}
        if(tag.equals(KNOCK)){principle = new MansusPrincipleKnock();}

        for (int i = 0; i < (relatedPrincipleLevel / 2 - 1); i++) {
            if (principle != null) {
                principle.upgrade();
            }
        }

        return principle;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {

    }

    public boolean GetAvailable() {
        if (DeckUtils.GetMansusLevel() * 2 < relatedPrincipleLevel) return false;

        if (AbstractDungeon.player.hasPower(ToolKnockFPower.POWER_ID)) return true;

        return !GetAvailableTags().isEmpty();
    }

    public ArrayList<CardTags> GetAvailableTags() {
        ArrayList<CardTags> tags = new ArrayList<>();

        for (CardTags tag : relatedPrincipleTags) {
            if (PrincipleUtils.GetPlayerPrincipleAmount(tag) >= relatedPrincipleLevel) {
                tags.add(tag);
            }
        }

        return tags;
    }
}
