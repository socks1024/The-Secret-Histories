package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusWay;

import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.AbstractMansusLocation;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusPrinciple.*;
import TheSecretHistories.Content.Cards.Template.TemplateOptionCard;
import TheSecretHistories.Content.Powers.UniqueCards.ToolKnockFPower;
import TheSecretHistories.Utils.DebugUtils;
import TheSecretHistories.Utils.DeckUtils;
import TheSecretHistories.Utils.PrincipleUtils;
import com.megacrit.cardcrawl.actions.watcher.ChooseOneAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import java.util.ArrayList;
import java.util.Arrays;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerColorEnum.CULT_BLUE;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.*;

public abstract class AbstractMansusWay extends TemplateOptionCard {

    private static final CardColor COLOR = CULT_BLUE;

    protected final CardTags[] relatedPrincipleTags;

    protected ArrayList<AbstractCard> relatedLocations = new ArrayList<>();

    public AbstractMansusWay(String id, String imgName, CardTags[] relatedPrincipleTags, AbstractCard[] relatedLocations, int relatedPrincipleLevel) {
        super(id, imgName, COLOR);
        this.relatedPrincipleTags = relatedPrincipleTags;
        this.principleCount = relatedPrincipleLevel;

        this.relatedLocations.addAll(Arrays.asList(relatedLocations));
    }

    @Override
    public void onChoseThisOption() {

        ArrayList<AbstractCard> principles = new ArrayList<>();

        for (CardTags tag : GetAvailableTags()) {
            principles.add(GetMansusPrinciple(tag));
        }

        if (AbstractDungeon.player.hasPower(ToolKnockFPower.POWER_ID)) {

            principles.add(new MansusFrangiclave(this));

        }

        addToBot(new ChooseOneAction(principles));
    }

    public void onConsumedPrinciple(boolean isKnock) {

        ArrayList<AbstractCard> locations = new ArrayList<>();

        for (AbstractCard location : relatedLocations) {
            AbstractMansusLocation l = (AbstractMansusLocation) location.makeStatEquivalentCopy();
            l.enterByKnock = isKnock;
            locations.add(l);
        }

        addToBot(new ChooseOneAction(locations));
    }

    private AbstractMansusPrinciple GetMansusPrinciple(CardTags tag) {
        AbstractMansusPrinciple principle = null;

        if(tag.equals(LANTERN)){principle = new MansusLantern(this);}
        if(tag.equals(FORGE)){principle = new MansusForge(this);}
        if(tag.equals(EDGE)){principle = new MansusEdge(this);}
        if(tag.equals(WINTER)){principle = new MansusWinter(this);}
        if(tag.equals(HEART)){principle = new MansusHeart(this);}
        if(tag.equals(GRAIL)){principle = new MansusGrail(this);}
        if(tag.equals(MOTH)){principle = new MansusMoth(this);}
        if(tag.equals(KNOCK)){principle = new MansusKnock(this);}

        if (principle != null) principle.DoUpgrade(principleCount / 2 - 1);

        return principle;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {

    }

    public boolean GetAvailable() {
        if (DeckUtils.GetMansusLevel() * 2 < principleCount) return false;

        if (AbstractDungeon.player.hasPower(ToolKnockFPower.POWER_ID)) return true;

        return !GetAvailableTags().isEmpty();
    }

    public ArrayList<CardTags> GetAvailableTags() {
        ArrayList<CardTags> tags = new ArrayList<>();

        for (CardTags tag : relatedPrincipleTags) {
            if (PrincipleUtils.GetPlayerPrincipleAmount(tag) >= principleCount) {
                tags.add(tag);
            }
        }

        return tags;
    }
}
